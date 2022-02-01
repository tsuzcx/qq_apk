package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Util;

public final class bl$a
  extends l.d
  implements l.b
{
  public cfg ltT;
  
  public bl$a()
  {
    AppMethodBeat.i(20361);
    this.ltT = new cfg();
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
    setRsaInfo(ac.hph());
    this.ltT.RQU = new eae().dc(Util.getUuidRandom());
    this.ltT.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.ltT.toByteArray();
    AppMethodBeat.o(20362);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bl.a
 * JD-Core Version:    0.7.0.1
 */