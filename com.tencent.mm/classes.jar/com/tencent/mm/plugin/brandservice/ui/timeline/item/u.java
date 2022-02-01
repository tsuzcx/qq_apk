package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "hasProcessCrash", "", "item", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "plugin-brandservice_release"})
public final class u
  extends ad
{
  private final String TAG;
  private final b psQ;
  private View puO;
  private BizTLRecCardCanvasView pvr;
  private boolean pvs;
  
  public u(b paramb)
  {
    AppMethodBeat.i(195375);
    this.psQ = paramb;
    this.TAG = "MicroMsg.BizTLRecCardCanvas";
    AppMethodBeat.o(195375);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195373);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    Object localObject1 = paramz.gAD();
    StringBuilder localStringBuilder = new StringBuilder("__rec_card_");
    if (localObject1 != null)
    {
      localObject1 = ((ege)localObject1).Ngc;
      if (localObject1 != null)
      {
        localObject2 = ((dkp)localObject1).cardId;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label83;
        }
      }
    }
    localObject1 = Long.valueOf(paramz.field_msgId);
    label83:
    localObject1 = localObject1;
    Object localObject2 = com.tencent.mm.plugin.webcanvas.l.IAx;
    com.tencent.mm.plugin.webcanvas.l.LV(71L);
    Log.i(this.TAG, "filling#" + (String)localObject1 + " msgId=" + paramz.field_msgId);
    localObject2 = r.NPl;
    if (!r.gzM())
    {
      paramView1.setVisibility(8);
      AppMethodBeat.o(195373);
      return;
    }
    if (!this.pvs)
    {
      localObject2 = c.pfv;
      if (!c.d((String)localObject1, paramView1))
      {
        paramz = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(73L);
        AppMethodBeat.o(195373);
        return;
      }
    }
    this.pvs = true;
    p.h(paramView2, "parent");
    if (this.puO == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(2131309872)).inflate();
      this.pvr = ((BizTLRecCardCanvasView)paramView1.findViewById(2131306600));
      this.puO = paramView1;
    }
    paramView1 = this.puO;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView2 = paramz.gAD();
    paramView1 = this.pvr;
    if (paramView1 != null) {
      paramView1.setBizTimeLineInfo(paramz);
    }
    localObject2 = this.pvr;
    if (localObject2 != null)
    {
      long l = paramz.field_msgId;
      paramView1 = paramView2.Ngc.MOE;
      paramz = paramView1;
      if (paramView1 == null) {
        paramz = "re";
      }
      paramView1 = paramView2.Ngc.data;
      p.g(paramView1, "wrapper.exptInfo.data");
      ((BizTLRecCardCanvasView)localObject2).a(l, (String)localObject1, paramz, paramView1);
    }
    paramz = com.tencent.mm.plugin.webcanvas.l.IAx;
    com.tencent.mm.plugin.webcanvas.l.LV(72L);
    paramz = c.pfv;
    c.ahj((String)localObject1);
    AppMethodBeat.o(195373);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(195374);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195374);
      return;
    }
    AppMethodBeat.o(195374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.u
 * JD-Core Version:    0.7.0.1
 */