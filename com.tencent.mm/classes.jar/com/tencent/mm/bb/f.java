package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

@Deprecated
public final class f
  extends k.b
{
  private adf iir;
  
  public f(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(20565);
    this.iir = new adf();
    this.iir.GbY = new cwt().aPy(bt.nullAsNil(paramString));
    this.iir.Gce.add(Integer.valueOf((int)paramLong));
    this.iir.nDi = 1;
    this.vKm = this.iir;
    AppMethodBeat.o(20565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.f
 * JD-Core Version:    0.7.0.1
 */