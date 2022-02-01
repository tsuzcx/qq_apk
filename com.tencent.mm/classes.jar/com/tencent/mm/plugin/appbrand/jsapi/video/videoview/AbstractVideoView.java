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
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class AbstractVideoView
  extends RelativeLayout
  implements e, a.a, a.b, a.c, a.d, a.e
{
  protected boolean Zn = false;
  protected int bFv = 0;
  protected aq gKO = new aq(Looper.getMainLooper());
  protected TextView gWL;
  private boolean isWaiting = false;
  protected e.c lpU;
  protected RelativeLayout lxA;
  protected ProgressBar lxB;
  protected TextView lxC;
  protected LinearLayout lxD;
  protected VideoPlayerSeekBar lxE;
  protected e.b lxF;
  protected a lxG;
  protected boolean lxH;
  protected boolean lxI = true;
  protected int lxJ = 0;
  protected boolean lxK = false;
  protected int lxL = 0;
  protected boolean lxM = true;
  protected int lxN = -1;
  protected boolean lxO = false;
  protected long lxP = 0L;
  protected int lxQ = 0;
  protected aw lxR = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(211499);
      if (!AbstractVideoView.this.isPlaying())
      {
        AppMethodBeat.o(211499);
        return false;
      }
      if (AbstractVideoView.this.lxK)
      {
        if (AbstractVideoView.this.lpU != null) {
          AbstractVideoView.this.lpU.dv(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        AbstractVideoView.this.lxK = false;
      }
      AbstractVideoView.this.tK(AbstractVideoView.this.getCurrPosSec());
      AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
      AppMethodBeat.o(211499);
      return true;
    }
  }, true);
  protected aw lxS = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(211502);
      boolean bool = AbstractVideoView.this.isPlaying();
      int i = AbstractVideoView.this.getCurrPosMs();
      ae.i("MicroMsg.Video.AbstractVideoView", "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { AbstractVideoView.this.bpA(), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((AbstractVideoView.this.lxG != null) && (i <= 50)) {
        AbstractVideoView.this.lxG.p(0.0D);
      }
      AppMethodBeat.o(211502);
      return false;
    }
  }, false);
  protected aw lxT = new aw(new aw.a()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(211503);
      if (AbstractVideoView.this.bFv > 0)
      {
        if (AbstractVideoView.this.isPlaying())
        {
          AbstractVideoView.a(AbstractVideoView.this);
          AppMethodBeat.o(211503);
          return false;
        }
        AppMethodBeat.o(211503);
        return true;
      }
      AppMethodBeat.o(211503);
      return false;
    }
  }, true);
  private e.d lxU = new e.d()
  {
    public final void aqS() {}
    
    public final void nP(int paramAnonymousInt)
    {
      AppMethodBeat.i(211504);
      if (AbstractVideoView.this.c(paramAnonymousInt, true)) {
        AbstractVideoView.this.bpz();
      }
      if (AbstractVideoView.this.lxE != null) {
        AbstractVideoView.this.lxE.setIsPlay(true);
      }
      AppMethodBeat.o(211504);
    }
  };
  private View.OnClickListener lxV = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(211505);
      b localb = new b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ae.i("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", new Object[] { AbstractVideoView.this.bpA() });
      AbstractVideoView.this.bpB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/videoview/AbstractVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211505);
    }
  };
  private Runnable lxW = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(211506);
      AbstractVideoView.b(AbstractVideoView.this, true);
      if ((AbstractVideoView.this.lxB != null) && (AbstractVideoView.this.lxB.getVisibility() != 0))
      {
        ae.i("MicroMsg.Video.AbstractVideoView", "%s show loading", new Object[] { AbstractVideoView.this.bpA() });
        AbstractVideoView.this.lxB.setVisibility(0);
      }
      if (AbstractVideoView.this.lpU != null) {
        AbstractVideoView.this.lpU.dw(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
      }
      AppMethodBeat.o(211506);
    }
  };
  protected boolean lxy = true;
  protected ImageView lxz;
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
    ae.i("MicroMsg.Video.AbstractVideoView", "%s init abstract video view", new Object[] { bpA() });
    LayoutInflater.from(this.mContext).inflate(2131496135, this);
    this.lxz = ((ImageView)findViewById(2131306398));
    this.lxA = ((RelativeLayout)findViewById(2131306392));
    this.gWL = ((TextView)findViewById(2131306332));
    this.lxB = ((ProgressBar)findViewById(2131306352));
    this.lxC = ((TextView)findViewById(2131306403));
    this.lxD = ((LinearLayout)findViewById(2131306342));
    paramContext = (VideoPlayerSeekBar)findViewById(2131306375);
    this.lxE = paramContext;
    this.lxF = paramContext;
    if (this.lxE != null)
    {
      this.lxE.setIplaySeekCallback(this.lxU);
      this.lxE.setOnClickListener(this.lxV);
    }
    this.lxG = dE(this.mContext);
    this.lxG.setVideoCallback(this);
    this.lxG.setOnSeekCompleteCallback(this);
    this.lxG.setOnInfoCallback(this);
    this.lxG.setOnSurfaceCallback(this);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(13);
    this.lxA.addView((View)this.lxG, 0, paramContext);
  }
  
  private void gS(boolean paramBoolean)
  {
    if (this.lxF != null) {
      this.lxF.gS(paramBoolean);
    }
  }
  
  private void stopTimer()
  {
    this.lxR.stopTimer();
    this.lxS.stopTimer();
  }
  
  public final void aMV()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s on surface available", new Object[] { bpA() });
    bpz();
  }
  
  protected final String bpA()
  {
    return hashCode();
  }
  
  public final boolean bpB()
  {
    if (this.lxG == null) {
      return false;
    }
    if (isPlaying()) {
      pause();
    }
    for (;;)
    {
      return true;
      if (bu.isNullOrNil(this.lxG.getVideoPath())) {
        start();
      } else {
        play();
      }
    }
  }
  
  protected final boolean bpC()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.lxG != null)
    {
      bool1 = bool2;
      if (!bu.isNullOrNil(this.lxG.getVideoPath()))
      {
        bool1 = bool2;
        if (this.Zn) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void bpD()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s onTextureUpdate ", new Object[] { bpA() });
    hideLoading();
  }
  
  protected final void bpz()
  {
    ae.d("MicroMsg.Video.AbstractVideoView", "%s start timer rightNow[%b]", new Object[] { bpA(), Boolean.FALSE });
    this.lxR.ay(500L, 500L);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    boolean bool2 = bpC();
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
    if (this.lxG != null) {
      if (!bu.isNullOrNil(this.lxG.getVideoPath())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      ae.m("MicroMsg.Video.AbstractVideoView", "%s seek to [%d %s] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[] { bpA(), Integer.valueOf(i), Double.valueOf(paramDouble), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if (!bool2) {
        break;
      }
      if (this.lxG == null) {
        break label202;
      }
      showLoading();
      tK(i);
      this.lxG.d(i * 1000, paramBoolean);
      return paramBoolean;
      bool1 = false;
      continue;
      bool1 = false;
    }
    this.lxN = i;
    if (bool1) {
      this.lxM = true;
    }
    for (;;)
    {
      label202:
      return false;
      this.lxM = paramBoolean;
      start();
    }
  }
  
  protected a dE(Context paramContext)
  {
    return null;
  }
  
  public final void eX(boolean paramBoolean)
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s on seek complete startPlay[%b]", new Object[] { bpA(), Boolean.valueOf(paramBoolean) });
    if (this.lxG != null) {
      this.lxG.setOneTimeVideoTextureUpdateCallback(this);
    }
    hideLoading();
    gS(paramBoolean);
    tK(getCurrPosSec());
    if (paramBoolean)
    {
      bpz();
      this.lxK = false;
      if (this.lpU != null) {
        this.lpU.dv(getSessionId(), getMediaId());
      }
    }
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s on get video size [%d, %d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.lpU != null) {
      this.lpU.d(getSessionId(), getMediaId(), paramInt1, paramInt2);
    }
  }
  
  public int getCacheTimeSec()
  {
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.lxG != null) {
      return this.lxG.getCurrentPosition();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.lxG != null) {
      return Math.round(this.lxG.getCurrentPosition() * 1.0F / 1000.0F);
    }
    return 0;
  }
  
  protected String getMediaId()
  {
    return "";
  }
  
  public int getPlayerType()
  {
    return this.lxL;
  }
  
  public String getSessionId()
  {
    return "";
  }
  
  public int getVideoDurationSec()
  {
    if (this.lxG != null) {
      return Math.round(this.lxG.getDuration() * 1.0F / 1000.0F);
    }
    return -1;
  }
  
  public int getVideoSource()
  {
    return 0;
  }
  
  protected void hideLoading()
  {
    this.gKO.removeCallbacks(this.lxW);
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211507);
        if (!AbstractVideoView.b(AbstractVideoView.this))
        {
          AppMethodBeat.o(211507);
          return;
        }
        AbstractVideoView.b(AbstractVideoView.this, false);
        if (AbstractVideoView.this.lpU != null) {
          AbstractVideoView.this.lpU.dx(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
        }
        if ((AbstractVideoView.this.lxB != null) && (AbstractVideoView.this.lxB.getVisibility() != 8))
        {
          ae.i("MicroMsg.Video.AbstractVideoView", "%s hide loading", new Object[] { AbstractVideoView.this.bpA() });
          AbstractVideoView.this.lxB.setVisibility(8);
        }
        AppMethodBeat.o(211507);
      }
    });
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    if (this.lxG != null) {
      bool = this.lxG.isPlaying();
    }
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    return c(paramDouble, isPlaying());
  }
  
  public void onCompletion()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s onCompletion, curMs %d, duration %d", new Object[] { bpA(), Integer.valueOf(getCurrPosSec()), Integer.valueOf(getVideoDurationSec()) });
    tK(getVideoDurationSec());
    hideLoading();
    stopTimer();
    if (this.lpU != null) {
      this.lpU.dt(getSessionId(), getMediaId());
    }
    this.lxQ = 0;
    this.lxP = 0L;
  }
  
  public final void onError(final int paramInt1, int paramInt2)
  {
    ae.w("MicroMsg.Video.AbstractVideoView", "%s onError info [%d %d] errorCount[%d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.bFv) });
    this.bFv += 1;
    if (this.bFv > 5)
    {
      e.c localc;
      String str2;
      String str3;
      String str1;
      if (this.lpU != null)
      {
        localc = this.lpU;
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
          if (!az.isConnected(this.mContext)) {
            str1 = "MEDIA_ERR_NETWORK";
          } else {
            str1 = "MEDIA_ERR_DECODE";
          }
        }
        else if (!az.isConnected(this.mContext)) {
          str1 = "MEDIA_ERR_NETWORK";
        } else {
          str1 = "MEDIA_ERR_DECODE";
        }
      }
    }
    paramInt2 = getCurrPosSec();
    if (this.lxN == -1) {}
    for (paramInt1 = paramInt2;; paramInt1 = this.lxN)
    {
      ae.i("MicroMsg.Video.AbstractVideoView", "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(this.lxN), Integer.valueOf(paramInt2) });
      stop();
      showLoading();
      this.gKO.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211501);
          AbstractVideoView.this.lxO = true;
          AbstractVideoView.this.tK(paramInt1);
          AbstractVideoView.this.c(paramInt1, true);
          AbstractVideoView.this.lxO = false;
          AppMethodBeat.o(211501);
        }
      }, 200L);
      return;
    }
  }
  
  public final void onUIDestroy()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s onUIDestroy", new Object[] { bpA() });
    stop();
    this.gKO.removeCallbacksAndMessages(null);
    stopTimer();
    this.lxT.stopTimer();
  }
  
  public void onUIPause()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s onUIPause %s", new Object[] { bpA(), bu.fpN() });
    this.lxJ = getCurrPosSec();
    this.lxK = isPlaying();
    this.lxQ = 0;
    this.lxP = 0L;
    pause();
    stopTimer();
    this.lxy = false;
  }
  
  public void onUIResume()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s onUIResume %s", new Object[] { bpA(), bu.fpN() });
    this.lxy = true;
  }
  
  public final boolean pause()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s pause", new Object[] { bpA() });
    if (this.lxG != null)
    {
      gS(false);
      this.lxG.pause();
      stopTimer();
      if (this.lpU != null) {
        this.lpU.du(getSessionId(), getMediaId());
      }
      return true;
    }
    return false;
  }
  
  public final boolean play()
  {
    if (!this.lxy) {
      ae.w("MicroMsg.Video.AbstractVideoView", "%s ui on pause now, why u call me to play? [%s]", new Object[] { bpA(), bu.fpN() });
    }
    while (this.lxG == null) {
      return false;
    }
    boolean bool = this.lxG.start();
    ae.i("MicroMsg.Video.AbstractVideoView", "%s video play [%b] isPlayOnUiPause[%b]", new Object[] { bpA(), Boolean.valueOf(bool), Boolean.valueOf(this.lxK) });
    gS(bool);
    if (bool)
    {
      this.lxK = false;
      bpz();
      if (this.lpU != null) {
        this.lpU.dv(getSessionId(), getMediaId());
      }
    }
    return bool;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s set cover", new Object[] { bpA() });
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (this.lxz != null)) {
      this.lxz.setImageBitmap(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt) {}
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.lpU = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s is show seek bar[%b]", new Object[] { bpA(), Boolean.valueOf(paramBoolean) });
    this.lxH = paramBoolean;
    if (this.lxH)
    {
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211508);
          if ((AbstractVideoView.this.lxD != null) && (AbstractVideoView.this.lxD.getVisibility() != 0)) {
            AbstractVideoView.this.lxD.setVisibility(0);
          }
          AppMethodBeat.o(211508);
        }
      });
      return;
    }
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211509);
        if ((AbstractVideoView.this.lxD != null) && (AbstractVideoView.this.lxD.getVisibility() != 8)) {
          AbstractVideoView.this.lxD.setVisibility(8);
        }
        AppMethodBeat.o(211509);
      }
    });
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.lxG != null) {
      this.lxG.setMute(paramBoolean);
    }
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    if (!(paramb instanceof View))
    {
      ae.w("MicroMsg.Video.AbstractVideoView", "%s set video footer view but is not view", new Object[] { bpA() });
      return;
    }
    if (this.lxF != null) {
      this.lxD.removeView((View)this.lxF);
    }
    this.lxF = paramb;
    this.lxI = false;
    this.lxD.addView((View)this.lxF);
  }
  
  protected void setVideoTotalTime(int paramInt)
  {
    if ((this.lxF != null) && (this.lxF.getVideoTotalTime() != paramInt)) {
      this.lxF.setVideoTotalTime(paramInt);
    }
  }
  
  protected final void showLoading()
  {
    this.gKO.removeCallbacks(this.lxW);
    this.gKO.postDelayed(this.lxW, 500L);
  }
  
  public final void stop()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s stop", new Object[] { bpA() });
    if (this.lxG != null) {
      this.lxG.stop();
    }
    this.lxN = -1;
    this.lxM = true;
    this.Zn = false;
    this.lxQ = 0;
    this.lxP = 0L;
    stopTimer();
    this.gKO.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211500);
        try
        {
          AbstractVideoView.this.tK(0);
          AbstractVideoView.a(AbstractVideoView.this, AbstractVideoView.this.isPlaying());
          AppMethodBeat.o(211500);
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(211500);
        }
      }
    }, 10L);
  }
  
  protected final void tK(int paramInt)
  {
    if (this.lxF != null) {
      this.lxF.tx(paramInt);
    }
  }
  
  public final void ta()
  {
    ae.i("MicroMsg.Video.AbstractVideoView", "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[] { bpA(), Boolean.valueOf(this.lxM), Integer.valueOf(this.lxN), Boolean.valueOf(this.Zn) });
    this.Zn = true;
    if (this.lxG != null) {
      this.lxG.setOneTimeVideoTextureUpdateCallback(this);
    }
    setVideoTotalTime(getVideoDurationSec());
    if (this.lxM) {
      if (this.lxN < 0) {
        if (play()) {
          this.lxS.ay(1000L, 1000L);
        }
      }
    }
    for (;;)
    {
      this.lxN = -1;
      this.lxM = true;
      this.lxQ = 0;
      this.lxP = 0L;
      if (this.lpU != null) {
        this.lpU.ds(getSessionId(), getMediaId());
      }
      if (this.bFv > 0)
      {
        ae.d("MicroMsg.Video.AbstractVideoView", "%s start error check timer", new Object[] { bpA() });
        this.lxT.ay(5000L, 5000L);
      }
      return;
      if (!bip())
      {
        c(this.lxN, this.lxM);
      }
      else
      {
        play();
        continue;
        if (this.lxN >= 0) {
          c(this.lxN, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
 * JD-Core Version:    0.7.0.1
 */