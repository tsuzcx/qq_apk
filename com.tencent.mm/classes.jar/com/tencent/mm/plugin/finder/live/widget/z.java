package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ax.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a.b;
import com.tencent.mm.plugin.finder.live.report.q.cb;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.h;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansJoinWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "cancle", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "confirm", "Landroid/widget/TextView;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fromGiftPanel", "", "giftImage", "giftName", "joinCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "suceess", "", "getJoinCallBack", "()Lkotlin/jvm/functions/Function1;", "setJoinCallBack", "(Lkotlin/jvm/functions/Function1;)V", "payDesc", "payGift", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "payValue", "root", "Landroid/view/View;", "wecoinBalance", "", "wecoinClickCallBack", "getWecoinClickCallBack", "setWecoinClickCallBack", "wecoinDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "wecoinGroup", "wecoinValue", "addLocalGiftMsg", "rewardGiftId", "", "rewardGiftCnt", "", "comboId", "targetUserName", "addSelfGiftToComment", "giftId", "comboCount", "confirmJoin", "hide", "join", "liveCookie", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "objectId", "(Lcom/tencent/mm/protobuf/ByteString;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClick", "v", "pay", "price", "cnt", "(JJLjava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "showConsumeFailDialog", "errMsg", "showWecoinInfo", "scene", "showWecoinNotEnoughDialog", "unMount", "updatePayGift", "updateWecoinBalance", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends p
  implements View.OnClickListener
{
  public static final z.a Epp;
  public final TextView DRn;
  private final View Dag;
  private com.tencent.mm.plugin.wallet.wecoin.a.e Dak;
  public h Epc;
  public boolean Epf;
  private kotlin.g.a.b<? super Boolean, ah> Epq;
  private kotlin.g.a.b<? super Boolean, ah> Epr;
  private final ImageView Eps;
  private final TextView Ept;
  public final TextView Epu;
  public final TextView Epv;
  public final ImageView Epw;
  private final TextView Epx;
  public com.tencent.d.a.a.a.d.a.d Epy;
  private long Epz;
  private aq coroutineScope;
  public final View lBX;
  
  static
  {
    AppMethodBeat.i(362372);
    Epp = new z.a((byte)0);
    AppMethodBeat.o(362372);
  }
  
  public z(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(362247);
    paramContext = LayoutInflater.from(paramContext).inflate(p.f.CdD, (ViewGroup)this, false);
    s.s(paramContext, "from(context).inflate(R.…n_widget_ui, this, false)");
    this.lBX = paramContext;
    this.Eps = ((ImageView)this.lBX.findViewById(p.e.BDt));
    this.Dag = this.lBX.findViewById(p.e.BDT);
    this.Ept = ((TextView)this.lBX.findViewById(p.e.BDU));
    this.Epu = ((TextView)this.lBX.findViewById(p.e.BVN));
    this.Epv = ((TextView)this.lBX.findViewById(p.e.BVK));
    this.Epw = ((ImageView)this.lBX.findViewById(p.e.BVL));
    this.DRn = ((TextView)this.lBX.findViewById(p.e.BVM));
    this.Epx = ((TextView)this.lBX.findViewById(p.e.BVJ));
    this.coroutineScope = ar.kBZ();
    this.Eps.setOnClickListener((View.OnClickListener)this);
    this.Dag.setOnClickListener((View.OnClickListener)this);
    this.Epx.setOnClickListener((View.OnClickListener)this);
    paramContext = this.Epx;
    s.s(paramContext, "confirm");
    setTextBold(paramContext);
    AppMethodBeat.o(362247);
  }
  
  private final void Qi(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(362261);
    if ((this.lBX.getContext() instanceof FragmentActivity)) {
      if (getBasePlugin() != null) {
        break label63;
      }
    }
    for (;;)
    {
      this.Dak = ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject);
      localObject = this.Dak;
      if (localObject != null) {
        ((com.tencent.mm.plugin.wallet.wecoin.a.e)localObject).a(new z..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(362261);
      return;
      label63:
      ap localap = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (localap != null)
      {
        localObject = this.lBX.getContext();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
          AppMethodBeat.o(362261);
          throw ((Throwable)localObject);
        }
        localObject = localap.a((FragmentActivity)localObject, paramInt, (kotlin.g.a.a)new e(this));
      }
    }
  }
  
  private static final void a(z paramz, com.tencent.mm.plugin.wallet.wecoin.a.e parame)
  {
    AppMethodBeat.i(362266);
    s.u(paramz, "this$0");
    if (paramz.Epc == null)
    {
      parame = paramz.getWecoinClickCallBack();
      if (parame != null) {
        parame.invoke(Boolean.valueOf(paramz.Epf));
      }
    }
    AppMethodBeat.o(362266);
  }
  
  public final kotlin.g.a.b<Boolean, ah> getJoinCallBack()
  {
    return this.Epr;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getWecoinClickCallBack()
  {
    return this.Epq;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(362409);
    h localh = this.Epc;
    if (localh != null) {
      localh.cyW();
    }
    this.Epc = null;
    AppMethodBeat.o(362409);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(362404);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFansJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BDt;
      if (paramView != null) {
        break label103;
      }
      label53:
      i = p.e.BDT;
      if (paramView != null) {
        break label118;
      }
      label61:
      i = p.e.BVJ;
      if (paramView != null) {
        break label138;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362404);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label103:
      if (paramView.intValue() != i) {
        break label53;
      }
      hide();
      continue;
      label118:
      if (paramView.intValue() != i) {
        break label61;
      }
      hide();
      Qi(1);
      continue;
      label138:
      if (paramView.intValue() == i)
      {
        paramView = aw.Gjk;
        if (aw.isFastClick())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansJoinWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(362404);
          return;
        }
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cb.DEm, null, Boolean.valueOf(this.Epf), 2);
        j.a(this.coroutineScope, null, null, (m)new b(this, null), 3);
      }
    }
  }
  
  public final void setJoinCallBack(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.Epr = paramb;
  }
  
  public final void setWecoinClickCallBack(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.Epq = paramb;
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(362414);
    super.unMount();
    hide();
    AppMethodBeat.o(362414);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int aai;
    int label;
    
    b(z paramz, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(361307);
      paramObject = (kotlin.d.d)new b(this.EpA, paramd);
      AppMethodBeat.o(361307);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(361300);
      Object localObject3 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(361300);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localw = w.a(this.EpA.getContext(), (CharSequence)this.EpA.getContext().getString(p.h.app_waiting), false, 3, null);
        paramObject = this.EpA.getBasePlugin();
        final long l1;
        long l2;
        if (paramObject == null)
        {
          l1 = 0L;
          paramObject = this.EpA.getBasePlugin();
          if (paramObject != null) {
            break label364;
          }
          l2 = 0L;
          label117:
          paramObject = this.EpA.getBasePlugin();
          if (paramObject != null) {
            break label393;
          }
          paramObject = null;
          label131:
          com.tencent.mm.bx.b.cX(paramObject);
          localObject1 = new StringBuilder();
          paramObject = com.tencent.mm.model.z.bAM();
          if (paramObject != null) {
            break label420;
          }
          paramObject = null;
          label155:
          str = g.getMessageDigest(paramObject) + '_' + UUID.randomUUID();
          paramObject = z.a(this.EpA);
          if (paramObject != null) {
            break label437;
          }
          localObject1 = null;
          label195:
          paramObject = z.a(this.EpA);
          if (paramObject != null) {
            break label446;
          }
          i = 0;
          label209:
          paramObject = this.EpA.getBasePlugin();
          if (paramObject != null) {
            break label455;
          }
          paramObject = "";
        }
        for (;;)
        {
          localObject2 = (kotlin.d.f)bg.kCi();
          m localm = (m)new a(this.EpA, l1, l2, str, (String)localObject1, i, 1, null);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.L$0 = localw;
          this.Uf = str;
          this.VC = localObject1;
          this.VD = paramObject;
          this.aai = 1;
          this.label = 1;
          localObject2 = l.a((kotlin.d.f)localObject2, localm, locald);
          if (localObject2 != localObject3) {
            break label711;
          }
          AppMethodBeat.o(361300);
          return localObject3;
          paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramObject.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (paramObject == null)
          {
            l1 = 0L;
            break;
          }
          paramObject = paramObject.liveInfo;
          if (paramObject == null)
          {
            l1 = 0L;
            break;
          }
          l1 = paramObject.liveId;
          break;
          label364:
          paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramObject.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (paramObject == null)
          {
            l2 = 0L;
            break label117;
          }
          l2 = paramObject.hKN;
          break label117;
          label393:
          paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramObject.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          if (paramObject == null)
          {
            paramObject = null;
            break label131;
          }
          paramObject = paramObject.mZp;
          break label131;
          label420:
          paramObject = paramObject.getBytes(kotlin.n.d.UTF_8);
          s.s(paramObject, "(this as java.lang.String).getBytes(charset)");
          break label155;
          label437:
          localObject1 = paramObject.field_rewardProductId;
          break label195;
          label446:
          i = (int)paramObject.field_price;
          break label209;
          label455:
          paramObject = paramObject.getBuContext();
          if (paramObject == null)
          {
            paramObject = "";
          }
          else
          {
            paramObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramObject.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            if (paramObject == null)
            {
              paramObject = "";
            }
            else
            {
              paramObject = paramObject.mIC;
              if (paramObject == null) {
                paramObject = "";
              }
            }
          }
        }
      }
      final int i = this.aai;
      localObject3 = (String)this.VD;
      Object localObject1 = (String)this.VC;
      final String str = (String)this.Uf;
      w localw = (w)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      Object localObject2 = paramObject;
      for (;;)
      {
        boolean bool = ((Boolean)localObject2).booleanValue();
        localw.dismiss();
        z.b(this.EpA).setText((CharSequence)String.valueOf(z.c(this.EpA)));
        if (bool)
        {
          aa.y(this.EpA.getContext(), z.d(this.EpA).getContext().getString(p.h.Ckc), p.g.icons_outlined_done);
          z.a(this.EpA, (String)localObject1, i, str, (String)localObject3);
          z.a(this.EpA, (String)localObject1, str, i);
        }
        this.EpA.hide();
        paramObject = this.EpA.getJoinCallBack();
        if (paramObject != null) {
          if (!bool) {
            break label705;
          }
        }
        label705:
        for (bool = true;; bool = false)
        {
          paramObject.invoke(Boolean.valueOf(bool));
          paramObject = ah.aiuX;
          AppMethodBeat.o(361300);
          return paramObject;
        }
        label711:
        i = 1;
        localObject3 = paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super Boolean>, Object>
    {
      int label;
      
      a(z paramz, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, int paramInt2, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(362165);
        paramObject = (kotlin.d.d)new a(this.EpA, l1, str, i, this.DcG, this.EpB, this.EpC, paramd);
        AppMethodBeat.o(362165);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(362159);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(362159);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.EpA;
          long l1 = l1;
          long l2 = str;
          Object localObject = i;
          String str = this.DcG;
          int i = this.EpB;
          int j = this.EpC;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          localObject = z.a(paramObject, l1, l2, (String)localObject, str, i, j, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(362159);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(362159);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveFansJoinWidget$pay$2$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "sendGiftCallback", "", "success", "", "errCode", "", "errType", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;", "rewardGiftId", "", "balance", "", "cnt", "comboId", "errMsg", "(ZILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback$ErrorType;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ax.a
  {
    c(z paramz, kotlin.d.d<? super Boolean> paramd) {}
    
    public final void a(boolean paramBoolean, int paramInt1, ax.a.b paramb, String paramString1, Long paramLong, int paramInt2, String paramString2, String paramString3)
    {
      AppMethodBeat.i(361290);
      s.u(paramb, "errType");
      long l;
      if (paramBoolean)
      {
        paramb = this.EpA;
        if (paramLong == null)
        {
          l = 0L;
          z.a(paramb, l);
        }
      }
      for (;;)
      {
        paramb = this.nXT;
        paramString1 = Result.Companion;
        paramb.resumeWith(Result.constructor-impl(Boolean.valueOf(paramBoolean)));
        AppMethodBeat.o(361290);
        return;
        l = paramLong.longValue();
        break;
        switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
        {
        default: 
          break;
        case 1: 
          if (paramInt1 == 10003) {
            z.h(this.EpA);
          } else {
            z.a(this.EpA, paramString3);
          }
          break;
        case 2: 
          z.a(this.EpA, paramString3);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(String paramString, z paramz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(z paramz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(z paramz)
    {
      super();
    }
    
    private static final void a(z paramz, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(361321);
      s.u(paramz, "this$0");
      z.e(paramz);
      AppMethodBeat.o(361321);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wecoinBalance", "", "requestId"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends u
    implements m<Long, Long, ah>
  {
    public g(long paramLong, z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.z
 * JD-Core Version:    0.7.0.1
 */