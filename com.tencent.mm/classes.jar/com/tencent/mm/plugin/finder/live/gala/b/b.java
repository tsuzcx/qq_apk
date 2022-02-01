package com.tencent.mm.plugin.finder.live.gala.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.gala.viewpager.FinderLiveBoxViewPager;
import com.tencent.mm.plugin.finder.live.gala.viewpager.d;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.cy;
import com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.i;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveViewPagerCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "context", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "rootParent", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Landroid/view/ViewGroup;)V", "canClear", "", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "contentMaxHeight", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "curBoxObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "isAutoSwitch", "redDotObserver", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxRedDotInfo;", "getRootParent", "()Landroid/view/ViewGroup;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "kotlin.jvm.PlatformType", "viewPager", "Lcom/tencent/mm/plugin/finder/live/gala/viewpager/FinderLiveBoxViewPager;", "viewPagerAdapter", "Lcom/tencent/mm/plugin/finder/live/gala/viewpager/LiveViewPagerPluginAdapter;", "viewPagerRegister", "Lcom/tencent/mm/plugin/finder/live/gala/viewpager/ViewPagerPluginRegister;", "adjustLayout", "", "bindCommentPlugin", "canClearScreen", "changeBoxData", "groupId", "initData", "initTabLayout", "initViewPager", "param", "Landroid/os/Bundle;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "switchTabLayoutAndViewPager", "index", "switchToBox", "switchToPublic", "unMount", "updateTabLayout", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  public static final a adlL;
  private static final int adlU = 0;
  private static final int adlV;
  private boolean CXU;
  public com.tencent.mm.plugin.finder.live.plugin.ah DcS;
  private final ViewGroup adlM;
  private final FinderLiveBoxViewPager adlN;
  private d adlO;
  private com.tencent.mm.plugin.finder.live.gala.viewpager.c adlP;
  private int adlQ;
  private boolean adlR;
  private final y<bfv> adlS;
  private final y<ConcurrentHashMap<String, i>> adlT;
  private final MMActivity lzt;
  private final com.tencent.mm.live.b.b nfT;
  private final TabLayout yaj;
  
  static
  {
    AppMethodBeat.i(371234);
    adlL = new a((byte)0);
    adlV = 1;
    AppMethodBeat.o(371234);
  }
  
  public b(MMActivity paramMMActivity, ViewGroup paramViewGroup1, com.tencent.mm.live.b.b paramb, ViewGroup paramViewGroup2)
  {
    super(paramViewGroup1, paramb);
    AppMethodBeat.i(371219);
    this.lzt = paramMMActivity;
    this.nfT = paramb;
    this.adlM = paramViewGroup2;
    this.yaj = ((TabLayout)paramViewGroup1.findViewById(p.e.EGE));
    this.adlN = ((FinderLiveBoxViewPager)paramViewGroup1.findViewById(p.e.KQR));
    this.adlO = new d(this.lzt, getBuContext(), this.nfT, (com.tencent.mm.plugin.finder.live.plugin.b)this);
    this.CXU = true;
    this.adlQ = com.tencent.mm.cd.a.fromDPToPix((Context)this.lzt, 240);
    this.adlS = new b..ExternalSyntheticLambda0(this);
    this.adlT = new b..ExternalSyntheticLambda1(this);
    tO(8);
    AppMethodBeat.o(371219);
  }
  
  private static final void a(b paramb, bfv parambfv)
  {
    AppMethodBeat.i(371228);
    kotlin.g.b.s.u(paramb, "this$0");
    if (parambfv != null)
    {
      parambfv = (CharSequence)parambfv.id;
      if ((parambfv != null) && (parambfv.length() != 0)) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i != 0; i = 0)
    {
      parambfv = bq.akii;
      bq.rU("FinderLiveViewPagerComm", "curBoxObserver switchToPublic");
      paramb.jcT();
      AppMethodBeat.o(371228);
      return;
    }
    parambfv = bq.akii;
    bq.rU("FinderLiveViewPagerComm", "curBoxObserver switchToBox");
    parambfv = paramb.yaj.js(adlV);
    if (parambfv == null)
    {
      parambfv = null;
      if (!(parambfv instanceof com.tencent.mm.plugin.finder.live.gala.viewpager.b)) {
        break label349;
      }
      parambfv = (com.tencent.mm.plugin.finder.live.gala.viewpager.b)parambfv;
      label109:
      if (parambfv == null) {
        break label359;
      }
      parambfv = parambfv.EFo;
      if ((parambfv == null) || (parambfv.getVisibility() != 0)) {
        break label354;
      }
      i = 1;
      label131:
      if (i != 1) {
        break label359;
      }
    }
    label349:
    label354:
    label359:
    for (boolean bool = true;; bool = false)
    {
      paramb.axL(adlV);
      parambfv = (cy)paramb.getPlugin(cy.class);
      if (parambfv != null)
      {
        Object localObject = bq.akii;
        bq.rR("FinderLiveViewPagerComm", kotlin.g.b.s.X("status FINDER_LIVE_SWITCH_BOX true, hasReddot:", Boolean.valueOf(bool)));
        paramb = paramb.nfT;
        localObject = com.tencent.mm.live.b.b.c.qMm;
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isShow", true);
        kotlin.ah localah = kotlin.ah.aiuX;
        paramb.statusChange((com.tencent.mm.live.b.b.c)localObject, localBundle);
        Log.i("FinderLiveBoxCommentPlugin", "resumeBoxComment " + parambfv.hashCode() + " id:" + parambfv.agxq);
        paramb = parambfv.jdt().getViewTreeObserver();
        if (paramb != null) {
          paramb.removeOnGlobalLayoutListener(parambfv.jdr());
        }
        paramb = parambfv.jdt().getViewTreeObserver();
        if (paramb != null) {
          paramb.addOnGlobalLayoutListener(parambfv.jdr());
        }
        parambfv.jdt().b((RecyclerView.l)parambfv.jds());
        parambfv.jdt().a((RecyclerView.l)parambfv.jds());
        parambfv.NR(true);
      }
      AppMethodBeat.o(371228);
      return;
      parambfv = parambfv.tag;
      break;
      parambfv = null;
      break label109;
      i = 0;
      break label131;
    }
  }
  
  private static final void a(b paramb, ConcurrentHashMap paramConcurrentHashMap)
  {
    int i = 1;
    AppMethodBeat.i(371230);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = bq.akii;
    bq.rU("FinderLiveViewPagerComm", kotlin.g.b.s.X("redDotObserver redDotMap: ", Integer.valueOf(paramConcurrentHashMap.size())));
    if (paramConcurrentHashMap == null)
    {
      Log.w("FinderLiveViewPagerComm", "redDotMap is null");
      paramb = paramb.yaj.js(adlV);
      if (paramb == null)
      {
        paramb = null;
        if (!(paramb instanceof com.tencent.mm.plugin.finder.live.gala.viewpager.b)) {
          break label102;
        }
      }
      label102:
      for (paramb = (com.tencent.mm.plugin.finder.live.gala.viewpager.b)paramb;; paramb = null)
      {
        if (paramb != null) {
          paramb.vm(false);
        }
        AppMethodBeat.o(371230);
        return;
        paramb = paramb.tag;
        break;
      }
    }
    localObject = (com.tencent.mm.plugin.finder.live.gala.a.a)p.ae((List)paramb.adlO.agjD, adlV);
    boolean bool;
    if (localObject != null)
    {
      paramConcurrentHashMap = (i)paramConcurrentHashMap.get(((com.tencent.mm.plugin.finder.live.gala.a.a)localObject).groupId);
      if ((paramConcurrentHashMap != null) && (paramConcurrentHashMap.PcF))
      {
        localObject = bq.akii;
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())
        {
          bool = true;
          bq.rS("FinderLiveViewPagerComm", kotlin.g.b.s.X("observed, show reddot:", Boolean.valueOf(bool)));
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm()) {
            break label329;
          }
          paramConcurrentHashMap = paramb.yaj.js(adlV);
          if (paramConcurrentHashMap != null) {
            break label316;
          }
          paramConcurrentHashMap = null;
          label228:
          if (!(paramConcurrentHashMap instanceof com.tencent.mm.plugin.finder.live.gala.viewpager.b)) {
            break label324;
          }
          paramConcurrentHashMap = (com.tencent.mm.plugin.finder.live.gala.viewpager.b)paramConcurrentHashMap;
          label240:
          if (paramConcurrentHashMap != null) {
            paramConcurrentHashMap.vm(true);
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLk();
          label262:
          if (i == 0)
          {
            paramb = paramb.yaj.js(adlV);
            if (paramb != null) {
              break label339;
            }
            paramb = null;
            label283:
            if (!(paramb instanceof com.tencent.mm.plugin.finder.live.gala.viewpager.b)) {
              break label347;
            }
          }
        }
      }
    }
    label316:
    label324:
    label329:
    label339:
    label347:
    for (paramb = (com.tencent.mm.plugin.finder.live.gala.viewpager.b)paramb;; paramb = null)
    {
      if (paramb != null) {
        paramb.vm(false);
      }
      AppMethodBeat.o(371230);
      return;
      bool = false;
      break;
      paramConcurrentHashMap = paramConcurrentHashMap.tag;
      break label228;
      paramConcurrentHashMap = null;
      break label240;
      paramConcurrentHashMap.PcF = false;
      i = 0;
      break label262;
      paramb = paramb.tag;
      break label283;
    }
  }
  
  private final void axL(int paramInt)
  {
    AppMethodBeat.i(371227);
    Log.i("FinderLiveViewPagerComm", kotlin.g.b.s.X("switchTabLayoutAndViewPager ", Integer.valueOf(paramInt)));
    Object localObject = this.yaj.js(paramInt);
    if ((localObject != null) && (!((TabLayout.e)localObject).isSelected())) {
      ((TabLayout.e)localObject).Xf();
    }
    if (this.adlN.getCurrentItem() != paramInt) {
      this.adlN.setCurrentItem(paramInt);
    }
    if (paramInt == adlV)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLk();
      localObject = bq.akii;
      bq.rS("FinderLiveViewPagerComm", "dismiss reddot");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLj();
      AppMethodBeat.o(371227);
      return;
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLl();
    AppMethodBeat.o(371227);
  }
  
  private final void iQt()
  {
    AppMethodBeat.i(371223);
    this.yaj.WY();
    Object localObject2 = ((Iterable)this.adlO.agjD).iterator();
    int i = 0;
    Object localObject1;
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (i < 0) {
        p.kkW();
      }
      Object localObject4 = (com.tencent.mm.plugin.finder.live.gala.a.a)localObject1;
      localObject3 = this.yaj;
      TabLayout.e locale = this.yaj.WW();
      kotlin.g.b.s.s(locale, "tabLayout.newTab()");
      localObject1 = Integer.valueOf(1);
      if (((Number)localObject1).intValue() == 0)
      {
        j = 1;
        label103:
        if (j == 0) {
          break label178;
        }
        label107:
        if (localObject1 != null) {
          break label183;
        }
      }
      label178:
      label183:
      for (int j = 2;; j = ((Integer)localObject1).intValue())
      {
        localObject1 = new com.tencent.mm.plugin.finder.live.gala.viewpager.b(locale, j, (kotlin.g.a.a)new e((com.tencent.mm.plugin.finder.live.gala.a.a)localObject4, this));
        ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)localObject1).setTitle(((com.tencent.mm.plugin.finder.live.gala.a.a)localObject4).abwL);
        ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)localObject1).index = i;
        localObject4 = kotlin.ah.aiuX;
        ((TabLayout)localObject3).a(((com.tencent.mm.plugin.finder.live.gala.viewpager.b)localObject1).dyQ, false);
        i += 1;
        break;
        j = 0;
        break label103;
        localObject1 = null;
        break label107;
      }
    }
    if (this.adlO.agjD.size() == 1)
    {
      localObject1 = this.yaj;
      localObject2 = this.yaj.WW();
      kotlin.g.b.s.s(localObject2, "tabLayout.newTab()");
      localObject2 = new com.tencent.mm.plugin.finder.live.gala.viewpager.b((TabLayout.e)localObject2, 3, (kotlin.g.a.a)new f(this));
      localObject3 = this.mJe.getContext().getString(p.h.XMx);
      kotlin.g.b.s.s(localObject3, "root.context.getString(R…_gala_bottom_content_box)");
      ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)localObject2).setTitle((String)localObject3);
      ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)localObject2).index = 1;
      localObject3 = kotlin.ah.aiuX;
      ((TabLayout)localObject1).a(((com.tencent.mm.plugin.finder.live.gala.viewpager.b)localObject2).dyQ, false);
    }
    AppMethodBeat.o(371223);
  }
  
  private final void jcT()
  {
    AppMethodBeat.i(371225);
    axL(adlU);
    cy localcy = (cy)getPlugin(cy.class);
    if (localcy == null)
    {
      AppMethodBeat.o(371225);
      return;
    }
    Object localObject = bq.akii;
    bq.rR("FinderLiveViewPagerComm", "status FINDER_LIVE_SWITCH_BOX false");
    localObject = this.nfT;
    com.tencent.mm.live.b.b.c localc = com.tencent.mm.live.b.b.c.qMm;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isShow", false);
    kotlin.ah localah = kotlin.ah.aiuX;
    ((com.tencent.mm.live.b.b)localObject).statusChange(localc, localBundle);
    localcy.jdx();
    AppMethodBeat.o(371225);
  }
  
  public final boolean eoI()
  {
    AppMethodBeat.i(371249);
    if ((isLandscape()) || (this.CXU))
    {
      AppMethodBeat.o(371249);
      return true;
    }
    AppMethodBeat.o(371249);
    return false;
  }
  
  public final void statusChange(com.tencent.mm.live.b.b.c paramc, Bundle paramBundle)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    AppMethodBeat.i(371245);
    kotlin.g.b.s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(371245);
      return;
      tO(0);
      paramc = this.mJe.getParent();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(371245);
        throw paramc;
      }
      paramc = ((LinearLayout)((ViewGroup)paramc).findViewById(p.e.BMa)).getLayoutParams();
      label184:
      label208:
      label232:
      label249:
      int j;
      if ((paramc instanceof RelativeLayout.LayoutParams))
      {
        paramc = (RelativeLayout.LayoutParams)paramc;
        if (paramc != null) {
          paramc.addRule(2, this.mJe.getId());
        }
        paramc = this.adlM;
        if (paramc != null)
        {
          localObject1 = (LinearLayout)paramc.findViewById(p.e.BIc);
          if (localObject1 != null)
          {
            paramc = ((LinearLayout)localObject1).getParent();
            if (!(paramc instanceof ViewGroup)) {
              break label589;
            }
            paramc = (ViewGroup)paramc;
            if (paramc != null) {
              paramc.removeView((View)localObject1);
            }
          }
        }
        paramc = this.adlM;
        if (paramc != null) {
          break label594;
        }
        paramc = null;
        localObject1 = this.mJe.getLayoutParams();
        if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
          break label605;
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).removeRule(2);
          if (paramc != null) {
            break label611;
          }
          i = 0;
          ((RelativeLayout.LayoutParams)localObject1).addRule(2, i);
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
        }
        localObject1 = this.adlN.getLayoutParams();
        if (localObject1 != null)
        {
          j = com.tencent.mm.cd.a.fromDPToPix((Context)this.lzt, 50);
          paramc = this.DcS;
          if (paramc != null) {
            break label619;
          }
          paramc = null;
          label301:
          if (paramc != null) {
            break label633;
          }
        }
      }
      label589:
      label594:
      label605:
      label611:
      label619:
      label633:
      for (int i = this.adlQ;; i = paramc.intValue())
      {
        i += j;
        Log.i("FinderLiveViewPagerComm", kotlin.g.b.s.X("adjustLayout commentHeight: ", Integer.valueOf(i)));
        ((ViewGroup.LayoutParams)localObject1).height = i;
        this.adlQ = ((ViewGroup.LayoutParams)localObject1).height;
        if (this.DcS != null)
        {
          localObject1 = this.adlO;
          com.tencent.mm.plugin.finder.live.plugin.ah localah = this.DcS;
          kotlin.g.b.s.checkNotNull(localah);
          kotlin.g.b.s.u(localah, "commentPlugin");
          ((d)localObject1).agjD.clear();
          ViewParent localViewParent = localah.mJe.getParent();
          paramc = (com.tencent.mm.live.b.b.c)localObject2;
          if ((localViewParent instanceof ViewGroup)) {
            paramc = (ViewGroup)localViewParent;
          }
          if (paramc != null) {
            paramc.removeView((View)localah.mJe);
          }
          paramc = ((d)localObject1).agjD;
          localObject2 = ((d)localObject1).lzt.getResources().getString(p.h.XMA);
          kotlin.g.b.s.s(localObject2, "context.resources.getStr…la_bottom_content_public)");
          paramc.add(0, new com.tencent.mm.plugin.finder.live.gala.a.a("", (String)localObject2, 0L, (com.tencent.mm.plugin.finder.live.gala.viewpager.a)localah));
          ((d)localObject1).cc(paramBundle);
          this.adlP = new com.tencent.mm.plugin.finder.live.gala.viewpager.c(this.adlO.agjD, this.adlQ);
          this.adlN.setAdapter((androidx.viewpager.widget.a)this.adlP);
          this.adlN.addOnPageChangeListener((ViewPager.OnPageChangeListener)new d(this));
        }
        iQt();
        this.yaj.setTabIndicatorFullWidth(false);
        paramc = this.yaj.getLayoutParams();
        if (paramc != null) {
          break label641;
        }
        paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(371245);
        throw paramc;
        paramc = null;
        break;
        paramc = null;
        break label184;
        paramc = paramc.findViewById(p.e.VIs);
        break label208;
        localObject1 = null;
        break label232;
        i = paramc.getId();
        break label249;
        paramc = Integer.valueOf(paramc.CXK.getMaxHeight());
        break label301;
      }
      label641:
      paramc.width = ((com.tencent.mm.plugin.finder.live.component.msginterceptor.c)getBuContext().business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class)).CBG;
      Log.i("FinderLiveViewPagerComm", kotlin.g.b.s.X("initTabLayout width: ", Integer.valueOf(paramc.width)));
      this.yaj.a((TabLayout.b)new c());
      paramc = bq.akii;
      bq.rR("FinderLiveViewPagerComm", kotlin.g.b.s.X("status FINDER_LIVE_SWITCH_BOX ", Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())));
      paramc = this.nfT;
      paramBundle = com.tencent.mm.live.b.b.c.qMm;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isShow", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm());
      localObject2 = kotlin.ah.aiuX;
      paramc.statusChange(paramBundle, (Bundle)localObject1);
      this.adlR = true;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())
      {
        paramc = bq.akii;
        bq.rU("FinderLiveViewPagerComm", "curBoxObserver manually switchToPublic");
        jcT();
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.a((q)this, this.adlS);
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLi();
      if (paramc != null) {
        paramc.a((q)this, this.adlT);
      }
      AppMethodBeat.o(371245);
      return;
      boolean bool1;
      if (paramBundle == null)
      {
        bool1 = false;
        paramc = this.yaj;
        if (!bool1) {
          break label935;
        }
      }
      label935:
      for (i = 4;; i = 0)
      {
        paramc.setVisibility(i);
        if (!bool1) {
          bool2 = true;
        }
        this.CXU = bool2;
        AppMethodBeat.o(371245);
        return;
        bool1 = paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
        break;
      }
      this.adlO.cc(paramBundle);
      paramc = this.adlP;
      if (paramc != null) {
        paramc.notifyDataSetChanged();
      }
      iQt();
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(371248);
    super.unMount();
    tO(8);
    this.CXU = true;
    Object localObject = com.tencent.mm.plugin.finder.live.gala.d.a.adlZ;
    com.tencent.mm.plugin.finder.live.gala.d.a.jdl();
    this.yaj.WY();
    this.adlO.agjD.clear();
    localObject = this.adlP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.gala.viewpager.c)localObject).notifyDataSetChanged();
    }
    AppMethodBeat.o(371248);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveViewPagerCommentPlugin$Companion;", "", "()V", "TAG", "", "boxIndex", "", "publicIndex", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveViewPagerCommentPlugin$initTabLayout$2", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(371220);
      kotlin.g.b.s.u(parame, "t");
      parame = parame.tag;
      if ((parame instanceof com.tencent.mm.plugin.finder.live.gala.viewpager.b))
      {
        ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)parame).setTextColor(p.b.white_force);
        ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)parame).setTextBold(true);
        Log.i("FinderLiveViewPagerComm", kotlin.g.b.s.X("onTabSelected: ", Integer.valueOf(((com.tencent.mm.plugin.finder.live.gala.viewpager.b)parame).index)));
      }
      AppMethodBeat.o(371220);
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(371215);
      kotlin.g.b.s.u(parame, "t");
      parame = parame.tag;
      if ((parame instanceof com.tencent.mm.plugin.finder.live.gala.viewpager.b))
      {
        ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)parame).setTextColor(p.b.BW_100_Alpha_0_5);
        ((com.tencent.mm.plugin.finder.live.gala.viewpager.b)parame).setTextBold(false);
      }
      Log.i("FinderLiveViewPagerComm", "onTabUnselected: ");
      AppMethodBeat.o(371215);
    }
    
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(371210);
      kotlin.g.b.s.u(parame, "t");
      Log.i("FinderLiveViewPagerComm", "onTabReselected: ");
      AppMethodBeat.o(371210);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/gala/plugin/FinderLiveViewPagerCommentPlugin$initViewPager$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ViewPager.OnPageChangeListener
  {
    d(b paramb) {}
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(371209);
      Log.i("FinderLiveViewPagerComm", "onPageSelected: " + paramInt1 + " positionOffset: " + paramFloat);
      AppMethodBeat.o(371209);
    }
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(371214);
      Log.i("FinderLiveViewPagerComm", kotlin.g.b.s.X("onPageSelected: ", Integer.valueOf(paramInt)));
      String str = ((com.tencent.mm.plugin.finder.live.gala.a.a)b.a(this.adlW).agjD.get(paramInt)).groupId;
      b.a(this.adlW, str);
      AppMethodBeat.o(371214);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(com.tencent.mm.plugin.finder.live.gala.a.a parama, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.b.b
 * JD-Core Version:    0.7.0.1
 */