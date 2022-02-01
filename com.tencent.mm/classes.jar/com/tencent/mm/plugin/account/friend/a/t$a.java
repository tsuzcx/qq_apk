package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Util;

public final class t$a
  extends l.d
  implements l.b
{
  public bui keT;
  
  public t$a()
  {
    AppMethodBeat.i(131071);
    this.keT = new bui();
    AppMethodBeat.o(131071);
  }
  
  public final int getFuncId()
  {
    return 572;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131072);
    setRsaInfo(ac.gtT());
    this.keT.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    this.keT.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.keT.toByteArray();
    AppMethodBeat.o(131072);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.t.a
 * JD-Core Version:    0.7.0.1
 */