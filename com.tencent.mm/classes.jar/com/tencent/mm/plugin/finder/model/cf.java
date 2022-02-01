package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmk;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "", "feedId", "", "isRead", "", "timestamp", "stat", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(JZJLcom/tencent/mm/protocal/protobuf/MarkReadStat;)V", "getFeedId", "()J", "()Z", "setRead", "(Z)V", "getStat", "()Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "setStat", "(Lcom/tencent/mm/protocal/protobuf/MarkReadStat;)V", "getTimestamp", "compareTo", "", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cf
  implements Comparable<cf>
{
  boolean EDT;
  dmk EDU;
  final long feedId;
  private final long timestamp;
  
  private cf(long paramLong1, long paramLong2)
  {
    this.feedId = paramLong1;
    this.EDT = false;
    this.timestamp = paramLong2;
    this.EDU = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(331989);
    if (this == paramObject)
    {
      AppMethodBeat.o(331989);
      return true;
    }
    if (!(paramObject instanceof cf))
    {
      AppMethodBeat.o(331989);
      return false;
    }
    paramObject = (cf)paramObject;
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(331989);
      return false;
    }
    if (this.EDT != paramObject.EDT)
    {
      AppMethodBeat.o(331989);
      return false;
    }
    if (this.timestamp != paramObject.timestamp)
    {
      AppMethodBeat.o(331989);
      return false;
    }
    if (!s.p(this.EDU, paramObject.EDU))
    {
      AppMethodBeat.o(331989);
      return false;
    }
    AppMethodBeat.o(331989);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(331975);
    String str = "StreamMarkReadStat(feedId=" + this.feedId + ", isRead=" + this.EDT + ", timestamp=" + this.timestamp + ", stat=" + this.EDU + ')';
    AppMethodBeat.o(331975);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.cf
 * JD-Core Version:    0.7.0.1
 */