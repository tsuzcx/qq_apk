package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;

public final class e
{
  public static f AF;
  private static int Ar = 1000;
  public int AA;
  private int AB;
  private h[] AC;
  private int AD;
  private b[] AE;
  private final a AG;
  public final c Aa;
  int As;
  private HashMap<String, h> At;
  public a Au;
  private int Av;
  private int Aw;
  public b[] Ax;
  public boolean Ay;
  private boolean[] Az;
  int mNumColumns;
  
  public e()
  {
    AppMethodBeat.i(229924);
    this.As = 0;
    this.At = null;
    this.Av = 32;
    this.Aw = this.Av;
    this.Ax = null;
    this.Ay = false;
    this.Az = new boolean[this.Av];
    this.mNumColumns = 1;
    this.AA = 0;
    this.AB = this.Av;
    this.AC = new h[Ar];
    this.AD = 0;
    this.AE = new b[this.Av];
    this.Ax = new b[this.Av];
    fl();
    this.Aa = new c();
    this.Au = new d(this.Aa);
    this.AG = new b(this.Aa);
    AppMethodBeat.o(229924);
  }
  
  public static b a(e parame, h paramh1, h paramh2, h paramh3, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(230001);
    b localb = parame.fm();
    if (paramBoolean) {
      localb.a(parame, 0);
    }
    localb.Am.a(paramh1, -1.0F);
    localb.Am.a(paramh2, 1.0F - paramFloat);
    localb.Am.a(paramh3, paramFloat);
    AppMethodBeat.o(230001);
    return localb;
  }
  
  private h a(h.a parama)
  {
    AppMethodBeat.i(229952);
    Object localObject = (h)this.Aa.Ap.acquire();
    if (localObject == null)
    {
      localObject = new h(parama);
      ((h)localObject).AQ = parama;
    }
    for (parama = (h.a)localObject;; parama = (h.a)localObject)
    {
      if (this.AD >= Ar)
      {
        Ar *= 2;
        this.AC = ((h[])Arrays.copyOf(this.AC, Ar));
      }
      localObject = this.AC;
      int i = this.AD;
      this.AD = (i + 1);
      localObject[i] = parama;
      AppMethodBeat.o(229952);
      return parama;
      ((h)localObject).reset();
      ((h)localObject).AQ = parama;
    }
  }
  
  private final void a(b paramb)
  {
    AppMethodBeat.i(229958);
    if (this.AA > 0)
    {
      paramb.Am.a(paramb, this.Ax);
      if (paramb.Am.zY == 0) {
        paramb.An = true;
      }
    }
    AppMethodBeat.o(229958);
  }
  
  private final int c(a parama)
  {
    AppMethodBeat.i(229973);
    if (AF != null)
    {
      AppMethodBeat.o(229973);
      throw null;
    }
    int i = 0;
    b localb;
    h localh;
    int m;
    while (i < this.mNumColumns)
    {
      this.Az[i] = false;
      i += 1;
      continue;
      localb.d(localh);
      localb.Aj.AM = m;
      localb.Aj.f(localb);
    }
    for (;;)
    {
      if (j == 0)
      {
        if (AF != null)
        {
          AppMethodBeat.o(229973);
          throw null;
        }
        i += 1;
        if (i >= this.mNumColumns * 2)
        {
          AppMethodBeat.o(229973);
          return i;
        }
        if (parama.fh() != null) {
          this.Az[parama.fh().id] = true;
        }
        localh = parama.a(this.Az);
        if (localh != null)
        {
          if (this.Az[localh.id] != 0)
          {
            AppMethodBeat.o(229973);
            return i;
          }
          this.Az[localh.id] = true;
        }
        if (localh != null)
        {
          float f1 = 3.4028235E+38F;
          int k = 0;
          m = -1;
          while (k < this.AA)
          {
            localb = this.Ax[k];
            int n = m;
            float f2 = f1;
            if (localb.Aj.AQ != h.a.AU)
            {
              n = m;
              f2 = f1;
              if (!localb.An)
              {
                n = m;
                f2 = f1;
                if (localb.c(localh))
                {
                  float f3 = localb.Am.b(localh);
                  n = m;
                  f2 = f1;
                  if (f3 < 0.0F)
                  {
                    f3 = -localb.Ak / f3;
                    n = m;
                    f2 = f1;
                    if (f3 < f1)
                    {
                      n = k;
                      f2 = f3;
                    }
                  }
                }
              }
            }
            k += 1;
            m = n;
            f1 = f2;
          }
          if (m >= 0)
          {
            localb = this.Ax[m];
            localb.Aj.AM = -1;
            if (AF == null) {
              break;
            }
            AppMethodBeat.o(229973);
            throw null;
          }
          j = 1;
          continue;
        }
        j = 1;
        continue;
      }
      AppMethodBeat.o(229973);
      return i;
      i = 0;
      int j = 0;
    }
  }
  
  private final void c(b paramb)
  {
    AppMethodBeat.i(229968);
    if (this.Ax[this.AA] != null) {
      this.Aa.Ao.release(this.Ax[this.AA]);
    }
    this.Ax[this.AA] = paramb;
    paramb.Aj.AM = this.AA;
    this.AA += 1;
    paramb.Aj.f(paramb);
    AppMethodBeat.o(229968);
  }
  
  public static f fi()
  {
    return AF;
  }
  
  private void fj()
  {
    AppMethodBeat.i(229925);
    this.Av *= 2;
    this.Ax = ((b[])Arrays.copyOf(this.Ax, this.Av));
    this.Aa.Aq = ((h[])Arrays.copyOf(this.Aa.Aq, this.Av));
    this.Az = new boolean[this.Av];
    this.Aw = this.Av;
    this.AB = this.Av;
    if (AF != null)
    {
      AppMethodBeat.o(229925);
      throw null;
    }
    AppMethodBeat.o(229925);
  }
  
  private void fl()
  {
    AppMethodBeat.i(229927);
    int i = 0;
    while (i < this.Ax.length)
    {
      b localb = this.Ax[i];
      if (localb != null) {
        this.Aa.Ao.release(localb);
      }
      this.Ax[i] = null;
      i += 1;
    }
    AppMethodBeat.o(229927);
  }
  
  public static int t(Object paramObject)
  {
    paramObject = ((androidx.constraintlayout.a.a.e)paramObject).BB;
    if (paramObject != null) {
      return (int)(paramObject.AO + 0.5F);
    }
    return 0;
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229946);
    h localh = aT(paramInt2);
    paramb.Am.a(localh, paramInt1);
    AppMethodBeat.o(229946);
  }
  
  public final void a(h paramh, int paramInt)
  {
    AppMethodBeat.i(229998);
    int i = paramh.AM;
    if (paramh.AM != -1)
    {
      localb = this.Ax[i];
      if (localb.An)
      {
        localb.Ak = paramInt;
        AppMethodBeat.o(229998);
        return;
      }
      if (localb.Am.zY == 0)
      {
        localb.An = true;
        localb.Ak = paramInt;
        AppMethodBeat.o(229998);
        return;
      }
      localb = fm();
      if (paramInt < 0)
      {
        localb.Ak = (paramInt * -1);
        localb.Am.a(paramh, 1.0F);
      }
      for (;;)
      {
        b(localb);
        AppMethodBeat.o(229998);
        return;
        localb.Ak = paramInt;
        localb.Am.a(paramh, -1.0F);
      }
    }
    b localb = fm();
    localb.Aj = paramh;
    paramh.AO = paramInt;
    localb.Ak = paramInt;
    localb.An = true;
    b(localb);
    AppMethodBeat.o(229998);
  }
  
  public final void a(h paramh1, h paramh2, int paramInt1, float paramFloat, h paramh3, h paramh4, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229986);
    b localb = fm();
    if (paramh2 == paramh3)
    {
      localb.Am.a(paramh1, 1.0F);
      localb.Am.a(paramh4, 1.0F);
      localb.Am.a(paramh2, -2.0F);
    }
    for (;;)
    {
      if (paramInt3 != 6) {
        localb.a(this, paramInt3);
      }
      b(localb);
      AppMethodBeat.o(229986);
      return;
      if (paramFloat == 0.5F)
      {
        localb.Am.a(paramh1, 1.0F);
        localb.Am.a(paramh2, -1.0F);
        localb.Am.a(paramh3, -1.0F);
        localb.Am.a(paramh4, 1.0F);
        if ((paramInt1 > 0) || (paramInt2 > 0)) {
          localb.Ak = (-paramInt1 + paramInt2);
        }
      }
      else if (paramFloat <= 0.0F)
      {
        localb.Am.a(paramh1, -1.0F);
        localb.Am.a(paramh2, 1.0F);
        localb.Ak = paramInt1;
      }
      else if (paramFloat >= 1.0F)
      {
        localb.Am.a(paramh3, -1.0F);
        localb.Am.a(paramh4, 1.0F);
        localb.Ak = paramInt2;
      }
      else
      {
        localb.Am.a(paramh1, (1.0F - paramFloat) * 1.0F);
        localb.Am.a(paramh2, (1.0F - paramFloat) * -1.0F);
        localb.Am.a(paramh3, -1.0F * paramFloat);
        localb.Am.a(paramh4, 1.0F * paramFloat);
        if ((paramInt1 > 0) || (paramInt2 > 0)) {
          localb.Ak = (-paramInt1 * (1.0F - paramFloat) + paramInt2 * paramFloat);
        }
      }
    }
  }
  
  public final void a(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229979);
    b localb = fm();
    h localh = fn();
    localh.AN = 0;
    localb.a(paramh1, paramh2, localh, paramInt1);
    if (paramInt2 != 6) {
      a(localb, (int)(localb.Am.b(localh) * -1.0F), paramInt2);
    }
    b(localb);
    AppMethodBeat.o(229979);
  }
  
  public final h aT(int paramInt)
  {
    AppMethodBeat.i(229949);
    if (AF != null)
    {
      AppMethodBeat.o(229949);
      throw null;
    }
    if (this.mNumColumns + 1 >= this.Aw) {
      fj();
    }
    h localh = a(h.a.AX);
    this.As += 1;
    this.mNumColumns += 1;
    localh.id = this.As;
    localh.AN = paramInt;
    this.Aa.Aq[this.As] = localh;
    this.Au.e(localh);
    AppMethodBeat.o(229949);
    return localh;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(229964);
    if (paramb == null)
    {
      AppMethodBeat.o(229964);
      return;
    }
    if (AF != null)
    {
      AppMethodBeat.o(229964);
      throw null;
    }
    if ((this.AA + 1 >= this.AB) || (this.mNumColumns + 1 >= this.Aw)) {
      fj();
    }
    int j;
    if (!paramb.An)
    {
      a(paramb);
      if ((paramb.Aj == null) && (paramb.Ak == 0.0F) && (paramb.Am.zY == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(229964);
        return;
      }
      Object localObject2;
      if (paramb.Ak < 0.0F)
      {
        paramb.Ak *= -1.0F;
        localObject1 = paramb.Am;
        j = ((a)localObject1).Ag;
        i = 0;
        while ((j != -1) && (i < ((a)localObject1).zY))
        {
          localObject2 = ((a)localObject1).Af;
          localObject2[j] *= -1.0F;
          j = localObject1.Ae[j];
          i += 1;
        }
      }
      a locala = paramb.Am;
      Object localObject4 = null;
      Object localObject5 = null;
      float f4 = 0.0F;
      float f5 = 0.0F;
      boolean bool3 = false;
      boolean bool4 = false;
      j = locala.Ag;
      i = 0;
      if ((j != -1) && (i < locala.zY))
      {
        float f2 = locala.Af[j];
        localObject1 = locala.Aa.Aq[locala.Ad[j]];
        float f1;
        label326:
        boolean bool1;
        boolean bool2;
        float f3;
        Object localObject3;
        if (f2 < 0.0F)
        {
          f1 = f2;
          if (f2 > -0.001F)
          {
            locala.Af[j] = 0.0F;
            f1 = 0.0F;
            ((h)localObject1).e(locala.zZ);
          }
          bool1 = bool4;
          bool2 = bool3;
          f2 = f5;
          f3 = f4;
          localObject2 = localObject5;
          localObject3 = localObject4;
          if (f1 != 0.0F)
          {
            if (((h)localObject1).AQ != h.a.AU) {
              break label590;
            }
            if (localObject5 != null) {
              break label472;
            }
            bool2 = a.a((h)localObject1);
            localObject3 = localObject4;
            localObject2 = localObject1;
            f3 = f1;
            f2 = f5;
            bool1 = bool4;
          }
        }
        label590:
        for (;;)
        {
          j = locala.Ae[j];
          i += 1;
          bool4 = bool1;
          bool3 = bool2;
          f5 = f2;
          f4 = f3;
          localObject5 = localObject2;
          localObject4 = localObject3;
          break;
          f1 = f2;
          if (f2 >= 0.001F) {
            break label326;
          }
          locala.Af[j] = 0.0F;
          f1 = 0.0F;
          ((h)localObject1).e(locala.zZ);
          break label326;
          label472:
          if (f4 > f1)
          {
            bool2 = a.a((h)localObject1);
            bool1 = bool4;
            f2 = f5;
            f3 = f1;
            localObject2 = localObject1;
            localObject3 = localObject4;
          }
          else
          {
            bool1 = bool4;
            bool2 = bool3;
            f2 = f5;
            f3 = f4;
            localObject2 = localObject5;
            localObject3 = localObject4;
            if (!bool3)
            {
              bool1 = bool4;
              bool2 = bool3;
              f2 = f5;
              f3 = f4;
              localObject2 = localObject5;
              localObject3 = localObject4;
              if (a.a((h)localObject1))
              {
                bool2 = true;
                bool1 = bool4;
                f2 = f5;
                f3 = f1;
                localObject2 = localObject1;
                localObject3 = localObject4;
                continue;
                bool1 = bool4;
                bool2 = bool3;
                f2 = f5;
                f3 = f4;
                localObject2 = localObject5;
                localObject3 = localObject4;
                if (localObject5 == null)
                {
                  bool1 = bool4;
                  bool2 = bool3;
                  f2 = f5;
                  f3 = f4;
                  localObject2 = localObject5;
                  localObject3 = localObject4;
                  if (f1 < 0.0F) {
                    if (localObject4 == null)
                    {
                      bool1 = a.a((h)localObject1);
                      bool2 = bool3;
                      f2 = f1;
                      f3 = f4;
                      localObject2 = localObject5;
                      localObject3 = localObject1;
                    }
                    else if (f5 > f1)
                    {
                      bool1 = a.a((h)localObject1);
                      bool2 = bool3;
                      f2 = f1;
                      f3 = f4;
                      localObject2 = localObject5;
                      localObject3 = localObject1;
                    }
                    else
                    {
                      bool1 = bool4;
                      bool2 = bool3;
                      f2 = f5;
                      f3 = f4;
                      localObject2 = localObject5;
                      localObject3 = localObject4;
                      if (!bool4)
                      {
                        bool1 = bool4;
                        bool2 = bool3;
                        f2 = f5;
                        f3 = f4;
                        localObject2 = localObject5;
                        localObject3 = localObject4;
                        if (a.a((h)localObject1))
                        {
                          bool1 = true;
                          bool2 = bool3;
                          f2 = f1;
                          f3 = f4;
                          localObject2 = localObject5;
                          localObject3 = localObject1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (localObject5 != null) {
        if (localObject5 != null) {
          break label852;
        }
      }
      for (i = 1;; i = 0)
      {
        if (paramb.Am.zY == 0) {
          paramb.An = true;
        }
        if (i == 0) {
          break label1124;
        }
        if (AF == null) {
          break label864;
        }
        AppMethodBeat.o(229964);
        throw null;
        localObject5 = localObject4;
        break;
        label852:
        paramb.d(localObject5);
      }
      label864:
      if (this.mNumColumns + 1 >= this.Aw) {
        fj();
      }
      Object localObject1 = a(h.a.AW);
      this.As += 1;
      this.mNumColumns += 1;
      ((h)localObject1).id = this.As;
      this.Aa.Aq[this.As] = localObject1;
      paramb.Aj = ((h)localObject1);
      c(paramb);
      j = 1;
      this.AG.a(paramb);
      c(this.AG);
      i = j;
      if (((h)localObject1).AM == -1)
      {
        if (paramb.Aj == localObject1)
        {
          localObject1 = paramb.Am.a(null, (h)localObject1);
          if (localObject1 != null)
          {
            if (AF != null)
            {
              AppMethodBeat.o(229964);
              throw null;
            }
            paramb.d((h)localObject1);
          }
        }
        if (!paramb.An) {
          paramb.Aj.f(paramb);
        }
        this.AA -= 1;
      }
    }
    label1124:
    for (int i = j;; i = 0)
    {
      if ((paramb.Aj != null) && ((paramb.Aj.AQ == h.a.AU) || (paramb.Ak >= 0.0F))) {
        j = 1;
      }
      while (j == 0)
      {
        AppMethodBeat.o(229964);
        return;
        j = 0;
        continue;
        i = 0;
      }
      if (i == 0) {
        c(paramb);
      }
      AppMethodBeat.o(229964);
      return;
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(229956);
    if (AF != null)
    {
      AppMethodBeat.o(229956);
      throw null;
    }
    a((b)parama);
    int i = 0;
    if (i < this.AA) {
      if ((this.Ax[i].Aj.AQ == h.a.AU) || (this.Ax[i].Ak >= 0.0F)) {}
    }
    for (i = 1;; i = 0)
    {
      int m;
      int i4;
      float f1;
      int j;
      int k;
      int n;
      label137:
      b localb;
      int i3;
      int i2;
      int i1;
      float f2;
      if (i != 0)
      {
        m = 0;
        i = 0;
        if (m == 0)
        {
          if (AF != null)
          {
            AppMethodBeat.o(229956);
            throw null;
            i += 1;
            break;
          }
          i4 = i + 1;
          f1 = 3.4028235E+38F;
          i = 0;
          j = -1;
          k = -1;
          n = 0;
          if (n < this.AA)
          {
            localb = this.Ax[n];
            i3 = k;
            i2 = j;
            i1 = i;
            f2 = f1;
            if (localb.Aj.AQ != h.a.AU)
            {
              i3 = k;
              i2 = j;
              i1 = i;
              f2 = f1;
              if (!localb.An)
              {
                i3 = k;
                i2 = j;
                i1 = i;
                f2 = f1;
                label348:
                if (localb.Ak < 0.0F)
                {
                  i1 = 1;
                  label232:
                  if (i1 < this.mNumColumns)
                  {
                    h localh = this.Aa.Aq[i1];
                    float f3 = localb.Am.b(localh);
                    if (f3 <= 0.0F) {
                      break label555;
                    }
                    int i5 = 0;
                    i2 = k;
                    i3 = j;
                    j = i5;
                    k = i;
                    i = i3;
                    while (j < 7)
                    {
                      f2 = localh.AP[j] / f3;
                      if (((f2 >= f1) || (j != k)) && (j <= k)) {
                        break label552;
                      }
                      i2 = i1;
                      i = n;
                      k = j;
                      f1 = f2;
                      j += 1;
                    }
                    j = i2;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        i1 += 1;
        i2 = k;
        k = j;
        j = i;
        i = i2;
        break label232;
        f2 = f1;
        i1 = i;
        i2 = j;
        i3 = k;
        n += 1;
        k = i3;
        j = i2;
        i = i1;
        f1 = f2;
        break label137;
        if (j != -1)
        {
          localb = this.Ax[j];
          localb.Aj.AM = -1;
          if (AF != null)
          {
            AppMethodBeat.o(229956);
            throw null;
          }
          localb.d(this.Aa.Aq[k]);
          localb.Aj.AM = j;
          localb.Aj.f(localb);
        }
        for (i = m;; i = 1)
        {
          if (i4 > this.mNumColumns / 2) {
            i = 1;
          }
          j = i4;
          m = i;
          i = j;
          break;
        }
        c(parama);
        fo();
        AppMethodBeat.o(229956);
        return;
        label552:
        break label348;
        label555:
        i2 = j;
        i3 = i;
        j = k;
        i = i2;
        k = i3;
      }
    }
  }
  
  public final void b(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229981);
    b localb = fm();
    h localh = fn();
    localh.AN = 0;
    localb.b(paramh1, paramh2, localh, paramInt1);
    if (paramInt2 != 6) {
      a(localb, (int)(localb.Am.b(localh) * -1.0F), paramInt2);
    }
    b(localb);
    AppMethodBeat.o(229981);
  }
  
  public final b c(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229993);
    b localb = fm();
    int i = 0;
    int j = 0;
    if (paramInt1 != 0)
    {
      i = j;
      j = paramInt1;
      if (paramInt1 < 0)
      {
        j = paramInt1 * -1;
        i = 1;
      }
      localb.Ak = j;
    }
    if (i == 0)
    {
      localb.Am.a(paramh1, -1.0F);
      localb.Am.a(paramh2, 1.0F);
    }
    for (;;)
    {
      if (paramInt2 != 6) {
        localb.a(this, paramInt2);
      }
      b(localb);
      AppMethodBeat.o(229993);
      return localb;
      localb.Am.a(paramh1, 1.0F);
      localb.Am.a(paramh2, -1.0F);
    }
  }
  
  public final void c(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    AppMethodBeat.i(229989);
    b localb = fm();
    localb.a(paramh1, paramh2, paramh3, paramh4, paramFloat);
    b(localb);
    AppMethodBeat.o(229989);
  }
  
  public final b fm()
  {
    AppMethodBeat.i(229938);
    b localb = (b)this.Aa.Ao.acquire();
    if (localb == null) {
      localb = new b(this.Aa);
    }
    for (;;)
    {
      h.fp();
      AppMethodBeat.o(229938);
      return localb;
      localb.Aj = null;
      localb.Am.clear();
      localb.Ak = 0.0F;
      localb.An = false;
    }
  }
  
  public final h fn()
  {
    AppMethodBeat.i(229942);
    if (AF != null)
    {
      AppMethodBeat.o(229942);
      throw null;
    }
    if (this.mNumColumns + 1 >= this.Aw) {
      fj();
    }
    h localh = a(h.a.AW);
    this.As += 1;
    this.mNumColumns += 1;
    localh.id = this.As;
    this.Aa.Aq[this.As] = localh;
    AppMethodBeat.o(229942);
    return localh;
  }
  
  public final void fo()
  {
    int i = 0;
    while (i < this.AA)
    {
      b localb = this.Ax[i];
      localb.Aj.AO = localb.Ak;
      i += 1;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(229932);
    int i = 0;
    while (i < this.Aa.Aq.length)
    {
      h localh = this.Aa.Aq[i];
      if (localh != null) {
        localh.reset();
      }
      i += 1;
    }
    this.Aa.Ap.b(this.AC, this.AD);
    this.AD = 0;
    Arrays.fill(this.Aa.Aq, null);
    if (this.At != null) {
      this.At.clear();
    }
    this.As = 0;
    this.Au.clear();
    this.mNumColumns = 1;
    i = 0;
    while (i < this.AA)
    {
      this.Ax[i].Al = false;
      i += 1;
    }
    fl();
    this.AA = 0;
    AppMethodBeat.o(229932);
  }
  
  public final h s(Object paramObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(229934);
    if (paramObject == null)
    {
      AppMethodBeat.o(229934);
      return null;
    }
    if (this.mNumColumns + 1 >= this.Aw) {
      fj();
    }
    if ((paramObject instanceof androidx.constraintlayout.a.a.e))
    {
      localObject2 = ((androidx.constraintlayout.a.a.e)paramObject).BB;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        ((androidx.constraintlayout.a.a.e)paramObject).fu();
        localObject1 = ((androidx.constraintlayout.a.a.e)paramObject).BB;
      }
      if ((((h)localObject1).id != -1) && (((h)localObject1).id <= this.As))
      {
        localObject2 = localObject1;
        if (this.Aa.Aq[localObject1.id] != null) {}
      }
      else
      {
        if (((h)localObject1).id != -1) {
          ((h)localObject1).reset();
        }
        this.As += 1;
        this.mNumColumns += 1;
        ((h)localObject1).id = this.As;
        ((h)localObject1).AQ = h.a.AU;
        this.Aa.Aq[this.As] = localObject1;
        localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(229934);
    return localObject2;
  }
  
  static abstract interface a
  {
    public abstract h a(boolean[] paramArrayOfBoolean);
    
    public abstract void a(a parama);
    
    public abstract void clear();
    
    public abstract void e(h paramh);
    
    public abstract h fh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.e
 * JD-Core Version:    0.7.0.1
 */