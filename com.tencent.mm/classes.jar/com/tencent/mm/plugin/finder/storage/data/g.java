package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aim;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "", "type", "", "name", "", "page", "Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "read", "", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;Z)V", "getName", "()Ljava/lang/String;", "getPage", "()Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "setPage", "(Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;)V", "getRead", "()Z", "setRead", "(Z)V", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class g
{
  public aim KXo;
  boolean jJR;
  final String name;
  final int type;
  
  private g(int paramInt, String paramString, aim paramaim)
  {
    AppMethodBeat.i(199040);
    this.type = paramInt;
    this.name = paramString;
    this.KXo = paramaim;
    this.jJR = false;
    AppMethodBeat.o(199040);
  }
  
  public final void a(aim paramaim)
  {
    AppMethodBeat.i(199039);
    k.h(paramaim, "<set-?>");
    this.KXo = paramaim;
    AppMethodBeat.o(199039);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199043);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((this.type != paramObject.type) || (!k.g(this.name, paramObject.name)) || (!k.g(this.KXo, paramObject.KXo)) || (this.jJR != paramObject.jJR)) {}
      }
    }
    else
    {
      AppMethodBeat.o(199043);
      return true;
    }
    AppMethodBeat.o(199043);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199041);
    String str = "CachePage(type=" + this.type + ", name=" + this.name + ", page=" + this.KXo + ", read=" + this.jJR + ")";
    AppMethodBeat.o(199041);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.g
 * JD-Core Version:    0.7.0.1
 */