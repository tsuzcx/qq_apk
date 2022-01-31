package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class c
  extends j.b
{
  private bqw eeL;
  
  public c(String paramString1, String paramString2)
  {
    super(16);
    AppMethodBeat.i(103959);
    this.eeL = new bqw();
    this.eeL.wOT = new bwc().aoF(bo.nullAsNil(paramString1));
    this.eeL.wow = new bwc().aoF(bo.nullAsNil(paramString2));
    this.oDZ = this.eeL;
    AppMethodBeat.o(103959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.c
 * JD-Core Version:    0.7.0.1
 */