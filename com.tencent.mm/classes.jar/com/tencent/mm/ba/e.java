package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;

@Deprecated
public final class e
  extends k.b
{
  private adh ilj;
  
  public e(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(20564);
    this.ilj = new adh();
    this.ilj.GuF = new cxn().aQV(bu.nullAsNil(paramString));
    this.ilj.xrk = paramLong;
    this.vWq = this.ilj;
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.e
 * JD-Core Version:    0.7.0.1
 */