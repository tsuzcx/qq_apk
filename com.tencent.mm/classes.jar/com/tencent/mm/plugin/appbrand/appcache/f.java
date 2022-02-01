package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

public final class f
  implements p, Closeable
{
  private volatile int cR;
  private volatile boolean iLs;
  private volatile AssetManager iLt;
  private volatile ByteArrayOutputStream iLu;
  private volatile int iLv;
  private volatile int iLw;
  private volatile int iLx;
  private volatile Map<String, WxaPkg.Info> iLy;
  private volatile String mFilePath;
  
  public f(Context paramContext, String paramString)
  {
    AppMethodBeat.i(134261);
    this.iLs = true;
    this.cR = -1;
    this.iLv = 0;
    this.iLw = 0;
    this.iLx = -1;
    this.mFilePath = null;
    this.iLy = null;
    this.iLt = paramContext.getAssets();
    this.mFilePath = paramString;
    try
    {
      paramContext = this.iLt.open(paramString);
      z(paramContext);
      paramContext.close();
      label78:
      int i;
      if (this.iLu != null)
      {
        if ((this.iLu == null) || (this.iLu.size() <= 0)) {
          break label133;
        }
        i = 1;
        if (i == 0) {
          break label213;
        }
        if (this.iLu != null) {
          break label138;
        }
        i = 0;
        label117:
        if (i == 0) {
          break label213;
        }
      }
      for (;;)
      {
        this.iLs = bool;
        AppMethodBeat.o(134261);
        return;
        label133:
        i = 0;
        break;
        label138:
        paramContext = new byte[14];
        System.arraycopy(this.iLu.toByteArray(), 0, paramContext, 0, 14);
        if ((-66 != paramContext[0]) || (-19 != paramContext[13]))
        {
          i = 0;
          break label117;
        }
        this.cR = F(paramContext, 1);
        this.iLv = F(paramContext, 5);
        this.iLw = F(paramContext, 9);
        i = 1;
        break label117;
        label213:
        bool = false;
      }
    }
    catch (IOException paramContext)
    {
      break label78;
    }
  }
  
  private static int F(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(134268);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt, 4);
    paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    paramInt = paramArrayOfByte.getInt();
    AppMethodBeat.o(134268);
    return paramInt;
  }
  
  /* Error */
  private InputStream a(WxaPkg.Info paramInfo)
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 60	com/tencent/mm/plugin/appbrand/appcache/f:iLt	Landroid/content/res/AssetManager;
    //   9: ifnonnull +10 -> 19
    //   12: ldc 126
    //   14: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_1
    //   20: getfield 131	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:iLS	I
    //   23: newarray byte
    //   25: astore 6
    //   27: aload_0
    //   28: getfield 60	com/tencent/mm/plugin/appbrand/appcache/f:iLt	Landroid/content/res/AssetManager;
    //   31: aload_0
    //   32: getfield 50	com/tencent/mm/plugin/appbrand/appcache/f:mFilePath	Ljava/lang/String;
    //   35: invokevirtual 66	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore 5
    //   40: aload 5
    //   42: astore 4
    //   44: aload 5
    //   46: aload 6
    //   48: aload_1
    //   49: getfield 134	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:iLR	I
    //   52: aload_1
    //   53: getfield 131	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:iLS	I
    //   56: invokevirtual 138	java/io/InputStream:read	([BII)I
    //   59: istore_2
    //   60: aload 5
    //   62: astore 4
    //   64: aload_1
    //   65: getfield 131	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:iLS	I
    //   68: istore_3
    //   69: iload_2
    //   70: iload_3
    //   71: if_icmpeq +15 -> 86
    //   74: aload 5
    //   76: invokestatic 144	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   79: ldc 126
    //   81: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: aload 5
    //   88: astore 4
    //   90: new 146	java/io/ByteArrayInputStream
    //   93: dup
    //   94: aload 6
    //   96: invokespecial 149	java/io/ByteArrayInputStream:<init>	([B)V
    //   99: astore 6
    //   101: aload 5
    //   103: invokestatic 144	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   106: ldc 126
    //   108: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload 6
    //   113: areturn
    //   114: astore 6
    //   116: aconst_null
    //   117: astore 5
    //   119: aload 5
    //   121: astore 4
    //   123: ldc 151
    //   125: ldc 153
    //   127: iconst_3
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_0
    //   134: getfield 50	com/tencent/mm/plugin/appbrand/appcache/f:mFilePath	Ljava/lang/String;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload_1
    //   141: getfield 156	com/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info:fileName	Ljava/lang/String;
    //   144: aastore
    //   145: dup
    //   146: iconst_2
    //   147: aload 6
    //   149: aastore
    //   150: invokestatic 162	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload 5
    //   155: invokestatic 144	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   158: ldc 126
    //   160: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_1
    //   166: aconst_null
    //   167: astore 4
    //   169: aload 4
    //   171: invokestatic 144	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   174: ldc 126
    //   176: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: goto -13 -> 169
    //   185: astore 6
    //   187: goto -68 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	f
    //   0	190	1	paramInfo	WxaPkg.Info
    //   59	13	2	i	int
    //   68	4	3	j	int
    //   42	128	4	localInputStream1	InputStream
    //   38	116	5	localInputStream2	InputStream
    //   25	87	6	localObject	Object
    //   114	34	6	localException1	java.lang.Exception
    //   185	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   19	40	114	java/lang/Exception
    //   19	40	165	finally
    //   44	60	181	finally
    //   64	69	181	finally
    //   90	101	181	finally
    //   123	153	181	finally
    //   44	60	185	java/lang/Exception
    //   64	69	185	java/lang/Exception
    //   90	101	185	java/lang/Exception
  }
  
  private void z(InputStream paramInputStream)
  {
    AppMethodBeat.i(134267);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(134267);
      return;
    }
    this.iLu = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i < 0) {
        break;
      }
      this.iLu.write(arrayOfByte, 0, i);
    }
    this.iLu.flush();
    AppMethodBeat.o(134267);
  }
  
  public final InputStream DM(String paramString)
  {
    AppMethodBeat.i(134264);
    if ((this.iLu == null) || (this.iLu.size() <= 0))
    {
      AppMethodBeat.o(134264);
      return null;
    }
    boolean bool;
    int i;
    if ((this.iLy == null) || (bt.isNullOrNil(paramString))) {
      if (this.iLy == null)
      {
        bool = true;
        if (this.iLy != null) {
          break label123;
        }
        i = 0;
        label61:
        ad.e("MicroMsg.AssetsWxaPkgReader", "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        paramString = null;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        if (Thread.currentThread().isInterrupted())
        {
          paramString = a(paramString);
          AppMethodBeat.o(134264);
          return paramString;
          bool = false;
          break;
          label123:
          i = this.iLy.size();
          break label61;
          paramString = m.EV(paramString);
          paramString = (WxaPkg.Info)this.iLy.get(paramString);
          continue;
        }
        byte[] arrayOfByte = new byte[paramString.iLS];
        System.arraycopy(this.iLu.toByteArray(), paramString.iLR, arrayOfByte, 0, paramString.iLS);
        paramString = new ByteArrayInputStream(arrayOfByte);
        AppMethodBeat.o(134264);
        return paramString;
      }
    }
    AppMethodBeat.o(134264);
    return null;
  }
  
  public final boolean aPe()
  {
    AppMethodBeat.i(134266);
    if ((!this.iLs) || (this.iLu == null) || (this.iLv <= 4))
    {
      ad.e("MicroMsg.AssetsWxaPkgReader", "readInfo, valid = %b, (null == mInputStream) = %b, mBodyInfoLength = %d, skip", new Object[] { Boolean.valueOf(this.iLs), this.iLu, Integer.valueOf(this.iLw) });
      AppMethodBeat.o(134266);
      return false;
    }
    if ((this.iLy != null) && (this.iLx >= 0) && (this.iLx == this.iLy.size()))
    {
      AppMethodBeat.o(134266);
      return true;
    }
    byte[] arrayOfByte = new byte[this.iLv];
    System.arraycopy(this.iLu.toByteArray(), 14, arrayOfByte, 0, this.iLv);
    this.iLx = F(arrayOfByte, 0);
    a locala = new a();
    WxaPkg.Info localInfo = null;
    int j = 4;
    int i = 0;
    while (i < this.iLx)
    {
      int k = F(arrayOfByte, j);
      j += 4;
      String str = new String(arrayOfByte, j, k);
      j += k;
      k = F(arrayOfByte, j);
      j += 4;
      int m = F(arrayOfByte, j);
      j += 4;
      localInfo = new WxaPkg.Info(this.mFilePath, str, k, m);
      locala.put(str, localInfo);
      i += 1;
    }
    this.iLy = locala;
    i = this.iLu.size();
    if ((localInfo != null) && (localInfo.iLR + localInfo.iLS > i))
    {
      ad.e("MicroMsg.AssetsWxaPkgReader", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(localInfo.iLR), Integer.valueOf(localInfo.iLS), Integer.valueOf(i) });
      AppMethodBeat.o(134266);
      return false;
    }
    AppMethodBeat.o(134266);
    return true;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134263);
    if ((this.iLu != null) && (this.iLu.size() > 0)) {
      try
      {
        this.iLu.close();
        this.iLu = null;
        AppMethodBeat.o(134263);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(134263);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(134262);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(134262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.f
 * JD-Core Version:    0.7.0.1
 */