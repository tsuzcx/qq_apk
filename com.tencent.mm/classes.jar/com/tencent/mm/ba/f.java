package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

@Deprecated
public final class f
  extends k.b
{
  private ado ilk;
  
  public f(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(20565);
    this.ilk = new ado();
    this.ilk.GuF = new cxn().aQV(bu.nullAsNil(paramString));
    this.ilk.GuL.add(Integer.valueOf((int)paramLong));
    this.ilk.nID = 1;
    this.vWq = this.ilk;
    AppMethodBeat.o(20565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.f
 * JD-Core Version:    0.7.0.1
 */