package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adq;
import com.tencent.mm.sdk.platformtools.bs;

public final class s$a
  extends l.d
  implements l.b
{
  public adq iKL;
  
  public s$a()
  {
    AppMethodBeat.i(131067);
    this.iKL = new adq();
    AppMethodBeat.o(131067);
  }
  
  public final int getFuncId()
  {
    return 481;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131068);
    setRsaInfo(ac.eRv());
    this.iKL.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    this.iKL.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.iKL.toByteArray();
    AppMethodBeat.o(131068);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.a
 * JD-Core Version:    0.7.0.1
 */