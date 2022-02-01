package com.tencent.mm.plugin.appbrand.appcache.pkg;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

public final class b
  extends WxaPkgBaseImpl
{
  private static final ByteOrder kMF = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int kKn = 0;
  private volatile int kKo = 0;
  private volatile int kKp = -1;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, o paramo)
  {
    String str = null;
    AppMethodBeat.i(175559);
    if (paramFileChannel == null)
    {
      Log.e("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
      AppMethodBeat.o(175559);
      return null;
    }
    if (paramo == null)
    {
      Log.e("MicroMsg.WxaPkgNormalImpl", "file is null");
      AppMethodBeat.o(175559);
      return null;
    }
    paramFileChannel.position(14L);
    Object localObject = ByteBuffer.allocate(this.kKn);
    ((ByteBuffer)localObject).order(kMF);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.kKp = A((byte[])localObject, 0, 4);
    a locala = new a();
    int i = 0;
    int j = 4;
    paramFileChannel = str;
    while (i < this.kKp)
    {
      int k = A((byte[])localObject, j, 4);
      j += 4;
      str = new String((byte[])localObject, j, k);
      j += k;
      k = A((byte[])localObject, j, 4);
      j += 4;
      int m = A((byte[])localObject, j, 4);
      j += 4;
      paramFileChannel = new WxaPkgBaseImpl.Info(aa.z(paramo.her()), str, k, m);
      locala.put(str, paramFileChannel);
      i += 1;
    }
    if ((paramFileChannel != null) && (paramFileChannel.kKJ + paramFileChannel.kKK > paramo.length())) {
      Log.e("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", new Object[] { Integer.valueOf(paramFileChannel.kKJ), Integer.valueOf(paramFileChannel.kKK), Long.valueOf(paramo.length()), Integer.valueOf(locala.size()), Integer.valueOf(this.kKp) });
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
    localByteBuffer.order(kMF);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(13)))
    {
      AppMethodBeat.o(175558);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = A(paramFileChannel, 1, 4);
    this.kKn = A(paramFileChannel, 5, 4);
    this.kKo = A(paramFileChannel, 9, 4);
    AppMethodBeat.o(175558);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return false;
  }
  
  public final int bwF()
  {
    return this.kKn;
  }
  
  public final int bwG()
  {
    return this.kKp;
  }
  
  public final void close()
  {
    this.cR = -1;
    this.kKn = 0;
    this.kKo = 0;
    this.kKp = -1;
  }
  
  public final int getVersion()
  {
    return this.cR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.b
 * JD-Core Version:    0.7.0.1
 */