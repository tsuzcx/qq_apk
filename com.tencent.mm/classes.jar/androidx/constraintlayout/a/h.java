package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class h
{
  private static int AH = 1;
  private static int AI = 1;
  private static int AJ = 1;
  private static int AK = 1;
  private static int AL = 1;
  int AM;
  public int AN;
  public float AO;
  float[] AP;
  a AQ;
  b[] AR;
  int AS;
  public int AT;
  public int id;
  private String mName;
  
  public h(a parama)
  {
    AppMethodBeat.i(229852);
    this.id = -1;
    this.AM = -1;
    this.AN = 0;
    this.AP = new float[7];
    this.AR = new b[8];
    this.AS = 0;
    this.AT = 0;
    this.AQ = parama;
    AppMethodBeat.o(229852);
  }
  
  static void fp()
  {
    AI += 1;
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(229854);
    int i = 0;
    while (i < this.AS)
    {
      if (this.AR[i] == paramb)
      {
        AppMethodBeat.o(229854);
        return;
      }
      i += 1;
    }
    if (this.AS >= this.AR.length) {
      this.AR = ((b[])Arrays.copyOf(this.AR, this.AR.length * 2));
    }
    this.AR[this.AS] = paramb;
    this.AS += 1;
    AppMethodBeat.o(229854);
  }
  
  public final void e(b paramb)
  {
    int j = 0;
    int k = this.AS;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        if (this.AR[i] == paramb)
        {
          while (j < k - i - 1)
          {
            this.AR[(i + j)] = this.AR[(i + j + 1)];
            j += 1;
          }
          this.AS -= 1;
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public final void f(b paramb)
  {
    AppMethodBeat.i(229857);
    int j = this.AS;
    int i = 0;
    while (i < j)
    {
      this.AR[i].Am.a(this.AR[i], paramb);
      i += 1;
    }
    this.AS = 0;
    AppMethodBeat.o(229857);
  }
  
  public final void reset()
  {
    this.mName = null;
    this.AQ = a.AY;
    this.AN = 0;
    this.id = -1;
    this.AM = -1;
    this.AO = 0.0F;
    this.AS = 0;
    this.AT = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229858);
    String str = "" + this.mName;
    AppMethodBeat.o(229858);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(229918);
      AU = new a("UNRESTRICTED", 0);
      AV = new a("CONSTANT", 1);
      AW = new a("SLACK", 2);
      AX = new a("ERROR", 3);
      AY = new a("UNKNOWN", 4);
      AZ = new a[] { AU, AV, AW, AX, AY };
      AppMethodBeat.o(229918);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.h
 * JD-Core Version:    0.7.0.1
 */