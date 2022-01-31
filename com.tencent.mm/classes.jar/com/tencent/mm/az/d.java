package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class d
  extends j.b
{
  private wu fLN;
  
  public d(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(16518);
    this.fLN = new wu();
    this.fLN.wOT = new bwc().aoF(bo.nullAsNil(paramString));
    this.fLN.pIG = paramLong;
    this.oDZ = this.fLN;
    AppMethodBeat.o(16518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.az.d
 * JD-Core Version:    0.7.0.1
 */