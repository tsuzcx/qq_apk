package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.sdk.platformtools.bu;

public final class j$a
  extends l.d
  implements l.b
{
  public cto roe;
  
  public j$a()
  {
    AppMethodBeat.i(103595);
    this.roe = new cto();
    AppMethodBeat.o(103595);
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
    AppMethodBeat.i(103596);
    setRsaInfo(ac.fkn());
    this.roe.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.roe.setBaseRequest(l.a(this));
    setPassKey(this.roe.FWl.getBuffer().toByteArray());
    byte[] arrayOfByte = this.roe.toByteArray();
    AppMethodBeat.o(103596);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j.a
 * JD-Core Version:    0.7.0.1
 */