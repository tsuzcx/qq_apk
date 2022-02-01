package com.tencent.mm.plugin.finder.storage;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/storage/FinderGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"})
public final class k$c
  extends GridLayoutManager.b
{
  k$c(y.f paramf) {}
  
  public final int bW(int paramInt)
  {
    AppMethodBeat.i(204233);
    if (paramInt == 0)
    {
      Object localObject = (GridLayoutManager)this.sIP.NiY;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(204233);
        throw ((Throwable)localObject);
      }
      paramInt = ((GridLayoutManager)localObject).jZ();
      AppMethodBeat.o(204233);
      return paramInt;
    }
    AppMethodBeat.o(204233);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k.c
 * JD-Core Version:    0.7.0.1
 */