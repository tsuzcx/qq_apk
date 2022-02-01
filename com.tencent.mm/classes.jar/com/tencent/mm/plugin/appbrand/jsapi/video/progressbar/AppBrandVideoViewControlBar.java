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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandVideoViewControlBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private TextView ayz;
  private ImageView mDc;
  private ImageView mDd;
  private LinearLayout mDe;
  private ImageView mDf;
  private FrameLayout mDg;
  private ImageView mDh;
  private ImageView mDi;
  private ImageView mDj;
  private LinearLayout mDk;
  private LinearLayout mDl;
  private e.i mDm;
  private MTimerHandler mDn;
  private boolean mDo;
  private boolean mDp;
  private boolean mDq;
  private boolean mDr;
  private boolean mDs;
  private boolean mDt;
  private boolean mDu;
  private boolean mDv;
  private e.e mDw;
  private ConcurrentLinkedQueue<e.f> mDx;
  private MTimerHandler mww;
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(235079);
    this.mDv = true;
    this.mDx = new ConcurrentLinkedQueue();
    AppMethodBeat.o(235079);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235080);
    this.mDv = true;
    this.mDx = new ConcurrentLinkedQueue();
    AppMethodBeat.o(235080);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235081);
    this.mDv = true;
    this.mDx = new ConcurrentLinkedQueue();
    AppMethodBeat.o(235081);
  }
  
  private void bKP()
  {
    AppMethodBeat.i(235091);
    if (this.mDo)
    {
      this.mDk.setVisibility(0);
      AppMethodBeat.o(235091);
      return;
    }
    this.mDk.setVisibility(8);
    AppMethodBeat.o(235091);
  }
  
  private void bKQ()
  {
    AppMethodBeat.i(235095);
    if (this.mDt)
    {
      if (this.mDu)
      {
        this.mCP.setVisibility(8);
        this.mDi.setVisibility(0);
        AppMethodBeat.o(235095);
        return;
      }
      this.mCP.setVisibility(0);
      this.mDi.setVisibility(8);
      AppMethodBeat.o(235095);
      return;
    }
    this.mCP.setVisibility(8);
    this.mDi.setVisibility(8);
    AppMethodBeat.o(235095);
  }
  
  private void bKR()
  {
    AppMethodBeat.i(235100);
    if (this.mDp)
    {
      this.mDd.setImageResource(2131689667);
      AppMethodBeat.o(235100);
      return;
    }
    this.mDd.setImageResource(2131689666);
    AppMethodBeat.o(235100);
  }
  
  private void bKS()
  {
    AppMethodBeat.i(235101);
    if (this.mDq)
    {
      this.mDc.setVisibility(0);
      if (this.mDo)
      {
        this.mDc.setImageResource(2131689672);
        AppMethodBeat.o(235101);
        return;
      }
      this.mDc.setImageResource(2131689669);
      AppMethodBeat.o(235101);
      return;
    }
    this.mDc.setVisibility(8);
    AppMethodBeat.o(235101);
  }
  
  private void bKT()
  {
    AppMethodBeat.i(235110);
    bKW();
    bKS();
    bKP();
    bKV();
    bKU();
    AppMethodBeat.o(235110);
  }
  
  private void bKU()
  {
    AppMethodBeat.i(235111);
    if (this.mDo) {}
    for (int i = getResources().getDimensionPixelSize(2131165901);; i = getResources().getDimensionPixelSize(2131165891))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.mCP != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mCP.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mCP.setLayoutParams(localMarginLayoutParams);
      }
      if (this.mDl != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mDl.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mDl.setLayoutParams(localMarginLayoutParams);
      }
      if (this.mDd != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mDd.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mDd.setLayoutParams(localMarginLayoutParams);
      }
      if (this.mDh != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mDh.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mDh.setLayoutParams(localMarginLayoutParams);
      }
      if (this.mDc != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mDc.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mDc.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(235111);
      return;
    }
  }
  
  private void bKV()
  {
    AppMethodBeat.i(235112);
    if (this.mDo) {}
    for (float f = getResources().getDimensionPixelSize(2131165904);; f = getResources().getDimensionPixelSize(2131165897))
    {
      this.mCQ.setTextSize(0, f);
      this.mCR.setTextSize(0, f);
      AppMethodBeat.o(235112);
      return;
    }
  }
  
  private void bKW()
  {
    AppMethodBeat.i(235113);
    ViewGroup.LayoutParams localLayoutParams = this.mDe.getLayoutParams();
    if (this.mDo)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165902);
      this.mDe.setLayoutParams(localLayoutParams);
      if (!this.mDo) {
        break label109;
      }
    }
    label109:
    for (int i = getResources().getDimensionPixelSize(2131165903);; i = getResources().getDimensionPixelSize(2131165894))
    {
      this.mDe.setPadding(0, 0, i, 0);
      if (this.mDk != null) {
        this.mDk.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(235113);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165893);
      break;
    }
  }
  
  private boolean bKX()
  {
    AppMethodBeat.i(235116);
    if (this.mDm == null)
    {
      Log.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(235116);
      return false;
    }
    int k = this.mDm.bJh();
    int j = this.mDm.bJi();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(235116);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(235116);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mDf.getLayoutParams();
      localLayoutParams.width = i;
      this.mDf.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(235116);
      return true;
      d = k;
    }
  }
  
  private void bKY()
  {
    int j = 0;
    AppMethodBeat.i(235123);
    boolean bool;
    Object localObject;
    if (this.mDs)
    {
      bool = this.mDr;
      localObject = this.mDg;
      if (!bool) {
        break label84;
      }
      i = 0;
      label31:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.mCQ;
      if (!bool) {
        break label90;
      }
      i = 0;
      label49:
      ((TextView)localObject).setVisibility(i);
      localObject = this.mCR;
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
      AppMethodBeat.o(235123);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
      i = 8;
      break label49;
    }
  }
  
  private void em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235124);
    if (this.mDw != null) {
      this.mDw.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(235124);
  }
  
  public final void KD()
  {
    AppMethodBeat.i(235108);
    this.mDo = true;
    bKT();
    AppMethodBeat.o(235108);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(235126);
    this.mDx.add(paramf);
    AppMethodBeat.o(235126);
  }
  
  public final void bGL()
  {
    AppMethodBeat.i(235109);
    this.mDo = false;
    bKT();
    AppMethodBeat.o(235109);
  }
  
  public final void bIZ()
  {
    AppMethodBeat.i(235093);
    if ((this.mDt) && (this.mDu)) {
      this.mDi.setVisibility(8);
    }
    AppMethodBeat.o(235093);
  }
  
  public final void bJA()
  {
    AppMethodBeat.i(235115);
    if (this.mww != null) {
      this.mww.stopTimer();
    }
    AppMethodBeat.o(235115);
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(235104);
    if (this.mDn != null)
    {
      this.mDn.stopTimer();
      this.mDn.startTimer(7000L);
    }
    AppMethodBeat.o(235104);
  }
  
  public final void bJC()
  {
    AppMethodBeat.i(235094);
    if ((this.mDt) && (this.mDu)) {
      this.mDi.setVisibility(0);
    }
    AppMethodBeat.o(235094);
  }
  
  public final boolean bJD()
  {
    AppMethodBeat.i(235122);
    if (this.mDg != null)
    {
      if ((getVisibility() == 0) && (this.mDg.getVisibility() == 0))
      {
        AppMethodBeat.o(235122);
        return true;
      }
      AppMethodBeat.o(235122);
      return false;
    }
    AppMethodBeat.o(235122);
    return false;
  }
  
  public final boolean bJt()
  {
    return this.mDp;
  }
  
  public final void bJu()
  {
    AppMethodBeat.i(235107);
    if (bJw())
    {
      setVisibility(8);
      AppMethodBeat.o(235107);
      return;
    }
    bJv();
    AppMethodBeat.o(235107);
  }
  
  public final void bJv()
  {
    AppMethodBeat.i(235103);
    setVisibility(0);
    if (!this.mDv)
    {
      AppMethodBeat.o(235103);
      return;
    }
    if (this.mDn == null) {
      this.mDn = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(235077);
          AppBrandVideoViewControlBar.this.setVisibility(8);
          AppBrandVideoViewControlBar.c(AppBrandVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(235077);
          return false;
        }
      }, false);
    }
    this.mDn.stopTimer();
    this.mDn.startTimer(7000L);
    AppMethodBeat.o(235103);
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(235106);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(235106);
      return true;
    }
    AppMethodBeat.o(235106);
    return false;
  }
  
  public final boolean bJx()
  {
    return this.mDo;
  }
  
  public final boolean bJy()
  {
    return this.mDv;
  }
  
  public final void bJz()
  {
    AppMethodBeat.i(235114);
    if (this.mww == null) {
      this.mww = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(235078);
          if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this))
          {
            AppMethodBeat.o(235078);
            return false;
          }
          AppMethodBeat.o(235078);
          return true;
        }
      }, true);
    }
    bKX();
    this.mww.stopTimer();
    this.mww.startTimer(500L);
    AppMethodBeat.o(235114);
  }
  
  public final void bKO()
  {
    AppMethodBeat.i(235118);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(235118);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(235118);
      return;
    }
    if (this.mCO == null)
    {
      AppMethodBeat.o(235118);
      return;
    }
    this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(235118);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = en(this.mPosition, i);
    this.mCO.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.mCS * i));
    this.mCM.setLayoutParams(localLayoutParams);
    requestLayout();
    em(this.mPosition, this.mCS);
    AppMethodBeat.o(235118);
  }
  
  protected int getLayoutId()
  {
    return 2131493117;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(235105);
    setVisibility(8);
    AppMethodBeat.o(235105);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(235083);
    super.init();
    this.mDc = ((ImageView)this.contentView.findViewById(2131301826));
    this.mDd = ((ImageView)this.contentView.findViewById(2131299403));
    this.mDf = ((ImageView)this.contentView.findViewById(2131305976));
    this.mDg = ((FrameLayout)this.contentView.findViewById(2131305979));
    this.mDe = ((LinearLayout)findViewById(2131307157));
    this.mDh = ((ImageView)findViewById(2131305118));
    this.mDi = ((ImageView)findViewById(2131298258));
    this.mDj = ((ImageView)findViewById(2131300227));
    this.ayz = ((TextView)findViewById(2131309195));
    this.mDk = ((LinearLayout)findViewById(2131301848));
    this.mDl = ((LinearLayout)findViewById(2131305973));
    AppMethodBeat.o(235083);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(235082);
    if (this.mww != null) {
      this.mww.stopTimer();
    }
    if (this.mDn != null) {
      this.mDn.stopTimer();
    }
    AppMethodBeat.o(235082);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(235117);
    super.seek(paramInt);
    em(this.mPosition, this.mCS);
    AppMethodBeat.o(235117);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.mDv = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(final e.g paramg)
  {
    AppMethodBeat.i(235098);
    this.mDd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235076);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
        if (paramg != null) {
          paramg.hO(AppBrandVideoViewControlBar.b(AppBrandVideoViewControlBar.this));
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235076);
      }
    });
    AppMethodBeat.o(235098);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(235099);
    this.mDp = paramBoolean;
    bKR();
    AppMethodBeat.o(235099);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(235085);
    this.mDj.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(235085);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(235097);
    this.mDc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(235097);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(235096);
    this.dLB = paramBoolean;
    if (this.dLB)
    {
      this.mCP.setImageResource(2131689680);
      this.mDi.setImageResource(2131689680);
      AppMethodBeat.o(235096);
      return;
    }
    this.mCP.setImageResource(2131689681);
    this.mDi.setImageResource(2131689681);
    AppMethodBeat.o(235096);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(235084);
    this.mDh.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(235084);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(235089);
    if (paramBoolean)
    {
      this.mDh.setImageResource(2131689676);
      AppMethodBeat.o(235089);
      return;
    }
    this.mDh.setImageResource(2131689677);
    AppMethodBeat.o(235089);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(235086);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.mDi.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(235086);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.mDw = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(235092);
    this.mDu = paramBoolean;
    bKQ();
    AppMethodBeat.o(235092);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(235090);
    this.mDs = paramBoolean;
    bKY();
    AppMethodBeat.o(235090);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(235102);
    if (paramBoolean)
    {
      this.mDd.setVisibility(0);
      AppMethodBeat.o(235102);
      return;
    }
    this.mDd.setVisibility(8);
    AppMethodBeat.o(235102);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(235119);
    this.mDq = paramBoolean;
    bKS();
    bKP();
    AppMethodBeat.o(235119);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(235088);
    ImageView localImageView = this.mDh;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(235088);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(235120);
    this.mDt = paramBoolean;
    bKQ();
    AppMethodBeat.o(235120);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(235121);
    this.mDr = paramBoolean;
    bKY();
    AppMethodBeat.o(235121);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.mDm = parami;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(235087);
    if (!Util.isNullOrNil(paramString)) {
      this.ayz.setText(paramString);
    }
    AppMethodBeat.o(235087);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(235125);
    super.setVisibility(paramInt);
    Iterator localIterator;
    e.f localf;
    if (paramInt == 0)
    {
      localIterator = this.mDx.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(235125);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.mDx.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(235125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */