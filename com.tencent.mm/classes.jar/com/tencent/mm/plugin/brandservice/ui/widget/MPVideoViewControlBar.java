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
import com.tencent.mm.aw.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.tools.o;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class MPVideoViewControlBar
  extends VideoPlayerSeekBar
  implements e.a, com.tencent.mm.pluginsdk.ui.g
{
  private int aag;
  private TextView avQ;
  private av krU;
  private ImageView ktA;
  private LinearLayout ktB;
  private LinearLayout ktC;
  private e.i ktD;
  private av ktE;
  private boolean ktF;
  private boolean ktH;
  private boolean ktI;
  private boolean ktJ;
  private boolean ktK;
  private boolean ktL;
  private e.e ktN;
  private ImageView ktt;
  private LinearLayout ktv;
  private ImageView ktw;
  private FrameLayout ktx;
  private ImageView kty;
  private ImageView ktz;
  private RelativeLayout noB;
  private LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> noC;
  private LinearLayout noD;
  private ImageView noE;
  private TextView noF;
  private TextView noG;
  private View noH;
  private LinearLayout noI;
  private TextView noJ;
  private View noK;
  private LinearLayout noL;
  private a noM;
  private b noN;
  private Animation noO;
  private Animation noP;
  private Animation noQ;
  private Animation noR;
  private LinkedList<fn> noS;
  private fn noT;
  private e.f noU;
  
  public MPVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6285);
    this.noC = null;
    this.noS = new LinkedList();
    AppMethodBeat.o(6285);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6286);
    this.noC = null;
    this.noS = new LinkedList();
    AppMethodBeat.o(6286);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6287);
    this.noC = null;
    this.noS = new LinkedList();
    AppMethodBeat.o(6287);
  }
  
  private boolean bGU()
  {
    return (this.ktF) && ((90 == this.aag) || (-90 == this.aag));
  }
  
  private void bGV()
  {
    AppMethodBeat.i(6322);
    if (bt.gL(this.noC))
    {
      AppMethodBeat.o(6322);
      return;
    }
    Iterator localIterator = this.noC.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localIterator.next();
      if (localc.nkN <= this.mPosition)
      {
        if (localc.nkL) {
          break label108;
        }
        i = 1;
      }
      else
      {
        if (!localc.nkL) {
          break label108;
        }
        i = 1;
      }
    }
    label108:
    for (;;)
    {
      break;
      if (i != 0) {
        L(this.noC);
      }
      AppMethodBeat.o(6322);
      return;
    }
  }
  
  private void bGW()
  {
    AppMethodBeat.i(6325);
    if ((!bGU()) || (bt.gL(this.noS)) || (this.noT == null))
    {
      bGX();
      this.noH.setVisibility(8);
      AppMethodBeat.o(6325);
      return;
    }
    this.noG.setText(this.noT.CAn);
    this.noH.setVisibility(0);
    this.noH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6284);
        if (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0)
        {
          MPVideoViewControlBar.d(MPVideoViewControlBar.this);
          if (MPVideoViewControlBar.this.bTK())
          {
            MPVideoViewControlBar.this.bcH();
            AppMethodBeat.o(6284);
          }
        }
        else
        {
          if (MPVideoViewControlBar.h(MPVideoViewControlBar.this) != null) {
            MPVideoViewControlBar.h(MPVideoViewControlBar.this).bGj();
          }
          MPVideoViewControlBar.i(MPVideoViewControlBar.this);
          MPVideoViewControlBar.j(MPVideoViewControlBar.this);
        }
        AppMethodBeat.o(6284);
      }
    });
    AppMethodBeat.o(6325);
  }
  
  private void bGX()
  {
    AppMethodBeat.i(6326);
    ad.d("MicroMsg.MPVideoViewControlBar", "hideResolutionContainer");
    if (this.noI.getVisibility() != 8)
    {
      this.noI.setVisibility(8);
      if (this.noM != null) {
        this.noM.bGk();
      }
    }
    AppMethodBeat.o(6326);
  }
  
  private void bGY()
  {
    AppMethodBeat.i(179005);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmM, 1) == 0) {}
    for (int i = 1; (!bGU()) || (bt.gL(this.noS)) || (this.noT == null) || (i != 0); i = 0)
    {
      bGZ();
      this.noK.setVisibility(8);
      AppMethodBeat.o(179005);
      return;
    }
    Object localObject = c.nnW;
    if (c.bGK().nod == 1.0F) {}
    for (localObject = getResources().getString(2131764684);; localObject = c.bGK().desc)
    {
      this.noJ.setText((CharSequence)localObject);
      this.noK.setVisibility(0);
      this.noK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179004);
          m.yC(42);
          if (MPVideoViewControlBar.k(MPVideoViewControlBar.this).getVisibility() == 0)
          {
            MPVideoViewControlBar.e(MPVideoViewControlBar.this);
            if (MPVideoViewControlBar.this.bTK())
            {
              MPVideoViewControlBar.this.bcH();
              AppMethodBeat.o(179004);
            }
          }
          else
          {
            if (MPVideoViewControlBar.l(MPVideoViewControlBar.this) != null) {
              MPVideoViewControlBar.l(MPVideoViewControlBar.this).bGR();
            }
            MPVideoViewControlBar.m(MPVideoViewControlBar.this);
            MPVideoViewControlBar.n(MPVideoViewControlBar.this);
          }
          AppMethodBeat.o(179004);
        }
      });
      AppMethodBeat.o(179005);
      return;
      localObject = c.nnW;
    }
  }
  
  private void bGZ()
  {
    AppMethodBeat.i(179006);
    ad.d("MicroMsg.MPVideoViewControlBar", "hideSpeedContainer");
    if (this.noL.getVisibility() != 8)
    {
      this.noL.setVisibility(8);
      if (this.noN != null) {
        this.noN.bGS();
      }
    }
    AppMethodBeat.o(179006);
  }
  
  private void bHa()
  {
    AppMethodBeat.i(179007);
    ImageView localImageView = this.kty;
    if (this.ktF) {}
    for (int i = 8;; i = 0)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(179007);
      return;
    }
  }
  
  private void bHb()
  {
    AppMethodBeat.i(179008);
    ViewGroup.LayoutParams localLayoutParams = this.kth.getLayoutParams();
    int i = getResources().getDimensionPixelSize(2131166603);
    if (this.ktF) {
      i = getResources().getDimensionPixelSize(2131166602);
    }
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.kth.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(179008);
  }
  
  private void bdU()
  {
    AppMethodBeat.i(6298);
    if (this.ktF)
    {
      this.ktB.setVisibility(0);
      this.noD.setVisibility(0);
      AppMethodBeat.o(6298);
      return;
    }
    this.ktB.setVisibility(8);
    this.noD.setVisibility(8);
    AppMethodBeat.o(6298);
  }
  
  private void bdV()
  {
    AppMethodBeat.i(6302);
    if (this.ktK)
    {
      if (this.ktL)
      {
        this.kth.setVisibility(8);
        this.ktz.setVisibility(0);
        AppMethodBeat.o(6302);
        return;
      }
      this.kth.setVisibility(0);
      this.ktz.setVisibility(8);
      AppMethodBeat.o(6302);
      return;
    }
    this.kth.setVisibility(8);
    this.ktz.setVisibility(8);
    AppMethodBeat.o(6302);
  }
  
  private void bdX()
  {
    AppMethodBeat.i(6305);
    if (this.ktH)
    {
      this.ktt.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.ktt.getLayoutParams();
      getResources().getDimensionPixelSize(2131166603);
      if (this.ktF) {
        this.ktt.setImageResource(2131233933);
      }
      for (int i = getResources().getDimensionPixelSize(2131166601);; i = getResources().getDimensionPixelSize(2131166603))
      {
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        this.ktt.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(6305);
        return;
        this.ktt.setImageResource(2131690861);
      }
    }
    this.ktt.setVisibility(8);
    AppMethodBeat.o(6305);
  }
  
  private void bdY()
  {
    AppMethodBeat.i(6315);
    beb();
    bdX();
    bdU();
    bea();
    bdZ();
    L(this.noC);
    bGW();
    bGY();
    bHa();
    bHb();
    AppMethodBeat.o(6315);
  }
  
  private void bdZ()
  {
    AppMethodBeat.i(6316);
    if (bGU()) {}
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166587))
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
      if (this.noH != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.noH.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.noH.setLayoutParams(localMarginLayoutParams);
      }
      if (this.noK != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.noH.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.noK.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(6316);
      return;
    }
  }
  
  private void bea()
  {
    AppMethodBeat.i(6317);
    if (bGU()) {}
    for (float f = getResources().getDimensionPixelSize(2131166600);; f = getResources().getDimensionPixelSize(2131166593))
    {
      this.kti.setTextSize(0, f);
      this.ktj.setTextSize(0, f);
      AppMethodBeat.o(6317);
      return;
    }
  }
  
  private void beb()
  {
    AppMethodBeat.i(6318);
    ViewGroup.LayoutParams localLayoutParams = this.ktv.getLayoutParams();
    int j;
    if (this.ktF)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166598);
      this.ktv.setLayoutParams(localLayoutParams);
      if (!bGU()) {
        break label143;
      }
      j = getResources().getDimensionPixelSize(2131166599);
    }
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166590))
    {
      this.ktv.setPadding(0, 0, i, 0);
      if (this.ktB != null) {
        this.ktB.setPadding(j, 0, j, 0);
      }
      if (this.noD != null) {
        this.noD.setPadding(j, 0, j, 0);
      }
      AppMethodBeat.o(6318);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166589);
      break;
      label143:
      j = getResources().getDimensionPixelSize(2131166590);
    }
  }
  
  private boolean bec()
  {
    AppMethodBeat.i(6321);
    if (this.ktD == null)
    {
      ad.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(6321);
      return false;
    }
    int k = this.ktD.bcl();
    int j = this.ktD.bcm();
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktw.getLayoutParams();
      localLayoutParams.width = i;
      this.ktw.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(6321);
      return true;
      d = k;
    }
  }
  
  private void bed()
  {
    int j = 0;
    AppMethodBeat.i(6333);
    boolean bool;
    Object localObject;
    if (this.ktJ)
    {
      bool = this.ktI;
      localObject = this.ktx;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.kti;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.ktj;
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
  
  private void dW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6334);
    if (this.ktN != null) {
      this.ktN.onProgressChanged(paramInt1, paramInt2);
    }
    bGV();
    AppMethodBeat.o(6334);
  }
  
  public final void L(LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> paramLinkedList)
  {
    AppMethodBeat.i(6323);
    this.noC = paramLinkedList;
    if ((this.noB == null) || (bt.gL(this.noC)))
    {
      this.noB.removeAllViews();
      AppMethodBeat.o(6323);
      return;
    }
    ad.i("MicroMsg.MPVideoViewControlBar", "updateControlBarDotPos");
    aq.n(new MPVideoViewControlBar.10(this, paramLinkedList), 100L);
    AppMethodBeat.o(6323);
  }
  
  public final void M(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(193012);
    a locala = a.ayO();
    ImageView localImageView = this.noE;
    com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
    locala1.gkG = true;
    locala1.hkf = 2131231342;
    locala.a(paramString3, localImageView, locala1.azc());
    this.noF.setText(paramString1);
    this.noD.setOnClickListener(null);
    this.noD.setOnClickListener(new MPVideoViewControlBar.6(this, paramString2));
    o.gp(this.noD);
    AppMethodBeat.o(193012);
  }
  
  public final void a(e.f paramf)
  {
    this.noU = paramf;
  }
  
  public final void a(LinkedList<fn> paramLinkedList, fn paramfn)
  {
    AppMethodBeat.i(6324);
    if ((paramLinkedList == null) || (paramfn == null))
    {
      AppMethodBeat.o(6324);
      return;
    }
    this.noS.clear();
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      fn localfn = (fn)paramLinkedList.next();
      if ((!bt.isNullOrNil(localfn.CAn)) && (!localHashSet.contains(Integer.valueOf(localfn.CAm))))
      {
        this.noS.add(localfn);
        localHashSet.add(Integer.valueOf(localfn.CAm));
      }
    }
    Collections.sort(this.noS, new Comparator() {});
    this.noT = paramfn;
    AppMethodBeat.o(6324);
  }
  
  public final void bGT()
  {
    AppMethodBeat.i(6308);
    if (this.ktE != null) {
      this.ktE.stopTimer();
    }
    AppMethodBeat.o(6308);
  }
  
  public final void bah()
  {
    AppMethodBeat.i(6314);
    this.ktF = false;
    bdY();
    AppMethodBeat.o(6314);
  }
  
  public final void bcA()
  {
    AppMethodBeat.i(6306);
    show();
    if (this.ktE == null) {
      this.ktE = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(193008);
          if ((MPVideoViewControlBar.a(MPVideoViewControlBar.this)) || (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0))
          {
            AppMethodBeat.o(193008);
            return true;
          }
          MPVideoViewControlBar.this.hide();
          MPVideoViewControlBar.c(MPVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(193008);
          return false;
        }
      }, false);
    }
    this.ktE.stopTimer();
    this.ktE.av(4000L, 4000L);
    AppMethodBeat.o(6306);
  }
  
  public final boolean bcB()
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
  
  public final void bcC()
  {
    AppMethodBeat.i(6313);
    this.ktF = true;
    bdY();
    AppMethodBeat.o(6313);
  }
  
  public final boolean bcD()
  {
    return this.ktF;
  }
  
  public final boolean bcE()
  {
    return true;
  }
  
  public final void bcF()
  {
    AppMethodBeat.i(6319);
    if (this.krU == null) {
      this.krU = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(193010);
          if (!MPVideoViewControlBar.f(MPVideoViewControlBar.this))
          {
            AppMethodBeat.o(193010);
            return false;
          }
          AppMethodBeat.o(193010);
          return true;
        }
      }, true);
    }
    bec();
    this.krU.stopTimer();
    this.krU.av(500L, 500L);
    AppMethodBeat.o(6319);
  }
  
  public final void bcG()
  {
    AppMethodBeat.i(6320);
    if (this.krU != null) {
      this.krU.stopTimer();
    }
    AppMethodBeat.o(6320);
  }
  
  public final void bcH()
  {
    AppMethodBeat.i(6307);
    if (this.ktE != null)
    {
      this.ktE.stopTimer();
      this.ktE.av(4000L, 4000L);
    }
    AppMethodBeat.o(6307);
  }
  
  public final void bcI()
  {
    AppMethodBeat.i(6301);
    if ((this.ktK) && (this.ktL)) {
      this.ktz.setVisibility(0);
    }
    AppMethodBeat.o(6301);
  }
  
  public final boolean bcJ()
  {
    AppMethodBeat.i(6332);
    if (this.ktx != null)
    {
      if ((getVisibility() == 0) && (this.ktx.getVisibility() == 0))
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
  
  public final void bce()
  {
    AppMethodBeat.i(6300);
    if ((this.ktK) && (this.ktL)) {
      this.ktz.setVisibility(8);
    }
    AppMethodBeat.o(6300);
  }
  
  public final boolean bcy()
  {
    return false;
  }
  
  public final void bcz()
  {
    AppMethodBeat.i(6312);
    if (bcB())
    {
      hide();
      AppMethodBeat.o(6312);
      return;
    }
    bcA();
    AppMethodBeat.o(6312);
  }
  
  public final void bdT()
  {
    AppMethodBeat.i(6328);
    if (this.ktk == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.jVE)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.ktg == null)
    {
      AppMethodBeat.o(6328);
      return;
    }
    this.kti.setText(rX(this.mPosition / 60) + ":" + rX(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(6328);
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
    AppMethodBeat.o(6328);
  }
  
  public int getLayoutId()
  {
    return 2131494960;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(6309);
    if (this.noP == null)
    {
      this.noP = AnimationUtils.loadAnimation(getContext(), 2130772106);
      this.noP.setDuration(300L);
    }
    this.ktv.clearAnimation();
    this.ktv.startAnimation(this.noP);
    if (this.ktF)
    {
      if (this.noR == null)
      {
        this.noR = AnimationUtils.loadAnimation(getContext(), 2130772109);
        this.noR.setDuration(300L);
      }
      this.ktB.clearAnimation();
      this.ktB.startAnimation(this.noR);
      this.noD.clearAnimation();
      this.noD.startAnimation(this.noR);
    }
    if (this.noI.getVisibility() == 0) {
      this.noI.startAnimation(this.noP);
    }
    if (this.noL.getVisibility() == 0) {
      this.noL.startAnimation(this.noP);
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193009);
        MPVideoViewControlBar.this.setVisibility(8);
        MPVideoViewControlBar.d(MPVideoViewControlBar.this);
        MPVideoViewControlBar.e(MPVideoViewControlBar.this);
        MPVideoViewControlBar.b(MPVideoViewControlBar.this).clearAnimation();
        AppMethodBeat.o(193009);
      }
    }, 200L);
    AppMethodBeat.o(6309);
  }
  
  public final void init()
  {
    AppMethodBeat.i(6290);
    super.init();
    this.ktt = ((ImageView)this.contentView.findViewById(2131300325));
    this.ktw = ((ImageView)this.contentView.findViewById(2131303303));
    this.ktx = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.ktv = ((LinearLayout)findViewById(2131304239));
    this.noB = ((RelativeLayout)findViewById(2131303295));
    this.noI = ((LinearLayout)findViewById(2131304134));
    this.noG = ((TextView)findViewById(2131304136));
    this.noH = findViewById(2131304135);
    this.noL = ((LinearLayout)findViewById(2131305144));
    this.noJ = ((TextView)findViewById(2131305146));
    this.noK = findViewById(2131305145);
    this.kty = ((ImageView)findViewById(2131302621));
    this.ktz = ((ImageView)findViewById(2131297935));
    this.ktA = ((ImageView)findViewById(2131299599));
    this.avQ = ((TextView)findViewById(2131305902));
    this.ktB = ((LinearLayout)findViewById(2131300332));
    this.ktC = ((LinearLayout)findViewById(2131303300));
    this.noD = ((LinearLayout)findViewById(2131302509));
    this.noE = ((ImageView)findViewById(2131302499));
    this.noF = ((TextView)findViewById(2131302500));
    this.ktv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6278);
        AppMethodBeat.o(6278);
      }
    });
    AppMethodBeat.o(6290);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6288);
    if (this.krU != null) {
      this.krU.stopTimer();
    }
    if (this.ktE != null) {
      this.ktE.stopTimer();
    }
    AppMethodBeat.o(6288);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(6327);
    super.seek(paramInt);
    dW(this.mPosition, this.ktk);
    AppMethodBeat.o(6327);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public void setDirection(int paramInt)
  {
    this.aag = paramInt;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6292);
    this.ktA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6292);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6304);
    this.ktt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6304);
  }
  
  public void setIplaySeekCallback(final e.d paramd)
  {
    AppMethodBeat.i(6289);
    setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void bcv()
      {
        AppMethodBeat.i(6276);
        paramd.bcv();
        AppMethodBeat.o(6276);
      }
      
      public final void rZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(6277);
        paramd.rZ(paramAnonymousInt);
        AppMethodBeat.o(6277);
      }
    });
    AppMethodBeat.o(6289);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(6303);
    this.dkr = paramBoolean;
    if (this.dkr)
    {
      this.kth.setImageDrawable(am.i(getContext(), 2131690445, -1));
      this.ktz.setImageResource(2131690871);
      AppMethodBeat.o(6303);
      return;
    }
    this.kth.setImageDrawable(am.i(getContext(), 2131690459, -1));
    this.ktz.setImageResource(2131690872);
    AppMethodBeat.o(6303);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6291);
    this.kty.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6291);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(6296);
    if (paramBoolean)
    {
      this.kty.setImageResource(2131690867);
      AppMethodBeat.o(6296);
      return;
    }
    this.kty.setImageResource(2131690868);
    AppMethodBeat.o(6296);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6293);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.ktz.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6293);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.ktN = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(6299);
    this.ktL = paramBoolean;
    bdV();
    AppMethodBeat.o(6299);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6297);
    this.ktJ = paramBoolean;
    bed();
    AppMethodBeat.o(6297);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6329);
    this.ktH = paramBoolean;
    bdX();
    bdU();
    AppMethodBeat.o(6329);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6295);
    ImageView localImageView = this.kty;
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
    this.ktK = paramBoolean;
    bdV();
    AppMethodBeat.o(6330);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6331);
    this.ktI = paramBoolean;
    bed();
    AppMethodBeat.o(6331);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.ktD = parami;
  }
  
  public void setSwitchResolutionListener(a parama)
  {
    this.noM = parama;
  }
  
  public void setSwitchSpeedListener(b paramb)
  {
    this.noN = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(6294);
    if (!bt.isNullOrNil(paramString)) {
      this.avQ.setText(paramString);
    }
    AppMethodBeat.o(6294);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(6335);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.noU != null)
      {
        this.noU.onVisibilityChanged(true);
        AppMethodBeat.o(6335);
      }
    }
    else if (((paramInt == 8) || (paramInt == 4)) && (this.noU != null)) {
      this.noU.onVisibilityChanged(false);
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
    if (this.noO == null)
    {
      this.noO = AnimationUtils.loadAnimation(getContext(), 2130772108);
      this.noO.setDuration(300L);
    }
    this.ktv.clearAnimation();
    this.ktv.startAnimation(this.noO);
    if (this.ktF)
    {
      if (this.noQ == null)
      {
        this.noQ = AnimationUtils.loadAnimation(getContext(), 2130772105);
        this.noQ.setDuration(300L);
      }
      this.ktB.clearAnimation();
      this.ktB.startAnimation(this.noQ);
      this.noD.clearAnimation();
      this.noD.startAnimation(this.noQ);
    }
    setVisibility(0);
    AppMethodBeat.o(6310);
  }
  
  public static abstract interface a
  {
    public abstract void a(fn paramfn, int paramInt1, int paramInt2);
    
    public abstract void bGj();
    
    public abstract void bGk();
  }
  
  public static abstract interface b
  {
    public abstract void a(fn paramfn, c.a parama1, c.a parama2);
    
    public abstract void bGR();
    
    public abstract void bGS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */