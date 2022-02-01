package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.sdk.platformtools.bs;

public final class j$a
  extends l.d
  implements l.b
{
  public cnr qwl;
  
  public j$a()
  {
    AppMethodBeat.i(103595);
    this.qwl = new cnr();
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
    setRsaInfo(ac.eRt());
    this.qwl.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.qwl.setBaseRequest(l.a(this));
    setPassKey(this.qwl.DYu.getBuffer().toByteArray());
    byte[] arrayOfByte = this.qwl.toByteArray();
    AppMethodBeat.o(103596);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j.a
 * JD-Core Version:    0.7.0.1
 */