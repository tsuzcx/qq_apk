package a.j.b.a.c.d.a.c.b;

import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.d.a.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  final l CgK;
  final b CgL;
  final boolean CgM;
  final ar CgN;
  
  private a(l paraml, b paramb, boolean paramBoolean, ar paramar)
  {
    AppMethodBeat.i(120023);
    this.CgK = paraml;
    this.CgL = paramb;
    this.CgM = paramBoolean;
    this.CgN = paramar;
    AppMethodBeat.o(120023);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(120022);
    j.q(paramb, "flexibility");
    l locall = this.CgK;
    boolean bool = this.CgM;
    ar localar = this.CgN;
    j.q(locall, "howThisTypeIsUsed");
    j.q(paramb, "flexibility");
    paramb = new a(locall, paramb, bool, localar);
    AppMethodBeat.o(120022);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(120027);
    if (this != paramObject)
    {
      if (!(paramObject instanceof a)) {
        break label93;
      }
      paramObject = (a)paramObject;
      if ((!j.e(this.CgK, paramObject.CgK)) || (!j.e(this.CgL, paramObject.CgL))) {
        break label93;
      }
      if (this.CgM != paramObject.CgM) {
        break label88;
      }
    }
    label88:
    for (int i = 1; (i != 0) && (j.e(this.CgN, paramObject.CgN)); i = 0)
    {
      AppMethodBeat.o(120027);
      return true;
    }
    label93:
    AppMethodBeat.o(120027);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120025);
    String str = "JavaTypeAttributes(howThisTypeIsUsed=" + this.CgK + ", flexibility=" + this.CgL + ", isForAnnotationParameter=" + this.CgM + ", upperBoundOfTypeParameter=" + this.CgN + ")";
    AppMethodBeat.o(120025);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */