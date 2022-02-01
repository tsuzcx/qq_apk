package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getContext", "()Landroid/content/Context;", "hasProcessCrash", "", "item", "Landroid/view/View;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "gone", "inflate", "show", "plugin-brandservice_release"})
public final class af
  extends ae
{
  private final String TAG;
  private final Context context;
  private final b sCg;
  private BizTLRecCardCanvasView sEI;
  private boolean sEJ;
  private View sEi;
  private int style;
  
  public af(b paramb, Context paramContext)
  {
    AppMethodBeat.i(257672);
    this.sCg = paramb;
    this.context = paramContext;
    this.TAG = "MicroMsg.BizTLRecFeedCanvas";
    this.style = 2003;
    AppMethodBeat.o(257672);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(257667);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    String str = "__rec_feed_" + paramz.Ven.RVi;
    Object localObject = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(71L);
    Log.i(this.TAG, "filling#" + str + " msgId=" + paramz.field_msgId);
    localObject = r.VcW;
    if (!r.hvP())
    {
      paramView1.setVisibility(8);
      AppMethodBeat.o(257667);
      return;
    }
    if (!this.sEJ)
    {
      localObject = c.shz;
      if (!c.d(str, paramView1))
      {
        paramz = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(73L);
        AppMethodBeat.o(257667);
        return;
      }
    }
    this.sEJ = true;
    p.k(paramView2, "parent");
    if (this.sEi == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(d.e.str)).inflate();
      this.sEI = ((BizTLRecCardCanvasView)paramView1.findViewById(d.e.ssB));
      this.sEi = paramView1;
    }
    paramView1 = this.sEi;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = this.sEI;
    if (paramView1 != null) {
      paramView1.setBizTimeLineInfo(paramz);
    }
    paramView1 = this.sEI;
    if (paramView1 != null)
    {
      long l = paramz.field_msgId;
      paramz = paramz.hwR();
      p.j(paramz, "info.recFeedData");
      paramView1.a(l, str, "rec-feed", paramz);
    }
    paramz = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(72L);
    paramz = c.shz;
    c.aoP(str);
    AppMethodBeat.o(257667);
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(257669);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(257669);
      return;
    }
    AppMethodBeat.o(257669);
  }
  
  public final void show()
  {
    AppMethodBeat.i(257671);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(257671);
      return;
    }
    AppMethodBeat.o(257671);
  }
  
  public final int uv()
  {
    return this.style;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.af
 * JD-Core Version:    0.7.0.1
 */