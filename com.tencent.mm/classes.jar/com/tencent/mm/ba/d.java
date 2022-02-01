package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class d
  extends k.b
{
  private afh jgh;
  public String username;
  
  public d(String paramString)
  {
    this(paramString, 0);
    this.username = paramString;
  }
  
  public d(String paramString, int paramInt)
  {
    super(4);
    AppMethodBeat.i(43053);
    this.jgh = new afh();
    this.jgh.Lqk = new dqi().bhy(Util.nullAsNil(paramString));
    this.jgh.Lql = paramInt;
    this.zqv = this.jgh;
    AppMethodBeat.o(43053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.d
 * JD-Core Version:    0.7.0.1
 */