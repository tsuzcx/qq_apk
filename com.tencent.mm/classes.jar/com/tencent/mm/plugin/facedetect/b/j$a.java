package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.sdk.platformtools.bo;

public final class j$a
  extends l.d
  implements l.b
{
  public btc mgO;
  
  public j$a()
  {
    AppMethodBeat.i(70);
    this.mgO = new btc();
    AppMethodBeat.o(70);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 931;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(71);
    setRsaInfo(aa.dqE());
    this.mgO.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.mgO.setBaseRequest(l.a(this));
    setPassKey(this.mgO.wvN.getBuffer().toByteArray());
    byte[] arrayOfByte = this.mgO.toByteArray();
    AppMethodBeat.o(71);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j.a
 * JD-Core Version:    0.7.0.1
 */