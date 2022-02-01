package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.sdk.platformtools.bt;

public final class k$a
  extends l.d
  implements l.b
{
  public dum rgd;
  
  public k$a()
  {
    AppMethodBeat.i(103599);
    this.rgd = new dum();
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
    setRsaInfo(ac.fgx());
    this.rgd.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
    this.rgd.setBaseRequest(l.a(this));
    setPassKey(this.rgd.FDQ.getBuffer().toByteArray());
    byte[] arrayOfByte = this.rgd.toByteArray();
    AppMethodBeat.o(103600);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.a
 * JD-Core Version:    0.7.0.1
 */