package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amw;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "", "type", "", "name", "", "page", "Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "read", "", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;Z)V", "getName", "()Ljava/lang/String;", "getPage", "()Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;", "setPage", "(Lcom/tencent/mm/protocal/protobuf/FinderFirstPage;)V", "getRead", "()Z", "setRead", "(Z)V", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class a
{
  boolean kFr;
  final String name;
  public amw szD;
  final int type;
  
  private a(int paramInt, String paramString, amw paramamw)
  {
    AppMethodBeat.i(203781);
    this.type = paramInt;
    this.name = paramString;
    this.szD = paramamw;
    this.kFr = false;
    AppMethodBeat.o(203781);
  }
  
  public final void a(amw paramamw)
  {
    AppMethodBeat.i(203780);
    p.h(paramamw, "<set-?>");
    this.szD = paramamw;
    AppMethodBeat.o(203780);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203784);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.type != paramObject.type) || (!p.i(this.name, paramObject.name)) || (!p.i(this.szD, paramObject.szD)) || (this.kFr != paramObject.kFr)) {}
      }
    }
    else
    {
      AppMethodBeat.o(203784);
      return true;
    }
    AppMethodBeat.o(203784);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203782);
    String str = "CachePage(type=" + this.type + ", name=" + this.name + ", page=" + this.szD + ", read=" + this.kFr + ")";
    AppMethodBeat.o(203782);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.a
 * JD-Core Version:    0.7.0.1
 */