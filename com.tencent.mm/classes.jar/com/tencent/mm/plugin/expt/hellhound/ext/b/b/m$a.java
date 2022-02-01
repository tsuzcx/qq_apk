package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "", "incrementList", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "hasMore", "", "isNeedClear", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;IZZ)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getIncrementList", "()Ljava/util/List;", "setIncrementList", "(Ljava/util/List;)V", "setNeedClear", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getPullType", "()I", "setPullType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$a
{
  private boolean hasMore;
  public List<?> incrementList;
  private boolean isNeedClear;
  private b lastBuffer;
  public int pullType;
  
  public m$a(List<?> paramList, b paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.incrementList = paramList;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    this.hasMore = paramBoolean1;
    this.isNeedClear = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(300574);
    if (this == paramObject)
    {
      AppMethodBeat.o(300574);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(300574);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.incrementList, paramObject.incrementList))
    {
      AppMethodBeat.o(300574);
      return false;
    }
    if (!s.p(this.lastBuffer, paramObject.lastBuffer))
    {
      AppMethodBeat.o(300574);
      return false;
    }
    if (this.pullType != paramObject.pullType)
    {
      AppMethodBeat.o(300574);
      return false;
    }
    if (this.hasMore != paramObject.hasMore)
    {
      AppMethodBeat.o(300574);
      return false;
    }
    if (this.isNeedClear != paramObject.isNeedClear)
    {
      AppMethodBeat.o(300574);
      return false;
    }
    AppMethodBeat.o(300574);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(300564);
    String str = "ArgsOnFetchDone(incrementList=" + this.incrementList + ", lastBuffer=" + this.lastBuffer + ", pullType=" + this.pullType + ", hasMore=" + this.hasMore + ", isNeedClear=" + this.isNeedClear + ')';
    AppMethodBeat.o(300564);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.m.a
 * JD-Core Version:    0.7.0.1
 */