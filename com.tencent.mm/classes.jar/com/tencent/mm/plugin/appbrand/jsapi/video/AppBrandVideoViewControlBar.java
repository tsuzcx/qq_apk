package com.tencent.mm.plugin.appbrand.jsapi.video;

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
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class AppBrandVideoViewControlBar
  extends VideoPlayerSeekBar
  implements c.a
{
  private TextView ama;
  private ImageView gDU;
  private ImageView gDV;
  private LinearLayout gDW;
  private ImageView gDX;
  private FrameLayout gDY;
  private ImageView gDZ;
  private ImageView gEa;
  private ImageView gEb;
  private LinearLayout gEc;
  private LinearLayout gEd;
  private c.h gEe;
  private am gEf;
  private am gEg;
  private boolean gEh;
  private boolean gEi;
  private boolean gEj;
  private boolean gEk;
  private boolean gEl;
  private boolean gEm;
  private boolean gEn;
  private c.d gEo;
  private c.e gEp;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void akA()
  {
    if (this.gEh)
    {
      this.gEc.setVisibility(0);
      return;
    }
    this.gEc.setVisibility(8);
  }
  
  private void akC()
  {
    if (this.gEm)
    {
      if (this.gEn)
      {
        this.ofr.setVisibility(8);
        this.gEa.setVisibility(0);
        return;
      }
      this.ofr.setVisibility(0);
      this.gEa.setVisibility(8);
      return;
    }
    this.ofr.setVisibility(8);
    this.gEa.setVisibility(8);
  }
  
  private void akE()
  {
    if (this.gEi)
    {
      this.gDV.setImageResource(y.i.app_brand_video_danmu_on);
      return;
    }
    this.gDV.setImageResource(y.i.app_brand_video_danmu_off);
  }
  
  private void akF()
  {
    if (this.gEj)
    {
      this.gDU.setVisibility(0);
      if (this.gEh)
      {
        this.gDU.setImageResource(y.i.app_brand_video_fullscreen_exit_btn);
        return;
      }
      this.gDU.setImageResource(y.i.app_brand_video_fullscreen_btn);
      return;
    }
    this.gDU.setVisibility(8);
  }
  
  private void akL()
  {
    Object localObject = this.gDW.getLayoutParams();
    label55:
    float f;
    if (this.gEh)
    {
      ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(y.e.app_brand_video_fullscreen_control_bar_height);
      this.gDW.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (!this.gEh) {
        break label320;
      }
      i = getResources().getDimensionPixelSize(y.e.app_brand_video_fullscreen_control_bar_horizontal_margin);
      this.gDW.setPadding(0, 0, i, 0);
      if (this.gEc != null) {
        this.gEc.setPadding(i, 0, i, 0);
      }
      akF();
      akA();
      if (!this.gEh) {
        break label334;
      }
      f = getResources().getDimensionPixelSize(y.e.app_brand_video_fullscreen_control_bar_time_textsize);
      label111:
      this.ofs.setTextSize(0, f);
      this.oft.setTextSize(0, f);
      if (!this.gEh) {
        break label349;
      }
    }
    label320:
    label334:
    label349:
    for (int i = getResources().getDimensionPixelSize(y.e.app_brand_video_fullscreen_control_bar_btn_gap);; i = getResources().getDimensionPixelSize(y.e.app_brand_video_control_bar_btn_gap))
    {
      if (this.ofr != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.ofr.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
        this.ofr.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.gEd != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.gEd.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
        this.gEd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.gDV != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.gDV.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
        this.gDV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.gDZ != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.gDZ.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
        this.gDZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.gDU != null)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.gDU.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(i);
        this.gDU.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(y.e.app_brand_video_control_bar_height);
      break;
      i = getResources().getDimensionPixelSize(y.e.app_brand_video_control_bar_horizontal_margin);
      break label55;
      f = getResources().getDimensionPixelSize(y.e.app_brand_video_control_bar_time_textsize);
      break label111;
    }
  }
  
  private boolean akO()
  {
    if (this.gEe == null) {
      y.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
    }
    int j;
    do
    {
      return false;
      k = this.gEe.akj();
      j = this.gEe.akk();
    } while ((k < 0) || (j < 0));
    int i = k;
    if (k > j) {
      i = j;
    }
    int k = getBarLen();
    if (k <= 0) {
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.gDX.getLayoutParams();
      localLayoutParams.width = i;
      this.gDX.setLayoutParams(localLayoutParams);
      return true;
      d = k;
    }
  }
  
  private void akQ()
  {
    int j = 0;
    boolean bool;
    Object localObject;
    if (this.gEl)
    {
      bool = this.gEk;
      localObject = this.gDY;
      if (!bool) {
        break label74;
      }
      i = 0;
      label26:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.ofs;
      if (!bool) {
        break label80;
      }
      i = 0;
      label44:
      ((TextView)localObject).setVisibility(i);
      localObject = this.oft;
      if (!bool) {
        break label86;
      }
    }
    label74:
    label80:
    label86:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      bool = false;
      break;
      i = 8;
      break label26;
      i = 8;
      break label44;
    }
  }
  
  private void bZ(int paramInt1, int paramInt2)
  {
    if (this.gEo != null) {
      this.gEo.bX(paramInt1, paramInt2);
    }
  }
  
  public final void aiZ()
  {
    this.gEh = false;
    akL();
  }
  
  public final void akB()
  {
    if ((this.gEm) && (this.gEn)) {
      this.gEa.setVisibility(0);
    }
  }
  
  public final boolean akD()
  {
    return this.gEi;
  }
  
  public final void akG()
  {
    if (this.gEf != null)
    {
      this.gEf.stopTimer();
      this.gEf.S(7000L, 7000L);
    }
  }
  
  public final boolean akH()
  {
    return getVisibility() == 0;
  }
  
  public final void akI()
  {
    if (akH())
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    if (this.gEf == null) {
      this.gEf = new am(new AppBrandVideoViewControlBar.3(this), false);
    }
    this.gEf.stopTimer();
    this.gEf.S(7000L, 7000L);
  }
  
  public final void akJ()
  {
    this.gEh = true;
    akL();
  }
  
  public final boolean akK()
  {
    return this.gEh;
  }
  
  public final void akM()
  {
    if (this.gEg == null) {
      this.gEg = new am(new AppBrandVideoViewControlBar.4(this), true);
    }
    akO();
    this.gEg.stopTimer();
    this.gEg.S(500L, 500L);
  }
  
  public final void akN()
  {
    if (this.gEg != null) {
      this.gEg.stopTimer();
    }
  }
  
  public final void akP()
  {
    if (this.ofu == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.guU) || (this.ofq == null));
      this.ofs.setText(lC(this.mPosition / 60) + ":" + lC(this.mPosition % 60));
    } while (getBarLen() == 0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ofq.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = fa(this.mPosition, i);
    this.ofq.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.ofo.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ofu * i));
    this.ofo.setLayoutParams(localLayoutParams);
    requestLayout();
    bZ(this.mPosition, this.ofu);
  }
  
  public final void akd()
  {
    if ((this.gEm) && (this.gEn)) {
      this.gEa.setVisibility(8);
    }
  }
  
  public final boolean cVl()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.gDY != null)
    {
      bool1 = bool2;
      if (getVisibility() == 0)
      {
        bool1 = bool2;
        if (this.gDY.getVisibility() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected int getLayoutId()
  {
    return y.h.app_brand_videoview_control_bar;
  }
  
  public final void hide()
  {
    setVisibility(8);
  }
  
  protected final void init()
  {
    super.init();
    this.gDU = ((ImageView)this.contentView.findViewById(y.g.full_screen_btn));
    this.gDV = ((ImageView)this.contentView.findViewById(y.g.danmaku_btn));
    this.gDX = ((ImageView)this.contentView.findViewById(y.g.player_progress_bar_middle));
    this.gDY = ((FrameLayout)this.contentView.findViewById(y.g.player_progress_root));
    this.gDW = ((LinearLayout)findViewById(y.g.root));
    this.gDZ = ((ImageView)findViewById(y.g.mute_btn));
    this.gEa = ((ImageView)findViewById(y.g.center_play_btn));
    this.gEb = ((ImageView)findViewById(y.g.exit_fullscreen_btn));
    this.ama = ((TextView)findViewById(y.g.title));
    this.gEc = ((LinearLayout)findViewById(y.g.fullscreen_title_bar));
    this.gEd = ((LinearLayout)findViewById(y.g.player_progress_bar));
  }
  
  public final void onDestroy()
  {
    if (this.gEg != null) {
      this.gEg.stopTimer();
    }
    if (this.gEf != null) {
      this.gEf.stopTimer();
    }
  }
  
  public final void seek(int paramInt)
  {
    super.seek(paramInt);
    bZ(this.mPosition, this.ofu);
  }
  
  public void setDanmakuBtnOnClickListener(c.f paramf)
  {
    this.gDV.setOnClickListener(new AppBrandVideoViewControlBar.2(this, paramf));
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.gEi = paramBoolean;
    akE();
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gEb.setOnClickListener(paramOnClickListener);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gDU.setOnClickListener(paramOnClickListener);
  }
  
  public void setIplaySeekCallback(c.c paramc)
  {
    setIplaySeekCallback(new AppBrandVideoViewControlBar.1(this, paramc));
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    this.bNU = paramBoolean;
    if (this.bNU)
    {
      this.ofr.setImageResource(y.i.app_brand_video_play_btn_pause);
      this.gEa.setImageResource(y.i.app_brand_video_play_btn_pause);
      return;
    }
    this.ofr.setImageResource(y.i.app_brand_video_play_btn_play);
    this.gEa.setImageResource(y.i.app_brand_video_play_btn_play);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gDZ.setOnClickListener(paramOnClickListener);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gDZ.setImageResource(y.i.app_brand_video_mute_btn_off);
      return;
    }
    this.gDZ.setImageResource(y.i.app_brand_video_mute_btn_on);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.gEa.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnUpdateProgressLenListener(c.d paramd)
  {
    this.gEo = paramd;
  }
  
  public void setOnVisibilityChangedListener(c.e parame)
  {
    this.gEp = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    this.gEn = paramBoolean;
    akC();
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    this.gEl = paramBoolean;
    akQ();
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gDV.setVisibility(0);
      return;
    }
    this.gDV.setVisibility(8);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.gEj = paramBoolean;
    akF();
    akA();
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    ImageView localImageView = this.gDZ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    this.gEm = paramBoolean;
    akC();
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    this.gEk = paramBoolean;
    akQ();
  }
  
  public void setStatePorter(c.h paramh)
  {
    this.gEe = paramh;
  }
  
  public void setTitle(String paramString)
  {
    if (!bk.bl(paramString)) {
      this.ama.setText(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      if (this.gEp != null) {
        this.gEp.cLm();
      }
    }
    while (((paramInt != 8) && (paramInt != 4)) || (this.gEp == null)) {
      return;
    }
    this.gEp.cLm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */