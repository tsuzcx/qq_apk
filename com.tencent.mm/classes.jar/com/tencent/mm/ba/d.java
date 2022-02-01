package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.bs;

@Deprecated
public final class d
  extends j.b
{
  private aav hPb;
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
    this.hPb = new aav();
    this.hPb.EuE = new crm().aJV(bs.nullAsNil(paramString));
    this.hPb.EuF = paramInt;
    this.uHj = this.hPb;
    AppMethodBeat.o(43053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.d
 * JD-Core Version:    0.7.0.1
 */