package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class c
  extends com.tencent.mm.ak.c<bfg>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(213269);
    Object localObject1 = new bff();
    ((bff)localObject1).egX = paramString1;
    ((bff)localObject1).yQE = paramString2;
    ((bff)localObject1).msgType = 1;
    ((bff)localObject1).LON = paramInt;
    Object localObject2 = z.aTY();
    localObject2 = ((l)g.af(l.class)).aSN().Kn((String)localObject2);
    if (localObject2 != null)
    {
      ((bff)localObject1).fuJ = ((as)localObject2).gBR();
      ((bff)localObject1).fuK = ((as)localObject2).getCityCode();
    }
    localObject2 = new d.a();
    ((d.a)localObject2).iLN = ((a)localObject1);
    ((d.a)localObject2).iLO = new bfg();
    ((d.a)localObject2).funcId = 4787;
    ((d.a)localObject2).uri = "/cgi-bin/mmpay-bin/foreignhbreceive";
    localObject1 = ((d.a)localObject2).aXF();
    ((d)localObject1).setIsUserCmd(true);
    c((d)localObject1);
    Log.i("MicroMsg.CgiHKHbReceive", "nativeUrl: %s, sendId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(213269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.c
 * JD-Core Version:    0.7.0.1
 */