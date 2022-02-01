package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.protocal.protobuf.kd;

public final class c$c
  extends l.e
  implements l.c
{
  private int cmdId;
  private boolean needHeader;
  private a otI = null;
  
  public c$c(a parama, int paramInt, boolean paramBoolean)
  {
    this.otI = parama;
    this.cmdId = paramInt;
    this.needHeader = paramBoolean;
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132304);
    this.otI = this.otI.parseFrom(paramArrayOfByte);
    if (!(this.otI instanceof fcu))
    {
      l.a(this, ((esc)this.otI).getBaseResponse());
      i = ((esc)this.otI).getBaseResponse().Idd;
      AppMethodBeat.o(132304);
      return i;
    }
    int i = ((fcu)this.otI).getRet();
    AppMethodBeat.o(132304);
    return i;
  }
  
  public final int getCmdId()
  {
    return this.cmdId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.c.c
 * JD-Core Version:    0.7.0.1
 */