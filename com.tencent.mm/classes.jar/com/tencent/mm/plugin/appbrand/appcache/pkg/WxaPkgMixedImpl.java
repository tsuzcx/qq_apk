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

public final class WxaPkgMixedImpl
  extends WxaPkgBaseImpl
{
  private static final ByteOrder jnI = ByteOrder.BIG_ENDIAN;
  private volatile int cR = -1;
  private volatile int jlC = 0;
  private volatile int jlD = 0;
  private volatile int jlE = -1;
  private volatile int jpL = 0;
  
  public final Map<String, WxaPkg.Info> a(FileChannel paramFileChannel, e parame)
  {
    AppMethodBeat.i(175557);
    if (paramFileChannel == null)
    {
      ac.e("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
      AppMethodBeat.o(175557);
      return null;
    }
    if (parame == null)
    {
      ac.e("MicroMsg.WxaPkgMixedImpl", "file is null");
      AppMethodBeat.o(175557);
      return null;
    }
    paramFileChannel.position(18L);
    Object localObject = ByteBuffer.allocate(this.jlC);
    ((ByteBuffer)localObject).order(jnI);
    paramFileChannel.read((ByteBuffer)localObject);
    localObject = ((ByteBuffer)localObject).array();
    this.jlE = q((byte[])localObject, 0, 4);
    a locala = new a();
    paramFileChannel = null;
    int j = 0;
    int i = 4;
    if (j < this.jlE)
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
        i = this.jlC + 18 + this.jpL + i1;
      }
      for (;;)
      {
        paramFileChannel = new Info(q.B(parame.fxV()), str, i, n, k);
        locala.put(str, paramFileChannel);
        j += 1;
        i = m + 4;
        break;
        if (k == 1) {
          i = this.jlC + 18 + i1;
        } else {
          ac.e("MicroMsg.WxaPkgMixedImpl", "encType error: %d", new Object[] { Integer.valueOf(k) });
        }
      }
    }
    if ((paramFileChannel != null) && (paramFileChannel.jlY + paramFileChannel.jlZ > parame.length()))
    {
      ac.e("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[] { Integer.valueOf(paramFileChannel.jlY), Integer.valueOf(paramFileChannel.jlZ), Long.valueOf(parame.length()) });
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
    localByteBuffer.order(jnI);
    paramFileChannel.read(localByteBuffer);
    if ((-66 != localByteBuffer.get(0)) || (-19 != localByteBuffer.get(17)))
    {
      AppMethodBeat.o(175556);
      return false;
    }
    paramFileChannel = localByteBuffer.array();
    this.cR = q(paramFileChannel, 1, 4);
    this.jlC = q(paramFileChannel, 5, 4);
    this.jpL = q(paramFileChannel, 9, 4);
    this.jlD = q(paramFileChannel, 13, 4);
    AppMethodBeat.o(175556);
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
    return ((paramInfo instanceof Info)) && (paramInfo.fileName != null) && (((Info)paramInfo).jpM == 1);
  }
  
  public final void close() {}
  
  public final int getVersion()
  {
    return this.cR;
  }
  
  public static class Info
    extends WxaPkgBaseImpl.Info
  {
    public final int jpM;
    
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramString2, paramInt1, paramInt2);
      this.jpM = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgMixedImpl
 * JD-Core Version:    0.7.0.1
 */