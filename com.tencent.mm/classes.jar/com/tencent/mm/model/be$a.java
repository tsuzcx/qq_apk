package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.sdk.platformtools.bt;

public final class be$a
  extends l.d
  implements l.b
{
  public bkl hGq;
  
  public be$a()
  {
    AppMethodBeat.i(20361);
    this.hGq = new bkl();
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
    setRsaInfo(ac.fgx());
    this.hGq.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
    this.hGq.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hGq.toByteArray();
    AppMethodBeat.o(20362);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.be.a
 * JD-Core Version:    0.7.0.1
 */