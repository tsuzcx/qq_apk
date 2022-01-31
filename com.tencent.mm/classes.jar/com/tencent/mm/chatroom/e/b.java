package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class b
  extends j.b
{
  private bdr eeK;
  
  public b(String paramString, int paramInt)
  {
    super(20);
    AppMethodBeat.i(103958);
    this.eeK = new bdr();
    this.eeK.wow = new bwc().aoF(bo.nullAsNil(paramString));
    this.eeK.jJS = paramInt;
    this.oDZ = this.eeK;
    AppMethodBeat.o(103958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */