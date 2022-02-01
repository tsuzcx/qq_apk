package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;

@Deprecated
public final class a
  extends k.b
{
  private cah fNA;
  
  public a(String paramString, int paramInt)
  {
    super(20);
    AppMethodBeat.i(12503);
    this.fNA = new cah();
    this.fNA.FNm = new cxn().aQV(bu.nullAsNil(paramString));
    this.fNA.nJb = paramInt;
    this.vWq = this.fNA;
    AppMethodBeat.o(12503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */