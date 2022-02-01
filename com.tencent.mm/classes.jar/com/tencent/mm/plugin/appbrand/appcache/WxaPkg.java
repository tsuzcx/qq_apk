package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgBaseImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl;
import com.tencent.mm.plugin.appbrand.appcache.pkg.b;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
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
  public static final ByteOrder iNA = ByteOrder.BIG_ENDIAN;
  public final e fGL;
  public volatile boolean iLs;
  volatile Map<String, WxaPkg.Info> iLy;
  private volatile RandomAccessFile iNB;
  private volatile FileChannel iNC;
  private volatile FileStructStat iND;
  private volatile com.tencent.mm.plugin.appbrand.appcache.pkg.a iNE;
  
  public WxaPkg(e parame)
  {
    AppMethodBeat.i(175554);
    this.iNC = null;
    this.iLs = true;
    this.iLy = null;
    this.fGL = parame;
    int i;
    if ((this.fGL == null) || (!this.fGL.exists()))
    {
      i = 0;
      if ((i == 0) || (!aQh())) {
        break label96;
      }
    }
    for (;;)
    {
      this.iLs = bool;
      AppMethodBeat.o(175554);
      return;
      if (this.fGL.length() > 14L)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label96:
      bool = false;
    }
  }
  
  public WxaPkg(String paramString)
  {
    this(new e(paramString));
    AppMethodBeat.i(134276);
    AppMethodBeat.o(134276);
  }
  
  /* Error */
  public static int DZ(String paramString)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 2	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 86	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_3
    //   17: getfield 52	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:iLs	Z
    //   20: ifeq +19 -> 39
    //   23: aload_3
    //   24: invokevirtual 90	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:version	()I
    //   27: istore_1
    //   28: aload_3
    //   29: invokevirtual 93	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   32: ldc 85
    //   34: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iload_1
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_1
    //   41: goto -13 -> 28
    //   44: astore_2
    //   45: ldc 85
    //   47: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_2
    //   51: athrow
    //   52: astore_0
    //   53: aload_2
    //   54: ifnull +23 -> 77
    //   57: aload_3
    //   58: invokevirtual 93	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   61: ldc 85
    //   63: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: athrow
    //   68: astore_3
    //   69: aload_2
    //   70: aload_3
    //   71: invokevirtual 97	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   74: goto -13 -> 61
    //   77: aload_3
    //   78: invokevirtual 93	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   81: goto -20 -> 61
    //   84: astore_0
    //   85: goto -32 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramString	String
    //   27	14	1	i	int
    //   15	1	2	localObject	Object
    //   44	26	2	localThrowable1	java.lang.Throwable
    //   13	45	3	localWxaPkg	WxaPkg
    //   68	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   16	28	44	java/lang/Throwable
    //   45	52	52	finally
    //   57	61	68	java/lang/Throwable
    //   16	28	84	finally
  }
  
  /* Error */
  private InputStream a(WxaPkg.Info paramInfo)
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 56	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:fGL	Lcom/tencent/mm/vfs/e;
    //   9: getfield 106	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   12: invokestatic 112	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   15: iconst_0
    //   16: invokestatic 118	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_1
    //   23: getfield 122	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:iLS	I
    //   26: newarray byte
    //   28: astore 4
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: aload_1
    //   34: getfield 125	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:iLR	I
    //   37: i2l
    //   38: invokevirtual 131	java/io/RandomAccessFile:seek	(J)V
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 4
    //   46: invokevirtual 135	java/io/RandomAccessFile:readFully	([B)V
    //   49: aload_3
    //   50: astore_2
    //   51: new 137	java/io/ByteArrayInputStream
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 139	java/io/ByteArrayInputStream:<init>	([B)V
    //   60: astore 4
    //   62: aload_3
    //   63: invokestatic 145	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   66: ldc 102
    //   68: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: astore 4
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: ldc 147
    //   82: ldc 149
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: getfield 56	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:fGL	Lcom/tencent/mm/vfs/e;
    //   94: getfield 106	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   97: invokestatic 112	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload_1
    //   104: getfield 153	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:fileName	Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload 4
    //   112: aastore
    //   113: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_3
    //   117: invokestatic 145	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   120: ldc 102
    //   122: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: invokestatic 145	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   134: ldc 102
    //   136: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: goto -12 -> 130
    //   145: astore 4
    //   147: goto -69 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	WxaPkg
    //   0	150	1	paramInfo	WxaPkg.Info
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
  
  private boolean aQh()
  {
    AppMethodBeat.i(134285);
    if (this.iNC == null) {}
    try
    {
      RandomAccessFile localRandomAccessFile = i.cS(q.B(this.fGL.mUri), false);
      this.iNB = localRandomAccessFile;
      this.iNC = localRandomAccessFile.getChannel();
      if (this.iNC == null)
      {
        AppMethodBeat.o(134285);
        return false;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[] { bt.m(localFileNotFoundException) });
      }
      int i = aQi();
      if (i < 0)
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "parseHeader, version is %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(134285);
        return false;
      }
      ad.i("MicroMsg.AppBrandWxaPkg", "wxapkg version: %d", new Object[] { Integer.valueOf(i) });
      Object localObject = null;
      switch (i)
      {
      }
      for (;;)
      {
        this.iNE = ((com.tencent.mm.plugin.appbrand.appcache.pkg.a)localObject);
        if (this.iNE != null) {
          break;
        }
        ad.e("MicroMsg.AppBrandWxaPkg", "parseHeader, mIWxaPkgAction is null");
        AppMethodBeat.o(134285);
        return false;
        localObject = new b();
        continue;
        localObject = new WxaPkgMixedImpl();
      }
      try
      {
        boolean bool = this.iNE.a(this.iNC);
        AppMethodBeat.o(134285);
        return bool;
      }
      catch (IOException localIOException)
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[] { bt.m(localIOException) });
        AppMethodBeat.o(134285);
      }
    }
    return true;
  }
  
  private int aQi()
  {
    AppMethodBeat.i(175555);
    int i = -1;
    try
    {
      this.iNC.position(1L);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(iNA);
      this.iNC.read(localByteBuffer);
      int j = WxaPkgBaseImpl.r(localByteBuffer.array(), 0, 4);
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "getVersionFromHead, exp = %s", new Object[] { bt.m(localIOException) });
      }
    }
    AppMethodBeat.o(175555);
    return i;
  }
  
  public final InputStream DM(String paramString)
  {
    AppMethodBeat.i(134281);
    WxaPkg.Info localInfo = openReadPartialInfo(paramString);
    if ((this.iNE != null) && (this.iNE.b(localInfo)))
    {
      if (localInfo != null)
      {
        paramString = this.iNE;
        AppMethodBeat.o(134281);
        return null;
      }
      ad.w("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", new Object[] { paramString });
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
        Object localObject = this.iNC.map(FileChannel.MapMode.READ_ONLY, localInfo.iLR, localInfo.iLS);
        ((MappedByteBuffer)localObject).order(iNA);
        ((MappedByteBuffer)localObject).limit(localInfo.iLS);
        localObject = new com.tencent.luggage.h.a((ByteBuffer)localObject);
        AppMethodBeat.o(134281);
        return localObject;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "handleOpenReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[] { paramString, Integer.valueOf(localInfo.iLR), Integer.valueOf(localInfo.iLS), bt.m(localException) });
        AppMethodBeat.o(134281);
        return null;
      }
    }
    ad.w("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", new Object[] { paramString });
    AppMethodBeat.o(134281);
    return null;
  }
  
  public final boolean aPe()
  {
    AppMethodBeat.i(134283);
    if ((!this.iLs) || (this.iNC == null) || (this.iNE == null) || (this.iNE.aQD() <= 4))
    {
      boolean bool = this.iLs;
      FileChannel localFileChannel = this.iNC;
      if (this.iNE == null) {}
      for (int i = -1;; i = this.iNE.aQD())
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[] { Boolean.valueOf(bool), localFileChannel, Integer.valueOf(i) });
        AppMethodBeat.o(134283);
        return false;
      }
    }
    if ((this.iLy != null) && (this.iNE.aQE() >= 0) && (this.iNE.aQE() == this.iLy.size()))
    {
      AppMethodBeat.o(134283);
      return true;
    }
    try
    {
      this.iLy = this.iNE.a(this.iNC, this.fGL);
      if (this.iLy != null)
      {
        AppMethodBeat.o(134283);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[] { bt.m(localException) });
      }
      AppMethodBeat.o(134283);
    }
    return false;
  }
  
  public final FileStructStat aQe()
  {
    AppMethodBeat.i(134278);
    FileStructStat localFileStructStat2 = this.iND;
    FileStructStat localFileStructStat1 = localFileStructStat2;
    if (localFileStructStat2 == null)
    {
      localFileStructStat1 = new FileStructStat();
      FileStat.b(q.B(this.fGL.fhU()), localFileStructStat1);
      this.iND = localFileStructStat1;
    }
    AppMethodBeat.o(134278);
    return localFileStructStat1;
  }
  
  public final String aQf()
  {
    AppMethodBeat.i(204824);
    String str = q.B(this.fGL.fhU());
    AppMethodBeat.o(204824);
    return str;
  }
  
  public final List<WxaPkg.Info> aQg()
  {
    AppMethodBeat.i(134284);
    if (!aPe()) {
      ad.e("MicroMsg.AppBrandWxaPkg", "listInfos readInfo returns false");
    }
    if (this.iLy == null)
    {
      localObject = Collections.emptyList();
      AppMethodBeat.o(134284);
      return localObject;
    }
    Object localObject = new LinkedList(this.iLy.values());
    AppMethodBeat.o(134284);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134279);
    if (this.iNC != null) {}
    try
    {
      this.iNC.close();
      this.iNC = null;
      label25:
      if (this.iNB != null) {
        try
        {
          this.iNB.close();
          this.iNB = null;
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
      if (this.iNE != null) {
        this.iNE.close();
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
    if ((this.iLy == null) || (bt.isNullOrNil(paramString)))
    {
      boolean bool;
      if (this.iLy == null)
      {
        bool = true;
        if (this.iLy != null) {
          break label81;
        }
      }
      for (;;)
      {
        ad.e("MicroMsg.AppBrandWxaPkg", "handleInterruptReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        AppMethodBeat.o(134280);
        return null;
        bool = false;
        break;
        label81:
        i = this.iLy.size();
      }
    }
    WxaPkg.Info localInfo2 = (WxaPkg.Info)this.iLy.get(paramString);
    WxaPkg.Info localInfo1 = localInfo2;
    if (localInfo2 == null)
    {
      paramString = m.EV(paramString);
      localInfo1 = (WxaPkg.Info)this.iLy.get(paramString);
    }
    AppMethodBeat.o(134280);
    return localInfo1;
  }
  
  public final int version()
  {
    AppMethodBeat.i(182984);
    if (this.iNE == null)
    {
      AppMethodBeat.o(182984);
      return -1;
    }
    int i = this.iNE.getVersion();
    AppMethodBeat.o(182984);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkg
 * JD-Core Version:    0.7.0.1
 */