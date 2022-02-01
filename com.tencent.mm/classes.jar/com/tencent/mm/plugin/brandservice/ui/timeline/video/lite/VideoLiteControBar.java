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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.am;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoLiteControBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private View fvu;
  private au kOQ;
  private ImageView kUL;
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
  private ImageView nNr;
  private View nNs;
  private a nNt;
  
  public VideoLiteControBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198746);
    this.kVb = true;
    this.kVd = new ConcurrentLinkedQueue();
    AppMethodBeat.o(198746);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198747);
    this.kVb = true;
    this.kVd = new ConcurrentLinkedQueue();
    AppMethodBeat.o(198747);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198748);
    this.kVb = true;
    this.kVd = new ConcurrentLinkedQueue();
    AppMethodBeat.o(198748);
  }
  
  private void bkP()
  {
    AppMethodBeat.i(198755);
    if ((this.kUZ) && (!this.kVa))
    {
      this.kUw.setVisibility(0);
      AppMethodBeat.o(198755);
      return;
    }
    this.kUw.setVisibility(8);
    AppMethodBeat.o(198755);
  }
  
  private void bkS()
  {
    AppMethodBeat.i(198764);
    bkU();
    bkT();
    AppMethodBeat.o(198764);
  }
  
  private void bkT()
  {
    AppMethodBeat.i(198765);
    if (this.kUU) {}
    for (int i = getResources().getDimensionPixelSize(2131165875);; i = getResources().getDimensionPixelSize(2131165865))
    {
      if (this.kUw != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUw.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUw.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(198765);
      return;
    }
  }
  
  private void bkU()
  {
    AppMethodBeat.i(198766);
    if (this.kUU) {}
    for (float f = getResources().getDimensionPixelSize(2131165878);; f = getResources().getDimensionPixelSize(2131165871))
    {
      this.kUx.setTextSize(0, f);
      this.kUy.setTextSize(0, f);
      AppMethodBeat.o(198766);
      return;
    }
  }
  
  private boolean bkW()
  {
    AppMethodBeat.i(198769);
    if (this.kUS == null)
    {
      ac.i("MicroMsg.VideoLiteControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(198769);
      return false;
    }
    int k = this.kUS.bjh();
    int j = this.kUS.bji();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(198769);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(198769);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUL.getLayoutParams();
      localLayoutParams.width = i;
      this.kUL.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(198769);
      return true;
      d = k;
    }
  }
  
  private void bkX()
  {
    int j = 0;
    AppMethodBeat.i(198774);
    boolean bool;
    TextView localTextView;
    if (this.kUY)
    {
      bool = this.kUX;
      localTextView = this.kUx;
      if (!bool) {
        break label66;
      }
      i = 0;
      label31:
      localTextView.setVisibility(i);
      localTextView = this.kUy;
      if (!bool) {
        break label72;
      }
    }
    label66:
    label72:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(198774);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
    }
  }
  
  private void dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198775);
    if (this.kVc != null) {
      this.kVc.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(198775);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(198777);
    this.kVd.add(paramf);
    AppMethodBeat.o(198777);
  }
  
  public final void bha()
  {
    AppMethodBeat.i(198763);
    this.kUU = false;
    bkS();
    AppMethodBeat.o(198763);
  }
  
  public final void biZ() {}
  
  public final void bjA()
  {
    AppMethodBeat.i(198767);
    if (this.kOQ == null) {
      this.kOQ = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(198745);
          if (!VideoLiteControBar.b(VideoLiteControBar.this))
          {
            AppMethodBeat.o(198745);
            return false;
          }
          AppMethodBeat.o(198745);
          return true;
        }
      }, true);
    }
    bkW();
    this.kOQ.stopTimer();
    this.kOQ.au(500L, 500L);
    AppMethodBeat.o(198767);
  }
  
  public final void bjB()
  {
    AppMethodBeat.i(198768);
    if (this.kOQ != null) {
      this.kOQ.stopTimer();
    }
    AppMethodBeat.o(198768);
  }
  
  public final void bjC()
  {
    AppMethodBeat.i(198758);
    if (this.kUT != null)
    {
      this.kUT.stopTimer();
      this.kUT.au(7000L, 7000L);
    }
    AppMethodBeat.o(198758);
  }
  
  public final void bjD() {}
  
  public final boolean bjE()
  {
    return false;
  }
  
  public final boolean bjt()
  {
    return this.kUV;
  }
  
  public final void bju()
  {
    AppMethodBeat.i(198761);
    if (bjw())
    {
      setVisibility(8);
      AppMethodBeat.o(198761);
      return;
    }
    bjv();
    AppMethodBeat.o(198761);
  }
  
  public final void bjv()
  {
    AppMethodBeat.i(198757);
    setVisibility(0);
    if (!this.kVb)
    {
      AppMethodBeat.o(198757);
      return;
    }
    if (this.kUT == null) {
      this.kUT = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(198744);
          VideoLiteControBar.this.setVisibility(8);
          VideoLiteControBar.a(VideoLiteControBar.this).stopTimer();
          AppMethodBeat.o(198744);
          return false;
        }
      }, false);
    }
    this.kUT.stopTimer();
    this.kUT.au(7000L, 7000L);
    AppMethodBeat.o(198757);
  }
  
  public final boolean bjw()
  {
    AppMethodBeat.i(198760);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(198760);
      return true;
    }
    AppMethodBeat.o(198760);
    return false;
  }
  
  public final void bjx()
  {
    AppMethodBeat.i(198762);
    this.kUU = true;
    bkS();
    AppMethodBeat.o(198762);
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
    AppMethodBeat.i(198771);
    if (this.kUz == 0)
    {
      AppMethodBeat.o(198771);
      return;
    }
    if (this.kwq)
    {
      AppMethodBeat.o(198771);
      return;
    }
    if (this.kUv == null)
    {
      AppMethodBeat.o(198771);
      return;
    }
    this.kUx.setText(sO(this.mPosition / 60) + ":" + sO(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(198771);
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
    AppMethodBeat.o(198771);
  }
  
  public final void f(Configuration paramConfiguration)
  {
    AppMethodBeat.i(198778);
    if (paramConfiguration.orientation == 1)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.nNs.getLayoutParams();
      paramConfiguration.addRule(2, 2131306316);
      paramConfiguration.removeRule(8);
      paramConfiguration.removeRule(1);
      paramConfiguration.setMargins(a.av(getContext(), 2131165292), 0, a.av(getContext(), 2131165292), 0);
      this.nNs.setLayoutParams(paramConfiguration);
      ((RelativeLayout.LayoutParams)this.nNr.getLayoutParams()).setMargins(a.av(getContext(), 2131165292), a.av(getContext(), 2131165292), 0, 0);
      ((RelativeLayout.LayoutParams)this.fvu.getLayoutParams()).setMargins(0, 0, 0, a.av(getContext(), 2131165289));
      AppMethodBeat.o(198778);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.nNs.getLayoutParams();
      paramConfiguration.removeRule(2);
      paramConfiguration.addRule(8, 2131306316);
      paramConfiguration.addRule(1, 2131306316);
      paramConfiguration.setMargins(a.av(getContext(), 2131165299), 0, a.av(getContext(), 2131165292), 0);
      this.nNs.setLayoutParams(paramConfiguration);
      paramConfiguration = (RelativeLayout.LayoutParams)this.nNr.getLayoutParams();
      int i = a.av(getContext(), 2131165292);
      paramConfiguration.setMargins(i, a.av(getContext(), 2131165289), 0, a.fromDPToPix(getContext(), -5));
      int j = a.av(getContext(), 2131165296);
      ((RelativeLayout.LayoutParams)this.fvu.getLayoutParams()).setMargins(i, 0, 0, j);
    }
    AppMethodBeat.o(198778);
  }
  
  public int getLayoutId()
  {
    return 2131496367;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(198759);
    setVisibility(8);
    AppMethodBeat.o(198759);
  }
  
  public final void init()
  {
    AppMethodBeat.i(198750);
    super.init();
    this.kUL = ((ImageView)this.contentView.findViewById(2131303303));
    this.nNr = ((ImageView)findViewById(2131306316));
    this.fvu = findViewById(2131304239);
    this.nNs = findViewById(2131307302);
    AppMethodBeat.o(198750);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198749);
    if (this.kOQ != null) {
      this.kOQ.stopTimer();
    }
    if (this.kUT != null) {
      this.kUT.stopTimer();
    }
    AppMethodBeat.o(198749);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(198770);
    super.seek(paramInt);
    dX(this.mPosition, this.kUz);
    AppMethodBeat.o(198770);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.kVb = paramBoolean;
  }
  
  public void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(198751);
    this.nNr.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(198751);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.kUV = paramBoolean;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(198756);
    this.dhM = paramBoolean;
    if (this.dhM) {
      this.kUw.setImageDrawable(am.k(getContext(), 2131690445, -1));
    }
    for (;;)
    {
      if (this.nNt != null) {
        this.nNt.jf(paramBoolean);
      }
      AppMethodBeat.o(198756);
      return;
      this.kUw.setImageDrawable(am.k(getContext(), 2131690459, -1));
    }
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setMuteBtnState(boolean paramBoolean) {}
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(198752);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(198752);
  }
  
  public void setOnPlayStatusChangeListener(a parama)
  {
    this.nNt = parama;
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.kVc = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(198754);
    this.kVa = paramBoolean;
    bkP();
    AppMethodBeat.o(198754);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(198753);
    this.kUY = paramBoolean;
    bkX();
    AppMethodBeat.o(198753);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.kUW = paramBoolean;
  }
  
  public void setShowMuteBtn(boolean paramBoolean) {}
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(198772);
    this.kUZ = paramBoolean;
    bkP();
    AppMethodBeat.o(198772);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(198773);
    this.kUX = paramBoolean;
    bkX();
    AppMethodBeat.o(198773);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.kUS = parami;
  }
  
  public void setTitle(String paramString) {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(198776);
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
      AppMethodBeat.o(198776);
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
    AppMethodBeat.o(198776);
  }
  
  public static abstract interface a
  {
    public abstract void jf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar
 * JD-Core Version:    0.7.0.1
 */