package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.sdk.platformtools.bt;

public final class j$a
  extends l.d
  implements l.b
{
  public cil pND;
  
  public j$a()
  {
    AppMethodBeat.i(103595);
    this.pND = new cil();
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
    setRsaInfo(ac.eBY());
    this.pND.CFU = new SKBuiltinBuffer_t().setBuffer(bt.eGG());
    this.pND.setBaseRequest(l.a(this));
    setPassKey(this.pND.CFU.getBuffer().toByteArray());
    byte[] arrayOfByte = this.pND.toByteArray();
    AppMethodBeat.o(103596);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j.a
 * JD-Core Version:    0.7.0.1
 */