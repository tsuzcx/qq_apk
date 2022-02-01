package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.appusage.ao.d;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public abstract class e
  extends a
  implements View.OnClickListener
{
  private FragmentActivity mActivity;
  private ViewGroup ulm;
  private ImageView uln;
  private WeImageView ulo;
  private View ulp;
  private ImageView ulq;
  private MMAnimateView ulr;
  private TextView uls;
  View ult;
  protected aod ulu;
  
  e(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.ulm = ((ViewGroup)LayoutInflater.from(paramFragmentActivity).inflate(ba.g.app_brand_recents_list_header_folder_entrance, paramViewGroup, false));
    this.ulm.setOnClickListener(this);
    ((TextView)this.ulm.findViewById(ba.f.title)).setText(getTitle());
    this.uln = ((ImageView)this.ulm.findViewById(ba.f.app_brand_entrance_arrow));
    this.ulo = ((WeImageView)this.ulm.findViewById(ba.f.icon));
    this.ult = this.ulm.findViewById(ba.f.red_dot);
    if (this.ulo != null) {
      a(this.ulo);
    }
    this.ulp = this.ulm.findViewById(ba.f.showcase);
    this.ulq = ((ImageView)this.ulm.findViewById(ba.f.showcase_iv_left));
    this.ulr = ((MMAnimateView)this.ulm.findViewById(ba.f.showcase_iv_right));
    this.uls = ((TextView)this.ulm.findViewById(ba.f.showcase_text));
  }
  
  private void cMB()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.ulp, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(30L);
    localObjectAnimator.start();
  }
  
  public final void Dt(int paramInt)
  {
    if (this.uln != null) {
      this.uln.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.ulm.findViewById(ba.f.title);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.ulm.getResources().getDimensionPixelOffset(ba.d.app_brand_header_title_left_margin);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void Du(int paramInt)
  {
    this.ulm.setBackgroundResource(paramInt);
  }
  
  public final void b(final aod paramaod)
  {
    if (paramaod == null) {}
    final ao.d locald;
    do
    {
      return;
      this.ulu = paramaod;
      locald = ao.d.zz(paramaod.show_type);
    } while (locald == null);
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + paramaod.wording + " icon_url=" + paramaod.icon_url + " icon_url2=" + paramaod.ZvI);
    new a(paramaod.icon_url, paramaod.ZvI, new e.a.a()
    {
      public final void b(final Bitmap paramAnonymousBitmap, final byte[] paramAnonymousArrayOfByte)
      {
        int i = 0;
        AppMethodBeat.i(180392);
        StringBuilder localStringBuilder = new StringBuilder("[LoadShowcaseImageTask#onLoadDone]  bitmap == null ");
        boolean bool;
        if (paramAnonymousBitmap == null)
        {
          bool = true;
          localStringBuilder = localStringBuilder.append(bool).append(" rightImageBytes length=");
          if (paramAnonymousArrayOfByte != null) {
            break label82;
          }
        }
        for (;;)
        {
          Log.i("AppBrandLauncherListHeaderFolderEntrance", i);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180391);
              e.a(e.this, e.1.this.ulv, e.1.this.ulw, paramAnonymousBitmap, paramAnonymousArrayOfByte);
              AppMethodBeat.o(180391);
            }
          });
          AppMethodBeat.o(180392);
          return;
          bool = false;
          break;
          label82:
          i = paramAnonymousArrayOfByte.length;
        }
      }
    }).start();
  }
  
  protected final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  public final View getItemView()
  {
    return this.ulm;
  }
  
  protected abstract String getTitle();
  
  public final void iQ()
  {
    this.ulr.stop();
  }
  
  public void iR()
  {
    setViewEnable(true);
  }
  
  public void onClick(View paramView)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public final void onPause()
  {
    this.ulr.pause();
  }
  
  public void onResume()
  {
    b(this.ulu);
    this.ulr.resume();
  }
  
  static final class a
  {
    private final AtomicInteger evJ;
    Bitmap imageBitmap;
    private final String ulB;
    private final String ulC;
    private final a ulD;
    byte[] ulE;
    
    public a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(180397);
      this.evJ = new AtomicInteger();
      this.imageBitmap = null;
      this.ulE = null;
      this.ulB = paramString1;
      this.ulC = paramString2;
      this.ulD = parama;
      if (!TextUtils.isEmpty(paramString1)) {
        cMD();
      }
      if (!TextUtils.isEmpty(paramString2)) {
        cMD();
      }
      if (this.evJ.get() == 0) {
        parama.b(null, null);
      }
      AppMethodBeat.o(180397);
    }
    
    private void ago(String paramString)
    {
      AppMethodBeat.i(180401);
      com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
      {
        public final void bFg() {}
        
        public final void bFh()
        {
          AppMethodBeat.i(180395);
          e.a.this.cMC();
          AppMethodBeat.o(180395);
        }
        
        public final String key()
        {
          return "LoadShowcaseImageTask";
        }
        
        public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(180394);
          e.a.this.imageBitmap = paramAnonymousBitmap;
          e.a.this.cMC();
          AppMethodBeat.o(180394);
        }
      }, paramString, null);
      AppMethodBeat.o(180401);
    }
    
    private void agp(String paramString)
    {
      AppMethodBeat.i(180402);
      com.tencent.mm.modelappbrand.a.b.bEY().a(paramString, new b.j()
      {
        public final void imageBytesCallback(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(180396);
          e.a.this.ulE = paramAnonymousArrayOfByte;
          e.a.this.cMC();
          AppMethodBeat.o(180396);
        }
      });
      AppMethodBeat.o(180402);
    }
    
    private void cMD()
    {
      AppMethodBeat.i(180399);
      this.evJ.incrementAndGet();
      AppMethodBeat.o(180399);
    }
    
    final void cMC()
    {
      AppMethodBeat.i(180398);
      if ((this.evJ.decrementAndGet() == 0) && (this.ulD != null)) {
        this.ulD.b(this.imageBitmap, this.ulE);
      }
      AppMethodBeat.o(180398);
    }
    
    public final void start()
    {
      AppMethodBeat.i(180400);
      if (!TextUtils.isEmpty(this.ulB)) {
        ago(this.ulB);
      }
      if (!TextUtils.isEmpty(this.ulC)) {
        agp(this.ulC);
      }
      AppMethodBeat.o(180400);
    }
    
    static abstract interface a
    {
      public abstract void b(Bitmap paramBitmap, byte[] paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */