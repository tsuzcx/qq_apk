package com.google.a.b.a;

import com.google.a.a.c;
import com.google.a.b.g;
import com.google.a.f;
import com.google.a.i;
import com.google.a.k;
import com.google.a.n;
import com.google.a.p;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class m
{
  public static final t bPA;
  public static final s<Number> bPB;
  public static final s<Number> bPC;
  public static final s<Number> bPD;
  public static final s<Number> bPE;
  public static final t bPF;
  public static final s<Character> bPG;
  public static final t bPH;
  public static final s<String> bPI;
  public static final s<BigDecimal> bPJ;
  public static final s<BigInteger> bPK;
  public static final t bPL;
  public static final s<StringBuilder> bPM;
  public static final t bPN;
  public static final s<StringBuffer> bPO;
  public static final t bPP;
  public static final s<URL> bPQ;
  public static final t bPR;
  public static final s<URI> bPS;
  public static final t bPT;
  public static final s<InetAddress> bPU;
  public static final t bPV;
  public static final s<UUID> bPW;
  public static final t bPX;
  public static final s<Currency> bPY;
  public static final t bPZ;
  public static final s<Class> bPi;
  public static final t bPj;
  public static final s<BitSet> bPk;
  public static final t bPl;
  public static final s<Boolean> bPm;
  public static final s<Boolean> bPn;
  public static final t bPo;
  public static final s<Number> bPp;
  public static final t bPq;
  public static final s<Number> bPr;
  public static final t bPs;
  public static final s<Number> bPt;
  public static final t bPu;
  public static final s<AtomicInteger> bPv;
  public static final t bPw;
  public static final s<AtomicBoolean> bPx;
  public static final t bPy;
  public static final s<AtomicIntegerArray> bPz;
  public static final t bQa;
  public static final s<Calendar> bQb;
  public static final t bQc;
  public static final s<Locale> bQd;
  public static final t bQe;
  public static final s<k> bQf;
  public static final t bQg;
  public static final t bQh;
  
  static
  {
    AppMethodBeat.i(108053);
    bPi = new s() {}.yB();
    bPj = a(Class.class, bPi);
    bPk = new s() {}.yB();
    bPl = a(BitSet.class, bPk);
    bPm = new s() {};
    bPn = new s() {};
    bPo = a(Boolean.TYPE, Boolean.class, bPm);
    bPp = new s() {};
    bPq = a(Byte.TYPE, Byte.class, bPp);
    bPr = new s() {};
    bPs = a(Short.TYPE, Short.class, bPr);
    bPt = new s() {};
    bPu = a(Integer.TYPE, Integer.class, bPt);
    bPv = new s() {}.yB();
    bPw = a(AtomicInteger.class, bPv);
    bPx = new s() {}.yB();
    bPy = a(AtomicBoolean.class, bPx);
    bPz = new s() {}.yB();
    bPA = a(AtomicIntegerArray.class, bPz);
    bPB = new s() {};
    bPC = new s() {};
    bPD = new s() {};
    bPE = new s() {};
    bPF = a(Number.class, bPE);
    bPG = new s() {};
    bPH = a(Character.TYPE, Character.class, bPG);
    bPI = new s() {};
    bPJ = new s() {};
    bPK = new s() {};
    bPL = a(String.class, bPI);
    bPM = new s() {};
    bPN = a(StringBuilder.class, bPM);
    bPO = new s() {};
    bPP = a(StringBuffer.class, bPO);
    bPQ = new s() {};
    bPR = a(URL.class, bPQ);
    bPS = new s() {};
    bPT = a(URI.class, bPS);
    bPU = new s() {};
    bPV = b(InetAddress.class, bPU);
    bPW = new s() {};
    bPX = a(UUID.class, bPW);
    bPY = new s() {}.yB();
    bPZ = a(Currency.class, bPY);
    bQa = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108058);
        if (paramAnonymousa.bQy != Timestamp.class)
        {
          AppMethodBeat.o(108058);
          return null;
        }
        paramAnonymousf = new s() {};
        AppMethodBeat.o(108058);
        return paramAnonymousf;
      }
    };
    bQb = new s() {};
    bQc = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        paramAnonymousf = paramAnonymousa.bQy;
        if ((paramAnonymousf == this.bQn) || (paramAnonymousf == this.bQo)) {
          return this.bOR;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108020);
        String str = "Factory[type=" + this.bQn.getName() + "+" + this.bQo.getName() + ",adapter=" + this.bOR + "]";
        AppMethodBeat.o(108020);
        return str;
      }
    };
    bQd = new s() {};
    bQe = a(Locale.class, bQd);
    bQf = new s()
    {
      private void a(com.google.a.d.a paramAnonymousa, k paramAnonymousk)
      {
        AppMethodBeat.i(108029);
        if ((paramAnonymousk == null) || ((paramAnonymousk instanceof com.google.a.m)))
        {
          paramAnonymousa.yS();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof p))
        {
          paramAnonymousk = paramAnonymousk.yz();
          if ((paramAnonymousk.value instanceof Number))
          {
            paramAnonymousa.a(paramAnonymousk.yx());
            AppMethodBeat.o(108029);
            return;
          }
          if ((paramAnonymousk.value instanceof Boolean))
          {
            paramAnonymousa.bg(paramAnonymousk.getAsBoolean());
            AppMethodBeat.o(108029);
            return;
          }
          paramAnonymousa.ca(paramAnonymousk.yy());
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof i))
        {
          paramAnonymousa.yO();
          if ((paramAnonymousk instanceof i))
          {
            paramAnonymousk = ((i)paramAnonymousk).iterator();
            while (paramAnonymousk.hasNext()) {
              a(paramAnonymousa, (k)paramAnonymousk.next());
            }
          }
          paramAnonymousa = new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(paramAnonymousk)));
          AppMethodBeat.o(108029);
          throw paramAnonymousa;
          paramAnonymousa.yP();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof n))
        {
          paramAnonymousa.yQ();
          if ((paramAnonymousk instanceof n))
          {
            paramAnonymousk = ((n)paramAnonymousk).bNx.entrySet().iterator();
            while (paramAnonymousk.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousk.next();
              paramAnonymousa.bZ((String)localEntry.getKey());
              a(paramAnonymousa, (k)localEntry.getValue());
            }
          }
          paramAnonymousa = new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(paramAnonymousk)));
          AppMethodBeat.o(108029);
          throw paramAnonymousa;
          paramAnonymousa.yR();
          AppMethodBeat.o(108029);
          return;
        }
        paramAnonymousa = new IllegalArgumentException("Couldn't write " + paramAnonymousk.getClass());
        AppMethodBeat.o(108029);
        throw paramAnonymousa;
      }
    };
    bQg = b(k.class, bQf);
    bQh = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108027);
        paramAnonymousa = paramAnonymousa.bQy;
        if ((!Enum.class.isAssignableFrom(paramAnonymousa)) || (paramAnonymousa == Enum.class))
        {
          AppMethodBeat.o(108027);
          return null;
        }
        paramAnonymousf = paramAnonymousa;
        if (!paramAnonymousa.isEnum()) {
          paramAnonymousf = paramAnonymousa.getSuperclass();
        }
        paramAnonymousf = new m.a(paramAnonymousf);
        AppMethodBeat.o(108027);
        return paramAnonymousf;
      }
    };
    AppMethodBeat.o(108053);
  }
  
  public static <TT> t a(Class<TT> paramClass, final s<TT> params)
  {
    AppMethodBeat.i(108050);
    paramClass = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.bQy == this.bQk) {
          return params;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108026);
        String str = "Factory[type=" + this.bQk.getName() + ",adapter=" + params + "]";
        AppMethodBeat.o(108026);
        return str;
      }
    };
    AppMethodBeat.o(108050);
    return paramClass;
  }
  
  public static <TT> t a(Class<TT> paramClass1, final Class<TT> paramClass2, final s<? super TT> params)
  {
    AppMethodBeat.i(108051);
    paramClass1 = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        paramAnonymousf = paramAnonymousa.bQy;
        if ((paramAnonymousf == this.bQl) || (paramAnonymousf == paramClass2)) {
          return params;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108018);
        String str = "Factory[type=" + paramClass2.getName() + "+" + this.bQl.getName() + ",adapter=" + params + "]";
        AppMethodBeat.o(108018);
        return str;
      }
    };
    AppMethodBeat.o(108051);
    return paramClass1;
  }
  
  private static <T1> t b(Class<T1> paramClass, final s<T1> params)
  {
    AppMethodBeat.i(108052);
    paramClass = new t()
    {
      public final <T2> s<T2> a(final f paramAnonymousf, com.google.a.c.a<T2> paramAnonymousa)
      {
        AppMethodBeat.i(107998);
        paramAnonymousf = paramAnonymousa.bQy;
        if (!this.bQp.isAssignableFrom(paramAnonymousf))
        {
          AppMethodBeat.o(107998);
          return null;
        }
        paramAnonymousf = new s()
        {
          public final void a(com.google.a.d.a paramAnonymous2a, T1 paramAnonymous2T1)
          {
            AppMethodBeat.i(107994);
            m.28.this.bOR.a(paramAnonymous2a, paramAnonymous2T1);
            AppMethodBeat.o(107994);
          }
        };
        AppMethodBeat.o(107998);
        return paramAnonymousf;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(107999);
        String str = "Factory[typeHierarchy=" + this.bQp.getName() + ",adapter=" + params + "]";
        AppMethodBeat.o(107999);
        return str;
      }
    };
    AppMethodBeat.o(108052);
    return paramClass;
  }
  
  static final class a<T extends Enum<T>>
    extends s<T>
  {
    private final Map<String, T> bQs;
    private final Map<T, String> bQt;
    
    public a(Class<T> paramClass)
    {
      AppMethodBeat.i(108010);
      this.bQs = new HashMap();
      this.bQt = new HashMap();
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (c)paramClass.getField((String)localObject1).getAnnotation(c.class);
          if (localObject2 != null)
          {
            String str = ((c)localObject2).value();
            localObject2 = ((c)localObject2).yF();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.bQs.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.bQs.put(localObject1, localEnum);
          this.bQt.put(localEnum, localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */