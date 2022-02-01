package com.tencent.mm.plugin.expt.d.h.a;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.apache.commons.b.g;

public final class a
  implements b
{
  private V8 qYn;
  
  public a()
  {
    AppMethodBeat.i(195935);
    try
    {
      this.qYn = V8.createV8Runtime();
      com.tencent.mm.plugin.expt.d.f.a.kT(true);
      AppMethodBeat.o(195935);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.plugin.expt.d.f.a.kT(false);
      ae.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] init V8 fail for : %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(195935);
    }
  }
  
  /* Error */
  public final java.util.List<String> W(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 56
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 62	org/apache/commons/b/g:ef	(Ljava/lang/String;)Z
    //   12: ifne +34 -> 46
    //   15: aload_2
    //   16: invokestatic 62	org/apache/commons/b/g:ef	(Ljava/lang/String;)Z
    //   19: ifne +27 -> 46
    //   22: aload_0
    //   23: getfield 29	com/tencent/mm/plugin/expt/d/h/a/a:qYn	Lcom/eclipsesource/v8/V8;
    //   26: ifnull +20 -> 46
    //   29: aload_0
    //   30: getfield 29	com/tencent/mm/plugin/expt/d/h/a/a:qYn	Lcom/eclipsesource/v8/V8;
    //   33: invokevirtual 66	com/eclipsesource/v8/V8:isReleased	()Z
    //   36: ifne +10 -> 46
    //   39: aload_3
    //   40: invokestatic 62	org/apache/commons/b/g:ef	(Ljava/lang/String;)Z
    //   43: ifeq +10 -> 53
    //   46: ldc 56
    //   48: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aconst_null
    //   52: areturn
    //   53: new 68	com/eclipsesource/v8/V8Array
    //   56: dup
    //   57: aload_0
    //   58: getfield 29	com/tencent/mm/plugin/expt/d/h/a/a:qYn	Lcom/eclipsesource/v8/V8;
    //   61: invokespecial 71	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   64: aload_2
    //   65: invokevirtual 75	com/eclipsesource/v8/V8Array:push	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Array;
    //   68: aload_3
    //   69: invokevirtual 75	com/eclipsesource/v8/V8Array:push	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Array;
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 29	com/tencent/mm/plugin/expt/d/h/a/a:qYn	Lcom/eclipsesource/v8/V8;
    //   77: aload_1
    //   78: aload_2
    //   79: invokevirtual 79	com/eclipsesource/v8/V8:executeArrayFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Lcom/eclipsesource/v8/V8Array;
    //   82: astore_3
    //   83: aload_3
    //   84: astore 6
    //   86: aload_2
    //   87: astore 5
    //   89: new 81	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 82	java/util/ArrayList:<init>	()V
    //   96: astore 7
    //   98: aload_3
    //   99: ifnull +78 -> 177
    //   102: aload_3
    //   103: astore 6
    //   105: aload_2
    //   106: astore 5
    //   108: aload_3
    //   109: invokevirtual 86	com/eclipsesource/v8/V8Array:length	()I
    //   112: ifle +65 -> 177
    //   115: aload_3
    //   116: astore 6
    //   118: aload_2
    //   119: astore 5
    //   121: iload 4
    //   123: aload_3
    //   124: invokevirtual 86	com/eclipsesource/v8/V8Array:length	()I
    //   127: if_icmpge +50 -> 177
    //   130: aload_3
    //   131: astore 6
    //   133: aload_2
    //   134: astore 5
    //   136: aload_3
    //   137: iload 4
    //   139: invokevirtual 90	com/eclipsesource/v8/V8Array:getString	(I)Ljava/lang/String;
    //   142: astore 8
    //   144: aload_3
    //   145: astore 6
    //   147: aload_2
    //   148: astore 5
    //   150: aload 8
    //   152: invokestatic 62	org/apache/commons/b/g:ef	(Ljava/lang/String;)Z
    //   155: ifne +224 -> 379
    //   158: aload_3
    //   159: astore 6
    //   161: aload_2
    //   162: astore 5
    //   164: aload 7
    //   166: aload 8
    //   168: invokeinterface 96 2 0
    //   173: pop
    //   174: goto +205 -> 379
    //   177: aload_3
    //   178: astore 6
    //   180: aload_2
    //   181: astore 5
    //   183: aload_2
    //   184: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   187: aload_3
    //   188: astore 6
    //   190: aload_2
    //   191: astore 5
    //   193: aload_3
    //   194: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   197: aload_2
    //   198: ifnull +14 -> 212
    //   201: aload_2
    //   202: invokevirtual 100	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   205: ifne +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   212: aload_3
    //   213: ifnull +14 -> 227
    //   216: aload_3
    //   217: invokevirtual 100	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   220: ifne +7 -> 227
    //   223: aload_3
    //   224: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   227: ldc 56
    //   229: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload 7
    //   234: areturn
    //   235: astore 7
    //   237: aconst_null
    //   238: astore_3
    //   239: aconst_null
    //   240: astore_2
    //   241: aload_3
    //   242: astore 6
    //   244: aload_2
    //   245: astore 5
    //   247: ldc 40
    //   249: ldc 102
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_1
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: aload 7
    //   263: invokevirtual 46	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 52	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_2
    //   271: ifnull +14 -> 285
    //   274: aload_2
    //   275: invokevirtual 100	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   278: ifne +7 -> 285
    //   281: aload_2
    //   282: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   285: aload_3
    //   286: ifnull +14 -> 300
    //   289: aload_3
    //   290: invokevirtual 100	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   293: ifne +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   300: ldc 56
    //   302: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aconst_null
    //   306: areturn
    //   307: astore_1
    //   308: aconst_null
    //   309: astore 6
    //   311: aconst_null
    //   312: astore_2
    //   313: aload_2
    //   314: ifnull +14 -> 328
    //   317: aload_2
    //   318: invokevirtual 100	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   321: ifne +7 -> 328
    //   324: aload_2
    //   325: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   328: aload 6
    //   330: ifnull +16 -> 346
    //   333: aload 6
    //   335: invokevirtual 100	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   338: ifne +8 -> 346
    //   341: aload 6
    //   343: invokevirtual 99	com/eclipsesource/v8/V8Array:release	()V
    //   346: ldc 56
    //   348: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: aload_1
    //   352: athrow
    //   353: astore_1
    //   354: aconst_null
    //   355: astore 6
    //   357: goto -44 -> 313
    //   360: astore_1
    //   361: aload 5
    //   363: astore_2
    //   364: goto -51 -> 313
    //   367: astore 7
    //   369: aconst_null
    //   370: astore_3
    //   371: goto -130 -> 241
    //   374: astore 7
    //   376: goto -135 -> 241
    //   379: iload 4
    //   381: iconst_1
    //   382: iadd
    //   383: istore 4
    //   385: goto -270 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	a
    //   0	388	1	paramString1	String
    //   0	388	2	paramString2	String
    //   0	388	3	paramString3	String
    //   1	383	4	i	int
    //   87	275	5	str1	String
    //   84	272	6	str2	String
    //   96	137	7	localArrayList	java.util.ArrayList
    //   235	27	7	localThrowable1	Throwable
    //   367	1	7	localThrowable2	Throwable
    //   374	1	7	localThrowable3	Throwable
    //   142	25	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   53	73	235	java/lang/Throwable
    //   53	73	307	finally
    //   73	83	353	finally
    //   89	98	360	finally
    //   108	115	360	finally
    //   121	130	360	finally
    //   136	144	360	finally
    //   150	158	360	finally
    //   164	174	360	finally
    //   183	187	360	finally
    //   193	197	360	finally
    //   247	270	360	finally
    //   73	83	367	java/lang/Throwable
    //   89	98	374	java/lang/Throwable
    //   108	115	374	java/lang/Throwable
    //   121	130	374	java/lang/Throwable
    //   136	144	374	java/lang/Throwable
    //   150	158	374	java/lang/Throwable
    //   164	174	374	java/lang/Throwable
    //   183	187	374	java/lang/Throwable
    //   193	197	374	java/lang/Throwable
  }
  
  public final boolean a(com.tencent.mm.plugin.expt.d.h.b.a parama)
  {
    AppMethodBeat.i(195936);
    if ((this.qYn == null) || (this.qYn.isReleased()) || (parama == null))
    {
      AppMethodBeat.o(195936);
      return false;
    }
    try
    {
      this.qYn.registerJavaMethod(parama, parama.coO());
      AppMethodBeat.o(195936);
      return true;
    }
    catch (Throwable localThrowable)
    {
      ae.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] registerJsApi fail, jsApi : %s, msg : %s", new Object[] { parama.coO(), localThrowable.getMessage() });
      AppMethodBeat.o(195936);
    }
    return false;
  }
  
  public final boolean aeh(String paramString)
  {
    AppMethodBeat.i(195937);
    if ((g.ef(paramString)) || (this.qYn == null) || (this.qYn.isReleased()))
    {
      AppMethodBeat.o(195937);
      return false;
    }
    try
    {
      this.qYn.executeVoidScript(paramString);
      AppMethodBeat.o(195937);
      return true;
    }
    catch (Throwable paramString)
    {
      ae.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] loadScript throw Throwable e : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(195937);
    }
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(195939);
    if ((this.qYn != null) && (!this.qYn.isReleased())) {}
    try
    {
      this.qYn.release(true);
      this.qYn = null;
      AppMethodBeat.o(195939);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] release throw Throwable : " + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.a.a
 * JD-Core Version:    0.7.0.1
 */