package com.google.d;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class de
{
  private static final Class<?> dUZ = ;
  private static final dm<?, ?> dVa = cz(false);
  private static final dm<?, ?> dVb = cz(true);
  private static final dm<?, ?> dVc = new dp();
  
  public static void P(Class<?> paramClass)
  {
    if ((!be.class.isAssignableFrom(paramClass)) && (dUZ != null) && (!dUZ.isAssignableFrom(paramClass))) {
      throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }
  }
  
  static <UT, UB> UB a(int paramInt1, int paramInt2, UB paramUB, dm<UT, UB> paramdm)
  {
    Object localObject = paramUB;
    if (paramUB == null) {
      localObject = paramdm.ajD();
    }
    paramdm.a(localObject, paramInt1, paramInt2);
    return localObject;
  }
  
  static <UT, UB> UB a(int paramInt, List<Integer> paramList, bj.e parame, UB paramUB, dm<UT, UB> paramdm)
  {
    if (parame == null) {
      return paramUB;
    }
    int i;
    if ((paramList instanceof RandomAccess))
    {
      int k = paramList.size();
      int j = 0;
      i = 0;
      if (j < k)
      {
        int m = ((Integer)paramList.get(j)).intValue();
        if (parame.kB(m))
        {
          if (j != i) {
            paramList.set(i, Integer.valueOf(m));
          }
          i += 1;
        }
        for (;;)
        {
          j += 1;
          break;
          paramUB = a(paramInt, m, paramUB, paramdm);
        }
      }
      parame = paramUB;
      if (i != k) {
        paramList.subList(i, k).clear();
      }
    }
    for (parame = paramUB;; parame = paramUB)
    {
      return parame;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        if (!parame.kB(i))
        {
          paramUB = a(paramInt, i, paramUB, paramdm);
          paramList.remove();
        }
      }
    }
  }
  
  public static void a(int paramInt, List<String> paramList, dv paramdv)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.a(paramInt, paramList);
    }
  }
  
  public static void a(int paramInt, List<?> paramList, dv paramdv, dc paramdc)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.a(paramInt, paramList, paramdc);
    }
  }
  
  public static void a(int paramInt, List<Double> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.g(paramInt, paramList, paramBoolean);
    }
  }
  
  static int aK(List<Long> paramList)
  {
    int m = paramList.size();
    int k;
    if (m == 0)
    {
      k = 0;
      return k;
    }
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += k.cS(paramList.getLong(j));
        j += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += k.cS(((Long)paramList.get(i)).longValue());
      i += 1;
    }
    return j;
  }
  
  static int aL(List<Long> paramList)
  {
    int m = paramList.size();
    int k;
    if (m == 0)
    {
      k = 0;
      return k;
    }
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += k.cT(paramList.getLong(j));
        j += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += k.cT(((Long)paramList.get(i)).longValue());
      i += 1;
    }
    return j;
  }
  
  static int aM(List<Long> paramList)
  {
    int m = paramList.size();
    int k;
    if (m == 0)
    {
      k = 0;
      return k;
    }
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += k.cU(paramList.getLong(j));
        j += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += k.cU(((Long)paramList.get(i)).longValue());
      i += 1;
    }
    return j;
  }
  
  static int aN(List<Integer> paramList)
  {
    int m = paramList.size();
    int k;
    if (m == 0)
    {
      k = 0;
      return k;
    }
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += k.ks(paramList.getInt(j));
        j += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += k.ks(((Integer)paramList.get(i)).intValue());
      i += 1;
    }
    return j;
  }
  
  static int aO(List<Integer> paramList)
  {
    int m = paramList.size();
    int k;
    if (m == 0)
    {
      k = 0;
      return k;
    }
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += k.kp(paramList.getInt(j));
        j += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += k.kp(((Integer)paramList.get(i)).intValue());
      i += 1;
    }
    return j;
  }
  
  static int aP(List<Integer> paramList)
  {
    int m = paramList.size();
    int k;
    if (m == 0)
    {
      k = 0;
      return k;
    }
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += k.kq(paramList.getInt(j));
        j += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += k.kq(((Integer)paramList.get(i)).intValue());
      i += 1;
    }
    return j;
  }
  
  static int aQ(List<Integer> paramList)
  {
    int m = paramList.size();
    int k;
    if (m == 0)
    {
      k = 0;
      return k;
    }
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i += k.kr(paramList.getInt(j));
        j += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += k.kr(((Integer)paramList.get(i)).intValue());
      i += 1;
    }
    return j;
  }
  
  static int aR(List<?> paramList)
  {
    return paramList.size() * 4;
  }
  
  static int aS(List<?> paramList)
  {
    return paramList.size() * 8;
  }
  
  static int aT(List<?> paramList)
  {
    return paramList.size();
  }
  
  public static dm<?, ?> ajh()
  {
    return dVa;
  }
  
  public static dm<?, ?> aji()
  {
    return dVb;
  }
  
  public static dm<?, ?> ajj()
  {
    return dVc;
  }
  
  private static Class<?> ajk()
  {
    try
    {
      Class localClass = Class.forName("com.google.d.bg");
      return localClass;
    }
    finally {}
    return null;
  }
  
  private static Class<?> ajl()
  {
    try
    {
      Class localClass = Class.forName("com.google.d.dq");
      return localClass;
    }
    finally {}
    return null;
  }
  
  public static void b(int paramInt, List<h> paramList, dv paramdv)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.b(paramInt, paramList);
    }
  }
  
  public static void b(int paramInt, List<?> paramList, dv paramdv, dc paramdc)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.b(paramInt, paramList, paramdc);
    }
  }
  
  public static void b(int paramInt, List<Float> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.f(paramInt, paramList, paramBoolean);
    }
  }
  
  static int c(int paramInt, Object paramObject, dc paramdc)
  {
    if ((paramObject instanceof bn)) {
      return k.a(paramInt, (bn)paramObject);
    }
    return k.b(paramInt, (ce)paramObject, paramdc);
  }
  
  static int c(int paramInt, List<?> paramList, dc paramdc)
  {
    int j = paramList.size();
    if (j == 0) {
      return 0;
    }
    paramInt = k.ko(paramInt) * j;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramList.get(i);
      if ((localObject instanceof bn)) {}
      for (paramInt = k.a((bn)localObject) + paramInt;; paramInt = k.a((ce)localObject, paramdc) + paramInt)
      {
        i += 1;
        break;
      }
    }
    return paramInt;
  }
  
  static Object c(Class<?> paramClass, String paramString)
  {
    Field[] arrayOfField;
    try
    {
      arrayOfField = Class.forName(paramClass.getName() + "$" + h(paramString, true) + "DefaultEntryHolder").getDeclaredFields();
      if (arrayOfField.length != 1) {
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + paramString + " in " + paramClass.getName());
      }
    }
    finally {}
    paramClass = ds.e(arrayOfField[0]);
    return paramClass;
  }
  
  public static void c(int paramInt, List<?> paramList, dv paramdv)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.c(paramInt, paramList);
    }
  }
  
  public static void c(int paramInt, List<Long> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.c(paramInt, paramList, paramBoolean);
    }
  }
  
  private static dm<?, ?> cz(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = ajl();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (dm)((Class)localObject1).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return localObject1;
    }
    finally {}
    return null;
  }
  
  static int d(int paramInt, List<ce> paramList, dc paramdc)
  {
    int k = paramList.size();
    if (k == 0) {
      return 0;
    }
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += k.c(paramInt, (ce)paramList.get(i), paramdc);
      i += 1;
    }
    return j;
  }
  
  public static void d(int paramInt, List<?> paramList, dv paramdv)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.d(paramInt, paramList);
    }
  }
  
  public static void d(int paramInt, List<Long> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.d(paramInt, paramList, paramBoolean);
    }
  }
  
  static int e(int paramInt, List<Long> paramList)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    return aK(paramList) + paramList.size() * k.ko(paramInt);
  }
  
  public static void e(int paramInt, List<Long> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.n(paramInt, paramList, paramBoolean);
    }
  }
  
  static int f(int paramInt, List<Long> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = aL(paramList);
    return i * k.ko(paramInt) + j;
  }
  
  public static void f(int paramInt, List<Long> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.e(paramInt, paramList, paramBoolean);
    }
  }
  
  static int g(int paramInt, List<Long> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = aM(paramList);
    return i * k.ko(paramInt) + j;
  }
  
  public static void g(int paramInt, List<Long> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.l(paramInt, paramList, paramBoolean);
    }
  }
  
  static int h(int paramInt, List<Integer> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = aN(paramList);
    return i * k.ko(paramInt) + j;
  }
  
  private static String h(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (('a' <= c) && (c <= 'z')) {
        if (paramBoolean)
        {
          localStringBuilder.append((char)(c - ' '));
          label52:
          paramBoolean = false;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(c);
        break label52;
        if (('A' <= c) && (c <= 'Z'))
        {
          if ((i == 0) && (!paramBoolean)) {
            localStringBuilder.append((char)(c + ' '));
          }
          for (;;)
          {
            paramBoolean = false;
            break;
            localStringBuilder.append(c);
          }
        }
        if (('0' <= c) && (c <= '9')) {
          localStringBuilder.append(c);
        }
        paramBoolean = true;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void h(int paramInt, List<Integer> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.a(paramInt, paramList, paramBoolean);
    }
  }
  
  static int i(int paramInt, List<Integer> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = aO(paramList);
    return i * k.ko(paramInt) + j;
  }
  
  public static void i(int paramInt, List<Integer> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.j(paramInt, paramList, paramBoolean);
    }
  }
  
  static int j(int paramInt, List<Integer> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = aP(paramList);
    return i * k.ko(paramInt) + j;
  }
  
  public static void j(int paramInt, List<Integer> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.m(paramInt, paramList, paramBoolean);
    }
  }
  
  static int k(int paramInt, List<Integer> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    int j = aQ(paramList);
    return i * k.ko(paramInt) + j;
  }
  
  public static void k(int paramInt, List<Integer> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.b(paramInt, paramList, paramBoolean);
    }
  }
  
  static int l(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * k.kh(paramInt);
  }
  
  public static void l(int paramInt, List<Integer> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.k(paramInt, paramList, paramBoolean);
    }
  }
  
  static int m(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * k.kj(paramInt);
  }
  
  public static void m(int paramInt, List<Integer> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.h(paramInt, paramList, paramBoolean);
    }
  }
  
  static int n(int paramInt, List<?> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * k.kn(paramInt);
  }
  
  public static void n(int paramInt, List<Boolean> paramList, dv paramdv, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramdv.i(paramInt, paramList, paramBoolean);
    }
  }
  
  static int o(int paramInt, List<?> paramList)
  {
    int j = paramList.size();
    if (j == 0) {
      return 0;
    }
    paramInt = k.ko(paramInt) * j;
    Object localObject;
    if ((paramList instanceof bp))
    {
      paramList = (bp)paramList;
      i = 0;
      if (i < j)
      {
        localObject = paramList.getRaw(i);
        if ((localObject instanceof h)) {}
        for (paramInt = k.b((h)localObject) + paramInt;; paramInt = k.dU((String)localObject) + paramInt)
        {
          i += 1;
          break;
        }
      }
      return paramInt;
    }
    int i = 0;
    if (i < j)
    {
      localObject = paramList.get(i);
      if ((localObject instanceof h)) {}
      for (paramInt = k.b((h)localObject) + paramInt;; paramInt = k.dU((String)localObject) + paramInt)
      {
        i += 1;
        break;
      }
    }
    return paramInt;
  }
  
  static int p(int paramInt, List<h> paramList)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    i = k.ko(paramInt) * i;
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      i += k.b((h)paramList.get(paramInt));
      paramInt += 1;
    }
    return i;
  }
  
  static boolean t(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.de
 * JD-Core Version:    0.7.0.1
 */