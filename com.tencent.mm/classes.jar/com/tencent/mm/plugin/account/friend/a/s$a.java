package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.sdk.platformtools.bu;

public final class s$a
  extends l.d
  implements l.b
{
  public agi jgN;
  
  public s$a()
  {
    AppMethodBeat.i(131067);
    this.jgN = new agi();
    AppMethodBeat.o(131067);
  }
  
  public final int getFuncId()
  {
    return 481;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131068);
    setRsaInfo(ac.fkp());
    this.jgN.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    this.jgN.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.jgN.toByteArray();
    AppMethodBeat.o(131068);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.a
 * JD-Core Version:    0.7.0.1
 */