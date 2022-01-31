package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Map;

public final class ao
  implements Closeable
{
  public static final ByteOrder gVK = ByteOrder.BIG_ENDIAN;
  private volatile int cO;
  public final File gVL;
  private volatile RandomAccessFile gVM;
  private volatile FileChannel gVN;
  public volatile boolean gVO;
  private volatile int gVP;
  private volatile int gVQ;
  private volatile int gVR;
  public volatile Map<String, ao.a> gVS;
  public volatile FileStructStat gVT;
  
  public ao(File paramFile)
  {
    AppMethodBeat.i(105316);
    this.gVN = null;
    this.gVO = true;
    this.cO = -1;
    this.gVP = 0;
    this.gVQ = 0;
    this.gVR = -1;
    this.gVS = null;
    this.gVL = paramFile;
    int i;
    if ((this.gVL == null) || (!this.gVL.exists()))
    {
      i = 0;
      if ((i == 0) || (!avP())) {
        break label116;
      }
    }
    for (;;)
    {
      this.gVO = bool;
      AppMethodBeat.o(105316);
      return;
      if (this.gVL.length() <= 14L)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label116:
      bool = false;
    }
  }
  
  public ao(String paramString)
  {
    this(new File(paramString));
    AppMethodBeat.i(105317);
    AppMethodBeat.o(105317);
  }
  
  private static int B(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(105324);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(105324);
      return 0;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt, 4);
    paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    paramInt = paramArrayOfByte.getInt();
    AppMethodBeat.o(105324);
    return paramInt;
  }
  
  /* Error */
  private InputStream a(ao.a parama)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 113	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: getfield 65	com/tencent/mm/plugin/appbrand/appcache/ao:gVL	Ljava/io/File;
    //   13: ldc 115
    //   15: invokespecial 118	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_1
    //   22: getfield 121	com/tencent/mm/plugin/appbrand/appcache/ao$a:gVW	I
    //   25: newarray byte
    //   27: astore 4
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: aload_1
    //   33: getfield 124	com/tencent/mm/plugin/appbrand/appcache/ao$a:gVV	I
    //   36: i2l
    //   37: invokevirtual 128	java/io/RandomAccessFile:seek	(J)V
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 132	java/io/RandomAccessFile:readFully	([B)V
    //   48: aload_3
    //   49: astore_2
    //   50: new 134	java/io/ByteArrayInputStream
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 136	java/io/ByteArrayInputStream:<init>	([B)V
    //   59: astore 4
    //   61: aload_3
    //   62: invokestatic 142	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   65: ldc 111
    //   67: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_3
    //   78: astore_2
    //   79: ldc 144
    //   81: ldc 146
    //   83: iconst_3
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: getfield 65	com/tencent/mm/plugin/appbrand/appcache/ao:gVL	Ljava/io/File;
    //   93: invokevirtual 150	java/io/File:getPath	()Ljava/lang/String;
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_1
    //   100: getfield 154	com/tencent/mm/plugin/appbrand/appcache/ao$a:fileName	Ljava/lang/String;
    //   103: aastore
    //   104: dup
    //   105: iconst_2
    //   106: aload 4
    //   108: aastore
    //   109: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_3
    //   113: invokestatic 142	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   116: ldc 111
    //   118: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: invokestatic 142	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   130: ldc 111
    //   132: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: goto -12 -> 126
    //   141: astore 4
    //   143: goto -66 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	ao
    //   0	146	1	parama	ao.a
    //   20	107	2	localRandomAccessFile1	RandomAccessFile
    //   18	95	3	localRandomAccessFile2	RandomAccessFile
    //   27	44	4	localObject	Object
    //   73	34	4	localException1	Exception
    //   141	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	19	73	java/lang/Exception
    //   5	19	123	finally
    //   21	29	137	finally
    //   31	40	137	finally
    //   42	48	137	finally
    //   50	61	137	finally
    //   79	112	137	finally
    //   21	29	141	java/lang/Exception
    //   31	40	141	java/lang/Exception
    //   42	48	141	java/lang/Exception
    //   50	61	141	java/lang/Exception
  }
  
  private boolean avP()
  {
    AppMethodBeat.i(105323);
    if (this.gVN == null) {}
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.gVL, "r");
      this.gVM = localRandomAccessFile;
      this.gVN = localRandomAccessFile.getChannel();
      if (this.gVN == null)
      {
        AppMethodBeat.o(105323);
        return false;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[] { bo.l(localFileNotFoundException) });
      }
    }
    try
    {
      this.gVN.position(0L);
      Object localObject = ByteBuffer.allocate(14);
      ((ByteBuffer)localObject).order(gVK);
      this.gVN.read((ByteBuffer)localObject);
      if (-66 == ((ByteBuffer)localObject).get(0))
      {
        int i = ((ByteBuffer)localObject).get(13);
        if (-19 == i) {}
      }
      else
      {
        AppMethodBeat.o(105323);
        return false;
      }
      localObject = ((ByteBuffer)localObject).array();
      this.cO = B((byte[])localObject, 1);
      this.gVP = B((byte[])localObject, 5);
      this.gVQ = B((byte[])localObject, 9);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[] { bo.l(localIOException) });
      }
    }
    AppMethodBeat.o(105323);
    return true;
  }
  
  public final boolean avO()
  {
    AppMethodBeat.i(105322);
    if ((!this.gVO) || (this.gVN == null) || (this.gVP <= 4))
    {
      ab.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[] { Boolean.valueOf(this.gVO), this.gVN, Integer.valueOf(this.gVQ) });
      AppMethodBeat.o(105322);
      return false;
    }
    if ((this.gVS != null) && (this.gVR >= 0) && (this.gVR == this.gVS.size()))
    {
      AppMethodBeat.o(105322);
      return true;
    }
    try
    {
      this.gVN.position(14L);
      Object localObject = ByteBuffer.allocate(this.gVP);
      ((ByteBuffer)localObject).order(gVK);
      this.gVN.read((ByteBuffer)localObject);
      byte[] arrayOfByte = ((ByteBuffer)localObject).array();
      this.gVR = B(arrayOfByte, 0);
      android.support.v4.e.a locala = new android.support.v4.e.a();
      localObject = null;
      int j = 4;
      int i = 0;
      while (i < this.gVR)
      {
        int k = B(arrayOfByte, j);
        j += 4;
        String str = new String(arrayOfByte, j, k);
        j += k;
        k = B(arrayOfByte, j);
        j += 4;
        int m = B(arrayOfByte, j);
        j += 4;
        localObject = new ao.a(this.gVL.getAbsolutePath(), str, k, m);
        locala.put(str, localObject);
        i += 1;
      }
      this.gVS = locala;
      if ((localObject != null) && (((ao.a)localObject).gVV + ((ao.a)localObject).gVW > this.gVL.length()))
      {
        ab.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(((ao.a)localObject).gVV), Integer.valueOf(((ao.a)localObject).gVW), Long.valueOf(this.gVL.length()) });
        AppMethodBeat.o(105322);
        return false;
      }
      AppMethodBeat.o(105322);
      return true;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(105322);
    }
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(105318);
    if (this.gVN != null) {}
    try
    {
      this.gVN.close();
      this.gVN = null;
      label24:
      if (this.gVM != null) {
        try
        {
          this.gVM.close();
          this.gVM = null;
          AppMethodBeat.o(105318);
          return;
        }
        catch (IOException localIOException1) {}
      }
      AppMethodBeat.o(105318);
      return;
    }
    catch (IOException localIOException2)
    {
      break label24;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(142818);
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(142818);
    }
  }
  
  public final ao.a yv(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(105319);
    if ((this.gVS == null) || (bo.isNullOrNil(paramString)))
    {
      boolean bool;
      if (this.gVS == null)
      {
        bool = true;
        if (this.gVS != null) {
          break label81;
        }
      }
      for (;;)
      {
        ab.e("MicroMsg.AppBrandWxaPkg", "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        AppMethodBeat.o(105319);
        return null;
        bool = false;
        break;
        label81:
        i = this.gVS.size();
      }
    }
    paramString = k.zl(paramString);
    paramString = (ao.a)this.gVS.get(paramString);
    AppMethodBeat.o(105319);
    return paramString;
  }
  
  public final InputStream yw(String paramString)
  {
    AppMethodBeat.i(105320);
    ao.a locala = yv(paramString);
    if (locala != null)
    {
      if (Thread.currentThread().isInterrupted())
      {
        paramString = a(locala);
        AppMethodBeat.o(105320);
        return paramString;
      }
      try
      {
        Object localObject = this.gVN.map(FileChannel.MapMode.READ_ONLY, locala.gVV, locala.gVW);
        ((MappedByteBuffer)localObject).order(gVK);
        ((MappedByteBuffer)localObject).limit(locala.gVW);
        localObject = new com.tencent.luggage.g.a((ByteBuffer)localObject);
        AppMethodBeat.o(105320);
        return localObject;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[] { paramString, Integer.valueOf(locala.gVV), Integer.valueOf(locala.gVW), bo.l(localException) });
        AppMethodBeat.o(105320);
        return null;
      }
    }
    AppMethodBeat.o(105320);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ao
 * JD-Core Version:    0.7.0.1
 */