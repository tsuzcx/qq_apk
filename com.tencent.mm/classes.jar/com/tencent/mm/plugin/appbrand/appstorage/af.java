package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.b.c;

public final class af
  extends o
{
  public final String qMI;
  public final String qNA;
  public volatile long qNB;
  private final af.b qNC;
  private final af.b qND;
  private final a qNE;
  private final a qNF;
  private final a qNG;
  private final a qNH;
  private final a qNI;
  private final a qNJ;
  private final af.b qNK;
  private final a qNL;
  private final a qNM;
  private final a qNN;
  private final a qNO;
  private final a qNP;
  private final a qNQ;
  public y qNe;
  
  public af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134418);
    this.qNB = -1L;
    this.qNe = null;
    this.qNC = new af.1(this);
    this.qND = new af.9(this);
    this.qNE = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175598);
        if (paramAnonymousu.jKS())
        {
          paramAnonymousu = r.qMQ;
          AppMethodBeat.o(175598);
          return paramAnonymousu;
        }
        if (((Boolean)paramAnonymousVarArgs[0]).booleanValue())
        {
          if (!paramAnonymousu.jKY()) {}
        }
        else {
          while (paramAnonymousu.jKY())
          {
            paramAnonymousu = r.qML;
            AppMethodBeat.o(175598);
            return paramAnonymousu;
          }
        }
        paramAnonymousu = r.qMM;
        AppMethodBeat.o(175598);
        return paramAnonymousu;
      }
    };
    this.qNF = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175599);
        if ((paramAnonymousu.jKV()) || (!paramAnonymousu.jKS()))
        {
          paramAnonymousu = r.qMR;
          AppMethodBeat.o(175599);
          return paramAnonymousu;
        }
        if (paramAnonymousu.equals(af.a(af.this)))
        {
          paramAnonymousu = r.qMP;
          AppMethodBeat.o(175599);
          return paramAnonymousu;
        }
        if (((Boolean)paramAnonymousVarArgs[0]).booleanValue())
        {
          Log.d("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
          try
          {
            t.t(paramAnonymousu);
            paramAnonymousu = r.qML;
            AppMethodBeat.o(175599);
            return paramAnonymousu;
          }
          catch (Exception paramAnonymousu)
          {
            Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", new Object[] { paramAnonymousu });
            paramAnonymousu = r.qMM;
            AppMethodBeat.o(175599);
            return paramAnonymousu;
          }
        }
        paramAnonymousVarArgs = paramAnonymousu.jKX();
        if (paramAnonymousVarArgs.length > 0)
        {
          if (paramAnonymousVarArgs.length != 1) {
            break label182;
          }
          if (paramAnonymousVarArgs[0].getName().equals(".nomedia")) {
            paramAnonymousVarArgs[0].diJ();
          }
        }
        else
        {
          if (!paramAnonymousu.diJ()) {
            break label193;
          }
          paramAnonymousu = r.qML;
          AppMethodBeat.o(175599);
          return paramAnonymousu;
        }
        paramAnonymousu = r.qMS;
        AppMethodBeat.o(175599);
        return paramAnonymousu;
        label182:
        paramAnonymousu = r.qMS;
        AppMethodBeat.o(175599);
        return paramAnonymousu;
        label193:
        paramAnonymousu = r.qMM;
        AppMethodBeat.o(175599);
        return paramAnonymousu;
      }
    };
    this.qNG = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175601);
        if (!paramAnonymousu.isDirectory())
        {
          paramAnonymousu = r.qMT;
          AppMethodBeat.o(175601);
          return paramAnonymousu;
        }
        if (t.u(paramAnonymousu))
        {
          paramAnonymousu = r.qMV;
          AppMethodBeat.o(175601);
          return paramAnonymousu;
        }
        final LinkedList localLinkedList = new LinkedList();
        paramAnonymousu.a(new w()
        {
          public final boolean accept(u paramAnonymous2u)
          {
            AppMethodBeat.i(175600);
            if (!paramAnonymous2u.getName().endsWith(".nomedia")) {}
            for (boolean bool = true;; bool = false)
            {
              if (bool)
              {
                p localp = new p();
                localp.fileName = t.Ws(ah.v(paramAnonymous2u.jKT()).replaceFirst(this.qNS, ""));
                localLinkedList.add(localp);
              }
              AppMethodBeat.o(175600);
              return bool;
            }
          }
        });
        ((k)paramAnonymousVarArgs[0]).value = localLinkedList;
        paramAnonymousu = r.qML;
        AppMethodBeat.o(175601);
        return paramAnonymousu;
      }
    };
    this.qNH = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175602);
        k localk = (k)paramAnonymousVarArgs[0];
        Long localLong;
        if (paramAnonymousVarArgs.length >= 3)
        {
          localLong = (Long)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs = (Long)paramAnonymousVarArgs[2];
        }
        for (;;)
        {
          if (!paramAnonymousu.jKS())
          {
            paramAnonymousu = r.qMR;
            AppMethodBeat.o(175602);
            return paramAnonymousu;
          }
          if (!paramAnonymousu.jKV())
          {
            paramAnonymousu = r.qMP;
            AppMethodBeat.o(175602);
            return paramAnonymousu;
          }
          if (t.u(paramAnonymousu))
          {
            paramAnonymousu = r.qMV;
            AppMethodBeat.o(175602);
            return paramAnonymousu;
          }
          if (localk != null)
          {
            if ((localLong == null) || (paramAnonymousVarArgs == null)) {
              break label185;
            }
            if (paramAnonymousVarArgs.longValue() != 9223372036854775807L) {
              break label197;
            }
            paramAnonymousVarArgs = Long.valueOf(paramAnonymousu.length() - localLong.longValue());
          }
          label185:
          label197:
          for (;;)
          {
            r localr = af.h(localLong.longValue(), paramAnonymousVarArgs.longValue(), paramAnonymousu.length());
            if (localr != r.qML)
            {
              AppMethodBeat.o(175602);
              return localr;
            }
            for (localk.value = t.a(paramAnonymousu, localLong.longValue(), paramAnonymousVarArgs.longValue());; localk.value = t.s(paramAnonymousu))
            {
              paramAnonymousu = r.qML;
              AppMethodBeat.o(175602);
              return paramAnonymousu;
            }
          }
          paramAnonymousVarArgs = null;
          localLong = null;
        }
      }
    };
    this.qNI = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175603);
        k localk = (k)paramAnonymousVarArgs[0];
        long l1 = 0L;
        long l2 = 9223372036854775807L;
        String str = null;
        if (paramAnonymousVarArgs.length >= 4)
        {
          str = (String)paramAnonymousVarArgs[1];
          l1 = ((Long)paramAnonymousVarArgs[2]).longValue();
          l2 = ((Long)paramAnonymousVarArgs[3]).longValue();
        }
        if (!paramAnonymousu.jKS())
        {
          paramAnonymousu = r.qMR;
          AppMethodBeat.o(175603);
          return paramAnonymousu;
        }
        if (!paramAnonymousu.jKV())
        {
          paramAnonymousu = r.qMP;
          AppMethodBeat.o(175603);
          return paramAnonymousu;
        }
        if (t.u(paramAnonymousu))
        {
          paramAnonymousu = r.qMV;
          AppMethodBeat.o(175603);
          return paramAnonymousu;
        }
        if (localk != null)
        {
          paramAnonymousu = t.a(ah.v(paramAnonymousu.jKT()), localk, str, l1, l2);
          AppMethodBeat.o(175603);
          return paramAnonymousu;
        }
        paramAnonymousu = r.qML;
        AppMethodBeat.o(175603);
        return paramAnonymousu;
      }
    };
    this.qNJ = new a()
    {
      /* Error */
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_1
        //   6: invokestatic 35	com/tencent/mm/plugin/appbrand/appstorage/t:u	(Lcom/tencent/mm/vfs/u;)Z
        //   9: ifeq +14 -> 23
        //   12: getstatic 41	com/tencent/mm/plugin/appbrand/appstorage/r:qMV	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   15: astore_1
        //   16: ldc 23
        //   18: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   21: aload_1
        //   22: areturn
        //   23: aload_2
        //   24: iconst_0
        //   25: aaload
        //   26: checkcast 46	java/io/InputStream
        //   29: astore 6
        //   31: aload_2
        //   32: iconst_1
        //   33: aaload
        //   34: checkcast 48	java/lang/Boolean
        //   37: invokevirtual 52	java/lang/Boolean:booleanValue	()Z
        //   40: istore 4
        //   42: aload 6
        //   44: instanceof 54
        //   47: ifeq +89 -> 136
        //   50: aload 6
        //   52: checkcast 54	java/util/zip/ZipInputStream
        //   55: aload_1
        //   56: invokevirtual 60	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   59: invokestatic 66	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   62: invokestatic 69	com/tencent/mm/plugin/appbrand/appstorage/t:a	(Ljava/util/zip/ZipInputStream;Ljava/lang/String;)I
        //   65: ifne +60 -> 125
        //   68: aload_0
        //   69: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/af$15:qNR	Lcom/tencent/mm/plugin/appbrand/appstorage/af;
        //   72: invokestatic 73	com/tencent/mm/plugin/appbrand/appstorage/af:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/af;)J
        //   75: lconst_0
        //   76: lcmp
        //   77: ifle +37 -> 114
        //   80: aload_0
        //   81: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/af$15:qNR	Lcom/tencent/mm/plugin/appbrand/appstorage/af;
        //   84: invokestatic 76	com/tencent/mm/plugin/appbrand/appstorage/af:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/af;)J
        //   87: aload_0
        //   88: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/af$15:qNR	Lcom/tencent/mm/plugin/appbrand/appstorage/af;
        //   91: invokestatic 73	com/tencent/mm/plugin/appbrand/appstorage/af:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/af;)J
        //   94: lcmp
        //   95: ifle +19 -> 114
        //   98: aload_1
        //   99: invokevirtual 79	com/tencent/mm/vfs/u:diJ	()Z
        //   102: pop
        //   103: getstatic 82	com/tencent/mm/plugin/appbrand/appstorage/r:qNa	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   106: astore_1
        //   107: ldc 23
        //   109: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   112: aload_1
        //   113: areturn
        //   114: getstatic 85	com/tencent/mm/plugin/appbrand/appstorage/r:qML	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   117: astore_1
        //   118: ldc 23
        //   120: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   123: aload_1
        //   124: areturn
        //   125: getstatic 88	com/tencent/mm/plugin/appbrand/appstorage/r:qMM	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   128: astore_1
        //   129: ldc 23
        //   131: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   134: aload_1
        //   135: areturn
        //   136: aload_1
        //   137: invokevirtual 91	com/tencent/mm/vfs/u:isDirectory	()Z
        //   140: ifeq +14 -> 154
        //   143: getstatic 94	com/tencent/mm/plugin/appbrand/appstorage/r:qMQ	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   146: astore_1
        //   147: ldc 23
        //   149: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   152: aload_1
        //   153: areturn
        //   154: aload_0
        //   155: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/af$15:qNR	Lcom/tencent/mm/plugin/appbrand/appstorage/af;
        //   158: invokestatic 73	com/tencent/mm/plugin/appbrand/appstorage/af:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/af;)J
        //   161: lconst_0
        //   162: lcmp
        //   163: ifle +68 -> 231
        //   166: aload 6
        //   168: invokevirtual 98	java/io/InputStream:available	()I
        //   171: istore_3
        //   172: iload_3
        //   173: i2l
        //   174: aload_0
        //   175: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/af$15:qNR	Lcom/tencent/mm/plugin/appbrand/appstorage/af;
        //   178: invokestatic 76	com/tencent/mm/plugin/appbrand/appstorage/af:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/af;)J
        //   181: ladd
        //   182: aload_0
        //   183: getfield 14	com/tencent/mm/plugin/appbrand/appstorage/af$15:qNR	Lcom/tencent/mm/plugin/appbrand/appstorage/af;
        //   186: invokestatic 73	com/tencent/mm/plugin/appbrand/appstorage/af:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/af;)J
        //   189: lcmp
        //   190: ifle +41 -> 231
        //   193: getstatic 82	com/tencent/mm/plugin/appbrand/appstorage/r:qNa	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   196: astore_1
        //   197: ldc 23
        //   199: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   202: aload_1
        //   203: areturn
        //   204: astore_1
        //   205: ldc 100
        //   207: ldc 102
        //   209: iconst_1
        //   210: anewarray 4	java/lang/Object
        //   213: dup
        //   214: iconst_0
        //   215: aload_1
        //   216: aastore
        //   217: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   220: getstatic 88	com/tencent/mm/plugin/appbrand/appstorage/r:qMM	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   223: astore_1
        //   224: ldc 23
        //   226: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   229: aload_1
        //   230: areturn
        //   231: aload_1
        //   232: invokevirtual 111	com/tencent/mm/vfs/u:jKS	()Z
        //   235: ifne +19 -> 254
        //   238: iload 4
        //   240: ifeq +14 -> 254
        //   243: getstatic 114	com/tencent/mm/plugin/appbrand/appstorage/r:qMR	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   246: astore_1
        //   247: ldc 23
        //   249: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   252: aload_1
        //   253: areturn
        //   254: aconst_null
        //   255: astore 5
        //   257: aconst_null
        //   258: astore_2
        //   259: aload_1
        //   260: invokevirtual 60	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   263: invokestatic 66	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   266: iload 4
        //   268: invokestatic 120	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   271: astore_1
        //   272: aload_1
        //   273: astore_2
        //   274: aload_1
        //   275: astore 5
        //   277: sipush 4096
        //   280: newarray byte
        //   282: astore 7
        //   284: aload_1
        //   285: astore_2
        //   286: aload_1
        //   287: astore 5
        //   289: aload 6
        //   291: aload 7
        //   293: iconst_0
        //   294: sipush 4096
        //   297: invokevirtual 124	java/io/InputStream:read	([BII)I
        //   300: istore_3
        //   301: iload_3
        //   302: iconst_m1
        //   303: if_icmpeq +61 -> 364
        //   306: aload_1
        //   307: astore_2
        //   308: aload_1
        //   309: astore 5
        //   311: aload_1
        //   312: aload 7
        //   314: iconst_0
        //   315: iload_3
        //   316: invokevirtual 130	java/io/OutputStream:write	([BII)V
        //   319: goto -35 -> 284
        //   322: astore_1
        //   323: aload_2
        //   324: astore 5
        //   326: ldc 100
        //   328: ldc 132
        //   330: iconst_1
        //   331: anewarray 4	java/lang/Object
        //   334: dup
        //   335: iconst_0
        //   336: aload_1
        //   337: aastore
        //   338: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   341: aload_2
        //   342: astore 5
        //   344: getstatic 88	com/tencent/mm/plugin/appbrand/appstorage/r:qMM	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   347: astore_1
        //   348: aload_2
        //   349: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   352: aload 6
        //   354: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   357: ldc 23
        //   359: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   362: aload_1
        //   363: areturn
        //   364: aload_1
        //   365: astore_2
        //   366: aload_1
        //   367: astore 5
        //   369: aload_1
        //   370: invokevirtual 143	java/io/OutputStream:flush	()V
        //   373: aload_1
        //   374: astore_2
        //   375: aload_1
        //   376: astore 5
        //   378: getstatic 85	com/tencent/mm/plugin/appbrand/appstorage/r:qML	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
        //   381: astore 7
        //   383: aload_1
        //   384: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   387: aload 6
        //   389: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   392: ldc 23
        //   394: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   397: aload 7
        //   399: areturn
        //   400: astore_1
        //   401: aload 5
        //   403: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   406: aload 6
        //   408: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
        //   411: ldc 23
        //   413: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   416: aload_1
        //   417: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	418	0	this	15
        //   0	418	1	paramAnonymousu	u
        //   0	418	2	paramAnonymousVarArgs	Object[]
        //   171	145	3	i	int
        //   40	227	4	bool	boolean
        //   255	147	5	localObject1	Object
        //   29	378	6	localInputStream	InputStream
        //   282	116	7	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   166	172	204	java/lang/Exception
        //   259	272	322	java/lang/Exception
        //   277	284	322	java/lang/Exception
        //   289	301	322	java/lang/Exception
        //   311	319	322	java/lang/Exception
        //   369	373	322	java/lang/Exception
        //   378	383	322	java/lang/Exception
        //   259	272	400	finally
        //   277	284	400	finally
        //   289	301	400	finally
        //   311	319	400	finally
        //   326	341	400	finally
        //   344	348	400	finally
        //   369	373	400	finally
        //   378	383	400	finally
      }
    };
    this.qNK = new af.16(this);
    this.qNL = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175593);
        if (!paramAnonymousu.jKS())
        {
          paramAnonymousu = r.qMR;
          AppMethodBeat.o(175593);
          return paramAnonymousu;
        }
        int i = FileStat.b(ah.v(paramAnonymousu.mUri), (FileStructStat)paramAnonymousVarArgs[0]);
        if (i != 0) {
          Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", new Object[] { Integer.valueOf(i), ah.v(paramAnonymousu.mUri) });
        }
        if (i == 0)
        {
          paramAnonymousu = r.qML;
          AppMethodBeat.o(175593);
          return paramAnonymousu;
        }
        paramAnonymousu = r.qMM;
        AppMethodBeat.o(175593);
        return paramAnonymousu;
      }
    };
    this.qNM = new a()
    {
      public final r a(u paramAnonymousu, final Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175594);
        if (!paramAnonymousu.isDirectory())
        {
          paramAnonymousu = r.qNb;
          AppMethodBeat.o(175594);
          return paramAnonymousu;
        }
        paramAnonymousVarArgs = (List)paramAnonymousVarArgs[0];
        t.a(paramAnonymousu, new w()
        {
          public final boolean accept(u paramAnonymous2u)
          {
            AppMethodBeat.i(323191);
            if (!paramAnonymous2u.getName().endsWith(".nomedia")) {}
            for (boolean bool = true;; bool = false)
            {
              if ((bool) && (!paramAnonymous2u.isDirectory()))
              {
                ad localad = new ad(t.Ws(ah.v(paramAnonymous2u.jKT()).replaceFirst(this.qNS, "")));
                FileStat.b(ah.v(paramAnonymous2u.jKT()), localad);
                paramAnonymousVarArgs.add(localad);
              }
              AppMethodBeat.o(323191);
              return bool;
            }
          }
        });
        paramAnonymousu = r.qML;
        AppMethodBeat.o(175594);
        return paramAnonymousu;
      }
    };
    this.qNN = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(323253);
        u localu = (u)paramAnonymousVarArgs[0];
        boolean bool = ((Boolean)paramAnonymousVarArgs[1]).booleanValue();
        if (paramAnonymousu.isDirectory())
        {
          paramAnonymousu = r.qMQ;
          AppMethodBeat.o(323253);
          return paramAnonymousu;
        }
        if (t.u(paramAnonymousu))
        {
          paramAnonymousu = r.qMV;
          AppMethodBeat.o(323253);
          return paramAnonymousu;
        }
        if ((af.b(af.this) > 0L) && (af.c(af.this) + localu.length() > af.b(af.this)))
        {
          paramAnonymousu = r.qNa;
          AppMethodBeat.o(323253);
          return paramAnonymousu;
        }
        if (bool)
        {
          if (q.de(ah.v(localu.jKT()), ah.v(paramAnonymousu.jKT())))
          {
            paramAnonymousu = r.qML;
            AppMethodBeat.o(323253);
            return paramAnonymousu;
          }
          paramAnonymousu = r.qMM;
          AppMethodBeat.o(323253);
          return paramAnonymousu;
        }
        if (FilesCopy.copy(ah.v(localu.jKT()), ah.v(paramAnonymousu.jKT()), false))
        {
          paramAnonymousu = r.qML;
          AppMethodBeat.o(323253);
          return paramAnonymousu;
        }
        paramAnonymousu = r.qMM;
        AppMethodBeat.o(323253);
        return paramAnonymousu;
      }
    };
    this.qNO = new af.5(this);
    this.qNP = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(175596);
        if (t.u(paramAnonymousu))
        {
          paramAnonymousu = r.qMV;
          AppMethodBeat.o(175596);
          return paramAnonymousu;
        }
        if ((paramAnonymousu.jKV()) && (paramAnonymousu.jKS()))
        {
          paramAnonymousu = r.qMQ;
          AppMethodBeat.o(175596);
          return paramAnonymousu;
        }
        long l3 = t.q(paramAnonymousu);
        try
        {
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[0];
          int i = ZipJNI.vfsUnzip(ah.v(paramAnonymousVarArgs.jKT()), ah.v(paramAnonymousu.jKT()), null);
          Log.i("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", new Object[] { ah.v(paramAnonymousVarArgs.jKT()), Integer.valueOf(i) });
          if (i == 0)
          {
            long l1;
            if (af.d(af.this) != null)
            {
              long l2 = af.d(af.this).df(af.e(af.this), "");
              Log.i("MicroMsg.LuggageNonFlattenedFileSystem", "unzipFile: AppBrandStorageSpaceMonitorService size=".concat(String.valueOf(l2)));
              l1 = l2;
              if (l2 != -1L) {}
            }
            else
            {
              l1 = af.c(af.this);
            }
            if ((af.b(af.this) > 0L) && (l1 > af.b(af.this)))
            {
              t.t(paramAnonymousu);
              paramAnonymousVarArgs = r.qNa;
              return paramAnonymousVarArgs;
            }
            paramAnonymousVarArgs = r.qML;
            return paramAnonymousVarArgs;
          }
          switch (i)
          {
          default: 
            paramAnonymousVarArgs = r.qMM;
            return paramAnonymousVarArgs;
          case 1: 
            paramAnonymousVarArgs = r.qMP;
            return paramAnonymousVarArgs;
          case -106: 
            paramAnonymousVarArgs = r.qMZ;
            return paramAnonymousVarArgs;
          }
          paramAnonymousVarArgs = r.qMY;
          return paramAnonymousVarArgs;
        }
        finally
        {
          if (af.d(af.this) != null) {
            af.d(af.this).d(ah.v(paramAnonymousu.jKT()), t.q(paramAnonymousu) - l3, "LuggageNonFlattenedFileSystem#unzipFile");
          }
          AppMethodBeat.o(175596);
        }
      }
    };
    this.qNQ = new a()
    {
      public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(323244);
        paramAnonymousVarArgs = (k)paramAnonymousVarArgs[0];
        if (!paramAnonymousu.jKS())
        {
          paramAnonymousu = r.qMR;
          AppMethodBeat.o(323244);
          return paramAnonymousu;
        }
        if (!paramAnonymousu.jKV())
        {
          paramAnonymousu = r.qMP;
          AppMethodBeat.o(323244);
          return paramAnonymousu;
        }
        if (t.u(paramAnonymousu))
        {
          paramAnonymousu = r.qMV;
          AppMethodBeat.o(323244);
          return paramAnonymousu;
        }
        try
        {
          paramAnonymousVarArgs.value = com.tencent.mm.vfs.y.ao(paramAnonymousu);
          paramAnonymousu = r.qML;
          AppMethodBeat.o(323244);
          return paramAnonymousu;
        }
        catch (FileNotFoundException paramAnonymousu)
        {
          paramAnonymousu = r.qMR;
          AppMethodBeat.o(323244);
        }
        return paramAnonymousu;
      }
    };
    this.qMI = paramString1;
    this.qNA = paramString2;
    Log.i("MicroMsg.LuggageNonFlattenedFileSystem", "mRootPath:%s mPathPrefix:%s", new Object[] { this.qMI, this.qNA });
    AppMethodBeat.o(134418);
  }
  
  private r a(String paramString, a parama, boolean paramBoolean, Object... paramVarArgs)
  {
    AppMethodBeat.i(134423);
    if (Util.isNullOrNil(paramString))
    {
      paramString = r.qMP;
      AppMethodBeat.o(134423);
      return paramString;
    }
    Object localObject;
    if (this.qNA.endsWith("/"))
    {
      localObject = this.qNA;
      if (!paramString.equals(this.qNA)) {
        break label126;
      }
    }
    for (;;)
    {
      paramString = t.Ws(((String)localObject).replaceFirst(Pattern.quote(this.qNA), "")).replace("", "");
      localObject = civ();
      if (localObject == null)
      {
        paramString = r.qMN;
        AppMethodBeat.o(134423);
        return paramString;
        localObject = this.qNA + "/";
        break;
        label126:
        if (paramString.startsWith((String)localObject)) {
          break label273;
        }
        paramString = r.qMP;
        AppMethodBeat.o(134423);
        return paramString;
      }
      paramString = c.rH(ah.v(((u)localObject).jKT()), paramString);
      if (Util.isNullOrNil(paramString))
      {
        paramString = r.qMP;
        AppMethodBeat.o(134423);
        return paramString;
      }
      paramString = new u(paramString);
      localObject = civ();
      if ((localObject != null) && (c((u)localObject, paramString))) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = r.qMP;
        AppMethodBeat.o(134423);
        return paramString;
      }
      if ((!paramBoolean) && (!paramString.jKP().jKS()))
      {
        paramString = r.qMO;
        AppMethodBeat.o(134423);
        return paramString;
      }
      paramString = parama.a(paramString, paramVarArgs);
      AppMethodBeat.o(134423);
      return paramString;
      label273:
      localObject = paramString;
    }
  }
  
  private r a(String paramString, a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(134424);
    paramString = a(paramString, parama, false, paramVarArgs);
    AppMethodBeat.o(134424);
    return paramString;
  }
  
  private static boolean c(u paramu1, u paramu2)
  {
    AppMethodBeat.i(182985);
    while (paramu2 != null)
    {
      if (paramu1.equals(paramu2))
      {
        AppMethodBeat.o(182985);
        return true;
      }
      paramu2 = paramu2.jKP();
    }
    AppMethodBeat.o(182985);
    return false;
  }
  
  private u civ()
  {
    AppMethodBeat.i(175606);
    if (TextUtils.isEmpty(this.qMI))
    {
      AppMethodBeat.o(175606);
      return null;
    }
    u localu = new u(this.qMI);
    if ((localu.jKS()) && (localu.jKV())) {
      localu.diJ();
    }
    localu.jKY();
    try
    {
      new u(ah.v(localu.mUri) + "/.nomedia").jKZ();
      label97:
      AppMethodBeat.o(175606);
      return localu;
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  private long ciw()
  {
    AppMethodBeat.i(323178);
    long l = t.q(new u(this.qMI));
    AppMethodBeat.o(323178);
    return l;
  }
  
  public final boolean Vq(String paramString)
  {
    AppMethodBeat.i(134419);
    boolean bool = Util.nullAsNil(paramString).startsWith(this.qNA);
    AppMethodBeat.o(134419);
    return bool;
  }
  
  public final r Vr(String paramString)
  {
    AppMethodBeat.i(134426);
    paramString = a(paramString, this.qNC, new Object[0]);
    AppMethodBeat.o(134426);
    return paramString;
  }
  
  public final r Vt(String paramString)
  {
    AppMethodBeat.i(134427);
    paramString = a(paramString, this.qND, new Object[0]);
    AppMethodBeat.o(134427);
    return paramString;
  }
  
  public final r Wl(String paramString)
  {
    AppMethodBeat.i(134434);
    paramString = a(paramString, this.qNK, new Object[0]);
    AppMethodBeat.o(134434);
    return paramString;
  }
  
  public final boolean Wn(String paramString)
  {
    return true;
  }
  
  public final InputStream Wr(String paramString)
  {
    AppMethodBeat.i(323245);
    k localk = new k();
    paramString = a(paramString, this.qNQ, new Object[] { localk });
    if (r.qML == paramString)
    {
      paramString = (InputStream)localk.value;
      AppMethodBeat.o(323245);
      return paramString;
    }
    AppMethodBeat.o(323245);
    return null;
  }
  
  public final r a(k<String> paramk)
  {
    return r.qNb;
  }
  
  public final r a(final u paramu, final String paramString, final k<String> paramk)
  {
    AppMethodBeat.i(175610);
    if (!Vq(paramString))
    {
      paramu = r.qNb;
      AppMethodBeat.o(175610);
      return paramu;
    }
    if ((paramu == null) || (!paramu.jKS()))
    {
      paramu = r.qMM;
      AppMethodBeat.o(175610);
      return paramu;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramu = r.qNb;
      AppMethodBeat.o(175610);
      return paramu;
    }
    long l1;
    if (this.qNe != null)
    {
      long l2 = this.qNe.df(this.qMI, ah.v(paramu.jKT())) + paramu.length();
      Log.i("MicroMsg.LuggageNonFlattenedFileSystem", "saveFile: WxaStorageSpaceStatisticsService getDirTotalSize=" + (l2 - paramu.length()));
      l1 = l2;
      if (l2 != -1L) {}
    }
    else
    {
      l1 = ciw() + paramu.length();
    }
    if ((this.qNB > 0L) && (l1 > this.qNB))
    {
      Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "saveFile exceed directory max size, MAX_SIZE[%d MB], TOTAL_SIZE[%d MB]", new Object[] { Long.valueOf(this.qNB / 1048576L), Long.valueOf(l1 / 1048576L) });
      paramu = r.qNa;
      AppMethodBeat.o(175610);
      return paramu;
    }
    r localr = Vt(paramString);
    if ((localr == r.qMR) || (localr == r.qMT)) {
      try
      {
        paramu = a(paramString, new a()
        {
          public final r a(u paramAnonymousu, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(323247);
            long l1 = paramAnonymousu.length();
            long l2 = paramu.length();
            paramAnonymousu.diJ();
            q.de(ah.v(paramu.jKT()), ah.v(paramAnonymousu.jKT()));
            if (paramk != null) {
              paramk.value = paramString;
            }
            if (af.d(af.this) != null)
            {
              af.d(af.this).c(ah.v(paramu.mUri), paramu.length() - l2, "LuggageNonFlattenedFileSystem#saveFile");
              af.d(af.this).c(ah.v(paramAnonymousu.mUri), paramAnonymousu.length() - l1, "LuggageNonFlattenedFileSystem#saveFile");
            }
            paramAnonymousu = r.qML;
            AppMethodBeat.o(323247);
            return paramAnonymousu;
          }
        }, new Object[0]);
        AppMethodBeat.o(175610);
        return paramu;
      }
      catch (Exception paramu)
      {
        Log.printErrStackTrace("MicroMsg.LuggageNonFlattenedFileSystem", paramu, "saveFile() error", new Object[0]);
        paramu = r.qMM;
        AppMethodBeat.o(175610);
        return paramu;
      }
    }
    AppMethodBeat.o(175610);
    return localr;
  }
  
  public final r a(u paramu, String paramString, boolean paramBoolean, k<String> paramk)
  {
    return r.qNb;
  }
  
  public final r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(134432);
    paramString = a(paramString, this.qNH, new Object[] { paramk, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(134432);
    return paramString;
  }
  
  public final r a(String paramString, k<List<p>> paramk)
  {
    AppMethodBeat.i(134430);
    paramString = a(paramString, this.qNG, new Object[] { paramk });
    AppMethodBeat.o(134430);
    return paramString;
  }
  
  public final r a(String paramString1, k<Map<String, ByteBuffer>> paramk, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(323229);
    paramString1 = a(paramString1, this.qNI, new Object[] { paramk, paramString2, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(323229);
    return paramString1;
  }
  
  public final r a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134435);
    paramString = a(paramString, this.qNL, new Object[] { paramFileStructStat });
    AppMethodBeat.o(134435);
    return paramString;
  }
  
  public final r a(String paramString, u paramu)
  {
    AppMethodBeat.i(175609);
    paramString = a(paramString, this.qNP, new Object[] { paramu });
    AppMethodBeat.o(175609);
    return paramString;
  }
  
  public final r a(String paramString, u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(175607);
    paramString = a(paramString, this.qNN, new Object[] { paramu, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(175607);
    return paramString;
  }
  
  public final r a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(134433);
    if (paramInputStream == null)
    {
      paramString = r.qMM;
      AppMethodBeat.o(134433);
      return paramString;
    }
    paramString = a(paramString, this.qNJ, new Object[] { paramInputStream, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(134433);
    return paramString;
  }
  
  public final u ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175608);
    Object localObject = new k();
    a(paramString, this.qNO, new Object[] { localObject });
    localObject = (u)((k)localObject).value;
    if (localObject == null)
    {
      Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", new Object[] { paramString });
      AppMethodBeat.o(175608);
      return null;
    }
    if (!((u)localObject).jKS())
    {
      Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", new Object[] { paramString });
      AppMethodBeat.o(175608);
      return null;
    }
    if ((!paramBoolean) && (!((u)localObject).jKV()))
    {
      Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", new Object[] { paramString });
      AppMethodBeat.o(175608);
      return null;
    }
    if (t.u((u)localObject))
    {
      Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", new Object[] { paramString });
      AppMethodBeat.o(175608);
      return null;
    }
    AppMethodBeat.o(175608);
    return localObject;
  }
  
  public final r aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134428);
    paramString = a(paramString, this.qNE, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(134428);
    return paramString;
  }
  
  public final r ar(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134429);
    paramString = a(paramString, this.qNF, paramBoolean, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(134429);
    return paramString;
  }
  
  public final r b(String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(134431);
    paramString = a(paramString, this.qNH, new Object[] { paramk });
    AppMethodBeat.o(134431);
    return paramString;
  }
  
  public final void cij()
  {
    AppMethodBeat.i(134421);
    u localu = new u(this.qMI);
    t.t(localu);
    if (localu.jKS()) {
      localu.diJ();
    }
    AppMethodBeat.o(134421);
  }
  
  public final List<w.a> cil()
  {
    return null;
  }
  
  public final y cim()
  {
    return this.qNe;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134420);
    u localu = civ();
    if ((localu == null) || (!localu.jKS())) {
      Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134420);
  }
  
  public final r j(String paramString, List<ad> paramList)
  {
    AppMethodBeat.i(134436);
    paramString = a(paramString, this.qNM, new Object[] { paramList });
    AppMethodBeat.o(134436);
    return paramString;
  }
  
  public final void release() {}
  
  static abstract interface a
  {
    public abstract r a(u paramu, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.af
 * JD-Core Version:    0.7.0.1
 */