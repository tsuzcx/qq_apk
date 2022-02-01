package com.google.b;

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
  implements bv
{
  private static a bPA = new a();
  private static final j bPy = new j();
  private static final Set<String> bPz = new HashSet(Arrays.asList(new String[] { "cached_size", "serialized_size", "class" }));
  
  public static j Bd()
  {
    return bPy;
  }
  
  private static bt C(Class<?> paramClass)
  {
    try
    {
      bt localbt = (bt)paramClass.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
      return localbt;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Unable to get default instance for message class " + paramClass.getName(), localException);
    }
  }
  
  private static au a(Class<?> paramClass, aj.f paramf, b paramb, boolean paramBoolean, be.c paramc)
  {
    paramb = paramb.a(paramClass, paramf.bUT);
    aw localaw = a(paramf);
    paramClass = a(paramClass, paramf, localaw);
    return au.a(paramf.bUO.bRD, localaw, paramb, paramClass, paramBoolean, paramc);
  }
  
  private static aw a(aj.f paramf)
  {
    switch (3.bPF[paramf.bUR.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unsupported field type: " + paramf.bUR);
    case 1: 
      if (!paramf.Hp()) {
        return aw.bWM;
      }
      if (paramf.Hq()) {
        return aw.bXv;
      }
      return aw.bXe;
    case 2: 
      if (paramf.Hp()) {
        return aw.bXh;
      }
      return aw.bWP;
    case 3: 
      if (!paramf.Hp()) {
        return aw.bWF;
      }
      if (paramf.Hq()) {
        return aw.bXo;
      }
      return aw.bWX;
    case 4: 
      if (!paramf.Hp()) {
        return aw.bWR;
      }
      if (paramf.Hq()) {
        return aw.bXx;
      }
      return aw.bXj;
    case 5: 
      if (!paramf.Hp()) {
        return aw.bWL;
      }
      if (paramf.Hq()) {
        return aw.bXu;
      }
      return aw.bXd;
    case 6: 
      if (!paramf.Hp()) {
        return aw.bWK;
      }
      if (paramf.Hq()) {
        return aw.bXt;
      }
      return aw.bXc;
    case 7: 
      if (!paramf.Hp()) {
        return aw.bWG;
      }
      if (paramf.Hq()) {
        return aw.bXp;
      }
      return aw.bWY;
    case 8: 
      if (paramf.Hp()) {
        return aw.bXC;
      }
      return aw.bWW;
    case 9: 
      if (!paramf.Hp()) {
        return aw.bWJ;
      }
      if (paramf.Hq()) {
        return aw.bXs;
      }
      return aw.bXb;
    case 10: 
      if (!paramf.Hp()) {
        return aw.bWH;
      }
      if (paramf.Hq()) {
        return aw.bXq;
      }
      return aw.bWZ;
    case 11: 
      if (paramf.Hm()) {
        return aw.bXD;
      }
      if (paramf.Hp()) {
        return aw.bXg;
      }
      return aw.bWO;
    case 12: 
      if (!paramf.Hp()) {
        return aw.bWS;
      }
      if (paramf.Hq()) {
        return aw.bXy;
      }
      return aw.bXk;
    case 13: 
      if (!paramf.Hp()) {
        return aw.bWT;
      }
      if (paramf.Hq()) {
        return aw.bXz;
      }
      return aw.bXl;
    case 14: 
      if (!paramf.Hp()) {
        return aw.bWU;
      }
      if (paramf.Hq()) {
        return aw.bXA;
      }
      return aw.bXm;
    case 15: 
      if (!paramf.Hp()) {
        return aw.bWV;
      }
      if (paramf.Hq()) {
        return aw.bXB;
      }
      return aw.bXn;
    case 16: 
      if (paramf.Hp()) {
        return aw.bXf;
      }
      return aw.bWN;
    case 17: 
      if (!paramf.Hp()) {
        return aw.bWQ;
      }
      if (paramf.Hq()) {
        return aw.bXw;
      }
      return aw.bXi;
    }
    if (!paramf.Hp()) {
      return aw.bWI;
    }
    if (paramf.Hq()) {
      return aw.bXr;
    }
    return aw.bXa;
  }
  
  private static cu a(Class<?> paramClass, aj.a parama)
  {
    List localList = parama.getFields();
    cu.a locala = cu.hF(localList.size());
    locala.caV = C(paramClass);
    locala.a(cj.can);
    locala.bYr = parama.bUp.Ck().bTs;
    b localb = new b((byte)0);
    int i = 0;
    int j = 1;
    parama = null;
    int k = 0;
    aj.f localf;
    boolean bool;
    Object localObject1;
    if (k < localList.size())
    {
      localf = (aj.f)localList.get(k);
      bool = localf.bUq.bVB.Ev().bSX;
      localObject1 = null;
      if (localf.bUR.bVz == aj.f.a.bVd) {
        localObject1 = new be.c() {};
      }
      if (localf.bUT != null)
      {
        locala.a(a(paramClass, localf, localb, bool, (be.c)localObject1));
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
      int m = localf.bUO.bRD;
      aw localaw = a(localf);
      Object localObject2;
      if (localf.Hm())
      {
        localObject2 = localf.Hu().hr(2);
        if (((aj.f)localObject2).bUR.bVz == aj.f.a.bVd) {
          localObject1 = new be.c() {};
        }
        locala.a(au.a(localField, m, cr.c(paramClass, localf.bUO.getName()), (be.c)localObject1));
      }
      else if (localf.Hp())
      {
        if (localObject1 != null)
        {
          if (localf.Hq()) {
            locala.a(au.a(localField, m, localaw, (be.c)localObject1, b(paramClass, localf)));
          } else {
            locala.a(au.a(localField, m, localaw, (be.c)localObject1));
          }
        }
        else if (localf.bUR.bVz == aj.f.a.bVe) {
          locala.a(au.a(localField, m, localaw, d(paramClass, localf)));
        } else if (localf.Hq()) {
          locala.a(au.a(localField, m, localaw, b(paramClass, localf)));
        } else {
          locala.a(au.a(localField, m, localaw, bool));
        }
      }
      else
      {
        localObject2 = parama;
        if (parama == null) {
          localObject2 = a(paramClass, "bitField" + i + "_");
        }
        if (localf.Hn())
        {
          locala.a(au.b(localField, m, localaw, (Field)localObject2, j, bool, (be.c)localObject1));
          parama = (aj.a)localObject2;
          break label164;
        }
        locala.a(au.a(localField, m, localaw, (Field)localObject2, j, bool, (be.c)localObject1));
        parama = (aj.a)localObject2;
        break label164;
        paramClass = new ArrayList();
        i = 0;
        while (i < localList.size())
        {
          parama = (aj.f)localList.get(i);
          if (!parama.Hn())
          {
            if (parama.bUR.bVz == aj.f.a.bVe)
            {
              localObject1 = parama.Hu();
              if (!bPA.a((aj.a)localObject1)) {}
            }
          }
          else {
            paramClass.add(Integer.valueOf(parama.bUO.bRD));
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
        locala.caR = parama;
        return locala.Jf();
      }
    }
  }
  
  private static Class<?> a(Class<?> paramClass, aj.f paramf, aw paramaw)
  {
    switch (3.bPE[paramaw.bXE.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Invalid type for oneof: ".concat(String.valueOf(paramaw)));
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
  
  private static Field a(Class<?> paramClass, aj.f paramf)
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
  
  private static cu b(Class<?> paramClass, aj.a parama)
  {
    parama = parama.getFields();
    cu.a locala = cu.hF(parama.size());
    locala.caV = C(paramClass);
    locala.a(cj.cao);
    b localb = new b((byte)0);
    int i = 0;
    if (i < parama.size())
    {
      aj.f localf = (aj.f)parama.get(i);
      if (localf.bUT != null) {
        locala.a(a(paramClass, localf, localb, true, null));
      }
      for (;;)
      {
        i += 1;
        break;
        if (localf.Hm()) {
          locala.a(au.a(a(paramClass, localf), localf.bUO.bRD, cr.c(paramClass, localf.bUO.getName()), null));
        } else if ((localf.Hp()) && (localf.bUR.bVz == aj.f.a.bVe)) {
          locala.a(au.a(a(paramClass, localf), localf.bUO.bRD, a(localf), d(paramClass, localf)));
        } else if (localf.Hq()) {
          locala.a(au.a(a(paramClass, localf), localf.bUO.bRD, a(localf), b(paramClass, localf)));
        } else {
          locala.a(au.a(a(paramClass, localf), localf.bUO.bRD, a(localf), true));
        }
      }
    }
    return locala.Jf();
  }
  
  private static String b(aj.f paramf)
  {
    if (paramf.bUR == aj.f.b.bVq)
    {
      paramf = paramf.Hu().bUp.getName();
      if (!bPz.contains(paramf)) {
        break label70;
      }
    }
    label70:
    for (String str = "__";; str = "_")
    {
      return cw(paramf) + str;
      paramf = paramf.bUO.getName();
      break;
    }
  }
  
  private static Field b(Class<?> paramClass, aj.f paramf)
  {
    return a(paramClass, c(paramf));
  }
  
  /* Error */
  private static Class<?> c(Class<?> paramClass, aj.f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 149	com/google/b/aj$f:bUR	Lcom/google/b/aj$f$b;
    //   4: getstatic 572	com/google/b/aj$f$b:bVq	Lcom/google/b/aj$f$b;
    //   7: if_acmpne +30 -> 37
    //   10: aload_1
    //   11: invokevirtual 433	com/google/b/aj$f:Hu	()Lcom/google/b/aj$a;
    //   14: getfield 366	com/google/b/aj$a:bUp	Lcom/google/b/k$a;
    //   17: invokevirtual 573	com/google/b/k$a:getName	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 586	com/google/b/j:cx	(Ljava/lang/String;)Ljava/lang/String;
    //   26: iconst_0
    //   27: anewarray 72	java/lang/Class
    //   30: invokevirtual 76	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: invokevirtual 590	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   36: areturn
    //   37: aload_1
    //   38: getfield 129	com/google/b/aj$f:bUO	Lcom/google/b/k$g;
    //   41: invokevirtual 439	com/google/b/k$g:getName	()Ljava/lang/String;
    //   44: astore_1
    //   45: goto -24 -> 21
    //   48: astore_0
    //   49: new 592	java/lang/RuntimeException
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 595	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramClass	Class<?>
    //   0	58	1	paramf	aj.f
    // Exception table:
    //   from	to	target	type
    //   0	21	48	java/lang/Exception
    //   21	37	48	java/lang/Exception
    //   37	45	48	java/lang/Exception
  }
  
  private static String c(aj.f paramf)
  {
    return cw(paramf.bUO.getName()) + "MemoizedSerializedSize";
  }
  
  private static String cw(String paramString)
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
  
  private static String cx(String paramString)
  {
    paramString = cw(paramString);
    StringBuilder localStringBuilder = new StringBuilder("get");
    localStringBuilder.append(Character.toUpperCase(paramString.charAt(0)));
    localStringBuilder.append(paramString.substring(1, paramString.length()));
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static Class<?> d(Class<?> paramClass, aj.f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 149	com/google/b/aj$f:bUR	Lcom/google/b/aj$f$b;
    //   4: getstatic 572	com/google/b/aj$f$b:bVq	Lcom/google/b/aj$f$b;
    //   7: if_acmpne +36 -> 43
    //   10: aload_1
    //   11: invokevirtual 433	com/google/b/aj$f:Hu	()Lcom/google/b/aj$a;
    //   14: getfield 366	com/google/b/aj$a:bUp	Lcom/google/b/k$a;
    //   17: invokevirtual 573	com/google/b/k$a:getName	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 586	com/google/b/j:cx	(Ljava/lang/String;)Ljava/lang/String;
    //   26: iconst_1
    //   27: anewarray 72	java/lang/Class
    //   30: dup
    //   31: iconst_0
    //   32: getstatic 633	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   35: aastore
    //   36: invokevirtual 76	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: invokevirtual 590	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   42: areturn
    //   43: aload_1
    //   44: getfield 129	com/google/b/aj$f:bUO	Lcom/google/b/k$g;
    //   47: invokevirtual 439	com/google/b/k$g:getName	()Ljava/lang/String;
    //   50: astore_1
    //   51: goto -30 -> 21
    //   54: astore_0
    //   55: new 592	java/lang/RuntimeException
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 595	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramClass	Class<?>
    //   0	64	1	paramf	aj.f
    // Exception table:
    //   from	to	target	type
    //   0	21	54	java/lang/Exception
    //   21	43	54	java/lang/Exception
    //   43	51	54	java/lang/Exception
  }
  
  public final boolean A(Class<?> paramClass)
  {
    return bb.class.isAssignableFrom(paramClass);
  }
  
  public final bu B(Class<?> paramClass)
  {
    if (!bb.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Unsupported message type: " + paramClass.getName());
    }
    aj.a locala = C(paramClass).Cv();
    switch (3.bPD[locala.bUq.Hx().ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unsupported syntax: " + locala.bUq.Hx());
    case 1: 
      return a(paramClass, locala);
    }
    return b(paramClass, locala);
  }
  
  static final class a
  {
    private final Map<aj.a, Boolean> bPG = new ConcurrentHashMap();
    private final Stack<a> bPH = new Stack();
    private final Map<aj.a, a> bPI = new HashMap();
    private int index = 0;
    
    private void a(b paramb)
    {
      Iterator localIterator = paramb.bPM.iterator();
      break label109;
      break label109;
      label10:
      Object localObject1;
      boolean bool;
      if (localIterator.hasNext())
      {
        localObject1 = (aj.a)localIterator.next();
        if (((aj.a)localObject1).Hg()) {
          bool = true;
        }
      }
      for (;;)
      {
        label40:
        paramb.bPN = bool;
        localIterator = paramb.bPM.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (aj.a)localIterator.next();
            this.bPG.put(localObject1, Boolean.valueOf(paramb.bPN));
            continue;
            localObject1 = ((aj.a)localObject1).getFields().iterator();
            label109:
            if (!((Iterator)localObject1).hasNext()) {
              break label10;
            }
            Object localObject2 = (aj.f)((Iterator)localObject1).next();
            if (((aj.f)localObject2).Hn())
            {
              bool = true;
              break label40;
            }
            if (((aj.f)localObject2).bUR.bVz != aj.f.a.bVe) {
              break;
            }
            localObject2 = (a)this.bPI.get(((aj.f)localObject2).Hu());
            if ((((a)localObject2).bPL == paramb) || (!((a)localObject2).bPL.bPN)) {
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
    
    private a b(aj.a parama)
    {
      int i = this.index;
      this.index = (i + 1);
      a locala1 = new a(parama, i);
      this.bPH.push(locala1);
      this.bPI.put(parama, locala1);
      parama = parama.getFields().iterator();
      Object localObject;
      while (parama.hasNext())
      {
        localObject = (aj.f)parama.next();
        if (((aj.f)localObject).bUR.bVz == aj.f.a.bVe)
        {
          a locala2 = (a)this.bPI.get(((aj.f)localObject).Hu());
          if (locala2 == null)
          {
            localObject = b(((aj.f)localObject).Hu());
            locala1.bPK = Math.min(locala1.bPK, ((a)localObject).bPK);
          }
          else if (locala2.bPL == null)
          {
            locala1.bPK = Math.min(locala1.bPK, locala2.bPK);
          }
        }
      }
      if (locala1.index == locala1.bPK)
      {
        parama = new b((byte)0);
        do
        {
          localObject = (a)this.bPH.pop();
          ((a)localObject).bPL = parama;
          parama.bPM.add(((a)localObject).bPJ);
        } while (localObject != locala1);
        a(parama);
      }
      return locala1;
    }
    
    public final boolean a(aj.a parama)
    {
      Boolean localBoolean = (Boolean)this.bPG.get(parama);
      if (localBoolean != null) {
        return localBoolean.booleanValue();
      }
      try
      {
        localBoolean = (Boolean)this.bPG.get(parama);
        if (localBoolean != null)
        {
          bool = localBoolean.booleanValue();
          return bool;
        }
      }
      finally {}
      boolean bool = b(parama).bPL.bPN;
      return bool;
    }
    
    static final class a
    {
      final aj.a bPJ;
      int bPK;
      j.a.b bPL;
      final int index;
      
      a(aj.a parama, int paramInt)
      {
        this.bPJ = parama;
        this.index = paramInt;
        this.bPK = paramInt;
        this.bPL = null;
      }
    }
    
    static final class b
    {
      final List<aj.a> bPM = new ArrayList();
      boolean bPN = false;
    }
  }
  
  static final class b
  {
    private ch[] bPO = new ch[2];
    
    private static ch b(Class<?> paramClass, aj.j paramj)
    {
      String str2 = j.cw(paramj.bVP.getName());
      String str1 = str2 + "_";
      str2 = str2 + "Case_";
      return new ch(paramj.index, j.b(paramClass, str2), j.b(paramClass, str1));
    }
    
    final ch a(Class<?> paramClass, aj.j paramj)
    {
      int i = paramj.index;
      if (i >= this.bPO.length) {
        this.bPO = ((ch[])Arrays.copyOf(this.bPO, i * 2));
      }
      ch localch2 = this.bPO[i];
      ch localch1 = localch2;
      if (localch2 == null)
      {
        localch1 = b(paramClass, paramj);
        this.bPO[i] = localch1;
      }
      return localch1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.j
 * JD-Core Version:    0.7.0.1
 */