package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class e
  extends k.b
{
  private aft lWL;
  
  public e(String paramString, long paramLong)
  {
    super(8);
    AppMethodBeat.i(20564);
    this.lWL = new aft();
    this.lWL.SrH = new eaf().btQ(Util.nullAsNil(paramString));
    this.lWL.HlH = paramLong;
    this.EVU = this.lWL;
    AppMethodBeat.o(20564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.e
 * JD-Core Version:    0.7.0.1
 */