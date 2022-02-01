package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class c
  extends j.b
{
  private cfv fpw;
  
  public c(String paramString1, String paramString2)
  {
    super(16);
    AppMethodBeat.i(12504);
    this.fpw = new cfv();
    this.fpw.Dby = new cmf().aEE(bt.nullAsNil(paramString1));
    this.fpw.Cxe = new cmf().aEE(bt.nullAsNil(paramString2));
    this.tyM = this.fpw;
    AppMethodBeat.o(12504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.c
 * JD-Core Version:    0.7.0.1
 */