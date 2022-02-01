package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$ConsumeNewXmlData;", "", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "pendingReason", "", "(Ljava/lang/String;Ljava/util/Map;Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;I)V", "getAddMsgInfo", "()Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "getPendingReason", "()I", "getSubType", "()Ljava/lang/String;", "getValues", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
final class i$c
{
  final String AGj;
  final g.a AGk;
  final int AGl;
  final Map<String, String> values;
  
  public i$c(String paramString, Map<String, String> paramMap, g.a parama, int paramInt)
  {
    AppMethodBeat.i(336100);
    this.AGj = paramString;
    this.values = paramMap;
    this.AGk = parama;
    this.AGl = paramInt;
    AppMethodBeat.o(336100);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(336117);
    if (this == paramObject)
    {
      AppMethodBeat.o(336117);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(336117);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.AGj, paramObject.AGj))
    {
      AppMethodBeat.o(336117);
      return false;
    }
    if (!s.p(this.values, paramObject.values))
    {
      AppMethodBeat.o(336117);
      return false;
    }
    if (!s.p(this.AGk, paramObject.AGk))
    {
      AppMethodBeat.o(336117);
      return false;
    }
    if (this.AGl != paramObject.AGl)
    {
      AppMethodBeat.o(336117);
      return false;
    }
    AppMethodBeat.o(336117);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(336113);
    int i;
    int k;
    if (this.AGj == null)
    {
      i = 0;
      k = this.values.hashCode();
      if (this.AGk != null) {
        break label71;
      }
    }
    for (;;)
    {
      int m = this.AGl;
      AppMethodBeat.o(336113);
      return ((i * 31 + k) * 31 + j) * 31 + m;
      i = this.AGj.hashCode();
      break;
      label71:
      j = this.AGk.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(336105);
    String str = "ConsumeNewXmlData(subType=" + this.AGj + ", values=" + this.values + ", addMsgInfo=" + this.AGk + ", pendingReason=" + this.AGl + ')';
    AppMethodBeat.o(336105);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i.c
 * JD-Core Version:    0.7.0.1
 */