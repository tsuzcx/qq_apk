package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bjp;

public final class b$c
  extends l.e
  implements l.c
{
  public bjp fLL;
  
  public b$c()
  {
    AppMethodBeat.i(59989);
    this.fLL = new bjp();
    AppMethodBeat.o(59989);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59990);
    this.fLL = ((bjp)new bjp().parseFrom(paramArrayOfByte));
    int i = this.fLL.Ret;
    AppMethodBeat.o(59990);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.b.c
 * JD-Core Version:    0.7.0.1
 */