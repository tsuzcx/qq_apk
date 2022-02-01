package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.webcanvas.j;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.r;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "hasProcessCrash", "", "item", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends ab
{
  private final String TAG;
  private final b vHY;
  private View vJU;
  private BizTLRecCardCanvasView vKq;
  private boolean vKr;
  
  public u(b paramb)
  {
    AppMethodBeat.i(302668);
    this.vHY = paramb;
    this.TAG = "MicroMsg.BizTLRecCardCanvas";
    AppMethodBeat.o(302668);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302683);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    flj localflj = paramab.iYp();
    if (localflj == null)
    {
      AppMethodBeat.o(302683);
      return;
    }
    Object localObject1 = localflj.abLO;
    if (localObject1 == null) {}
    Object localObject2;
    for (localObject1 = null;; localObject1 = ((enc)localObject1).cardId)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = Long.valueOf(paramab.field_msgId);
      }
      localObject1 = s.X("__rec_card_", localObject2);
      localObject2 = j.WkY;
      j.xC(71L);
      Log.i(this.TAG, "filling#" + (String)localObject1 + " msgId=" + paramab.field_msgId);
      localObject2 = r.acDM;
      if (r.iXo()) {
        break;
      }
      paramView1.setVisibility(8);
      AppMethodBeat.o(302683);
      return;
    }
    if (!this.vKr)
    {
      localObject2 = c.vtp;
      if (!c.e((String)localObject1, paramView1))
      {
        paramab = j.WkY;
        j.xC(73L);
        AppMethodBeat.o(302683);
        return;
      }
    }
    if (!com.tencent.mm.storage.ah.cA(localflj.abLO.ablO, false))
    {
      paramView1.setVisibility(8);
      AppMethodBeat.o(302683);
      return;
    }
    this.vKr = true;
    s.u(paramView2, "parent");
    if (this.vJU == null) {}
    try
    {
      paramView1 = ((ViewStub)paramView2.findViewById(d.e.viewstub_canvas)).inflate();
      this.vKq = ((BizTLRecCardCanvasView)paramView1.findViewById(d.e.rec_canvas));
      localObject2 = kotlin.ah.aiuX;
      this.vJU = paramView1;
      paramView1 = this.vJU;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.vKq;
      if (paramView1 != null) {
        paramView1.setBizTimeLineInfo(paramab);
      }
      paramView2 = this.vKq;
      if (paramView2 != null)
      {
        long l = paramab.field_msgId;
        paramView1 = localflj.abLO.abrA;
        paramab = paramView1;
        if (paramView1 == null) {
          paramab = "re";
        }
        paramView1 = localflj.abLO.data;
        s.s(paramView1, "wrapper.exptInfo.data");
        paramView2.a(l, (String)localObject1, paramab, paramView1);
      }
      paramab = j.WkY;
      j.xC(72L);
      paramab = c.vtp;
      c.ail((String)localObject1);
      AppMethodBeat.o(302683);
      return;
    }
    finally
    {
      for (;;)
      {
        paramView2.setVisibility(8);
        Log.printErrStackTrace(this.TAG, paramView1, "inflate", new Object[0]);
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(302687);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.u
 * JD-Core Version:    0.7.0.1
 */