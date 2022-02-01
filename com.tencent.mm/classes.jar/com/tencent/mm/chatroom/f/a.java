package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class a
  extends k.b
{
  private dpf lza;
  
  public a(String paramString, int paramInt)
  {
    super(20);
    AppMethodBeat.i(12503);
    this.lza = new dpf();
    this.lza.YFn = new etl().btH(Util.nullAsNil(paramString));
    this.lza.vhk = paramInt;
    this.KRu = this.lza;
    AppMethodBeat.o(12503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */