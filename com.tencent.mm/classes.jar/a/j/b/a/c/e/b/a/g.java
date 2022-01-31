package a.j.b.a.c.e.b.a;

import a.f.b.j;
import a.j.b.a.c.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g
  extends a
{
  public static final g Cqi;
  public static final g Cqj;
  public static final g.a Cqk;
  private final boolean Cqh;
  
  static
  {
    AppMethodBeat.i(121321);
    Cqk = new g.a((byte)0);
    Cqi = new g(new int[] { 1, 1, 13 });
    Cqj = new g(new int[0]);
    AppMethodBeat.o(121321);
  }
  
  public g(int... paramVarArgs)
  {
    this(paramVarArgs, false);
    AppMethodBeat.i(121320);
    AppMethodBeat.o(121320);
  }
  
  public g(int[] paramArrayOfInt, boolean paramBoolean)
  {
    super(Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    AppMethodBeat.i(121319);
    this.Cqh = paramBoolean;
    AppMethodBeat.o(121319);
  }
  
  public final boolean elW()
  {
    AppMethodBeat.i(121318);
    if ((this.major != 1) || (this.minor != 0))
    {
      a locala;
      int i;
      if (this.Cqh)
      {
        locala = (a)Cqi;
        j.q(locala, "ourVersion");
        if (this.major == 0) {
          if ((locala.major == 0) && (this.minor == locala.minor)) {
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(121318);
        return true;
        i = 0;
        continue;
        if ((this.major == locala.major) && (this.minor <= locala.minor))
        {
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          if ((this.major == 1) && (this.minor <= 4)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
    AppMethodBeat.o(121318);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.g
 * JD-Core Version:    0.7.0.1
 */