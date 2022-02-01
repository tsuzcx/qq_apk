package com.tencent.mm.plugin.appbrand.appcache.pkg;

import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class b
  extends WxaPkgBaseImpl
{
  private static final ByteOrder nGz = ByteOrder.BIG_ENDIAN;
  private volatile int aan = -1;
  private volatile int nEe = 0;
  private volatile int nEf = 0;
  private volatile int nEg = -1;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, q paramq)
  {
    String str = null;
    AppMethodBeat.i(175559);
    if (paramFileChannel == null)
    {
      Log.e("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
      AppMethodBeat.o(175559);
      return null;
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.WxaPkgNormalImpl", "file is null");
      AppMethodBeat.o(175559);
      return null;
    }
    paramFileChannel.position(14L);
    Object localObject = ByteBuffer.allocate(this.nEe);
    ((ByteBuffer)localObject).order(nGz);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.nEg = B((byte[])localObject, 0, 4);
    a locala = new a();
    int i = 0;
    int j = 4;
    paramFileChannel = str;
    while (i < this.nEg)
    {
      int k = B((byte[])localObject, j, 4);
      j += 4;
      str = new String((byte[])localObject, j, k);
      j += k;
      k = B((byte[])localObject, j, 4);
      j += 4;
      int m = B((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new WxaPkgBaseImpl.Info(paramq.bOF(), str, k, m);
      locala.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.nEy + paramFileChannel.nEz > paramq.length())) {
      Log.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", new Object[] { Integer.valueOf(paramFileChannel.nEy), Integer.valueOf(paramFileChannel.nEz), Long.valueOf(paramq.length()), Integer.valueOf(locala.size()), Integer.valueOf(this.nEg) });
    }
    AppMethodBeat.o(175559);
    return locala;
  }
  
  public final boolean a(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(175558);
    if (paramFileChannel == null)
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel.position(0L);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(14);
    localByteBuffer.order(nGz);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(13)))
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.aan = B(paramFileChannel, 1, 4);
    this.nEe = B(paramFileChannel, 5, 4);
    this.nEf = B(paramFileChannel, 9, 4);
    AppMethodBeat.o(175558);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return false;
  }
  
  public final int bHN()
  {
    return this.nEe;
  }
  
  public final int bHO()
  {
    return this.nEg;
  }
  
  public final void close()
  {
    this.aan = -1;
    this.nEe = 0;
    this.nEf = 0;
    this.nEg = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.b
 * JD-Core Version:    0.7.0.1
 */