package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfl;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUserDesc;", "", "descType", "", "badgeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "getBadgeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "setBadgeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "getDescType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public bfl EbL;
  public final int prf;
  
  public i(int paramInt, bfl parambfl)
  {
    this.prf = paramInt;
    this.EbL = parambfl;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356583);
    if (this == paramObject)
    {
      AppMethodBeat.o(356583);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(356583);
      return false;
    }
    paramObject = (i)paramObject;
    if (this.prf != paramObject.prf)
    {
      AppMethodBeat.o(356583);
      return false;
    }
    if (!s.p(this.EbL, paramObject.EbL))
    {
      AppMethodBeat.o(356583);
      return false;
    }
    AppMethodBeat.o(356583);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(356579);
    int j = this.prf;
    if (this.EbL == null) {}
    for (int i = 0;; i = this.EbL.hashCode())
    {
      AppMethodBeat.o(356579);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356570);
    String str = "FinderLiveLinkMicUserDesc(descType=" + this.prf + ", badgeInfo=" + this.EbL + ')';
    AppMethodBeat.o(356570);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.i
 * JD-Core Version:    0.7.0.1
 */