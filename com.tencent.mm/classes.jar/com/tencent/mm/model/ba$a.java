package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.bo;

public final class ba$a
  extends l.d
  implements l.b
{
  public ars fmk;
  
  public ba$a()
  {
    AppMethodBeat.i(16315);
    this.fmk = new ars();
    AppMethodBeat.o(16315);
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
    AppMethodBeat.i(16316);
    setRsaInfo(aa.dqE());
    this.fmk.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.fmk.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.fmk.toByteArray();
    AppMethodBeat.o(16316);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.ba.a
 * JD-Core Version:    0.7.0.1
 */