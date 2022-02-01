package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.sdk.platformtools.Util;

public final class v$a
  extends l.d
  implements l.b
{
  public bxj keW;
  
  public v$a()
  {
    AppMethodBeat.i(131077);
    this.keW = new bxj();
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
    setRsaInfo(ac.gtT());
    this.keW.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    this.keW.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.keW.toByteArray();
    AppMethodBeat.o(131078);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.v.a
 * JD-Core Version:    0.7.0.1
 */