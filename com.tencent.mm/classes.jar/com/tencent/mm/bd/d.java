package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class d
  extends k.b
{
  private afq lWK;
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
    this.lWK = new afq();
    this.lWK.SrH = new eaf().btQ(Util.nullAsNil(paramString));
    this.lWK.SrI = paramInt;
    this.EVU = this.lWK;
    AppMethodBeat.o(43053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.d
 * JD-Core Version:    0.7.0.1
 */