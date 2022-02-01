package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Util;

public final class k$a
  extends l.d
  implements l.b
{
  public dvv wvD;
  
  public k$a()
  {
    AppMethodBeat.i(103595);
    this.wvD = new dvv();
    AppMethodBeat.o(103595);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 931;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(103596);
    setRsaInfo(ac.hph());
    this.wvD.RQU = new eae().dc(Util.getUuidRandom());
    this.wvD.setBaseRequest(l.a(this));
    setPassKey(this.wvD.RQU.Tkb.toByteArray());
    byte[] arrayOfByte = this.wvD.toByteArray();
    AppMethodBeat.o(103596);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.a
 * JD-Core Version:    0.7.0.1
 */