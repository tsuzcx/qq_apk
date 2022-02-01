package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.ContextMenu.ContextMenuInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/RawFunctionName2Show;", "Landroid/view/ContextMenu$ContextMenuInfo;", "line1", "", "line2", "needEllipsize", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "functionName2Show", "getFunctionName2Show", "()Ljava/lang/String;", "getLine1", "getLine2", "getNeedEllipsize", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class m
  implements ContextMenu.ContextMenuInfo
{
  final String trB;
  final String trC;
  final boolean trD;
  final String trE;
  
  public m(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(323509);
    this.trB = paramString1;
    this.trC = paramString2;
    this.trD = paramBoolean;
    if (this.trC == null) {}
    for (paramString1 = this.trB;; paramString1 = this.trB + '\n' + this.trC)
    {
      this.trE = paramString1;
      AppMethodBeat.o(323509);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(323528);
    if (this == paramObject)
    {
      AppMethodBeat.o(323528);
      return true;
    }
    if (!(paramObject instanceof m))
    {
      AppMethodBeat.o(323528);
      return false;
    }
    paramObject = (m)paramObject;
    if (!s.p(this.trB, paramObject.trB))
    {
      AppMethodBeat.o(323528);
      return false;
    }
    if (!s.p(this.trC, paramObject.trC))
    {
      AppMethodBeat.o(323528);
      return false;
    }
    if (this.trD != paramObject.trD)
    {
      AppMethodBeat.o(323528);
      return false;
    }
    AppMethodBeat.o(323528);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(323514);
    String str = "RawFunctionName2Show(line1=" + this.trB + ", line2=" + this.trC + ", needEllipsize=" + this.trD + ')';
    AppMethodBeat.o(323514);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.m
 * JD-Core Version:    0.7.0.1
 */