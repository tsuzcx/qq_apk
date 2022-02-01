package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class c
  extends com.tencent.mm.an.c<bmk>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(274199);
    Object localObject1 = new bmj();
    ((bmj)localObject1).gbn = paramString1;
    ((bmj)localObject1).ybP = paramString2;
    ((bmj)localObject1).msgType = 1;
    ((bmj)localObject1).SXi = paramInt;
    Object localObject2 = z.bcZ();
    localObject2 = ((n)h.ae(n.class)).bbL().RG((String)localObject2);
    if (localObject2 != null)
    {
      ((bmj)localObject1).province = ((as)localObject2).hyc();
      ((bmj)localObject1).city = ((as)localObject2).getCityCode();
    }
    localObject2 = new d.a();
    ((d.a)localObject2).lBU = ((a)localObject1);
    ((d.a)localObject2).lBV = new bmk();
    ((d.a)localObject2).funcId = 4787;
    ((d.a)localObject2).uri = "/cgi-bin/mmpay-bin/foreignhbreceive";
    localObject1 = ((d.a)localObject2).bgN();
    ((d)localObject1).setIsUserCmd(true);
    c((d)localObject1);
    Log.i("MicroMsg.CgiHKHbReceive", "nativeUrl: %s, sendId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(274199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.c
 * JD-Core Version:    0.7.0.1
 */