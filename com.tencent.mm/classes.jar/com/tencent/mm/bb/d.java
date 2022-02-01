package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class d
  extends k.b
{
  private acv iip;
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
    this.iip = new acv();
    this.iip.GbY = new cwt().aPy(bt.nullAsNil(paramString));
    this.iip.GbZ = paramInt;
    this.vKm = this.iip;
    AppMethodBeat.o(43053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.d
 * JD-Core Version:    0.7.0.1
 */