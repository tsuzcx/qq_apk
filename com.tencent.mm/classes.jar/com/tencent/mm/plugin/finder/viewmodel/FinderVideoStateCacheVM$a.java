package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "timestamp", "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class FinderVideoStateCacheVM$a
{
  final String mediaId;
  public int progress;
  public double sdg;
  
  public FinderVideoStateCacheVM$a(String paramString)
  {
    AppMethodBeat.i(204465);
    this.mediaId = paramString;
    AppMethodBeat.o(204465);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204468);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!k.g(this.mediaId, paramObject.mediaId)) {}
      }
    }
    else
    {
      AppMethodBeat.o(204468);
      return true;
    }
    AppMethodBeat.o(204468);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204467);
    String str = this.mediaId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(204467);
      return i;
    }
    AppMethodBeat.o(204467);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204466);
    String str = "Cache(mediaId=" + this.mediaId + ")";
    AppMethodBeat.o(204466);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM.a
 * JD-Core Version:    0.7.0.1
 */