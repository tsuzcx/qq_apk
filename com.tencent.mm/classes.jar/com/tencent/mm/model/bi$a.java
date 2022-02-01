package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.bu;

public final class bi$a
  extends l.d
  implements l.b
{
  public dwe hJm;
  
  public bi$a()
  {
    AppMethodBeat.i(20369);
    this.hJm = new dwe();
    AppMethodBeat.o(20369);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 617;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20370);
    setRsaInfo(ac.fkn());
    this.hJm.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.hJm.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hJm.toByteArray();
    AppMethodBeat.o(20370);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bi.a
 * JD-Core Version:    0.7.0.1
 */