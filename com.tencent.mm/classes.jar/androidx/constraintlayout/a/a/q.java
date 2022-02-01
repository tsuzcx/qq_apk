package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class q
  extends f
{
  protected ArrayList<f> bkE;
  
  public q()
  {
    AppMethodBeat.i(194054);
    this.bkE = new ArrayList();
    AppMethodBeat.o(194054);
  }
  
  public final void CT()
  {
    AppMethodBeat.i(194090);
    super.CT();
    if (this.bkE == null)
    {
      AppMethodBeat.o(194090);
      return;
    }
    int j = this.bkE.size();
    int i = 0;
    while (i < j)
    {
      f localf = (f)this.bkE.get(i);
      localf.ap(CL(), CM());
      if (!(localf instanceof g)) {
        localf.CT();
      }
      i += 1;
    }
    AppMethodBeat.o(194090);
  }
  
  public void CY()
  {
    AppMethodBeat.i(194098);
    CT();
    if (this.bkE == null)
    {
      AppMethodBeat.o(194098);
      return;
    }
    int j = this.bkE.size();
    int i = 0;
    while (i < j)
    {
      f localf = (f)this.bkE.get(i);
      if ((localf instanceof q)) {
        ((q)localf).CY();
      }
      i += 1;
    }
    AppMethodBeat.o(194098);
  }
  
  public final void Dg()
  {
    AppMethodBeat.i(194120);
    this.bkE.clear();
    AppMethodBeat.o(194120);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(194105);
    super.a(paramc);
    int j = this.bkE.size();
    int i = 0;
    while (i < j)
    {
      ((f)this.bkE.get(i)).a(paramc);
      i += 1;
    }
    AppMethodBeat.o(194105);
  }
  
  public final void ap(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194082);
    super.ap(paramInt1, paramInt2);
    paramInt2 = this.bkE.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((f)this.bkE.get(paramInt1)).ap(CN(), CO());
      paramInt1 += 1;
    }
    AppMethodBeat.o(194082);
  }
  
  public final void e(f paramf)
  {
    AppMethodBeat.i(194068);
    this.bkE.add(paramf);
    if (paramf.biI != null) {
      ((q)paramf.biI).f(paramf);
    }
    paramf.biI = this;
    AppMethodBeat.o(194068);
  }
  
  public final void f(f paramf)
  {
    AppMethodBeat.i(194076);
    this.bkE.remove(paramf);
    paramf.biI = null;
    AppMethodBeat.o(194076);
  }
  
  public void reset()
  {
    AppMethodBeat.i(194063);
    this.bkE.clear();
    super.reset();
    AppMethodBeat.o(194063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.q
 * JD-Core Version:    0.7.0.1
 */