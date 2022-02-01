package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class c
  extends j.b
{
  private zw hoy;
  public String username;
  
  public c(String paramString)
  {
    this(paramString, 0);
    this.username = paramString;
  }
  
  public c(String paramString, int paramInt)
  {
    super(4);
    AppMethodBeat.i(43053);
    this.hoy = new zw();
    this.hoy.Dby = new cmf().aEE(bt.nullAsNil(paramString));
    this.hoy.Dbz = paramInt;
    this.tyM = this.hoy;
    AppMethodBeat.o(43053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.c
 * JD-Core Version:    0.7.0.1
 */