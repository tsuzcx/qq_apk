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
  private static final ByteOrder iNA = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int iLv = 0;
  private volatile int iLw = 0;
  private volatile int iLx = -1;
  
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
    Object localObject = ByteBuffer.allocate(this.iLv);
    ((ByteBuffer)localObject).order(iNA);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.iLx = r((byte[])localObject, 0, 4);
    a locala = new a();
    int i = 0;
    int j = 4;
    paramFileChannel = null;
    while (i < this.iLx)
    {
      int k = r((byte[])localObject, j, 4);
      j += 4;
      String str = new String((byte[])localObject, j, k);
      j += k;
      k = r((byte[])localObject, j, 4);
      j += 4;
      int m = r((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new WxaPkgBaseImpl.Info(q.B(parame.fhU()), str, k, m);
      locala.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.iLR + paramFileChannel.iLS > parame.length()))
    {
      ad.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.iLR), Integer.valueOf(paramFileChannel.iLS), Long.valueOf(parame.length()) });
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
    localByteBuffer.order(iNA);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(13)))
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = r(paramFileChannel, 1, 4);
    this.iLv = r(paramFileChannel, 5, 4);
    this.iLw = r(paramFileChannel, 9, 4);
    AppMethodBeat.o(175558);
    return true;
  }
  
  public final int aQD()
  {
    return this.iLv;
  }
  
  public final int aQE()
  {
    return this.iLx;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return false;
  }
  
  public final void close()
  {
    this.cR = -1;
    this.iLv = 0;
    this.iLw = 0;
    this.iLx = -1;
  }
  
  public final int getVersion()
  {
    return this.cR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.b
 * JD-Core Version:    0.7.0.1
 */