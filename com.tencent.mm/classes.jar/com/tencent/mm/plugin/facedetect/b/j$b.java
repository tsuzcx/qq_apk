package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;

public final class j$b
  extends l.e
  implements l.c
{
  public btd mgP;
  
  public j$b()
  {
    AppMethodBeat.i(72);
    this.mgP = new btd();
    AppMethodBeat.o(72);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73);
    this.mgP = ((btd)new btd().parseFrom(paramArrayOfByte));
    l.a(this, this.mgP.getBaseResponse());
    int i = this.mgP.getBaseResponse().Ret;
    AppMethodBeat.o(73);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j.b
 * JD-Core Version:    0.7.0.1
 */