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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.o;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class MPVideoViewControlBar
  extends VideoPlayerSeekBar
  implements e.a, h
{
  private int acQ;
  private TextView ayB;
  private av llt;
  private ImageView lrG;
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
  private boolean lrU;
  private boolean lrV;
  private boolean lrW;
  private boolean lrX;
  private boolean lrY;
  private e.e lsa;
  private LinkedList<fu> ouA;
  private fu ouB;
  private e.f ouC;
  private RelativeLayout oui;
  private LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> ouj;
  private LinearLayout ouk;
  private ImageView oul;
  private TextView oum;
  private TextView oun;
  private View ouo;
  private LinearLayout oup;
  private TextView ouq;
  private View our;
  private LinearLayout ous;
  private a ouu;
  private b ouv;
  private Animation ouw;
  private Animation oux;
  private Animation ouy;
  private Animation ouz;
  
  public MPVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6285);
    this.ouj = null;
    this.ouA = new LinkedList();
    AppMethodBeat.o(6285);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6286);
    this.ouj = null;
    this.ouA = new LinkedList();
    AppMethodBeat.o(6286);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6287);
    this.ouj = null;
    this.ouA = new LinkedList();
    AppMethodBeat.o(6287);
  }
  
  private boolean bSI()
  {
    return (this.lrS) && ((90 == this.acQ) || (-90 == this.acQ));
  }
  
  private void bSJ()
  {
    AppMethodBeat.i(6322);
    if (bt.hj(this.ouj))
    {
      AppMethodBeat.o(6322);
      return;
    }
    Iterator localIterator = this.ouj.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localIterator.next();
      if (localc.oqt <= this.mPosition)
      {
        if (localc.oqr) {
          break label108;
        }
        i = 1;
      }
      else
      {
        if (!localc.oqr) {
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
        L(this.ouj);
      }
      AppMethodBeat.o(6322);
      return;
    }
  }
  
  private void bSK()
  {
    AppMethodBeat.i(6325);
    if ((!bSI()) || (bt.hj(this.ouA)) || (this.ouB == null))
    {
      bSL();
      this.ouo.setVisibility(8);
      AppMethodBeat.o(6325);
      return;
    }
    this.oun.setText(this.ouB.Fyc);
    this.ouo.setVisibility(0);
    this.ouo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6284);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0)
        {
          MPVideoViewControlBar.d(MPVideoViewControlBar.this);
          if (MPVideoViewControlBar.this.cfC()) {
            MPVideoViewControlBar.this.bno();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6284);
          return;
          if (MPVideoViewControlBar.h(MPVideoViewControlBar.this) != null) {
            MPVideoViewControlBar.h(MPVideoViewControlBar.this).bRW();
          }
          MPVideoViewControlBar.i(MPVideoViewControlBar.this);
          MPVideoViewControlBar.j(MPVideoViewControlBar.this);
        }
      }
    });
    AppMethodBeat.o(6325);
  }
  
  private void bSL()
  {
    AppMethodBeat.i(6326);
    ad.d("MicroMsg.MPVideoViewControlBar", "hideResolutionContainer");
    if (this.oup.getVisibility() != 8)
    {
      this.oup.setVisibility(8);
      if (this.ouu != null) {
        this.ouu.bRX();
      }
    }
    AppMethodBeat.o(6326);
  }
  
  private void bSM()
  {
    AppMethodBeat.i(179005);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quz, 1) == 0) {}
    for (int i = 1; (!bSI()) || (bt.hj(this.ouA)) || (this.ouB == null) || (i != 0); i = 0)
    {
      bSN();
      this.our.setVisibility(8);
      AppMethodBeat.o(179005);
      return;
    }
    Object localObject = c.otD;
    if (c.bSy().otK == 1.0F) {}
    for (localObject = getResources().getString(2131764684);; localObject = c.bSy().desc)
    {
      this.ouq.setText((CharSequence)localObject);
      this.our.setVisibility(0);
      this.our.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          m.Ac(42);
          if (MPVideoViewControlBar.k(MPVideoViewControlBar.this).getVisibility() == 0)
          {
            MPVideoViewControlBar.e(MPVideoViewControlBar.this);
            if (MPVideoViewControlBar.this.cfC()) {
              MPVideoViewControlBar.this.bno();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179004);
            return;
            if (MPVideoViewControlBar.l(MPVideoViewControlBar.this) != null) {
              MPVideoViewControlBar.l(MPVideoViewControlBar.this).bSF();
            }
            MPVideoViewControlBar.m(MPVideoViewControlBar.this);
            MPVideoViewControlBar.n(MPVideoViewControlBar.this);
          }
        }
      });
      AppMethodBeat.o(179005);
      return;
      localObject = c.otD;
    }
  }
  
  private void bSN()
  {
    AppMethodBeat.i(179006);
    ad.d("MicroMsg.MPVideoViewControlBar", "hideSpeedContainer");
    if (this.ous.getVisibility() != 8)
    {
      this.ous.setVisibility(8);
      if (this.ouv != null) {
        this.ouv.bSG();
      }
    }
    AppMethodBeat.o(179006);
  }
  
  private void bSO()
  {
    AppMethodBeat.i(179007);
    ImageView localImageView = this.lrL;
    if (this.lrS) {}
    for (int i = 8;; i = 0)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(179007);
      return;
    }
  }
  
  private void bSP()
  {
    AppMethodBeat.i(179008);
    ViewGroup.LayoutParams localLayoutParams = this.lru.getLayoutParams();
    int i = getResources().getDimensionPixelSize(2131166603);
    if (this.lrS) {
      i = getResources().getDimensionPixelSize(2131166602);
    }
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.lru.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(179008);
  }
  
  private void boA()
  {
    AppMethodBeat.i(6302);
    if (this.lrX)
    {
      if (this.lrY)
      {
        this.lru.setVisibility(8);
        this.lrM.setVisibility(0);
        AppMethodBeat.o(6302);
        return;
      }
      this.lru.setVisibility(0);
      this.lrM.setVisibility(8);
      AppMethodBeat.o(6302);
      return;
    }
    this.lru.setVisibility(8);
    this.lrM.setVisibility(8);
    AppMethodBeat.o(6302);
  }
  
  private void boC()
  {
    AppMethodBeat.i(6305);
    if (this.lrU)
    {
      this.lrG.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.lrG.getLayoutParams();
      getResources().getDimensionPixelSize(2131166603);
      if (this.lrS) {
        this.lrG.setImageResource(2131233933);
      }
      for (int i = getResources().getDimensionPixelSize(2131166601);; i = getResources().getDimensionPixelSize(2131166603))
      {
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        this.lrG.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(6305);
        return;
        this.lrG.setImageResource(2131690861);
      }
    }
    this.lrG.setVisibility(8);
    AppMethodBeat.o(6305);
  }
  
  private void boD()
  {
    AppMethodBeat.i(6315);
    boG();
    boC();
    boz();
    boF();
    boE();
    L(this.ouj);
    bSK();
    bSM();
    bSO();
    bSP();
    AppMethodBeat.o(6315);
  }
  
  private void boE()
  {
    AppMethodBeat.i(6316);
    if (bSI()) {}
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166587))
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
      if (this.ouo != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ouo.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.ouo.setLayoutParams(localMarginLayoutParams);
      }
      if (this.our != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ouo.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.our.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(6316);
      return;
    }
  }
  
  private void boF()
  {
    AppMethodBeat.i(6317);
    if (bSI()) {}
    for (float f = getResources().getDimensionPixelSize(2131166600);; f = getResources().getDimensionPixelSize(2131166593))
    {
      this.lrv.setTextSize(0, f);
      this.lrw.setTextSize(0, f);
      AppMethodBeat.o(6317);
      return;
    }
  }
  
  private void boG()
  {
    AppMethodBeat.i(6318);
    ViewGroup.LayoutParams localLayoutParams = this.lrI.getLayoutParams();
    int j;
    if (this.lrS)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166598);
      this.lrI.setLayoutParams(localLayoutParams);
      if (!bSI()) {
        break label143;
      }
      j = getResources().getDimensionPixelSize(2131166599);
    }
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166590))
    {
      this.lrI.setPadding(0, 0, i, 0);
      if (this.lrO != null) {
        this.lrO.setPadding(j, 0, j, 0);
      }
      if (this.ouk != null) {
        this.ouk.setPadding(j, 0, j, 0);
      }
      AppMethodBeat.o(6318);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166589);
      break;
      label143:
      j = getResources().getDimensionPixelSize(2131166590);
    }
  }
  
  private boolean boH()
  {
    AppMethodBeat.i(6321);
    if (this.lrQ == null)
    {
      ad.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(6321);
      return false;
    }
    int k = this.lrQ.bmT();
    int j = this.lrQ.bmU();
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrJ.getLayoutParams();
      localLayoutParams.width = i;
      this.lrJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(6321);
      return true;
      d = k;
    }
  }
  
  private void boI()
  {
    int j = 0;
    AppMethodBeat.i(6333);
    boolean bool;
    Object localObject;
    if (this.lrW)
    {
      bool = this.lrV;
      localObject = this.lrK;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.lrv;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.lrw;
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
  
  private void boz()
  {
    AppMethodBeat.i(6298);
    if (this.lrS)
    {
      this.lrO.setVisibility(0);
      this.ouk.setVisibility(0);
      AppMethodBeat.o(6298);
      return;
    }
    this.lrO.setVisibility(8);
    this.ouk.setVisibility(8);
    AppMethodBeat.o(6298);
  }
  
  private void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6334);
    if (this.lsa != null) {
      this.lsa.onProgressChanged(paramInt1, paramInt2);
    }
    bSJ();
    AppMethodBeat.o(6334);
  }
  
  public final void L(LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> paramLinkedList)
  {
    AppMethodBeat.i(6323);
    this.ouj = paramLinkedList;
    if ((this.oui == null) || (bt.hj(this.ouj)))
    {
      this.oui.removeAllViews();
      AppMethodBeat.o(6323);
      return;
    }
    ad.i("MicroMsg.MPVideoViewControlBar", "updateControlBarDotPos");
    aq.o(new MPVideoViewControlBar.10(this, paramLinkedList), 100L);
    AppMethodBeat.o(6323);
  }
  
  public final void N(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(209605);
    com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.a.a.aIP();
    ImageView localImageView = this.oul;
    com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
    locala1.hfi = true;
    locala1.idD = 2131231342;
    locala.a(paramString3, localImageView, locala1.aJc());
    this.oum.setText(paramString1);
    this.ouk.setOnClickListener(null);
    this.ouk.setOnClickListener(new MPVideoViewControlBar.6(this, paramString2));
    o.gU(this.ouk);
    AppMethodBeat.o(209605);
  }
  
  public final void a(e.f paramf)
  {
    this.ouC = paramf;
  }
  
  public final void a(LinkedList<fu> paramLinkedList, fu paramfu)
  {
    AppMethodBeat.i(6324);
    if ((paramLinkedList == null) || (paramfu == null))
    {
      AppMethodBeat.o(6324);
      return;
    }
    this.ouA.clear();
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      fu localfu = (fu)paramLinkedList.next();
      if ((!bt.isNullOrNil(localfu.Fyc)) && (!localHashSet.contains(Integer.valueOf(localfu.Fyb))))
      {
        this.ouA.add(localfu);
        localHashSet.add(Integer.valueOf(localfu.Fyb));
      }
    }
    Collections.sort(this.ouA, new Comparator() {});
    this.ouB = paramfu;
    AppMethodBeat.o(6324);
  }
  
  public final void bSH()
  {
    AppMethodBeat.i(6308);
    if (this.lrR != null) {
      this.lrR.stopTimer();
    }
    AppMethodBeat.o(6308);
  }
  
  public final void bkF()
  {
    AppMethodBeat.i(6314);
    this.lrS = false;
    boD();
    AppMethodBeat.o(6314);
  }
  
  public final void bmL()
  {
    AppMethodBeat.i(6300);
    if ((this.lrX) && (this.lrY)) {
      this.lrM.setVisibility(8);
    }
    AppMethodBeat.o(6300);
  }
  
  public final boolean bnf()
  {
    return false;
  }
  
  public final void bng()
  {
    AppMethodBeat.i(6312);
    if (bni())
    {
      hide();
      AppMethodBeat.o(6312);
      return;
    }
    bnh();
    AppMethodBeat.o(6312);
  }
  
  public final void bnh()
  {
    AppMethodBeat.i(6306);
    show();
    if (this.lrR == null) {
      this.lrR = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(209601);
          if ((MPVideoViewControlBar.a(MPVideoViewControlBar.this)) || (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0))
          {
            AppMethodBeat.o(209601);
            return true;
          }
          MPVideoViewControlBar.this.hide();
          MPVideoViewControlBar.c(MPVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(209601);
          return false;
        }
      }, false);
    }
    this.lrR.stopTimer();
    this.lrR.az(4000L, 4000L);
    AppMethodBeat.o(6306);
  }
  
  public final boolean bni()
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
  
  public final void bnj()
  {
    AppMethodBeat.i(6313);
    this.lrS = true;
    boD();
    AppMethodBeat.o(6313);
  }
  
  public final boolean bnk()
  {
    return this.lrS;
  }
  
  public final boolean bnl()
  {
    return true;
  }
  
  public final void bnm()
  {
    AppMethodBeat.i(6319);
    if (this.llt == null) {
      this.llt = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(209603);
          if (!MPVideoViewControlBar.f(MPVideoViewControlBar.this))
          {
            AppMethodBeat.o(209603);
            return false;
          }
          AppMethodBeat.o(209603);
          return true;
        }
      }, true);
    }
    boH();
    this.llt.stopTimer();
    this.llt.az(500L, 500L);
    AppMethodBeat.o(6319);
  }
  
  public final void bnn()
  {
    AppMethodBeat.i(6320);
    if (this.llt != null) {
      this.llt.stopTimer();
    }
    AppMethodBeat.o(6320);
  }
  
  public final void bno()
  {
    AppMethodBeat.i(6307);
    if (this.lrR != null)
    {
      this.lrR.stopTimer();
      this.lrR.az(4000L, 4000L);
    }
    AppMethodBeat.o(6307);
  }
  
  public final void bnp()
  {
    AppMethodBeat.i(6301);
    if ((this.lrX) && (this.lrY)) {
      this.lrM.setVisibility(0);
    }
    AppMethodBeat.o(6301);
  }
  
  public final boolean bnq()
  {
    AppMethodBeat.i(6332);
    if (this.lrK != null)
    {
      if ((getVisibility() == 0) && (this.lrK.getVisibility() == 0))
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
  
  public final void boy()
  {
    AppMethodBeat.i(6328);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(6328);
      return;
    }
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(6328);
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
    AppMethodBeat.o(6328);
  }
  
  public int getLayoutId()
  {
    return 2131494960;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(6309);
    if (this.oux == null)
    {
      this.oux = AnimationUtils.loadAnimation(getContext(), 2130772106);
      this.oux.setDuration(300L);
    }
    this.lrI.clearAnimation();
    this.lrI.startAnimation(this.oux);
    if (this.lrS)
    {
      if (this.ouz == null)
      {
        this.ouz = AnimationUtils.loadAnimation(getContext(), 2130772109);
        this.ouz.setDuration(300L);
      }
      this.lrO.clearAnimation();
      this.lrO.startAnimation(this.ouz);
      this.ouk.clearAnimation();
      this.ouk.startAnimation(this.ouz);
    }
    if (this.oup.getVisibility() == 0) {
      this.oup.startAnimation(this.oux);
    }
    if (this.ous.getVisibility() == 0) {
      this.ous.startAnimation(this.oux);
    }
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209602);
        MPVideoViewControlBar.this.setVisibility(8);
        MPVideoViewControlBar.d(MPVideoViewControlBar.this);
        MPVideoViewControlBar.e(MPVideoViewControlBar.this);
        MPVideoViewControlBar.b(MPVideoViewControlBar.this).clearAnimation();
        AppMethodBeat.o(209602);
      }
    }, 200L);
    AppMethodBeat.o(6309);
  }
  
  public final void init()
  {
    AppMethodBeat.i(6290);
    super.init();
    this.lrG = ((ImageView)this.contentView.findViewById(2131300325));
    this.lrJ = ((ImageView)this.contentView.findViewById(2131303303));
    this.lrK = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.lrI = ((LinearLayout)findViewById(2131304239));
    this.oui = ((RelativeLayout)findViewById(2131303295));
    this.oup = ((LinearLayout)findViewById(2131304134));
    this.oun = ((TextView)findViewById(2131304136));
    this.ouo = findViewById(2131304135);
    this.ous = ((LinearLayout)findViewById(2131305144));
    this.ouq = ((TextView)findViewById(2131305146));
    this.our = findViewById(2131305145);
    this.lrL = ((ImageView)findViewById(2131302621));
    this.lrM = ((ImageView)findViewById(2131297935));
    this.lrN = ((ImageView)findViewById(2131299599));
    this.ayB = ((TextView)findViewById(2131305902));
    this.lrO = ((LinearLayout)findViewById(2131300332));
    this.lrP = ((LinearLayout)findViewById(2131303300));
    this.ouk = ((LinearLayout)findViewById(2131302509));
    this.oul = ((ImageView)findViewById(2131302499));
    this.oum = ((TextView)findViewById(2131302500));
    this.lrI.setOnClickListener(new MPVideoViewControlBar.5(this));
    AppMethodBeat.o(6290);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6288);
    if (this.llt != null) {
      this.llt.stopTimer();
    }
    if (this.lrR != null) {
      this.lrR.stopTimer();
    }
    AppMethodBeat.o(6288);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(6327);
    super.seek(paramInt);
    dZ(this.mPosition, this.lrx);
    AppMethodBeat.o(6327);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public void setDirection(int paramInt)
  {
    this.acQ = paramInt;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6292);
    this.lrN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6292);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6304);
    this.lrG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6304);
  }
  
  public void setIplaySeekCallback(final e.d paramd)
  {
    AppMethodBeat.i(6289);
    setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aqD()
      {
        AppMethodBeat.i(6276);
        paramd.aqD();
        AppMethodBeat.o(6276);
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(6277);
        paramd.nM(paramAnonymousInt);
        AppMethodBeat.o(6277);
      }
    });
    AppMethodBeat.o(6289);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(6303);
    this.dtk = paramBoolean;
    if (this.dtk)
    {
      this.lru.setImageDrawable(ao.k(getContext(), 2131690445, -1));
      this.lrM.setImageResource(2131690871);
      AppMethodBeat.o(6303);
      return;
    }
    this.lru.setImageDrawable(ao.k(getContext(), 2131690459, -1));
    this.lrM.setImageResource(2131690872);
    AppMethodBeat.o(6303);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6291);
    this.lrL.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6291);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(6296);
    if (paramBoolean)
    {
      this.lrL.setImageResource(2131690867);
      AppMethodBeat.o(6296);
      return;
    }
    this.lrL.setImageResource(2131690868);
    AppMethodBeat.o(6296);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6293);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.lrM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6293);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.lsa = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(6299);
    this.lrY = paramBoolean;
    boA();
    AppMethodBeat.o(6299);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6297);
    this.lrW = paramBoolean;
    boI();
    AppMethodBeat.o(6297);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6329);
    this.lrU = paramBoolean;
    boC();
    boz();
    AppMethodBeat.o(6329);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6295);
    ImageView localImageView = this.lrL;
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
    this.lrX = paramBoolean;
    boA();
    AppMethodBeat.o(6330);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6331);
    this.lrV = paramBoolean;
    boI();
    AppMethodBeat.o(6331);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.lrQ = parami;
  }
  
  public void setSwitchResolutionListener(a parama)
  {
    this.ouu = parama;
  }
  
  public void setSwitchSpeedListener(b paramb)
  {
    this.ouv = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(6294);
    if (!bt.isNullOrNil(paramString)) {
      this.ayB.setText(paramString);
    }
    AppMethodBeat.o(6294);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(6335);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.ouC != null)
      {
        this.ouC.onVisibilityChanged(true);
        AppMethodBeat.o(6335);
      }
    }
    else if (((paramInt == 8) || (paramInt == 4)) && (this.ouC != null)) {
      this.ouC.onVisibilityChanged(false);
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
    if (this.ouw == null)
    {
      this.ouw = AnimationUtils.loadAnimation(getContext(), 2130772108);
      this.ouw.setDuration(300L);
    }
    this.lrI.clearAnimation();
    this.lrI.startAnimation(this.ouw);
    if (this.lrS)
    {
      if (this.ouy == null)
      {
        this.ouy = AnimationUtils.loadAnimation(getContext(), 2130772105);
        this.ouy.setDuration(300L);
      }
      this.lrO.clearAnimation();
      this.lrO.startAnimation(this.ouy);
      this.ouk.clearAnimation();
      this.ouk.startAnimation(this.ouy);
    }
    setVisibility(0);
    AppMethodBeat.o(6310);
  }
  
  public static abstract interface a
  {
    public abstract void a(fu paramfu, int paramInt1, int paramInt2);
    
    public abstract void bRW();
    
    public abstract void bRX();
  }
  
  public static abstract interface b
  {
    public abstract void a(fu paramfu, c.a parama1, c.a parama2);
    
    public abstract void bSF();
    
    public abstract void bSG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */