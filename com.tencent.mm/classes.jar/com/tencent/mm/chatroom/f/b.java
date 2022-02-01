package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;

@Deprecated
public final class b
  extends k.b
{
  private cqs fNB;
  
  public b(String paramString1, String paramString2)
  {
    super(16);
    AppMethodBeat.i(12504);
    this.fNB = new cqs();
    this.fNB.GuF = new cxn().aQV(bu.nullAsNil(paramString1));
    this.fNB.FNm = new cxn().aQV(bu.nullAsNil(paramString2));
    this.vWq = this.fNB;
    AppMethodBeat.o(12504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.b
 * JD-Core Version:    0.7.0.1
 */