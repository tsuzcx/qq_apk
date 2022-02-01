package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class b
  extends c<bmh>
{
  public b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(187436);
    bmg localbmg = new bmg();
    localbmg.gbn = paramString1;
    localbmg.ybP = paramString2;
    localbmg.SXh = paramString3;
    localbmg.msgType = 1;
    localbmg.SXi = paramInt;
    localbmg.EBW = paramString4;
    paramString4 = z.bcZ();
    paramString4 = ((n)h.ae(n.class)).bbL().RG(paramString4);
    if (paramString4 != null)
    {
      localbmg.province = paramString4.hyc();
      localbmg.city = paramString4.getCityCode();
    }
    paramString4 = new d.a();
    paramString4.lBU = localbmg;
    paramString4.lBV = new bmh();
    paramString4.funcId = 4583;
    paramString4.uri = "/cgi-bin/mmpay-bin/foreignhbopen";
    paramString4 = paramString4.bgN();
    paramString4.setIsUserCmd(true);
    c(paramString4);
    Log.i("MicroMsg.CgiHKHbOpen", "nativeUrl: %s, sendId: %s, username: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(187436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.b
 * JD-Core Version:    0.7.0.1
 */