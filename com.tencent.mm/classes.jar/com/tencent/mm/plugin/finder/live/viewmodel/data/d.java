package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveAudioModeCoverInfo;", "", "coverUrl", "", "avatarUrl", "choosePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getChoosePath", "setChoosePath", "getCoverUrl", "setCoverUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public String Ebq = null;
  public String coverUrl = null;
  public String nVM = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356580);
    if (this == paramObject)
    {
      AppMethodBeat.o(356580);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(356580);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.coverUrl, paramObject.coverUrl))
    {
      AppMethodBeat.o(356580);
      return false;
    }
    if (!s.p(this.nVM, paramObject.nVM))
    {
      AppMethodBeat.o(356580);
      return false;
    }
    if (!s.p(this.Ebq, paramObject.Ebq))
    {
      AppMethodBeat.o(356580);
      return false;
    }
    AppMethodBeat.o(356580);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(356571);
    int i;
    int j;
    if (this.coverUrl == null)
    {
      i = 0;
      if (this.nVM != null) {
        break label60;
      }
      j = 0;
      label25:
      if (this.Ebq != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(356571);
      return (j + i * 31) * 31 + k;
      i = this.coverUrl.hashCode();
      break;
      label60:
      j = this.nVM.hashCode();
      break label25;
      label71:
      k = this.Ebq.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356562);
    String str = "FinderLiveAudioModeCoverInfo(coverUrl=" + this.coverUrl + ", avatarUrl=" + this.nVM + ", choosePath=" + this.Ebq + ')';
    AppMethodBeat.o(356562);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.d
 * JD-Core Version:    0.7.0.1
 */