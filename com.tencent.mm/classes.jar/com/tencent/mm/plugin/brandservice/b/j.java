package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  LinkedList<String> mTh;
  private final com.tencent.mm.al.b rr;
  
  public j()
  {
    AppMethodBeat.i(5577);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new aop();
    ((b.a)localObject1).gUV = new aoq();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getapplist";
    ((b.a)localObject1).funcId = 387;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).atI();
    this.mTh = new LinkedList();
    aop localaop = (aop)this.rr.gUS.gUX;
    com.tencent.mm.kernel.g.afC();
    Object localObject2 = com.tencent.mm.kernel.g.afB().afk().get(196610, null);
    if (localObject2 == null) {}
    for (localObject1 = "null";; localObject1 = localObject2.toString())
    {
      ad.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", new Object[] { Integer.valueOf(196610), localObject1 });
      localaop.Dqu = bt.a((Integer)localObject2, 0);
      ad.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[] { Integer.valueOf(localaop.Dqu) });
      AppMethodBeat.o(5577);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(5579);
    this.callback = paramg;
    ad.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5579);
    return i;
  }
  
  public final int getType()
  {
    return 387;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5578);
    ad.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aoq)this.rr.gUT.gUX;
      ad.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[] { Integer.valueOf(paramq.Dqu), Integer.valueOf(paramq.mAK) });
      com.tencent.mm.plugin.brandservice.b.j(196610, Integer.valueOf(paramq.Dqu));
      paramq = paramq.mAL.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (aj)paramq.next();
        this.mTh.add(paramArrayOfByte.mAQ);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */