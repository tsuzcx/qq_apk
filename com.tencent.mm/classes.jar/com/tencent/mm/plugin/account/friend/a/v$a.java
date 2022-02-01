package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.sdk.platformtools.bu;

public final class v$a
  extends l.d
  implements l.b
{
  public bla jgS;
  
  public v$a()
  {
    AppMethodBeat.i(131077);
    this.jgS = new bla();
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
    setRsaInfo(ac.fkp());
    this.jgS.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.jgS.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.jgS.toByteArray();
    AppMethodBeat.o(131078);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.v.a
 * JD-Core Version:    0.7.0.1
 */