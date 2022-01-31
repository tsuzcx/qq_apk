package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.bo;

public final class k$a
  extends l.d
  implements l.b
{
  public cpv mgQ;
  
  public k$a()
  {
    AppMethodBeat.i(74);
    this.mgQ = new cpv();
    AppMethodBeat.o(74);
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
    AppMethodBeat.i(75);
    setRsaInfo(aa.dqE());
    this.mgQ.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.mgQ.setBaseRequest(l.a(this));
    setPassKey(this.mgQ.wvN.getBuffer().toByteArray());
    byte[] arrayOfByte = this.mgQ.toByteArray();
    AppMethodBeat.o(75);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.a
 * JD-Core Version:    0.7.0.1
 */