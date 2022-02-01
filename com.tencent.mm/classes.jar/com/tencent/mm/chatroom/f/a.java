package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.bs;

@Deprecated
public final class a
  extends j.b
{
  private buy fsW;
  
  public a(String paramString, int paramInt)
  {
    super(20);
    AppMethodBeat.i(12503);
    this.fsW = new buy();
    this.fsW.DPA = new crm().aJV(bs.nullAsNil(paramString));
    this.fsW.ndj = paramInt;
    this.uHj = this.fsW;
    AppMethodBeat.o(12503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */