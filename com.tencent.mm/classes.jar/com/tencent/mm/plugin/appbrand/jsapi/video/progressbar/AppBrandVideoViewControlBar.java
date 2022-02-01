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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandVideoViewControlBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private TextView avQ;
  private av krU;
  private ImageView ktA;
  private LinearLayout ktB;
  private LinearLayout ktC;
  private e.i ktD;
  private av ktE;
  private boolean ktF;
  private boolean ktG;
  private boolean ktH;
  private boolean ktI;
  private boolean ktJ;
  private boolean ktK;
  private boolean ktL;
  private boolean ktM;
  private e.e ktN;
  private ConcurrentLinkedQueue<e.f> ktO;
  private ImageView ktt;
  private ImageView ktu;
  private LinearLayout ktv;
  private ImageView ktw;
  private FrameLayout ktx;
  private ImageView kty;
  private ImageView ktz;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194215);
    this.ktM = true;
    this.ktO = new ConcurrentLinkedQueue();
    AppMethodBeat.o(194215);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194216);
    this.ktM = true;
    this.ktO = new ConcurrentLinkedQueue();
    AppMethodBeat.o(194216);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194217);
    this.ktM = true;
    this.ktO = new ConcurrentLinkedQueue();
    AppMethodBeat.o(194217);
  }
  
  private void bdU()
  {
    AppMethodBeat.i(194227);
    if (this.ktF)
    {
      this.ktB.setVisibility(0);
      AppMethodBeat.o(194227);
      return;
    }
    this.ktB.setVisibility(8);
    AppMethodBeat.o(194227);
  }
  
  private void bdV()
  {
    AppMethodBeat.i(194231);
    if (this.ktK)
    {
      if (this.ktL)
      {
        this.kth.setVisibility(8);
        this.ktz.setVisibility(0);
        AppMethodBeat.o(194231);
        return;
      }
      this.kth.setVisibility(0);
      this.ktz.setVisibility(8);
      AppMethodBeat.o(194231);
      return;
    }
    this.kth.setVisibility(8);
    this.ktz.setVisibility(8);
    AppMethodBeat.o(194231);
  }
  
  private void bdW()
  {
    AppMethodBeat.i(194236);
    if (this.ktG)
    {
      this.ktu.setImageResource(2131689662);
      AppMethodBeat.o(194236);
      return;
    }
    this.ktu.setImageResource(2131689661);
    AppMethodBeat.o(194236);
  }
  
  private void bdX()
  {
    AppMethodBeat.i(194237);
    if (this.ktH)
    {
      this.ktt.setVisibility(0);
      if (this.ktF)
      {
        this.ktt.setImageResource(2131689667);
        AppMethodBeat.o(194237);
        return;
      }
      this.ktt.setImageResource(2131689664);
      AppMethodBeat.o(194237);
      return;
    }
    this.ktt.setVisibility(8);
    AppMethodBeat.o(194237);
  }
  
  private void bdY()
  {
    AppMethodBeat.i(194246);
    beb();
    bdX();
    bdU();
    bea();
    bdZ();
    AppMethodBeat.o(194246);
  }
  
  private void bdZ()
  {
    AppMethodBeat.i(194247);
    if (this.ktF) {}
    for (int i = getResources().getDimensionPixelSize(2131165875);; i = getResources().getDimensionPixelSize(2131165865))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.kth != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kth.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kth.setLayoutParams(localMarginLayoutParams);
      }
      if (this.ktC != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ktC.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.ktC.setLayoutParams(localMarginLayoutParams);
      }
      if (this.ktu != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ktu.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.ktu.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kty != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kty.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kty.setLayoutParams(localMarginLayoutParams);
      }
      if (this.ktt != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ktt.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.ktt.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(194247);
      return;
    }
  }
  
  private void bea()
  {
    AppMethodBeat.i(194248);
    if (this.ktF) {}
    for (float f = getResources().getDimensionPixelSize(2131165878);; f = getResources().getDimensionPixelSize(2131165871))
    {
      this.kti.setTextSize(0, f);
      this.ktj.setTextSize(0, f);
      AppMethodBeat.o(194248);
      return;
    }
  }
  
  private void beb()
  {
    AppMethodBeat.i(194249);
    ViewGroup.LayoutParams localLayoutParams = this.ktv.getLayoutParams();
    if (this.ktF)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165876);
      this.ktv.setLayoutParams(localLayoutParams);
      if (!this.ktF) {
        break label109;
      }
    }
    label109:
    for (int i = getResources().getDimensionPixelSize(2131165877);; i = getResources().getDimensionPixelSize(2131165868))
    {
      this.ktv.setPadding(0, 0, i, 0);
      if (this.ktB != null) {
        this.ktB.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(194249);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165867);
      break;
    }
  }
  
  private boolean bec()
  {
    AppMethodBeat.i(194252);
    if (this.ktD == null)
    {
      ad.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(194252);
      return false;
    }
    int k = this.ktD.bcl();
    int j = this.ktD.bcm();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(194252);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(194252);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktw.getLayoutParams();
      localLayoutParams.width = i;
      this.ktw.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(194252);
      return true;
      d = k;
    }
  }
  
  private void bed()
  {
    int j = 0;
    AppMethodBeat.i(194259);
    boolean bool;
    Object localObject;
    if (this.ktJ)
    {
      bool = this.ktI;
      localObject = this.ktx;
      if (!bool) {
        break label84;
      }
      i = 0;
      label31:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.kti;
      if (!bool) {
        break label90;
      }
      i = 0;
      label49:
      ((TextView)localObject).setVisibility(i);
      localObject = this.ktj;
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
      AppMethodBeat.o(194259);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
      i = 8;
      break label49;
    }
  }
  
  private void dW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194260);
    if (this.ktN != null) {
      this.ktN.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(194260);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(194262);
    this.ktO.add(paramf);
    AppMethodBeat.o(194262);
  }
  
  public final void bah()
  {
    AppMethodBeat.i(194245);
    this.ktF = false;
    bdY();
    AppMethodBeat.o(194245);
  }
  
  public final void bcA()
  {
    AppMethodBeat.i(194239);
    setVisibility(0);
    if (!this.ktM)
    {
      AppMethodBeat.o(194239);
      return;
    }
    if (this.ktE == null) {
      this.ktE = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(194213);
          AppBrandVideoViewControlBar.this.setVisibility(8);
          AppBrandVideoViewControlBar.c(AppBrandVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(194213);
          return false;
        }
      }, false);
    }
    this.ktE.stopTimer();
    this.ktE.av(7000L, 7000L);
    AppMethodBeat.o(194239);
  }
  
  public final boolean bcB()
  {
    AppMethodBeat.i(194242);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(194242);
      return true;
    }
    AppMethodBeat.o(194242);
    return false;
  }
  
  public final void bcC()
  {
    AppMethodBeat.i(194244);
    this.ktF = true;
    bdY();
    AppMethodBeat.o(194244);
  }
  
  public final boolean bcD()
  {
    return this.ktF;
  }
  
  public final boolean bcE()
  {
    return this.ktM;
  }
  
  public final void bcF()
  {
    AppMethodBeat.i(194250);
    if (this.krU == null) {
      this.krU = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(194214);
          if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this))
          {
            AppMethodBeat.o(194214);
            return false;
          }
          AppMethodBeat.o(194214);
          return true;
        }
      }, true);
    }
    bec();
    this.krU.stopTimer();
    this.krU.av(500L, 500L);
    AppMethodBeat.o(194250);
  }
  
  public final void bcG()
  {
    AppMethodBeat.i(194251);
    if (this.krU != null) {
      this.krU.stopTimer();
    }
    AppMethodBeat.o(194251);
  }
  
  public final void bcH()
  {
    AppMethodBeat.i(194240);
    if (this.ktE != null)
    {
      this.ktE.stopTimer();
      this.ktE.av(7000L, 7000L);
    }
    AppMethodBeat.o(194240);
  }
  
  public final void bcI()
  {
    AppMethodBeat.i(194230);
    if ((this.ktK) && (this.ktL)) {
      this.ktz.setVisibility(0);
    }
    AppMethodBeat.o(194230);
  }
  
  public final boolean bcJ()
  {
    AppMethodBeat.i(194258);
    if (this.ktx != null)
    {
      if ((getVisibility() == 0) && (this.ktx.getVisibility() == 0))
      {
        AppMethodBeat.o(194258);
        return true;
      }
      AppMethodBeat.o(194258);
      return false;
    }
    AppMethodBeat.o(194258);
    return false;
  }
  
  public final void bce()
  {
    AppMethodBeat.i(194229);
    if ((this.ktK) && (this.ktL)) {
      this.ktz.setVisibility(8);
    }
    AppMethodBeat.o(194229);
  }
  
  public final boolean bcy()
  {
    return this.ktG;
  }
  
  public final void bcz()
  {
    AppMethodBeat.i(194243);
    if (bcB())
    {
      setVisibility(8);
      AppMethodBeat.o(194243);
      return;
    }
    bcA();
    AppMethodBeat.o(194243);
  }
  
  public final void bdT()
  {
    AppMethodBeat.i(194254);
    if (this.ktk == 0)
    {
      AppMethodBeat.o(194254);
      return;
    }
    if (this.jVE)
    {
      AppMethodBeat.o(194254);
      return;
    }
    if (this.ktg == null)
    {
      AppMethodBeat.o(194254);
      return;
    }
    this.kti.setText(rX(this.mPosition / 60) + ":" + rX(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(194254);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktg.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = dX(this.mPosition, i);
    this.ktg.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.ktk * i));
    this.kte.setLayoutParams(localLayoutParams);
    requestLayout();
    dW(this.mPosition, this.ktk);
    AppMethodBeat.o(194254);
  }
  
  protected int getLayoutId()
  {
    return 2131493075;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(194241);
    setVisibility(8);
    AppMethodBeat.o(194241);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(194219);
    super.init();
    this.ktt = ((ImageView)this.contentView.findViewById(2131300325));
    this.ktu = ((ImageView)this.contentView.findViewById(2131298919));
    this.ktw = ((ImageView)this.contentView.findViewById(2131303303));
    this.ktx = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.ktv = ((LinearLayout)findViewById(2131304239));
    this.kty = ((ImageView)findViewById(2131302621));
    this.ktz = ((ImageView)findViewById(2131297935));
    this.ktA = ((ImageView)findViewById(2131299599));
    this.avQ = ((TextView)findViewById(2131305902));
    this.ktB = ((LinearLayout)findViewById(2131300332));
    this.ktC = ((LinearLayout)findViewById(2131303300));
    AppMethodBeat.o(194219);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(194218);
    if (this.krU != null) {
      this.krU.stopTimer();
    }
    if (this.ktE != null) {
      this.ktE.stopTimer();
    }
    AppMethodBeat.o(194218);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(194253);
    super.seek(paramInt);
    dW(this.mPosition, this.ktk);
    AppMethodBeat.o(194253);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.ktM = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(final e.g paramg)
  {
    AppMethodBeat.i(194234);
    this.ktu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194212);
        AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
        if (paramg != null) {
          paramg.go(AppBrandVideoViewControlBar.b(AppBrandVideoViewControlBar.this));
        }
        AppMethodBeat.o(194212);
      }
    });
    AppMethodBeat.o(194234);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(194235);
    this.ktG = paramBoolean;
    bdW();
    AppMethodBeat.o(194235);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194221);
    this.ktA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194221);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194233);
    this.ktt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194233);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(194232);
    this.dkr = paramBoolean;
    if (this.dkr)
    {
      this.kth.setImageResource(2131689675);
      this.ktz.setImageResource(2131689675);
      AppMethodBeat.o(194232);
      return;
    }
    this.kth.setImageResource(2131689676);
    this.ktz.setImageResource(2131689676);
    AppMethodBeat.o(194232);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194220);
    this.kty.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194220);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(194225);
    if (paramBoolean)
    {
      this.kty.setImageResource(2131689671);
      AppMethodBeat.o(194225);
      return;
    }
    this.kty.setImageResource(2131689672);
    AppMethodBeat.o(194225);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194222);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.ktz.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(194222);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.ktN = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(194228);
    this.ktL = paramBoolean;
    bdV();
    AppMethodBeat.o(194228);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(194226);
    this.ktJ = paramBoolean;
    bed();
    AppMethodBeat.o(194226);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194238);
    if (paramBoolean)
    {
      this.ktu.setVisibility(0);
      AppMethodBeat.o(194238);
      return;
    }
    this.ktu.setVisibility(8);
    AppMethodBeat.o(194238);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194255);
    this.ktH = paramBoolean;
    bdX();
    bdU();
    AppMethodBeat.o(194255);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194224);
    ImageView localImageView = this.kty;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(194224);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(194256);
    this.ktK = paramBoolean;
    bdV();
    AppMethodBeat.o(194256);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(194257);
    this.ktI = paramBoolean;
    bed();
    AppMethodBeat.o(194257);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.ktD = parami;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(194223);
    if (!bt.isNullOrNil(paramString)) {
      this.avQ.setText(paramString);
    }
    AppMethodBeat.o(194223);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(194261);
    super.setVisibility(paramInt);
    Iterator localIterator;
    e.f localf;
    if (paramInt == 0)
    {
      localIterator = this.ktO.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(194261);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.ktO.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(194261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */