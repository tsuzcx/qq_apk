package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  public static Map<Integer, ByteBuffer> A(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(2326);
    b.z(paramByteBuffer);
    paramByteBuffer = b.d(paramByteBuffer, paramByteBuffer.capacity() - 24);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8)
      {
        paramByteBuffer = new b.b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
        AppMethodBeat.o(2326);
        throw paramByteBuffer;
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L))
      {
        paramByteBuffer = new b.b("APK Signing Block entry #" + i + " size out of range: " + l);
        AppMethodBeat.o(2326);
        throw paramByteBuffer;
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining())
      {
        paramByteBuffer = new b.b("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
        AppMethodBeat.o(2326);
        throw paramByteBuffer;
      }
      int m = paramByteBuffer.getInt();
      localLinkedHashMap.put(Integer.valueOf(m), b.e(paramByteBuffer, j - 4));
      if (m == 1896449818) {
        ab.i("MicroMsg.Channel.V2SchemeUtil", "find V2 signature block Id : 1896449818");
      }
      paramByteBuffer.position(k + j);
    }
    if (localLinkedHashMap.isEmpty())
    {
      paramByteBuffer = new b.b("not have Id-Value Pair in APK Signing Block entry #".concat(String.valueOf(i)));
      AppMethodBeat.o(2326);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(2326);
    return localLinkedHashMap;
  }
  
  public static ByteBuffer H(Map<Integer, ByteBuffer> paramMap)
  {
    AppMethodBeat.i(2330);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      paramMap = new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
      AppMethodBeat.o(2330);
      throw paramMap;
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
    if (((ByteBuffer)localObject).remaining() > 0)
    {
      paramMap = new RuntimeException("generateNewApkV2SchemeBlock error");
      AppMethodBeat.o(2330);
      throw paramMap;
    }
    ((ByteBuffer)localObject).flip();
    AppMethodBeat.o(2330);
    return localObject;
  }
  
  public static ByteBuffer P(File paramFile)
  {
    AppMethodBeat.i(2327);
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile()))
    {
      AppMethodBeat.o(2327);
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
          break label112;
        }
        paramFile = new b.b("ZIP64 APK not supported");
        AppMethodBeat.o(2327);
        throw paramFile;
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
    AppMethodBeat.o(2327);
    throw paramFile;
    label112:
    paramFile = (ByteBuffer)b.b(localRandomAccessFile, b.b(localByteBuffer, l)).first;
    localRandomAccessFile.close();
    AppMethodBeat.o(2327);
    return paramFile;
  }
  
  public static a Q(File paramFile)
  {
    AppMethodBeat.i(2328);
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
          break label97;
        }
        paramFile = new b.b("ZIP64 APK not supported");
        AppMethodBeat.o(2328);
        throw paramFile;
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
    AppMethodBeat.o(2328);
    throw paramFile;
    label97:
    l2 = b.b((ByteBuffer)localObject2, l1);
    localObject2 = b.b((RandomAccessFile)localObject1, l2);
    localPair2 = Pair.create(a((RandomAccessFile)localObject1, l2, (int)(l1 - l2)), Long.valueOf(l2));
    locala = new a();
    locala.lowMemory = false;
    locala.kXs = paramFile.length();
    locala.kXt = Pair.create(a((RandomAccessFile)localObject1, 0L, (int)((Long)((Pair)localObject2).second).longValue()), Long.valueOf(0L));
    locala.kXu = ((Pair)localObject2);
    locala.kXv = localPair2;
    locala.kXw = localPair1;
    if (((!locala.lowMemory) && (locala.kXt == null)) || (locala.kXu == null) || (locala.kXv == null) || (locala.kXw == null))
    {
      paramFile = new RuntimeException("ApkSectionInfo paramters is not valid : " + locala.toString());
      AppMethodBeat.o(2328);
      throw paramFile;
    }
    if (((locala.lowMemory) || ((((Long)locala.kXt.second).longValue() == 0L) && (((ByteBuffer)locala.kXt.first).remaining() + ((Long)locala.kXt.second).longValue() == ((Long)locala.kXu.second).longValue()))) && (((ByteBuffer)locala.kXu.first).remaining() + ((Long)locala.kXu.second).longValue() == ((Long)locala.kXv.second).longValue()) && (((ByteBuffer)locala.kXv.first).remaining() + ((Long)locala.kXv.second).longValue() == ((Long)locala.kXw.second).longValue()))
    {
      l1 = ((ByteBuffer)locala.kXw.first).remaining();
      if (((Long)locala.kXw.second).longValue() + l1 == locala.kXs)
      {
        i = 1;
        if (i == 0)
        {
          paramFile = new RuntimeException("ApkSectionInfo paramters is not valid : " + locala.toString());
          AppMethodBeat.o(2328);
          throw paramFile;
        }
        l1 = b.b((ByteBuffer)locala.kXw.first, ((Long)locala.kXw.second).longValue());
        if (l1 != ((Long)locala.kXv.second).longValue())
        {
          paramFile = new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + l1 + ", centralDirOffset : " + locala.kXv.second);
          AppMethodBeat.o(2328);
          throw paramFile;
        }
        ab.i("MicroMsg.Channel.V2SchemeUtil", "baseApk : " + paramFile.getAbsolutePath() + "\nApkSectionInfo = " + locala);
        ((RandomAccessFile)localObject1).close();
        AppMethodBeat.o(2328);
        return locala;
      }
    }
  }
  
  public static boolean R(File paramFile)
  {
    AppMethodBeat.i(2331);
    try
    {
      boolean bool = A(P(paramFile)).containsKey(Integer.valueOf(1896449818));
      if (bool)
      {
        AppMethodBeat.o(2331);
        return true;
      }
    }
    catch (IOException paramFile)
    {
      ab.e("MicroMsg.Channel.V2SchemeUtil", "containV2Signature, error: %s", new Object[] { paramFile.getMessage() });
      AppMethodBeat.o(2331);
      return false;
    }
    catch (b.b localb)
    {
      for (;;)
      {
        ab.e("MicroMsg.Channel.V2SchemeUtil", "APK : " + paramFile.getAbsolutePath() + " not have apk signature block");
      }
    }
  }
  
  private static ByteBuffer a(RandomAccessFile paramRandomAccessFile, long paramLong, int paramInt)
  {
    AppMethodBeat.i(2329);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    AppMethodBeat.o(2329);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.i
 * JD-Core Version:    0.7.0.1
 */