package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class c
  extends j.b
{
  private wr fLM;
  public String username;
  
  public c(String paramString)
  {
    this(paramString, 0);
    this.username = paramString;
  }
  
  public c(String paramString, int paramInt)
  {
    super(4);
    AppMethodBeat.i(988);
    this.fLM = new wr();
    this.fLM.wOT = new bwc().aoF(bo.nullAsNil(paramString));
    this.fLM.wOU = paramInt;
    this.oDZ = this.fLM;
    AppMethodBeat.o(988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.az.c
 * JD-Core Version:    0.7.0.1
 */