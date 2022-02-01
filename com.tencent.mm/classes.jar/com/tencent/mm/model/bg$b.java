package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ble;

public final class bg$b
  extends l.e
  implements l.c
{
  public ble hJj;
  
  public bg$b()
  {
    AppMethodBeat.i(20363);
    this.hJj = new ble();
    AppMethodBeat.o(20363);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20364);
    this.hJj = ((ble)new ble().parseFrom(paramArrayOfByte));
    l.a(this, this.hJj.getBaseResponse());
    int i = this.hJj.getBaseResponse().Ret;
    AppMethodBeat.o(20364);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bg.b
 * JD-Core Version:    0.7.0.1
 */