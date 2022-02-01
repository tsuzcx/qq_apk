package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgBaseImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.b;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  implements q, Closeable
{
  public static final ByteOrder qGr = ByteOrder.BIG_ENDIAN;
  public final u mFile;
  public volatile boolean qDW;
  private volatile Map<String, Info> qEb;
  private volatile RandomAccessFile qGs;
  private volatile FileChannel qGt;
  private volatile FileStructStat qGu;
  private volatile int qGv;
  private volatile com.tencent.mm.plugin.appbrand.appcache.pkg.a qGw;
  
  public WxaPkg(u paramu)
  {
    AppMethodBeat.i(175554);
    this.qGt = null;
    this.qDW = true;
    this.qEb = null;
    this.qGv = -1;
    this.mFile = paramu;
    int i;
    if ((this.mFile == null) || (!this.mFile.jKS()))
    {
      i = 0;
      if ((i == 0) || (cgO() < 0)) {
        break label101;
      }
    }
    for (;;)
    {
      this.qDW = bool;
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
    this(new u(paramString));
    AppMethodBeat.i(134276);
    AppMethodBeat.o(134276);
  }
  
  /* Error */
  public static int Vo(String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc 91
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 65	com/tencent/mm/vfs/u
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 85	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 69	com/tencent/mm/vfs/u:jKS	()Z
    //   22: ifne +10 -> 32
    //   25: ldc 91
    //   27: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_m1
    //   31: ireturn
    //   32: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   35: lstore_2
    //   36: new 2	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 87	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Lcom/tencent/mm/vfs/u;)V
    //   45: astore 5
    //   47: aload 5
    //   49: getfield 57	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:qDW	Z
    //   52: ifeq +9 -> 61
    //   55: aload 5
    //   57: invokevirtual 73	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:cgO	()I
    //   60: istore_1
    //   61: aload 5
    //   63: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   66: ldc 101
    //   68: ldc 103
    //   70: iconst_2
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   83: lload_2
    //   84: lsub
    //   85: invokestatic 109	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: aastore
    //   89: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: ldc 91
    //   94: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iload_1
    //   98: ireturn
    //   99: astore 4
    //   101: aload 5
    //   103: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   106: ldc 91
    //   108: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload 4
    //   113: athrow
    //   114: astore 4
    //   116: ldc 101
    //   118: ldc 103
    //   120: iconst_2
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_0
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   133: lload_2
    //   134: lsub
    //   135: invokestatic 109	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: aastore
    //   139: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: ldc 91
    //   144: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload 4
    //   149: athrow
    //   150: astore 5
    //   152: aload 4
    //   154: aload 5
    //   156: invokevirtual 120	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   159: goto -53 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   1	97	1	i	int
    //   35	99	2	l	long
    //   15	26	4	localu	u
    //   99	13	4	localObject1	Object
    //   114	39	4	localObject2	Object
    //   45	57	5	localWxaPkg	WxaPkg
    //   150	5	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   47	61	99	finally
    //   36	47	114	finally
    //   61	66	114	finally
    //   106	114	114	finally
    //   152	159	114	finally
    //   101	106	150	finally
  }
  
  /* Error */
  private InputStream a(Info paramInfo)
  {
    // Byte code:
    //   0: ldc 125
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 63	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:mFile	Lcom/tencent/mm/vfs/u;
    //   9: getfield 129	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   12: invokestatic 135	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   15: iconst_0
    //   16: invokestatic 141	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_1
    //   23: getfield 144	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:qEw	I
    //   26: newarray byte
    //   28: astore 4
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: aload_1
    //   34: getfield 147	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:qEv	I
    //   37: i2l
    //   38: invokevirtual 153	java/io/RandomAccessFile:seek	(J)V
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 4
    //   46: invokevirtual 157	java/io/RandomAccessFile:readFully	([B)V
    //   49: aload_3
    //   50: astore_2
    //   51: new 159	java/io/ByteArrayInputStream
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 161	java/io/ByteArrayInputStream:<init>	([B)V
    //   60: astore 4
    //   62: aload_3
    //   63: invokestatic 165	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   66: ldc 125
    //   68: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: astore 4
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: ldc 101
    //   82: ldc 167
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: getfield 63	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:mFile	Lcom/tencent/mm/vfs/u;
    //   94: getfield 129	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   97: invokestatic 135	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload_1
    //   104: getfield 171	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:fileName	Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload 4
    //   112: aastore
    //   113: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_3
    //   117: invokestatic 165	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   120: ldc 125
    //   122: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: invokestatic 165	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   134: ldc 125
    //   136: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: goto -12 -> 130
    //   145: astore 4
    //   147: goto -69 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	WxaPkg
    //   0	150	1	paramInfo	Info
    //   21	110	2	localRandomAccessFile1	RandomAccessFile
    //   19	98	3	localRandomAccessFile2	RandomAccessFile
    //   28	44	4	localObject	Object
    //   74	37	4	localException1	Exception
    //   145	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	20	74	java/lang/Exception
    //   5	20	127	finally
    //   22	30	141	finally
    //   32	41	141	finally
    //   43	49	141	finally
    //   51	62	141	finally
    //   80	116	141	finally
    //   22	30	145	java/lang/Exception
    //   32	41	145	java/lang/Exception
    //   43	49	145	java/lang/Exception
    //   51	62	145	java/lang/Exception
  }
  
  /* Error */
  public static String cP(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 2	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 178	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 181	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:cfK	()Z
    //   18: pop
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 185	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:Va	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: invokestatic 191	com/tencent/mm/plugin/appbrand/af/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload_0
    //   29: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   32: ldc 177
    //   34: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   44: ldc 177
    //   46: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_1
    //   50: athrow
    //   51: astore_0
    //   52: ldc 177
    //   54: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aload_1
    //   61: aload_0
    //   62: invokevirtual 120	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   65: goto -21 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramString1	String
    //   0	68	1	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   14	28	39	finally
    //   5	14	51	java/lang/Exception
    //   28	32	51	java/lang/Exception
    //   44	51	51	java/lang/Exception
    //   60	65	51	java/lang/Exception
    //   40	44	59	finally
  }
  
  private boolean cgN()
  {
    AppMethodBeat.i(320292);
    if (!open())
    {
      AppMethodBeat.o(320292);
      return false;
    }
    int i = cgO();
    if (i < 0)
    {
      AppMethodBeat.o(320292);
      return false;
    }
    Object localObject = null;
    switch (i)
    {
    }
    for (;;)
    {
      this.qGw = ((com.tencent.mm.plugin.appbrand.appcache.pkg.a)localObject);
      if (this.qGw != null) {
        break;
      }
      Log.e("MicroMsg.WxaPkg", "parseHeader, mIWxaPkgAction is null");
      AppMethodBeat.o(320292);
      return false;
      localObject = new b();
      continue;
      localObject = new WxaPkgMixedImpl();
    }
    try
    {
      boolean bool = this.qGw.a(this.qGt);
      AppMethodBeat.o(320292);
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.WxaPkg", "parseHeader, exp = %s", new Object[] { Util.stackTraceToString(localIOException) });
      AppMethodBeat.o(320292);
    }
    return false;
  }
  
  private boolean open()
  {
    AppMethodBeat.i(320294);
    if (this.qGt != null)
    {
      AppMethodBeat.o(320294);
      return true;
    }
    try
    {
      RandomAccessFile localRandomAccessFile = y.eA(ah.v(this.mFile.mUri), false);
      this.qGs = localRandomAccessFile;
      this.qGt = localRandomAccessFile.getChannel();
      AppMethodBeat.o(320294);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e("MicroMsg.WxaPkg", "open(), exp = %s", new Object[] { Util.stackTraceToString(localFileNotFoundException) });
      AppMethodBeat.o(320294);
    }
    return false;
  }
  
  public final InputStream Va(String paramString)
  {
    AppMethodBeat.i(134281);
    Info localInfo = openReadPartialInfo(paramString);
    if ((this.qGw != null) && (this.qGw.b(localInfo)))
    {
      if (localInfo != null)
      {
        paramString = this.qGw.chl();
        AppMethodBeat.o(134281);
        return paramString;
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
        Object localObject = this.qGt.map(FileChannel.MapMode.READ_ONLY, localInfo.qEv, localInfo.qEw);
        ((MappedByteBuffer)localObject).order(qGr);
        ((MappedByteBuffer)localObject).limit(localInfo.qEw);
        localObject = new com.tencent.luggage.l.a((ByteBuffer)localObject);
        AppMethodBeat.o(134281);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WxaPkg", "handleOpenReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[] { paramString, Integer.valueOf(localInfo.qEv), Integer.valueOf(localInfo.qEw), Util.stackTraceToString(localException) });
        AppMethodBeat.o(134281);
        return null;
      }
    }
    Log.w("MicroMsg.WxaPkg", "can't find info of file: %s", new Object[] { paramString });
    AppMethodBeat.o(134281);
    return null;
  }
  
  public final String cfJ()
  {
    AppMethodBeat.i(370014);
    String str = ah.v(this.mFile.jKT());
    AppMethodBeat.o(370014);
    return str;
  }
  
  public final boolean cfK()
  {
    AppMethodBeat.i(134283);
    if (!this.qDW)
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) valid==false", new Object[] { ah.v(this.mFile.jKT()) });
      AppMethodBeat.o(134283);
      return false;
    }
    if ((this.qGw == null) && (!cgN()))
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) parseHeaderFully==false", new Object[] { ah.v(this.mFile.jKT()) });
      AppMethodBeat.o(134283);
      return false;
    }
    if (this.qGw.chj() <= 4)
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) getBodyInfoLength<=4", new Object[] { ah.v(this.mFile.jKT()) });
      AppMethodBeat.o(134283);
      return false;
    }
    if ((this.qEb != null) && (this.qGw.chk() >= 0) && (this.qGw.chk() == this.qEb.size()))
    {
      AppMethodBeat.o(134283);
      return true;
    }
    try
    {
      this.qEb = this.qGw.a(this.qGt, this.mFile);
      if (this.qEb != null)
      {
        AppMethodBeat.o(134283);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WxaPkg", "readInfo, file(%s) getInfo failed exp = %s", new Object[] { ah.v(this.mFile.jKT()), Util.stackTraceToString(localException) });
      AppMethodBeat.o(134283);
      return false;
    }
    AppMethodBeat.o(134283);
    return false;
  }
  
  public final FileStructStat cgK()
  {
    AppMethodBeat.i(134278);
    FileStructStat localFileStructStat2 = this.qGu;
    FileStructStat localFileStructStat1 = localFileStructStat2;
    if (localFileStructStat2 == null)
    {
      localFileStructStat1 = new FileStructStat();
      FileStat.b(ah.v(this.mFile.jKT()), localFileStructStat1);
      this.qGu = localFileStructStat1;
    }
    AppMethodBeat.o(134278);
    return localFileStructStat1;
  }
  
  public final List<Info> cgL()
  {
    AppMethodBeat.i(134284);
    if (!cfK()) {
      Log.e("MicroMsg.WxaPkg", "listInfos readInfo returns false");
    }
    if (this.qEb == null)
    {
      localObject = Collections.emptyList();
      AppMethodBeat.o(134284);
      return localObject;
    }
    Object localObject = new LinkedList(this.qEb.values());
    AppMethodBeat.o(134284);
    return localObject;
  }
  
  public final List<String> cgM()
  {
    AppMethodBeat.i(320329);
    LinkedList localLinkedList = new LinkedList(this.qEb.keySet());
    AppMethodBeat.o(320329);
    return localLinkedList;
  }
  
  public final int cgO()
  {
    int j = -1;
    AppMethodBeat.i(320335);
    if (!open())
    {
      AppMethodBeat.o(320335);
      return -1;
    }
    if (this.qGv >= 0)
    {
      i = this.qGv;
      AppMethodBeat.o(320335);
      return i;
    }
    int i = j;
    try
    {
      this.qGt.position(1L);
      i = j;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      i = j;
      localByteBuffer.order(qGr);
      i = j;
      this.qGt.read(localByteBuffer);
      i = j;
      j = WxaPkgBaseImpl.z(localByteBuffer.array(), 0, 4);
      i = j;
      this.qGv = j;
      i = j;
      Log.i("MicroMsg.WxaPkg", "parsed header version:%d, path:%s", new Object[] { Integer.valueOf(j), ah.v(this.mFile.jKT()) });
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WxaPkg", "parseHeaderVersion, exp = %s", new Object[] { Util.stackTraceToString(localIOException) });
      }
    }
    AppMethodBeat.o(320335);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134279);
    if (this.qGt != null) {}
    try
    {
      this.qGt.close();
      this.qGt = null;
      label25:
      if (this.qGs != null) {
        try
        {
          this.qGs.close();
          this.qGs = null;
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
      if (this.qGw != null) {
        this.qGw.close();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(134277);
    }
  }
  
  public final Info openReadPartialInfo(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(134280);
    if ((this.qEb == null) || (Util.isNullOrNil(paramString)))
    {
      boolean bool;
      if (this.qEb == null)
      {
        bool = true;
        if (this.qEb != null) {
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
        i = this.qEb.size();
      }
    }
    Info localInfo2 = (Info)this.qEb.get(paramString);
    Info localInfo1 = localInfo2;
    if (localInfo2 == null)
    {
      paramString = t.as(paramString, true);
      localInfo1 = (Info)this.qEb.get(paramString);
    }
    AppMethodBeat.o(134280);
    return localInfo1;
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public final String fileName;
    public final int qEv;
    public final int qEw;
    public final String qGx;
    
    static
    {
      AppMethodBeat.i(182981);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(182981);
    }
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(182980);
      this.qGx = paramParcel.readString();
      this.fileName = paramParcel.readString();
      this.qEv = paramParcel.readInt();
      this.qEw = paramParcel.readInt();
      AppMethodBeat.o(182980);
    }
    
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.qGx = paramString1;
      this.fileName = paramString2;
      this.qEv = paramInt1;
      this.qEw = paramInt2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(182979);
      paramParcel.writeString(this.qGx);
      paramParcel.writeString(this.fileName);
      paramParcel.writeInt(this.qEv);
      paramParcel.writeInt(this.qEw);
      AppMethodBeat.o(182979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkg
 * JD-Core Version:    0.7.0.1
 */