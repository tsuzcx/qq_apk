package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.Util;

public final class bk$a
  extends l.d
  implements l.b
{
  public bxm iDS;
  
  public bk$a()
  {
    AppMethodBeat.i(20361);
    this.iDS = new bxm();
    AppMethodBeat.o(20361);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 616;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20362);
    setRsaInfo(ac.gtR());
    this.iDS.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    this.iDS.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.iDS.toByteArray();
    AppMethodBeat.o(20362);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bk.a
 * JD-Core Version:    0.7.0.1
 */