package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.b.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.af.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.au;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoLiteControBar
  extends VideoPlayerSeekBar
  implements d.a, d.b
{
  private View jac;
  private boolean pCA;
  private boolean pCB;
  private boolean pCC;
  private boolean pCD;
  private boolean pCE;
  private boolean pCF;
  private boolean pCG;
  private boolean pCH;
  private com.tencent.mm.plugin.appbrand.jsapi.video.d.e pCI;
  private ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.jsapi.video.d.f> pCJ;
  private ImageView pCr;
  private d.i pCy;
  private MTimerHandler pCz;
  private MTimerHandler puW;
  private ImageView sSJ;
  private View sSK;
  private VideoLiteControBar.a sSL;
  
  public VideoLiteControBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(266645);
    this.pCH = true;
    this.pCJ = new ConcurrentLinkedQueue();
    AppMethodBeat.o(266645);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(266647);
    this.pCH = true;
    this.pCJ = new ConcurrentLinkedQueue();
    AppMethodBeat.o(266647);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(266648);
    this.pCH = true;
    this.pCJ = new ConcurrentLinkedQueue();
    AppMethodBeat.o(266648);
  }
  
  private void bWQ()
  {
    AppMethodBeat.i(266666);
    if ((this.pCF) && (!this.pCG))
    {
      this.pCc.setVisibility(0);
      AppMethodBeat.o(266666);
      return;
    }
    this.pCc.setVisibility(8);
    AppMethodBeat.o(266666);
  }
  
  private void bWT()
  {
    AppMethodBeat.i(266685);
    bWV();
    bWU();
    AppMethodBeat.o(266685);
  }
  
  private void bWU()
  {
    AppMethodBeat.i(266687);
    if (this.pCA) {}
    for (int i = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_btn_gap);; i = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_btn_gap))
    {
      if (this.pCc != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCc.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCc.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(266687);
      return;
    }
  }
  
  private void bWV()
  {
    AppMethodBeat.i(266688);
    if (this.pCA) {}
    for (float f = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_time_textsize);; f = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_time_textsize))
    {
      this.pCd.setTextSize(0, f);
      this.pCe.setTextSize(0, f);
      AppMethodBeat.o(266688);
      return;
    }
  }
  
  private boolean bWX()
  {
    AppMethodBeat.i(266693);
    if (this.pCy == null)
    {
      Log.i("MicroMsg.VideoLiteControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(266693);
      return false;
    }
    int k = this.pCy.bUQ();
    int j = this.pCy.bUR();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(266693);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(266693);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCr.getLayoutParams();
      localLayoutParams.width = i;
      this.pCr.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(266693);
      return true;
      d = k;
    }
  }
  
  private void bWY()
  {
    int j = 0;
    AppMethodBeat.i(266701);
    boolean bool;
    TextView localTextView;
    if (this.pCE)
    {
      bool = this.pCD;
      localTextView = this.pCd;
      if (!bool) {
        break label66;
      }
      i = 0;
      label31:
      localTextView.setVisibility(i);
      localTextView = this.pCe;
      if (!bool) {
        break label72;
      }
    }
    label66:
    label72:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(266701);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
    }
  }
  
  private void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266702);
    if (this.pCI != null) {
      this.pCI.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(266702);
  }
  
  public final void Nq()
  {
    AppMethodBeat.i(266680);
    this.pCA = true;
    bWT();
    AppMethodBeat.o(266680);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.d.f paramf)
  {
    AppMethodBeat.i(266704);
    this.pCJ.add(paramf);
    AppMethodBeat.o(266704);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(266682);
    this.pCA = false;
    bWT();
    AppMethodBeat.o(266682);
  }
  
  public final void bUI() {}
  
  public final boolean bVa()
  {
    return this.pCB;
  }
  
  public final void bVb()
  {
    AppMethodBeat.i(266678);
    if (bVd())
    {
      setVisibility(8);
      AppMethodBeat.o(266678);
      return;
    }
    bVc();
    AppMethodBeat.o(266678);
  }
  
  public final void bVc()
  {
    AppMethodBeat.i(266671);
    setVisibility(0);
    if (!this.pCH)
    {
      AppMethodBeat.o(266671);
      return;
    }
    if (this.pCz == null) {
      this.pCz = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(265493);
          VideoLiteControBar.this.setVisibility(8);
          VideoLiteControBar.a(VideoLiteControBar.this).stopTimer();
          AppMethodBeat.o(265493);
          return false;
        }
      }, false);
    }
    this.pCz.stopTimer();
    this.pCz.startTimer(7000L);
    AppMethodBeat.o(266671);
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(266677);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(266677);
      return true;
    }
    AppMethodBeat.o(266677);
    return false;
  }
  
  public final boolean bVe()
  {
    return this.pCA;
  }
  
  public final boolean bVf()
  {
    return this.pCH;
  }
  
  public final void bVg()
  {
    AppMethodBeat.i(266689);
    if (this.puW == null) {
      this.puW = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(265102);
          if (!VideoLiteControBar.b(VideoLiteControBar.this))
          {
            AppMethodBeat.o(265102);
            return false;
          }
          AppMethodBeat.o(265102);
          return true;
        }
      }, true);
    }
    bWX();
    this.puW.stopTimer();
    this.puW.startTimer(500L);
    AppMethodBeat.o(266689);
  }
  
  public final void bVh()
  {
    AppMethodBeat.i(266691);
    if (this.puW != null) {
      this.puW.stopTimer();
    }
    AppMethodBeat.o(266691);
  }
  
  public final void bVi()
  {
    AppMethodBeat.i(266673);
    if (this.pCz != null)
    {
      this.pCz.stopTimer();
      this.pCz.startTimer(7000L);
    }
    AppMethodBeat.o(266673);
  }
  
  public final void bVj() {}
  
  public final boolean bVk()
  {
    return false;
  }
  
  public final void bWO()
  {
    AppMethodBeat.i(266695);
    if (this.pCf == 0)
    {
      AppMethodBeat.o(266695);
      return;
    }
    if (this.oZf)
    {
      AppMethodBeat.o(266695);
      return;
    }
    if (this.pCb == null)
    {
      AppMethodBeat.o(266695);
      return;
    }
    this.pCd.setText(AQ(this.mPosition / 60) + ":" + AQ(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(266695);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCb.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = eL(this.mPosition, i);
    this.pCb.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.pCf * i));
    this.pBZ.setLayoutParams(localLayoutParams);
    requestLayout();
    eK(this.mPosition, this.pCf);
    AppMethodBeat.o(266695);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(266705);
    if (paramConfiguration.orientation == 1)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.sSK.getLayoutParams();
      paramConfiguration.addRule(2, com.tencent.mm.plugin.brandservice.d.e.video_close_btn);
      paramConfiguration.removeRule(8);
      paramConfiguration.removeRule(1);
      paramConfiguration.setMargins(a.aZ(getContext(), d.c.Edge_3A), 0, a.aZ(getContext(), d.c.Edge_3A), 0);
      this.sSK.setLayoutParams(paramConfiguration);
      ((RelativeLayout.LayoutParams)this.sSJ.getLayoutParams()).setMargins(a.aZ(getContext(), d.c.Edge_3A), a.aZ(getContext(), d.c.Edge_3A), 0, 0);
      ((RelativeLayout.LayoutParams)this.jac.getLayoutParams()).setMargins(0, 0, 0, a.aZ(getContext(), d.c.Edge_2A));
      AppMethodBeat.o(266705);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.sSK.getLayoutParams();
      paramConfiguration.removeRule(2);
      paramConfiguration.addRule(8, com.tencent.mm.plugin.brandservice.d.e.video_close_btn);
      paramConfiguration.addRule(1, com.tencent.mm.plugin.brandservice.d.e.video_close_btn);
      paramConfiguration.setMargins(a.aZ(getContext(), d.c.Edge_7A), 0, a.aZ(getContext(), d.c.Edge_3A), 0);
      this.sSK.setLayoutParams(paramConfiguration);
      paramConfiguration = (RelativeLayout.LayoutParams)this.sSJ.getLayoutParams();
      int i = a.aZ(getContext(), d.c.Edge_3A);
      paramConfiguration.setMargins(i, a.aZ(getContext(), d.c.Edge_2A), 0, a.fromDPToPix(getContext(), -5));
      int j = a.aZ(getContext(), d.c.Edge_5A);
      ((RelativeLayout.LayoutParams)this.jac.getLayoutParams()).setMargins(i, 0, 0, j);
    }
    AppMethodBeat.o(266705);
  }
  
  public int getLayoutId()
  {
    return com.tencent.mm.plugin.brandservice.d.f.suA;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(266675);
    setVisibility(8);
    AppMethodBeat.o(266675);
  }
  
  public final void init()
  {
    AppMethodBeat.i(266650);
    super.init();
    this.pCr = ((ImageView)this.contentView.findViewById(com.tencent.mm.plugin.brandservice.d.e.player_progress_bar_middle));
    this.sSJ = ((ImageView)findViewById(com.tencent.mm.plugin.brandservice.d.e.video_close_btn));
    this.jac = findViewById(com.tencent.mm.plugin.brandservice.d.e.root);
    this.sSK = findViewById(com.tencent.mm.plugin.brandservice.d.e.srM);
    AppMethodBeat.o(266650);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(266649);
    if (this.puW != null) {
      this.puW.stopTimer();
    }
    if (this.pCz != null) {
      this.pCz.stopTimer();
    }
    AppMethodBeat.o(266649);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(266694);
    super.seek(paramInt);
    eK(this.mPosition, this.pCf);
    AppMethodBeat.o(266694);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.pCH = paramBoolean;
  }
  
  public void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(266651);
    this.sSJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(266651);
  }
  
  public void setDanmakuBtnOnClickListener(d.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.pCB = paramBoolean;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(266667);
    this.fEq = paramBoolean;
    if (this.fEq) {
      this.pCc.setImageDrawable(au.o(getContext(), a.d.icons_filled_pause, -1));
    }
    for (;;)
    {
      if (this.sSL != null) {
        this.sSL.lE(paramBoolean);
      }
      AppMethodBeat.o(266667);
      return;
      this.pCc.setImageDrawable(au.o(getContext(), a.d.icons_filled_play, -1));
    }
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setMuteBtnState(boolean paramBoolean) {}
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(266652);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(266652);
  }
  
  public void setOnPlayStatusChangeListener(VideoLiteControBar.a parama)
  {
    this.sSL = parama;
  }
  
  public void setOnUpdateProgressLenListener(com.tencent.mm.plugin.appbrand.jsapi.video.d.e parame)
  {
    this.pCI = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(266661);
    this.pCG = paramBoolean;
    bWQ();
    AppMethodBeat.o(266661);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(266658);
    this.pCE = paramBoolean;
    bWY();
    AppMethodBeat.o(266658);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.pCC = paramBoolean;
  }
  
  public void setShowMuteBtn(boolean paramBoolean) {}
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(266698);
    this.pCF = paramBoolean;
    bWQ();
    AppMethodBeat.o(266698);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(266700);
    this.pCD = paramBoolean;
    bWY();
    AppMethodBeat.o(266700);
  }
  
  public void setStatePorter(d.i parami)
  {
    this.pCy = parami;
  }
  
  public void setTitle(String paramString) {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(266703);
    super.setVisibility(paramInt);
    Iterator localIterator;
    com.tencent.mm.plugin.appbrand.jsapi.video.d.f localf;
    if (paramInt == 0)
    {
      localIterator = this.pCJ.iterator();
      while (localIterator.hasNext())
      {
        localf = (com.tencent.mm.plugin.appbrand.jsapi.video.d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(266703);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.pCJ.iterator();
      while (localIterator.hasNext())
      {
        localf = (com.tencent.mm.plugin.appbrand.jsapi.video.d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(266703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar
 * JD-Core Version:    0.7.0.1
 */