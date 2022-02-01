package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.bs;

@Deprecated
public final class e
  extends j.b
{
  private aay hPc;
  
  public e(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(20564);
    this.hPc = new aay();
    this.hPc.EuE = new crm().aJV(bs.nullAsNil(paramString));
    this.hPc.vTQ = paramLong;
    this.uHj = this.hPc;
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.e
 * JD-Core Version:    0.7.0.1
 */