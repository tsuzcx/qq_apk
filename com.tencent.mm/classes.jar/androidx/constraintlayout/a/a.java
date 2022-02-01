package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
{
  int bgg;
  final b bgh;
  final c bgi;
  private int bgj;
  private h bgk;
  int[] bgl;
  int[] bgm;
  float[] bgn;
  int bgo;
  private int bgp;
  private boolean bgq;
  
  a(b paramb, c paramc)
  {
    AppMethodBeat.i(193959);
    this.bgg = 0;
    this.bgj = 8;
    this.bgk = null;
    this.bgl = new int[this.bgj];
    this.bgm = new int[this.bgj];
    this.bgn = new float[this.bgj];
    this.bgo = -1;
    this.bgp = -1;
    this.bgq = false;
    this.bgh = paramb;
    this.bgi = paramc;
    AppMethodBeat.o(193959);
  }
  
  static boolean a(h paramh)
  {
    return paramh.bhb <= 1;
  }
  
  public final float a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(194042);
    if (this.bgk == paramh) {
      this.bgk = null;
    }
    if (this.bgo == -1)
    {
      AppMethodBeat.o(194042);
      return 0.0F;
    }
    int i = this.bgo;
    int j = 0;
    int k = -1;
    while ((i != -1) && (j < this.bgg))
    {
      if (this.bgl[i] == paramh.id)
      {
        if (i == this.bgo) {
          this.bgo = this.bgm[i];
        }
        for (;;)
        {
          if (paramBoolean) {
            paramh.e(this.bgh);
          }
          paramh.bhb -= 1;
          this.bgg -= 1;
          this.bgl[i] = -1;
          if (this.bgq) {
            this.bgp = i;
          }
          float f = this.bgn[i];
          AppMethodBeat.o(194042);
          return f;
          int[] arrayOfInt = this.bgm;
          arrayOfInt[k] = arrayOfInt[i];
        }
      }
      int m = this.bgm[i];
      j += 1;
      k = i;
      i = m;
    }
    AppMethodBeat.o(194042);
    return 0.0F;
  }
  
  final h a(boolean[] paramArrayOfBoolean, h paramh)
  {
    int j = this.bgo;
    Object localObject1 = null;
    float f1 = 0.0F;
    int i = 0;
    while ((j != -1) && (i < this.bgg))
    {
      float f2 = f1;
      Object localObject2 = localObject1;
      if (this.bgn[j] < 0.0F)
      {
        h localh = this.bgi.bgy[this.bgl[j]];
        if (paramArrayOfBoolean != null)
        {
          f2 = f1;
          localObject2 = localObject1;
          if (paramArrayOfBoolean[localh.id] != 0) {}
        }
        else
        {
          f2 = f1;
          localObject2 = localObject1;
          if (localh != paramh) {
            if (localh.bgY != h.a.bhe)
            {
              f2 = f1;
              localObject2 = localObject1;
              if (localh.bgY != h.a.bhf) {}
            }
            else
            {
              float f3 = this.bgn[j];
              f2 = f1;
              localObject2 = localObject1;
              if (f3 < f1)
              {
                f2 = f3;
                localObject2 = localh;
              }
            }
          }
        }
      }
      j = this.bgm[j];
      i += 1;
      f1 = f2;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  final void a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(194070);
    int j = this.bgo;
    int i = 0;
    while ((j != -1) && (i < this.bgg)) {
      if (this.bgl[j] == paramb2.bgr.id)
      {
        float f = this.bgn[j];
        a(paramb2.bgr, false);
        a locala = (a)paramb2.bgu;
        j = locala.bgo;
        i = 0;
        while ((j != -1) && (i < locala.bgg))
        {
          a(this.bgi.bgy[locala.bgl[j]], locala.bgn[j] * f, false);
          j = locala.bgm[j];
          i += 1;
        }
        paramb1.bgs += paramb2.bgs * f;
        j = this.bgo;
        i = 0;
      }
      else
      {
        j = this.bgm[j];
        i += 1;
      }
    }
    AppMethodBeat.o(194070);
  }
  
  final void a(b paramb, b[] paramArrayOfb)
  {
    AppMethodBeat.i(194084);
    int j = this.bgo;
    int i = 0;
    while ((j != -1) && (i < this.bgg))
    {
      Object localObject = this.bgi.bgy[this.bgl[j]];
      if (((h)localObject).bgU != -1)
      {
        float f = this.bgn[j];
        a((h)localObject, true);
        localObject = paramArrayOfb[localObject.bgU];
        if (!((b)localObject).bgv)
        {
          a locala = (a)((b)localObject).bgu;
          j = locala.bgo;
          i = 0;
          while ((j != -1) && (i < locala.bgg))
          {
            a(this.bgi.bgy[locala.bgl[j]], locala.bgn[j] * f, true);
            j = locala.bgm[j];
            i += 1;
          }
        }
        paramb.bgs += ((b)localObject).bgs * f;
        ((b)localObject).bgr.e(paramb);
        j = this.bgo;
        i = 0;
      }
      else
      {
        j = this.bgm[j];
        i += 1;
      }
    }
    AppMethodBeat.o(194084);
  }
  
  public final void a(h paramh, float paramFloat)
  {
    AppMethodBeat.i(194000);
    if (paramFloat == 0.0F)
    {
      a(paramh, true);
      AppMethodBeat.o(194000);
      return;
    }
    if (this.bgo == -1)
    {
      this.bgo = 0;
      this.bgn[this.bgo] = paramFloat;
      this.bgl[this.bgo] = paramh.id;
      this.bgm[this.bgo] = -1;
      paramh.bhb += 1;
      paramh.d(this.bgh);
      this.bgg += 1;
      if (!this.bgq)
      {
        this.bgp += 1;
        if (this.bgp >= this.bgl.length)
        {
          this.bgq = true;
          this.bgp = (this.bgl.length - 1);
        }
      }
      AppMethodBeat.o(194000);
      return;
    }
    int i = this.bgo;
    int j = 0;
    int m = -1;
    while ((i != -1) && (j < this.bgg))
    {
      if (this.bgl[i] == paramh.id)
      {
        this.bgn[i] = paramFloat;
        AppMethodBeat.o(194000);
        return;
      }
      if (this.bgl[i] < paramh.id) {
        m = i;
      }
      i = this.bgm[i];
      j += 1;
    }
    i = this.bgp + 1;
    int k;
    if (this.bgq)
    {
      if (this.bgl[this.bgp] == -1) {
        i = this.bgp;
      }
    }
    else
    {
      j = i;
      if (i >= this.bgl.length)
      {
        j = i;
        if (this.bgg < this.bgl.length)
        {
          k = 0;
          label294:
          j = i;
          if (k < this.bgl.length)
          {
            if (this.bgl[k] != -1) {
              break label559;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.bgl.length)
      {
        i = this.bgl.length;
        this.bgj *= 2;
        this.bgq = false;
        this.bgp = (i - 1);
        this.bgn = Arrays.copyOf(this.bgn, this.bgj);
        this.bgl = Arrays.copyOf(this.bgl, this.bgj);
        this.bgm = Arrays.copyOf(this.bgm, this.bgj);
      }
      this.bgl[i] = paramh.id;
      this.bgn[i] = paramFloat;
      if (m == -1) {
        break label568;
      }
      int[] arrayOfInt = this.bgm;
      arrayOfInt[i] = arrayOfInt[m];
      this.bgm[m] = i;
    }
    for (;;)
    {
      paramh.bhb += 1;
      paramh.d(this.bgh);
      this.bgg += 1;
      if (!this.bgq) {
        this.bgp += 1;
      }
      if (this.bgg >= this.bgl.length) {
        this.bgq = true;
      }
      if (this.bgp >= this.bgl.length)
      {
        this.bgq = true;
        this.bgp = (this.bgl.length - 1);
      }
      AppMethodBeat.o(194000);
      return;
      i = this.bgl.length;
      break;
      label559:
      k += 1;
      break label294;
      label568:
      this.bgm[i] = this.bgo;
      this.bgo = i;
    }
  }
  
  final void a(h paramh, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(194026);
    if (paramFloat == 0.0F)
    {
      AppMethodBeat.o(194026);
      return;
    }
    if (this.bgo == -1)
    {
      this.bgo = 0;
      this.bgn[this.bgo] = paramFloat;
      this.bgl[this.bgo] = paramh.id;
      this.bgm[this.bgo] = -1;
      paramh.bhb += 1;
      paramh.d(this.bgh);
      this.bgg += 1;
      if (!this.bgq)
      {
        this.bgp += 1;
        if (this.bgp >= this.bgl.length)
        {
          this.bgq = true;
          this.bgp = (this.bgl.length - 1);
        }
      }
      AppMethodBeat.o(194026);
      return;
    }
    int i = this.bgo;
    int j = 0;
    int m = -1;
    Object localObject;
    while ((i != -1) && (j < this.bgg))
    {
      if (this.bgl[i] == paramh.id)
      {
        localObject = this.bgn;
        localObject[i] += paramFloat;
        if (this.bgn[i] == 0.0F)
        {
          if (i != this.bgo) {
            break label284;
          }
          this.bgo = this.bgm[i];
        }
        for (;;)
        {
          if (paramBoolean) {
            paramh.e(this.bgh);
          }
          if (this.bgq) {
            this.bgp = i;
          }
          paramh.bhb -= 1;
          this.bgg -= 1;
          AppMethodBeat.o(194026);
          return;
          label284:
          localObject = this.bgm;
          localObject[m] = localObject[i];
        }
      }
      if (this.bgl[i] < paramh.id) {
        m = i;
      }
      i = this.bgm[i];
      j += 1;
    }
    i = this.bgp + 1;
    int k;
    if (this.bgq)
    {
      if (this.bgl[this.bgp] == -1) {
        i = this.bgp;
      }
    }
    else
    {
      j = i;
      if (i >= this.bgl.length)
      {
        j = i;
        if (this.bgg < this.bgl.length)
        {
          k = 0;
          label406:
          j = i;
          if (k < this.bgl.length)
          {
            if (this.bgl[k] != -1) {
              break label663;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.bgl.length)
      {
        i = this.bgl.length;
        this.bgj *= 2;
        this.bgq = false;
        this.bgp = (i - 1);
        this.bgn = Arrays.copyOf(this.bgn, this.bgj);
        this.bgl = Arrays.copyOf(this.bgl, this.bgj);
        this.bgm = Arrays.copyOf(this.bgm, this.bgj);
      }
      this.bgl[i] = paramh.id;
      this.bgn[i] = paramFloat;
      if (m == -1) {
        break label672;
      }
      localObject = this.bgm;
      localObject[i] = localObject[m];
      this.bgm[m] = i;
    }
    for (;;)
    {
      paramh.bhb += 1;
      paramh.d(this.bgh);
      this.bgg += 1;
      if (!this.bgq) {
        this.bgp += 1;
      }
      if (this.bgp >= this.bgl.length)
      {
        this.bgq = true;
        this.bgp = (this.bgl.length - 1);
      }
      AppMethodBeat.o(194026);
      return;
      i = this.bgl.length;
      break;
      label663:
      k += 1;
      break label406;
      label672:
      this.bgm[i] = this.bgo;
      this.bgo = i;
    }
  }
  
  public final float b(h paramh)
  {
    int j = this.bgo;
    int i = 0;
    while ((j != -1) && (i < this.bgg))
    {
      if (this.bgl[j] == paramh.id) {
        return this.bgn[j];
      }
      j = this.bgm[j];
      i += 1;
    }
    return 0.0F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(194052);
    int j = this.bgo;
    int i = 0;
    while ((j != -1) && (i < this.bgg))
    {
      h localh = this.bgi.bgy[this.bgl[j]];
      if (localh != null) {
        localh.e(this.bgh);
      }
      j = this.bgm[j];
      i += 1;
    }
    this.bgo = -1;
    this.bgp = -1;
    this.bgq = false;
    this.bgg = 0;
    AppMethodBeat.o(194052);
  }
  
  final h dH(int paramInt)
  {
    int j = this.bgo;
    int i = 0;
    while ((j != -1) && (i < this.bgg))
    {
      if (i == paramInt) {
        return this.bgi.bgy[this.bgl[j]];
      }
      j = this.bgm[j];
      i += 1;
    }
    return null;
  }
  
  final float dI(int paramInt)
  {
    int j = this.bgo;
    int i = 0;
    while ((j != -1) && (i < this.bgg))
    {
      if (i == paramInt) {
        return this.bgn[j];
      }
      j = this.bgm[j];
      i += 1;
    }
    return 0.0F;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194141);
    String str = "";
    int j = this.bgo;
    int i = 0;
    while ((j != -1) && (i < this.bgg))
    {
      str = str + " -> ";
      str = str + this.bgn[j] + " : ";
      str = str + this.bgi.bgy[this.bgl[j]];
      j = this.bgm[j];
      i += 1;
    }
    AppMethodBeat.o(194141);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a
 * JD-Core Version:    0.7.0.1
 */