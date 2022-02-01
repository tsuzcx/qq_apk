package com.google.a;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public final class j
  implements av
{
  private static final Set<String> bNA = new HashSet(Arrays.asList(new String[] { "cached_size", "serialized_size", "class" }));
  private static a bNB = new a();
  private static final j bNz = new j();
  
  private static at E(Class<?> paramClass)
  {
    try
    {
      at localat = (at)paramClass.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
      return localat;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Unable to get default instance for message class " + paramClass.getName(), localException);
    }
  }
  
  private static bw a(Class<?> paramClass, l.a parama)
  {
    List localList = parama.getFields();
    bw.a locala = bw.gO(localList.size());
    locala.bZs = E(paramClass);
    locala.a(bl.bYJ);
    locala.bWz = parama.bSq.AG().bRt;
    b localb = new b((byte)0);
    int i = 0;
    int j = 1;
    parama = null;
    int k = 0;
    l.f localf;
    boolean bool;
    Object localObject1;
    if (k < localList.size())
    {
      localf = (l.f)localList.get(k);
      bool = localf.bSr.bTB.CQ().bQY;
      localObject1 = null;
      if (localf.bSS.bTz == l.f.a.bTd) {
        localObject1 = new ae.c() {};
      }
      if (localf.bSU != null)
      {
        locala.a(a(paramClass, localf, localb, bool, (ae.c)localObject1));
        label164:
        j <<= 1;
        if (j != 0) {
          break label687;
        }
        parama = null;
        j = 1;
        i += 1;
      }
    }
    label687:
    for (;;)
    {
      k += 1;
      break;
      Field localField = a(paramClass, localf);
      int m = localf.bSP.bPE;
      y localy = a(localf);
      Object localObject2;
      if (localf.FG())
      {
        localObject2 = localf.FN().gz(2);
        if (((l.f)localObject2).bSS.bTz == l.f.a.bTd) {
          localObject1 = new ae.c() {};
        }
        locala.a(w.a(localField, m, bt.d(paramClass, localf.bSP.getName()), (ae.c)localObject1));
      }
      else if (localf.FJ())
      {
        if (localObject1 != null)
        {
          if (localf.FK()) {
            locala.a(w.a(localField, m, localy, (ae.c)localObject1, b(paramClass, localf)));
          } else {
            locala.a(w.a(localField, m, localy, (ae.c)localObject1));
          }
        }
        else if (localf.bSS.bTz == l.f.a.bTe) {
          locala.a(w.a(localField, m, localy, d(paramClass, localf)));
        } else if (localf.FK()) {
          locala.a(w.a(localField, m, localy, b(paramClass, localf)));
        } else {
          locala.a(w.a(localField, m, localy, bool));
        }
      }
      else
      {
        localObject2 = parama;
        if (parama == null) {
          localObject2 = a(paramClass, "bitField" + i + "_");
        }
        if (localf.FH())
        {
          locala.a(w.b(localField, m, localy, (Field)localObject2, j, bool, (ae.c)localObject1));
          parama = (l.a)localObject2;
          break label164;
        }
        locala.a(w.a(localField, m, localy, (Field)localObject2, j, bool, (ae.c)localObject1));
        parama = (l.a)localObject2;
        break label164;
        paramClass = new ArrayList();
        i = 0;
        while (i < localList.size())
        {
          parama = (l.f)localList.get(i);
          if (!parama.FH())
          {
            if (parama.bSS.bTz == l.f.a.bTe)
            {
              localObject1 = parama.FN();
              if (!bNB.a((l.a)localObject1)) {}
            }
          }
          else {
            paramClass.add(Integer.valueOf(parama.bSP.bPE));
          }
          i += 1;
        }
        parama = new int[paramClass.size()];
        i = 0;
        while (i < paramClass.size())
        {
          parama[i] = ((Integer)paramClass.get(i)).intValue();
          i += 1;
        }
        locala.bZo = parama;
        return locala.HF();
      }
    }
  }
  
  private static w a(Class<?> paramClass, l.f paramf, b paramb, boolean paramBoolean, ae.c paramc)
  {
    paramb = paramb.a(paramClass, paramf.bSU);
    y localy = a(paramf);
    paramClass = a(paramClass, paramf, localy);
    return w.a(paramf.bSP.bPE, localy, paramb, paramClass, paramBoolean, paramc);
  }
  
  private static y a(l.f paramf)
  {
    switch (3.bNG[paramf.bSS.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unsupported field type: " + paramf.bSS);
    case 1: 
      if (!paramf.FJ()) {
        return y.bUO;
      }
      if (paramf.FK()) {
        return y.bVx;
      }
      return y.bVg;
    case 2: 
      if (paramf.FJ()) {
        return y.bVj;
      }
      return y.bUR;
    case 3: 
      if (!paramf.FJ()) {
        return y.bUH;
      }
      if (paramf.FK()) {
        return y.bVq;
      }
      return y.bUZ;
    case 4: 
      if (!paramf.FJ()) {
        return y.bUT;
      }
      if (paramf.FK()) {
        return y.bVz;
      }
      return y.bVl;
    case 5: 
      if (!paramf.FJ()) {
        return y.bUN;
      }
      if (paramf.FK()) {
        return y.bVw;
      }
      return y.bVf;
    case 6: 
      if (!paramf.FJ()) {
        return y.bUM;
      }
      if (paramf.FK()) {
        return y.bVv;
      }
      return y.bVe;
    case 7: 
      if (!paramf.FJ()) {
        return y.bUI;
      }
      if (paramf.FK()) {
        return y.bVr;
      }
      return y.bVa;
    case 8: 
      if (paramf.FJ()) {
        return y.bVE;
      }
      return y.bUY;
    case 9: 
      if (!paramf.FJ()) {
        return y.bUL;
      }
      if (paramf.FK()) {
        return y.bVu;
      }
      return y.bVd;
    case 10: 
      if (!paramf.FJ()) {
        return y.bUJ;
      }
      if (paramf.FK()) {
        return y.bVs;
      }
      return y.bVb;
    case 11: 
      if (paramf.FG()) {
        return y.bVF;
      }
      if (paramf.FJ()) {
        return y.bVi;
      }
      return y.bUQ;
    case 12: 
      if (!paramf.FJ()) {
        return y.bUU;
      }
      if (paramf.FK()) {
        return y.bVA;
      }
      return y.bVm;
    case 13: 
      if (!paramf.FJ()) {
        return y.bUV;
      }
      if (paramf.FK()) {
        return y.bVB;
      }
      return y.bVn;
    case 14: 
      if (!paramf.FJ()) {
        return y.bUW;
      }
      if (paramf.FK()) {
        return y.bVC;
      }
      return y.bVo;
    case 15: 
      if (!paramf.FJ()) {
        return y.bUX;
      }
      if (paramf.FK()) {
        return y.bVD;
      }
      return y.bVp;
    case 16: 
      if (paramf.FJ()) {
        return y.bVh;
      }
      return y.bUP;
    case 17: 
      if (!paramf.FJ()) {
        return y.bUS;
      }
      if (paramf.FK()) {
        return y.bVy;
      }
      return y.bVk;
    }
    if (!paramf.FJ()) {
      return y.bUK;
    }
    if (paramf.FK()) {
      return y.bVt;
    }
    return y.bVc;
  }
  
  private static Class<?> a(Class<?> paramClass, l.f paramf, y paramy)
  {
    switch (3.bNF[paramy.bVG.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Invalid type for oneof: ".concat(String.valueOf(paramy)));
    case 1: 
      return Boolean.class;
    case 2: 
      return g.class;
    case 3: 
      return Double.class;
    case 4: 
      return Float.class;
    case 5: 
    case 6: 
      return Integer.class;
    case 7: 
      return Long.class;
    case 8: 
      return String.class;
    }
    return c(paramClass, paramf);
  }
  
  private static Field a(Class<?> paramClass, l.f paramf)
  {
    return a(paramClass, b(paramf));
  }
  
  private static Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      return localField;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Unable to find field " + paramString + " in message class " + paramClass.getName());
    }
  }
  
  private static bw b(Class<?> paramClass, l.a parama)
  {
    parama = parama.getFields();
    bw.a locala = bw.gO(parama.size());
    locala.bZs = E(paramClass);
    locala.a(bl.bYK);
    b localb = new b((byte)0);
    int i = 0;
    if (i < parama.size())
    {
      l.f localf = (l.f)parama.get(i);
      if (localf.bSU != null) {
        locala.a(a(paramClass, localf, localb, true, null));
      }
      for (;;)
      {
        i += 1;
        break;
        if (localf.FG()) {
          locala.a(w.a(a(paramClass, localf), localf.bSP.bPE, bt.d(paramClass, localf.bSP.getName()), null));
        } else if ((localf.FJ()) && (localf.bSS.bTz == l.f.a.bTe)) {
          locala.a(w.a(a(paramClass, localf), localf.bSP.bPE, a(localf), d(paramClass, localf)));
        } else if (localf.FK()) {
          locala.a(w.a(a(paramClass, localf), localf.bSP.bPE, a(localf), b(paramClass, localf)));
        } else {
          locala.a(w.a(a(paramClass, localf), localf.bSP.bPE, a(localf), true));
        }
      }
    }
    return locala.HF();
  }
  
  private static String b(l.f paramf)
  {
    if (paramf.bSS == l.f.b.bTq)
    {
      paramf = paramf.FN().bSq.getName();
      if (!bNA.contains(paramf)) {
        break label70;
      }
    }
    label70:
    for (String str = "__";; str = "_")
    {
      return cc(paramf) + str;
      paramf = paramf.bSP.getName();
      break;
    }
  }
  
  private static Field b(Class<?> paramClass, l.f paramf)
  {
    return a(paramClass, c(paramf));
  }
  
  /* Error */
  private static Class<?> c(Class<?> paramClass, l.f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 196	com/google/a/l$f:bSS	Lcom/google/a/l$f$b;
    //   4: getstatic 570	com/google/a/l$f$b:bTq	Lcom/google/a/l$f$b;
    //   7: if_acmpne +30 -> 37
    //   10: aload_1
    //   11: invokevirtual 244	com/google/a/l$f:FN	()Lcom/google/a/l$a;
    //   14: getfield 147	com/google/a/l$a:bSq	Lcom/google/a/k$a;
    //   17: invokevirtual 571	com/google/a/k$a:getName	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 584	com/google/a/j:cd	(Ljava/lang/String;)Ljava/lang/String;
    //   26: iconst_0
    //   27: anewarray 70	java/lang/Class
    //   30: invokevirtual 74	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: invokevirtual 588	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   36: areturn
    //   37: aload_1
    //   38: getfield 227	com/google/a/l$f:bSP	Lcom/google/a/k$m;
    //   41: invokevirtual 250	com/google/a/k$m:getName	()Ljava/lang/String;
    //   44: astore_1
    //   45: goto -24 -> 21
    //   48: astore_0
    //   49: new 590	java/lang/RuntimeException
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 593	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramClass	Class<?>
    //   0	58	1	paramf	l.f
    // Exception table:
    //   from	to	target	type
    //   0	21	48	java/lang/Exception
    //   21	37	48	java/lang/Exception
    //   37	45	48	java/lang/Exception
  }
  
  private static String c(l.f paramf)
  {
    return cc(paramf.bSP.getName()) + "MemoizedSerializedSize";
  }
  
  private static String cc(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 1);
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      char c = paramString.charAt(j);
      if (c == '_') {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (Character.isDigit(c))
        {
          localStringBuilder.append(c);
          i = 1;
        }
        else if (i != 0)
        {
          localStringBuilder.append(Character.toUpperCase(c));
          i = 0;
        }
        else if (j == 0)
        {
          localStringBuilder.append(Character.toLowerCase(c));
        }
        else
        {
          localStringBuilder.append(c);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String cd(String paramString)
  {
    paramString = cc(paramString);
    StringBuilder localStringBuilder = new StringBuilder("get");
    localStringBuilder.append(Character.toUpperCase(paramString.charAt(0)));
    localStringBuilder.append(paramString.substring(1, paramString.length()));
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static Class<?> d(Class<?> paramClass, l.f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 196	com/google/a/l$f:bSS	Lcom/google/a/l$f$b;
    //   4: getstatic 570	com/google/a/l$f$b:bTq	Lcom/google/a/l$f$b;
    //   7: if_acmpne +36 -> 43
    //   10: aload_1
    //   11: invokevirtual 244	com/google/a/l$f:FN	()Lcom/google/a/l$a;
    //   14: getfield 147	com/google/a/l$a:bSq	Lcom/google/a/k$a;
    //   17: invokevirtual 571	com/google/a/k$a:getName	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 584	com/google/a/j:cd	(Ljava/lang/String;)Ljava/lang/String;
    //   26: iconst_1
    //   27: anewarray 70	java/lang/Class
    //   30: dup
    //   31: iconst_0
    //   32: getstatic 631	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   35: aastore
    //   36: invokevirtual 74	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: invokevirtual 588	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   42: areturn
    //   43: aload_1
    //   44: getfield 227	com/google/a/l$f:bSP	Lcom/google/a/k$m;
    //   47: invokevirtual 250	com/google/a/k$m:getName	()Ljava/lang/String;
    //   50: astore_1
    //   51: goto -30 -> 21
    //   54: astore_0
    //   55: new 590	java/lang/RuntimeException
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 593	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramClass	Class<?>
    //   0	64	1	paramf	l.f
    // Exception table:
    //   from	to	target	type
    //   0	21	54	java/lang/Exception
    //   21	43	54	java/lang/Exception
    //   43	51	54	java/lang/Exception
  }
  
  public final boolean C(Class<?> paramClass)
  {
    return ac.class.isAssignableFrom(paramClass);
  }
  
  public final au D(Class<?> paramClass)
  {
    if (!ac.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Unsupported message type: " + paramClass.getName());
    }
    l.a locala = E(paramClass).AS();
    switch (3.bNE[locala.bSr.FQ().ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unsupported syntax: " + locala.bSr.FQ());
    case 1: 
      return a(paramClass, locala);
    }
    return b(paramClass, locala);
  }
  
  static final class a
  {
    private final Map<l.a, Boolean> bNH = new ConcurrentHashMap();
    private final Stack<a> bNI = new Stack();
    private final Map<l.a, a> bNJ = new HashMap();
    private int index = 0;
    
    private void a(b paramb)
    {
      Iterator localIterator = paramb.bNN.iterator();
      break label109;
      break label109;
      label10:
      Object localObject1;
      boolean bool;
      if (localIterator.hasNext())
      {
        localObject1 = (l.a)localIterator.next();
        if (((l.a)localObject1).FA()) {
          bool = true;
        }
      }
      for (;;)
      {
        label40:
        paramb.bNO = bool;
        localIterator = paramb.bNN.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (l.a)localIterator.next();
            this.bNH.put(localObject1, Boolean.valueOf(paramb.bNO));
            continue;
            localObject1 = ((l.a)localObject1).getFields().iterator();
            label109:
            if (!((Iterator)localObject1).hasNext()) {
              break label10;
            }
            Object localObject2 = (l.f)((Iterator)localObject1).next();
            if (((l.f)localObject2).FH())
            {
              bool = true;
              break label40;
            }
            if (((l.f)localObject2).bSS.bTz != l.f.a.bTe) {
              break;
            }
            localObject2 = (a)this.bNJ.get(((l.f)localObject2).FN());
            if ((((a)localObject2).bNM == paramb) || (!((a)localObject2).bNM.bNO)) {
              break;
            }
            bool = true;
            break label40;
          }
        }
        return;
        bool = false;
      }
    }
    
    private a b(l.a parama)
    {
      int i = this.index;
      this.index = (i + 1);
      a locala1 = new a(parama, i);
      this.bNI.push(locala1);
      this.bNJ.put(parama, locala1);
      parama = parama.getFields().iterator();
      Object localObject;
      while (parama.hasNext())
      {
        localObject = (l.f)parama.next();
        if (((l.f)localObject).bSS.bTz == l.f.a.bTe)
        {
          a locala2 = (a)this.bNJ.get(((l.f)localObject).FN());
          if (locala2 == null)
          {
            localObject = b(((l.f)localObject).FN());
            locala1.bNL = Math.min(locala1.bNL, ((a)localObject).bNL);
          }
          else if (locala2.bNM == null)
          {
            locala1.bNL = Math.min(locala1.bNL, locala2.bNL);
          }
        }
      }
      if (locala1.index == locala1.bNL)
      {
        parama = new b((byte)0);
        do
        {
          localObject = (a)this.bNI.pop();
          ((a)localObject).bNM = parama;
          parama.bNN.add(((a)localObject).bNK);
        } while (localObject != locala1);
        a(parama);
      }
      return locala1;
    }
    
    public final boolean a(l.a parama)
    {
      Boolean localBoolean = (Boolean)this.bNH.get(parama);
      if (localBoolean != null) {
        return localBoolean.booleanValue();
      }
      try
      {
        localBoolean = (Boolean)this.bNH.get(parama);
        if (localBoolean != null)
        {
          bool = localBoolean.booleanValue();
          return bool;
        }
      }
      finally {}
      boolean bool = b(parama).bNM.bNO;
      return bool;
    }
    
    static final class a
    {
      final l.a bNK;
      int bNL;
      j.a.b bNM;
      final int index;
      
      a(l.a parama, int paramInt)
      {
        this.bNK = parama;
        this.index = paramInt;
        this.bNL = paramInt;
        this.bNM = null;
      }
    }
    
    static final class b
    {
      final List<l.a> bNN = new ArrayList();
      boolean bNO = false;
    }
  }
  
  static final class b
  {
    private bi[] bNP = new bi[2];
    
    private static bi b(Class<?> paramClass, l.j paramj)
    {
      String str2 = j.cc(paramj.bTP.getName());
      String str1 = str2 + "_";
      str2 = str2 + "Case_";
      return new bi(paramj.index, j.b(paramClass, str2), j.b(paramClass, str1));
    }
    
    final bi a(Class<?> paramClass, l.j paramj)
    {
      int i = paramj.index;
      if (i >= this.bNP.length) {
        this.bNP = ((bi[])Arrays.copyOf(this.bNP, i * 2));
      }
      bi localbi2 = this.bNP[i];
      bi localbi1 = localbi2;
      if (localbi2 == null)
      {
        localbi1 = b(paramClass, paramj);
        this.bNP[i] = localbi1;
      }
      return localbi1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.j
 * JD-Core Version:    0.7.0.1
 */