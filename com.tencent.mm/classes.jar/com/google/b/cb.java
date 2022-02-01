package com.google.b;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

final class cb<T>
  implements cp<T>
{
  private static final Unsafe UNSAFE = df.Ju();
  private static final int[] bZR = new int[0];
  private final int[] bZS;
  private final Object[] bZT;
  private final int bZU;
  private final int bZV;
  private final bw bZW;
  private final boolean bZX;
  private final boolean bZY;
  private final boolean bZZ;
  private final boolean caa;
  private final int[] cab;
  private final int cac;
  private final int cad;
  private final cd cae;
  private final bl caf;
  private final cz<?, ?> cag;
  private final aq<?> cah;
  private final bp cai;
  
  private cb(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, bw parambw, boolean paramBoolean, int[] paramArrayOfInt2, int paramInt3, int paramInt4, cd paramcd, bl parambl, cz<?, ?> paramcz, aq<?> paramaq, bp parambp)
  {
    this.bZS = paramArrayOfInt1;
    this.bZT = paramArrayOfObject;
    this.bZU = paramInt1;
    this.bZV = paramInt2;
    this.bZY = (parambw instanceof az);
    this.bZZ = paramBoolean;
    if ((paramaq != null) && (paramaq.e(parambw))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bZX = paramBoolean;
      this.caa = true;
      this.cab = paramArrayOfInt2;
      this.cac = paramInt3;
      this.cad = paramInt4;
      this.cae = paramcd;
      this.caf = parambl;
      this.cag = paramcz;
      this.cah = paramaq;
      this.bZW = parambw;
      this.cai = parambp;
      return;
    }
  }
  
  private static <T> int a(T paramT, long paramLong)
  {
    return ((Integer)df.h(paramT, paramLong)).intValue();
  }
  
  static <T> cb<T> a(bu parambu, cd paramcd, bl parambl, cz<?, ?> paramcz, aq<?> paramaq, bp parambp)
  {
    if ((parambu instanceof cn)) {
      throw null;
    }
    cu localcu = (cu)parambu;
    boolean bool;
    au[] arrayOfau;
    int k;
    int m;
    label48:
    int i;
    int[] arrayOfInt3;
    Object[] arrayOfObject;
    int j;
    int n;
    int i3;
    label84:
    int i2;
    int i1;
    if (localcu.caQ == cj.cao)
    {
      bool = true;
      arrayOfau = localcu.caS;
      if (arrayOfau.length != 0) {
        break label140;
      }
      k = 0;
      m = 0;
      i = arrayOfau.length;
      arrayOfInt3 = new int[i * 3];
      arrayOfObject = new Object[i * 2];
      j = 0;
      n = 0;
      i3 = arrayOfau.length;
      i = 0;
      if (i >= i3) {
        break label218;
      }
      parambu = arrayOfau[i];
      if (parambu.bWm != aw.bXD) {
        break label165;
      }
      i2 = j + 1;
      i1 = n;
    }
    for (;;)
    {
      i += 1;
      n = i1;
      j = i2;
      break label84;
      bool = false;
      break;
      label140:
      k = arrayOfau[0].bWo;
      m = arrayOfau[(arrayOfau.length - 1)].bWo;
      break label48;
      label165:
      i1 = n;
      i2 = j;
      if (parambu.bWm.id >= 18)
      {
        i1 = n;
        i2 = j;
        if (parambu.bWm.id <= 49)
        {
          i1 = n + 1;
          i2 = j;
        }
      }
    }
    label218:
    Object localObject;
    int[] arrayOfInt1;
    label240:
    int[] arrayOfInt2;
    if (j > 0)
    {
      localObject = new int[j];
      if (n <= 0) {
        break label592;
      }
      arrayOfInt1 = new int[n];
      n = 0;
      i1 = 0;
      arrayOfInt2 = localcu.caR;
      if (arrayOfInt2 != null) {
        break label1035;
      }
      arrayOfInt2 = bZR;
    }
    label1035:
    for (;;)
    {
      int i4 = 0;
      i3 = 0;
      i2 = 0;
      label272:
      if (i3 < arrayOfau.length)
      {
        au localau = arrayOfau[i3];
        int i9 = localau.bWo;
        parambu = localau.bWt;
        int i6;
        int i5;
        label340:
        int i7;
        label362:
        int i8;
        if (parambu != null)
        {
          i6 = localau.bWm.id + 51;
          i5 = (int)df.c(parambu.cam);
          i = (int)df.c(parambu.cal);
          j = 0;
          arrayOfInt3[i2] = localau.bWo;
          if (!localau.bWs) {
            break label718;
          }
          i7 = 536870912;
          if (!localau.bWr) {
            break label724;
          }
          i8 = 268435456;
          label374:
          arrayOfInt3[(i2 + 1)] = (i5 | i6 << 20 | i7 | i8);
          arrayOfInt3[(i2 + 2)] = (j << 20 | i);
          switch (au.1.bWy[localau.bWm.ordinal()])
          {
          default: 
            parambu = null;
            label454:
            if (localau.bWw != null)
            {
              arrayOfObject[(i2 / 3 * 2)] = localau.bWw;
              if (parambu != null)
              {
                arrayOfObject[(i2 / 3 * 2 + 1)] = parambu;
                label492:
                i = i4;
                if (i4 < arrayOfInt2.length)
                {
                  i = i4;
                  if (arrayOfInt2[i4] == i9)
                  {
                    arrayOfInt2[i4] = i2;
                    i = i4 + 1;
                  }
                }
                if (localau.bWm != aw.bXD) {
                  break label841;
                }
                localObject[n] = i2;
                i5 = n + 1;
                j = i1;
              }
            }
            break;
          }
        }
        for (;;)
        {
          i3 += 1;
          i2 += 3;
          i4 = i;
          i1 = j;
          n = i5;
          break label272;
          localObject = null;
          break;
          label592:
          arrayOfInt1 = null;
          break label240;
          parambu = localau.bWm;
          i5 = (int)df.c(localau.bKF);
          i6 = parambu.id;
          if ((!bool) && (!parambu.bXF.bXQ))
          {
            if (parambu.bXF == aw.a.bXP) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label684;
              }
              i = (int)df.c(localau.bWp);
              j = Integer.numberOfTrailingZeros(localau.bWq);
              break;
            }
          }
          label684:
          if (localau.bWu == null)
          {
            i = 0;
            j = 0;
            break label340;
          }
          i = (int)df.c(localau.bWu);
          j = 0;
          break label340;
          label718:
          i7 = 0;
          break label362;
          label724:
          i8 = 0;
          break label374;
          if (localau.bKF != null)
          {
            parambu = localau.bKF.getType();
            break label454;
          }
          parambu = localau.bWv;
          break label454;
          parambu = localau.bWn;
          break label454;
          if (localau.bWx == null) {
            break label492;
          }
          arrayOfObject[(i2 / 3 * 2 + 1)] = localau.bWx;
          break label492;
          if (parambu != null)
          {
            arrayOfObject[(i2 / 3 * 2 + 1)] = parambu;
            break label492;
          }
          if (localau.bWx == null) {
            break label492;
          }
          arrayOfObject[(i2 / 3 * 2 + 1)] = localau.bWx;
          break label492;
          label841:
          j = i1;
          i5 = n;
          if (localau.bWm.id >= 18)
          {
            j = i1;
            i5 = n;
            if (localau.bWm.id <= 49)
            {
              arrayOfInt1[i1] = ((int)df.c(localau.bKF));
              j = i1 + 1;
              i5 = n;
            }
          }
        }
      }
      if (localObject == null) {}
      for (parambu = bZR;; parambu = (bu)localObject)
      {
        localObject = arrayOfInt1;
        if (arrayOfInt1 == null) {
          localObject = bZR;
        }
        arrayOfInt1 = new int[arrayOfInt2.length + parambu.length + localObject.length];
        System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
        System.arraycopy(parambu, 0, arrayOfInt1, arrayOfInt2.length, parambu.length);
        System.arraycopy(localObject, 0, arrayOfInt1, arrayOfInt2.length + parambu.length, localObject.length);
        return new cb(arrayOfInt3, arrayOfObject, k, m, localcu.bZW, bool, arrayOfInt1, arrayOfInt2.length, arrayOfInt2.length + parambu.length, paramcd, parambl, paramcz, paramaq, parambp);
      }
    }
  }
  
  private boolean a(T paramT, int paramInt1, int paramInt2)
  {
    return df.c(paramT, hB(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private boolean a(T paramT1, T paramT2, int paramInt)
  {
    return f(paramT1, paramInt) == f(paramT2, paramInt);
  }
  
  private static <T> long b(T paramT, long paramLong)
  {
    return ((Long)df.h(paramT, paramLong)).longValue();
  }
  
  private boolean f(T paramT, int paramInt)
  {
    if (this.bZZ)
    {
      paramInt = hA(paramInt);
      long l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 0: 
        return df.g(paramT, l) != 0.0D;
      case 1: 
        return df.f(paramT, l) != 0.0F;
      case 2: 
        return df.d(paramT, l) != 0L;
      case 3: 
        return df.d(paramT, l) != 0L;
      case 4: 
        return df.c(paramT, l) != 0;
      case 5: 
        return df.d(paramT, l) != 0L;
      case 6: 
        return df.c(paramT, l) != 0;
      case 7: 
        return df.e(paramT, l);
      case 8: 
        paramT = df.h(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof g)) {
          return !g.bPf.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 9: 
        return df.h(paramT, l) != null;
      case 10: 
        return !g.bPf.equals(df.h(paramT, l));
      case 11: 
        return df.c(paramT, l) != 0;
      case 12: 
        return df.c(paramT, l) != 0;
      case 13: 
        return df.c(paramT, l) != 0;
      case 14: 
        return df.d(paramT, l) != 0L;
      case 15: 
        return df.c(paramT, l) != 0;
      case 16: 
        return df.d(paramT, l) != 0L;
      }
      return df.h(paramT, l) != null;
    }
    paramInt = hB(paramInt);
    return (df.c(paramT, paramInt & 0xFFFFF) & 1 << (paramInt >>> 20)) != 0;
  }
  
  private int hA(int paramInt)
  {
    return this.bZS[(paramInt + 1)];
  }
  
  private int hB(int paramInt)
  {
    return this.bZS[(paramInt + 2)];
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    int k = this.bZS.length;
    int i = 0;
    if (i < k)
    {
      j = hA(i);
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
    label1032:
    while (!this.cag.as(paramT1).equals(this.cag.as(paramT2)))
    {
      for (;;)
      {
        int j;
        long l;
        boolean bool;
        return false;
        if ((!a(paramT1, paramT2, i)) || (Double.doubleToLongBits(df.g(paramT1, l)) != Double.doubleToLongBits(df.g(paramT2, l))))
        {
          bool = false;
          continue;
          if ((!a(paramT1, paramT2, i)) || (Float.floatToIntBits(df.f(paramT1, l)) != Float.floatToIntBits(df.f(paramT2, l))))
          {
            bool = false;
            continue;
            if ((!a(paramT1, paramT2, i)) || (df.d(paramT1, l) != df.d(paramT2, l)))
            {
              bool = false;
              continue;
              if ((!a(paramT1, paramT2, i)) || (df.d(paramT1, l) != df.d(paramT2, l)))
              {
                bool = false;
                continue;
                if ((!a(paramT1, paramT2, i)) || (df.c(paramT1, l) != df.c(paramT2, l)))
                {
                  bool = false;
                  continue;
                  if ((!a(paramT1, paramT2, i)) || (df.d(paramT1, l) != df.d(paramT2, l)))
                  {
                    bool = false;
                    continue;
                    if ((!a(paramT1, paramT2, i)) || (df.c(paramT1, l) != df.c(paramT2, l)))
                    {
                      bool = false;
                      continue;
                      if ((!a(paramT1, paramT2, i)) || (df.e(paramT1, l) != df.e(paramT2, l)))
                      {
                        bool = false;
                        continue;
                        if ((!a(paramT1, paramT2, i)) || (!cr.j(df.h(paramT1, l), df.h(paramT2, l))))
                        {
                          bool = false;
                          continue;
                          if ((!a(paramT1, paramT2, i)) || (!cr.j(df.h(paramT1, l), df.h(paramT2, l))))
                          {
                            bool = false;
                            continue;
                            if ((!a(paramT1, paramT2, i)) || (!cr.j(df.h(paramT1, l), df.h(paramT2, l))))
                            {
                              bool = false;
                              continue;
                              if ((!a(paramT1, paramT2, i)) || (df.c(paramT1, l) != df.c(paramT2, l)))
                              {
                                bool = false;
                                continue;
                                if ((!a(paramT1, paramT2, i)) || (df.c(paramT1, l) != df.c(paramT2, l)))
                                {
                                  bool = false;
                                  continue;
                                  if ((!a(paramT1, paramT2, i)) || (df.c(paramT1, l) != df.c(paramT2, l)))
                                  {
                                    bool = false;
                                    continue;
                                    if ((!a(paramT1, paramT2, i)) || (df.d(paramT1, l) != df.d(paramT2, l)))
                                    {
                                      bool = false;
                                      continue;
                                      if ((!a(paramT1, paramT2, i)) || (df.c(paramT1, l) != df.c(paramT2, l)))
                                      {
                                        bool = false;
                                        continue;
                                        if ((!a(paramT1, paramT2, i)) || (df.d(paramT1, l) != df.d(paramT2, l)))
                                        {
                                          bool = false;
                                          continue;
                                          if ((!a(paramT1, paramT2, i)) || (!cr.j(df.h(paramT1, l), df.h(paramT2, l))))
                                          {
                                            bool = false;
                                            continue;
                                            bool = cr.j(df.h(paramT1, l), df.h(paramT2, l));
                                            continue;
                                            bool = cr.j(df.h(paramT1, l), df.h(paramT2, l));
                                            continue;
                                            j = hB(i);
                                            if (df.c(paramT1, j & 0xFFFFF) == df.c(paramT2, j & 0xFFFFF)) {}
                                            for (j = 1;; j = 0)
                                            {
                                              if ((j != 0) && (cr.j(df.h(paramT1, l), df.h(paramT2, l)))) {
                                                break label1032;
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
    if (this.bZX) {
      return this.cah.am(paramT1).equals(this.cah.am(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int m = this.bZS.length;
    int j = 0;
    int i = 0;
    int n;
    long l;
    Object localObject;
    if (j < m)
    {
      k = hA(j);
      n = this.bZS[j];
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
          i = i * 53 + be.aJ(Double.doubleToLongBits(df.g(paramT, l)));
          continue;
          i = i * 53 + Float.floatToIntBits(df.f(paramT, l));
          continue;
          i = i * 53 + be.aJ(df.d(paramT, l));
          continue;
          i = i * 53 + be.aJ(df.d(paramT, l));
          continue;
          i = i * 53 + df.c(paramT, l);
          continue;
          i = i * 53 + be.aJ(df.d(paramT, l));
          continue;
          i = i * 53 + df.c(paramT, l);
          continue;
          i = i * 53 + be.bS(df.e(paramT, l));
          continue;
          i = ((String)df.h(paramT, l)).hashCode() + i * 53;
        }
      case 9: 
        localObject = df.h(paramT, l);
        if (localObject == null) {
          break;
        }
      }
    }
    for (int k = localObject.hashCode();; k = 37)
    {
      i = k + i * 53;
      break;
      i = i * 53 + df.h(paramT, l).hashCode();
      break;
      i = i * 53 + df.c(paramT, l);
      break;
      i = i * 53 + df.c(paramT, l);
      break;
      i = i * 53 + df.c(paramT, l);
      break;
      i = i * 53 + be.aJ(df.d(paramT, l));
      break;
      i = i * 53 + df.c(paramT, l);
      break;
      i = i * 53 + be.aJ(df.d(paramT, l));
      break;
      localObject = df.h(paramT, l);
      if (localObject != null) {}
      for (k = localObject.hashCode();; k = 37)
      {
        i = k + i * 53;
        break;
        i = i * 53 + df.h(paramT, l).hashCode();
        break;
        i = i * 53 + df.h(paramT, l).hashCode();
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = be.aJ(Double.doubleToLongBits(((Double)df.h(paramT, l)).doubleValue())) + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = Float.floatToIntBits(((Float)df.h(paramT, l)).floatValue()) + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + be.aJ(b(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + be.aJ(b(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + a(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + be.aJ(b(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + a(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = be.bS(((Boolean)df.h(paramT, l)).booleanValue()) + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = ((String)df.h(paramT, l)).hashCode() + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = df.h(paramT, l).hashCode() + i * 53;
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + df.h(paramT, l).hashCode();
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + a(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + a(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + a(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + be.aJ(b(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + a(paramT, l);
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = i * 53 + be.aJ(b(paramT, l));
        break;
        if (!a(paramT, n, j)) {
          break;
        }
        i = df.h(paramT, l).hashCode() + i * 53;
        break;
        j = i * 53 + this.cag.as(paramT).hashCode();
        i = j;
        if (this.bZX) {
          i = j * 53 + this.cah.am(paramT).hashCode();
        }
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.cb
 * JD-Core Version:    0.7.0.1
 */