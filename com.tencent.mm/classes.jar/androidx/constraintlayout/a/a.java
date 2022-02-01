package androidx.constraintlayout.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
{
  final c Aa;
  private int Ab;
  private h Ac;
  int[] Ad;
  int[] Ae;
  float[] Af;
  int Ag;
  private int Ah;
  private boolean Ai;
  int zY;
  final b zZ;
  
  a(b paramb, c paramc)
  {
    AppMethodBeat.i(229871);
    this.zY = 0;
    this.Ab = 8;
    this.Ac = null;
    this.Ad = new int[this.Ab];
    this.Ae = new int[this.Ab];
    this.Af = new float[this.Ab];
    this.Ag = -1;
    this.Ah = -1;
    this.Ai = false;
    this.zZ = paramb;
    this.Aa = paramc;
    AppMethodBeat.o(229871);
  }
  
  static boolean a(h paramh)
  {
    return paramh.AT <= 1;
  }
  
  public final float a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(229888);
    if (this.Ac == paramh) {
      this.Ac = null;
    }
    if (this.Ag == -1)
    {
      AppMethodBeat.o(229888);
      return 0.0F;
    }
    int i = this.Ag;
    int j = 0;
    int k = -1;
    while ((i != -1) && (j < this.zY))
    {
      if (this.Ad[i] == paramh.id)
      {
        if (i == this.Ag) {
          this.Ag = this.Ae[i];
        }
        for (;;)
        {
          if (paramBoolean) {
            paramh.e(this.zZ);
          }
          paramh.AT -= 1;
          this.zY -= 1;
          this.Ad[i] = -1;
          if (this.Ai) {
            this.Ah = i;
          }
          float f = this.Af[i];
          AppMethodBeat.o(229888);
          return f;
          int[] arrayOfInt = this.Ae;
          arrayOfInt[k] = arrayOfInt[i];
        }
      }
      int m = this.Ae[i];
      j += 1;
      k = i;
      i = m;
    }
    AppMethodBeat.o(229888);
    return 0.0F;
  }
  
  final h a(boolean[] paramArrayOfBoolean, h paramh)
  {
    int j = this.Ag;
    Object localObject1 = null;
    float f1 = 0.0F;
    int i = 0;
    while ((j != -1) && (i < this.zY))
    {
      float f2 = f1;
      Object localObject2 = localObject1;
      if (this.Af[j] < 0.0F)
      {
        h localh = this.Aa.Aq[this.Ad[j]];
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
            if (localh.AQ != h.a.AW)
            {
              f2 = f1;
              localObject2 = localObject1;
              if (localh.AQ != h.a.AX) {}
            }
            else
            {
              float f3 = this.Af[j];
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
      j = this.Ae[j];
      i += 1;
      f1 = f2;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  final void a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(229895);
    int j = this.Ag;
    int i = 0;
    while ((j != -1) && (i < this.zY)) {
      if (this.Ad[j] == paramb2.Aj.id)
      {
        float f = this.Af[j];
        a(paramb2.Aj, false);
        a locala = (a)paramb2.Am;
        j = locala.Ag;
        i = 0;
        while ((j != -1) && (i < locala.zY))
        {
          a(this.Aa.Aq[locala.Ad[j]], locala.Af[j] * f, false);
          j = locala.Ae[j];
          i += 1;
        }
        paramb1.Ak += paramb2.Ak * f;
        j = this.Ag;
        i = 0;
      }
      else
      {
        j = this.Ae[j];
        i += 1;
      }
    }
    AppMethodBeat.o(229895);
  }
  
  final void a(b paramb, b[] paramArrayOfb)
  {
    AppMethodBeat.i(229898);
    int j = this.Ag;
    int i = 0;
    while ((j != -1) && (i < this.zY))
    {
      Object localObject = this.Aa.Aq[this.Ad[j]];
      if (((h)localObject).AM != -1)
      {
        float f = this.Af[j];
        a((h)localObject, true);
        localObject = paramArrayOfb[localObject.AM];
        if (!((b)localObject).An)
        {
          a locala = (a)((b)localObject).Am;
          j = locala.Ag;
          i = 0;
          while ((j != -1) && (i < locala.zY))
          {
            a(this.Aa.Aq[locala.Ad[j]], locala.Af[j] * f, true);
            j = locala.Ae[j];
            i += 1;
          }
        }
        paramb.Ak += ((b)localObject).Ak * f;
        ((b)localObject).Aj.e(paramb);
        j = this.Ag;
        i = 0;
      }
      else
      {
        j = this.Ae[j];
        i += 1;
      }
    }
    AppMethodBeat.o(229898);
  }
  
  public final void a(h paramh, float paramFloat)
  {
    AppMethodBeat.i(229880);
    if (paramFloat == 0.0F)
    {
      a(paramh, true);
      AppMethodBeat.o(229880);
      return;
    }
    if (this.Ag == -1)
    {
      this.Ag = 0;
      this.Af[this.Ag] = paramFloat;
      this.Ad[this.Ag] = paramh.id;
      this.Ae[this.Ag] = -1;
      paramh.AT += 1;
      paramh.d(this.zZ);
      this.zY += 1;
      if (!this.Ai)
      {
        this.Ah += 1;
        if (this.Ah >= this.Ad.length)
        {
          this.Ai = true;
          this.Ah = (this.Ad.length - 1);
        }
      }
      AppMethodBeat.o(229880);
      return;
    }
    int i = this.Ag;
    int j = 0;
    int m = -1;
    while ((i != -1) && (j < this.zY))
    {
      if (this.Ad[i] == paramh.id)
      {
        this.Af[i] = paramFloat;
        AppMethodBeat.o(229880);
        return;
      }
      if (this.Ad[i] < paramh.id) {
        m = i;
      }
      i = this.Ae[i];
      j += 1;
    }
    i = this.Ah + 1;
    int k;
    if (this.Ai)
    {
      if (this.Ad[this.Ah] == -1) {
        i = this.Ah;
      }
    }
    else
    {
      j = i;
      if (i >= this.Ad.length)
      {
        j = i;
        if (this.zY < this.Ad.length)
        {
          k = 0;
          label294:
          j = i;
          if (k < this.Ad.length)
          {
            if (this.Ad[k] != -1) {
              break label559;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.Ad.length)
      {
        i = this.Ad.length;
        this.Ab *= 2;
        this.Ai = false;
        this.Ah = (i - 1);
        this.Af = Arrays.copyOf(this.Af, this.Ab);
        this.Ad = Arrays.copyOf(this.Ad, this.Ab);
        this.Ae = Arrays.copyOf(this.Ae, this.Ab);
      }
      this.Ad[i] = paramh.id;
      this.Af[i] = paramFloat;
      if (m == -1) {
        break label568;
      }
      int[] arrayOfInt = this.Ae;
      arrayOfInt[i] = arrayOfInt[m];
      this.Ae[m] = i;
    }
    for (;;)
    {
      paramh.AT += 1;
      paramh.d(this.zZ);
      this.zY += 1;
      if (!this.Ai) {
        this.Ah += 1;
      }
      if (this.zY >= this.Ad.length) {
        this.Ai = true;
      }
      if (this.Ah >= this.Ad.length)
      {
        this.Ai = true;
        this.Ah = (this.Ad.length - 1);
      }
      AppMethodBeat.o(229880);
      return;
      i = this.Ad.length;
      break;
      label559:
      k += 1;
      break label294;
      label568:
      this.Ae[i] = this.Ag;
      this.Ag = i;
    }
  }
  
  final void a(h paramh, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(229886);
    if (paramFloat == 0.0F)
    {
      AppMethodBeat.o(229886);
      return;
    }
    if (this.Ag == -1)
    {
      this.Ag = 0;
      this.Af[this.Ag] = paramFloat;
      this.Ad[this.Ag] = paramh.id;
      this.Ae[this.Ag] = -1;
      paramh.AT += 1;
      paramh.d(this.zZ);
      this.zY += 1;
      if (!this.Ai)
      {
        this.Ah += 1;
        if (this.Ah >= this.Ad.length)
        {
          this.Ai = true;
          this.Ah = (this.Ad.length - 1);
        }
      }
      AppMethodBeat.o(229886);
      return;
    }
    int i = this.Ag;
    int j = 0;
    int m = -1;
    Object localObject;
    while ((i != -1) && (j < this.zY))
    {
      if (this.Ad[i] == paramh.id)
      {
        localObject = this.Af;
        localObject[i] += paramFloat;
        if (this.Af[i] == 0.0F)
        {
          if (i != this.Ag) {
            break label284;
          }
          this.Ag = this.Ae[i];
        }
        for (;;)
        {
          if (paramBoolean) {
            paramh.e(this.zZ);
          }
          if (this.Ai) {
            this.Ah = i;
          }
          paramh.AT -= 1;
          this.zY -= 1;
          AppMethodBeat.o(229886);
          return;
          label284:
          localObject = this.Ae;
          localObject[m] = localObject[i];
        }
      }
      if (this.Ad[i] < paramh.id) {
        m = i;
      }
      i = this.Ae[i];
      j += 1;
    }
    i = this.Ah + 1;
    int k;
    if (this.Ai)
    {
      if (this.Ad[this.Ah] == -1) {
        i = this.Ah;
      }
    }
    else
    {
      j = i;
      if (i >= this.Ad.length)
      {
        j = i;
        if (this.zY < this.Ad.length)
        {
          k = 0;
          label406:
          j = i;
          if (k < this.Ad.length)
          {
            if (this.Ad[k] != -1) {
              break label663;
            }
            j = k;
          }
        }
      }
      i = j;
      if (j >= this.Ad.length)
      {
        i = this.Ad.length;
        this.Ab *= 2;
        this.Ai = false;
        this.Ah = (i - 1);
        this.Af = Arrays.copyOf(this.Af, this.Ab);
        this.Ad = Arrays.copyOf(this.Ad, this.Ab);
        this.Ae = Arrays.copyOf(this.Ae, this.Ab);
      }
      this.Ad[i] = paramh.id;
      this.Af[i] = paramFloat;
      if (m == -1) {
        break label672;
      }
      localObject = this.Ae;
      localObject[i] = localObject[m];
      this.Ae[m] = i;
    }
    for (;;)
    {
      paramh.AT += 1;
      paramh.d(this.zZ);
      this.zY += 1;
      if (!this.Ai) {
        this.Ah += 1;
      }
      if (this.Ah >= this.Ad.length)
      {
        this.Ai = true;
        this.Ah = (this.Ad.length - 1);
      }
      AppMethodBeat.o(229886);
      return;
      i = this.Ad.length;
      break;
      label663:
      k += 1;
      break label406;
      label672:
      this.Ae[i] = this.Ag;
      this.Ag = i;
    }
  }
  
  final h aR(int paramInt)
  {
    int j = this.Ag;
    int i = 0;
    while ((j != -1) && (i < this.zY))
    {
      if (i == paramInt) {
        return this.Aa.Aq[this.Ad[j]];
      }
      j = this.Ae[j];
      i += 1;
    }
    return null;
  }
  
  final float aS(int paramInt)
  {
    int j = this.Ag;
    int i = 0;
    while ((j != -1) && (i < this.zY))
    {
      if (i == paramInt) {
        return this.Af[j];
      }
      j = this.Ae[j];
      i += 1;
    }
    return 0.0F;
  }
  
  public final float b(h paramh)
  {
    int j = this.Ag;
    int i = 0;
    while ((j != -1) && (i < this.zY))
    {
      if (this.Ad[j] == paramh.id) {
        return this.Af[j];
      }
      j = this.Ae[j];
      i += 1;
    }
    return 0.0F;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(229891);
    int j = this.Ag;
    int i = 0;
    while ((j != -1) && (i < this.zY))
    {
      h localh = this.Aa.Aq[this.Ad[j]];
      if (localh != null) {
        localh.e(this.zZ);
      }
      j = this.Ae[j];
      i += 1;
    }
    this.Ag = -1;
    this.Ah = -1;
    this.Ai = false;
    this.zY = 0;
    AppMethodBeat.o(229891);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229906);
    String str = "";
    int j = this.Ag;
    int i = 0;
    while ((j != -1) && (i < this.zY))
    {
      str = str + " -> ";
      str = str + this.Af[j] + " : ";
      str = str + this.Aa.Aq[this.Ad[j]];
      j = this.Ae[j];
      i += 1;
    }
    AppMethodBeat.o(229906);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a
 * JD-Core Version:    0.7.0.1
 */