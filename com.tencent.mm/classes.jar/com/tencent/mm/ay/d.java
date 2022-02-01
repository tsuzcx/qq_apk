package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class d
  extends k.b
{
  private aid oPM;
  public String username;
  
  public d(String paramString)
  {
    this(paramString, (byte)0);
    this.username = paramString;
  }
  
  private d(String paramString, byte paramByte)
  {
    super(4);
    AppMethodBeat.i(231256);
    this.oPM = new aid();
    this.oPM.ZqL = new etl().btH(Util.nullAsNil(paramString));
    this.oPM.ZqM = 0;
    this.KRu = this.oPM;
    AppMethodBeat.o(231256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.d
 * JD-Core Version:    0.7.0.1
 */