package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.brandservice.d.a;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTlRecFeedCard;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "topLine", "Landroid/view/View;", "getTopLine", "()Landroid/view/View;", "topLine$delegate", "Lkotlin/Lazy;", "viewBizCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedCanvas;", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "viewBizTag", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "viewParent", "doInsertAnimation", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "preInfo", "pos", "", "convertView", "getView", "hideAll", "initGapLine", "isSupportStyle", "", "style", "showGap", "showLine", "Companion", "plugin-brandservice_release"})
public final class ay
  extends a
{
  public static final ay.a sIm;
  private final Context context;
  private final b sCg;
  public final View sFU;
  private final ag sIh;
  private final ah sIi;
  private final af sIj;
  private final ae[] sIk;
  private final f sIl;
  
  static
  {
    AppMethodBeat.i(266000);
    sIm = new ay.a((byte)0);
    AppMethodBeat.o(266000);
  }
  
  public ay(Context paramContext, b paramb)
  {
    AppMethodBeat.i(265999);
    this.context = paramContext;
    this.sCg = paramb;
    this.sIh = new ag(this.sCg, this.context);
    this.sIi = new ah(this.sCg, this.context);
    this.sIj = new af(this.sCg, this.context);
    this.sIk = new ae[] { (ae)this.sIh, (ae)this.sIi, (ae)this.sIj };
    paramContext = View.inflate(this.context, d.f.stY, null);
    p.j(paramContext, "View.inflate(context, R.…ne_rec_feed_layout, null)");
    this.sFU = paramContext;
    this.sIl = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(265999);
  }
  
  private final View cAS()
  {
    AppMethodBeat.i(265996);
    View localView = (View)this.sIl.getValue();
    AppMethodBeat.o(265996);
    return localView;
  }
  
  private final void cAT()
  {
    AppMethodBeat.i(265998);
    ae[] arrayOfae = this.sIk;
    int j = arrayOfae.length;
    int i = 0;
    while (i < j)
    {
      arrayOfae[i].cAv();
      i += 1;
    }
    AppMethodBeat.o(265998);
  }
  
  public final void a(z paramz1, z paramz2, int paramInt, View paramView)
  {
    AppMethodBeat.i(265997);
    p.k(paramz1, "info");
    p.k(paramView, "convertView");
    if (paramz1.Ven == null)
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is null");
      cAT();
      AppMethodBeat.o(265997);
      return;
    }
    int i;
    switch (paramz1.Ven.RVf)
    {
    default: 
      i = 0;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] style = " + paramz1.Ven.RVf + " not support");
      cAT();
      AppMethodBeat.o(265997);
      return;
      i = 1;
      continue;
      i = 1;
      continue;
      i = 1;
    }
    dug localdug = paramz1.Ven;
    p.j(localdug, "info.recFeed");
    if (!com.tencent.mm.storage.af.c(localdug))
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is illegal");
      cAT();
      AppMethodBeat.o(265997);
      return;
    }
    if ((paramz1.Ven.UaG == 0) && (paramz2 != null) && (paramz2.hwz() == true))
    {
      paramz2 = paramz2.Ven;
      if ((paramz2 != null) && (paramz2.UaG == 0))
      {
        cAS().setVisibility(0);
        this.sFU.setPadding(0, 0, 0, 0);
        paramz2 = o.lrA;
        o.Gh(20L);
        paramz2 = this.sIk;
        int j = paramz2.length;
        i = 0;
        label261:
        if (i >= j) {
          break label346;
        }
        localdug = paramz2[i];
        if (paramz1.hwQ() == localdug.uv()) {
          break label325;
        }
        localdug.cAv();
      }
    }
    for (;;)
    {
      i += 1;
      break label261;
      cAS().setVisibility(8);
      this.sFU.setPadding(0, b.sAA, 0, 0);
      break;
      label325:
      localdug.show();
      localdug.a(paramz1, paramInt, paramView, this.sFU);
    }
    label346:
    if (paramz1.Veh)
    {
      paramz1.Veh = false;
      this.sFU.startAnimation(AnimationUtils.loadAnimation(this.context, d.a.fast_faded_in));
    }
    AppMethodBeat.o(265997);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(ay paramay)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ay
 * JD-Core Version:    0.7.0.1
 */