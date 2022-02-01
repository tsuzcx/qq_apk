package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.appusage.ap.d;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public abstract class f
  extends a
  implements View.OnClickListener
{
  FragmentActivity mActivity;
  private TextView mJA;
  private View mJB;
  protected agw mJC;
  private ViewGroup mJu;
  private ImageView mJv;
  private WeImageView mJw;
  private View mJx;
  private ImageView mJy;
  private MMAnimateView mJz;
  
  f(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.mJu = ((ViewGroup)LayoutInflater.from(paramFragmentActivity).inflate(2131493037, paramViewGroup, false));
    this.mJu.setOnClickListener(this);
    ((TextView)this.mJu.findViewById(2131305902)).setText(getTitle());
    this.mJv = ((ImageView)this.mJu.findViewById(2131296712));
    this.mJw = ((WeImageView)this.mJu.findViewById(2131300874));
    this.mJB = this.mJu.findViewById(2131303917);
    if (this.mJw != null) {
      a(this.mJw);
    }
    this.mJx = this.mJu.findViewById(2131304794);
    this.mJy = ((ImageView)this.mJu.findViewById(2131304795));
    this.mJz = ((MMAnimateView)this.mJu.findViewById(2131304796));
    this.mJA = ((TextView)this.mJu.findViewById(2131304797));
  }
  
  private void bAz()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mJx, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(30L);
    localObjectAnimator.start();
  }
  
  public final void b(final agw paramagw)
  {
    if (paramagw == null) {}
    final ap.d locald;
    do
    {
      return;
      this.mJC = paramagw;
      locald = ap.d.sc(paramagw.uda);
    } while (locald == null);
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + paramagw.dxD + " icon_url=" + paramagw.pkr + " icon_url2=" + paramagw.GeQ);
    new a(paramagw.pkr, paramagw.GeQ, new f.a.a()
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
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180391);
              f.a(f.this, f.1.this.mJD, f.1.this.mJE, paramAnonymousBitmap, paramAnonymousArrayOfByte);
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
  
  public void bAu()
  {
    hL(true);
  }
  
  public final View bAv()
  {
    return this.mJu;
  }
  
  protected final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  protected abstract String getTitle();
  
  public final void hM(boolean paramBoolean)
  {
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(paramBoolean)));
    View localView = this.mJB;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public final void onDetached()
  {
    this.mJz.stop();
  }
  
  public final void onPause()
  {
    this.mJz.pause();
  }
  
  public void onResume()
  {
    b(this.mJC);
    this.mJz.resume();
  }
  
  public final void vA(int paramInt)
  {
    if (this.mJv != null) {
      this.mJv.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.mJu.findViewById(2131305902);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.mJu.getResources().getDimensionPixelOffset(2131165786);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void vB(int paramInt)
  {
    this.mJu.setBackgroundResource(paramInt);
  }
  
  static final class a
  {
    private final AtomicInteger counter;
    Bitmap imageBitmap;
    private final String mJJ;
    private final String mJK;
    private final a mJL;
    byte[] mJM;
    
    public a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(180397);
      this.counter = new AtomicInteger();
      this.imageBitmap = null;
      this.mJM = null;
      this.mJJ = paramString1;
      this.mJK = paramString2;
      this.mJL = parama;
      if (!TextUtils.isEmpty(paramString1)) {
        bAB();
      }
      if (!TextUtils.isEmpty(paramString2)) {
        bAB();
      }
      if (this.counter.get() == 0) {
        parama.b(null, null);
      }
      AppMethodBeat.o(180397);
    }
    
    private void UP(String paramString)
    {
      AppMethodBeat.i(180401);
      com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
      {
        public final String BM()
        {
          return "LoadShowcaseImageTask";
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(180394);
          f.a.this.imageBitmap = paramAnonymousBitmap;
          f.a.this.bAA();
          AppMethodBeat.o(180394);
        }
        
        public final void aEd() {}
        
        public final void ox()
        {
          AppMethodBeat.i(180395);
          f.a.this.bAA();
          AppMethodBeat.o(180395);
        }
      }, paramString, null);
      AppMethodBeat.o(180401);
    }
    
    private void UQ(String paramString)
    {
      AppMethodBeat.i(180402);
      com.tencent.mm.modelappbrand.a.b.aDV().a(paramString, new b.j()
      {
        public final void V(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(180396);
          f.a.this.mJM = paramAnonymousArrayOfByte;
          f.a.this.bAA();
          AppMethodBeat.o(180396);
        }
      });
      AppMethodBeat.o(180402);
    }
    
    private void bAB()
    {
      AppMethodBeat.i(180399);
      this.counter.incrementAndGet();
      AppMethodBeat.o(180399);
    }
    
    final void bAA()
    {
      AppMethodBeat.i(180398);
      if ((this.counter.decrementAndGet() == 0) && (this.mJL != null)) {
        this.mJL.b(this.imageBitmap, this.mJM);
      }
      AppMethodBeat.o(180398);
    }
    
    public final void start()
    {
      AppMethodBeat.i(180400);
      if (!TextUtils.isEmpty(this.mJJ)) {
        UP(this.mJJ);
      }
      if (!TextUtils.isEmpty(this.mJK)) {
        UQ(this.mJK);
      }
      AppMethodBeat.o(180400);
    }
    
    static abstract interface a
    {
      public abstract void b(Bitmap paramBitmap, byte[] paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f
 * JD-Core Version:    0.7.0.1
 */