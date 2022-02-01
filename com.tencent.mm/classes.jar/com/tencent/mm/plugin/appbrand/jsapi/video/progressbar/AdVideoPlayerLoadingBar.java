package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.sdk.platformtools.ad;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
{
  protected View contentView;
  protected boolean kSw;
  protected float lrA;
  private int lrB;
  private int lrC;
  private int lrD;
  private int lrE;
  protected e.d lrq;
  protected ImageView lrr;
  protected ImageView lrs;
  protected ImageView lrt;
  protected ImageView lru;
  protected TextView lrv;
  protected TextView lrw;
  protected int lrx;
  private int lry;
  private int lrz;
  protected int mPosition;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206352);
    this.lrq = null;
    this.contentView = null;
    this.lrs = null;
    this.lrt = null;
    this.lru = null;
    this.lrx = 0;
    this.mPosition = 0;
    this.lry = 0;
    this.lrz = 0;
    this.kSw = false;
    this.lrA = 0.0F;
    this.lrB = -1;
    this.lrC = -1;
    this.lrD = -1;
    this.lrE = -1;
    init();
    AppMethodBeat.o(206352);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206353);
    this.lrq = null;
    this.contentView = null;
    this.lrs = null;
    this.lrt = null;
    this.lru = null;
    this.lrx = 0;
    this.mPosition = 0;
    this.lry = 0;
    this.lrz = 0;
    this.kSw = false;
    this.lrA = 0.0F;
    this.lrB = -1;
    this.lrC = -1;
    this.lrD = -1;
    this.lrE = -1;
    init();
    AppMethodBeat.o(206353);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206354);
    this.lrq = null;
    this.contentView = null;
    this.lrs = null;
    this.lrt = null;
    this.lru = null;
    this.lrx = 0;
    this.mPosition = 0;
    this.lry = 0;
    this.lrz = 0;
    this.kSw = false;
    this.lrA = 0.0F;
    this.lrB = -1;
    this.lrC = -1;
    this.lrD = -1;
    this.lrE = -1;
    init();
    AppMethodBeat.o(206354);
  }
  
  public static String tr(int paramInt)
  {
    AppMethodBeat.i(206366);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(206366);
      return str;
    }
    AppMethodBeat.o(206366);
    return String.valueOf(paramInt);
  }
  
  public final void box()
  {
    AppMethodBeat.i(206362);
    this.lrw.setText(tr(this.lrx / 60) + ":" + tr(this.lrx % 60));
    boy();
    AppMethodBeat.o(206362);
  }
  
  public void boy()
  {
    AppMethodBeat.i(206365);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(206365);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(206365);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(206365);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(206365);
      return;
    }
    int i = (getBarPointWidth() - this.lrt.getPaddingLeft() - this.lrt.getPaddingRight()) / 2;
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.lrs.getLayoutParams()).leftMargin;
    int k = this.lrt.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrt.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.lrx * getBarLen()) - i);
    this.lrt.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lrx * getBarLen()));
    this.lrr.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(206365);
  }
  
  protected int getBarLen()
  {
    AppMethodBeat.i(206363);
    if (this.lry <= 0) {
      this.lry = this.lrs.getWidth();
    }
    int i = this.lry;
    AppMethodBeat.o(206363);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(206364);
    if (this.lrz <= 0) {
      this.lrz = this.lrt.getWidth();
    }
    int i = this.lrz;
    AppMethodBeat.o(206364);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(206359);
    int i = ((FrameLayout.LayoutParams)this.lrs.getLayoutParams()).leftMargin;
    int j = this.lrt.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.lrt.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.lrt.getPaddingLeft() - this.lrt.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.lrx));
    AppMethodBeat.o(206359);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131496136;
  }
  
  public int getVideoTotalTime()
  {
    return this.lrx;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(206355);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.lrr = ((ImageView)this.contentView.findViewById(2131303302));
    this.lrs = ((ImageView)this.contentView.findViewById(2131303301));
    this.lrt = ((ImageView)this.contentView.findViewById(2131303305));
    this.lru = ((ImageView)this.contentView.findViewById(2131303281));
    this.lrv = ((TextView)this.contentView.findViewById(2131303283));
    this.lrw = ((TextView)this.contentView.findViewById(2131303289));
    this.lrt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206349);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AdVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.AdVideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.kSw = false;
          AdVideoPlayerLoadingBar.this.lrA = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.lrq != null) {
            AdVideoPlayerLoadingBar.this.lrq.aqD();
          }
        }
        for (;;)
        {
          a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AdVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(206349);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrt.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.lrA);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.lrt.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.lrx > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrr.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.lrx * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.lrr.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.lrv.setText(AdVideoPlayerLoadingBar.tr(i / 60) + ":" + AdVideoPlayerLoadingBar.tr(i % 60));
            AdVideoPlayerLoadingBar.this.kSw = true;
          }
          else if (AdVideoPlayerLoadingBar.this.kSw)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.lrq != null)
            {
              ad.i("MicroMsg.AdVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.lrq.nM(i);
            }
            AdVideoPlayerLoadingBar.this.kSw = false;
          }
        }
      }
    });
    this.lrt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206350);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.lrt.getPaddingLeft() - AdVideoPlayerLoadingBar.this.lrt.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrs.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.lrt.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrt.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.lrt.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(206350);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
    localLayoutParams.width = 0;
    this.lrr.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(206355);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206356);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.lry = 0;
    if ((paramInt1 != this.lrB) || (paramInt2 != this.lrC) || (paramInt3 != this.lrD) || (paramInt4 != this.lrE)) {
      boy();
    }
    this.lrB = paramInt1;
    this.lrC = paramInt2;
    this.lrD = paramInt3;
    this.lrE = paramInt4;
    AppMethodBeat.o(206356);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(206360);
    this.mPosition = paramInt;
    boy();
    AppMethodBeat.o(206360);
  }
  
  public void setIplaySeekCallback(e.d paramd)
  {
    this.lrq = paramd;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(206358);
    if (paramBoolean)
    {
      this.lru.setImageResource(2131690795);
      AppMethodBeat.o(206358);
      return;
    }
    this.lru.setImageResource(2131690796);
    AppMethodBeat.o(206358);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206357);
    this.lru.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(206357);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(206361);
    this.lrx = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206351);
          AdVideoPlayerLoadingBar.this.box();
          AppMethodBeat.o(206351);
        }
      });
      AppMethodBeat.o(206361);
      return;
    }
    box();
    AppMethodBeat.o(206361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */