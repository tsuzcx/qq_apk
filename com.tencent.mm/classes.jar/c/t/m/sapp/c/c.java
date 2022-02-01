package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements Runnable
{
  public static int a;
  public final int b;
  public final int c;
  public Context d;
  public List<a> e;
  public String f;
  public boolean g;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(210691);
    this.b = 30000;
    this.c = 20000;
    this.e = null;
    this.f = null;
    this.g = false;
    this.d = paramContext;
    this.f = (this.d.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp");
    paramContext = new File(this.d.getFilesDir().getAbsolutePath(), "TencentLocation_sapp/UpCp");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(210691);
  }
  
  public final void a()
  {
    int j = 0;
    Object localObject2;
    int i;
    Object localObject3;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210694);
        Object localObject1 = this.e;
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label522;
        }
        a = 1;
        q.j(this.d);
        if (q.d() < 10485760L)
        {
          a = 2;
          AppMethodBeat.o(210694);
          return;
        }
        localObject1 = new ArrayList();
        localObject2 = this.e.iterator();
        i = 1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a)((Iterator)localObject2).next();
          if (!a((a)localObject3))
          {
            i = 0;
            continue;
          }
          ((List)localObject1).add(localObject3);
          continue;
        }
        if (i != 0) {
          break;
        }
      }
      finally {}
      a = 2;
      a(localList);
      AppMethodBeat.o(210694);
    }
    Iterator localIterator;
    if (localList.size() == this.e.size())
    {
      q.a(this.d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
      if (q.a(this.d, this.e))
      {
        q.b(this.d, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", h.a);
        localIterator = localList.iterator();
        i = j;
        label233:
        if (localIterator.hasNext())
        {
          localObject2 = (a)localIterator.next();
          if (!((a)localObject2).c.contains(".dex")) {
            ((a)localObject2).c += ".dex";
          }
          localObject3 = new File(this.f, ((a)localObject2).c);
          if (!((File)localObject3).exists()) {
            break label530;
          }
        }
      }
    }
    label522:
    label530:
    for (boolean bool1 = ((File)localObject3).delete();; bool1 = true)
    {
      localObject3 = new File(this.f, ((a)localObject2).c);
      boolean bool2 = new File(this.f, "tmp__sapp" + ((a)localObject2).c).renameTo((File)localObject3);
      boolean bool3 = a((a)localObject2, (File)localObject3);
      if ((!bool1) || (!bool2) || (!bool3)) {
        break label233;
      }
      i = 1;
      break label233;
      if (i == 0)
      {
        q.b(this.d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
        q.a(this.f);
        a = 2;
        AppMethodBeat.o(210694);
        break;
      }
      a = 1;
      e.a(this.d).a("CPU", "down suc");
      AppMethodBeat.o(210694);
      break;
      a(localIterator);
      a = 2;
      AppMethodBeat.o(210694);
      break;
      j.a("down load failed");
      e.a(this.d).a("CPU", "down failed");
      a(localIterator);
      a = 2;
      AppMethodBeat.o(210694);
      break;
    }
  }
  
  public final void a(List<a> paramList)
  {
    AppMethodBeat.i(210695);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (a)paramList.next();
      localObject = new File(this.f, "tmp__sapp" + ((a)localObject).c);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        ((File)localObject).delete();
      }
    }
    AppMethodBeat.o(210695);
  }
  
  /* Error */
  public final boolean a(a parama)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 45	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 211
    //   16: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: getfield 213	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   23: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 7
    //   31: new 45	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: aload_3
    //   40: ldc 215
    //   42: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: getfield 213	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   49: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 196	c/t/m/sapp/c/j:a	(Ljava/lang/String;)V
    //   58: aconst_null
    //   59: astore_3
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_3
    //   64: if_icmpge +485 -> 549
    //   67: aload 7
    //   69: invokestatic 220	c/t/m/sapp/c/p:a	(Ljava/lang/String;)[B
    //   72: astore 4
    //   74: aload 4
    //   76: ifnull +492 -> 568
    //   79: aload 4
    //   81: ldc 222
    //   83: invokestatic 227	c/t/m/sapp/c/m:a	([BLjava/lang/String;)[B
    //   86: invokestatic 230	c/t/m/sapp/c/q:c	([B)[B
    //   89: astore 6
    //   91: aload 6
    //   93: ifnull +475 -> 568
    //   96: aload_0
    //   97: getfield 39	c/t/m/sapp/c/c:f	Ljava/lang/String;
    //   100: astore 4
    //   102: new 45	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   109: astore 5
    //   111: new 54	java/io/File
    //   114: dup
    //   115: aload 4
    //   117: aload 5
    //   119: ldc 166
    //   121: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: getfield 153	c/t/m/sapp/c/a:c	Ljava/lang/String;
    //   128: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: astore 8
    //   139: new 232	java/io/BufferedOutputStream
    //   142: dup
    //   143: new 234	java/io/FileOutputStream
    //   146: dup
    //   147: aload 8
    //   149: iconst_0
    //   150: invokespecial 237	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   153: sipush 1024
    //   156: invokespecial 240	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   159: astore 4
    //   161: aload 4
    //   163: astore 5
    //   165: aload 4
    //   167: aload 6
    //   169: invokevirtual 244	java/io/BufferedOutputStream:write	([B)V
    //   172: aload 4
    //   174: astore 5
    //   176: aload_0
    //   177: aload_1
    //   178: aload 8
    //   180: invokevirtual 176	c/t/m/sapp/c/c:a	(Lc/t/m/sapp/c/a;Ljava/io/File;)Z
    //   183: ifeq +102 -> 285
    //   186: aload 4
    //   188: astore 5
    //   190: new 45	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   197: astore_3
    //   198: aload 4
    //   200: astore 5
    //   202: aload_3
    //   203: ldc 246
    //   205: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: getfield 213	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   212: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 196	c/t/m/sapp/c/j:a	(Ljava/lang/String;)V
    //   221: aload 4
    //   223: astore 5
    //   225: aload_0
    //   226: getfield 43	c/t/m/sapp/c/c:d	Landroid/content/Context;
    //   229: invokestatic 184	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   232: astore_3
    //   233: aload 4
    //   235: astore 5
    //   237: new 45	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   244: astore 6
    //   246: aload 4
    //   248: astore 5
    //   250: aload_3
    //   251: ldc 186
    //   253: aload 6
    //   255: ldc 248
    //   257: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: getfield 213	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   264: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokevirtual 190	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload 4
    //   275: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   278: ldc 209
    //   280: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: aload 4
    //   287: astore 5
    //   289: new 45	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   296: astore_3
    //   297: aload 4
    //   299: astore 5
    //   301: aload_3
    //   302: ldc 253
    //   304: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: getfield 213	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   311: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 196	c/t/m/sapp/c/j:a	(Ljava/lang/String;)V
    //   320: aload 4
    //   322: astore 5
    //   324: aload_0
    //   325: getfield 43	c/t/m/sapp/c/c:d	Landroid/content/Context;
    //   328: invokestatic 184	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   331: astore_3
    //   332: aload 4
    //   334: astore 5
    //   336: new 45	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   343: astore 6
    //   345: aload 4
    //   347: astore 5
    //   349: aload_3
    //   350: ldc 186
    //   352: aload 6
    //   354: ldc 255
    //   356: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: getfield 213	c/t/m/sapp/c/a:e	Ljava/lang/String;
    //   363: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokevirtual 190	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload 4
    //   374: astore 5
    //   376: aload 8
    //   378: invokevirtual 77	java/io/File:exists	()Z
    //   381: ifeq +25 -> 406
    //   384: aload 4
    //   386: astore 5
    //   388: aload 8
    //   390: invokevirtual 202	java/io/File:isFile	()Z
    //   393: ifeq +13 -> 406
    //   396: aload 4
    //   398: astore 5
    //   400: aload 8
    //   402: invokevirtual 164	java/io/File:delete	()Z
    //   405: pop
    //   406: aload 4
    //   408: astore 5
    //   410: aload 4
    //   412: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   415: aload 4
    //   417: astore_3
    //   418: ldc2_w 256
    //   421: invokestatic 260	c/t/m/sapp/c/q:a	(J)V
    //   424: iload_2
    //   425: iconst_1
    //   426: iadd
    //   427: istore_2
    //   428: goto -366 -> 62
    //   431: astore 6
    //   433: aload 4
    //   435: astore_3
    //   436: aload_3
    //   437: astore 5
    //   439: aload 8
    //   441: invokevirtual 77	java/io/File:exists	()Z
    //   444: ifeq +23 -> 467
    //   447: aload_3
    //   448: astore 5
    //   450: aload 8
    //   452: invokevirtual 202	java/io/File:isFile	()Z
    //   455: ifeq +12 -> 467
    //   458: aload_3
    //   459: astore 5
    //   461: aload 8
    //   463: invokevirtual 164	java/io/File:delete	()Z
    //   466: pop
    //   467: aload_3
    //   468: astore 5
    //   470: aload_0
    //   471: getfield 43	c/t/m/sapp/c/c:d	Landroid/content/Context;
    //   474: invokestatic 184	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   477: astore 4
    //   479: aload_3
    //   480: astore 5
    //   482: new 45	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   489: astore 8
    //   491: aload_3
    //   492: astore 5
    //   494: aload 4
    //   496: ldc 186
    //   498: aload 8
    //   500: ldc 255
    //   502: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload 6
    //   507: invokevirtual 261	java/lang/Exception:toString	()Ljava/lang/String;
    //   510: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokevirtual 190	c/t/m/sapp/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: aload_3
    //   520: astore 5
    //   522: aload_3
    //   523: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   526: goto -108 -> 418
    //   529: astore_3
    //   530: aload 5
    //   532: astore_3
    //   533: goto -115 -> 418
    //   536: astore_1
    //   537: aload_3
    //   538: invokevirtual 251	java/io/BufferedOutputStream:close	()V
    //   541: ldc 209
    //   543: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   546: aload_1
    //   547: athrow
    //   548: astore_1
    //   549: ldc 209
    //   551: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   554: iconst_0
    //   555: ireturn
    //   556: astore 6
    //   558: goto -122 -> 436
    //   561: astore_1
    //   562: aload 5
    //   564: astore_3
    //   565: goto -28 -> 537
    //   568: goto -150 -> 418
    //   571: astore_1
    //   572: goto -294 -> 278
    //   575: astore_3
    //   576: goto -35 -> 541
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	c
    //   0	579	1	parama	a
    //   61	367	2	i	int
    //   12	511	3	localObject1	Object
    //   529	1	3	localException1	java.lang.Exception
    //   532	33	3	localObject2	Object
    //   575	1	3	localException2	java.lang.Exception
    //   72	423	4	localObject3	Object
    //   109	454	5	localObject4	Object
    //   89	264	6	localObject5	Object
    //   431	75	6	localException3	java.lang.Exception
    //   556	1	6	localException4	java.lang.Exception
    //   29	39	7	str	String
    //   137	362	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   165	172	431	java/lang/Exception
    //   176	186	431	java/lang/Exception
    //   190	198	431	java/lang/Exception
    //   202	221	431	java/lang/Exception
    //   225	233	431	java/lang/Exception
    //   237	246	431	java/lang/Exception
    //   250	273	431	java/lang/Exception
    //   289	297	431	java/lang/Exception
    //   301	320	431	java/lang/Exception
    //   324	332	431	java/lang/Exception
    //   336	345	431	java/lang/Exception
    //   349	372	431	java/lang/Exception
    //   376	384	431	java/lang/Exception
    //   388	396	431	java/lang/Exception
    //   400	406	431	java/lang/Exception
    //   410	415	529	java/lang/Exception
    //   522	526	529	java/lang/Exception
    //   139	161	536	finally
    //   5	13	548	java/lang/Throwable
    //   13	39	548	java/lang/Throwable
    //   39	58	548	java/lang/Throwable
    //   67	74	548	java/lang/Throwable
    //   79	91	548	java/lang/Throwable
    //   96	111	548	java/lang/Throwable
    //   111	139	548	java/lang/Throwable
    //   273	278	548	java/lang/Throwable
    //   410	415	548	java/lang/Throwable
    //   418	424	548	java/lang/Throwable
    //   522	526	548	java/lang/Throwable
    //   537	541	548	java/lang/Throwable
    //   541	548	548	java/lang/Throwable
    //   139	161	556	java/lang/Exception
    //   165	172	561	finally
    //   176	186	561	finally
    //   190	198	561	finally
    //   202	221	561	finally
    //   225	233	561	finally
    //   237	246	561	finally
    //   250	273	561	finally
    //   289	297	561	finally
    //   301	320	561	finally
    //   324	332	561	finally
    //   336	345	561	finally
    //   349	372	561	finally
    //   376	384	561	finally
    //   388	396	561	finally
    //   400	406	561	finally
    //   439	447	561	finally
    //   450	458	561	finally
    //   461	467	561	finally
    //   470	479	561	finally
    //   482	491	561	finally
    //   494	519	561	finally
    //   273	278	571	java/lang/Exception
    //   537	541	575	java/lang/Exception
  }
  
  public final boolean a(a parama, File paramFile)
  {
    AppMethodBeat.i(210697);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        int i = (int)paramFile.length();
        paramFile = q.a(paramFile);
        bool1 = bool2;
        if (parama.d == i)
        {
          bool1 = bool2;
          if (parama.e.equals(paramFile)) {
            bool1 = true;
          }
        }
      }
    }
    AppMethodBeat.o(210697);
    return bool1;
  }
  
  public void b(List<a> paramList)
  {
    AppMethodBeat.i(210693);
    this.e = paramList;
    if (a != 1) {
      new Thread(this).start();
    }
    AppMethodBeat.o(210693);
  }
  
  public void run()
  {
    AppMethodBeat.i(210692);
    d.a(this.d).b("updatelock_sapp");
    a();
    e.a(this.d).d();
    d.a(this.d).c("updatelock_sapp");
    AppMethodBeat.o(210692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.c
 * JD-Core Version:    0.7.0.1
 */