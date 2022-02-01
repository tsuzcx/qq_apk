package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Util;

public final class bm$a
  extends l.d
  implements l.b
{
  public cfk ltV;
  
  public bm$a()
  {
    AppMethodBeat.i(20365);
    this.ltV = new cfk();
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
    setRsaInfo(ac.hph());
    this.ltV.RQU = new eae().dc(Util.getUuidRandom());
    this.ltV.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.ltV.toByteArray();
    AppMethodBeat.o(20366);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bm.a
 * JD-Core Version:    0.7.0.1
 */