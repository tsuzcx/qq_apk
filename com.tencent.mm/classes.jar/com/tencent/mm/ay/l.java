package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

@Deprecated
public final class l
  extends k.b
{
  private dqk oPU;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(43058);
    this.oPU = new dqk();
    this.oPU.aaWL = 2048;
    this.oPU.ZqL = new etl().btH(Util.nullAsNil(paramString1));
    this.oPU.aaIz = new etl().btH(Util.nullAsNil(paramString2));
    this.oPU.YBU = 0;
    this.oPU.aaWM = new etl().btH(Util.nullAsNil(paramString3));
    this.oPU.aaWN = new etl().btH(Util.nullAsNil(paramString4));
    this.oPU.vhk = 0;
    paramString2 = y.bi(Util.nullAsNil(paramString5), 0, -1);
    paramString3 = this.oPU;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.aaWJ = new b(paramString1);
      paramString1 = this.oPU;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.aaWI = i;
      this.oPU.pSf = 0;
      this.oPU.pSj = 0;
      this.oPU.pSi = Util.nullAsNil(paramString6);
      this.oPU.pSh = Util.nullAsNil(paramString7);
      this.oPU.pSg = Util.nullAsNil(paramString8);
      this.oPU.YBX = paramInt;
      this.oPU.aaMo = Util.nullAsNil(paramString9);
      this.oPU.aaWS = 0;
      this.oPU.pSk = Util.nullAsNil(paramString10);
      this.oPU.aaMq = 0;
      this.oPU.aaMp = "";
      this.KRu = this.oPU;
      AppMethodBeat.o(43058);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.l
 * JD-Core Version:    0.7.0.1
 */