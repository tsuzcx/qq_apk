package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "hasProcessCrash", "", "item", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "plugin-brandservice_release"})
public final class v
  extends ae
{
  private final String TAG;
  private final b sCg;
  private BizTLRecCardCanvasView sEI;
  private boolean sEJ;
  private View sEi;
  
  public v(b paramb)
  {
    AppMethodBeat.i(265762);
    this.sCg = paramb;
    this.TAG = "MicroMsg.BizTLRecCardCanvas";
    AppMethodBeat.o(265762);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(265760);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    Object localObject1 = paramz.hwL();
    StringBuilder localStringBuilder = new StringBuilder("__rec_card_");
    if (localObject1 != null)
    {
      localObject1 = ((eqg)localObject1).UsH;
      if (localObject1 != null)
      {
        localObject2 = ((due)localObject1).cardId;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label83;
        }
      }
    }
    localObject1 = Long.valueOf(paramz.field_msgId);
    label83:
    localObject1 = localObject1;
    Object localObject2 = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(71L);
    Log.i(this.TAG, "filling#" + (String)localObject1 + " msgId=" + paramz.field_msgId);
    localObject2 = r.VcW;
    if (!r.hvP())
    {
      paramView1.setVisibility(8);
      AppMethodBeat.o(265760);
      return;
    }
    if (!this.sEJ)
    {
      localObject2 = c.shz;
      if (!c.d((String)localObject1, paramView1))
      {
        paramz = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(73L);
        AppMethodBeat.o(265760);
        return;
      }
    }
    this.sEJ = true;
    p.k(paramView2, "parent");
    if (this.sEi == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(d.e.stq)).inflate();
      this.sEI = ((BizTLRecCardCanvasView)paramView1.findViewById(d.e.ssz));
      this.sEi = paramView1;
    }
    paramView1 = this.sEi;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView2 = paramz.hwL();
    paramView1 = this.sEI;
    if (paramView1 != null) {
      paramView1.setBizTimeLineInfo(paramz);
    }
    localObject2 = this.sEI;
    if (localObject2 != null)
    {
      long l = paramz.field_msgId;
      paramView1 = paramView2.UsH.Uay;
      paramz = paramView1;
      if (paramView1 == null) {
        paramz = "re";
      }
      paramView1 = paramView2.UsH.data;
      p.j(paramView1, "wrapper.exptInfo.data");
      ((BizTLRecCardCanvasView)localObject2).a(l, (String)localObject1, paramz, paramView1);
    }
    paramz = com.tencent.mm.plugin.webcanvas.l.PuB;
    com.tencent.mm.plugin.webcanvas.l.Tt(72L);
    paramz = c.shz;
    c.aoP((String)localObject1);
    AppMethodBeat.o(265760);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(265761);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(265761);
      return;
    }
    AppMethodBeat.o(265761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.v
 * JD-Core Version:    0.7.0.1
 */