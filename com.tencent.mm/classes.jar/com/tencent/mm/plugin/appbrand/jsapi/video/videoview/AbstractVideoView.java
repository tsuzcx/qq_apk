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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements e, a.a, a.b, a.c, a.d, a.e
{
  protected boolean WD = false;
  protected int bxy = 0;
  protected ap gAC = new ap(Looper.getMainLooper());
  private boolean isWaiting = false;
  protected e.c knC;
  protected boolean kuL = true;
  protected ImageView kuM;
  protected RelativeLayout kuN;
  protected TextView kuO;
  protected ProgressBar kuP;
  protected TextView kuQ;
  protected LinearLayout kuR;
  protected VideoPlayerSeekBar kuS;
  protected e.b kuT;
  protected a kuU;
  protected boolean kuV;
  protected boolean kuW = true;
  protected int kuX = 0;
  protected boolean kuY = false;
  protected int kuZ = 0;
  protected boolean kva = true;
  protected int kvb = -1;
  protected boolean kvc = false;
  protected long kvd = 0L;
  protected int kve = 0;
  protected av kvf = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(194310);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(194310);
        return false;
      }
      if (AbstractVideoView.this.kuY)
      {
        if (AbstractVideoView.this.knC != null) {
          AbstractVideoView.this.knC.de(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.kuY = false;
      }
      AbstractVideoView.this.sm(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      AppMethodBeat.o(194310);
      return true;
    }
  }, true);
  protected av kvg = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(194313);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ad.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bel(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.kuU != null) && (i <= 50)) {
        AbstractVideoView.this.kuU.q(0.0D);
      }
      AppMethodBeat.o(194313);
      return false;
    }
  }, false);
  protected av kvh = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(194314);
      if (AbstractVideoView.this.bxy > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(194314);
          return false;
        }
        AppMethodBeat.o(194314);
        return true;
      }
      AppMethodBeat.o(194314);
      return false;
    }
  }, true);
  private e.d kvi = new e.d()
  {
    public final void bcv() {}
    
    public final void rZ(int paramAnonymousInt)
    {
      AppMethodBeat.i(194315);
      if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
        AbstractVideoView.this.bek();
      }
      if (AbstractVideoView.this.kuS != null) {
        AbstractVideoView.this.kuS.setIsPlay(true);
      }
      AppMethodBeat.o(194315);
    }
  };
  private View.OnClickListener kvj = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(194316);
      ad.i("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bel() });
      AbstractVideoView.this.bem();
      AppMethodBeat.o(194316);
    }
  };
  private Runnable kvk = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(194317);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.kuP != null) && (AbstractVideoView.this.kuP.getVisibility() != 0))
      {
        ad.i("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { AbstractVideoView.this.bel() });
        AbstractVideoView.this.kuP.setVisibility(0);
      }
      if (AbstractVideoView.this.knC != null) {
        AbstractVideoView.this.knC.dg(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(194317);
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
    ad.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { bel() });
    LayoutInflater.from(this.mContext).inflate(2131496135, this);
    this.kuM = ((ImageView)findViewById(2131306398));
    this.kuN = ((RelativeLayout)findViewById(2131306392));
    this.kuO = ((TextView)findViewById(2131306332));
    this.kuP = ((ProgressBar)findViewById(2131306352));
    this.kuQ = ((TextView)findViewById(2131306403));
    this.kuR = ((LinearLayout)findViewById(2131306342));
    paramContext = (VideoPlayerSeekBar)findViewById(2131306375);
    this.kuS = paramContext;
    this.kuT = paramContext;
    if (this.kuS != null)
    {
      this.kuS.setIplaySeekCallback(this.kvi);
      this.kuS.setOnClickListener(this.kvj);
    }
    this.kuU = dt(this.mContext);
    this.kuU.setVideoCallback(this);
    this.kuU.setOnSeekCompleteCallback(this);
    this.kuU.setOnInfoCallback(this);
    this.kuU.setOnSurfaceCallback(this);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    this.kuN.addView((View)this.kuU, 0, paramContext);
  }
  
  private void gp(boolean paramBoolean)
  {
    if (this.kuT != null) {
      this.kuT.gp(paramBoolean);
    }
  }
  
  private void stopTimer()
  {
    this.kvf.stopTimer();
    this.kvg.stopTimer();
  }
  
  public final void aCw()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { bel() });
    bek();
  }
  
  protected final void bek()
  {
    ad.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { bel(), Boolean.FALSE });
    this.kvf.av(500L, 500L);
  }
  
  protected final String bel()
  {
    return hashCode();
  }
  
  public final boolean bem()
  {
    if (this.kuU == null) {
      return false;
    }
    if (isPlaying()) {
      pause();
    }
    for (;;)
    {
      return true;
      if (bt.isNullOrNil(this.kuU.getVideoPath())) {
        start();
      } else {
        play();
      }
    }
  }
  
  protected final boolean ben()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.kuU != null)
    {
      bool1 = bool2;
      if (!bt.isNullOrNil(this.kuU.getVideoPath()))
      {
        bool1 = bool2;
        if (this.WD) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void beo()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { bel() });
    hideLoading();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = ben();
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
    if (this.kuU != null) {
      if (!bt.isNullOrNil(this.kuU.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ad.m("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bel(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (!bool2) {
        break;
      }
      if (this.kuU == null) {
        break label202;
      }
      showLoading();
      sm(i);
      this.kuU.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.kvb = i;
    if (bool1) {
      this.kva = true;
    }
    for (;;)
    {
      label202:
      return false;
      this.kva = paramBoolean;
      start();
    }
  }
  
  public final void dY(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.knC != null) {
      this.knC.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  protected a dt(Context paramContext)
  {
    return null;
  }
  
  public final void ey(boolean paramBoolean)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { bel(), Boolean.valueOf(paramBoolean) });
    if (this.kuU != null) {
      this.kuU.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gp(paramBoolean);
    sm(getCurrPosSec());
    if (paramBoolean)
    {
      bek();
      this.kuY = false;
      if (this.knC != null) {
        this.knC.de(getSessionId(), getMediaId());
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.kuU != null) {
      return this.kuU.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.kuU != null) {
      return Math.round(this.kuU.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.kuZ;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.kuU != null) {
      return Math.round(this.kuU.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gAC.removeCallbacks(this.kvk);
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194318);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(194318);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.knC != null) {
          AbstractVideoView.this.knC.dh(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.kuP != null) && (AbstractVideoView.this.kuP.getVisibility() != 8))
        {
          ad.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { AbstractVideoView.this.bel() });
          AbstractVideoView.this.kuP.setVisibility(8);
        }
        AppMethodBeat.o(194318);
      }
    });
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    if (this.kuU != null) {
      bool = this.kuU.isPlaying();
    }
    return bool;
  }
  
  public void onCompletion()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { bel(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    sm(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.knC != null) {
      this.knC.dc(getSessionId(), getMediaId());
    }
    this.kve = 0;
    this.kvd = 0L;
  }
  
  public final void onError(final int paramInt1, int paramInt2)
  {
    ad.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bxy) });
    this.bxy += 1;
    if (this.bxy > 5)
    {
      e.c localc;
      String str2;
      String str3;
      String str1;
      if (this.knC != null)
      {
        localc = this.knC;
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
          if (!ay.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!ay.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.kvb == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.kvb)
    {
      ad.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(this.kvb), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gAC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194312);
          AbstractVideoView.this.kvc = true;
          AbstractVideoView.this.sm(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.kvc = false;
          AppMethodBeat.o(194312);
        }
      }, 200L);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { bel() });
    stop();
    this.gAC.removeCallbacksAndMessages(null);
    stopTimer();
    this.kvh.stopTimer();
  }
  
  public void onUIPause()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { bel(), bt.eGN() });
    this.kuX = getCurrPosSec();
    this.kuY = isPlaying();
    this.kve = 0;
    this.kvd = 0L;
    pause();
    stopTimer();
    this.kuL = false;
  }
  
  public void onUIResume()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { bel(), bt.eGN() });
    this.kuL = true;
  }
  
  public final boolean p(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public final boolean pause()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { bel() });
    if (this.kuU != null)
    {
      gp(false);
      this.kuU.pause();
      stopTimer();
      if (this.knC != null) {
        this.knC.dd(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public final boolean play()
  {
    if (!this.kuL) {
      ad.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { bel(), bt.eGN() });
    }
    while (this.kuU == null) {
      return false;
    }
    boolean bool = this.kuU.start();
    ad.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bel(), Boolean.valueOf(bool), Boolean.valueOf(this.kuY) });
    gp(bool);
    if (bool)
    {
      this.kuY = false;
      bek();
      if (this.knC != null) {
        this.knC.de(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public final void rq()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bel(), Boolean.valueOf(this.kva), Integer.valueOf(this.kvb), Boolean.valueOf(this.WD) });
    this.WD = true;
    if (this.kuU != null) {
      this.kuU.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.kva) {
      if (this.kvb < 0) {
        if (play()) {
          this.kvg.av(1000L, 1000L);
        }
      }
    }
    for (;;)
    {
      this.kvb = -1;
      this.kva = true;
      this.kve = 0;
      this.kvd = 0L;
      if (this.knC != null) {
        this.knC.db(getSessionId(), getMediaId());
      }
      if (this.bxy > 0)
      {
        ad.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { bel() });
        this.kvh.av(5000L, 5000L);
      }
      return;
      if (!aXf())
      {
        c(this.kvb, this.kva);
      }
      else
      {
        play();
        continue;
        if (this.kvb >= 0) {
          c(this.kvb, false);
        }
      }
    }
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { bel() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.kuM != null)) {
      this.kuM.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.knC = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { bel(), Boolean.valueOf(paramBoolean) });
    this.kuV = paramBoolean;
    if (this.kuV)
    {
      this.gAC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194319);
          if ((AbstractVideoView.this.kuR != null) && (AbstractVideoView.this.kuR.getVisibility() != 0)) {
            AbstractVideoView.this.kuR.setVisibility(0);
          }
          AppMethodBeat.o(194319);
        }
      });
      return;
    }
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194320);
        if ((AbstractVideoView.this.kuR != null) && (AbstractVideoView.this.kuR.getVisibility() != 8)) {
          AbstractVideoView.this.kuR.setVisibility(8);
        }
        AppMethodBeat.o(194320);
      }
    });
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.kuU != null) {
      this.kuU.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    if (!(paramb instanceof View))
    {
      ad.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { bel() });
      return;
    }
    if (this.kuT != null) {
      this.kuR.removeView((View)this.kuT);
    }
    this.kuT = paramb;
    this.kuW = false;
    this.kuR.addView((View)this.kuT);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.kuT != null) && (this.kuT.getVideoTotalTime() != paramInt)) {
      this.kuT.setVideoTotalTime(paramInt);
    }
  }
  
  protected final void showLoading()
  {
    this.gAC.removeCallbacks(this.kvk);
    this.gAC.postDelayed(this.kvk, 500L);
  }
  
  protected final void sm(int paramInt)
  {
    if (this.kuT != null) {
      this.kuT.sa(paramInt);
    }
  }
  
  public final void stop()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { bel() });
    if (this.kuU != null) {
      this.kuU.stop();
    }
    this.kvb = -1;
    this.kva = true;
    this.WD = false;
    this.kve = 0;
    this.kvd = 0L;
    stopTimer();
    this.gAC.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194311);
        try
        {
          AbstractVideoView.this.sm(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(194311);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(194311);
        }
      }
    }, 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */