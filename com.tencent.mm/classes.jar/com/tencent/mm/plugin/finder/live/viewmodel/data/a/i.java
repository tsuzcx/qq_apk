package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxRedDotInfo;", "", "hasRedDot", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(ZLcom/tencent/mm/protobuf/ByteString;)V", "getHasRedDot", "()Z", "setHasRedDot", "(Z)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public boolean PcF;
  public b lastBuffer;
  
  public i(boolean paramBoolean, b paramb)
  {
    this.PcF = paramBoolean;
    this.lastBuffer = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(371712);
    if (this == paramObject)
    {
      AppMethodBeat.o(371712);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(371712);
      return false;
    }
    paramObject = (i)paramObject;
    if (this.PcF != paramObject.PcF)
    {
      AppMethodBeat.o(371712);
      return false;
    }
    if (!s.p(this.lastBuffer, paramObject.lastBuffer))
    {
      AppMethodBeat.o(371712);
      return false;
    }
    AppMethodBeat.o(371712);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(371694);
    String str = "BoxRedDotInfo(hasRedDot=" + this.PcF + ", lastBuffer=" + this.lastBuffer + ')';
    AppMethodBeat.o(371694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.i
 * JD-Core Version:    0.7.0.1
 */