package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.bs;

public final class be$a
  extends l.d
  implements l.b
{
  public bgh hoa;
  
  public be$a()
  {
    AppMethodBeat.i(20365);
    this.hoa = new bgh();
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
    setRsaInfo(ac.eRt());
    this.hoa.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.hoa.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hoa.toByteArray();
    AppMethodBeat.o(20366);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.be.a
 * JD-Core Version:    0.7.0.1
 */