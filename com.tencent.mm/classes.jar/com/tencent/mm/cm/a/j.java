package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class j
{
  private float UPH;
  private int agCM;
  private int agCN;
  private int agCO;
  private float agCP;
  private int agCQ;
  private int agCR;
  private boolean agCS;
  private int agCT;
  private ByteBuffer agCU;
  private ByteBuffer agCV;
  private float[] agCW;
  private ArrayList<m> agCX;
  private int[] agCY;
  private int[] agCZ;
  private boolean agDa;
  private int blockSize;
  private boolean nvA;
  
  public j()
  {
    AppMethodBeat.i(231111);
    this.agDa = false;
    this.blockSize = 35;
    this.UPH = 1.2F;
    this.agCP = 1.2F;
    this.agCO = 0;
    this.agCM = 0;
    this.agCN = 6;
    this.agCS = false;
    this.agCT = 0;
    this.nvA = false;
    this.agCQ = 0;
    this.agCR = 0;
    this.agCW = new float[6];
    this.agCX = new ArrayList();
    this.agCY = new int[10];
    this.agCZ = new int[10];
    this.agCU = ByteBuffer.allocate(6125);
    this.agCV = ByteBuffer.allocate(6125);
    AppMethodBeat.o(231111);
  }
  
  private l a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt, int paramInt7)
  {
    AppMethodBeat.i(231152);
    l locall = new l();
    if ((paramInt3 < 0) || (paramInt4 < 0) || (paramInt3 >= paramInt1) || (paramInt4 >= paramInt2))
    {
      locall.UPG = 1;
      locall.agDg = 255.0F;
    }
    paramInt2 = paramArrayOfInt[0];
    int k = 0;
    int i = 0;
    int i2 = 0;
    int m = 0;
    int j;
    int n;
    int i1;
    if (!this.agDa)
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
            if (this.agCU.get(j) >= 0) {
              break label265;
            }
          }
          label265:
          for (i1 = this.agCU.get(j) + 255;; i1 = this.agCU.get(j))
          {
            i1 = Math.abs(i1 - n);
            i += i1;
            paramInt2 += n;
            this.agCU.put(j, paramByteBuffer.get((paramInt6 + k) * paramInt1 + (paramInt5 + m)));
            this.agCV.put(j, (byte)i1);
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
        this.agCU.put(paramInt2, paramByteBuffer.get(paramInt5 + j + (paramInt6 + i) * paramInt1));
        this.agCV.put(paramInt2, (byte)m);
        paramInt2 += 1;
        j += 1;
      }
      i += 1;
    }
    paramArrayOfInt[0] = i1;
    locall.agDg = (n / (this.blockSize * this.blockSize));
    locall.agDh = (m / (this.blockSize * this.blockSize));
    locall.UPG = 0;
    if ((this.agCS) && (!this.agDa)) {
      a(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt7);
    }
    float f = bo(this.UPH, locall.agDh);
    if (locall.agDh < 120.0F) {
      locall.agDi = 1;
    }
    if (((locall.agDh < 120.0F) && (locall.agDg > this.UPH * f * 0.6F)) || ((locall.agDh > 120.0F) && ((locall.agDg > f * this.UPH * 0.65F) || (locall.agDh > 250.0F)))) {
      locall.UPG = 1;
    }
    AppMethodBeat.o(231152);
    return locall;
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(231125);
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
        int i5 = f(paramByteBuffer, paramInt1, i2 + 2 + (i1 + 2) * paramInt1);
        i6 = f(this.agCV, this.blockSize, i4 + 2 + (i3 + 2) * k + m * paramInt4 * i6);
        k = 0;
        while (k < 5)
        {
          m = 0;
          while (m < 5)
          {
            int i7 = i2 + m + (i1 + k) * paramInt1;
            int i8 = i4 + m + (i3 + k) * this.blockSize + this.blockSize * paramInt4 * this.blockSize;
            f3 += paramByteBuffer.get(i7);
            f1 += this.agCV.get(i8);
            int i9 = paramByteBuffer.get(i7);
            f4 += paramByteBuffer.get(i7) * i9;
            f2 += this.agCV.get(i8) * this.agCV.get(i8);
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
        this.agCX.add(localm1);
        this.agCX.add(localm2);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(231125);
  }
  
  private float bo(float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    if (paramFloat2 < 80.0F) {}
    for (;;)
    {
      paramFloat2 = f;
      if (this.nvA) {
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
  
  private static float ch(ArrayList<m> paramArrayList)
  {
    AppMethodBeat.i(231131);
    float f1 = 0.0F;
    float f2 = 0.0F;
    int k = 16;
    int m = 0;
    int i = 0;
    if ((paramArrayList == null) || (paramArrayList.size() < 16))
    {
      AppMethodBeat.o(231131);
      return 1.2F;
    }
    int j = 0;
    float f3;
    if (j < k)
    {
      m localm = (m)paramArrayList.get(j);
      boolean bool = localm.agDj;
      f3 = localm.agDl;
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
      AppMethodBeat.o(231131);
      return (f6 + f1) * f5 + f3 * (f4 + f2);
      f1 = 1.2F;
      break;
    }
    label220:
    AppMethodBeat.o(231131);
    return 1.2F;
  }
  
  private void ci(ArrayList<m> paramArrayList)
  {
    AppMethodBeat.i(231135);
    Collections.sort(paramArrayList, new Comparator()
    {
      public final int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        paramAnonymousObject1 = (m)paramAnonymousObject1;
        paramAnonymousObject2 = (m)paramAnonymousObject2;
        int i = paramAnonymousObject1.agDk;
        int j = paramAnonymousObject2.agDk;
        if (j < i) {
          return 1;
        }
        if (i < j) {
          return -1;
        }
        return 0;
      }
    });
    AppMethodBeat.o(231135);
  }
  
  private void es(float paramFloat)
  {
    float f = 4.2F;
    AppMethodBeat.i(231114);
    if (this.agCT == 6)
    {
      float[] arrayOfFloat = this.agCW;
      paramFloat = 0.0F;
      int j = arrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        paramFloat += arrayOfFloat[i];
        i += 1;
      }
      paramFloat /= arrayOfFloat.length;
      this.agCT = 0;
      if (this.agCM > 7200)
      {
        this.blockSize = 35;
        this.UPH = 1.2F;
        this.agCP = 1.2F;
        this.agCO = 0;
        this.agCM = 0;
        this.agCS = false;
        this.agCT = 0;
        this.agCN = 6;
        this.agCX.clear();
        this.agCU.clear();
        this.agCV.clear();
      }
      if (Math.abs(paramFloat - this.agCP) < 4.0F)
      {
        if (paramFloat <= 4.2F) {
          break label195;
        }
        paramFloat = f;
      }
      label195:
      for (;;)
      {
        this.UPH = (paramFloat * 0.5F + this.agCP * 0.5F);
        this.agCP = this.UPH;
        AppMethodBeat.o(231114);
        return;
      }
    }
    this.agCW[this.agCT] = (2.0F * paramFloat);
    this.agCT += 1;
    AppMethodBeat.o(231114);
  }
  
  private static int f(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231118);
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
    AppMethodBeat.o(231118);
    return i + (i1 + (paramInt1 + paramInt2 + i8 + i5 + i6 + i7));
  }
  
  private void pj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231143);
    int i = paramInt1 / 2 - this.blockSize;
    int j = paramInt2 / 3 - this.blockSize;
    int k = (int)(Math.random() * j);
    int m = (int)(Math.random() * i);
    this.agCY[0] = k;
    this.agCY[1] = m;
    k = (int)(Math.random() * j);
    m = (int)(Math.random() * i + paramInt1 / 2);
    this.agCY[2] = k;
    this.agCY[3] = m;
    k = (int)(Math.random() * j + paramInt2 / 3);
    m = (int)(Math.random() * (i * 2));
    this.agCY[4] = k;
    this.agCY[5] = m;
    k = (int)(Math.random() * j + paramInt2 * 2 / 3);
    m = (int)(Math.random() * i);
    this.agCY[6] = k;
    this.agCY[7] = m;
    paramInt2 = (int)(Math.random() * j + paramInt2 * 2 / 3);
    paramInt1 = (int)(Math.random() * i + paramInt1 / 2);
    this.agCY[8] = paramInt2;
    this.agCY[9] = paramInt1;
    AppMethodBeat.o(231143);
  }
  
  public final int Q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231161);
    paramInt1 = g(ByteBuffer.wrap(paramArrayOfByte), paramInt1, paramInt2);
    AppMethodBeat.o(231161);
    return paramInt1;
  }
  
  public final int g(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231168);
    if ((paramByteBuffer == null) || (paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 < 320) || (paramInt2 < 100) || (paramInt1 > 1280) || (paramInt2 > 720))
    {
      AppMethodBeat.o(231168);
      return 4;
    }
    n localn;
    if ((paramInt1 == 0) || (paramInt1 != this.agCQ) || (paramInt2 != this.agCR))
    {
      this.agCQ = paramInt1;
      this.agCR = paramInt2;
      this.agDa = true;
      if (this.agCV == null) {
        this.agCV = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
      }
      if (this.agCU == null) {
        this.agCU = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
      }
      localn = new n();
      pj(paramInt1, paramInt2);
      this.agCM += 1;
      if (this.agCM % this.agCN != 0) {
        break label312;
      }
    }
    label312:
    for (boolean bool = true;; bool = false)
    {
      this.agCS = bool;
      int i = 0;
      while (i < 5)
      {
        int j = this.agCZ[(i * 2)];
        int k = this.agCZ[(i * 2 + 1)];
        int m = this.agCY[(i * 2)];
        int n = this.agCY[(i * 2 + 1)];
        localn.agDm[i] = a(paramByteBuffer, paramInt1, paramInt2, k, j, n, m, new int[] { 0 }, i);
        this.agCZ[(i * 2)] = m;
        this.agCZ[(i * 2 + 1)] = n;
        i += 1;
      }
      this.agDa = false;
      break;
    }
    localn.agDn.UPG = (localn.agDm[0].UPG + localn.agDm[1].UPG + localn.agDm[2].UPG + localn.agDm[3].UPG + localn.agDm[4].UPG);
    localn.agDn.agDh = ((localn.agDm[0].agDh + localn.agDm[1].agDh + localn.agDm[2].agDh + localn.agDm[3].agDh + localn.agDm[4].agDh) / 5.0F);
    localn.agDn.agDg = ((localn.agDm[0].agDg + localn.agDm[1].agDg + localn.agDm[2].agDg + localn.agDm[3].agDg + localn.agDm[4].agDg) / 5.0F);
    localn.agDn.agDi = (localn.agDm[0].agDi + localn.agDm[1].agDi + localn.agDm[2].agDi + localn.agDm[3].agDi + localn.agDm[4].agDi);
    if ((this.agCS) && (!this.agDa))
    {
      ci(this.agCX);
      f = ch(this.agCX);
      this.agCX.clear();
      es(f);
    }
    float f = bo(this.UPH, localn.agDn.agDh);
    if ((localn.agDn.agDg > f * this.UPH * 1.2F) || (localn.agDn.UPG >= 3) || (localn.agDn.agDi >= 4))
    {
      this.agCO = 0;
      AppMethodBeat.o(231168);
      return 4;
    }
    if (this.agCO > 5)
    {
      AppMethodBeat.o(231168);
      return 0;
    }
    this.agCO += 1;
    AppMethodBeat.o(231168);
    return 4;
  }
  
  public final float jLL()
  {
    float f1 = 0.025F;
    float f2 = this.UPH * 0.016F;
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
 * Qualified Name:     com.tencent.mm.cm.a.j
 * JD-Core Version:    0.7.0.1
 */