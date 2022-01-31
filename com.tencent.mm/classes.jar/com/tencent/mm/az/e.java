package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

@Deprecated
public final class e
  extends j.b
{
  private xb fLO;
  
  public e(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(16519);
    this.fLO = new xb();
    this.fLO.wOT = new bwc().aoF(bo.nullAsNil(paramString));
    this.fLO.wOZ.add(Integer.valueOf((int)paramLong));
    this.fLO.jJu = 1;
    this.oDZ = this.fLO;
    AppMethodBeat.o(16519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.az.e
 * JD-Core Version:    0.7.0.1
 */