package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class b
  extends k.b
{
  private cpy fLx;
  
  public b(String paramString1, String paramString2)
  {
    super(16);
    AppMethodBeat.i(12504);
    this.fLx = new cpy();
    this.fLx.GbY = new cwt().aPy(bt.nullAsNil(paramString1));
    this.fLx.FuO = new cwt().aPy(bt.nullAsNil(paramString2));
    this.vKm = this.fLx;
    AppMethodBeat.o(12504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.b
 * JD-Core Version:    0.7.0.1
 */