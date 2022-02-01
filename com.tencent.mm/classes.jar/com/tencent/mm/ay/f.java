package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

@Deprecated
public final class f
  extends k.b
{
  private ain oPO;
  
  public f(String paramString, long paramLong)
  {
    super(9);
    AppMethodBeat.i(20565);
    this.oPO = new ain();
    this.oPO.ZqL = new etl().btH(Util.nullAsNil(paramString));
    this.oPO.ZqR.add(Integer.valueOf((int)paramLong));
    this.oPO.vgN = 1;
    this.KRu = this.oPO;
    AppMethodBeat.o(20565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ay.f
 * JD-Core Version:    0.7.0.1
 */