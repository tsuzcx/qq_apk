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
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.appusage.ap.d;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public abstract class f
  extends a
  implements View.OnClickListener
{
  FragmentActivity mActivity;
  private ViewGroup miT;
  private ImageView miU;
  private WeImageView miV;
  private View miW;
  private ImageView miX;
  private MMAnimateView miY;
  private TextView miZ;
  private View mja;
  protected aen mjb;
  
  f(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.miT = ((ViewGroup)LayoutInflater.from(paramFragmentActivity).inflate(2131493037, paramViewGroup, false));
    this.miT.setOnClickListener(this);
    ((TextView)this.miT.findViewById(2131305902)).setText(getTitle());
    this.miU = ((ImageView)this.miT.findViewById(2131296712));
    this.miV = ((WeImageView)this.miT.findViewById(2131300874));
    this.mja = this.miT.findViewById(2131303917);
    if (this.miV != null) {
      a(this.miV);
    }
    this.miW = this.miT.findViewById(2131304794);
    this.miX = ((ImageView)this.miT.findViewById(2131304795));
    this.miY = ((MMAnimateView)this.miT.findViewById(2131304796));
    this.miZ = ((TextView)this.miT.findViewById(2131304797));
  }
  
  private void bwt()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.miW, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(30L);
    localObjectAnimator.start();
  }
  
  public final void b(final aen paramaen)
  {
    if (paramaen == null) {}
    final ap.d locald;
    do
    {
      return;
      this.mjb = paramaen;
      locald = ap.d.rC(paramaen.tfk);
    } while (locald == null);
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + paramaen.dlQ + " icon_url=" + paramaen.oGN + " icon_url2=" + paramaen.Exn);
    new a(paramaen.oGN, paramaen.Exn, new f.a.a()
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
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180391);
              f.a(f.this, f.1.this.mjc, f.1.this.mjd, paramAnonymousBitmap, paramAnonymousArrayOfByte);
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
  
  public void bwo()
  {
    hB(true);
  }
  
  public final View bwp()
  {
    return this.miT;
  }
  
  protected final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  protected abstract String getTitle();
  
  public final void hC(boolean paramBoolean)
  {
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(paramBoolean)));
    View localView = this.mja;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView) {}
  
  public final void onDetached()
  {
    this.miY.stop();
  }
  
  public final void onPause()
  {
    this.miY.pause();
  }
  
  public void onResume()
  {
    b(this.mjb);
    this.miY.resume();
  }
  
  public final void uV(int paramInt)
  {
    if (this.miU != null) {
      this.miU.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.miT.findViewById(2131305902);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.miT.getResources().getDimensionPixelOffset(2131165786);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void uW(int paramInt)
  {
    this.miT.setBackgroundResource(paramInt);
  }
  
  static final class a
  {
    private final AtomicInteger counter;
    Bitmap imageBitmap;
    private final String mji;
    private final String mjj;
    private final a mjk;
    byte[] mjl;
    
    public a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(180397);
      this.counter = new AtomicInteger();
      this.imageBitmap = null;
      this.mjl = null;
      this.mji = paramString1;
      this.mjj = paramString2;
      this.mjk = parama;
      if (!TextUtils.isEmpty(paramString1)) {
        bwv();
      }
      if (!TextUtils.isEmpty(paramString2)) {
        bwv();
      }
      if (this.counter.get() == 0) {
        parama.b(null, null);
      }
      AppMethodBeat.o(180397);
    }
    
    private void Rj(String paramString)
    {
      AppMethodBeat.i(180401);
      b.aAS().a(new b.k()
      {
        public final String Ap()
        {
          return "LoadShowcaseImageTask";
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(180394);
          f.a.this.imageBitmap = paramAnonymousBitmap;
          f.a.this.bwu();
          AppMethodBeat.o(180394);
        }
        
        public final void aBa() {}
        
        public final void of()
        {
          AppMethodBeat.i(180395);
          f.a.this.bwu();
          AppMethodBeat.o(180395);
        }
      }, paramString, null);
      AppMethodBeat.o(180401);
    }
    
    private void Rk(String paramString)
    {
      AppMethodBeat.i(180402);
      b.aAS().a(paramString, new b.j()
      {
        public final void W(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(180396);
          f.a.this.mjl = paramAnonymousArrayOfByte;
          f.a.this.bwu();
          AppMethodBeat.o(180396);
        }
      });
      AppMethodBeat.o(180402);
    }
    
    private void bwv()
    {
      AppMethodBeat.i(180399);
      this.counter.incrementAndGet();
      AppMethodBeat.o(180399);
    }
    
    final void bwu()
    {
      AppMethodBeat.i(180398);
      if ((this.counter.decrementAndGet() == 0) && (this.mjk != null)) {
        this.mjk.b(this.imageBitmap, this.mjl);
      }
      AppMethodBeat.o(180398);
    }
    
    public final void start()
    {
      AppMethodBeat.i(180400);
      if (!TextUtils.isEmpty(this.mji)) {
        Rj(this.mji);
      }
      if (!TextUtils.isEmpty(this.mjj)) {
        Rk(this.mjj);
      }
      AppMethodBeat.o(180400);
    }
    
    static abstract interface a
    {
      public abstract void b(Bitmap paramBitmap, byte[] paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f
 * JD-Core Version:    0.7.0.1
 */