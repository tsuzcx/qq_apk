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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandVideoViewControlBar
  extends VideoPlayerSeekBar
  implements e.a, e.b
{
  private TextView ayB;
  private aw lpR;
  private e.e lwA;
  private ConcurrentLinkedQueue<e.f> lwB;
  private ImageView lwg;
  private ImageView lwh;
  private LinearLayout lwi;
  private ImageView lwj;
  private FrameLayout lwk;
  private ImageView lwl;
  private ImageView lwm;
  private ImageView lwn;
  private LinearLayout lwo;
  private LinearLayout lwp;
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
  
  public AppBrandVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(211402);
    this.lwz = true;
    this.lwB = new ConcurrentLinkedQueue();
    AppMethodBeat.o(211402);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(211403);
    this.lwz = true;
    this.lwB = new ConcurrentLinkedQueue();
    AppMethodBeat.o(211403);
  }
  
  public AppBrandVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(211404);
    this.lwz = true;
    this.lwB = new ConcurrentLinkedQueue();
    AppMethodBeat.o(211404);
  }
  
  private void bpj()
  {
    AppMethodBeat.i(211414);
    if (this.lws)
    {
      this.lwo.setVisibility(0);
      AppMethodBeat.o(211414);
      return;
    }
    this.lwo.setVisibility(8);
    AppMethodBeat.o(211414);
  }
  
  private void bpk()
  {
    AppMethodBeat.i(211418);
    if (this.lwx)
    {
      if (this.lwy)
      {
        this.lvU.setVisibility(8);
        this.lwm.setVisibility(0);
        AppMethodBeat.o(211418);
        return;
      }
      this.lvU.setVisibility(0);
      this.lwm.setVisibility(8);
      AppMethodBeat.o(211418);
      return;
    }
    this.lvU.setVisibility(8);
    this.lwm.setVisibility(8);
    AppMethodBeat.o(211418);
  }
  
  private void bpl()
  {
    AppMethodBeat.i(211423);
    if (this.lwt)
    {
      this.lwh.setImageResource(2131689662);
      AppMethodBeat.o(211423);
      return;
    }
    this.lwh.setImageResource(2131689661);
    AppMethodBeat.o(211423);
  }
  
  private void bpm()
  {
    AppMethodBeat.i(211424);
    if (this.lwu)
    {
      this.lwg.setVisibility(0);
      if (this.lws)
      {
        this.lwg.setImageResource(2131689667);
        AppMethodBeat.o(211424);
        return;
      }
      this.lwg.setImageResource(2131689664);
      AppMethodBeat.o(211424);
      return;
    }
    this.lwg.setVisibility(8);
    AppMethodBeat.o(211424);
  }
  
  private void bpn()
  {
    AppMethodBeat.i(211433);
    bpq();
    bpm();
    bpj();
    bpp();
    bpo();
    AppMethodBeat.o(211433);
  }
  
  private void bpo()
  {
    AppMethodBeat.i(211434);
    if (this.lws) {}
    for (int i = getResources().getDimensionPixelSize(2131165875);; i = getResources().getDimensionPixelSize(2131165865))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.lvU != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lvU.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lvU.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lwp != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lwp.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lwp.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lwh != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lwh.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lwh.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lwl != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lwl.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lwl.setLayoutParams(localMarginLayoutParams);
      }
      if (this.lwg != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.lwg.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.lwg.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(211434);
      return;
    }
  }
  
  private void bpp()
  {
    AppMethodBeat.i(211435);
    if (this.lws) {}
    for (float f = getResources().getDimensionPixelSize(2131165878);; f = getResources().getDimensionPixelSize(2131165871))
    {
      this.lvV.setTextSize(0, f);
      this.lvW.setTextSize(0, f);
      AppMethodBeat.o(211435);
      return;
    }
  }
  
  private void bpq()
  {
    AppMethodBeat.i(211436);
    ViewGroup.LayoutParams localLayoutParams = this.lwi.getLayoutParams();
    if (this.lws)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165876);
      this.lwi.setLayoutParams(localLayoutParams);
      if (!this.lws) {
        break label109;
      }
    }
    label109:
    for (int i = getResources().getDimensionPixelSize(2131165877);; i = getResources().getDimensionPixelSize(2131165868))
    {
      this.lwi.setPadding(0, 0, i, 0);
      if (this.lwo != null) {
        this.lwo.setPadding(i, 0, i, 0);
      }
      AppMethodBeat.o(211436);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131165867);
      break;
    }
  }
  
  private boolean bpr()
  {
    AppMethodBeat.i(211439);
    if (this.lwq == null)
    {
      ae.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(211439);
      return false;
    }
    int k = this.lwq.bnD();
    int j = this.lwq.bnE();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(211439);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(211439);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lwj.getLayoutParams();
      localLayoutParams.width = i;
      this.lwj.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(211439);
      return true;
      d = k;
    }
  }
  
  private void bps()
  {
    int j = 0;
    AppMethodBeat.i(211446);
    boolean bool;
    Object localObject;
    if (this.lww)
    {
      bool = this.lwv;
      localObject = this.lwk;
      if (!bool) {
        break label84;
      }
      i = 0;
      label31:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.lvV;
      if (!bool) {
        break label90;
      }
      i = 0;
      label49:
      ((TextView)localObject).setVisibility(i);
      localObject = this.lvW;
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
      AppMethodBeat.o(211446);
      return;
      bool = false;
      break;
      i = 8;
      break label31;
      i = 8;
      break label49;
    }
  }
  
  private void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211447);
    if (this.lwA != null) {
      this.lwA.onProgressChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(211447);
  }
  
  public final void a(e.f paramf)
  {
    AppMethodBeat.i(211449);
    this.lwB.add(paramf);
    AppMethodBeat.o(211449);
  }
  
  public final void blp()
  {
    AppMethodBeat.i(211432);
    this.lws = false;
    bpn();
    AppMethodBeat.o(211432);
  }
  
  public final boolean bnP()
  {
    return this.lwt;
  }
  
  public final void bnQ()
  {
    AppMethodBeat.i(211430);
    if (bnS())
    {
      setVisibility(8);
      AppMethodBeat.o(211430);
      return;
    }
    bnR();
    AppMethodBeat.o(211430);
  }
  
  public final void bnR()
  {
    AppMethodBeat.i(211426);
    setVisibility(0);
    if (!this.lwz)
    {
      AppMethodBeat.o(211426);
      return;
    }
    if (this.lwr == null) {
      this.lwr = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(211400);
          AppBrandVideoViewControlBar.this.setVisibility(8);
          AppBrandVideoViewControlBar.c(AppBrandVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(211400);
          return false;
        }
      }, false);
    }
    this.lwr.stopTimer();
    this.lwr.ay(7000L, 7000L);
    AppMethodBeat.o(211426);
  }
  
  public final boolean bnS()
  {
    AppMethodBeat.i(211429);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(211429);
      return true;
    }
    AppMethodBeat.o(211429);
    return false;
  }
  
  public final void bnT()
  {
    AppMethodBeat.i(211431);
    this.lws = true;
    bpn();
    AppMethodBeat.o(211431);
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
    AppMethodBeat.i(211437);
    if (this.lpR == null) {
      this.lpR = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(211401);
          if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this))
          {
            AppMethodBeat.o(211401);
            return false;
          }
          AppMethodBeat.o(211401);
          return true;
        }
      }, true);
    }
    bpr();
    this.lpR.stopTimer();
    this.lpR.ay(500L, 500L);
    AppMethodBeat.o(211437);
  }
  
  public final void bnX()
  {
    AppMethodBeat.i(211438);
    if (this.lpR != null) {
      this.lpR.stopTimer();
    }
    AppMethodBeat.o(211438);
  }
  
  public final void bnY()
  {
    AppMethodBeat.i(211427);
    if (this.lwr != null)
    {
      this.lwr.stopTimer();
      this.lwr.ay(7000L, 7000L);
    }
    AppMethodBeat.o(211427);
  }
  
  public final void bnZ()
  {
    AppMethodBeat.i(211417);
    if ((this.lwx) && (this.lwy)) {
      this.lwm.setVisibility(0);
    }
    AppMethodBeat.o(211417);
  }
  
  public final void bnv()
  {
    AppMethodBeat.i(211416);
    if ((this.lwx) && (this.lwy)) {
      this.lwm.setVisibility(8);
    }
    AppMethodBeat.o(211416);
  }
  
  public final boolean boa()
  {
    AppMethodBeat.i(211445);
    if (this.lwk != null)
    {
      if ((getVisibility() == 0) && (this.lwk.getVisibility() == 0))
      {
        AppMethodBeat.o(211445);
        return true;
      }
      AppMethodBeat.o(211445);
      return false;
    }
    AppMethodBeat.o(211445);
    return false;
  }
  
  public final void bpi()
  {
    AppMethodBeat.i(211441);
    if (this.lvX == 0)
    {
      AppMethodBeat.o(211441);
      return;
    }
    if (this.kWf)
    {
      AppMethodBeat.o(211441);
      return;
    }
    if (this.lvT == null)
    {
      AppMethodBeat.o(211441);
      return;
    }
    this.lvV.setText(tv(this.mPosition / 60) + ":" + tv(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(211441);
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
    AppMethodBeat.o(211441);
  }
  
  protected int getLayoutId()
  {
    return 2131493075;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(211428);
    setVisibility(8);
    AppMethodBeat.o(211428);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(211406);
    super.init();
    this.lwg = ((ImageView)this.contentView.findViewById(2131300325));
    this.lwh = ((ImageView)this.contentView.findViewById(2131298919));
    this.lwj = ((ImageView)this.contentView.findViewById(2131303303));
    this.lwk = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.lwi = ((LinearLayout)findViewById(2131304239));
    this.lwl = ((ImageView)findViewById(2131302621));
    this.lwm = ((ImageView)findViewById(2131297935));
    this.lwn = ((ImageView)findViewById(2131299599));
    this.ayB = ((TextView)findViewById(2131305902));
    this.lwo = ((LinearLayout)findViewById(2131300332));
    this.lwp = ((LinearLayout)findViewById(2131303300));
    AppMethodBeat.o(211406);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(211405);
    if (this.lpR != null) {
      this.lpR.stopTimer();
    }
    if (this.lwr != null) {
      this.lwr.stopTimer();
    }
    AppMethodBeat.o(211405);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(211440);
    super.seek(paramInt);
    dZ(this.mPosition, this.lvX);
    AppMethodBeat.o(211440);
  }
  
  public void setAutoHide(boolean paramBoolean)
  {
    this.lwz = paramBoolean;
  }
  
  public void setDanmakuBtnOnClickListener(final e.g paramg)
  {
    AppMethodBeat.i(211421);
    this.lwh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211399);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
        if (paramg != null) {
          paramg.gR(AppBrandVideoViewControlBar.b(AppBrandVideoViewControlBar.this));
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211399);
      }
    });
    AppMethodBeat.o(211421);
  }
  
  public void setDanmakuBtnOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(211422);
    this.lwt = paramBoolean;
    bpl();
    AppMethodBeat.o(211422);
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211408);
    this.lwn.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(211408);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211420);
    this.lwg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(211420);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(211419);
    this.duq = paramBoolean;
    if (this.duq)
    {
      this.lvU.setImageResource(2131689675);
      this.lwm.setImageResource(2131689675);
      AppMethodBeat.o(211419);
      return;
    }
    this.lvU.setImageResource(2131689676);
    this.lwm.setImageResource(2131689676);
    AppMethodBeat.o(211419);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211407);
    this.lwl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(211407);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(211412);
    if (paramBoolean)
    {
      this.lwl.setImageResource(2131689671);
      AppMethodBeat.o(211412);
      return;
    }
    this.lwl.setImageResource(2131689672);
    AppMethodBeat.o(211412);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211409);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.lwm.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(211409);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.lwA = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(211415);
    this.lwy = paramBoolean;
    bpk();
    AppMethodBeat.o(211415);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(211413);
    this.lww = paramBoolean;
    bps();
    AppMethodBeat.o(211413);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(211425);
    if (paramBoolean)
    {
      this.lwh.setVisibility(0);
      AppMethodBeat.o(211425);
      return;
    }
    this.lwh.setVisibility(8);
    AppMethodBeat.o(211425);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(211442);
    this.lwu = paramBoolean;
    bpm();
    bpj();
    AppMethodBeat.o(211442);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(211411);
    ImageView localImageView = this.lwl;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(211411);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(211443);
    this.lwx = paramBoolean;
    bpk();
    AppMethodBeat.o(211443);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(211444);
    this.lwv = paramBoolean;
    bps();
    AppMethodBeat.o(211444);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.lwq = parami;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(211410);
    if (!bu.isNullOrNil(paramString)) {
      this.ayB.setText(paramString);
    }
    AppMethodBeat.o(211410);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(211448);
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
      AppMethodBeat.o(211448);
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
    AppMethodBeat.o(211448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */