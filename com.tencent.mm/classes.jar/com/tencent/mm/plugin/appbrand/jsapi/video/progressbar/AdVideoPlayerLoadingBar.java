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
import com.tencent.mm.sdk.platformtools.ae;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
{
  protected View contentView;
  protected boolean kWf;
  protected e.d lvQ;
  protected ImageView lvR;
  protected ImageView lvS;
  protected ImageView lvT;
  protected ImageView lvU;
  protected TextView lvV;
  protected TextView lvW;
  protected int lvX;
  private int lvY;
  private int lvZ;
  protected float lwa;
  private int lwb;
  private int lwc;
  private int lwd;
  private int lwe;
  protected int mPosition;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(211382);
    this.lvQ = null;
    this.contentView = null;
    this.lvS = null;
    this.lvT = null;
    this.lvU = null;
    this.lvX = 0;
    this.mPosition = 0;
    this.lvY = 0;
    this.lvZ = 0;
    this.kWf = false;
    this.lwa = 0.0F;
    this.lwb = -1;
    this.lwc = -1;
    this.lwd = -1;
    this.lwe = -1;
    init();
    AppMethodBeat.o(211382);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(211383);
    this.lvQ = null;
    this.contentView = null;
    this.lvS = null;
    this.lvT = null;
    this.lvU = null;
    this.lvX = 0;
    this.mPosition = 0;
    this.lvY = 0;
    this.lvZ = 0;
    this.kWf = false;
    this.lwa = 0.0F;
    this.lwb = -1;
    this.lwc = -1;
    this.lwd = -1;
    this.lwe = -1;
    init();
    AppMethodBeat.o(211383);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(211384);
    this.lvQ = null;
    this.contentView = null;
    this.lvS = null;
    this.lvT = null;
    this.lvU = null;
    this.lvX = 0;
    this.mPosition = 0;
    this.lvY = 0;
    this.lvZ = 0;
    this.kWf = false;
    this.lwa = 0.0F;
    this.lwb = -1;
    this.lwc = -1;
    this.lwd = -1;
    this.lwe = -1;
    init();
    AppMethodBeat.o(211384);
  }
  
  public static String tv(int paramInt)
  {
    AppMethodBeat.i(211396);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(211396);
      return str;
    }
    AppMethodBeat.o(211396);
    return String.valueOf(paramInt);
  }
  
  public final void bph()
  {
    AppMethodBeat.i(211392);
    this.lvW.setText(tv(this.lvX / 60) + ":" + tv(this.lvX % 60));
    bpi();
    AppMethodBeat.o(211392);
  }
  
  public void bpi()
  {
    AppMethodBeat.i(211395);
    if (this.lvX == 0)
    {
      AppMethodBeat.o(211395);
      return;
    }
    if (this.kWf)
    {
      AppMethodBeat.o(211395);
      return;
    }
    if (this.lvT == null)
    {
      AppMethodBeat.o(211395);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(211395);
      return;
    }
    int i = (getBarPointWidth() - this.lvT.getPaddingLeft() - this.lvT.getPaddingRight()) / 2;
    this.lvV.setText(tv(this.mPosition / 60) + ":" + tv(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.lvS.getLayoutParams()).leftMargin;
    int k = this.lvT.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lvT.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.lvX * getBarLen()) - i);
    this.lvT.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lvR.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lvX * getBarLen()));
    this.lvR.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(211395);
  }
  
  protected int getBarLen()
  {
    AppMethodBeat.i(211393);
    if (this.lvY <= 0) {
      this.lvY = this.lvS.getWidth();
    }
    int i = this.lvY;
    AppMethodBeat.o(211393);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(211394);
    if (this.lvZ <= 0) {
      this.lvZ = this.lvT.getWidth();
    }
    int i = this.lvZ;
    AppMethodBeat.o(211394);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(211389);
    int i = ((FrameLayout.LayoutParams)this.lvS.getLayoutParams()).leftMargin;
    int j = this.lvT.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.lvT.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.lvT.getPaddingLeft() - this.lvT.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.lvX));
    AppMethodBeat.o(211389);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131496136;
  }
  
  public int getVideoTotalTime()
  {
    return this.lvX;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(211385);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.lvR = ((ImageView)this.contentView.findViewById(2131303302));
    this.lvS = ((ImageView)this.contentView.findViewById(2131303301));
    this.lvT = ((ImageView)this.contentView.findViewById(2131303305));
    this.lvU = ((ImageView)this.contentView.findViewById(2131303281));
    this.lvV = ((TextView)this.contentView.findViewById(2131303283));
    this.lvW = ((TextView)this.contentView.findViewById(2131303289));
    this.lvT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211379);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AdVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ae.i("MicroMsg.AdVideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.kWf = false;
          AdVideoPlayerLoadingBar.this.lwa = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.lvQ != null) {
            AdVideoPlayerLoadingBar.this.lvQ.aqS();
          }
        }
        for (;;)
        {
          a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AdVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(211379);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lvT.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.lwa);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.lvT.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.lvX > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lvR.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.lvX * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.lvR.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.lvV.setText(AdVideoPlayerLoadingBar.tv(i / 60) + ":" + AdVideoPlayerLoadingBar.tv(i % 60));
            AdVideoPlayerLoadingBar.this.kWf = true;
          }
          else if (AdVideoPlayerLoadingBar.this.kWf)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.lvQ != null)
            {
              ae.i("MicroMsg.AdVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.lvQ.nP(i);
            }
            AdVideoPlayerLoadingBar.this.kWf = false;
          }
        }
      }
    });
    this.lvT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211380);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.lvT.getPaddingLeft() - AdVideoPlayerLoadingBar.this.lvT.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lvS.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.lvT.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lvT.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.lvT.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(211380);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lvR.getLayoutParams();
    localLayoutParams.width = 0;
    this.lvR.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(211385);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(211386);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.lvY = 0;
    if ((paramInt1 != this.lwb) || (paramInt2 != this.lwc) || (paramInt3 != this.lwd) || (paramInt4 != this.lwe)) {
      bpi();
    }
    this.lwb = paramInt1;
    this.lwc = paramInt2;
    this.lwd = paramInt3;
    this.lwe = paramInt4;
    AppMethodBeat.o(211386);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(211390);
    this.mPosition = paramInt;
    bpi();
    AppMethodBeat.o(211390);
  }
  
  public void setIplaySeekCallback(e.d paramd)
  {
    this.lvQ = paramd;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(211388);
    if (paramBoolean)
    {
      this.lvU.setImageResource(2131690795);
      AppMethodBeat.o(211388);
      return;
    }
    this.lvU.setImageResource(2131690796);
    AppMethodBeat.o(211388);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211387);
    this.lvU.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(211387);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(211391);
    this.lvX = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211381);
          AdVideoPlayerLoadingBar.this.bph();
          AppMethodBeat.o(211381);
        }
      });
      AppMethodBeat.o(211391);
      return;
    }
    bph();
    AppMethodBeat.o(211391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */