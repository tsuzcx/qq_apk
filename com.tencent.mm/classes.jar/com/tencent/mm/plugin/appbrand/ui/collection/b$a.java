package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import a.v;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$2$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IItemDragResultCallback;", "isCanCancel", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "target", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "isCanMove", "holder", "from", "", "to", "itemContent", "", "isDragEnable", "onCreateFloatView", "Landroid/view/View;", "onDelete", "", "dragObject", "onDrag", "floatView", "area", "onDragEnd", "startPos", "endPos", "isInserted", "onDragRelease", "plugin-appbrand-integration_release"})
public final class b$a
  implements a
{
  b$a(b paramb) {}
  
  public final boolean O(RecyclerView.v paramv)
  {
    return true;
  }
  
  public final boolean P(RecyclerView.v paramv)
  {
    return false;
  }
  
  public final void a(RecyclerView.v paramv, View paramView, Object paramObject, int paramInt) {}
  
  public final boolean a(RecyclerView.v paramv, Object paramObject)
  {
    return true;
  }
  
  public final View b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(135080);
    b localb = this.iRW;
    if (paramRecyclerView == null) {
      j.ebi();
    }
    if (paramv == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionViewHolder");
      AppMethodBeat.o(135080);
      throw paramRecyclerView;
    }
    paramRecyclerView = b.a(localb, paramRecyclerView, (m)paramv);
    AppMethodBeat.o(135080);
    return paramRecyclerView;
  }
  
  public final void b(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(135078);
    this.iRW.aMV();
    AppMethodBeat.o(135078);
  }
  
  public final void bn(Object paramObject)
  {
    AppMethodBeat.i(135079);
    this.iRW.aMV();
    AppMethodBeat.o(135079);
  }
  
  public final void cz(View paramView)
  {
    AppMethodBeat.i(135081);
    j.q(paramView, "floatView");
    AppMethodBeat.o(135081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b.a
 * JD-Core Version:    0.7.0.1
 */