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
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public abstract class f
  extends a
  implements View.OnClickListener
{
  FragmentActivity mActivity;
  private WeImageView obA;
  private View obB;
  private ImageView obC;
  private MMAnimateView obD;
  private TextView obE;
  private View obF;
  protected ajs obG;
  private ViewGroup oby;
  private ImageView obz;
  
  f(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.oby = ((ViewGroup)LayoutInflater.from(paramFragmentActivity).inflate(2131493076, paramViewGroup, false));
    this.oby.setOnClickListener(this);
    ((TextView)this.oby.findViewById(2131309195)).setText(getTitle());
    this.obz = ((ImageView)this.oby.findViewById(2131296794));
    this.obA = ((WeImageView)this.oby.findViewById(2131302468));
    this.obF = this.oby.findViewById(2131306759);
    if (this.obA != null) {
      a(this.obA);
    }
    this.obB = this.oby.findViewById(2131307876);
    this.obC = ((ImageView)this.oby.findViewById(2131307877));
    this.obD = ((MMAnimateView)this.oby.findViewById(2131307878));
    this.obE = ((TextView)this.oby.findViewById(2131307879));
  }
  
  private void bYs()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.obB, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(30L);
    localObjectAnimator.start();
  }
  
  public final void b(final ajs paramajs)
  {
    if (paramajs == null) {}
    final ap.d locald;
    do
    {
      return;
      this.obG = paramajs;
      locald = ap.d.wb(paramajs.xGz);
    } while (locald == null);
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + paramajs.dQx + " icon_url=" + paramajs.qGB + " icon_url2=" + paramajs.Lth);
    new a(paramajs.qGB, paramajs.Lth, new f.a.a()
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
              f.a(f.this, f.1.this.obH, f.1.this.obI, paramAnonymousBitmap, paramAnonymousArrayOfByte);
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
  
  public void bSx()
  {
    setViewEnable(true);
  }
  
  public final View bYp()
  {
    return this.oby;
  }
  
  protected final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  protected abstract String getTitle();
  
  public final void iR(boolean paramBoolean)
  {
    Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(paramBoolean)));
    View localView = this.obF;
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
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public final void onDetached()
  {
    this.obD.stop();
  }
  
  public final void onPause()
  {
    this.obD.pause();
  }
  
  public void onResume()
  {
    b(this.obG);
    this.obD.resume();
  }
  
  public final void zu(int paramInt)
  {
    if (this.obz != null) {
      this.obz.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.oby.findViewById(2131309195);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.oby.getResources().getDimensionPixelOffset(2131165809);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void zv(int paramInt)
  {
    this.oby.setBackgroundResource(paramInt);
  }
  
  static final class a
  {
    private final AtomicInteger counter;
    Bitmap imageBitmap;
    private final String obN;
    private final String obO;
    private final a obP;
    byte[] obQ;
    
    public a(String paramString1, String paramString2, a parama)
    {
      AppMethodBeat.i(180397);
      this.counter = new AtomicInteger();
      this.imageBitmap = null;
      this.obQ = null;
      this.obN = paramString1;
      this.obO = paramString2;
      this.obP = parama;
      if (!TextUtils.isEmpty(paramString1)) {
        bYu();
      }
      if (!TextUtils.isEmpty(paramString2)) {
        bYu();
      }
      if (this.counter.get() == 0) {
        parama.b(null, null);
      }
      AppMethodBeat.o(180397);
    }
    
    private void afw(String paramString)
    {
      AppMethodBeat.i(180401);
      com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
      {
        public final void I(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(180394);
          f.a.this.imageBitmap = paramAnonymousBitmap;
          f.a.this.bYt();
          AppMethodBeat.o(180394);
        }
        
        public final String Lb()
        {
          return "LoadShowcaseImageTask";
        }
        
        public final void aYg() {}
        
        public final void oD()
        {
          AppMethodBeat.i(180395);
          f.a.this.bYt();
          AppMethodBeat.o(180395);
        }
      }, paramString, null);
      AppMethodBeat.o(180401);
    }
    
    private void afx(String paramString)
    {
      AppMethodBeat.i(180402);
      com.tencent.mm.modelappbrand.a.b.aXY().a(paramString, new b.j()
      {
        public final void aj(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(180396);
          f.a.this.obQ = paramAnonymousArrayOfByte;
          f.a.this.bYt();
          AppMethodBeat.o(180396);
        }
      });
      AppMethodBeat.o(180402);
    }
    
    private void bYu()
    {
      AppMethodBeat.i(180399);
      this.counter.incrementAndGet();
      AppMethodBeat.o(180399);
    }
    
    final void bYt()
    {
      AppMethodBeat.i(180398);
      if ((this.counter.decrementAndGet() == 0) && (this.obP != null)) {
        this.obP.b(this.imageBitmap, this.obQ);
      }
      AppMethodBeat.o(180398);
    }
    
    public final void start()
    {
      AppMethodBeat.i(180400);
      if (!TextUtils.isEmpty(this.obN)) {
        afw(this.obN);
      }
      if (!TextUtils.isEmpty(this.obO)) {
        afx(this.obO);
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