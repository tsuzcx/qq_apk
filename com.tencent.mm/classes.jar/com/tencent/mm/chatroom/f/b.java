package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class b
  extends k.b
{
  private dir gsM;
  
  public b(String paramString1, String paramString2)
  {
    super(16);
    AppMethodBeat.i(12504);
    this.gsM = new dir();
    this.gsM.Lqk = new dqi().bhy(Util.nullAsNil(paramString1));
    this.gsM.KGR = new dqi().bhy(Util.nullAsNil(paramString2));
    this.zqv = this.gsM;
    AppMethodBeat.o(12504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.f.b
 * JD-Core Version:    0.7.0.1
 */