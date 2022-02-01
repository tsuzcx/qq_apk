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
  protected boolean Zn = false;
  protected int bFv = 0;
  protected ap gIf = new ap(Looper.getMainLooper());
  protected TextView gUc;
  private boolean isWaiting = false;
  protected e.c llz;
  protected boolean lsZ = true;
  protected ImageView lta;
  protected RelativeLayout ltb;
  protected ProgressBar ltc;
  protected TextView ltd;
  protected LinearLayout lte;
  protected VideoPlayerSeekBar ltf;
  protected e.b ltg;
  protected a lth;
  protected boolean lti;
  protected boolean ltj = true;
  protected int ltk = 0;
  protected boolean ltl = false;
  protected int ltm = 0;
  protected boolean ltn = true;
  protected int lto = -1;
  protected boolean ltp = false;
  protected long ltq = 0L;
  protected int ltr = 0;
  protected av lts = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(206469);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(206469);
        return false;
      }
      if (AbstractVideoView.this.ltl)
      {
        if (AbstractVideoView.this.llz != null) {
          AbstractVideoView.this.llz.dt(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.ltl = false;
      }
      AbstractVideoView.this.tF(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      AppMethodBeat.o(206469);
      return true;
    }
  }, true);
  protected av ltt = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(206472);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ad.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.boQ(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.lth != null) && (i <= 50)) {
        AbstractVideoView.this.lth.p(0.0D);
      }
      AppMethodBeat.o(206472);
      return false;
    }
  }, false);
  protected av ltu = new av(new av.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(206473);
      if (AbstractVideoView.this.bFv > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(206473);
          return false;
        }
        AppMethodBeat.o(206473);
        return true;
      }
      AppMethodBeat.o(206473);
      return false;
    }
  }, true);
  private e.d ltv = new AbstractVideoView.6(this);
  private View.OnClickListener ltw = new AbstractVideoView.7(this);
  private Runnable ltx = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(206476);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.ltc != null) && (AbstractVideoView.this.ltc.getVisibility() != 0))
      {
        ad.i("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { AbstractVideoView.this.boQ() });
        AbstractVideoView.this.ltc.setVisibility(0);
      }
      if (AbstractVideoView.this.llz != null) {
        AbstractVideoView.this.llz.du(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(206476);
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
    ad.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { boQ() });
    LayoutInflater.from(this.mContext).inflate(2131496135, this);
    this.lta = ((ImageView)findViewById(2131306398));
    this.ltb = ((RelativeLayout)findViewById(2131306392));
    this.gUc = ((TextView)findViewById(2131306332));
    this.ltc = ((ProgressBar)findViewById(2131306352));
    this.ltd = ((TextView)findViewById(2131306403));
    this.lte = ((LinearLayout)findViewById(2131306342));
    paramContext = (VideoPlayerSeekBar)findViewById(2131306375);
    this.ltf = paramContext;
    this.ltg = paramContext;
    if (this.ltf != null)
    {
      this.ltf.setIplaySeekCallback(this.ltv);
      this.ltf.setOnClickListener(this.ltw);
    }
    this.lth = dA(this.mContext);
    this.lth.setVideoCallback(this);
    this.lth.setOnSeekCompleteCallback(this);
    this.lth.setOnInfoCallback(this);
    this.lth.setOnSurfaceCallback(this);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    this.ltb.addView((View)this.lth, 0, paramContext);
  }
  
  private void gS(boolean paramBoolean)
  {
    if (this.ltg != null) {
      this.ltg.gS(paramBoolean);
    }
  }
  
  private void stopTimer()
  {
    this.lts.stopTimer();
    this.ltt.stopTimer();
  }
  
  public final void aMx()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { boQ() });
    boP();
  }
  
  protected final void boP()
  {
    ad.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { boQ(), Boolean.FALSE });
    this.lts.az(500L, 500L);
  }
  
  protected final String boQ()
  {
    return hashCode();
  }
  
  public final boolean boR()
  {
    if (this.lth == null) {
      return false;
    }
    if (isPlaying()) {
      pause();
    }
    for (;;)
    {
      return true;
      if (bt.isNullOrNil(this.lth.getVideoPath())) {
        start();
      } else {
        play();
      }
    }
  }
  
  protected final boolean boS()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.lth != null)
    {
      bool1 = bool2;
      if (!bt.isNullOrNil(this.lth.getVideoPath()))
      {
        bool1 = bool2;
        if (this.Zn) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void boT()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { boQ() });
    hideLoading();
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = boS();
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
    if (this.lth != null) {
      if (!bt.isNullOrNil(this.lth.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ad.m("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { boQ(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (!bool2) {
        break;
      }
      if (this.lth == null) {
        break label202;
      }
      showLoading();
      tF(i);
      this.lth.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.lto = i;
    if (bool1) {
      this.ltn = true;
    }
    for (;;)
    {
      label202:
      return false;
      this.ltn = paramBoolean;
      start();
    }
  }
  
  protected a dA(Context paramContext)
  {
    return null;
  }
  
  public final void eU(boolean paramBoolean)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { boQ(), Boolean.valueOf(paramBoolean) });
    if (this.lth != null) {
      this.lth.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gS(paramBoolean);
    tF(getCurrPosSec());
    if (paramBoolean)
    {
      boP();
      this.ltl = false;
      if (this.llz != null) {
        this.llz.dt(getSessionId(), getMediaId());
      }
    }
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.llz != null) {
      this.llz.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.lth != null) {
      return this.lth.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.lth != null) {
      return Math.round(this.lth.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.ltm;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.lth != null) {
      return Math.round(this.lth.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gIf.removeCallbacks(this.ltx);
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206477);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(206477);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.llz != null) {
          AbstractVideoView.this.llz.dv(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.ltc != null) && (AbstractVideoView.this.ltc.getVisibility() != 8))
        {
          ad.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { AbstractVideoView.this.boQ() });
          AbstractVideoView.this.ltc.setVisibility(8);
        }
        AppMethodBeat.o(206477);
      }
    });
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    if (this.lth != null) {
      bool = this.lth.isPlaying();
    }
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public void onCompletion()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { boQ(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    tF(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.llz != null) {
      this.llz.dr(getSessionId(), getMediaId());
    }
    this.ltr = 0;
    this.ltq = 0L;
  }
  
  public final void onError(final int paramInt1, int paramInt2)
  {
    ad.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bFv) });
    this.bFv += 1;
    if (this.bFv > 5)
    {
      e.c localc;
      String str2;
      String str3;
      String str1;
      if (this.llz != null)
      {
        localc = this.llz;
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
    if (this.lto == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.lto)
    {
      ad.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(this.lto), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gIf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206471);
          AbstractVideoView.this.ltp = true;
          AbstractVideoView.this.tF(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.ltp = false;
          AppMethodBeat.o(206471);
        }
      }, 200L);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { boQ() });
    stop();
    this.gIf.removeCallbacksAndMessages(null);
    stopTimer();
    this.ltu.stopTimer();
  }
  
  public void onUIPause()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { boQ(), bt.flS() });
    this.ltk = getCurrPosSec();
    this.ltl = isPlaying();
    this.ltr = 0;
    this.ltq = 0L;
    pause();
    stopTimer();
    this.lsZ = false;
  }
  
  public void onUIResume()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { boQ(), bt.flS() });
    this.lsZ = true;
  }
  
  public final boolean pause()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { boQ() });
    if (this.lth != null)
    {
      gS(false);
      this.lth.pause();
      stopTimer();
      if (this.llz != null) {
        this.llz.ds(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public final boolean play()
  {
    if (!this.lsZ) {
      ad.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { boQ(), bt.flS() });
    }
    while (this.lth == null) {
      return false;
    }
    boolean bool = this.lth.start();
    ad.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { boQ(), Boolean.valueOf(bool), Boolean.valueOf(this.ltl) });
    gS(bool);
    if (bool)
    {
      this.ltl = false;
      boP();
      if (this.llz != null) {
        this.llz.dt(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { boQ() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.lta != null)) {
      this.lta.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.llz = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { boQ(), Boolean.valueOf(paramBoolean) });
    this.lti = paramBoolean;
    if (this.lti)
    {
      this.gIf.post(new AbstractVideoView.10(this));
      return;
    }
    this.gIf.post(new AbstractVideoView.11(this));
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.lth != null) {
      this.lth.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    if (!(paramb instanceof View))
    {
      ad.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { boQ() });
      return;
    }
    if (this.ltg != null) {
      this.lte.removeView((View)this.ltg);
    }
    this.ltg = paramb;
    this.ltj = false;
    this.lte.addView((View)this.ltg);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.ltg != null) && (this.ltg.getVideoTotalTime() != paramInt)) {
      this.ltg.setVideoTotalTime(paramInt);
    }
  }
  
  protected final void showLoading()
  {
    this.gIf.removeCallbacks(this.ltx);
    this.gIf.postDelayed(this.ltx, 500L);
  }
  
  public final void stop()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { boQ() });
    if (this.lth != null) {
      this.lth.stop();
    }
    this.lto = -1;
    this.ltn = true;
    this.Zn = false;
    this.ltr = 0;
    this.ltq = 0L;
    stopTimer();
    this.gIf.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206470);
        try
        {
          AbstractVideoView.this.tF(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(206470);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(206470);
        }
      }
    }, 10L);
  }
  
  protected final void tF(int paramInt)
  {
    if (this.ltg != null) {
      this.ltg.tt(paramInt);
    }
  }
  
  public final void ta()
  {
    ad.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { boQ(), Boolean.valueOf(this.ltn), Integer.valueOf(this.lto), Boolean.valueOf(this.Zn) });
    this.Zn = true;
    if (this.lth != null) {
      this.lth.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.ltn) {
      if (this.lto < 0) {
        if (play()) {
          this.ltt.az(1000L, 1000L);
        }
      }
    }
    for (;;)
    {
      this.lto = -1;
      this.ltn = true;
      this.ltr = 0;
      this.ltq = 0L;
      if (this.llz != null) {
        this.llz.dq(getSessionId(), getMediaId());
      }
      if (this.bFv > 0)
      {
        ad.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { boQ() });
        this.ltu.az(5000L, 5000L);
      }
      return;
      if (!bhH())
      {
        c(this.lto, this.ltn);
      }
      else
      {
        play();
        continue;
        if (this.lto >= 0) {
          c(this.lto, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */