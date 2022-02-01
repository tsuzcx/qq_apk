package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.sdk.platformtools.bu;

public final class bg$a
  extends l.d
  implements l.b
{
  public bld hJi;
  
  public bg$a()
  {
    AppMethodBeat.i(20361);
    this.hJi = new bld();
    AppMethodBeat.o(20361);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 616;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20362);
    setRsaInfo(ac.fkn());
    this.hJi.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.hJi.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hJi.toByteArray();
    AppMethodBeat.o(20362);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bg.a
 * JD-Core Version:    0.7.0.1
 */