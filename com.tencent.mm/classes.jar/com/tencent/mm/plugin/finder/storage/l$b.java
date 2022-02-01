package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Config;", "", "brands", "", "models", "maxSize", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBrands", "()Ljava/lang/String;", "getMaxSize", "()I", "getModels", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$b
{
  final String FKC;
  final String FKD;
  final int maxSize;
  
  public l$b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(166960);
    this.FKC = paramString1;
    this.FKD = paramString2;
    this.maxSize = paramInt;
    AppMethodBeat.o(166960);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(166963);
    if (this == paramObject)
    {
      AppMethodBeat.o(166963);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(166963);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.FKC, paramObject.FKC))
    {
      AppMethodBeat.o(166963);
      return false;
    }
    if (!s.p(this.FKD, paramObject.FKD))
    {
      AppMethodBeat.o(166963);
      return false;
    }
    if (this.maxSize != paramObject.maxSize)
    {
      AppMethodBeat.o(166963);
      return false;
    }
    AppMethodBeat.o(166963);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(166962);
    int i = this.FKC.hashCode();
    int j = this.FKD.hashCode();
    int k = this.maxSize;
    AppMethodBeat.o(166962);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166961);
    String str = "Config(brands=" + this.FKC + ", models=" + this.FKD + ", maxSize=" + this.maxSize + ')';
    AppMethodBeat.o(166961);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l.b
 * JD-Core Version:    0.7.0.1
 */