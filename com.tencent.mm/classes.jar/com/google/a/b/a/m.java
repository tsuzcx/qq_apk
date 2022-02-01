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
  public static final s<Class> bEU;
  public static final t bEV;
  public static final s<BitSet> bEW;
  public static final t bEX;
  public static final s<Boolean> bEY;
  public static final s<Boolean> bEZ;
  public static final s<StringBuffer> bFA;
  public static final t bFB;
  public static final s<URL> bFC;
  public static final t bFD;
  public static final s<URI> bFE;
  public static final t bFF;
  public static final s<InetAddress> bFG;
  public static final t bFH;
  public static final s<UUID> bFI;
  public static final t bFJ;
  public static final s<Currency> bFK;
  public static final t bFL;
  public static final t bFM;
  public static final s<Calendar> bFN;
  public static final t bFO;
  public static final s<Locale> bFP;
  public static final t bFQ;
  public static final s<k> bFR;
  public static final t bFS;
  public static final t bFT;
  public static final t bFa;
  public static final s<Number> bFb;
  public static final t bFc;
  public static final s<Number> bFd;
  public static final t bFe;
  public static final s<Number> bFf;
  public static final t bFg;
  public static final s<AtomicInteger> bFh;
  public static final t bFi;
  public static final s<AtomicBoolean> bFj;
  public static final t bFk;
  public static final s<AtomicIntegerArray> bFl;
  public static final t bFm;
  public static final s<Number> bFn;
  public static final s<Number> bFo;
  public static final s<Number> bFp;
  public static final s<Number> bFq;
  public static final t bFr;
  public static final s<Character> bFs;
  public static final t bFt;
  public static final s<String> bFu;
  public static final s<BigDecimal> bFv;
  public static final s<BigInteger> bFw;
  public static final t bFx;
  public static final s<StringBuilder> bFy;
  public static final t bFz;
  
  static
  {
    AppMethodBeat.i(108053);
    bEU = new s() {}.xe();
    bEV = a(Class.class, bEU);
    bEW = new s() {}.xe();
    bEX = a(BitSet.class, bEW);
    bEY = new s() {};
    bEZ = new s() {};
    bFa = a(Boolean.TYPE, Boolean.class, bEY);
    bFb = new s() {};
    bFc = a(Byte.TYPE, Byte.class, bFb);
    bFd = new s() {};
    bFe = a(Short.TYPE, Short.class, bFd);
    bFf = new s() {};
    bFg = a(Integer.TYPE, Integer.class, bFf);
    bFh = new s() {}.xe();
    bFi = a(AtomicInteger.class, bFh);
    bFj = new s() {}.xe();
    bFk = a(AtomicBoolean.class, bFj);
    bFl = new s() {}.xe();
    bFm = a(AtomicIntegerArray.class, bFl);
    bFn = new s() {};
    bFo = new s() {};
    bFp = new s() {};
    bFq = new s() {};
    bFr = a(Number.class, bFq);
    bFs = new s() {};
    bFt = a(Character.TYPE, Character.class, bFs);
    bFu = new s() {};
    bFv = new s() {};
    bFw = new s() {};
    bFx = a(String.class, bFu);
    bFy = new s() {};
    bFz = a(StringBuilder.class, bFy);
    bFA = new s() {};
    bFB = a(StringBuffer.class, bFA);
    bFC = new s() {};
    bFD = a(URL.class, bFC);
    bFE = new s() {};
    bFF = a(URI.class, bFE);
    bFG = new s() {};
    bFH = b(InetAddress.class, bFG);
    bFI = new s() {};
    bFJ = a(UUID.class, bFI);
    bFK = new s() {}.xe();
    bFL = a(Currency.class, bFK);
    bFM = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108058);
        if (paramAnonymousa.bGk != Timestamp.class)
        {
          AppMethodBeat.o(108058);
          return null;
        }
        paramAnonymousf = new s() {};
        AppMethodBeat.o(108058);
        return paramAnonymousf;
      }
    };
    bFN = new s() {};
    bFO = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        paramAnonymousf = paramAnonymousa.bGk;
        if ((paramAnonymousf == this.bFZ) || (paramAnonymousf == this.bGa)) {
          return this.bED;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108020);
        String str = "Factory[type=" + this.bFZ.getName() + "+" + this.bGa.getName() + ",adapter=" + this.bED + "]";
        AppMethodBeat.o(108020);
        return str;
      }
    };
    bFP = new s() {};
    bFQ = a(Locale.class, bFP);
    bFR = new s()
    {
      private void a(com.google.a.d.a paramAnonymousa, k paramAnonymousk)
      {
        AppMethodBeat.i(108029);
        if ((paramAnonymousk == null) || ((paramAnonymousk instanceof com.google.a.m)))
        {
          paramAnonymousa.xv();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof p))
        {
          paramAnonymousk = paramAnonymousk.xc();
          if ((paramAnonymousk.value instanceof Number))
          {
            paramAnonymousa.a(paramAnonymousk.xa());
            AppMethodBeat.o(108029);
            return;
          }
          if ((paramAnonymousk.value instanceof Boolean))
          {
            paramAnonymousa.bf(paramAnonymousk.getAsBoolean());
            AppMethodBeat.o(108029);
            return;
          }
          paramAnonymousa.bh(paramAnonymousk.xb());
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof i))
        {
          paramAnonymousa.xr();
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
          paramAnonymousa.xs();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof n))
        {
          paramAnonymousa.xt();
          if ((paramAnonymousk instanceof n))
          {
            paramAnonymousk = ((n)paramAnonymousk).bDj.entrySet().iterator();
            while (paramAnonymousk.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousk.next();
              paramAnonymousa.bg((String)localEntry.getKey());
              a(paramAnonymousa, (k)localEntry.getValue());
            }
          }
          paramAnonymousa = new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(paramAnonymousk)));
          AppMethodBeat.o(108029);
          throw paramAnonymousa;
          paramAnonymousa.xu();
          AppMethodBeat.o(108029);
          return;
        }
        paramAnonymousa = new IllegalArgumentException("Couldn't write " + paramAnonymousk.getClass());
        AppMethodBeat.o(108029);
        throw paramAnonymousa;
      }
    };
    bFS = b(k.class, bFR);
    bFT = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108027);
        paramAnonymousa = paramAnonymousa.bGk;
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
        if (paramAnonymousa.bGk == this.bFW) {
          return params;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108026);
        String str = "Factory[type=" + this.bFW.getName() + ",adapter=" + params + "]";
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
        paramAnonymousf = paramAnonymousa.bGk;
        if ((paramAnonymousf == this.bFX) || (paramAnonymousf == paramClass2)) {
          return params;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108018);
        String str = "Factory[type=" + paramClass2.getName() + "+" + this.bFX.getName() + ",adapter=" + params + "]";
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
        paramAnonymousf = paramAnonymousa.bGk;
        if (!this.bGb.isAssignableFrom(paramAnonymousf))
        {
          AppMethodBeat.o(107998);
          return null;
        }
        paramAnonymousf = new s()
        {
          public final void a(com.google.a.d.a paramAnonymous2a, T1 paramAnonymous2T1)
          {
            AppMethodBeat.i(107994);
            m.28.this.bED.a(paramAnonymous2a, paramAnonymous2T1);
            AppMethodBeat.o(107994);
          }
        };
        AppMethodBeat.o(107998);
        return paramAnonymousf;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(107999);
        String str = "Factory[typeHierarchy=" + this.bGb.getName() + ",adapter=" + params + "]";
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
    private final Map<String, T> bGe;
    private final Map<T, String> bGf;
    
    public a(Class<T> paramClass)
    {
      AppMethodBeat.i(108010);
      this.bGe = new HashMap();
      this.bGf = new HashMap();
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
            localObject2 = ((c)localObject2).xi();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.bGe.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.bGe.put(localObject1, localEnum);
          this.bGf.put(localEnum, localObject1);
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