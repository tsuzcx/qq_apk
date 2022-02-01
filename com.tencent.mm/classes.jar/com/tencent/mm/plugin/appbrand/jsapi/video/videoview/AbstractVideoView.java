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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements e, a.a, a.b, a.c, a.d, a.e
{
  protected boolean ZA = false;
  protected int bFM = 0;
  protected MMHandler hAk = new MMHandler(Looper.getMainLooper());
  protected TextView hPF;
  private boolean isWaiting = false;
  protected Context mContext;
  protected TextView mEA;
  protected LinearLayout mEB;
  protected VideoPlayerSeekBar mEC;
  protected e.b mED;
  protected a mEE;
  protected boolean mEF;
  protected boolean mEG = true;
  protected int mEH = 0;
  protected boolean mEI = false;
  protected int mEJ = 0;
  protected boolean mEK = true;
  protected int mEL = -1;
  protected boolean mEM = false;
  protected long mEN = 0L;
  protected int mEO = 0;
  protected MTimerHandler mEP = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(235178);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(235178);
        return false;
      }
      if (AbstractVideoView.this.mEI)
      {
        if (AbstractVideoView.this.mwz != null) {
          AbstractVideoView.this.mwz.dK(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.mEI = false;
      }
      AbstractVideoView.this.xI(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      AppMethodBeat.o(235178);
      return true;
    }
  }, true);
  protected MTimerHandler mEQ = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(235181);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      Log.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bgQ(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.mEE != null) && (i <= 50)) {
        AbstractVideoView.this.mEE.q(0.0D);
      }
      AppMethodBeat.o(235181);
      return false;
    }
  }, false);
  protected MTimerHandler mER = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(235182);
      if (AbstractVideoView.this.bFM > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(235182);
          return false;
        }
        AppMethodBeat.o(235182);
        return true;
      }
      AppMethodBeat.o(235182);
      return false;
    }
  }, true);
  private e.d mES = new e.d()
  {
    public final void aJq() {}
    
    public final void rk(int paramAnonymousInt)
    {
      AppMethodBeat.i(235183);
      if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
        AbstractVideoView.this.bLf();
      }
      if (AbstractVideoView.this.mEC != null) {
        AbstractVideoView.this.mEC.setIsPlay(true);
      }
      AppMethodBeat.o(235183);
    }
  };
  private View.OnClickListener mET = new AbstractVideoView.7(this);
  private Runnable mEU = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(235185);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.mEz != null) && (AbstractVideoView.this.mEz.getVisibility() != 0))
      {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { AbstractVideoView.this.bgQ() });
        AbstractVideoView.this.mEz.setVisibility(0);
      }
      if (AbstractVideoView.this.mwz != null) {
        AbstractVideoView.this.mwz.dL(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(235185);
    }
  };
  protected boolean mEw = true;
  protected ImageView mEx;
  protected RelativeLayout mEy;
  protected ProgressBar mEz;
  protected e.c mwz;
  
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
    Log.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { bgQ() });
    LayoutInflater.from(this.mContext).inflate(2131492998, this);
    this.mEx = ((ImageView)findViewById(2131309829));
    this.mEy = ((RelativeLayout)findViewById(2131309821));
    this.hPF = ((TextView)findViewById(2131309754));
    this.mEz = ((ProgressBar)findViewById(2131309778));
    this.mEA = ((TextView)findViewById(2131309834));
    this.mEB = ((LinearLayout)findViewById(2131309767));
    paramContext = (VideoPlayerSeekBar)findViewById(2131309804);
    this.mEC = paramContext;
    this.mED = paramContext;
    if (this.mEC != null)
    {
      this.mEC.setIplaySeekCallback(this.mES);
      this.mEC.setOnClickListener(this.mET);
    }
    this.mEE = dZ(this.mContext);
    this.mEE.setVideoCallback(this);
    this.mEE.setOnSeekCompleteCallback(this);
    this.mEE.setOnInfoCallback(this);
    this.mEE.setOnSurfaceCallback(this);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    this.mEy.addView((View)this.mEE, 0, paramContext);
  }
  
  private void hP(boolean paramBoolean)
  {
    if (this.mED != null) {
      this.mED.hP(paramBoolean);
    }
  }
  
  private void stopTimer()
  {
    this.mEP.stopTimer();
    this.mEQ.stopTimer();
  }
  
  protected final boolean asa()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mEE != null)
    {
      bool1 = bool2;
      if (!Util.isNullOrNil(this.mEE.getVideoPath()))
      {
        bool1 = bool2;
        if (this.ZA) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected final void bLf()
  {
    Log.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { bgQ(), Boolean.FALSE });
    this.mEP.startTimer(500L);
  }
  
  public final boolean bLg()
  {
    if (this.mEE == null) {
      return false;
    }
    if (isPlaying()) {
      pause();
    }
    for (;;)
    {
      return true;
      if (Util.isNullOrNil(this.mEE.getVideoPath())) {
        start();
      } else {
        play();
      }
    }
  }
  
  public final void bLh()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { bgQ() });
    hideLoading();
  }
  
  protected final String bgQ()
  {
    return hashCode();
  }
  
  public final void bgX()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { bgQ() });
    bLf();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = asa();
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
    if (this.mEE != null) {
      if (!Util.isNullOrNil(this.mEE.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bgQ(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (!bool2) {
        break;
      }
      if (this.mEE == null) {
        break label197;
      }
      showLoading();
      xI(i);
      this.mEE.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.mEL = i;
    this.mEK = paramBoolean;
    label197:
    return false;
  }
  
  protected a dZ(Context paramContext)
  {
    return null;
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.mwz != null) {
      this.mwz.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  public final void fN(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { bgQ(), Boolean.valueOf(paramBoolean) });
    if (this.mEE != null) {
      this.mEE.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    hP(paramBoolean);
    xI(getCurrPosSec());
    if (paramBoolean)
    {
      bLf();
      this.mEI = false;
      if (this.mwz != null) {
        this.mwz.dK(getSessionId(), getMediaId());
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.mEE != null) {
      return this.mEE.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.mEE != null) {
      return Math.round(this.mEE.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.mEJ;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.mEE != null) {
      return Math.round(this.mEE.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.hAk.removeCallbacks(this.mEU);
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235186);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(235186);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.mwz != null) {
          AbstractVideoView.this.mwz.dM(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.mEz != null) && (AbstractVideoView.this.mEz.getVisibility() != 8))
        {
          Log.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { AbstractVideoView.this.bgQ() });
          AbstractVideoView.this.mEz.setVisibility(8);
        }
        AppMethodBeat.o(235186);
      }
    });
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    if (this.mEE != null) {
      bool = this.mEE.isPlaying();
    }
    return bool;
  }
  
  public void onCompletion()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { bgQ(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    xI(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.mwz != null) {
      this.mwz.dI(getSessionId(), getMediaId());
    }
    this.mEO = 0;
    this.mEN = 0L;
  }
  
  public final void onError(final int paramInt1, int paramInt2)
  {
    Log.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bFM) });
    this.bFM += 1;
    if (this.bFM > 5)
    {
      e.c localc;
      String str2;
      String str3;
      String str1;
      if (this.mwz != null)
      {
        localc = this.mwz;
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
          if (!NetStatusUtil.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!NetStatusUtil.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.mEL == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.mEL)
    {
      Log.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(this.mEL), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.hAk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235180);
          AbstractVideoView.this.mEM = true;
          AbstractVideoView.this.xI(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.mEM = false;
          AppMethodBeat.o(235180);
        }
      }, 200L);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { bgQ() });
    stop();
    this.hAk.removeCallbacksAndMessages(null);
    stopTimer();
    this.mER.stopTimer();
  }
  
  public void onUIPause()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { bgQ(), Util.getStack() });
    this.mEH = getCurrPosSec();
    this.mEI = isPlaying();
    this.mEO = 0;
    this.mEN = 0L;
    pause();
    stopTimer();
    this.mEw = false;
  }
  
  public void onUIResume()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { bgQ(), Util.getStack() });
    this.mEw = true;
  }
  
  public final boolean p(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public final boolean pause()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { bgQ() });
    if (this.mEE != null)
    {
      hP(false);
      this.mEE.pause();
      stopTimer();
      if (this.mwz != null) {
        this.mwz.dJ(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public final boolean play()
  {
    if (!this.mEw) {
      Log.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { bgQ(), Util.getStack() });
    }
    while (this.mEE == null) {
      return false;
    }
    boolean bool = this.mEE.start();
    Log.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bgQ(), Boolean.valueOf(bool), Boolean.valueOf(this.mEI) });
    hP(bool);
    if (bool)
    {
      this.mEI = false;
      bLf();
      if (this.mwz != null) {
        this.mwz.dK(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { bgQ() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.mEx != null)) {
      this.mEx.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.mwz = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { bgQ(), Boolean.valueOf(paramBoolean) });
    this.mEF = paramBoolean;
    if (this.mEF)
    {
      this.hAk.post(new AbstractVideoView.10(this));
      return;
    }
    this.hAk.post(new AbstractVideoView.11(this));
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.mEE != null) {
      this.mEE.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    if (!(paramb instanceof View))
    {
      Log.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { bgQ() });
      return;
    }
    if (this.mED != null) {
      this.mEB.removeView((View)this.mED);
    }
    this.mED = paramb;
    this.mEG = false;
    this.mEB.addView((View)this.mED);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.mED != null) && (this.mED.getVideoTotalTime() != paramInt)) {
      this.mED.setVideoTotalTime(paramInt);
    }
  }
  
  protected final void showLoading()
  {
    this.hAk.removeCallbacks(this.mEU);
    this.hAk.postDelayed(this.mEU, 500L);
  }
  
  public final void stop()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { bgQ() });
    if (this.mEE != null) {
      this.mEE.stop();
    }
    this.mEL = -1;
    this.mEK = true;
    this.ZA = false;
    this.mEO = 0;
    this.mEN = 0L;
    stopTimer();
    this.hAk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235179);
        try
        {
          AbstractVideoView.this.xI(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(235179);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(235179);
        }
      }
    }, 10L);
  }
  
  public final void tf()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bgQ(), Boolean.valueOf(this.mEK), Integer.valueOf(this.mEL), Boolean.valueOf(this.ZA) });
    this.ZA = true;
    if (this.mEE != null) {
      this.mEE.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.mEK) {
      if (this.mEL < 0) {
        if (play()) {
          this.mEQ.startTimer(1000L);
        }
      }
    }
    for (;;)
    {
      this.mEL = -1;
      this.mEK = true;
      this.mEO = 0;
      this.mEN = 0L;
      if (this.mwz != null) {
        this.mwz.dH(getSessionId(), getMediaId());
      }
      if (this.bFM > 0)
      {
        Log.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { bgQ() });
        this.mER.startTimer(5000L);
      }
      return;
      if (!isLive())
      {
        c(this.mEL, this.mEK);
      }
      else
      {
        play();
        continue;
        if (this.mEL >= 0) {
          c(this.mEL, false);
        }
      }
    }
  }
  
  protected final void xI(int paramInt)
  {
    if (this.mED != null) {
      this.mED.xv(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */