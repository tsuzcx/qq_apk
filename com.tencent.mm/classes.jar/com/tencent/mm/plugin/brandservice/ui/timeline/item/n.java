package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "hasProcessCrash", "", "item", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "plugin-brandservice_release"})
public final class n
  extends v
{
  public final String TAG;
  private final b ohs;
  public View oiV;
  public BizTLRecCardCanvasView ojy;
  public boolean ojz;
  
  public n(b paramb)
  {
    AppMethodBeat.i(208733);
    this.ohs = paramb;
    this.TAG = "MicroMsg.BizTLRecCardCanvas";
    AppMethodBeat.o(208733);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208732);
    View localView = this.oiV;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(208732);
      return;
    }
    AppMethodBeat.o(208732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.n
 * JD-Core Version:    0.7.0.1
 */