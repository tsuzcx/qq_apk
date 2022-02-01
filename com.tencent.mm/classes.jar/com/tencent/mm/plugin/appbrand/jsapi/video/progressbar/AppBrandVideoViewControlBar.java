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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
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
  private TextView ayB;
  private av llt;
  private ImageView lrG;
  private ImageView lrH;
  private LinearLayout lrI;
  private ImageView lrJ;
  private FrameLayout lrK;
  private ImageView lrL;
  private ImageView lrM;
  private ImageView lrN;
  private LinearLayout lrO;
  private LinearLayout lrP;
  private e.i lrQ;
  private av lrR;
  private boolean lrS;
  private boolean lrT;
  private boolean lrU;
  private boolean lrV;
  private boolean lrW;
  private boolean lrX;
  private boolean lrY;
  private boolean lrZ;
  private e.e lsa;
  private ConcurrentLinkedQueue<e.f> lsb;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206372);
    this.lrZ = true;
    this.lsb = new ConcurrentLinkedQueue();
    AppMethodBeat.o(206372);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206373);
    this.lrZ = true;
    this.lsb = new ConcurrentLinkedQueue();
    AppMethodBeat.o(206373);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206374);
    this.lrZ = true;
    this.lsb = new ConcurrentLinkedQueue();
    AppMethodBeat.o(206374);
  }
  
  private void boA()
  {
    AppMethodBeat.i(206388);
    if (this.lrX)
    {
      if (this.lrY)
      {
        this.lru.setVisibility(8);
        this.lrM.setVisibility(0);
        AppMethodBeat.o(206388);
        return;
      }
      this.lru.setVisibility(0);
      this.lrM.setVisibility(8);
      AppMethodBeat.o(206388);
      return;
    }
    this.lru.setVisibility(8);
    this.lrM.setVisibility(8);
    AppMethodBeat.o(206388);
  }
  
  private void boB()
  {
    AppMethodBeat.i(206393);
    if (this.lrT)
    {
      this.lrH.setImageResource(2131689662);
      AppMethodBeat.o(206393);
      return;
    }
    this.lrH.setImageResource(2131689661);
    AppMethodBeat.o(206393);
  }
  
  private void boC()
  {
    AppMethodBeat.i(206394);
    if (this.lrU)
    {
      this.lrG.setVisibility(0);
      if (this.lrS)
      {
        this.lrG.setImageResource(2131689667);
        AppMethodBeat.o(206394);
        return;
      }
      this.lrG.setImageResource(2131689664);
      AppMethodBeat.o(206394);
      return;
    }
    this.lrG.setVisibility(8);
    AppMethodBeat.o(206394);
  }
  
  private void boD()
  {
    AppMethodBeat.i(206403);
    boG();
    boC();
    boz();
    boF();
    boE();
    AppMethodBeat.o(206403);
  }
  
  private void boE()
  {
    AppMethodBeat.i(206404);
    if (this.lrS) {}
    for (int i = getResources().getDimensionPixelSize(2131165875);; i = getResources().getDimensionPixelSize(2131165865))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.lru != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lru.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lru.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lrP != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lrP.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lrP.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lrH != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lrH.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lrH.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lrL != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lrL.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lrL.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lrG != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lrG.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lrG.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(206404);
      return;
    }
  }
  
  private void boF()
  {
    AppMethodBeat.i(206405);
    if (this.lrS) {}
    for (float f = getResources().getDimensionPixelSize(2131165878);; f = getResources().getDimensionPixelSize(2131165871))
    {
      this.lrv.setTextSize(0, f);
      this.lrw.setTextSize(0, f);
      AppMethodBeat.o(206405);
      return;
    }
  }
  
  private void boG()
  {
    AppMethodBeat.i(206406);
    ViewGroup.LayoutParams localLayoutParams = this.lrI.getLayoutParams();
    if (this.lrS)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165876);
      this.lrI.setLayoutParams(localLayoutParams);
      if (!this.lrS) {
        break label109;
      }
    }
    label109:
    for (int i = getResources().getDimensionPixelSize(2131165877);; i = getResources().getDimensionPixelSize(2131165868))
    {
      this.lrI.setPadding(0, 0, i, 0);
      if (this.lrO != null) {
        this.lrO.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(206406);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165867);
      break;
    }
  }
  
  private boolean boH()
  {
    AppMethodBeat.i(206409);
    if (this.lrQ == null)
    {
      ad.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(206409);
      return false;
    }
    int k = this.lrQ.bmT();
    int j = this.lrQ.bmU();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(206409);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(206409);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrJ.getLayoutParams();
      localLayoutParams.width = i;
      this.lrJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(206409);
      return true;
      d = k;
    }
  }
  
  private void boI()
  {
    int j = 0;
    AppMethodBeat.i(206416);
    boolean bool;
    Object localObject;
    if (this.lrW)
    {
      bool = this.lrV;
      localObject = this.lrK;
      if (!bool) {
        break label84;
      }
      i = 0;
      label31:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.lrv;
      if (!bool) {
        break label90;
      }
      i = 0;
      label49:
      ((TextView)localObject).setVisibility(i);
      localObject = this.lrw;
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
      AppMethodBeat.o(206416);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
      i = 8;
      break label49;
    }
  }
  
  private void boz()
  {
    AppMethodBeat.i(206384);
    if (this.lrS)
    {
      this.lrO.setVisibility(0);
      AppMethodBeat.o(206384);
      return;
    }
    this.lrO.setVisibility(8);
    AppMethodBeat.o(206384);
  }
  
  private void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206417);
    if (this.lsa != null) {
      this.lsa.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(206417);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(206419);
    this.lsb.add(paramf);
    AppMethodBeat.o(206419);
  }
  
  public final void bkF()
  {
    AppMethodBeat.i(206402);
    this.lrS = false;
    boD();
    AppMethodBeat.o(206402);
  }
  
  public final void bmL()
  {
    AppMethodBeat.i(206386);
    if ((this.lrX) && (this.lrY)) {
      this.lrM.setVisibility(8);
    }
    AppMethodBeat.o(206386);
  }
  
  public final boolean bnf()
  {
    return this.lrT;
  }
  
  public final void bng()
  {
    AppMethodBeat.i(206400);
    if (bni())
    {
      setVisibility(8);
      AppMethodBeat.o(206400);
      return;
    }
    bnh();
    AppMethodBeat.o(206400);
  }
  
  public final void bnh()
  {
    AppMethodBeat.i(206396);
    setVisibility(0);
    if (!this.lrZ)
    {
      AppMethodBeat.o(206396);
      return;
    }
    if (this.lrR == null) {
      this.lrR = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(206370);
          AppBrandVideoViewControlBar.this.setVisibility(8);
          AppBrandVideoViewControlBar.c(AppBrandVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(206370);
          return false;
        }
      }, false);
    }
    this.lrR.stopTimer();
    this.lrR.az(7000L, 7000L);
    AppMethodBeat.o(206396);
  }
  
  public final boolean bni()
  {
    AppMethodBeat.i(206399);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(206399);
      return true;
    }
    AppMethodBeat.o(206399);
    return false;
  }
  
  public final void bnj()
  {
    AppMethodBeat.i(206401);
    this.lrS = true;
    boD();
    AppMethodBeat.o(206401);
  }
  
  public final boolean bnk()
  {
    return this.lrS;
  }
  
  public final boolean bnl()
  {
    return this.lrZ;
  }
  
  public final void bnm()
  {
    AppMethodBeat.i(206407);
    if (this.llt == null) {
      this.llt = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(206371);
          if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this))
          {
            AppMethodBeat.o(206371);
            return false;
          }
          AppMethodBeat.o(206371);
          return true;
        }
      }, true);
    }
    boH();
    this.llt.stopTimer();
    this.llt.az(500L, 500L);
    AppMethodBeat.o(206407);
  }
  
  public final void bnn()
  {
    AppMethodBeat.i(206408);
    if (this.llt != null) {
      this.llt.stopTimer();
    }
    AppMethodBeat.o(206408);
  }
  
  public final void bno()
  {
    AppMethodBeat.i(206397);
    if (this.lrR != null)
    {
      this.lrR.stopTimer();
      this.lrR.az(7000L, 7000L);
    }
    AppMethodBeat.o(206397);
  }
  
  public final void bnp()
  {
    AppMethodBeat.i(206387);
    if ((this.lrX) && (this.lrY)) {
      this.lrM.setVisibility(0);
    }
    AppMethodBeat.o(206387);
  }
  
  public final boolean bnq()
  {
    AppMethodBeat.i(206415);
    if (this.lrK != null)
    {
      if ((getVisibility() == 0) && (this.lrK.getVisibility() == 0))
      {
        AppMethodBeat.o(206415);
        return true;
      }
      AppMethodBeat.o(206415);
      return false;
    }
    AppMethodBeat.o(206415);
    return false;
  }
  
  public final void boy()
  {
    AppMethodBeat.i(206411);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(206411);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(206411);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(206411);
      return;
    }
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(206411);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrt.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = ea(this.mPosition, i);
    this.lrt.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lrx * i));
    this.lrr.setLayoutParams(localLayoutParams);
    requestLayout();
    dZ(this.mPosition, this.lrx);
    AppMethodBeat.o(206411);
  }
  
  protected int getLayoutId()
  {
    return 2131493075;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(206398);
    setVisibility(8);
    AppMethodBeat.o(206398);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(206376);
    super.init();
    this.lrG = ((ImageView)this.contentView.findViewById(2131300325));
    this.lrH = ((ImageView)this.contentView.findViewById(2131298919));
    this.lrJ = ((ImageView)this.contentView.findViewById(2131303303));
    this.lrK = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.lrI = ((LinearLayout)findViewById(2131304239));
    this.lrL = ((ImageView)findViewById(2131302621));
    this.lrM = ((ImageView)findViewById(2131297935));
    this.lrN = ((ImageView)findViewById(2131299599));
    this.ayB = ((TextView)findViewById(2131305902));
    this.lrO = ((LinearLayout)findViewById(2131300332));
    this.lrP = ((LinearLayout)findViewById(2131303300));
    AppMethodBeat.o(206376);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206375);
    if (this.llt != null) {
      this.llt.stopTimer();
    }
    if (this.lrR != null) {
      this.lrR.stopTimer();
    }
    AppMethodBeat.o(206375);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(206410);
    super.seek(paramInt);
    dZ(this.mPosition, this.lrx);
    AppMethodBeat.o(206410);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.lrZ = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(final e.g paramg)
  {
    AppMethodBeat.i(206391);
    this.lrH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(206369);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
        if (paramg != null) {
          paramg.gR(AppBrandVideoViewControlBar.b(AppBrandVideoViewControlBar.this));
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206369);
      }
    });
    AppMethodBeat.o(206391);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(206392);
    this.lrT = paramBoolean;
    boB();
    AppMethodBeat.o(206392);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206378);
    this.lrN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(206378);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206390);
    this.lrG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(206390);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(206389);
    this.dtk = paramBoolean;
    if (this.dtk)
    {
      this.lru.setImageResource(2131689675);
      this.lrM.setImageResource(2131689675);
      AppMethodBeat.o(206389);
      return;
    }
    this.lru.setImageResource(2131689676);
    this.lrM.setImageResource(2131689676);
    AppMethodBeat.o(206389);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206377);
    this.lrL.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(206377);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(206382);
    if (paramBoolean)
    {
      this.lrL.setImageResource(2131689671);
      AppMethodBeat.o(206382);
      return;
    }
    this.lrL.setImageResource(2131689672);
    AppMethodBeat.o(206382);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206379);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.lrM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(206379);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.lsa = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(206385);
    this.lrY = paramBoolean;
    boA();
    AppMethodBeat.o(206385);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(206383);
    this.lrW = paramBoolean;
    boI();
    AppMethodBeat.o(206383);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(206395);
    if (paramBoolean)
    {
      this.lrH.setVisibility(0);
      AppMethodBeat.o(206395);
      return;
    }
    this.lrH.setVisibility(8);
    AppMethodBeat.o(206395);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(206412);
    this.lrU = paramBoolean;
    boC();
    boz();
    AppMethodBeat.o(206412);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(206381);
    ImageView localImageView = this.lrL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(206381);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(206413);
    this.lrX = paramBoolean;
    boA();
    AppMethodBeat.o(206413);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(206414);
    this.lrV = paramBoolean;
    boI();
    AppMethodBeat.o(206414);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.lrQ = parami;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(206380);
    if (!bt.isNullOrNil(paramString)) {
      this.ayB.setText(paramString);
    }
    AppMethodBeat.o(206380);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(206418);
    super.setVisibility(paramInt);
    Iterator localIterator;
    e.f localf;
    if (paramInt == 0)
    {
      localIterator = this.lsb.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(206418);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.lsb.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(206418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */