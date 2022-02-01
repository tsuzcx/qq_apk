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
import com.tencent.mm.av.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  private int abb;
  private TextView awK;
  private au kOQ;
  private ImageView kUI;
  private LinearLayout kUK;
  private ImageView kUL;
  private FrameLayout kUM;
  private ImageView kUN;
  private ImageView kUO;
  private ImageView kUP;
  private LinearLayout kUQ;
  private LinearLayout kUR;
  private e.i kUS;
  private au kUT;
  private boolean kUU;
  private boolean kUW;
  private boolean kUX;
  private boolean kUY;
  private boolean kUZ;
  private boolean kVa;
  private e.e kVc;
  private RelativeLayout nRB;
  private LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> nRC;
  private LinearLayout nRD;
  private ImageView nRE;
  private TextView nRF;
  private TextView nRG;
  private View nRH;
  private LinearLayout nRI;
  private TextView nRJ;
  private View nRK;
  private LinearLayout nRL;
  private a nRM;
  private b nRN;
  private Animation nRO;
  private Animation nRP;
  private Animation nRQ;
  private Animation nRR;
  private LinkedList<fp> nRS;
  private fp nRT;
  private e.f nRU;
  
  public MPVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6285);
    this.nRC = null;
    this.nRS = new LinkedList();
    AppMethodBeat.o(6285);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6286);
    this.nRC = null;
    this.nRS = new LinkedList();
    AppMethodBeat.o(6286);
  }
  
  public MPVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6287);
    this.nRC = null;
    this.nRS = new LinkedList();
    AppMethodBeat.o(6287);
  }
  
  private boolean bOh()
  {
    return (this.kUU) && ((90 == this.abb) || (-90 == this.abb));
  }
  
  private void bOi()
  {
    AppMethodBeat.i(6322);
    if (bs.gY(this.nRC))
    {
      AppMethodBeat.o(6322);
      return;
    }
    Iterator localIterator = this.nRC.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localIterator.next();
      if (localc.nNN <= this.mPosition)
      {
        if (localc.nNL) {
          break label108;
        }
        i = 1;
      }
      else
      {
        if (!localc.nNL) {
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
        L(this.nRC);
      }
      AppMethodBeat.o(6322);
      return;
    }
  }
  
  private void bOj()
  {
    AppMethodBeat.i(6325);
    if ((!bOh()) || (bs.gY(this.nRS)) || (this.nRT == null))
    {
      bOk();
      this.nRH.setVisibility(8);
      AppMethodBeat.o(6325);
      return;
    }
    this.nRG.setText(this.nRT.DSJ);
    this.nRH.setVisibility(0);
    this.nRH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6284);
        if (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0)
        {
          MPVideoViewControlBar.d(MPVideoViewControlBar.this);
          if (MPVideoViewControlBar.this.caY())
          {
            MPVideoViewControlBar.this.bjC();
            AppMethodBeat.o(6284);
          }
        }
        else
        {
          if (MPVideoViewControlBar.h(MPVideoViewControlBar.this) != null) {
            MPVideoViewControlBar.h(MPVideoViewControlBar.this).bNw();
          }
          MPVideoViewControlBar.i(MPVideoViewControlBar.this);
          MPVideoViewControlBar.j(MPVideoViewControlBar.this);
        }
        AppMethodBeat.o(6284);
      }
    });
    AppMethodBeat.o(6325);
  }
  
  private void bOk()
  {
    AppMethodBeat.i(6326);
    ac.d("MicroMsg.MPVideoViewControlBar", "hideResolutionContainer");
    if (this.nRI.getVisibility() != 8)
    {
      this.nRI.setVisibility(8);
      if (this.nRM != null) {
        this.nRM.bNx();
      }
    }
    AppMethodBeat.o(6326);
  }
  
  private void bOl()
  {
    AppMethodBeat.i(179005);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQm, 1) == 0) {}
    for (int i = 1; (!bOh()) || (bs.gY(this.nRS)) || (this.nRT == null) || (i != 0); i = 0)
    {
      bOm();
      this.nRK.setVisibility(8);
      AppMethodBeat.o(179005);
      return;
    }
    Object localObject = c.nQW;
    if (c.bNX().nRd == 1.0F) {}
    for (localObject = getResources().getString(2131764684);; localObject = c.bNX().desc)
    {
      this.nRJ.setText((CharSequence)localObject);
      this.nRK.setVisibility(0);
      this.nRK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179004);
          m.zt(42);
          if (MPVideoViewControlBar.k(MPVideoViewControlBar.this).getVisibility() == 0)
          {
            MPVideoViewControlBar.e(MPVideoViewControlBar.this);
            if (MPVideoViewControlBar.this.caY())
            {
              MPVideoViewControlBar.this.bjC();
              AppMethodBeat.o(179004);
            }
          }
          else
          {
            if (MPVideoViewControlBar.l(MPVideoViewControlBar.this) != null) {
              MPVideoViewControlBar.l(MPVideoViewControlBar.this).bOe();
            }
            MPVideoViewControlBar.m(MPVideoViewControlBar.this);
            MPVideoViewControlBar.n(MPVideoViewControlBar.this);
          }
          AppMethodBeat.o(179004);
        }
      });
      AppMethodBeat.o(179005);
      return;
      localObject = c.nQW;
    }
  }
  
  private void bOm()
  {
    AppMethodBeat.i(179006);
    ac.d("MicroMsg.MPVideoViewControlBar", "hideSpeedContainer");
    if (this.nRL.getVisibility() != 8)
    {
      this.nRL.setVisibility(8);
      if (this.nRN != null) {
        this.nRN.bOf();
      }
    }
    AppMethodBeat.o(179006);
  }
  
  private void bOn()
  {
    AppMethodBeat.i(179007);
    ImageView localImageView = this.kUN;
    if (this.kUU) {}
    for (int i = 8;; i = 0)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(179007);
      return;
    }
  }
  
  private void bOo()
  {
    AppMethodBeat.i(179008);
    ViewGroup.LayoutParams localLayoutParams = this.kUw.getLayoutParams();
    int i = getResources().getDimensionPixelSize(2131166603);
    if (this.kUU) {
      i = getResources().getDimensionPixelSize(2131166602);
    }
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.kUw.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(179008);
  }
  
  private void bkO()
  {
    AppMethodBeat.i(6298);
    if (this.kUU)
    {
      this.kUQ.setVisibility(0);
      this.nRD.setVisibility(0);
      AppMethodBeat.o(6298);
      return;
    }
    this.kUQ.setVisibility(8);
    this.nRD.setVisibility(8);
    AppMethodBeat.o(6298);
  }
  
  private void bkP()
  {
    AppMethodBeat.i(6302);
    if (this.kUZ)
    {
      if (this.kVa)
      {
        this.kUw.setVisibility(8);
        this.kUO.setVisibility(0);
        AppMethodBeat.o(6302);
        return;
      }
      this.kUw.setVisibility(0);
      this.kUO.setVisibility(8);
      AppMethodBeat.o(6302);
      return;
    }
    this.kUw.setVisibility(8);
    this.kUO.setVisibility(8);
    AppMethodBeat.o(6302);
  }
  
  private void bkR()
  {
    AppMethodBeat.i(6305);
    if (this.kUW)
    {
      this.kUI.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.kUI.getLayoutParams();
      getResources().getDimensionPixelSize(2131166603);
      if (this.kUU) {
        this.kUI.setImageResource(2131233933);
      }
      for (int i = getResources().getDimensionPixelSize(2131166601);; i = getResources().getDimensionPixelSize(2131166603))
      {
        localLayoutParams.height = i;
        localLayoutParams.width = i;
        this.kUI.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(6305);
        return;
        this.kUI.setImageResource(2131690861);
      }
    }
    this.kUI.setVisibility(8);
    AppMethodBeat.o(6305);
  }
  
  private void bkS()
  {
    AppMethodBeat.i(6315);
    bkV();
    bkR();
    bkO();
    bkU();
    bkT();
    L(this.nRC);
    bOj();
    bOl();
    bOn();
    bOo();
    AppMethodBeat.o(6315);
  }
  
  private void bkT()
  {
    AppMethodBeat.i(6316);
    if (bOh()) {}
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166587))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (this.kUw != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUw.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUw.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kUR != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUR.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUR.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kUN != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUN.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUN.setLayoutParams(localMarginLayoutParams);
      }
      if (this.kUI != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.kUI.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.kUI.setLayoutParams(localMarginLayoutParams);
      }
      if (this.nRH != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.nRH.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.nRH.setLayoutParams(localMarginLayoutParams);
      }
      if (this.nRK != null)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.nRH.getLayoutParams();
        localMarginLayoutParams.setMarginStart(i);
        this.nRK.setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(6316);
      return;
    }
  }
  
  private void bkU()
  {
    AppMethodBeat.i(6317);
    if (bOh()) {}
    for (float f = getResources().getDimensionPixelSize(2131166600);; f = getResources().getDimensionPixelSize(2131166593))
    {
      this.kUx.setTextSize(0, f);
      this.kUy.setTextSize(0, f);
      AppMethodBeat.o(6317);
      return;
    }
  }
  
  private void bkV()
  {
    AppMethodBeat.i(6318);
    ViewGroup.LayoutParams localLayoutParams = this.kUK.getLayoutParams();
    int j;
    if (this.kUU)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166598);
      this.kUK.setLayoutParams(localLayoutParams);
      if (!bOh()) {
        break label143;
      }
      j = getResources().getDimensionPixelSize(2131166599);
    }
    for (int i = getResources().getDimensionPixelSize(2131166597);; i = getResources().getDimensionPixelSize(2131166590))
    {
      this.kUK.setPadding(0, 0, i, 0);
      if (this.kUQ != null) {
        this.kUQ.setPadding(j, 0, j, 0);
      }
      if (this.nRD != null) {
        this.nRD.setPadding(j, 0, j, 0);
      }
      AppMethodBeat.o(6318);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131166589);
      break;
      label143:
      j = getResources().getDimensionPixelSize(2131166590);
    }
  }
  
  private boolean bkW()
  {
    AppMethodBeat.i(6321);
    if (this.kUS == null)
    {
      ac.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(6321);
      return false;
    }
    int k = this.kUS.bjh();
    int j = this.kUS.bji();
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUL.getLayoutParams();
      localLayoutParams.width = i;
      this.kUL.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(6321);
      return true;
      d = k;
    }
  }
  
  private void bkX()
  {
    int j = 0;
    AppMethodBeat.i(6333);
    boolean bool;
    Object localObject;
    if (this.kUY)
    {
      bool = this.kUX;
      localObject = this.kUM;
      if (!bool) {
        break label86;
      }
      i = 0;
      label32:
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.kUx;
      if (!bool) {
        break label92;
      }
      i = 0;
      label50:
      ((TextView)localObject).setVisibility(i);
      localObject = this.kUy;
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
  
  private void dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6334);
    if (this.kVc != null) {
      this.kVc.onProgressChanged(paramInt1, paramInt2);
    }
    bOi();
    AppMethodBeat.o(6334);
  }
  
  public final void L(LinkedList<com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c> paramLinkedList)
  {
    AppMethodBeat.i(6323);
    this.nRC = paramLinkedList;
    if ((this.nRB == null) || (bs.gY(this.nRC)))
    {
      this.nRB.removeAllViews();
      AppMethodBeat.o(6323);
      return;
    }
    ac.i("MicroMsg.MPVideoViewControlBar", "updateControlBarDotPos");
    ap.n(new MPVideoViewControlBar.10(this, paramLinkedList), 100L);
    AppMethodBeat.o(6323);
  }
  
  public final void M(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(198788);
    a locala = a.aFG();
    ImageView localImageView = this.nRE;
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.gLt = true;
    locala1.hKI = 2131231342;
    locala.a(paramString3, localImageView, locala1.aFT());
    this.nRF.setText(paramString1);
    this.nRD.setOnClickListener(null);
    this.nRD.setOnClickListener(new MPVideoViewControlBar.6(this, paramString2));
    o.gD(this.nRD);
    AppMethodBeat.o(198788);
  }
  
  public final void a(e.f paramf)
  {
    this.nRU = paramf;
  }
  
  public final void a(LinkedList<fp> paramLinkedList, fp paramfp)
  {
    AppMethodBeat.i(6324);
    if ((paramLinkedList == null) || (paramfp == null))
    {
      AppMethodBeat.o(6324);
      return;
    }
    this.nRS.clear();
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      fp localfp = (fp)paramLinkedList.next();
      if ((!bs.isNullOrNil(localfp.DSJ)) && (!localHashSet.contains(Integer.valueOf(localfp.DSI))))
      {
        this.nRS.add(localfp);
        localHashSet.add(Integer.valueOf(localfp.DSI));
      }
    }
    Collections.sort(this.nRS, new Comparator() {});
    this.nRT = paramfp;
    AppMethodBeat.o(6324);
  }
  
  public final void bOg()
  {
    AppMethodBeat.i(6308);
    if (this.kUT != null) {
      this.kUT.stopTimer();
    }
    AppMethodBeat.o(6308);
  }
  
  public final void bha()
  {
    AppMethodBeat.i(6314);
    this.kUU = false;
    bkS();
    AppMethodBeat.o(6314);
  }
  
  public final void biZ()
  {
    AppMethodBeat.i(6300);
    if ((this.kUZ) && (this.kVa)) {
      this.kUO.setVisibility(8);
    }
    AppMethodBeat.o(6300);
  }
  
  public final void bjA()
  {
    AppMethodBeat.i(6319);
    if (this.kOQ == null) {
      this.kOQ = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(198786);
          if (!MPVideoViewControlBar.f(MPVideoViewControlBar.this))
          {
            AppMethodBeat.o(198786);
            return false;
          }
          AppMethodBeat.o(198786);
          return true;
        }
      }, true);
    }
    bkW();
    this.kOQ.stopTimer();
    this.kOQ.au(500L, 500L);
    AppMethodBeat.o(6319);
  }
  
  public final void bjB()
  {
    AppMethodBeat.i(6320);
    if (this.kOQ != null) {
      this.kOQ.stopTimer();
    }
    AppMethodBeat.o(6320);
  }
  
  public final void bjC()
  {
    AppMethodBeat.i(6307);
    if (this.kUT != null)
    {
      this.kUT.stopTimer();
      this.kUT.au(4000L, 4000L);
    }
    AppMethodBeat.o(6307);
  }
  
  public final void bjD()
  {
    AppMethodBeat.i(6301);
    if ((this.kUZ) && (this.kVa)) {
      this.kUO.setVisibility(0);
    }
    AppMethodBeat.o(6301);
  }
  
  public final boolean bjE()
  {
    AppMethodBeat.i(6332);
    if (this.kUM != null)
    {
      if ((getVisibility() == 0) && (this.kUM.getVisibility() == 0))
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
  
  public final boolean bjt()
  {
    return false;
  }
  
  public final void bju()
  {
    AppMethodBeat.i(6312);
    if (bjw())
    {
      hide();
      AppMethodBeat.o(6312);
      return;
    }
    bjv();
    AppMethodBeat.o(6312);
  }
  
  public final void bjv()
  {
    AppMethodBeat.i(6306);
    show();
    if (this.kUT == null) {
      this.kUT = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(198784);
          if ((MPVideoViewControlBar.a(MPVideoViewControlBar.this)) || (MPVideoViewControlBar.b(MPVideoViewControlBar.this).getVisibility() == 0))
          {
            AppMethodBeat.o(198784);
            return true;
          }
          MPVideoViewControlBar.this.hide();
          MPVideoViewControlBar.c(MPVideoViewControlBar.this).stopTimer();
          AppMethodBeat.o(198784);
          return false;
        }
      }, false);
    }
    this.kUT.stopTimer();
    this.kUT.au(4000L, 4000L);
    AppMethodBeat.o(6306);
  }
  
  public final boolean bjw()
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
  
  public final void bjx()
  {
    AppMethodBeat.i(6313);
    this.kUU = true;
    bkS();
    AppMethodBeat.o(6313);
  }
  
  public final boolean bjy()
  {
    return this.kUU;
  }
  
  public final boolean bjz()
  {
    return true;
  }
  
  public final void bkN()
  {
    AppMethodBeat.i(6328);
    if (this.kUz == 0)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.kwq)
    {
      AppMethodBeat.o(6328);
      return;
    }
    if (this.kUv == null)
    {
      AppMethodBeat.o(6328);
      return;
    }
    this.kUx.setText(sO(this.mPosition / 60) + ":" + sO(this.mPosition % 60));
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(6328);
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
    AppMethodBeat.o(6328);
  }
  
  public int getLayoutId()
  {
    return 2131494960;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(6309);
    if (this.nRP == null)
    {
      this.nRP = AnimationUtils.loadAnimation(getContext(), 2130772106);
      this.nRP.setDuration(300L);
    }
    this.kUK.clearAnimation();
    this.kUK.startAnimation(this.nRP);
    if (this.kUU)
    {
      if (this.nRR == null)
      {
        this.nRR = AnimationUtils.loadAnimation(getContext(), 2130772109);
        this.nRR.setDuration(300L);
      }
      this.kUQ.clearAnimation();
      this.kUQ.startAnimation(this.nRR);
      this.nRD.clearAnimation();
      this.nRD.startAnimation(this.nRR);
    }
    if (this.nRI.getVisibility() == 0) {
      this.nRI.startAnimation(this.nRP);
    }
    if (this.nRL.getVisibility() == 0) {
      this.nRL.startAnimation(this.nRP);
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198785);
        MPVideoViewControlBar.this.setVisibility(8);
        MPVideoViewControlBar.d(MPVideoViewControlBar.this);
        MPVideoViewControlBar.e(MPVideoViewControlBar.this);
        MPVideoViewControlBar.b(MPVideoViewControlBar.this).clearAnimation();
        AppMethodBeat.o(198785);
      }
    }, 200L);
    AppMethodBeat.o(6309);
  }
  
  public final void init()
  {
    AppMethodBeat.i(6290);
    super.init();
    this.kUI = ((ImageView)this.contentView.findViewById(2131300325));
    this.kUL = ((ImageView)this.contentView.findViewById(2131303303));
    this.kUM = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.kUK = ((LinearLayout)findViewById(2131304239));
    this.nRB = ((RelativeLayout)findViewById(2131303295));
    this.nRI = ((LinearLayout)findViewById(2131304134));
    this.nRG = ((TextView)findViewById(2131304136));
    this.nRH = findViewById(2131304135);
    this.nRL = ((LinearLayout)findViewById(2131305144));
    this.nRJ = ((TextView)findViewById(2131305146));
    this.nRK = findViewById(2131305145);
    this.kUN = ((ImageView)findViewById(2131302621));
    this.kUO = ((ImageView)findViewById(2131297935));
    this.kUP = ((ImageView)findViewById(2131299599));
    this.awK = ((TextView)findViewById(2131305902));
    this.kUQ = ((LinearLayout)findViewById(2131300332));
    this.kUR = ((LinearLayout)findViewById(2131303300));
    this.nRD = ((LinearLayout)findViewById(2131302509));
    this.nRE = ((ImageView)findViewById(2131302499));
    this.nRF = ((TextView)findViewById(2131302500));
    this.kUK.setOnClickListener(new View.OnClickListener()
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
    if (this.kOQ != null) {
      this.kOQ.stopTimer();
    }
    if (this.kUT != null) {
      this.kUT.stopTimer();
    }
    AppMethodBeat.o(6288);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(6327);
    super.seek(paramInt);
    dX(this.mPosition, this.kUz);
    AppMethodBeat.o(6327);
  }
  
  public void setDanmakuBtnOnClickListener(e.g paramg) {}
  
  public void setDanmakuBtnOpen(boolean paramBoolean) {}
  
  public void setDirection(int paramInt)
  {
    this.abb = paramInt;
  }
  
  public void setExitFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6292);
    this.kUP.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6292);
  }
  
  public void setFullScreenBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6304);
    this.kUI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6304);
  }
  
  public void setIplaySeekCallback(final e.d paramd)
  {
    AppMethodBeat.i(6289);
    setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void anR()
      {
        AppMethodBeat.i(6276);
        paramd.anR();
        AppMethodBeat.o(6276);
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(6277);
        paramd.nn(paramAnonymousInt);
        AppMethodBeat.o(6277);
      }
    });
    AppMethodBeat.o(6289);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(6303);
    this.dhM = paramBoolean;
    if (this.dhM)
    {
      this.kUw.setImageDrawable(am.k(getContext(), 2131690445, -1));
      this.kUO.setImageResource(2131690871);
      AppMethodBeat.o(6303);
      return;
    }
    this.kUw.setImageDrawable(am.k(getContext(), 2131690459, -1));
    this.kUO.setImageResource(2131690872);
    AppMethodBeat.o(6303);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6291);
    this.kUN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6291);
  }
  
  public void setMuteBtnState(boolean paramBoolean)
  {
    AppMethodBeat.i(6296);
    if (paramBoolean)
    {
      this.kUN.setImageResource(2131690867);
      AppMethodBeat.o(6296);
      return;
    }
    this.kUN.setImageResource(2131690868);
    AppMethodBeat.o(6296);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(6293);
    super.setOnPlayButtonClickListener(paramOnClickListener);
    this.kUO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(6293);
  }
  
  public void setOnUpdateProgressLenListener(e.e parame)
  {
    this.kVc = parame;
  }
  
  public void setPlayBtnInCenterPosition(boolean paramBoolean)
  {
    AppMethodBeat.i(6299);
    this.kVa = paramBoolean;
    bkP();
    AppMethodBeat.o(6299);
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6297);
    this.kUY = paramBoolean;
    bkX();
    AppMethodBeat.o(6297);
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean) {}
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6329);
    this.kUW = paramBoolean;
    bkR();
    bkO();
    AppMethodBeat.o(6329);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(6295);
    ImageView localImageView = this.kUN;
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
    this.kUZ = paramBoolean;
    bkP();
    AppMethodBeat.o(6330);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(6331);
    this.kUX = paramBoolean;
    bkX();
    AppMethodBeat.o(6331);
  }
  
  public void setStatePorter(e.i parami)
  {
    this.kUS = parami;
  }
  
  public void setSwitchResolutionListener(a parama)
  {
    this.nRM = parama;
  }
  
  public void setSwitchSpeedListener(b paramb)
  {
    this.nRN = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(6294);
    if (!bs.isNullOrNil(paramString)) {
      this.awK.setText(paramString);
    }
    AppMethodBeat.o(6294);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(6335);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.nRU != null)
      {
        this.nRU.onVisibilityChanged(true);
        AppMethodBeat.o(6335);
      }
    }
    else if (((paramInt == 8) || (paramInt == 4)) && (this.nRU != null)) {
      this.nRU.onVisibilityChanged(false);
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
    if (this.nRO == null)
    {
      this.nRO = AnimationUtils.loadAnimation(getContext(), 2130772108);
      this.nRO.setDuration(300L);
    }
    this.kUK.clearAnimation();
    this.kUK.startAnimation(this.nRO);
    if (this.kUU)
    {
      if (this.nRQ == null)
      {
        this.nRQ = AnimationUtils.loadAnimation(getContext(), 2130772105);
        this.nRQ.setDuration(300L);
      }
      this.kUQ.clearAnimation();
      this.kUQ.startAnimation(this.nRQ);
      this.nRD.clearAnimation();
      this.nRD.startAnimation(this.nRQ);
    }
    setVisibility(0);
    AppMethodBeat.o(6310);
  }
  
  public static abstract interface a
  {
    public abstract void a(fp paramfp, int paramInt1, int paramInt2);
    
    public abstract void bNw();
    
    public abstract void bNx();
  }
  
  public static abstract interface b
  {
    public abstract void a(fp paramfp, c.a parama1, c.a parama2);
    
    public abstract void bOe();
    
    public abstract void bOf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */