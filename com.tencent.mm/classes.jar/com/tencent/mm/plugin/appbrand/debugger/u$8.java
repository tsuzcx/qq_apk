package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctp;

final class u$8
  implements Runnable
{
  u$8(u paramu, int paramInt, ctp paramctp) {}
  
  public final void run()
  {
    AppMethodBeat.i(101923);
    u.a(this.hmM, "cmdId " + this.hmN + ", errCode " + this.hmO.csV);
    AppMethodBeat.o(101923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u.8
 * JD-Core Version:    0.7.0.1
 */