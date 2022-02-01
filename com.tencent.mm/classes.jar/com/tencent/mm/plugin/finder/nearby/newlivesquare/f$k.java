package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.a;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.d;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragmentViewCallback$initView$7", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$k
  extends d<a>
{
  f$k(f paramf) {}
  
  public final void a(b<a> paramb)
  {
    AppMethodBeat.i(370486);
    s.u(paramb, "item");
    AppMethodBeat.o(370486);
  }
  
  public final void s(Set<b<a>> paramSet)
  {
    AppMethodBeat.i(370484);
    s.u(paramSet, "recordsSet");
    Log.i("Finder.LiveEntranceFragmentViewCallback", s.X("onExposeTimeRecorded: size = ", Integer.valueOf(paramSet.size())));
    Object localObject2 = (Iterable)paramSet;
    Object localObject1 = this.EMY;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      f.a((f)localObject1, (b)((Iterator)localObject2).next());
    }
    localObject1 = i.akhB;
    i.R(paramSet);
    AppMethodBeat.o(370484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.f.k
 * JD-Core Version:    0.7.0.1
 */