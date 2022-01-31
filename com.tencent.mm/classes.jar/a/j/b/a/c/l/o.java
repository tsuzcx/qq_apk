package a.j.b.a.c.l;

import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class o
  extends ad
{
  private final List<ap> BWD;
  private final an CBb;
  private final h Caq;
  private final boolean Cwx;
  
  public o(an paraman, h paramh, byte paramByte)
  {
    this(paraman, paramh);
  }
  
  public o(an paraman, h paramh, List<? extends ap> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(122536);
    this.CBb = paraman;
    this.Caq = paramh;
    this.BWD = paramList;
    this.Cwx = paramBoolean;
    AppMethodBeat.o(122536);
  }
  
  public final ad d(g paramg)
  {
    AppMethodBeat.i(122532);
    a.f.b.j.q(paramg, "newAnnotations");
    paramg = (ad)this;
    AppMethodBeat.o(122532);
    return paramg;
  }
  
  public final g ecM()
  {
    AppMethodBeat.i(122530);
    Object localObject = g.BXx;
    localObject = g.a.eeH();
    AppMethodBeat.o(122530);
    return localObject;
  }
  
  public final h ecq()
  {
    return this.Caq;
  }
  
  public final boolean egH()
  {
    return this.Cwx;
  }
  
  public final List<ap> enR()
  {
    return this.BWD;
  }
  
  public final an enU()
  {
    return this.CBb;
  }
  
  public ad ss(boolean paramBoolean)
  {
    AppMethodBeat.i(122534);
    ad localad = (ad)new o(this.CBb, this.Caq, this.BWD, paramBoolean);
    AppMethodBeat.o(122534);
    return localad;
  }
  
  public String toString()
  {
    AppMethodBeat.i(122531);
    StringBuilder localStringBuilder = new StringBuilder().append(this.CBb.toString());
    if (this.BWD.isEmpty()) {}
    for (String str = "";; str = a.a.j.a((Iterable)this.BWD, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(122531);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.l.o
 * JD-Core Version:    0.7.0.1
 */