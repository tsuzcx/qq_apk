package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.sdk.platformtools.bu;

public final class t$a
  extends l.d
  implements l.b
{
  public bii jgP;
  
  public t$a()
  {
    AppMethodBeat.i(131071);
    this.jgP = new bii();
    AppMethodBeat.o(131071);
  }
  
  public final int getFuncId()
  {
    return 572;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131072);
    setRsaInfo(ac.fkp());
    this.jgP.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.jgP.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.jgP.toByteArray();
    AppMethodBeat.o(131072);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.t.a
 * JD-Core Version:    0.7.0.1
 */