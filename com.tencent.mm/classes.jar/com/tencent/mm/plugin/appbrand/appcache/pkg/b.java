package com.tencent.mm.plugin.appbrand.appcache.pkg;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class b
  extends WxaPkgBaseImpl
{
  private static final ByteOrder jHF = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int jFs = 0;
  private volatile int jFt = 0;
  private volatile int jFu = -1;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, e parame)
  {
    AppMethodBeat.i(175559);
    if (paramFileChannel == null)
    {
      ad.e("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
      AppMethodBeat.o(175559);
      return null;
    }
    if (parame == null)
    {
      ad.e("MicroMsg.WxaPkgNormalImpl", "file is null");
      AppMethodBeat.o(175559);
      return null;
    }
    paramFileChannel.position(14L);
    Object localObject = ByteBuffer.allocate(this.jFs);
    ((ByteBuffer)localObject).order(jHF);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.jFu = q((byte[])localObject, 0, 4);
    a locala = new a();
    int i = 0;
    int j = 4;
    paramFileChannel = null;
    while (i < this.jFu)
    {
      int k = q((byte[])localObject, j, 4);
      j += 4;
      String str = new String((byte[])localObject, j, k);
      j += k;
      k = q((byte[])localObject, j, 4);
      j += 4;
      int m = q((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new WxaPkgBaseImpl.Info(q.B(parame.fOK()), str, k, m);
      locala.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.jFO + paramFileChannel.jFP > parame.length()))
    {
      ad.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.jFO), Integer.valueOf(paramFileChannel.jFP), Long.valueOf(parame.length()) });
      AppMethodBeat.o(175559);
      return null;
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
    localByteBuffer.order(jHF);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(13)))
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = q(paramFileChannel, 1, 4);
    this.jFs = q(paramFileChannel, 5, 4);
    this.jFt = q(paramFileChannel, 9, 4);
    AppMethodBeat.o(175558);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return false;
  }
  
  public final int baT()
  {
    return this.jFs;
  }
  
  public final int baU()
  {
    return this.jFu;
  }
  
  public final void close()
  {
    this.cR = -1;
    this.jFs = 0;
    this.jFt = 0;
    this.jFu = -1;
  }
  
  public final int getVersion()
  {
    return this.cR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.b
 * JD-Core Version:    0.7.0.1
 */