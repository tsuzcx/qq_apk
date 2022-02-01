package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class e
  implements a
{
  private static final String TAG;
  private byte[] aBF;
  private ByteBuffer aBG;
  private c aBH;
  private int[] aBI;
  private final int[] aBJ;
  private final a.a aBK;
  private short[] aBL;
  private byte[] aBM;
  private byte[] aBN;
  private byte[] aBO;
  private int[] aBP;
  private int aBQ;
  private Bitmap aBR;
  private boolean aBS;
  private int aBT;
  private int aBU;
  private Boolean aBV;
  private Bitmap.Config aBW;
  private int sampleSize;
  private int status;
  
  static
  {
    AppMethodBeat.i(3487);
    TAG = e.class.getSimpleName();
    AppMethodBeat.o(3487);
  }
  
  private e(a.a parama)
  {
    AppMethodBeat.i(3477);
    this.aBJ = new int[256];
    this.aBW = Bitmap.Config.ARGB_8888;
    this.aBK = parama;
    this.aBH = new c();
    AppMethodBeat.o(3477);
  }
  
  public e(a.a parama, c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    this(parama);
    AppMethodBeat.i(3476);
    a(paramc, paramByteBuffer, paramInt);
    AppMethodBeat.o(3476);
  }
  
  private Bitmap a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(3484);
    int[] arrayOfInt = this.aBP;
    if (paramb2 == null)
    {
      if (this.aBR != null) {
        this.aBK.f(this.aBR);
      }
      this.aBR = null;
      Arrays.fill(arrayOfInt, 0);
    }
    if ((paramb2 != null) && (paramb2.aBt == 3) && (this.aBR == null)) {
      Arrays.fill(arrayOfInt, 0);
    }
    int j;
    int k;
    int m;
    if ((paramb2 != null) && (paramb2.aBt > 0))
    {
      if (paramb2.aBt == 2)
      {
        j = 0;
        if (!paramb1.aBs)
        {
          j = this.aBH.bgColor;
          i = j;
          if (paramb1.aBw != null)
          {
            i = j;
            if (this.aBH.aBC == paramb1.aBu) {
              i = 0;
            }
          }
          n = paramb2.aBq / this.sampleSize;
          j = paramb2.aBo / this.sampleSize;
          i1 = paramb2.aBp / this.sampleSize;
          k = paramb2.aBn / this.sampleSize;
          m = j * this.aBU + k;
          i2 = this.aBU;
          j = m;
        }
        for (;;)
        {
          if (j >= m + n * i2) {
            break label321;
          }
          k = j;
          for (;;)
          {
            if (k < j + i1)
            {
              arrayOfInt[k] = i;
              k += 1;
              continue;
              i = j;
              if (this.aBQ != 0) {
                break;
              }
              this.aBV = Boolean.TRUE;
              i = j;
              break;
            }
          }
          j += this.aBU;
        }
      }
      if ((paramb2.aBt == 3) && (this.aBR != null)) {
        this.aBR.getPixels(arrayOfInt, 0, this.aBU, 0, 0, this.aBU, this.aBT);
      }
    }
    label321:
    if (paramb1 != null) {
      this.aBG.position(paramb1.aBv);
    }
    if (paramb1 == null) {}
    Object localObject1;
    Object localObject2;
    byte[] arrayOfByte;
    int i12;
    int i13;
    for (int i9 = this.aBH.width * this.aBH.height;; i9 = paramb1.aBp * paramb1.aBq)
    {
      if ((this.aBO == null) || (this.aBO.length < i9)) {
        this.aBO = this.aBK.dl(i9);
      }
      paramb2 = this.aBO;
      if (this.aBL == null) {
        this.aBL = new short[4096];
      }
      localObject1 = this.aBL;
      if (this.aBM == null) {
        this.aBM = new byte[4096];
      }
      localObject2 = this.aBM;
      if (this.aBN == null) {
        this.aBN = new byte[4097];
      }
      arrayOfByte = this.aBN;
      i12 = nI();
      i13 = 1 << i12;
      m = i13 + 2;
      i3 = -1;
      k = i12 + 1;
      j = (1 << k) - 1;
      i = 0;
      while (i < i13)
      {
        localObject1[i] = 0;
        localObject2[i] = ((byte)i);
        i += 1;
      }
    }
    Object localObject3 = this.aBF;
    int i8 = 0;
    int i7 = 0;
    int i5 = 0;
    int n = 0;
    int i1 = 0;
    int i4 = 0;
    int i2 = 0;
    int i6 = 0;
    int i = i3;
    int i3 = i8;
    for (;;)
    {
      int i11;
      if (i3 < i9)
      {
        i11 = n;
        i10 = i6;
        if (n != 0) {
          break label1002;
        }
        i11 = nI();
        if (i11 > 0) {
          break label971;
        }
      }
      int i19;
      while (i11 <= 0)
      {
        this.status = 3;
        Arrays.fill(paramb2, i2, i9, (byte)0);
        if ((!paramb1.aBr) && (this.sampleSize == 1)) {
          break label2087;
        }
        localObject2 = this.aBP;
        int i15 = paramb1.aBq / this.sampleSize;
        int i16 = paramb1.aBo / this.sampleSize;
        int i17 = paramb1.aBp / this.sampleSize;
        int i18 = paramb1.aBn / this.sampleSize;
        k = 1;
        n = 8;
        j = 0;
        if (this.aBQ != 0) {
          break label1371;
        }
        i6 = 1;
        i19 = this.sampleSize;
        int i20 = this.aBU;
        int i21 = this.aBT;
        arrayOfByte = this.aBO;
        localObject3 = this.aBI;
        paramb2 = this.aBV;
        i1 = 0;
        if (i1 >= i15) {
          break label1960;
        }
        if (!paramb1.aBr) {
          break label2342;
        }
        m = n;
        i = j;
        i2 = k;
        if (j >= i15) {
          i2 = k + 1;
        }
        switch (i2)
        {
        default: 
          i = j;
          m = n;
          label819:
          k = m;
          n = i;
          j = i + m;
          i = i2;
          m = n + i16;
          if (i19 != 1) {
            break label1402;
          }
          n = 1;
          label851:
          localObject1 = paramb2;
          if (m >= i21) {
            break label1434;
          }
          i2 = m * i20;
          m = i2 + i18;
          i7 = m + i17;
          if (i2 + i20 >= i7) {
            break label2339;
          }
          i7 = i2 + i20;
          label899:
          i2 = paramb1.aBp * (i1 * i19);
          if (n == 0) {
            break label1453;
          }
          for (;;)
          {
            if (m >= i7) {
              break label1431;
            }
            n = localObject3[(arrayOfByte[i2] & 0xFF)];
            if (n == 0) {
              break;
            }
            localObject2[m] = n;
            localObject1 = paramb2;
            label952:
            i2 += i19;
            m += 1;
            paramb2 = (b)localObject1;
          }
          label971:
          this.aBG.get(this.aBF, 0, Math.min(i11, this.aBG.remaining()));
        }
      }
      int i10 = 0;
      label1002:
      i8 = ((localObject3[i10] & 0xFF) << i5) + i7;
      i6 = i5 + 8;
      for (;;)
      {
        label1026:
        i7 = i8;
        i5 = i6;
        if (i6 < k) {
          break label2390;
        }
        n = i8 & j;
        i8 >>= k;
        i6 -= k;
        if (n == i13)
        {
          k = i12 + 1;
          j = (1 << k) - 1;
          m = i13 + 2;
          i = -1;
        }
        else
        {
          i7 = i8;
          i5 = i6;
          if (n == i13 + 1) {
            break label2390;
          }
          if (i != -1) {
            break;
          }
          paramb2[i2] = localObject2[n];
          i3 += 1;
          i1 = n;
          i2 += 1;
          i = n;
        }
      }
      if (n >= m)
      {
        arrayOfByte[i4] = ((byte)i1);
        i1 = i4 + 1;
        i4 = i;
      }
      for (;;)
      {
        if (i4 >= i13)
        {
          arrayOfByte[i1] = localObject2[i4];
          i1 += 1;
          i4 = localObject1[i4];
        }
        else
        {
          i5 = localObject2[i4] & 0xFF;
          paramb2[i2] = ((byte)i5);
          i2 += 1;
          i3 += 1;
          i4 = i1;
          i1 = i2;
          while (i4 > 0)
          {
            i4 -= 1;
            paramb2[i1] = arrayOfByte[i4];
            i1 += 1;
            i3 += 1;
          }
          i2 = m;
          if (m < 4096)
          {
            localObject1[m] = ((short)i);
            localObject2[m] = ((byte)i5);
            m += 1;
            i2 = m;
            if ((m & j) == 0)
            {
              i2 = m;
              if (m < 4096)
              {
                k += 1;
                i = j + m;
                j = k;
              }
            }
          }
          for (;;)
          {
            i2 = i1;
            k = j;
            j = i;
            i = n;
            i1 = i5;
            break label1026;
            label1371:
            i6 = 0;
            break;
            i = 4;
            m = n;
            break label819;
            i = 2;
            m = 4;
            break label819;
            i = 1;
            m = 2;
            break label819;
            label1402:
            n = 0;
            break label851;
            localObject1 = paramb2;
            if (i6 == 0) {
              break label952;
            }
            localObject1 = paramb2;
            if (paramb2 != null) {
              break label952;
            }
            localObject1 = Boolean.TRUE;
            break label952;
            label1431:
            localObject1 = paramb2;
            label1434:
            label1453:
            int i22;
            label1474:
            do
            {
              i1 += 1;
              n = k;
              k = i;
              paramb2 = (b)localObject1;
              break;
              i22 = i2 + (i7 - m) * i19;
              i8 = m;
              m = i2;
              localObject1 = paramb2;
            } while (i8 >= i7);
            int i23 = paramb1.aBp;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            n = 0;
            i9 = m;
            int i24;
            int i14;
            while ((i9 < this.sampleSize + m) && (i9 < this.aBO.length) && (i9 < i22))
            {
              i10 = this.aBO[i9];
              i24 = this.aBI[(i10 & 0xFF)];
              i14 = n;
              i13 = i2;
              i12 = i3;
              i11 = i4;
              i10 = i5;
              if (i24 != 0)
              {
                i10 = i5 + (i24 >> 24 & 0xFF);
                i11 = i4 + (i24 >> 16 & 0xFF);
                i12 = i3 + (i24 >> 8 & 0xFF);
                i13 = i2 + (i24 & 0xFF);
                i14 = n + 1;
              }
              i9 += 1;
              n = i14;
              i2 = i13;
              i3 = i12;
              i4 = i11;
              i5 = i10;
            }
            i10 = m + i23;
            i9 = i5;
            i5 = i4;
            i4 = i3;
            i3 = i2;
            i2 = n;
            n = i10;
            while ((n < m + i23 + this.sampleSize) && (n < this.aBO.length) && (n < i22))
            {
              i10 = this.aBO[n];
              i24 = this.aBI[(i10 & 0xFF)];
              i14 = i2;
              i13 = i3;
              i12 = i4;
              i11 = i5;
              i10 = i9;
              if (i24 != 0)
              {
                i10 = i9 + (i24 >> 24 & 0xFF);
                i11 = i5 + (i24 >> 16 & 0xFF);
                i12 = i4 + (i24 >> 8 & 0xFF);
                i13 = i3 + (i24 & 0xFF);
                i14 = i2 + 1;
              }
              n += 1;
              i2 = i14;
              i3 = i13;
              i4 = i12;
              i5 = i11;
              i9 = i10;
            }
            if (i2 == 0)
            {
              n = 0;
              label1879:
              if (n == 0) {
                break label1944;
              }
              localObject2[i8] = n;
            }
            for (;;)
            {
              m += i19;
              i8 += 1;
              break label1474;
              n = i9 / i2 << 24 | i5 / i2 << 16 | i4 / i2 << 8 | i3 / i2;
              break label1879;
              label1944:
              if ((i6 != 0) && (paramb2 == null))
              {
                paramb2 = Boolean.TRUE;
                continue;
                label1960:
                if (this.aBV == null) {
                  if (paramb2 != null) {
                    break label2078;
                  }
                }
                label2078:
                for (boolean bool = false;; bool = paramb2.booleanValue())
                {
                  this.aBV = Boolean.valueOf(bool);
                  if ((this.aBS) && ((paramb1.aBt == 0) || (paramb1.aBt == 1)))
                  {
                    if (this.aBR == null) {
                      this.aBR = nJ();
                    }
                    this.aBR.setPixels(arrayOfInt, 0, this.aBU, 0, 0, this.aBU, this.aBT);
                  }
                  paramb1 = nJ();
                  paramb1.setPixels(arrayOfInt, 0, this.aBU, 0, 0, this.aBU, this.aBT);
                  AppMethodBeat.o(3484);
                  return paramb1;
                }
                label2087:
                paramb2 = this.aBP;
                i4 = paramb1.aBq;
                i5 = paramb1.aBo;
                i6 = paramb1.aBp;
                i7 = paramb1.aBn;
                if (this.aBQ == 0)
                {
                  j = 1;
                  i8 = this.aBU;
                  localObject1 = this.aBO;
                  localObject2 = this.aBI;
                  k = 0;
                  i = -1;
                  label2149:
                  if (k >= i4) {
                    break label2298;
                  }
                  i1 = (k + i5) * i8;
                  n = i1 + i7;
                  m = n + i6;
                  if (i1 + i8 >= m) {
                    break label2336;
                  }
                  m = i1 + i8;
                }
                label2206:
                label2336:
                for (;;)
                {
                  i1 = k * paramb1.aBp;
                  if (n < m)
                  {
                    i3 = localObject1[i1];
                    i9 = i3 & 0xFF;
                    i2 = i;
                    if (i9 != i)
                    {
                      i2 = localObject2[i9];
                      if (i2 == 0) {
                        break label2282;
                      }
                      paramb2[n] = i2;
                    }
                    label2282:
                    for (i2 = i;; i2 = i3)
                    {
                      i1 += 1;
                      n += 1;
                      i = i2;
                      break label2206;
                      j = 0;
                      break;
                    }
                  }
                  k += 1;
                  break label2149;
                  label2298:
                  if ((this.aBV == null) && (j != 0) && (i != -1)) {}
                  for (bool = true;; bool = false)
                  {
                    this.aBV = Boolean.valueOf(bool);
                    break;
                  }
                }
                label2339:
                break label899;
                label2342:
                i = n;
                n = i1;
                m = k;
                k = i;
                i = m;
                break;
              }
            }
            i = j;
            j = k;
            m = i2;
          }
          i1 = i4;
          i4 = n;
        }
      }
      label2390:
      n = i11 - 1;
      i6 = i10 + 1;
    }
  }
  
  private void a(c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    try
    {
      AppMethodBeat.i(3482);
      if (paramInt <= 0)
      {
        paramc = new IllegalArgumentException("Sample size must be >=0, not: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(3482);
        throw paramc;
      }
    }
    finally {}
    paramInt = Integer.highestOneBit(paramInt);
    this.status = 0;
    this.aBH = paramc;
    this.aBQ = -1;
    this.aBG = paramByteBuffer.asReadOnlyBuffer();
    this.aBG.position(0);
    this.aBG.order(ByteOrder.LITTLE_ENDIAN);
    this.aBS = false;
    paramByteBuffer = paramc.aBz.iterator();
    while (paramByteBuffer.hasNext()) {
      if (((b)paramByteBuffer.next()).aBt == 3) {
        this.aBS = true;
      }
    }
    this.sampleSize = paramInt;
    this.aBU = (paramc.width / paramInt);
    this.aBT = (paramc.height / paramInt);
    this.aBO = this.aBK.dl(paramc.width * paramc.height);
    this.aBP = this.aBK.dm(this.aBU * this.aBT);
    AppMethodBeat.o(3482);
  }
  
  private int nI()
  {
    AppMethodBeat.i(3485);
    int i = this.aBG.get();
    AppMethodBeat.o(3485);
    return i & 0xFF;
  }
  
  private Bitmap nJ()
  {
    AppMethodBeat.i(3486);
    if ((this.aBV == null) || (this.aBV.booleanValue())) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = this.aBW)
    {
      localObject = this.aBK.a(this.aBU, this.aBT, (Bitmap.Config)localObject);
      ((Bitmap)localObject).setHasAlpha(true);
      AppMethodBeat.o(3486);
      return localObject;
    }
  }
  
  public final void a(Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(3483);
    if ((paramConfig != Bitmap.Config.ARGB_8888) && (paramConfig != Bitmap.Config.RGB_565))
    {
      paramConfig = new IllegalArgumentException("Unsupported format: " + paramConfig + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
      AppMethodBeat.o(3483);
      throw paramConfig;
    }
    this.aBW = paramConfig;
    AppMethodBeat.o(3483);
  }
  
  public final void advance()
  {
    this.aBQ = ((this.aBQ + 1) % this.aBH.frameCount);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(3481);
    this.aBH = null;
    if (this.aBO != null) {
      this.aBK.k(this.aBO);
    }
    if (this.aBP != null) {
      this.aBK.n(this.aBP);
    }
    if (this.aBR != null) {
      this.aBK.f(this.aBR);
    }
    this.aBR = null;
    this.aBG = null;
    this.aBV = null;
    if (this.aBF != null) {
      this.aBK.k(this.aBF);
    }
    AppMethodBeat.o(3481);
  }
  
  public final ByteBuffer getData()
  {
    return this.aBG;
  }
  
  public final int getFrameCount()
  {
    return this.aBH.frameCount;
  }
  
  public final int nA()
  {
    AppMethodBeat.i(3479);
    int i = this.aBG.limit();
    int j = this.aBO.length;
    int k = this.aBP.length;
    AppMethodBeat.o(3479);
    return i + j + k * 4;
  }
  
  public final Bitmap nB()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3480);
        if ((this.aBH.frameCount <= 0) || (this.aBQ < 0))
        {
          if (Log.isLoggable(TAG, 3)) {
            new StringBuilder("Unable to decode frame, frameCount=").append(this.aBH.frameCount).append(", framePointer=").append(this.aBQ);
          }
          this.status = 1;
        }
        Object localObject1;
        if ((this.status == 1) || (this.status == 2))
        {
          if (Log.isLoggable(TAG, 3)) {
            new StringBuilder("Unable to decode frame, status=").append(this.status);
          }
          AppMethodBeat.o(3480);
          localObject1 = null;
          return localObject1;
        }
        this.status = 0;
        if (this.aBF == null) {
          this.aBF = this.aBK.dl(255);
        }
        b localb = (b)this.aBH.aBz.get(this.aBQ);
        int i = this.aBQ - 1;
        if (i >= 0)
        {
          localObject1 = (b)this.aBH.aBz.get(i);
          int[] arrayOfInt;
          if (localb.aBw != null)
          {
            arrayOfInt = localb.aBw;
            this.aBI = arrayOfInt;
            if (this.aBI == null)
            {
              if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("No valid color table found for frame #").append(this.aBQ);
              }
              this.status = 1;
              AppMethodBeat.o(3480);
              localObject1 = null;
            }
          }
          else
          {
            arrayOfInt = this.aBH.aBx;
            continue;
          }
          if (localb.aBs)
          {
            System.arraycopy(this.aBI, 0, this.aBJ, 0, this.aBI.length);
            this.aBI = this.aBJ;
            this.aBI[localb.aBu] = 0;
          }
          localObject1 = a(localb, (b)localObject1);
          AppMethodBeat.o(3480);
        }
        else
        {
          Object localObject3 = null;
        }
      }
      finally {}
    }
  }
  
  public final int nx()
  {
    AppMethodBeat.i(3478);
    if ((this.aBH.frameCount <= 0) || (this.aBQ < 0))
    {
      AppMethodBeat.o(3478);
      return 0;
    }
    int k = this.aBQ;
    int j = -1;
    int i = j;
    if (k >= 0)
    {
      i = j;
      if (k < this.aBH.frameCount) {
        i = ((b)this.aBH.aBz.get(k)).delay;
      }
    }
    AppMethodBeat.o(3478);
    return i;
  }
  
  public final int ny()
  {
    return this.aBQ;
  }
  
  public final void nz()
  {
    this.aBQ = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.b.e
 * JD-Core Version:    0.7.0.1
 */