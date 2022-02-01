package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.bs;

@Deprecated
public final class b
  extends j.b
{
  private cky fsX;
  
  public b(String paramString1, String paramString2)
  {
    super(16);
    AppMethodBeat.i(12504);
    this.fsX = new cky();
    this.fsX.EuE = new crm().aJV(bs.nullAsNil(paramString1));
    this.fsX.DPA = new crm().aJV(bs.nullAsNil(paramString2));
    this.uHj = this.fsX;
    AppMethodBeat.o(12504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.b
 * JD-Core Version:    0.7.0.1
 */