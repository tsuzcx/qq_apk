package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class a
  implements o
{
  private Queue<c> ckH;
  private Map<String, com.tencent.mm.compatible.util.g.a> ckJ;
  boolean ckL;
  public int ckM;
  long ckN;
  public ap ckR;
  private com.tencent.mm.i.g.a fFy;
  public n fyJ;
  Map<String, a.a> muW;
  Set<String> muX;
  boolean muY;
  int muZ;
  boolean mva;
  private Runnable mvb;
  boolean running;
  
  public a()
  {
    AppMethodBeat.i(5332);
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.ckL = false;
    this.ckH = new LinkedList();
    this.ckJ = new HashMap();
    this.muW = new HashMap();
    this.muX = new HashSet();
    this.muZ = 0;
    this.mva = true;
    this.fyJ = new a.1(this);
    this.mvb = new a.4(this);
    this.ckR = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new a.5(this), false);
    this.fFy = new a.6(this);
    this.muY = at.isWifi(ah.getContext());
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().a(this.fyJ);
    AppMethodBeat.o(5332);
  }
  
  /* Error */
  static boolean NT(String paramString)
  {
    // Byte code:
    //   0: sipush 5343
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 163	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: ldc 165
    //   13: invokespecial 168	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: astore_3
    //   17: aload_3
    //   18: astore_0
    //   19: bipush 6
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_3
    //   26: astore_0
    //   27: aload_3
    //   28: aload 4
    //   30: iconst_0
    //   31: bipush 6
    //   33: invokevirtual 172	java/io/RandomAccessFile:read	([BII)I
    //   36: istore_1
    //   37: iload_1
    //   38: iconst_m1
    //   39: if_icmpne +31 -> 70
    //   42: aload_3
    //   43: invokevirtual 175	java/io/RandomAccessFile:close	()V
    //   46: sipush 5343
    //   49: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: iconst_0
    //   53: ireturn
    //   54: astore_0
    //   55: ldc 177
    //   57: aload_0
    //   58: ldc 179
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: goto -21 -> 46
    //   70: aload_3
    //   71: astore_0
    //   72: new 187	java/lang/String
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 190	java/lang/String:<init>	([B)V
    //   81: astore 4
    //   83: aload_3
    //   84: astore_0
    //   85: ldc 177
    //   87: new 192	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 194
    //   93: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 4
    //   98: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 203
    //   103: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 209	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_3
    //   113: astore_0
    //   114: aload 4
    //   116: ldc 211
    //   118: invokevirtual 214	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   121: istore_2
    //   122: aload_3
    //   123: invokevirtual 175	java/io/RandomAccessFile:close	()V
    //   126: sipush 5343
    //   129: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iload_2
    //   133: ireturn
    //   134: astore_0
    //   135: ldc 177
    //   137: aload_0
    //   138: ldc 179
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: goto -21 -> 126
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_3
    //   154: aload_3
    //   155: astore_0
    //   156: ldc 177
    //   158: aload 4
    //   160: ldc 179
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_3
    //   170: ifnull +7 -> 177
    //   173: aload_3
    //   174: invokevirtual 175	java/io/RandomAccessFile:close	()V
    //   177: sipush 5343
    //   180: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_0
    //   186: ldc 177
    //   188: aload_0
    //   189: ldc 179
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: goto -21 -> 177
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_0
    //   204: aload_0
    //   205: ifnull +7 -> 212
    //   208: aload_0
    //   209: invokevirtual 175	java/io/RandomAccessFile:close	()V
    //   212: sipush 5343
    //   215: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_3
    //   219: athrow
    //   220: astore_0
    //   221: ldc 177
    //   223: aload_0
    //   224: ldc 179
    //   226: iconst_0
    //   227: anewarray 4	java/lang/Object
    //   230: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: goto -21 -> 212
    //   236: astore_3
    //   237: goto -33 -> 204
    //   240: astore 4
    //   242: goto -88 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramString	String
    //   36	4	1	i	int
    //   121	12	2	bool	boolean
    //   16	158	3	localRandomAccessFile	java.io.RandomAccessFile
    //   201	18	3	localObject1	Object
    //   236	1	3	localObject2	Object
    //   23	92	4	localObject3	Object
    //   150	9	4	localException1	java.lang.Exception
    //   240	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   42	46	54	java/io/IOException
    //   122	126	134	java/io/IOException
    //   6	17	150	java/lang/Exception
    //   173	177	185	java/io/IOException
    //   6	17	201	finally
    //   208	212	220	java/io/IOException
    //   19	25	236	finally
    //   27	37	236	finally
    //   72	83	236	finally
    //   85	112	236	finally
    //   114	122	236	finally
    //   156	169	236	finally
    //   19	25	240	java/lang/Exception
    //   27	37	240	java/lang/Exception
    //   72	83	240	java/lang/Exception
    //   85	112	240	java/lang/Exception
    //   114	122	240	java/lang/Exception
  }
  
  private static int eo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5341);
    if ((paramInt1 & 0x1) == 0)
    {
      AppMethodBeat.o(5341);
      return paramInt2;
    }
    ab.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt2) });
    if (com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO == paramInt2)
    {
      paramInt1 = com.tencent.mm.i.a.MediaType_FAVORITE_FILE;
      AppMethodBeat.o(5341);
      return paramInt1;
    }
    paramInt1 = com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO;
    AppMethodBeat.o(5341);
    return paramInt1;
  }
  
  /* Error */
  static boolean er(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 5342
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 377	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokestatic 381	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   16: astore_1
    //   17: aload_1
    //   18: astore 6
    //   20: aload_0
    //   21: astore 5
    //   23: sipush 16384
    //   26: newarray byte
    //   28: astore 7
    //   30: aload_1
    //   31: astore 6
    //   33: aload_0
    //   34: astore 5
    //   36: aload_1
    //   37: ldc 211
    //   39: invokevirtual 385	java/lang/String:getBytes	()[B
    //   42: invokevirtual 390	java/io/OutputStream:write	([B)V
    //   45: aload_1
    //   46: astore 6
    //   48: aload_0
    //   49: astore 5
    //   51: aload_0
    //   52: aload 7
    //   54: invokevirtual 395	java/io/InputStream:read	([B)I
    //   57: istore_2
    //   58: iload_2
    //   59: iconst_m1
    //   60: if_icmpeq +67 -> 127
    //   63: aload_1
    //   64: astore 6
    //   66: aload_0
    //   67: astore 5
    //   69: aload_1
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 398	java/io/OutputStream:write	([BII)V
    //   77: goto -32 -> 45
    //   80: astore 7
    //   82: aload_1
    //   83: astore 6
    //   85: aload_0
    //   86: astore 5
    //   88: ldc 177
    //   90: aload 7
    //   92: ldc 179
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 399	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: ifnull +215 -> 325
    //   113: aload_1
    //   114: invokevirtual 400	java/io/OutputStream:close	()V
    //   117: iconst_0
    //   118: istore_3
    //   119: sipush 5342
    //   122: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iload_3
    //   126: ireturn
    //   127: iconst_1
    //   128: istore_3
    //   129: iload_3
    //   130: istore 4
    //   132: aload_0
    //   133: ifnull +10 -> 143
    //   136: aload_0
    //   137: invokevirtual 399	java/io/InputStream:close	()V
    //   140: iload_3
    //   141: istore 4
    //   143: iload 4
    //   145: istore_3
    //   146: aload_1
    //   147: ifnull -28 -> 119
    //   150: aload_1
    //   151: invokevirtual 400	java/io/OutputStream:close	()V
    //   154: iload 4
    //   156: istore_3
    //   157: goto -38 -> 119
    //   160: astore_0
    //   161: ldc 177
    //   163: aload_0
    //   164: ldc 179
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: iconst_0
    //   174: istore_3
    //   175: goto -56 -> 119
    //   178: astore_0
    //   179: ldc 177
    //   181: aload_0
    //   182: ldc 179
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: iconst_0
    //   192: istore 4
    //   194: goto -51 -> 143
    //   197: astore_0
    //   198: ldc 177
    //   200: aload_0
    //   201: ldc 179
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: goto -101 -> 109
    //   213: astore_0
    //   214: ldc 177
    //   216: aload_0
    //   217: ldc 179
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -109 -> 119
    //   231: astore_1
    //   232: aconst_null
    //   233: astore 6
    //   235: aconst_null
    //   236: astore_0
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 399	java/io/InputStream:close	()V
    //   245: aload 6
    //   247: ifnull +8 -> 255
    //   250: aload 6
    //   252: invokevirtual 400	java/io/OutputStream:close	()V
    //   255: sipush 5342
    //   258: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    //   263: astore_0
    //   264: ldc 177
    //   266: aload_0
    //   267: ldc 179
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: goto -31 -> 245
    //   279: astore_0
    //   280: ldc 177
    //   282: aload_0
    //   283: ldc 179
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: goto -37 -> 255
    //   295: astore_1
    //   296: aconst_null
    //   297: astore 6
    //   299: goto -62 -> 237
    //   302: astore_1
    //   303: aload 5
    //   305: astore_0
    //   306: goto -69 -> 237
    //   309: astore 7
    //   311: aconst_null
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_0
    //   315: goto -233 -> 82
    //   318: astore 7
    //   320: aconst_null
    //   321: astore_1
    //   322: goto -240 -> 82
    //   325: iconst_0
    //   326: istore_3
    //   327: goto -208 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramString1	String
    //   0	330	1	paramString2	String
    //   57	17	2	i	int
    //   118	209	3	bool1	boolean
    //   130	63	4	bool2	boolean
    //   21	283	5	str1	String
    //   18	280	6	str2	String
    //   28	43	7	arrayOfByte	byte[]
    //   80	11	7	localException1	java.lang.Exception
    //   309	1	7	localException2	java.lang.Exception
    //   318	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   23	30	80	java/lang/Exception
    //   36	45	80	java/lang/Exception
    //   51	58	80	java/lang/Exception
    //   69	77	80	java/lang/Exception
    //   150	154	160	java/io/IOException
    //   136	140	178	java/io/IOException
    //   105	109	197	java/io/IOException
    //   113	117	213	java/io/IOException
    //   6	11	231	finally
    //   241	245	263	java/io/IOException
    //   250	255	279	java/io/IOException
    //   11	17	295	finally
    //   23	30	302	finally
    //   36	45	302	finally
    //   51	58	302	finally
    //   69	77	302	finally
    //   88	101	302	finally
    //   6	11	309	java/lang/Exception
    //   11	17	318	java/lang/Exception
  }
  
  private static void f(c paramc)
  {
    AppMethodBeat.i(5337);
    if (1 == paramc.field_type) {}
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(paramc, new String[] { "dataId" });
      g(paramc);
      AppMethodBeat.o(5337);
      return;
    }
  }
  
  static void g(c paramc)
  {
    AppMethodBeat.i(5345);
    if (paramc.field_type == 0)
    {
      com.tencent.mm.plugin.fav.a.b.a(paramc);
      AppMethodBeat.o(5345);
      return;
    }
    if (paramc.field_type == 1)
    {
      com.tencent.mm.plugin.fav.a.b.b(paramc);
      AppMethodBeat.o(5345);
      return;
    }
    AppMethodBeat.o(5345);
  }
  
  public final void ET()
  {
    AppMethodBeat.i(5340);
    this.ckH.clear();
    this.ckJ.clear();
    this.running = false;
    this.ckL = false;
    AppMethodBeat.o(5340);
  }
  
  public final void NN(String paramString)
  {
    AppMethodBeat.i(5334);
    ab.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[] { paramString });
    com.tencent.mm.kernel.g.RO().ac(new a.3(this, paramString));
    AppMethodBeat.o(5334);
  }
  
  public final void NO(String paramString)
  {
    AppMethodBeat.i(5339);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5339);
      return;
    }
    com.tencent.mm.al.f.afO().sI(paramString);
    ab.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[] { paramString });
    g(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramString));
    NU(paramString);
    AppMethodBeat.o(5339);
  }
  
  final void NU(String paramString)
  {
    AppMethodBeat.i(5344);
    this.ckL = false;
    this.ckJ.remove(paramString);
    pauseDownload(paramString);
    if (this.ckM > 0)
    {
      ahb();
      AppMethodBeat.o(5344);
      return;
    }
    ab.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
    ET();
    AppMethodBeat.o(5344);
  }
  
  final void ahb()
  {
    AppMethodBeat.i(5336);
    this.ckN = System.currentTimeMillis();
    if ((!this.ckL) && (this.ckH.size() == 0))
    {
      if (com.tencent.mm.compatible.util.f.Mi()) {
        break label88;
      }
      ab.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
      ET();
    }
    label88:
    Object localObject1;
    Object localObject2;
    while ((!this.ckL) && (this.ckH.size() <= 0))
    {
      ET();
      ab.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
      AppMethodBeat.o(5336);
      return;
      localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().bwD();
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c)((Iterator)localObject1).next();
          if (this.ckJ.containsKey(((c)localObject2).field_dataId))
          {
            ab.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + ((c)localObject2).field_dataId);
          }
          else
          {
            this.ckH.add(localObject2);
            this.ckJ.put(((c)localObject2).field_dataId, null);
          }
        }
        ab.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.ckJ.size() + ",send:" + this.ckH.size() + "]");
        this.ckH.size();
      }
    }
    if ((!this.ckL) && (this.ckH.size() > 0)) {
      try
      {
        localObject1 = (c)this.ckH.poll();
        if ((localObject1 != null) && (!bo.isNullOrNil(((c)localObject1).field_dataId)))
        {
          localObject2 = (a.a)this.muW.get(((c)localObject1).field_dataId);
          if (localObject2 == null)
          {
            localObject2 = new a.a(this, (byte)0);
            ((a.a)localObject2).gjM = 1;
            ((a.a)localObject2).mvf = bo.aoy();
            this.muW.put(((c)localObject1).field_dataId, localObject2);
            if (((c)localObject1).field_type != 0) {
              break label830;
            }
            ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(((c)localObject1).field_favLocalId), ((c)localObject1).field_dataId, Integer.valueOf(((c)localObject1).field_type), Integer.valueOf(((c)localObject1).field_dataType) });
            i = 1;
            if (i == 0) {
              break label1391;
            }
            this.ckL = true;
            if (localObject1 == null) {
              break label1367;
            }
            ab.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[] { ((c)localObject1).field_dataId });
            localObject2 = new com.tencent.mm.i.g();
            ((com.tencent.mm.i.g)localObject2).edp = this.fFy;
            ((com.tencent.mm.i.g)localObject2).field_mediaId = ((c)localObject1).field_dataId;
            if (((c)localObject1).field_type != 0) {
              break label1249;
            }
            ((com.tencent.mm.i.g)localObject2).cMU = true;
            ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.ecE;
            ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
            ((com.tencent.mm.i.g)localObject2).field_totalLen = ((c)localObject1).field_totalLen;
            ((com.tencent.mm.i.g)localObject2).field_aesKey = ((c)localObject1).field_cdnKey;
            ((com.tencent.mm.i.g)localObject2).field_fileId = ((c)localObject1).field_cdnUrl;
            ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = ((c)localObject1).bwi();
            ((com.tencent.mm.i.g)localObject2).field_fullpath = ((c)localObject1).field_path;
            if (!e.cN(((com.tencent.mm.i.g)localObject2).field_fullpath)) {
              ab.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[] { ((c)localObject1).field_path });
            }
            if (!((c)localObject1).bwi()) {
              break label1232;
            }
            ((com.tencent.mm.i.g)localObject2).field_fileType = eo(((c)localObject1).field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
            ((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn = true;
            ((com.tencent.mm.i.g)localObject2).field_trysafecdn = false;
            ab.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
            com.tencent.mm.al.f.afO().e((com.tencent.mm.i.g)localObject2);
            AppMethodBeat.o(5336);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        c localc;
        for (;;)
        {
          int i;
          localc = null;
          continue;
          if ((bo.aoy() - ((a.a)localObject2).mvf > 180000L) && (((a.a)localObject2).errCode != -6101))
          {
            ((a.a)localObject2).gjM = 1;
            ((a.a)localObject2).mvf = bo.aoy();
            this.muW.put(localc.field_dataId, localObject2);
          }
          else if (((a.a)localObject2).gjM <= 3)
          {
            ((a.a)localObject2).gjM += 1;
            this.muW.put(localc.field_dataId, localObject2);
          }
          else
          {
            ab.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            f(localc);
            i = 0;
            continue;
            label830:
            if ((this.muX.contains(localc.field_dataId)) || (com.tencent.mm.plugin.fav.a.b.Nz(localc.field_dataId)))
            {
              ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!at.isWifi(ah.getContext()))
            {
              ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              f(localc);
              i = 0;
            }
            else if (localc.field_type == 0)
            {
              ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
            }
            else if (!this.mva)
            {
              ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              this.muZ = 0;
            }
            else if (this.muZ < 10)
            {
              ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[] { Integer.valueOf(10), Integer.valueOf(this.muZ), Integer.valueOf(((a.a)localObject2).gjM), Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              if (((a.a)localObject2).gjM == 1) {
                this.muZ += 1;
              }
            }
            else
            {
              ab.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[] { Integer.valueOf(10) });
              i = 0;
              continue;
              label1232:
              ((com.tencent.mm.i.g)localObject2).field_fileType = eo(localc.field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
            }
          }
        }
        label1249:
        ((com.tencent.mm.i.g)localObject2).cMU = false;
        ((com.tencent.mm.i.g)localObject2).field_totalLen = localc.field_totalLen;
        ((com.tencent.mm.i.g)localObject2).field_aesKey = localc.field_cdnKey;
        ((com.tencent.mm.i.g)localObject2).field_fileId = localc.field_cdnUrl;
        ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.ecF;
        ((com.tencent.mm.i.g)localObject2).edp = this.fFy;
        ((com.tencent.mm.i.g)localObject2).field_fullpath = (localc.field_path + ".temp");
        ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
        ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = localc.bwi();
        if (localc.bwi()) {}
        for (((com.tencent.mm.i.g)localObject2).field_fileType = eo(localc.field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);; ((com.tencent.mm.i.g)localObject2).field_fileType = eo(localc.field_extFlag, com.tencent.mm.i.a.MediaType_FAVORITE_FILE))
        {
          com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject2, -1);
          g(localc);
          label1367:
          AppMethodBeat.o(5336);
          return;
        }
        label1391:
        if (this.muZ >= 10)
        {
          ET();
          AppMethodBeat.o(5336);
          return;
        }
        this.ckR.ag(500L, 500L);
      }
    }
    AppMethodBeat.o(5336);
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(5346);
    if (paramc != null) {
      this.ckH.add(paramc);
    }
    AppMethodBeat.o(5346);
  }
  
  public final void hw(final boolean paramBoolean)
  {
    AppMethodBeat.i(5333);
    com.tencent.mm.kernel.g.RO().ac(new Runnable()
    {
      public final void run()
      {
        a.this.mva = paramBoolean;
        a.this.muZ = 0;
      }
    });
    AppMethodBeat.o(5333);
  }
  
  public final void pauseDownload(String paramString)
  {
    AppMethodBeat.i(5338);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5338);
      return;
    }
    if (this.ckJ.containsKey(paramString))
    {
      com.tencent.mm.al.f.afO().sJ(paramString);
      ab.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[] { paramString });
      g(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(paramString));
      NU(paramString);
    }
    AppMethodBeat.o(5338);
  }
  
  public final void run()
  {
    AppMethodBeat.i(5335);
    ab.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
    com.tencent.mm.kernel.g.RO().caB().removeCallbacks(this.mvb);
    com.tencent.mm.kernel.g.RO().ac(this.mvb);
    AppMethodBeat.o(5335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a
 * JD-Core Version:    0.7.0.1
 */