package com.google.c.b.a;

import com.google.c.b.h;
import com.google.c.d.b;
import com.google.c.e;
import com.google.c.i;
import com.google.c.j;
import com.google.c.k;
import com.google.c.l;
import com.google.c.p;
import com.google.c.r;
import com.google.c.s;
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
  public static final r<Class> dGK;
  public static final s dGL;
  public static final r<BitSet> dGM;
  public static final s dGN;
  public static final r<Boolean> dGO;
  public static final r<Boolean> dGP;
  public static final s dGQ;
  public static final r<Number> dGR;
  public static final s dGS;
  public static final r<Number> dGT;
  public static final s dGU;
  public static final r<Number> dGV;
  public static final s dGW;
  public static final r<AtomicInteger> dGX;
  public static final s dGY;
  public static final r<AtomicBoolean> dGZ;
  public static final r<Currency> dHA;
  public static final s dHB;
  public static final s dHC;
  public static final r<Calendar> dHD;
  public static final s dHE;
  public static final r<Locale> dHF;
  public static final s dHG;
  public static final r<i> dHH;
  public static final s dHI;
  public static final s dHJ;
  public static final s dHa;
  public static final r<AtomicIntegerArray> dHb;
  public static final s dHc;
  public static final r<Number> dHd;
  public static final r<Number> dHe;
  public static final r<Number> dHf;
  public static final r<Number> dHg;
  public static final s dHh;
  public static final r<Character> dHi;
  public static final s dHj;
  public static final r<String> dHk;
  public static final r<BigDecimal> dHl;
  public static final r<BigInteger> dHm;
  public static final s dHn;
  public static final r<StringBuilder> dHo;
  public static final s dHp;
  public static final r<StringBuffer> dHq;
  public static final s dHr;
  public static final r<URL> dHs;
  public static final s dHt;
  public static final r<URI> dHu;
  public static final s dHv;
  public static final r<InetAddress> dHw;
  public static final s dHx;
  public static final r<UUID> dHy;
  public static final s dHz;
  
  static
  {
    AppMethodBeat.i(108053);
    dGK = new r() {}.YQ();
    dGL = a(Class.class, dGK);
    dGM = new r()
    {
      private static BitSet j(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208861);
        BitSet localBitSet = new BitSet();
        paramAnonymousa.Zd();
        Object localObject = paramAnonymousa.Zh();
        int i = 0;
        if (localObject != b.dIo)
        {
          boolean bool;
          switch (n.29.dGp[localObject.ordinal()])
          {
          default: 
            paramAnonymousa = new p("Invalid bitset value type: ".concat(String.valueOf(localObject)));
            AppMethodBeat.o(208861);
            throw paramAnonymousa;
          case 1: 
            if (paramAnonymousa.Zo() != 0) {
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
            localObject = paramAnonymousa.Zh();
            break;
            bool = false;
            continue;
            bool = paramAnonymousa.Zk();
            continue;
            localObject = paramAnonymousa.Zj();
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
              AppMethodBeat.o(208861);
              throw paramAnonymousa;
            }
          }
        }
        paramAnonymousa.Ze();
        AppMethodBeat.o(208861);
        return localBitSet;
      }
    }.YQ();
    dGN = a(BitSet.class, dGM);
    dGO = new r() {};
    dGP = new r() {};
    dGQ = a(Boolean.TYPE, Boolean.class, dGO);
    dGR = new r()
    {
      private static Number g(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208878);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208878);
          return null;
        }
        try
        {
          byte b = (byte)paramAnonymousa.Zo();
          AppMethodBeat.o(208878);
          return Byte.valueOf(b);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(208878);
          throw paramAnonymousa;
        }
      }
    };
    dGS = a(Byte.TYPE, Byte.class, dGR);
    dGT = new r()
    {
      private static Number g(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208873);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208873);
          return null;
        }
        try
        {
          short s = (short)paramAnonymousa.Zo();
          AppMethodBeat.o(208873);
          return Short.valueOf(s);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(208873);
          throw paramAnonymousa;
        }
      }
    };
    dGU = a(Short.TYPE, Short.class, dGT);
    dGV = new r()
    {
      private static Number g(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208883);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208883);
          return null;
        }
        try
        {
          int i = paramAnonymousa.Zo();
          AppMethodBeat.o(208883);
          return Integer.valueOf(i);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(208883);
          throw paramAnonymousa;
        }
      }
    };
    dGW = a(Integer.TYPE, Integer.class, dGV);
    dGX = new r()
    {
      private static AtomicInteger m(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208876);
        try
        {
          paramAnonymousa = new AtomicInteger(paramAnonymousa.Zo());
          AppMethodBeat.o(208876);
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(208876);
          throw paramAnonymousa;
        }
      }
    }.YQ();
    dGY = a(AtomicInteger.class, dGX);
    dGZ = new r() {}.YQ();
    dHa = a(AtomicBoolean.class, dGZ);
    dHb = new r()
    {
      private static AtomicIntegerArray f(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208833);
        ArrayList localArrayList = new ArrayList();
        paramAnonymousa.Zd();
        while (paramAnonymousa.hasNext()) {
          try
          {
            localArrayList.add(Integer.valueOf(paramAnonymousa.Zo()));
          }
          catch (NumberFormatException paramAnonymousa)
          {
            paramAnonymousa = new p(paramAnonymousa);
            AppMethodBeat.o(208833);
            throw paramAnonymousa;
          }
        }
        paramAnonymousa.Ze();
        int j = localArrayList.size();
        paramAnonymousa = new AtomicIntegerArray(j);
        int i = 0;
        while (i < j)
        {
          paramAnonymousa.set(i, ((Integer)localArrayList.get(i)).intValue());
          i += 1;
        }
        AppMethodBeat.o(208833);
        return paramAnonymousa;
      }
    }.YQ();
    dHc = a(AtomicIntegerArray.class, dHb);
    dHd = new r()
    {
      private static Number g(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208832);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208832);
          return null;
        }
        try
        {
          long l = paramAnonymousa.Zn();
          AppMethodBeat.o(208832);
          return Long.valueOf(l);
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(208832);
          throw paramAnonymousa;
        }
      }
    };
    dHe = new r() {};
    dHf = new r() {};
    dHg = new r() {};
    dHh = a(Number.class, dHg);
    dHi = new r() {};
    dHj = a(Character.TYPE, Character.class, dHi);
    dHk = new r() {};
    dHl = new r()
    {
      private static BigDecimal h(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208845);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208845);
          return null;
        }
        try
        {
          paramAnonymousa = new BigDecimal(paramAnonymousa.Zj());
          AppMethodBeat.o(208845);
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(208845);
          throw paramAnonymousa;
        }
      }
    };
    dHm = new r()
    {
      private static BigInteger i(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208905);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208905);
          return null;
        }
        try
        {
          paramAnonymousa = new BigInteger(paramAnonymousa.Zj());
          AppMethodBeat.o(208905);
          return paramAnonymousa;
        }
        catch (NumberFormatException paramAnonymousa)
        {
          paramAnonymousa = new p(paramAnonymousa);
          AppMethodBeat.o(208905);
          throw paramAnonymousa;
        }
      }
    };
    dHn = a(String.class, dHk);
    dHo = new r() {};
    dHp = a(StringBuilder.class, dHo);
    dHq = new r() {};
    dHr = a(StringBuffer.class, dHq);
    dHs = new r() {};
    dHt = a(URL.class, dHs);
    dHu = new r()
    {
      private static URI k(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208863);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208863);
          return null;
        }
        try
        {
          paramAnonymousa = paramAnonymousa.Zj();
          if ("null".equals(paramAnonymousa))
          {
            AppMethodBeat.o(208863);
            return null;
          }
        }
        catch (URISyntaxException paramAnonymousa)
        {
          paramAnonymousa = new j(paramAnonymousa);
          AppMethodBeat.o(208863);
          throw paramAnonymousa;
        }
        paramAnonymousa = new URI(paramAnonymousa);
        AppMethodBeat.o(208863);
        return paramAnonymousa;
      }
    };
    dHv = a(URI.class, dHu);
    dHw = new r() {};
    dHx = b(InetAddress.class, dHw);
    dHy = new r() {};
    dHz = a(UUID.class, dHy);
    dHA = new r() {}.YQ();
    dHB = a(Currency.class, dHA);
    dHC = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108058);
        if (paramAnonymousa.dIb != Timestamp.class)
        {
          AppMethodBeat.o(108058);
          return null;
        }
        paramAnonymouse = new r() {};
        AppMethodBeat.o(108058);
        return paramAnonymouse;
      }
    };
    dHD = new r() {};
    dHE = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        paramAnonymouse = paramAnonymousa.dIb;
        if ((paramAnonymouse == this.dHP) || (paramAnonymouse == this.dHQ)) {
          return this.dGt;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108020);
        String str = "Factory[type=" + this.dHP.getName() + "+" + this.dHQ.getName() + ",adapter=" + this.dGt + "]";
        AppMethodBeat.o(108020);
        return str;
      }
    };
    dHF = new r() {};
    dHG = a(Locale.class, dHF);
    dHH = new r()
    {
      private void a(com.google.c.d.c paramAnonymousc, i paramAnonymousi)
      {
        AppMethodBeat.i(108029);
        if ((paramAnonymousi == null) || ((paramAnonymousi instanceof k)))
        {
          paramAnonymousc.Zv();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousi instanceof com.google.c.n))
        {
          paramAnonymousi = paramAnonymousi.YO();
          if ((paramAnonymousi.value instanceof Number))
          {
            paramAnonymousc.a(paramAnonymousi.YK());
            AppMethodBeat.o(108029);
            return;
          }
          if ((paramAnonymousi.value instanceof Boolean))
          {
            paramAnonymousc.bW(paramAnonymousi.YM());
            AppMethodBeat.o(108029);
            return;
          }
          paramAnonymousc.dN(paramAnonymousi.YL());
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousi instanceof com.google.c.g))
        {
          paramAnonymousc.Zr();
          if ((paramAnonymousi instanceof com.google.c.g))
          {
            paramAnonymousi = ((com.google.c.g)paramAnonymousi).iterator();
            while (paramAnonymousi.hasNext()) {
              a(paramAnonymousc, (i)paramAnonymousi.next());
            }
          }
          paramAnonymousc = new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(paramAnonymousi)));
          AppMethodBeat.o(108029);
          throw paramAnonymousc;
          paramAnonymousc.Zs();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousi instanceof l))
        {
          paramAnonymousc.Zt();
          if ((paramAnonymousi instanceof l))
          {
            paramAnonymousi = ((l)paramAnonymousi).dEV.entrySet().iterator();
            while (paramAnonymousi.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousi.next();
              paramAnonymousc.dM((String)localEntry.getKey());
              a(paramAnonymousc, (i)localEntry.getValue());
            }
          }
          paramAnonymousc = new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(paramAnonymousi)));
          AppMethodBeat.o(108029);
          throw paramAnonymousc;
          paramAnonymousc.Zu();
          AppMethodBeat.o(108029);
          return;
        }
        paramAnonymousc = new IllegalArgumentException("Couldn't write " + paramAnonymousi.getClass());
        AppMethodBeat.o(108029);
        throw paramAnonymousc;
      }
      
      private i l(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208859);
        switch (n.29.dGp[paramAnonymousa.Zh().ordinal()])
        {
        default: 
          paramAnonymousa = new IllegalArgumentException();
          AppMethodBeat.o(208859);
          throw paramAnonymousa;
        case 3: 
          paramAnonymousa = new com.google.c.n(paramAnonymousa.Zj());
          AppMethodBeat.o(208859);
          return paramAnonymousa;
        case 1: 
          paramAnonymousa = new com.google.c.n(new com.google.c.b.g(paramAnonymousa.Zj()));
          AppMethodBeat.o(208859);
          return paramAnonymousa;
        case 2: 
          paramAnonymousa = new com.google.c.n(Boolean.valueOf(paramAnonymousa.Zk()));
          AppMethodBeat.o(208859);
          return paramAnonymousa;
        case 4: 
          paramAnonymousa.Zl();
          paramAnonymousa = k.dEU;
          AppMethodBeat.o(208859);
          return paramAnonymousa;
        case 5: 
          localObject = new com.google.c.g();
          paramAnonymousa.Zd();
          while (paramAnonymousa.hasNext()) {
            ((com.google.c.g)localObject).a(l(paramAnonymousa));
          }
          paramAnonymousa.Ze();
          AppMethodBeat.o(208859);
          return localObject;
        }
        Object localObject = new l();
        paramAnonymousa.Zf();
        while (paramAnonymousa.hasNext()) {
          ((l)localObject).a(paramAnonymousa.Zi(), l(paramAnonymousa));
        }
        paramAnonymousa.Zg();
        AppMethodBeat.o(208859);
        return localObject;
      }
    };
    dHI = b(i.class, dHH);
    dHJ = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108027);
        paramAnonymousa = paramAnonymousa.dIb;
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
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.dIb == this.dHM) {
          return paramr;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108026);
        String str = "Factory[type=" + this.dHM.getName() + ",adapter=" + paramr + "]";
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
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        paramAnonymouse = paramAnonymousa.dIb;
        if ((paramAnonymouse == this.dHN) || (paramAnonymouse == paramClass2)) {
          return paramr;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108018);
        String str = "Factory[type=" + paramClass2.getName() + "+" + this.dHN.getName() + ",adapter=" + paramr + "]";
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
      public final <T2> r<T2> a(final e paramAnonymouse, com.google.c.c.a<T2> paramAnonymousa)
      {
        AppMethodBeat.i(107998);
        paramAnonymouse = paramAnonymousa.dIb;
        if (!this.dHR.isAssignableFrom(paramAnonymouse))
        {
          AppMethodBeat.o(107998);
          return null;
        }
        paramAnonymouse = new r()
        {
          public final T1 a(com.google.c.d.a paramAnonymous2a)
          {
            AppMethodBeat.i(208844);
            paramAnonymous2a = n.28.this.dGt.a(paramAnonymous2a);
            if ((paramAnonymous2a != null) && (!paramAnonymouse.isInstance(paramAnonymous2a)))
            {
              paramAnonymous2a = new p("Expected a " + paramAnonymouse.getName() + " but was " + paramAnonymous2a.getClass().getName());
              AppMethodBeat.o(208844);
              throw paramAnonymous2a;
            }
            AppMethodBeat.o(208844);
            return paramAnonymous2a;
          }
          
          public final void a(com.google.c.d.c paramAnonymous2c, T1 paramAnonymous2T1)
          {
            AppMethodBeat.i(107994);
            n.28.this.dGt.a(paramAnonymous2c, paramAnonymous2T1);
            AppMethodBeat.o(107994);
          }
        };
        AppMethodBeat.o(107998);
        return paramAnonymouse;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(107999);
        String str = "Factory[typeHierarchy=" + this.dHR.getName() + ",adapter=" + paramr + "]";
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
    private final Map<String, T> dHU;
    private final Map<T, String> dHV;
    
    public a(Class<T> paramClass)
    {
      AppMethodBeat.i(108010);
      this.dHU = new HashMap();
      this.dHV = new HashMap();
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (com.google.c.a.c)paramClass.getField((String)localObject1).getAnnotation(com.google.c.a.c.class);
          if (localObject2 != null)
          {
            String str = ((com.google.c.a.c)localObject2).value();
            localObject2 = ((com.google.c.a.c)localObject2).YU();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.dHU.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.dHU.put(localObject1, localEnum);
          this.dHV.put(localEnum, localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.n
 * JD-Core Version:    0.7.0.1
 */