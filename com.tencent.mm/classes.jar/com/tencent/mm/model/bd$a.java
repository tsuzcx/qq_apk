package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.sdk.platformtools.bs;

public final class bd$a
  extends l.d
  implements l.b
{
  public bgd hnY;
  
  public bd$a()
  {
    AppMethodBeat.i(20361);
    this.hnY = new bgd();
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
    setRsaInfo(ac.eRt());
    this.hnY.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.hnY.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hnY.toByteArray();
    AppMethodBeat.o(20362);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bd.a
 * JD-Core Version:    0.7.0.1
 */