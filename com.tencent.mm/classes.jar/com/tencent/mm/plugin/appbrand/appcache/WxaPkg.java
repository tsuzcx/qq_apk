package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgBaseImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.b;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class WxaPkg
  implements p, Closeable
{
  public static final ByteOrder nGz = ByteOrder.BIG_ENDIAN;
  public final q mFile;
  public volatile boolean nEb;
  private volatile Map<String, WxaPkg.Info> nEh;
  private volatile RandomAccessFile nGA;
  private volatile FileChannel nGB;
  private volatile FileStructStat nGC;
  private volatile int nGD;
  private volatile com.tencent.mm.plugin.appbrand.appcache.pkg.a nGE;
  
  public WxaPkg(q paramq)
  {
    AppMethodBeat.i(175554);
    this.nGB = null;
    this.nEb = true;
    this.nEh = null;
    this.nGD = -1;
    this.mFile = paramq;
    int i;
    if ((this.mFile == null) || (!this.mFile.ifE()))
    {
      i = 0;
      if ((i == 0) || (bHs() < 0)) {
        break label101;
      }
    }
    for (;;)
    {
      this.nEb = bool;
      AppMethodBeat.o(175554);
      return;
      if (this.mFile.length() > 14L)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label101:
      bool = false;
    }
  }
  
  public WxaPkg(String paramString)
  {
    this(new q(paramString));
    AppMethodBeat.i(134276);
    AppMethodBeat.o(134276);
  }
  
  /* Error */
  private InputStream a(WxaPkg.Info paramInfo)
  {
    // Byte code:
    //   0: ldc 90
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 60	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:mFile	Lcom/tencent/mm/vfs/q;
    //   9: invokevirtual 94	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   12: iconst_0
    //   13: invokestatic 100	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_1
    //   20: getfield 103	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:nEz	I
    //   23: newarray byte
    //   25: astore 4
    //   27: aload_3
    //   28: astore_2
    //   29: aload_3
    //   30: aload_1
    //   31: getfield 106	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:nEy	I
    //   34: i2l
    //   35: invokevirtual 112	java/io/RandomAccessFile:seek	(J)V
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: aload 4
    //   43: invokevirtual 116	java/io/RandomAccessFile:readFully	([B)V
    //   46: aload_3
    //   47: astore_2
    //   48: new 118	java/io/ByteArrayInputStream
    //   51: dup
    //   52: aload 4
    //   54: invokespecial 120	java/io/ByteArrayInputStream:<init>	([B)V
    //   57: astore 4
    //   59: aload_3
    //   60: invokestatic 126	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   63: ldc 90
    //   65: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload 4
    //   70: areturn
    //   71: astore 4
    //   73: aconst_null
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: ldc 128
    //   79: ldc 130
    //   81: iconst_3
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_0
    //   88: getfield 60	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:mFile	Lcom/tencent/mm/vfs/q;
    //   91: invokevirtual 94	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_1
    //   98: getfield 134	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:fileName	Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: iconst_2
    //   104: aload 4
    //   106: aastore
    //   107: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_3
    //   111: invokestatic 126	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   114: ldc 90
    //   116: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: invokestatic 126	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   128: ldc 90
    //   130: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: goto -12 -> 124
    //   139: astore 4
    //   141: goto -66 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	WxaPkg
    //   0	144	1	paramInfo	WxaPkg.Info
    //   18	107	2	localRandomAccessFile1	RandomAccessFile
    //   16	95	3	localRandomAccessFile2	RandomAccessFile
    //   25	44	4	localObject	Object
    //   71	34	4	localException1	Exception
    //   139	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	17	71	java/lang/Exception
    //   5	17	121	finally
    //   19	27	135	finally
    //   29	38	135	finally
    //   40	46	135	finally
    //   48	59	135	finally
    //   77	110	135	finally
    //   19	27	139	java/lang/Exception
    //   29	38	139	java/lang/Exception
    //   40	46	139	java/lang/Exception
    //   48	59	139	java/lang/Exception
  }
  
  /* Error */
  public static int acQ(String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc 145
    //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 62	com/tencent/mm/vfs/q
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 82	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 66	com/tencent/mm/vfs/q:ifE	()Z
    //   22: ifne +10 -> 32
    //   25: ldc 145
    //   27: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_m1
    //   31: ireturn
    //   32: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   35: lstore_2
    //   36: new 2	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 84	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Lcom/tencent/mm/vfs/q;)V
    //   45: astore 6
    //   47: aconst_null
    //   48: astore 5
    //   50: aload 6
    //   52: getfield 54	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:nEb	Z
    //   55: ifeq +9 -> 64
    //   58: aload 6
    //   60: invokevirtual 70	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bHs	()I
    //   63: istore_1
    //   64: aload 6
    //   66: invokevirtual 151	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   69: ldc 128
    //   71: ldc 153
    //   73: iconst_2
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   86: lload_2
    //   87: lsub
    //   88: invokestatic 159	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   91: aastore
    //   92: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: ldc 145
    //   97: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iload_1
    //   101: ireturn
    //   102: astore 5
    //   104: ldc 145
    //   106: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload 5
    //   111: athrow
    //   112: astore 4
    //   114: aload 5
    //   116: ifnull +64 -> 180
    //   119: aload 6
    //   121: invokevirtual 151	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   124: ldc 145
    //   126: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload 4
    //   131: athrow
    //   132: astore 4
    //   134: ldc 128
    //   136: ldc 153
    //   138: iconst_2
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_0
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   151: lload_2
    //   152: lsub
    //   153: invokestatic 159	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   156: aastore
    //   157: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: ldc 145
    //   162: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 4
    //   167: athrow
    //   168: astore 6
    //   170: aload 5
    //   172: aload 6
    //   174: invokevirtual 165	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   177: goto -53 -> 124
    //   180: aload 6
    //   182: invokevirtual 151	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   185: goto -61 -> 124
    //   188: astore 4
    //   190: goto -76 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramString	String
    //   1	100	1	i	int
    //   35	117	2	l	long
    //   15	26	4	localq	q
    //   112	18	4	localObject1	Object
    //   132	34	4	localObject2	Object
    //   188	1	4	localObject3	Object
    //   48	1	5	localObject4	Object
    //   102	69	5	localThrowable1	java.lang.Throwable
    //   45	75	6	localWxaPkg	WxaPkg
    //   168	13	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   50	64	102	java/lang/Throwable
    //   104	112	112	finally
    //   36	47	132	finally
    //   64	69	132	finally
    //   119	124	132	finally
    //   124	132	132	finally
    //   170	177	132	finally
    //   180	185	132	finally
    //   119	124	168	java/lang/Throwable
    //   50	64	188	finally
  }
  
  private boolean bHr()
  {
    AppMethodBeat.i(225127);
    if (!open())
    {
      AppMethodBeat.o(225127);
      return false;
    }
    int i = bHs();
    if (i < 0)
    {
      AppMethodBeat.o(225127);
      return false;
    }
    Object localObject = null;
    switch (i)
    {
    }
    for (;;)
    {
      this.nGE = ((com.tencent.mm.plugin.appbrand.appcache.pkg.a)localObject);
      if (this.nGE != null) {
        break;
      }
      Log.e("MicroMsg.WxaPkg", "parseHeader, mIWxaPkgAction is null");
      AppMethodBeat.o(225127);
      return false;
      localObject = new b();
      continue;
      localObject = new WxaPkgMixedImpl();
    }
    try
    {
      boolean bool = this.nGE.a(this.nGB);
      AppMethodBeat.o(225127);
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.WxaPkg", "parseHeader, exp = %s", new Object[] { Util.stackTraceToString(localIOException) });
      AppMethodBeat.o(225127);
    }
    return false;
  }
  
  /* Error */
  public static String cy(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 199
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 2	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 200	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 203	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bGl	()Z
    //   18: pop
    //   19: aload_2
    //   20: aload_1
    //   21: invokevirtual 207	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:acB	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: invokestatic 213	com/tencent/mm/plugin/appbrand/ac/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 151	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   32: ldc 199
    //   34: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: ldc 199
    //   42: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: aload_1
    //   49: ifnull +31 -> 80
    //   52: aload_2
    //   53: invokevirtual 151	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   56: ldc 199
    //   58: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: athrow
    //   63: astore_0
    //   64: ldc 199
    //   66: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_2
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 165	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   77: goto -21 -> 56
    //   80: aload_2
    //   81: invokevirtual 151	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   84: goto -28 -> 56
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -42 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString1	String
    //   0	93	1	paramString2	String
    //   13	40	2	localWxaPkg	WxaPkg
    //   71	10	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   14	28	39	java/lang/Throwable
    //   40	47	47	finally
    //   5	14	63	java/lang/Exception
    //   28	32	63	java/lang/Exception
    //   52	56	63	java/lang/Exception
    //   56	63	63	java/lang/Exception
    //   72	77	63	java/lang/Exception
    //   80	84	63	java/lang/Exception
    //   52	56	71	java/lang/Throwable
    //   14	28	87	finally
  }
  
  private boolean open()
  {
    AppMethodBeat.i(225137);
    if (this.nGB != null)
    {
      AppMethodBeat.o(225137);
      return true;
    }
    try
    {
      RandomAccessFile localRandomAccessFile = u.dO(this.mFile.getPath(), false);
      this.nGA = localRandomAccessFile;
      this.nGB = localRandomAccessFile.getChannel();
      AppMethodBeat.o(225137);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e("MicroMsg.WxaPkg", "open(), exp = %s", new Object[] { Util.stackTraceToString(localFileNotFoundException) });
      AppMethodBeat.o(225137);
    }
    return false;
  }
  
  public final InputStream acB(String paramString)
  {
    AppMethodBeat.i(134281);
    WxaPkg.Info localInfo = openReadPartialInfo(paramString);
    if ((this.nGE != null) && (this.nGE.b(localInfo)))
    {
      if (localInfo != null)
      {
        paramString = this.nGE;
        AppMethodBeat.o(134281);
        return null;
      }
      Log.w("MicroMsg.WxaPkg", "can't find info of file: %s", new Object[] { paramString });
      AppMethodBeat.o(134281);
      return null;
    }
    if (localInfo != null)
    {
      if (Thread.currentThread().isInterrupted())
      {
        paramString = a(localInfo);
        AppMethodBeat.o(134281);
        return paramString;
      }
      try
      {
        Object localObject = this.nGB.map(FileChannel.MapMode.READ_ONLY, localInfo.nEy, localInfo.nEz);
        ((MappedByteBuffer)localObject).order(nGz);
        ((MappedByteBuffer)localObject).limit(localInfo.nEz);
        localObject = new com.tencent.luggage.k.a((ByteBuffer)localObject);
        AppMethodBeat.o(134281);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WxaPkg", "handleOpenReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[] { paramString, Integer.valueOf(localInfo.nEy), Integer.valueOf(localInfo.nEz), Util.stackTraceToString(localException) });
        AppMethodBeat.o(134281);
        return null;
      }
    }
    Log.w("MicroMsg.WxaPkg", "can't find info of file: %s", new Object[] { paramString });
    AppMethodBeat.o(134281);
    return null;
  }
  
  public final String bGk()
  {
    AppMethodBeat.i(292997);
    String str = this.mFile.bOF();
    AppMethodBeat.o(292997);
    return str;
  }
  
  public final boolean bGl()
  {
    AppMethodBeat.i(134283);
    if (!this.nEb)
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) valid==false", new Object[] { this.mFile.bOF() });
      AppMethodBeat.o(134283);
      return false;
    }
    if ((this.nGE == null) && (!bHr()))
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) parseHeaderFully==false", new Object[] { this.mFile.bOF() });
      AppMethodBeat.o(134283);
      return false;
    }
    if (this.nGE.bHN() <= 4)
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) getBodyInfoLength<=4", new Object[] { this.mFile.bOF() });
      AppMethodBeat.o(134283);
      return false;
    }
    if ((this.nEh != null) && (this.nGE.bHO() >= 0) && (this.nGE.bHO() == this.nEh.size()))
    {
      AppMethodBeat.o(134283);
      return true;
    }
    try
    {
      this.nEh = this.nGE.a(this.nGB, this.mFile);
      if (this.nEh != null)
      {
        AppMethodBeat.o(134283);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) getInfo failed exp = %s", new Object[] { this.mFile.bOF(), Util.stackTraceToString(localException) });
      AppMethodBeat.o(134283);
      return false;
    }
    AppMethodBeat.o(134283);
    return false;
  }
  
  public final FileStructStat bHn()
  {
    AppMethodBeat.i(134278);
    FileStructStat localFileStructStat2 = this.nGC;
    FileStructStat localFileStructStat1 = localFileStructStat2;
    if (localFileStructStat2 == null)
    {
      localFileStructStat1 = new FileStructStat();
      FileStat.b(this.mFile.bOF(), localFileStructStat1);
      this.nGC = localFileStructStat1;
    }
    AppMethodBeat.o(134278);
    return localFileStructStat1;
  }
  
  public final int bHo()
  {
    AppMethodBeat.i(292998);
    int i = bHs();
    AppMethodBeat.o(292998);
    return i;
  }
  
  public final List<WxaPkg.Info> bHp()
  {
    AppMethodBeat.i(134284);
    if (!bGl()) {
      Log.e("MicroMsg.WxaPkg", "listInfos readInfo returns false");
    }
    if (this.nEh == null)
    {
      localObject = Collections.emptyList();
      AppMethodBeat.o(134284);
      return localObject;
    }
    Object localObject = new LinkedList(this.nEh.values());
    AppMethodBeat.o(134284);
    return localObject;
  }
  
  public final List<String> bHq()
  {
    AppMethodBeat.i(225122);
    LinkedList localLinkedList = new LinkedList(this.nEh.keySet());
    AppMethodBeat.o(225122);
    return localLinkedList;
  }
  
  public final int bHs()
  {
    int j = -1;
    AppMethodBeat.i(225133);
    if (!open())
    {
      AppMethodBeat.o(225133);
      return -1;
    }
    if (this.nGD >= 0)
    {
      i = this.nGD;
      AppMethodBeat.o(225133);
      return i;
    }
    int i = j;
    try
    {
      this.nGB.position(1L);
      i = j;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      i = j;
      localByteBuffer.order(nGz);
      i = j;
      this.nGB.read(localByteBuffer);
      i = j;
      j = WxaPkgBaseImpl.B(localByteBuffer.array(), 0, 4);
      i = j;
      this.nGD = j;
      i = j;
      Log.i("MicroMsg.WxaPkg", "parsed header version:%d, path:%s", new Object[] { Integer.valueOf(j), this.mFile.bOF() });
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WxaPkg", "parseHeaderVersion, exp = %s", new Object[] { Util.stackTraceToString(localIOException) });
      }
    }
    AppMethodBeat.o(225133);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134279);
    if (this.nGB != null) {}
    try
    {
      this.nGB.close();
      this.nGB = null;
      label25:
      if (this.nGA != null) {
        try
        {
          this.nGA.close();
          this.nGA = null;
          AppMethodBeat.o(134279);
          return;
        }
        catch (IOException localIOException1) {}
      }
      AppMethodBeat.o(134279);
      return;
    }
    catch (IOException localIOException2)
    {
      break label25;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(134277);
    try
    {
      close();
      if (this.nGE != null) {
        this.nGE.close();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(134277);
    }
  }
  
  public final WxaPkg.Info openReadPartialInfo(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(134280);
    if ((this.nEh == null) || (Util.isNullOrNil(paramString)))
    {
      boolean bool;
      if (this.nEh == null)
      {
        bool = true;
        if (this.nEh != null) {
          break label81;
        }
      }
      for (;;)
      {
        Log.e("MicroMsg.WxaPkg", "handleInterruptReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        AppMethodBeat.o(134280);
        return null;
        bool = false;
        break;
        label81:
        i = this.nEh.size();
      }
    }
    WxaPkg.Info localInfo2 = (WxaPkg.Info)this.nEh.get(paramString);
    WxaPkg.Info localInfo1 = localInfo2;
    if (localInfo2 == null)
    {
      paramString = o.adS(paramString);
      localInfo1 = (WxaPkg.Info)this.nEh.get(paramString);
    }
    AppMethodBeat.o(134280);
    return localInfo1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkg
 * JD-Core Version:    0.7.0.1
 */