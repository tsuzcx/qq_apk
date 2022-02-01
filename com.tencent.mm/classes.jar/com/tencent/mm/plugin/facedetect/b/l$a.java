package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ezw;
import com.tencent.mm.sdk.platformtools.Util;

public final class l$a
  extends l.d
  implements l.b
{
  public ezw wvF;
  
  public l$a()
  {
    AppMethodBeat.i(103599);
    this.wvF = new ezw();
    AppMethodBeat.o(103599);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 930;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(103600);
    setRsaInfo(ac.hph());
    this.wvF.RQU = new eae().dc(Util.getUuidRandom());
    this.wvF.setBaseRequest(l.a(this));
    setPassKey(this.wvF.RQU.Tkb.toByteArray());
    byte[] arrayOfByte = this.wvF.toByteArray();
    AppMethodBeat.o(103600);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l.a
 * JD-Core Version:    0.7.0.1
 */