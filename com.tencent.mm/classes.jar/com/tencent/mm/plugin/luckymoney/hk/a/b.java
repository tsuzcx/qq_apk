package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class b
  extends c<bfd>
{
  public b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(213268);
    bfc localbfc = new bfc();
    localbfc.egX = paramString1;
    localbfc.yQE = paramString2;
    localbfc.LOM = paramString3;
    localbfc.msgType = 1;
    localbfc.LON = paramInt;
    localbfc.yXR = paramString4;
    paramString4 = z.aTY();
    paramString4 = ((l)g.af(l.class)).aSN().Kn(paramString4);
    if (paramString4 != null)
    {
      localbfc.fuJ = paramString4.gBR();
      localbfc.fuK = paramString4.getCityCode();
    }
    paramString4 = new d.a();
    paramString4.iLN = localbfc;
    paramString4.iLO = new bfd();
    paramString4.funcId = 4583;
    paramString4.uri = "/cgi-bin/mmpay-bin/foreignhbopen";
    paramString4 = paramString4.aXF();
    paramString4.setIsUserCmd(true);
    c(paramString4);
    Log.i("MicroMsg.CgiHKHbOpen", "nativeUrl: %s, sendId: %s, username: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(213268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.b
 * JD-Core Version:    0.7.0.1
 */