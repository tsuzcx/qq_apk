package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.sdk.platformtools.Util;

public final class k$a
  extends l.d
  implements l.b
{
  public epl sPL;
  
  public k$a()
  {
    AppMethodBeat.i(103599);
    this.sPL = new epl();
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
    setRsaInfo(ac.gtR());
    this.sPL.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    this.sPL.setBaseRequest(l.a(this));
    setPassKey(this.sPL.KPW.getBuffer().toByteArray());
    byte[] arrayOfByte = this.sPL.toByteArray();
    AppMethodBeat.o(103600);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.a
 * JD-Core Version:    0.7.0.1
 */