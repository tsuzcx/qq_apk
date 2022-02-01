package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.cgi.n;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bx;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAdBubble;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "root", "Landroid/view/ViewGroup;", "afterAddAnim", "", "getView", "Landroid/view/View;", "initView", "data", "", "jumpAd", "product", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "onBubbleDel", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "delayMs", "", "refreshView", "updateView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements cx
{
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final Context context;
  private ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public c(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(354301);
    this.context = paramContext;
    this.buContext = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveAdBubble";
    paramContext = af.mU(this.context).inflate(p.f.CcL, null);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(354301);
      throw paramContext;
    }
    this.mJe = ((ViewGroup)paramContext);
    AppMethodBeat.o(354301);
  }
  
  private static final ah a(i parami, c paramc, b.a parama)
  {
    AppMethodBeat.i(354379);
    s.u(parami, "$promotingProduct");
    s.u(paramc, "this$0");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Object localObject = ((bhx)parama.ott).ZRc;
      if (localObject != null)
      {
        parama = new bmt();
        parama.parseFrom(((com.tencent.mm.bx.b)localObject).toByteArray());
        localObject = ah.aiuX;
        s.u(parama, "<set-?>");
        parami.DUO = parama;
        if ((((q)paramc.buContext.business(q.class)).Eie instanceof i))
        {
          parama = ((q)paramc.buContext.business(q.class)).Eie;
          if (parama == null)
          {
            parami = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.convert.ShopWindowAdItem");
            AppMethodBeat.o(354379);
            throw parami;
          }
          if (((i)parama).DUP == parami.DUP) {
            ((q)paramc.buContext.business(q.class)).d((cc)parami);
          }
        }
      }
    }
    paramc.b(parami);
    parami = ah.aiuX;
    AppMethodBeat.o(354379);
    return parami;
  }
  
  private static final void a(c paramc, i parami, View paramView)
  {
    AppMethodBeat.i(354362);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parami);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAdBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramc, "this$0");
    s.u(parami, "$data");
    Log.i(paramc.TAG, s.X("close promote, id:", Long.valueOf(parami.DUO.DUP)));
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    localObject1 = paramc.buContext;
    s.checkNotNull(localObject1);
    paramView = String.valueOf(parami.DUP);
    paramc = paramView;
    if (paramView == null) {
      paramc = "";
    }
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.b((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, 2, 4, paramc);
    localObject2 = k.Doi;
    q.bx localbx = q.bx.DDM;
    long l1 = parami.DUP;
    paramc = parami.DUQ;
    if (paramc == null) {
      paramc = "";
    }
    for (;;)
    {
      long l2 = parami.DUP;
      localObject1 = parami.mdG;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((k)localObject2).a(localbx, null, String.valueOf(l1), paramc, String.valueOf(l2), paramView);
      paramc = aj.CGT;
      paramc = aj.elk();
      if (paramc != null)
      {
        paramView = b.c.ndQ;
        localObject1 = new Bundle();
        localObject2 = new bla();
        ((bla)localObject2).id = parami.DUI;
        ((bla)localObject2).type = 4;
        ((bla)localObject2).ZTU = new com.tencent.mm.bx.b(parami.DUO.toByteArray());
        parami = ah.aiuX;
        ((Bundle)localObject1).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject2).toByteArray());
        parami = ah.aiuX;
        paramc.statusChange(paramView, (Bundle)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAdBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354362);
      return;
      paramView = paramc.YEY;
      paramc = paramView;
      if (paramView == null) {
        paramc = "";
      }
    }
  }
  
  private final void a(i parami)
  {
    Object localObject3 = null;
    AppMethodBeat.i(354323);
    if ((parami.DUP == 0L) || (Util.isNullOrNil(parami.DUR)))
    {
      Log.i(this.TAG, "showShoppingBubble ad_id:" + parami.DUP + ", imgUrl:" + parami.DUR);
      AppMethodBeat.o(354323);
      return;
    }
    Object localObject5 = k.Doi;
    Object localObject6 = q.bx.DDF;
    long l1 = parami.DUP;
    Object localObject1 = parami.DUQ;
    Object localObject4;
    Object localObject2;
    label223:
    int i;
    if (localObject1 == null)
    {
      localObject1 = "";
      long l2 = parami.DUP;
      localObject4 = parami.mdG;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((k)localObject5).a((q.bx)localObject6, null, String.valueOf(l1), (String)localObject1, String.valueOf(l2), (String)localObject2);
      localObject2 = this.mJe;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("root");
        localObject1 = null;
      }
      localObject2 = (TextView)((ViewGroup)localObject1).findViewById(p.e.BEW);
      aw.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
      localObject1 = parami.title;
      if (localObject1 != null) {
        break label580;
      }
      localObject1 = (CharSequence)"";
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = this.mJe;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("root");
        localObject1 = null;
      }
      localObject2 = (TextView)((ViewGroup)localObject1).findViewById(p.e.BET);
      localObject1 = parami.desc;
      if (localObject1 != null) {
        break label590;
      }
      localObject1 = (CharSequence)"";
      label286:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = this.mJe;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("root");
        localObject1 = null;
      }
      localObject1 = (TextView)((ViewGroup)localObject1).findViewById(p.e.BEU);
      localObject2 = (CharSequence)parami.DUT;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label600;
      }
      i = 1;
      label356:
      if (i == 0) {
        break label605;
      }
      ((TextView)localObject1).setVisibility(8);
      label367:
      localObject2 = this.mJe;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("root");
        localObject1 = null;
      }
      localObject4 = ((ViewGroup)localObject1).findViewById(p.e.BIb);
      localObject1 = p.ExI;
      localObject5 = p.eCq();
      localObject6 = new com.tencent.mm.plugin.finder.loader.b(parami.DUR);
      localObject2 = this.mJe;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("root");
        localObject1 = null;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(p.e.BEV);
      s.s(localObject1, "root.findViewById<ImageV….id.finder_live_ad_thumb)");
      localObject1 = (ImageView)localObject1;
      localObject2 = p.ExI;
      ((com.tencent.mm.loader.d)localObject5).a(localObject6, (ImageView)localObject1, p.a(p.a.ExV));
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.s(this.buContext)) {
        break label626;
      }
      ((View)localObject4).setVisibility(4);
      label514:
      localObject1 = this.mJe;
      if (localObject1 != null) {
        break label649;
      }
      s.bIx("root");
      localObject1 = localObject3;
    }
    label649:
    for (;;)
    {
      ((ViewGroup)localObject1).setOnClickListener(new c..ExternalSyntheticLambda1(this, parami));
      AppMethodBeat.o(354323);
      return;
      localObject2 = ((cr)localObject1).YEY;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label580:
      localObject1 = (CharSequence)localObject1;
      break label223;
      label590:
      localObject1 = (CharSequence)localObject1;
      break label286;
      label600:
      i = 0;
      break label356;
      label605:
      ((TextView)localObject1).setText((CharSequence)parami.DUT);
      ((TextView)localObject1).setVisibility(0);
      break label367;
      label626:
      ((View)localObject4).setVisibility(0);
      ((View)localObject4).setOnClickListener(new c..ExternalSyntheticLambda0(this, parami));
      break label514;
    }
  }
  
  private static final void b(c paramc, i parami, View paramView)
  {
    AppMethodBeat.i(354388);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parami);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAdBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramc, "this$0");
    s.u(parami, "$data");
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    localObject2 = paramc.buContext;
    localObject1 = String.valueOf(parami.DUP);
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.b((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, 5, 4, paramView);
    Log.i(paramc.TAG, s.X("needJump:", Boolean.valueOf(parami.hPp)));
    if (parami.hPp)
    {
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramc.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramView != null)
      {
        long l1 = paramView.hKN;
        long l2 = paramView.liveInfo.liveId;
        paramView = parami.DUN;
        localObject1 = new com.tencent.mm.bx.b(parami.DUO.toByteArray());
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        new n(l1, l2, 5, paramView, (com.tencent.mm.bx.b)localObject1, com.tencent.mm.plugin.finder.live.utils.a.a(paramc.buContext, Long.valueOf(parami.DUP)), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramc.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer).bFJ().g(new c..ExternalSyntheticLambda2(parami, paramc));
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAdBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354388);
      return;
      paramc.b(parami);
    }
  }
  
  private final void b(i parami)
  {
    AppMethodBeat.i(354340);
    Object localObject4 = parami.DUQ;
    Object localObject1;
    int i;
    label118:
    Object localObject2;
    label169:
    Object localObject3;
    long l1;
    if (localObject4 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eWS().bmg()).booleanValue())
      {
        ((e)this.buContext.business(e.class)).EeF = null;
        ((e)this.buContext.business(e.class)).EeG.clear();
      }
      localObject1 = ((e)this.buContext.business(e.class)).EeF;
      if (localObject1 == null) {
        break label335;
      }
      if (((CharSequence)localObject1).length() <= 0) {
        break label330;
      }
      i = 1;
      if (i != 1) {
        break label335;
      }
      i = 1;
      if (i == 0) {
        break label340;
      }
      Log.i(this.TAG, s.X("get uxInfo from outsize:", ((e)this.buContext.business(e.class)).EeF));
      localObject1 = ((e)this.buContext.business(e.class)).EeF;
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject3 = this.mJe;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("root");
        localObject2 = null;
      }
      localObject3 = ((ViewGroup)localObject2).getContext();
      s.s(localObject3, "root.context");
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject3, (cr)localObject4, (String)localObject2);
      if (this.nfT.getLiveRole() == 0)
      {
        localObject3 = k.Doi;
        localObject4 = q.bx.DDG;
        l1 = parami.DUP;
        localObject1 = parami.DUQ;
        if (localObject1 != null) {
          break label626;
        }
        localObject1 = "";
      }
    }
    for (;;)
    {
      long l2 = parami.DUP;
      localObject2 = parami.mdG;
      parami = (i)localObject2;
      if (localObject2 == null) {
        parami = "";
      }
      ((k)localObject3).a((q.bx)localObject4, null, String.valueOf(l1), (String)localObject1, String.valueOf(l2), parami);
      AppMethodBeat.o(354340);
      return;
      label330:
      i = 0;
      break;
      label335:
      i = 0;
      break label118;
      label340:
      if (((e)this.buContext.business(e.class)).EeG.containsKey(Long.valueOf(parami.DUP)))
      {
        localObject1 = (String)((e)this.buContext.business(e.class)).EeG.get(Long.valueOf(parami.DUP));
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label532;
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label537;
          }
          Log.i(this.TAG, "get uxInfo from cgi-getShowShopSelf,adid:" + parami.DUP + ",uxinfo:" + ((e)this.buContext.business(e.class)).EeG.get(Long.valueOf(parami.DUP)));
          localObject1 = (String)((e)this.buContext.business(e.class)).EeG.get(Long.valueOf(parami.DUP));
          break;
          i = 0;
          break label420;
        }
      }
      label420:
      localObject3 = this.TAG;
      label532:
      label537:
      StringBuilder localStringBuilder = new StringBuilder("get uxInfo from promotingProduct,adid:").append(parami.DUP).append(",uxinfo:");
      localObject2 = parami.mdG;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Log.i((String)localObject3, (String)localObject1);
      localObject2 = parami.mdG;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label169;
      }
      localObject1 = "";
      break label169;
      label626:
      localObject2 = ((cr)localObject1).YEY;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong) {}
  
  public final void eoK() {}
  
  public final void eoL() {}
  
  public final void fs(Object paramObject)
  {
    AppMethodBeat.i(354417);
    s.u(paramObject, "data");
    if ((paramObject instanceof i)) {
      a((i)paramObject);
    }
    AppMethodBeat.o(354417);
  }
  
  public final void ft(Object paramObject)
  {
    AppMethodBeat.i(354429);
    s.u(paramObject, "data");
    if ((paramObject instanceof i))
    {
      a((i)paramObject);
      Object localObject = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.model.context.a locala = this.buContext;
      localObject = String.valueOf(((i)paramObject).DUP);
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.b(locala, 1, 4, paramObject);
    }
    AppMethodBeat.o(354429);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(354438);
    ViewGroup localViewGroup = this.mJe;
    Object localObject = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("root");
      localObject = null;
    }
    localObject = (View)localObject;
    AppMethodBeat.o(354438);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.c
 * JD-Core Version:    0.7.0.1
 */