package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

@Deprecated
public final class e
  extends j.b
{
  private aag hoA;
  
  public e(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(20565);
    this.hoA = new aag();
    this.hoA.Dby = new cmf().aEE(bt.nullAsNil(paramString));
    this.hoA.DbE.add(Integer.valueOf((int)paramLong));
    this.hoA.mAK = 1;
    this.tyM = this.hoA;
    AppMethodBeat.o(20565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.e
 * JD-Core Version:    0.7.0.1
 */