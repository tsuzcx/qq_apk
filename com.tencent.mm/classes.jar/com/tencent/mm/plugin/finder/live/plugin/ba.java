package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.aa;
import com.tencent.mm.plugin.finder.live.component.ab;
import com.tencent.mm.plugin.finder.live.component.z.a;
import com.tencent.mm.plugin.finder.live.component.z.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.fwv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "attendLotteryJob", "Lkotlinx/coroutines/Job;", "cacheVisible", "", "getCacheVisible", "()Z", "setCacheVisible", "(Z)V", "dataObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "showingLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "getShowingLocation", "()Landroidx/lifecycle/MutableLiveData;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;)V", "canClearScreen", "checkCacheLotteryInfo", "", "doAttendLotteryLogic", "finallyRequestAttendLotteryWithFollowCondition", "getBottomLocation", "", "isAnchorFollowed", "mount", "onFollowChanged", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFollow", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onSceneEnd", "errType", "", "errCode", "errMsg", "printLotteryInfo", "action", "resumeLottery", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "unwatchLuckyMoneyBubbleShowingLocation", "updateLottery", "watchLuckyMoneyBubbleShowingLocation", "Companion", "ShowingLocation", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
  extends b
  implements com.tencent.mm.am.h
{
  public static final ba.a Def;
  private static final float Del;
  private z.b CyD;
  z.a CyQ;
  private cb Deg;
  public final x<b> Deh;
  private final View.OnLayoutChangeListener Dei;
  private volatile boolean Dej;
  private y<bc.b> Dek;
  private final aq mainScope;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355033);
    Def = new ba.a((byte)0);
    Del = -MMApplicationContext.getResources().getDimension(p.c.Edge_6_5_A);
    AppMethodBeat.o(355033);
  }
  
  public ba(final ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354979);
    this.nfT = paramb;
    this.mainScope = ar.kBZ();
    this.Deh = new x();
    paramb = paramViewGroup.getContext();
    kotlin.g.b.s.s(paramb, "root.context");
    this.CyQ = ((z.a)new aa(paramb, getBuContext(), this.nfT));
    paramb = (View)paramViewGroup;
    Object localObject = paramViewGroup.getContext();
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(354979);
      throw paramViewGroup;
    }
    this.CyD = ((z.b)new ab(paramb, (MMActivity)localObject, this.CyQ));
    paramb = this.CyQ;
    if (paramb != null)
    {
      localObject = this.CyD;
      kotlin.g.b.s.checkNotNull(localObject);
      paramb.onAttach(localObject);
    }
    paramb = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
    this.Deh.setValue(b.Den);
    this.Dei = ((View.OnLayoutChangeListener)new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(355642);
        if ((paramAnonymousInt6 == paramAnonymousInt2) && (paramAnonymousInt8 == paramAnonymousInt4))
        {
          AppMethodBeat.o(355642);
          return;
        }
        Log.i("FinderLiveLotteryBubblePlugin", "onLayoutChange: oldTop = " + paramAnonymousInt6 + ", oldBottom = " + paramAnonymousInt8 + ", top = " + paramAnonymousInt2 + ", bottom = " + paramAnonymousInt4);
        if ((paramAnonymousInt6 == 0) || (this.Dem.Deh.getValue() == ba.b.Dep))
        {
          paramAnonymousView = (bc)this.Dem.getPlugin(bc.class);
          float f;
          if (paramAnonymousView == null)
          {
            f = 0.0F;
            paramAnonymousView = (bc)this.Dem.getPlugin(bc.class);
            if (paramAnonymousView != null) {
              break label190;
            }
            paramAnonymousView = null;
          }
          for (;;)
          {
            if ((paramAnonymousView != bc.b.DeJ) || (f <= 0.0F)) {
              break label215;
            }
            paramViewGroup.setY(f + ba.eqS());
            this.Dem.Deh.setValue(ba.b.Dep);
            AppMethodBeat.o(355642);
            return;
            f = paramAnonymousView.eqY();
            break;
            label190:
            paramAnonymousView = paramAnonymousView.DeG;
            if (paramAnonymousView == null) {
              paramAnonymousView = null;
            } else {
              paramAnonymousView = (bc.b)paramAnonymousView.getValue();
            }
          }
          label215:
          paramViewGroup.setTranslationY(0.0F);
          this.Dem.Deh.setValue(ba.b.Deo);
          AppMethodBeat.o(355642);
          return;
        }
        this.Dem.Deh.setValue(this.Dem.Deh.getValue());
        AppMethodBeat.o(355642);
      }
    });
    Log.i("FinderLiveLotteryBubblePlugin", "enable :" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egt + ",useUpdateStrategy:" + ((e)business(e.class)).EdN);
    AppMethodBeat.o(354979);
  }
  
  private static final void a(ba paramba, bc.b paramb)
  {
    AppMethodBeat.i(355019);
    kotlin.g.b.s.u(paramba, "this$0");
    Object localObject;
    if (paramb == null)
    {
      localObject = null;
      Log.i("FinderLiveLotteryBubblePlugin", kotlin.g.b.s.X("watchLuckyMoneyBubbleShowingLocation: ", localObject));
      if (paramb != null) {
        break label117;
      }
    }
    label117:
    for (int i = -1;; i = c.avl[paramb.ordinal()])
    {
      if ((i == 1) && (paramba.Deh.getValue() == b.Dep))
      {
        ObjectAnimator.ofFloat(paramba.mJe, "translationY", new float[] { paramba.mJe.getTranslationY(), 0.0F }).setDuration(500L).start();
        paramba.Deh.setValue(b.Deo);
      }
      AppMethodBeat.o(355019);
      return;
      localObject = paramb.name();
      break;
    }
  }
  
  private final void axb(String paramString)
  {
    AppMethodBeat.i(354989);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.m)localObject).Bhm)
    {
      if (localObject == null) {
        Log.i("FinderLiveLotteryBubblePlugin", kotlin.g.b.s.X(paramString, " lotteryInfo is empty!"));
      }
      AppMethodBeat.o(354989);
      return;
    }
  }
  
  private final void eqQ()
  {
    AppMethodBeat.i(354997);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if (localObject == null)
    {
      localObject = null;
      Log.i("FinderLiveLotteryBubblePlugin", kotlin.g.b.s.X("#finallyRequestAttendLotteryWithFollowCondition begin , lotteryAttendType: ", localObject));
      if (localObject != null) {
        break label102;
      }
      label43:
      if (localObject != null) {
        break label160;
      }
    }
    for (;;)
    {
      Log.i("FinderLiveLotteryBubblePlugin", "#finallyRequestAttendLotteryWithFollowCondition Condition not invalid ");
      AppMethodBeat.o(354997);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.m)localObject).Bhm;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((bjc)localObject).ZQa;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = Integer.valueOf(((bja)localObject).ZSK);
      break;
      label102:
      if (((Integer)localObject).intValue() != 4) {
        break label43;
      }
      label160:
      do
      {
        cb localcb = this.Deg;
        if (localcb != null) {
          localcb.a(null);
        }
        this.Deg = kotlinx.coroutines.j.a(this.mainScope, null, null, (kotlin.g.a.m)new ba.d((Integer)localObject, this, null), 3);
        AppMethodBeat.o(354997);
        return;
      } while (((Integer)localObject).intValue() == 5);
    }
  }
  
  private final void eqR()
  {
    AppMethodBeat.i(355008);
    com.tencent.mm.plugin.finder.live.view.a locala = eoH();
    String str = MMApplicationContext.getContext().getResources().getString(p.h.Cmh);
    kotlin.g.b.s.s(str, "getContext().resources.g…er_live_lottery_attended)");
    locala.showCenterCustomizeToast(str, p.g.icons_outlined_done);
    com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFp, null);
    AppMethodBeat.o(355008);
  }
  
  public final void a(LinkedHashMap<String, Rect> arg1, boolean paramBoolean)
  {
    AppMethodBeat.i(355155);
    kotlin.g.b.s.u(???, "micUserMap");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
    {
      ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      for (;;)
      {
        synchronized ((Iterable)???)
        {
          Collection localCollection = (Collection)new ArrayList();
          Iterator localIterator = ???.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = localIterator.next();
          if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).EbK, Boolean.TRUE))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            localCollection.add(localObject2);
          }
        }
        int i = 0;
      }
      List localList = (List)localObject1;
      if (localList.size() >= 2)
      {
        ??? = this.CyD;
        if (??? == null) {
          break label209;
        }
        ???.qq(true);
        AppMethodBeat.o(355155);
        return;
      }
    }
    ??? = this.CyD;
    if (??? != null) {
      ???.qq(false);
    }
    label209:
    AppMethodBeat.o(355155);
  }
  
  public final float eiI()
  {
    AppMethodBeat.i(355108);
    float f1 = com.tencent.mm.ae.d.cZ((View)this.mJe)[1];
    float f2 = this.mJe.getHeight();
    AppMethodBeat.o(355108);
    return f1 + f2;
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void eqN()
  {
    AppMethodBeat.i(355089);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ba.f(this));
    AppMethodBeat.o(355089);
  }
  
  public final void eqO()
  {
    AppMethodBeat.i(355099);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ba.e(this));
    AppMethodBeat.o(355099);
  }
  
  public final void eqP()
  {
    AppMethodBeat.i(355128);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (!((e)business(e.class)).isLiveStarted()))
    {
      AppMethodBeat.o(355128);
      return;
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egv;
    com.tencent.mm.plugin.finder.live.viewmodel.data.m localm;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localm = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label198;
      }
      i = 1;
      label94:
      if (i == 0)
      {
        if (localm != null) {
          break label203;
        }
        localObject2 = null;
        label105:
        if (kotlin.g.b.s.p(localObject1, localObject2)) {
          if ((localm == null) || (localm.CBc != 1)) {
            break label226;
          }
        }
      }
    }
    label198:
    label203:
    label226:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        eqR();
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).Egv = null;
        Log.i("MMFinder.LiveLotterySlice", kotlin.g.b.s.X("resetCacheLotteryInfo:", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).Egv));
      }
      AppMethodBeat.o(355128);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.m)localObject1).Bhm;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bjc)localObject1).id;
      break;
      i = 0;
      break label94;
      localObject2 = localm.Bhm;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label105;
      }
      localObject2 = ((bjc)localObject2).id;
      break label105;
    }
  }
  
  public final void mount()
  {
    boolean bool2 = true;
    AppMethodBeat.i(355056);
    Object localObject1 = new StringBuilder("mount ").append(hashCode()).append(" presenter is empty:");
    if (this.CyQ == null)
    {
      bool1 = true;
      localObject1 = ((StringBuilder)localObject1).append(bool1).append(",viewCallback is empty:");
      if (this.CyD != null) {
        break label176;
      }
    }
    label176:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i("FinderLiveLotteryBubblePlugin", bool1);
      super.mount();
      if ((this.CyQ != null) && (this.CyD != null)) {
        break label205;
      }
      localObject1 = this.mJe.getContext();
      kotlin.g.b.s.s(localObject1, "root.context");
      this.CyQ = ((z.a)new aa((Context)localObject1, getBuContext(), this.nfT));
      localObject1 = (View)this.mJe;
      localObject2 = this.mJe.getContext();
      if (localObject2 != null) {
        break label181;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(355056);
      throw ((Throwable)localObject1);
      bool1 = false;
      break;
    }
    label181:
    this.CyD = ((z.b)new ab((View)localObject1, (MMActivity)localObject2, this.CyQ));
    label205:
    localObject1 = this.CyQ;
    if (localObject1 != null)
    {
      localObject2 = this.CyD;
      kotlin.g.b.s.checkNotNull(localObject2);
      ((z.a)localObject1).onAttach(localObject2);
    }
    this.mJe.addOnLayoutChangeListener(this.Dei);
    com.tencent.mm.kernel.h.aZW().a(30, (com.tencent.mm.am.h)this);
    localObject1 = new ba..ExternalSyntheticLambda0(this);
    Object localObject2 = (bc)getPlugin(bc.class);
    if (localObject2 != null)
    {
      localObject2 = ((bc)localObject2).DeG;
      if (localObject2 != null)
      {
        Context localContext = this.mJe.getContext();
        if (localContext == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(355056);
          throw ((Throwable)localObject1);
        }
        ((x)localObject2).a((q)localContext, (y)localObject1);
      }
    }
    localObject2 = ah.aiuX;
    this.Dek = ((y)localObject1);
    AppMethodBeat.o(355056);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(355145);
    paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      AppMethodBeat.o(355145);
      return;
    }
    if (paramp == null) {}
    for (paramString = null; paramString == null; paramString = Integer.valueOf(paramp.getType()))
    {
      AppMethodBeat.o(355145);
      return;
    }
    if ((paramString.intValue() == 30) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("FinderLiveLotteryBubblePlugin", "#onSceneEnd MMFunc_VerifyUser");
      paramString = paramp.getReqResp();
      if (!(paramString instanceof c)) {
        break label179;
      }
      paramString = (c)paramString;
      if (paramString != null) {
        break label184;
      }
    }
    label179:
    label184:
    for (paramString = null;; paramString = c.c.b(paramString.otC))
    {
      paramp = localObject;
      if ((paramString instanceof fwv)) {
        paramp = (fwv)paramString;
      }
      if ((paramp != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg) && (kotlin.g.b.s.p(paramp.UserName, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).hUQ))) {
        eqQ();
      }
      AppMethodBeat.o(355145);
      return;
      paramString = null;
      break;
    }
  }
  
  public final void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(355135);
    Log.i("FinderLiveLotteryBubblePlugin", kotlin.g.b.s.X("#onSceneEnd MMFunc_FinderFollow,isFollow:", Boolean.valueOf(paramBoolean)));
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).esD())) {
      eqQ();
    }
    AppMethodBeat.o(355135);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(355081);
    kotlin.g.b.s.u(paramc, "status");
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355081);
      return;
      AppMethodBeat.o(355081);
      return;
      axb("FINDER_LIVE_CREATE_LOTTERY_SUCCESS");
      eqN();
      AppMethodBeat.o(355081);
      return;
      axb("FINDER_LIVE_CANCEL_LOTTERY_SUCCESS");
      eqN();
      AppMethodBeat.o(355081);
      return;
      label133:
      label242:
      float f;
      if (paramBundle == null)
      {
        bool = false;
        this.Dej = bool;
        Log.i("FinderLiveLotteryBubblePlugin", "FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:" + this.Dej + ",screenclear:" + ((e)business(e.class)).EcH);
        axb(kotlin.g.b.s.X("FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:", Boolean.valueOf(this.Dej)));
        if (!this.Dej) {
          break label375;
        }
        if (!((e)business(e.class)).EcH)
        {
          this.CTm = 65535;
          tO(this.CTl);
        }
        if (this.mJe.getVisibility() == 0)
        {
          paramc = (bc)getPlugin(bc.class);
          if (paramc != null) {
            break label383;
          }
          f = 0.0F;
          label269:
          paramc = (bc)getPlugin(bc.class);
          if (paramc != null) {
            break label391;
          }
          paramc = null;
          label286:
          if ((paramc != bc.b.DeJ) || (f <= 0.0F) || (this.mJe.getTop() == 0)) {
            break label416;
          }
          this.mJe.setY(f + Del);
          this.Deh.setValue(b.Dep);
        }
      }
      while (this.nfT.getLiveRole() == 0)
      {
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFe, "");
        AppMethodBeat.o(355081);
        return;
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false);
        break label133;
        label375:
        tO(0);
        break label242;
        label383:
        f = paramc.eqY();
        break label269;
        label391:
        paramc = paramc.DeG;
        if (paramc == null)
        {
          paramc = null;
          break label286;
        }
        paramc = (bc.b)paramc.getValue();
        break label286;
        label416:
        this.mJe.setTranslationY(0.0F);
        this.Deh.setValue(b.Deo);
      }
      if (paramBundle == null)
      {
        label441:
        this.Dej = bool;
        Log.i("FinderLiveLotteryBubblePlugin", "FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:" + this.Dej + ",screenclear:" + ((e)business(e.class)).EcH);
        axb(kotlin.g.b.s.X("FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:", Boolean.valueOf(this.Dej)));
        if (!this.Dej) {
          break label575;
        }
        this.CTm = 8;
        tO(this.CTl);
      }
      while (this.mJe.getVisibility() == 8)
      {
        this.Deh.setValue(b.Den);
        AppMethodBeat.o(355081);
        return;
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false);
        break label441;
        label575:
        tO(8);
      }
      axb("FINDER_LIVE_LOTTERY_UPDATE");
      eqN();
      AppMethodBeat.o(355081);
      return;
      paramc = this.CyQ;
      if (paramc != null)
      {
        paramc.onDetach();
        AppMethodBeat.o(355081);
        return;
        eqQ();
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355117);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w("FinderLiveLotteryBubblePlugin", "setVisible return for isTeenMode");
      AppMethodBeat.o(355117);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(355117);
  }
  
  public final void unMount()
  {
    boolean bool2 = true;
    AppMethodBeat.i(355066);
    Object localObject1 = new StringBuilder("unMount ").append(hashCode()).append(" presenter is empty:");
    if (this.CyQ == null)
    {
      bool1 = true;
      localObject1 = ((StringBuilder)localObject1).append(bool1).append(",viewCallback is empty:");
      if (this.CyD != null) {
        break label195;
      }
    }
    label195:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i("FinderLiveLotteryBubblePlugin", bool1);
      super.unMount();
      localObject1 = this.CyQ;
      if (localObject1 != null) {
        ((z.a)localObject1).onDetach();
      }
      this.mJe.removeOnLayoutChangeListener(this.Dei);
      com.tencent.mm.kernel.h.aZW().b(30, (com.tencent.mm.am.h)this);
      localObject1 = this.Dek;
      if (localObject1 != null)
      {
        Object localObject2 = (bc)getPlugin(bc.class);
        if (localObject2 != null)
        {
          localObject2 = ((bc)localObject2).DeG;
          if (localObject2 != null) {
            ((x)localObject2).b((y)localObject1);
          }
        }
      }
      this.Dek = null;
      localObject1 = this.Deg;
      if (localObject1 != null) {
        ((cb)localObject1).a(null);
      }
      AppMethodBeat.o(355066);
      return;
      bool1 = false;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "", "(Ljava/lang/String;I)V", "GONE", "DEFAULT_LOCATION", "TRANSLATED_LOCATION", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(356103);
      Den = new b("GONE", 0);
      Deo = new b("DEFAULT_LOCATION", 1);
      Dep = new b("TRANSLATED_LOCATION", 2);
      Deq = new b[] { Den, Deo, Dep };
      AppMethodBeat.o(356103);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ba
 * JD-Core Version:    0.7.0.1
 */