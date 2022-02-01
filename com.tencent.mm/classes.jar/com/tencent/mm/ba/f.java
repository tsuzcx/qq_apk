package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

@Deprecated
public final class f
  extends k.b
{
  private afr jgj;
  
  public f(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(20565);
    this.jgj = new afr();
    this.jgj.Lqk = new dqi().bhy(Util.nullAsNil(paramString));
    this.jgj.Lqq.add(Integer.valueOf((int)paramLong));
    this.jgj.oTz = 1;
    this.zqv = this.jgj;
    AppMethodBeat.o(20565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.f
 * JD-Core Version:    0.7.0.1
 */