package a.j.b.a.c.d.a.f;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public final g ChD;
  public final boolean ChE;
  
  public h(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(120109);
    this.ChD = paramg;
    this.ChE = paramBoolean;
    AppMethodBeat.o(120109);
  }
  
  private static h a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(120110);
    j.q(paramg, "qualifier");
    paramg = new h(paramg, paramBoolean);
    AppMethodBeat.o(120110);
    return paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(120114);
    if (this != paramObject)
    {
      if (!(paramObject instanceof h)) {
        break label65;
      }
      paramObject = (h)paramObject;
      if (!j.e(this.ChD, paramObject.ChD)) {
        break label65;
      }
      if (this.ChE != paramObject.ChE) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(120114);
      return true;
    }
    label65:
    AppMethodBeat.o(120114);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120112);
    String str = "NullabilityQualifierWithMigrationStatus(qualifier=" + this.ChD + ", isForWarningOnly=" + this.ChE + ")";
    AppMethodBeat.o(120112);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.h
 * JD-Core Version:    0.7.0.1
 */