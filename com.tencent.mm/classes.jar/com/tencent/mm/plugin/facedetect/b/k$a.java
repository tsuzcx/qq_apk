package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.sdk.platformtools.bu;

public final class k$a
  extends l.d
  implements l.b
{
  public dvj rog;
  
  public k$a()
  {
    AppMethodBeat.i(103599);
    this.rog = new dvj();
    AppMethodBeat.o(103599);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 930;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(103600);
    setRsaInfo(ac.fkn());
    this.rog.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.rog.setBaseRequest(l.a(this));
    setPassKey(this.rog.FWl.getBuffer().toByteArray());
    byte[] arrayOfByte = this.rog.toByteArray();
    AppMethodBeat.o(103600);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.a
 * JD-Core Version:    0.7.0.1
 */