package com.tencent.mm.plugin.hld.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "plugin-hld_release"})
public final class j
{
  public final String content;
  
  public j(String paramString)
  {
    AppMethodBeat.i(215156);
    this.content = paramString;
    AppMethodBeat.o(215156);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215152);
    if ((j)this == paramObject)
    {
      AppMethodBeat.o(215152);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.h(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(215152);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.utils.WxImeSymbolData");
      AppMethodBeat.o(215152);
      throw paramObject;
    }
    if ((p.h(this.content, ((j)paramObject).content) ^ true))
    {
      AppMethodBeat.o(215152);
      return false;
    }
    AppMethodBeat.o(215152);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(215155);
    int i = this.content.hashCode();
    AppMethodBeat.o(215155);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.j
 * JD-Core Version:    0.7.0.1
 */