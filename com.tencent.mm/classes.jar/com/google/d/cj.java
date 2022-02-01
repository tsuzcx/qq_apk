package com.google.d;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import sun.misc.Unsafe;

final class cj<T>
  implements dc<T>
{
  private static final Unsafe UNSAFE = ds.ajQ();
  private static final int[] dTZ = new int[0];
  private final int[] dUa;
  private final Object[] dUb;
  private final int dUc;
  private final int dUd;
  private final ce dUe;
  private final boolean dUf;
  private final boolean dUg;
  private final boolean dUh;
  private final boolean dUi;
  private final int[] dUj;
  private final int dUk;
  private final int dUl;
  private final cm dUm;
  private final bq dUn;
  private final dm<?, ?> dUo;
  private final au<?> dUp;
  private final bx dUq;
  
  private cj(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, ce paramce, boolean paramBoolean, int[] paramArrayOfInt2, int paramInt3, int paramInt4, cm paramcm, bq parambq, dm<?, ?> paramdm, au<?> paramau, bx parambx)
  {
    this.dUa = paramArrayOfInt1;
    this.dUb = paramArrayOfObject;
    this.dUc = paramInt1;
    this.dUd = paramInt2;
    this.dUg = (paramce instanceof be);
    this.dUh = paramBoolean;
    if ((paramau != null) && (paramau.d(paramce))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.dUf = paramBoolean;
      this.dUi = true;
      this.dUj = paramArrayOfInt2;
      this.dUk = paramInt3;
      this.dUl = paramInt4;
      this.dUm = paramcm;
      this.dUn = parambq;
      this.dUo = paramdm;
      this.dUp = paramau;
      this.dUe = paramce;
      this.dUq = parambx;
      return;
    }
  }
  
  private static <UT, UB> int a(dm<UT, UB> paramdm, T paramT)
  {
    return paramdm.bH(paramdm.bL(paramT));
  }
  
  static <T> cj<T> a(cc paramcc, cm paramcm, bq parambq, dm<?, ?> paramdm, au<?> paramau, bx parambx)
  {
    if ((paramcc instanceof cy)) {
      throw null;
    }
    dh localdh = (dh)paramcc;
    boolean bool;
    ay[] arrayOfay;
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
    if (localdh.dVr == cu.dUx)
    {
      bool = true;
      arrayOfay = localdh.dVt;
      if (arrayOfay.length != 0) {
        break label140;
      }
      k = 0;
      m = 0;
      i = arrayOfay.length;
      arrayOfInt3 = new int[i * 3];
      arrayOfObject = new Object[i * 2];
      j = 0;
      n = 0;
      i3 = arrayOfay.length;
      i = 0;
      if (i >= i3) {
        break label218;
      }
      paramcc = arrayOfay[i];
      if (paramcc.dQa != ba.dRp) {
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
      k = arrayOfay[0].dQc;
      m = arrayOfay[(arrayOfay.length - 1)].dQc;
      break label48;
      label165:
      i1 = n;
      i2 = j;
      if (paramcc.dQa.id >= 18)
      {
        i1 = n;
        i2 = j;
        if (paramcc.dQa.id <= 49)
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
      arrayOfInt2 = localdh.dVs;
      if (arrayOfInt2 != null) {
        break label1035;
      }
      arrayOfInt2 = dTZ;
    }
    label1035:
    for (;;)
    {
      int i4 = 0;
      i3 = 0;
      i2 = 0;
      label272:
      if (i3 < arrayOfay.length)
      {
        ay localay = arrayOfay[i3];
        int i9 = localay.dQc;
        paramcc = localay.dQh;
        int i6;
        int i5;
        label340:
        int i7;
        label362:
        int i8;
        if (paramcc != null)
        {
          i6 = localay.dQa.id + 51;
          i5 = (int)ds.d(paramcc.dUv);
          i = (int)ds.d(paramcc.dUu);
          j = 0;
          arrayOfInt3[i2] = localay.dQc;
          if (!localay.dQg) {
            break label718;
          }
          i7 = 536870912;
          if (!localay.dQf) {
            break label724;
          }
          i8 = 268435456;
          label374:
          arrayOfInt3[(i2 + 1)] = (i5 | i6 << 20 | i7 | i8);
          arrayOfInt3[(i2 + 2)] = (j << 20 | i);
          switch (ay.1.dQm[localay.dQa.ordinal()])
          {
          default: 
            paramcc = null;
            label454:
            if (localay.dQk != null)
            {
              arrayOfObject[(i2 / 3 * 2)] = localay.dQk;
              if (paramcc != null)
              {
                arrayOfObject[(i2 / 3 * 2 + 1)] = paramcc;
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
                if (localay.dQa != ba.dRp) {
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
          paramcc = localay.dQa;
          i5 = (int)ds.d(localay.dEn);
          i6 = paramcc.id;
          if ((!bool) && (!paramcc.dRr.dRC))
          {
            if (paramcc.dRr == ba.a.dRB) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label684;
              }
              i = (int)ds.d(localay.dQd);
              j = Integer.numberOfTrailingZeros(localay.dQe);
              break;
            }
          }
          label684:
          if (localay.dQi == null)
          {
            i = 0;
            j = 0;
            break label340;
          }
          i = (int)ds.d(localay.dQi);
          j = 0;
          break label340;
          label718:
          i7 = 0;
          break label362;
          label724:
          i8 = 0;
          break label374;
          if (localay.dEn != null)
          {
            paramcc = localay.dEn.getType();
            break label454;
          }
          paramcc = localay.dQj;
          break label454;
          paramcc = localay.dQb;
          break label454;
          if (localay.dQl == null) {
            break label492;
          }
          arrayOfObject[(i2 / 3 * 2 + 1)] = localay.dQl;
          break label492;
          if (paramcc != null)
          {
            arrayOfObject[(i2 / 3 * 2 + 1)] = paramcc;
            break label492;
          }
          if (localay.dQl == null) {
            break label492;
          }
          arrayOfObject[(i2 / 3 * 2 + 1)] = localay.dQl;
          break label492;
          label841:
          j = i1;
          i5 = n;
          if (localay.dQa.id >= 18)
          {
            j = i1;
            i5 = n;
            if (localay.dQa.id <= 49)
            {
              arrayOfInt1[i1] = ((int)ds.d(localay.dEn));
              j = i1 + 1;
              i5 = n;
            }
          }
        }
      }
      if (localObject == null) {}
      for (paramcc = dTZ;; paramcc = (cc)localObject)
      {
        localObject = arrayOfInt1;
        if (arrayOfInt1 == null) {
          localObject = dTZ;
        }
        arrayOfInt1 = new int[arrayOfInt2.length + paramcc.length + localObject.length];
        System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
        System.arraycopy(paramcc, 0, arrayOfInt1, arrayOfInt2.length, paramcc.length);
        System.arraycopy(localObject, 0, arrayOfInt1, arrayOfInt2.length + paramcc.length, localObject.length);
        return new cj(arrayOfInt3, arrayOfObject, k, m, localdh.dUe, bool, arrayOfInt1, arrayOfInt2.length, arrayOfInt2.length + paramcc.length, paramcm, parambq, paramdm, paramau, parambx);
      }
    }
  }
  
  private final <K, V, UT, UB> UB a(int paramInt1, int paramInt2, Map<K, V> paramMap, bj.e parame, UB paramUB, dm<UT, UB> paramdm)
  {
    bu.a locala = this.dUq.bG(ln(paramInt1));
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!parame.kB(((Integer)localEntry.getValue()).intValue()))
      {
        paramMap = paramUB;
        if (paramUB == null) {
          paramMap = paramdm.ajD();
        }
        paramUB = h.jL(bu.a(locala, localEntry.getKey(), localEntry.getValue()));
        k localk = paramUB.dIQ;
        try
        {
          bu.a(localk, locala, localEntry.getKey(), localEntry.getValue());
          paramdm.a(paramMap, paramInt2, paramUB.aab());
          localIterator.remove();
          paramUB = paramMap;
        }
        catch (IOException paramMap)
        {
          throw new RuntimeException(paramMap);
        }
      }
    }
    return paramUB;
  }
  
  private final <UT, UB> UB a(Object paramObject, int paramInt, UB paramUB, dm<UT, UB> paramdm)
  {
    int i = this.dUa[paramInt];
    paramObject = ds.o(paramObject, lp(paramInt) & 0xFFFFF);
    if (paramObject == null) {}
    bj.e locale;
    do
    {
      return paramUB;
      locale = lo(paramInt);
    } while (locale == null);
    return a(paramInt, i, this.dUq.bB(paramObject), locale, paramUB, paramdm);
  }
  
  private static void a(int paramInt, Object paramObject, dv paramdv)
  {
    if ((paramObject instanceof String))
    {
      paramdv.g(paramInt, (String)paramObject);
      return;
    }
    paramdv.a(paramInt, (h)paramObject);
  }
  
  private <UT, UB, ET extends az.a<ET>> void a(dm<UT, UB> paramdm, au<ET> paramau, T paramT, cz paramcz, at paramat)
  {
    Object localObject1 = null;
    Object localObject6 = null;
    label6:
    Object localObject3 = localObject1;
    for (;;)
    {
      try
      {
        for (;;)
        {
          m = paramcz.aaD();
          localObject3 = localObject1;
          int n;
          int i1;
          if (m >= this.dUc)
          {
            localObject3 = localObject1;
            if (m <= this.dUd)
            {
              i = 0;
              localObject3 = localObject1;
              j = this.dUa.length / 3 - 1;
              if (i <= j)
              {
                n = j + i >>> 1;
                k = n * 3;
                localObject3 = localObject1;
                i1 = this.dUa[k];
                if (m == i1) {
                  i = k;
                }
              }
            }
          }
          label290:
          for (;;)
          {
            label109:
            if (i < 0)
            {
              if (m == 2147483647)
              {
                i = this.dUk;
                for (;;)
                {
                  if (i < this.dUl)
                  {
                    localObject1 = a(paramT, this.dUj[i], localObject1, paramdm);
                    i += 1;
                    continue;
                    if (m < i1)
                    {
                      j = n - 1;
                      break;
                    }
                    i = n + 1;
                    break;
                    i = -1;
                    break label109;
                    i = -1;
                    break label109;
                  }
                }
                if (localObject1 != null) {
                  paramdm.u(paramT, localObject1);
                }
              }
              do
              {
                return;
                localObject3 = localObject1;
                if (!this.dUf) {}
                for (localObject3 = null;; localObject3 = localObject4)
                {
                  if (localObject3 == null) {
                    break label290;
                  }
                  if (localObject6 != null) {
                    break label4641;
                  }
                  localObject3 = localObject1;
                  localObject4 = paramau.bt(paramT);
                  localObject3 = localObject1;
                  localObject1 = paramau.ahK();
                  localObject6 = localObject4;
                  break;
                  localObject3 = localObject1;
                  localObject4 = paramau.a(paramat, this.dUe, m);
                }
                localObject3 = localObject1;
                if (paramdm.a(paramcz))
                {
                  localObject3 = localObject1;
                  bool = paramcz.aaE();
                  if (bool) {
                    break;
                  }
                }
                for (;;)
                {
                  i = this.dUk;
                  while (i < this.dUl)
                  {
                    localObject1 = a(paramT, this.dUj[i], localObject1, paramdm);
                    i += 1;
                  }
                  localObject4 = localObject1;
                  if (localObject1 == null)
                  {
                    localObject3 = localObject1;
                    localObject4 = paramdm.bM(paramT);
                  }
                  localObject3 = localObject4;
                  bool = paramdm.a(localObject4, paramcz);
                  localObject1 = localObject4;
                  if (bool) {
                    break;
                  }
                  localObject1 = localObject4;
                }
              } while (localObject1 == null);
              paramdm.u(paramT, localObject1);
              return;
            }
          }
          localObject3 = localObject1;
          j = lp(i);
          switch ((0xFF00000 & j) >>> 20)
          {
          default: 
            localObject5 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localObject1;
              localObject3 = localObject1;
            }
          case 0: 
            try
            {
              localObject5 = paramdm.ajD();
              localObject4 = localObject5;
              localObject3 = localObject5;
              bool = paramdm.a(localObject5, paramcz);
              localObject1 = localObject5;
              if (bool) {
                break label6;
              }
              i = this.dUk;
              while (i < this.dUl)
              {
                localObject5 = a(paramT, this.dUj[i], localObject5, paramdm);
                i += 1;
              }
              l = j & 0xFFFFF;
              localObject4 = localObject1;
              localObject3 = localObject1;
              ds.a(paramT, l, paramcz.readDouble());
              localObject4 = localObject1;
              localObject3 = localObject1;
              h(paramT, i);
            }
            catch (bk.a locala)
            {
              localObject3 = localObject4;
              if (!paramdm.a(paramcz)) {
                break label4527;
              }
            }
          }
        }
        localObject3 = localObject4;
        bool = paramcz.aaE();
        localObject2 = localObject4;
        if (bool) {
          break;
        }
        i = this.dUk;
        if (i < this.dUl)
        {
          localObject4 = a(paramT, this.dUj[i], localObject4, paramdm);
          i += 1;
          continue;
          l = j & 0xFFFFF;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, l, paramcz.readFloat());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
        }
      }
      finally
      {
        int m;
        int j;
        int k;
        boolean bool;
        Object localObject5;
        long l;
        Object localObject2;
        int i = this.dUk;
        if (i < this.dUl)
        {
          localObject3 = a(paramT, this.dUj[i], localObject3, paramdm);
          i += 1;
          continue;
          l = j & 0xFFFFF;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, l, paramcz.aae());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aad());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aaf());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aag());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aah());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aai());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          a(paramT, j, paramcz);
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          if (g(paramT, i))
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            localObject5 = bj.q(ds.o(paramT, 0xFFFFF & j), paramcz.a(lm(i), paramat));
            localObject4 = localObject2;
            localObject3 = localObject2;
            ds.a(paramT, j & 0xFFFFF, localObject5);
            break;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.a(lm(i), paramat));
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aak());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aal());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          k = paramcz.aam();
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject5 = lo(i);
          if (localObject5 != null)
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            if (!((bj.e)localObject5).kB(k)) {}
          }
          else
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            ds.a(paramT, j & 0xFFFFF, k);
            localObject4 = localObject2;
            localObject3 = localObject2;
            h(paramT, i);
            break;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject2 = de.a(m, k, localObject2, paramdm);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aan());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aao());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aap());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aaq());
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          if (g(paramT, i))
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            localObject5 = bj.q(ds.o(paramT, 0xFFFFF & j), paramcz.b(lm(i), paramat));
            localObject4 = localObject2;
            localObject3 = localObject2;
            ds.a(paramT, j & 0xFFFFF, localObject5);
            break;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.b(lm(i), paramat));
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.ar(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.as(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.au(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.at(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.av(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aw(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.ax(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.ay(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          if (lr(j))
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            paramcz.aA(this.dUn.a(paramT, j & 0xFFFFF));
            break;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.az(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject5 = lm(i);
          l = j & 0xFFFFF;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.a(this.dUn.a(paramT, l), (dc)localObject5, paramat);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aB(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aC(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject5 = this.dUn.a(paramT, j & 0xFFFFF);
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aD((List)localObject5);
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject2 = de.a(m, (List)localObject5, lo(i), localObject2, paramdm);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aE(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aF(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aG(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aH(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.ar(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.as(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.au(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.at(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.av(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aw(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.ax(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.ay(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aC(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject5 = this.dUn.a(paramT, j & 0xFFFFF);
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aD((List)localObject5);
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject2 = de.a(m, (List)localObject5, lo(i), localObject2, paramdm);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aE(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aF(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aG(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.aH(this.dUn.a(paramT, j & 0xFFFFF));
          break;
          l = j & 0xFFFFF;
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject5 = lm(i);
          localObject4 = localObject2;
          localObject3 = localObject2;
          paramcz.b(this.dUn.a(paramT, l), (dc)localObject5, paramat);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          Object localObject8 = ln(i);
          localObject4 = localObject2;
          localObject3 = localObject2;
          l = lp(i) & 0xFFFFF;
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject5 = ds.o(paramT, l);
          if (localObject5 == null)
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            localObject5 = this.dUq.bF(localObject8);
            localObject4 = localObject2;
            localObject3 = localObject2;
            ds.a(paramT, l, localObject5);
            localObject4 = localObject2;
            localObject3 = localObject2;
            paramcz.a(this.dUq.bB(localObject5), this.dUq.bG(localObject8), paramat);
            break;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          if (!this.dUq.bD(localObject5)) {
            break label4638;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          Object localObject7 = this.dUq.bF(localObject8);
          localObject4 = localObject2;
          localObject3 = localObject2;
          this.dUq.s(localObject7, localObject5);
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, l, localObject7);
          localObject5 = localObject7;
          continue;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Double.valueOf(paramcz.readDouble()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Float.valueOf(paramcz.readFloat()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Long.valueOf(paramcz.aae()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Long.valueOf(paramcz.aad()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Integer.valueOf(paramcz.aaf()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Long.valueOf(paramcz.aag()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Integer.valueOf(paramcz.aah()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Boolean.valueOf(paramcz.aai()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          a(paramT, j, paramcz);
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          if (b(paramT, m, i))
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            localObject5 = bj.q(ds.o(paramT, 0xFFFFF & j), paramcz.a(lm(i), paramat));
            localObject4 = localObject2;
            localObject3 = localObject2;
            ds.a(paramT, j & 0xFFFFF, localObject5);
            localObject4 = localObject2;
            localObject3 = localObject2;
            c(paramT, m, i);
            break;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.a(lm(i), paramat));
          localObject4 = localObject2;
          localObject3 = localObject2;
          h(paramT, i);
          continue;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.aak());
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Integer.valueOf(paramcz.aal()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          k = paramcz.aam();
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject5 = lo(i);
          if (localObject5 != null)
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            if (!((bj.e)localObject5).kB(k)) {}
          }
          else
          {
            localObject4 = localObject2;
            localObject3 = localObject2;
            ds.a(paramT, j & 0xFFFFF, Integer.valueOf(k));
            localObject4 = localObject2;
            localObject3 = localObject2;
            c(paramT, m, i);
            break;
          }
          localObject4 = localObject2;
          localObject3 = localObject2;
          localObject2 = de.a(m, k, localObject2, paramdm);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Integer.valueOf(paramcz.aan()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Long.valueOf(paramcz.aao()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Integer.valueOf(paramcz.aap()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, Long.valueOf(paramcz.aaq()));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          localObject4 = localObject2;
          localObject3 = localObject2;
          ds.a(paramT, j & 0xFFFFF, paramcz.b(lm(i), paramat));
          localObject4 = localObject2;
          localObject3 = localObject2;
          c(paramT, m, i);
          break;
          if (localObject5 == null) {
            continue;
          }
          paramdm.u(paramT, localObject5);
          return;
          if (localObject4 == null) {
            continue;
          }
          paramdm.u(paramT, localObject4);
          return;
          label4527:
          localObject5 = localObject4;
          if (localObject4 == null)
          {
            localObject3 = localObject4;
            localObject5 = paramdm.bM(paramT);
          }
          localObject3 = localObject5;
          bool = paramdm.a(localObject5, paramcz);
          localObject2 = localObject5;
          if (bool) {
            break;
          }
          i = this.dUk;
          if (i < this.dUl)
          {
            localObject5 = a(paramT, this.dUj[i], localObject5, paramdm);
            i += 1;
            continue;
          }
          if (localObject5 == null) {
            continue;
          }
          paramdm.u(paramT, localObject5);
          return;
        }
        if (localObject3 != null) {
          paramdm.u(paramT, localObject3);
        }
      }
      label4638:
      continue;
      label4641:
      Object localObject4 = localObject6;
    }
  }
  
  private static <UT, UB> void a(dm<UT, UB> paramdm, T paramT, dv paramdv)
  {
    paramdm.a(paramdm.bL(paramT), paramdv);
  }
  
  private <K, V> void a(dv paramdv, int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramObject != null) {
      paramdv.a(paramInt1, this.dUq.bG(ln(paramInt2)), this.dUq.bC(paramObject));
    }
  }
  
  private void a(Object paramObject, int paramInt, cz paramcz)
  {
    if (lr(paramInt))
    {
      ds.a(paramObject, paramInt & 0xFFFFF, paramcz.aaj());
      return;
    }
    if (this.dUg)
    {
      ds.a(paramObject, paramInt & 0xFFFFF, paramcz.readString());
      return;
    }
    ds.a(paramObject, paramInt & 0xFFFFF, paramcz.aak());
  }
  
  private boolean a(T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.dUh) {
      return g(paramT, paramInt1);
    }
    return (paramInt2 & paramInt3) != 0;
  }
  
  private static boolean a(Object paramObject, int paramInt, dc paramdc)
  {
    return paramdc.bI(ds.o(paramObject, 0xFFFFF & paramInt));
  }
  
  private boolean a(T paramT1, T paramT2, int paramInt)
  {
    return g(paramT1, paramInt) == g(paramT2, paramInt);
  }
  
  private void b(T paramT, dv paramdv)
  {
    Unsafe localUnsafe = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localUnsafe;
    if (this.dUf)
    {
      az localaz = this.dUp.bs(paramT);
      localObject1 = localObject3;
      localObject2 = localUnsafe;
      if (!localaz.dQn.isEmpty())
      {
        localObject2 = localaz.iterator();
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
      }
    }
    int j = -1;
    int i = 0;
    int i1 = this.dUa.length;
    localUnsafe = UNSAFE;
    int k = 0;
    int m;
    if (k < i1)
    {
      int i2 = lp(k);
      int i3 = this.dUa[k];
      int i4 = (0xFF00000 & i2) >>> 20;
      if ((!this.dUh) && (i4 <= 17))
      {
        int n = this.dUa[(k + 2)];
        m = n & 0xFFFFF;
        if (m != j)
        {
          j = localUnsafe.getInt(paramT, m);
          i = m;
          n = 1 << (n >>> 20);
          m = j;
          j = i;
          i = m;
          m = n;
          label201:
          if ((localObject1 != null) && (this.dUp.e((Map.Entry)localObject1) <= i3))
          {
            this.dUp.a(paramdv, (Map.Entry)localObject1);
            if (((Iterator)localObject2).hasNext()) {}
            for (localObject1 = (Map.Entry)((Iterator)localObject2).next();; localObject1 = null) {
              break;
            }
          }
          long l = 0xFFFFF & i2;
          switch (i4)
          {
          }
          for (;;)
          {
            k += 3;
            break;
            if ((i & m) != 0)
            {
              paramdv.d(i3, ds.n(paramT, l));
              continue;
              if ((i & m) != 0)
              {
                paramdv.l(i3, ds.m(paramT, l));
                continue;
                if ((i & m) != 0)
                {
                  paramdv.t(i3, localUnsafe.getLong(paramT, l));
                  continue;
                  if ((i & m) != 0)
                  {
                    paramdv.n(i3, localUnsafe.getLong(paramT, l));
                    continue;
                    if ((i & m) != 0)
                    {
                      paramdv.cF(i3, localUnsafe.getInt(paramT, l));
                      continue;
                      if ((i & m) != 0)
                      {
                        paramdv.p(i3, localUnsafe.getLong(paramT, l));
                        continue;
                        if ((i & m) != 0)
                        {
                          paramdv.cI(i3, localUnsafe.getInt(paramT, l));
                          continue;
                          if ((i & m) != 0)
                          {
                            paramdv.I(i3, ds.l(paramT, l));
                            continue;
                            if ((i & m) != 0)
                            {
                              a(i3, localUnsafe.getObject(paramT, l), paramdv);
                              continue;
                              if ((i & m) != 0)
                              {
                                paramdv.a(i3, localUnsafe.getObject(paramT, l), lm(k));
                                continue;
                                if ((i & m) != 0)
                                {
                                  paramdv.a(i3, (h)localUnsafe.getObject(paramT, l));
                                  continue;
                                  if ((i & m) != 0)
                                  {
                                    paramdv.cG(i3, localUnsafe.getInt(paramT, l));
                                    continue;
                                    if ((i & m) != 0)
                                    {
                                      paramdv.cP(i3, localUnsafe.getInt(paramT, l));
                                      continue;
                                      if ((i & m) != 0)
                                      {
                                        paramdv.cO(i3, localUnsafe.getInt(paramT, l));
                                        continue;
                                        if ((i & m) != 0)
                                        {
                                          paramdv.u(i3, localUnsafe.getLong(paramT, l));
                                          continue;
                                          if ((i & m) != 0)
                                          {
                                            paramdv.cH(i3, localUnsafe.getInt(paramT, l));
                                            continue;
                                            if ((i & m) != 0)
                                            {
                                              paramdv.o(i3, localUnsafe.getLong(paramT, l));
                                              continue;
                                              if ((i & m) != 0)
                                              {
                                                paramdv.b(i3, localUnsafe.getObject(paramT, l), lm(k));
                                                continue;
                                                de.a(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.b(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.c(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.d(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.h(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.f(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.k(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.n(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.a(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv);
                                                continue;
                                                de.a(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, lm(k));
                                                continue;
                                                de.b(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv);
                                                continue;
                                                de.i(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.m(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.l(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.g(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.j(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.e(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, false);
                                                continue;
                                                de.a(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.b(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.c(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.d(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.h(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.f(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.k(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.n(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.i(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.m(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.l(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.g(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.j(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.e(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, true);
                                                continue;
                                                de.b(this.dUa[k], (List)localUnsafe.getObject(paramT, l), paramdv, lm(k));
                                                continue;
                                                a(paramdv, i3, localUnsafe.getObject(paramT, l), k);
                                                continue;
                                                if (b(paramT, i3, k))
                                                {
                                                  paramdv.d(i3, e(paramT, l));
                                                  continue;
                                                  if (b(paramT, i3, k))
                                                  {
                                                    paramdv.l(i3, f(paramT, l));
                                                    continue;
                                                    if (b(paramT, i3, k))
                                                    {
                                                      paramdv.t(i3, h(paramT, l));
                                                      continue;
                                                      if (b(paramT, i3, k))
                                                      {
                                                        paramdv.n(i3, h(paramT, l));
                                                        continue;
                                                        if (b(paramT, i3, k))
                                                        {
                                                          paramdv.cF(i3, g(paramT, l));
                                                          continue;
                                                          if (b(paramT, i3, k))
                                                          {
                                                            paramdv.p(i3, h(paramT, l));
                                                            continue;
                                                            if (b(paramT, i3, k))
                                                            {
                                                              paramdv.cI(i3, g(paramT, l));
                                                              continue;
                                                              if (b(paramT, i3, k))
                                                              {
                                                                paramdv.I(i3, i(paramT, l));
                                                                continue;
                                                                if (b(paramT, i3, k))
                                                                {
                                                                  a(i3, localUnsafe.getObject(paramT, l), paramdv);
                                                                  continue;
                                                                  if (b(paramT, i3, k))
                                                                  {
                                                                    paramdv.a(i3, localUnsafe.getObject(paramT, l), lm(k));
                                                                    continue;
                                                                    if (b(paramT, i3, k))
                                                                    {
                                                                      paramdv.a(i3, (h)localUnsafe.getObject(paramT, l));
                                                                      continue;
                                                                      if (b(paramT, i3, k))
                                                                      {
                                                                        paramdv.cG(i3, g(paramT, l));
                                                                        continue;
                                                                        if (b(paramT, i3, k))
                                                                        {
                                                                          paramdv.cP(i3, g(paramT, l));
                                                                          continue;
                                                                          if (b(paramT, i3, k))
                                                                          {
                                                                            paramdv.cO(i3, g(paramT, l));
                                                                            continue;
                                                                            if (b(paramT, i3, k))
                                                                            {
                                                                              paramdv.u(i3, h(paramT, l));
                                                                              continue;
                                                                              if (b(paramT, i3, k))
                                                                              {
                                                                                paramdv.cH(i3, g(paramT, l));
                                                                                continue;
                                                                                if (b(paramT, i3, k))
                                                                                {
                                                                                  paramdv.o(i3, h(paramT, l));
                                                                                  continue;
                                                                                  if (b(paramT, i3, k)) {
                                                                                    paramdv.b(i3, localUnsafe.getObject(paramT, l), lm(k));
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
          label2451:
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        this.dUp.a(paramdv, (Map.Entry)localObject1);
        if (!((Iterator)localObject2).hasNext()) {
          break label2451;
        }
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        continue;
      }
      a(this.dUo, paramT, paramdv);
      return;
      m = j;
      j = i;
      i = m;
      break;
      m = 0;
      break label201;
    }
  }
  
  private boolean b(T paramT, int paramInt1, int paramInt2)
  {
    return ds.j(paramT, lq(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private void c(T paramT, int paramInt1, int paramInt2)
  {
    ds.a(paramT, lq(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private static List<?> d(Object paramObject, long paramLong)
  {
    return (List)ds.o(paramObject, paramLong);
  }
  
  private static <T> double e(T paramT, long paramLong)
  {
    return ((Double)ds.o(paramT, paramLong)).doubleValue();
  }
  
  private static <T> float f(T paramT, long paramLong)
  {
    return ((Float)ds.o(paramT, paramLong)).floatValue();
  }
  
  private static <T> int g(T paramT, long paramLong)
  {
    return ((Integer)ds.o(paramT, paramLong)).intValue();
  }
  
  private boolean g(T paramT, int paramInt)
  {
    if (this.dUh)
    {
      paramInt = lp(paramInt);
      long l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 0: 
        return ds.n(paramT, l) != 0.0D;
      case 1: 
        return ds.m(paramT, l) != 0.0F;
      case 2: 
        return ds.k(paramT, l) != 0L;
      case 3: 
        return ds.k(paramT, l) != 0L;
      case 4: 
        return ds.j(paramT, l) != 0;
      case 5: 
        return ds.k(paramT, l) != 0L;
      case 6: 
        return ds.j(paramT, l) != 0;
      case 7: 
        return ds.l(paramT, l);
      case 8: 
        paramT = ds.o(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof h)) {
          return !h.dIJ.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 9: 
        return ds.o(paramT, l) != null;
      case 10: 
        return !h.dIJ.equals(ds.o(paramT, l));
      case 11: 
        return ds.j(paramT, l) != 0;
      case 12: 
        return ds.j(paramT, l) != 0;
      case 13: 
        return ds.j(paramT, l) != 0;
      case 14: 
        return ds.k(paramT, l) != 0L;
      case 15: 
        return ds.j(paramT, l) != 0;
      case 16: 
        return ds.k(paramT, l) != 0L;
      }
      return ds.o(paramT, l) != null;
    }
    paramInt = lq(paramInt);
    return (ds.j(paramT, paramInt & 0xFFFFF) & 1 << (paramInt >>> 20)) != 0;
  }
  
  private static <T> long h(T paramT, long paramLong)
  {
    return ((Long)ds.o(paramT, paramLong)).longValue();
  }
  
  private void h(T paramT, int paramInt)
  {
    if (this.dUh) {
      return;
    }
    paramInt = lq(paramInt);
    long l = paramInt & 0xFFFFF;
    ds.a(paramT, l, ds.j(paramT, l) | 1 << (paramInt >>> 20));
  }
  
  private static <T> boolean i(T paramT, long paramLong)
  {
    return ((Boolean)ds.o(paramT, paramLong)).booleanValue();
  }
  
  private dc lm(int paramInt)
  {
    paramInt = paramInt / 3 * 2;
    dc localdc = (dc)this.dUb[paramInt];
    if (localdc != null) {
      return localdc;
    }
    localdc = cv.aja().O((Class)this.dUb[(paramInt + 1)]);
    this.dUb[paramInt] = localdc;
    return localdc;
  }
  
  private Object ln(int paramInt)
  {
    return this.dUb[(paramInt / 3 * 2)];
  }
  
  private bj.e lo(int paramInt)
  {
    return (bj.e)this.dUb[(paramInt / 3 * 2 + 1)];
  }
  
  private int lp(int paramInt)
  {
    return this.dUa[(paramInt + 1)];
  }
  
  private int lq(int paramInt)
  {
    return this.dUa[(paramInt + 2)];
  }
  
  private static boolean lr(int paramInt)
  {
    return (0x20000000 & paramInt) != 0;
  }
  
  public final void a(T paramT, cz paramcz, at paramat)
  {
    if (paramat == null) {
      throw new NullPointerException();
    }
    a(this.dUo, this.dUp, paramT, paramcz, paramat);
  }
  
  public final void a(T paramT, dv paramdv)
  {
    Object localObject2;
    Object localObject4;
    Object localObject1;
    Object localObject3;
    az localaz;
    int i;
    int j;
    int k;
    if (paramdv.aaP() == dv.a.dXq)
    {
      a(this.dUo, paramT, paramdv);
      localObject2 = null;
      localObject4 = null;
      localObject1 = localObject4;
      localObject3 = localObject2;
      if (this.dUf)
      {
        localaz = this.dUp.bs(paramT);
        localObject1 = localObject4;
        localObject3 = localObject2;
        if (!localaz.dQn.isEmpty())
        {
          if (!localaz.dQo) {
            break label206;
          }
          localObject1 = new bm.b(localaz.dQn.ajs().iterator());
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = localObject1;
          localObject1 = localObject2;
        }
      }
      i = this.dUa.length - 3;
      localObject2 = localObject1;
      if (i >= 0)
      {
        j = lp(i);
        k = this.dUa[i];
        label152:
        if ((localObject1 != null) && (this.dUp.e((Map.Entry)localObject1) > k))
        {
          this.dUp.a(paramdv, (Map.Entry)localObject1);
          if (((Iterator)localObject3).hasNext()) {}
          for (localObject1 = (Map.Entry)((Iterator)localObject3).next();; localObject1 = null)
          {
            break label152;
            label206:
            localObject1 = localaz.dQn.ajs().iterator();
            break;
          }
        }
        switch ((0xFF00000 & j) >>> 20)
        {
        }
        for (;;)
        {
          i -= 3;
          break;
          if (g(paramT, i))
          {
            paramdv.d(k, ds.n(paramT, 0xFFFFF & j));
            continue;
            if (g(paramT, i))
            {
              paramdv.l(k, ds.m(paramT, 0xFFFFF & j));
              continue;
              if (g(paramT, i))
              {
                paramdv.t(k, ds.k(paramT, 0xFFFFF & j));
                continue;
                if (g(paramT, i))
                {
                  paramdv.n(k, ds.k(paramT, 0xFFFFF & j));
                  continue;
                  if (g(paramT, i))
                  {
                    paramdv.cF(k, ds.j(paramT, 0xFFFFF & j));
                    continue;
                    if (g(paramT, i))
                    {
                      paramdv.p(k, ds.k(paramT, 0xFFFFF & j));
                      continue;
                      if (g(paramT, i))
                      {
                        paramdv.cI(k, ds.j(paramT, 0xFFFFF & j));
                        continue;
                        if (g(paramT, i))
                        {
                          paramdv.I(k, ds.l(paramT, 0xFFFFF & j));
                          continue;
                          if (g(paramT, i))
                          {
                            a(k, ds.o(paramT, 0xFFFFF & j), paramdv);
                            continue;
                            if (g(paramT, i))
                            {
                              paramdv.a(k, ds.o(paramT, 0xFFFFF & j), lm(i));
                              continue;
                              if (g(paramT, i))
                              {
                                paramdv.a(k, (h)ds.o(paramT, 0xFFFFF & j));
                                continue;
                                if (g(paramT, i))
                                {
                                  paramdv.cG(k, ds.j(paramT, 0xFFFFF & j));
                                  continue;
                                  if (g(paramT, i))
                                  {
                                    paramdv.cP(k, ds.j(paramT, 0xFFFFF & j));
                                    continue;
                                    if (g(paramT, i))
                                    {
                                      paramdv.cO(k, ds.j(paramT, 0xFFFFF & j));
                                      continue;
                                      if (g(paramT, i))
                                      {
                                        paramdv.u(k, ds.k(paramT, 0xFFFFF & j));
                                        continue;
                                        if (g(paramT, i))
                                        {
                                          paramdv.cH(k, ds.j(paramT, 0xFFFFF & j));
                                          continue;
                                          if (g(paramT, i))
                                          {
                                            paramdv.o(k, ds.k(paramT, 0xFFFFF & j));
                                            continue;
                                            if (g(paramT, i))
                                            {
                                              paramdv.b(k, ds.o(paramT, 0xFFFFF & j), lm(i));
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.c(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.d(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.h(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.f(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.k(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.n(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv);
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, lm(i));
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv);
                                              continue;
                                              de.i(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.m(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.l(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.g(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.j(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.e(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, false);
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.c(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.d(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.h(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.f(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.k(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.n(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.i(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.m(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.l(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.g(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.j(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.e(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, true);
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & j), paramdv, lm(i));
                                              continue;
                                              a(paramdv, k, ds.o(paramT, 0xFFFFF & j), i);
                                              continue;
                                              if (b(paramT, k, i))
                                              {
                                                paramdv.d(k, e(paramT, 0xFFFFF & j));
                                                continue;
                                                if (b(paramT, k, i))
                                                {
                                                  paramdv.l(k, f(paramT, 0xFFFFF & j));
                                                  continue;
                                                  if (b(paramT, k, i))
                                                  {
                                                    paramdv.t(k, h(paramT, 0xFFFFF & j));
                                                    continue;
                                                    if (b(paramT, k, i))
                                                    {
                                                      paramdv.n(k, h(paramT, 0xFFFFF & j));
                                                      continue;
                                                      if (b(paramT, k, i))
                                                      {
                                                        paramdv.cF(k, g(paramT, 0xFFFFF & j));
                                                        continue;
                                                        if (b(paramT, k, i))
                                                        {
                                                          paramdv.p(k, h(paramT, 0xFFFFF & j));
                                                          continue;
                                                          if (b(paramT, k, i))
                                                          {
                                                            paramdv.cI(k, g(paramT, 0xFFFFF & j));
                                                            continue;
                                                            if (b(paramT, k, i))
                                                            {
                                                              paramdv.I(k, i(paramT, 0xFFFFF & j));
                                                              continue;
                                                              if (b(paramT, k, i))
                                                              {
                                                                a(k, ds.o(paramT, 0xFFFFF & j), paramdv);
                                                                continue;
                                                                if (b(paramT, k, i))
                                                                {
                                                                  paramdv.a(k, ds.o(paramT, 0xFFFFF & j), lm(i));
                                                                  continue;
                                                                  if (b(paramT, k, i))
                                                                  {
                                                                    paramdv.a(k, (h)ds.o(paramT, 0xFFFFF & j));
                                                                    continue;
                                                                    if (b(paramT, k, i))
                                                                    {
                                                                      paramdv.cG(k, g(paramT, 0xFFFFF & j));
                                                                      continue;
                                                                      if (b(paramT, k, i))
                                                                      {
                                                                        paramdv.cP(k, g(paramT, 0xFFFFF & j));
                                                                        continue;
                                                                        if (b(paramT, k, i))
                                                                        {
                                                                          paramdv.cO(k, g(paramT, 0xFFFFF & j));
                                                                          continue;
                                                                          if (b(paramT, k, i))
                                                                          {
                                                                            paramdv.u(k, h(paramT, 0xFFFFF & j));
                                                                            continue;
                                                                            if (b(paramT, k, i))
                                                                            {
                                                                              paramdv.cH(k, g(paramT, 0xFFFFF & j));
                                                                              continue;
                                                                              if (b(paramT, k, i))
                                                                              {
                                                                                paramdv.o(k, h(paramT, 0xFFFFF & j));
                                                                                continue;
                                                                                if (b(paramT, k, i)) {
                                                                                  paramdv.b(k, ds.o(paramT, 0xFFFFF & j), lm(i));
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
      for (localObject2 = null;; localObject2 = (Map.Entry)((Iterator)localObject3).next())
      {
        if (localObject2 == null) {
          break label5301;
        }
        this.dUp.a(paramdv, (Map.Entry)localObject2);
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      }
    }
    if (this.dUh)
    {
      localObject2 = null;
      localObject4 = null;
      localObject1 = localObject4;
      localObject3 = localObject2;
      if (this.dUf)
      {
        localaz = this.dUp.bs(paramT);
        localObject1 = localObject4;
        localObject3 = localObject2;
        if (!localaz.dQn.isEmpty())
        {
          localObject3 = localaz.iterator();
          localObject1 = (Map.Entry)((Iterator)localObject3).next();
        }
      }
      j = this.dUa.length;
      i = 0;
      localObject2 = localObject1;
      if (i < j)
      {
        k = lp(i);
        int m = this.dUa[i];
        if ((localObject1 != null) && (this.dUp.e((Map.Entry)localObject1) <= m))
        {
          this.dUp.a(paramdv, (Map.Entry)localObject1);
          if (((Iterator)localObject3).hasNext()) {}
          for (localObject1 = (Map.Entry)((Iterator)localObject3).next();; localObject1 = null) {
            break;
          }
        }
        switch ((0xFF00000 & k) >>> 20)
        {
        }
        for (;;)
        {
          i += 3;
          break;
          if (g(paramT, i))
          {
            paramdv.d(m, ds.n(paramT, 0xFFFFF & k));
            continue;
            if (g(paramT, i))
            {
              paramdv.l(m, ds.m(paramT, 0xFFFFF & k));
              continue;
              if (g(paramT, i))
              {
                paramdv.t(m, ds.k(paramT, 0xFFFFF & k));
                continue;
                if (g(paramT, i))
                {
                  paramdv.n(m, ds.k(paramT, 0xFFFFF & k));
                  continue;
                  if (g(paramT, i))
                  {
                    paramdv.cF(m, ds.j(paramT, 0xFFFFF & k));
                    continue;
                    if (g(paramT, i))
                    {
                      paramdv.p(m, ds.k(paramT, 0xFFFFF & k));
                      continue;
                      if (g(paramT, i))
                      {
                        paramdv.cI(m, ds.j(paramT, 0xFFFFF & k));
                        continue;
                        if (g(paramT, i))
                        {
                          paramdv.I(m, ds.l(paramT, 0xFFFFF & k));
                          continue;
                          if (g(paramT, i))
                          {
                            a(m, ds.o(paramT, 0xFFFFF & k), paramdv);
                            continue;
                            if (g(paramT, i))
                            {
                              paramdv.a(m, ds.o(paramT, 0xFFFFF & k), lm(i));
                              continue;
                              if (g(paramT, i))
                              {
                                paramdv.a(m, (h)ds.o(paramT, 0xFFFFF & k));
                                continue;
                                if (g(paramT, i))
                                {
                                  paramdv.cG(m, ds.j(paramT, 0xFFFFF & k));
                                  continue;
                                  if (g(paramT, i))
                                  {
                                    paramdv.cP(m, ds.j(paramT, 0xFFFFF & k));
                                    continue;
                                    if (g(paramT, i))
                                    {
                                      paramdv.cO(m, ds.j(paramT, 0xFFFFF & k));
                                      continue;
                                      if (g(paramT, i))
                                      {
                                        paramdv.u(m, ds.k(paramT, 0xFFFFF & k));
                                        continue;
                                        if (g(paramT, i))
                                        {
                                          paramdv.cH(m, ds.j(paramT, 0xFFFFF & k));
                                          continue;
                                          if (g(paramT, i))
                                          {
                                            paramdv.o(m, ds.k(paramT, 0xFFFFF & k));
                                            continue;
                                            if (g(paramT, i))
                                            {
                                              paramdv.b(m, ds.o(paramT, 0xFFFFF & k), lm(i));
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.c(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.d(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.h(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.f(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.k(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.n(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv);
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, lm(i));
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv);
                                              continue;
                                              de.i(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.m(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.l(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.g(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.j(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.e(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, false);
                                              continue;
                                              de.a(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.c(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.d(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.h(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.f(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.k(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.n(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.i(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.m(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.l(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.g(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.j(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.e(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, true);
                                              continue;
                                              de.b(this.dUa[i], (List)ds.o(paramT, 0xFFFFF & k), paramdv, lm(i));
                                              continue;
                                              a(paramdv, m, ds.o(paramT, 0xFFFFF & k), i);
                                              continue;
                                              if (b(paramT, m, i))
                                              {
                                                paramdv.d(m, e(paramT, 0xFFFFF & k));
                                                continue;
                                                if (b(paramT, m, i))
                                                {
                                                  paramdv.l(m, f(paramT, 0xFFFFF & k));
                                                  continue;
                                                  if (b(paramT, m, i))
                                                  {
                                                    paramdv.t(m, h(paramT, 0xFFFFF & k));
                                                    continue;
                                                    if (b(paramT, m, i))
                                                    {
                                                      paramdv.n(m, h(paramT, 0xFFFFF & k));
                                                      continue;
                                                      if (b(paramT, m, i))
                                                      {
                                                        paramdv.cF(m, g(paramT, 0xFFFFF & k));
                                                        continue;
                                                        if (b(paramT, m, i))
                                                        {
                                                          paramdv.p(m, h(paramT, 0xFFFFF & k));
                                                          continue;
                                                          if (b(paramT, m, i))
                                                          {
                                                            paramdv.cI(m, g(paramT, 0xFFFFF & k));
                                                            continue;
                                                            if (b(paramT, m, i))
                                                            {
                                                              paramdv.I(m, i(paramT, 0xFFFFF & k));
                                                              continue;
                                                              if (b(paramT, m, i))
                                                              {
                                                                a(m, ds.o(paramT, 0xFFFFF & k), paramdv);
                                                                continue;
                                                                if (b(paramT, m, i))
                                                                {
                                                                  paramdv.a(m, ds.o(paramT, 0xFFFFF & k), lm(i));
                                                                  continue;
                                                                  if (b(paramT, m, i))
                                                                  {
                                                                    paramdv.a(m, (h)ds.o(paramT, 0xFFFFF & k));
                                                                    continue;
                                                                    if (b(paramT, m, i))
                                                                    {
                                                                      paramdv.cG(m, g(paramT, 0xFFFFF & k));
                                                                      continue;
                                                                      if (b(paramT, m, i))
                                                                      {
                                                                        paramdv.cP(m, g(paramT, 0xFFFFF & k));
                                                                        continue;
                                                                        if (b(paramT, m, i))
                                                                        {
                                                                          paramdv.cO(m, g(paramT, 0xFFFFF & k));
                                                                          continue;
                                                                          if (b(paramT, m, i))
                                                                          {
                                                                            paramdv.u(m, h(paramT, 0xFFFFF & k));
                                                                            continue;
                                                                            if (b(paramT, m, i))
                                                                            {
                                                                              paramdv.cH(m, g(paramT, 0xFFFFF & k));
                                                                              continue;
                                                                              if (b(paramT, m, i))
                                                                              {
                                                                                paramdv.o(m, h(paramT, 0xFFFFF & k));
                                                                                continue;
                                                                                if (b(paramT, m, i)) {
                                                                                  paramdv.b(m, ds.o(paramT, 0xFFFFF & k), lm(i));
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
      for (localObject2 = null;; localObject2 = (Map.Entry)((Iterator)localObject3).next())
      {
        if (localObject2 == null) {
          break label5292;
        }
        this.dUp.a(paramdv, (Map.Entry)localObject2);
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      }
      label5292:
      a(this.dUo, paramT, paramdv);
      label5301:
      return;
    }
    b(paramT, paramdv);
  }
  
  public final T aiW()
  {
    return this.dUm.bJ(this.dUe);
  }
  
  public final int bH(T paramT)
  {
    int i;
    int n;
    long l;
    label94:
    Object localObject;
    if (this.dUh)
    {
      localUnsafe = UNSAFE;
      k = 0;
      j = 0;
      if (j < this.dUa.length)
      {
        m = lp(j);
        i = (0xFF00000 & m) >>> 20;
        n = this.dUa[j];
        l = m & 0xFFFFF;
        if ((i >= ba.dRa.id) && (i <= ba.dRn.id))
        {
          m = this.dUa[(j + 2)] & 0xFFFFF;
          switch (i)
          {
          default: 
            i = k;
          }
        }
        for (;;)
        {
          j += 3;
          k = i;
          break;
          m = 0;
          break label94;
          i = k;
          if (g(paramT, j))
          {
            i = k + k.km(n);
            continue;
            i = k;
            if (g(paramT, j))
            {
              i = k + k.kl(n);
              continue;
              i = k;
              if (g(paramT, j))
              {
                i = k + k.q(n, ds.k(paramT, l));
                continue;
                i = k;
                if (g(paramT, j))
                {
                  i = k + k.r(n, ds.k(paramT, l));
                  continue;
                  i = k;
                  if (g(paramT, j))
                  {
                    i = k + k.cJ(n, ds.j(paramT, l));
                    continue;
                    i = k;
                    if (g(paramT, j))
                    {
                      i = k + k.kj(n);
                      continue;
                      i = k;
                      if (g(paramT, j))
                      {
                        i = k + k.kh(n);
                        continue;
                        i = k;
                        if (g(paramT, j))
                        {
                          i = k + k.kn(n);
                          continue;
                          i = k;
                          if (g(paramT, j))
                          {
                            localObject = ds.o(paramT, l);
                            if ((localObject instanceof h))
                            {
                              i = k + k.c(n, (h)localObject);
                            }
                            else
                            {
                              i = k + k.h(n, (String)localObject);
                              continue;
                              i = k;
                              if (g(paramT, j))
                              {
                                i = k + de.c(n, ds.o(paramT, l), lm(j));
                                continue;
                                i = k;
                                if (g(paramT, j))
                                {
                                  i = k + k.c(n, (h)ds.o(paramT, l));
                                  continue;
                                  i = k;
                                  if (g(paramT, j))
                                  {
                                    i = k + k.cK(n, ds.j(paramT, l));
                                    continue;
                                    i = k;
                                    if (g(paramT, j))
                                    {
                                      i = k + k.cM(n, ds.j(paramT, l));
                                      continue;
                                      i = k;
                                      if (g(paramT, j))
                                      {
                                        i = k + k.ki(n);
                                        continue;
                                        i = k;
                                        if (g(paramT, j))
                                        {
                                          i = k + k.kk(n);
                                          continue;
                                          i = k;
                                          if (g(paramT, j))
                                          {
                                            i = k + k.cL(n, ds.j(paramT, l));
                                            continue;
                                            i = k;
                                            if (g(paramT, j))
                                            {
                                              i = k + k.s(n, ds.k(paramT, l));
                                              continue;
                                              i = k;
                                              if (g(paramT, j))
                                              {
                                                i = k + k.c(n, (ce)ds.o(paramT, l), lm(j));
                                                continue;
                                                i = k + de.m(n, d(paramT, l));
                                                continue;
                                                i = k + de.l(n, d(paramT, l));
                                                continue;
                                                i = k + de.e(n, d(paramT, l));
                                                continue;
                                                i = k + de.f(n, d(paramT, l));
                                                continue;
                                                i = k + de.i(n, d(paramT, l));
                                                continue;
                                                i = k + de.m(n, d(paramT, l));
                                                continue;
                                                i = k + de.l(n, d(paramT, l));
                                                continue;
                                                i = k + de.n(n, d(paramT, l));
                                                continue;
                                                i = k + de.o(n, d(paramT, l));
                                                continue;
                                                i = k + de.c(n, d(paramT, l), lm(j));
                                                continue;
                                                i = k + de.p(n, d(paramT, l));
                                                continue;
                                                i = k + de.j(n, d(paramT, l));
                                                continue;
                                                i = k + de.h(n, d(paramT, l));
                                                continue;
                                                i = k + de.l(n, d(paramT, l));
                                                continue;
                                                i = k + de.m(n, d(paramT, l));
                                                continue;
                                                i = k + de.k(n, d(paramT, l));
                                                continue;
                                                i = k + de.g(n, d(paramT, l));
                                                continue;
                                                i1 = de.aS((List)localUnsafe.getObject(paramT, l));
                                                i = k;
                                                if (i1 > 0)
                                                {
                                                  if (this.dUi) {
                                                    localUnsafe.putInt(paramT, m, i1);
                                                  }
                                                  i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                  continue;
                                                  i1 = de.aR((List)localUnsafe.getObject(paramT, l));
                                                  i = k;
                                                  if (i1 > 0)
                                                  {
                                                    if (this.dUi) {
                                                      localUnsafe.putInt(paramT, m, i1);
                                                    }
                                                    i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                    continue;
                                                    i1 = de.aK((List)localUnsafe.getObject(paramT, l));
                                                    i = k;
                                                    if (i1 > 0)
                                                    {
                                                      if (this.dUi) {
                                                        localUnsafe.putInt(paramT, m, i1);
                                                      }
                                                      i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                      continue;
                                                      i1 = de.aL((List)localUnsafe.getObject(paramT, l));
                                                      i = k;
                                                      if (i1 > 0)
                                                      {
                                                        if (this.dUi) {
                                                          localUnsafe.putInt(paramT, m, i1);
                                                        }
                                                        i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                        continue;
                                                        i1 = de.aO((List)localUnsafe.getObject(paramT, l));
                                                        i = k;
                                                        if (i1 > 0)
                                                        {
                                                          if (this.dUi) {
                                                            localUnsafe.putInt(paramT, m, i1);
                                                          }
                                                          i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                          continue;
                                                          i1 = de.aS((List)localUnsafe.getObject(paramT, l));
                                                          i = k;
                                                          if (i1 > 0)
                                                          {
                                                            if (this.dUi) {
                                                              localUnsafe.putInt(paramT, m, i1);
                                                            }
                                                            i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                            continue;
                                                            i1 = de.aR((List)localUnsafe.getObject(paramT, l));
                                                            i = k;
                                                            if (i1 > 0)
                                                            {
                                                              if (this.dUi) {
                                                                localUnsafe.putInt(paramT, m, i1);
                                                              }
                                                              i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                              continue;
                                                              i1 = de.aT((List)localUnsafe.getObject(paramT, l));
                                                              i = k;
                                                              if (i1 > 0)
                                                              {
                                                                if (this.dUi) {
                                                                  localUnsafe.putInt(paramT, m, i1);
                                                                }
                                                                i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                                continue;
                                                                i1 = de.aP((List)localUnsafe.getObject(paramT, l));
                                                                i = k;
                                                                if (i1 > 0)
                                                                {
                                                                  if (this.dUi) {
                                                                    localUnsafe.putInt(paramT, m, i1);
                                                                  }
                                                                  i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                                  continue;
                                                                  i1 = de.aN((List)localUnsafe.getObject(paramT, l));
                                                                  i = k;
                                                                  if (i1 > 0)
                                                                  {
                                                                    if (this.dUi) {
                                                                      localUnsafe.putInt(paramT, m, i1);
                                                                    }
                                                                    i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                                    continue;
                                                                    i1 = de.aR((List)localUnsafe.getObject(paramT, l));
                                                                    i = k;
                                                                    if (i1 > 0)
                                                                    {
                                                                      if (this.dUi) {
                                                                        localUnsafe.putInt(paramT, m, i1);
                                                                      }
                                                                      i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                                      continue;
                                                                      i1 = de.aS((List)localUnsafe.getObject(paramT, l));
                                                                      i = k;
                                                                      if (i1 > 0)
                                                                      {
                                                                        if (this.dUi) {
                                                                          localUnsafe.putInt(paramT, m, i1);
                                                                        }
                                                                        i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                                        continue;
                                                                        i1 = de.aQ((List)localUnsafe.getObject(paramT, l));
                                                                        i = k;
                                                                        if (i1 > 0)
                                                                        {
                                                                          if (this.dUi) {
                                                                            localUnsafe.putInt(paramT, m, i1);
                                                                          }
                                                                          i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                                          continue;
                                                                          i1 = de.aM((List)localUnsafe.getObject(paramT, l));
                                                                          i = k;
                                                                          if (i1 > 0)
                                                                          {
                                                                            if (this.dUi) {
                                                                              localUnsafe.putInt(paramT, m, i1);
                                                                            }
                                                                            i = k + (i1 + (k.ko(n) + k.kq(i1)));
                                                                            continue;
                                                                            i = k + de.d(n, d(paramT, l), lm(j));
                                                                            continue;
                                                                            i = k + this.dUq.f(n, ds.o(paramT, l), ln(j));
                                                                            continue;
                                                                            i = k;
                                                                            if (b(paramT, n, j))
                                                                            {
                                                                              i = k + k.km(n);
                                                                              continue;
                                                                              i = k;
                                                                              if (b(paramT, n, j))
                                                                              {
                                                                                i = k + k.kl(n);
                                                                                continue;
                                                                                i = k;
                                                                                if (b(paramT, n, j))
                                                                                {
                                                                                  i = k + k.q(n, h(paramT, l));
                                                                                  continue;
                                                                                  i = k;
                                                                                  if (b(paramT, n, j))
                                                                                  {
                                                                                    i = k + k.r(n, h(paramT, l));
                                                                                    continue;
                                                                                    i = k;
                                                                                    if (b(paramT, n, j))
                                                                                    {
                                                                                      i = k + k.cJ(n, g(paramT, l));
                                                                                      continue;
                                                                                      i = k;
                                                                                      if (b(paramT, n, j))
                                                                                      {
                                                                                        i = k + k.kj(n);
                                                                                        continue;
                                                                                        i = k;
                                                                                        if (b(paramT, n, j))
                                                                                        {
                                                                                          i = k + k.kh(n);
                                                                                          continue;
                                                                                          i = k;
                                                                                          if (b(paramT, n, j))
                                                                                          {
                                                                                            i = k + k.kn(n);
                                                                                            continue;
                                                                                            i = k;
                                                                                            if (b(paramT, n, j))
                                                                                            {
                                                                                              localObject = ds.o(paramT, l);
                                                                                              if ((localObject instanceof h))
                                                                                              {
                                                                                                i = k + k.c(n, (h)localObject);
                                                                                              }
                                                                                              else
                                                                                              {
                                                                                                i = k + k.h(n, (String)localObject);
                                                                                                continue;
                                                                                                i = k;
                                                                                                if (b(paramT, n, j))
                                                                                                {
                                                                                                  i = k + de.c(n, ds.o(paramT, l), lm(j));
                                                                                                  continue;
                                                                                                  i = k;
                                                                                                  if (b(paramT, n, j))
                                                                                                  {
                                                                                                    i = k + k.c(n, (h)ds.o(paramT, l));
                                                                                                    continue;
                                                                                                    i = k;
                                                                                                    if (b(paramT, n, j))
                                                                                                    {
                                                                                                      i = k + k.cK(n, g(paramT, l));
                                                                                                      continue;
                                                                                                      i = k;
                                                                                                      if (b(paramT, n, j))
                                                                                                      {
                                                                                                        i = k + k.cM(n, g(paramT, l));
                                                                                                        continue;
                                                                                                        i = k;
                                                                                                        if (b(paramT, n, j))
                                                                                                        {
                                                                                                          i = k + k.ki(n);
                                                                                                          continue;
                                                                                                          i = k;
                                                                                                          if (b(paramT, n, j))
                                                                                                          {
                                                                                                            i = k + k.kk(n);
                                                                                                            continue;
                                                                                                            i = k;
                                                                                                            if (b(paramT, n, j))
                                                                                                            {
                                                                                                              i = k + k.cL(n, g(paramT, l));
                                                                                                              continue;
                                                                                                              i = k;
                                                                                                              if (b(paramT, n, j))
                                                                                                              {
                                                                                                                i = k + k.s(n, h(paramT, l));
                                                                                                                continue;
                                                                                                                i = k;
                                                                                                                if (b(paramT, n, j)) {
                                                                                                                  i = k + k.c(n, (ce)ds.o(paramT, l), lm(j));
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
      i = a(this.dUo, paramT) + k;
      return i;
    }
    int i1 = 0;
    Unsafe localUnsafe = UNSAFE;
    int j = -1;
    int k = 0;
    int m = 0;
    int i4;
    int i3;
    int i5;
    int i2;
    if (m < this.dUa.length)
    {
      i4 = lp(m);
      i3 = this.dUa[m];
      i5 = (0xFF00000 & i4) >>> 20;
      i2 = 0;
      if (i5 <= 17)
      {
        n = this.dUa[(m + 2)];
        i2 = 0xFFFFF & n;
        i = j;
        if (i2 != j)
        {
          k = localUnsafe.getInt(paramT, i2);
          i = i2;
        }
        i2 = 1 << (n >>> 20);
        j = n;
        n = i;
      }
    }
    for (;;)
    {
      label2910:
      l = 0xFFFFF & i4;
      switch (i5)
      {
      default: 
        i = i1;
      }
      for (;;)
      {
        m += 3;
        j = n;
        i1 = i;
        break;
        if ((!this.dUi) || (i5 < ba.dRa.id) || (i5 > ba.dRn.id)) {
          break label5804;
        }
        i = this.dUa[(m + 2)] & 0xFFFFF;
        n = j;
        j = i;
        break label2910;
        i = i1;
        if ((i2 & k) != 0)
        {
          i = i1 + k.km(i3);
          continue;
          i = i1;
          if ((i2 & k) != 0)
          {
            i = i1 + k.kl(i3);
            continue;
            i = i1;
            if ((i2 & k) != 0)
            {
              i = i1 + k.q(i3, localUnsafe.getLong(paramT, l));
              continue;
              i = i1;
              if ((i2 & k) != 0)
              {
                i = i1 + k.r(i3, localUnsafe.getLong(paramT, l));
                continue;
                i = i1;
                if ((i2 & k) != 0)
                {
                  i = i1 + k.cJ(i3, localUnsafe.getInt(paramT, l));
                  continue;
                  i = i1;
                  if ((i2 & k) != 0)
                  {
                    i = i1 + k.kj(i3);
                    continue;
                    i = i1;
                    if ((i2 & k) != 0)
                    {
                      i = i1 + k.kh(i3);
                      continue;
                      i = i1;
                      if ((i2 & k) != 0)
                      {
                        i = i1 + k.kn(i3);
                        continue;
                        i = i1;
                        if ((i2 & k) != 0)
                        {
                          localObject = localUnsafe.getObject(paramT, l);
                          if ((localObject instanceof h))
                          {
                            i = i1 + k.c(i3, (h)localObject);
                          }
                          else
                          {
                            i = i1 + k.h(i3, (String)localObject);
                            continue;
                            i = i1;
                            if ((i2 & k) != 0)
                            {
                              i = i1 + de.c(i3, localUnsafe.getObject(paramT, l), lm(m));
                              continue;
                              i = i1;
                              if ((i2 & k) != 0)
                              {
                                i = i1 + k.c(i3, (h)localUnsafe.getObject(paramT, l));
                                continue;
                                i = i1;
                                if ((i2 & k) != 0)
                                {
                                  i = i1 + k.cK(i3, localUnsafe.getInt(paramT, l));
                                  continue;
                                  i = i1;
                                  if ((i2 & k) != 0)
                                  {
                                    i = i1 + k.cM(i3, localUnsafe.getInt(paramT, l));
                                    continue;
                                    i = i1;
                                    if ((i2 & k) != 0)
                                    {
                                      i = i1 + k.ki(i3);
                                      continue;
                                      i = i1;
                                      if ((i2 & k) != 0)
                                      {
                                        i = i1 + k.kk(i3);
                                        continue;
                                        i = i1;
                                        if ((i2 & k) != 0)
                                        {
                                          i = i1 + k.cL(i3, localUnsafe.getInt(paramT, l));
                                          continue;
                                          i = i1;
                                          if ((i2 & k) != 0)
                                          {
                                            i = i1 + k.s(i3, localUnsafe.getLong(paramT, l));
                                            continue;
                                            i = i1;
                                            if ((i2 & k) != 0)
                                            {
                                              i = i1 + k.c(i3, (ce)localUnsafe.getObject(paramT, l), lm(m));
                                              continue;
                                              i = i1 + de.m(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.l(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.e(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.f(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.i(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.m(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.l(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.n(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.o(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.c(i3, (List)localUnsafe.getObject(paramT, l), lm(m));
                                              continue;
                                              i = i1 + de.p(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.j(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.h(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.l(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.m(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.k(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i = i1 + de.g(i3, (List)localUnsafe.getObject(paramT, l));
                                              continue;
                                              i2 = de.aS((List)localUnsafe.getObject(paramT, l));
                                              i = i1;
                                              if (i2 > 0)
                                              {
                                                if (this.dUi) {
                                                  localUnsafe.putInt(paramT, j, i2);
                                                }
                                                i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                continue;
                                                i2 = de.aR((List)localUnsafe.getObject(paramT, l));
                                                i = i1;
                                                if (i2 > 0)
                                                {
                                                  if (this.dUi) {
                                                    localUnsafe.putInt(paramT, j, i2);
                                                  }
                                                  i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                  continue;
                                                  i2 = de.aK((List)localUnsafe.getObject(paramT, l));
                                                  i = i1;
                                                  if (i2 > 0)
                                                  {
                                                    if (this.dUi) {
                                                      localUnsafe.putInt(paramT, j, i2);
                                                    }
                                                    i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                    continue;
                                                    i2 = de.aL((List)localUnsafe.getObject(paramT, l));
                                                    i = i1;
                                                    if (i2 > 0)
                                                    {
                                                      if (this.dUi) {
                                                        localUnsafe.putInt(paramT, j, i2);
                                                      }
                                                      i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                      continue;
                                                      i2 = de.aO((List)localUnsafe.getObject(paramT, l));
                                                      i = i1;
                                                      if (i2 > 0)
                                                      {
                                                        if (this.dUi) {
                                                          localUnsafe.putInt(paramT, j, i2);
                                                        }
                                                        i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                        continue;
                                                        i2 = de.aS((List)localUnsafe.getObject(paramT, l));
                                                        i = i1;
                                                        if (i2 > 0)
                                                        {
                                                          if (this.dUi) {
                                                            localUnsafe.putInt(paramT, j, i2);
                                                          }
                                                          i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                          continue;
                                                          i2 = de.aR((List)localUnsafe.getObject(paramT, l));
                                                          i = i1;
                                                          if (i2 > 0)
                                                          {
                                                            if (this.dUi) {
                                                              localUnsafe.putInt(paramT, j, i2);
                                                            }
                                                            i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                            continue;
                                                            i2 = de.aT((List)localUnsafe.getObject(paramT, l));
                                                            i = i1;
                                                            if (i2 > 0)
                                                            {
                                                              if (this.dUi) {
                                                                localUnsafe.putInt(paramT, j, i2);
                                                              }
                                                              i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                              continue;
                                                              i2 = de.aP((List)localUnsafe.getObject(paramT, l));
                                                              i = i1;
                                                              if (i2 > 0)
                                                              {
                                                                if (this.dUi) {
                                                                  localUnsafe.putInt(paramT, j, i2);
                                                                }
                                                                i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                                continue;
                                                                i2 = de.aN((List)localUnsafe.getObject(paramT, l));
                                                                i = i1;
                                                                if (i2 > 0)
                                                                {
                                                                  if (this.dUi) {
                                                                    localUnsafe.putInt(paramT, j, i2);
                                                                  }
                                                                  i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                                  continue;
                                                                  i2 = de.aR((List)localUnsafe.getObject(paramT, l));
                                                                  i = i1;
                                                                  if (i2 > 0)
                                                                  {
                                                                    if (this.dUi) {
                                                                      localUnsafe.putInt(paramT, j, i2);
                                                                    }
                                                                    i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                                    continue;
                                                                    i2 = de.aS((List)localUnsafe.getObject(paramT, l));
                                                                    i = i1;
                                                                    if (i2 > 0)
                                                                    {
                                                                      if (this.dUi) {
                                                                        localUnsafe.putInt(paramT, j, i2);
                                                                      }
                                                                      i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                                      continue;
                                                                      i2 = de.aQ((List)localUnsafe.getObject(paramT, l));
                                                                      i = i1;
                                                                      if (i2 > 0)
                                                                      {
                                                                        if (this.dUi) {
                                                                          localUnsafe.putInt(paramT, j, i2);
                                                                        }
                                                                        i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                                        continue;
                                                                        i2 = de.aM((List)localUnsafe.getObject(paramT, l));
                                                                        i = i1;
                                                                        if (i2 > 0)
                                                                        {
                                                                          if (this.dUi) {
                                                                            localUnsafe.putInt(paramT, j, i2);
                                                                          }
                                                                          i = i1 + (i2 + (k.ko(i3) + k.kq(i2)));
                                                                          continue;
                                                                          i = i1 + de.d(i3, (List)localUnsafe.getObject(paramT, l), lm(m));
                                                                          continue;
                                                                          i = i1 + this.dUq.f(i3, localUnsafe.getObject(paramT, l), ln(m));
                                                                          continue;
                                                                          i = i1;
                                                                          if (b(paramT, i3, m))
                                                                          {
                                                                            i = i1 + k.km(i3);
                                                                            continue;
                                                                            i = i1;
                                                                            if (b(paramT, i3, m))
                                                                            {
                                                                              i = i1 + k.kl(i3);
                                                                              continue;
                                                                              i = i1;
                                                                              if (b(paramT, i3, m))
                                                                              {
                                                                                i = i1 + k.q(i3, h(paramT, l));
                                                                                continue;
                                                                                i = i1;
                                                                                if (b(paramT, i3, m))
                                                                                {
                                                                                  i = i1 + k.r(i3, h(paramT, l));
                                                                                  continue;
                                                                                  i = i1;
                                                                                  if (b(paramT, i3, m))
                                                                                  {
                                                                                    i = i1 + k.cJ(i3, g(paramT, l));
                                                                                    continue;
                                                                                    i = i1;
                                                                                    if (b(paramT, i3, m))
                                                                                    {
                                                                                      i = i1 + k.kj(i3);
                                                                                      continue;
                                                                                      i = i1;
                                                                                      if (b(paramT, i3, m))
                                                                                      {
                                                                                        i = i1 + k.kh(i3);
                                                                                        continue;
                                                                                        i = i1;
                                                                                        if (b(paramT, i3, m))
                                                                                        {
                                                                                          i = i1 + k.kn(i3);
                                                                                          continue;
                                                                                          i = i1;
                                                                                          if (b(paramT, i3, m))
                                                                                          {
                                                                                            localObject = localUnsafe.getObject(paramT, l);
                                                                                            if ((localObject instanceof h))
                                                                                            {
                                                                                              i = i1 + k.c(i3, (h)localObject);
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                              i = i1 + k.h(i3, (String)localObject);
                                                                                              continue;
                                                                                              i = i1;
                                                                                              if (b(paramT, i3, m))
                                                                                              {
                                                                                                i = i1 + de.c(i3, localUnsafe.getObject(paramT, l), lm(m));
                                                                                                continue;
                                                                                                i = i1;
                                                                                                if (b(paramT, i3, m))
                                                                                                {
                                                                                                  i = i1 + k.c(i3, (h)localUnsafe.getObject(paramT, l));
                                                                                                  continue;
                                                                                                  i = i1;
                                                                                                  if (b(paramT, i3, m))
                                                                                                  {
                                                                                                    i = i1 + k.cK(i3, g(paramT, l));
                                                                                                    continue;
                                                                                                    i = i1;
                                                                                                    if (b(paramT, i3, m))
                                                                                                    {
                                                                                                      i = i1 + k.cM(i3, g(paramT, l));
                                                                                                      continue;
                                                                                                      i = i1;
                                                                                                      if (b(paramT, i3, m))
                                                                                                      {
                                                                                                        i = i1 + k.ki(i3);
                                                                                                        continue;
                                                                                                        i = i1;
                                                                                                        if (b(paramT, i3, m))
                                                                                                        {
                                                                                                          i = i1 + k.kk(i3);
                                                                                                          continue;
                                                                                                          i = i1;
                                                                                                          if (b(paramT, i3, m))
                                                                                                          {
                                                                                                            i = i1 + k.cL(i3, g(paramT, l));
                                                                                                            continue;
                                                                                                            i = i1;
                                                                                                            if (b(paramT, i3, m))
                                                                                                            {
                                                                                                              i = i1 + k.s(i3, h(paramT, l));
                                                                                                              continue;
                                                                                                              i = i1;
                                                                                                              if (b(paramT, i3, m)) {
                                                                                                                i = i1 + k.c(i3, (ce)localUnsafe.getObject(paramT, l), lm(m));
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
      j = a(this.dUo, paramT) + i1;
      i = j;
      if (!this.dUf) {
        break;
      }
      return j + this.dUp.bs(paramT).getSerializedSize();
      label5804:
      i = 0;
      n = j;
      j = i;
    }
  }
  
  public final boolean bI(T paramT)
  {
    int j = 0;
    int m = 0;
    int k = -1;
    int i1;
    int i2;
    int i3;
    int i;
    int n;
    if (j < this.dUk)
    {
      i1 = this.dUj[j];
      i2 = this.dUa[i1];
      i3 = lp(i1);
      if (this.dUh) {
        break label535;
      }
      i = this.dUa[(i1 + 2)];
      n = i & 0xFFFFF;
      i = 1 << (i >>> 20);
      if (n == k) {
        break label532;
      }
      m = UNSAFE.getInt(paramT, n);
      k = n;
    }
    for (;;)
    {
      if ((0x10000000 & i3) != 0)
      {
        n = 1;
        label106:
        if ((n == 0) || (a(paramT, i1, m, i))) {
          break label132;
        }
      }
      label132:
      label281:
      do
      {
        return false;
        n = 0;
        break label106;
        switch ((0xFF00000 & i3) >>> 20)
        {
        }
        for (;;)
        {
          j += 1;
          break;
          if ((a(paramT, i1, m, i)) && (!a(paramT, i3, lm(i1))))
          {
            return false;
            Object localObject1 = (List)ds.o(paramT, i3 & 0xFFFFF);
            Object localObject2;
            if (!((List)localObject1).isEmpty())
            {
              localObject2 = lm(i1);
              i = 0;
              if (i < ((List)localObject1).size()) {
                if (((dc)localObject2).bI(((List)localObject1).get(i))) {}
              }
            }
            for (i = 0; i == 0; i = 1)
            {
              return false;
              i += 1;
              break label281;
            }
            if ((b(paramT, i2, i1)) && (!a(paramT, i3, lm(i1))))
            {
              return false;
              localObject2 = this.dUq.bC(ds.o(paramT, i3 & 0xFFFFF));
              if (!((Map)localObject2).isEmpty())
              {
                localObject1 = ln(i1);
                if (this.dUq.bG(localObject1).dTD.dWY == du.b.dXj)
                {
                  localObject1 = null;
                  Iterator localIterator = ((Map)localObject2).values().iterator();
                  Object localObject3;
                  do
                  {
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localObject3 = localIterator.next();
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = cv.aja().O(localObject3.getClass());
                    }
                    localObject1 = localObject2;
                  } while (((dc)localObject2).bI(localObject3));
                }
              }
              for (i = 0; i == 0; i = 1) {
                return false;
              }
            }
          }
        }
      } while ((this.dUf) && (!this.dUp.bs(paramT).isInitialized()));
      return true;
      label532:
      continue;
      label535:
      i = 0;
    }
  }
  
  public final void bu(T paramT)
  {
    int i = this.dUk;
    while (i < this.dUl)
    {
      long l = lp(this.dUj[i]) & 0xFFFFF;
      Object localObject = ds.o(paramT, l);
      if (localObject != null) {
        ds.a(paramT, l, this.dUq.bE(localObject));
      }
      i += 1;
    }
    int j = this.dUj.length;
    i = this.dUl;
    while (i < j)
    {
      this.dUn.b(paramT, this.dUj[i]);
      i += 1;
    }
    this.dUo.bu(paramT);
    if (this.dUf) {
      this.dUp.bu(paramT);
    }
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    int k = this.dUa.length;
    int i = 0;
    if (i < k)
    {
      j = lp(i);
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
    while (!this.dUo.bL(paramT1).equals(this.dUo.bL(paramT2)))
    {
      for (;;)
      {
        int j;
        long l;
        boolean bool;
        return false;
        if ((!a(paramT1, paramT2, i)) || (Double.doubleToLongBits(ds.n(paramT1, l)) != Double.doubleToLongBits(ds.n(paramT2, l))))
        {
          bool = false;
          continue;
          if ((!a(paramT1, paramT2, i)) || (Float.floatToIntBits(ds.m(paramT1, l)) != Float.floatToIntBits(ds.m(paramT2, l))))
          {
            bool = false;
            continue;
            if ((!a(paramT1, paramT2, i)) || (ds.k(paramT1, l) != ds.k(paramT2, l)))
            {
              bool = false;
              continue;
              if ((!a(paramT1, paramT2, i)) || (ds.k(paramT1, l) != ds.k(paramT2, l)))
              {
                bool = false;
                continue;
                if ((!a(paramT1, paramT2, i)) || (ds.j(paramT1, l) != ds.j(paramT2, l)))
                {
                  bool = false;
                  continue;
                  if ((!a(paramT1, paramT2, i)) || (ds.k(paramT1, l) != ds.k(paramT2, l)))
                  {
                    bool = false;
                    continue;
                    if ((!a(paramT1, paramT2, i)) || (ds.j(paramT1, l) != ds.j(paramT2, l)))
                    {
                      bool = false;
                      continue;
                      if ((!a(paramT1, paramT2, i)) || (ds.l(paramT1, l) != ds.l(paramT2, l)))
                      {
                        bool = false;
                        continue;
                        if ((!a(paramT1, paramT2, i)) || (!de.t(ds.o(paramT1, l), ds.o(paramT2, l))))
                        {
                          bool = false;
                          continue;
                          if ((!a(paramT1, paramT2, i)) || (!de.t(ds.o(paramT1, l), ds.o(paramT2, l))))
                          {
                            bool = false;
                            continue;
                            if ((!a(paramT1, paramT2, i)) || (!de.t(ds.o(paramT1, l), ds.o(paramT2, l))))
                            {
                              bool = false;
                              continue;
                              if ((!a(paramT1, paramT2, i)) || (ds.j(paramT1, l) != ds.j(paramT2, l)))
                              {
                                bool = false;
                                continue;
                                if ((!a(paramT1, paramT2, i)) || (ds.j(paramT1, l) != ds.j(paramT2, l)))
                                {
                                  bool = false;
                                  continue;
                                  if ((!a(paramT1, paramT2, i)) || (ds.j(paramT1, l) != ds.j(paramT2, l)))
                                  {
                                    bool = false;
                                    continue;
                                    if ((!a(paramT1, paramT2, i)) || (ds.k(paramT1, l) != ds.k(paramT2, l)))
                                    {
                                      bool = false;
                                      continue;
                                      if ((!a(paramT1, paramT2, i)) || (ds.j(paramT1, l) != ds.j(paramT2, l)))
                                      {
                                        bool = false;
                                        continue;
                                        if ((!a(paramT1, paramT2, i)) || (ds.k(paramT1, l) != ds.k(paramT2, l)))
                                        {
                                          bool = false;
                                          continue;
                                          if ((!a(paramT1, paramT2, i)) || (!de.t(ds.o(paramT1, l), ds.o(paramT2, l))))
                                          {
                                            bool = false;
                                            continue;
                                            bool = de.t(ds.o(paramT1, l), ds.o(paramT2, l));
                                            continue;
                                            bool = de.t(ds.o(paramT1, l), ds.o(paramT2, l));
                                            continue;
                                            j = lq(i);
                                            if (ds.j(paramT1, j & 0xFFFFF) == ds.j(paramT2, j & 0xFFFFF)) {}
                                            for (j = 1;; j = 0)
                                            {
                                              if ((j != 0) && (de.t(ds.o(paramT1, l), ds.o(paramT2, l)))) {
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
    if (this.dUf) {
      return this.dUp.bs(paramT1).equals(this.dUp.bs(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int m = this.dUa.length;
    int j = 0;
    int i = 0;
    int n;
    long l;
    Object localObject;
    if (j < m)
    {
      k = lp(j);
      n = this.dUa[j];
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
          i = i * 53 + bj.hashLong(Double.doubleToLongBits(ds.n(paramT, l)));
          continue;
          i = i * 53 + Float.floatToIntBits(ds.m(paramT, l));
          continue;
          i = i * 53 + bj.hashLong(ds.k(paramT, l));
          continue;
          i = i * 53 + bj.hashLong(ds.k(paramT, l));
          continue;
          i = i * 53 + ds.j(paramT, l);
          continue;
          i = i * 53 + bj.hashLong(ds.k(paramT, l));
          continue;
          i = i * 53 + ds.j(paramT, l);
          continue;
          i = i * 53 + bj.hashBoolean(ds.l(paramT, l));
          continue;
          i = ((String)ds.o(paramT, l)).hashCode() + i * 53;
        }
      case 9: 
        localObject = ds.o(paramT, l);
        if (localObject == null) {
          break;
        }
      }
    }
    for (int k = localObject.hashCode();; k = 37)
    {
      i = k + i * 53;
      break;
      i = i * 53 + ds.o(paramT, l).hashCode();
      break;
      i = i * 53 + ds.j(paramT, l);
      break;
      i = i * 53 + ds.j(paramT, l);
      break;
      i = i * 53 + ds.j(paramT, l);
      break;
      i = i * 53 + bj.hashLong(ds.k(paramT, l));
      break;
      i = i * 53 + ds.j(paramT, l);
      break;
      i = i * 53 + bj.hashLong(ds.k(paramT, l));
      break;
      localObject = ds.o(paramT, l);
      if (localObject != null) {}
      for (k = localObject.hashCode();; k = 37)
      {
        i = k + i * 53;
        break;
        i = i * 53 + ds.o(paramT, l).hashCode();
        break;
        i = i * 53 + ds.o(paramT, l).hashCode();
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + bj.hashLong(Double.doubleToLongBits(e(paramT, l)));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + Float.floatToIntBits(f(paramT, l));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + bj.hashLong(h(paramT, l));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + bj.hashLong(h(paramT, l));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + g(paramT, l);
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + bj.hashLong(h(paramT, l));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + g(paramT, l);
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + bj.hashBoolean(i(paramT, l));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = ((String)ds.o(paramT, l)).hashCode() + i * 53;
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = ds.o(paramT, l).hashCode() + i * 53;
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + ds.o(paramT, l).hashCode();
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + g(paramT, l);
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + g(paramT, l);
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + g(paramT, l);
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + bj.hashLong(h(paramT, l));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + g(paramT, l);
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = i * 53 + bj.hashLong(h(paramT, l));
        break;
        if (!b(paramT, n, j)) {
          break;
        }
        i = ds.o(paramT, l).hashCode() + i * 53;
        break;
        j = i * 53 + this.dUo.bL(paramT).hashCode();
        i = j;
        if (this.dUf) {
          i = j * 53 + this.dUp.bs(paramT).hashCode();
        }
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.cj
 * JD-Core Version:    0.7.0.1
 */