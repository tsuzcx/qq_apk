package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;", "", "coverUrl", "", "avatarUrl", "choosePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getChoosePath", "setChoosePath", "getCoverUrl", "setCoverUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"})
public final class d
{
  public String coverUrl = null;
  public String nfY = null;
  public String zex = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258033);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!p.h(this.coverUrl, paramObject.coverUrl)) || (!p.h(this.nfY, paramObject.nfY)) || (!p.h(this.zex, paramObject.zex))) {}
      }
    }
    else
    {
      AppMethodBeat.o(258033);
      return true;
    }
    AppMethodBeat.o(258033);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(258032);
    String str = this.coverUrl;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.nfY;
      if (str == null) {
        break label80;
      }
    }
    label80:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.zex;
      if (str != null) {
        k = str.hashCode();
      }
      AppMethodBeat.o(258032);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258031);
    String str = "FinderLiveAudioModeCoverInfo(coverUrl=" + this.coverUrl + ", avatarUrl=" + this.nfY + ", choosePath=" + this.zex + ")";
    AppMethodBeat.o(258031);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.d
 * JD-Core Version:    0.7.0.1
 */