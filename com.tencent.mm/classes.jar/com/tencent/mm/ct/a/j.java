package com.tencent.mm.ct.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class j
{
  private float ObL;
  private int YHg;
  private int YHh;
  private int YHi;
  private float YHj;
  private boolean YHk;
  private int YHl;
  private int YHm;
  private boolean YHn;
  private int YHo;
  private ByteBuffer YHp;
  private ByteBuffer YHq;
  private float[] YHr;
  private ArrayList<m> YHs;
  private int[] YHt;
  private int[] YHu;
  private boolean YHv;
  private int blockSize;
  
  public j()
  {
    AppMethodBeat.i(188190);
    this.YHv = false;
    this.blockSize = 35;
    this.ObL = 1.2F;
    this.YHj = 1.2F;
    this.YHi = 0;
    this.YHg = 0;
    this.YHh = 6;
    this.YHn = false;
    this.YHo = 0;
    this.YHk = false;
    this.YHl = 0;
    this.YHm = 0;
    this.YHr = new float[6];
    this.YHs = new ArrayList();
    this.YHt = new int[10];
    this.YHu = new int[10];
    this.YHp = ByteBuffer.allocate(6125);
    this.YHq = ByteBuffer.allocate(6125);
    AppMethodBeat.o(188190);
  }
  
  private static int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188195);
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
    AppMethodBeat.o(188195);
    return i + (i1 + (paramInt1 + paramInt2 + i8 + i5 + i6 + i7));
  }
  
  private l a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt, int paramInt7)
  {
    AppMethodBeat.i(188210);
    l locall = new l();
    if ((paramInt3 < 0) || (paramInt4 < 0) || (paramInt3 >= paramInt1) || (paramInt4 >= paramInt2))
    {
      locall.ObK = 1;
      locall.YHB = 255.0F;
    }
    paramInt2 = paramArrayOfInt[0];
    int k = 0;
    int i = 0;
    int i2 = 0;
    int m = 0;
    int j;
    int n;
    int i1;
    if (!this.YHv)
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
          n = paramInt3 + m + (paramInt4 + k) * paramInt1;
          if (paramByteBuffer.get(n) < 0)
          {
            n = paramByteBuffer.get(n) + 255;
            label150:
            if (this.YHp.get(j) >= 0) {
              break label265;
            }
          }
          label265:
          for (i1 = this.YHp.get(j) + 255;; i1 = this.YHp.get(j))
          {
            i1 = Math.abs(i1 - n);
            i += i1;
            paramInt2 += n;
            this.YHp.put(j, paramByteBuffer.get((paramInt6 + k) * paramInt1 + (paramInt5 + m)));
            this.YHq.put(j, (byte)i1);
            j += 1;
            m += 1;
            break;
            n = paramByteBuffer.get(n);
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
        this.YHp.put(paramInt2, paramByteBuffer.get(paramInt5 + j + (paramInt6 + i) * paramInt1));
        this.YHq.put(paramInt2, (byte)m);
        paramInt2 += 1;
        j += 1;
      }
      i += 1;
    }
    paramArrayOfInt[0] = i1;
    locall.YHB = (n / (this.blockSize * this.blockSize));
    locall.YHC = (m / (this.blockSize * this.blockSize));
    locall.ObK = 0;
    if ((this.YHn) && (!this.YHv)) {
      a(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt7);
    }
    float f = aK(this.ObL, locall.YHC);
    if (locall.YHC < 120.0F) {
      locall.YHD = 1;
    }
    if (((locall.YHC < 120.0F) && (locall.YHB > this.ObL * f * 0.6F)) || ((locall.YHC > 120.0F) && ((locall.YHB > f * this.ObL * 0.65F) || (locall.YHC > 250.0F)))) {
      locall.ObK = 1;
    }
    AppMethodBeat.o(188210);
    return locall;
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(188197);
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
        i6 = a(this.YHq, this.blockSize, i4 + 2 + (i3 + 2) * k + m * paramInt4 * i6);
        k = 0;
        while (k < 5)
        {
          m = 0;
          while (m < 5)
          {
            int i7 = i2 + m + (i1 + k) * paramInt1;
            int i8 = i4 + m + (i3 + k) * this.blockSize + this.blockSize * paramInt4 * this.blockSize;
            f3 += paramByteBuffer.get(i7);
            f1 += this.YHq.get(i8);
            int i9 = paramByteBuffer.get(i7);
            f4 += paramByteBuffer.get(i7) * i9;
            f2 += this.YHq.get(i8) * this.YHq.get(i8);
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
        m localm1 = new m(false, i5, f4 - f3 * f5);
        m localm2 = new m(true, i6, f1);
        this.YHs.add(localm1);
        this.YHs.add(localm2);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(188197);
  }
  
  private float aK(float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    if (paramFloat2 < 80.0F) {}
    for (;;)
    {
      paramFloat2 = f;
      if (this.YHk) {
        paramFloat2 = f + 1.0F;
      }
      if (paramFloat1 >= 0.8F) {
        break;
      }
      return 4.0F - paramFloat2;
      if (paramFloat2 >= 120.0F) {
        f = 0.5F;
      }
    }
    if (paramFloat1 < 1.5F) {
      return 3.6F - paramFloat2;
    }
    if (paramFloat1 < 2.4F) {
      return 3.2F - paramFloat2;
    }
    return 2.8F - paramFloat2;
  }
  
  private static float bH(ArrayList<m> paramArrayList)
  {
    AppMethodBeat.i(188200);
    float f1 = 0.0F;
    float f2 = 0.0F;
    int k = 16;
    int m = 0;
    int i = 0;
    if ((paramArrayList == null) || (paramArrayList.size() < 16))
    {
      AppMethodBeat.o(188200);
      return 1.2F;
    }
    int j = 0;
    float f3;
    if (j < k)
    {
      m localm = (m)paramArrayList.get(j);
      boolean bool = localm.YHE;
      f3 = localm.YHG;
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
      AppMethodBeat.o(188200);
      return (f6 + f1) * f5 + f3 * (f4 + f2);
      f1 = 1.2F;
      break;
    }
    label220:
    AppMethodBeat.o(188200);
    return 1.2F;
  }
  
  private void bI(ArrayList<m> paramArrayList)
  {
    AppMethodBeat.i(188201);
    Collections.sort(paramArrayList, new Comparator()
    {
      public final int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        paramAnonymousObject1 = (m)paramAnonymousObject1;
        paramAnonymousObject2 = (m)paramAnonymousObject2;
        int i = paramAnonymousObject1.YHF;
        int j = paramAnonymousObject2.YHF;
        if (j < i) {
          return 1;
        }
        if (i < j) {
          return -1;
        }
        return 0;
      }
    });
    AppMethodBeat.o(188201);
  }
  
  private void dd(float paramFloat)
  {
    float f = 4.2F;
    AppMethodBeat.i(188192);
    if (this.YHo == 6)
    {
      float[] arrayOfFloat = this.YHr;
      paramFloat = 0.0F;
      int j = arrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        paramFloat += arrayOfFloat[i];
        i += 1;
      }
      paramFloat /= arrayOfFloat.length;
      this.YHo = 0;
      if (this.YHg > 7200)
      {
        this.blockSize = 35;
        this.ObL = 1.2F;
        this.YHj = 1.2F;
        this.YHi = 0;
        this.YHg = 0;
        this.YHn = false;
        this.YHo = 0;
        this.YHh = 6;
        this.YHs.clear();
        this.YHp.clear();
        this.YHq.clear();
      }
      if (Math.abs(paramFloat - this.YHj) < 4.0F)
      {
        if (paramFloat <= 4.2F) {
          break label195;
        }
        paramFloat = f;
      }
      label195:
      for (;;)
      {
        this.ObL = (paramFloat * 0.5F + this.YHj * 0.5F);
        this.YHj = this.ObL;
        AppMethodBeat.o(188192);
        return;
      }
    }
    this.YHr[this.YHo] = (2.0F * paramFloat);
    this.YHo += 1;
    AppMethodBeat.o(188192);
  }
  
  private void nm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188203);
    int i = paramInt1 / 2 - this.blockSize;
    int j = paramInt2 / 3 - this.blockSize;
    int k = (int)(Math.random() * j);
    int m = (int)(Math.random() * i);
    this.YHt[0] = k;
    this.YHt[1] = m;
    k = (int)(Math.random() * j);
    m = (int)(Math.random() * i + paramInt1 / 2);
    this.YHt[2] = k;
    this.YHt[3] = m;
    k = (int)(Math.random() * j + paramInt2 / 3);
    m = (int)(Math.random() * (i * 2));
    this.YHt[4] = k;
    this.YHt[5] = m;
    k = (int)(Math.random() * j + paramInt2 * 2 / 3);
    m = (int)(Math.random() * i);
    this.YHt[6] = k;
    this.YHt[7] = m;
    paramInt2 = (int)(Math.random() * j + paramInt2 * 2 / 3);
    paramInt1 = (int)(Math.random() * i + paramInt1 / 2);
    this.YHt[8] = paramInt2;
    this.YHt[9] = paramInt1;
    AppMethodBeat.o(188203);
  }
  
  public final int T(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188204);
    paramInt1 = b(ByteBuffer.wrap(paramArrayOfByte), paramInt1, paramInt2);
    AppMethodBeat.o(188204);
    return paramInt1;
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188207);
    if ((paramByteBuffer == null) || (paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 < 320) || (paramInt2 < 100) || (paramInt1 > 1280) || (paramInt2 > 720))
    {
      AppMethodBeat.o(188207);
      return 4;
    }
    n localn;
    if ((paramInt1 == 0) || (paramInt1 != this.YHl) || (paramInt2 != this.YHm))
    {
      this.YHl = paramInt1;
      this.YHm = paramInt2;
      this.YHv = true;
      if (this.YHq == null) {
        this.YHq = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
      }
      if (this.YHp == null) {
        this.YHp = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
      }
      localn = new n();
      nm(paramInt1, paramInt2);
      this.YHg += 1;
      if (this.YHg % this.YHh != 0) {
        break label312;
      }
    }
    label312:
    for (boolean bool = true;; bool = false)
    {
      this.YHn = bool;
      int i = 0;
      while (i < 5)
      {
        int j = this.YHu[(i * 2)];
        int k = this.YHu[(i * 2 + 1)];
        int m = this.YHt[(i * 2)];
        int n = this.YHt[(i * 2 + 1)];
        localn.YHH[i] = a(paramByteBuffer, paramInt1, paramInt2, k, j, n, m, new int[] { 0 }, i);
        this.YHu[(i * 2)] = m;
        this.YHu[(i * 2 + 1)] = n;
        i += 1;
      }
      this.YHv = false;
      break;
    }
    localn.YHI.ObK = (localn.YHH[0].ObK + localn.YHH[1].ObK + localn.YHH[2].ObK + localn.YHH[3].ObK + localn.YHH[4].ObK);
    localn.YHI.YHC = ((localn.YHH[0].YHC + localn.YHH[1].YHC + localn.YHH[2].YHC + localn.YHH[3].YHC + localn.YHH[4].YHC) / 5.0F);
    localn.YHI.YHB = ((localn.YHH[0].YHB + localn.YHH[1].YHB + localn.YHH[2].YHB + localn.YHH[3].YHB + localn.YHH[4].YHB) / 5.0F);
    localn.YHI.YHD = (localn.YHH[0].YHD + localn.YHH[1].YHD + localn.YHH[2].YHD + localn.YHH[3].YHD + localn.YHH[4].YHD);
    if ((this.YHn) && (!this.YHv))
    {
      bI(this.YHs);
      f = bH(this.YHs);
      this.YHs.clear();
      dd(f);
    }
    float f = aK(this.ObL, localn.YHI.YHC);
    if ((localn.YHI.YHB > f * this.ObL * 1.2F) || (localn.YHI.ObK >= 3) || (localn.YHI.YHD >= 4))
    {
      this.YHi = 0;
      AppMethodBeat.o(188207);
      return 4;
    }
    if (this.YHi > 5)
    {
      AppMethodBeat.o(188207);
      return 0;
    }
    this.YHi += 1;
    AppMethodBeat.o(188207);
    return 4;
  }
  
  public final float igy()
  {
    float f1 = 0.025F;
    float f2 = this.ObL * 0.016F;
    if (f2 > 0.025F) {}
    while (f1 < 0.012F)
    {
      return 0.012F;
      f1 = f2;
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.j
 * JD-Core Version:    0.7.0.1
 */