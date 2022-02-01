package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "plugin-appbrand-integration_release"})
public final class i
  extends DragRecyclerView
{
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51268);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(51268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.i
 * JD-Core Version:    0.7.0.1
 */