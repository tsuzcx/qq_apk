package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MPVideoViewControlBar
  extends VideoPlayerSeekBar
  implements com.tencent.mm.plugin.appbrand.jsapi.video.d.a, com.tencent.mm.pluginsdk.ui.h
{
  private boolean pCA;
  private boolean pCC;
  private boolean pCD;
  private boolean pCE;
  private boolean pCF;
  private boolean pCG;
  private com.tencent.mm.plugin.appbrand.jsapi.video.d.e pCI;
  private ImageView pCo;
  private LinearLayout pCq;
  private ImageView pCr;
  private FrameLayout pCs;
  private ImageView pCt;
  private ImageView pCu;
  private ImageView pCv;
  private LinearLayout pCw;
  private LinearLayout pCx;
  private com.tencent.mm.plugin.appbrand.jsapi.video.d.i pCy;
  private MTimerHandler pCz;
  private MTimerHandler puW;
  private int puh;
  private LinearLayout sVA;
  private a sVB;
  private b sVC;
  private Animation sVD;
  private Animation sVE;
  private Animation sVF;
  private Animation sVG;
  private LinkedList<fv> sVH;
  private fv sVI;
  private com.tencent.mm.plugin.appbrand.jsapi.video.d.f sVJ;
  private RelativeLayout sVq;
  private LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a> sVr;
  private LinearLayout sVs;
  private ImageView sVt;
  private TextView sVu;
  private TextView sVv;
  private View sVw;
  private LinearLayout sVx;
  private TextView sVy;
  private View sVz;
  private TextView wB;
  
  public MPVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6285);
    this.sVr = null;
    this.sVH = new LinkedList();
    AppMethodBeat.o(6285);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6286);
    this.sVr = null;
    this.sVH = new LinkedList();
    AppMethodBeat.o(6286);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6287);
    this.sVr = null;
    this.sVH = new LinkedList();
    AppMethodBeat.o(6287);
  }
  
  private void M(final LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a> paramLinkedList)
  {
    AppMethodBeat.i(6323);
    this.sVr = paramLinkedList;
    if ((this.sVq == null) || (Util.isNullOrNil(this.sVr)))
    {
      this.sVq.removeAllViews();
      AppMethodBeat.o(6323);
      return;
    }
    Log.i("MicroMsg.MPVideoViewControlBar", "updateControlBarDotPos");
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257532);
        MPVideoViewControlBar.g(MPVideoViewControlBar.this).removeAllViews();
        Object localObject = paramLinkedList;
        if (!Util.isNullOrNil((List)localObject))
        {
          localObject = ((LinkedList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a locala = (com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a)((Iterator)localObject).next();
            ImageView localImageView = new ImageView(MPVideoViewControlBar.this.getContext());
            MPVideoViewControlBar.g(MPVideoViewControlBar.this).addView(localImageView);
            MPVideoViewControlBar.a(MPVideoViewControlBar.this, locala);
            MPVideoViewControlBar.g(MPVideoViewControlBar.this).removeView(localImageView);
          }
        }
        AppMethodBeat.o(257532);
      }
    }, 100L);
    AppMethodBeat.o(6323);
  }
  
  private void bWP()
  {
    AppMethodBeat.i(6298);
    if (this.pCA)
    {
      this.pCw.setVisibility(0);
      this.sVs.setVisibility(0);
      AppMethodBeat.o(6298);
      return;
    }
    this.pCw.setVisibility(8);
    this.sVs.setVisibility(8);
    AppMethodBeat.o(6298);
  }
  
  private void bWQ()
  {
    AppMethodBeat.i(6302);
    if (this.pCF)
    {
      if (this.pCG)
      {
        this.pCc.setVisibility(8);
        this.pCu.setVisibility(0);
        AppMethodBeat.o(6302);
        return;
      }
      this.pCc.setVisibility(0);
      this.pCu.setVisibility(8);
      AppMethodBeat.o(6302);
      return;
    }
    this.pCc.setVisibility(8);
    this.pCu.setVisibility(8);
    AppMethodBeat.o(6302);
  }
  
  private void bWS()
  {
    AppMethodBeat.i(6305);
    if (this.pCC)
    {
      this.pCo.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.pCo.getLayoutParams();
      getResources().getDimensionPixelSize(d.c.spv);
      if (this.pCA) {
        this.pCo.setImageResource(com.tencent.mm.plugin.brandservice.d.d.spK);
      }
      for (int i = getResources().getDimensionPixelSize(d.c.spt);; i = getResources().getDimensionPixelSize(d.c.spv))
      {
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        this.pCo.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(6305);
        return;
        this.pCo.setImageResource(d.h.mp_video_fullscreen_btn);
      }
    }
    this.pCo.setVisibility(8);
    AppMethodBeat.o(6305);
  }
  
  private void bWT()
  {
    AppMethodBeat.i(6315);
    bWW();
    bWS();
    bWP();
    bWV();
    bWU();
    M(this.sVr);
    cER();
    cET();
    cEV();
    cEW();
    AppMethodBeat.o(6315);
  }
  
  private void bWU()
  {
    AppMethodBeat.i(6316);
    if (cEP()) {}
    for (int i = getResources().getDimensionPixelSize(d.c.spp);; i = getResources().getDimensionPixelSize(d.c.spl))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.pCc != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCc.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCc.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pCx != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCx.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCx.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pCt != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCt.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCt.setLayoutParams(localMarginLayoutParams);
      }
      if (this.pCo != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.pCo.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.pCo.setLayoutParams(localMarginLayoutParams);
      }
      if (this.sVw != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sVw.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sVw.setLayoutParams(localMarginLayoutParams);
      }
      if (this.sVz != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.sVw.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.sVz.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(6316);
      return;
    }
  }
  
  private void bWV()
  {
    AppMethodBeat.i(6317);
    if (cEP()) {}
    for (float f = getResources().getDimensionPixelSize(d.c.sps);; f = getResources().getDimensionPixelSize(d.c.spo))
    {
      this.pCd.setTextSize(0, f);
      this.pCe.setTextSize(0, f);
      AppMethodBeat.o(6317);
      return;
    }
  }
  
  private void bWW()
  {
    AppMethodBeat.i(6318);
    ViewGroup.LayoutParams localLayoutParams = this.pCq.getLayoutParams();
    int j;
    if (this.pCA)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(d.c.spq);
      this.pCq.setLayoutParams(localLayoutParams);
      if (!cEP()) {
        break label143;
      }
      j = getResources().getDimensionPixelSize(d.c.spr);
    }
    for (int i = getResources().getDimensionPixelSize(d.c.spp);; i = getResources().getDimensionPixelSize(d.c.spn))
    {
      this.pCq.setPadding(0, 0, i, 0);
      if (this.pCw != null) {
        this.pCw.setPadding(j, 0, j, 0);
      }
      if (this.sVs != null) {
        this.sVs.setPadding(j, 0, j, 0);
      }
      AppMethodBeat.o(6318);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(d.c.spm);
      break;
      label143:
      j = getResources().getDimensionPixelSize(d.c.spn);
    }
  }
  
  private boolean bWX()
  {
    AppMethodBeat.i(6321);
    if (this.pCy == null)
    {
      Log.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(6321);
      return false;
    }
    int k = this.pCy.bUQ();
    int j = this.pCy.bUR();
    if ((k < 0) || (j < 0))
    {
      AppMethodBeat.o(6321);
      return false;
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    k = getBarLen();
    if (k <= 0)
    {
      AppMethodBeat.o(6321);
      return true;
    }
    if (j == 0) {}
    double d;
    for (i = 0;; i = (int)(i * 1.0D / j * d))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCr.getLayoutParams();
      localLayoutParams.width = i;
      this.pCr.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(6321);
      return true;
      d = k;
    }
  }
  
  private void bWY()
  {
    int j = 0;
    AppMethodBeat.i(6333);
    boolean bool;
    Object localObject;
    if (this.pCE)
    {
      bool = this.pCD;
      localObject = this.pCs;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.pCd;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.pCe;
      if (!bool) {
        break label98;
      }
    }
    label86:
    label92:
    label98:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      AppMethodBeat.o(6333);
      return;
      bool = false;
      break;
      i = 8;
      break label32;
      i = 8;
      break label50;
    }
  }
  
  private boolean cEP()
  {
    return (this.pCA) && ((90 == this.puh) || (-90 == this.puh));
  }
  
  private void cEQ()
  {
    AppMethodBeat.i(6322);
    if (Util.isNullOrNil(this.sVr))
    {
      AppMethodBeat.o(6322);
      return;
    }
    Iterator localIterator = this.sVr.iterator();
    if (localIterator.hasNext())
    {
      localIterator.next();
      AppMethodBeat.o(6322);
      throw null;
    }
    AppMethodBeat.o(6322);
  }
  
  private void cER()
  {
    AppMethodBeat.i(6325);
    if ((!cEP()) || (Util.isNullOrNil(this.sVH)) || (this.sVI == null))
    {
      cES();
      this.sVw.setVisibility(8);
      AppMethodBeat.o(6325);
      return;
    }
    this.sVv.setText(this.sVI.RKY);
    this.sVw.setVisibility(0);
    this.sVw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6284);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0)
        {
          MPVideoViewControlBar.d(MPVideoViewControlBar.this);
          if (MPVideoViewControlBar.this.cTl()) {
            MPVideoViewControlBar.this.bVi();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6284);
          return;
          if (MPVideoViewControlBar.h(MPVideoViewControlBar.this) != null) {
            MPVideoViewControlBar.h(MPVideoViewControlBar.this).cEN();
          }
          MPVideoViewControlBar.i(MPVideoViewControlBar.this);
          MPVideoViewControlBar.j(MPVideoViewControlBar.this);
        }
      }
    });
    AppMethodBeat.o(6325);
  }
  
  private void cES()
  {
    AppMethodBeat.i(6326);
    Log.d("MicroMsg.MPVideoViewControlBar", "hideResolutionContainer");
    if (this.sVx.getVisibility() != 8)
    {
      this.sVx.setVisibility(8);
      if (this.sVB != null) {
        this.sVB.cEM();
      }
    }
    AppMethodBeat.o(6326);
  }
  
  private void cET()
  {
    AppMethodBeat.i(179005);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAE, 1) == 0) {}
    for (int i = 1; (!cEP()) || (Util.isNullOrNil(this.sVH)) || (this.sVI == null) || (i != 0); i = 0)
    {
      cEU();
      this.sVz.setVisibility(8);
      AppMethodBeat.o(179005);
      return;
    }
    Object localObject = a.sUM;
    if (a.cEG().sUT == 1.0F) {}
    for (localObject = getResources().getString(com.tencent.mm.plugin.brandservice.d.i.video_multispeed);; localObject = a.cEG().desc)
    {
      this.sVy.setText((CharSequence)localObject);
      this.sVz.setVisibility(0);
      this.sVz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (MPVideoViewControlBar.k(MPVideoViewControlBar.this).getVisibility() == 0)
          {
            MPVideoViewControlBar.e(MPVideoViewControlBar.this);
            if (MPVideoViewControlBar.this.cTl()) {
              MPVideoViewControlBar.this.bVi();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179004);
            return;
            if (MPVideoViewControlBar.l(MPVideoViewControlBar.this) != null) {
              MPVideoViewControlBar.l(MPVideoViewControlBar.this).cEK();
            }
            MPVideoViewControlBar.m(MPVideoViewControlBar.this);
            MPVideoViewControlBar.n(MPVideoViewControlBar.this);
          }
        }
      });
      AppMethodBeat.o(179005);
      return;
      localObject = a.sUM;
    }
  }
  
  private void cEU()
  {
    AppMethodBeat.i(179006);
    Log.d("MicroMsg.MPVideoViewControlBar", "hideSpeedContainer");
    if (this.sVA.getVisibility() != 8)
    {
      this.sVA.setVisibility(8);
      if (this.sVC != null) {
        this.sVC.cEL();
      }
    }
    AppMethodBeat.o(179006);
  }
  
  private void cEV()
  {
    AppMethodBeat.i(179007);
    ImageView localImageView = this.pCt;
    if (this.pCA) {}
    for (int i = 8;; i = 0)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(179007);
      return;
    }
  }
  
  private void cEW()
  {
    AppMethodBeat.i(179008);
    ViewGroup.LayoutParams localLayoutParams = this.pCc.getLayoutParams();
    int i = getResources().getDimensionPixelSize(d.c.spv);
    if (this.pCA) {
      i = getResources().getDimensionPixelSize(d.c.spu);
    }
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.pCc.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(179008);
  }
  
  private void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6334);
    if (this.pCI != null) {
      this.pCI.onProgressChanged(paramInt1, paramInt2);
    }
    cEQ();
    AppMethodBeat.o(6334);
  }
  
  public final void Nq()
  {
    AppMethodBeat.i(6313);
    this.pCA = true;
    bWT();
    AppMethodBeat.o(6313);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.d.f paramf)
  {
    this.sVJ = paramf;
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(6314);
    this.pCA = false;
    bWT();
    AppMethodBeat.o(6314);
  }
  
  public final void bUI()
  {
    AppMethodBeat.i(6300);
    if ((this.pCF) && (this.pCG)) {
      this.pCu.setVisibility(8);
    }
    AppMethodBeat.o(6300);
  }
  
  public final boolean bVa()
  {
    return false;
  }
  
  public final void bVb()
  {
    AppMethodBeat.i(6312);
    if (bVd())
    {
      hide();
      AppMethodBeat.o(6312);
      return;
    }
    bVc();
    AppMethodBeat.o(6312);
  }
  
  public final void bVc()
  {
    AppMethodBeat.i(6306);
    show();
    if (this.pCz == null) {
      this.pCz = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(266918);
          if ((MPVideoViewControlBar.a(MPVideoViewControlBar.this)) || (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0))
          {
            AppMethodBeat.o(266918);
            return true;
          }
          MPVideoViewControlBar.this.hide();
          MPVideoViewControlBar.c(MPVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(266918);
          return false;
        }
      }, false);
    }
    this.pCz.stopTimer();
    this.pCz.startTimer(4000L);
    AppMethodBeat.o(6306);
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(6311);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(6311);
      return true;
    }
    AppMethodBeat.o(6311);
    return false;
  }
  
  public final boolean bVe()
  {
    return this.pCA;
  }
  
  public final boolean bVf()
  {
    return true;
  }
  
  public final void bVg()
  {
    AppMethodBeat.i(6319);
    if (this.puW == null) {
      this.puW = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(266770);
          if (!MPVideoViewControlBar.f(MPVideoViewControlBar.this))
          {
            AppMethodBeat.o(266770);
            return false;
          }
          AppMethodBeat.o(266770);
          return true;
        }
      }, true);
    }
    bWX();
    this.puW.stopTimer();
    this.puW.startTimer(500L);
    AppMethodBeat.o(6319);
  }
  
  public final void bVh()
  {
    AppMethodBeat.i(6320);
    if (this.puW != null) {
      this.puW.stopTimer();
    }
    AppMethodBeat.o(6320);
  }
  
  public final void bVi()
  {
    AppMethodBeat.i(6307);
    if (this.pCz != null)
    {
      this.pCz.stopTimer();
      this.pCz.startTimer(4000L);
    }
    AppMethodBeat.o(6307);
  }
  
  public final void bVj()
  {
    AppMethodBeat.i(6301);
    if ((this.pCF) && (this.pCG)) {
      this.pCu.setVisibility(0);
    }
    AppMethodBeat.o(6301);
  }
  
  public final boolean bVk()
  {
    AppMethodBeat.i(6332);
    if (this.pCs != null)
    {
      if ((getVisibility() == 0) && (this.pCs.getVisibility() == 0))
      {
        AppMethodBeat.o(6332);
        return true;
      }
      AppMethodBeat.o(6332);
      return false;
    }
    AppMethodBeat.o(6332);
    return false;
  }
  
  public final void bWO()
  {
    AppMethodBeat.i(6328);
    if (this.pCf == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.oZf)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.pCb == null)
    {
      AppMethodBeat.o(6328);
      return;
    }
    this.pCd.setText(AQ(this.mPosition / 60) + ":" + AQ(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCb.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = eL(this.mPosition, i);
    this.pCb.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.pCf * i));
    this.pBZ.setLayoutParams(localLayoutParams);
    requestLayout();
    eK(this.mPosition, this.pCf);
    AppMethodBeat.o(6328);
  }
  
  public final void cEO()
  {
    AppMethodBeat.i(6308);
    if (this.pCz != null) {
      this.pCz.stopTimer();
    }
    AppMethodBeat.o(6308);
  }
  
  public int getLayoutId()
  {
    return com.tencent.mm.plugin.brandservice.d.f.suu;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(6309);
    if (this.sVE == null)
    {
      this.sVE = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.brandservice.d.a.push_down_out);
      this.sVE.setDuration(300L);
    }
    this.pCq.clearAnimation();
    this.pCq.startAnimation(this.sVE);
    if (this.pCA)
    {
      if (this.sVG == null)
      {
        this.sVG = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.brandservice.d.a.push_up_out);
        this.sVG.setDuration(300L);
      }
      this.pCw.clearAnimation();
      this.pCw.startAnimation(this.sVG);
      this.sVs.clearAnimation();
      this.sVs.startAnimation(this.sVG);
    }
    if (this.sVx.getVisibility() == 0) {
      this.sVx.startAnimation(this.sVE);
    }
    if (this.sVA.getVisibility() == 0) {
      this.sVA.startAnimation(this.sVE);
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266473);
        MPVideoViewControlBar.this.setVisibility(8);
        MPVideoViewControlBar.d(MPVideoViewControlBar.this);
        MPVideoViewControlBar.e(MPVideoViewControlBar.this);
        MPVideoViewControlBar.b(MPVideoViewControlBar.this).clearAnimation();
        AppMethodBeat.o(266473);
      }
    }, 200L);
    AppMethodBeat.o(6309);
  }
  
  public final void init()
  {
    AppMethodBeat.i(6290);
    super.init();
    this.pCo = ((ImageView)this.contentView.findViewById(com.tencent.mm.plugin.brandservice.d.e.full_screen_btn));
    this.pCr = ((ImageView)this.contentView.findViewById(com.tencent.mm.plugin.brandservice.d.e.player_progress_bar_middle));
    this.pCs = ((FrameLayout)this.contentView.findViewById(com.tencent.mm.plugin.brandservice.d.e.player_progress_root));
    this.pCq = ((LinearLayout)findViewById(com.tencent.mm.plugin.brandservice.d.e.root));
    this.sVq = ((RelativeLayout)findViewById(com.tencent.mm.plugin.brandservice.d.e.ssv));
    this.sVx = ((LinearLayout)findViewById(com.tencent.mm.plugin.brandservice.d.e.ssM));
    this.sVv = ((TextView)findViewById(com.tencent.mm.plugin.brandservice.d.e.ssO));
    this.sVw = findViewById(com.tencent.mm.plugin.brandservice.d.e.ssN);
    this.sVA = ((LinearLayout)findViewById(com.tencent.mm.plugin.brandservice.d.e.ssX));
    this.sVy = ((TextView)findViewById(com.tencent.mm.plugin.brandservice.d.e.ssZ));
    this.sVz = findViewById(com.tencent.mm.plugin.brandservice.d.e.ssY);
    this.pCt = ((ImageView)findViewById(com.tencent.mm.plugin.brandservice.d.e.mute_btn));
    this.pCu = ((ImageView)findViewById(com.tencent.mm.plugin.brandservice.d.e.center_play_btn));
    this.pCv = ((ImageView)findViewById(com.tencent.mm.plugin.brandservice.d.e.exit_fullscreen_btn));
    this.wB = ((TextView)findViewById(com.tencent.mm.plugin.brandservice.d.e.title));
    this.pCw = ((LinearLayout)findViewById(com.tencent.mm.plugin.brandservice.d.e.fullscreen_title_bar));
    this.pCx = ((LinearLayout)findViewById(com.tencent.mm.plugin.brandservice.d.e.player_progress_bar));
    this.sVs = ((LinearLayout)findViewById(com.tencent.mm.plugin.brandservice.d.e.ssb));
    this.sVt = ((ImageView)findViewById(com.tencent.mm.plugin.brandservice.d.e.srY));
    this.sVu = ((TextView)findViewById(com.tencent.mm.plugin.brandservice.d.e.srZ));
    this.pCq.setOnClickListener(new MPVideoViewControlBar.5(this));
    AppMethodBeat.o(6290);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6288);
    if (this.puW != null) {
      this.puW.stopTimer();
    }
    if (this.pCz != null) {
      this.pCz.stopTimer();
    }
    AppMethodBeat.o(6288);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(6327);
    super.seek(paramInt);
    eK(this.mPosition, this.pCf);
    AppMethodBeat.o(6327);
  }
  
  public void setDanmakuBtnOnClickListener(d.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public void setDirection(int paramInt)
  {
    this.puh = paramInt;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6292);
    this.pCv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6292);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6304);
    this.pCo.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6304);
  }
  
  public void setIplaySeekCallback(com.tencent.mm.plugin.appbrand.jsapi.video.d.d paramd)
  {
    AppMethodBeat.i(6289);
    setIplaySeekCallback(new MPVideoViewControlBar.1(this, paramd));
    AppMethodBeat.o(6289);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(6303);
    this.fEq = paramBoolean;
    if (this.fEq)
    {
      this.pCc.setImageDrawable(au.o(getContext(), d.h.icons_filled_pause, -1));
      this.pCu.setImageResource(d.h.mp_video_play_btn_pause);
      AppMethodBeat.o(6303);
      return;
    }
    this.pCc.setImageDrawable(au.o(getContext(), d.h.icons_filled_play, -1));
    this.pCu.setImageResource(d.h.mp_video_play_btn_play);
    AppMethodBeat.o(6303);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6291);
    this.pCt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6291);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(6296);
    if (paramBoolean)
    {
      this.pCt.setImageResource(d.h.mp_video_mute_btn_off);
      AppMethodBeat.o(6296);
      return;
    }
    this.pCt.setImageResource(d.h.mp_video_mute_btn_on);
    AppMethodBeat.o(6296);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6293);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.pCu.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6293);
  }
  
  public void setOnUpdateProgressLenListener(com.tencent.mm.plugin.appbrand.jsapi.video.d.e parame)
  {
    this.pCI = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(6299);
    this.pCG = paramBoolean;
    bWQ();
    AppMethodBeat.o(6299);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6297);
    this.pCE = paramBoolean;
    bWY();
    AppMethodBeat.o(6297);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6329);
    this.pCC = paramBoolean;
    bWS();
    bWP();
    AppMethodBeat.o(6329);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6295);
    ImageView localImageView = this.pCt;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(6295);
      return;
    }
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6330);
    this.pCF = paramBoolean;
    bWQ();
    AppMethodBeat.o(6330);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6331);
    this.pCD = paramBoolean;
    bWY();
    AppMethodBeat.o(6331);
  }
  
  public void setStatePorter(com.tencent.mm.plugin.appbrand.jsapi.video.d.i parami)
  {
    this.pCy = parami;
  }
  
  public void setSwitchResolutionListener(a parama)
  {
    this.sVB = parama;
  }
  
  public void setSwitchSpeedListener(b paramb)
  {
    this.sVC = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(6294);
    if (!Util.isNullOrNil(paramString)) {
      this.wB.setText(paramString);
    }
    AppMethodBeat.o(6294);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(6335);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.sVJ != null)
      {
        this.sVJ.onVisibilityChanged(true);
        AppMethodBeat.o(6335);
      }
    }
    else if (((paramInt == 8) || (paramInt == 4)) && (this.sVJ != null)) {
      this.sVJ.onVisibilityChanged(false);
    }
    AppMethodBeat.o(6335);
  }
  
  public final void show()
  {
    AppMethodBeat.i(6310);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(6310);
      return;
    }
    if (this.sVD == null)
    {
      this.sVD = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.brandservice.d.a.push_up_in);
      this.sVD.setDuration(300L);
    }
    this.pCq.clearAnimation();
    this.pCq.startAnimation(this.sVD);
    if (this.pCA)
    {
      if (this.sVF == null)
      {
        this.sVF = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.brandservice.d.a.push_down_in);
        this.sVF.setDuration(300L);
      }
      this.pCw.clearAnimation();
      this.pCw.startAnimation(this.sVF);
      this.sVs.clearAnimation();
      this.sVs.startAnimation(this.sVF);
    }
    setVisibility(0);
    AppMethodBeat.o(6310);
  }
  
  public static abstract interface a
  {
    public abstract void b(fv paramfv);
    
    public abstract void cEM();
    
    public abstract void cEN();
  }
  
  public static abstract interface b
  {
    public abstract void a(fv paramfv);
    
    public abstract void cEK();
    
    public abstract void cEL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */