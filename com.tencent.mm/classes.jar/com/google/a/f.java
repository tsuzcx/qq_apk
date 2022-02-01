package com.google.a;

import com.google.a.b.a.b;
import com.google.a.b.a.g;
import com.google.a.b.a.i;
import com.google.a.b.a.j;
import com.google.a.b.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
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

public final class f
{
  private static final com.google.a.c.a<?> bEY;
  private final ThreadLocal<Map<com.google.a.c.a<?>, a<?>>> bEZ;
  private final Map<com.google.a.c.a<?>, s<?>> bFa;
  private final com.google.a.b.c bFb;
  private final com.google.a.b.a.d bFc;
  final List<t> bFd;
  final com.google.a.b.d bFe;
  final e bFf;
  final Map<Type, h<?>> bFg;
  final boolean bFh;
  final boolean bFi;
  final boolean bFj;
  final boolean bFk;
  final boolean bFl;
  final boolean bFm;
  final boolean bFn;
  final String bFo;
  final int bFp;
  final int bFq;
  final r bFr;
  final List<t> bFs;
  final List<t> bFt;
  
  static
  {
    AppMethodBeat.i(107835);
    bEY = com.google.a.c.a.J(Object.class);
    AppMethodBeat.o(107835);
  }
  
  public f()
  {
    this(com.google.a.b.d.bFW, d.bER, Collections.emptyMap(), false, false, false, true, false, false, false, r.bFD, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    AppMethodBeat.i(107826);
    AppMethodBeat.o(107826);
  }
  
  f(com.google.a.b.d paramd, e parame, Map<Type, h<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, r paramr, String paramString, int paramInt1, int paramInt2, List<t> paramList1, List<t> paramList2, List<t> paramList3)
  {
    AppMethodBeat.i(107827);
    this.bEZ = new ThreadLocal();
    this.bFa = new ConcurrentHashMap();
    this.bFe = paramd;
    this.bFf = parame;
    this.bFg = paramMap;
    this.bFb = new com.google.a.b.c(paramMap);
    this.bFh = paramBoolean1;
    this.bFi = paramBoolean2;
    this.bFj = paramBoolean3;
    this.bFk = paramBoolean4;
    this.bFl = paramBoolean5;
    this.bFm = paramBoolean6;
    this.bFn = paramBoolean7;
    this.bFr = paramr;
    this.bFo = paramString;
    this.bFp = paramInt1;
    this.bFq = paramInt2;
    this.bFs = paramList1;
    this.bFt = paramList2;
    paramString = new ArrayList();
    paramString.add(m.bIk);
    paramString.add(g.bGF);
    paramString.add(paramd);
    paramString.addAll(paramList3);
    paramString.add(m.bHP);
    paramString.add(m.bHy);
    paramString.add(m.bHs);
    paramString.add(m.bHu);
    paramString.add(m.bHw);
    if (paramr == r.bFD)
    {
      paramMap = m.bHF;
      paramString.add(m.a(Long.TYPE, Long.class, paramMap));
      paramList1 = Double.TYPE;
      if (!paramBoolean7) {
        break label776;
      }
      paramr = m.bHH;
      label285:
      paramString.add(m.a(paramList1, Double.class, paramr));
      paramList1 = Float.TYPE;
      if (!paramBoolean7) {
        break label789;
      }
    }
    label776:
    label789:
    for (paramr = m.bHG;; paramr = new s() {})
    {
      paramString.add(m.a(paramList1, Float.class, paramr));
      paramString.add(m.bHJ);
      paramString.add(m.bHA);
      paramString.add(m.bHC);
      paramString.add(m.a(AtomicLong.class, new s() {}.xr()));
      paramString.add(m.a(AtomicLongArray.class, new s() {}.xr()));
      paramString.add(m.bHE);
      paramString.add(m.bHL);
      paramString.add(m.bHR);
      paramString.add(m.bHT);
      paramString.add(m.a(BigDecimal.class, m.bHN));
      paramString.add(m.a(BigInteger.class, m.bHO));
      paramString.add(m.bHV);
      paramString.add(m.bHX);
      paramString.add(m.bIb);
      paramString.add(m.bId);
      paramString.add(m.bIi);
      paramString.add(m.bHZ);
      paramString.add(m.bHp);
      paramString.add(com.google.a.b.a.c.bGF);
      paramString.add(m.bIg);
      paramString.add(j.bGF);
      paramString.add(i.bGF);
      paramString.add(m.bIe);
      paramString.add(com.google.a.b.a.a.bGF);
      paramString.add(m.bHn);
      paramString.add(new b(this.bFb));
      paramString.add(new com.google.a.b.a.f(this.bFb, paramBoolean2));
      this.bFc = new com.google.a.b.a.d(this.bFb);
      paramString.add(this.bFc);
      paramString.add(m.bIl);
      paramString.add(new com.google.a.b.a.h(this.bFb, parame, paramd, this.bFc));
      this.bFd = Collections.unmodifiableList(paramString);
      AppMethodBeat.o(107827);
      return;
      paramMap = new s() {};
      break;
      paramr = new s() {};
      break label285;
    }
  }
  
  private com.google.a.d.a b(Writer paramWriter)
  {
    AppMethodBeat.i(107833);
    if (this.bFj) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new com.google.a.d.a(paramWriter);
    if (this.bFl) {
      paramWriter.setIndent("  ");
    }
    paramWriter.bFh = this.bFh;
    AppMethodBeat.o(107833);
    return paramWriter;
  }
  
  static void f(double paramDouble)
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
  
  public final <T> s<T> B(Class<T> paramClass)
  {
    AppMethodBeat.i(107831);
    paramClass = a(com.google.a.c.a.J(paramClass));
    AppMethodBeat.o(107831);
    return paramClass;
  }
  
  public final <T> s<T> a(com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107829);
    Object localObject2 = this.bFa;
    if (parama == null) {}
    for (Object localObject1 = bEY;; localObject1 = parama)
    {
      localObject1 = (s)((Map)localObject2).get(localObject1);
      if (localObject1 == null) {
        break;
      }
      AppMethodBeat.o(107829);
      return localObject1;
    }
    localObject1 = (Map)this.bEZ.get();
    int i = 0;
    if (localObject1 == null)
    {
      localObject1 = new HashMap();
      this.bEZ.set(localObject1);
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
      s locals;
      try
      {
        localObject2 = new a();
        ((Map)localObject1).put(parama, localObject2);
        Iterator localIterator = this.bFd.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locals = ((t)localIterator.next()).a(this, parama);
        } while (locals == null);
        if (((a)localObject2).bFw != null)
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
          this.bEZ.remove();
        }
        AppMethodBeat.o(107829);
      }
      localObject3.bFw = locals;
      this.bFa.put(parama, locals);
      ((Map)localObject1).remove(parama);
      if (i != 0) {
        this.bEZ.remove();
      }
      AppMethodBeat.o(107829);
      return locals;
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("GSON (2.8.5) cannot handle ".concat(String.valueOf(parama)));
      AppMethodBeat.o(107829);
      throw localIllegalArgumentException;
    }
  }
  
  public final <T> s<T> a(t paramt, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(107830);
    Object localObject1 = paramt;
    if (!this.bFd.contains(paramt)) {
      localObject1 = this.bFc;
    }
    paramt = this.bFd.iterator();
    int i = 0;
    while (paramt.hasNext())
    {
      Object localObject2 = (t)paramt.next();
      if (i == 0)
      {
        if (localObject2 == localObject1) {
          i = 1;
        }
      }
      else
      {
        localObject2 = ((t)localObject2).a(this, parama);
        if (localObject2 != null)
        {
          AppMethodBeat.o(107830);
          return localObject2;
        }
      }
    }
    paramt = new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(parama)));
    AppMethodBeat.o(107830);
    throw paramt;
  }
  
  /* Error */
  public final String toJson(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 486
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +210 -> 217
    //   10: getstatic 492	com/google/a/m:bFA	Lcom/google/a/m;
    //   13: astore 5
    //   15: new 494	java/io/StringWriter
    //   18: dup
    //   19: invokespecial 495	java/io/StringWriter:<init>	()V
    //   22: astore 6
    //   24: aload_0
    //   25: aload 6
    //   27: checkcast 356	java/io/Writer
    //   30: invokespecial 497	com/google/a/f:b	(Ljava/io/Writer;)Lcom/google/a/d/a;
    //   33: astore_1
    //   34: aload_1
    //   35: getfield 498	com/google/a/d/a:bFm	Z
    //   38: istore_2
    //   39: aload_1
    //   40: iconst_1
    //   41: putfield 498	com/google/a/d/a:bFm	Z
    //   44: aload_1
    //   45: getfield 499	com/google/a/d/a:bFk	Z
    //   48: istore_3
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 142	com/google/a/f:bFk	Z
    //   54: putfield 499	com/google/a/d/a:bFk	Z
    //   57: aload_1
    //   58: getfield 371	com/google/a/d/a:bFh	Z
    //   61: istore 4
    //   63: aload_1
    //   64: aload_0
    //   65: getfield 136	com/google/a/f:bFh	Z
    //   68: putfield 371	com/google/a/d/a:bFh	Z
    //   71: aload 5
    //   73: aload_1
    //   74: invokestatic 504	com/google/a/b/k:a	(Lcom/google/a/k;Lcom/google/a/d/a;)V
    //   77: aload_1
    //   78: iload_2
    //   79: putfield 498	com/google/a/d/a:bFm	Z
    //   82: aload_1
    //   83: iload_3
    //   84: putfield 499	com/google/a/d/a:bFk	Z
    //   87: aload_1
    //   88: iload 4
    //   90: putfield 371	com/google/a/d/a:bFh	Z
    //   93: aload 6
    //   95: invokevirtual 505	java/io/StringWriter:toString	()Ljava/lang/String;
    //   98: astore_1
    //   99: ldc_w 486
    //   102: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_1
    //   106: areturn
    //   107: astore 5
    //   109: new 507	com/google/a/l
    //   112: dup
    //   113: aload 5
    //   115: invokespecial 510	com/google/a/l:<init>	(Ljava/lang/Throwable;)V
    //   118: astore 5
    //   120: ldc_w 486
    //   123: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload 5
    //   128: athrow
    //   129: astore 5
    //   131: aload_1
    //   132: iload_2
    //   133: putfield 498	com/google/a/d/a:bFm	Z
    //   136: aload_1
    //   137: iload_3
    //   138: putfield 499	com/google/a/d/a:bFk	Z
    //   141: aload_1
    //   142: iload 4
    //   144: putfield 371	com/google/a/d/a:bFh	Z
    //   147: ldc_w 486
    //   150: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload 5
    //   155: athrow
    //   156: astore_1
    //   157: new 507	com/google/a/l
    //   160: dup
    //   161: aload_1
    //   162: invokespecial 510	com/google/a/l:<init>	(Ljava/lang/Throwable;)V
    //   165: astore_1
    //   166: ldc_w 486
    //   169: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_1
    //   173: athrow
    //   174: astore 5
    //   176: new 455	java/lang/AssertionError
    //   179: dup
    //   180: new 385	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 512
    //   187: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 5
    //   192: invokevirtual 516	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   195: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload 5
    //   203: invokespecial 519	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   206: astore 5
    //   208: ldc_w 486
    //   211: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload 5
    //   216: athrow
    //   217: aload_1
    //   218: invokevirtual 523	java/lang/Object:getClass	()Ljava/lang/Class;
    //   221: astore 7
    //   223: new 494	java/io/StringWriter
    //   226: dup
    //   227: invokespecial 495	java/io/StringWriter:<init>	()V
    //   230: astore 6
    //   232: aload_0
    //   233: aload 6
    //   235: checkcast 356	java/io/Writer
    //   238: invokespecial 497	com/google/a/f:b	(Ljava/io/Writer;)Lcom/google/a/d/a;
    //   241: astore 5
    //   243: aload_0
    //   244: aload 7
    //   246: invokestatic 527	com/google/a/c/a:h	(Ljava/lang/reflect/Type;)Lcom/google/a/c/a;
    //   249: invokevirtual 407	com/google/a/f:a	(Lcom/google/a/c/a;)Lcom/google/a/s;
    //   252: astore 7
    //   254: aload 5
    //   256: getfield 498	com/google/a/d/a:bFm	Z
    //   259: istore_2
    //   260: aload 5
    //   262: iconst_1
    //   263: putfield 498	com/google/a/d/a:bFm	Z
    //   266: aload 5
    //   268: getfield 499	com/google/a/d/a:bFk	Z
    //   271: istore_3
    //   272: aload 5
    //   274: aload_0
    //   275: getfield 142	com/google/a/f:bFk	Z
    //   278: putfield 499	com/google/a/d/a:bFk	Z
    //   281: aload 5
    //   283: getfield 371	com/google/a/d/a:bFh	Z
    //   286: istore 4
    //   288: aload 5
    //   290: aload_0
    //   291: getfield 136	com/google/a/f:bFh	Z
    //   294: putfield 371	com/google/a/d/a:bFh	Z
    //   297: aload 7
    //   299: aload 5
    //   301: aload_1
    //   302: invokevirtual 530	com/google/a/s:a	(Lcom/google/a/d/a;Ljava/lang/Object;)V
    //   305: aload 5
    //   307: iload_2
    //   308: putfield 498	com/google/a/d/a:bFm	Z
    //   311: aload 5
    //   313: iload_3
    //   314: putfield 499	com/google/a/d/a:bFk	Z
    //   317: aload 5
    //   319: iload 4
    //   321: putfield 371	com/google/a/d/a:bFh	Z
    //   324: aload 6
    //   326: invokevirtual 505	java/io/StringWriter:toString	()Ljava/lang/String;
    //   329: astore_1
    //   330: ldc_w 486
    //   333: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload_1
    //   337: areturn
    //   338: astore_1
    //   339: new 507	com/google/a/l
    //   342: dup
    //   343: aload_1
    //   344: invokespecial 510	com/google/a/l:<init>	(Ljava/lang/Throwable;)V
    //   347: astore_1
    //   348: ldc_w 486
    //   351: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload_1
    //   355: athrow
    //   356: astore_1
    //   357: aload 5
    //   359: iload_2
    //   360: putfield 498	com/google/a/d/a:bFm	Z
    //   363: aload 5
    //   365: iload_3
    //   366: putfield 499	com/google/a/d/a:bFk	Z
    //   369: aload 5
    //   371: iload 4
    //   373: putfield 371	com/google/a/d/a:bFh	Z
    //   376: ldc_w 486
    //   379: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload_1
    //   383: athrow
    //   384: astore_1
    //   385: new 507	com/google/a/l
    //   388: dup
    //   389: aload_1
    //   390: invokespecial 510	com/google/a/l:<init>	(Ljava/lang/Throwable;)V
    //   393: astore_1
    //   394: ldc_w 486
    //   397: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload_1
    //   401: athrow
    //   402: astore_1
    //   403: new 455	java/lang/AssertionError
    //   406: dup
    //   407: new 385	java/lang/StringBuilder
    //   410: dup
    //   411: ldc_w 512
    //   414: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   417: aload_1
    //   418: invokevirtual 516	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: aload_1
    //   428: invokespecial 519	java/lang/AssertionError:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   431: astore_1
    //   432: ldc_w 486
    //   435: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: aload_1
    //   439: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	f
    //   0	440	1	paramObject	Object
    //   38	322	2	bool1	boolean
    //   48	318	3	bool2	boolean
    //   61	311	4	bool3	boolean
    //   13	59	5	localm	m
    //   107	7	5	localIOException	java.io.IOException
    //   118	9	5	locall	l
    //   129	25	5	localObject1	Object
    //   174	28	5	localAssertionError	AssertionError
    //   206	164	5	localObject2	Object
    //   22	303	6	localStringWriter	java.io.StringWriter
    //   221	77	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   71	77	107	java/io/IOException
    //   71	77	129	finally
    //   109	129	129	finally
    //   176	217	129	finally
    //   24	71	156	java/io/IOException
    //   77	93	156	java/io/IOException
    //   131	156	156	java/io/IOException
    //   71	77	174	java/lang/AssertionError
    //   297	305	338	java/io/IOException
    //   297	305	356	finally
    //   339	356	356	finally
    //   403	440	356	finally
    //   232	297	384	java/io/IOException
    //   305	324	384	java/io/IOException
    //   357	384	384	java/io/IOException
    //   297	305	402	java/lang/AssertionError
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107834);
    String str = "{serializeNulls:" + this.bFh + ",factories:" + this.bFd + ",instanceCreators:" + this.bFb + "}";
    AppMethodBeat.o(107834);
    return str;
  }
  
  static final class a<T>
    extends s<T>
  {
    s<T> bFw;
    
    public final void a(com.google.a.d.a parama, T paramT)
    {
      AppMethodBeat.i(107825);
      if (this.bFw == null)
      {
        parama = new IllegalStateException();
        AppMethodBeat.o(107825);
        throw parama;
      }
      this.bFw.a(parama, paramT);
      AppMethodBeat.o(107825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.f
 * JD-Core Version:    0.7.0.1
 */