package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements e.a
{
  h bgr;
  public float bgs;
  boolean bgt;
  public final a bgu;
  public boolean bgv;
  
  public b(c paramc)
  {
    AppMethodBeat.i(193951);
    this.bgr = null;
    this.bgs = 0.0F;
    this.bgt = false;
    this.bgv = false;
    this.bgu = new a(this, paramc);
    AppMethodBeat.o(193951);
  }
  
  public final h Cr()
  {
    return this.bgr;
  }
  
  public final b a(e parame, int paramInt)
  {
    AppMethodBeat.i(194001);
    this.bgu.a(parame.dJ(paramInt), 1.0F);
    this.bgu.a(parame.dJ(paramInt), -1.0F);
    AppMethodBeat.o(194001);
    return this;
  }
  
  public final b a(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    AppMethodBeat.i(193984);
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.bgs = j;
    }
    if (i == 0)
    {
      this.bgu.a(paramh1, -1.0F);
      this.bgu.a(paramh2, 1.0F);
      this.bgu.a(paramh3, 1.0F);
    }
    for (;;)
    {
      AppMethodBeat.o(193984);
      return this;
      this.bgu.a(paramh1, 1.0F);
      this.bgu.a(paramh2, -1.0F);
      this.bgu.a(paramh3, -1.0F);
    }
  }
  
  public final b a(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    AppMethodBeat.i(194010);
    this.bgu.a(paramh1, -1.0F);
    this.bgu.a(paramh2, 1.0F);
    this.bgu.a(paramh3, paramFloat);
    this.bgu.a(paramh4, -paramFloat);
    AppMethodBeat.o(194010);
    return this;
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(194047);
    if ((parama instanceof b))
    {
      parama = (b)parama;
      this.bgr = null;
      this.bgu.clear();
      int i = 0;
      while (i < parama.bgu.bgg)
      {
        h localh = parama.bgu.dH(i);
        float f = parama.bgu.dI(i);
        this.bgu.a(localh, f, true);
        i += 1;
      }
    }
    AppMethodBeat.o(194047);
  }
  
  public final b b(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    AppMethodBeat.i(193992);
    int i = 0;
    int j = 0;
    if (paramInt != 0)
    {
      i = j;
      j = paramInt;
      if (paramInt < 0)
      {
        j = paramInt * -1;
        i = 1;
      }
      this.bgs = j;
    }
    if (i == 0)
    {
      this.bgu.a(paramh1, -1.0F);
      this.bgu.a(paramh2, 1.0F);
      this.bgu.a(paramh3, -1.0F);
    }
    for (;;)
    {
      AppMethodBeat.o(193992);
      return this;
      this.bgu.a(paramh1, 1.0F);
      this.bgu.a(paramh2, -1.0F);
      this.bgu.a(paramh3, 1.0F);
    }
  }
  
  public final b b(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    AppMethodBeat.i(194016);
    this.bgu.a(paramh3, 0.5F);
    this.bgu.a(paramh4, 0.5F);
    this.bgu.a(paramh1, -0.5F);
    this.bgu.a(paramh2, -0.5F);
    this.bgs = (-paramFloat);
    AppMethodBeat.o(194016);
    return this;
  }
  
  public final h b(boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(194031);
    paramArrayOfBoolean = this.bgu.a(paramArrayOfBoolean, null);
    AppMethodBeat.o(194031);
    return paramArrayOfBoolean;
  }
  
  final boolean c(h paramh)
  {
    boolean bool2 = false;
    a locala = this.bgu;
    boolean bool1 = bool2;
    int j;
    int i;
    if (locala.bgo != -1)
    {
      j = locala.bgo;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (j != -1)
      {
        bool1 = bool2;
        if (i < locala.bgg)
        {
          if (locala.bgl[j] != paramh.id) {
            break label72;
          }
          bool1 = true;
        }
      }
      return bool1;
      label72:
      j = locala.bgm[j];
      i += 1;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(194040);
    this.bgu.clear();
    this.bgr = null;
    this.bgs = 0.0F;
    AppMethodBeat.o(194040);
  }
  
  final void d(h paramh)
  {
    AppMethodBeat.i(194025);
    if (this.bgr != null)
    {
      this.bgu.a(this.bgr, -1.0F);
      this.bgr = null;
    }
    float f = -1.0F * this.bgu.a(paramh, true);
    this.bgr = paramh;
    if (f == 1.0F)
    {
      AppMethodBeat.o(194025);
      return;
    }
    this.bgs /= f;
    paramh = this.bgu;
    int j = paramh.bgo;
    int i = 0;
    while ((j != -1) && (i < paramh.bgg))
    {
      float[] arrayOfFloat = paramh.bgn;
      arrayOfFloat[j] /= f;
      j = paramh.bgm[j];
      i += 1;
    }
    AppMethodBeat.o(194025);
  }
  
  public void e(h paramh)
  {
    float f = 1.0F;
    AppMethodBeat.i(194058);
    if (paramh.bgV == 1) {}
    for (;;)
    {
      this.bgu.a(paramh, f);
      AppMethodBeat.o(194058);
      return;
      if (paramh.bgV == 2) {
        f = 1000.0F;
      } else if (paramh.bgV == 3) {
        f = 1000000.0F;
      } else if (paramh.bgV == 4) {
        f = 1.0E+009F;
      } else if (paramh.bgV == 5) {
        f = 1.0E+012F;
      }
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(193961);
    String str;
    if (this.bgr == null)
    {
      str = "" + "0";
      str = str + " = ";
      if (this.bgs == 0.0F) {
        break label385;
      }
      str = str + this.bgs;
    }
    label385:
    for (int i = 1;; i = 0)
    {
      int k = this.bgu.bgg;
      int j = 0;
      label102:
      Object localObject;
      float f;
      if (j < k)
      {
        localObject = this.bgu.dH(j);
        if (localObject == null) {
          break label382;
        }
        f = this.bgu.dI(j);
        if (f == 0.0F) {
          break label382;
        }
        localObject = ((h)localObject).toString();
        if (i == 0)
        {
          if (f >= 0.0F) {
            break label379;
          }
          str = str + "- ";
          f *= -1.0F;
          label182:
          if (f != 1.0F) {
            break label307;
          }
          str = str + (String)localObject;
          label210:
          i = 1;
        }
      }
      label307:
      label379:
      label382:
      for (;;)
      {
        j += 1;
        break label102;
        str = "" + this.bgr;
        break;
        if (f > 0.0F)
        {
          str = str + " + ";
          break label182;
        }
        str = str + " - ";
        f *= -1.0F;
        break label182;
        str = str + f + " " + (String)localObject;
        break label210;
        localObject = str;
        if (i == 0) {
          localObject = str + "0.0";
        }
        AppMethodBeat.o(193961);
        return localObject;
        break label182;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.b
 * JD-Core Version:    0.7.0.1
 */