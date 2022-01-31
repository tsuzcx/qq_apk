package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.bo;

public final class r$a
  extends l.d
  implements l.b
{
  public ze gxH;
  
  public r$a()
  {
    AppMethodBeat.i(108406);
    this.gxH = new ze();
    AppMethodBeat.o(108406);
  }
  
  public final int getFuncId()
  {
    return 481;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(108407);
    setRsaInfo(aa.dqG());
    this.gxH.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.gxH.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.gxH.toByteArray();
    AppMethodBeat.o(108407);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.r.a
 * JD-Core Version:    0.7.0.1
 */