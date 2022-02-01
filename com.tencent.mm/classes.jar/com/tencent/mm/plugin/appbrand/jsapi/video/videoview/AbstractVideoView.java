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
  protected int diT = 0;
  protected boolean hS = false;
  private boolean isWaiting = false;
  protected Context mContext;
  protected MMHandler mRi = new MMHandler(Looper.getMainLooper());
  protected TextView nhp;
  protected d.c sAf;
  protected boolean sIU = true;
  protected ImageView sIV;
  protected RelativeLayout sIW;
  protected ProgressBar sIX;
  protected TextView sIY;
  protected LinearLayout sIZ;
  protected VideoPlayerSeekBar sJa;
  protected d.b sJb;
  protected a sJc;
  protected boolean sJd;
  protected boolean sJe = true;
  protected int sJf = 0;
  protected boolean sJg = false;
  protected int sJh = 0;
  protected boolean sJi = true;
  protected int sJj = -1;
  protected boolean sJk = false;
  protected long sJl = 0L;
  protected int sJm = 0;
  protected MTimerHandler sJn = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(328896);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(328896);
        return false;
      }
      if (AbstractVideoView.this.sJg)
      {
        if (AbstractVideoView.this.sAf != null) {
          AbstractVideoView.this.sAf.eo(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.sJg = false;
      }
      AbstractVideoView.this.Bt(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      if (AbstractVideoView.cxu())
      {
        boolean bool = AbstractVideoView.this.cxt();
        AppMethodBeat.o(328896);
        return bool;
      }
      AppMethodBeat.o(328896);
      return true;
    }
  }, true);
  protected MTimerHandler sJo = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(328891);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      Log.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bNL(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.sJc != null) && (i <= 50)) {
        AbstractVideoView.this.sJc.H(0.0D);
      }
      AppMethodBeat.o(328891);
      return false;
    }
  }, false);
  protected MTimerHandler sJp = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(328888);
      if (AbstractVideoView.this.diT > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(328888);
          return false;
        }
        AppMethodBeat.o(328888);
        return true;
      }
      AppMethodBeat.o(328888);
      return false;
    }
  }, true);
  private d.d sJq = new d.d()
  {
    public final void blc() {}
    
    public final void tS(int paramAnonymousInt)
    {
      AppMethodBeat.i(328893);
      if (AbstractVideoView.this.b(paramAnonymousInt, true)) {
        AbstractVideoView.this.cxq();
      }
      if (AbstractVideoView.this.sJa != null) {
        AbstractVideoView.this.sJa.setIsPlay(true);
      }
      AppMethodBeat.o(328893);
    }
  };
  private View.OnClickListener sJr = new AbstractVideoView.7(this);
  private Runnable sJs = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(328892);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.sIX != null) && (AbstractVideoView.this.sIX.getVisibility() != 0))
      {
        Log.i("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { AbstractVideoView.this.bNL() });
        AbstractVideoView.this.sIX.setVisibility(0);
      }
      if (AbstractVideoView.this.sAf != null) {
        AbstractVideoView.this.sAf.ep(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(328892);
    }
  };
  
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
    Log.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { bNL() });
    LayoutInflater.from(this.mContext).inflate(com.tencent.luggage.b.d.a.d.app_brand_abstract_video_view, this);
    this.sIV = ((ImageView)findViewById(com.tencent.luggage.b.d.a.c.video_thumb));
    this.sIW = ((RelativeLayout)findViewById(com.tencent.luggage.b.d.a.c.video_root));
    this.nhp = ((TextView)findViewById(com.tencent.luggage.b.d.a.c.video_duration));
    this.sIX = ((ProgressBar)findViewById(com.tencent.luggage.b.d.a.c.video_loading));
    this.sIY = ((TextView)findViewById(com.tencent.luggage.b.d.a.c.video_tips));
    this.sIZ = ((LinearLayout)findViewById(com.tencent.luggage.b.d.a.c.video_footer_root));
    paramContext = (VideoPlayerSeekBar)findViewById(com.tencent.luggage.b.d.a.c.video_player_seek_bar);
    this.sJa = paramContext;
    this.sJb = paramContext;
    if (this.sJa != null)
    {
      this.sJa.setIplaySeekCallback(this.sJq);
      this.sJa.setOnClickListener(this.sJr);
    }
    this.sJc = eR(this.mContext);
    this.sJc.setVideoCallback(this);
    this.sJc.setOnSeekCompleteCallback(this);
    this.sJc.setOnInfoCallback(this);
    this.sJc.setOnSurfaceCallback(this);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    this.sIW.addView((View)this.sJc, 0, paramContext);
  }
  
  protected static boolean cxu()
  {
    return false;
  }
  
  private void jJ(boolean paramBoolean)
  {
    if (this.sJb != null) {
      this.sJb.jJ(paramBoolean);
    }
  }
  
  private void stopTimer()
  {
    this.sJn.stopTimer();
    this.sJo.stopTimer();
  }
  
  protected final void Bt(int paramInt)
  {
    if (this.sJb != null) {
      this.sJb.Bh(paramInt);
    }
  }
  
  public final boolean G(double paramDouble)
  {
    return b(paramDouble, isPlaying());
  }
  
  public final void Qz()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bNL(), Boolean.valueOf(this.sJi), Integer.valueOf(this.sJj), Boolean.valueOf(this.hS) });
    this.hS = true;
    if (this.sJc != null) {
      this.sJc.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.sJi) {
      if (this.sJj < 0) {
        if (bNU()) {
          this.sJo.startTimer(1000L);
        }
      }
    }
    for (;;)
    {
      this.sJj = -1;
      this.sJi = true;
      this.sJm = 0;
      this.sJl = 0L;
      if (this.sAf != null) {
        this.sAf.el(getSessionId(), getMediaId());
      }
      if (this.diT > 0)
      {
        Log.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { bNL() });
        this.sJp.startTimer(5000L);
      }
      return;
      if (!isLive())
      {
        b(this.sJj, this.sJi);
      }
      else
      {
        bNU();
        continue;
        if (this.sJj >= 0) {
          b(this.sJj, false);
        }
      }
    }
  }
  
  public boolean b(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = cxs();
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
    if (this.sJc != null) {
      if (!Util.isNullOrNil(this.sJc.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bNL(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (!bool2) {
        break;
      }
      if (this.sJc == null) {
        break label197;
      }
      showLoading();
      Bt(i);
      this.sJc.c(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.sJj = i;
    this.sJi = paramBoolean;
    label197:
    return false;
  }
  
  protected final String bNL()
  {
    return hashCode();
  }
  
  public final boolean bNU()
  {
    if (!this.sIU) {
      Log.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { bNL(), Util.getStack() });
    }
    while (this.sJc == null) {
      return false;
    }
    boolean bool = this.sJc.start();
    Log.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bNL(), Boolean.valueOf(bool), Boolean.valueOf(this.sJg) });
    jJ(bool);
    if (bool)
    {
      this.sJg = false;
      cxq();
      if (this.sAf != null) {
        this.sAf.eo(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public final void bNV()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { bNL() });
    cxq();
  }
  
  protected final void cxq()
  {
    Log.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { bNL(), Boolean.FALSE });
    this.sJn.startTimer(500L);
  }
  
  public final boolean cxr()
  {
    if (this.sJc == null) {
      return false;
    }
    if (isPlaying()) {
      pause();
    }
    for (;;)
    {
      return true;
      if (Util.isNullOrNil(this.sJc.getVideoPath())) {
        start();
      } else {
        bNU();
      }
    }
  }
  
  protected final boolean cxs()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.sJc != null)
    {
      bool1 = bool2;
      if (!Util.isNullOrNil(this.sJc.getVideoPath()))
      {
        bool1 = bool2;
        if (this.hS) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected final boolean cxt()
  {
    long l = this.sJc.getLastSurfaceUpdateTime();
    int i = this.sJc.getCurrentPosition();
    Log.d("MicroMsg.Video.AbstractVideoView", "%s check surface is update surface[%d %d] playtime[%d %d]", new Object[] { bNL(), Long.valueOf(this.sJl), Long.valueOf(l), Integer.valueOf(this.sJm), Integer.valueOf(i) });
    if ((l > 0L) && (l == this.sJl) && (i != this.sJm))
    {
      Log.w("MicroMsg.Video.AbstractVideoView", "%s check surface is update error", new Object[] { bNL() });
      b(this.sJm / 1000, true);
      return false;
    }
    this.sJl = l;
    this.sJm = i;
    return true;
  }
  
  protected a eR(Context paramContext)
  {
    return null;
  }
  
  public final void fG(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sAf != null) {
      this.sAf.e(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.sJc != null) {
      return this.sJc.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.sJc != null) {
      return Math.round(this.sJc.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.sJh;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.sJc != null) {
      return Math.round(this.sJc.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.mRi.removeCallbacks(this.sJs);
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(328898);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(328898);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.sAf != null) {
          AbstractVideoView.this.sAf.eq(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.sIX != null) && (AbstractVideoView.this.sIX.getVisibility() != 8))
        {
          Log.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { AbstractVideoView.this.bNL() });
          AbstractVideoView.this.sIX.setVisibility(8);
        }
        AppMethodBeat.o(328898);
      }
    });
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    if (this.sJc != null) {
      bool = this.sJc.isPlaying();
    }
    return bool;
  }
  
  public void onCompletion()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { bNL(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    Bt(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.sAf != null) {
      this.sAf.em(getSessionId(), getMediaId());
    }
    this.sJm = 0;
    this.sJl = 0L;
  }
  
  public final void onError(final int paramInt1, int paramInt2)
  {
    Log.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.diT) });
    this.diT += 1;
    if (this.diT > 0)
    {
      d.c localc;
      String str2;
      String str3;
      String str1;
      if (this.sAf != null)
      {
        localc = this.sAf;
        str2 = getSessionId();
        str3 = getMediaId();
        if (paramInt1 != -1010) {
          break label119;
        }
        str1 = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      }
      for (;;)
      {
        localc.d(str2, str3, str1, paramInt1, paramInt2);
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
    if (this.sJj == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.sJj)
    {
      Log.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(this.sJj), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.mRi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(328890);
          AbstractVideoView.this.sJk = true;
          AbstractVideoView.this.Bt(paramInt1);
          AbstractVideoView.this.b(paramInt1, true);
          AbstractVideoView.this.sJk = false;
          AppMethodBeat.o(328890);
        }
      }, 200L);
      return;
    }
  }
  
  public final void onSeekComplete(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { bNL(), Boolean.valueOf(paramBoolean) });
    if (this.sJc != null) {
      this.sJc.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    jJ(paramBoolean);
    Bt(getCurrPosSec());
    if (paramBoolean)
    {
      cxq();
      this.sJg = false;
      if (this.sAf != null) {
        this.sAf.eo(getSessionId(), getMediaId());
      }
    }
  }
  
  public final void onTextureUpdate()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { bNL() });
    hideLoading();
  }
  
  public final void onUIDestroy()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { bNL() });
    stop();
    this.mRi.removeCallbacksAndMessages(null);
    stopTimer();
    this.sJp.stopTimer();
  }
  
  public void onUIPause()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { bNL(), Util.getStack() });
    this.sJf = getCurrPosSec();
    this.sJg = isPlaying();
    this.sJm = 0;
    this.sJl = 0L;
    pause();
    stopTimer();
    this.sIU = false;
  }
  
  public void onUIResume()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { bNL(), Util.getStack() });
    this.sIU = true;
  }
  
  public final boolean pause()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { bNL() });
    if (this.sJc != null)
    {
      jJ(false);
      this.sJc.pause();
      stopTimer();
      if (this.sAf != null) {
        this.sAf.en(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { bNL() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.sIV != null)) {
      this.sIV.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(d.c paramc)
  {
    this.sAf = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { bNL(), Boolean.valueOf(paramBoolean) });
    this.sJd = paramBoolean;
    if (this.sJd)
    {
      this.mRi.post(new AbstractVideoView.10(this));
      return;
    }
    this.mRi.post(new AbstractVideoView.11(this));
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.sJc != null) {
      this.sJc.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(d.b paramb)
  {
    if (!(paramb instanceof View))
    {
      Log.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { bNL() });
      return;
    }
    if (this.sJb != null) {
      this.sIZ.removeView((View)this.sJb);
    }
    this.sJb = paramb;
    this.sJe = false;
    this.sIZ.addView((View)this.sJb);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.sJb != null) && (this.sJb.getVideoTotalTime() != paramInt)) {
      this.sJb.setVideoTotalTime(paramInt);
    }
  }
  
  protected final void showLoading()
  {
    this.mRi.removeCallbacks(this.sJs);
    this.mRi.postDelayed(this.sJs, 500L);
  }
  
  public final void stop()
  {
    Log.i("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { bNL() });
    if (this.sJc != null) {
      this.sJc.stop();
    }
    this.sJj = -1;
    this.sJi = true;
    this.hS = false;
    this.sJm = 0;
    this.sJl = 0L;
    stopTimer();
    this.mRi.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(328895);
        try
        {
          AbstractVideoView.this.Bt(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          return;
        }
        finally
        {
          AppMethodBeat.o(328895);
        }
      }
    }, 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */