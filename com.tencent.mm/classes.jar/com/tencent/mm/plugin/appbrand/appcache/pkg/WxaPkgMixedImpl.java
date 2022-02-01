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

public final class WxaPkgMixedImpl
  extends WxaPkgBaseImpl
{
  private static final ByteOrder kMF = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int kKn = 0;
  private volatile int kKo = 0;
  private volatile int kKp = -1;
  private volatile int kOL = 0;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, o paramo)
  {
    AppMethodBeat.i(175557);
    if (paramFileChannel == null)
    {
      Log.e("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
      AppMethodBeat.o(175557);
      return null;
    }
    if (paramo == null)
    {
      Log.e("MicroMsg.WxaPkgMixedImpl", "file is null");
      AppMethodBeat.o(175557);
      return null;
    }
    paramFileChannel.position(18L);
    Object localObject = ByteBuffer.allocate(this.kKn);
    ((ByteBuffer)localObject).order(kMF);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.kKp = A((byte[])localObject, 0, 4);
    a locala = new a();
    paramFileChannel = null;
    int j = 0;
    int i = 4;
    if (j < this.kKp)
    {
      int k = A((byte[])localObject, i, 4);
      i += 4;
      String str = new String((byte[])localObject, i, k);
      i = k + i;
      k = A((byte[])localObject, i, 1);
      i += 1;
      int i1 = A((byte[])localObject, i, 4);
      int m = i + 4;
      int n = A((byte[])localObject, m, 4);
      i = 0;
      if (k == 0) {
        i = this.kKn + 18 + this.kOL + i1;
      }
      for (;;)
      {
        paramFileChannel = new Info(aa.z(paramo.her()), str, i, n, k);
        locala.put(str, paramFileChannel);
        j += 1;
        i = m + 4;
        break;
        if (k == 1) {
          i = this.kKn + 18 + i1;
        } else {
          Log.e("MicroMsg.WxaPkgMixedImpl", "encType error: %d", new Object[] { Integer.valueOf(k) });
        }
      }
    }
    if ((paramFileChannel != null) && (paramFileChannel.kKJ + paramFileChannel.kKK > paramo.length())) {
      Log.e("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", new Object[] { Integer.valueOf(paramFileChannel.kKJ), Integer.valueOf(paramFileChannel.kKK), Long.valueOf(paramo.length()), Integer.valueOf(locala.size()), Integer.valueOf(this.kKp) });
    }
    AppMethodBeat.o(175557);
    return locala;
  }
  
  public final boolean a(FileChannel paramFileChannel)
  {
    AppMethodBeat.i(175556);
    if (paramFileChannel == null)
    {
      AppMethodBeat.o(175556);
      return false;
    }
    paramFileChannel.position(0L);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(18);
    localByteBuffer.order(kMF);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(17)))
    {
      AppMethodBeat.o(175556);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = A(paramFileChannel, 1, 4);
    this.kKn = A(paramFileChannel, 5, 4);
    this.kOL = A(paramFileChannel, 9, 4);
    this.kKo = A(paramFileChannel, 13, 4);
    AppMethodBeat.o(175556);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return ((paramInfo instanceof Info)) && (paramInfo.fileName != null) && (((Info)paramInfo).kOM == 1);
  }
  
  public final int bwF()
  {
    return this.kKn;
  }
  
  public final int bwG()
  {
    return this.kKp;
  }
  
  public final void close() {}
  
  public final int getVersion()
  {
    return this.cR;
  }
  
  public static class Info
    extends WxaPkgBaseImpl.Info
  {
    public final int kOM;
    
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramString2, paramInt1, paramInt2);
      this.kOM = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl
 * JD-Core Version:    0.7.0.1
 */