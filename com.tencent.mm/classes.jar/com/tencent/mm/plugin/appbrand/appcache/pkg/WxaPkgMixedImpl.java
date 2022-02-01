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

public final class WxaPkgMixedImpl
  extends WxaPkgBaseImpl
{
  private static final ByteOrder jKG = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int jIr = 0;
  private volatile int jIs = 0;
  private volatile int jIt = -1;
  private volatile int jMH = 0;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, k paramk)
  {
    AppMethodBeat.i(175557);
    if (paramFileChannel == null)
    {
      ae.e("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
      AppMethodBeat.o(175557);
      return null;
    }
    if (paramk == null)
    {
      ae.e("MicroMsg.WxaPkgMixedImpl", "file is null");
      AppMethodBeat.o(175557);
      return null;
    }
    paramFileChannel.position(18L);
    Object localObject = ByteBuffer.allocate(this.jIr);
    ((ByteBuffer)localObject).order(jKG);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.jIt = q((byte[])localObject, 0, 4);
    a locala = new a();
    paramFileChannel = null;
    int j = 0;
    int i = 4;
    if (j < this.jIt)
    {
      int k = q((byte[])localObject, i, 4);
      i += 4;
      String str = new String((byte[])localObject, i, k);
      i = k + i;
      k = q((byte[])localObject, i, 1);
      i += 1;
      int i1 = q((byte[])localObject, i, 4);
      int m = i + 4;
      int n = q((byte[])localObject, m, 4);
      i = 0;
      if (k == 0) {
        i = this.jIr + 18 + this.jMH + i1;
      }
      for (;;)
      {
        paramFileChannel = new Info(w.B(paramk.fTh()), str, i, n, k);
        locala.put(str, paramFileChannel);
        j += 1;
        i = m + 4;
        break;
        if (k == 1) {
          i = this.jIr + 18 + i1;
        } else {
          ae.e("MicroMsg.WxaPkgMixedImpl", "encType error: %d", new Object[] { Integer.valueOf(k) });
        }
      }
    }
    if ((paramFileChannel != null) && (paramFileChannel.jIN + paramFileChannel.jIO > paramk.length()))
    {
      ae.e("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.jIN), Integer.valueOf(paramFileChannel.jIO), Long.valueOf(paramk.length()) });
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
    localByteBuffer.order(jKG);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(17)))
    {
      AppMethodBeat.o(175556);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = q(paramFileChannel, 1, 4);
    this.jIr = q(paramFileChannel, 5, 4);
    this.jMH = q(paramFileChannel, 9, 4);
    this.jIs = q(paramFileChannel, 13, 4);
    AppMethodBeat.o(175556);
    return true;
  }
  
  public final boolean b(WxaPkg.Info paramInfo)
  {
    return ((paramInfo instanceof Info)) && (paramInfo.fileName != null) && (((Info)paramInfo).jMI == 1);
  }
  
  public final int bbs()
  {
    return this.jIr;
  }
  
  public final int bbt()
  {
    return this.jIt;
  }
  
  public final void close() {}
  
  public final int getVersion()
  {
    return this.cR;
  }
  
  public static class Info
    extends WxaPkgBaseImpl.Info
  {
    public final int jMI;
    
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramString2, paramInt1, paramInt2);
      this.jMI = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl
 * JD-Core Version:    0.7.0.1
 */