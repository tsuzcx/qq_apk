package com.tencent.mm.plugin.appbrand.appcache.pkg;

import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class b
  extends WxaPkgBaseImpl
{
  private static final ByteOrder qGr = ByteOrder.BIG_ENDIAN;
  private volatile int bHI = -1;
  private volatile int qDY = 0;
  private volatile int qDZ = 0;
  private volatile int qEa = -1;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, u paramu)
  {
    String str = null;
    AppMethodBeat.i(175559);
    if (paramFileChannel == null)
    {
      Log.e("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
      AppMethodBeat.o(175559);
      return null;
    }
    if (paramu == null)
    {
      Log.e("MicroMsg.WxaPkgNormalImpl", "file is null");
      AppMethodBeat.o(175559);
      return null;
    }
    paramFileChannel.position(14L);
    Object localObject = ByteBuffer.allocate(this.qDY);
    ((ByteBuffer)localObject).order(qGr);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.qEa = z((byte[])localObject, 0, 4);
    a locala = new a();
    int i = 0;
    int j = 4;
    paramFileChannel = str;
    while (i < this.qEa)
    {
      int k = z((byte[])localObject, j, 4);
      j += 4;
      str = new String((byte[])localObject, j, k);
      j += k;
      k = z((byte[])localObject, j, 4);
      j += 4;
      int m = z((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new WxaPkgBaseImpl.Info(ah.v(paramu.jKT()), str, k, m);
      locala.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.qEv + paramFileChannel.qEw > paramu.length())) {
      Log.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", new Object[] { Integer.valueOf(paramFileChannel.qEv), Integer.valueOf(paramFileChannel.qEw), Long.valueOf(paramu.length()), Integer.valueOf(locala.size()), Integer.valueOf(this.qEa) });
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
    localByteBuffer.order(qGr);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(13)))
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.bHI = z(paramFileChannel, 1, 4);
    this.qDY = z(paramFileChannel, 5, 4);
    this.qDZ = z(paramFileChannel, 9, 4);
    AppMethodBeat.o(175558);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return false;
  }
  
  public final int chj()
  {
    return this.qDY;
  }
  
  public final int chk()
  {
    return this.qEa;
  }
  
  public final InputStream chl()
  {
    return null;
  }
  
  public final void close()
  {
    this.bHI = -1;
    this.qDY = 0;
    this.qDZ = 0;
    this.qEa = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.b
 * JD-Core Version:    0.7.0.1
 */