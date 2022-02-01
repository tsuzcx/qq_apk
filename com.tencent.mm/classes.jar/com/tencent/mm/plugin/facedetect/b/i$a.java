package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.sdk.platformtools.bs;

public final class i$a
  extends l.d
  implements l.b
{
  public atj qwj;
  
  public i$a()
  {
    AppMethodBeat.i(103591);
    this.qwj = new atj();
    AppMethodBeat.o(103591);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 733;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(103592);
    setRsaInfo(ac.eRt());
    this.qwj.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.qwj.setBaseRequest(l.a(this));
    setPassKey(this.qwj.DYu.getBuffer().toByteArray());
    byte[] arrayOfByte = this.qwj.toByteArray();
    AppMethodBeat.o(103592);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i.a
 * JD-Core Version:    0.7.0.1
 */