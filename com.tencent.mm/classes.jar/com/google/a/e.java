package com.google.a;

import com.google.a.b.a.g;
import com.google.a.b.a.h;
import com.google.a.b.a.i;
import com.google.a.b.a.k;
import com.google.a.b.a.n;
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
  public static final com.google.a.c.a<?> bKN;
  public final ThreadLocal<Map<com.google.a.c.a<?>, a<?>>> bKO;
  public final Map<com.google.a.c.a<?>, r<?>> bKP;
  public final com.google.a.b.c bKQ;
  public final com.google.a.b.a.d bKR;
  public final List<s> bKS;
  public final com.google.a.b.d bKT;
  public final d bKU;
  public final Map<Type, f<?>> bKV;
  public final boolean bKW;
  public final boolean bKX;
  public final boolean bKY;
  public final boolean bKZ;
  public final boolean bLa;
  public final boolean bLb;
  public final boolean bLc;
  public final String bLd;
  public final int bLe;
  public final int bLf;
  public final q bLg;
  public final List<s> bLh;
  public final List<s> bLi;
  
  static
  {
    AppMethodBeat.i(107835);
    bKN = com.google.a.c.a.z(Object.class);
    AppMethodBeat.o(107835);
  }
  
  public e()
  {
    this(com.google.a.b.d.bLI, c.bKG, Collections.emptyMap(), q.bLp, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    AppMethodBeat.i(107826);
    AppMethodBeat.o(107826);
  }
  
  private e(com.google.a.b.d paramd, d paramd1, Map<Type, f<?>> paramMap, q paramq, List<s> paramList1, List<s> paramList2, List<s> paramList3)
  {
    AppMethodBeat.i(221930);
    this.bKO = new ThreadLocal();
    this.bKP = new ConcurrentHashMap();
    this.bKT = paramd;
    this.bKU = paramd1;
    this.bKV = paramMap;
    this.bKQ = new com.google.a.b.c(paramMap);
    this.bKW = false;
    this.bKX = false;
    this.bKY = false;
    this.bKZ = true;
    this.bLa = false;
    this.bLb = false;
    this.bLc = false;
    this.bLg = paramq;
    this.bLd = null;
    this.bLe = 2;
    this.bLf = 2;
    this.bLh = paramList1;
    this.bLi = paramList2;
    paramList1 = new ArrayList();
    paramList1.add(n.bOd);
    paramList1.add(h.bMt);
    paramList1.add(paramd);
    paramList1.addAll(paramList3);
    paramList1.add(n.bNI);
    paramList1.add(n.bNr);
    paramList1.add(n.bNl);
    paramList1.add(n.bNn);
    paramList1.add(n.bNp);
    if (paramq == q.bLp) {}
    for (paramMap = n.bNy;; paramMap = new r() {})
    {
      paramList1.add(n.a(Long.TYPE, Long.class, paramMap));
      paramList1.add(n.a(Double.TYPE, Double.class, new r() {}));
      paramList1.add(n.a(Float.TYPE, Float.class, new r() {}));
      paramList1.add(n.bNC);
      paramList1.add(n.bNt);
      paramList1.add(n.bNv);
      paramList1.add(n.a(AtomicLong.class, new r() {}.zf()));
      paramList1.add(n.a(AtomicLongArray.class, new r() {}.zf()));
      paramList1.add(n.bNx);
      paramList1.add(n.bNE);
      paramList1.add(n.bNK);
      paramList1.add(n.bNM);
      paramList1.add(n.a(BigDecimal.class, n.bNG));
      paramList1.add(n.a(BigInteger.class, n.bNH));
      paramList1.add(n.bNO);
      paramList1.add(n.bNQ);
      paramList1.add(n.bNU);
      paramList1.add(n.bNW);
      paramList1.add(n.bOb);
      paramList1.add(n.bNS);
      paramList1.add(n.bNi);
      paramList1.add(com.google.a.b.a.c.bMt);
      paramList1.add(n.bNZ);
      paramList1.add(k.bMt);
      paramList1.add(com.google.a.b.a.j.bMt);
      paramList1.add(n.bNX);
      paramList1.add(com.google.a.b.a.a.bMt);
      paramList1.add(n.bNg);
      paramList1.add(new com.google.a.b.a.b(this.bKQ));
      paramList1.add(new g(this.bKQ));
      this.bKR = new com.google.a.b.a.d(this.bKQ);
      paramList1.add(this.bKR);
      paramList1.add(n.bOe);
      paramList1.add(new i(this.bKQ, paramd1, paramd, this.bKR));
      this.bKS = Collections.unmodifiableList(paramList1);
      AppMethodBeat.o(221930);
      return;
    }
  }
  
  public static void a(Object paramObject, com.google.a.d.a parama)
  {
    AppMethodBeat.i(221948);
    if (paramObject != null) {}
    try
    {
      if (parama.zw() != com.google.a.d.b.bOR)
      {
        paramObject = new j("JSON document was not fully consumed.");
        AppMethodBeat.o(221948);
        throw paramObject;
      }
    }
    catch (com.google.a.d.d paramObject)
    {
      paramObject = new p(paramObject);
      AppMethodBeat.o(221948);
      throw paramObject;
      AppMethodBeat.o(221948);
      return;
    }
    catch (IOException paramObject)
    {
      paramObject = new j(paramObject);
      AppMethodBeat.o(221948);
      throw paramObject;
    }
  }
  
  static void e(double paramDouble)
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
  
  public final <T> r<T> a(com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107829);
    Object localObject2 = this.bKP;
    if (parama == null) {}
    for (Object localObject1 = bKN;; localObject1 = parama)
    {
      localObject1 = (r)((Map)localObject2).get(localObject1);
      if (localObject1 == null) {
        break;
      }
      AppMethodBeat.o(107829);
      return localObject1;
    }
    localObject1 = (Map)this.bKO.get();
    int i = 0;
    if (localObject1 == null)
    {
      localObject1 = new HashMap();
      this.bKO.set(localObject1);
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
        Iterator localIterator = this.bKS.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localr = ((s)localIterator.next()).a(this, parama);
        } while (localr == null);
        if (((a)localObject2).bLl != null)
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
          this.bKO.remove();
        }
        AppMethodBeat.o(107829);
      }
      localObject3.bLl = localr;
      this.bKP.put(parama, localr);
      ((Map)localObject1).remove(parama);
      if (i != 0) {
        this.bKO.remove();
      }
      AppMethodBeat.o(107829);
      return localr;
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("GSON (2.8.5) cannot handle ".concat(String.valueOf(parama)));
      AppMethodBeat.o(107829);
      throw localIllegalArgumentException;
    }
  }
  
  public final <T> r<T> a(s params, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107830);
    Object localObject1 = params;
    if (!this.bKS.contains(params)) {
      localObject1 = this.bKR;
    }
    params = this.bKS.iterator();
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
  public final <T> T a(com.google.a.d.a parama, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 482
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 483	com/google/a/d/a:bLb	Z
    //   12: istore 4
    //   14: aload_1
    //   15: iconst_1
    //   16: putfield 483	com/google/a/d/a:bLb	Z
    //   19: aload_1
    //   20: invokevirtual 353	com/google/a/d/a:zw	()Lcom/google/a/d/b;
    //   23: pop
    //   24: iconst_0
    //   25: istore_3
    //   26: aload_0
    //   27: aload_2
    //   28: invokestatic 487	com/google/a/c/a:h	(Ljava/lang/reflect/Type;)Lcom/google/a/c/a;
    //   31: invokevirtual 489	com/google/a/e:a	(Lcom/google/a/c/a;)Lcom/google/a/r;
    //   34: aload_1
    //   35: invokevirtual 492	com/google/a/r:a	(Lcom/google/a/d/a;)Ljava/lang/Object;
    //   38: astore_2
    //   39: aload_1
    //   40: iload 4
    //   42: putfield 483	com/google/a/d/a:bLb	Z
    //   45: ldc_w 482
    //   48: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: iload_3
    //   55: ifeq +17 -> 72
    //   58: aload_1
    //   59: iload 4
    //   61: putfield 483	com/google/a/d/a:bLb	Z
    //   64: ldc_w 482
    //   67: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: areturn
    //   72: new 368	com/google/a/p
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 371	com/google/a/p:<init>	(Ljava/lang/Throwable;)V
    //   80: astore_2
    //   81: ldc_w 482
    //   84: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_2
    //   88: athrow
    //   89: astore_2
    //   90: aload_1
    //   91: iload 4
    //   93: putfield 483	com/google/a/d/a:bLb	Z
    //   96: ldc_w 482
    //   99: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: new 368	com/google/a/p
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 371	com/google/a/p:<init>	(Ljava/lang/Throwable;)V
    //   113: astore_2
    //   114: ldc_w 482
    //   117: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: new 368	com/google/a/p
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 371	com/google/a/p:<init>	(Ljava/lang/Throwable;)V
    //   131: astore_2
    //   132: ldc_w 482
    //   135: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_2
    //   139: athrow
    //   140: astore_2
    //   141: new 449	java/lang/AssertionError
    //   144: dup
    //   145: new 386	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 494
    //   152: invokespecial 495	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_2
    //   156: invokevirtual 498	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 400	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: aload_2
    //   166: invokespecial 501	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: astore_2
    //   170: ldc_w 482
    //   173: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_2
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	e
    //   0	178	1	parama	com.google.a.d.a
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
  
  public final <T> r<T> q(Class<T> paramClass)
  {
    AppMethodBeat.i(107831);
    paramClass = a(com.google.a.c.a.z(paramClass));
    AppMethodBeat.o(107831);
    return paramClass;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107834);
    String str = "{serializeNulls:" + this.bKW + ",factories:" + this.bKS + ",instanceCreators:" + this.bKQ + "}";
    AppMethodBeat.o(107834);
    return str;
  }
  
  static final class a<T>
    extends r<T>
  {
    r<T> bLl;
    
    public final T a(com.google.a.d.a parama)
    {
      AppMethodBeat.i(221899);
      if (this.bLl == null)
      {
        parama = new IllegalStateException();
        AppMethodBeat.o(221899);
        throw parama;
      }
      parama = this.bLl.a(parama);
      AppMethodBeat.o(221899);
      return parama;
    }
    
    public final void a(com.google.a.d.c paramc, T paramT)
    {
      AppMethodBeat.i(107825);
      if (this.bLl == null)
      {
        paramc = new IllegalStateException();
        AppMethodBeat.o(107825);
        throw paramc;
      }
      this.bLl.a(paramc, paramT);
      AppMethodBeat.o(107825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.e
 * JD-Core Version:    0.7.0.1
 */