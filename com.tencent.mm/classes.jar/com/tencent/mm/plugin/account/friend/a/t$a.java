package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.sdk.platformtools.bo;

public final class t$a
  extends l.d
  implements l.b
{
  public aqh gxK;
  
  public t$a()
  {
    AppMethodBeat.i(108412);
    this.gxK = new aqh();
    AppMethodBeat.o(108412);
  }
  
  public final int getFuncId()
  {
    return 429;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(108413);
    setRsaInfo(aa.dqE());
    this.gxK.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.gxK.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.gxK.toByteArray();
    AppMethodBeat.o(108413);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.t.a
 * JD-Core Version:    0.7.0.1
 */