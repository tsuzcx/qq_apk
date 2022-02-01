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
  private MTimerHandler sAc;
  private ImageView sHA;
  private ImageView sHB;
  private LinearLayout sHC;
  private ImageView sHD;
  private FrameLayout sHE;
  private ImageView sHF;
  private ImageView sHG;
  private ImageView sHH;
  private LinearLayout sHI;
  private LinearLayout sHJ;
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
  private d.e sHU;
  private ConcurrentLinkedQueue<d.f> sHV;
  private TextView xw;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(328248);
    this.sHT = true;
    this.sHV = new ConcurrentLinkedQueue();
    AppMethodBeat.o(328248);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(328252);
    this.sHT = true;
    this.sHV = new ConcurrentLinkedQueue();
    AppMethodBeat.o(328252);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(328256);
    this.sHT = true;
    this.sHV = new ConcurrentLinkedQueue();
    AppMethodBeat.o(328256);
  }
  
  private void cxc()
  {
    AppMethodBeat.i(328258);
    if (this.sHM)
    {
      this.sHI.setVisibility(0);
      AppMethodBeat.o(328258);
      return;
    }
    this.sHI.setVisibility(8);
    AppMethodBeat.o(328258);
  }
  
  private void cxd()
  {
    AppMethodBeat.i(328261);
    if (this.sHR)
    {
      if (this.sHS)
      {
        this.sHp.setVisibility(8);
        this.sHG.setVisibility(0);
        AppMethodBeat.o(328261);
        return;
      }
      this.sHp.setVisibility(0);
      this.sHG.setVisibility(8);
      AppMethodBeat.o(328261);
      return;
    }
    this.sHp.setVisibility(8);
    this.sHG.setVisibility(8);
    AppMethodBeat.o(328261);
  }
  
  private void cxe()
  {
    AppMethodBeat.i(328265);
    if (this.sHN)
    {
      this.sHB.setImageResource(a.e.app_brand_video_danmu_on);
      AppMethodBeat.o(328265);
      return;
    }
    this.sHB.setImageResource(a.e.app_brand_video_danmu_off);
    AppMethodBeat.o(328265);
  }
  
  private void cxf()
  {
    AppMethodBeat.i(328269);
    if (this.sHO)
    {
      this.sHA.setVisibility(0);
      if (this.sHM)
      {
        this.sHA.setImageResource(a.e.app_brand_video_fullscreen_exit_btn);
        AppMethodBeat.o(328269);
        return;
      }
      this.sHA.setImageResource(a.e.app_brand_video_fullscreen_btn);
      AppMethodBeat.o(328269);
      return;
    }
    this.sHA.setVisibility(8);
    AppMethodBeat.o(328269);
  }
  
  private void cxg()
  {
    AppMethodBeat.i(328273);
    cxj();
    cxf();
    cxc();
    cxi();
    cxh();
    AppMethodBeat.o(328273);
  }
  
  private void cxh()
  {
    AppMethodBeat.i(328277);
    if (this.sHM) {}
    for (int i = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_btn_gap);; i = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_btn_gap))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.sHp != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sHp.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sHp.setLayoutParams(localMarginLayoutParams);
      }
      if (this.sHJ != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sHJ.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sHJ.setLayoutParams(localMarginLayoutParams);
      }
      if (this.sHB != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sHB.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sHB.setLayoutParams(localMarginLayoutParams);
      }
      if (this.sHF != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sHF.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sHF.setLayoutParams(localMarginLayoutParams);
      }
      if (this.sHA != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sHA.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sHA.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(328277);
      return;
    }
  }
  
  private void cxi()
  {
    AppMethodBeat.i(328284);
    if (this.sHM) {}
    for (float f = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_time_textsize);; f = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_time_textsize))
    {
      this.sHq.setTextSize(0, f);
      this.sHr.setTextSize(0, f);
      AppMethodBeat.o(328284);
      return;
    }
  }
  
  private void cxj()
  {
    AppMethodBeat.i(328290);
    ViewGroup.LayoutParams localLayoutParams = this.sHC.getLayoutParams();
    if (this.sHM)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_height);
      this.sHC.setLayoutParams(localLayoutParams);
      if (!this.sHM) {
        break label112;
      }
    }
    label112:
    for (int i = getResources().getDimensionPixelSize(a.a.app_brand_video_fullscreen_control_bar_horizontal_margin);; i = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_horizontal_margin))
    {
      this.sHC.setPadding(0, 0, i, 0);
      if (this.sHI != null) {
        this.sHI.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(328290);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(a.a.app_brand_video_control_bar_height);
      break;
    }
  }
  
  private boolean cxk()
  {
    AppMethodBeat.i(328298);
    if (this.sHK == null)
    {
      Log.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(328298);
      return false;
    }
    int k = this.sHK.cvf();
    int j = this.sHK.cvg();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(328298);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(328298);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHD.getLayoutParams();
      localLayoutParams.width = i;
      this.sHD.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(328298);
      return true;
      d = k;
    }
  }
  
  private void cxl()
  {
    int j = 0;
    AppMethodBeat.i(328309);
    boolean bool;
    Object localObject;
    if (this.sHQ)
    {
      bool = this.sHP;
      localObject = this.sHE;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.sHq;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.sHr;
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
      AppMethodBeat.o(328309);
      return;
      bool = false;
      break;
      i = 8;
      break label32;
      i = 8;
      break label50;
    }
  }
  
  private void fE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328316);
    if (this.sHU != null) {
      this.sHU.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(328316);
  }
  
  public final void a(d.f paramf)
  {
    AppMethodBeat.i(328617);
    this.sHV.add(paramf);
    AppMethodBeat.o(328617);
  }
  
  public final void anJ()
  {
    AppMethodBeat.i(328534);
    this.sHM = true;
    cxg();
    AppMethodBeat.o(328534);
  }
  
  public final void csz()
  {
    AppMethodBeat.i(328541);
    this.sHM = false;
    cxg();
    AppMethodBeat.o(328541);
  }
  
  public final void cuX()
  {
    AppMethodBeat.i(328445);
    if ((this.sHR) && (this.sHS)) {
      this.sHG.setVisibility(8);
    }
    AppMethodBeat.o(328445);
  }
  
  public final boolean cvA()
  {
    AppMethodBeat.i(328599);
    if (this.sHE != null)
    {
      if ((getVisibility() == 0) && (this.sHE.getVisibility() == 0))
      {
        AppMethodBeat.o(328599);
        return true;
      }
      AppMethodBeat.o(328599);
      return false;
    }
    AppMethodBeat.o(328599);
    return false;
  }
  
  public final boolean cvq()
  {
    return this.sHN;
  }
  
  public final void cvr()
  {
    AppMethodBeat.i(328526);
    if (cvt())
    {
      setVisibility(8);
      AppMethodBeat.o(328526);
      return;
    }
    cvs();
    AppMethodBeat.o(328526);
  }
  
  public final void cvs()
  {
    AppMethodBeat.i(328503);
    setVisibility(0);
    if (!this.sHT)
    {
      AppMethodBeat.o(328503);
      return;
    }
    if (this.sHL == null) {
      this.sHL = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(328249);
          AppBrandVideoViewControlBar.this.setVisibility(8);
          AppBrandVideoViewControlBar.c(AppBrandVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(328249);
          return false;
        }
      }, false);
    }
    this.sHL.stopTimer();
    this.sHL.startTimer(7000L);
    AppMethodBeat.o(328503);
  }
  
  public final boolean cvt()
  {
    AppMethodBeat.i(328518);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(328518);
      return true;
    }
    AppMethodBeat.o(328518);
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
    AppMethodBeat.i(328558);
    if (this.sAc == null) {
      this.sAc = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(328239);
          if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this))
          {
            AppMethodBeat.o(328239);
            return false;
          }
          AppMethodBeat.o(328239);
          return true;
        }
      }, true);
    }
    cxk();
    this.sAc.stopTimer();
    this.sAc.startTimer(500L);
    AppMethodBeat.o(328558);
  }
  
  public final void cvx()
  {
    AppMethodBeat.i(328565);
    if (this.sAc != null) {
      this.sAc.stopTimer();
    }
    AppMethodBeat.o(328565);
  }
  
  public final void cvy()
  {
    AppMethodBeat.i(328508);
    if (this.sHL != null)
    {
      this.sHL.stopTimer();
      this.sHL.startTimer(7000L);
    }
    AppMethodBeat.o(328508);
  }
  
  public final void cvz()
  {
    AppMethodBeat.i(328452);
    if ((this.sHR) && (this.sHS)) {
      this.sHG.setVisibility(0);
    }
    AppMethodBeat.o(328452);
  }
  
  public final void cxb()
  {
    AppMethodBeat.i(328578);
    if (this.cqW == 0)
    {
      AppMethodBeat.o(328578);
      return;
    }
    if (this.seH)
    {
      AppMethodBeat.o(328578);
      return;
    }
    if (this.sHo == null)
    {
      AppMethodBeat.o(328578);
      return;
    }
    this.sHq.setText(Bf(this.mPosition / 60) + ":" + Bf(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(328578);
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
    AppMethodBeat.o(328578);
  }
  
  protected int getLayoutId()
  {
    return a.d.app_brand_videoview_control_bar;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(328514);
    setVisibility(8);
    AppMethodBeat.o(328514);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(328379);
    super.init();
    this.sHA = ((ImageView)this.contentView.findViewById(a.c.full_screen_btn));
    this.sHB = ((ImageView)this.contentView.findViewById(a.c.danmaku_btn));
    this.sHD = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_middle));
    this.sHE = ((FrameLayout)this.contentView.findViewById(a.c.player_progress_root));
    this.sHC = ((LinearLayout)findViewById(a.c.root));
    this.sHF = ((ImageView)findViewById(a.c.mute_btn));
    this.sHG = ((ImageView)findViewById(a.c.center_play_btn));
    this.sHH = ((ImageView)findViewById(a.c.exit_fullscreen_btn));
    this.xw = ((TextView)findViewById(a.c.title));
    this.sHI = ((LinearLayout)findViewById(a.c.fullscreen_title_bar));
    this.sHJ = ((LinearLayout)findViewById(a.c.player_progress_bar));
    AppMethodBeat.o(328379);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(328364);
    if (this.sAc != null) {
      this.sAc.stopTimer();
    }
    if (this.sHL != null) {
      this.sHL.stopTimer();
    }
    AppMethodBeat.o(328364);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(328570);
    super.seek(paramInt);
    fE(this.mPosition, this.cqW);
    AppMethodBeat.o(328570);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.sHT = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(final d.g paramg)
  {
    AppMethodBeat.i(328477);
    this.sHB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(328240);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
        if (paramg != null) {
          paramg.jI(AppBrandVideoViewControlBar.b(AppBrandVideoViewControlBar.this));
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(328240);
      }
    });
    AppMethodBeat.o(328477);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(328488);
    this.sHN = paramBoolean;
    cxe();
    AppMethodBeat.o(328488);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(328395);
    this.sHH.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(328395);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(328470);
    this.sHA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(328470);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(328460);
    this.hJg = paramBoolean;
    if (this.hJg)
    {
      this.sHp.setImageResource(a.e.app_brand_video_play_btn_pause);
      this.sHG.setImageResource(a.e.app_brand_video_play_btn_pause);
      AppMethodBeat.o(328460);
      return;
    }
    this.sHp.setImageResource(a.e.app_brand_video_play_btn_play);
    this.sHG.setImageResource(a.e.app_brand_video_play_btn_play);
    AppMethodBeat.o(328460);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(328386);
    this.sHF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(328386);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(328426);
    if (paramBoolean)
    {
      this.sHF.setImageResource(a.e.app_brand_video_mute_btn_off);
      AppMethodBeat.o(328426);
      return;
    }
    this.sHF.setImageResource(a.e.app_brand_video_mute_btn_on);
    AppMethodBeat.o(328426);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(328401);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.sHG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(328401);
  }
  
  public void setOnUpdateProgressLenListener(d.e parame)
  {
    this.sHU = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(328441);
    this.sHS = paramBoolean;
    cxd();
    AppMethodBeat.o(328441);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(328432);
    this.sHQ = paramBoolean;
    cxl();
    AppMethodBeat.o(328432);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(328495);
    if (paramBoolean)
    {
      this.sHB.setVisibility(0);
      AppMethodBeat.o(328495);
      return;
    }
    this.sHB.setVisibility(8);
    AppMethodBeat.o(328495);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(328585);
    this.sHO = paramBoolean;
    cxf();
    cxc();
    AppMethodBeat.o(328585);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(328420);
    ImageView localImageView = this.sHF;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(328420);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(328589);
    this.sHR = paramBoolean;
    cxd();
    AppMethodBeat.o(328589);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(328595);
    this.sHP = paramBoolean;
    cxl();
    AppMethodBeat.o(328595);
  }
  
  public void setStatePorter(d.i parami)
  {
    this.sHK = parami;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(328412);
    if (!Util.isNullOrNil(paramString)) {
      this.xw.setText(paramString);
    }
    AppMethodBeat.o(328412);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(328607);
    super.setVisibility(paramInt);
    Iterator localIterator;
    d.f localf;
    if (paramInt == 0)
    {
      localIterator = this.sHV.iterator();
      while (localIterator.hasNext())
      {
        localf = (d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(328607);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.sHV.iterator();
      while (localIterator.hasNext())
      {
        localf = (d.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(328607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */