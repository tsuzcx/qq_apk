package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "", "insertIndex", "", "insertCount", "changeIndex", "Ljava/util/LinkedList;", "isRemoveBeforeInsert", "", "(IILjava/util/LinkedList;Z)V", "getChangeIndex", "()Ljava/util/LinkedList;", "getInsertCount", "()I", "getInsertIndex", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class j
{
  final int scX;
  final int scY;
  final LinkedList<Integer> scZ;
  final boolean sda;
  
  public j(int paramInt1, int paramInt2, LinkedList<Integer> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(202585);
    this.scX = paramInt1;
    this.scY = paramInt2;
    this.scZ = paramLinkedList;
    this.sda = paramBoolean;
    AppMethodBeat.o(202585);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202588);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((this.scX != paramObject.scX) || (this.scY != paramObject.scY) || (!p.i(this.scZ, paramObject.scZ)) || (this.sda != paramObject.sda)) {}
      }
    }
    else
    {
      AppMethodBeat.o(202588);
      return true;
    }
    AppMethodBeat.o(202588);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202586);
    String str = "MergeResult(insertIndex=" + this.scX + ", insertCount=" + this.scY + ", changeIndex=" + this.scZ + ", isRemoveBeforeInsert=" + this.sda + ")";
    AppMethodBeat.o(202586);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.j
 * JD-Core Version:    0.7.0.1
 */