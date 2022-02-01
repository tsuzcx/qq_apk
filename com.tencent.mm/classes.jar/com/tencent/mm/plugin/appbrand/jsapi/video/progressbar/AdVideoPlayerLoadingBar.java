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
import com.tencent.luggage.b.d.a.c;
import com.tencent.luggage.b.d.a.d;
import com.tencent.luggage.b.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.sdk.platformtools.Log;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
{
  protected View contentView;
  protected int mPosition;
  protected boolean oZf;
  protected d.d pBY;
  protected ImageView pBZ;
  protected ImageView pCa;
  protected ImageView pCb;
  protected ImageView pCc;
  protected TextView pCd;
  protected TextView pCe;
  protected int pCf;
  private int pCg;
  private int pCh;
  protected float pCi;
  private int pCj;
  private int pCk;
  private int pCl;
  private int pCm;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(229012);
    this.pBY = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.pCh = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(229012);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(229018);
    this.pBY = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.pCh = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(229018);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(229021);
    this.pBY = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.pCh = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(229021);
  }
  
  public static String AQ(int paramInt)
  {
    AppMethodBeat.i(229056);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(229056);
      return str;
    }
    AppMethodBeat.o(229056);
    return String.valueOf(paramInt);
  }
  
  public final void bWN()
  {
    AppMethodBeat.i(229043);
    this.pCe.setText(AQ(this.pCf / 60) + ":" + AQ(this.pCf % 60));
    bWO();
    AppMethodBeat.o(229043);
  }
  
  public void bWO()
  {
    AppMethodBeat.i(229054);
    if (this.pCf == 0)
    {
      AppMethodBeat.o(229054);
      return;
    }
    if (this.oZf)
    {
      AppMethodBeat.o(229054);
      return;
    }
    if (this.pCb == null)
    {
      AppMethodBeat.o(229054);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(229054);
      return;
    }
    int i = (getBarPointWidth() - this.pCb.getPaddingLeft() - this.pCb.getPaddingRight()) / 2;
    this.pCd.setText(AQ(this.mPosition / 60) + ":" + AQ(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.pCa.getLayoutParams()).leftMargin;
    int k = this.pCb.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCb.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.pCf * getBarLen()) - i);
    this.pCb.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.pCf * getBarLen()));
    this.pBZ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(229054);
  }
  
  protected int getBarLen()
  {
    AppMethodBeat.i(229045);
    if (this.pCg <= 0) {
      this.pCg = this.pCa.getWidth();
    }
    int i = this.pCg;
    AppMethodBeat.o(229045);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(229047);
    if (this.pCh <= 0) {
      this.pCh = this.pCb.getWidth();
    }
    int i = this.pCh;
    AppMethodBeat.o(229047);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(229038);
    int i = ((FrameLayout.LayoutParams)this.pCa.getLayoutParams()).leftMargin;
    int j = this.pCb.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.pCb.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.pCb.getPaddingLeft() - this.pCb.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.pCf));
    AppMethodBeat.o(229038);
    return i;
  }
  
  protected int getLayoutId()
  {
    return a.d.app_brand_video_player_loading_bar;
  }
  
  public int getVideoTotalTime()
  {
    return this.pCf;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(229031);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.pBZ = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_front));
    this.pCa = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_background));
    this.pCb = ((ImageView)this.contentView.findViewById(a.c.player_progress_point));
    this.pCc = ((ImageView)this.contentView.findViewById(a.c.play_btn));
    this.pCd = ((TextView)this.contentView.findViewById(a.c.play_current_time_tv));
    this.pCe = ((TextView)this.contentView.findViewById(a.c.play_total_time_tv));
    this.pCb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(230400);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.AdVideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.oZf = false;
          AdVideoPlayerLoadingBar.this.pCi = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.pBY != null) {
            AdVideoPlayerLoadingBar.this.pBY.aRo();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(230400);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pCb.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.pCi);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.pCb.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.pCf > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pBZ.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.pCf * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.pBZ.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.pCd.setText(AdVideoPlayerLoadingBar.AQ(i / 60) + ":" + AdVideoPlayerLoadingBar.AQ(i % 60));
            AdVideoPlayerLoadingBar.this.oZf = true;
          }
          else if (AdVideoPlayerLoadingBar.this.oZf)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.pBY != null)
            {
              Log.i("MicroMsg.AdVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.pBY.tY(i);
            }
            AdVideoPlayerLoadingBar.this.oZf = false;
          }
        }
      }
    });
    this.pCb.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226883);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.pCb.getPaddingLeft() - AdVideoPlayerLoadingBar.this.pCb.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pCa.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.pCb.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.pCb.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.pCb.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(226883);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = 0;
    this.pBZ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(229031);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(229033);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pCg = 0;
    if ((paramInt1 != this.pCj) || (paramInt2 != this.pCk) || (paramInt3 != this.pCl) || (paramInt4 != this.pCm)) {
      bWO();
    }
    this.pCj = paramInt1;
    this.pCk = paramInt2;
    this.pCl = paramInt3;
    this.pCm = paramInt4;
    AppMethodBeat.o(229033);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(229040);
    this.mPosition = paramInt;
    bWO();
    AppMethodBeat.o(229040);
  }
  
  public void setIplaySeekCallback(d.d paramd)
  {
    this.pBY = paramd;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(229035);
    if (paramBoolean)
    {
      this.pCc.setImageResource(a.e.media_player_pause_btn);
      AppMethodBeat.o(229035);
      return;
    }
    this.pCc.setImageResource(a.e.media_player_play_btn);
    AppMethodBeat.o(229035);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(229034);
    this.pCc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(229034);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(229042);
    this.pCf = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227398);
          AdVideoPlayerLoadingBar.this.bWN();
          AppMethodBeat.o(227398);
        }
      });
      AppMethodBeat.o(229042);
      return;
    }
    bWN();
    AppMethodBeat.o(229042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */