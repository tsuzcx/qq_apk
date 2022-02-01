package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.widget.aa;
import com.tencent.mm.plugin.finder.live.widget.ac;
import com.tencent.mm.plugin.finder.live.widget.y;
import com.tencent.mm.plugin.finder.live.widget.z;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorFansClubPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "inviteWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubDescWidget;", "joinWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansJoinWidget;", "listWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget;", "taskWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansTaskWidget;", "checkFansClubState", "", "fromGiftPanel", "", "haveJoinFansClub", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initInviteWidget", "initJoinWidget", "initListWidget", "initTaskWidget", "mount", "onFollowChanged", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFollow", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "showHelpPage", "showInvitePanel", "needPurcase", "showJoinPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cl
  extends b
{
  public static final cl.a DlJ;
  private y DlK;
  private z DlL;
  private ac DlM;
  private aa DlN;
  private aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(354534);
    DlJ = new cl.a((byte)0);
    AppMethodBeat.o(354534);
  }
  
  public cl(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354418);
    this.coroutineScope = ar.kBZ();
    AppMethodBeat.o(354418);
  }
  
  private final void esJ()
  {
    AppMethodBeat.i(354430);
    if (this.DlK == null)
    {
      Object localObject = this.mJe.getContext();
      s.s(localObject, "root.context");
      localObject = new y((Context)localObject);
      ((y)localObject).setJoinClickListener((kotlin.g.a.b)new e(this));
      ((y)localObject).setHelpClickListener((kotlin.g.a.a)new f(this));
      ((y)localObject).c((b)this);
      ah localah = ah.aiuX;
      this.DlK = ((y)localObject);
    }
    AppMethodBeat.o(354430);
  }
  
  private final void esK()
  {
    AppMethodBeat.i(354443);
    if (this.DlM == null)
    {
      Object localObject = this.mJe.getContext();
      s.s(localObject, "root.context");
      localObject = new ac((Context)localObject);
      ((ac)localObject).setHelpIconClickListener((kotlin.g.a.a)new i(this));
      ((ac)localObject).setFansGroupClickListener((kotlin.g.a.a)new cl.j(this, (ac)localObject));
      ((ac)localObject).c((b)this);
      ah localah = ah.aiuX;
      this.DlM = ((ac)localObject);
    }
    AppMethodBeat.o(354443);
  }
  
  public final void c(Bundle paramBundle, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(354602);
    if (paramBundle == null) {
      paramBundle = null;
    }
    while (s.p(paramBundle, "PORTRAIT_ACTION_JOIN_FANS_CLUB")) {
      if (isFinished())
      {
        AppMethodBeat.o(354602);
        return;
        paramBundle = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      }
      else
      {
        if (!(paramObject instanceof Bundle)) {
          break label95;
        }
        paramBundle = (Bundle)paramObject;
        if (paramBundle != null) {
          break label100;
        }
        paramBundle = localObject;
      }
    }
    for (;;)
    {
      if (paramBundle == null) {
        Log.i("FinderLiveVisitorFansClubPanelPlugin", s.X("onPortraitAction extraData:", paramObject));
      }
      AppMethodBeat.o(354602);
      return;
      label95:
      paramBundle = null;
      break;
      label100:
      boolean bool1 = paramBundle.getBoolean("JOIN_FANS_CLUB_NEED_PURCHASE", false);
      boolean bool2 = paramBundle.getBoolean("JOIN_FANS_CLUB_FROM_GIFT", false);
      Log.i("FinderLiveVisitorFansClubPanelPlugin", "onPortraitAction needPurcase:" + bool1 + ",fromGiftPanel:" + bool2);
      esJ();
      y localy = this.DlK;
      paramBundle = localObject;
      if (localy != null)
      {
        localy.b(getBuContext(), bool1, bool2);
        paramBundle = ah.aiuX;
      }
    }
  }
  
  public final void mount()
  {
    AppMethodBeat.i(354579);
    Object localObject = this.DlL;
    if (localObject != null) {
      ((z)localObject).c((b)this);
    }
    localObject = this.DlM;
    if (localObject != null) {
      ((ac)localObject).c((b)this);
    }
    localObject = this.DlN;
    if (localObject != null) {
      ((aa)localObject).c((b)this);
    }
    localObject = this.DlK;
    if (localObject != null) {
      ((y)localObject).c((b)this);
    }
    AppMethodBeat.o(354579);
  }
  
  public final void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(354562);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
    if ((localObject1 != null) && (((bgw)localObject1).ZQq == true))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
        if ((localObject1 == null) || (((bgw)localObject1).ZQo != true)) {
          break label82;
        }
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label87;
      }
      AppMethodBeat.o(354562);
      return;
      i = 0;
      break;
    }
    label87:
    esJ();
    localObject1 = this.DlK;
    if (localObject1 != null)
    {
      Log.i("FinderLiveFansClubDescWidget", "followSuccess tryFollowing:" + ((y)localObject1).Eph + ",isFollow:" + paramBoolean);
      if ((paramBoolean) && (((y)localObject1).Eph))
      {
        ((y)localObject1).Eph = false;
        Object localObject2 = ((y)localObject1).getBasePlugin();
        if (localObject2 != null)
        {
          localObject2 = (cd)((b)localObject2).getPlugin(cd.class);
          if (localObject2 != null) {
            cd.a((cd)localObject2);
          }
        }
        ((y)localObject1).eAG();
      }
    }
    AppMethodBeat.o(354562);
  }
  
  public final void rN(final boolean paramBoolean)
  {
    AppMethodBeat.i(354570);
    Log.i("FinderLiveVisitorFansClubPanelPlugin", "checkFansClubState fromGiftPanel:" + paramBoolean + ", isActivate:" + ar.a(this.coroutineScope));
    j.a(this.coroutineScope, null, null, (m)new c(this, paramBoolean, null), 3);
    AppMethodBeat.o(354570);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354548);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354548);
      return;
      if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
      {
        Log.i("FinderLiveVisitorFansClubPanelPlugin", "青少年模式不展示粉丝");
        paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramc = this.mJe.getContext();
        s.s(paramc, "root.context");
        com.tencent.mm.plugin.finder.live.utils.a.aD(paramc, "青少年模式不展示粉丝");
        AppMethodBeat.o(354548);
        return;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Eff)
      {
        esK();
        paramc = this.DlM;
        if (paramc != null)
        {
          paramc.W(false);
          AppMethodBeat.o(354548);
        }
      }
      else
      {
        rN(false);
        AppMethodBeat.o(354548);
        return;
        unMount();
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354590);
    Object localObject = this.DlL;
    if (localObject != null) {
      ((z)localObject).unMount();
    }
    localObject = this.DlM;
    if (localObject != null) {
      ((ac)localObject).unMount();
    }
    localObject = this.DlN;
    if (localObject != null) {
      ((aa)localObject).unMount();
    }
    localObject = this.DlK;
    if (localObject != null) {
      ((y)localObject).unMount();
    }
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(354590);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(cl paramcl, boolean paramBoolean, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(356063);
      paramObject = (kotlin.d.d)new c(this.DlO, paramBoolean, paramd);
      AppMethodBeat.o(356063);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool2 = true;
      AppMethodBeat.i(356060);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(356060);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (f)bg.kCi();
        localObject1 = (m)new a(this.DlO, null);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = l.a(paramObject, (m)localObject1, locald);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(356060);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (r)paramObject;
      boolean bool3 = ((Boolean)paramObject.bsC).booleanValue();
      boolean bool4 = ((Boolean)paramObject.bsD).booleanValue();
      paramObject = new StringBuilder("haveJoinFansClub success:");
      if (bool3)
      {
        bool1 = true;
        paramObject = paramObject.append(bool1).append(", needPurcase:");
        if (!bool4) {
          break label351;
        }
        bool1 = true;
        label192:
        Log.i("FinderLiveVisitorFansClubPanelPlugin", bool1);
        if (bool3)
        {
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)this.DlO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)this.DlO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efh;
          paramObject = localObject1;
          if (localObject1 == null)
          {
            paramObject = q.CFU;
            localObject1 = ((Iterable)q.ekL().values()).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              paramObject = ((Iterator)localObject1).next();
            } while (!com.tencent.mm.ae.d.ee(((com.tencent.d.a.a.a.d.a.d)paramObject).field_flag, 4));
            label303:
            paramObject = (com.tencent.d.a.a.a.d.a.d)paramObject;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)localObject2).b(paramObject);
          paramObject = this.DlO;
          if (!bool4) {
            break label361;
          }
        }
      }
      label351:
      label361:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        cl.a(paramObject, bool1, paramBoolean);
        paramObject = ah.aiuX;
        AppMethodBeat.o(356060);
        return paramObject;
        bool1 = false;
        break;
        bool1 = false;
        break label192;
        paramObject = null;
        break label303;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super r<? extends Boolean, ? extends Boolean>>, Object>
    {
      int label;
      
      a(cl paramcl, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(354596);
        paramObject = (kotlin.d.d)new a(this.DlO, paramd);
        AppMethodBeat.o(354596);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(354586);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(354586);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.DlO;
          Object localObject = (kotlin.d.d)this;
          this.label = 1;
          localObject = cl.a(paramObject, (kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(354586);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(354586);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "fromGiftPanel", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    e(cl paramcl)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(cl paramcl)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "fromGiftPanel", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    g(cl paramcl)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    h(cl paramcl)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(cl paramcl)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cl
 * JD-Core Version:    0.7.0.1
 */