package com.google.a.b.a;

import com.google.a.b.g;
import com.google.a.f;
import com.google.a.i;
import com.google.a.k;
import com.google.a.n;
import com.google.a.p;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class m
{
  public static final t bHA;
  public static final s<AtomicBoolean> bHB;
  public static final t bHC;
  public static final s<AtomicIntegerArray> bHD;
  public static final t bHE;
  public static final s<Number> bHF;
  public static final s<Number> bHG;
  public static final s<Number> bHH;
  public static final s<Number> bHI;
  public static final t bHJ;
  public static final s<Character> bHK;
  public static final t bHL;
  public static final s<String> bHM;
  public static final s<BigDecimal> bHN;
  public static final s<BigInteger> bHO;
  public static final t bHP;
  public static final s<StringBuilder> bHQ;
  public static final t bHR;
  public static final s<StringBuffer> bHS;
  public static final t bHT;
  public static final s<URL> bHU;
  public static final t bHV;
  public static final s<URI> bHW;
  public static final t bHX;
  public static final s<InetAddress> bHY;
  public static final t bHZ;
  public static final s<Class> bHm;
  public static final t bHn;
  public static final s<BitSet> bHo;
  public static final t bHp;
  public static final s<Boolean> bHq;
  public static final s<Boolean> bHr;
  public static final t bHs;
  public static final s<Number> bHt;
  public static final t bHu;
  public static final s<Number> bHv;
  public static final t bHw;
  public static final s<Number> bHx;
  public static final t bHy;
  public static final s<AtomicInteger> bHz;
  public static final s<UUID> bIa;
  public static final t bIb;
  public static final s<Currency> bIc;
  public static final t bId;
  public static final t bIe;
  public static final s<Calendar> bIf;
  public static final t bIg;
  public static final s<Locale> bIh;
  public static final t bIi;
  public static final s<k> bIj;
  public static final t bIk;
  public static final t bIl;
  
  static
  {
    AppMethodBeat.i(108053);
    bHm = new m.1().xr();
    bHn = a(Class.class, bHm);
    bHo = new s() {}.xr();
    bHp = a(BitSet.class, bHo);
    bHq = new s() {};
    bHr = new s() {};
    bHs = a(Boolean.TYPE, Boolean.class, bHq);
    bHt = new s() {};
    bHu = a(Byte.TYPE, Byte.class, bHt);
    bHv = new s() {};
    bHw = a(Short.TYPE, Short.class, bHv);
    bHx = new s() {};
    bHy = a(Integer.TYPE, Integer.class, bHx);
    bHz = new s() {}.xr();
    bHA = a(AtomicInteger.class, bHz);
    bHB = new s() {}.xr();
    bHC = a(AtomicBoolean.class, bHB);
    bHD = new s() {}.xr();
    bHE = a(AtomicIntegerArray.class, bHD);
    bHF = new s() {};
    bHG = new s() {};
    bHH = new s() {};
    bHI = new s() {};
    bHJ = a(Number.class, bHI);
    bHK = new m.7();
    bHL = a(Character.TYPE, Character.class, bHK);
    bHM = new m.8();
    bHN = new s() {};
    bHO = new s() {};
    bHP = a(String.class, bHM);
    bHQ = new m.11();
    bHR = a(StringBuilder.class, bHQ);
    bHS = new m.13();
    bHT = a(StringBuffer.class, bHS);
    bHU = new m.14();
    bHV = a(URL.class, bHU);
    bHW = new m.15();
    bHX = a(URI.class, bHW);
    bHY = new m.16();
    bHZ = b(InetAddress.class, bHY);
    bIa = new m.17();
    bIb = a(UUID.class, bIa);
    bIc = new m.18().xr();
    bId = a(Currency.class, bIc);
    bIe = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108058);
        if (paramAnonymousa.bIC != Timestamp.class)
        {
          AppMethodBeat.o(108058);
          return null;
        }
        paramAnonymousf = new s() {};
        AppMethodBeat.o(108058);
        return paramAnonymousf;
      }
    };
    bIf = new s() {};
    bIg = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        paramAnonymousf = paramAnonymousa.bIC;
        if ((paramAnonymousf == this.bIr) || (paramAnonymousf == this.bIs)) {
          return this.bGV;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108020);
        String str = "Factory[type=" + this.bIr.getName() + "+" + this.bIs.getName() + ",adapter=" + this.bGV + "]";
        AppMethodBeat.o(108020);
        return str;
      }
    };
    bIh = new m.21();
    bIi = a(Locale.class, bIh);
    bIj = new s()
    {
      private void a(com.google.a.d.a paramAnonymousa, k paramAnonymousk)
      {
        AppMethodBeat.i(108029);
        if ((paramAnonymousk == null) || ((paramAnonymousk instanceof com.google.a.m)))
        {
          paramAnonymousa.xI();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof p))
        {
          paramAnonymousk = paramAnonymousk.xp();
          if ((paramAnonymousk.value instanceof Number))
          {
            paramAnonymousa.a(paramAnonymousk.xn());
            AppMethodBeat.o(108029);
            return;
          }
          if ((paramAnonymousk.value instanceof Boolean))
          {
            paramAnonymousa.bg(paramAnonymousk.getAsBoolean());
            AppMethodBeat.o(108029);
            return;
          }
          paramAnonymousa.bq(paramAnonymousk.xo());
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof i))
        {
          paramAnonymousa.xE();
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
          paramAnonymousa.xF();
          AppMethodBeat.o(108029);
          return;
        }
        if ((paramAnonymousk instanceof n))
        {
          paramAnonymousa.xG();
          if ((paramAnonymousk instanceof n))
          {
            paramAnonymousk = ((n)paramAnonymousk).bFB.entrySet().iterator();
            while (paramAnonymousk.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousk.next();
              paramAnonymousa.bp((String)localEntry.getKey());
              a(paramAnonymousa, (k)localEntry.getValue());
            }
          }
          paramAnonymousa = new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(paramAnonymousk)));
          AppMethodBeat.o(108029);
          throw paramAnonymousa;
          paramAnonymousa.xH();
          AppMethodBeat.o(108029);
          return;
        }
        paramAnonymousa = new IllegalArgumentException("Couldn't write " + paramAnonymousk.getClass());
        AppMethodBeat.o(108029);
        throw paramAnonymousa;
      }
    };
    bIk = b(k.class, bIj);
    bIl = new m.24();
    AppMethodBeat.o(108053);
  }
  
  public static <TT> t a(Class<TT> paramClass, final s<TT> params)
  {
    AppMethodBeat.i(108050);
    paramClass = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.bIC == this.bIo) {
          return params;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108026);
        String str = "Factory[type=" + this.bIo.getName() + ",adapter=" + params + "]";
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
        paramAnonymousf = paramAnonymousa.bIC;
        if ((paramAnonymousf == this.bIp) || (paramAnonymousf == paramClass2)) {
          return params;
        }
        return null;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(108018);
        String str = "Factory[type=" + paramClass2.getName() + "+" + this.bIp.getName() + ",adapter=" + params + "]";
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
        paramAnonymousf = paramAnonymousa.bIC;
        if (!this.bIt.isAssignableFrom(paramAnonymousf))
        {
          AppMethodBeat.o(107998);
          return null;
        }
        paramAnonymousf = new s()
        {
          public final void a(com.google.a.d.a paramAnonymous2a, T1 paramAnonymous2T1)
          {
            AppMethodBeat.i(107994);
            m.28.this.bGV.a(paramAnonymous2a, paramAnonymous2T1);
            AppMethodBeat.o(107994);
          }
        };
        AppMethodBeat.o(107998);
        return paramAnonymousf;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(107999);
        String str = "Factory[typeHierarchy=" + this.bIt.getName() + ",adapter=" + params + "]";
        AppMethodBeat.o(107999);
        return str;
      }
    };
    AppMethodBeat.o(108052);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */