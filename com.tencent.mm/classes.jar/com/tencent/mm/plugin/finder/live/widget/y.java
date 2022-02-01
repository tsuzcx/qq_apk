package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.cb;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.service.n;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubDescWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fansMemberCount", "Landroid/widget/TextView;", "follow", "", "getFollow", "()Z", "setFollow", "(Z)V", "fromGiftPanel", "getFromGiftPanel", "setFromGiftPanel", "helpBtn", "helpClickListener", "Lkotlin/Function0;", "", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "joinBtn", "joinClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getJoinClickListener", "()Lkotlin/jvm/functions/Function1;", "setJoinClickListener", "(Lkotlin/jvm/functions/Function1;)V", "needPurcahse", "getNeedPurcahse", "setNeedPurcahse", "oplogCallback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "payTips", "root", "title", "tryFollowing", "getTryFollowing", "setTryFollowing", "directJoin", "doBlockOpLog", "username", "", "doFollowLogic", "doJoinLogic", "followActionSuccess", "isFollow", "hide", "join", "liveCookie", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "objectId", "(Lcom/tencent/mm/protobuf/ByteString;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClick", "v", "setContent", "business", "show", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends p
  implements View.OnClickListener
{
  public static final y.a EoX;
  private ck<bpq> CYX;
  private final View CxW;
  private final View EoY;
  private final View EoZ;
  private final TextView Epa;
  private final TextView Epb;
  private com.tencent.mm.ui.widget.a.h Epc;
  private kotlin.g.a.b<? super Boolean, ah> Epd;
  private boolean Epe;
  private boolean Epf;
  private boolean Epg;
  public boolean Eph;
  private com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private aq coroutineScope;
  private final View lBX;
  private final TextView mll;
  private kotlin.g.a.a<ah> sRF;
  
  static
  {
    AppMethodBeat.i(362281);
    EoX = new y.a((byte)0);
    AppMethodBeat.o(362281);
  }
  
  public y(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(362242);
    this.lBX = LayoutInflater.from(paramContext).inflate(p.f.CdB, (ViewGroup)this, false);
    this.CxW = this.lBX.findViewById(p.e.BDr);
    this.EoY = this.lBX.findViewById(p.e.BDq);
    this.mll = ((TextView)this.lBX.findViewById(p.e.BDs));
    this.EoZ = this.lBX.findViewById(p.e.BZi);
    this.Epa = ((TextView)this.lBX.findViewById(p.e.BDH));
    this.Epb = ((TextView)this.lBX.findViewById(p.e.BVP));
    this.coroutineScope = ar.kBZ();
    this.CxW.setOnClickListener((View.OnClickListener)this);
    this.EoY.setOnClickListener((View.OnClickListener)this);
    this.Epb.setOnClickListener((View.OnClickListener)this);
    paramContext = this.Epb;
    s.s(paramContext, "joinBtn");
    setTextBold(paramContext);
    AppMethodBeat.o(362242);
  }
  
  private final void c(com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(362259);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = d.a.auT(((e)parama.business(e.class)).mIC);
    TextView localTextView = this.mll;
    Context localContext1 = this.lBX.getContext();
    Context localContext2 = this.lBX.getContext();
    int i = p.h.Ckd;
    Object localObject2;
    label92:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      if (localObject2 != null) {
        break label306;
      }
      localObject2 = "";
      localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(localContext1, (CharSequence)localContext2.getString(i, new Object[] { localObject1, localObject2 }), this.mll.getTextSize()));
      localObject1 = this.Epa;
      localObject2 = this.lBX.getContext();
      int j = p.h.Cke;
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      if (localObject3 != null) {
        break label330;
      }
      i = 0;
      label177:
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(j, new Object[] { Integer.valueOf(i) }));
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      this.Epg = com.tencent.mm.plugin.finder.live.utils.a.q(parama);
      if (!this.Epg) {
        break label351;
      }
      if (!paramBoolean) {
        break label339;
      }
      this.EoZ.setVisibility(0);
    }
    for (;;)
    {
      this.Epb.setText((CharSequence)getContext().getString(p.h.Ckm));
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.cb.DEj, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Epf));
      AppMethodBeat.o(362259);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.api.m)localObject1).getNickname();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label306:
      localObject3 = ((bgw)localObject2).ZQn;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label92;
      }
      localObject2 = "";
      break label92;
      label330:
      i = ((bgw)localObject3).YFb;
      break label177;
      label339:
      this.EoZ.setVisibility(8);
    }
    label351:
    if (paramBoolean) {
      this.EoZ.setVisibility(0);
    }
    for (;;)
    {
      this.Epb.setText((CharSequence)getContext().getString(p.h.Ckl));
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cb.DEh, Boolean.valueOf(paramBoolean), null, 4);
      AppMethodBeat.o(362259);
      return;
      this.EoZ.setVisibility(8);
    }
  }
  
  private final void eAH()
  {
    AppMethodBeat.i(362265);
    j.a(this.coroutineScope, null, null, (kotlin.g.a.m)new b(this, null), 3);
    AppMethodBeat.o(362265);
  }
  
  public final void b(com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(362369);
    s.u(parama, "business");
    this.buContext = parama;
    this.Epe = paramBoolean1;
    this.Epf = paramBoolean2;
    c(parama, paramBoolean1);
    parama = new com.tencent.mm.ui.widget.a.h(getContext());
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject = this.lBX;
    s.s(localObject, "root");
    com.tencent.mm.plugin.finder.live.utils.a.gg((View)localObject);
    parama.mh(this.lBX);
    parama.jHO();
    parama.dDn();
    localObject = ah.aiuX;
    this.Epc = parama;
    AppMethodBeat.o(362369);
  }
  
  public final void eAG()
  {
    AppMethodBeat.i(362402);
    if (this.Epe)
    {
      hide();
      kotlin.g.a.b localb = this.Epd;
      if (localb != null)
      {
        localb.invoke(Boolean.valueOf(this.Epf));
        AppMethodBeat.o(362402);
      }
    }
    else
    {
      eAH();
    }
    AppMethodBeat.o(362402);
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getBuContext()
  {
    return this.buContext;
  }
  
  public final boolean getFollow()
  {
    return this.Epg;
  }
  
  public final boolean getFromGiftPanel()
  {
    return this.Epf;
  }
  
  public final kotlin.g.a.a<ah> getHelpClickListener()
  {
    return this.sRF;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getJoinClickListener()
  {
    return this.Epd;
  }
  
  public final boolean getNeedPurcahse()
  {
    return this.Epe;
  }
  
  public final boolean getTryFollowing()
  {
    return this.Eph;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(362378);
    com.tencent.mm.ui.widget.a.h localh = this.Epc;
    if (localh != null) {
      localh.cyW();
    }
    this.Epc = null;
    this.Eph = false;
    AppMethodBeat.o(362378);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(362397);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubDescWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BDr;
      if (paramView != null) {
        break label106;
      }
      label56:
      i = p.e.BDq;
      if (paramView != null) {
        break label121;
      }
      label64:
      i = p.e.BVP;
      if (paramView != null) {
        break label148;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubDescWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362397);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label106:
      if (paramView.intValue() != i) {
        break label56;
      }
      hide();
      continue;
      label121:
      if (paramView.intValue() != i) {
        break label64;
      }
      paramView = this.sRF;
      if (paramView != null)
      {
        paramView.invoke();
        continue;
        label148:
        if (paramView.intValue() == i)
        {
          paramView = aw.Gjk;
          if (aw.isFastClick())
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubDescWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(362397);
            return;
          }
          if (!this.Epg) {
            break label226;
          }
          com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.cb.DEk, Boolean.valueOf(this.Epe), Boolean.valueOf(this.Epf));
          eAG();
        }
      }
    }
    label226:
    com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cb.DEi, Boolean.valueOf(this.Epe), null, 4);
    paramView = this.buContext;
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((paramView == null) || (paramView.Ecg != true)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label329;
      }
      paramView = this.buContext;
      if (paramView == null) {
        break;
      }
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject = getContext();
      s.s(localObject, "context");
      com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject, paramView, (kotlin.g.a.b)y.d.Epk);
      break;
    }
    label329:
    paramView = com.tencent.mm.plugin.finder.api.d.AwY;
    paramView = this.buContext;
    if (paramView == null) {
      paramView = null;
    }
    for (;;)
    {
      localObject = d.a.auT(paramView);
      if (localObject != null) {
        break label423;
      }
      paramView = null;
      label357:
      if (paramView != null) {
        break label695;
      }
      Log.i("FinderLiveFansClubDescWidget", "doFollowLogic anchorContact is null!");
      aa.dc(getContext(), getContext().getString(p.h.CjY));
      setTryFollowing(false);
      break;
      paramView = (e)paramView.business(e.class);
      if (paramView == null) {
        paramView = null;
      } else {
        paramView = paramView.mIC;
      }
    }
    label423:
    paramView = aw.Gjk;
    boolean bool1 = aw.n((com.tencent.mm.plugin.finder.api.m)localObject);
    paramView = aw.Gjk;
    boolean bool2 = aw.o((com.tencent.mm.plugin.finder.api.m)localObject);
    String str1 = z.bAW();
    paramView = getBuContext();
    long l;
    label461:
    com.tencent.mm.plugin.h localh;
    bui localbui;
    String str2;
    if (paramView == null)
    {
      l = 0L;
      Log.i("FinderLiveFansClubDescWidget", "doFollowLogic, nickName:" + ((com.tencent.mm.plugin.finder.api.m)localObject).getNickname() + ", objectId:" + l + ", participantFinderUsername:" + str1 + ", isPrivate:" + bool1 + " , isBlock" + bool2);
      localh = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramView = this.lBX.getContext();
      s.s(paramView, "root.context");
      localbui = ((bn)com.tencent.mm.ui.component.k.nq(paramView).cq(bn.class)).fou();
      str2 = ((com.tencent.mm.plugin.finder.api.m)localObject).getUsername();
      paramView = bh.ABm;
      i = bh.dVr();
      s.s(str1, "participantFinderUsername");
      if (getBasePlugin() != null) {
        break label727;
      }
      paramView = null;
    }
    for (;;)
    {
      localh.a(localbui, str2, i, l, bool1, str1, paramView);
      if (bool2)
      {
        paramView = ((com.tencent.mm.plugin.finder.api.m)localObject).getUsername();
        Log.i("FinderLiveFansClubDescWidget", "[doBlockOpLog] ");
        this.CYX = ((ck)new y.c());
        ((n)com.tencent.mm.kernel.h.ax(n.class)).a(paramView, false, this.CYX);
      }
      setTryFollowing(true);
      paramView = ah.aiuX;
      break label357;
      label695:
      break;
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramView == null)
      {
        l = 0L;
        break label461;
      }
      l = paramView.hKN;
      break label461;
      label727:
      paramView = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (paramView == null) {
        paramView = null;
      } else {
        paramView = paramView.ekj();
      }
    }
  }
  
  public final void setBuContext(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    this.buContext = parama;
  }
  
  public final void setFollow(boolean paramBoolean)
  {
    this.Epg = paramBoolean;
  }
  
  public final void setFromGiftPanel(boolean paramBoolean)
  {
    this.Epf = paramBoolean;
  }
  
  public final void setHelpClickListener(kotlin.g.a.a<ah> parama)
  {
    this.sRF = parama;
  }
  
  public final void setJoinClickListener(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.Epd = paramb;
  }
  
  public final void setNeedPurcahse(boolean paramBoolean)
  {
    this.Epe = paramBoolean;
  }
  
  public final void setTryFollowing(boolean paramBoolean)
  {
    this.Eph = paramBoolean;
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(362382);
    super.unMount();
    hide();
    this.buContext = null;
    this.Epd = null;
    this.sRF = null;
    this.Epe = false;
    this.Epg = false;
    AppMethodBeat.o(362382);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(y paramy, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(362282);
      paramObject = (kotlin.d.d)new b(this.Epi, paramd);
      AppMethodBeat.o(362282);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      long l2 = 0L;
      AppMethodBeat.i(362275);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(362275);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = this.Epi.getContext();
        paramObject = this.Epi.getContext();
        label115:
        Object localObject2;
        final long l1;
        if (paramObject == null)
        {
          paramObject = null;
          localObject1 = w.a((Context)localObject1, (CharSequence)paramObject, false);
          ((w)localObject1).show();
          paramObject = this.Epi.getBuContext();
          if (paramObject != null) {
            break label224;
          }
          paramObject = null;
          localObject2 = this.Epi.getBuContext();
          if (localObject2 != null) {
            break label251;
          }
          l1 = 0L;
          label131:
          localObject2 = this.Epi.getBuContext();
          if (localObject2 != null) {
            break label299;
          }
        }
        for (;;)
        {
          localObject2 = (kotlin.d.f)bg.kCi();
          paramObject = (kotlin.g.a.m)new a(this.Epi, paramObject, l1, l2, null);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.L$0 = localObject1;
          this.label = 1;
          paramObject = l.a((kotlin.d.f)localObject2, paramObject, locald);
          if (paramObject != locala) {
            break label433;
          }
          AppMethodBeat.o(362275);
          return locala;
          paramObject = paramObject.getString(p.h.app_waiting);
          break;
          label224:
          paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramObject.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (paramObject == null)
          {
            paramObject = null;
            break label115;
          }
          paramObject = paramObject.mZp;
          break label115;
          label251:
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (localObject2 == null)
          {
            l1 = 0L;
            break label131;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).liveInfo;
          if (localObject2 == null)
          {
            l1 = 0L;
            break label131;
          }
          l1 = ((bip)localObject2).liveId;
          break label131;
          label299:
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (localObject2 != null) {
            l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).hKN;
          }
        }
      }
      Object localObject1 = (w)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      label433:
      for (;;)
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        ((w)localObject1).hide();
        ((w)localObject1).dismiss();
        if (bool)
        {
          this.Epi.hide();
          aa.y(this.Epi.getContext(), this.Epi.getContext().getString(p.h.Ckc), p.g.icons_outlined_done);
        }
        for (;;)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(362275);
          return paramObject;
          aa.dc(this.Epi.getContext(), this.Epi.getContext().getString(p.h.Cka));
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super Boolean>, Object>
    {
      int label;
      
      a(y paramy, byte[] paramArrayOfByte, long paramLong1, long paramLong2, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(361892);
        paramObject = (kotlin.d.d)new a(this.Epi, paramObject, l1, this.AsN, paramd);
        AppMethodBeat.o(361892);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(361884);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(361884);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = com.tencent.mm.bx.b.cX(paramObject);
          s.s(paramObject, "copyFrom(cookies)");
          long l1 = l1;
          long l2 = this.AsN;
          Object localObject = (kotlin.d.d)this;
          this.label = 1;
          localObject = y.a(paramObject, l1, l2, (kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(361884);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(361884);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.y
 * JD-Core Version:    0.7.0.1
 */