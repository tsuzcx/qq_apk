package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class d
  extends j.b
{
  private zz hoz;
  
  public d(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(20564);
    this.hoz = new zz();
    this.hoz.Dby = new cmf().aEE(bt.nullAsNil(paramString));
    this.hoz.uKZ = paramLong;
    this.tyM = this.hoz;
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.d
 * JD-Core Version:    0.7.0.1
 */