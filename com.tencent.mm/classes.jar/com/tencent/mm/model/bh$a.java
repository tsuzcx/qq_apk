package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.sdk.platformtools.bu;

public final class bh$a
  extends l.d
  implements l.b
{
  public blh hJk;
  
  public bh$a()
  {
    AppMethodBeat.i(20365);
    this.hJk = new blh();
    AppMethodBeat.o(20365);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 618;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20366);
    setRsaInfo(ac.fkn());
    this.hJk.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.hJk.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hJk.toByteArray();
    AppMethodBeat.o(20366);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bh.a
 * JD-Core Version:    0.7.0.1
 */