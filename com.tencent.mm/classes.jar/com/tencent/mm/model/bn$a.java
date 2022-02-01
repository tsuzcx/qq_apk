package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class bn$a
  extends l.d
  implements l.b
{
  public cvn olu;
  
  public bn$a()
  {
    AppMethodBeat.i(20365);
    this.olu = new cvn();
    AppMethodBeat.o(20365);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 618;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20366);
    setRsaInfo(ac.iQc());
    this.olu.YOj = new gol().df(Util.getUuidRandom());
    this.olu.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.olu.toByteArray();
    AppMethodBeat.o(20366);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bn.a
 * JD-Core Version:    0.7.0.1
 */