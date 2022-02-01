package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class b
  extends j.b
{
  private bqh fpv;
  
  public b(String paramString, int paramInt)
  {
    super(20);
    AppMethodBeat.i(12503);
    this.fpv = new bqh();
    this.fpv.Cxe = new cmf().aEE(bt.nullAsNil(paramString));
    this.fpv.mBi = paramInt;
    this.tyM = this.fpv;
    AppMethodBeat.o(12503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.b
 * JD-Core Version:    0.7.0.1
 */