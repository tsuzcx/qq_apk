package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.sdk.platformtools.bs;

public final class u$a
  extends l.d
  implements l.b
{
  public beo iKO;
  
  public u$a()
  {
    AppMethodBeat.i(131073);
    this.iKO = new beo();
    AppMethodBeat.o(131073);
  }
  
  public final int getFuncId()
  {
    return 429;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131074);
    setRsaInfo(ac.eRt());
    this.iKO.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.iKO.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.iKO.toByteArray();
    AppMethodBeat.o(131074);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.u.a
 * JD-Core Version:    0.7.0.1
 */