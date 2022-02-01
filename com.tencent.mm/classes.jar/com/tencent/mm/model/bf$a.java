package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.sdk.platformtools.bt;

public final class bf$a
  extends l.d
  implements l.b
{
  public bkp hGs;
  
  public bf$a()
  {
    AppMethodBeat.i(20365);
    this.hGs = new bkp();
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
    setRsaInfo(ac.fgx());
    this.hGs.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
    this.hGs.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.hGs.toByteArray();
    AppMethodBeat.o(20366);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bf.a
 * JD-Core Version:    0.7.0.1
 */