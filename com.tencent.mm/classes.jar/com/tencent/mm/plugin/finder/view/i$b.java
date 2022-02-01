package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper$TopMemuConfig;", "", "isShowTopMenuItem", "", "topMemuItem", "Lcom/tencent/mm/ui/base/MMMenuItem;", "wxContactFirst", "(ZLcom/tencent/mm/ui/base/MMMenuItem;Z)V", "()Z", "setShowTopMenuItem", "(Z)V", "getTopMemuItem", "()Lcom/tencent/mm/ui/base/MMMenuItem;", "setTopMemuItem", "(Lcom/tencent/mm/ui/base/MMMenuItem;)V", "getWxContactFirst", "setWxContactFirst", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$b
{
  boolean akio;
  t akip;
  boolean akiq;
  
  public i$b(boolean paramBoolean1, t paramt, boolean paramBoolean2)
  {
    this.akio = paramBoolean1;
    this.akip = paramt;
    this.akiq = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(370613);
    if (this == paramObject)
    {
      AppMethodBeat.o(370613);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(370613);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.akio != paramObject.akio)
    {
      AppMethodBeat.o(370613);
      return false;
    }
    if (!s.p(this.akip, paramObject.akip))
    {
      AppMethodBeat.o(370613);
      return false;
    }
    if (this.akiq != paramObject.akiq)
    {
      AppMethodBeat.o(370613);
      return false;
    }
    AppMethodBeat.o(370613);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(370609);
    String str = "TopMemuConfig(isShowTopMenuItem=" + this.akio + ", topMemuItem=" + this.akip + ", wxContactFirst=" + this.akiq + ')';
    AppMethodBeat.o(370609);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.i.b
 * JD-Core Version:    0.7.0.1
 */