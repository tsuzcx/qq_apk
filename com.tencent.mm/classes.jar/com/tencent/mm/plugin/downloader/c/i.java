package com.tencent.mm.plugin.downloader.c;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public static ByteBuffer H(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile())) {
      return null;
    }
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      try
      {
        paramFile = b.e(localRandomAccessFile);
        localByteBuffer = (ByteBuffer)paramFile.first;
        l = ((Long)paramFile.second).longValue();
        if (!k.c(localRandomAccessFile, l)) {
          break label85;
        }
        throw new b.b("ZIP64 APK not supported");
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        ByteBuffer localByteBuffer;
        long l;
        RandomAccessFile localRandomAccessFile = null;
      }
    }
    if (localRandomAccessFile != null) {
      localRandomAccessFile.close();
    }
    throw paramFile;
    label85:
    paramFile = (ByteBuffer)b.b(localRandomAccessFile, b.b(localByteBuffer, l)).first;
    localRandomAccessFile.close();
    return paramFile;
  }
  
  public static a I(File paramFile)
  {
    localPair1 = null;
    try
    {
      localObject1 = new RandomAccessFile(paramFile, "r");
      try
      {
        localPair1 = b.e((RandomAccessFile)localObject1);
        localObject2 = (ByteBuffer)localPair1.first;
        l1 = ((Long)localPair1.second).longValue();
        if (!k.c((RandomAccessFile)localObject1, l1)) {
          break label76;
        }
        throw new b.b("ZIP64 APK not supported");
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        long l1;
        long l2;
        Pair localPair2;
        a locala;
        Object localObject1 = localPair1;
        continue;
        int i = 0;
      }
    }
    if (localObject1 != null) {
      ((RandomAccessFile)localObject1).close();
    }
    throw paramFile;
    label76:
    l2 = b.b((ByteBuffer)localObject2, l1);
    localObject2 = b.b((RandomAccessFile)localObject1, l2);
    localPair2 = Pair.create(a((RandomAccessFile)localObject1, l2, (int)(l1 - l2)), Long.valueOf(l2));
    locala = new a();
    locala.lowMemory = false;
    locala.iOB = paramFile.length();
    locala.iOC = Pair.create(a((RandomAccessFile)localObject1, 0L, (int)((Long)((Pair)localObject2).second).longValue()), Long.valueOf(0L));
    locala.iOD = ((Pair)localObject2);
    locala.iOE = localPair2;
    locala.iOF = localPair1;
    if (((!locala.lowMemory) && (locala.iOC == null)) || (locala.iOD == null) || (locala.iOE == null) || (locala.iOF == null)) {
      throw new RuntimeException("ApkSectionInfo paramters is not valid : " + locala.toString());
    }
    if (((locala.lowMemory) || ((((Long)locala.iOC.second).longValue() == 0L) && (((ByteBuffer)locala.iOC.first).remaining() + ((Long)locala.iOC.second).longValue() == ((Long)locala.iOD.second).longValue()))) && (((ByteBuffer)locala.iOD.first).remaining() + ((Long)locala.iOD.second).longValue() == ((Long)locala.iOE.second).longValue()) && (((ByteBuffer)locala.iOE.first).remaining() + ((Long)locala.iOE.second).longValue() == ((Long)locala.iOF.second).longValue()))
    {
      l1 = ((ByteBuffer)locala.iOF.first).remaining();
      if (((Long)locala.iOF.second).longValue() + l1 == locala.iOB)
      {
        i = 1;
        if (i == 0) {
          throw new RuntimeException("ApkSectionInfo paramters is not valid : " + locala.toString());
        }
        l1 = b.b((ByteBuffer)locala.iOF.first, ((Long)locala.iOF.second).longValue());
        if (l1 != ((Long)locala.iOE.second).longValue()) {
          throw new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + l1 + ", centralDirOffset : " + locala.iOE.second);
        }
        y.i("MicroMsg.Channel.V2SchemeUtil", "baseApk : " + paramFile.getAbsolutePath() + "\nApkSectionInfo = " + locala);
        ((RandomAccessFile)localObject1).close();
        return locala;
      }
    }
  }
  
  public static boolean J(File paramFile)
  {
    try
    {
      boolean bool = z(H(paramFile)).containsKey(Integer.valueOf(1896449818));
      if (bool) {
        return true;
      }
    }
    catch (IOException paramFile)
    {
      y.e("MicroMsg.Channel.V2SchemeUtil", "containV2Signature, error: %s", new Object[] { paramFile.getMessage() });
      return false;
    }
    catch (b.b localb)
    {
      for (;;)
      {
        y.e("MicroMsg.Channel.V2SchemeUtil", "APK : " + paramFile.getAbsolutePath() + " not have apk signature block");
      }
    }
  }
  
  private static ByteBuffer a(RandomAccessFile paramRandomAccessFile, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    return localByteBuffer;
  }
  
  public static ByteBuffer x(Map<Integer, ByteBuffer> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      throw new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
    }
    Object localObject = paramMap.entrySet().iterator();
    for (long l = 24L; ((Iterator)localObject).hasNext(); l = ((ByteBuffer)((Map.Entry)((Iterator)localObject).next()).getValue()).remaining() + 12 + l) {}
    localObject = ByteBuffer.allocate((int)(8L + l));
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject).putLong(l);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      ByteBuffer localByteBuffer = (ByteBuffer)localEntry.getValue();
      ((ByteBuffer)localObject).putLong(localByteBuffer.remaining() + 4);
      ((ByteBuffer)localObject).putInt(((Integer)localEntry.getKey()).intValue());
      ((ByteBuffer)localObject).put(localByteBuffer.array(), localByteBuffer.arrayOffset() + localByteBuffer.position(), localByteBuffer.remaining());
    }
    ((ByteBuffer)localObject).putLong(l);
    ((ByteBuffer)localObject).putLong(2334950737559900225L);
    ((ByteBuffer)localObject).putLong(3617552046287187010L);
    if (((ByteBuffer)localObject).remaining() > 0) {
      throw new RuntimeException("generateNewApkV2SchemeBlock error");
    }
    ((ByteBuffer)localObject).flip();
    return localObject;
  }
  
  public static Map<Integer, ByteBuffer> z(ByteBuffer paramByteBuffer)
  {
    b.y(paramByteBuffer);
    paramByteBuffer = b.c(paramByteBuffer, paramByteBuffer.capacity() - 24);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8) {
        throw new b.b("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L)) {
        throw new b.b("APK Signing Block entry #" + i + " size out of range: " + l);
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining()) {
        throw new b.b("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
      }
      int m = paramByteBuffer.getInt();
      localLinkedHashMap.put(Integer.valueOf(m), b.d(paramByteBuffer, j - 4));
      if (m == 1896449818) {
        y.i("MicroMsg.Channel.V2SchemeUtil", "find V2 signature block Id : 1896449818");
      }
      paramByteBuffer.position(k + j);
    }
    if (localLinkedHashMap.isEmpty()) {
      throw new b.b("not have Id-Value Pair in APK Signing Block entry #" + i);
    }
    return localLinkedHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.i
 * JD-Core Version:    0.7.0.1
 */