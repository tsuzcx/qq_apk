package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import java.nio.ByteBuffer;

final class w$1
  extends com.tencent.mm.appbrand.v8.w
{
  w$1(w paramw) {}
  
  public final int NE()
  {
    AppMethodBeat.i(134606);
    if (this.jAL.jAI != null)
    {
      int i = this.jAL.jAI.getNativeBufferId();
      AppMethodBeat.o(134606);
      return i;
    }
    AppMethodBeat.o(134606);
    return 0;
  }
  
  public final void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(134610);
    if (this.jAL.jAI != null) {
      this.jAL.jAI.bufferStoreBindTo(paramLong1, paramLong2);
    }
    AppMethodBeat.o(134610);
  }
  
  public final ByteBuffer getBuffer(int paramInt)
  {
    AppMethodBeat.i(134607);
    if (this.jAL.jAI != null)
    {
      ByteBuffer localByteBuffer = this.jAL.jAI.ak(paramInt, false);
      AppMethodBeat.o(134607);
      return localByteBuffer;
    }
    AppMethodBeat.o(134607);
    return null;
  }
  
  public final void n(int paramInt, String paramString)
  {
    AppMethodBeat.i(134611);
    this.jAL.jwH.aYh().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString }), null);
    AppMethodBeat.o(134611);
  }
  
  public final void setBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(134608);
    if (this.jAL.jAI != null) {
      this.jAL.jAI.setNativeBuffer(paramInt, paramByteBuffer);
    }
    AppMethodBeat.o(134608);
  }
  
  public final boolean supportBufferStoreBindTo()
  {
    AppMethodBeat.i(134609);
    if (this.jAL.jAI != null)
    {
      boolean bool = this.jAL.jAI.supportBufferStoreBindTo();
      AppMethodBeat.o(134609);
      return bool;
    }
    AppMethodBeat.o(134609);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.1
 * JD-Core Version:    0.7.0.1
 */