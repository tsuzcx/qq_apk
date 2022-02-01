package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.sdk.platformtools.bs;

public final class v$a
  extends l.d
  implements l.b
{
  public bga iKQ;
  
  public v$a()
  {
    AppMethodBeat.i(131077);
    this.iKQ = new bga();
    AppMethodBeat.o(131077);
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
    AppMethodBeat.i(131078);
    setRsaInfo(ac.eRv());
    this.iKQ.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.iKQ.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.iKQ.toByteArray();
    AppMethodBeat.o(131078);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.v.a
 * JD-Core Version:    0.7.0.1
 */