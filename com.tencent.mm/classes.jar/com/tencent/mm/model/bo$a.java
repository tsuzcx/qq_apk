package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.fxa;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class bo$a
  extends l.d
  implements l.b
{
  public fxa olw;
  
  public bo$a()
  {
    AppMethodBeat.i(20369);
    this.olw = new fxa();
    AppMethodBeat.o(20369);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 617;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20370);
    setRsaInfo(ac.iQc());
    this.olw.YOj = new gol().df(Util.getUuidRandom());
    this.olw.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.olw.toByteArray();
    AppMethodBeat.o(20370);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bo.a
 * JD-Core Version:    0.7.0.1
 */