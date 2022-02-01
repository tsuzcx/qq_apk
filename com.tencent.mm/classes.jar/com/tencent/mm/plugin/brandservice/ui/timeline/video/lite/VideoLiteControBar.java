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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoLiteControBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private View gvQ;
  private ImageView mDf;
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
  private ImageView pJX;
  private View pJY;
  private VideoLiteControBar.a pJZ;
  
  public VideoLiteControBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195027);
    this.mDv = true;
    this.mDx = new ConcurrentLinkedQueue();
    AppMethodBeat.o(195027);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195028);
    this.mDv = true;
    this.mDx = new ConcurrentLinkedQueue();
    AppMethodBeat.o(195028);
  }
  
  public VideoLiteControBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195029);
    this.mDv = true;
    this.mDx = new ConcurrentLinkedQueue();
    AppMethodBeat.o(195029);
  }
  
  private void bKQ()
  {
    AppMethodBeat.i(195036);
    if ((this.mDt) && (!this.mDu))
    {
      this.mCP.setVisibility(0);
      AppMethodBeat.o(195036);
      return;
    }
    this.mCP.setVisibility(8);
    AppMethodBeat.o(195036);
  }
  
  private void bKT()
  {
    AppMethodBeat.i(195045);
    bKV();
    bKU();
    AppMethodBeat.o(195045);
  }
  
  private void bKU()
  {
    AppMethodBeat.i(195046);
    if (this.mDo) {}
    for (int i = getResources().getDimensionPixelSize(2131165901);; i = getResources().getDimensionPixelSize(2131165891))
    {
      if (this.mCP != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mCP.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.mCP.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(195046);
      return;
    }
  }
  
  private void bKV()
  {
    AppMethodBeat.i(195047);
    if (this.mDo) {}
    for (float f = getResources().getDimensionPixelSize(2131165904);; f = getResources().getDimensionPixelSize(2131165897))
    {
      this.mCQ.setTextSize(0, f);
      this.mCR.setTextSize(0, f);
      AppMethodBeat.o(195047);
      return;
    }
  }
  
  private boolean bKX()
  {
    AppMethodBeat.i(195050);
    if (this.mDm == null)
    {
      Log.i("MicroMsg.VideoLiteControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(195050);
      return false;
    }
    int k = this.mDm.bJh();
    int j = this.mDm.bJi();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(195050);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(195050);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mDf.getLayoutParams();
      localLayoutParams.width = i;
      this.mDf.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(195050);
      return true;
      d = k;
    }
  }
  
  private void bKY()
  {
    int j = 0;
    AppMethodBeat.i(195055);
    boolean bool;
    TextView localTextView;
    if (this.mDs)
    {
      bool = this.mDr;
      localTextView = this.mCQ;
      if (!bool) {
        break label66;
      }
      i = 0;
      label31:
      localTextView.setVisibility(i);
      localTextView = this.mCR;
      if (!bool) {
        break label72;
      }
    }
    label66:
    label72:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(195055);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
    }
  }
  
  private void em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195056);
    if (this.mDw != null) {
      this.mDw.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(195056);
  }
  
  public final void KD()
  {
    AppMethodBeat.i(195043);
    this.mDo = true;
    bKT();
    AppMethodBeat.o(195043);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(195058);
    this.mDx.add(paramf);
    AppMethodBeat.o(195058);
  }
  
  public final void bGL()
  {
    AppMethodBeat.i(195044);
    this.mDo = false;
    bKT();
    AppMethodBeat.o(195044);
  }
  
  public final void bIZ() {}
  
  public final void bJA()
  {
    AppMethodBeat.i(195049);
    if (this.mww != null) {
      this.mww.stopTimer();
    }
    AppMethodBeat.o(195049);
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(195039);
    if (this.mDn != null)
    {
      this.mDn.stopTimer();
      this.mDn.startTimer(7000L);
    }
    AppMethodBeat.o(195039);
  }
  
  public final void bJC() {}
  
  public final boolean bJD()
  {
    return false;
  }
  
  public final boolean bJt()
  {
    return this.mDp;
  }
  
  public final void bJu()
  {
    AppMethodBeat.i(195042);
    if (bJw())
    {
      setVisibility(8);
      AppMethodBeat.o(195042);
      return;
    }
    bJv();
    AppMethodBeat.o(195042);
  }
  
  public final void bJv()
  {
    AppMethodBeat.i(195038);
    setVisibility(0);
    if (!this.mDv)
    {
      AppMethodBeat.o(195038);
      return;
    }
    if (this.mDn == null) {
      this.mDn = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(195025);
          VideoLiteControBar.this.setVisibility(8);
          VideoLiteControBar.a(VideoLiteControBar.this).stopTimer();
          AppMethodBeat.o(195025);
          return false;
        }
      }, false);
    }
    this.mDn.stopTimer();
    this.mDn.startTimer(7000L);
    AppMethodBeat.o(195038);
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(195041);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(195041);
      return true;
    }
    AppMethodBeat.o(195041);
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
    AppMethodBeat.i(195048);
    if (this.mww == null) {
      this.mww = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(195026);
          if (!VideoLiteControBar.b(VideoLiteControBar.this))
          {
            AppMethodBeat.o(195026);
            return false;
          }
          AppMethodBeat.o(195026);
          return true;
        }
      }, true);
    }
    bKX();
    this.mww.stopTimer();
    this.mww.startTimer(500L);
    AppMethodBeat.o(195048);
  }
  
  public final void bKO()
  {
    AppMethodBeat.i(195052);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(195052);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(195052);
      return;
    }
    if (this.mCO == null)
    {
      AppMethodBeat.o(195052);
      return;
    }
    this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(195052);
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
    AppMethodBeat.o(195052);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(195059);
    if (paramConfiguration.orientation == 1)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.pJY.getLayoutParams();
      paramConfiguration.addRule(2, 2131309735);
      paramConfiguration.removeRule(8);
      paramConfiguration.removeRule(1);
      paramConfiguration.setMargins(a.aH(getContext(), 2131165299), 0, a.aH(getContext(), 2131165299), 0);
      this.pJY.setLayoutParams(paramConfiguration);
      ((RelativeLayout.LayoutParams)this.pJX.getLayoutParams()).setMargins(a.aH(getContext(), 2131165299), a.aH(getContext(), 2131165299), 0, 0);
      ((RelativeLayout.LayoutParams)this.gvQ.getLayoutParams()).setMargins(0, 0, 0, a.aH(getContext(), 2131165296));
      AppMethodBeat.o(195059);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.pJY.getLayoutParams();
      paramConfiguration.removeRule(2);
      paramConfiguration.addRule(8, 2131309735);
      paramConfiguration.addRule(1, 2131309735);
      paramConfiguration.setMargins(a.aH(getContext(), 2131165310), 0, a.aH(getContext(), 2131165299), 0);
      this.pJY.setLayoutParams(paramConfiguration);
      paramConfiguration = (RelativeLayout.LayoutParams)this.pJX.getLayoutParams();
      int i = a.aH(getContext(), 2131165299);
      paramConfiguration.setMargins(i, a.aH(getContext(), 2131165296), 0, a.fromDPToPix(getContext(), -5));
      int j = a.aH(getContext(), 2131165306);
      ((RelativeLayout.LayoutParams)this.gvQ.getLayoutParams()).setMargins(i, 0, 0, j);
    }
    AppMethodBeat.o(195059);
  }
  
  public int getLayoutId()
  {
    return 2131496798;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(195040);
    setVisibility(8);
    AppMethodBeat.o(195040);
  }
  
  public final void init()
  {
    AppMethodBeat.i(195031);
    super.init();
    this.mDf = ((ImageView)this.contentView.findViewById(2131305976));
    this.pJX = ((ImageView)findViewById(2131309735));
    this.gvQ = findViewById(2131307157);
    this.pJY = findViewById(2131299233);
    AppMethodBeat.o(195031);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(195030);
    if (this.mww != null) {
      this.mww.stopTimer();
    }
    if (this.mDn != null) {
      this.mDn.stopTimer();
    }
    AppMethodBeat.o(195030);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(195051);
    super.seek(paramInt);
    em(this.mPosition, this.mCS);
    AppMethodBeat.o(195051);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.mDv = paramBoolean;
  }
  
  public void setBtnCloseListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195032);
    this.pJX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(195032);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    this.mDp = paramBoolean;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(195037);
    this.dLB = paramBoolean;
    if (this.dLB) {
      this.mCP.setImageDrawable(ar.m(getContext(), 2131690631, -1));
    }
    for (;;)
    {
      if (this.pJZ != null) {
        this.pJZ.kr(paramBoolean);
      }
      AppMethodBeat.o(195037);
      return;
      this.mCP.setImageDrawable(ar.m(getContext(), 2131690647, -1));
    }
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setMuteBtnState(boolean paramBoolean) {}
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195033);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(195033);
  }
  
  public void setOnPlayStatusChangeListener(VideoLiteControBar.a parama)
  {
    this.pJZ = parama;
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.mDw = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(195035);
    this.mDu = paramBoolean;
    bKQ();
    AppMethodBeat.o(195035);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(195034);
    this.mDs = paramBoolean;
    bKY();
    AppMethodBeat.o(195034);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    this.mDq = paramBoolean;
  }
  
  public void setShowMuteBtn(boolean paramBoolean) {}
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(195053);
    this.mDt = paramBoolean;
    bKQ();
    AppMethodBeat.o(195053);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(195054);
    this.mDr = paramBoolean;
    bKY();
    AppMethodBeat.o(195054);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.mDm = parami;
  }
  
  public void setTitle(String paramString) {}
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(195057);
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
      AppMethodBeat.o(195057);
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
    AppMethodBeat.o(195057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar
 * JD-Core Version:    0.7.0.1
 */