package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.platformtools.bo;

public final class s$a
  extends l.d
  implements l.b
{
  public apf gxJ;
  
  public s$a()
  {
    AppMethodBeat.i(108410);
    this.gxJ = new apf();
    AppMethodBeat.o(108410);
  }
  
  public final int getFuncId()
  {
    return 572;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(108411);
    setRsaInfo(aa.dqG());
    this.gxJ.wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
    this.gxJ.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.gxJ.toByteArray();
    AppMethodBeat.o(108411);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.a
 * JD-Core Version:    0.7.0.1
 */