package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.j.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private Queue<c> bDS = new LinkedList();
  private Map<String, g.a> bDU = new HashMap();
  boolean bDW = false;
  boolean bDX = false;
  public int bDY = 0;
  long bDZ = 0L;
  public am bEd = new am(g.DS().mnU.getLooper(), new a.5(this), false);
  public n eiF = new a.1(this);
  private f.a epa = new a.6(this);
  Map<String, a.a> kaA = new HashMap();
  Set<String> kaB = new HashSet();
  boolean kaC = aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext());
  int kaD = 0;
  boolean kaE = true;
  private Runnable kaF = new a.4(this);
  
  public a()
  {
    g.DQ();
    g.DO().a(this.eiF);
  }
  
  /* Error */
  static boolean CR(String paramString)
  {
    // Byte code:
    //   0: new 152	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 154
    //   7: invokespecial 157	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: astore_0
    //   13: bipush 6
    //   15: newarray byte
    //   17: astore 4
    //   19: aload_3
    //   20: astore_0
    //   21: aload_3
    //   22: aload 4
    //   24: iconst_0
    //   25: bipush 6
    //   27: invokevirtual 161	java/io/RandomAccessFile:read	([BII)I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpne +24 -> 57
    //   36: aload_3
    //   37: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   40: iconst_0
    //   41: ireturn
    //   42: astore_0
    //   43: ldc 166
    //   45: aload_0
    //   46: ldc 168
    //   48: iconst_0
    //   49: anewarray 4	java/lang/Object
    //   52: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_3
    //   58: astore_0
    //   59: new 176	java/lang/String
    //   62: dup
    //   63: aload 4
    //   65: invokespecial 179	java/lang/String:<init>	([B)V
    //   68: astore 4
    //   70: aload_3
    //   71: astore_0
    //   72: ldc 166
    //   74: new 181	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 183
    //   80: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload 4
    //   85: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 192
    //   90: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 199	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: astore_0
    //   101: aload 4
    //   103: ldc 201
    //   105: invokevirtual 204	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   108: istore_2
    //   109: aload_3
    //   110: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   113: iload_2
    //   114: ireturn
    //   115: astore_0
    //   116: ldc 166
    //   118: aload_0
    //   119: ldc 168
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: goto -15 -> 113
    //   131: astore 4
    //   133: aconst_null
    //   134: astore_3
    //   135: aload_3
    //   136: astore_0
    //   137: ldc 166
    //   139: aload 4
    //   141: ldc 168
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_3
    //   151: ifnull -111 -> 40
    //   154: aload_3
    //   155: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_0
    //   161: ldc 166
    //   163: aload_0
    //   164: ldc 168
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   186: aload_3
    //   187: athrow
    //   188: astore_0
    //   189: ldc 166
    //   191: aload_0
    //   192: ldc 168
    //   194: iconst_0
    //   195: anewarray 4	java/lang/Object
    //   198: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: goto -15 -> 186
    //   204: astore_3
    //   205: goto -27 -> 178
    //   208: astore 4
    //   210: goto -75 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   30	4	1	i	int
    //   108	6	2	bool	boolean
    //   10	145	3	localRandomAccessFile	java.io.RandomAccessFile
    //   175	12	3	localObject1	Object
    //   204	1	3	localObject2	Object
    //   17	85	4	localObject3	Object
    //   131	9	4	localException1	java.lang.Exception
    //   208	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	40	42	java/io/IOException
    //   109	113	115	java/io/IOException
    //   0	11	131	java/lang/Exception
    //   154	158	160	java/io/IOException
    //   0	11	175	finally
    //   182	186	188	java/io/IOException
    //   13	19	204	finally
    //   21	31	204	finally
    //   59	70	204	finally
    //   72	99	204	finally
    //   101	109	204	finally
    //   137	150	204	finally
    //   13	19	208	java/lang/Exception
    //   21	31	208	java/lang/Exception
    //   59	70	208	java/lang/Exception
    //   72	99	208	java/lang/Exception
    //   101	109	208	java/lang/Exception
  }
  
  private static int cQ(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 0) {
      return paramInt2;
    }
    y.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", new Object[] { Integer.valueOf(paramInt2) });
    if (com.tencent.mm.j.a.MediaType_FAVORITE_VIDEO == paramInt2) {
      return com.tencent.mm.j.a.MediaType_FAVORITE_FILE;
    }
    return com.tencent.mm.j.a.MediaType_FAVORITE_VIDEO;
  }
  
  /* Error */
  static boolean dc(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 367	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore_0
    //   5: aload_1
    //   6: iconst_0
    //   7: invokestatic 370	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   10: astore_1
    //   11: aload_1
    //   12: astore 6
    //   14: aload_0
    //   15: astore 5
    //   17: sipush 16384
    //   20: newarray byte
    //   22: astore 7
    //   24: aload_1
    //   25: astore 6
    //   27: aload_0
    //   28: astore 5
    //   30: aload_1
    //   31: ldc 201
    //   33: invokevirtual 374	java/lang/String:getBytes	()[B
    //   36: invokevirtual 379	java/io/OutputStream:write	([B)V
    //   39: aload_1
    //   40: astore 6
    //   42: aload_0
    //   43: astore 5
    //   45: aload_0
    //   46: aload 7
    //   48: invokevirtual 384	java/io/InputStream:read	([B)I
    //   51: istore_2
    //   52: iload_2
    //   53: iconst_m1
    //   54: if_icmpeq +63 -> 117
    //   57: aload_1
    //   58: astore 6
    //   60: aload_0
    //   61: astore 5
    //   63: aload_1
    //   64: aload 7
    //   66: iconst_0
    //   67: iload_2
    //   68: invokevirtual 387	java/io/OutputStream:write	([BII)V
    //   71: goto -32 -> 39
    //   74: astore 7
    //   76: aload_1
    //   77: astore 6
    //   79: aload_0
    //   80: astore 5
    //   82: ldc 166
    //   84: aload 7
    //   86: ldc 168
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_0
    //   96: ifnull +7 -> 103
    //   99: aload_0
    //   100: invokevirtual 388	java/io/InputStream:close	()V
    //   103: aload_1
    //   104: ifnull +195 -> 299
    //   107: aload_1
    //   108: invokevirtual 389	java/io/OutputStream:close	()V
    //   111: iconst_0
    //   112: istore 4
    //   114: iload 4
    //   116: ireturn
    //   117: iconst_1
    //   118: istore 4
    //   120: iload 4
    //   122: istore_3
    //   123: aload_0
    //   124: ifnull +10 -> 134
    //   127: aload_0
    //   128: invokevirtual 388	java/io/InputStream:close	()V
    //   131: iload 4
    //   133: istore_3
    //   134: iload_3
    //   135: istore 4
    //   137: aload_1
    //   138: ifnull -24 -> 114
    //   141: aload_1
    //   142: invokevirtual 389	java/io/OutputStream:close	()V
    //   145: iload_3
    //   146: ireturn
    //   147: astore_0
    //   148: ldc 166
    //   150: aload_0
    //   151: ldc 168
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_0
    //   163: ldc 166
    //   165: aload_0
    //   166: ldc 168
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -43 -> 134
    //   180: astore_0
    //   181: ldc 166
    //   183: aload_0
    //   184: ldc 168
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: goto -90 -> 103
    //   196: astore_0
    //   197: ldc 166
    //   199: aload_0
    //   200: ldc 168
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: iconst_0
    //   210: ireturn
    //   211: astore_1
    //   212: aconst_null
    //   213: astore 6
    //   215: aconst_null
    //   216: astore_0
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 388	java/io/InputStream:close	()V
    //   225: aload 6
    //   227: ifnull +8 -> 235
    //   230: aload 6
    //   232: invokevirtual 389	java/io/OutputStream:close	()V
    //   235: aload_1
    //   236: athrow
    //   237: astore_0
    //   238: ldc 166
    //   240: aload_0
    //   241: ldc 168
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: goto -25 -> 225
    //   253: astore_0
    //   254: ldc 166
    //   256: aload_0
    //   257: ldc 168
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 174	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: goto -31 -> 235
    //   269: astore_1
    //   270: aconst_null
    //   271: astore 6
    //   273: goto -56 -> 217
    //   276: astore_1
    //   277: aload 5
    //   279: astore_0
    //   280: goto -63 -> 217
    //   283: astore 7
    //   285: aconst_null
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_0
    //   289: goto -213 -> 76
    //   292: astore 7
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -220 -> 76
    //   299: iconst_0
    //   300: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramString1	String
    //   0	301	1	paramString2	String
    //   51	17	2	i	int
    //   122	55	3	bool1	boolean
    //   112	24	4	bool2	boolean
    //   15	263	5	str1	String
    //   12	260	6	str2	String
    //   22	43	7	arrayOfByte	byte[]
    //   74	11	7	localException1	java.lang.Exception
    //   283	1	7	localException2	java.lang.Exception
    //   292	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   17	24	74	java/lang/Exception
    //   30	39	74	java/lang/Exception
    //   45	52	74	java/lang/Exception
    //   63	71	74	java/lang/Exception
    //   141	145	147	java/io/IOException
    //   127	131	162	java/io/IOException
    //   99	103	180	java/io/IOException
    //   107	111	196	java/io/IOException
    //   0	5	211	finally
    //   221	225	237	java/io/IOException
    //   230	235	253	java/io/IOException
    //   5	11	269	finally
    //   17	24	276	finally
    //   30	39	276	finally
    //   45	52	276	finally
    //   63	71	276	finally
    //   82	95	276	finally
    //   0	5	283	java/lang/Exception
    //   5	11	292	java/lang/Exception
  }
  
  private static void f(c paramc)
  {
    if (1 == paramc.field_type) {}
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().a(paramc, new String[] { "dataId" });
      g(paramc);
      return;
    }
  }
  
  static void g(c paramc)
  {
    if (paramc.field_type == 0) {
      com.tencent.mm.plugin.fav.a.b.a(paramc);
    }
    while (paramc.field_type != 1) {
      return;
    }
    com.tencent.mm.plugin.fav.a.b.b(paramc);
  }
  
  public final void CL(String paramString)
  {
    y.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[] { paramString });
    g.DS().O(new a.3(this, paramString));
  }
  
  public final void CM(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    com.tencent.mm.ak.f.Nd().lL(paramString);
    y.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[] { paramString });
    g(((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().CN(paramString));
    CS(paramString);
  }
  
  final void CS(String paramString)
  {
    this.bDW = false;
    this.bDU.remove(paramString);
    pauseDownload(paramString);
    if (this.bDY > 0)
    {
      Om();
      return;
    }
    y.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
    uB();
  }
  
  final void Om()
  {
    this.bDZ = System.currentTimeMillis();
    if ((!this.bDW) && (this.bDS.size() == 0))
    {
      if (!com.tencent.mm.compatible.util.f.zF())
      {
        y.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
        uB();
      }
    }
    else
    {
      if ((this.bDW) || (this.bDS.size() > 0)) {
        break label274;
      }
      uB();
      y.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
    }
    for (;;)
    {
      return;
      Object localObject1 = ((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().aQo();
      if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (this.bDU.containsKey(((c)localObject2).field_dataId))
        {
          y.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + ((c)localObject2).field_dataId);
        }
        else
        {
          this.bDS.add(localObject2);
          this.bDU.put(((c)localObject2).field_dataId, null);
        }
      }
      y.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.bDU.size() + ",send:" + this.bDS.size() + "]");
      this.bDS.size();
      break;
      label274:
      if ((!this.bDW) && (this.bDS.size() > 0)) {
        try
        {
          localObject1 = (c)this.bDS.poll();
          if ((localObject1 != null) && (!bk.bl(((c)localObject1).field_dataId)))
          {
            localObject2 = (a.a)this.kaA.get(((c)localObject1).field_dataId);
            if (localObject2 == null)
            {
              localObject2 = new a.a(this, (byte)0);
              ((a.a)localObject2).eRR = 1;
              ((a.a)localObject2).kaJ = bk.UY();
              this.kaA.put(((c)localObject1).field_dataId, localObject2);
              if (((c)localObject1).field_type != 0) {
                break label812;
              }
              y.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(((c)localObject1).field_favLocalId), ((c)localObject1).field_dataId, Integer.valueOf(((c)localObject1).field_type), Integer.valueOf(((c)localObject1).field_dataType) });
              i = 1;
              if (i == 0) {
                break label1367;
              }
              this.bDW = true;
              if (localObject1 == null) {
                continue;
              }
              y.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[] { ((c)localObject1).field_dataId });
              localObject2 = new com.tencent.mm.j.f();
              ((com.tencent.mm.j.f)localObject2).dlP = this.epa;
              ((com.tencent.mm.j.f)localObject2).field_mediaId = ((c)localObject1).field_dataId;
              if (((c)localObject1).field_type != 0) {
                break label1231;
              }
              ((com.tencent.mm.j.f)localObject2).ceg = true;
              ((com.tencent.mm.j.f)localObject2).field_priority = com.tencent.mm.j.a.dlj;
              ((com.tencent.mm.j.f)localObject2).field_needStorage = true;
              ((com.tencent.mm.j.f)localObject2).field_totalLen = ((c)localObject1).field_totalLen;
              ((com.tencent.mm.j.f)localObject2).field_aesKey = ((c)localObject1).field_cdnKey;
              ((com.tencent.mm.j.f)localObject2).field_fileId = ((c)localObject1).field_cdnUrl;
              ((com.tencent.mm.j.f)localObject2).field_isStreamMedia = ((c)localObject1).aPU();
              ((com.tencent.mm.j.f)localObject2).field_fullpath = ((c)localObject1).field_path;
              if (!e.bK(((com.tencent.mm.j.f)localObject2).field_fullpath)) {
                y.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[] { ((c)localObject1).field_path });
              }
              if (!((c)localObject1).aPU()) {
                break label1214;
              }
              ((com.tencent.mm.j.f)localObject2).field_fileType = cQ(((c)localObject1).field_extFlag, com.tencent.mm.j.a.MediaType_FAVORITE_VIDEO);
              ((com.tencent.mm.j.f)localObject2).field_force_aeskeycdn = true;
              ((com.tencent.mm.j.f)localObject2).field_trysafecdn = false;
              y.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[] { Boolean.valueOf(((com.tencent.mm.j.f)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.j.f)localObject2).field_trysafecdn) });
              com.tencent.mm.ak.f.Nd().c((com.tencent.mm.j.f)localObject2);
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
            if ((bk.UY() - ((a.a)localObject2).kaJ > 180000L) && (((a.a)localObject2).errCode != -6101))
            {
              ((a.a)localObject2).eRR = 1;
              ((a.a)localObject2).kaJ = bk.UY();
              this.kaA.put(localc.field_dataId, localObject2);
            }
            else if (((a.a)localObject2).eRR <= 3)
            {
              ((a.a)localObject2).eRR += 1;
              this.kaA.put(localc.field_dataId, localObject2);
            }
            else
            {
              y.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              f(localc);
              i = 0;
              continue;
              label812:
              if ((this.kaB.contains(localc.field_dataId)) || (com.tencent.mm.plugin.fav.a.b.Cx(localc.field_dataId)))
              {
                y.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              }
              else if (!aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext()))
              {
                y.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
                f(localc);
                i = 0;
              }
              else if (localc.field_type == 0)
              {
                y.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
              }
              else if (!this.kaE)
              {
                y.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[] { Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
                this.kaD = 0;
              }
              else if (this.kaD < 10)
              {
                y.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[] { Integer.valueOf(10), Integer.valueOf(this.kaD), Integer.valueOf(((a.a)localObject2).eRR), Long.valueOf(localc.field_favLocalId), localc.field_dataId, Integer.valueOf(localc.field_type), Integer.valueOf(localc.field_dataType) });
                if (((a.a)localObject2).eRR == 1) {
                  this.kaD += 1;
                }
              }
              else
              {
                y.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[] { Integer.valueOf(10) });
                i = 0;
                continue;
                label1214:
                ((com.tencent.mm.j.f)localObject2).field_fileType = cQ(localc.field_extFlag, com.tencent.mm.j.a.MediaType_FAVORITE_FILE);
              }
            }
          }
          label1231:
          ((com.tencent.mm.j.f)localObject2).ceg = false;
          ((com.tencent.mm.j.f)localObject2).field_totalLen = localc.field_totalLen;
          ((com.tencent.mm.j.f)localObject2).field_aesKey = localc.field_cdnKey;
          ((com.tencent.mm.j.f)localObject2).field_fileId = localc.field_cdnUrl;
          ((com.tencent.mm.j.f)localObject2).field_priority = com.tencent.mm.j.a.dlk;
          ((com.tencent.mm.j.f)localObject2).dlP = this.epa;
          ((com.tencent.mm.j.f)localObject2).field_fullpath = (localc.field_path + ".temp");
          ((com.tencent.mm.j.f)localObject2).field_needStorage = true;
          ((com.tencent.mm.j.f)localObject2).field_isStreamMedia = localc.aPU();
          if (localc.aPU()) {}
          for (((com.tencent.mm.j.f)localObject2).field_fileType = cQ(localc.field_extFlag, com.tencent.mm.j.a.MediaType_FAVORITE_VIDEO);; ((com.tencent.mm.j.f)localObject2).field_fileType = cQ(localc.field_extFlag, com.tencent.mm.j.a.MediaType_FAVORITE_FILE))
          {
            com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject2, -1);
            g(localc);
            return;
          }
          label1367:
          if (this.kaD >= 10)
          {
            uB();
            return;
          }
          this.bEd.S(500L, 500L);
        }
      }
    }
  }
  
  public final void c(c paramc)
  {
    if (paramc != null) {
      this.bDS.add(paramc);
    }
  }
  
  public final void fS(boolean paramBoolean)
  {
    g.DS().O(new a.2(this, paramBoolean));
  }
  
  public final void pauseDownload(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (!this.bDU.containsKey(paramString)) {
      return;
    }
    com.tencent.mm.ak.f.Nd().lM(paramString);
    y.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[] { paramString });
    g(((com.tencent.mm.plugin.fav.a.ae)g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().CN(paramString));
    CS(paramString);
  }
  
  public final void run()
  {
    y.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
    g.DS().crf().removeCallbacks(this.kaF);
    g.DS().O(this.kaF);
  }
  
  public final void uB()
  {
    this.bDS.clear();
    this.bDU.clear();
    this.bDX = false;
    this.bDW = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a
 * JD-Core Version:    0.7.0.1
 */