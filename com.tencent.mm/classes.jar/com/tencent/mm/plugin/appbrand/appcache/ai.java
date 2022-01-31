package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class ai
  implements Closeable
{
  public static final ByteOrder fDv = ByteOrder.BIG_ENDIAN;
  private volatile int fDA = 0;
  private volatile int fDB = -1;
  public volatile Map<String, ai.a> fDC = null;
  public volatile FileStructStat fDD;
  public final File fDw;
  private volatile FileChannel fDx = null;
  public volatile boolean fDy = true;
  private volatile int fDz = 0;
  private volatile int mVersion = -1;
  
  public ai(File paramFile)
  {
    this.fDw = paramFile;
    int i;
    if ((this.fDw == null) || (!this.fDw.exists()))
    {
      i = 0;
      if ((i == 0) || (!abY())) {
        break label106;
      }
    }
    for (;;)
    {
      this.fDy = bool;
      return;
      if (this.fDw.length() <= 14L)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label106:
      bool = false;
    }
  }
  
  public ai(String paramString)
  {
    this(new File(paramString));
  }
  
  private static int A(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt, 4);
    paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    return paramArrayOfByte.getInt();
  }
  
  /* Error */
  private InputStream a(ai.a parama)
  {
    // Byte code:
    //   0: new 98	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: getfield 56	com/tencent/mm/plugin/appbrand/appcache/ai:fDw	Ljava/io/File;
    //   8: ldc 100
    //   10: invokespecial 103	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: aload_1
    //   17: getfield 106	com/tencent/mm/plugin/appbrand/appcache/ai$a:fDG	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: astore_2
    //   26: aload_3
    //   27: aload_1
    //   28: getfield 109	com/tencent/mm/plugin/appbrand/appcache/ai$a:fDF	I
    //   31: i2l
    //   32: invokevirtual 113	java/io/RandomAccessFile:seek	(J)V
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: aload 4
    //   40: invokevirtual 117	java/io/RandomAccessFile:readFully	([B)V
    //   43: aload_3
    //   44: astore_2
    //   45: new 119	java/io/ByteArrayInputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 121	java/io/ByteArrayInputStream:<init>	([B)V
    //   54: astore 4
    //   56: aload_3
    //   57: invokestatic 127	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   60: aload 4
    //   62: areturn
    //   63: astore 4
    //   65: aconst_null
    //   66: astore_3
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 129
    //   71: ldc 131
    //   73: iconst_3
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: getfield 56	com/tencent/mm/plugin/appbrand/appcache/ai:fDw	Ljava/io/File;
    //   83: invokevirtual 135	java/io/File:getPath	()Ljava/lang/String;
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_1
    //   90: getfield 139	com/tencent/mm/plugin/appbrand/appcache/ai$a:fileName	Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: aload 4
    //   98: aastore
    //   99: invokestatic 145	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_3
    //   103: invokestatic 127	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: invokestatic 127	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: goto -7 -> 111
    //   121: astore 4
    //   123: goto -56 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ai
    //   0	126	1	parama	ai.a
    //   15	97	2	localRandomAccessFile1	RandomAccessFile
    //   13	90	3	localRandomAccessFile2	RandomAccessFile
    //   22	39	4	localObject	Object
    //   63	34	4	localException1	Exception
    //   121	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	63	java/lang/Exception
    //   0	14	108	finally
    //   16	24	117	finally
    //   26	35	117	finally
    //   37	43	117	finally
    //   45	56	117	finally
    //   69	102	117	finally
    //   16	24	121	java/lang/Exception
    //   26	35	121	java/lang/Exception
    //   37	43	121	java/lang/Exception
    //   45	56	121	java/lang/Exception
  }
  
  private boolean abY()
  {
    if (this.fDx == null) {}
    for (;;)
    {
      try
      {
        this.fDx = new RandomAccessFile(this.fDw, "r").getChannel();
        if (this.fDx == null) {
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        y.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[] { bk.j(localFileNotFoundException) });
        continue;
      }
      try
      {
        this.fDx.position(0L);
        Object localObject = ByteBuffer.allocate(14);
        ((ByteBuffer)localObject).order(fDv);
        this.fDx.read((ByteBuffer)localObject);
        if ((-66 != ((ByteBuffer)localObject).get(0)) || (-19 != ((ByteBuffer)localObject).get(13))) {
          continue;
        }
        localObject = ((ByteBuffer)localObject).array();
        this.mVersion = A((byte[])localObject, 1);
        this.fDz = A((byte[])localObject, 5);
        this.fDA = A((byte[])localObject, 9);
        return true;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[] { bk.j(localIOException) });
        }
      }
    }
  }
  
  public final boolean abX()
  {
    int j = 4;
    boolean bool2 = true;
    boolean bool1;
    if ((!this.fDy) || (this.fDx == null) || (this.fDz <= 4))
    {
      y.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[] { Boolean.valueOf(this.fDy), this.fDx, Integer.valueOf(this.fDA) });
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if ((this.fDC != null) && (this.fDB >= 0))
      {
        bool1 = bool2;
        if (this.fDB == this.fDC.size()) {}
      }
      else
      {
        try
        {
          this.fDx.position(14L);
          Object localObject = ByteBuffer.allocate(this.fDz);
          ((ByteBuffer)localObject).order(fDv);
          this.fDx.read((ByteBuffer)localObject);
          byte[] arrayOfByte = ((ByteBuffer)localObject).array();
          this.fDB = A(arrayOfByte, 0);
          android.support.v4.f.a locala = new android.support.v4.f.a();
          localObject = null;
          int i = 0;
          while (i < this.fDB)
          {
            int k = A(arrayOfByte, j);
            j += 4;
            String str = new String(arrayOfByte, j, k);
            j += k;
            k = A(arrayOfByte, j);
            j += 4;
            int m = A(arrayOfByte, j);
            j += 4;
            localObject = new ai.a(this.fDw.getAbsolutePath(), str, k, m);
            locala.put(str, localObject);
            i += 1;
          }
          this.fDC = locala;
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((ai.a)localObject).fDF + ((ai.a)localObject).fDG > this.fDw.length())
            {
              y.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(((ai.a)localObject).fDF), Integer.valueOf(((ai.a)localObject).fDG), Long.valueOf(this.fDw.length()) });
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[] { bk.j(localException) });
        }
      }
    }
    return false;
  }
  
  public final void close()
  {
    if (this.fDx != null) {}
    try
    {
      this.fDx.close();
      this.fDx = null;
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final ai.a ra(String paramString)
  {
    int i = 0;
    if ((this.fDC == null) || (bk.bl(paramString)))
    {
      boolean bool;
      if (this.fDC == null)
      {
        bool = true;
        if (this.fDC != null) {
          break label68;
        }
      }
      for (;;)
      {
        y.e("MicroMsg.AppBrandWxaPkg", "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        return null;
        bool = false;
        break;
        label68:
        i = this.fDC.size();
      }
    }
    paramString = i.rA(paramString);
    return (ai.a)this.fDC.get(paramString);
  }
  
  public final InputStream rb(String paramString)
  {
    ai.a locala = ra(paramString);
    if (locala != null)
    {
      if (Thread.currentThread().isInterrupted()) {
        return a(locala);
      }
      try
      {
        Object localObject = this.fDx.map(FileChannel.MapMode.READ_ONLY, locala.fDF, locala.fDG);
        ((MappedByteBuffer)localObject).order(fDv);
        ((MappedByteBuffer)localObject).limit(locala.fDG);
        localObject = new com.tencent.luggage.j.a((ByteBuffer)localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[] { paramString, Integer.valueOf(locala.fDF), Integer.valueOf(locala.fDG), bk.j(localException) });
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */