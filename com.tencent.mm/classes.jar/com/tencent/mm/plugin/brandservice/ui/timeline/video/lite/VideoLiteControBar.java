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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.ao;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoLiteControBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private View fQH;
  private aw lpR;
  private e.e lwA;
  private ConcurrentLinkedQueue<e.f> lwB;
  private ImageView lwj;
  private e.i lwq;
  private aw lwr;
  private boolean lws;
  private boolean lwt;
  private boolean lwu;
  private boolean lwv;
  private boolean lww;
  private boolean lwx;
  private boolean lwy;
  private boolean lwz;
  private ImageView owt;
  private View owu;
  private VideoLiteControBar.a owv;
  
  public VideoLiteControBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(208516);
    this.lwz = true;
    this.lwB = new ConcurrentLinkedQueue();
    AppMethodBeat.o(208516);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208517);
    this.lwz = true;
    this.lwB = new ConcurrentLinkedQueue();
    AppMethodBeat.o(208517);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208518);
    this.lwz = true;
    this.lwB = new ConcurrentLinkedQueue();
    AppMethodBeat.o(208518);
  }
  
  private void bpk()
  {
    AppMethodBeat.i(208525);
    if ((this.lwx) && (!this.lwy))
    {
      this.lvU.setVisibility(0);
      AppMethodBeat.o(208525);
      return;
    }
    this.lvU.setVisibility(8);
    AppMethodBeat.o(208525);
  }
  
  private void bpn()
  {
    AppMethodBeat.i(208534);
    bpp();
    bpo();
    AppMethodBeat.o(208534);
  }
  
  private void bpo()
  {
    AppMethodBeat.i(208535);
    if (this.lws) {}
    for (int i = getResources().getDimensionPixelSize(2131165875);; i = getResources().getDimensionPixelSize(2131165865))
    {
      if (this.lvU != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lvU.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lvU.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(208535);
      return;
    }
  }
  
  private void bpp()
  {
    AppMethodBeat.i(208536);
    if (this.lws) {}
    for (float f = getResources().getDimensionPixelSize(2131165878);; f = getResources().getDimensionPixelSize(2131165871))
    {
      this.lvV.setTextSize(0, f);
      this.lvW.setTextSize(0, f);
      AppMethodBeat.o(208536);
      return;
    }
  }
  
  private boolean bpr()
  {
    AppMethodBeat.i(208539);
    if (this.lwq == null)
    {
      ae.i("MicroMsg.VideoLiteControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(208539);
      return false;
    }
    int k = this.lwq.bnD();
    int j = this.lwq.bnE();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(208539);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(208539);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lwj.getLayoutParams();
      localLayoutParams.width = i;
      this.lwj.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(208539);
      return true;
      d = k;
    }
  }
  
  private void bps()
  {
    int j = 0;
    AppMethodBeat.i(208544);
    boolean bool;
    TextView localTextView;
    if (this.lww)
    {
      bool = this.lwv;
      localTextView = this.lvV;
      if (!bool) {
        break label66;
      }
      i = 0;
      label31:
      localTextView.setVisibility(i);
      localTextView = this.lvW;
      if (!bool) {
        break label72;
      }
    }
    label66:
    label72:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(208544);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
    }
  }
  
  private void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208545);
    if (this.lwA != null) {
      this.lwA.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(208545);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(208547);
    this.lwB.add(paramf);
    AppMethodBeat.o(208547);
  }
  
  public final void blp()
  {
    AppMethodBeat.i(208533);
    this.lws = false;
    bpn();
    AppMethodBeat.o(208533);
  }
  
  public final boolean bnP()
  {
    return this.lwt;
  }
  
  public final void bnQ()
  {
    AppMethodBeat.i(208531);
    if (bnS())
    {
      setVisibility(8);
      AppMethodBeat.o(208531);
      return;
    }
    bnR();
    AppMethodBeat.o(208531);
  }
  
  public final void bnR()
  {
    AppMethodBeat.i(208527);
    setVisibility(0);
    if (!this.lwz)
    {
      AppMethodBeat.o(208527);
      return;
    }
    if (this.lwr == null) {
      this.lwr = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(208514);
          VideoLiteControBar.this.setVisibility(8);
          VideoLiteControBar.a(VideoLiteControBar.this).stopTimer();
          AppMethodBeat.o(208514);
          return false;
        }
      }, false);
    }
    this.lwr.stopTimer();
    this.lwr.ay(7000L, 7000L);
    AppMethodBeat.o(208527);
  }
  
  public final boolean bnS()
  {
    AppMethodBeat.i(208530);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(208530);
      return true;
    }
    AppMethodBeat.o(208530);
    return false;
  }
  
  public final void bnT()
  {
    AppMethodBeat.i(208532);
    this.lws = true;
    bpn();
    AppMethodBeat.o(208532);
  }
  
  public final boolean bnU()
  {
    return this.lws;
  }
  
  public final boolean bnV()
  {
    return this.lwz;
  }
  
  public final void bnW()
  {
    AppMethodBeat.i(208537);
    if (this.lpR == null) {
      this.lpR = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(208515);
          if (!VideoLiteControBar.b(VideoLiteControBar.this))
          {
            AppMethodBeat.o(208515);
            return false;
          }
          AppMethodBeat.o(208515);
          return true;
        }
      }, true);
    }
    bpr();
    this.lpR.stopTimer();
    this.lpR.ay(500L, 500L);
    AppMethodBeat.o(208537);
  }
  
  public final void bnX()
  {
    AppMethodBeat.i(208538);
    if (this.lpR != null) {
      this.lpR.stopTimer();
    }
    AppMethodBeat.o(208538);
  }
  
  public final void bnY()
  {
    AppMethodBeat.i(208528);
    if (this.lwr != null)
    {
      this.lwr.stopTimer();
      this.lwr.ay(7000L, 7000L);
    }
    AppMethodBeat.o(208528);
  }
  
  public final void bnZ() {}
  
  public final void bnv() {}
  
  public final boolean boa()
  {
    return false;
  }
  
  public final void bpi()
  {
    AppMethodBeat.i(208541);
    if (this.lvX == 0)
    {
      AppMethodBeat.o(208541);
      return;
    }
    if (this.kWf)
    {
      AppMethodBeat.o(208541);
      return;
    }
    if (this.lvT == null)
    {
      AppMethodBeat.o(208541);
      return;
    }
    this.lvV.setText(tv(this.mPosition / 60) + ":" + tv(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(208541);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lvT.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = ea(this.mPosition, i);
    this.lvT.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lvR.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lvX * i));
    this.lvR.setLayoutParams(localLayoutParams);
    requestLayout();
    dZ(this.mPosition, this.lvX);
    AppMethodBeat.o(208541);
  }
  
  public final void f(Configuration paramConfiguration)
  {
    AppMethodBeat.i(208548);
    if (paramConfiguration.orientation == 1)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.owu.getLayoutParams();
      paramConfiguration.addRule(2, 2131306316);
      paramConfiguration.removeRule(8);
      paramConfiguration.removeRule(1);
      paramConfiguration.setMargins(a.ay(getContext(), 2131165292), 0, a.ay(getContext(), 2131165292), 0);
      this.owu.setLayoutParams(paramConfiguration);
      ((RelativeLayout.LayoutParams)this.owt.getLayoutParams()).setMargins(a.ay(getContext(), 2131165292), a.ay(getContext(), 2131165292), 0, 0);
      ((RelativeLayout.LayoutParams)this.fQH.getLayoutParams()).setMargins(0, 0, 0, a.ay(getContext(), 2131165289));
      AppMethodBeat.o(208548);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.owu.getLayoutParams();
      paramConfiguration.removeRule(2);
      paramConfiguration.addRule(8, 2131306316);
      paramConfiguration.addRule(1, 2131306316);
      paramConfiguration.setMargins(a.ay(getContext(), 2131165299), 0, a.ay(getContext(), 2131165292), 0);
      this.owu.setLayoutParams(paramConfiguration);
      paramConfiguration = (RelativeLayout.LayoutParams)this.owt.getLayoutParams();
      int i = a.ay(getContext(), 2131165292);
      paramConfiguration.setMargins(i, a.ay(getContext(), 2131165289), 0, a.fromDPToPix(getContext(), -5));
      int j = a.ay(getContext(), 2131165296);
      ((RelativeLayout.LayoutParams)this.fQH.getLayoutParams()).setMargins(i, 0, 0, j);
    }
    AppMethodBeat.o(208548);
  }
  
  public int getLayoutId()
  {
    return 2131496367;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208529);
    setVisibility(8);
    AppMethodBeat.o(208529);
  }
  
  public final void init()
  {
    AppMethodBeat.i(208520);
    super.init();
    this.lwj = ((ImageView)this.contentView.findViewById(2131303303));
    this.owt = ((ImageView)findViewById(2131306316));
    this.fQH = findViewById(2131304239);
    this.owu = findViewById(2131307302);
    AppMethodBeat.o(208520);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(208519);
    if (this.lpR != null) {
      this.lpR.stopTimer();
    }
    if (this.lwr != null) {
      this.lwr.stopTimer();
    }
    AppMethodBeat.o(208519);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(208540);
    super.seek(paramInt);
    dZ(this.mPosition, this.lvX);
    AppMethodBeat.o(208540);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.lwz = paramBoolean;
  }
  
  public void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(208521);
    this.owt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(208521);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.lwt = paramBoolean;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(208526);
    this.duq = paramBoolean;
    if (this.duq) {
      this.lvU.setImageDrawable(ao.k(getContext(), 2131690445, -1));
    }
    for (;;)
    {
      if (this.owv != null) {
        this.owv.jp(paramBoolean);
      }
      AppMethodBeat.o(208526);
      return;
      this.lvU.setImageDrawable(ao.k(getContext(), 2131690459, -1));
    }
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setMuteBtnState(boolean paramBoolean) {}
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(208522);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(208522);
  }
  
  public void setOnPlayStatusChangeListener(VideoLiteControBar.a parama)
  {
    this.owv = parama;
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.lwA = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(208524);
    this.lwy = paramBoolean;
    bpk();
    AppMethodBeat.o(208524);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(208523);
    this.lww = paramBoolean;
    bps();
    AppMethodBeat.o(208523);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.lwu = paramBoolean;
  }
  
  public void setShowMuteBtn(boolean paramBoolean) {}
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(208542);
    this.lwx = paramBoolean;
    bpk();
    AppMethodBeat.o(208542);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(208543);
    this.lwv = paramBoolean;
    bps();
    AppMethodBeat.o(208543);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.lwq = parami;
  }
  
  public void setTitle(String paramString) {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(208546);
    super.setVisibility(paramInt);
    Iterator localIterator;
    e.f localf;
    if (paramInt == 0)
    {
      localIterator = this.lwB.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(true);
        }
      }
      AppMethodBeat.o(208546);
      return;
    }
    if ((paramInt == 8) || (paramInt == 4))
    {
      localIterator = this.lwB.iterator();
      while (localIterator.hasNext())
      {
        localf = (e.f)localIterator.next();
        if (localf != null) {
          localf.onVisibilityChanged(false);
        }
      }
    }
    AppMethodBeat.o(208546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar
 * JD-Core Version:    0.7.0.1
 */