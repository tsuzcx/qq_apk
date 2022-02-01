package com.google.c;

import com.google.c.b.a.g;
import com.google.c.b.a.h;
import com.google.c.b.a.i;
import com.google.c.b.a.k;
import com.google.c.b.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class e
{
  public static final com.google.c.c.a<?> dEv;
  public final List<s> dEA;
  public final com.google.c.b.d dEB;
  public final d dEC;
  public final Map<Type, f<?>> dED;
  public final boolean dEE;
  public final boolean dEF;
  public final boolean dEG;
  public final boolean dEH;
  public final boolean dEI;
  public final boolean dEJ;
  public final boolean dEK;
  public final String dEL;
  public final int dEM;
  public final int dEN;
  public final q dEO;
  public final List<s> dEP;
  public final List<s> dEQ;
  public final ThreadLocal<Map<com.google.c.c.a<?>, a<?>>> dEw;
  public final Map<com.google.c.c.a<?>, r<?>> dEx;
  public final com.google.c.b.c dEy;
  public final com.google.c.b.a.d dEz;
  
  static
  {
    AppMethodBeat.i(107835);
    dEv = com.google.c.c.a.I(Object.class);
    AppMethodBeat.o(107835);
  }
  
  public e()
  {
    this(com.google.c.b.d.dFq, c.dEo, Collections.emptyMap(), q.dEX, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    AppMethodBeat.i(107826);
    AppMethodBeat.o(107826);
  }
  
  private e(com.google.c.b.d paramd, d paramd1, Map<Type, f<?>> paramMap, q paramq, List<s> paramList1, List<s> paramList2, List<s> paramList3)
  {
    AppMethodBeat.i(208794);
    this.dEw = new ThreadLocal();
    this.dEx = new ConcurrentHashMap();
    this.dEB = paramd;
    this.dEC = paramd1;
    this.dED = paramMap;
    this.dEy = new com.google.c.b.c(paramMap);
    this.dEE = false;
    this.dEF = false;
    this.dEG = false;
    this.dEH = true;
    this.dEI = false;
    this.dEJ = false;
    this.dEK = false;
    this.dEO = paramq;
    this.dEL = null;
    this.dEM = 2;
    this.dEN = 2;
    this.dEP = paramList1;
    this.dEQ = paramList2;
    paramList1 = new ArrayList();
    paramList1.add(n.dHI);
    paramList1.add(h.dFZ);
    paramList1.add(paramd);
    paramList1.addAll(paramList3);
    paramList1.add(n.dHn);
    paramList1.add(n.dGW);
    paramList1.add(n.dGQ);
    paramList1.add(n.dGS);
    paramList1.add(n.dGU);
    if (paramq == q.dEX) {}
    for (paramMap = n.dHd;; paramMap = new r() {})
    {
      paramList1.add(n.a(Long.TYPE, Long.class, paramMap));
      paramList1.add(n.a(Double.TYPE, Double.class, new r() {}));
      paramList1.add(n.a(Float.TYPE, Float.class, new r() {}));
      paramList1.add(n.dHh);
      paramList1.add(n.dGY);
      paramList1.add(n.dHa);
      paramList1.add(n.a(AtomicLong.class, new r() {}.YQ()));
      paramList1.add(n.a(AtomicLongArray.class, new r() {}.YQ()));
      paramList1.add(n.dHc);
      paramList1.add(n.dHj);
      paramList1.add(n.dHp);
      paramList1.add(n.dHr);
      paramList1.add(n.a(BigDecimal.class, n.dHl));
      paramList1.add(n.a(BigInteger.class, n.dHm));
      paramList1.add(n.dHt);
      paramList1.add(n.dHv);
      paramList1.add(n.dHz);
      paramList1.add(n.dHB);
      paramList1.add(n.dHG);
      paramList1.add(n.dHx);
      paramList1.add(n.dGN);
      paramList1.add(com.google.c.b.a.c.dFZ);
      paramList1.add(n.dHE);
      paramList1.add(k.dFZ);
      paramList1.add(com.google.c.b.a.j.dFZ);
      paramList1.add(n.dHC);
      paramList1.add(com.google.c.b.a.a.dFZ);
      paramList1.add(n.dGL);
      paramList1.add(new com.google.c.b.a.b(this.dEy));
      paramList1.add(new g(this.dEy));
      this.dEz = new com.google.c.b.a.d(this.dEy);
      paramList1.add(this.dEz);
      paramList1.add(n.dHJ);
      paramList1.add(new i(this.dEy, paramd1, paramd, this.dEz));
      this.dEA = Collections.unmodifiableList(paramList1);
      AppMethodBeat.o(208794);
      return;
    }
  }
  
  public static void a(Object paramObject, com.google.c.d.a parama)
  {
    AppMethodBeat.i(208796);
    if (paramObject != null) {}
    try
    {
      if (parama.Zh() != com.google.c.d.b.dIw)
      {
        paramObject = new j("JSON document was not fully consumed.");
        AppMethodBeat.o(208796);
        throw paramObject;
      }
    }
    catch (com.google.c.d.d paramObject)
    {
      paramObject = new p(paramObject);
      AppMethodBeat.o(208796);
      throw paramObject;
      AppMethodBeat.o(208796);
      return;
    }
    catch (IOException paramObject)
    {
      paramObject = new j(paramObject);
      AppMethodBeat.o(208796);
      throw paramObject;
    }
  }
  
  static void t(double paramDouble)
  {
    AppMethodBeat.i(107828);
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
      AppMethodBeat.o(107828);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(107828);
  }
  
  public final <T> r<T> a(com.google.c.c.a<T> parama)
  {
    AppMethodBeat.i(107829);
    Object localObject2 = this.dEx;
    if (parama == null) {}
    for (Object localObject1 = dEv;; localObject1 = parama)
    {
      localObject1 = (r)((Map)localObject2).get(localObject1);
      if (localObject1 == null) {
        break;
      }
      AppMethodBeat.o(107829);
      return localObject1;
    }
    localObject1 = (Map)this.dEw.get();
    int i = 0;
    if (localObject1 == null)
    {
      localObject1 = new HashMap();
      this.dEw.set(localObject1);
      i = 1;
    }
    for (;;)
    {
      localObject2 = (a)((Map)localObject1).get(parama);
      if (localObject2 != null)
      {
        AppMethodBeat.o(107829);
        return localObject2;
      }
      r localr;
      try
      {
        localObject2 = new a();
        ((Map)localObject1).put(parama, localObject2);
        Iterator localIterator = this.dEA.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localr = ((s)localIterator.next()).a(this, parama);
        } while (localr == null);
        if (((a)localObject2).dET != null)
        {
          localObject2 = new AssertionError();
          AppMethodBeat.o(107829);
          throw ((Throwable)localObject2);
        }
      }
      finally
      {
        ((Map)localObject1).remove(parama);
        if (i != 0) {
          this.dEw.remove();
        }
        AppMethodBeat.o(107829);
      }
      localObject3.dET = localr;
      this.dEx.put(parama, localr);
      ((Map)localObject1).remove(parama);
      if (i != 0) {
        this.dEw.remove();
      }
      AppMethodBeat.o(107829);
      return localr;
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("GSON (2.8.5) cannot handle ".concat(String.valueOf(parama)));
      AppMethodBeat.o(107829);
      throw localIllegalArgumentException;
    }
  }
  
  public final <T> r<T> a(s params, com.google.c.c.a<T> parama)
  {
    AppMethodBeat.i(107830);
    Object localObject1 = params;
    if (!this.dEA.contains(params)) {
      localObject1 = this.dEz;
    }
    params = this.dEA.iterator();
    int i = 0;
    while (params.hasNext())
    {
      Object localObject2 = (s)params.next();
      if (i == 0)
      {
        if (localObject2 == localObject1) {
          i = 1;
        }
      }
      else
      {
        localObject2 = ((s)localObject2).a(this, parama);
        if (localObject2 != null)
        {
          AppMethodBeat.o(107830);
          return localObject2;
        }
      }
    }
    params = new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(parama)));
    AppMethodBeat.o(107830);
    throw params;
  }
  
  /* Error */
  public final <T> T a(com.google.c.d.a parama, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 481
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 482	com/google/c/d/a:dEJ	Z
    //   12: istore 4
    //   14: aload_1
    //   15: iconst_1
    //   16: putfield 482	com/google/c/d/a:dEJ	Z
    //   19: aload_1
    //   20: invokevirtual 352	com/google/c/d/a:Zh	()Lcom/google/c/d/b;
    //   23: pop
    //   24: iconst_0
    //   25: istore_3
    //   26: aload_0
    //   27: aload_2
    //   28: invokestatic 486	com/google/c/c/a:h	(Ljava/lang/reflect/Type;)Lcom/google/c/c/a;
    //   31: invokevirtual 488	com/google/c/e:a	(Lcom/google/c/c/a;)Lcom/google/c/r;
    //   34: aload_1
    //   35: invokevirtual 491	com/google/c/r:a	(Lcom/google/c/d/a;)Ljava/lang/Object;
    //   38: astore_2
    //   39: aload_1
    //   40: iload 4
    //   42: putfield 482	com/google/c/d/a:dEJ	Z
    //   45: ldc_w 481
    //   48: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: iload_3
    //   55: ifeq +17 -> 72
    //   58: aload_1
    //   59: iload 4
    //   61: putfield 482	com/google/c/d/a:dEJ	Z
    //   64: ldc_w 481
    //   67: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: areturn
    //   72: new 367	com/google/c/p
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 370	com/google/c/p:<init>	(Ljava/lang/Throwable;)V
    //   80: astore_2
    //   81: ldc_w 481
    //   84: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_2
    //   88: athrow
    //   89: astore_2
    //   90: aload_1
    //   91: iload 4
    //   93: putfield 482	com/google/c/d/a:dEJ	Z
    //   96: ldc_w 481
    //   99: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: new 367	com/google/c/p
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 370	com/google/c/p:<init>	(Ljava/lang/Throwable;)V
    //   113: astore_2
    //   114: ldc_w 481
    //   117: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: new 367	com/google/c/p
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 370	com/google/c/p:<init>	(Ljava/lang/Throwable;)V
    //   131: astore_2
    //   132: ldc_w 481
    //   135: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_2
    //   139: athrow
    //   140: astore_2
    //   141: new 448	java/lang/AssertionError
    //   144: dup
    //   145: new 385	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 493
    //   152: invokespecial 494	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_2
    //   156: invokevirtual 497	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: aload_2
    //   166: invokespecial 500	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: astore_2
    //   170: ldc_w 481
    //   173: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_2
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	e
    //   0	178	1	parama	com.google.c.d.a
    //   0	178	2	paramType	Type
    //   1	54	3	i	int
    //   12	80	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	24	53	java/io/EOFException
    //   26	39	53	java/io/EOFException
    //   19	24	89	finally
    //   26	39	89	finally
    //   72	89	89	finally
    //   105	122	89	finally
    //   123	140	89	finally
    //   141	178	89	finally
    //   19	24	104	java/lang/IllegalStateException
    //   26	39	104	java/lang/IllegalStateException
    //   19	24	122	java/io/IOException
    //   26	39	122	java/io/IOException
    //   19	24	140	java/lang/AssertionError
    //   26	39	140	java/lang/AssertionError
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107834);
    String str = "{serializeNulls:" + this.dEE + ",factories:" + this.dEA + ",instanceCreators:" + this.dEy + "}";
    AppMethodBeat.o(107834);
    return str;
  }
  
  public final <T> r<T> z(Class<T> paramClass)
  {
    AppMethodBeat.i(107831);
    paramClass = a(com.google.c.c.a.I(paramClass));
    AppMethodBeat.o(107831);
    return paramClass;
  }
  
  static final class a<T>
    extends r<T>
  {
    r<T> dET;
    
    public final T a(com.google.c.d.a parama)
    {
      AppMethodBeat.i(208785);
      if (this.dET == null)
      {
        parama = new IllegalStateException();
        AppMethodBeat.o(208785);
        throw parama;
      }
      parama = this.dET.a(parama);
      AppMethodBeat.o(208785);
      return parama;
    }
    
    public final void a(com.google.c.d.c paramc, T paramT)
    {
      AppMethodBeat.i(107825);
      if (this.dET == null)
      {
        paramc = new IllegalStateException();
        AppMethodBeat.o(107825);
        throw paramc;
      }
      this.dET.a(paramc, paramT);
      AppMethodBeat.o(107825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.e
 * JD-Core Version:    0.7.0.1
 */