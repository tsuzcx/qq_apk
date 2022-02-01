package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class r$a
  extends l.d
  implements l.b
{
  public ctb pSZ;
  
  public r$a()
  {
    AppMethodBeat.i(131073);
    this.pSZ = new ctb();
    AppMethodBeat.o(131073);
  }
  
  public final int getFuncId()
  {
    return 429;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131074);
    setRsaInfo(ac.iQc());
    this.pSZ.YOj = new gol().df(Util.getUuidRandom());
    this.pSZ.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.pSZ.toByteArray();
    AppMethodBeat.o(131074);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.r.a
 * JD-Core Version:    0.7.0.1
 */