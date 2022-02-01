package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class k
{
  private float HkW;
  private int[] RgA;
  private boolean RgB;
  private int Rgm;
  private int Rgn;
  private int Rgo;
  private float Rgp;
  private boolean Rgq;
  private int Rgr;
  private int Rgs;
  private boolean Rgt;
  private int Rgu;
  private ByteBuffer Rgv;
  private ByteBuffer Rgw;
  private float[] Rgx;
  private ArrayList<n> Rgy;
  private int[] Rgz;
  private int blockSize;
  
  public k()
  {
    AppMethodBeat.i(190273);
    this.RgB = false;
    this.blockSize = 35;
    this.HkW = 1.2F;
    this.Rgp = 1.2F;
    this.Rgo = 0;
    this.Rgm = 0;
    this.Rgn = 6;
    this.Rgt = false;
    this.Rgu = 0;
    this.Rgq = false;
    this.Rgr = 0;
    this.Rgs = 0;
    this.Rgx = new float[6];
    this.Rgy = new ArrayList();
    this.Rgz = new int[10];
    this.RgA = new int[10];
    this.Rgv = ByteBuffer.allocate(6125);
    this.Rgw = ByteBuffer.allocate(6125);
    AppMethodBeat.o(190273);
  }
  
  private static int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190275);
    int i = paramByteBuffer.get(paramInt2) & 0xFF;
    int i1 = paramByteBuffer.get(paramInt2 - 1) & 0xFF;
    int i2 = paramByteBuffer.get(paramInt2 - 2) & 0xFF;
    int j = paramByteBuffer.get(paramInt2 + 1) & 0xFF;
    int k = paramByteBuffer.get(paramInt2 + 2) & 0xFF;
    int i3 = paramByteBuffer.get(paramInt2 - paramInt1) & 0xFF;
    int i4 = paramByteBuffer.get(paramInt2 - paramInt1 * 2) & 0xFF;
    int m = paramByteBuffer.get(paramInt2 + paramInt1) & 0xFF;
    int n = paramByteBuffer.get(paramInt1 * 2 + paramInt2) & 0xFF;
    int i8 = paramByteBuffer.get(paramInt2 - paramInt1 - 1);
    int i9 = paramByteBuffer.get(paramInt2 - paramInt1 * 2 - 2);
    int i10 = paramByteBuffer.get(paramInt2 + paramInt1 + 1);
    int i11 = paramByteBuffer.get(paramInt1 * 2 + paramInt2 + 2);
    int i5 = paramByteBuffer.get(paramInt2 - paramInt1 + 1);
    int i6 = paramByteBuffer.get(paramInt2 - paramInt1 * 2 + 2);
    int i7 = paramByteBuffer.get(paramInt2 + paramInt1 - 1);
    int i12 = paramByteBuffer.get(paramInt1 * 2 + paramInt2 - 2);
    paramInt1 = Math.abs(i * 4 - i1 - i2 - j - k);
    paramInt2 = Math.abs(i * 4 - i3 - i4 - m - n);
    i8 = Math.abs(i * 4 - (i8 & 0xFF) - (i9 & 0xFF) - (i10 & 0xFF) - (i11 & 0xFF));
    i5 = Math.abs(i * 4 - (i5 & 0xFF) - (i6 & 0xFF) - (i7 & 0xFF) - (i12 & 0xFF));
    i6 = Math.abs(i * 4 - i3 - i4 - j - k);
    i7 = Math.abs(i * 4 - i1 - i2 - m - n);
    i1 = Math.abs(i * 4 - i1 - i2 - i3 - i4);
    i = Math.abs(i * 4 - m - n - j - k);
    AppMethodBeat.o(190275);
    return i + (i1 + (paramInt1 + paramInt2 + i8 + i5 + i6 + i7));
  }
  
  private m a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt, int paramInt7)
  {
    AppMethodBeat.i(190282);
    m localm = new m();
    if ((paramInt3 < 0) || (paramInt4 < 0) || (paramInt3 >= paramInt1) || (paramInt4 >= paramInt2))
    {
      localm.HkV = 1;
      localm.RgH = 255.0F;
    }
    paramInt2 = paramArrayOfInt[0];
    int k = 0;
    int i = 0;
    int i2 = 0;
    int m = 0;
    int j;
    int n;
    int i1;
    if (!this.RgB)
    {
      k = 0;
      j = paramInt2;
      paramInt2 = m;
      for (;;)
      {
        m = paramInt2;
        n = i;
        i1 = j;
        if (k >= this.blockSize) {
          break;
        }
        m = 0;
        if (m < this.blockSize)
        {
          i2 = paramInt3 + m + (paramInt4 + k) * paramInt1;
          if (paramByteBuffer.get(i2) < 0)
          {
            n = paramByteBuffer.get(i2) + 255;
            label150:
            if (this.Rgv.get(j) >= 0) {
              break label269;
            }
          }
          label269:
          for (i1 = this.Rgv.get(j) + 255;; i1 = this.Rgv.get(j))
          {
            n = Math.abs(i1 - n);
            i += n;
            paramInt2 += paramByteBuffer.get(i2);
            this.Rgv.put(j, paramByteBuffer.get(paramInt5 + m + (paramInt6 + k) * paramInt1));
            this.Rgw.put(j, (byte)n);
            j += 1;
            m += 1;
            break;
            n = paramByteBuffer.get(i2);
            break label150;
          }
        }
        k += 1;
      }
    }
    i = 0;
    for (;;)
    {
      m = i2;
      n = k;
      i1 = paramInt2;
      if (i >= this.blockSize) {
        break;
      }
      j = 0;
      while (j < this.blockSize)
      {
        m = Math.abs(0);
        this.Rgv.put(paramInt2, paramByteBuffer.get(paramInt5 + j + (paramInt6 + i) * paramInt1));
        this.Rgw.put(paramInt2, (byte)m);
        paramInt2 += 1;
        j += 1;
      }
      i += 1;
    }
    paramArrayOfInt[0] = i1;
    localm.RgH = (n / (this.blockSize * this.blockSize));
    localm.RgI = (m / (this.blockSize * this.blockSize));
    if (localm.RgI < 0.0F) {}
    for (float f = localm.RgI + 255.0F;; f = localm.RgI)
    {
      localm.RgI = f;
      localm.HkV = 0;
      if ((this.Rgt) && (!this.RgB)) {
        a(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt7);
      }
      f = aC(this.HkW, localm.RgI);
      if (((localm.RgI < 100.0F) && (localm.RgH > this.HkW * f * 0.8F)) || ((localm.RgI > 100.0F) && ((localm.RgH > f * this.HkW * 0.65F) || (localm.RgI > 250.0F)))) {
        localm.HkV = 1;
      }
      AppMethodBeat.o(190282);
      return localm;
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190276);
    int n = this.blockSize / 5;
    int i = 0;
    while (i < n)
    {
      int j = 0;
      while (j < n)
      {
        int i1 = paramInt3 + i * 5;
        int i2 = paramInt2 + j * 5;
        int i3 = i * 5;
        int i4 = j * 5;
        float f4 = 0.0F;
        float f3 = 0.0F;
        float f2 = 0.0F;
        float f1 = 0.0F;
        int k = this.blockSize;
        int m = this.blockSize;
        int i6 = this.blockSize;
        int i5 = a(paramByteBuffer, paramInt1, i2 + 2 + (i1 + 2) * paramInt1);
        i6 = a(this.Rgw, this.blockSize, i4 + 2 + (i3 + 2) * k + m * paramInt4 * i6);
        k = 0;
        while (k < 5)
        {
          m = 0;
          while (m < 5)
          {
            int i7 = i2 + m + (i1 + k) * paramInt1;
            int i8 = i4 + m + (i3 + k) * this.blockSize + this.blockSize * paramInt4 * this.blockSize;
            f3 += paramByteBuffer.get(i7);
            f1 += this.Rgw.get(i8);
            int i9 = paramByteBuffer.get(i7);
            f4 += paramByteBuffer.get(i7) * i9;
            f2 += this.Rgw.get(i8) * this.Rgw.get(i8);
            m += 1;
          }
          k += 1;
        }
        f4 /= 25.0F;
        float f5 = f3 / 25.0F;
        f3 /= 25.0F;
        f2 /= 25.0F;
        float f6 = f1 / 25.0F;
        f1 = (f2 - f1 / 25.0F * f6) / 2.0F;
        n localn1 = new n(false, i5, f4 - f3 * f5);
        n localn2 = new n(true, i6, f1);
        this.Rgy.add(localn1);
        this.Rgy.add(localn2);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(190276);
  }
  
  private float aC(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 < 80.0F) {
      paramFloat2 = -0.5F;
    }
    float f;
    for (;;)
    {
      f = paramFloat2;
      if (this.Rgq) {
        f = paramFloat2 + 1.0F;
      }
      if (paramFloat1 >= 0.8F) {
        break;
      }
      return 5.0F - f;
      if (paramFloat2 < 120.0F) {
        paramFloat2 = 0.0F;
      } else {
        paramFloat2 = 0.5F;
      }
    }
    if (paramFloat1 < 1.5F) {
      return 4.5F - f;
    }
    if (paramFloat1 < 2.4F) {
      return 4.0F - f;
    }
    return 3.5F - f;
  }
  
  private static float bs(ArrayList<n> paramArrayList)
  {
    AppMethodBeat.i(190277);
    float f1 = 0.0F;
    float f2 = 0.0F;
    int k = 16;
    int m = 0;
    int i = 0;
    if ((paramArrayList == null) || (paramArrayList.size() < 16))
    {
      AppMethodBeat.o(190277);
      return 1.2F;
    }
    int j = 0;
    float f3;
    if (j < k)
    {
      n localn = (n)paramArrayList.get(j);
      boolean bool = localn.RgJ;
      f3 = localn.RgL;
      if (f3 > 5.0D) {
        k -= 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (!bool)
        {
          f1 += f3;
          m += 1;
        }
        else
        {
          f2 += f3;
          i += 1;
        }
      }
    }
    if (m != 0)
    {
      f1 /= m;
      if (i == 0) {
        break label214;
      }
    }
    label214:
    for (f2 /= i;; f2 = 1.2F)
    {
      if (k == 0) {
        break label220;
      }
      f3 = i / k;
      float f4 = f1 / 2.0F;
      float f5 = m / k;
      float f6 = f2 / 2.0F;
      f1 /= 3.5F;
      AppMethodBeat.o(190277);
      return (f6 + f1) * f5 + f3 * (f4 + f2);
      f1 = 1.2F;
      break;
    }
    label220:
    AppMethodBeat.o(190277);
    return 1.2F;
  }
  
  private void bt(ArrayList<n> paramArrayList)
  {
    AppMethodBeat.i(190278);
    Collections.sort(paramArrayList, new Comparator()
    {
      public final int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        paramAnonymousObject1 = (n)paramAnonymousObject1;
        paramAnonymousObject2 = (n)paramAnonymousObject2;
        int i = paramAnonymousObject1.RgK;
        int j = paramAnonymousObject2.RgK;
        if (j < i) {
          return 1;
        }
        if (i < j) {
          return -1;
        }
        return 0;
      }
    });
    AppMethodBeat.o(190278);
  }
  
  private void cI(float paramFloat)
  {
    float f = 4.2F;
    AppMethodBeat.i(190274);
    if (this.Rgu == 6)
    {
      float[] arrayOfFloat = this.Rgx;
      paramFloat = 0.0F;
      int j = arrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        paramFloat += arrayOfFloat[i];
        i += 1;
      }
      paramFloat /= arrayOfFloat.length;
      this.Rgu = 0;
      if (this.Rgm > 7200)
      {
        this.blockSize = 35;
        this.HkW = 1.2F;
        this.Rgp = 1.2F;
        this.Rgo = 0;
        this.Rgm = 0;
        this.Rgt = false;
        this.Rgu = 0;
        this.Rgn = 6;
        this.Rgy.clear();
        this.Rgv.clear();
        this.Rgw.clear();
      }
      if (Math.abs(paramFloat - this.Rgp) < 4.0F)
      {
        if (paramFloat <= 4.2F) {
          break label195;
        }
        paramFloat = f;
      }
      label195:
      for (;;)
      {
        this.HkW = (paramFloat * 0.5F + this.Rgp * 0.5F);
        this.Rgp = this.HkW;
        AppMethodBeat.o(190274);
        return;
      }
    }
    this.Rgx[this.Rgu] = (2.0F * paramFloat);
    this.Rgu += 1;
    AppMethodBeat.o(190274);
  }
  
  private void lV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190279);
    int i = paramInt1 / 2 - this.blockSize;
    int j = paramInt2 / 3 - this.blockSize;
    int k = (int)(Math.random() * j);
    int m = (int)(Math.random() * i);
    this.Rgz[0] = k;
    this.Rgz[1] = m;
    k = (int)(Math.random() * j);
    m = (int)(Math.random() * i + paramInt1 / 2);
    this.Rgz[2] = k;
    this.Rgz[3] = m;
    k = (int)(Math.random() * j + paramInt2 / 3);
    m = (int)(Math.random() * (i * 2));
    this.Rgz[4] = k;
    this.Rgz[5] = m;
    k = (int)(Math.random() * j + paramInt2 * 2 / 3);
    m = (int)(Math.random() * i);
    this.Rgz[6] = k;
    this.Rgz[7] = m;
    paramInt2 = (int)(Math.random() * j + paramInt2 * 2 / 3);
    paramInt1 = (int)(Math.random() * i + paramInt1 / 2);
    this.Rgz[8] = paramInt2;
    this.Rgz[9] = paramInt1;
    AppMethodBeat.o(190279);
  }
  
  public final int R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190280);
    paramInt1 = b(ByteBuffer.wrap(paramArrayOfByte), paramInt1, paramInt2);
    AppMethodBeat.o(190280);
    return paramInt1;
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190281);
    if ((paramByteBuffer == null) || (paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 < 320) || (paramInt2 < 100) || (paramInt1 > 1280) || (paramInt2 > 720))
    {
      AppMethodBeat.o(190281);
      return 4;
    }
    o localo;
    if ((paramInt1 == 0) || (paramInt1 != this.Rgr) || (paramInt2 != this.Rgs))
    {
      this.Rgr = paramInt1;
      this.Rgs = paramInt2;
      this.RgB = true;
      if (this.Rgw == null) {
        this.Rgw = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
      }
      if (this.Rgv == null) {
        this.Rgv = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
      }
      localo = new o();
      lV(paramInt1, paramInt2);
      this.Rgm += 1;
      if (this.Rgm % this.Rgn != 0) {
        break label312;
      }
    }
    label312:
    for (boolean bool = true;; bool = false)
    {
      this.Rgt = bool;
      int i = 0;
      while (i < 5)
      {
        int j = this.RgA[(i * 2)];
        int k = this.RgA[(i * 2 + 1)];
        int m = this.Rgz[(i * 2)];
        int n = this.Rgz[(i * 2 + 1)];
        localo.RgM[i] = a(paramByteBuffer, paramInt1, paramInt2, k, j, n, m, new int[] { 0 }, i);
        this.RgA[(i * 2)] = m;
        this.RgA[(i * 2 + 1)] = n;
        i += 1;
      }
      this.RgB = false;
      break;
    }
    localo.RgN.HkV = (localo.RgM[0].HkV + localo.RgM[1].HkV + localo.RgM[2].HkV + localo.RgM[3].HkV + localo.RgM[4].HkV);
    localo.RgN.RgI = ((localo.RgM[0].RgI + localo.RgM[1].RgI + localo.RgM[2].RgI + localo.RgM[3].RgI + localo.RgM[4].RgI) / 5.0F);
    localo.RgN.RgH = ((localo.RgM[0].RgH + localo.RgM[1].RgH + localo.RgM[2].RgH + localo.RgM[3].RgH + localo.RgM[4].RgH) / 5.0F);
    if ((this.Rgt) && (!this.RgB))
    {
      bt(this.Rgy);
      f = bs(this.Rgy);
      this.Rgy.clear();
      cI(f);
    }
    float f = aC(this.HkW, localo.RgN.RgI);
    if ((localo.RgN.RgH > f * this.HkW * 2.0F) || (localo.RgN.HkV >= 5))
    {
      this.Rgo = 0;
      AppMethodBeat.o(190281);
      return 5;
    }
    if (this.Rgo > 3)
    {
      AppMethodBeat.o(190281);
      return 0;
    }
    this.Rgo += 1;
    AppMethodBeat.o(190281);
    return 4;
  }
  
  public final float hff()
  {
    float f1 = 0.032F;
    float f2 = this.HkW * 0.016F;
    if (f2 > 0.032F) {}
    while (f1 < 0.016F)
    {
      return 0.016F;
      f1 = f2;
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.k
 * JD-Core Version:    0.7.0.1
 */