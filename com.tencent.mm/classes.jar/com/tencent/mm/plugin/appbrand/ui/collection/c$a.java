package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$a
  implements View.OnClickListener
{
  c$a(c paramc, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135088);
    paramView = c.a(this.iRX);
    if (paramView != null)
    {
      paramView.removeItem(this.euX);
      AppMethodBeat.o(135088);
      return;
    }
    AppMethodBeat.o(135088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.c.a
 * JD-Core Version:    0.7.0.1
 */