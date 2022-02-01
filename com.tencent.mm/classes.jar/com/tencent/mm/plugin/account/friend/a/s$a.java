package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.sdk.platformtools.bt;

public final class s$a
  extends l.d
  implements l.b
{
  public acr ikE;
  
  public s$a()
  {
    AppMethodBeat.i(131067);
    this.ikE = new acr();
    AppMethodBeat.o(131067);
  }
  
  public final int getFuncId()
  {
    return 481;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(131068);
    setRsaInfo(ac.eCa());
    this.ikE.CFU = new SKBuiltinBuffer_t().setBuffer(bt.eGG());
    this.ikE.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.ikE.toByteArray();
    AppMethodBeat.o(131068);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.a
 * JD-Core Version:    0.7.0.1
 */