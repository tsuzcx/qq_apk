package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.ContextMenu.ContextMenuInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/RawFunctionName2Show;", "Landroid/view/ContextMenu$ContextMenuInfo;", "line1", "", "line2", "needEllipsize", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "functionName2Show", "getFunctionName2Show", "()Ljava/lang/String;", "getLine1", "getLine2", "getNeedEllipsize", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
final class l
  implements ContextMenu.ContextMenuInfo
{
  final String line1;
  final String line2;
  final String nll;
  final boolean nlm;
  
  public l(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(229129);
    this.line1 = paramString1;
    this.line2 = paramString2;
    this.nlm = paramBoolean;
    if (this.line2 == null) {}
    for (paramString1 = this.line1;; paramString1 = this.line1 + "\n" + this.line2)
    {
      this.nll = paramString1;
      AppMethodBeat.o(229129);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229133);
    if (this != paramObject)
    {
      if ((paramObject instanceof l))
      {
        paramObject = (l)paramObject;
        if ((!p.j(this.line1, paramObject.line1)) || (!p.j(this.line2, paramObject.line2)) || (this.nlm != paramObject.nlm)) {}
      }
    }
    else
    {
      AppMethodBeat.o(229133);
      return true;
    }
    AppMethodBeat.o(229133);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229131);
    String str = "RawFunctionName2Show(line1=" + this.line1 + ", line2=" + this.line2 + ", needEllipsize=" + this.nlm + ")";
    AppMethodBeat.o(229131);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.l
 * JD-Core Version:    0.7.0.1
 */