package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.erp;

public final class c$b
  extends l.d
  implements l.b
{
  private int cmdId;
  private int funcId;
  private boolean needHeader;
  public a otI;
  
  public c$b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(132302);
    this.otI = parama;
    this.funcId = paramInt1;
    this.cmdId = paramInt2;
    this.needHeader = paramBoolean;
    setRouteInfo(paramInt3);
    AppMethodBeat.o(132302);
  }
  
  public final int getCmdId()
  {
    return this.cmdId;
  }
  
  public final int getFuncId()
  {
    return this.funcId;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(132303);
    if ((this.otI instanceof erp)) {
      ((erp)this.otI).setBaseRequest(l.a(this));
    }
    byte[] arrayOfByte = this.otI.toByteArray();
    AppMethodBeat.o(132303);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.c.b
 * JD-Core Version:    0.7.0.1
 */