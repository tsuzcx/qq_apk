package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements e, a.a, a.b, a.c, a.d, a.e
{
  protected boolean Xy = false;
  protected int bvh = 0;
  protected TextView gAs;
  protected ao gox = new ao(Looper.getMainLooper());
  private boolean isWaiting = false;
  protected e.c kOW;
  protected boolean kWa = true;
  protected ImageView kWb;
  protected RelativeLayout kWc;
  protected ProgressBar kWd;
  protected TextView kWe;
  protected LinearLayout kWf;
  protected VideoPlayerSeekBar kWg;
  protected e.b kWh;
  protected a kWi;
  protected boolean kWj;
  protected boolean kWk = true;
  protected int kWl = 0;
  protected boolean kWm = false;
  protected int kWn = 0;
  protected boolean kWo = true;
  protected int kWp = -1;
  protected boolean kWq = false;
  protected long kWr = 0L;
  protected int kWs = 0;
  protected au kWt = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(194655);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(194655);
        return false;
      }
      if (AbstractVideoView.this.kWm)
      {
        if (AbstractVideoView.this.kOW != null) {
          AbstractVideoView.this.kOW.dr(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.kWm = false;
      }
      AbstractVideoView.this.tc(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      AppMethodBeat.o(194655);
      return true;
    }
  }, true);
  protected au kWu = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(194658);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ac.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.blf(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.kWi != null) && (i <= 50)) {
        AbstractVideoView.this.kWi.p(0.0D);
      }
      AppMethodBeat.o(194658);
      return false;
    }
  }, false);
  protected au kWv = new au(new au.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(194659);
      if (AbstractVideoView.this.bvh > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(194659);
          return false;
        }
        AppMethodBeat.o(194659);
        return true;
      }
      AppMethodBeat.o(194659);
      return false;
    }
  }, true);
  private e.d kWw = new e.d()
  {
    public final void anR() {}
    
    public final void nn(int paramAnonymousInt)
    {
      AppMethodBeat.i(194660);
      if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
        AbstractVideoView.this.ble();
      }
      if (AbstractVideoView.this.kWg != null) {
        AbstractVideoView.this.kWg.setIsPlay(true);
      }
      AppMethodBeat.o(194660);
    }
  };
  private View.OnClickListener kWx = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(194661);
      ac.i("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.blf() });
      AbstractVideoView.this.blg();
      AppMethodBeat.o(194661);
    }
  };
  private Runnable kWy = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(194662);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.kWd != null) && (AbstractVideoView.this.kWd.getVisibility() != 0))
      {
        ac.i("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { AbstractVideoView.this.blf() });
        AbstractVideoView.this.kWd.setVisibility(0);
      }
      if (AbstractVideoView.this.kOW != null) {
        AbstractVideoView.this.kOW.ds(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(194662);
    }
  };
  protected Context mContext;
  
  public AbstractVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbstractVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbstractVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    ac.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { blf() });
    LayoutInflater.from(this.mContext).inflate(2131496135, this);
    this.kWb = ((ImageView)findViewById(2131306398));
    this.kWc = ((RelativeLayout)findViewById(2131306392));
    this.gAs = ((TextView)findViewById(2131306332));
    this.kWd = ((ProgressBar)findViewById(2131306352));
    this.kWe = ((TextView)findViewById(2131306403));
    this.kWf = ((LinearLayout)findViewById(2131306342));
    paramContext = (VideoPlayerSeekBar)findViewById(2131306375);
    this.kWg = paramContext;
    this.kWh = paramContext;
    if (this.kWg != null)
    {
      this.kWg.setIplaySeekCallback(this.kWw);
      this.kWg.setOnClickListener(this.kWx);
    }
    this.kWi = dC(this.mContext);
    this.kWi.setVideoCallback(this);
    this.kWi.setOnSeekCompleteCallback(this);
    this.kWi.setOnInfoCallback(this);
    this.kWi.setOnSurfaceCallback(this);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    this.kWc.addView((View)this.kWi, 0, paramContext);
  }
  
  private void gL(boolean paramBoolean)
  {
    if (this.kWh != null) {
      this.kWh.gL(paramBoolean);
    }
  }
  
  private void stopTimer()
  {
    this.kWt.stopTimer();
    this.kWu.stopTimer();
  }
  
  public final void aJn()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { blf() });
    ble();
  }
  
  protected final void ble()
  {
    ac.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { blf(), Boolean.FALSE });
    this.kWt.au(500L, 500L);
  }
  
  protected final String blf()
  {
    return hashCode();
  }
  
  public final boolean blg()
  {
    if (this.kWi == null) {
      return false;
    }
    if (isPlaying()) {
      pause();
    }
    for (;;)
    {
      return true;
      if (bs.isNullOrNil(this.kWi.getVideoPath())) {
        start();
      } else {
        play();
      }
    }
  }
  
  protected final boolean blh()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.kWi != null)
    {
      bool1 = bool2;
      if (!bs.isNullOrNil(this.kWi.getVideoPath()))
      {
        bool1 = bool2;
        if (this.Xy) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void bli()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { blf() });
    hideLoading();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = blh();
    int j = getVideoDurationSec();
    int k = (int)paramDouble;
    int i = k;
    if (j > 0)
    {
      i = k;
      if (paramDouble > j) {
        i = j;
      }
    }
    boolean bool1;
    if (this.kWi != null) {
      if (!bs.isNullOrNil(this.kWi.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ac.m("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { blf(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (!bool2) {
        break;
      }
      if (this.kWi == null) {
        break label202;
      }
      showLoading();
      tc(i);
      this.kWi.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.kWp = i;
    if (bool1) {
      this.kWo = true;
    }
    for (;;)
    {
      label202:
      return false;
      this.kWo = paramBoolean;
      start();
    }
  }
  
  protected a dC(Context paramContext)
  {
    return null;
  }
  
  public final void dZ(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.kOW != null) {
      this.kOW.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  public final void eS(boolean paramBoolean)
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { blf(), Boolean.valueOf(paramBoolean) });
    if (this.kWi != null) {
      this.kWi.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gL(paramBoolean);
    tc(getCurrPosSec());
    if (paramBoolean)
    {
      ble();
      this.kWm = false;
      if (this.kOW != null) {
        this.kOW.dr(getSessionId(), getMediaId());
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.kWi != null) {
      return this.kWi.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.kWi != null) {
      return Math.round(this.kWi.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.kWn;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.kWi != null) {
      return Math.round(this.kWi.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gox.removeCallbacks(this.kWy);
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194663);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(194663);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.kOW != null) {
          AbstractVideoView.this.kOW.dt(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.kWd != null) && (AbstractVideoView.this.kWd.getVisibility() != 8))
        {
          ac.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { AbstractVideoView.this.blf() });
          AbstractVideoView.this.kWd.setVisibility(8);
        }
        AppMethodBeat.o(194663);
      }
    });
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    if (this.kWi != null) {
      bool = this.kWi.isPlaying();
    }
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public void onCompletion()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { blf(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    tc(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.kOW != null) {
      this.kOW.dp(getSessionId(), getMediaId());
    }
    this.kWs = 0;
    this.kWr = 0L;
  }
  
  public final void onError(final int paramInt1, int paramInt2)
  {
    ac.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bvh) });
    this.bvh += 1;
    if (this.bvh > 5)
    {
      e.c localc;
      String str2;
      String str3;
      String str1;
      if (this.kOW != null)
      {
        localc = this.kOW;
        str2 = getSessionId();
        str3 = getMediaId();
        if (paramInt1 != -1010) {
          break label120;
        }
        str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      }
      for (;;)
      {
        localc.c(str2, str3, str1, paramInt1, paramInt2);
        stop();
        hideLoading();
        return;
        label120:
        if (paramInt1 == -1007) {
          str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
        } else if (paramInt1 == -1004)
        {
          if (!ax.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!ax.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.kWp == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.kWp)
    {
      ac.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(this.kWp), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gox.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194657);
          AbstractVideoView.this.kWq = true;
          AbstractVideoView.this.tc(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.kWq = false;
          AppMethodBeat.o(194657);
        }
      }, 200L);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { blf() });
    stop();
    this.gox.removeCallbacksAndMessages(null);
    stopTimer();
    this.kWv.stopTimer();
  }
  
  public void onUIPause()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { blf(), bs.eWi() });
    this.kWl = getCurrPosSec();
    this.kWm = isPlaying();
    this.kWs = 0;
    this.kWr = 0L;
    pause();
    stopTimer();
    this.kWa = false;
  }
  
  public void onUIResume()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { blf(), bs.eWi() });
    this.kWa = true;
  }
  
  public final boolean pause()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { blf() });
    if (this.kWi != null)
    {
      gL(false);
      this.kWi.pause();
      stopTimer();
      if (this.kOW != null) {
        this.kOW.dq(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public final boolean play()
  {
    if (!this.kWa) {
      ac.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { blf(), bs.eWi() });
    }
    while (this.kWi == null) {
      return false;
    }
    boolean bool = this.kWi.start();
    ac.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { blf(), Boolean.valueOf(bool), Boolean.valueOf(this.kWm) });
    gL(bool);
    if (bool)
    {
      this.kWm = false;
      ble();
      if (this.kOW != null) {
        this.kOW.dr(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public final void rB()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { blf(), Boolean.valueOf(this.kWo), Integer.valueOf(this.kWp), Boolean.valueOf(this.Xy) });
    this.Xy = true;
    if (this.kWi != null) {
      this.kWi.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.kWo) {
      if (this.kWp < 0) {
        if (play()) {
          this.kWu.au(1000L, 1000L);
        }
      }
    }
    for (;;)
    {
      this.kWp = -1;
      this.kWo = true;
      this.kWs = 0;
      this.kWr = 0L;
      if (this.kOW != null) {
        this.kOW.jdMethod_do(getSessionId(), getMediaId());
      }
      if (this.bvh > 0)
      {
        ac.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { blf() });
        this.kWv.au(5000L, 5000L);
      }
      return;
      if (!bed())
      {
        c(this.kWp, this.kWo);
      }
      else
      {
        play();
        continue;
        if (this.kWp >= 0) {
          c(this.kWp, false);
        }
      }
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { blf() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.kWb != null)) {
      this.kWb.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.kOW = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { blf(), Boolean.valueOf(paramBoolean) });
    this.kWj = paramBoolean;
    if (this.kWj)
    {
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194664);
          if ((AbstractVideoView.this.kWf != null) && (AbstractVideoView.this.kWf.getVisibility() != 0)) {
            AbstractVideoView.this.kWf.setVisibility(0);
          }
          AppMethodBeat.o(194664);
        }
      });
      return;
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194665);
        if ((AbstractVideoView.this.kWf != null) && (AbstractVideoView.this.kWf.getVisibility() != 8)) {
          AbstractVideoView.this.kWf.setVisibility(8);
        }
        AppMethodBeat.o(194665);
      }
    });
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.kWi != null) {
      this.kWi.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    if (!(paramb instanceof View))
    {
      ac.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { blf() });
      return;
    }
    if (this.kWh != null) {
      this.kWf.removeView((View)this.kWh);
    }
    this.kWh = paramb;
    this.kWk = false;
    this.kWf.addView((View)this.kWh);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.kWh != null) && (this.kWh.getVideoTotalTime() != paramInt)) {
      this.kWh.setVideoTotalTime(paramInt);
    }
  }
  
  protected final void showLoading()
  {
    this.gox.removeCallbacks(this.kWy);
    this.gox.postDelayed(this.kWy, 500L);
  }
  
  public final void stop()
  {
    ac.i("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { blf() });
    if (this.kWi != null) {
      this.kWi.stop();
    }
    this.kWp = -1;
    this.kWo = true;
    this.Xy = false;
    this.kWs = 0;
    this.kWr = 0L;
    stopTimer();
    this.gox.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194656);
        try
        {
          AbstractVideoView.this.tc(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(194656);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(194656);
        }
      }
    }, 10L);
  }
  
  protected final void tc(int paramInt)
  {
    if (this.kWh != null) {
      this.kWh.sQ(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */