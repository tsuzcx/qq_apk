package com.google.a.b.a;

import com.google.a.b.h;
import com.google.a.d.b;
import com.google.a.e;
import com.google.a.i;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class n
{
  public static final r<Number> bNA;
  public static final r<Number> bNB;
  public static final s bNC;
  public static final r<Character> bND;
  public static final s bNE;
  public static final r<String> bNF;
  public static final r<BigDecimal> bNG;
  public static final r<BigInteger> bNH;
  public static final s bNI;
  public static final r<StringBuilder> bNJ;
  public static final s bNK;
  public static final r<StringBuffer> bNL;
  public static final s bNM;
  public static final r<URL> bNN;
  public static final s bNO;
  public static final r<URI> bNP;
  public static final s bNQ;
  public static final r<InetAddress> bNR;
  public static final s bNS;
  public static final r<UUID> bNT;
  public static final s bNU;
  public static final r<Currency> bNV;
  public static final s bNW;
  public static final s bNX;
  public static final r<Calendar> bNY;
  public static final s bNZ;
  public static final r<Class> bNf;
  public static final s bNg;
  public static final r<BitSet> bNh;
  public static final s bNi;
  public static final r<Boolean> bNj;
  public static final r<Boolean> bNk;
  public static final s bNl;
  public static final r<Number> bNm;
  public static final s bNn;
  public static final r<Number> bNo;
  public static final s bNp;
  public static final r<Number> bNq;
  public static final s bNr;
  public static final r<AtomicInteger> bNs;
  public static final s bNt;
  public static final r<AtomicBoolean> bNu;
  public static final s bNv;
  public static final r<AtomicIntegerArray> bNw;
  public static final s bNx;
  public static final r<Number> bNy;
  public static final r<Number> bNz;
  public static final r<Locale> bOa;
  public static final s bOb;
  public static final r<i> bOc;
  public static final s bOd;
  public static final s bOe;
  
  static
  {
    AppMethodBeat.i(108053);
    bNf = new r() {}.zf();
    bNg = a(Class.class, bNf);
    bNh = new r()
    {
      private static BitSet j(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223428);
        BitSet localBitSet = new BitSet();
        paramAnonymousa.zs();
        Object localObject = paramAnonymousa.zw();
        int i = 0;
        if (localObject != b.bOJ)
        {
          boolean bool;
          switch (n.29.bMK[localObject.ordinal()])
          {
          default: 
            paramAnonymousa = new p("Invalid bitset value type: ".concat(String.valueOf(localObject)));
            AppMethodBeat.o(223428);
            throw paramAnonymousa;
          case 1: 
            if (paramAnonymousa.zD() != 0) {
              bool = true;
            }
            break;
          }
          for (;;)
          {
            if (bool) {
              localBitSet.set(i);
            }
            i += 1;
            localObject = paramAnonymousa.zw();
            break;
            bool = false;
            continue;
            bool = paramAnonymousa.zz();
            continue;
            localObject = paramAnonymousa.zy();
            try
            {
              int j = Integer.parseInt((String)localObject);
              if (j != 0) {
                bool = true;
              } else {
                bool = false;
              }
            }
            catch (NumberFormatException paramAnonymousa)
            {
              paramAnonymousa = new p("Error: Expecting: bitset number value (1, 0), Found: ".concat(String.valueOf(localObject)));
              AppMethodBeat.o(223428);
              throw paramAnonymousa;
            }
          }
        }
        paramAnonymousa.zt();
        AppMethodBeat.o(223428);
        return localBitSet;
      }
    }.zf();
    bNi = a(BitSet.class, bNh);
    bNj = new r() {};
    bNk = new r() {};
    bNl = a(Boolean.TYPE, Boolean.class, bNj);
    bNm = new r()
    {
      private static Number g(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223218);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(223218);
          return null;
        }
        try
        {
          byte b = (byte)paramAnonymousa.zD();
          AppMethodBeat.o(223218);
          return Byte.valueOf(b);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(223218);
          throw paramAnonymousa;
        }
      }
    };
    bNn = a(Byte.TYPE, Byte.class, bNm);
    bNo = new r()
    {
      private static Number g(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223435);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(223435);
          return null;
        }
        try
        {
          short s = (short)paramAnonymousa.zD();
          AppMethodBeat.o(223435);
          return Short.valueOf(s);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(223435);
          throw paramAnonymousa;
        }
      }
    };
    bNp = a(Short.TYPE, Short.class, bNo);
    bNq = new r()
    {
      private static Number g(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223235);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(223235);
          return null;
        }
        try
        {
          int i = paramAnonymousa.zD();
          AppMethodBeat.o(223235);
          return Integer.valueOf(i);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(223235);
          throw paramAnonymousa;
        }
      }
    };
    bNr = a(Integer.TYPE, Integer.class, bNq);
    bNs = new r()
    {
      private static AtomicInteger m(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(222791);
        try
        {
          paramAnonymousa = new AtomicInteger(paramAnonymousa.zD());
          AppMethodBeat.o(222791);
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(222791);
          throw paramAnonymousa;
        }
      }
    }.zf();
    bNt = a(AtomicInteger.class, bNs);
    bNu = new r() {}.zf();
    bNv = a(AtomicBoolean.class, bNu);
    bNw = new r()
    {
      private static AtomicIntegerArray f(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223015);
        ArrayList localArrayList = new ArrayList();
        paramAnonymousa.zs();
        while (paramAnonymousa.hasNext()) {
          try
          {
            localArrayList.add(Integer.valueOf(paramAnonymousa.zD()));
          }
          catch (NumberFormatException paramAnonymousa)
          {
            paramAnonymousa = new p(paramAnonymousa);
            AppMethodBeat.o(223015);
            throw paramAnonymousa;
          }
        }
        paramAnonymousa.zt();
        int j = localArrayList.size();
        paramAnonymousa = new AtomicIntegerArray(j);
        int i = 0;
        while (i < j)
        {
          paramAnonymousa.set(i, ((Integer)localArrayList.get(i)).intValue());
          i += 1;
        }
        AppMethodBeat.o(223015);
        return paramAnonymousa;
      }
    }.zf();
    bNx = a(AtomicIntegerArray.class, bNw);
    bNy = new r()
    {
      private static Number g(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(222820);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(222820);
          return null;
        }
        try
        {
          long l = paramAnonymousa.zC();
          AppMethodBeat.o(222820);
          return Long.valueOf(l);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(222820);
          throw paramAnonymousa;
        }
      }
    };
    bNz = new r() {};
    bNA = new r() {};
    bNB = new r() {};
    bNC = a(Number.class, bNB);
    bND = new r() {};
    bNE = a(Character.TYPE, Character.class, bND);
    bNF = new r() {};
    bNG = new r()
    {
      private static BigDecimal h(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(222906);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(222906);
          return null;
        }
        try
        {
          paramAnonymousa = new BigDecimal(paramAnonymousa.zy());
          AppMethodBeat.o(222906);
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(222906);
          throw paramAnonymousa;
        }
      }
    };
    bNH = new r()
    {
      private static BigInteger i(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223153);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(223153);
          return null;
        }
        try
        {
          paramAnonymousa = new BigInteger(paramAnonymousa.zy());
          AppMethodBeat.o(223153);
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(223153);
          throw paramAnonymousa;
        }
      }
    };
    bNI = a(String.class, bNF);
    bNJ = new r() {};
    bNK = a(StringBuilder.class, bNJ);
    bNL = new r() {};
    bNM = a(StringBuffer.class, bNL);
    bNN = new r() {};
    bNO = a(URL.class, bNN);
    bNP = new r()
    {
      private static URI k(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223445);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(223445);
          return null;
        }
        try
        {
          paramAnonymousa = paramAnonymousa.zy();
          if ("null".equals(paramAnonymousa))
          {
            AppMethodBeat.o(223445);
            return null;
          }
        }
        catch (URISyntaxException paramAnonymousa)
        {
          paramAnonymousa = new j(paramAnonymousa);
          AppMethodBeat.o(223445);
          throw paramAnonymousa;
        }
        paramAnonymousa = new URI(paramAnonymousa);
        AppMethodBeat.o(223445);
        return paramAnonymousa;
      }
    };
    bNQ = a(URI.class, bNP);
    bNR = new r() {};
    bNS = b(InetAddress.class, bNR);
    bNT = new r() {};
    bNU = a(UUID.class, bNT);
    bNV = new r() {}.zf();
    bNW = a(Currency.class, bNV);
    bNX = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108058);
        if (paramAnonymousa.bOw != Timestamp.class)
        {
          AppMethodBeat.o(108058);
          return null;
        }
        paramAnonymouse = new r() {};
        AppMethodBeat.o(108058);
        return paramAnonymouse;
      }
    };
    bNY = new r() {};
    bNZ = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        paramAnonymouse = paramAnonymousa.bOw;
        if ((paramAnonymouse == this.bOk) || (paramAnonymouse == this.bOl)) {
          return this.bMO;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108020);
        String str = "Factory[type=" + this.bOk.getName() + "+" + this.bOl.getName() + ",adapter=" + this.bMO + "]";
        AppMethodBeat.o(108020);
        return str;
      }
    };
    bOa = new r() {};
    bOb = a(Locale.class, bOa);
    bOc = new r()
    {
      private void a(com.google.a.d.c paramAnonymousc, i paramAnonymousi)
      {
        AppMethodBeat.i(108029);
        if ((paramAnonymousi == null) || ((paramAnonymousi instanceof k)))
        {
          paramAnonymousc.zK();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousi instanceof com.google.a.n))
        {
          paramAnonymousi = paramAnonymousi.zd();
          if ((paramAnonymousi.value instanceof Number))
          {
            paramAnonymousc.a(paramAnonymousi.yZ());
            AppMethodBeat.o(108029);
            return;
          }
          if ((paramAnonymousi.value instanceof Boolean))
          {
            paramAnonymousc.bp(paramAnonymousi.zb());
            AppMethodBeat.o(108029);
            return;
          }
          paramAnonymousc.cn(paramAnonymousi.za());
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousi instanceof com.google.a.g))
        {
          paramAnonymousc.zG();
          if ((paramAnonymousi instanceof com.google.a.g))
          {
            paramAnonymousi = ((com.google.a.g)paramAnonymousi).iterator();
            while (paramAnonymousi.hasNext()) {
              a(paramAnonymousc, (i)paramAnonymousi.next());
            }
          }
          paramAnonymousc = new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(paramAnonymousi)));
          AppMethodBeat.o(108029);
          throw paramAnonymousc;
          paramAnonymousc.zH();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousi instanceof l))
        {
          paramAnonymousc.zI();
          if ((paramAnonymousi instanceof l))
          {
            paramAnonymousi = ((l)paramAnonymousi).bLn.entrySet().iterator();
            while (paramAnonymousi.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousi.next();
              paramAnonymousc.cm((String)localEntry.getKey());
              a(paramAnonymousc, (i)localEntry.getValue());
            }
          }
          paramAnonymousc = new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(paramAnonymousi)));
          AppMethodBeat.o(108029);
          throw paramAnonymousc;
          paramAnonymousc.zJ();
          AppMethodBeat.o(108029);
          return;
        }
        paramAnonymousc = new IllegalArgumentException("Couldn't write " + paramAnonymousi.getClass());
        AppMethodBeat.o(108029);
        throw paramAnonymousc;
      }
      
      private i l(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(223089);
        switch (n.29.bMK[paramAnonymousa.zw().ordinal()])
        {
        default: 
          paramAnonymousa = new IllegalArgumentException();
          AppMethodBeat.o(223089);
          throw paramAnonymousa;
        case 3: 
          paramAnonymousa = new com.google.a.n(paramAnonymousa.zy());
          AppMethodBeat.o(223089);
          return paramAnonymousa;
        case 1: 
          paramAnonymousa = new com.google.a.n(new com.google.a.b.g(paramAnonymousa.zy()));
          AppMethodBeat.o(223089);
          return paramAnonymousa;
        case 2: 
          paramAnonymousa = new com.google.a.n(Boolean.valueOf(paramAnonymousa.zz()));
          AppMethodBeat.o(223089);
          return paramAnonymousa;
        case 4: 
          paramAnonymousa.zA();
          paramAnonymousa = k.bLm;
          AppMethodBeat.o(223089);
          return paramAnonymousa;
        case 5: 
          localObject = new com.google.a.g();
          paramAnonymousa.zs();
          while (paramAnonymousa.hasNext()) {
            ((com.google.a.g)localObject).a(l(paramAnonymousa));
          }
          paramAnonymousa.zt();
          AppMethodBeat.o(223089);
          return localObject;
        }
        Object localObject = new l();
        paramAnonymousa.zu();
        while (paramAnonymousa.hasNext()) {
          ((l)localObject).a(paramAnonymousa.zx(), l(paramAnonymousa));
        }
        paramAnonymousa.zv();
        AppMethodBeat.o(223089);
        return localObject;
      }
    };
    bOd = b(i.class, bOc);
    bOe = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108027);
        paramAnonymousa = paramAnonymousa.bOw;
        if ((!Enum.class.isAssignableFrom(paramAnonymousa)) || (paramAnonymousa == Enum.class))
        {
          AppMethodBeat.o(108027);
          return null;
        }
        paramAnonymouse = paramAnonymousa;
        if (!paramAnonymousa.isEnum()) {
          paramAnonymouse = paramAnonymousa.getSuperclass();
        }
        paramAnonymouse = new n.a(paramAnonymouse);
        AppMethodBeat.o(108027);
        return paramAnonymouse;
      }
    };
    AppMethodBeat.o(108053);
  }
  
  public static <TT> s a(Class<TT> paramClass, final r<TT> paramr)
  {
    AppMethodBeat.i(108050);
    paramClass = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.bOw == this.bOh) {
          return paramr;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108026);
        String str = "Factory[type=" + this.bOh.getName() + ",adapter=" + paramr + "]";
        AppMethodBeat.o(108026);
        return str;
      }
    };
    AppMethodBeat.o(108050);
    return paramClass;
  }
  
  public static <TT> s a(Class<TT> paramClass1, final Class<TT> paramClass2, final r<? super TT> paramr)
  {
    AppMethodBeat.i(108051);
    paramClass1 = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        paramAnonymouse = paramAnonymousa.bOw;
        if ((paramAnonymouse == this.bOi) || (paramAnonymouse == paramClass2)) {
          return paramr;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108018);
        String str = "Factory[type=" + paramClass2.getName() + "+" + this.bOi.getName() + ",adapter=" + paramr + "]";
        AppMethodBeat.o(108018);
        return str;
      }
    };
    AppMethodBeat.o(108051);
    return paramClass1;
  }
  
  private static <T1> s b(Class<T1> paramClass, final r<T1> paramr)
  {
    AppMethodBeat.i(108052);
    paramClass = new s()
    {
      public final <T2> r<T2> a(final e paramAnonymouse, com.google.a.c.a<T2> paramAnonymousa)
      {
        AppMethodBeat.i(107998);
        paramAnonymouse = paramAnonymousa.bOw;
        if (!this.bOm.isAssignableFrom(paramAnonymouse))
        {
          AppMethodBeat.o(107998);
          return null;
        }
        paramAnonymouse = new r()
        {
          public final T1 a(com.google.a.d.a paramAnonymous2a)
          {
            AppMethodBeat.i(222815);
            paramAnonymous2a = n.28.this.bMO.a(paramAnonymous2a);
            if ((paramAnonymous2a != null) && (!paramAnonymouse.isInstance(paramAnonymous2a)))
            {
              paramAnonymous2a = new p("Expected a " + paramAnonymouse.getName() + " but was " + paramAnonymous2a.getClass().getName());
              AppMethodBeat.o(222815);
              throw paramAnonymous2a;
            }
            AppMethodBeat.o(222815);
            return paramAnonymous2a;
          }
          
          public final void a(com.google.a.d.c paramAnonymous2c, T1 paramAnonymous2T1)
          {
            AppMethodBeat.i(107994);
            n.28.this.bMO.a(paramAnonymous2c, paramAnonymous2T1);
            AppMethodBeat.o(107994);
          }
        };
        AppMethodBeat.o(107998);
        return paramAnonymouse;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(107999);
        String str = "Factory[typeHierarchy=" + this.bOm.getName() + ",adapter=" + paramr + "]";
        AppMethodBeat.o(107999);
        return str;
      }
    };
    AppMethodBeat.o(108052);
    return paramClass;
  }
  
  static final class a<T extends Enum<T>>
    extends r<T>
  {
    private final Map<String, T> bOp;
    private final Map<T, String> bOq;
    
    public a(Class<T> paramClass)
    {
      AppMethodBeat.i(108010);
      this.bOp = new HashMap();
      this.bOq = new HashMap();
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (com.google.a.a.c)paramClass.getField((String)localObject1).getAnnotation(com.google.a.a.c.class);
          if (localObject2 != null)
          {
            String str = ((com.google.a.a.c)localObject2).value();
            localObject2 = ((com.google.a.a.c)localObject2).zj();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.bOp.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.bOp.put(localObject1, localEnum);
          this.bOq.put(localEnum, localObject1);
          i += 1;
        }
        AppMethodBeat.o(108010);
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        paramClass = new AssertionError(paramClass);
        AppMethodBeat.o(108010);
        throw paramClass;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.n
 * JD-Core Version:    0.7.0.1
 */