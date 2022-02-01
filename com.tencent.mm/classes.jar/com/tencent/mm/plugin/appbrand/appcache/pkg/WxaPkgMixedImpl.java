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

public final class WxaPkgMixedImpl
  extends WxaPkgBaseImpl
{
  private static final ByteOrder qGr = ByteOrder.BIG_ENDIAN;
  private volatile int bHI = -1;
  private volatile int qDY = 0;
  private volatile int qDZ = 0;
  private volatile int qEa = -1;
  private volatile int qIE = 0;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, u paramu)
  {
    AppMethodBeat.i(175557);
    if (paramFileChannel == null)
    {
      Log.e("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
      AppMethodBeat.o(175557);
      return null;
    }
    if (paramu == null)
    {
      Log.e("MicroMsg.WxaPkgMixedImpl", "file is null");
      AppMethodBeat.o(175557);
      return null;
    }
    paramFileChannel.position(18L);
    Object localObject = ByteBuffer.allocate(this.qDY);
    ((ByteBuffer)localObject).order(qGr);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.qEa = z((byte[])localObject, 0, 4);
    a locala = new a();
    paramFileChannel = null;
    int j = 0;
    int i = 4;
    if (j < this.qEa)
    {
      int k = z((byte[])localObject, i, 4);
      i += 4;
      String str = new String((byte[])localObject, i, k);
      i = k + i;
      k = z((byte[])localObject, i, 1);
      i += 1;
      int i1 = z((byte[])localObject, i, 4);
      int m = i + 4;
      int n = z((byte[])localObject, m, 4);
      i = 0;
      if (k == 0) {
        i = this.qDY + 18 + this.qIE + i1;
      }
      for (;;)
      {
        paramFileChannel = new Info(ah.v(paramu.jKT()), str, i, n, k);
        locala.put(str, paramFileChannel);
        j += 1;
        i = m + 4;
        break;
        if (k == 1) {
          i = this.qDY + 18 + i1;
        } else {
          Log.e("MicroMsg.WxaPkgMixedImpl", "encType error: %d", new Object[] { Integer.valueOf(k) });
        }
      }
    }
    if ((paramFileChannel != null) && (paramFileChannel.qEv + paramFileChannel.qEw > paramu.length())) {
      Log.e("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", new Object[] { Integer.valueOf(paramFileChannel.qEv), Integer.valueOf(paramFileChannel.qEw), Long.valueOf(paramu.length()), Integer.valueOf(locala.size()), Integer.valueOf(this.qEa) });
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
    localByteBuffer.order(qGr);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(17)))
    {
      AppMethodBeat.o(175556);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.bHI = z(paramFileChannel, 1, 4);
    this.qDY = z(paramFileChannel, 5, 4);
    this.qIE = z(paramFileChannel, 9, 4);
    this.qDZ = z(paramFileChannel, 13, 4);
    AppMethodBeat.o(175556);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return ((paramInfo instanceof Info)) && (paramInfo.fileName != null) && (((Info)paramInfo).qIF == 1);
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
  
  public final void close() {}
  
  public static class Info
    extends WxaPkgBaseImpl.Info
  {
    public final int qIF;
    
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramString2, paramInt1, paramInt2);
      this.qIF = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl
 * JD-Core Version:    0.7.0.1
 */