package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class a
  extends j.b
{
  private zr fpu;
  
  public a(String paramString)
  {
    super(7);
    AppMethodBeat.i(12502);
    this.fpu = new zr();
    this.fpu.Dby = new cmf().aEE(bt.nullAsNil(paramString));
    this.tyM = this.fpu;
    AppMethodBeat.o(12502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */