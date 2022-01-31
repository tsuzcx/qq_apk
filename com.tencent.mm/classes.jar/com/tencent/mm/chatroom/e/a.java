package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class a
  extends j.b
{
  private wm eeJ;
  
  public a(String paramString)
  {
    super(7);
    AppMethodBeat.i(103957);
    this.eeJ = new wm();
    this.eeJ.wOT = new bwc().aoF(bo.nullAsNil(paramString));
    this.oDZ = this.eeJ;
    AppMethodBeat.o(103957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */