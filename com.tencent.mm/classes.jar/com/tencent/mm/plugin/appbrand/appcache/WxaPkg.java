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
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  public static final ByteOrder jKG = ByteOrder.BIG_ENDIAN;
  public final k ggb;
  public volatile boolean jIo;
  private volatile Map<String, Info> jIu;
  private volatile RandomAccessFile jKH;
  private volatile FileChannel jKI;
  private volatile FileStructStat jKJ;
  private volatile com.tencent.mm.plugin.appbrand.appcache.pkg.a jKK;
  
  public WxaPkg(k paramk)
  {
    AppMethodBeat.i(175554);
    this.jKI = null;
    this.jIo = true;
    this.jIu = null;
    this.ggb = paramk;
    int i;
    if ((this.ggb == null) || (!this.ggb.exists()))
    {
      i = 0;
      if ((i == 0) || (!baW())) {
        break label96;
      }
    }
    for (;;)
    {
      this.jIo = bool;
      AppMethodBeat.o(175554);
      return;
      if (this.ggb.length() > 14L)
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
    this(new k(paramString));
    AppMethodBeat.i(134276);
    AppMethodBeat.o(134276);
  }
  
  /* Error */
  public static int LX(String paramString)
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 2	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 89	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_3
    //   17: getfield 55	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:jIo	Z
    //   20: ifeq +19 -> 39
    //   23: aload_3
    //   24: invokevirtual 93	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:version	()I
    //   27: istore_1
    //   28: aload_3
    //   29: invokevirtual 96	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   32: ldc 88
    //   34: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iload_1
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_1
    //   41: goto -13 -> 28
    //   44: astore_2
    //   45: ldc 88
    //   47: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_2
    //   51: athrow
    //   52: astore_0
    //   53: aload_2
    //   54: ifnull +23 -> 77
    //   57: aload_3
    //   58: invokevirtual 96	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   61: ldc 88
    //   63: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: athrow
    //   68: astore_3
    //   69: aload_2
    //   70: aload_3
    //   71: invokevirtual 100	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   74: goto -13 -> 61
    //   77: aload_3
    //   78: invokevirtual 96	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
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
  private InputStream a(Info paramInfo)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 59	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:ggb	Lcom/tencent/mm/vfs/k;
    //   9: getfield 109	com/tencent/mm/vfs/k:mUri	Landroid/net/Uri;
    //   12: invokestatic 115	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   15: iconst_0
    //   16: invokestatic 121	com/tencent/mm/vfs/o:dg	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_1
    //   23: getfield 125	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:jIO	I
    //   26: newarray byte
    //   28: astore 4
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: aload_1
    //   34: getfield 128	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:jIN	I
    //   37: i2l
    //   38: invokevirtual 134	java/io/RandomAccessFile:seek	(J)V
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 4
    //   46: invokevirtual 138	java/io/RandomAccessFile:readFully	([B)V
    //   49: aload_3
    //   50: astore_2
    //   51: new 140	java/io/ByteArrayInputStream
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 142	java/io/ByteArrayInputStream:<init>	([B)V
    //   60: astore 4
    //   62: aload_3
    //   63: invokestatic 148	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   66: ldc 105
    //   68: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: astore 4
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: ldc 150
    //   82: ldc 152
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: getfield 59	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:ggb	Lcom/tencent/mm/vfs/k;
    //   94: getfield 109	com/tencent/mm/vfs/k:mUri	Landroid/net/Uri;
    //   97: invokestatic 115	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload_1
    //   104: getfield 156	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:fileName	Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload 4
    //   112: aastore
    //   113: invokestatic 162	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_3
    //   117: invokestatic 148	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   120: ldc 105
    //   122: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: invokestatic 148	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   134: ldc 105
    //   136: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private boolean baW()
  {
    AppMethodBeat.i(134285);
    if (this.jKI == null) {}
    try
    {
      RandomAccessFile localRandomAccessFile = o.dg(w.B(this.ggb.mUri), false);
      this.jKH = localRandomAccessFile;
      this.jKI = localRandomAccessFile.getChannel();
      if (this.jKI == null)
      {
        AppMethodBeat.o(134285);
        return false;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[] { bu.o(localFileNotFoundException) });
      }
      int i = baX();
      if (i < 0)
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "parseHeader, version is %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(134285);
        return false;
      }
      ae.i("MicroMsg.AppBrandWxaPkg", "wxapkg version: %d", new Object[] { Integer.valueOf(i) });
      Object localObject = null;
      switch (i)
      {
      }
      for (;;)
      {
        this.jKK = ((com.tencent.mm.plugin.appbrand.appcache.pkg.a)localObject);
        if (this.jKK != null) {
          break;
        }
        ae.e("MicroMsg.AppBrandWxaPkg", "parseHeader, mIWxaPkgAction is null");
        AppMethodBeat.o(134285);
        return false;
        localObject = new b();
        continue;
        localObject = new WxaPkgMixedImpl();
      }
      try
      {
        boolean bool = this.jKK.a(this.jKI);
        AppMethodBeat.o(134285);
        return bool;
      }
      catch (IOException localIOException)
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[] { bu.o(localIOException) });
        AppMethodBeat.o(134285);
      }
    }
    return true;
  }
  
  private int baX()
  {
    AppMethodBeat.i(175555);
    int i = -1;
    try
    {
      this.jKI.position(1L);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(jKG);
      this.jKI.read(localByteBuffer);
      int j = WxaPkgBaseImpl.q(localByteBuffer.array(), 0, 4);
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "getVersionFromHead, exp = %s", new Object[] { bu.o(localIOException) });
      }
    }
    AppMethodBeat.o(175555);
    return i;
  }
  
  /* Error */
  public static String cf(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 249
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 2	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 89	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 252	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aZO	()Z
    //   18: pop
    //   19: aload_2
    //   20: aload_1
    //   21: invokevirtual 256	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:LI	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: invokestatic 262	com/tencent/mm/plugin/appbrand/y/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 96	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   32: ldc 249
    //   34: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: ldc 249
    //   42: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: aload_1
    //   49: ifnull +31 -> 80
    //   52: aload_2
    //   53: invokevirtual 96	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   56: ldc 249
    //   58: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: athrow
    //   63: astore_0
    //   64: ldc 249
    //   66: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_2
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 100	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   77: goto -21 -> 56
    //   80: aload_2
    //   81: invokevirtual 96	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
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
  
  public final InputStream LI(String paramString)
  {
    AppMethodBeat.i(134281);
    Info localInfo = openReadPartialInfo(paramString);
    if ((this.jKK != null) && (this.jKK.b(localInfo)))
    {
      if (localInfo != null)
      {
        paramString = this.jKK;
        AppMethodBeat.o(134281);
        return null;
      }
      ae.w("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", new Object[] { paramString });
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
        Object localObject = this.jKI.map(FileChannel.MapMode.READ_ONLY, localInfo.jIN, localInfo.jIO);
        ((MappedByteBuffer)localObject).order(jKG);
        ((MappedByteBuffer)localObject).limit(localInfo.jIO);
        localObject = new com.tencent.luggage.h.a((ByteBuffer)localObject);
        AppMethodBeat.o(134281);
        return localObject;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "handleOpenReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[] { paramString, Integer.valueOf(localInfo.jIN), Integer.valueOf(localInfo.jIO), bu.o(localException) });
        AppMethodBeat.o(134281);
        return null;
      }
    }
    ae.w("MicroMsg.AppBrandWxaPkg", "can't find info of file: %s", new Object[] { paramString });
    AppMethodBeat.o(134281);
    return null;
  }
  
  public final boolean aZO()
  {
    AppMethodBeat.i(134283);
    if ((!this.jIo) || (this.jKI == null) || (this.jKK == null) || (this.jKK.bbs() <= 4))
    {
      boolean bool = this.jIo;
      FileChannel localFileChannel = this.jKI;
      if (this.jKK == null) {}
      for (int i = -1;; i = this.jKK.bbs())
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[] { Boolean.valueOf(bool), localFileChannel, Integer.valueOf(i) });
        AppMethodBeat.o(134283);
        return false;
      }
    }
    if ((this.jIu != null) && (this.jKK.bbt() >= 0) && (this.jKK.bbt() == this.jIu.size()))
    {
      AppMethodBeat.o(134283);
      return true;
    }
    try
    {
      this.jIu = this.jKK.a(this.jKI, this.ggb);
      if (this.jIu != null)
      {
        AppMethodBeat.o(134283);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[] { bu.o(localException) });
      }
      AppMethodBeat.o(134283);
    }
    return false;
  }
  
  public final FileStructStat baS()
  {
    AppMethodBeat.i(134278);
    FileStructStat localFileStructStat2 = this.jKJ;
    FileStructStat localFileStructStat1 = localFileStructStat2;
    if (localFileStructStat2 == null)
    {
      localFileStructStat1 = new FileStructStat();
      FileStat.b(w.B(this.ggb.fTh()), localFileStructStat1);
      this.jKJ = localFileStructStat1;
    }
    AppMethodBeat.o(134278);
    return localFileStructStat1;
  }
  
  public final String baT()
  {
    AppMethodBeat.i(224490);
    String str = w.B(this.ggb.fTh());
    AppMethodBeat.o(224490);
    return str;
  }
  
  public final List<Info> baU()
  {
    AppMethodBeat.i(134284);
    if (!aZO()) {
      ae.e("MicroMsg.AppBrandWxaPkg", "listInfos readInfo returns false");
    }
    if (this.jIu == null)
    {
      localObject = Collections.emptyList();
      AppMethodBeat.o(134284);
      return localObject;
    }
    Object localObject = new LinkedList(this.jIu.values());
    AppMethodBeat.o(134284);
    return localObject;
  }
  
  public final List<String> baV()
  {
    AppMethodBeat.i(195064);
    LinkedList localLinkedList = new LinkedList(this.jIu.keySet());
    AppMethodBeat.o(195064);
    return localLinkedList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134279);
    if (this.jKI != null) {}
    try
    {
      this.jKI.close();
      this.jKI = null;
      label25:
      if (this.jKH != null) {
        try
        {
          this.jKH.close();
          this.jKH = null;
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
      if (this.jKK != null) {
        this.jKK.close();
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
    if ((this.jIu == null) || (bu.isNullOrNil(paramString)))
    {
      boolean bool;
      if (this.jIu == null)
      {
        bool = true;
        if (this.jIu != null) {
          break label81;
        }
      }
      for (;;)
      {
        ae.e("MicroMsg.AppBrandWxaPkg", "handleInterruptReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        AppMethodBeat.o(134280);
        return null;
        bool = false;
        break;
        label81:
        i = this.jIu.size();
      }
    }
    Info localInfo2 = (Info)this.jIu.get(paramString);
    Info localInfo1 = localInfo2;
    if (localInfo2 == null)
    {
      paramString = n.MV(paramString);
      localInfo1 = (Info)this.jIu.get(paramString);
    }
    AppMethodBeat.o(134280);
    return localInfo1;
  }
  
  public final int version()
  {
    AppMethodBeat.i(182984);
    if (this.jKK == null)
    {
      AppMethodBeat.o(182984);
      return -1;
    }
    int i = this.jKK.getVersion();
    AppMethodBeat.o(182984);
    return i;
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public final String fileName;
    public final int jIN;
    public final int jIO;
    public final String jKL;
    
    static
    {
      AppMethodBeat.i(182981);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(182981);
    }
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(182980);
      this.jKL = paramParcel.readString();
      this.fileName = paramParcel.readString();
      this.jIN = paramParcel.readInt();
      this.jIO = paramParcel.readInt();
      AppMethodBeat.o(182980);
    }
    
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.jKL = paramString1;
      this.fileName = paramString2;
      this.jIN = paramInt1;
      this.jIO = paramInt2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(182979);
      paramParcel.writeString(this.jKL);
      paramParcel.writeString(this.fileName);
      paramParcel.writeInt(this.jIN);
      paramParcel.writeInt(this.jIO);
      AppMethodBeat.o(182979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkg
 * JD-Core Version:    0.7.0.1
 */