package com.tencent.mm.plugin.appbrand.appcache.pkg;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class b
  extends WxaPkgBaseImpl
{
  private static final ByteOrder jKG = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int jIr = 0;
  private volatile int jIs = 0;
  private volatile int jIt = -1;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, k paramk)
  {
    AppMethodBeat.i(175559);
    if (paramFileChannel == null)
    {
      ae.e("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
      AppMethodBeat.o(175559);
      return null;
    }
    if (paramk == null)
    {
      ae.e("MicroMsg.WxaPkgNormalImpl", "file is null");
      AppMethodBeat.o(175559);
      return null;
    }
    paramFileChannel.position(14L);
    Object localObject = ByteBuffer.allocate(this.jIr);
    ((ByteBuffer)localObject).order(jKG);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.jIt = q((byte[])localObject, 0, 4);
    a locala = new a();
    int i = 0;
    int j = 4;
    paramFileChannel = null;
    while (i < this.jIt)
    {
      int k = q((byte[])localObject, j, 4);
      j += 4;
      String str = new String((byte[])localObject, j, k);
      j += k;
      k = q((byte[])localObject, j, 4);
      j += 4;
      int m = q((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new WxaPkgBaseImpl.Info(w.B(paramk.fTh()), str, k, m);
      locala.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.jIN + paramFileChannel.jIO > paramk.length()))
    {
      ae.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.jIN), Integer.valueOf(paramFileChannel.jIO), Long.valueOf(paramk.length()) });
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
    localByteBuffer.order(jKG);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(13)))
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = q(paramFileChannel, 1, 4);
    this.jIr = q(paramFileChannel, 5, 4);
    this.jIs = q(paramFileChannel, 9, 4);
    AppMethodBeat.o(175558);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return false;
  }
  
  public final int bbs()
  {
    return this.jIr;
  }
  
  public final int bbt()
  {
    return this.jIt;
  }
  
  public final void close()
  {
    this.cR = -1;
    this.jIr = 0;
    this.jIs = 0;
    this.jIt = -1;
  }
  
  public final int getVersion()
  {
    return this.cR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.b
 * JD-Core Version:    0.7.0.1
 */