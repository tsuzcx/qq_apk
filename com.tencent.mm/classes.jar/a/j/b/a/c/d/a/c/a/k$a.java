package a.j.b.a.c.d.a.c.a;

import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class k$a
{
  final List<ar> BWy;
  final boolean BZO;
  final w CaW;
  final w Ceg;
  final List<au> Ceh;
  final List<String> Cgu;
  
  public k$a(w paramw1, w paramw2, List<? extends au> paramList, List<? extends ar> paramList1, boolean paramBoolean, List<String> paramList2)
  {
    AppMethodBeat.i(119986);
    this.CaW = paramw1;
    this.Ceg = paramw2;
    this.Ceh = paramList;
    this.BWy = paramList1;
    this.BZO = paramBoolean;
    this.Cgu = paramList2;
    AppMethodBeat.o(119986);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119989);
    if (this != paramObject)
    {
      if (!(paramObject instanceof a)) {
        break label121;
      }
      paramObject = (a)paramObject;
      if ((!j.e(this.CaW, paramObject.CaW)) || (!j.e(this.Ceg, paramObject.Ceg)) || (!j.e(this.Ceh, paramObject.Ceh)) || (!j.e(this.BWy, paramObject.BWy))) {
        break label121;
      }
      if (this.BZO != paramObject.BZO) {
        break label116;
      }
    }
    label116:
    for (int i = 1; (i != 0) && (j.e(this.Cgu, paramObject.Cgu)); i = 0)
    {
      AppMethodBeat.o(119989);
      return true;
    }
    label121:
    AppMethodBeat.o(119989);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119987);
    String str = "MethodSignatureData(returnType=" + this.CaW + ", receiverType=" + this.Ceg + ", valueParameters=" + this.Ceh + ", typeParameters=" + this.BWy + ", hasStableParameterNames=" + this.BZO + ", errors=" + this.Cgu + ")";
    AppMethodBeat.o(119987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.k.a
 * JD-Core Version:    0.7.0.1
 */