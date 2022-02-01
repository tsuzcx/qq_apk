package com.google.d;

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

public final class m
  implements cd
{
  private static final m dJq = new m();
  private static final Set<String> dJr = new HashSet(Arrays.asList(new String[] { "cached_size", "serialized_size", "class" }));
  private static a dJs = new a();
  
  private static cb L(Class<?> paramClass)
  {
    try
    {
      cb localcb = (cb)paramClass.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
      return localcb;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Unable to get default instance for message class " + paramClass.getName(), localException);
    }
  }
  
  private static ay a(Class<?> paramClass, am.f paramf, b paramb, boolean paramBoolean, bj.e parame)
  {
    paramb = paramb.a(paramClass, paramf.dOG);
    ba localba = a(paramf);
    paramClass = a(paramClass, paramf, localba);
    return ay.a(paramf.dOB.dLq, localba, paramb, paramClass, paramBoolean, parame);
  }
  
  private static ba a(am.f paramf)
  {
    switch (3.dJx[paramf.dOE.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unsupported field type: " + paramf.dOE);
    case 1: 
      if (!paramf.ahl()) {
        return ba.dQy;
      }
      if (paramf.ahm()) {
        return ba.dRh;
      }
      return ba.dQQ;
    case 2: 
      if (paramf.ahl()) {
        return ba.dQT;
      }
      return ba.dQB;
    case 3: 
      if (!paramf.ahl()) {
        return ba.dQr;
      }
      if (paramf.ahm()) {
        return ba.dRa;
      }
      return ba.dQJ;
    case 4: 
      if (!paramf.ahl()) {
        return ba.dQD;
      }
      if (paramf.ahm()) {
        return ba.dRj;
      }
      return ba.dQV;
    case 5: 
      if (!paramf.ahl()) {
        return ba.dQx;
      }
      if (paramf.ahm()) {
        return ba.dRg;
      }
      return ba.dQP;
    case 6: 
      if (!paramf.ahl()) {
        return ba.dQw;
      }
      if (paramf.ahm()) {
        return ba.dRf;
      }
      return ba.dQO;
    case 7: 
      if (!paramf.ahl()) {
        return ba.dQs;
      }
      if (paramf.ahm()) {
        return ba.dRb;
      }
      return ba.dQK;
    case 8: 
      if (paramf.ahl()) {
        return ba.dRo;
      }
      return ba.dQI;
    case 9: 
      if (!paramf.ahl()) {
        return ba.dQv;
      }
      if (paramf.ahm()) {
        return ba.dRe;
      }
      return ba.dQN;
    case 10: 
      if (!paramf.ahl()) {
        return ba.dQt;
      }
      if (paramf.ahm()) {
        return ba.dRc;
      }
      return ba.dQL;
    case 11: 
      if (paramf.ahi()) {
        return ba.dRp;
      }
      if (paramf.ahl()) {
        return ba.dQS;
      }
      return ba.dQA;
    case 12: 
      if (!paramf.ahl()) {
        return ba.dQE;
      }
      if (paramf.ahm()) {
        return ba.dRk;
      }
      return ba.dQW;
    case 13: 
      if (!paramf.ahl()) {
        return ba.dQF;
      }
      if (paramf.ahm()) {
        return ba.dRl;
      }
      return ba.dQX;
    case 14: 
      if (!paramf.ahl()) {
        return ba.dQG;
      }
      if (paramf.ahm()) {
        return ba.dRm;
      }
      return ba.dQY;
    case 15: 
      if (!paramf.ahl()) {
        return ba.dQH;
      }
      if (paramf.ahm()) {
        return ba.dRn;
      }
      return ba.dQZ;
    case 16: 
      if (paramf.ahl()) {
        return ba.dQR;
      }
      return ba.dQz;
    case 17: 
      if (!paramf.ahl()) {
        return ba.dQC;
      }
      if (paramf.ahm()) {
        return ba.dRi;
      }
      return ba.dQU;
    }
    if (!paramf.ahl()) {
      return ba.dQu;
    }
    if (paramf.ahm()) {
      return ba.dRd;
    }
    return ba.dQM;
  }
  
  private static dh a(Class<?> paramClass, am.a parama)
  {
    List localList = parama.getFields();
    dh.a locala = dh.lv(localList.size());
    locala.dVw = L(paramClass);
    locala.a(cu.dUw);
    locala.dSa = parama.dOc.abU().dNf;
    b localb = new b((byte)0);
    int i = 0;
    int j = 1;
    parama = null;
    int k = 0;
    am.f localf;
    boolean bool;
    Object localObject1;
    if (k < localList.size())
    {
      localf = (am.f)localList.get(k);
      bool = localf.dOd.dPo.aee().dMK;
      localObject1 = null;
      if (localf.dOE.dPm == am.f.a.dOQ) {
        localObject1 = new bj.e()
        {
          public final boolean kB(int paramAnonymousInt)
          {
            return this.dJt.ahr().lc(paramAnonymousInt) != null;
          }
        };
      }
      if (localf.dOG != null)
      {
        locala.a(a(paramClass, localf, localb, bool, (bj.e)localObject1));
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
      int m = localf.dOB.dLq;
      ba localba = a(localf);
      Object localObject2;
      if (localf.ahi())
      {
        localObject2 = localf.ahq().lb(2);
        if (((am.f)localObject2).dOE.dPm == am.f.a.dOQ) {
          localObject1 = new bj.e()
          {
            public final boolean kB(int paramAnonymousInt)
            {
              return this.dJu.ahr().lc(paramAnonymousInt) != null;
            }
          };
        }
        locala.a(ay.a(localField, m, de.c(paramClass, localf.dOB.getName()), (bj.e)localObject1));
      }
      else if (localf.ahl())
      {
        if (localObject1 != null)
        {
          if (localf.ahm()) {
            locala.a(ay.a(localField, m, localba, (bj.e)localObject1, b(paramClass, localf)));
          } else {
            locala.a(ay.a(localField, m, localba, (bj.e)localObject1));
          }
        }
        else if (localf.dOE.dPm == am.f.a.dOR) {
          locala.a(ay.a(localField, m, localba, d(paramClass, localf)));
        } else if (localf.ahm()) {
          locala.a(ay.a(localField, m, localba, b(paramClass, localf)));
        } else {
          locala.a(ay.a(localField, m, localba, bool));
        }
      }
      else
      {
        localObject2 = parama;
        if (parama == null) {
          localObject2 = a(paramClass, "bitField" + i + "_");
        }
        if (localf.ahj())
        {
          locala.a(ay.b(localField, m, localba, (Field)localObject2, j, bool, (bj.e)localObject1));
          parama = (am.a)localObject2;
          break label164;
        }
        locala.a(ay.a(localField, m, localba, (Field)localObject2, j, bool, (bj.e)localObject1));
        parama = (am.a)localObject2;
        break label164;
        paramClass = new ArrayList();
        i = 0;
        while (i < localList.size())
        {
          parama = (am.f)localList.get(i);
          if (!parama.ahj())
          {
            if (parama.dOE.dPm == am.f.a.dOR)
            {
              localObject1 = parama.ahq();
              if (!dJs.a((am.a)localObject1)) {}
            }
          }
          else {
            paramClass.add(Integer.valueOf(parama.dOB.dLq));
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
        locala.dVs = parama;
        return locala.ajz();
      }
    }
  }
  
  private static Class<?> a(Class<?> paramClass, am.f paramf, ba paramba)
  {
    switch (3.dJw[paramba.dRq.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Invalid type for oneof: ".concat(String.valueOf(paramba)));
    case 1: 
      return Boolean.class;
    case 2: 
      return h.class;
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
  
  private static Field a(Class<?> paramClass, am.f paramf)
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
  
  public static m aaQ()
  {
    return dJq;
  }
  
  private static dh b(Class<?> paramClass, am.a parama)
  {
    parama = parama.getFields();
    dh.a locala = dh.lv(parama.size());
    locala.dVw = L(paramClass);
    locala.a(cu.dUx);
    b localb = new b((byte)0);
    int i = 0;
    if (i < parama.size())
    {
      am.f localf = (am.f)parama.get(i);
      if (localf.dOG != null) {
        locala.a(a(paramClass, localf, localb, true, null));
      }
      for (;;)
      {
        i += 1;
        break;
        if (localf.ahi()) {
          locala.a(ay.a(a(paramClass, localf), localf.dOB.dLq, de.c(paramClass, localf.dOB.getName()), null));
        } else if ((localf.ahl()) && (localf.dOE.dPm == am.f.a.dOR)) {
          locala.a(ay.a(a(paramClass, localf), localf.dOB.dLq, a(localf), d(paramClass, localf)));
        } else if (localf.ahm()) {
          locala.a(ay.a(a(paramClass, localf), localf.dOB.dLq, a(localf), b(paramClass, localf)));
        } else {
          locala.a(ay.a(a(paramClass, localf), localf.dOB.dLq, a(localf), true));
        }
      }
    }
    return locala.ajz();
  }
  
  private static String b(am.f paramf)
  {
    if (paramf.dOE == am.f.b.dPd)
    {
      paramf = paramf.ahq().dOc.getName();
      if (!dJr.contains(paramf)) {
        break label70;
      }
    }
    label70:
    for (String str = "__";; str = "_")
    {
      return dV(paramf) + str;
      paramf = paramf.dOB.getName();
      break;
    }
  }
  
  private static Field b(Class<?> paramClass, am.f paramf)
  {
    return a(paramClass, c(paramf));
  }
  
  /* Error */
  private static Class<?> c(Class<?> paramClass, am.f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 147	com/google/d/am$f:dOE	Lcom/google/d/am$f$b;
    //   4: getstatic 572	com/google/d/am$f$b:dPd	Lcom/google/d/am$f$b;
    //   7: if_acmpne +30 -> 37
    //   10: aload_1
    //   11: invokevirtual 431	com/google/d/am$f:ahq	()Lcom/google/d/am$a;
    //   14: getfield 364	com/google/d/am$a:dOc	Lcom/google/d/n$a;
    //   17: invokevirtual 573	com/google/d/n$a:getName	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 586	com/google/d/m:dW	(Ljava/lang/String;)Ljava/lang/String;
    //   26: iconst_0
    //   27: anewarray 70	java/lang/Class
    //   30: invokevirtual 74	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: invokevirtual 590	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   36: areturn
    //   37: aload_1
    //   38: getfield 127	com/google/d/am$f:dOB	Lcom/google/d/n$g;
    //   41: invokevirtual 437	com/google/d/n$g:getName	()Ljava/lang/String;
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
    //   0	58	1	paramf	am.f
    // Exception table:
    //   from	to	target	type
    //   0	21	48	java/lang/Exception
    //   21	37	48	java/lang/Exception
    //   37	45	48	java/lang/Exception
  }
  
  private static String c(am.f paramf)
  {
    return dV(paramf.dOB.getName()) + "MemoizedSerializedSize";
  }
  
  /* Error */
  private static Class<?> d(Class<?> paramClass, am.f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 147	com/google/d/am$f:dOE	Lcom/google/d/am$f$b;
    //   4: getstatic 572	com/google/d/am$f$b:dPd	Lcom/google/d/am$f$b;
    //   7: if_acmpne +36 -> 43
    //   10: aload_1
    //   11: invokevirtual 431	com/google/d/am$f:ahq	()Lcom/google/d/am$a;
    //   14: getfield 364	com/google/d/am$a:dOc	Lcom/google/d/n$a;
    //   17: invokevirtual 573	com/google/d/n$a:getName	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 586	com/google/d/m:dW	(Ljava/lang/String;)Ljava/lang/String;
    //   26: iconst_1
    //   27: anewarray 70	java/lang/Class
    //   30: dup
    //   31: iconst_0
    //   32: getstatic 602	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   35: aastore
    //   36: invokevirtual 74	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: invokevirtual 590	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   42: areturn
    //   43: aload_1
    //   44: getfield 127	com/google/d/am$f:dOB	Lcom/google/d/n$g;
    //   47: invokevirtual 437	com/google/d/n$g:getName	()Ljava/lang/String;
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
    //   0	64	1	paramf	am.f
    // Exception table:
    //   from	to	target	type
    //   0	21	54	java/lang/Exception
    //   21	43	54	java/lang/Exception
    //   43	51	54	java/lang/Exception
  }
  
  private static String dV(String paramString)
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
  
  private static String dW(String paramString)
  {
    paramString = dV(paramString);
    StringBuilder localStringBuilder = new StringBuilder("get");
    localStringBuilder.append(Character.toUpperCase(paramString.charAt(0)));
    localStringBuilder.append(paramString.substring(1, paramString.length()));
    return localStringBuilder.toString();
  }
  
  public final boolean J(Class<?> paramClass)
  {
    return bg.class.isAssignableFrom(paramClass);
  }
  
  public final cc K(Class<?> paramClass)
  {
    if (!bg.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Unsupported message type: " + paramClass.getName());
    }
    am.a locala = L(paramClass).getDescriptorForType();
    switch (3.dJv[locala.dOd.aht().ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unsupported syntax: " + locala.dOd.aht());
    case 1: 
      return a(paramClass, locala);
    }
    return b(paramClass, locala);
  }
  
  static final class a
  {
    private final Map<am.a, a> dJA = new HashMap();
    private final Map<am.a, Boolean> dJy = new ConcurrentHashMap();
    private final Stack<a> dJz = new Stack();
    private int index = 0;
    
    private void a(b paramb)
    {
      Iterator localIterator = paramb.dJE.iterator();
      break label109;
      break label109;
      label10:
      Object localObject1;
      boolean bool;
      if (localIterator.hasNext())
      {
        localObject1 = (am.a)localIterator.next();
        if (((am.a)localObject1).ahc()) {
          bool = true;
        }
      }
      for (;;)
      {
        label40:
        paramb.dJF = bool;
        localIterator = paramb.dJE.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (am.a)localIterator.next();
            this.dJy.put(localObject1, Boolean.valueOf(paramb.dJF));
            continue;
            localObject1 = ((am.a)localObject1).getFields().iterator();
            label109:
            if (!((Iterator)localObject1).hasNext()) {
              break label10;
            }
            Object localObject2 = (am.f)((Iterator)localObject1).next();
            if (((am.f)localObject2).ahj())
            {
              bool = true;
              break label40;
            }
            if (((am.f)localObject2).dOE.dPm != am.f.a.dOR) {
              break;
            }
            localObject2 = (a)this.dJA.get(((am.f)localObject2).ahq());
            if ((((a)localObject2).dJD == paramb) || (!((a)localObject2).dJD.dJF)) {
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
    
    private a b(am.a parama)
    {
      int i = this.index;
      this.index = (i + 1);
      a locala1 = new a(parama, i);
      this.dJz.push(locala1);
      this.dJA.put(parama, locala1);
      parama = parama.getFields().iterator();
      Object localObject;
      while (parama.hasNext())
      {
        localObject = (am.f)parama.next();
        if (((am.f)localObject).dOE.dPm == am.f.a.dOR)
        {
          a locala2 = (a)this.dJA.get(((am.f)localObject).ahq());
          if (locala2 == null)
          {
            localObject = b(((am.f)localObject).ahq());
            locala1.dJC = Math.min(locala1.dJC, ((a)localObject).dJC);
          }
          else if (locala2.dJD == null)
          {
            locala1.dJC = Math.min(locala1.dJC, locala2.dJC);
          }
        }
      }
      if (locala1.index == locala1.dJC)
      {
        parama = new b((byte)0);
        do
        {
          localObject = (a)this.dJz.pop();
          ((a)localObject).dJD = parama;
          parama.dJE.add(((a)localObject).dJB);
        } while (localObject != locala1);
        a(parama);
      }
      return locala1;
    }
    
    public final boolean a(am.a parama)
    {
      Boolean localBoolean = (Boolean)this.dJy.get(parama);
      if (localBoolean != null) {
        return localBoolean.booleanValue();
      }
      try
      {
        localBoolean = (Boolean)this.dJy.get(parama);
        if (localBoolean != null)
        {
          bool = localBoolean.booleanValue();
          return bool;
        }
      }
      finally {}
      boolean bool = b(parama).dJD.dJF;
      return bool;
    }
    
    static final class a
    {
      final am.a dJB;
      int dJC;
      m.a.b dJD;
      final int index;
      
      a(am.a parama, int paramInt)
      {
        this.dJB = parama;
        this.index = paramInt;
        this.dJC = paramInt;
        this.dJD = null;
      }
    }
    
    static final class b
    {
      final List<am.a> dJE = new ArrayList();
      boolean dJF = false;
    }
  }
  
  static final class b
  {
    private cr[] dJG = new cr[2];
    
    private static cr b(Class<?> paramClass, am.j paramj)
    {
      String str2 = m.dV(paramj.dPC.getName());
      String str1 = str2 + "_";
      str2 = str2 + "Case_";
      return new cr(paramj.index, m.b(paramClass, str2), m.b(paramClass, str1));
    }
    
    final cr a(Class<?> paramClass, am.j paramj)
    {
      int i = paramj.index;
      if (i >= this.dJG.length) {
        this.dJG = ((cr[])Arrays.copyOf(this.dJG, i * 2));
      }
      cr localcr2 = this.dJG[i];
      cr localcr1 = localcr2;
      if (localcr2 == null)
      {
        localcr1 = b(paramClass, paramj);
        this.dJG[i] = localcr1;
      }
      return localcr1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.m
 * JD-Core Version:    0.7.0.1
 */