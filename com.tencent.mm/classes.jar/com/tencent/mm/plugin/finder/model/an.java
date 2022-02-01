package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bya;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "", "feedId", "", "isRead", "", "timestamp", "stat", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(JZJLcom/tencent/mm/protocal/protobuf/MarkReadStat;)V", "getFeedId", "()J", "()Z", "setRead", "(Z)V", "getStat", "()Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "setStat", "(Lcom/tencent/mm/protocal/protobuf/MarkReadStat;)V", "getTimestamp", "compareTo", "", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "hashCode", "toString", "", "plugin-finder_release"})
public final class an
  implements Comparable<an>
{
  final long dtq;
  boolean skE;
  bya skF;
  private final long timestamp;
  
  private an(long paramLong1, long paramLong2)
  {
    this.dtq = paramLong1;
    this.skE = false;
    this.timestamp = paramLong2;
    this.skF = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203004);
    if (this != paramObject)
    {
      if ((paramObject instanceof an))
      {
        paramObject = (an)paramObject;
        if ((this.dtq != paramObject.dtq) || (this.skE != paramObject.skE) || (this.timestamp != paramObject.timestamp) || (!p.i(this.skF, paramObject.skF))) {}
      }
    }
    else
    {
      AppMethodBeat.o(203004);
      return true;
    }
    AppMethodBeat.o(203004);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203002);
    String str = "StreamMarkReadStat(feedId=" + this.dtq + ", isRead=" + this.skE + ", timestamp=" + this.timestamp + ", stat=" + this.skF + ")";
    AppMethodBeat.o(203002);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.an
 * JD-Core Version:    0.7.0.1
 */