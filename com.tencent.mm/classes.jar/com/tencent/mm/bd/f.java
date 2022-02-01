package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

@Deprecated
public final class f
  extends k.b
{
  private aga lWM;
  
  public f(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(20565);
    this.lWM = new aga();
    this.lWM.SrH = new eaf().btQ(Util.nullAsNil(paramString));
    this.lWM.SrN.add(Integer.valueOf((int)paramLong));
    this.lWM.rVx = 1;
    this.EVU = this.lWM;
    AppMethodBeat.o(20565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.f
 * JD-Core Version:    0.7.0.1
 */