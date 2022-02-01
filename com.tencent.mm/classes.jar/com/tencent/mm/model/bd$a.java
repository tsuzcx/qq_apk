package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.bt;

public final class bd$a
  extends l.d
  implements l.b
{
  public bcl gNy;
  
  public bd$a()
  {
    AppMethodBeat.i(20361);
    this.gNy = new bcl();
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
    setRsaInfo(ac.eBY());
    this.gNy.CFU = new SKBuiltinBuffer_t().setBuffer(bt.eGG());
    this.gNy.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.gNy.toByteArray();
    AppMethodBeat.o(20362);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bd.a
 * JD-Core Version:    0.7.0.1
 */