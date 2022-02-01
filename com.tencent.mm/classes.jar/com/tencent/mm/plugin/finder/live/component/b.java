package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ab;
import com.tencent.mm.plugin.finder.live.plugin.ax.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubblePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleContract$Presenter;", "viewRoot", "Landroid/view/View;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Landroid/view/View;Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "iconTickerJpb", "Lkotlinx/coroutines/Job;", "scope", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleContract$ViewCallback;)V", "addLocalGiftMsg", "", "rewardGiftId", "", "rewardGiftCnt", "", "comboId", "addSelfGiftToComment", "giftId", "comboCount", "onAnchorClick", "onAttach", "callback", "onDetach", "onVisitorClick", "updateBubbleInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a.a
{
  public static final b.a CvS;
  private final View CvT;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final com.tencent.mm.plugin.finder.live.view.a CvV;
  private cb CvW;
  a.b CvX;
  private final Context context;
  private aq coroutineScope;
  private final com.tencent.mm.live.b.b nfT;
  private final aq scope;
  
  static
  {
    AppMethodBeat.i(352626);
    CvS = new b.a((byte)0);
    AppMethodBeat.o(352626);
  }
  
  public b(View paramView, Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.view.a parama1)
  {
    AppMethodBeat.i(352542);
    this.CvT = paramView;
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    this.CvV = parama1;
    this.coroutineScope = ar.kBZ();
    this.scope = ar.kBZ();
    AppMethodBeat.o(352542);
  }
  
  public final void ehr()
  {
    int i = 1;
    ah localah = null;
    AppMethodBeat.i(352639);
    Object localObject = this.CvW;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
      if (localObject == null)
      {
        localObject = null;
        Log.i("FinderLiveAllowanceGiftBubblePresenter", s.X("#updateBubbleInfo isAnchorNeedShowGuide=", localObject));
        localObject = aj.CGT;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
        if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject).eyf() != true)) {
          break label151;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label156;
        }
        localObject = this.CvX;
        if (localObject == null) {
          break label174;
        }
        ((a.b)localObject).ehs();
        AppMethodBeat.o(352639);
        return;
        localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject).eyf());
        break;
        label151:
        i = 0;
      }
      label156:
      localObject = this.CvX;
      if (localObject != null) {
        ((a.b)localObject).eht();
      }
      label174:
      AppMethodBeat.o(352639);
      return;
    }
    localObject = aj.CGT;
    localObject = (e)aj.business(e.class);
    if ((localObject != null) && (((e)localObject).DUe == true)) {}
    for (i = 1; i != 0; i = 0)
    {
      localObject = this.CvX;
      if (localObject != null) {
        ((a.b)localObject).eht();
      }
      AppMethodBeat.o(352639);
      return;
    }
    localObject = aj.CGT;
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
    long l1;
    long l2;
    if (localObject == null)
    {
      l1 = -1L;
      l2 = l1 - System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder("#updateBubbleInfo allowancePackageId=");
      localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
      if (localObject != null) {
        break label428;
      }
      localObject = null;
      label314:
      Log.i("FinderLiveAllowanceGiftBubblePresenter", localObject + " cutOffTime=" + l1 + " remainingTime=" + l2);
      localObject = aj.CGT;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
      if (localObject != null) {
        break label438;
      }
    }
    label537:
    label542:
    label546:
    for (;;)
    {
      if (localah == null)
      {
        localObject = this.CvX;
        if (localObject != null) {
          ((a.b)localObject).eht();
        }
      }
      AppMethodBeat.o(352639);
      return;
      if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.a.eyg())
      {
        l1 = System.currentTimeMillis() + 86400000L;
        break;
      }
      l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject).Ecd;
      break;
      label428:
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject).eye();
      break label314;
      label438:
      if (((CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject).eye()).length() > 0)
      {
        i = 1;
        label456:
        if ((i == 0) || (l2 <= 0L)) {
          break label537;
        }
        i = 1;
        label469:
        if (i == 0) {
          break label542;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label546;
        }
        localObject = this.CvX;
        if (localObject != null) {
          ((a.b)localObject).ehs();
        }
        this.CvW = j.a(this.scope, null, null, (m)new e(l2, this, null), 3);
        localah = ah.aiuX;
        break;
        i = 0;
        break label456;
        i = 0;
        break label469;
        localObject = null;
      }
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(352644);
    Object localObject = this.CvX;
    if (localObject != null) {
      ((a.b)localObject).eht();
    }
    localObject = this.CvW;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    AppMethodBeat.o(352644);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(b paramb, com.tencent.d.a.a.a.d.a.d paramd, String paramString, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(352691);
      paramObject = (kotlin.d.d)new c(this.CvY, this.CvZ, this.Cwa, paramd);
      AppMethodBeat.o(352691);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = null;
      AppMethodBeat.i(352688);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(352688);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(1250L, paramObject) == localObject2)
        {
          AppMethodBeat.o(352688);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      localObject2 = this.CvY;
      paramObject = this.CvZ;
      if (paramObject == null)
      {
        paramObject = null;
        b.a((b)localObject2, paramObject, this.Cwa);
        localObject2 = this.CvY;
        paramObject = this.CvZ;
        if (paramObject != null) {
          break label158;
        }
      }
      label158:
      for (paramObject = localObject1;; paramObject = paramObject.field_rewardProductId)
      {
        b.b((b)localObject2, paramObject, this.Cwa);
        paramObject = ah.aiuX;
        AppMethodBeat.o(352688);
        return paramObject;
        paramObject = paramObject.field_rewardProductId;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    d(b paramb, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(352717);
      paramObject = (kotlin.d.d)new d(this.CvY, paramd);
      AppMethodBeat.o(352717);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(352714);
      Object localObject7 = kotlin.d.a.a.aiwj;
      Object localObject6;
      Object localObject4;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(352714);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject6 = (kotlin.g.a.a)new d(this.CvY);
        localObject4 = (kotlin.g.a.b)new c(this.CvY);
        localObject1 = localObject4;
      }
      for (;;)
      {
        label717:
        label765:
        int i;
        try
        {
          localObject8 = z.bAW();
          localObject1 = localObject4;
          s.s(localObject8, "getMyFinderUsername()");
          localObject1 = localObject4;
          paramObject = aj.CGT;
          localObject1 = localObject4;
          paramObject = (f)aj.business(f.class);
          if (paramObject == null)
          {
            paramObject = null;
            localObject1 = localObject4;
            localObject9 = com.tencent.mm.bx.b.cX(paramObject);
            localObject1 = localObject4;
            paramObject = aj.CGT;
            localObject1 = localObject4;
            paramObject = (f)aj.business(f.class);
            if (paramObject == null)
            {
              l2 = 0L;
              localObject1 = localObject4;
              paramObject = aj.CGT;
              localObject1 = localObject4;
              paramObject = (f)aj.business(f.class);
              if (paramObject != null) {
                continue;
              }
              l1 = 0L;
              localObject1 = localObject4;
              paramObject = aj.CGT;
              localObject1 = localObject4;
              paramObject = (f)aj.business(f.class);
              if (paramObject != null) {
                continue;
              }
              paramObject = "";
              localObject1 = localObject4;
              bhu localbhu = new bhu();
              localObject1 = localObject4;
              localObject3 = aj.CGT;
              localObject1 = localObject4;
              localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
              if (localObject3 != null) {
                continue;
              }
              localObject3 = "";
              localObject1 = localObject4;
              localbhu.ZRa = ((String)localObject3);
              localObject1 = localObject4;
              localObject3 = ah.aiuX;
              localObject1 = localObject4;
              paramObject = new ab((String)localObject8, (com.tencent.mm.bx.b)localObject9, l2, l1, paramObject, localbhu);
              localObject1 = localObject4;
              localObject3 = aj.CGT;
              localObject1 = localObject4;
              localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
              if (localObject3 != null)
              {
                localObject1 = localObject4;
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecb = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).eye();
                localObject1 = localObject4;
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecc = "";
                localObject1 = localObject4;
                ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecd = -1L;
              }
              localObject1 = localObject4;
              paramObject = (com.tencent.mm.am.b)paramObject;
              localObject1 = localObject4;
              localObject3 = (kotlin.d.d)this;
              localObject1 = localObject4;
              this.L$0 = localObject6;
              localObject1 = localObject4;
              this.Uf = localObject4;
              localObject1 = localObject4;
              this.label = 1;
              localObject1 = localObject4;
              localObject5 = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject3);
              if (localObject5 != localObject7) {
                break label1110;
              }
              AppMethodBeat.o(352714);
              return localObject7;
            }
          }
          else
          {
            localObject1 = localObject4;
            paramObject = paramObject.mZp;
            continue;
          }
          localObject1 = localObject4;
          long l2 = paramObject.hKN;
          continue;
          localObject1 = localObject4;
          paramObject = paramObject.liveInfo;
          if (paramObject == null)
          {
            l1 = 0L;
            continue;
          }
          localObject1 = localObject4;
          long l1 = paramObject.liveId;
          continue;
          localObject1 = localObject4;
          localObject3 = paramObject.nonceId;
          paramObject = localObject3;
          if (localObject3 != null) {
            continue;
          }
          paramObject = "";
          continue;
          localObject1 = localObject4;
          localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).eye();
          localObject3 = localObject5;
          if (localObject5 != null) {
            continue;
          }
          localObject3 = "";
          continue;
          localObject3 = (kotlin.g.a.b)this.Uf;
          localObject4 = (kotlin.g.a.a)this.L$0;
        }
        catch (com.tencent.mm.af.a paramObject)
        {
          Object localObject8;
          Object localObject9;
          Object localObject5;
          label809:
          label817:
          paramObject = s.X(" CgiFinderLiveGetDeliveryDetail fail:", paramObject.getLocalizedMessage());
          Log.e("FinderLiveAllowanceGiftBubblePresenter", s.X("#onVisitorClick", paramObject));
          ((kotlin.g.a.b)localObject1).invoke(paramObject);
          paramObject = ah.aiuX;
          AppMethodBeat.o(352714);
          return paramObject;
        }
        for (;;)
        {
          try
          {
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject3;
            localObject3 = localObject4;
            localObject5 = localObject1;
            localObject1 = paramObject;
            localObject5 = (bhn)localObject5;
            localObject4 = (com.tencent.mm.bx.a)new bhv();
            localObject1 = ((bhn)localObject5).ZQV;
            if (localObject1 == null) {
              localObject1 = null;
            }
          }
          catch (com.tencent.mm.af.a paramObject)
          {
            Object localObject2 = localObject3;
            break label958;
          }
          try
          {
            ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
            localObject1 = localObject4;
          }
          catch (Exception localException)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException });
            localObject2 = null;
            break;
            localObject2 = Integer.valueOf(((bim)localObject2).ZRJ);
            break label717;
            localObject2 = ((String)localObject2).getBytes(kotlin.n.d.UTF_8);
            s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
            break label765;
            i = 0;
            break label809;
            localObject2 = null;
            break label817;
            ((kotlin.g.a.a)localObject3).invoke();
            paramObject.invoke(localObject7);
            break label946;
          }
        }
        localObject4 = (bhv)localObject1;
        if (localObject4 != null)
        {
          localObject5 = this.CvY;
          localObject6 = new StringBuilder(" CgiFinderLiveGetDeliveryDetail result.ret_code:").append(((bhv)localObject4).wuz).append("   result.package_id:").append(((bhv)localObject4).ZRa).append("   result.gift_type:");
          localObject1 = ((bhv)localObject4).ZOR;
          if (localObject1 != null) {
            break label1037;
          }
          localObject1 = null;
          localObject7 = localObject1;
          Log.i("FinderLiveAllowanceGiftBubblePresenter", s.X("#onVisitorClick", localObject7));
          localObject6 = new StringBuilder();
          localObject1 = z.bAM();
          if (localObject1 != null) {
            break label1050;
          }
          localObject1 = null;
          localObject6 = g.getMessageDigest((byte[])localObject1) + '_' + UUID.randomUUID();
          if (((bhv)localObject4).wuz != 0) {
            break label1082;
          }
          if (((bhv)localObject4).ZRb == null) {
            break label1071;
          }
          i = 1;
          if (i == 0) {
            break label1076;
          }
          localObject1 = localObject4;
          if (localObject1 != null)
          {
            localObject1 = ((bhv)localObject1).ZOR;
            if (localObject1 != null)
            {
              ((kotlin.g.a.a)new b((bim)localObject1, (b)localObject5, (String)localObject6)).invoke();
              localObject7 = aj.CGT;
              localObject7 = aj.getFinderLiveAssistant();
              if (localObject7 != null)
              {
                localObject8 = b.e((b)localObject5);
                localObject9 = aj.CGT;
                aj.business(f.class);
                localObject9 = aj.CGT;
                aj.business(f.class);
                ((ap)localObject7).a((Context)localObject8, ((bim)localObject1).ZOC, 1, (int)((bim)localObject1).ZRI, (String)localObject6, "", 3, ((bhv)localObject4).ZRb, (ax.a)new a((b)localObject5, (kotlin.g.a.a)localObject3, paramObject));
              }
            }
          }
        }
        label946:
        paramObject = ah.aiuX;
        AppMethodBeat.o(352714);
        return paramObject;
        label958:
        localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray();
        continue;
        label1037:
        label1050:
        label1071:
        label1076:
        label1082:
        label1110:
        Object localObject3 = localObject6;
        paramObject = localObject4;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubblePresenter$onVisitorClick$3$1$2$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ax.a
    {
      a(b paramb, kotlin.g.a.a<ah> parama, kotlin.g.a.b<? super String, ah> paramb1) {}
      
      public final void a(boolean paramBoolean, int paramInt1, ax.a.b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3)
      {
        AppMethodBeat.i(352625);
        s.u(paramb, "errType");
        paramb = " sendGiftCallback success:" + paramBoolean + "  errCode:" + paramInt1 + "  errType:" + paramb + "  rewardGiftId:" + paramString1 + "  balance:" + paramLong + "  cnt:" + paramInt2 + "  comboId:" + paramString2 + "  errMsg:" + paramString3;
        Log.i("FinderLiveAllowanceGiftBubblePresenter", s.X("#onVisitorClick", paramb));
        if (paramBoolean)
        {
          com.tencent.mm.live.b.b.b.a(b.d(this.CvY), com.tencent.mm.live.b.b.c.nfx);
          AppMethodBeat.o(352625);
          return;
        }
        this.Cwb.invoke();
        paramObject.invoke(paramb);
        AppMethodBeat.o(352625);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/Job;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<cb>
    {
      b(bim parambim, b paramb, String paramString)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "msg", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<String, ah>
    {
      c(b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(long paramLong, b paramb, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(352697);
      paramObject = (kotlin.d.d)new e(this.Cwe, this.CvY, paramd);
      AppMethodBeat.o(352697);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(352692);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(352692);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        long l = this.Cwe;
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(l, paramObject) == locala)
        {
          AppMethodBeat.o(352692);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Log.i("FinderLiveAllowanceGiftBubblePresenter", "#updateBubbleInfo iconTickerJpb time to hide.");
      paramObject = this.CvY.CvX;
      if (paramObject != null) {
        paramObject.eht();
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(352692);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.b
 * JD-Core Version:    0.7.0.1
 */