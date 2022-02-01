package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class h
{
  private static int bgP = 1;
  private static int bgQ = 1;
  private static int bgR = 1;
  private static int bgS = 1;
  private static int bgT = 1;
  int bgU;
  public int bgV;
  public float bgW;
  float[] bgX;
  a bgY;
  b[] bgZ;
  int bha;
  public int bhb;
  public int id;
  private String mName;
  
  public h(a parama)
  {
    AppMethodBeat.i(193944);
    this.id = -1;
    this.bgU = -1;
    this.bgV = 0;
    this.bgX = new float[7];
    this.bgZ = new b[8];
    this.bha = 0;
    this.bhb = 0;
    this.bgY = parama;
    AppMethodBeat.o(193944);
  }
  
  static void Cy()
  {
    bgQ += 1;
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(193956);
    int i = 0;
    while (i < this.bha)
    {
      if (this.bgZ[i] == paramb)
      {
        AppMethodBeat.o(193956);
        return;
      }
      i += 1;
    }
    if (this.bha >= this.bgZ.length) {
      this.bgZ = ((b[])Arrays.copyOf(this.bgZ, this.bgZ.length * 2));
    }
    this.bgZ[this.bha] = paramb;
    this.bha += 1;
    AppMethodBeat.o(193956);
  }
  
  public final void e(b paramb)
  {
    int j = 0;
    int k = this.bha;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        if (this.bgZ[i] == paramb)
        {
          while (j < k - i - 1)
          {
            this.bgZ[(i + j)] = this.bgZ[(i + j + 1)];
            j += 1;
          }
          this.bha -= 1;
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
    AppMethodBeat.i(193974);
    int j = this.bha;
    int i = 0;
    while (i < j)
    {
      this.bgZ[i].bgu.a(this.bgZ[i], paramb);
      i += 1;
    }
    this.bha = 0;
    AppMethodBeat.o(193974);
  }
  
  public final void reset()
  {
    this.mName = null;
    this.bgY = a.bhg;
    this.bgV = 0;
    this.id = -1;
    this.bgU = -1;
    this.bgW = 0.0F;
    this.bha = 0;
    this.bhb = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193990);
    String str = "" + this.mName;
    AppMethodBeat.o(193990);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(193981);
      bhc = new a("UNRESTRICTED", 0);
      bhd = new a("CONSTANT", 1);
      bhe = new a("SLACK", 2);
      bhf = new a("ERROR", 3);
      bhg = new a("UNKNOWN", 4);
      bhh = new a[] { bhc, bhd, bhe, bhf, bhg };
      AppMethodBeat.o(193981);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.h
 * JD-Core Version:    0.7.0.1
 */