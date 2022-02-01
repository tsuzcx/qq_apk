package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anc;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxMsgInfo;", "", "boxId", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "Lkotlin/collections/ArrayList;", "lastEnterTimeStamp", "", "bindBoxContext", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "(Ljava/lang/String;Ljava/util/ArrayList;JLcom/tencent/mm/protocal/protobuf/BoxContext;)V", "getBindBoxContext", "()Lcom/tencent/mm/protocal/protobuf/BoxContext;", "getBoxId", "()Ljava/lang/String;", "getDataList", "()Ljava/util/ArrayList;", "getLastEnterTimeStamp", "()J", "setLastEnterTimeStamp", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public long adlC;
  public final String adma;
  public final anc akgL;
  public final ArrayList<b> pUj;
  
  public h(String paramString, ArrayList<b> paramArrayList, long paramLong, anc paramanc)
  {
    AppMethodBeat.i(371688);
    this.adma = paramString;
    this.pUj = paramArrayList;
    this.adlC = paramLong;
    this.akgL = paramanc;
    AppMethodBeat.o(371688);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(371734);
    if (this == paramObject)
    {
      AppMethodBeat.o(371734);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(371734);
      return false;
    }
    paramObject = (h)paramObject;
    if (!s.p(this.adma, paramObject.adma))
    {
      AppMethodBeat.o(371734);
      return false;
    }
    if (!s.p(this.pUj, paramObject.pUj))
    {
      AppMethodBeat.o(371734);
      return false;
    }
    if (this.adlC != paramObject.adlC)
    {
      AppMethodBeat.o(371734);
      return false;
    }
    if (!s.p(this.akgL, paramObject.akgL))
    {
      AppMethodBeat.o(371734);
      return false;
    }
    AppMethodBeat.o(371734);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(371719);
    int i = this.adma.hashCode();
    int j = this.pUj.hashCode();
    int k = q.a..ExternalSyntheticBackport0.m(this.adlC);
    int m = this.akgL.hashCode();
    AppMethodBeat.o(371719);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(371702);
    String str = "BoxMsgInfo(boxId=" + this.adma + ", dataList=" + this.pUj + ", lastEnterTimeStamp=" + this.adlC + ", bindBoxContext=" + this.akgL + ')';
    AppMethodBeat.o(371702);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.h
 * JD-Core Version:    0.7.0.1
 */