package com.tencent.mm.plugin.appbrand.appcache.pkg;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class b
  extends WxaPkgBaseImpl
{
  private static final ByteOrder jnI = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int jlC = 0;
  private volatile int jlD = 0;
  private volatile int jlE = -1;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, e parame)
  {
    AppMethodBeat.i(175559);
    if (paramFileChannel == null)
    {
      ac.e("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
      AppMethodBeat.o(175559);
      return null;
    }
    if (parame == null)
    {
      ac.e("MicroMsg.WxaPkgNormalImpl", "file is null");
      AppMethodBeat.o(175559);
      return null;
    }
    paramFileChannel.position(14L);
    Object localObject = ByteBuffer.allocate(this.jlC);
    ((ByteBuffer)localObject).order(jnI);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.jlE = q((byte[])localObject, 0, 4);
    a locala = new a();
    int i = 0;
    int j = 4;
    paramFileChannel = null;
    while (i < this.jlE)
    {
      int k = q((byte[])localObject, j, 4);
      j += 4;
      String str = new String((byte[])localObject, j, k);
      j += k;
      k = q((byte[])localObject, j, 4);
      j += 4;
      int m = q((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new WxaPkgBaseImpl.Info(q.B(parame.fxV()), str, k, m);
      locala.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.jlY + paramFileChannel.jlZ > parame.length()))
    {
      ac.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.jlY), Integer.valueOf(paramFileChannel.jlZ), Long.valueOf(parame.length()) });
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
    localByteBuffer.order(jnI);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(13)))
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = q(paramFileChannel, 1, 4);
    this.jlC = q(paramFileChannel, 5, 4);
    this.jlD = q(paramFileChannel, 9, 4);
    AppMethodBeat.o(175558);
    return true;
  }
  
  public final int aXv()
  {
    return this.jlC;
  }
  
  public final int aXw()
  {
    return this.jlE;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return false;
  }
  
  public final void close()
  {
    this.cR = -1;
    this.jlC = 0;
    this.jlD = 0;
    this.jlE = -1;
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