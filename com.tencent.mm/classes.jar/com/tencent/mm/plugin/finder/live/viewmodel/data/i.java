package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayl;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUserDesc;", "", "descType", "", "badgeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "getBadgeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "setBadgeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "getDescType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"})
public final class i
{
  public final int myb;
  public ayl zeM;
  
  public i(int paramInt, ayl paramayl)
  {
    this.myb = paramInt;
    this.zeM = paramayl;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260439);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((this.myb != paramObject.myb) || (!p.h(this.zeM, paramObject.zeM))) {}
      }
    }
    else
    {
      AppMethodBeat.o(260439);
      return true;
    }
    AppMethodBeat.o(260439);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260436);
    int j = this.myb;
    ayl localayl = this.zeM;
    if (localayl != null) {}
    for (int i = localayl.hashCode();; i = 0)
    {
      AppMethodBeat.o(260436);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260432);
    String str = "FinderLiveLinkMicUserDesc(descType=" + this.myb + ", badgeInfo=" + this.zeM + ")";
    AppMethodBeat.o(260432);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.i
 * JD-Core Version:    0.7.0.1
 */