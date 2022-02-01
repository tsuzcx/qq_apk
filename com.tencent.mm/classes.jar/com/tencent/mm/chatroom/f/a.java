package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class a
  extends k.b
{
  private bzn fLw;
  
  public a(String paramString, int paramInt)
  {
    super(20);
    AppMethodBeat.i(12503);
    this.fLw = new bzn();
    this.fLw.FuO = new cwt().aPy(bt.nullAsNil(paramString));
    this.fLw.nDG = paramInt;
    this.vKm = this.fLw;
    AppMethodBeat.o(12503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */