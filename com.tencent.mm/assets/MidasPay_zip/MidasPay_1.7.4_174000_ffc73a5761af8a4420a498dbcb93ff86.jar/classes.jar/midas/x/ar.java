package midas.x;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ar
{
  private Context a = null;
  private int b = 0;
  private int c = 0;
  private int d;
  private int e = 0;
  private int f = 0;
  private at[] g = null;
  private File h;
  private Map<String, Map<Integer, Integer>> i = new HashMap();
  private ao j = null;
  private ba k = null;
  private HashMap<String, Integer> l = new HashMap();
  private HashMap<String, Integer> m = new HashMap();
  private boolean n = false;
  
  public ar(Context paramContext)
  {
    this.a = paramContext;
    this.j = new ao(this.a);
  }
  
  private void a(String paramString)
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
  
  private void a(String paramString1, String paramString2, ArrayList<ap> paramArrayList)
  {
    ap localap = new ap();
    localap.a = paramString2;
    if (paramArrayList.contains(localap))
    {
      int i1 = ((ap)paramArrayList.get(paramArrayList.indexOf(localap))).b;
      this.l.put(paramString1, Integer.valueOf(i1));
      this.e += i1;
    }
  }
  
  private void b(ArrayList<ap> paramArrayList, String paramString, int paramInt)
  {
    this.b += 1;
    a(paramArrayList, paramString, paramInt);
  }
  
  private void c(ArrayList<ap> paramArrayList)
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
          this.j.b(((ap)paramArrayList.get(i1)).d, 1);
          i1 += 1;
        }
        this.j.b("filetotalsize", 2);
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
  
  public int a()
  {
    return this.f;
  }
  
  protected void a(String paramString, int paramInt)
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
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      ((Map)this.i.get(paramString)).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      this.j.a(paramString, (Map)this.i.get(paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void a(String paramString1, String paramString2, File paramFile)
  {
    try
    {
      if (!paramFile.exists()) {
        paramFile.mkdir();
      }
      this.g = new at[2];
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
  
  public void a(ArrayList<ap> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      a(((ap)paramArrayList.get(i1)).d);
      i1 += 1;
    }
  }
  
  protected void a(ArrayList<ap> paramArrayList, int paramInt)
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
      if (((ap)localArrayList.get(i1)).f)
      {
        paramArrayList = ((ap)localArrayList.get(i1)).a.split("\\_");
        str = ((ap)localArrayList.get(i1)).d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayList[0]);
        localStringBuilder.append(".");
        localStringBuilder.append(((ap)localArrayList.get(i1)).k);
        localStringBuilder.append(".diff");
        a(str, localStringBuilder.toString(), localFile);
      }
      else
      {
        str = ((ap)localArrayList.get(i1)).a;
        paramArrayList = str;
        if (!str.endsWith(".apk"))
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append(str);
          paramArrayList.append(".apk");
          paramArrayList = paramArrayList.toString();
        }
        a(((ap)localArrayList.get(i1)).d, paramArrayList, localFile);
      }
      if (paramInt == 1) {
        a(localArrayList, ((ap)localArrayList.get(i1)).d, paramInt);
      }
      if ((!this.n) && (paramInt == 2)) {
        a(localArrayList, ((ap)localArrayList.get(i1)).d, paramInt);
      }
      i1 += 1;
    }
    if (this.c < this.e)
    {
      if (this.j != null) {
        this.j.a();
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
    c(localArrayList);
    if (this.b > 1) {
      this.k.b(0);
    }
  }
  
  public void a(ArrayList<ap> paramArrayList, int paramInt, ba paramba)
  {
    this.k = paramba;
    if (new au().c() > 3145728L)
    {
      a(paramArrayList, paramInt);
      return;
    }
    this.k.b();
  }
  
  /* Error */
  protected void a(ArrayList<ap> paramArrayList, String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 276	java/net/URL
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 278	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 10
    //   10: aload_0
    //   11: getfield 51	midas/x/ar:i	Ljava/util/Map;
    //   14: aload_2
    //   15: invokeinterface 181 2 0
    //   20: checkcast 94	java/util/Map
    //   23: astore 9
    //   25: aload 9
    //   27: ifnull +88 -> 115
    //   30: aload 9
    //   32: astore 8
    //   34: aload 9
    //   36: invokeinterface 279 1 0
    //   41: ifgt +537 -> 578
    //   44: aload 9
    //   46: invokeinterface 282 1 0
    //   51: iconst_0
    //   52: istore 4
    //   54: iload 4
    //   56: aload_0
    //   57: getfield 46	midas/x/ar:g	[Lmidas/x/at;
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
    //   91: getfield 53	midas/x/ar:j	Lmidas/x/ao;
    //   94: aload_2
    //   95: aload 9
    //   97: invokevirtual 284	midas/x/ao:b	(Ljava/lang/String;Ljava/util/Map;)V
    //   100: ldc 112
    //   102: ldc_w 286
    //   105: invokestatic 121	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 9
    //   110: astore 8
    //   112: goto +466 -> 578
    //   115: new 69	java/util/concurrent/ConcurrentHashMap
    //   118: dup
    //   119: invokespecial 70	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   122: astore 8
    //   124: aload 8
    //   126: invokeinterface 282 1 0
    //   131: iconst_0
    //   132: istore 4
    //   134: iload 4
    //   136: aload_0
    //   137: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   140: arraylength
    //   141: if_icmpge +29 -> 170
    //   144: iload 4
    //   146: iconst_1
    //   147: iadd
    //   148: istore 4
    //   150: aload 8
    //   152: iload 4
    //   154: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: iconst_0
    //   158: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: invokeinterface 98 3 0
    //   166: pop
    //   167: goto -33 -> 134
    //   170: aload_0
    //   171: getfield 53	midas/x/ar:j	Lmidas/x/ao;
    //   174: aload_2
    //   175: aload 8
    //   177: invokevirtual 284	midas/x/ao:b	(Ljava/lang/String;Ljava/util/Map;)V
    //   180: ldc 112
    //   182: ldc_w 288
    //   185: invokestatic 121	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: goto +390 -> 578
    //   191: iload 4
    //   193: aload_0
    //   194: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   197: arraylength
    //   198: if_icmpge +393 -> 591
    //   201: iload 4
    //   203: iconst_1
    //   204: iadd
    //   205: istore 5
    //   207: aload 8
    //   209: iload 5
    //   211: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 181 2 0
    //   219: checkcast 85	java/lang/Integer
    //   222: invokevirtual 205	java/lang/Integer:intValue	()I
    //   225: istore 6
    //   227: new 100	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   234: astore 9
    //   236: aload 9
    //   238: ldc_w 290
    //   241: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 9
    //   247: iload 6
    //   249: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: ldc 112
    //   255: aload 9
    //   257: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 121	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: iload 6
    //   265: aload_0
    //   266: getfield 209	midas/x/ar:d	I
    //   269: if_icmpge +93 -> 362
    //   272: aload_0
    //   273: getfield 59	midas/x/ar:m	Ljava/util/HashMap;
    //   276: aload_2
    //   277: invokevirtual 202	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: checkcast 85	java/lang/Integer
    //   283: invokevirtual 205	java/lang/Integer:intValue	()I
    //   286: aload_0
    //   287: getfield 57	midas/x/ar:l	Ljava/util/HashMap;
    //   290: aload_2
    //   291: invokevirtual 202	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   294: checkcast 85	java/lang/Integer
    //   297: invokevirtual 205	java/lang/Integer:intValue	()I
    //   300: if_icmpge +62 -> 362
    //   303: aload_0
    //   304: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   307: iload 4
    //   309: new 196	midas/x/at
    //   312: dup
    //   313: aload_0
    //   314: aload_2
    //   315: aload 10
    //   317: aload_0
    //   318: getfield 201	midas/x/ar:h	Ljava/io/File;
    //   321: aload_0
    //   322: getfield 209	midas/x/ar:d	I
    //   325: aload 8
    //   327: iload 5
    //   329: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: invokeinterface 181 2 0
    //   337: checkcast 85	java/lang/Integer
    //   340: invokevirtual 205	java/lang/Integer:intValue	()I
    //   343: iload 5
    //   345: invokespecial 293	midas/x/at:<init>	(Lmidas/x/ar;Ljava/lang/String;Ljava/net/URL;Ljava/io/File;III)V
    //   348: aastore
    //   349: aload_0
    //   350: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   353: iload 4
    //   355: aaload
    //   356: invokevirtual 296	midas/x/at:start	()V
    //   359: goto +225 -> 584
    //   362: aload_0
    //   363: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   366: iload 4
    //   368: aconst_null
    //   369: aastore
    //   370: goto +214 -> 584
    //   373: iload 4
    //   375: ifeq +200 -> 575
    //   378: ldc2_w 297
    //   381: invokestatic 304	java/lang/Thread:sleep	(J)V
    //   384: iconst_0
    //   385: istore 5
    //   387: iconst_0
    //   388: istore 4
    //   390: iload 5
    //   392: aload_0
    //   393: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   396: arraylength
    //   397: if_icmpge +71 -> 468
    //   400: iload 4
    //   402: istore 6
    //   404: aload_0
    //   405: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   408: iload 5
    //   410: aaload
    //   411: ifnull +44 -> 455
    //   414: iload 4
    //   416: istore 6
    //   418: aload_0
    //   419: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   422: iload 5
    //   424: aaload
    //   425: invokevirtual 306	midas/x/at:a	()Z
    //   428: ifne +27 -> 455
    //   431: aload_0
    //   432: getfield 46	midas/x/ar:g	[Lmidas/x/at;
    //   435: iload 5
    //   437: aaload
    //   438: invokevirtual 309	midas/x/at:isAlive	()Z
    //   441: istore 7
    //   443: iload 4
    //   445: istore 6
    //   447: iload 7
    //   449: ifeq +6 -> 455
    //   452: iconst_1
    //   453: istore 6
    //   455: iload 5
    //   457: iconst_1
    //   458: iadd
    //   459: istore 5
    //   461: iload 6
    //   463: istore 4
    //   465: goto -75 -> 390
    //   468: iload_3
    //   469: iconst_2
    //   470: if_icmpne +31 -> 501
    //   473: aload_0
    //   474: getfield 55	midas/x/ar:k	Lmidas/x/ba;
    //   477: ifnull +24 -> 501
    //   480: aload_0
    //   481: getfield 55	midas/x/ar:k	Lmidas/x/ba;
    //   484: aload_0
    //   485: getfield 40	midas/x/ar:c	I
    //   488: invokeinterface 311 2 0
    //   493: goto +8 -> 501
    //   496: astore 8
    //   498: goto +12 -> 510
    //   501: goto -128 -> 373
    //   504: astore_1
    //   505: goto +71 -> 576
    //   508: astore 8
    //   510: aload 8
    //   512: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   515: invokestatic 316	midas/x/aq:a	()Lmidas/x/aq;
    //   518: astore 9
    //   520: new 100	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   527: astore 10
    //   529: aload 10
    //   531: aload 8
    //   533: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   536: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 10
    //   542: aload_0
    //   543: getfield 38	midas/x/ar:b	I
    //   546: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 9
    //   552: aload 10
    //   554: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokevirtual 319	midas/x/aq:c	(Ljava/lang/String;)V
    //   560: aload_0
    //   561: getfield 38	midas/x/ar:b	I
    //   564: iconst_1
    //   565: if_icmpgt +10 -> 575
    //   568: aload_0
    //   569: aload_1
    //   570: aload_2
    //   571: iload_3
    //   572: invokespecial 321	midas/x/ar:b	(Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   575: return
    //   576: aload_1
    //   577: athrow
    //   578: iconst_0
    //   579: istore 4
    //   581: goto -390 -> 191
    //   584: iload 5
    //   586: istore 4
    //   588: goto -397 -> 191
    //   591: iconst_1
    //   592: istore 4
    //   594: goto -221 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	ar
    //   0	597	1	paramArrayList	ArrayList<ap>
    //   0	597	2	paramString	String
    //   0	597	3	paramInt	int
    //   52	541	4	i1	int
    //   205	380	5	i2	int
    //   225	237	6	i3	int
    //   441	7	7	bool	boolean
    //   32	294	8	localObject1	Object
    //   496	1	8	localException1	Exception
    //   508	24	8	localException2	Exception
    //   23	528	9	localObject2	Object
    //   8	545	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   473	493	496	java/lang/Exception
    //   0	25	504	finally
    //   34	51	504	finally
    //   54	64	504	finally
    //   70	87	504	finally
    //   90	108	504	finally
    //   115	131	504	finally
    //   134	144	504	finally
    //   150	167	504	finally
    //   170	188	504	finally
    //   191	201	504	finally
    //   207	359	504	finally
    //   362	370	504	finally
    //   378	384	504	finally
    //   390	400	504	finally
    //   404	414	504	finally
    //   418	443	504	finally
    //   473	493	504	finally
    //   510	575	504	finally
    //   0	25	508	java/lang/Exception
    //   34	51	508	java/lang/Exception
    //   54	64	508	java/lang/Exception
    //   70	87	508	java/lang/Exception
    //   90	108	508	java/lang/Exception
    //   115	131	508	java/lang/Exception
    //   134	144	508	java/lang/Exception
    //   150	167	508	java/lang/Exception
    //   170	188	508	java/lang/Exception
    //   191	201	508	java/lang/Exception
    //   207	359	508	java/lang/Exception
    //   362	370	508	java/lang/Exception
    //   378	384	508	java/lang/Exception
    //   390	400	508	java/lang/Exception
    //   404	414	508	java/lang/Exception
    //   418	443	508	java/lang/Exception
  }
  
  public int b()
  {
    return this.e;
  }
  
  public void b(ArrayList<ap> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      this.i.put(((ap)paramArrayList.get(i1)).d, localConcurrentHashMap);
      this.m.put(((ap)paramArrayList.get(i1)).d, Integer.valueOf(0));
      i1 += 1;
    }
  }
  
  public void b(ArrayList<ap> paramArrayList, int paramInt)
  {
    paramInt = 0;
    try
    {
      while (paramInt < paramArrayList.size())
      {
        a(((ap)paramArrayList.get(paramInt)).d, ((ap)paramArrayList.get(paramInt)).a, paramArrayList);
        paramInt += 1;
      }
      if (this.c <= 0)
      {
        this.j.a("filetotalsize", this.e);
        return;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public void b(ArrayList<ap> paramArrayList, int paramInt, ba paramba)
  {
    this.k = paramba;
    if (new au().c() > 3145728L)
    {
      a(paramArrayList, paramInt);
      return;
    }
    this.k.b();
  }
  
  public int c()
  {
    return this.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ar
 * JD-Core Version:    0.7.0.1
 */