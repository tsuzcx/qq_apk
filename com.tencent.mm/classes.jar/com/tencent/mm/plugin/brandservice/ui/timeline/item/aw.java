package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTlRecFeedCard;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "viewBizTag", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "viewParent", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getView", "hideAll", "isSupportStyle", "", "style", "Companion", "plugin-brandservice_release"})
public final class aw
  extends a
{
  public static final aw.a pyH;
  private final b psQ;
  public final View pwy;
  private final ae pyE;
  private final af pyF;
  private final ad[] pyG;
  
  static
  {
    AppMethodBeat.i(195503);
    pyH = new aw.a((byte)0);
    AppMethodBeat.o(195503);
  }
  
  public aw(Context paramContext, b paramb)
  {
    AppMethodBeat.i(195502);
    this.psQ = paramb;
    this.pyE = new ae(this.psQ, paramContext);
    this.pyF = new af(this.psQ, paramContext);
    this.pyG = new ad[] { (ad)this.pyE, (ad)this.pyF };
    paramContext = View.inflate(paramContext, 2131493284, null);
    p.g(paramContext, "View.inflate(context, R.…ne_rec_feed_layout, null)");
    this.pwy = paramContext;
    AppMethodBeat.o(195502);
  }
  
  private final void cnh()
  {
    AppMethodBeat.i(195501);
    ad[] arrayOfad = this.pyG;
    int j = arrayOfad.length;
    int i = 0;
    while (i < j)
    {
      arrayOfad[i].cmO();
      i += 1;
    }
    AppMethodBeat.o(195501);
  }
  
  public final void c(z paramz, int paramInt, View paramView)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(195500);
    p.h(paramz, "info");
    p.h(paramView, "convertView");
    if (paramz.NQr == null)
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is null");
      cnh();
      AppMethodBeat.o(195500);
      return;
    }
    switch (paramz.NQr.KUh)
    {
    default: 
      i = 0;
    }
    if (i == 0)
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] style = " + paramz.NQr.KUh + " not support");
      cnh();
      AppMethodBeat.o(195500);
      return;
    }
    Object localObject1 = paramz.NQr;
    p.g(localObject1, "info.recFeed");
    if (!com.tencent.mm.storage.af.b((dkr)localObject1))
    {
      Log.i("MicroMsg.BizTlRecFeedCard", "[TRACE_BIZRECFEED] recFeed is illegal");
      cnh();
      AppMethodBeat.o(195500);
      return;
    }
    localObject1 = o.iBV;
    o.Aa(20L);
    localObject1 = this.pyG;
    int k = localObject1.length;
    i = j;
    if (i < k)
    {
      Object localObject2 = localObject1[i];
      if (paramz.gAJ() != localObject2.getStyle()) {
        localObject2.cmO();
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2.show();
        localObject2.a(paramz, paramInt, paramView, this.pwy);
      }
    }
    AppMethodBeat.o(195500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aw
 * JD-Core Version:    0.7.0.1
 */