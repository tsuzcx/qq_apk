package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements e.a
{
  h Aj;
  public float Ak;
  boolean Al;
  public final a Am;
  public boolean An;
  
  public b(c paramc)
  {
    AppMethodBeat.i(229820);
    this.Aj = null;
    this.Ak = 0.0F;
    this.Al = false;
    this.An = false;
    this.Am = new a(this, paramc);
    AppMethodBeat.o(229820);
  }
  
  public final b a(e parame, int paramInt)
  {
    AppMethodBeat.i(229834);
    this.Am.a(parame.aT(paramInt), 1.0F);
    this.Am.a(parame.aT(paramInt), -1.0F);
    AppMethodBeat.o(229834);
    return this;
  }
  
  public final b a(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    AppMethodBeat.i(229829);
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
      this.Ak = j;
    }
    if (i == 0)
    {
      this.Am.a(paramh1, -1.0F);
      this.Am.a(paramh2, 1.0F);
      this.Am.a(paramh3, 1.0F);
    }
    for (;;)
    {
      AppMethodBeat.o(229829);
      return this;
      this.Am.a(paramh1, 1.0F);
      this.Am.a(paramh2, -1.0F);
      this.Am.a(paramh3, -1.0F);
    }
  }
  
  public final b a(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    AppMethodBeat.i(229836);
    this.Am.a(paramh1, -1.0F);
    this.Am.a(paramh2, 1.0F);
    this.Am.a(paramh3, paramFloat);
    this.Am.a(paramh4, -paramFloat);
    AppMethodBeat.o(229836);
    return this;
  }
  
  public final h a(boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(229842);
    paramArrayOfBoolean = this.Am.a(paramArrayOfBoolean, null);
    AppMethodBeat.o(229842);
    return paramArrayOfBoolean;
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(229845);
    if ((parama instanceof b))
    {
      parama = (b)parama;
      this.Aj = null;
      this.Am.clear();
      int i = 0;
      while (i < parama.Am.zY)
      {
        h localh = parama.Am.aR(i);
        float f = parama.Am.aS(i);
        this.Am.a(localh, f, true);
        i += 1;
      }
    }
    AppMethodBeat.o(229845);
  }
  
  public final b b(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    AppMethodBeat.i(229833);
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
      this.Ak = j;
    }
    if (i == 0)
    {
      this.Am.a(paramh1, -1.0F);
      this.Am.a(paramh2, 1.0F);
      this.Am.a(paramh3, -1.0F);
    }
    for (;;)
    {
      AppMethodBeat.o(229833);
      return this;
      this.Am.a(paramh1, 1.0F);
      this.Am.a(paramh2, -1.0F);
      this.Am.a(paramh3, 1.0F);
    }
  }
  
  public final b b(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    AppMethodBeat.i(229837);
    this.Am.a(paramh3, 0.5F);
    this.Am.a(paramh4, 0.5F);
    this.Am.a(paramh1, -0.5F);
    this.Am.a(paramh2, -0.5F);
    this.Ak = (-paramFloat);
    AppMethodBeat.o(229837);
    return this;
  }
  
  final boolean c(h paramh)
  {
    boolean bool2 = false;
    a locala = this.Am;
    boolean bool1 = bool2;
    int j;
    int i;
    if (locala.Ag != -1)
    {
      j = locala.Ag;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (j != -1)
      {
        bool1 = bool2;
        if (i < locala.zY)
        {
          if (locala.Ad[j] != paramh.id) {
            break label72;
          }
          bool1 = true;
        }
      }
      return bool1;
      label72:
      j = locala.Ae[j];
      i += 1;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(229844);
    this.Am.clear();
    this.Aj = null;
    this.Ak = 0.0F;
    AppMethodBeat.o(229844);
  }
  
  final void d(h paramh)
  {
    AppMethodBeat.i(229840);
    if (this.Aj != null)
    {
      this.Am.a(this.Aj, -1.0F);
      this.Aj = null;
    }
    float f = -1.0F * this.Am.a(paramh, true);
    this.Aj = paramh;
    if (f == 1.0F)
    {
      AppMethodBeat.o(229840);
      return;
    }
    this.Ak /= f;
    paramh = this.Am;
    int j = paramh.Ag;
    int i = 0;
    while ((j != -1) && (i < paramh.zY))
    {
      float[] arrayOfFloat = paramh.Af;
      arrayOfFloat[j] /= f;
      j = paramh.Ae[j];
      i += 1;
    }
    AppMethodBeat.o(229840);
  }
  
  public void e(h paramh)
  {
    float f = 1.0F;
    AppMethodBeat.i(229846);
    if (paramh.AN == 1) {}
    for (;;)
    {
      this.Am.a(paramh, f);
      AppMethodBeat.o(229846);
      return;
      if (paramh.AN == 2) {
        f = 1000.0F;
      } else if (paramh.AN == 3) {
        f = 1000000.0F;
      } else if (paramh.AN == 4) {
        f = 1.0E+009F;
      } else if (paramh.AN == 5) {
        f = 1.0E+012F;
      }
    }
  }
  
  public final h fh()
  {
    return this.Aj;
  }
  
  public String toString()
  {
    AppMethodBeat.i(229824);
    String str;
    if (this.Aj == null)
    {
      str = "" + "0";
      str = str + " = ";
      if (this.Ak == 0.0F) {
        break label385;
      }
      str = str + this.Ak;
    }
    label385:
    for (int i = 1;; i = 0)
    {
      int k = this.Am.zY;
      int j = 0;
      label102:
      Object localObject;
      float f;
      if (j < k)
      {
        localObject = this.Am.aR(j);
        if (localObject == null) {
          break label382;
        }
        f = this.Am.aS(j);
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
        str = "" + this.Aj;
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
        AppMethodBeat.o(229824);
        return localObject;
        break label182;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.b
 * JD-Core Version:    0.7.0.1
 */