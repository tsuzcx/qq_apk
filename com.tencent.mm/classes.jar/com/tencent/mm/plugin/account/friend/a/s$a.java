package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.sdk.platformtools.Util;

public final class s$a
  extends l.d
  implements l.b
{
  public air keR;
  
  public s$a()
  {
    AppMethodBeat.i(131067);
    this.keR = new air();
    AppMethodBeat.o(131067);
  }
  
  public final int getFuncId()
  {
    return 481;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131068);
    setRsaInfo(ac.gtT());
    this.keR.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    this.keR.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.keR.toByteArray();
    AppMethodBeat.o(131068);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.a
 * JD-Core Version:    0.7.0.1
 */