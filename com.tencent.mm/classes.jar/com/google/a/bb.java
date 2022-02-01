package com.google.a;

import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

final class bb<T>
  implements br<T>
{
  private static final Unsafe UNSAFE = ch.HU();
  private static final int[] bYn = new int[0];
  private final aw bXE;
  private final al bYA;
  private final cb<?, ?> bYB;
  private final s<?> bYC;
  private final ap bYD;
  private final int[] bYo;
  private final Object[] bYp;
  private final int bYq;
  private final int bYr;
  private final boolean bYs;
  private final boolean bYt;
  private final boolean bYu;
  private final boolean bYv;
  private final int[] bYw;
  private final int bYx;
  private final int bYy;
  private final be bYz;
  
  private bb(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, aw paramaw, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, be parambe, al paramal, cb<?, ?> paramcb, s<?> params, ap paramap)
  {
    this.bYo = paramArrayOfInt1;
    this.bYp = paramArrayOfObject;
    this.bYq = paramInt1;
    this.bYr = paramInt2;
    this.bYt = (paramaw instanceof ab);
    this.bYu = paramBoolean1;
    if ((params != null) && (params.f(paramaw))) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.bYs = paramBoolean1;
      this.bYv = paramBoolean2;
      this.bYw = paramArrayOfInt2;
      this.bYx = paramInt3;
      this.bYy = paramInt4;
      this.bYz = parambe;
      this.bYA = paramal;
      this.bYB = paramcb;
      this.bYC = params;
      this.bXE = paramaw;
      this.bYD = paramap;
      return;
    }
  }
  
  static <T> bb<T> a(au paramau, be parambe, al paramal, cb<?, ?> paramcb, s<?> params, ap paramap)
  {
    Object localObject2;
    boolean bool;
    Object localObject3;
    int i14;
    int m;
    int i5;
    int k;
    int j;
    int i;
    if ((paramau instanceof bp))
    {
      localObject2 = (bp)paramau;
      if (((bp)localObject2).He() == bl.bYK) {}
      for (bool = true;; bool = false)
      {
        localObject3 = ((bp)localObject2).info;
        i14 = ((String)localObject3).length();
        m = 1;
        i5 = ((String)localObject3).charAt(0);
        if (i5 < 55296) {
          break label3603;
        }
        k = i5 & 0x1FFF;
        j = 13;
        for (;;)
        {
          i = m + 1;
          m = ((String)localObject3).charAt(m);
          if (m < 55296) {
            break;
          }
          k |= (m & 0x1FFF) << j;
          j += 13;
          m = i;
        }
      }
      i5 = m << j | k;
    }
    for (;;)
    {
      m = i + 1;
      j = ((String)localObject3).charAt(i);
      if (j >= 55296)
      {
        k = j & 0x1FFF;
        j = 13;
        for (;;)
        {
          i = m + 1;
          m = ((String)localObject3).charAt(m);
          if (m < 55296) {
            break;
          }
          k |= (m & 0x1FFF) << j;
          j += 13;
          m = i;
        }
        j = m << j | k;
      }
      for (;;)
      {
        int i6;
        int i7;
        int i8;
        int i9;
        Object localObject4;
        Object localObject5;
        int n;
        Object localObject6;
        Object localObject7;
        Object[] arrayOfObject;
        int i10;
        int i1;
        int i2;
        int i11;
        int i3;
        int i4;
        if (j == 0)
        {
          i6 = 0;
          i7 = 0;
          k = 0;
          i8 = 0;
          m = 0;
          paramau = bYn;
          j = 0;
          i9 = 0;
          localObject4 = UNSAFE;
          localObject5 = ((bp)localObject2).bYp;
          n = 0;
          localObject6 = ((bp)localObject2).bXE.getClass();
          localObject7 = new int[k * 3];
          arrayOfObject = new Object[k * 2];
          k = m + i8;
          i10 = 0;
          i1 = m;
          i2 = i;
          i = i1;
          if (i2 < i14)
          {
            i1 = i2 + 1;
            i11 = ((String)localObject3).charAt(i2);
            if (i11 < 55296) {
              break label3551;
            }
            i3 = i11 & 0x1FFF;
            i2 = 13;
            i4 = i1;
            i1 = i2;
            for (;;)
            {
              i2 = i4 + 1;
              i4 = ((String)localObject3).charAt(i4);
              if (i4 < 55296) {
                break;
              }
              i3 |= (i4 & 0x1FFF) << i1;
              i1 += 13;
              i4 = i2;
            }
          }
        }
        else
        {
          m = i + 1;
          i = ((String)localObject3).charAt(i);
          if (i < 55296) {
            break label3589;
          }
          k = i & 0x1FFF;
          j = 13;
          for (;;)
          {
            i = m + 1;
            m = ((String)localObject3).charAt(m);
            if (m < 55296) {
              break;
            }
            k |= (m & 0x1FFF) << j;
            j += 13;
            m = i;
          }
          j = m << j | k;
          k = i;
          i = j;
        }
        for (;;)
        {
          j = k + 1;
          k = ((String)localObject3).charAt(k);
          i3 = k;
          m = j;
          if (k >= 55296)
          {
            m = k & 0x1FFF;
            k = 13;
            for (n = j;; n = j)
            {
              j = n + 1;
              n = ((String)localObject3).charAt(n);
              if (n < 55296) {
                break;
              }
              m |= (n & 0x1FFF) << k;
              k += 13;
            }
            i3 = n << k | m;
            m = j;
          }
          k = m + 1;
          m = ((String)localObject3).charAt(m);
          j = m;
          n = k;
          if (m >= 55296)
          {
            m &= 0x1FFF;
            j = 13;
            n = k;
            k = j;
            for (;;)
            {
              j = n + 1;
              n = ((String)localObject3).charAt(n);
              if (n < 55296) {
                break;
              }
              m |= (n & 0x1FFF) << k;
              k += 13;
              n = j;
            }
            k = n << k | m;
            n = j;
            j = k;
          }
          m = n + 1;
          k = ((String)localObject3).charAt(n);
          if (k >= 55296)
          {
            n = k & 0x1FFF;
            k = 13;
            i1 = m;
            m = k;
            for (;;)
            {
              k = i1 + 1;
              i1 = ((String)localObject3).charAt(i1);
              if (i1 < 55296) {
                break;
              }
              n |= (i1 & 0x1FFF) << m;
              m += 13;
              i1 = k;
            }
            n = i1 << m | n;
            m = k;
            k = n;
          }
          for (;;)
          {
            n = m + 1;
            m = ((String)localObject3).charAt(m);
            if (m >= 55296)
            {
              i1 = m & 0x1FFF;
              m = 13;
              i2 = n;
              n = m;
              for (;;)
              {
                m = i2 + 1;
                i2 = ((String)localObject3).charAt(i2);
                if (i2 < 55296) {
                  break;
                }
                i1 |= (i2 & 0x1FFF) << n;
                n += 13;
                i2 = m;
              }
              n = i2 << n | i1;
              i1 = m;
              m = n;
            }
            for (;;)
            {
              n = i1 + 1;
              i2 = ((String)localObject3).charAt(i1);
              if (i2 >= 55296)
              {
                i2 &= 0x1FFF;
                i1 = 13;
                i4 = n;
                n = i1;
                for (;;)
                {
                  i1 = i4 + 1;
                  i4 = ((String)localObject3).charAt(i4);
                  if (i4 < 55296) {
                    break;
                  }
                  i2 |= (i4 & 0x1FFF) << n;
                  n += 13;
                  i4 = i1;
                }
              }
              for (n = i4 << n | i2;; n = i2)
              {
                i6 = i1 + 1;
                i4 = ((String)localObject3).charAt(i1);
                if (i4 >= 55296)
                {
                  i4 &= 0x1FFF;
                  i2 = 13;
                  for (;;)
                  {
                    i1 = i6 + 1;
                    i6 = ((String)localObject3).charAt(i6);
                    if (i6 < 55296) {
                      break;
                    }
                    i4 |= (i6 & 0x1FFF) << i2;
                    i2 += 13;
                    i6 = i1;
                  }
                  i4 = i6 << i2 | i4;
                }
                for (i2 = i1;; i2 = i6)
                {
                  i1 = i2 + 1;
                  i2 = ((String)localObject3).charAt(i2);
                  if (i2 >= 55296)
                  {
                    i6 = i2 & 0x1FFF;
                    i2 = 13;
                    for (i7 = i1;; i7 = i1)
                    {
                      i1 = i7 + 1;
                      i7 = ((String)localObject3).charAt(i7);
                      if (i7 < 55296) {
                        break;
                      }
                      i6 |= (i7 & 0x1FFF) << i2;
                      i2 += 13;
                    }
                    i2 = i7 << i2 | i6;
                  }
                  for (;;)
                  {
                    paramau = new int[i4 + (i2 + n)];
                    i3 += i * 2;
                    i9 = i;
                    i6 = j;
                    i7 = k;
                    k = m;
                    m = i2;
                    j = i3;
                    i8 = n;
                    i = i1;
                    break;
                    i11 = i3 | i4 << i1;
                    for (;;)
                    {
                      i1 = i2 + 1;
                      int i12 = ((String)localObject3).charAt(i2);
                      if (i12 >= 55296)
                      {
                        i3 = i12 & 0x1FFF;
                        i2 = 13;
                        i4 = i1;
                        i1 = i2;
                        for (;;)
                        {
                          i2 = i4 + 1;
                          i4 = ((String)localObject3).charAt(i4);
                          if (i4 < 55296) {
                            break;
                          }
                          i3 |= (i4 & 0x1FFF) << i1;
                          i1 += 13;
                          i4 = i2;
                        }
                        i12 = i3 | i4 << i1;
                        i1 = i2;
                      }
                      for (;;)
                      {
                        int i15 = i12 & 0xFF;
                        if ((i12 & 0x400) != 0)
                        {
                          paramau[n] = i10;
                          n += 1;
                        }
                        for (;;)
                        {
                          if (i15 >= 51)
                          {
                            i2 = i1 + 1;
                            i1 = ((String)localObject3).charAt(i1);
                            if (i1 < 55296) {
                              break label3530;
                            }
                            i3 = i1 & 0x1FFF;
                            i1 = 13;
                            i4 = i2;
                            i2 = i1;
                            for (;;)
                            {
                              i1 = i4 + 1;
                              i4 = ((String)localObject3).charAt(i4);
                              if (i4 < 55296) {
                                break;
                              }
                              i3 |= (i4 & 0x1FFF) << i2;
                              i2 += 13;
                              i4 = i1;
                            }
                            i2 = i4 << i2 | i3;
                          }
                          for (;;)
                          {
                            i3 = i15 - 51;
                            if ((i3 == 9) || (i3 == 17))
                            {
                              arrayOfObject[(i10 / 3 * 2 + 1)] = localObject5[j];
                              j += 1;
                            }
                            label2486:
                            label3520:
                            label3527:
                            for (;;)
                            {
                              label1624:
                              i3 = i2 * 2;
                              Object localObject1 = localObject5[i3];
                              if ((localObject1 instanceof Field))
                              {
                                localObject1 = (Field)localObject1;
                                label1652:
                                i2 = (int)((Unsafe)localObject4).objectFieldOffset((Field)localObject1);
                                i3 += 1;
                                localObject1 = localObject5[i3];
                                if (!(localObject1 instanceof Field)) {
                                  break label1879;
                                }
                                localObject1 = (Field)localObject1;
                              }
                              int i13;
                              for (;;)
                              {
                                i3 = (int)((Unsafe)localObject4).objectFieldOffset((Field)localObject1);
                                i4 = 0;
                                i13 = k;
                                k = i;
                                i = i13;
                                i13 = i10 + 1;
                                localObject7[i10] = i11;
                                int i16 = i13 + 1;
                                if ((i12 & 0x200) == 0) {
                                  break label2396;
                                }
                                i10 = 536870912;
                                label1747:
                                if ((i12 & 0x100) == 0) {
                                  break label2402;
                                }
                                i11 = 268435456;
                                label1760:
                                localObject7[i13] = (i11 | i10 | i15 << 20 | i2);
                                localObject7[i16] = (i4 << 20 | i3);
                                i10 = i16 + 1;
                                i2 = i;
                                i = k;
                                k = i2;
                                i2 = i1;
                                break;
                                if ((i3 != 12) || ((i5 & 0x1) != 1)) {
                                  break label3527;
                                }
                                arrayOfObject[(i10 / 3 * 2 + 1)] = localObject5[j];
                                j += 1;
                                break label1624;
                                localObject1 = c((Class)localObject6, (String)localObject1);
                                localObject5[i3] = localObject1;
                                break label1652;
                                label1879:
                                localObject1 = c((Class)localObject6, (String)localObject1);
                                localObject5[i3] = localObject1;
                              }
                              i2 = j + 1;
                              localObject1 = c((Class)localObject6, (String)localObject5[j]);
                              if ((i15 == 9) || (i15 == 17))
                              {
                                arrayOfObject[(i10 / 3 * 2 + 1)] = ((Field)localObject1).getType();
                                j = i2;
                              }
                              for (;;)
                              {
                                i2 = (int)((Unsafe)localObject4).objectFieldOffset((Field)localObject1);
                                if (((i5 & 0x1) == 1) && (i15 <= 17))
                                {
                                  i3 = i1 + 1;
                                  i1 = ((String)localObject3).charAt(i1);
                                  if (i1 < 55296) {
                                    break label3494;
                                  }
                                  i4 = i1 & 0x1FFF;
                                  i1 = 13;
                                  for (i13 = i3;; i13 = i3)
                                  {
                                    i3 = i13 + 1;
                                    i13 = ((String)localObject3).charAt(i13);
                                    if (i13 < 55296) {
                                      break;
                                    }
                                    i4 |= (i13 & 0x1FFF) << i1;
                                    i1 += 13;
                                  }
                                  if ((i15 == 27) || (i15 == 49))
                                  {
                                    arrayOfObject[(i10 / 3 * 2 + 1)] = localObject5[i2];
                                    j = i2 + 1;
                                    continue;
                                  }
                                  if ((i15 == 12) || (i15 == 30) || (i15 == 44))
                                  {
                                    if ((i5 & 0x1) != 1) {
                                      break label3520;
                                    }
                                    arrayOfObject[(i10 / 3 * 2 + 1)] = localObject5[i2];
                                    j = i2 + 1;
                                    continue;
                                  }
                                  if (i15 != 50) {
                                    break label3520;
                                  }
                                  j = i + 1;
                                  paramau[i] = i10;
                                  i = i10 / 3;
                                  i3 = i2 + 1;
                                  arrayOfObject[(i * 2)] = localObject5[i2];
                                  if ((i12 & 0x800) == 0) {
                                    break label3509;
                                  }
                                  i = i10 / 3;
                                  i2 = i3 + 1;
                                  arrayOfObject[(i * 2 + 1)] = localObject5[i3];
                                  i = j;
                                  j = i2;
                                  continue;
                                  i4 |= i13 << i1;
                                  i1 = i3;
                                  i3 = i4;
                                }
                                for (;;)
                                {
                                  i4 = i3 / 32 + i9 * 2;
                                  localObject1 = localObject5[i4];
                                  if ((localObject1 instanceof Field))
                                  {
                                    localObject1 = (Field)localObject1;
                                    label2303:
                                    i4 = (int)((Unsafe)localObject4).objectFieldOffset((Field)localObject1);
                                    i13 = i3 % 32;
                                    i3 = i4;
                                    i4 = i13;
                                  }
                                  for (;;)
                                  {
                                    if ((i15 >= 18) && (i15 <= 49))
                                    {
                                      i13 = k + 1;
                                      paramau[k] = i2;
                                      k = i;
                                      i = i13;
                                      break;
                                      localObject1 = c((Class)localObject6, (String)localObject1);
                                      localObject5[i4] = localObject1;
                                      break label2303;
                                      i3 = 0;
                                      i4 = 0;
                                      continue;
                                      label2396:
                                      i10 = 0;
                                      break label1747;
                                      label2402:
                                      i11 = 0;
                                      break label1760;
                                      return new bb((int[])localObject7, arrayOfObject, i6, i7, ((bp)localObject2).bXE, bool, false, paramau, m, m + i8, parambe, paramal, paramcb, params, paramap);
                                      localObject4 = (bw)paramau;
                                      if (((bw)localObject4).bZn == bl.bYK)
                                      {
                                        bool = true;
                                        localObject7 = ((bw)localObject4).bZp;
                                        if (localObject7.length != 0) {
                                          break label2578;
                                        }
                                        k = 0;
                                        m = 0;
                                        i = localObject7.length;
                                        localObject5 = new int[i * 3];
                                        localObject6 = new Object[i * 2];
                                        j = 0;
                                        n = 0;
                                        i3 = localObject7.length;
                                        i = 0;
                                        label2522:
                                        if (i >= i3) {
                                          break label2656;
                                        }
                                        paramau = localObject7[i];
                                        if (paramau.bUp != y.bVF) {
                                          break label2603;
                                        }
                                        i2 = j + 1;
                                        i1 = n;
                                      }
                                      for (;;)
                                      {
                                        i += 1;
                                        n = i1;
                                        j = i2;
                                        break label2522;
                                        bool = false;
                                        break;
                                        k = localObject7[0].bUr;
                                        m = localObject7[(localObject7.length - 1)].bUr;
                                        break label2486;
                                        i1 = n;
                                        i2 = j;
                                        if (paramau.bUp.id >= 18)
                                        {
                                          i1 = n;
                                          i2 = j;
                                          if (paramau.bUp.id <= 49)
                                          {
                                            i1 = n + 1;
                                            i2 = j;
                                          }
                                        }
                                      }
                                      label2656:
                                      if (j > 0)
                                      {
                                        localObject2 = new int[j];
                                        if (n <= 0) {
                                          break label3032;
                                        }
                                        localObject1 = new int[n];
                                        label2678:
                                        i1 = 0;
                                        i3 = 0;
                                        localObject3 = ((bw)localObject4).bZo;
                                        if (localObject3 != null) {
                                          break label3476;
                                        }
                                        localObject3 = bYn;
                                      }
                                      for (;;)
                                      {
                                        i4 = 0;
                                        i2 = 0;
                                        n = 0;
                                        if (i2 < localObject7.length)
                                        {
                                          arrayOfObject = localObject7[i2];
                                          i9 = arrayOfObject.bUr;
                                          paramau = arrayOfObject.bUv;
                                          if (paramau != null)
                                          {
                                            i5 = arrayOfObject.bUp.id + 51;
                                            i6 = (int)ch.a(paramau.bYI);
                                            i = (int)ch.a(paramau.bYH);
                                            j = 0;
                                            label2778:
                                            localObject5[n] = arrayOfObject.bUr;
                                            if (!arrayOfObject.bUu) {
                                              break label3158;
                                            }
                                            i7 = 536870912;
                                            label2800:
                                            if (!arrayOfObject.required) {
                                              break label3164;
                                            }
                                            i8 = 268435456;
                                            label2812:
                                            localObject5[(n + 1)] = (i5 << 20 | i7 | i8 | i6);
                                            localObject5[(n + 2)] = (i | j << 20);
                                            switch (w.1.bUA[arrayOfObject.bUp.ordinal()])
                                            {
                                            default: 
                                              paramau = null;
                                              label2894:
                                              if (arrayOfObject.bUy != null)
                                              {
                                                localObject6[(n / 3 * 2)] = arrayOfObject.bUy;
                                                if (paramau != null)
                                                {
                                                  localObject6[(n / 3 * 2 + 1)] = paramau;
                                                  label2932:
                                                  i = i4;
                                                  if (i4 < localObject3.length)
                                                  {
                                                    i = i4;
                                                    if (localObject3[i4] == i9)
                                                    {
                                                      localObject3[i4] = n;
                                                      i = i4 + 1;
                                                    }
                                                  }
                                                  if (arrayOfObject.bUp != y.bVF) {
                                                    break label3281;
                                                  }
                                                  localObject2[i1] = n;
                                                  j = i1 + 1;
                                                  i4 = i3;
                                                }
                                              }
                                              break;
                                            }
                                          }
                                          for (;;)
                                          {
                                            i2 += 1;
                                            n += 3;
                                            i3 = i4;
                                            i4 = i;
                                            i1 = j;
                                            break label2710;
                                            localObject2 = null;
                                            break;
                                            label3032:
                                            localObject1 = null;
                                            break label2678;
                                            paramau = arrayOfObject.bUp;
                                            i6 = (int)ch.a(arrayOfObject.bUo);
                                            i5 = paramau.id;
                                            if ((!bool) && (!paramau.bVH.bVS))
                                            {
                                              if (paramau.bVH == y.a.bVR) {}
                                              for (i = 1;; i = 0)
                                              {
                                                if (i != 0) {
                                                  break label3124;
                                                }
                                                i = (int)ch.a(arrayOfObject.bUs);
                                                j = Integer.numberOfTrailingZeros(arrayOfObject.bUt);
                                                break;
                                              }
                                            }
                                            if (arrayOfObject.bUw == null)
                                            {
                                              i = 0;
                                              j = 0;
                                              break label2778;
                                            }
                                            i = (int)ch.a(arrayOfObject.bUw);
                                            j = 0;
                                            break label2778;
                                            label3158:
                                            i7 = 0;
                                            break label2800;
                                            label3164:
                                            i8 = 0;
                                            break label2812;
                                            if (arrayOfObject.bUo != null)
                                            {
                                              paramau = arrayOfObject.bUo.getType();
                                              break label2894;
                                            }
                                            paramau = arrayOfObject.bUx;
                                            break label2894;
                                            paramau = arrayOfObject.bUq;
                                            break label2894;
                                            if (arrayOfObject.bUz == null) {
                                              break label2932;
                                            }
                                            localObject6[(n / 3 * 2 + 1)] = arrayOfObject.bUz;
                                            break label2932;
                                            if (paramau != null)
                                            {
                                              localObject6[(n / 3 * 2 + 1)] = paramau;
                                              break label2932;
                                            }
                                            if (arrayOfObject.bUz == null) {
                                              break label2932;
                                            }
                                            localObject6[(n / 3 * 2 + 1)] = arrayOfObject.bUz;
                                            break label2932;
                                            label3281:
                                            i4 = i3;
                                            j = i1;
                                            if (arrayOfObject.bUp.id >= 18)
                                            {
                                              i4 = i3;
                                              j = i1;
                                              if (arrayOfObject.bUp.id <= 49)
                                              {
                                                localObject1[i3] = ((int)ch.a(arrayOfObject.bUo));
                                                i4 = i3 + 1;
                                                j = i1;
                                              }
                                            }
                                          }
                                        }
                                        if (localObject2 == null) {}
                                        for (paramau = bYn;; paramau = (au)localObject2)
                                        {
                                          localObject2 = localObject1;
                                          if (localObject1 == null) {
                                            localObject2 = bYn;
                                          }
                                          localObject1 = new int[localObject3.length + paramau.length + localObject2.length];
                                          System.arraycopy(localObject3, 0, localObject1, 0, localObject3.length);
                                          System.arraycopy(paramau, 0, localObject1, localObject3.length, paramau.length);
                                          System.arraycopy(localObject2, 0, localObject1, localObject3.length + paramau.length, localObject2.length);
                                          return new bb((int[])localObject5, (Object[])localObject6, k, m, ((bw)localObject4).bXE, bool, true, (int[])localObject1, localObject3.length, localObject3.length + paramau.length, parambe, paramal, paramcb, params, paramap);
                                        }
                                      }
                                    }
                                  }
                                  i13 = k;
                                  k = i;
                                  i = i13;
                                  break;
                                  i4 = i3;
                                  i3 = i1;
                                  i1 = i4;
                                }
                                i = j;
                                j = i3;
                                continue;
                                j = i2;
                              }
                            }
                            label2578:
                            label2603:
                            label3124:
                            label3509:
                            label3530:
                            i3 = i2;
                            label2710:
                            label3494:
                            i2 = i1;
                            label3476:
                            i1 = i3;
                          }
                        }
                      }
                      label3551:
                      i2 = i1;
                    }
                  }
                }
                i1 = n;
              }
              i1 = n;
            }
          }
          label3589:
          k = m;
        }
        i = m;
      }
      label3603:
      i = 1;
    }
  }
  
  private void a(T paramT1, T paramT2, int paramInt)
  {
    long l = gJ(paramInt) & 0xFFFFF;
    if (!e(paramT2, paramInt)) {}
    do
    {
      return;
      Object localObject = ch.k(paramT1, l);
      paramT2 = ch.k(paramT2, l);
      if ((localObject != null) && (paramT2 != null))
      {
        ch.a(paramT1, l, ae.l(localObject, paramT2));
        f(paramT1, paramInt);
        return;
      }
    } while (paramT2 == null);
    ch.a(paramT1, l, paramT2);
    f(paramT1, paramInt);
  }
  
  private boolean a(T paramT, int paramInt1, int paramInt2)
  {
    return ch.f(paramT, gK(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private void b(T paramT, int paramInt1, int paramInt2)
  {
    ch.a(paramT, gK(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private void b(T paramT1, T paramT2, int paramInt)
  {
    int i = gJ(paramInt);
    int j = this.bYo[paramInt];
    long l = i & 0xFFFFF;
    if (!a(paramT2, j, paramInt)) {}
    do
    {
      return;
      Object localObject = ch.k(paramT1, l);
      paramT2 = ch.k(paramT2, l);
      if ((localObject != null) && (paramT2 != null))
      {
        ch.a(paramT1, l, ae.l(localObject, paramT2));
        b(paramT1, j, paramInt);
        return;
      }
    } while (paramT2 == null);
    ch.a(paramT1, l, paramT2);
    b(paramT1, j, paramInt);
  }
  
  private static Field c(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField1 = paramClass.getDeclaredField(paramString);
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label58;
        }
        Field localField2 = arrayOfField[i];
        Object localObject = localField2;
        if (paramString.equals(localField2.getName())) {
          break;
        }
        i += 1;
      }
      label58:
      throw new RuntimeException("Field " + paramString + " for " + paramClass.getName() + " not found. Known fields are " + Arrays.toString(arrayOfField));
    }
  }
  
  private boolean c(T paramT1, T paramT2, int paramInt)
  {
    return e(paramT1, paramInt) == e(paramT2, paramInt);
  }
  
  private static <T> int d(T paramT, long paramLong)
  {
    return ((Integer)ch.k(paramT, paramLong)).intValue();
  }
  
  private static <T> long e(T paramT, long paramLong)
  {
    return ((Long)ch.k(paramT, paramLong)).longValue();
  }
  
  private boolean e(T paramT, int paramInt)
  {
    if (this.bYu)
    {
      paramInt = gJ(paramInt);
      long l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 0: 
        return ch.j(paramT, l) != 0.0D;
      case 1: 
        return ch.i(paramT, l) != 0.0F;
      case 2: 
        return ch.g(paramT, l) != 0L;
      case 3: 
        return ch.g(paramT, l) != 0L;
      case 4: 
        return ch.f(paramT, l) != 0;
      case 5: 
        return ch.g(paramT, l) != 0L;
      case 6: 
        return ch.f(paramT, l) != 0;
      case 7: 
        return ch.h(paramT, l);
      case 8: 
        paramT = ch.k(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof g)) {
          return !g.bNg.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 9: 
        return ch.k(paramT, l) != null;
      case 10: 
        return !g.bNg.equals(ch.k(paramT, l));
      case 11: 
        return ch.f(paramT, l) != 0;
      case 12: 
        return ch.f(paramT, l) != 0;
      case 13: 
        return ch.f(paramT, l) != 0;
      case 14: 
        return ch.g(paramT, l) != 0L;
      case 15: 
        return ch.f(paramT, l) != 0;
      case 16: 
        return ch.g(paramT, l) != 0L;
      }
      return ch.k(paramT, l) != null;
    }
    paramInt = gK(paramInt);
    return (ch.f(paramT, paramInt & 0xFFFFF) & 1 << (paramInt >>> 20)) != 0;
  }
  
  private void f(T paramT, int paramInt)
  {
    if (this.bYu) {
      return;
    }
    paramInt = gK(paramInt);
    long l = paramInt & 0xFFFFF;
    ch.a(paramT, l, ch.f(paramT, l) | 1 << (paramInt >>> 20));
  }
  
  private int gJ(int paramInt)
  {
    return this.bYo[(paramInt + 1)];
  }
  
  private int gK(int paramInt)
  {
    return this.bYo[(paramInt + 2)];
  }
  
  public final void ap(T paramT)
  {
    int i = this.bYx;
    while (i < this.bYy)
    {
      long l = gJ(this.bYw[i]) & 0xFFFFF;
      Object localObject = ch.k(paramT, l);
      if (localObject != null) {
        ch.a(paramT, l, this.bYD.au(localObject));
      }
      i += 1;
    }
    int j = this.bYw.length;
    i = this.bYy;
    while (i < j)
    {
      this.bYA.a(paramT, this.bYw[i]);
      i += 1;
    }
    this.bYB.ap(paramT);
    if (this.bYs) {
      this.bYC.ap(paramT);
    }
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    int k = this.bYo.length;
    int i = 0;
    if (i < k)
    {
      j = gJ(i);
      l = j & 0xFFFFF;
      switch ((j & 0xFF00000) >>> 20)
      {
      default: 
        bool = true;
        if (bool) {
          break;
        }
      }
    }
    label1038:
    while (!this.bYB.aw(paramT1).equals(this.bYB.aw(paramT2)))
    {
      for (;;)
      {
        int j;
        long l;
        boolean bool;
        return false;
        if ((!c(paramT1, paramT2, i)) || (Double.doubleToLongBits(ch.j(paramT1, l)) != Double.doubleToLongBits(ch.j(paramT2, l))))
        {
          bool = false;
          continue;
          if ((!c(paramT1, paramT2, i)) || (Float.floatToIntBits(ch.i(paramT1, l)) != Float.floatToIntBits(ch.i(paramT2, l))))
          {
            bool = false;
            continue;
            if ((!c(paramT1, paramT2, i)) || (ch.g(paramT1, l) != ch.g(paramT2, l)))
            {
              bool = false;
              continue;
              if ((!c(paramT1, paramT2, i)) || (ch.g(paramT1, l) != ch.g(paramT2, l)))
              {
                bool = false;
                continue;
                if ((!c(paramT1, paramT2, i)) || (ch.f(paramT1, l) != ch.f(paramT2, l)))
                {
                  bool = false;
                  continue;
                  if ((!c(paramT1, paramT2, i)) || (ch.g(paramT1, l) != ch.g(paramT2, l)))
                  {
                    bool = false;
                    continue;
                    if ((!c(paramT1, paramT2, i)) || (ch.f(paramT1, l) != ch.f(paramT2, l)))
                    {
                      bool = false;
                      continue;
                      if ((!c(paramT1, paramT2, i)) || (ch.h(paramT1, l) != ch.h(paramT2, l)))
                      {
                        bool = false;
                        continue;
                        if ((!c(paramT1, paramT2, i)) || (!bt.o(ch.k(paramT1, l), ch.k(paramT2, l))))
                        {
                          bool = false;
                          continue;
                          if ((!c(paramT1, paramT2, i)) || (!bt.o(ch.k(paramT1, l), ch.k(paramT2, l))))
                          {
                            bool = false;
                            continue;
                            if ((!c(paramT1, paramT2, i)) || (!bt.o(ch.k(paramT1, l), ch.k(paramT2, l))))
                            {
                              bool = false;
                              continue;
                              if ((!c(paramT1, paramT2, i)) || (ch.f(paramT1, l) != ch.f(paramT2, l)))
                              {
                                bool = false;
                                continue;
                                if ((!c(paramT1, paramT2, i)) || (ch.f(paramT1, l) != ch.f(paramT2, l)))
                                {
                                  bool = false;
                                  continue;
                                  if ((!c(paramT1, paramT2, i)) || (ch.f(paramT1, l) != ch.f(paramT2, l)))
                                  {
                                    bool = false;
                                    continue;
                                    if ((!c(paramT1, paramT2, i)) || (ch.g(paramT1, l) != ch.g(paramT2, l)))
                                    {
                                      bool = false;
                                      continue;
                                      if ((!c(paramT1, paramT2, i)) || (ch.f(paramT1, l) != ch.f(paramT2, l)))
                                      {
                                        bool = false;
                                        continue;
                                        if ((!c(paramT1, paramT2, i)) || (ch.g(paramT1, l) != ch.g(paramT2, l)))
                                        {
                                          bool = false;
                                          continue;
                                          if ((!c(paramT1, paramT2, i)) || (!bt.o(ch.k(paramT1, l), ch.k(paramT2, l))))
                                          {
                                            bool = false;
                                            continue;
                                            bool = bt.o(ch.k(paramT1, l), ch.k(paramT2, l));
                                            continue;
                                            bool = bt.o(ch.k(paramT1, l), ch.k(paramT2, l));
                                            continue;
                                            j = gK(i);
                                            if (ch.f(paramT1, j & 0xFFFFF) == ch.f(paramT2, j & 0xFFFFF)) {}
                                            for (j = 1;; j = 0)
                                            {
                                              if ((j != 0) && (bt.o(ch.k(paramT1, l), ch.k(paramT2, l)))) {
                                                break label1038;
                                              }
                                              bool = false;
                                              break;
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
      i += 3;
      break;
    }
    if (this.bYs) {
      return this.bYC.an(paramT1).equals(this.bYC.an(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int m = this.bYo.length;
    int j = 0;
    int i = 0;
    int n;
    long l;
    Object localObject;
    if (j < m)
    {
      k = gJ(j);
      n = this.bYo[j];
      l = 0xFFFFF & k;
      switch ((k & 0xFF00000) >>> 20)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        for (;;)
        {
          j += 3;
          break;
          i = i * 53 + ae.aF(Double.doubleToLongBits(ch.j(paramT, l)));
          continue;
          i = i * 53 + Float.floatToIntBits(ch.i(paramT, l));
          continue;
          i = i * 53 + ae.aF(ch.g(paramT, l));
          continue;
          i = i * 53 + ae.aF(ch.g(paramT, l));
          continue;
          i = i * 53 + ch.f(paramT, l);
          continue;
          i = i * 53 + ae.aF(ch.g(paramT, l));
          continue;
          i = i * 53 + ch.f(paramT, l);
          continue;
          i = i * 53 + ae.bF(ch.h(paramT, l));
          continue;
          i = ((String)ch.k(paramT, l)).hashCode() + i * 53;
        }
      case 9: 
        localObject = ch.k(paramT, l);
        if (localObject == null) {
          break;
        }
      }
    }
    for (int k = localObject.hashCode();; k = 37)
    {
      i = k + i * 53;
      break;
      i = i * 53 + ch.k(paramT, l).hashCode();
      break;
      i = i * 53 + ch.f(paramT, l);
      break;
      i = i * 53 + ch.f(paramT, l);
      break;
      i = i * 53 + ch.f(paramT, l);
      break;
      i = i * 53 + ae.aF(ch.g(paramT, l));
      break;
      i = i * 53 + ch.f(paramT, l);
      break;
      i = i * 53 + ae.aF(ch.g(paramT, l));
      break;
      localObject = ch.k(paramT, l);
      if (localObject != null) {}
      for (k = localObject.hashCode();; k = 37)
      {
        i = k + i * 53;
        break;
        i = i * 53 + ch.k(paramT, l).hashCode();
        break;
        i = i * 53 + ch.k(paramT, l).hashCode();
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = ae.aF(Double.doubleToLongBits(((Double)ch.k(paramT, l)).doubleValue())) + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = Float.floatToIntBits(((Float)ch.k(paramT, l)).floatValue()) + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + ae.aF(e(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + ae.aF(e(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + d(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + ae.aF(e(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + d(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = ae.bF(((Boolean)ch.k(paramT, l)).booleanValue()) + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = ((String)ch.k(paramT, l)).hashCode() + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = ch.k(paramT, l).hashCode() + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + ch.k(paramT, l).hashCode();
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + d(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + d(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + d(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + ae.aF(e(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + d(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + ae.aF(e(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = ch.k(paramT, l).hashCode() + i * 53;
        break;
        j = i * 53 + this.bYB.aw(paramT).hashCode();
        i = j;
        if (this.bYs) {
          i = j * 53 + this.bYC.an(paramT).hashCode();
        }
        return i;
      }
    }
  }
  
  public final void n(T paramT1, T paramT2)
  {
    if (paramT2 == null) {
      throw new NullPointerException();
    }
    int i = 0;
    if (i < this.bYo.length)
    {
      int j = gJ(i);
      long l = 0xFFFFF & j;
      int k = this.bYo[i];
      switch ((j & 0xFF00000) >>> 20)
      {
      }
      for (;;)
      {
        i += 3;
        break;
        if (e(paramT2, i))
        {
          ch.a(paramT1, l, ch.j(paramT2, l));
          f(paramT1, i);
          continue;
          if (e(paramT2, i))
          {
            ch.a(paramT1, l, ch.i(paramT2, l));
            f(paramT1, i);
            continue;
            if (e(paramT2, i))
            {
              ch.a(paramT1, l, ch.g(paramT2, l));
              f(paramT1, i);
              continue;
              if (e(paramT2, i))
              {
                ch.a(paramT1, l, ch.g(paramT2, l));
                f(paramT1, i);
                continue;
                if (e(paramT2, i))
                {
                  ch.a(paramT1, l, ch.f(paramT2, l));
                  f(paramT1, i);
                  continue;
                  if (e(paramT2, i))
                  {
                    ch.a(paramT1, l, ch.g(paramT2, l));
                    f(paramT1, i);
                    continue;
                    if (e(paramT2, i))
                    {
                      ch.a(paramT1, l, ch.f(paramT2, l));
                      f(paramT1, i);
                      continue;
                      if (e(paramT2, i))
                      {
                        ch.a(paramT1, l, ch.h(paramT2, l));
                        f(paramT1, i);
                        continue;
                        if (e(paramT2, i))
                        {
                          ch.a(paramT1, l, ch.k(paramT2, l));
                          f(paramT1, i);
                          continue;
                          a(paramT1, paramT2, i);
                          continue;
                          if (e(paramT2, i))
                          {
                            ch.a(paramT1, l, ch.k(paramT2, l));
                            f(paramT1, i);
                            continue;
                            if (e(paramT2, i))
                            {
                              ch.a(paramT1, l, ch.f(paramT2, l));
                              f(paramT1, i);
                              continue;
                              if (e(paramT2, i))
                              {
                                ch.a(paramT1, l, ch.f(paramT2, l));
                                f(paramT1, i);
                                continue;
                                if (e(paramT2, i))
                                {
                                  ch.a(paramT1, l, ch.f(paramT2, l));
                                  f(paramT1, i);
                                  continue;
                                  if (e(paramT2, i))
                                  {
                                    ch.a(paramT1, l, ch.g(paramT2, l));
                                    f(paramT1, i);
                                    continue;
                                    if (e(paramT2, i))
                                    {
                                      ch.a(paramT1, l, ch.f(paramT2, l));
                                      f(paramT1, i);
                                      continue;
                                      if (e(paramT2, i))
                                      {
                                        ch.a(paramT1, l, ch.g(paramT2, l));
                                        f(paramT1, i);
                                        continue;
                                        a(paramT1, paramT2, i);
                                        continue;
                                        this.bYA.a(paramT1, paramT2, l);
                                        continue;
                                        bt.a(this.bYD, paramT1, paramT2, l);
                                        continue;
                                        if (a(paramT2, k, i))
                                        {
                                          ch.a(paramT1, l, ch.k(paramT2, l));
                                          b(paramT1, k, i);
                                          continue;
                                          b(paramT1, paramT2, i);
                                          continue;
                                          if (a(paramT2, k, i))
                                          {
                                            ch.a(paramT1, l, ch.k(paramT2, l));
                                            b(paramT1, k, i);
                                            continue;
                                            b(paramT1, paramT2, i);
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
    if (!this.bYu)
    {
      bt.a(this.bYB, paramT1, paramT2);
      if (this.bYs) {
        bt.a(this.bYC, paramT1, paramT2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.bb
 * JD-Core Version:    0.7.0.1
 */