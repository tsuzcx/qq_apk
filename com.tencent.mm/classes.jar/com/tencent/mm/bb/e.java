package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class e
  extends k.b
{
  private acy iiq;
  
  public e(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(20564);
    this.iiq = new acy();
    this.iiq.GbY = new cwt().aPy(bt.nullAsNil(paramString));
    this.iiq.xbt = paramLong;
    this.vKm = this.iiq;
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.e
 * JD-Core Version:    0.7.0.1
 */