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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements d, a.a, a.b, a.c, a.d, a.e
{
  protected int bpq = 0;
  protected boolean gX = false;
  private boolean isWaiting = false;
  protected TextView kEb;
  protected MMHandler knk = new MMHandler(Looper.getMainLooper());
  protected Context mContext;
  protected boolean pDI = true;
  protected ImageView pDJ;
  protected RelativeLayout pDK;
  protected ProgressBar pDL;
  protected TextView pDM;
  protected LinearLayout pDN;
  protected VideoPlayerSeekBar pDO;
  protected d.b pDP;
  protected a pDQ;
  protected boolean pDR;
  protected boolean pDS = true;
  protected int pDT = 0;
  protected boolean pDU = false;
  protected int pDV = 0;
  protected boolean pDW = true;
  protected int pDX = -1;
  protected boolean pDY = false;
  protected long pDZ = 0L;
  protected int pEa = 0;
  protected MTimerHandler pEb = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(229914);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(229914);
        return false;
      }
      if (AbstractVideoView.this.pDU)
      {
        if (AbstractVideoView.this.puZ != null) {
          AbstractVideoView.this.puZ.dV(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.pDU = false;
      }
      AbstractVideoView.this.Bg(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      AppMethodBeat.o(229914);
      return true;
    }
  }, true);
  protected MTimerHandler pEc = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(230503);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      Log.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bqf(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.pDQ != null) && (i <= 50)) {
        AbstractVideoView.this.pDQ.q(0.0D);
      }
      AppMethodBeat.o(230503);
      return false;
    }
  }, false);
  protected MTimerHandler pEd = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(230633);
      if (AbstractVideoView.this.bpq > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(230633);
          return false;
        }
        AppMethodBeat.o(230633);
        return true;
      }
      AppMethodBeat.o(230633);
      return false;
    }
  }, true);
  private d.d pEe = new d.d()
  {
    public final void aRo() {}
    
    public final void tY(int paramAnonymousInt)
    {
      AppMethodBeat.i(230115);
      if (AbstractVideoView.this.a(paramAnonymousInt, true)) {
        AbstractVideoView.this.bXf();
      }
      if (AbstractVideoView.this.pDO != null) {
        AbstractVideoView.this.pDO.setIsPlay(true);
      }
      AppMethodBeat.o(230115);
    }
  };
  private View.OnClickListener pEf = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(227013);
      b localb = new b();
      localb.bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bqf() });
      AbstractVideoView.this.bXg();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227013);
    }
  };
  private Runnable pEg = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(227263);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.pDL != null) && (AbstractVideoView.this.pDL.getVisibility() != 0))
      {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { AbstractVideoView.this.bqf() });
        AbstractVideoView.this.pDL.setVisibility(0);
      }
      if (AbstractVideoView.this.puZ != null) {
        AbstractVideoView.this.puZ.dW(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(227263);
    }
  };
  protected d.c puZ;
  
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
    Log.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { bqf() });
    LayoutInflater.from(this.mContext).inflate(com.tencent.luggage.b.d.a.d.app_brand_abstract_video_view, this);
    this.pDJ = ((ImageView)findViewById(com.tencent.luggage.b.d.a.c.video_thumb));
    this.pDK = ((RelativeLayout)findViewById(com.tencent.luggage.b.d.a.c.video_root));
    this.kEb = ((TextView)findViewById(com.tencent.luggage.b.d.a.c.video_duration));
    this.pDL = ((ProgressBar)findViewById(com.tencent.luggage.b.d.a.c.video_loading));
    this.pDM = ((TextView)findViewById(com.tencent.luggage.b.d.a.c.video_tips));
    this.pDN = ((LinearLayout)findViewById(com.tencent.luggage.b.d.a.c.video_footer_root));
    paramContext = (VideoPlayerSeekBar)findViewById(com.tencent.luggage.b.d.a.c.video_player_seek_bar);
    this.pDO = paramContext;
    this.pDP = paramContext;
    if (this.pDO != null)
    {
      this.pDO.setIplaySeekCallback(this.pEe);
      this.pDO.setOnClickListener(this.pEf);
    }
    this.pDQ = dX(this.mContext);
    this.pDQ.setVideoCallback(this);
    this.pDQ.setOnSeekCompleteCallback(this);
    this.pDQ.setOnInfoCallback(this);
    this.pDQ.setOnSurfaceCallback(this);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    this.pDK.addView((View)this.pDQ, 0, paramContext);
  }
  
  private void iF(boolean paramBoolean)
  {
    if (this.pDP != null) {
      this.pDP.iF(paramBoolean);
    }
  }
  
  private void stopTimer()
  {
    this.pEb.stopTimer();
    this.pEc.stopTimer();
  }
  
  protected final void Bg(int paramInt)
  {
    if (this.pDP != null) {
      this.pDP.AS(paramInt);
    }
  }
  
  public boolean a(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = ayN();
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
    if (this.pDQ != null) {
      if (!Util.isNullOrNil(this.pDQ.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bqf(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (!bool2) {
        break;
      }
      if (this.pDQ == null) {
        break label197;
      }
      showLoading();
      Bg(i);
      this.pDQ.b(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.pDX = i;
    this.pDW = paramBoolean;
    label197:
    return false;
  }
  
  protected final boolean ayN()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.pDQ != null)
    {
      bool1 = bool2;
      if (!Util.isNullOrNil(this.pDQ.getVideoPath()))
      {
        bool1 = bool2;
        if (this.gX) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected final void bXf()
  {
    Log.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { bqf(), Boolean.FALSE });
    this.pEb.startTimer(500L);
  }
  
  public final boolean bXg()
  {
    if (this.pDQ == null) {
      return false;
    }
    if (isPlaying()) {
      pause();
    }
    for (;;)
    {
      return true;
      if (Util.isNullOrNil(this.pDQ.getVideoPath())) {
        start();
      } else {
        bqo();
      }
    }
  }
  
  public final void bXh()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { bqf() });
    hideLoading();
  }
  
  protected final String bqf()
  {
    return hashCode();
  }
  
  public final boolean bqo()
  {
    if (!this.pDI) {
      Log.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { bqf(), Util.getStack() });
    }
    while (this.pDQ == null) {
      return false;
    }
    boolean bool = this.pDQ.start();
    Log.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bqf(), Boolean.valueOf(bool), Boolean.valueOf(this.pDU) });
    iF(bool);
    if (bool)
    {
      this.pDU = false;
      bXf();
      if (this.puZ != null) {
        this.puZ.dV(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public final void bqp()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { bqf() });
    bXf();
  }
  
  protected a dX(Context paramContext)
  {
    return null;
  }
  
  public final void eM(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.puZ != null) {
      this.puZ.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.pDQ != null) {
      return this.pDQ.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.pDQ != null) {
      return Math.round(this.pDQ.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.pDV;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.pDQ != null) {
      return Math.round(this.pDQ.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  public final void gz(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { bqf(), Boolean.valueOf(paramBoolean) });
    if (this.pDQ != null) {
      this.pDQ.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    iF(paramBoolean);
    Bg(getCurrPosSec());
    if (paramBoolean)
    {
      bXf();
      this.pDU = false;
      if (this.puZ != null) {
        this.puZ.dV(getSessionId(), getMediaId());
      }
    }
  }
  
  protected void hideLoading()
  {
    this.knk.removeCallbacks(this.pEg);
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228088);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(228088);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.puZ != null) {
          AbstractVideoView.this.puZ.dX(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.pDL != null) && (AbstractVideoView.this.pDL.getVisibility() != 8))
        {
          Log.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { AbstractVideoView.this.bqf() });
          AbstractVideoView.this.pDL.setVisibility(8);
        }
        AppMethodBeat.o(228088);
      }
    });
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    if (this.pDQ != null) {
      bool = this.pDQ.isPlaying();
    }
    return bool;
  }
  
  public void onCompletion()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { bqf(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    Bg(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.puZ != null) {
      this.puZ.dT(getSessionId(), getMediaId());
    }
    this.pEa = 0;
    this.pDZ = 0L;
  }
  
  public final void onError(final int paramInt1, int paramInt2)
  {
    Log.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bpq) });
    this.bpq += 1;
    if (this.bpq > 0)
    {
      d.c localc;
      String str2;
      String str3;
      String str1;
      if (this.puZ != null)
      {
        localc = this.puZ;
        str2 = getSessionId();
        str3 = getMediaId();
        if (paramInt1 != -1010) {
          break label119;
        }
        str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      }
      for (;;)
      {
        localc.c(str2, str3, str1, paramInt1, paramInt2);
        stop();
        hideLoading();
        return;
        label119:
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
    if (this.pDX == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.pDX)
    {
      Log.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(this.pDX), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.knk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230626);
          AbstractVideoView.this.pDY = true;
          AbstractVideoView.this.Bg(paramInt1);
          AbstractVideoView.this.a(paramInt1, true);
          AbstractVideoView.this.pDY = false;
          AppMethodBeat.o(230626);
        }
      }, 200L);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { bqf() });
    stop();
    this.knk.removeCallbacksAndMessages(null);
    stopTimer();
    this.pEd.stopTimer();
  }
  
  public void onUIPause()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { bqf(), Util.getStack() });
    this.pDT = getCurrPosSec();
    this.pDU = isPlaying();
    this.pEa = 0;
    this.pDZ = 0L;
    pause();
    stopTimer();
    this.pDI = false;
  }
  
  public void onUIResume()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { bqf(), Util.getStack() });
    this.pDI = true;
  }
  
  public final boolean p(double paramDouble)
  {
    return a(paramDouble, isPlaying());
  }
  
  public final boolean pause()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { bqf() });
    if (this.pDQ != null)
    {
      iF(false);
      this.pDQ.pause();
      stopTimer();
      if (this.puZ != null) {
        this.puZ.dU(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public final void qX()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bqf(), Boolean.valueOf(this.pDW), Integer.valueOf(this.pDX), Boolean.valueOf(this.gX) });
    this.gX = true;
    if (this.pDQ != null) {
      this.pDQ.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.pDW) {
      if (this.pDX < 0) {
        if (bqo()) {
          this.pEc.startTimer(1000L);
        }
      }
    }
    for (;;)
    {
      this.pDX = -1;
      this.pDW = true;
      this.pEa = 0;
      this.pDZ = 0L;
      if (this.puZ != null) {
        this.puZ.dS(getSessionId(), getMediaId());
      }
      if (this.bpq > 0)
      {
        Log.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { bqf() });
        this.pEd.startTimer(5000L);
      }
      return;
      if (!isLive())
      {
        a(this.pDX, this.pDW);
      }
      else
      {
        bqo();
        continue;
        if (this.pDX >= 0) {
          a(this.pDX, false);
        }
      }
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { bqf() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.pDJ != null)) {
      this.pDJ.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(d.c paramc)
  {
    this.puZ = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { bqf(), Boolean.valueOf(paramBoolean) });
    this.pDR = paramBoolean;
    if (this.pDR)
    {
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(229123);
          if ((AbstractVideoView.this.pDN != null) && (AbstractVideoView.this.pDN.getVisibility() != 0)) {
            AbstractVideoView.this.pDN.setVisibility(0);
          }
          AppMethodBeat.o(229123);
        }
      });
      return;
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228482);
        if ((AbstractVideoView.this.pDN != null) && (AbstractVideoView.this.pDN.getVisibility() != 8)) {
          AbstractVideoView.this.pDN.setVisibility(8);
        }
        AppMethodBeat.o(228482);
      }
    });
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.pDQ != null) {
      this.pDQ.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(d.b paramb)
  {
    if (!(paramb instanceof View))
    {
      Log.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { bqf() });
      return;
    }
    if (this.pDP != null) {
      this.pDN.removeView((View)this.pDP);
    }
    this.pDP = paramb;
    this.pDS = false;
    this.pDN.addView((View)this.pDP);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.pDP != null) && (this.pDP.getVideoTotalTime() != paramInt)) {
      this.pDP.setVideoTotalTime(paramInt);
    }
  }
  
  protected final void showLoading()
  {
    this.knk.removeCallbacks(this.pEg);
    this.knk.postDelayed(this.pEg, 500L);
  }
  
  public final void stop()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { bqf() });
    if (this.pDQ != null) {
      this.pDQ.stop();
    }
    this.pDX = -1;
    this.pDW = true;
    this.gX = false;
    this.pEa = 0;
    this.pDZ = 0L;
    stopTimer();
    this.knk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226872);
        try
        {
          AbstractVideoView.this.Bg(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(226872);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(226872);
        }
      }
    }, 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */