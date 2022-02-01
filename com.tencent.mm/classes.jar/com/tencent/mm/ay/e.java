package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class e
  extends k.b
{
  private aig oPN;
  
  public e(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(20564);
    this.oPN = new aig();
    this.oPN.ZqL = new etl().btH(Util.nullAsNil(paramString));
    this.oPN.Njv = paramLong;
    this.KRu = this.oPN;
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.e
 * JD-Core Version:    0.7.0.1
 */