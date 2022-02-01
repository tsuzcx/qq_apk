package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.b.d.a.a;
import com.tencent.luggage.b.d.a.c;
import com.tencent.luggage.b.d.a.d;
import com.tencent.luggage.b.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandVideoViewControlBar
  extends VideoPlayerSeekBar
  implements d.a, d.b
{
  private boolean pCA;
  private boolean pCB;
  private boolean pCC;
  private boolean pCD;
  private boolean pCE;
  private boolean pCF;
  private boolean pCG;
  private boolean pCH;
  private d.e pCI;
  private ConcurrentLinkedQueue<d.f> pCJ;
  private ImageView pCo;
  private ImageView pCp;
  private LinearLayout pCq;
  private ImageView pCr;
  private FrameLayout pCs;
  private ImageView pCt;
  private ImageView pCu;
  private ImageView pCv;
  private LinearLayout pCw;
  private LinearLayout pCx;
  private d.i pCy;
  private MTimerHandler pCz;
  private MTimerHandler puW;
  private TextView wB;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(228553);
    this.pCH = true;
    this.pCJ = new ConcurrentLinkedQueue();
    AppMethodBeat.o(228553);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(228556);
    this.pCH = true;
    this.pCJ = new ConcurrentLinkedQueue();
    AppMethodBeat.o(228556);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(228558);
    this.pCH = true;
    this.pCJ = new ConcurrentLinkedQueue();
    AppMethodBeat.o(228558);
  }
  
  private void bWP()
  {
    AppMethodBeat.i(228575);
    if (this.pCA)
    {
      this.pCw.setVisibility(0);
      AppMethodBeat.o(228575);
      return;
    }
    this.pCw.setVisibility(8);
    AppMethodBeat.o(228575);
  }
  
  private void bWQ()
  {
    AppMethodBeat.i(228587);
    if (this.pCF)
    {
      if (this.pCG)
      {
        this.pCc.setVisibility(8);
        this.pCu.setVisibility(0);
        AppMethodBeat.o(228587);
        return;
      }
      this.pCc.setVisibility(0);
      this.pCu.setVisibility(8);
      AppMethodBeat.o(228587);
      return;
    }
    this.pCc.setVisibility(8);
    this.pCu.setVisibility(8);
    AppMethodBeat.o(228587);
  }
  
  private void bWR()
  {
    AppMethodBeat.i(228603);
    if (this.pCB)
    {
      this.pCp.setImageResource(a.e.app_brand_video_danmu_on);
      AppMethodBeat.o(228603);
      return;
    }
    this.pCp.setImageResource(a.e.app_brand_video_danmu_off);
    AppMethodBeat.o(228603);
  }
  
  private void bWS()
  {
    AppMethodBeat.i(228608);
    if (this.pCC)
    {
      this.pCo.setVisibility(0);
      if (this.pCA)
      {
        this.pCo.setImageResource(a.e.app_brand_video_fullscreen_exit_btn);
        AppMethodBeat.o(228608);
        return;
      }
      this.pCo.setImageResource(a.e.app_brand_video_fullscreen_btn);
      AppMethodBeat.o(228608);
      return;
    }
    this.pCo.setVisibility(8);
    AppMethodBeat.o(228608);
  }
  
  private void bWT()
  {
    AppMethodBeat.i(228632);
    bWW();
    bWS();
    bWP();
    bWV();
    bWU();
    AppMethodBeat.o(228632);
  }
  
  private void bWU()
  {
    AppMethodBeat.i(228635);
    if (this.pCA) {}
    for (int i = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_btn_gap);; i = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_btn_gap))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.pCc != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCc.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCc.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pCx != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCx.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCx.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pCp != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCp.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCp.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pCt != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCt.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCt.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pCo != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCo.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCo.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(228635);
      return;
    }
  }
  
  private void bWV()
  {
    AppMethodBeat.i(228637);
    if (this.pCA) {}
    for (float f = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_time_textsize);; f = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_time_textsize))
    {
      this.pCd.setTextSize(0, f);
      this.pCe.setTextSize(0, f);
      AppMethodBeat.o(228637);
      return;
    }
  }
  
  private void bWW()
  {
    AppMethodBeat.i(228638);
    ViewGroup.LayoutParams localLayoutParams = this.pCq.getLayoutParams();
    if (this.pCA)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_height);
      this.pCq.setLayoutParams(localLayoutParams);
      if (!this.pCA) {
        break label112;
      }
    }
    label112:
    for (int i = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_horizontal_margin);; i = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_horizontal_margin))
    {
      this.pCq.setPadding(0, 0, i, 0);
      if (this.pCw != null) {
        this.pCw.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(228638);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_height);
      break;
    }
  }
  
  private boolean bWX()
  {
    AppMethodBeat.i(228647);
    if (this.pCy == null)
    {
      Log.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(228647);
      return false;
    }
    int k = this.pCy.bUQ();
    int j = this.pCy.bUR();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(228647);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(228647);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCr.getLayoutParams();
      localLayoutParams.width = i;
      this.pCr.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(228647);
      return true;
      d = k;
    }
  }
  
  private void bWY()
  {
    int j = 0;
    AppMethodBeat.i(228662);
    boolean bool;
    Object localObject;
    if (this.pCE)
    {
      bool = this.pCD;
      localObject = this.pCs;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.pCd;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.pCe;
      if (!bool) {
        break label98;
      }
    }
    label86:
    label92:
    label98:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      AppMethodBeat.o(228662);
      return;
      bool = false;
      break;
      i = 8;
      break label32;
      i = 8;
      break label50;
    }
  }
  
  private void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228664);
    if (this.pCI != null) {
      this.pCI.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(228664);
  }
  
  public final void Nq()
  {
    AppMethodBeat.i(228626);
    this.pCA = true;
    bWT();
    AppMethodBeat.o(228626);
  }
  
  public final void a(d.f paramf)
  {
    AppMethodBeat.i(228675);
    this.pCJ.add(paramf);
    AppMethodBeat.o(228675);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(228629);
    this.pCA = false;
    bWT();
    AppMethodBeat.o(228629);
  }
  
  public final void bUI()
  {
    AppMethodBeat.i(228579);
    if ((this.pCF) && (this.pCG)) {
      this.pCu.setVisibility(8);
    }
    AppMethodBeat.o(228579);
  }
  
  public final boolean bVa()
  {
    return this.pCB;
  }
  
  public final void bVb()
  {
    AppMethodBeat.i(228624);
    if (bVd())
    {
      setVisibility(8);
      AppMethodBeat.o(228624);
      return;
    }
    bVc();
    AppMethodBeat.o(228624);
  }
  
  public final void bVc()
  {
    AppMethodBeat.i(228617);
    setVisibility(0);
    if (!this.pCH)
    {
      AppMethodBeat.o(228617);
      return;
    }
    if (this.pCz == null) {
      this.pCz = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(227948);
          AppBrandVideoViewControlBar.this.setVisibility(8);
          AppBrandVideoViewControlBar.c(AppBrandVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(227948);
          return false;
        }
      }, false);
    }
    this.pCz.stopTimer();
    this.pCz.startTimer(7000L);
    AppMethodBeat.o(228617);
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(228623);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(228623);
      return true;
    }
    AppMethodBeat.o(228623);
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
    AppMethodBeat.i(228640);
    if (this.puW == null) {
      this.puW = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(227142);
          if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this))
          {
            AppMethodBeat.o(227142);
            return false;
          }
          AppMethodBeat.o(227142);
          return true;
        }
      }, true);
    }
    bWX();
    this.puW.stopTimer();
    this.puW.startTimer(500L);
    AppMethodBeat.o(228640);
  }
  
  public final void bVh()
  {
    AppMethodBeat.i(228642);
    if (this.puW != null) {
      this.puW.stopTimer();
    }
    AppMethodBeat.o(228642);
  }
  
  public final void bVi()
  {
    AppMethodBeat.i(228618);
    if (this.pCz != null)
    {
      this.pCz.stopTimer();
      this.pCz.startTimer(7000L);
    }
    AppMethodBeat.o(228618);
  }
  
  public final void bVj()
  {
    AppMethodBeat.i(228581);
    if ((this.pCF) && (this.pCG)) {
      this.pCu.setVisibility(0);
    }
    AppMethodBeat.o(228581);
  }
  
  public final boolean bVk()
  {
    AppMethodBeat.i(228658);
    if (this.pCs != null)
    {
      if ((getVisibility() == 0) && (this.pCs.getVisibility() == 0))
      {
        AppMethodBeat.o(228658);
        return true;
      }
      AppMethodBeat.o(228658);
      return false;
    }
    AppMethodBeat.o(228658);
    return false;
  }
  
  public final void bWO()
  {
    AppMethodBeat.i(228651);
    if (this.pCf == 0)
    {
      AppMethodBeat.o(228651);
      return;
    }
    if (this.oZf)
    {
      AppMethodBeat.o(228651);
      return;
    }
    if (this.pCb == null)
    {
      AppMethodBeat.o(228651);
      return;
    }
    this.pCd.setText(AQ(this.mPosition / 60) + ":" + AQ(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(228651);
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
    AppMethodBeat.o(228651);
  }
  
  protected int getLayoutId()
  {
    return a.d.app_brand_videoview_control_bar;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(228622);
    setVisibility(8);
    AppMethodBeat.o(228622);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(228564);
    super.init();
    this.pCo = ((ImageView)this.contentView.findViewById(a.c.full_screen_btn));
    this.pCp = ((ImageView)this.contentView.findViewById(a.c.danmaku_btn));
    this.pCr = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_middle));
    this.pCs = ((FrameLayout)this.contentView.findViewById(a.c.player_progress_root));
    this.pCq = ((LinearLayout)findViewById(a.c.root));
    this.pCt = ((ImageView)findViewById(a.c.mute_btn));
    this.pCu = ((ImageView)findViewById(a.c.center_play_btn));
    this.pCv = ((ImageView)findViewById(a.c.exit_fullscreen_btn));
    this.wB = ((TextView)findViewById(a.c.title));
    this.pCw = ((LinearLayout)findViewById(a.c.fullscreen_title_bar));
    this.pCx = ((LinearLayout)findViewById(a.c.player_progress_bar));
    AppMethodBeat.o(228564);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(228559);
    if (this.puW != null) {
      this.puW.stopTimer();
    }
    if (this.pCz != null) {
      this.pCz.stopTimer();
    }
    AppMethodBeat.o(228559);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(228648);
    super.seek(paramInt);
    eK(this.mPosition, this.pCf);
    AppMethodBeat.o(228648);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.pCH = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(final d.g paramg)
  {
    AppMethodBeat.i(228596);
    this.pCp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229581);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
        if (paramg != null) {
          paramg.iE(AppBrandVideoViewControlBar.b(AppBrandVideoViewControlBar.this));
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229581);
      }
    });
    AppMethodBeat.o(228596);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(228600);
    this.pCB = paramBoolean;
    bWR();
    AppMethodBeat.o(228600);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(228568);
    this.pCv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(228568);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(228592);
    this.pCo.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(228592);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(228589);
    this.fEq = paramBoolean;
    if (this.fEq)
    {
      this.pCc.setImageResource(a.e.app_brand_video_play_btn_pause);
      this.pCu.setImageResource(a.e.app_brand_video_play_btn_pause);
      AppMethodBeat.o(228589);
      return;
    }
    this.pCc.setImageResource(a.e.app_brand_video_play_btn_play);
    this.pCu.setImageResource(a.e.app_brand_video_play_btn_play);
    AppMethodBeat.o(228589);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(228567);
    this.pCt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(228567);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(228573);
    if (paramBoolean)
    {
      this.pCt.setImageResource(a.e.app_brand_video_mute_btn_off);
      AppMethodBeat.o(228573);
      return;
    }
    this.pCt.setImageResource(a.e.app_brand_video_mute_btn_on);
    AppMethodBeat.o(228573);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(228569);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.pCu.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(228569);
  }
  
  public void setOnUpdateProgressLenListener(d.e parame)
  {
    this.pCI = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(228577);
    this.pCG = paramBoolean;
    bWQ();
    AppMethodBeat.o(228577);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(228574);
    this.pCE = paramBoolean;
    bWY();
    AppMethodBeat.o(228574);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(228610);
    if (paramBoolean)
    {
      this.pCp.setVisibility(0);
      AppMethodBeat.o(228610);
      return;
    }
    this.pCp.setVisibility(8);
    AppMethodBeat.o(228610);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(228652);
    this.pCC = paramBoolean;
    bWS();
    bWP();
    AppMethodBeat.o(228652);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(228572);
    ImageView localImageView = this.pCt;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(228572);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(228653);
    this.pCF = paramBoolean;
    bWQ();
    AppMethodBeat.o(228653);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(228655);
    this.pCD = paramBoolean;
    bWY();
    AppMethodBeat.o(228655);
  }
  
  public void setStatePorter(d.i parami)
  {
    this.pCy = parami;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(228570);
    if (!Util.isNullOrNil(paramString)) {
      this.wB.setText(paramString);
    }
    AppMethodBeat.o(228570);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(228672);
    super.setVisibility(paramInt);
    Iterator localIterator;
    d.f localf;
    if (paramInt == 0)
    {
      localIterator = this.pCJ.iterator();
      while (localIterator.hasNext())
      {
        localf = (d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(228672);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.pCJ.iterator();
      while (localIterator.hasNext())
      {
        localf = (d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(228672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */