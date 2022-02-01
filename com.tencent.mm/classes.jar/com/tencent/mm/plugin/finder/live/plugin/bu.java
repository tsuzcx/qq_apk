package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.br.c;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.convert.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveRedPacketBubble;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "dataItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/PromoteRedPacketItem;", "delayJob", "Lkotlinx/coroutines/Job;", "getDelayJob", "()Lkotlinx/coroutines/Job;", "setDelayJob", "(Lkotlinx/coroutines/Job;)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "root", "Landroid/view/ViewGroup;", "afterAddAnim", "", "getView", "Landroid/view/View;", "goRedPacketCoverPage", "data", "initView", "", "jumpRedPacketUrl", "url", "onBubbleDel", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "delayMs", "", "postDismiss", "refreshBtnStatus", "coverUrl", "getBtn", "Landroid/widget/TextView;", "itemView", "refreshView", "updateView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bu
  implements cx
{
  public static final bu.a DiD;
  private static final String DiG;
  private cb DiE;
  private h DiF;
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final Context context;
  private ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  private w rYw;
  
  static
  {
    AppMethodBeat.i(354221);
    DiD = new bu.a((byte)0);
    DiG = "POST_PORTRAIT";
    AppMethodBeat.o(354221);
  }
  
  public bu(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(354112);
    this.context = paramContext;
    this.buContext = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveRedPacketBubble";
    paramContext = af.mU(this.context).inflate(p.f.Cfq, null);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(354112);
      throw paramContext;
    }
    this.mJe = ((ViewGroup)paramContext);
    AppMethodBeat.o(354112);
  }
  
  private static final ah a(bu parambu, h paramh, b.a parama)
  {
    AppMethodBeat.i(371413);
    kotlin.g.b.s.u(parambu, "this$0");
    kotlin.g.b.s.u(paramh, "$data");
    Object localObject = parambu.DiE;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    localObject = parambu.rYw;
    if (localObject != null) {
      ((w)localObject).dismiss();
    }
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((bhx)parama.ott).ZRc;
      if (parama == null)
      {
        AppMethodBeat.o(371413);
        return null;
      }
      localObject = new bkz();
      ((bkz)localObject).parseFrom(parama.toByteArray());
      kotlin.g.b.s.u(localObject, "<set-?>");
      paramh.DUM = ((bkz)localObject);
      ((q)parambu.buContext.business(q.class)).d((cc)paramh);
      paramh = ((bkz)localObject).ToF;
      kotlin.g.b.s.s(paramh, "redpacketCover.infos");
      paramh = (ehn)kotlin.a.p.oL((List)paramh);
      if (paramh == null)
      {
        AppMethodBeat.o(371413);
        return null;
      }
      parambu.axj(paramh.ablC);
      parambu = ah.aiuX;
      AppMethodBeat.o(371413);
      return parambu;
    }
    aa.dc(parambu.context, parambu.context.getString(p.h.CrK));
    parambu = ah.aiuX;
    AppMethodBeat.o(371413);
    return parambu;
  }
  
  private static final void a(bu parambu, View paramView)
  {
    AppMethodBeat.i(371410);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveRedPacketBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambu, "this$0");
    aa.y(parambu.context, parambu.context.getString(p.h.Zud), p.g.icons_filled_info);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveRedPacketBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371410);
  }
  
  private static final void a(bu parambu, h paramh, View paramView)
  {
    AppMethodBeat.i(354178);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambu);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramh);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveRedPacketBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambu, "this$0");
    kotlin.g.b.s.u(paramh, "$data");
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(parambu.buContext, 2, 7);
    Log.i(parambu.TAG, "close promote");
    parambu = aj.CGT;
    parambu = aj.elk();
    if (parambu != null)
    {
      paramView = b.c.ndQ;
      localObject1 = new Bundle();
      localObject2 = new bla();
      ((bla)localObject2).id = paramh.DUI;
      ((bla)localObject2).type = 7;
      ((bla)localObject2).ZTU = new com.tencent.mm.bx.b(paramh.DUM.toByteArray());
      paramh = ah.aiuX;
      ((Bundle)localObject1).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject2).toByteArray());
      paramh = ah.aiuX;
      parambu.statusChange(paramView, (Bundle)localObject1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveRedPacketBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354178);
  }
  
  private final void a(h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(354126);
    this.DiF = paramh;
    Object localObject3 = this.mJe;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    TextView localTextView = (TextView)((ViewGroup)localObject1).findViewById(p.e.BRW);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    View localView1 = ((ViewGroup)localObject1).findViewById(p.e.item_detail_container);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    View localView2 = ((ViewGroup)localObject1).findViewById(p.e.BIb);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    localObject3 = (TextView)((ViewGroup)localObject1).findViewById(p.e.title);
    aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
    aw.a((Paint)localTextView.getPaint(), 0.8F);
    localObject1 = this.mJe;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = (ImageView)((ViewGroup)localObject1).findViewById(p.e.thumb);
      localObject2 = paramh.DUM.ToF;
      kotlin.g.b.s.s(localObject2, "data.data.infos");
      localObject2 = (ehn)kotlin.a.p.oL((List)localObject2);
      if (localObject2 != null)
      {
        Object localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject4 = com.tencent.mm.plugin.finder.loader.p.eCl();
        com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(((ehn)localObject2).image, v.FKZ);
        kotlin.g.b.s.s(localObject1, "thumb");
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject4).a(locals, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.Eyb));
        ((TextView)localObject3).setText((CharSequence)((ehn)localObject2).title);
        localObject1 = ((ehn)localObject2).ZNU;
        if (localObject1 != null)
        {
          kotlin.g.b.s.s(localTextView, "getBtn");
          kotlin.g.b.s.s(localView1, "itemView");
          a((String)localObject1, localTextView, localView1, paramh);
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.s(this.buContext)) {
        break;
      }
      localTextView.setVisibility(8);
      localView2.setVisibility(4);
      AppMethodBeat.o(354126);
      return;
    }
    localTextView.setVisibility(0);
    localView2.setVisibility(0);
    localView2.setOnClickListener(new bu..ExternalSyntheticLambda2(this, paramh));
    AppMethodBeat.o(354126);
  }
  
  private final void a(String paramString, TextView paramTextView, View paramView, h paramh)
  {
    AppMethodBeat.i(354135);
    Object localObject1 = com.tencent.mm.plugin.finder.live.util.n.DJd;
    bld localbld = com.tencent.mm.plugin.finder.live.util.n.axM(paramString);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[saveStatus] status:");
    if (localbld == null)
    {
      localObject1 = null;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "null";
      }
      Log.i(str, localObject2 + ", url:" + paramString);
      if (localbld != null) {
        break label181;
      }
      paramTextView.setText((CharSequence)this.context.getString(p.h.CrH));
      paramTextView.setTextColor(this.context.getResources().getColor(p.b.BW_0));
      paramTextView.setBackground(this.context.getResources().getDrawable(p.d.BAj));
    }
    for (;;)
    {
      paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.s(this.buContext)) {
        break label347;
      }
      paramView.setOnClickListener(new bu..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(354135);
      return;
      localObject1 = com.tencent.mm.ae.f.dg(localbld);
      break;
      label181:
      if (localbld.ZUf)
      {
        paramTextView.setText((CharSequence)this.context.getString(p.h.CrI));
        paramTextView.setTextColor(this.context.getResources().getColor(p.b.UN_BW_0_Alpha_0_5));
        paramTextView.setBackground(null);
        b(paramh);
      }
      else if (localbld.ZUg == 0)
      {
        paramTextView.setText((CharSequence)this.context.getString(p.h.CrH));
        paramTextView.setTextColor(this.context.getResources().getColor(p.b.BW_0));
        paramTextView.setBackground(this.context.getResources().getDrawable(p.d.BAj));
      }
      else
      {
        paramTextView.setText((CharSequence)this.context.getString(p.h.CrJ));
        paramTextView.setTextColor(this.context.getResources().getColor(p.b.UN_BW_0_Alpha_0_5));
        paramTextView.setBackground(null);
        b(paramh);
      }
    }
    label347:
    paramView.setOnClickListener(new bu..ExternalSyntheticLambda1(this, paramh));
    AppMethodBeat.o(354135);
  }
  
  private final void axj(String paramString)
  {
    AppMethodBeat.i(354167);
    Log.i(this.TAG, kotlin.g.b.s.X("url: ", paramString));
    Intent localIntent = new Intent();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("convertActivityFromTranslucent", true);
    c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent, 1011);
    AppMethodBeat.o(354167);
  }
  
  private static final void b(bu parambu, h paramh, View paramView)
  {
    AppMethodBeat.i(371411);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambu);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveRedPacketBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambu, "this$0");
    kotlin.g.b.s.u(paramh, "$data");
    parambu.c(paramh);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveRedPacketBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371411);
  }
  
  private final void b(h paramh)
  {
    AppMethodBeat.i(354142);
    ViewGroup localViewGroup2 = this.mJe;
    ViewGroup localViewGroup1 = localViewGroup2;
    if (localViewGroup2 == null)
    {
      kotlin.g.b.s.bIx("root");
      localViewGroup1 = null;
    }
    localViewGroup1.postDelayed(new bu..ExternalSyntheticLambda4(paramh), 5000L);
    AppMethodBeat.o(354142);
  }
  
  private final void c(h paramh)
  {
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = null;
    AppMethodBeat.i(354161);
    if (this.context.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, kotlin.g.b.s.X("goRedPacketCoverPage isLandscape:", Boolean.valueOf(bool)));
      if (!bool) {
        break;
      }
      paramh = aj.CGT;
      paramh = aj.elk();
      if (paramh == null) {
        break label264;
      }
      paramh = (br)paramh.getPlugin(br.class);
      if (paramh == null) {
        break label264;
      }
      b.a((b)paramh, DiG);
      AppMethodBeat.o(354161);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(this.buContext, 5, 7);
    this.DiE = j.a((aq)kotlinx.coroutines.bu.ajwo, null, null, (m)new b(this, null), 3);
    Log.i(this.TAG, kotlin.g.b.s.X("needJump:", Boolean.valueOf(paramh.hPp)));
    if (paramh.hPp)
    {
      localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localf != null)
      {
        new com.tencent.mm.plugin.finder.live.cgi.n(localf.hKN, localf.liveInfo.liveId, 7, paramh.DUN, new com.tencent.mm.bx.b(paramh.DUM.toByteArray()), null, null).bFJ().g(new bu..ExternalSyntheticLambda3(this, paramh));
        AppMethodBeat.o(354161);
      }
    }
    else
    {
      paramh = paramh.DUM;
      if (paramh != null) {
        break label271;
      }
      paramh = localf;
    }
    for (;;)
    {
      axj(paramh);
      label264:
      AppMethodBeat.o(354161);
      return;
      label271:
      localObject = paramh.ToF;
      paramh = localf;
      if (localObject != null)
      {
        localObject = (ehn)kotlin.a.p.oL((List)localObject);
        paramh = localf;
        if (localObject != null) {
          paramh = ((ehn)localObject).ablC;
        }
      }
    }
  }
  
  private static final void d(h paramh)
  {
    AppMethodBeat.i(371412);
    kotlin.g.b.s.u(paramh, "$data");
    Object localObject = aj.CGT;
    localObject = aj.elk();
    if (localObject != null)
    {
      b.c localc = b.c.ndQ;
      Bundle localBundle = new Bundle();
      bla localbla = new bla();
      localbla.type = 7;
      localbla.ZTU = new com.tencent.mm.bx.b(paramh.DUM.toByteArray());
      localbla.id = paramh.DUI;
      localbla.jump_id = paramh.DUN;
      paramh = ah.aiuX;
      localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", localbla.toByteArray());
      paramh = ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).statusChange(localc, localBundle);
    }
    AppMethodBeat.o(371412);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(354273);
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      if (kotlin.g.b.s.p(paramBundle, DiG))
      {
        paramBundle = this.DiF;
        if (paramBundle != null) {
          c(paramBundle);
        }
      }
      AppMethodBeat.o(354273);
      return;
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void eoK() {}
  
  public final void eoL() {}
  
  public final void fs(Object paramObject)
  {
    AppMethodBeat.i(354253);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof h)) {
      a((h)paramObject);
    }
    AppMethodBeat.o(354253);
  }
  
  public final void ft(Object paramObject)
  {
    AppMethodBeat.i(354261);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof h))
    {
      a((h)paramObject);
      paramObject = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(this.buContext, 1, 7);
    }
    AppMethodBeat.o(354261);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(354269);
    ViewGroup localViewGroup = this.mJe;
    Object localObject = localViewGroup;
    if (localViewGroup == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject = null;
    }
    localObject = (View)localObject;
    AppMethodBeat.o(354269);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(bu parambu, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(353873);
      paramObject = (kotlin.d.d)new b(this.DiH, paramd);
      AppMethodBeat.o(353873);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(353864);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(353864);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(1000L, paramObject) == locala)
        {
          AppMethodBeat.o(353864);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(this.DiH) {});
      paramObject = ah.aiuX;
      AppMethodBeat.o(353864);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bu
 * JD-Core Version:    0.7.0.1
 */