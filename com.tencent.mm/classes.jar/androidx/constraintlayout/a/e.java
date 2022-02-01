package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;

public final class e
{
  public static f bgN;
  private static int bgz = 1000;
  int bgA;
  private HashMap<String, h> bgB;
  public a bgC;
  private int bgD;
  private int bgE;
  public b[] bgF;
  public boolean bgG;
  private boolean[] bgH;
  public int bgI;
  private int bgJ;
  private h[] bgK;
  private int bgL;
  private b[] bgM;
  private final a bgO;
  public final c bgi;
  int mNumColumns;
  
  public e()
  {
    AppMethodBeat.i(193962);
    this.bgA = 0;
    this.bgB = null;
    this.bgD = 32;
    this.bgE = this.bgD;
    this.bgF = null;
    this.bgG = false;
    this.bgH = new boolean[this.bgD];
    this.mNumColumns = 1;
    this.bgI = 0;
    this.bgJ = this.bgD;
    this.bgK = new h[bgz];
    this.bgL = 0;
    this.bgM = new b[this.bgD];
    this.bgF = new b[this.bgD];
    Cu();
    this.bgi = new c();
    this.bgC = new d(this.bgi);
    this.bgO = new b(this.bgi);
    AppMethodBeat.o(193962);
  }
  
  public static f Cs()
  {
    return bgN;
  }
  
  private void Ct()
  {
    AppMethodBeat.i(193991);
    this.bgD *= 2;
    this.bgF = ((b[])Arrays.copyOf(this.bgF, this.bgD));
    this.bgi.bgy = ((h[])Arrays.copyOf(this.bgi.bgy, this.bgD));
    this.bgH = new boolean[this.bgD];
    this.bgE = this.bgD;
    this.bgJ = this.bgD;
    if (bgN != null)
    {
      AppMethodBeat.o(193991);
      throw null;
    }
    AppMethodBeat.o(193991);
  }
  
  private void Cu()
  {
    AppMethodBeat.i(194007);
    int i = 0;
    while (i < this.bgF.length)
    {
      b localb = this.bgF[i];
      if (localb != null) {
        this.bgi.bgw.release(localb);
      }
      this.bgF[i] = null;
      i += 1;
    }
    AppMethodBeat.o(194007);
  }
  
  public static b a(e parame, h paramh1, h paramh2, h paramh3, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(194088);
    b localb = parame.Cv();
    if (paramBoolean) {
      localb.a(parame, 0);
    }
    localb.bgu.a(paramh1, -1.0F);
    localb.bgu.a(paramh2, 1.0F - paramFloat);
    localb.bgu.a(paramh3, paramFloat);
    AppMethodBeat.o(194088);
    return localb;
  }
  
  private h a(h.a parama)
  {
    AppMethodBeat.i(194019);
    Object localObject = (h)this.bgi.bgx.acquire();
    if (localObject == null)
    {
      localObject = new h(parama);
      ((h)localObject).bgY = parama;
    }
    for (parama = (h.a)localObject;; parama = (h.a)localObject)
    {
      if (this.bgL >= bgz)
      {
        bgz *= 2;
        this.bgK = ((h[])Arrays.copyOf(this.bgK, bgz));
      }
      localObject = this.bgK;
      int i = this.bgL;
      this.bgL = (i + 1);
      localObject[i] = parama;
      AppMethodBeat.o(194019);
      return parama;
      ((h)localObject).reset();
      ((h)localObject).bgY = parama;
    }
  }
  
  private final void a(b paramb)
  {
    AppMethodBeat.i(194044);
    if (this.bgI > 0)
    {
      paramb.bgu.a(paramb, this.bgF);
      if (paramb.bgu.bgg == 0) {
        paramb.bgv = true;
      }
    }
    AppMethodBeat.o(194044);
  }
  
  public static int as(Object paramObject)
  {
    paramObject = ((androidx.constraintlayout.a.a.e)paramObject).bhJ;
    if (paramObject != null) {
      return (int)(paramObject.bgW + 0.5F);
    }
    return 0;
  }
  
  private final int c(a parama)
  {
    AppMethodBeat.i(194075);
    if (bgN != null)
    {
      AppMethodBeat.o(194075);
      throw null;
    }
    int i = 0;
    b localb;
    h localh;
    int m;
    while (i < this.mNumColumns)
    {
      this.bgH[i] = false;
      i += 1;
      continue;
      localb.d(localh);
      localb.bgr.bgU = m;
      localb.bgr.f(localb);
    }
    for (;;)
    {
      if (j == 0)
      {
        if (bgN != null)
        {
          AppMethodBeat.o(194075);
          throw null;
        }
        i += 1;
        if (i >= this.mNumColumns * 2)
        {
          AppMethodBeat.o(194075);
          return i;
        }
        if (parama.Cr() != null) {
          this.bgH[parama.Cr().id] = true;
        }
        localh = parama.b(this.bgH);
        if (localh != null)
        {
          if (this.bgH[localh.id] != 0)
          {
            AppMethodBeat.o(194075);
            return i;
          }
          this.bgH[localh.id] = true;
        }
        if (localh != null)
        {
          float f1 = 3.4028235E+38F;
          int k = 0;
          m = -1;
          while (k < this.bgI)
          {
            localb = this.bgF[k];
            int n = m;
            float f2 = f1;
            if (localb.bgr.bgY != h.a.bhc)
            {
              n = m;
              f2 = f1;
              if (!localb.bgv)
              {
                n = m;
                f2 = f1;
                if (localb.c(localh))
                {
                  float f3 = localb.bgu.b(localh);
                  n = m;
                  f2 = f1;
                  if (f3 < 0.0F)
                  {
                    f3 = -localb.bgs / f3;
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
            localb = this.bgF[m];
            localb.bgr.bgU = -1;
            if (bgN == null) {
              break;
            }
            AppMethodBeat.o(194075);
            throw null;
          }
          j = 1;
          continue;
        }
        j = 1;
        continue;
      }
      AppMethodBeat.o(194075);
      return i;
      i = 0;
      int j = 0;
    }
  }
  
  private final void c(b paramb)
  {
    AppMethodBeat.i(194055);
    if (this.bgF[this.bgI] != null) {
      this.bgi.bgw.release(this.bgF[this.bgI]);
    }
    this.bgF[this.bgI] = paramb;
    paramb.bgr.bgU = this.bgI;
    this.bgI += 1;
    paramb.bgr.f(paramb);
    AppMethodBeat.o(194055);
  }
  
  public final b Cv()
  {
    AppMethodBeat.i(194140);
    b localb = (b)this.bgi.bgw.acquire();
    if (localb == null) {
      localb = new b(this.bgi);
    }
    for (;;)
    {
      h.Cy();
      AppMethodBeat.o(194140);
      return localb;
      localb.bgr = null;
      localb.bgu.clear();
      localb.bgs = 0.0F;
      localb.bgv = false;
    }
  }
  
  public final h Cw()
  {
    AppMethodBeat.i(194150);
    if (bgN != null)
    {
      AppMethodBeat.o(194150);
      throw null;
    }
    if (this.mNumColumns + 1 >= this.bgE) {
      Ct();
    }
    h localh = a(h.a.bhe);
    this.bgA += 1;
    this.mNumColumns += 1;
    localh.id = this.bgA;
    this.bgi.bgy[this.bgA] = localh;
    AppMethodBeat.o(194150);
    return localh;
  }
  
  public final void Cx()
  {
    int i = 0;
    while (i < this.bgI)
    {
      b localb = this.bgF[i];
      localb.bgr.bgW = localb.bgs;
      i += 1;
    }
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194160);
    h localh = dJ(paramInt2);
    paramb.bgu.a(localh, paramInt1);
    AppMethodBeat.o(194160);
  }
  
  public final void a(h paramh, int paramInt)
  {
    AppMethodBeat.i(194284);
    int i = paramh.bgU;
    if (paramh.bgU != -1)
    {
      localb = this.bgF[i];
      if (localb.bgv)
      {
        localb.bgs = paramInt;
        AppMethodBeat.o(194284);
        return;
      }
      if (localb.bgu.bgg == 0)
      {
        localb.bgv = true;
        localb.bgs = paramInt;
        AppMethodBeat.o(194284);
        return;
      }
      localb = Cv();
      if (paramInt < 0)
      {
        localb.bgs = (paramInt * -1);
        localb.bgu.a(paramh, 1.0F);
      }
      for (;;)
      {
        b(localb);
        AppMethodBeat.o(194284);
        return;
        localb.bgs = paramInt;
        localb.bgu.a(paramh, -1.0F);
      }
    }
    b localb = Cv();
    localb.bgr = paramh;
    paramh.bgW = paramInt;
    localb.bgs = paramInt;
    localb.bgv = true;
    b(localb);
    AppMethodBeat.o(194284);
  }
  
  public final void a(h paramh1, h paramh2, int paramInt1, float paramFloat, h paramh3, h paramh4, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194248);
    b localb = Cv();
    if (paramh2 == paramh3)
    {
      localb.bgu.a(paramh1, 1.0F);
      localb.bgu.a(paramh4, 1.0F);
      localb.bgu.a(paramh2, -2.0F);
    }
    for (;;)
    {
      if (paramInt3 != 6) {
        localb.a(this, paramInt3);
      }
      b(localb);
      AppMethodBeat.o(194248);
      return;
      if (paramFloat == 0.5F)
      {
        localb.bgu.a(paramh1, 1.0F);
        localb.bgu.a(paramh2, -1.0F);
        localb.bgu.a(paramh3, -1.0F);
        localb.bgu.a(paramh4, 1.0F);
        if ((paramInt1 > 0) || (paramInt2 > 0)) {
          localb.bgs = (-paramInt1 + paramInt2);
        }
      }
      else if (paramFloat <= 0.0F)
      {
        localb.bgu.a(paramh1, -1.0F);
        localb.bgu.a(paramh2, 1.0F);
        localb.bgs = paramInt1;
      }
      else if (paramFloat >= 1.0F)
      {
        localb.bgu.a(paramh3, -1.0F);
        localb.bgu.a(paramh4, 1.0F);
        localb.bgs = paramInt2;
      }
      else
      {
        localb.bgu.a(paramh1, (1.0F - paramFloat) * 1.0F);
        localb.bgu.a(paramh2, (1.0F - paramFloat) * -1.0F);
        localb.bgu.a(paramh3, -1.0F * paramFloat);
        localb.bgu.a(paramh4, 1.0F * paramFloat);
        if ((paramInt1 > 0) || (paramInt2 > 0)) {
          localb.bgs = (-paramInt1 * (1.0F - paramFloat) + paramInt2 * paramFloat);
        }
      }
    }
  }
  
  public final void a(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194221);
    b localb = Cv();
    h localh = Cw();
    localh.bgV = 0;
    localb.a(paramh1, paramh2, localh, paramInt1);
    if (paramInt2 != 6) {
      a(localb, (int)(localb.bgu.b(localh) * -1.0F), paramInt2);
    }
    b(localb);
    AppMethodBeat.o(194221);
  }
  
  public final h ar(Object paramObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(194131);
    if (paramObject == null)
    {
      AppMethodBeat.o(194131);
      return null;
    }
    if (this.mNumColumns + 1 >= this.bgE) {
      Ct();
    }
    if ((paramObject instanceof androidx.constraintlayout.a.a.e))
    {
      localObject2 = ((androidx.constraintlayout.a.a.e)paramObject).bhJ;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        ((androidx.constraintlayout.a.a.e)paramObject).CD();
        localObject1 = ((androidx.constraintlayout.a.a.e)paramObject).bhJ;
      }
      if ((((h)localObject1).id != -1) && (((h)localObject1).id <= this.bgA))
      {
        localObject2 = localObject1;
        if (this.bgi.bgy[localObject1.id] != null) {}
      }
      else
      {
        if (((h)localObject1).id != -1) {
          ((h)localObject1).reset();
        }
        this.bgA += 1;
        this.mNumColumns += 1;
        ((h)localObject1).id = this.bgA;
        ((h)localObject1).bgY = h.a.bhc;
        this.bgi.bgy[this.bgA] = localObject1;
        localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(194131);
    return localObject2;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(194205);
    if (paramb == null)
    {
      AppMethodBeat.o(194205);
      return;
    }
    if (bgN != null)
    {
      AppMethodBeat.o(194205);
      throw null;
    }
    if ((this.bgI + 1 >= this.bgJ) || (this.mNumColumns + 1 >= this.bgE)) {
      Ct();
    }
    int j;
    if (!paramb.bgv)
    {
      a(paramb);
      if ((paramb.bgr == null) && (paramb.bgs == 0.0F) && (paramb.bgu.bgg == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(194205);
        return;
      }
      Object localObject2;
      if (paramb.bgs < 0.0F)
      {
        paramb.bgs *= -1.0F;
        localObject1 = paramb.bgu;
        j = ((a)localObject1).bgo;
        i = 0;
        while ((j != -1) && (i < ((a)localObject1).bgg))
        {
          localObject2 = ((a)localObject1).bgn;
          localObject2[j] *= -1.0F;
          j = localObject1.bgm[j];
          i += 1;
        }
      }
      a locala = paramb.bgu;
      Object localObject4 = null;
      Object localObject5 = null;
      float f4 = 0.0F;
      float f5 = 0.0F;
      boolean bool3 = false;
      boolean bool4 = false;
      j = locala.bgo;
      i = 0;
      if ((j != -1) && (i < locala.bgg))
      {
        float f2 = locala.bgn[j];
        localObject1 = locala.bgi.bgy[locala.bgl[j]];
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
            locala.bgn[j] = 0.0F;
            f1 = 0.0F;
            ((h)localObject1).e(locala.bgh);
          }
          bool1 = bool4;
          bool2 = bool3;
          f2 = f5;
          f3 = f4;
          localObject2 = localObject5;
          localObject3 = localObject4;
          if (f1 != 0.0F)
          {
            if (((h)localObject1).bgY != h.a.bhc) {
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
          j = locala.bgm[j];
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
          locala.bgn[j] = 0.0F;
          f1 = 0.0F;
          ((h)localObject1).e(locala.bgh);
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
        if (paramb.bgu.bgg == 0) {
          paramb.bgv = true;
        }
        if (i == 0) {
          break label1124;
        }
        if (bgN == null) {
          break label864;
        }
        AppMethodBeat.o(194205);
        throw null;
        localObject5 = localObject4;
        break;
        label852:
        paramb.d(localObject5);
      }
      label864:
      if (this.mNumColumns + 1 >= this.bgE) {
        Ct();
      }
      Object localObject1 = a(h.a.bhe);
      this.bgA += 1;
      this.mNumColumns += 1;
      ((h)localObject1).id = this.bgA;
      this.bgi.bgy[this.bgA] = localObject1;
      paramb.bgr = ((h)localObject1);
      c(paramb);
      j = 1;
      this.bgO.a(paramb);
      c(this.bgO);
      i = j;
      if (((h)localObject1).bgU == -1)
      {
        if (paramb.bgr == localObject1)
        {
          localObject1 = paramb.bgu.a(null, (h)localObject1);
          if (localObject1 != null)
          {
            if (bgN != null)
            {
              AppMethodBeat.o(194205);
              throw null;
            }
            paramb.d((h)localObject1);
          }
        }
        if (!paramb.bgv) {
          paramb.bgr.f(paramb);
        }
        this.bgI -= 1;
      }
    }
    label1124:
    for (int i = j;; i = 0)
    {
      if ((paramb.bgr != null) && ((paramb.bgr.bgY == h.a.bhc) || (paramb.bgs >= 0.0F))) {
        j = 1;
      }
      while (j == 0)
      {
        AppMethodBeat.o(194205);
        return;
        j = 0;
        continue;
        i = 0;
      }
      if (i == 0) {
        c(paramb);
      }
      AppMethodBeat.o(194205);
      return;
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(194190);
    if (bgN != null)
    {
      AppMethodBeat.o(194190);
      throw null;
    }
    a((b)parama);
    int i = 0;
    if (i < this.bgI) {
      if ((this.bgF[i].bgr.bgY == h.a.bhc) || (this.bgF[i].bgs >= 0.0F)) {}
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
          if (bgN != null)
          {
            AppMethodBeat.o(194190);
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
          if (n < this.bgI)
          {
            localb = this.bgF[n];
            i3 = k;
            i2 = j;
            i1 = i;
            f2 = f1;
            if (localb.bgr.bgY != h.a.bhc)
            {
              i3 = k;
              i2 = j;
              i1 = i;
              f2 = f1;
              if (!localb.bgv)
              {
                i3 = k;
                i2 = j;
                i1 = i;
                f2 = f1;
                label348:
                if (localb.bgs < 0.0F)
                {
                  i1 = 1;
                  label232:
                  if (i1 < this.mNumColumns)
                  {
                    h localh = this.bgi.bgy[i1];
                    float f3 = localb.bgu.b(localh);
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
                      f2 = localh.bgX[j] / f3;
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
          localb = this.bgF[j];
          localb.bgr.bgU = -1;
          if (bgN != null)
          {
            AppMethodBeat.o(194190);
            throw null;
          }
          localb.d(this.bgi.bgy[k]);
          localb.bgr.bgU = j;
          localb.bgr.f(localb);
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
        Cx();
        AppMethodBeat.o(194190);
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
    AppMethodBeat.i(194233);
    b localb = Cv();
    h localh = Cw();
    localh.bgV = 0;
    localb.b(paramh1, paramh2, localh, paramInt1);
    if (paramInt2 != 6) {
      a(localb, (int)(localb.bgu.b(localh) * -1.0F), paramInt2);
    }
    b(localb);
    AppMethodBeat.o(194233);
  }
  
  public final b c(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194271);
    b localb = Cv();
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
      localb.bgs = j;
    }
    if (i == 0)
    {
      localb.bgu.a(paramh1, -1.0F);
      localb.bgu.a(paramh2, 1.0F);
    }
    for (;;)
    {
      if (paramInt2 != 6) {
        localb.a(this, paramInt2);
      }
      b(localb);
      AppMethodBeat.o(194271);
      return localb;
      localb.bgu.a(paramh1, 1.0F);
      localb.bgu.a(paramh2, -1.0F);
    }
  }
  
  public final void c(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    AppMethodBeat.i(194260);
    b localb = Cv();
    localb.a(paramh1, paramh2, paramh3, paramh4, paramFloat);
    b(localb);
    AppMethodBeat.o(194260);
  }
  
  public final h dJ(int paramInt)
  {
    AppMethodBeat.i(194172);
    if (bgN != null)
    {
      AppMethodBeat.o(194172);
      throw null;
    }
    if (this.mNumColumns + 1 >= this.bgE) {
      Ct();
    }
    h localh = a(h.a.bhf);
    this.bgA += 1;
    this.mNumColumns += 1;
    localh.id = this.bgA;
    localh.bgV = paramInt;
    this.bgi.bgy[this.bgA] = localh;
    this.bgC.e(localh);
    AppMethodBeat.o(194172);
    return localh;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194115);
    int i = 0;
    while (i < this.bgi.bgy.length)
    {
      h localh = this.bgi.bgy[i];
      if (localh != null) {
        localh.reset();
      }
      i += 1;
    }
    this.bgi.bgx.i(this.bgK, this.bgL);
    this.bgL = 0;
    Arrays.fill(this.bgi.bgy, null);
    if (this.bgB != null) {
      this.bgB.clear();
    }
    this.bgA = 0;
    this.bgC.clear();
    this.mNumColumns = 1;
    i = 0;
    while (i < this.bgI)
    {
      this.bgF[i].bgt = false;
      i += 1;
    }
    Cu();
    this.bgI = 0;
    AppMethodBeat.o(194115);
  }
  
  static abstract interface a
  {
    public abstract h Cr();
    
    public abstract void a(a parama);
    
    public abstract h b(boolean[] paramArrayOfBoolean);
    
    public abstract void clear();
    
    public abstract void e(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.e
 * JD-Core Version:    0.7.0.1
 */