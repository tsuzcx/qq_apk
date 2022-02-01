package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajy;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "", "type", "", "name", "", "page", "Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "read", "", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;Z)V", "getName", "()Ljava/lang/String;", "getPage", "()Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "setPage", "(Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;)V", "getRead", "()Z", "setRead", "(Z)V", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class a
{
  boolean kkr;
  final String name;
  public ajy rEA;
  final int type;
  
  private a(int paramInt, String paramString, ajy paramajy)
  {
    AppMethodBeat.i(203004);
    this.type = paramInt;
    this.name = paramString;
    this.rEA = paramajy;
    this.kkr = false;
    AppMethodBeat.o(203004);
  }
  
  public final void a(ajy paramajy)
  {
    AppMethodBeat.i(203003);
    k.h(paramajy, "<set-?>");
    this.rEA = paramajy;
    AppMethodBeat.o(203003);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203007);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.type != paramObject.type) || (!k.g(this.name, paramObject.name)) || (!k.g(this.rEA, paramObject.rEA)) || (this.kkr != paramObject.kkr)) {}
      }
    }
    else
    {
      AppMethodBeat.o(203007);
      return true;
    }
    AppMethodBeat.o(203007);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203005);
    String str = "CachePage(type=" + this.type + ", name=" + this.name + ", page=" + this.rEA + ", read=" + this.kkr + ")";
    AppMethodBeat.o(203005);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.a
 * JD-Core Version:    0.7.0.1
 */