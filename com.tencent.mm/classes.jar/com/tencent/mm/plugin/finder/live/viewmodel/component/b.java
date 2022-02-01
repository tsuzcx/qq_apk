package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.iv;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveVisitorFragment;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveExitAnimateOpUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "currentFeedId", "", "finderLiveBundle", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "finderLiveViewLayoutEventListener", "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveExitAnimateOpUIC$finderLiveViewLayoutEventListener$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveExitAnimateOpUIC$finderLiveViewLayoutEventListener$1;", "interceptEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderFluentSwitchInterceptEvent;", "isEventIntercept", "", "isForceFinish", "isUserClose", "()Z", "setUserClose", "(Z)V", "isVoiceFinish", "livePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "parentView", "Landroid/view/ViewGroup;", "videoHeight", "", "videoRatioWH", "", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "videoWidth", "voipCallEvent", "Lcom/tencent/mm/autogen/events/VoipEvent;", "attachToWindow", "", "director", "Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchInWindowDirector;", "outParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "liveFragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "checkIsNeedInterceptExit", "isSwiping", "checkWindowExit", "isShowFloatWindow", "errorNotifyFinish", "source", "", "isCurrentFeed", "isLandscape", "isNeedIntercept", "isSwipBack", "notifyFinish", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDirectorExit", "Lcom/tencent/mm/plugin/finder/live/fluent/IFinderFluentSwitchDirector;", "onWindowExit", "switchDirector", "startExitAnimate", "switchFinish", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public static final b.a DZY;
  private final IListener<acn> BtB;
  private com.tencent.mm.live.core.core.c.b CCB;
  private TXCloudVideoView CDn;
  private boolean DZZ;
  private boolean Eaa;
  private FinderLiveBundle Eab;
  private long Eac;
  private boolean Ead;
  public boolean Eae;
  private final FinderLiveExitAnimateOpUIC.finderLiveViewLayoutEventListener.1 Eaf;
  private final IListener<iv> Eag;
  private float hKI;
  private ViewGroup parentView;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(357075);
    DZY = new b.a((byte)0);
    AppMethodBeat.o(357075);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356915);
    this.Eaf = new FinderLiveExitAnimateOpUIC.finderLiveViewLayoutEventListener.1(this, com.tencent.mm.app.f.hfK);
    this.BtB = ((IListener)new FinderLiveExitAnimateOpUIC.voipCallEvent.1(this, com.tencent.mm.app.f.hfK));
    this.Eag = ((IListener)new FinderLiveExitAnimateOpUIC.interceptEvent.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(356915);
  }
  
  private final void ayi(String paramString)
  {
    AppMethodBeat.i(356921);
    com.tencent.mm.plugin.finder.live.fluent.g localg = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    com.tencent.mm.plugin.finder.live.fluent.g.eju();
    ayj(paramString);
    AppMethodBeat.o(356921);
  }
  
  private final void ayj(String paramString)
  {
    AppMethodBeat.i(356930);
    Log.i("FinderLiveExitAnimateOp", "notifyFinish source: " + paramString + " start finish");
    this.DZZ = true;
    getActivity().finish();
    AppMethodBeat.o(356930);
  }
  
  private static void b(com.tencent.mm.plugin.finder.live.fluent.director.live.b paramb)
  {
    AppMethodBeat.i(356942);
    paramb.ejM();
    paramb = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    com.tencent.mm.plugin.finder.live.fluent.g.eju();
    AppMethodBeat.o(356942);
  }
  
  private final boolean exD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(356954);
    Object localObject1 = aj.CGT;
    localObject1 = aj.egD();
    long l;
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      Log.i("FinderLiveExitAnimateOp", "isCurrentFeed currentFeedId: " + this.Eac + " currentLiveFeedId: " + localObject1);
      if (this.Eac == 0L) {
        break label160;
      }
      l = this.Eac;
      if (localObject1 != null) {
        break label150;
      }
    }
    label83:
    for (boolean bool = false;; bool = true)
    {
      if (!bool)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
        com.tencent.mm.plugin.finder.live.fluent.g.eju();
      }
      AppMethodBeat.o(356954);
      return bool;
      Object localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).exW();
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject3).Ebr;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = Long.valueOf(((LiveConfig)localObject3).mIH);
      break;
      if (l != ((Long)localObject1).longValue()) {
        break label83;
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(357118);
    this.Eae = true;
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(357118);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(357082);
    super.onCreate(paramBundle);
    this.Eab = ((FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
    this.Eac = getIntent().getLongExtra("CURRENT_FEED_ID", 0L);
    FinderObject localFinderObject;
    if (this.Eac == 0L)
    {
      paramBundle = this.Eab;
      if (paramBundle != null)
      {
        localFinderObject = paramBundle.CFj;
        if (localFinderObject != null) {
          break label212;
        }
      }
    }
    label212:
    for (long l = 0L;; l = localFinderObject.id)
    {
      this.Eac = l;
      if ((this.Eac == 0L) && (paramBundle.CFa.size() > 0)) {
        this.Eac = ((LiveConfig)paramBundle.CFa.get(0)).mIH;
      }
      Log.i("FinderLiveExitAnimateOp", s.X("onCreate currentFeedId: ", Long.valueOf(this.Eac)));
      paramBundle = getActivity().findViewById(p.e.fragment_container);
      s.s(paramBundle, "activity.findViewById(R.id.fragment_container)");
      this.parentView = ((ViewGroup)paramBundle);
      this.Eaf.alive();
      this.BtB.alive();
      this.Eag.alive();
      paramBundle = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      com.tencent.mm.plugin.finder.live.fluent.g.qv(false);
      paramBundle = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      com.tencent.mm.plugin.finder.live.fluent.g.qw(false);
      paramBundle = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      com.tencent.mm.plugin.finder.live.fluent.g.qx(false);
      AppMethodBeat.o(357082);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(357116);
    super.onDestroy();
    Log.i("FinderLiveExitAnimateOp", "onDestroy");
    this.CDn = null;
    this.Eaf.dead();
    this.BtB.dead();
    this.Eag.dead();
    com.tencent.mm.plugin.finder.live.fluent.g localg = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    com.tencent.mm.plugin.finder.live.fluent.g.qw(true);
    AppMethodBeat.o(357116);
  }
  
  public final boolean sh(boolean paramBoolean)
  {
    AppMethodBeat.i(357107);
    if (this.DZZ)
    {
      AppMethodBeat.o(357107);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    localObject1 = com.tencent.mm.plugin.finder.live.fluent.g.nW(this.Eac);
    int i;
    if (localObject1 != null)
    {
      Log.i("FinderLiveExitAnimateOp", s.X("isNeedIntercept hasDetach : ", Boolean.valueOf(((com.tencent.mm.plugin.finder.live.fluent.k)localObject1).aFA())));
      if (!((com.tencent.mm.plugin.finder.live.fluent.k)localObject1).aFA())
      {
        ((com.tencent.mm.plugin.finder.live.fluent.k)localObject1).ejn();
        i = 0;
        label80:
        if (i == 0) {
          break label1513;
        }
      }
    }
    final FinderLiveVisitorFragment localFinderLiveVisitorFragment;
    label132:
    label471:
    Object localObject4;
    label574:
    label597:
    Object localObject3;
    label684:
    label766:
    Object localObject5;
    label791:
    Object localObject6;
    long l;
    for (;;)
    {
      try
      {
        localFinderLiveVisitorFragment = ((FinderLiveVisitorWithoutAffinityUI)getActivity()).BpT;
        if ((localFinderLiveVisitorFragment != null) && (this.CDn != null))
        {
          localObject1 = this.CDn;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          break label1533;
        }
        ayj("liveFragment = null or videoView = null");
      }
      finally
      {
        boolean bool3;
        Log.e("FinderLiveExitAnimateOp", "startExitAnimate exception", new Object[] { localObject2 });
        ayj("exception");
        continue;
        localObject3 = localObject2.bch();
        continue;
        paramBoolean = ((com.tencent.mm.plugin.finder.live.model.service.a)localObject4).bfD();
        continue;
      }
      AppMethodBeat.o(357107);
      return true;
      if ((!this.Eae) || (paramBoolean))
      {
        Log.i("FinderLiveExitAnimateOp", "isNeedIntercept isUserClose = false");
        break;
      }
      localObject1 = aj.CGT;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 == null)
      {
        paramBoolean = true;
        localObject1 = aj.CGT;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 != null) {
          continue;
        }
        i = 0;
        bool3 = com.tencent.mm.ae.d.ee(i, 524288);
        localObject1 = aj.CGT;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 != null) {
          continue;
        }
        bool1 = false;
        if (getActivity().getResources().getConfiguration().orientation != 2) {
          continue;
        }
        bool2 = true;
        Log.i("FinderLiveExitAnimateOp", "isNeedInterceptdestory currentLiveFeedId = " + exD() + " isForceFinish = " + this.DZZ + " isLiveFinish: " + paramBoolean + " isVoiceFinish: " + this.Eaa + " isVrLive: " + bool1 + " isLandscape: " + bool2 + " isEventIntercept: " + this.Ead + "isPause: " + bool3);
        localObject1 = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
        if ((!com.tencent.mm.plugin.finder.live.fluent.a.ejm()) || (this.DZZ) || (!exD()) || (paramBoolean) || (bool3) || (this.Eaa) || (bool1) || (bool2) || (this.Ead)) {
          break;
        }
        i = 1;
        break label80;
      }
      paramBoolean = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).eyA();
      continue;
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EcS;
      continue;
      boolean bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).eyM();
      continue;
      boolean bool2 = false;
      continue;
      localObject1 = ((TXCloudVideoView)localObject1).getVideoView();
      break label1533;
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((i)com.tencent.mm.ui.component.k.y((Fragment)localFinderLiveVisitorFragment).q(i.class)).getIFinderLiveCommonAdapter();
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject4 = com.tencent.mm.ui.component.k.aeZF;
        localObject4 = ((i)com.tencent.mm.ui.component.k.y((Fragment)localFinderLiveVisitorFragment).q(i.class)).getIFinderLiveCommonAdapter();
        if (localObject4 != null) {
          continue;
        }
        paramBoolean = false;
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).bex() != true)) {
          break label1552;
        }
        i = 1;
        if (i == 0)
        {
          if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).beu() != true)) {
            break label1557;
          }
          i = 1;
          if (i == 0)
          {
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).bet() != true)) {
              break label1562;
            }
            i = 1;
            break label1541;
          }
        }
        ayi("liveStatus invalid: " + localObject1 + " isCdnMode: " + paramBoolean);
      }
      localObject3 = com.tencent.mm.ui.component.k.aeZF;
      localObject3 = ((i)com.tencent.mm.ui.component.k.y((Fragment)localFinderLiveVisitorFragment).q(i.class)).getIFinderLiveCommonAdapter();
      if (localObject3 == null) {}
      for (paramBoolean = false;; paramBoolean = ((com.tencent.mm.plugin.finder.live.model.service.a)localObject3).enm())
      {
        bool1 = com.tencent.mm.compatible.e.b.dh((Context)getContext());
        bool2 = ((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actB, d.a.acsO);
        if (!paramBoolean) {
          break label1572;
        }
        if (!bool1) {
          break label1567;
        }
        if (bool2) {
          break label1572;
        }
        break label1567;
        if (i == 0) {
          break label791;
        }
        ayi("window permission reject");
        break;
      }
      getActivity().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
      getActivity().getWindow().getDecorView().setBackgroundColor(0);
      localObject3 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      localObject5 = com.tencent.mm.plugin.finder.live.fluent.g.nW(this.Eac);
      if ((localObject5 instanceof com.tencent.mm.plugin.finder.live.fluent.e))
      {
        localObject3 = ((com.tencent.mm.plugin.finder.live.fluent.e)localObject5).ejq();
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.live.fluent.f)localObject3).CCr = paramBoolean;
        }
      }
      localObject3 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
      com.tencent.mm.plugin.finder.live.fluent.g.qv(true);
      if ((paramBoolean) || (localObject5 == null)) {
        break label1577;
      }
      if ((this.CDn == null) || (((com.tencent.mm.plugin.finder.live.fluent.k)localObject5).ejp() == null))
      {
        ayi("onDirectorExit object = null");
      }
      else
      {
        localObject3 = ((com.tencent.mm.plugin.finder.live.fluent.k)localObject5).ejp();
        s.checkNotNull(localObject3);
        localObject6 = ((com.tencent.mm.plugin.finder.live.fluent.h)localObject3).CCA;
        l = this.Eac;
        localObject4 = this.parentView;
        localObject3 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("parentView");
          localObject3 = null;
        }
        localObject3 = new com.tencent.mm.plugin.finder.live.fluent.params.a((h.a)localObject6, l, (ViewGroup)localObject3, this.CDn);
        if (((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject3).CCA == h.a.CCF)
        {
          ayi("onDirectorExit scent = window");
        }
        else
        {
          ((com.tencent.mm.plugin.finder.live.fluent.k)localObject5).a((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject3);
          Log.i("FinderLiveExitAnimateOp", s.X("onDirectorExit params = ", localObject3));
          ((com.tencent.mm.plugin.finder.live.fluent.k)localObject5).aY((kotlin.g.a.a)new b.d((com.tencent.mm.plugin.finder.live.fluent.k)localObject5, this, localFinderLiveVisitorFragment));
          continue;
          label1052:
          if (localObject3 != null) {
            break label1601;
          }
          localObject3 = new com.tencent.mm.plugin.finder.live.fluent.h(h.a.CCG, this.Eac, null, this.videoWidth, this.videoHeight, this.hKI, this.CCB);
          if (((com.tencent.mm.plugin.finder.live.fluent.h)localObject3).CCB == null) {
            ((com.tencent.mm.plugin.finder.live.fluent.h)localObject3).CCB = this.CCB;
          }
          if ((((com.tencent.mm.plugin.finder.live.fluent.h)localObject3).videoWidth == 0) || (((com.tencent.mm.plugin.finder.live.fluent.h)localObject3).videoHeight == 0)) {
            break label1609;
          }
          if (((com.tencent.mm.plugin.finder.live.fluent.h)localObject3).hKI != 0.0F) {
            break label1604;
          }
          i = 1;
          break label1592;
        }
      }
    }
    for (;;)
    {
      label1138:
      if (i == 0)
      {
        ayi("outParams invalid");
        break label132;
      }
      label1282:
      label1513:
      label1533:
      do
      {
        localObject3 = ((com.tencent.mm.plugin.finder.live.fluent.k)localObject5).ejp();
        break label1052;
        localObject4 = com.tencent.mm.ui.component.k.aeZF;
        localObject4 = ((i)com.tencent.mm.ui.component.k.y((Fragment)localFinderLiveVisitorFragment).q(i.class)).getIFinderLiveCommonAdapter();
        if (localObject4 != null) {
          ((com.tencent.mm.plugin.finder.live.model.service.a)localObject4).qL(true);
        }
        localObject4 = com.tencent.mm.ui.component.k.aeZF;
        localObject4 = ((i)com.tencent.mm.ui.component.k.y((Fragment)localFinderLiveVisitorFragment).q(i.class)).getIFinderLiveCommonAdapter();
        if (localObject4 == null) {}
        for (localObject4 = null;; localObject4 = ((com.tencent.mm.plugin.finder.live.model.service.a)localObject4).enn())
        {
          if ((localObject4 != null) && ((((com.tencent.mm.live.core.mini.b)localObject4).mUN instanceof com.tencent.mm.live.core.view.a)) && (this.CDn != null)) {
            break label1282;
          }
          ayi("liveMiniManager not FluentSwitchRelativeLayout");
          break;
        }
        localObject5 = MMApplicationContext.getContext();
        s.s(localObject5, "getContext()");
        final com.tencent.mm.plugin.finder.live.fluent.director.live.b localb = new com.tencent.mm.plugin.finder.live.fluent.director.live.b((Context)localObject5, (Activity)getActivity());
        localb.b((com.tencent.mm.plugin.finder.live.fluent.h)localObject3);
        h.a locala = h.a.CCG;
        l = this.Eac;
        localObject6 = this.parentView;
        localObject5 = localObject6;
        if (localObject6 == null)
        {
          s.bIx("parentView");
          localObject5 = null;
        }
        localObject5 = new com.tencent.mm.plugin.finder.live.fluent.params.a(locala, l, (ViewGroup)localObject5, this.CDn);
        ((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject5).CDo = ((com.tencent.mm.live.core.mini.b)localObject4).mUN;
        localObject4 = com.tencent.mm.ui.component.k.aeZF;
        localObject4 = ((i)com.tencent.mm.ui.component.k.y((Fragment)localFinderLiveVisitorFragment).q(i.class)).getIFinderLiveCommonAdapter();
        if (localObject4 == null) {}
        for (localObject4 = null;; localObject4 = ((com.tencent.mm.plugin.finder.live.model.service.a)localObject4).enp())
        {
          ((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject5).CDp = ((Point)localObject4);
          localb.a((com.tencent.mm.plugin.finder.live.fluent.params.a)localObject5);
          Log.i("FinderLiveExitAnimateOp", "onWindowExit outParams = " + localObject3 + " inParams = " + localObject5);
          localb.aY((kotlin.g.a.a)new e(this, localb, (com.tencent.mm.plugin.finder.live.fluent.h)localObject3, localFinderLiveVisitorFragment));
          break;
        }
        do
        {
          ayj("director = null");
          break label132;
          localObject3 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
          com.tencent.mm.plugin.finder.live.fluent.g.nZ(this.Eac);
          AppMethodBeat.o(357107);
          return false;
          if (localObject3 != null) {
            break label471;
          }
          break;
          for (;;)
          {
            if (i != 0) {
              break label1565;
            }
            if (paramBoolean) {
              break label684;
            }
            break label597;
            i = 0;
            break;
            i = 0;
            break label574;
            i = 0;
          }
          break label597;
          i = 1;
          break label766;
          i = 0;
          break label766;
        } while (!paramBoolean);
      } while (localObject5 != null);
      label1541:
      label1552:
      label1557:
      label1562:
      label1565:
      label1567:
      label1572:
      label1577:
      localObject3 = null;
      break label1052;
      for (;;)
      {
        label1592:
        if (i != 0) {
          break label1609;
        }
        i = 1;
        break label1138;
        label1601:
        break;
        label1604:
        i = 0;
      }
      label1609:
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    b(ah.a parama, b paramb, com.tencent.mm.plugin.finder.live.fluent.director.live.b paramb1, com.tencent.mm.live.core.view.a parama1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ah.a parama, b paramb, com.tencent.mm.plugin.finder.live.fluent.director.live.b paramb1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(b paramb, com.tencent.mm.plugin.finder.live.fluent.director.live.b paramb1, com.tencent.mm.plugin.finder.live.fluent.h paramh, FinderLiveVisitorFragment paramFinderLiveVisitorFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.b
 * JD-Core Version:    0.7.0.1
 */