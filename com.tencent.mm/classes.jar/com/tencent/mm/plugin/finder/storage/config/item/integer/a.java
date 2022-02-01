package com.tencent.mm.plugin.finder.storage.config.item.integer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/config/item/integer/FinderIntConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "defValue", "_title", "", "onClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", "index", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.finder.storage.config.b<Integer>
{
  private final d.g.a.b<Integer, z> sKw;
  
  public a(int paramInt, String paramString, d.g.a.b<? super Integer, z> paramb)
  {
    super(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.i(204362);
    this.sKw = paramb;
    AppMethodBeat.o(204362);
  }
  
  public final void FN(int paramInt)
  {
    AppMethodBeat.i(204361);
    super.FN(paramInt);
    d.g.a.b localb = this.sKw;
    if (localb != null)
    {
      localb.invoke(value());
      AppMethodBeat.o(204361);
      return;
    }
    AppMethodBeat.o(204361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.integer.a
 * JD-Core Version:    0.7.0.1
 */