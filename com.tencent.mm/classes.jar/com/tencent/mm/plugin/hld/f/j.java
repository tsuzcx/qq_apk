package com.tencent.mm.plugin.hld.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public final String content;
  
  public j(String paramString)
  {
    AppMethodBeat.i(311529);
    this.content = paramString;
    AppMethodBeat.o(311529);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(311534);
    if (this == paramObject)
    {
      AppMethodBeat.o(311534);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(311534);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.utils.WxImeSymbolData");
      AppMethodBeat.o(311534);
      throw paramObject;
    }
    if (!s.p(this.content, ((j)paramObject).content))
    {
      AppMethodBeat.o(311534);
      return false;
    }
    AppMethodBeat.o(311534);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(311535);
    int i = this.content.hashCode();
    AppMethodBeat.o(311535);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.j
 * JD-Core Version:    0.7.0.1
 */