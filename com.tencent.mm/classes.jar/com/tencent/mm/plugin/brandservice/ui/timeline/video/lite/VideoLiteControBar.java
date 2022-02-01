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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.ao;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoLiteControBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private View fOB;
  private av llt;
  private ImageView lrJ;
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
  private ImageView opX;
  private View opY;
  private VideoLiteControBar.a opZ;
  
  public VideoLiteControBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(209560);
    this.lrZ = true;
    this.lsb = new ConcurrentLinkedQueue();
    AppMethodBeat.o(209560);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209561);
    this.lrZ = true;
    this.lsb = new ConcurrentLinkedQueue();
    AppMethodBeat.o(209561);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209562);
    this.lrZ = true;
    this.lsb = new ConcurrentLinkedQueue();
    AppMethodBeat.o(209562);
  }
  
  private void boA()
  {
    AppMethodBeat.i(209569);
    if ((this.lrX) && (!this.lrY))
    {
      this.lru.setVisibility(0);
      AppMethodBeat.o(209569);
      return;
    }
    this.lru.setVisibility(8);
    AppMethodBeat.o(209569);
  }
  
  private void boD()
  {
    AppMethodBeat.i(209578);
    boF();
    boE();
    AppMethodBeat.o(209578);
  }
  
  private void boE()
  {
    AppMethodBeat.i(209579);
    if (this.lrS) {}
    for (int i = getResources().getDimensionPixelSize(2131165875);; i = getResources().getDimensionPixelSize(2131165865))
    {
      if (this.lru != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lru.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lru.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(209579);
      return;
    }
  }
  
  private void boF()
  {
    AppMethodBeat.i(209580);
    if (this.lrS) {}
    for (float f = getResources().getDimensionPixelSize(2131165878);; f = getResources().getDimensionPixelSize(2131165871))
    {
      this.lrv.setTextSize(0, f);
      this.lrw.setTextSize(0, f);
      AppMethodBeat.o(209580);
      return;
    }
  }
  
  private boolean boH()
  {
    AppMethodBeat.i(209583);
    if (this.lrQ == null)
    {
      ad.i("MicroMsg.VideoLiteControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(209583);
      return false;
    }
    int k = this.lrQ.bmT();
    int j = this.lrQ.bmU();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(209583);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(209583);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrJ.getLayoutParams();
      localLayoutParams.width = i;
      this.lrJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(209583);
      return true;
      d = k;
    }
  }
  
  private void boI()
  {
    int j = 0;
    AppMethodBeat.i(209588);
    boolean bool;
    TextView localTextView;
    if (this.lrW)
    {
      bool = this.lrV;
      localTextView = this.lrv;
      if (!bool) {
        break label66;
      }
      i = 0;
      label31:
      localTextView.setVisibility(i);
      localTextView = this.lrw;
      if (!bool) {
        break label72;
      }
    }
    label66:
    label72:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(209588);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
    }
  }
  
  private void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209589);
    if (this.lsa != null) {
      this.lsa.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(209589);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(209591);
    this.lsb.add(paramf);
    AppMethodBeat.o(209591);
  }
  
  public final void bkF()
  {
    AppMethodBeat.i(209577);
    this.lrS = false;
    boD();
    AppMethodBeat.o(209577);
  }
  
  public final void bmL() {}
  
  public final boolean bnf()
  {
    return this.lrT;
  }
  
  public final void bng()
  {
    AppMethodBeat.i(209575);
    if (bni())
    {
      setVisibility(8);
      AppMethodBeat.o(209575);
      return;
    }
    bnh();
    AppMethodBeat.o(209575);
  }
  
  public final void bnh()
  {
    AppMethodBeat.i(209571);
    setVisibility(0);
    if (!this.lrZ)
    {
      AppMethodBeat.o(209571);
      return;
    }
    if (this.lrR == null) {
      this.lrR = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(209558);
          VideoLiteControBar.this.setVisibility(8);
          VideoLiteControBar.a(VideoLiteControBar.this).stopTimer();
          AppMethodBeat.o(209558);
          return false;
        }
      }, false);
    }
    this.lrR.stopTimer();
    this.lrR.az(7000L, 7000L);
    AppMethodBeat.o(209571);
  }
  
  public final boolean bni()
  {
    AppMethodBeat.i(209574);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(209574);
      return true;
    }
    AppMethodBeat.o(209574);
    return false;
  }
  
  public final void bnj()
  {
    AppMethodBeat.i(209576);
    this.lrS = true;
    boD();
    AppMethodBeat.o(209576);
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
    AppMethodBeat.i(209581);
    if (this.llt == null) {
      this.llt = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(209559);
          if (!VideoLiteControBar.b(VideoLiteControBar.this))
          {
            AppMethodBeat.o(209559);
            return false;
          }
          AppMethodBeat.o(209559);
          return true;
        }
      }, true);
    }
    boH();
    this.llt.stopTimer();
    this.llt.az(500L, 500L);
    AppMethodBeat.o(209581);
  }
  
  public final void bnn()
  {
    AppMethodBeat.i(209582);
    if (this.llt != null) {
      this.llt.stopTimer();
    }
    AppMethodBeat.o(209582);
  }
  
  public final void bno()
  {
    AppMethodBeat.i(209572);
    if (this.lrR != null)
    {
      this.lrR.stopTimer();
      this.lrR.az(7000L, 7000L);
    }
    AppMethodBeat.o(209572);
  }
  
  public final void bnp() {}
  
  public final boolean bnq()
  {
    return false;
  }
  
  public final void boy()
  {
    AppMethodBeat.i(209585);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(209585);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(209585);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(209585);
      return;
    }
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(209585);
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
    AppMethodBeat.o(209585);
  }
  
  public final void f(Configuration paramConfiguration)
  {
    AppMethodBeat.i(209592);
    if (paramConfiguration.orientation == 1)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.opY.getLayoutParams();
      paramConfiguration.addRule(2, 2131306316);
      paramConfiguration.removeRule(8);
      paramConfiguration.removeRule(1);
      paramConfiguration.setMargins(a.ay(getContext(), 2131165292), 0, a.ay(getContext(), 2131165292), 0);
      this.opY.setLayoutParams(paramConfiguration);
      ((RelativeLayout.LayoutParams)this.opX.getLayoutParams()).setMargins(a.ay(getContext(), 2131165292), a.ay(getContext(), 2131165292), 0, 0);
      ((RelativeLayout.LayoutParams)this.fOB.getLayoutParams()).setMargins(0, 0, 0, a.ay(getContext(), 2131165289));
      AppMethodBeat.o(209592);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.opY.getLayoutParams();
      paramConfiguration.removeRule(2);
      paramConfiguration.addRule(8, 2131306316);
      paramConfiguration.addRule(1, 2131306316);
      paramConfiguration.setMargins(a.ay(getContext(), 2131165299), 0, a.ay(getContext(), 2131165292), 0);
      this.opY.setLayoutParams(paramConfiguration);
      paramConfiguration = (RelativeLayout.LayoutParams)this.opX.getLayoutParams();
      int i = a.ay(getContext(), 2131165292);
      paramConfiguration.setMargins(i, a.ay(getContext(), 2131165289), 0, a.fromDPToPix(getContext(), -5));
      int j = a.ay(getContext(), 2131165296);
      ((RelativeLayout.LayoutParams)this.fOB.getLayoutParams()).setMargins(i, 0, 0, j);
    }
    AppMethodBeat.o(209592);
  }
  
  public int getLayoutId()
  {
    return 2131496367;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(209573);
    setVisibility(8);
    AppMethodBeat.o(209573);
  }
  
  public final void init()
  {
    AppMethodBeat.i(209564);
    super.init();
    this.lrJ = ((ImageView)this.contentView.findViewById(2131303303));
    this.opX = ((ImageView)findViewById(2131306316));
    this.fOB = findViewById(2131304239);
    this.opY = findViewById(2131307302);
    AppMethodBeat.o(209564);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(209563);
    if (this.llt != null) {
      this.llt.stopTimer();
    }
    if (this.lrR != null) {
      this.lrR.stopTimer();
    }
    AppMethodBeat.o(209563);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(209584);
    super.seek(paramInt);
    dZ(this.mPosition, this.lrx);
    AppMethodBeat.o(209584);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.lrZ = paramBoolean;
  }
  
  public void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(209565);
    this.opX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(209565);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.lrT = paramBoolean;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(209570);
    this.dtk = paramBoolean;
    if (this.dtk) {
      this.lru.setImageDrawable(ao.k(getContext(), 2131690445, -1));
    }
    for (;;)
    {
      if (this.opZ != null) {
        this.opZ.jq(paramBoolean);
      }
      AppMethodBeat.o(209570);
      return;
      this.lru.setImageDrawable(ao.k(getContext(), 2131690459, -1));
    }
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setMuteBtnState(boolean paramBoolean) {}
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(209566);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(209566);
  }
  
  public void setOnPlayStatusChangeListener(VideoLiteControBar.a parama)
  {
    this.opZ = parama;
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.lsa = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(209568);
    this.lrY = paramBoolean;
    boA();
    AppMethodBeat.o(209568);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(209567);
    this.lrW = paramBoolean;
    boI();
    AppMethodBeat.o(209567);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.lrU = paramBoolean;
  }
  
  public void setShowMuteBtn(boolean paramBoolean) {}
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(209586);
    this.lrX = paramBoolean;
    boA();
    AppMethodBeat.o(209586);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(209587);
    this.lrV = paramBoolean;
    boI();
    AppMethodBeat.o(209587);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.lrQ = parami;
  }
  
  public void setTitle(String paramString) {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(209590);
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
      AppMethodBeat.o(209590);
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
    AppMethodBeat.o(209590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar
 * JD-Core Version:    0.7.0.1
 */