package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import java.nio.ByteBuffer;

final class ab$4
  extends w
{
  ab$4(ab paramab) {}
  
  public final int act()
  {
    AppMethodBeat.i(246682);
    if (this.nya.nxR != null)
    {
      int i = this.nya.nxR.getNativeBufferId();
      AppMethodBeat.o(246682);
      return i;
    }
    AppMethodBeat.o(246682);
    return 0;
  }
  
  public final void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246687);
    if (this.nya.nxR != null) {
      this.nya.nxR.bufferStoreBindTo(paramLong1, paramLong2);
    }
    AppMethodBeat.o(246687);
  }
  
  public final ByteBuffer kk(int paramInt)
  {
    AppMethodBeat.i(246684);
    if (this.nya.nxR != null)
    {
      ByteBuffer localByteBuffer = this.nya.nxR.P(paramInt, false);
      AppMethodBeat.o(246684);
      return localByteBuffer;
    }
    AppMethodBeat.o(246684);
    return null;
  }
  
  public final void q(int paramInt, String paramString)
  {
    AppMethodBeat.i(246688);
    this.nya.ntA.getJsRuntime().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString }), null);
    AppMethodBeat.o(246688);
  }
  
  public final void setBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(246685);
    if (this.nya.nxR != null) {
      this.nya.nxR.setNativeBuffer(paramInt, paramByteBuffer);
    }
    AppMethodBeat.o(246685);
  }
  
  public final boolean supportBufferStoreBindTo()
  {
    AppMethodBeat.i(246686);
    if (this.nya.nxR != null)
    {
      boolean bool = this.nya.nxR.supportBufferStoreBindTo();
      AppMethodBeat.o(246686);
      return bool;
    }
    AppMethodBeat.o(246686);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.4
 * JD-Core Version:    0.7.0.1
 */