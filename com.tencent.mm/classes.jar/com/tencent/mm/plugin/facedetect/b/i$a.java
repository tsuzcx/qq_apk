package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.sdk.platformtools.bo;

public final class i$a
  extends l.d
  implements l.b
{
  public agy mgM;
  
  public i$a()
  {
    AppMethodBeat.i(66);
    this.mgM = new agy();
    AppMethodBeat.o(66);
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
    AppMethodBeat.i(67);
    setRsaInfo(aa.dqE());
    this.mgM.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.mgM.setBaseRequest(l.a(this));
    setPassKey(this.mgM.wvN.getBuffer().toByteArray());
    byte[] arrayOfByte = this.mgM.toByteArray();
    AppMethodBeat.o(67);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i.a
 * JD-Core Version:    0.7.0.1
 */