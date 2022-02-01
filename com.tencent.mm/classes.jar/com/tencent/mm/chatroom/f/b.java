package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.ele;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class b
  extends k.b
{
  private ele lzb;
  
  public b(String paramString1, String paramString2)
  {
    super(16);
    AppMethodBeat.i(12504);
    this.lzb = new ele();
    this.lzb.ZqL = new etl().btH(Util.nullAsNil(paramString1));
    this.lzb.YFn = new etl().btH(Util.nullAsNil(paramString2));
    this.KRu = this.lzb;
    AppMethodBeat.o(12504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.b
 * JD-Core Version:    0.7.0.1
 */