package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.sdk.platformtools.bo;

public final class bc$a
  extends l.d
  implements l.b
{
  public cqp fmo;
  
  public bc$a()
  {
    AppMethodBeat.i(16323);
    this.fmo = new cqp();
    AppMethodBeat.o(16323);
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
    AppMethodBeat.i(16324);
    setRsaInfo(aa.dqE());
    this.fmo.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.fmo.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.fmo.toByteArray();
    AppMethodBeat.o(16324);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bc.a
 * JD-Core Version:    0.7.0.1
 */