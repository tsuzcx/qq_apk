package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class q
  extends f
{
  protected ArrayList<f> Ew;
  
  public q()
  {
    AppMethodBeat.i(229715);
    this.Ew = new ArrayList();
    AppMethodBeat.o(229715);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(229724);
    super.a(paramc);
    int j = this.Ew.size();
    int i = 0;
    while (i < j)
    {
      ((f)this.Ew.get(i)).a(paramc);
      i += 1;
    }
    AppMethodBeat.o(229724);
  }
  
  public final void e(f paramf)
  {
    AppMethodBeat.i(229717);
    this.Ew.add(paramf);
    if (paramf.CA != null) {
      ((q)paramf.CA).f(paramf);
    }
    paramf.CA = this;
    AppMethodBeat.o(229717);
  }
  
  public final void f(f paramf)
  {
    AppMethodBeat.i(229718);
    this.Ew.remove(paramf);
    paramf.CA = null;
    AppMethodBeat.o(229718);
  }
  
  public final void fK()
  {
    AppMethodBeat.i(229721);
    super.fK();
    if (this.Ew == null)
    {
      AppMethodBeat.o(229721);
      return;
    }
    int j = this.Ew.size();
    int i = 0;
    while (i < j)
    {
      f localf = (f)this.Ew.get(i);
      localf.v(fC(), fD());
      if (!(localf instanceof g)) {
        localf.fK();
      }
      i += 1;
    }
    AppMethodBeat.o(229721);
  }
  
  public void fP()
  {
    AppMethodBeat.i(229723);
    fK();
    if (this.Ew == null)
    {
      AppMethodBeat.o(229723);
      return;
    }
    int j = this.Ew.size();
    int i = 0;
    while (i < j)
    {
      f localf = (f)this.Ew.get(i);
      if ((localf instanceof q)) {
        ((q)localf).fP();
      }
      i += 1;
    }
    AppMethodBeat.o(229723);
  }
  
  public final void fX()
  {
    AppMethodBeat.i(229726);
    this.Ew.clear();
    AppMethodBeat.o(229726);
  }
  
  public void reset()
  {
    AppMethodBeat.i(229716);
    this.Ew.clear();
    super.reset();
    AppMethodBeat.o(229716);
  }
  
  public final void v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229719);
    super.v(paramInt1, paramInt2);
    paramInt2 = this.Ew.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((f)this.Ew.get(paramInt1)).v(fE(), fF());
      paramInt1 += 1;
    }
    AppMethodBeat.o(229719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.q
 * JD-Core Version:    0.7.0.1
 */