package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.a;
import com.tencent.mm.plugin.finder.convert.b;
import com.tencent.mm.plugin.finder.convert.c;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
public final class FinderBlockListContract$BlockListViewCallback$initView$1
  implements f
{
  public final e<?> EC(int paramInt)
  {
    AppMethodBeat.i(249691);
    e locale;
    if (paramInt == -3)
    {
      locale = (e)new b();
      AppMethodBeat.o(249691);
      return locale;
    }
    if (paramInt == -8)
    {
      locale = (e)new c();
      AppMethodBeat.o(249691);
      return locale;
    }
    if (paramInt == com.tencent.mm.plugin.finder.model.p.class.getName().hashCode())
    {
      locale = (e)new a();
      AppMethodBeat.o(249691);
      return locale;
    }
    kotlin.g.b.p.hyc();
    AppMethodBeat.o(249691);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback.initView.1
 * JD-Core Version:    0.7.0.1
 */