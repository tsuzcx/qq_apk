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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandVideoViewControlBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private TextView awK;
  private au kOQ;
  private ImageView kUI;
  private ImageView kUJ;
  private LinearLayout kUK;
  private ImageView kUL;
  private FrameLayout kUM;
  private ImageView kUN;
  private ImageView kUO;
  private ImageView kUP;
  private LinearLayout kUQ;
  private LinearLayout kUR;
  private e.i kUS;
  private au kUT;
  private boolean kUU;
  private boolean kUV;
  private boolean kUW;
  private boolean kUX;
  private boolean kUY;
  private boolean kUZ;
  private boolean kVa;
  private boolean kVb;
  private e.e kVc;
  private ConcurrentLinkedQueue<e.f> kVd;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194560);
    this.kVb = true;
    this.kVd = new ConcurrentLinkedQueue();
    AppMethodBeat.o(194560);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194561);
    this.kVb = true;
    this.kVd = new ConcurrentLinkedQueue();
    AppMethodBeat.o(194561);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194562);
    this.kVb = true;
    this.kVd = new ConcurrentLinkedQueue();
    AppMethodBeat.o(194562);
  }
  
  private void bkO()
  {
    AppMethodBeat.i(194572);
    if (this.kUU)
    {
      this.kUQ.setVisibility(0);
      AppMethodBeat.o(194572);
      return;
    }
    this.kUQ.setVisibility(8);
    AppMethodBeat.o(194572);
  }
  
  private void bkP()
  {
    AppMethodBeat.i(194576);
    if (this.kUZ)
    {
      if (this.kVa)
      {
        this.kUw.setVisibility(8);
        this.kUO.setVisibility(0);
        AppMethodBeat.o(194576);
        return;
      }
      this.kUw.setVisibility(0);
      this.kUO.setVisibility(8);
      AppMethodBeat.o(194576);
      return;
    }
    this.kUw.setVisibility(8);
    this.kUO.setVisibility(8);
    AppMethodBeat.o(194576);
  }
  
  private void bkQ()
  {
    AppMethodBeat.i(194581);
    if (this.kUV)
    {
      this.kUJ.setImageResource(2131689662);
      AppMethodBeat.o(194581);
      return;
    }
    this.kUJ.setImageResource(2131689661);
    AppMethodBeat.o(194581);
  }
  
  private void bkR()
  {
    AppMethodBeat.i(194582);
    if (this.kUW)
    {
      this.kUI.setVisibility(0);
      if (this.kUU)
      {
        this.kUI.setImageResource(2131689667);
        AppMethodBeat.o(194582);
        return;
      }
      this.kUI.setImageResource(2131689664);
      AppMethodBeat.o(194582);
      return;
    }
    this.kUI.setVisibility(8);
    AppMethodBeat.o(194582);
  }
  
  private void bkS()
  {
    AppMethodBeat.i(194591);
    bkV();
    bkR();
    bkO();
    bkU();
    bkT();
    AppMethodBeat.o(194591);
  }
  
  private void bkT()
  {
    AppMethodBeat.i(194592);
    if (this.kUU) {}
    for (int i = getResources().getDimensionPixelSize(2131165875);; i = getResources().getDimensionPixelSize(2131165865))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.kUw != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUw.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUw.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kUR != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUR.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUR.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kUJ != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUJ.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUJ.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kUN != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUN.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUN.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kUI != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUI.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUI.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(194592);
      return;
    }
  }
  
  private void bkU()
  {
    AppMethodBeat.i(194593);
    if (this.kUU) {}
    for (float f = getResources().getDimensionPixelSize(2131165878);; f = getResources().getDimensionPixelSize(2131165871))
    {
      this.kUx.setTextSize(0, f);
      this.kUy.setTextSize(0, f);
      AppMethodBeat.o(194593);
      return;
    }
  }
  
  private void bkV()
  {
    AppMethodBeat.i(194594);
    ViewGroup.LayoutParams localLayoutParams = this.kUK.getLayoutParams();
    if (this.kUU)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165876);
      this.kUK.setLayoutParams(localLayoutParams);
      if (!this.kUU) {
        break label109;
      }
    }
    label109:
    for (int i = getResources().getDimensionPixelSize(2131165877);; i = getResources().getDimensionPixelSize(2131165868))
    {
      this.kUK.setPadding(0, 0, i, 0);
      if (this.kUQ != null) {
        this.kUQ.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(194594);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165867);
      break;
    }
  }
  
  private boolean bkW()
  {
    AppMethodBeat.i(194597);
    if (this.kUS == null)
    {
      ac.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(194597);
      return false;
    }
    int k = this.kUS.bjh();
    int j = this.kUS.bji();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(194597);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(194597);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUL.getLayoutParams();
      localLayoutParams.width = i;
      this.kUL.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(194597);
      return true;
      d = k;
    }
  }
  
  private void bkX()
  {
    int j = 0;
    AppMethodBeat.i(194604);
    boolean bool;
    Object localObject;
    if (this.kUY)
    {
      bool = this.kUX;
      localObject = this.kUM;
      if (!bool) {
        break label84;
      }
      i = 0;
      label31:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.kUx;
      if (!bool) {
        break label90;
      }
      i = 0;
      label49:
      ((TextView)localObject).setVisibility(i);
      localObject = this.kUy;
      if (!bool) {
        break label96;
      }
    }
    label84:
    label90:
    label96:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      AppMethodBeat.o(194604);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
      i = 8;
      break label49;
    }
  }
  
  private void dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194605);
    if (this.kVc != null) {
      this.kVc.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(194605);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(194607);
    this.kVd.add(paramf);
    AppMethodBeat.o(194607);
  }
  
  public final void bha()
  {
    AppMethodBeat.i(194590);
    this.kUU = false;
    bkS();
    AppMethodBeat.o(194590);
  }
  
  public final void biZ()
  {
    AppMethodBeat.i(194574);
    if ((this.kUZ) && (this.kVa)) {
      this.kUO.setVisibility(8);
    }
    AppMethodBeat.o(194574);
  }
  
  public final void bjA()
  {
    AppMethodBeat.i(194595);
    if (this.kOQ == null) {
      this.kOQ = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(194559);
          if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this))
          {
            AppMethodBeat.o(194559);
            return false;
          }
          AppMethodBeat.o(194559);
          return true;
        }
      }, true);
    }
    bkW();
    this.kOQ.stopTimer();
    this.kOQ.au(500L, 500L);
    AppMethodBeat.o(194595);
  }
  
  public final void bjB()
  {
    AppMethodBeat.i(194596);
    if (this.kOQ != null) {
      this.kOQ.stopTimer();
    }
    AppMethodBeat.o(194596);
  }
  
  public final void bjC()
  {
    AppMethodBeat.i(194585);
    if (this.kUT != null)
    {
      this.kUT.stopTimer();
      this.kUT.au(7000L, 7000L);
    }
    AppMethodBeat.o(194585);
  }
  
  public final void bjD()
  {
    AppMethodBeat.i(194575);
    if ((this.kUZ) && (this.kVa)) {
      this.kUO.setVisibility(0);
    }
    AppMethodBeat.o(194575);
  }
  
  public final boolean bjE()
  {
    AppMethodBeat.i(194603);
    if (this.kUM != null)
    {
      if ((getVisibility() == 0) && (this.kUM.getVisibility() == 0))
      {
        AppMethodBeat.o(194603);
        return true;
      }
      AppMethodBeat.o(194603);
      return false;
    }
    AppMethodBeat.o(194603);
    return false;
  }
  
  public final boolean bjt()
  {
    return this.kUV;
  }
  
  public final void bju()
  {
    AppMethodBeat.i(194588);
    if (bjw())
    {
      setVisibility(8);
      AppMethodBeat.o(194588);
      return;
    }
    bjv();
    AppMethodBeat.o(194588);
  }
  
  public final void bjv()
  {
    AppMethodBeat.i(194584);
    setVisibility(0);
    if (!this.kVb)
    {
      AppMethodBeat.o(194584);
      return;
    }
    if (this.kUT == null) {
      this.kUT = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(194558);
          AppBrandVideoViewControlBar.this.setVisibility(8);
          AppBrandVideoViewControlBar.c(AppBrandVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(194558);
          return false;
        }
      }, false);
    }
    this.kUT.stopTimer();
    this.kUT.au(7000L, 7000L);
    AppMethodBeat.o(194584);
  }
  
  public final boolean bjw()
  {
    AppMethodBeat.i(194587);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(194587);
      return true;
    }
    AppMethodBeat.o(194587);
    return false;
  }
  
  public final void bjx()
  {
    AppMethodBeat.i(194589);
    this.kUU = true;
    bkS();
    AppMethodBeat.o(194589);
  }
  
  public final boolean bjy()
  {
    return this.kUU;
  }
  
  public final boolean bjz()
  {
    return this.kVb;
  }
  
  public final void bkN()
  {
    AppMethodBeat.i(194599);
    if (this.kUz == 0)
    {
      AppMethodBeat.o(194599);
      return;
    }
    if (this.kwq)
    {
      AppMethodBeat.o(194599);
      return;
    }
    if (this.kUv == null)
    {
      AppMethodBeat.o(194599);
      return;
    }
    this.kUx.setText(sO(this.mPosition / 60) + ":" + sO(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(194599);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUv.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = dY(this.mPosition, i);
    this.kUv.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kUt.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.kUz * i));
    this.kUt.setLayoutParams(localLayoutParams);
    requestLayout();
    dX(this.mPosition, this.kUz);
    AppMethodBeat.o(194599);
  }
  
  protected int getLayoutId()
  {
    return 2131493075;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(194586);
    setVisibility(8);
    AppMethodBeat.o(194586);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(194564);
    super.init();
    this.kUI = ((ImageView)this.contentView.findViewById(2131300325));
    this.kUJ = ((ImageView)this.contentView.findViewById(2131298919));
    this.kUL = ((ImageView)this.contentView.findViewById(2131303303));
    this.kUM = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.kUK = ((LinearLayout)findViewById(2131304239));
    this.kUN = ((ImageView)findViewById(2131302621));
    this.kUO = ((ImageView)findViewById(2131297935));
    this.kUP = ((ImageView)findViewById(2131299599));
    this.awK = ((TextView)findViewById(2131305902));
    this.kUQ = ((LinearLayout)findViewById(2131300332));
    this.kUR = ((LinearLayout)findViewById(2131303300));
    AppMethodBeat.o(194564);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(194563);
    if (this.kOQ != null) {
      this.kOQ.stopTimer();
    }
    if (this.kUT != null) {
      this.kUT.stopTimer();
    }
    AppMethodBeat.o(194563);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(194598);
    super.seek(paramInt);
    dX(this.mPosition, this.kUz);
    AppMethodBeat.o(194598);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.kVb = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(final e.g paramg)
  {
    AppMethodBeat.i(194579);
    this.kUJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194557);
        AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
        if (paramg != null) {
          paramg.gK(AppBrandVideoViewControlBar.b(AppBrandVideoViewControlBar.this));
        }
        AppMethodBeat.o(194557);
      }
    });
    AppMethodBeat.o(194579);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(194580);
    this.kUV = paramBoolean;
    bkQ();
    AppMethodBeat.o(194580);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194566);
    this.kUP.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194566);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194578);
    this.kUI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194578);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(194577);
    this.dhM = paramBoolean;
    if (this.dhM)
    {
      this.kUw.setImageResource(2131689675);
      this.kUO.setImageResource(2131689675);
      AppMethodBeat.o(194577);
      return;
    }
    this.kUw.setImageResource(2131689676);
    this.kUO.setImageResource(2131689676);
    AppMethodBeat.o(194577);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194565);
    this.kUN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194565);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(194570);
    if (paramBoolean)
    {
      this.kUN.setImageResource(2131689671);
      AppMethodBeat.o(194570);
      return;
    }
    this.kUN.setImageResource(2131689672);
    AppMethodBeat.o(194570);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194567);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.kUO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194567);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.kVc = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(194573);
    this.kVa = paramBoolean;
    bkP();
    AppMethodBeat.o(194573);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(194571);
    this.kUY = paramBoolean;
    bkX();
    AppMethodBeat.o(194571);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194583);
    if (paramBoolean)
    {
      this.kUJ.setVisibility(0);
      AppMethodBeat.o(194583);
      return;
    }
    this.kUJ.setVisibility(8);
    AppMethodBeat.o(194583);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194600);
    this.kUW = paramBoolean;
    bkR();
    bkO();
    AppMethodBeat.o(194600);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194569);
    ImageView localImageView = this.kUN;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(194569);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194601);
    this.kUZ = paramBoolean;
    bkP();
    AppMethodBeat.o(194601);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(194602);
    this.kUX = paramBoolean;
    bkX();
    AppMethodBeat.o(194602);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.kUS = parami;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(194568);
    if (!bs.isNullOrNil(paramString)) {
      this.awK.setText(paramString);
    }
    AppMethodBeat.o(194568);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(194606);
    super.setVisibility(paramInt);
    Iterator localIterator;
    e.f localf;
    if (paramInt == 0)
    {
      localIterator = this.kVd.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(194606);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.kVd.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(194606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */