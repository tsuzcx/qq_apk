package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

@Deprecated
public final class f
  extends j.b
{
  private abf hPd;
  
  public f(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(20565);
    this.hPd = new abf();
    this.hPd.EuE = new crm().aJV(bs.nullAsNil(paramString));
    this.hPd.EuK.add(Integer.valueOf((int)paramLong));
    this.hPd.ncL = 1;
    this.uHj = this.hPd;
    AppMethodBeat.o(20565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.f
 * JD-Core Version:    0.7.0.1
 */