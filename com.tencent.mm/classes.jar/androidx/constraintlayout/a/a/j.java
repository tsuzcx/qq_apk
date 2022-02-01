package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class j
  extends f
{
  protected int bht;
  protected f[] bko;
  
  public j()
  {
    AppMethodBeat.i(193958);
    this.bko = new f[4];
    this.bht = 0;
    AppMethodBeat.o(193958);
  }
  
  public final void Dd()
  {
    this.bht = 0;
  }
  
  public final void e(f paramf)
  {
    AppMethodBeat.i(193969);
    if (this.bht + 1 > this.bko.length) {
      this.bko = ((f[])Arrays.copyOf(this.bko, this.bko.length * 2));
    }
    this.bko[this.bht] = paramf;
    this.bht += 1;
    AppMethodBeat.o(193969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.j
 * JD-Core Version:    0.7.0.1
 */