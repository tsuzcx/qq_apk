package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements Runnable
{
  private static int g = 0;
  private final int a;
  private final int b;
  private Context c;
  private List<a> d;
  private String e;
  private boolean f;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(136331);
    this.a = 30000;
    this.b = 20000;
    this.d = null;
    this.e = null;
    this.f = false;
    this.c = paramContext;
    this.e = (this.c.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp");
    paramContext = new File(this.c.getFilesDir().getAbsolutePath(), "TencentLocation/comp");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(136331);
  }
  
  private void a()
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        AppMethodBeat.i(136333);
        if ((this.d == null) || (this.d.size() <= 0)) {
          break label426;
        }
        g = 1;
        q.f(this.c);
        if (q.d() < 10485760L)
        {
          g = 2;
          AppMethodBeat.o(136333);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject1 = this.d.iterator();
        int i = 1;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (!a((a)localObject2))
          {
            i = 0;
            continue;
          }
          localArrayList.add(localObject2);
          continue;
        }
        if (i != 0) {
          break label152;
        }
      }
      finally {}
      g = 2;
      b(localList);
      AppMethodBeat.o(136333);
      continue;
      label152:
      Iterator localIterator;
      if (localList.size() == this.d.size())
      {
        d.a(this.c).a("load");
        if (!q.a(this.c, this.d))
        {
          b(localList);
          g = 2;
          AppMethodBeat.o(136333);
        }
        else
        {
          localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (a)localIterator.next();
            if (!((a)localObject1).c.contains(".dex")) {
              ((a)localObject1).c += ".dex";
            }
            localObject2 = new File(this.e, ((a)localObject1).c);
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
            localObject2 = new File(this.e, ((a)localObject1).c);
            new File(this.e, "tmp_" + ((a)localObject1).c).renameTo((File)localObject2);
          }
          g = 1;
          e.a(this.c).a("CPU", "down suc");
          d.a(this.c).b("load");
          AppMethodBeat.o(136333);
        }
      }
      else
      {
        e.a(this.c).a("CPU", "down failed");
        b(localIterator);
        g = 2;
        label426:
        AppMethodBeat.o(136333);
      }
    }
  }
  
  /* Error */
  private boolean a(a parama)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 49	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 189
    //   11: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: getfield 190	c/t/m/c/a:e	Ljava/lang/String;
    //   18: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 6
    //   26: aconst_null
    //   27: astore 4
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_2
    //   32: iconst_3
    //   33: if_icmpge +342 -> 375
    //   36: aload 6
    //   38: invokestatic 195	c/t/m/c/p:a	(Ljava/lang/String;)[B
    //   41: astore 5
    //   43: aload 4
    //   45: astore_3
    //   46: aload 5
    //   48: ifnull +212 -> 260
    //   51: aload 5
    //   53: ldc 197
    //   55: invokestatic 202	c/t/m/c/m:b	([BLjava/lang/String;)[B
    //   58: invokestatic 205	c/t/m/c/q:a	([B)[B
    //   61: astore 5
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: ifnull +192 -> 260
    //   71: new 58	java/io/File
    //   74: dup
    //   75: aload_0
    //   76: getfield 43	c/t/m/c/c:e	Ljava/lang/String;
    //   79: new 49	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 160
    //   85: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_1
    //   89: getfield 147	c/t/m/c/a:c	Ljava/lang/String;
    //   92: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: astore 7
    //   103: new 207	java/io/BufferedOutputStream
    //   106: dup
    //   107: new 209	java/io/FileOutputStream
    //   110: dup
    //   111: aload 7
    //   113: iconst_0
    //   114: invokespecial 212	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   117: sipush 1024
    //   120: invokespecial 215	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   123: astore_3
    //   124: aload_3
    //   125: astore 4
    //   127: aload_3
    //   128: aload 5
    //   130: invokevirtual 219	java/io/BufferedOutputStream:write	([B)V
    //   133: aload_3
    //   134: astore 4
    //   136: aload_0
    //   137: aload_1
    //   138: aload 7
    //   140: invokespecial 222	c/t/m/c/c:a	(Lc/t/m/c/a;Ljava/io/File;)Z
    //   143: ifeq +48 -> 191
    //   146: aload_3
    //   147: astore 4
    //   149: aload_0
    //   150: getfield 47	c/t/m/c/c:c	Landroid/content/Context;
    //   153: invokestatic 172	c/t/m/c/e:a	(Landroid/content/Context;)Lc/t/m/c/e;
    //   156: ldc 174
    //   158: new 49	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 224
    //   164: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_1
    //   168: getfield 190	c/t/m/c/a:e	Ljava/lang/String;
    //   171: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokevirtual 178	c/t/m/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_3
    //   181: invokevirtual 227	java/io/BufferedOutputStream:close	()V
    //   184: ldc 187
    //   186: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_1
    //   190: ireturn
    //   191: aload_3
    //   192: astore 4
    //   194: aload_0
    //   195: getfield 47	c/t/m/c/c:c	Landroid/content/Context;
    //   198: invokestatic 172	c/t/m/c/e:a	(Landroid/content/Context;)Lc/t/m/c/e;
    //   201: ldc 174
    //   203: new 49	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 229
    //   209: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload_1
    //   213: getfield 190	c/t/m/c/a:e	Ljava/lang/String;
    //   216: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 178	c/t/m/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_3
    //   226: astore 4
    //   228: aload 7
    //   230: invokevirtual 81	java/io/File:exists	()Z
    //   233: ifeq +23 -> 256
    //   236: aload_3
    //   237: astore 4
    //   239: aload 7
    //   241: invokevirtual 232	java/io/File:isFile	()Z
    //   244: ifeq +12 -> 256
    //   247: aload_3
    //   248: astore 4
    //   250: aload 7
    //   252: invokevirtual 158	java/io/File:delete	()Z
    //   255: pop
    //   256: aload_3
    //   257: invokevirtual 227	java/io/BufferedOutputStream:close	()V
    //   260: ldc2_w 233
    //   263: invokestatic 237	c/t/m/c/q:a	(J)V
    //   266: iload_2
    //   267: iconst_1
    //   268: iadd
    //   269: istore_2
    //   270: aload_3
    //   271: astore 4
    //   273: goto -242 -> 31
    //   276: astore 4
    //   278: goto -18 -> 260
    //   281: astore 5
    //   283: aload_3
    //   284: astore 4
    //   286: aload 7
    //   288: invokevirtual 81	java/io/File:exists	()Z
    //   291: ifeq +23 -> 314
    //   294: aload_3
    //   295: astore 4
    //   297: aload 7
    //   299: invokevirtual 232	java/io/File:isFile	()Z
    //   302: ifeq +12 -> 314
    //   305: aload_3
    //   306: astore 4
    //   308: aload 7
    //   310: invokevirtual 158	java/io/File:delete	()Z
    //   313: pop
    //   314: aload_3
    //   315: astore 4
    //   317: aload_0
    //   318: getfield 47	c/t/m/c/c:c	Landroid/content/Context;
    //   321: invokestatic 172	c/t/m/c/e:a	(Landroid/content/Context;)Lc/t/m/c/e;
    //   324: ldc 174
    //   326: new 49	java/lang/StringBuilder
    //   329: dup
    //   330: ldc 229
    //   332: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: aload 5
    //   337: invokevirtual 238	java/lang/Exception:toString	()Ljava/lang/String;
    //   340: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokevirtual 178	c/t/m/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_3
    //   350: invokevirtual 227	java/io/BufferedOutputStream:close	()V
    //   353: goto -93 -> 260
    //   356: astore 4
    //   358: goto -98 -> 260
    //   361: astore_1
    //   362: aload 4
    //   364: invokevirtual 227	java/io/BufferedOutputStream:close	()V
    //   367: ldc 187
    //   369: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_1
    //   373: athrow
    //   374: astore_1
    //   375: ldc 187
    //   377: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: iconst_0
    //   381: ireturn
    //   382: astore_1
    //   383: goto -199 -> 184
    //   386: astore_3
    //   387: goto -20 -> 367
    //   390: astore_1
    //   391: goto -29 -> 362
    //   394: astore 5
    //   396: aload 4
    //   398: astore_3
    //   399: goto -116 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	c
    //   0	402	1	parama	a
    //   30	240	2	i	int
    //   45	305	3	localObject1	Object
    //   386	1	3	localException1	java.lang.Exception
    //   398	1	3	localException2	java.lang.Exception
    //   27	245	4	localObject2	Object
    //   276	1	4	localException3	java.lang.Exception
    //   284	32	4	localObject3	Object
    //   356	41	4	localException4	java.lang.Exception
    //   41	88	5	arrayOfByte	byte[]
    //   281	55	5	localException5	java.lang.Exception
    //   394	1	5	localException6	java.lang.Exception
    //   24	13	6	str	String
    //   101	208	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   256	260	276	java/lang/Exception
    //   127	133	281	java/lang/Exception
    //   136	146	281	java/lang/Exception
    //   149	180	281	java/lang/Exception
    //   194	225	281	java/lang/Exception
    //   228	236	281	java/lang/Exception
    //   239	247	281	java/lang/Exception
    //   250	256	281	java/lang/Exception
    //   349	353	356	java/lang/Exception
    //   127	133	361	finally
    //   136	146	361	finally
    //   149	180	361	finally
    //   194	225	361	finally
    //   228	236	361	finally
    //   239	247	361	finally
    //   250	256	361	finally
    //   286	294	361	finally
    //   297	305	361	finally
    //   308	314	361	finally
    //   317	349	361	finally
    //   5	26	374	java/lang/Throwable
    //   36	43	374	java/lang/Throwable
    //   51	63	374	java/lang/Throwable
    //   71	103	374	java/lang/Throwable
    //   180	184	374	java/lang/Throwable
    //   256	260	374	java/lang/Throwable
    //   260	266	374	java/lang/Throwable
    //   349	353	374	java/lang/Throwable
    //   362	367	374	java/lang/Throwable
    //   367	374	374	java/lang/Throwable
    //   180	184	382	java/lang/Exception
    //   362	367	386	java/lang/Exception
    //   103	124	390	finally
    //   103	124	394	java/lang/Exception
  }
  
  private boolean a(a parama, File paramFile)
  {
    AppMethodBeat.i(136336);
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
    AppMethodBeat.o(136336);
    return bool1;
  }
  
  private void b(List<a> paramList)
  {
    AppMethodBeat.i(136334);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (a)paramList.next();
      localObject = new File(this.e, "tmp_" + ((a)localObject).c);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        ((File)localObject).delete();
      }
    }
    AppMethodBeat.o(136334);
  }
  
  public void a(List<a> paramList)
  {
    AppMethodBeat.i(136337);
    this.d = paramList;
    if (g != 1) {
      new Thread(this).start();
    }
    AppMethodBeat.o(136337);
  }
  
  public void run()
  {
    AppMethodBeat.i(136332);
    a();
    e.a(this.c).c();
    AppMethodBeat.o(136332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.c.c
 * JD-Core Version:    0.7.0.1
 */