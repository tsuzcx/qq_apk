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
  private Bitmap aEA;
  private boolean aEB;
  private int aEC;
  private int aED;
  private Boolean aEE;
  private Bitmap.Config aEF;
  private byte[] aEo;
  private ByteBuffer aEp;
  private c aEq;
  private int[] aEr;
  private final int[] aEs;
  private final a.a aEt;
  private short[] aEu;
  private byte[] aEv;
  private byte[] aEw;
  private byte[] aEx;
  private int[] aEy;
  private int aEz;
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
    this.aEs = new int[256];
    this.aEF = Bitmap.Config.ARGB_8888;
    this.aEt = parama;
    this.aEq = new c();
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
    int[] arrayOfInt = this.aEy;
    if (paramb2 == null)
    {
      if (this.aEA != null) {
        this.aEt.f(this.aEA);
      }
      this.aEA = null;
      Arrays.fill(arrayOfInt, 0);
    }
    if ((paramb2 != null) && (paramb2.aEd == 3) && (this.aEA == null)) {
      Arrays.fill(arrayOfInt, 0);
    }
    int j;
    int k;
    int m;
    if ((paramb2 != null) && (paramb2.aEd > 0))
    {
      if (paramb2.aEd == 2)
      {
        j = 0;
        if (!paramb1.aEc)
        {
          j = this.aEq.bgColor;
          i = j;
          if (paramb1.aEg != null)
          {
            i = j;
            if (this.aEq.aEm == paramb1.aEe) {
              i = 0;
            }
          }
          n = paramb2.aEa / this.sampleSize;
          j = paramb2.aDY / this.sampleSize;
          i1 = paramb2.aDZ / this.sampleSize;
          k = paramb2.aDX / this.sampleSize;
          m = j * this.aED + k;
          i2 = this.aED;
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
              if (this.aEz != 0) {
                break;
              }
              this.aEE = Boolean.TRUE;
              i = j;
              break;
            }
          }
          j += this.aED;
        }
      }
      if ((paramb2.aEd == 3) && (this.aEA != null)) {
        this.aEA.getPixels(arrayOfInt, 0, this.aED, 0, 0, this.aED, this.aEC);
      }
    }
    label321:
    if (paramb1 != null) {
      this.aEp.position(paramb1.aEf);
    }
    if (paramb1 == null) {}
    Object localObject1;
    Object localObject2;
    byte[] arrayOfByte;
    int i12;
    int i13;
    for (int i9 = this.aEq.width * this.aEq.height;; i9 = paramb1.aDZ * paramb1.aEa)
    {
      if ((this.aEx == null) || (this.aEx.length < i9)) {
        this.aEx = this.aEt.dk(i9);
      }
      paramb2 = this.aEx;
      if (this.aEu == null) {
        this.aEu = new short[4096];
      }
      localObject1 = this.aEu;
      if (this.aEv == null) {
        this.aEv = new byte[4096];
      }
      localObject2 = this.aEv;
      if (this.aEw == null) {
        this.aEw = new byte[4097];
      }
      arrayOfByte = this.aEw;
      i12 = ok();
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
    Object localObject3 = this.aEo;
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
        i11 = ok();
        if (i11 > 0) {
          break label971;
        }
      }
      int i19;
      while (i11 <= 0)
      {
        this.status = 3;
        Arrays.fill(paramb2, i2, i9, (byte)0);
        if ((!paramb1.aEb) && (this.sampleSize == 1)) {
          break label2087;
        }
        localObject2 = this.aEy;
        int i15 = paramb1.aEa / this.sampleSize;
        int i16 = paramb1.aDY / this.sampleSize;
        int i17 = paramb1.aDZ / this.sampleSize;
        int i18 = paramb1.aDX / this.sampleSize;
        k = 1;
        n = 8;
        j = 0;
        if (this.aEz != 0) {
          break label1371;
        }
        i6 = 1;
        i19 = this.sampleSize;
        int i20 = this.aED;
        int i21 = this.aEC;
        arrayOfByte = this.aEx;
        localObject3 = this.aEr;
        paramb2 = this.aEE;
        i1 = 0;
        if (i1 >= i15) {
          break label1960;
        }
        if (!paramb1.aEb) {
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
          i2 = paramb1.aDZ * (i1 * i19);
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
          this.aEp.get(this.aEo, 0, Math.min(i11, this.aEp.remaining()));
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
            int i23 = paramb1.aDZ;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            n = 0;
            i9 = m;
            int i24;
            int i14;
            while ((i9 < this.sampleSize + m) && (i9 < this.aEx.length) && (i9 < i22))
            {
              i10 = this.aEx[i9];
              i24 = this.aEr[(i10 & 0xFF)];
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
            while ((n < m + i23 + this.sampleSize) && (n < this.aEx.length) && (n < i22))
            {
              i10 = this.aEx[n];
              i24 = this.aEr[(i10 & 0xFF)];
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
                if (this.aEE == null) {
                  if (paramb2 != null) {
                    break label2078;
                  }
                }
                label2078:
                for (boolean bool = false;; bool = paramb2.booleanValue())
                {
                  this.aEE = Boolean.valueOf(bool);
                  if ((this.aEB) && ((paramb1.aEd == 0) || (paramb1.aEd == 1)))
                  {
                    if (this.aEA == null) {
                      this.aEA = ol();
                    }
                    this.aEA.setPixels(arrayOfInt, 0, this.aED, 0, 0, this.aED, this.aEC);
                  }
                  paramb1 = ol();
                  paramb1.setPixels(arrayOfInt, 0, this.aED, 0, 0, this.aED, this.aEC);
                  AppMethodBeat.o(3484);
                  return paramb1;
                }
                label2087:
                paramb2 = this.aEy;
                i4 = paramb1.aEa;
                i5 = paramb1.aDY;
                i6 = paramb1.aDZ;
                i7 = paramb1.aDX;
                if (this.aEz == 0)
                {
                  j = 1;
                  i8 = this.aED;
                  localObject1 = this.aEx;
                  localObject2 = this.aEr;
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
                  i1 = k * paramb1.aDZ;
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
                  if ((this.aEE == null) && (j != 0) && (i != -1)) {}
                  for (bool = true;; bool = false)
                  {
                    this.aEE = Boolean.valueOf(bool);
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
    this.aEq = paramc;
    this.aEz = -1;
    this.aEp = paramByteBuffer.asReadOnlyBuffer();
    this.aEp.position(0);
    this.aEp.order(ByteOrder.LITTLE_ENDIAN);
    this.aEB = false;
    paramByteBuffer = paramc.aEj.iterator();
    while (paramByteBuffer.hasNext()) {
      if (((b)paramByteBuffer.next()).aEd == 3) {
        this.aEB = true;
      }
    }
    this.sampleSize = paramInt;
    this.aED = (paramc.width / paramInt);
    this.aEC = (paramc.height / paramInt);
    this.aEx = this.aEt.dk(paramc.width * paramc.height);
    this.aEy = this.aEt.dl(this.aED * this.aEC);
    AppMethodBeat.o(3482);
  }
  
  private int ok()
  {
    AppMethodBeat.i(3485);
    int i = this.aEp.get();
    AppMethodBeat.o(3485);
    return i & 0xFF;
  }
  
  private Bitmap ol()
  {
    AppMethodBeat.i(3486);
    if ((this.aEE == null) || (this.aEE.booleanValue())) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = this.aEF)
    {
      localObject = this.aEt.a(this.aED, this.aEC, (Bitmap.Config)localObject);
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
    this.aEF = paramConfig;
    AppMethodBeat.o(3483);
  }
  
  public final void advance()
  {
    this.aEz = ((this.aEz + 1) % this.aEq.frameCount);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(3481);
    this.aEq = null;
    if (this.aEx != null) {
      this.aEt.k(this.aEx);
    }
    if (this.aEy != null) {
      this.aEt.o(this.aEy);
    }
    if (this.aEA != null) {
      this.aEt.f(this.aEA);
    }
    this.aEA = null;
    this.aEp = null;
    this.aEE = null;
    if (this.aEo != null) {
      this.aEt.k(this.aEo);
    }
    AppMethodBeat.o(3481);
  }
  
  public final ByteBuffer getData()
  {
    return this.aEp;
  }
  
  public final int getFrameCount()
  {
    return this.aEq.frameCount;
  }
  
  public final int nZ()
  {
    AppMethodBeat.i(3478);
    if ((this.aEq.frameCount <= 0) || (this.aEz < 0))
    {
      AppMethodBeat.o(3478);
      return 0;
    }
    int k = this.aEz;
    int j = -1;
    int i = j;
    if (k >= 0)
    {
      i = j;
      if (k < this.aEq.frameCount) {
        i = ((b)this.aEq.aEj.get(k)).delay;
      }
    }
    AppMethodBeat.o(3478);
    return i;
  }
  
  public final int oa()
  {
    return this.aEz;
  }
  
  public final void ob()
  {
    this.aEz = -1;
  }
  
  public final int oc()
  {
    AppMethodBeat.i(3479);
    int i = this.aEp.limit();
    int j = this.aEx.length;
    int k = this.aEy.length;
    AppMethodBeat.o(3479);
    return i + j + k * 4;
  }
  
  public final Bitmap od()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3480);
        if ((this.aEq.frameCount <= 0) || (this.aEz < 0))
        {
          if (Log.isLoggable(TAG, 3)) {
            new StringBuilder("Unable to decode frame, frameCount=").append(this.aEq.frameCount).append(", framePointer=").append(this.aEz);
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
        if (this.aEo == null) {
          this.aEo = this.aEt.dk(255);
        }
        b localb = (b)this.aEq.aEj.get(this.aEz);
        int i = this.aEz - 1;
        if (i >= 0)
        {
          localObject1 = (b)this.aEq.aEj.get(i);
          int[] arrayOfInt;
          if (localb.aEg != null)
          {
            arrayOfInt = localb.aEg;
            this.aEr = arrayOfInt;
            if (this.aEr == null)
            {
              if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("No valid color table found for frame #").append(this.aEz);
              }
              this.status = 1;
              AppMethodBeat.o(3480);
              localObject1 = null;
            }
          }
          else
          {
            arrayOfInt = this.aEq.aEh;
            continue;
          }
          if (localb.aEc)
          {
            System.arraycopy(this.aEr, 0, this.aEs, 0, this.aEr.length);
            this.aEr = this.aEs;
            this.aEr[localb.aEe] = 0;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.b.e
 * JD-Core Version:    0.7.0.1
 */