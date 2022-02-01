package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class j
  extends f
{
  protected int Bl;
  protected f[] Eg;
  
  public j()
  {
    AppMethodBeat.i(229810);
    this.Eg = new f[4];
    this.Bl = 0;
    AppMethodBeat.o(229810);
  }
  
  public final void e(f paramf)
  {
    AppMethodBeat.i(229814);
    if (this.Bl + 1 > this.Eg.length) {
      this.Eg = ((f[])Arrays.copyOf(this.Eg, this.Eg.length * 2));
    }
    this.Eg[this.Bl] = paramf;
    this.Bl += 1;
    AppMethodBeat.o(229814);
  }
  
  public final void fU()
  {
    this.Bl = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.j
 * JD-Core Version:    0.7.0.1
 */