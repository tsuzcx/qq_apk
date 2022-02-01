package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private f callback;
  LinkedList<String> ocG;
  private final com.tencent.mm.ak.b rr;
  
  public i()
  {
    AppMethodBeat.i(5577);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new awf();
    ((b.a)localObject1).hQG = new awg();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getapplist";
    ((b.a)localObject1).funcId = 387;
    ((b.a)localObject1).hQH = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDS();
    this.ocG = new LinkedList();
    awf localawf = (awf)this.rr.hQD.hQJ;
    g.ajS();
    Object localObject2 = g.ajR().ajA().get(196610, null);
    if (localObject2 == null) {}
    for (localObject1 = "null";; localObject1 = localObject2.toString())
    {
      ae.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", new Object[] { Integer.valueOf(196610), localObject1 });
      localawf.GNY = bu.a((Integer)localObject2, 0);
      ae.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[] { Integer.valueOf(localawf.GNY) });
      AppMethodBeat.o(5577);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5579);
    this.callback = paramf;
    ae.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
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
    ae.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (awg)this.rr.hQE.hQJ;
      ae.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[] { Integer.valueOf(paramq.GNY), Integer.valueOf(paramq.nID) });
      com.tencent.mm.plugin.brandservice.b.j(196610, Integer.valueOf(paramq.GNY));
      paramq = paramq.nIE.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (com.tencent.mm.protocal.protobuf.aj)paramq.next();
        this.ocG.add(paramArrayOfByte.nIJ);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.i
 * JD-Core Version:    0.7.0.1
 */