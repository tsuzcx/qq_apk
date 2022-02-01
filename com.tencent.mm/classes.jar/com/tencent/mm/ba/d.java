package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;

@Deprecated
public final class d
  extends k.b
{
  private ade ili;
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
    this.ili = new ade();
    this.ili.GuF = new cxn().aQV(bu.nullAsNil(paramString));
    this.ili.GuG = paramInt;
    this.vWq = this.ili;
    AppMethodBeat.o(43053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.d
 * JD-Core Version:    0.7.0.1
 */