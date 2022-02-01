package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public static b a;
  public Context b;
  public List<a> c;
  public String d;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(186187);
    this.c = null;
    this.d = "";
    this.b = paramContext;
    this.c = new ArrayList();
    AppMethodBeat.o(186187);
  }
  
  public static b a(Context paramContext)
  {
    AppMethodBeat.i(186190);
    if (a == null) {
      a = new b(paramContext);
    }
    paramContext = a;
    AppMethodBeat.o(186190);
    return paramContext;
  }
  
  /* Error */
  public final DexClassLoader a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 50
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 33	c/t/m/sapp/c/b:b	Landroid/content/Context;
    //   11: invokestatic 54	c/t/m/sapp/c/l:a	(Landroid/content/Context;)V
    //   14: aload_0
    //   15: getfield 27	c/t/m/sapp/c/b:c	Ljava/util/List;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +617 -> 637
    //   23: aload_3
    //   24: invokeinterface 60 1 0
    //   29: ifle +608 -> 637
    //   32: aload_0
    //   33: getfield 27	c/t/m/sapp/c/b:c	Ljava/util/List;
    //   36: invokestatic 65	c/t/m/sapp/c/r:a	(Ljava/util/List;)Ljava/lang/String;
    //   39: putstatic 66	c/t/m/sapp/c/r:d	Ljava/lang/String;
    //   42: new 68	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   49: aload_0
    //   50: getfield 33	c/t/m/sapp/c/b:b	Landroid/content/Context;
    //   53: invokevirtual 75	android/content/Context:getFilesDir	()Ljava/io/File;
    //   56: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: getstatic 88	java/io/File:separator	Ljava/lang/String;
    //   65: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 31	c/t/m/sapp/c/b:d	Ljava/lang/String;
    //   72: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 5
    //   80: new 68	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   87: aload_0
    //   88: getfield 33	c/t/m/sapp/c/b:b	Landroid/content/Context;
    //   91: invokevirtual 75	android/content/Context:getFilesDir	()Ljava/io/File;
    //   94: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   97: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: getstatic 88	java/io/File:separator	Ljava/lang/String;
    //   103: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: getstatic 93	c/t/m/sapp/c/r:c	Ljava/lang/String;
    //   109: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 6
    //   117: new 68	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   124: astore 7
    //   126: aload_0
    //   127: getfield 27	c/t/m/sapp/c/b:c	Ljava/util/List;
    //   130: invokeinterface 97 1 0
    //   135: astore_3
    //   136: aload_3
    //   137: invokeinterface 103 1 0
    //   142: ifeq +64 -> 206
    //   145: aload_3
    //   146: invokeinterface 107 1 0
    //   151: checkcast 109	c/t/m/sapp/c/a
    //   154: astore 4
    //   156: aload 4
    //   158: ifnull -22 -> 136
    //   161: aload 7
    //   163: aload 5
    //   165: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 7
    //   171: getstatic 88	java/io/File:separator	Ljava/lang/String;
    //   174: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 7
    //   180: aload 4
    //   182: getfield 110	c/t/m/sapp/c/a:c	Ljava/lang/String;
    //   185: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 7
    //   191: getstatic 113	java/io/File:pathSeparator	Ljava/lang/String;
    //   194: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: goto -62 -> 136
    //   201: astore_3
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_3
    //   205: athrow
    //   206: invokestatic 119	java/lang/System:currentTimeMillis	()J
    //   209: pop2
    //   210: new 121	dalvik/system/DexClassLoader
    //   213: dup
    //   214: aload 7
    //   216: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: aload 6
    //   221: aconst_null
    //   222: aload_0
    //   223: invokevirtual 125	java/lang/Object:getClass	()Ljava/lang/Class;
    //   226: invokevirtual 131	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   229: invokespecial 134	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   232: astore 4
    //   234: ldc 29
    //   236: astore_3
    //   237: new 77	java/io/File
    //   240: dup
    //   241: aload 5
    //   243: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: astore 8
    //   248: aload_3
    //   249: astore 5
    //   251: aload 8
    //   253: invokevirtual 140	java/io/File:exists	()Z
    //   256: ifeq +146 -> 402
    //   259: aload_3
    //   260: astore 5
    //   262: aload 8
    //   264: invokevirtual 143	java/io/File:isDirectory	()Z
    //   267: ifeq +135 -> 402
    //   270: aload 8
    //   272: invokevirtual 147	java/io/File:listFiles	()[Ljava/io/File;
    //   275: astore 8
    //   277: aload_3
    //   278: astore 5
    //   280: aload 8
    //   282: ifnull +120 -> 402
    //   285: aload_3
    //   286: astore 5
    //   288: aload 8
    //   290: arraylength
    //   291: ifle +111 -> 402
    //   294: aload 8
    //   296: arraylength
    //   297: istore_2
    //   298: iconst_0
    //   299: istore_1
    //   300: aload_3
    //   301: astore 5
    //   303: iload_1
    //   304: iload_2
    //   305: if_icmpge +97 -> 402
    //   308: aload 8
    //   310: iload_1
    //   311: aaload
    //   312: astore 5
    //   314: new 68	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   321: aload 5
    //   323: invokevirtual 150	java/io/File:getName	()Ljava/lang/String;
    //   326: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: astore 9
    //   331: aload 9
    //   333: ldc 152
    //   335: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 5
    //   340: invokevirtual 155	java/io/File:length	()J
    //   343: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   346: astore 9
    //   348: aload 9
    //   350: ldc 152
    //   352: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload 5
    //   357: invokestatic 161	c/t/m/sapp/c/r:a	(Ljava/io/File;)Ljava/lang/String;
    //   360: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: astore 5
    //   368: new 68	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   375: aload_3
    //   376: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 5
    //   381: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: astore_3
    //   385: aload_3
    //   386: ldc 163
    //   388: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: astore_3
    //   395: iload_1
    //   396: iconst_1
    //   397: iadd
    //   398: istore_1
    //   399: goto -99 -> 300
    //   402: new 68	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   409: astore_3
    //   410: aload_3
    //   411: ldc 165
    //   413: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 5
    //   418: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 169	c/t/m/sapp/c/j:a	(Ljava/lang/String;)V
    //   427: aload_0
    //   428: getfield 33	c/t/m/sapp/c/b:b	Landroid/content/Context;
    //   431: invokestatic 174	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   434: astore_3
    //   435: new 68	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   442: astore 5
    //   444: aload_3
    //   445: ldc 176
    //   447: aload 5
    //   449: ldc 178
    //   451: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: getstatic 66	c/t/m/sapp/c/r:d	Ljava/lang/String;
    //   457: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokevirtual 181	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: ldc 50
    //   468: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: aload 4
    //   473: astore_3
    //   474: aload_0
    //   475: monitorexit
    //   476: aload_3
    //   477: areturn
    //   478: astore 5
    //   480: aload 4
    //   482: astore_3
    //   483: aload 5
    //   485: astore 4
    //   487: ldc 183
    //   489: aload 4
    //   491: invokestatic 186	c/t/m/sapp/c/j:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload_0
    //   495: getfield 33	c/t/m/sapp/c/b:b	Landroid/content/Context;
    //   498: invokestatic 174	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   501: ldc 176
    //   503: new 68	java/lang/StringBuilder
    //   506: dup
    //   507: ldc 188
    //   509: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   512: getstatic 66	c/t/m/sapp/c/r:d	Ljava/lang/String;
    //   515: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc 191
    //   520: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload 4
    //   525: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   528: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokevirtual 181	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload_0
    //   538: getfield 33	c/t/m/sapp/c/b:b	Landroid/content/Context;
    //   541: invokestatic 54	c/t/m/sapp/c/l:a	(Landroid/content/Context;)V
    //   544: invokestatic 119	java/lang/System:currentTimeMillis	()J
    //   547: pop2
    //   548: new 121	dalvik/system/DexClassLoader
    //   551: dup
    //   552: aload 7
    //   554: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: aload 6
    //   559: aconst_null
    //   560: aload_0
    //   561: invokevirtual 125	java/lang/Object:getClass	()Ljava/lang/Class;
    //   564: invokevirtual 131	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   567: invokespecial 134	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   570: astore 5
    //   572: aload_0
    //   573: getfield 33	c/t/m/sapp/c/b:b	Landroid/content/Context;
    //   576: invokestatic 174	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   579: astore_3
    //   580: new 68	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   587: astore 6
    //   589: aload_3
    //   590: ldc 176
    //   592: aload 6
    //   594: ldc 194
    //   596: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: getstatic 66	c/t/m/sapp/c/r:d	Ljava/lang/String;
    //   602: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokevirtual 181	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: ldc 50
    //   613: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   616: aload 5
    //   618: astore_3
    //   619: goto -145 -> 474
    //   622: ldc 196
    //   624: aload 4
    //   626: invokestatic 186	c/t/m/sapp/c/j:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   629: ldc 50
    //   631: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   634: goto -160 -> 474
    //   637: ldc 50
    //   639: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   642: aconst_null
    //   643: astore_3
    //   644: goto -170 -> 474
    //   647: astore_3
    //   648: aload 5
    //   650: astore_3
    //   651: goto -29 -> 622
    //   654: astore 4
    //   656: aconst_null
    //   657: astore_3
    //   658: goto -171 -> 487
    //   661: astore 5
    //   663: goto -41 -> 622
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	b
    //   299	100	1	i	int
    //   297	9	2	j	int
    //   18	128	3	localObject1	Object
    //   201	4	3	localObject2	Object
    //   236	408	3	localObject3	Object
    //   647	1	3	localObject4	Object
    //   650	8	3	localObject5	Object
    //   154	471	4	localObject6	Object
    //   654	1	4	localException1	java.lang.Exception
    //   78	370	5	localObject7	Object
    //   478	6	5	localException2	java.lang.Exception
    //   570	79	5	localDexClassLoader	DexClassLoader
    //   661	1	5	localObject8	Object
    //   115	478	6	localObject9	Object
    //   124	429	7	localStringBuilder1	StringBuilder
    //   246	63	8	localObject10	Object
    //   329	20	9	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	19	201	finally
    //   23	136	201	finally
    //   136	156	201	finally
    //   161	198	201	finally
    //   206	234	201	finally
    //   237	248	201	finally
    //   251	259	201	finally
    //   262	277	201	finally
    //   288	298	201	finally
    //   314	331	201	finally
    //   331	348	201	finally
    //   348	385	201	finally
    //   385	395	201	finally
    //   402	410	201	finally
    //   410	435	201	finally
    //   435	444	201	finally
    //   444	466	201	finally
    //   466	471	201	finally
    //   487	544	201	finally
    //   611	616	201	finally
    //   622	634	201	finally
    //   637	642	201	finally
    //   237	248	478	java/lang/Exception
    //   251	259	478	java/lang/Exception
    //   262	277	478	java/lang/Exception
    //   288	298	478	java/lang/Exception
    //   314	331	478	java/lang/Exception
    //   331	348	478	java/lang/Exception
    //   348	385	478	java/lang/Exception
    //   385	395	478	java/lang/Exception
    //   402	410	478	java/lang/Exception
    //   410	435	478	java/lang/Exception
    //   435	444	478	java/lang/Exception
    //   444	466	478	java/lang/Exception
    //   572	580	647	finally
    //   580	589	647	finally
    //   589	611	647	finally
    //   206	234	654	java/lang/Exception
    //   544	572	661	finally
  }
  
  public DexClassLoader a(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(186193);
    this.c = paramList;
    this.d = paramString;
    int i = 0;
    paramList = null;
    int j = i + 1;
    paramString = paramList;
    if (i < 3) {}
    try
    {
      paramString = a();
      paramList = paramString;
    }
    finally
    {
      try
      {
        paramString = e.b();
        StringBuilder localStringBuilder = new StringBuilder();
        paramString.a("CPL", "lcn:" + j);
        if (paramList != null)
        {
          l.f(this.b);
          AppMethodBeat.o(186193);
          return paramList;
        }
        i = j;
      }
      finally
      {
        label97:
        break label97;
      }
      paramString = finally;
      e.b().a("CPL", "fail:" + paramString.toString());
      paramString = paramList;
      l.f(this.b);
      AppMethodBeat.o(186193);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.b
 * JD-Core Version:    0.7.0.1
 */