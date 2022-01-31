package a.j.b.a.c.n;

import a.a.ad;
import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e
{
  public static final e CET;
  public static final e CEU;
  public static final e CEV;
  public static final e.a CEW;
  private final f CEO;
  public final g CEP;
  public final g CEQ;
  public final Map<String, g> CER;
  public final boolean CES;
  
  static
  {
    AppMethodBeat.i(122935);
    eOJ = new k[] { (k)v.a(new t(v.aG(e.class), "description", "getDescription()[Ljava/lang/String;")) };
    CEW = new e.a((byte)0);
    CET = new e(g.CFa, null, ad.emptyMap(), (byte)0);
    g localg = g.CEZ;
    CEU = new e(localg, localg, ad.emptyMap(), (byte)0);
    localg = g.CFb;
    CEV = new e(localg, localg, ad.emptyMap(), (byte)0);
    AppMethodBeat.o(122935);
  }
  
  private e(g paramg1, g paramg2, Map<String, ? extends g> paramMap)
  {
    AppMethodBeat.i(122936);
    this.CEP = paramg1;
    this.CEQ = paramg2;
    this.CER = paramMap;
    this.CES = true;
    this.CEO = a.g.j((a)new e.b(this));
    AppMethodBeat.o(122936);
  }
  
  public final boolean eoV()
  {
    return (e)this == CEU;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122939);
    if (this != paramObject)
    {
      if (!(paramObject instanceof e)) {
        break label93;
      }
      paramObject = (e)paramObject;
      if ((!j.e(this.CEP, paramObject.CEP)) || (!j.e(this.CEQ, paramObject.CEQ)) || (!j.e(this.CER, paramObject.CER))) {
        break label93;
      }
      if (this.CES != paramObject.CES) {
        break label88;
      }
    }
    label88:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(122939);
      return true;
    }
    label93:
    AppMethodBeat.o(122939);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122937);
    String str = "Jsr305State(global=" + this.CEP + ", migration=" + this.CEQ + ", user=" + this.CER + ", enableCompatqualCheckerFrameworkAnnotations=" + this.CES + ")";
    AppMethodBeat.o(122937);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.n.e
 * JD-Core Version:    0.7.0.1
 */