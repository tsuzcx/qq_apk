package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.sdk.platformtools.bs;

public final class bf$a
  extends l.d
  implements l.b
{
  public dpq hoc;
  
  public bf$a()
  {
    AppMethodBeat.i(20369);
    this.hoc = new dpq();
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
    setRsaInfo(ac.eRt());
    this.hoc.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.hoc.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hoc.toByteArray();
    AppMethodBeat.o(20370);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bf.a
 * JD-Core Version:    0.7.0.1
 */