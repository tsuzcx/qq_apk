package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.convert.e;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMpArticleBubble;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "root", "Landroid/view/ViewGroup;", "afterAddAnim", "", "getView", "Landroid/view/View;", "initView", "data", "", "onBubbleDel", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "delayMs", "", "refreshView", "Lcom/tencent/mm/plugin/finder/live/view/convert/PromoteLiveMpArticleItem;", "updateView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi
  implements cx
{
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final Context context;
  private ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public bi(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(355168);
    this.context = paramContext;
    this.buContext = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveMpArticleBubble";
    paramContext = af.mU(this.context).inflate(p.f.Cdd, null);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(355168);
      throw paramContext;
    }
    this.mJe = ((ViewGroup)paramContext);
    AppMethodBeat.o(355168);
  }
  
  private static final void a(bi parambi, e parame, View paramView)
  {
    AppMethodBeat.i(355188);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambi);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parame);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMpArticleBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambi, "this$0");
    kotlin.g.b.s.u(parame, "$data");
    kotlin.g.b.s.X("click to mp article,url:", parame.DUH.url);
    h.jXD();
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    localObject2 = parambi.buContext;
    localObject1 = parame.DUH.url;
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.b((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, 5, 2, paramView);
    paramView = new Intent();
    parame = Uri.parse(parame.DUH.url).buildUpon();
    kotlin.g.b.s.s(parame, "parse(data.getPromoteData().url).buildUpon()");
    parame.appendQueryParameter("scene", "221");
    parame = parame.build().toString();
    kotlin.g.b.s.s(parame, "builder.build().toString()");
    localObject1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.bgV()) {
      aa.makeText(parambi.context, (CharSequence)kotlin.g.b.s.X("url: ", parame), 0).show();
    }
    paramView.putExtra("rawUrl", parame);
    paramView.putExtra("convertActivityFromTranslucent", true);
    c.b(parambi.context, "webview", ".ui.tools.WebViewUI", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMpArticleBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355188);
  }
  
  private final void a(e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(355179);
    Object localObject3 = this.mJe;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    ImageView localImageView = (ImageView)((ViewGroup)localObject1).findViewById(p.e.BOU);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    TextView localTextView1 = (TextView)((ViewGroup)localObject1).findViewById(p.e.BRo);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    TextView localTextView2 = (TextView)((ViewGroup)localObject1).findViewById(p.e.BRn);
    com.tencent.mm.ui.aw.a((Paint)localTextView1.getPaint(), 0.8F);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    localObject3 = ((ViewGroup)localObject1).findViewById(p.e.BIb);
    localObject1 = p.ExI;
    localObject1 = p.eCl();
    com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(parame.DUH.mdZ, v.FKY);
    kotlin.g.b.s.s(localImageView, "thumbView");
    p localp = p.ExI;
    ((d)localObject1).a(locals, localImageView, p.a(p.a.Eyb));
    localTextView1.setText((CharSequence)parame.DUH.title);
    localTextView2.setText((CharSequence)parame.DUH.ZTY);
    localObject1 = this.mJe;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ViewGroup)localObject1).setOnClickListener(new bi..ExternalSyntheticLambda1(this, parame));
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.s(this.buContext)) {
        break;
      }
      ((View)localObject3).setVisibility(4);
      AppMethodBeat.o(355179);
      return;
    }
    ((View)localObject3).setVisibility(0);
    ((View)localObject3).setOnClickListener(new bi..ExternalSyntheticLambda0(this, parame));
    AppMethodBeat.o(355179);
  }
  
  private static final void b(bi parambi, e parame, View paramView)
  {
    AppMethodBeat.i(355199);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambi);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parame);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMpArticleBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambi, "this$0");
    kotlin.g.b.s.u(parame, "$data");
    kotlin.g.b.s.X("close promote, url:", parame.DUH.url);
    h.jXD();
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(parambi.buContext, 2, 2);
    parambi = aj.CGT;
    parambi = aj.elk();
    if (parambi != null)
    {
      paramView = b.c.ndQ;
      localObject1 = new Bundle();
      localObject2 = new bla();
      ((bla)localObject2).id = parame.DUI;
      ((bla)localObject2).type = 2;
      ((bla)localObject2).ZTU = new com.tencent.mm.bx.b(parame.DUH.toByteArray());
      parame = ah.aiuX;
      ((Bundle)localObject1).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject2).toByteArray());
      parame = ah.aiuX;
      parambi.statusChange(paramView, (Bundle)localObject1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMpArticleBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355199);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong) {}
  
  public final void eoK() {}
  
  public final void eoL() {}
  
  public final void fs(Object paramObject)
  {
    AppMethodBeat.i(355219);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof e)) {
      a((e)paramObject);
    }
    AppMethodBeat.o(355219);
  }
  
  public final void ft(Object paramObject)
  {
    AppMethodBeat.i(355225);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof e))
    {
      a((e)paramObject);
      Object localObject = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.model.context.a locala = this.buContext;
      localObject = ((e)paramObject).DUH.url;
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.b(locala, 1, 2, paramObject);
    }
    AppMethodBeat.o(355225);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(355233);
    ViewGroup localViewGroup = this.mJe;
    Object localObject = localViewGroup;
    if (localViewGroup == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject = null;
    }
    localObject = (View)localObject;
    AppMethodBeat.o(355233);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bi
 * JD-Core Version:    0.7.0.1
 */