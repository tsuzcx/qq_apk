package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.sdk.platformtools.Util;

public final class bn$a
  extends l.d
  implements l.b
{
  public fau ltX;
  
  public bn$a()
  {
    AppMethodBeat.i(20369);
    this.ltX = new fau();
    AppMethodBeat.o(20369);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 617;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20370);
    setRsaInfo(ac.hph());
    this.ltX.RQU = new eae().dc(Util.getUuidRandom());
    this.ltX.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.ltX.toByteArray();
    AppMethodBeat.o(20370);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bn.a
 * JD-Core Version:    0.7.0.1
 */