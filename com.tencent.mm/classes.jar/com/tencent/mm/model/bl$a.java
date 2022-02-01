package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Util;

public final class bl$a
  extends l.d
  implements l.b
{
  public bxq iDU;
  
  public bl$a()
  {
    AppMethodBeat.i(20365);
    this.iDU = new bxq();
    AppMethodBeat.o(20365);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 618;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20366);
    setRsaInfo(ac.gtR());
    this.iDU.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    this.iDU.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.iDU.toByteArray();
    AppMethodBeat.o(20366);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bl.a
 * JD-Core Version:    0.7.0.1
 */