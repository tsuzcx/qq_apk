package com.tencent.mm.plugin.finder.storage.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "title", "onClick", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "onItemClick", "index", "", "reset", "value", "plugin-finder_release"})
public final class c
  extends b<String>
{
  private final a<z> gjX;
  
  public c(String paramString, a<z> parama)
  {
    super("", paramString);
    AppMethodBeat.i(204350);
    this.gjX = parama;
    AppMethodBeat.o(204350);
  }
  
  public final void FN(int paramInt)
  {
    AppMethodBeat.i(204349);
    a locala = this.gjX;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(204349);
      return;
    }
    AppMethodBeat.o(204349);
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.c
 * JD-Core Version:    0.7.0.1
 */