package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class q$a
  extends l.d
  implements l.b
{
  public crj pSY;
  
  public q$a()
  {
    AppMethodBeat.i(131071);
    this.pSY = new crj();
    AppMethodBeat.o(131071);
  }
  
  public final int getFuncId()
  {
    return 572;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131072);
    setRsaInfo(ac.iQe());
    this.pSY.YOj = new gol().df(Util.getUuidRandom());
    this.pSY.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.pSY.toByteArray();
    AppMethodBeat.o(131072);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.q.a
 * JD-Core Version:    0.7.0.1
 */