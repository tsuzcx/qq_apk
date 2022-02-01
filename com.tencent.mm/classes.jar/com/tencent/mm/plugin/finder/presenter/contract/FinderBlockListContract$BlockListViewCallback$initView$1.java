package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.a;
import com.tencent.mm.plugin.finder.convert.b;
import com.tencent.mm.plugin.finder.convert.c;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.view.recyclerview.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBlockListContract$BlockListViewCallback$initView$1
  implements g
{
  public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
  {
    AppMethodBeat.i(343549);
    if (paramInt == -3)
    {
      localObject = (com.tencent.mm.view.recyclerview.f)new b();
      AppMethodBeat.o(343549);
      return localObject;
    }
    if (paramInt == -8)
    {
      localObject = (com.tencent.mm.view.recyclerview.f)new c();
      AppMethodBeat.o(343549);
      return localObject;
    }
    if (paramInt == p.class.getName().hashCode())
    {
      localObject = (com.tencent.mm.view.recyclerview.f)new a();
      AppMethodBeat.o(343549);
      return localObject;
    }
    s.checkNotNull(null);
    Object localObject = new kotlin.f();
    AppMethodBeat.o(343549);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback.initView.1
 * JD-Core Version:    0.7.0.1
 */