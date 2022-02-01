package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.fwa;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Util;

public final class l$a
  extends l.d
  implements l.b
{
  public fwa zRK;
  
  public l$a()
  {
    AppMethodBeat.i(103599);
    this.zRK = new fwa();
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
    setRsaInfo(ac.iQc());
    this.zRK.YOj = new gol().df(Util.getUuidRandom());
    this.zRK.setBaseRequest(l.a(this));
    setPassKey(this.zRK.YOj.aaxD.toByteArray());
    byte[] arrayOfByte = this.zRK.toByteArray();
    AppMethodBeat.o(103600);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l.a
 * JD-Core Version:    0.7.0.1
 */