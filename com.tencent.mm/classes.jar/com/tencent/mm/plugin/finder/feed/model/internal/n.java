package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "", "insertIndex", "", "insertCount", "changeIndex", "Ljava/util/LinkedList;", "isRemoveBeforeInsert", "", "dataReplace", "(IILjava/util/LinkedList;ZZ)V", "getChangeIndex", "()Ljava/util/LinkedList;", "getDataReplace", "()Z", "setDataReplace", "(Z)V", "getInsertCount", "()I", "setInsertCount", "(I)V", "getInsertIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-base_release"})
public final class n
{
  final int xKN;
  public int xKO;
  final LinkedList<Integer> xKP;
  final boolean xKQ;
  public boolean xKR;
  
  public n(int paramInt1, int paramInt2, LinkedList<Integer> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(260411);
    this.xKN = paramInt1;
    this.xKO = paramInt2;
    this.xKP = paramLinkedList;
    this.xKQ = paramBoolean1;
    this.xKR = paramBoolean2;
    AppMethodBeat.o(260411);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260420);
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if ((this.xKN != paramObject.xKN) || (this.xKO != paramObject.xKO) || (!p.h(this.xKP, paramObject.xKP)) || (this.xKQ != paramObject.xKQ) || (this.xKR != paramObject.xKR)) {}
      }
    }
    else
    {
      AppMethodBeat.o(260420);
      return true;
    }
    AppMethodBeat.o(260420);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260415);
    String str = "MergeResult(insertIndex=" + this.xKN + ", insertCount=" + this.xKO + ", changeIndex=" + this.xKP + ", isRemoveBeforeInsert=" + this.xKQ + ", dataReplace=" + this.xKR + ")";
    AppMethodBeat.o(260415);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.n
 * JD-Core Version:    0.7.0.1
 */