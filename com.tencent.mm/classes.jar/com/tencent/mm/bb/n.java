package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.drm;

@Deprecated
public final class n
  extends k.b
{
  private drm iiz;
  
  public n(int paramInt)
  {
    super(30);
    AppMethodBeat.i(20568);
    this.iiz = new drm();
    this.iiz.OpCode = paramInt;
    this.vKm = this.iiz;
    AppMethodBeat.o(20568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.n
 * JD-Core Version:    0.7.0.1
 */