package com.tencent.mm.plugin.finder.live.view.adapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/EditData;", "", "productInfo", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "select", "", "(Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;Z)V", "getProductInfo", "()Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "getSelect", "()Z", "setSelect", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public boolean CIw;
  public final k DPG;
  
  private a(k paramk)
  {
    AppMethodBeat.i(358529);
    this.DPG = paramk;
    this.CIw = false;
    AppMethodBeat.o(358529);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(358564);
    if (this == paramObject)
    {
      AppMethodBeat.o(358564);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(358564);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.DPG, paramObject.DPG))
    {
      AppMethodBeat.o(358564);
      return false;
    }
    if (this.CIw != paramObject.CIw)
    {
      AppMethodBeat.o(358564);
      return false;
    }
    AppMethodBeat.o(358564);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(358543);
    String str = "EditData(productInfo=" + this.DPG + ", select=" + this.CIw + ')';
    AppMethodBeat.o(358543);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.a
 * JD-Core Version:    0.7.0.1
 */