package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.b.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ag.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.bb;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoLiteControBar
  extends VideoPlayerSeekBar
  implements d.a, d.b
{
  View lBX;
  private MTimerHandler sAc;
  private ImageView sHD;
  private d.i sHK;
  private MTimerHandler sHL;
  private boolean sHM;
  private boolean sHN;
  private boolean sHO;
  private boolean sHP;
  private boolean sHQ;
  private boolean sHR;
  private boolean sHS;
  private boolean sHT;
  private com.tencent.mm.plugin.appbrand.jsapi.video.d.e sHU;
  private ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.jsapi.video.d.f> sHV;
  ImageView vYa;
  View vYb;
  private a vYc;
  
  public VideoLiteControBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(302102);
    this.sHT = true;
    this.sHV = new ConcurrentLinkedQueue();
    AppMethodBeat.o(302102);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(302108);
    this.sHT = true;
    this.sHV = new ConcurrentLinkedQueue();
    AppMethodBeat.o(302108);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(302113);
    this.sHT = true;
    this.sHV = new ConcurrentLinkedQueue();
    AppMethodBeat.o(302113);
  }
  
  private void cxd()
  {
    AppMethodBeat.i(302120);
    if ((this.sHR) && (!this.sHS))
    {
      this.sHp.setVisibility(0);
      AppMethodBeat.o(302120);
      return;
    }
    this.sHp.setVisibility(8);
    AppMethodBeat.o(302120);
  }
  
  private void cxg()
  {
    AppMethodBeat.i(302127);
    cxi();
    cxh();
    AppMethodBeat.o(302127);
  }
  
  private void cxh()
  {
    AppMethodBeat.i(302135);
    if (this.sHM) {}
    for (int i = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_btn_gap);; i = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_btn_gap))
    {
      if (this.sHp != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sHp.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sHp.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(302135);
      return;
    }
  }
  
  private void cxi()
  {
    AppMethodBeat.i(302142);
    if (this.sHM) {}
    for (float f = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_time_textsize);; f = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_time_textsize))
    {
      this.sHq.setTextSize(0, f);
      this.sHr.setTextSize(0, f);
      AppMethodBeat.o(302142);
      return;
    }
  }
  
  private boolean cxk()
  {
    AppMethodBeat.i(302148);
    if (this.sHK == null)
    {
      Log.i("MicroMsg.VideoLiteControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(302148);
      return false;
    }
    int k = this.sHK.cvf();
    int j = this.sHK.cvg();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(302148);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(302148);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHD.getLayoutParams();
      localLayoutParams.width = i;
      this.sHD.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(302148);
      return true;
      d = k;
    }
  }
  
  private void cxl()
  {
    int j = 0;
    AppMethodBeat.i(302154);
    boolean bool;
    TextView localTextView;
    if (this.sHQ)
    {
      bool = this.sHP;
      localTextView = this.sHq;
      if (!bool) {
        break label66;
      }
      i = 0;
      label31:
      localTextView.setVisibility(i);
      localTextView = this.sHr;
      if (!bool) {
        break label72;
      }
    }
    label66:
    label72:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(302154);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
    }
  }
  
  private void fE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(302158);
    if (this.sHU != null) {
      this.sHU.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(302158);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.d.f paramf)
  {
    AppMethodBeat.i(302373);
    this.sHV.add(paramf);
    AppMethodBeat.o(302373);
  }
  
  public final void anJ()
  {
    AppMethodBeat.i(302307);
    this.sHM = true;
    cxg();
    AppMethodBeat.o(302307);
  }
  
  public final void csz()
  {
    AppMethodBeat.i(302313);
    this.sHM = false;
    cxg();
    AppMethodBeat.o(302313);
  }
  
  public final void cuX() {}
  
  public final boolean cvA()
  {
    return false;
  }
  
  public final boolean cvq()
  {
    return this.sHN;
  }
  
  public final void cvr()
  {
    AppMethodBeat.i(302301);
    if (cvt())
    {
      setVisibility(8);
      AppMethodBeat.o(302301);
      return;
    }
    cvs();
    AppMethodBeat.o(302301);
  }
  
  public final void cvs()
  {
    AppMethodBeat.i(302283);
    setVisibility(0);
    if (!this.sHT)
    {
      AppMethodBeat.o(302283);
      return;
    }
    if (this.sHL == null) {
      this.sHL = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(302106);
          VideoLiteControBar.this.setVisibility(8);
          VideoLiteControBar.a(VideoLiteControBar.this).stopTimer();
          AppMethodBeat.o(302106);
          return false;
        }
      }, false);
    }
    this.sHL.stopTimer();
    this.sHL.startTimer(7000L);
    AppMethodBeat.o(302283);
  }
  
  public final boolean cvt()
  {
    AppMethodBeat.i(302298);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(302298);
      return true;
    }
    AppMethodBeat.o(302298);
    return false;
  }
  
  public final boolean cvu()
  {
    return this.sHM;
  }
  
  public final boolean cvv()
  {
    return this.sHT;
  }
  
  public final void cvw()
  {
    AppMethodBeat.i(302326);
    if (this.sAc == null) {
      this.sAc = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(302093);
          if (!VideoLiteControBar.b(VideoLiteControBar.this))
          {
            AppMethodBeat.o(302093);
            return false;
          }
          AppMethodBeat.o(302093);
          return true;
        }
      }, true);
    }
    cxk();
    this.sAc.stopTimer();
    this.sAc.startTimer(500L);
    AppMethodBeat.o(302326);
  }
  
  public final void cvx()
  {
    AppMethodBeat.i(302333);
    if (this.sAc != null) {
      this.sAc.stopTimer();
    }
    AppMethodBeat.o(302333);
  }
  
  public final void cvy()
  {
    AppMethodBeat.i(302288);
    if (this.sHL != null)
    {
      this.sHL.stopTimer();
      this.sHL.startTimer(7000L);
    }
    AppMethodBeat.o(302288);
  }
  
  public final void cvz() {}
  
  public final void cxb()
  {
    AppMethodBeat.i(302340);
    if (this.cqW == 0)
    {
      AppMethodBeat.o(302340);
      return;
    }
    if (this.seH)
    {
      AppMethodBeat.o(302340);
      return;
    }
    if (this.sHo == null)
    {
      AppMethodBeat.o(302340);
      return;
    }
    this.sHq.setText(Bf(this.mPosition / 60) + ":" + Bf(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(302340);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHo.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = fF(this.mPosition, i);
    this.sHo.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.sHm.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.cqW * i));
    this.sHm.setLayoutParams(localLayoutParams);
    requestLayout();
    fE(this.mPosition, this.cqW);
    AppMethodBeat.o(302340);
  }
  
  public int getLayoutId()
  {
    return com.tencent.mm.plugin.brandservice.d.f.video_lite_control_bar;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(302291);
    setVisibility(8);
    AppMethodBeat.o(302291);
  }
  
  public final void init()
  {
    AppMethodBeat.i(302188);
    super.init();
    this.sHD = ((ImageView)this.contentView.findViewById(com.tencent.mm.plugin.brandservice.d.e.player_progress_bar_middle));
    this.vYa = ((ImageView)findViewById(com.tencent.mm.plugin.brandservice.d.e.video_close_btn));
    this.lBX = findViewById(com.tencent.mm.plugin.brandservice.d.e.root);
    this.vYb = findViewById(com.tencent.mm.plugin.brandservice.d.e.control_bar_root);
    AppMethodBeat.o(302188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(302176);
    if (this.sAc != null) {
      this.sAc.stopTimer();
    }
    if (this.sHL != null) {
      this.sHL.stopTimer();
    }
    AppMethodBeat.o(302176);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(302336);
    super.seek(paramInt);
    fE(this.mPosition, this.cqW);
    AppMethodBeat.o(302336);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.sHT = paramBoolean;
  }
  
  public void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(302197);
    this.vYa.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(302197);
  }
  
  public void setDanmakuBtnOnClickListener(d.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.sHN = paramBoolean;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(302253);
    this.hJg = paramBoolean;
    if (this.hJg) {
      this.sHp.setImageDrawable(bb.m(getContext(), a.d.icons_filled_pause, -1));
    }
    for (;;)
    {
      if (this.vYc != null) {
        this.vYc.onPlayStatusChange(paramBoolean);
      }
      AppMethodBeat.o(302253);
      return;
      this.sHp.setImageDrawable(bb.m(getContext(), a.d.icons_filled_play, -1));
    }
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setMuteBtnState(boolean paramBoolean) {}
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(302216);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(302216);
  }
  
  public void setOnPlayStatusChangeListener(a parama)
  {
    this.vYc = parama;
  }
  
  public void setOnUpdateProgressLenListener(com.tencent.mm.plugin.appbrand.jsapi.video.d.e parame)
  {
    this.sHU = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(302242);
    this.sHS = paramBoolean;
    cxd();
    AppMethodBeat.o(302242);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(302235);
    this.sHQ = paramBoolean;
    cxl();
    AppMethodBeat.o(302235);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.sHO = paramBoolean;
  }
  
  public void setShowMuteBtn(boolean paramBoolean) {}
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(302349);
    this.sHR = paramBoolean;
    cxd();
    AppMethodBeat.o(302349);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(302354);
    this.sHP = paramBoolean;
    cxl();
    AppMethodBeat.o(302354);
  }
  
  public void setStatePorter(d.i parami)
  {
    this.sHK = parami;
  }
  
  public void setTitle(String paramString) {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(302364);
    super.setVisibility(paramInt);
    Iterator localIterator;
    com.tencent.mm.plugin.appbrand.jsapi.video.d.f localf;
    if (paramInt == 0)
    {
      localIterator = this.sHV.iterator();
      while (localIterator.hasNext())
      {
        localf = (com.tencent.mm.plugin.appbrand.jsapi.video.d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(302364);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.sHV.iterator();
      while (localIterator.hasNext())
      {
        localf = (com.tencent.mm.plugin.appbrand.jsapi.video.d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(302364);
  }
  
  public static abstract interface a
  {
    public abstract void onPlayStatusChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar
 * JD-Core Version:    0.7.0.1
 */