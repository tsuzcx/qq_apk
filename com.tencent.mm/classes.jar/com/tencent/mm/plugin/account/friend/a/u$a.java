package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.sdk.platformtools.bo;

public final class u$a
  extends l.d
  implements l.b
{
  public arp gxM;
  
  public u$a()
  {
    AppMethodBeat.i(108416);
    this.gxM = new arp();
    AppMethodBeat.o(108416);
  }
  
  public final int getCmdId()
  {
    return 48;
  }
  
  public final int getFuncId()
  {
    return 107;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(108417);
    setRsaInfo(aa.dqG());
    this.gxM.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.gxM.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.gxM.toByteArray();
    AppMethodBeat.o(108417);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.u.a
 * JD-Core Version:    0.7.0.1
 */