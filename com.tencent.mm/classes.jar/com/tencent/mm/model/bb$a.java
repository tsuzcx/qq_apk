package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.sdk.platformtools.bo;

public final class bb$a
  extends l.d
  implements l.b
{
  public arw fmm;
  
  public bb$a()
  {
    AppMethodBeat.i(16319);
    this.fmm = new arw();
    AppMethodBeat.o(16319);
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
    AppMethodBeat.i(16320);
    setRsaInfo(aa.dqE());
    this.fmm.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.fmm.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.fmm.toByteArray();
    AppMethodBeat.o(16320);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bb.a
 * JD-Core Version:    0.7.0.1
 */