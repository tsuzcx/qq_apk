package midas.x;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class s0
{
  public Context a = null;
  public int b = 0;
  public int c = 0;
  public int d;
  public int e = 0;
  public int f = 0;
  public u0[] g = null;
  public File h;
  public Map<String, Map<Integer, Integer>> i = new HashMap();
  public p0 j = null;
  public b1 k = null;
  public HashMap<String, Integer> l = new HashMap();
  public HashMap<String, Integer> m = new HashMap();
  public boolean n = false;
  
  public s0(Context paramContext)
  {
    this.a = paramContext;
    this.j = new p0(this.a);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public final void a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    SparseIntArray localSparseIntArray = this.j.a(paramString);
    int i1 = localSparseIntArray.size();
    int i2 = 0;
    if (i1 > 0)
    {
      i1 = 0;
      for (;;)
      {
        i3 = i1;
        if (i2 >= localSparseIntArray.size()) {
          break;
        }
        localConcurrentHashMap.put(Integer.valueOf(localSparseIntArray.keyAt(i2)), Integer.valueOf(localSparseIntArray.get(localSparseIntArray.keyAt(i2))));
        i1 += localSparseIntArray.get(localSparseIntArray.keyAt(i2));
        this.c += localSparseIntArray.get(localSparseIntArray.keyAt(i2));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resultData=从数据库取数据时，每个下载url链接id的大小逐渐累加");
        localStringBuilder.append(i1);
        APLog.i("APMidasDownManager", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("resultData=从数据库取数据时，所有下载url链接id的大小逐渐累加");
        localStringBuilder.append(this.c);
        APLog.i("APMidasDownManager", localStringBuilder.toString());
        i2 += 1;
      }
    }
    int i3 = 0;
    this.i.put(paramString, localConcurrentHashMap);
    this.m.put(paramString, Integer.valueOf(i3));
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.c += paramInt;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      ((Map)this.i.get(paramString)).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      this.j.b(paramString, (Map)this.i.get(paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    try
    {
      if (!paramFile.exists()) {
        paramFile.mkdir();
      }
      this.g = new u0[2];
      this.h = new File(paramFile, paramString2);
      int i1 = ((Integer)this.l.get(paramString1)).intValue();
      paramString2 = new StringBuilder();
      paramString2.append("resultData=开始下载时，单个url链接需要下载的文件长度，分2个线程去下载");
      paramString2.append(i1);
      paramString2.append(paramString1);
      APLog.i("APMidasDownManager", paramString2.toString());
      if (i1 > 0)
      {
        if (i1 % this.g.length == 0) {
          i1 /= this.g.length;
        } else {
          i1 = i1 / this.g.length + 1;
        }
        this.d = i1;
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<q0> paramArrayList)
  {
    q0 localq0 = new q0();
    localq0.a = paramString2;
    if (paramArrayList.contains(localq0))
    {
      int i1 = ((q0)paramArrayList.get(paramArrayList.indexOf(localq0))).b;
      this.l.put(paramString1, Integer.valueOf(i1));
      this.e += i1;
    }
  }
  
  public final void a(ArrayList<q0> paramArrayList)
  {
    try
    {
      if (this.c >= this.e)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resultData=下载结束时downloadsize的长度");
        localStringBuilder.append(this.c);
        APLog.i("APMidasDownManager", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("resultData=下载结束时fileTotalSize的长度");
        localStringBuilder.append(this.e);
        APLog.i("APMidasDownManager", localStringBuilder.toString());
        APLog.i("APMidasDownManager", "resultData=两个文件的大小一致，才说明下载成功；或者是downloadsize的长度大于filetotalsize的长度");
        int i1 = 0;
        while (i1 < paramArrayList.size())
        {
          this.j.a(((q0)paramArrayList.get(i1)).d, 1);
          i1 += 1;
        }
        this.j.a("filetotalsize", 2);
        this.j.a();
        this.k.a();
        return;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public void a(ArrayList<q0> paramArrayList, int paramInt)
  {
    paramInt = 0;
    try
    {
      while (paramInt < paramArrayList.size())
      {
        a(((q0)paramArrayList.get(paramInt)).d, ((q0)paramArrayList.get(paramInt)).a, paramArrayList);
        paramInt += 1;
      }
      if (this.c <= 0)
      {
        this.j.b("filetotalsize", this.e);
        return;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public void a(ArrayList<q0> paramArrayList, int paramInt, b1 paramb1)
  {
    this.k = paramb1;
    if (new v0().e() > 3145728L)
    {
      b(paramArrayList, paramInt);
      return;
    }
    this.k.b();
  }
  
  /* Error */
  public void a(ArrayList<q0> paramArrayList, String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 228	java/net/URL
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 230	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 10
    //   10: aload_0
    //   11: getfield 51	midas/x/s0:i	Ljava/util/Map;
    //   14: aload_2
    //   15: invokeinterface 129 2 0
    //   20: checkcast 94	java/util/Map
    //   23: astore 9
    //   25: aload 9
    //   27: ifnull +87 -> 114
    //   30: aload 9
    //   32: astore 8
    //   34: aload 9
    //   36: invokeinterface 231 1 0
    //   41: ifgt +540 -> 581
    //   44: aload 9
    //   46: invokeinterface 234 1 0
    //   51: iconst_0
    //   52: istore 4
    //   54: iload 4
    //   56: aload_0
    //   57: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   60: arraylength
    //   61: if_icmpge +29 -> 90
    //   64: iload 4
    //   66: iconst_1
    //   67: iadd
    //   68: istore 4
    //   70: aload 9
    //   72: iload 4
    //   74: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: iconst_0
    //   78: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: invokeinterface 98 3 0
    //   86: pop
    //   87: goto -33 -> 54
    //   90: aload_0
    //   91: getfield 53	midas/x/s0:j	Lmidas/x/p0;
    //   94: aload_2
    //   95: aload 9
    //   97: invokevirtual 236	midas/x/p0:a	(Ljava/lang/String;Ljava/util/Map;)V
    //   100: ldc 112
    //   102: ldc 238
    //   104: invokestatic 121	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 9
    //   109: astore 8
    //   111: goto +470 -> 581
    //   114: new 70	java/util/concurrent/ConcurrentHashMap
    //   117: dup
    //   118: invokespecial 71	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   121: astore 8
    //   123: aload 8
    //   125: invokeinterface 234 1 0
    //   130: iconst_0
    //   131: istore 4
    //   133: iload 4
    //   135: aload_0
    //   136: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   139: arraylength
    //   140: if_icmpge +29 -> 169
    //   143: iload 4
    //   145: iconst_1
    //   146: iadd
    //   147: istore 4
    //   149: aload 8
    //   151: iload 4
    //   153: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: iconst_0
    //   157: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokeinterface 98 3 0
    //   165: pop
    //   166: goto -33 -> 133
    //   169: aload_0
    //   170: getfield 53	midas/x/s0:j	Lmidas/x/p0;
    //   173: aload_2
    //   174: aload 8
    //   176: invokevirtual 236	midas/x/p0:a	(Ljava/lang/String;Ljava/util/Map;)V
    //   179: ldc 112
    //   181: ldc 240
    //   183: invokestatic 121	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: goto +395 -> 581
    //   189: iload 4
    //   191: aload_0
    //   192: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   195: arraylength
    //   196: if_icmpge +398 -> 594
    //   199: iload 4
    //   201: iconst_1
    //   202: iadd
    //   203: istore 5
    //   205: aload 8
    //   207: iload 5
    //   209: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokeinterface 129 2 0
    //   217: checkcast 85	java/lang/Integer
    //   220: invokevirtual 155	java/lang/Integer:intValue	()I
    //   223: istore 6
    //   225: new 100	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   232: astore 9
    //   234: aload 9
    //   236: ldc 242
    //   238: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 9
    //   244: iload 6
    //   246: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 112
    //   252: aload 9
    //   254: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 121	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: iload 6
    //   262: aload_0
    //   263: getfield 159	midas/x/s0:d	I
    //   266: if_icmpge +93 -> 359
    //   269: aload_0
    //   270: getfield 59	midas/x/s0:m	Ljava/util/HashMap;
    //   273: aload_2
    //   274: invokevirtual 152	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: checkcast 85	java/lang/Integer
    //   280: invokevirtual 155	java/lang/Integer:intValue	()I
    //   283: aload_0
    //   284: getfield 57	midas/x/s0:l	Ljava/util/HashMap;
    //   287: aload_2
    //   288: invokevirtual 152	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: checkcast 85	java/lang/Integer
    //   294: invokevirtual 155	java/lang/Integer:intValue	()I
    //   297: if_icmpge +62 -> 359
    //   300: aload_0
    //   301: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   304: iload 4
    //   306: new 146	midas/x/u0
    //   309: dup
    //   310: aload_0
    //   311: aload_2
    //   312: aload 10
    //   314: aload_0
    //   315: getfield 151	midas/x/s0:h	Ljava/io/File;
    //   318: aload_0
    //   319: getfield 159	midas/x/s0:d	I
    //   322: aload 8
    //   324: iload 5
    //   326: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: invokeinterface 129 2 0
    //   334: checkcast 85	java/lang/Integer
    //   337: invokevirtual 155	java/lang/Integer:intValue	()I
    //   340: iload 5
    //   342: invokespecial 245	midas/x/u0:<init>	(Lmidas/x/s0;Ljava/lang/String;Ljava/net/URL;Ljava/io/File;III)V
    //   345: aastore
    //   346: aload_0
    //   347: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   350: iload 4
    //   352: aaload
    //   353: invokevirtual 248	midas/x/u0:start	()V
    //   356: goto +231 -> 587
    //   359: aload_0
    //   360: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   363: iload 4
    //   365: aconst_null
    //   366: aastore
    //   367: goto +220 -> 587
    //   370: iload 4
    //   372: ifeq +200 -> 572
    //   375: ldc2_w 249
    //   378: invokestatic 256	java/lang/Thread:sleep	(J)V
    //   381: iconst_0
    //   382: istore 5
    //   384: iconst_0
    //   385: istore 4
    //   387: iload 5
    //   389: aload_0
    //   390: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   393: arraylength
    //   394: if_icmpge +71 -> 465
    //   397: iload 4
    //   399: istore 6
    //   401: aload_0
    //   402: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   405: iload 5
    //   407: aaload
    //   408: ifnull +44 -> 452
    //   411: iload 4
    //   413: istore 6
    //   415: aload_0
    //   416: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   419: iload 5
    //   421: aaload
    //   422: invokevirtual 258	midas/x/u0:a	()Z
    //   425: ifne +27 -> 452
    //   428: aload_0
    //   429: getfield 46	midas/x/s0:g	[Lmidas/x/u0;
    //   432: iload 5
    //   434: aaload
    //   435: invokevirtual 261	java/lang/Thread:isAlive	()Z
    //   438: istore 7
    //   440: iload 4
    //   442: istore 6
    //   444: iload 7
    //   446: ifeq +6 -> 452
    //   449: iconst_1
    //   450: istore 6
    //   452: iload 5
    //   454: iconst_1
    //   455: iadd
    //   456: istore 5
    //   458: iload 6
    //   460: istore 4
    //   462: goto -75 -> 387
    //   465: iload_3
    //   466: iconst_2
    //   467: if_icmpne +31 -> 498
    //   470: aload_0
    //   471: getfield 55	midas/x/s0:k	Lmidas/x/b1;
    //   474: ifnull +24 -> 498
    //   477: aload_0
    //   478: getfield 55	midas/x/s0:k	Lmidas/x/b1;
    //   481: aload_0
    //   482: getfield 40	midas/x/s0:c	I
    //   485: invokeinterface 264 2 0
    //   490: goto +8 -> 498
    //   493: astore 8
    //   495: goto +12 -> 507
    //   498: goto -128 -> 370
    //   501: astore_1
    //   502: goto +71 -> 573
    //   505: astore 8
    //   507: aload 8
    //   509: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   512: invokestatic 270	midas/x/r0:p	()Lmidas/x/r0;
    //   515: astore 9
    //   517: new 100	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   524: astore 10
    //   526: aload 10
    //   528: aload 8
    //   530: invokevirtual 271	java/lang/Exception:toString	()Ljava/lang/String;
    //   533: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 10
    //   539: aload_0
    //   540: getfield 38	midas/x/s0:b	I
    //   543: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 9
    //   549: aload 10
    //   551: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokevirtual 273	midas/x/r0:b	(Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 38	midas/x/s0:b	I
    //   561: iconst_1
    //   562: if_icmpgt +10 -> 572
    //   565: aload_0
    //   566: aload_1
    //   567: aload_2
    //   568: iload_3
    //   569: invokevirtual 275	midas/x/s0:b	(Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   572: return
    //   573: goto +5 -> 578
    //   576: aload_1
    //   577: athrow
    //   578: goto -2 -> 576
    //   581: iconst_0
    //   582: istore 4
    //   584: goto -395 -> 189
    //   587: iload 5
    //   589: istore 4
    //   591: goto -402 -> 189
    //   594: iconst_1
    //   595: istore 4
    //   597: goto -227 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	s0
    //   0	600	1	paramArrayList	ArrayList<q0>
    //   0	600	2	paramString	String
    //   0	600	3	paramInt	int
    //   52	544	4	i1	int
    //   203	385	5	i2	int
    //   223	236	6	i3	int
    //   438	7	7	bool	boolean
    //   32	291	8	localObject1	Object
    //   493	1	8	localException1	Exception
    //   505	24	8	localException2	Exception
    //   23	525	9	localObject2	Object
    //   8	542	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   470	490	493	java/lang/Exception
    //   0	25	501	finally
    //   34	51	501	finally
    //   54	64	501	finally
    //   70	87	501	finally
    //   90	107	501	finally
    //   114	130	501	finally
    //   133	143	501	finally
    //   149	166	501	finally
    //   169	186	501	finally
    //   189	199	501	finally
    //   205	356	501	finally
    //   359	367	501	finally
    //   375	381	501	finally
    //   387	397	501	finally
    //   401	411	501	finally
    //   415	440	501	finally
    //   470	490	501	finally
    //   507	572	501	finally
    //   0	25	505	java/lang/Exception
    //   34	51	505	java/lang/Exception
    //   54	64	505	java/lang/Exception
    //   70	87	505	java/lang/Exception
    //   90	107	505	java/lang/Exception
    //   114	130	505	java/lang/Exception
    //   133	143	505	java/lang/Exception
    //   149	166	505	java/lang/Exception
    //   169	186	505	java/lang/Exception
    //   189	199	505	java/lang/Exception
    //   205	356	505	java/lang/Exception
    //   359	367	505	java/lang/Exception
    //   375	381	505	java/lang/Exception
    //   387	397	505	java/lang/Exception
    //   401	411	505	java/lang/Exception
    //   415	440	505	java/lang/Exception
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(ArrayList<q0> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      a(((q0)paramArrayList.get(i1)).d);
      i1 += 1;
    }
  }
  
  public void b(ArrayList<q0> paramArrayList, int paramInt)
  {
    File localFile = this.a.getApplicationContext().getDir("midaspluginsTemp", 0);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localArrayList.add(paramArrayList.get(i1));
      i1 += 1;
    }
    if (localArrayList.size() == 0)
    {
      this.k.a();
      return;
    }
    i1 = 0;
    while (i1 < localArrayList.size())
    {
      String str;
      if (((q0)localArrayList.get(i1)).f)
      {
        paramArrayList = ((q0)localArrayList.get(i1)).a.split("\\_");
        str = ((q0)localArrayList.get(i1)).d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayList[0]);
        localStringBuilder.append(".");
        localStringBuilder.append(((q0)localArrayList.get(i1)).j);
        localStringBuilder.append(".diff");
        a(str, localStringBuilder.toString(), localFile);
      }
      else
      {
        str = ((q0)localArrayList.get(i1)).a;
        paramArrayList = str;
        if (!str.endsWith(".apk"))
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append(str);
          paramArrayList.append(".apk");
          paramArrayList = paramArrayList.toString();
        }
        a(((q0)localArrayList.get(i1)).d, paramArrayList, localFile);
      }
      if (paramInt == 1) {
        a(localArrayList, ((q0)localArrayList.get(i1)).d, paramInt);
      }
      if ((!this.n) && (paramInt == 2)) {
        a(localArrayList, ((q0)localArrayList.get(i1)).d, paramInt);
      }
      i1 += 1;
    }
    if (this.c < this.e)
    {
      paramArrayList = this.j;
      if (paramArrayList != null) {
        paramArrayList.a();
      }
      paramArrayList = new StringBuilder();
      paramArrayList.append("resultData=下载结束异常时downloadsize的长度");
      paramArrayList.append(this.c);
      APLog.i("APMidasDownManager", paramArrayList.toString());
      paramArrayList = new StringBuilder();
      paramArrayList.append("resultData=下载结束异常时downloadsize的长度");
      paramArrayList.append(this.e);
      APLog.i("APMidasDownManager", paramArrayList.toString());
      this.k.b(0);
    }
    a(localArrayList);
    if (this.b > 1) {
      this.k.b(0);
    }
  }
  
  public void b(ArrayList<q0> paramArrayList, int paramInt, b1 paramb1)
  {
    this.k = paramb1;
    if (new v0().e() > 3145728L)
    {
      b(paramArrayList, paramInt);
      return;
    }
    this.k.b();
  }
  
  public final void b(ArrayList<q0> paramArrayList, String paramString, int paramInt)
  {
    this.b += 1;
    a(paramArrayList, paramString, paramInt);
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(ArrayList<q0> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      this.i.put(((q0)paramArrayList.get(i1)).d, localConcurrentHashMap);
      this.m.put(((q0)paramArrayList.get(i1)).d, Integer.valueOf(0));
      i1 += 1;
    }
  }
  
  public boolean d()
  {
    if (this.f == 0)
    {
      HashMap localHashMap = this.j.b("filetotalsize");
      if (localHashMap.size() > 0) {
        this.f = ((Integer)localHashMap.get("filetotalsize")).intValue();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s0
 * JD-Core Version:    0.7.0.1
 */