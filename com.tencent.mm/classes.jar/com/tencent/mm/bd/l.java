package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

@Deprecated
public final class l
  extends k.b
{
  private czd lWS;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(43058);
    this.lWS = new czd();
    this.lWS.THd = 2048;
    this.lWS.SrH = new eaf().btQ(Util.nullAsNil(paramString1));
    this.lWS.TtX = new eaf().btQ(Util.nullAsNil(paramString2));
    this.lWS.RFr = 0;
    this.lWS.THe = new eaf().btQ(Util.nullAsNil(paramString3));
    this.lWS.THf = new eaf().btQ(Util.nullAsNil(paramString4));
    this.lWS.rVU = 0;
    paramString2 = u.aY(Util.nullAsNil(paramString5), 0, -1);
    paramString3 = this.lWS;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.THb = new b(paramString1);
      paramString1 = this.lWS;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.THa = i;
      this.lWS.mVy = 0;
      this.lWS.mVC = 0;
      this.lWS.mVB = Util.nullAsNil(paramString6);
      this.lWS.mVA = Util.nullAsNil(paramString7);
      this.lWS.mVz = Util.nullAsNil(paramString8);
      this.lWS.RFu = paramInt;
      this.lWS.TxH = Util.nullAsNil(paramString9);
      this.lWS.THk = 0;
      this.lWS.mVD = Util.nullAsNil(paramString10);
      this.lWS.TxJ = 0;
      this.lWS.TxI = "";
      this.EVU = this.lWS;
      AppMethodBeat.o(43058);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bd.l
 * JD-Core Version:    0.7.0.1
 */