package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class e
  extends k.b
{
  private afk jgi;
  
  public e(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(20564);
    this.jgi = new afk();
    this.jgi.Lqk = new dqi().bhy(Util.nullAsNil(paramString));
    this.jgi.Brn = paramLong;
    this.zqv = this.jgi;
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.e
 * JD-Core Version:    0.7.0.1
 */