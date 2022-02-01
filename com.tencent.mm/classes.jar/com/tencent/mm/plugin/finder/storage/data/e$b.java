package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "(ILcom/tencent/mm/protobuf/ByteString;ZZZ)V", "getDownContinue", "()Z", "getHasExpand", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPos", "()I", "getUpContinue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class e$b
{
  public final b lastBuffer;
  public final int pos;
  public final boolean rEJ;
  public final boolean rgB;
  public final boolean rgC;
  
  public e$b(int paramInt, b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.pos = paramInt;
    this.lastBuffer = paramb;
    this.rgB = paramBoolean1;
    this.rgC = paramBoolean2;
    this.rEJ = paramBoolean3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(167051);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.pos != paramObject.pos) || (!k.g(this.lastBuffer, paramObject.lastBuffer)) || (this.rgB != paramObject.rgB) || (this.rgC != paramObject.rgC) || (this.rEJ != paramObject.rEJ)) {}
      }
    }
    else
    {
      AppMethodBeat.o(167051);
      return true;
    }
    AppMethodBeat.o(167051);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167049);
    String str = "Extra(pos=" + this.pos + ", lastBuffer=" + this.lastBuffer + ", upContinue=" + this.rgB + ", downContinue=" + this.rgC + ", hasExpand=" + this.rEJ + ")";
    AppMethodBeat.o(167049);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.e.b
 * JD-Core Version:    0.7.0.1
 */