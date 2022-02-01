package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "", "insertIndex", "", "insertCount", "changeIndex", "Ljava/util/LinkedList;", "isRemoveBeforeInsert", "", "dataReplace", "(IILjava/util/LinkedList;ZZ)V", "getChangeIndex", "()Ljava/util/LinkedList;", "getDataReplace", "()Z", "setDataReplace", "(Z)V", "getInsertCount", "()I", "setInsertCount", "(I)V", "getInsertIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  final int BkC;
  final LinkedList<Integer> BkD;
  final boolean BkE;
  public boolean BkF;
  public int apS;
  
  public o(int paramInt1, int paramInt2, LinkedList<Integer> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(366518);
    this.BkC = paramInt1;
    this.apS = paramInt2;
    this.BkD = paramLinkedList;
    this.BkE = paramBoolean1;
    this.BkF = paramBoolean2;
    AppMethodBeat.o(366518);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(366539);
    if (this == paramObject)
    {
      AppMethodBeat.o(366539);
      return true;
    }
    if (!(paramObject instanceof o))
    {
      AppMethodBeat.o(366539);
      return false;
    }
    paramObject = (o)paramObject;
    if (this.BkC != paramObject.BkC)
    {
      AppMethodBeat.o(366539);
      return false;
    }
    if (this.apS != paramObject.apS)
    {
      AppMethodBeat.o(366539);
      return false;
    }
    if (!s.p(this.BkD, paramObject.BkD))
    {
      AppMethodBeat.o(366539);
      return false;
    }
    if (this.BkE != paramObject.BkE)
    {
      AppMethodBeat.o(366539);
      return false;
    }
    if (this.BkF != paramObject.BkF)
    {
      AppMethodBeat.o(366539);
      return false;
    }
    AppMethodBeat.o(366539);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(366524);
    String str = "MergeResult(insertIndex=" + this.BkC + ", insertCount=" + this.apS + ", changeIndex=" + this.BkD + ", isRemoveBeforeInsert=" + this.BkE + ", dataReplace=" + this.BkF + ')';
    AppMethodBeat.o(366524);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.o
 * JD-Core Version:    0.7.0.1
 */