package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.u;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.k;
import java.nio.ByteBuffer;

final class w$1
  extends u
{
  w$1(w paramw) {}
  
  public final int Cv()
  {
    AppMethodBeat.i(86779);
    if (this.gRR.gRO != null)
    {
      int i = this.gRR.gRO.getNativeBufferId();
      AppMethodBeat.o(86779);
      return i;
    }
    AppMethodBeat.o(86779);
    return 0;
  }
  
  public final void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(86781);
    if (this.gRR.gRO != null) {
      this.gRR.gRO.setNativeBuffer(paramInt, paramByteBuffer);
    }
    AppMethodBeat.o(86781);
  }
  
  public final ByteBuffer gk(int paramInt)
  {
    AppMethodBeat.i(86780);
    if (this.gRR.gRO != null)
    {
      ByteBuffer localByteBuffer = this.gRR.gRO.getNativeBuffer(paramInt);
      AppMethodBeat.o(86780);
      return localByteBuffer;
    }
    AppMethodBeat.o(86780);
    return null;
  }
  
  public final void l(int paramInt, String paramString)
  {
    AppMethodBeat.i(86782);
    this.gRR.gPA.aAO().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString }), null);
    AppMethodBeat.o(86782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.1
 * JD-Core Version:    0.7.0.1
 */