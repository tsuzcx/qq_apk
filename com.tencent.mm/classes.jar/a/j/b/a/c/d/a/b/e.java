package a.j.b.a.c.d.a.b;

import a.f.b.j;
import a.j.b.a.c.b.a.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.ad;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import a.j.b.a.c.f.f;
import a.j.b.a.c.m.a;
import a.j.b.a.c.m.c;
import a.j.b.a.c.m.c.a;
import a.j.b.a.c.m.c.b;
import a.j.b.a.c.m.c.c;
import a.j.b.a.c.m.d;
import a.j.b.a.c.m.i;
import a.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
  extends ad
  implements b
{
  public static final a.a<au> Ceo;
  private e.a Cep = null;
  
  static
  {
    AppMethodBeat.i(119805);
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Ceo = new e.1();
      AppMethodBeat.o(119805);
      return;
    }
  }
  
  private e(l paraml, al paramal, g paramg, f paramf, b.a parama, am paramam)
  {
    super(paraml, paramal, paramg, paramf, parama, paramam);
  }
  
  public static e a(l paraml, g paramg, f paramf, am paramam)
  {
    AppMethodBeat.i(119798);
    paraml = new e(paraml, null, paramg, paramf, b.a.BVX, paramam);
    AppMethodBeat.o(119798);
    return paraml;
  }
  
  public final ad a(ak paramak1, ak paramak2, List<? extends ar> paramList, List<au> paramList1, a.j.b.a.c.l.w paramw, a.j.b.a.c.b.w paramw1, az paramaz, Map<? extends a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(119799);
    paramak2 = super.a(paramak1, paramak2, paramList, paramList1, paramw, paramw1, paramaz, paramMap);
    paramak1 = i.CDy;
    j.q(paramak2, "functionDescriptor");
    paramList = paramak1.eoR().iterator();
    int i;
    if (paramList.hasNext())
    {
      paramak1 = (d)paramList.next();
      j.q(paramak2, "functionDescriptor");
      if ((paramak1.BYN != null) && ((j.e(paramak2.edF(), paramak1.BYN) ^ true)))
      {
        i = 0;
        label96:
        if (i == 0) {
          break label256;
        }
        j.q(paramak2, "functionDescriptor");
        paramList = paramak1.CDo;
        int j = paramList.length;
        i = 0;
        label119:
        if (i >= j) {
          break label267;
        }
        paramList1 = paramList[i].i(paramak2);
        if (paramList1 == null) {
          break label258;
        }
        paramak1 = (c)new c.b(paramList1);
      }
    }
    for (;;)
    {
      this.BZF = paramak1.csk;
      AppMethodBeat.o(119799);
      return paramak2;
      if (paramak1.CDl != null)
      {
        paramList1 = paramak2.edF().name;
        j.p(paramList1, "functionDescriptor.name.asString()");
        paramList1 = (CharSequence)paramList1;
        if (!paramak1.CDl.ao(paramList1))
        {
          i = 0;
          break label96;
        }
      }
      if ((paramak1.CDm != null) && (!paramak1.CDm.contains(paramak2.edF())))
      {
        i = 0;
        break label96;
      }
      i = 1;
      break label96;
      label256:
      break;
      label258:
      i += 1;
      break label119;
      label267:
      paramak1 = (String)paramak1.CDn.S(paramak2);
      if (paramak1 != null)
      {
        paramak1 = (c)new c.b(paramak1);
      }
      else
      {
        paramak1 = (c)c.c.CDk;
        continue;
        paramak1 = (c)c.a.CDj;
      }
    }
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(119802);
    this.Cep = e.a.ar(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(119802);
  }
  
  public final boolean edv()
  {
    AppMethodBeat.i(119801);
    if ((!$assertionsDisabled) && (this.Cep == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(119801);
      throw localAssertionError;
    }
    boolean bool = this.Cep.Cev;
    AppMethodBeat.o(119801);
    return bool;
  }
  
  public final boolean eeV()
  {
    AppMethodBeat.i(119800);
    if ((!$assertionsDisabled) && (this.Cep == null))
    {
      AssertionError localAssertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(119800);
      throw localAssertionError;
    }
    boolean bool = this.Cep.Ceu;
    AppMethodBeat.o(119800);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */