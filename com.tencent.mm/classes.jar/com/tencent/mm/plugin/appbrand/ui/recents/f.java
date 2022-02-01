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
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public abstract class f
  extends a
  implements View.OnClickListener
{
  private ViewGroup lGY;
  private ImageView lGZ;
  private WeImageView lHa;
  private View lHb;
  private ImageView lHc;
  private MMAnimateView lHd;
  private TextView lHe;
  private View lHf;
  protected ado lHg;
  FragmentActivity mActivity;
  
  f(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.lGY = ((ViewGroup)LayoutInflater.from(paramFragmentActivity).inflate(2131493037, paramViewGroup, false));
    this.lGY.setOnClickListener(this);
    ((TextView)this.lGY.findViewById(2131305902)).setText(getTitle());
    this.lGZ = ((ImageView)this.lGY.findViewById(2131296712));
    this.lHa = ((WeImageView)this.lGY.findViewById(2131300874));
    this.lHf = this.lGY.findViewById(2131303917);
    if (this.lHa != null) {
      a(this.lHa);
    }
    this.lHb = this.lGY.findViewById(2131304794);
    this.lHc = ((ImageView)this.lGY.findViewById(2131304795));
    this.lHd = ((MMAnimateView)this.lGY.findViewById(2131304796));
    this.lHe = ((TextView)this.lGY.findViewById(2131304797));
  }
  
  private void bpy()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.lHb, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(30L);
    localObjectAnimator.start();
  }
  
  public final void b(final ado paramado)
  {
    if (paramado == null) {}
    final ap.d locald;
    do
    {
      return;
      this.lHg = paramado;
      locald = ap.d.qP(paramado.rXs);
    } while (locald == null);
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + paramado.doh + " icon_url=" + paramado.odo + " icon_url2=" + paramado.Deh);
    new a(paramado.odo, paramado.Deh, new f.a.a()
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
              f.a(f.this, f.1.this.lHh, f.1.this.lHi, paramAnonymousBitmap, paramAnonymousArrayOfByte);
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
  
  public void bpt()
  {
    he(true);
  }
  
  public final View bpu()
  {
    return this.lGY;
  }
  
  protected final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  protected abstract String getTitle();
  
  public final void hf(boolean paramBoolean)
  {
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(paramBoolean)));
    View localView = this.lHf;
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
    this.lHd.stop();
  }
  
  public final void onPause()
  {
    this.lHd.pause();
  }
  
  public void onResume()
  {
    b(this.lHg);
    this.lHd.resume();
  }
  
  public final void ud(int paramInt)
  {
    if (this.lGZ != null) {
      this.lGZ.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.lGY.findViewById(2131305902);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.lGY.getResources().getDimensionPixelOffset(2131165786);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void ue(int paramInt)
  {
    this.lGY.setBackgroundResource(paramInt);
  }
  
  static final class a
  {
    private final AtomicInteger counter;
    Bitmap imageBitmap;
    private final String lHn;
    private final String lHo;
    private final a lHp;
    byte[] lHq;
    
    public a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(180397);
      this.counter = new AtomicInteger();
      this.imageBitmap = null;
      this.lHq = null;
      this.lHn = paramString1;
      this.lHo = paramString2;
      this.lHp = parama;
      if (!TextUtils.isEmpty(paramString1)) {
        bpA();
      }
      if (!TextUtils.isEmpty(paramString2)) {
        bpA();
      }
      if (this.counter.get() == 0) {
        parama.b(null, null);
      }
      AppMethodBeat.o(180397);
    }
    
    private void Na(String paramString)
    {
      AppMethodBeat.i(180401);
      b.aub().a(new b.k()
      {
        public final String AL()
        {
          return "LoadShowcaseImageTask";
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(180394);
          f.a.this.imageBitmap = paramAnonymousBitmap;
          f.a.this.bpz();
          AppMethodBeat.o(180394);
        }
        
        public final void auj() {}
        
        public final void nV()
        {
          AppMethodBeat.i(180395);
          f.a.this.bpz();
          AppMethodBeat.o(180395);
        }
      }, paramString, null);
      AppMethodBeat.o(180401);
    }
    
    private void Nb(String paramString)
    {
      AppMethodBeat.i(180402);
      b.aub().a(paramString, new b.j()
      {
        public final void X(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(180396);
          f.a.this.lHq = paramAnonymousArrayOfByte;
          f.a.this.bpz();
          AppMethodBeat.o(180396);
        }
      });
      AppMethodBeat.o(180402);
    }
    
    private void bpA()
    {
      AppMethodBeat.i(180399);
      this.counter.incrementAndGet();
      AppMethodBeat.o(180399);
    }
    
    final void bpz()
    {
      AppMethodBeat.i(180398);
      if ((this.counter.decrementAndGet() == 0) && (this.lHp != null)) {
        this.lHp.b(this.imageBitmap, this.lHq);
      }
      AppMethodBeat.o(180398);
    }
    
    public final void start()
    {
      AppMethodBeat.i(180400);
      if (!TextUtils.isEmpty(this.lHn)) {
        Na(this.lHn);
      }
      if (!TextUtils.isEmpty(this.lHo)) {
        Nb(this.lHo);
      }
      AppMethodBeat.o(180400);
    }
    
    static abstract interface a
    {
      public abstract void b(Bitmap paramBitmap, byte[] paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f
 * JD-Core Version:    0.7.0.1
 */