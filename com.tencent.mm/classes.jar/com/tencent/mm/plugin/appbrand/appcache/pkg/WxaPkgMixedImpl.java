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

public final class WxaPkgMixedImpl
  extends WxaPkgBaseImpl
{
  private static final ByteOrder iNA = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int iLv = 0;
  private volatile int iLw = 0;
  private volatile int iLx = -1;
  private volatile int iPC = 0;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, e parame)
  {
    AppMethodBeat.i(175557);
    if (paramFileChannel == null)
    {
      ad.e("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
      AppMethodBeat.o(175557);
      return null;
    }
    if (parame == null)
    {
      ad.e("MicroMsg.WxaPkgMixedImpl", "file is null");
      AppMethodBeat.o(175557);
      return null;
    }
    paramFileChannel.position(18L);
    Object localObject = ByteBuffer.allocate(this.iLv);
    ((ByteBuffer)localObject).order(iNA);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.iLx = r((byte[])localObject, 0, 4);
    a locala = new a();
    paramFileChannel = null;
    int j = 0;
    int i = 4;
    if (j < this.iLx)
    {
      int k = r((byte[])localObject, i, 4);
      i += 4;
      String str = new String((byte[])localObject, i, k);
      i = k + i;
      k = r((byte[])localObject, i, 1);
      i += 1;
      int i1 = r((byte[])localObject, i, 4);
      int m = i + 4;
      int n = r((byte[])localObject, m, 4);
      i = 0;
      if (k == 0) {
        i = this.iLv + 18 + this.iPC + i1;
      }
      for (;;)
      {
        paramFileChannel = new Info(q.B(parame.fhU()), str, i, n, k);
        locala.put(str, paramFileChannel);
        j += 1;
        i = m + 4;
        break;
        if (k == 1) {
          i = this.iLv + 18 + i1;
        } else {
          ad.e("MicroMsg.WxaPkgMixedImpl", "encType error: %d", new Object[] { Integer.valueOf(k) });
        }
      }
    }
    if ((paramFileChannel != null) && (paramFileChannel.iLR + paramFileChannel.iLS > parame.length()))
    {
      ad.e("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.iLR), Integer.valueOf(paramFileChannel.iLS), Long.valueOf(parame.length()) });
      AppMethodBeat.o(175557);
      return null;
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
    localByteBuffer.order(iNA);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(17)))
    {
      AppMethodBeat.o(175556);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = r(paramFileChannel, 1, 4);
    this.iLv = r(paramFileChannel, 5, 4);
    this.iPC = r(paramFileChannel, 9, 4);
    this.iLw = r(paramFileChannel, 13, 4);
    AppMethodBeat.o(175556);
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
    return ((paramInfo instanceof Info)) && (paramInfo.fileName != null) && (((Info)paramInfo).iPD == 1);
  }
  
  public final void close() {}
  
  public final int getVersion()
  {
    return this.cR;
  }
  
  public static class Info
    extends WxaPkgBaseImpl.Info
  {
    public final int iPD;
    
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramString2, paramInt1, paramInt2);
      this.iPD = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl
 * JD-Core Version:    0.7.0.1
 */