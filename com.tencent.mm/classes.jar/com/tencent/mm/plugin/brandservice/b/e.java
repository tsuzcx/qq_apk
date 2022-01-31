package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  LinkedList<String> ibZ;
  
  public e()
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new aat();
    ((b.a)localObject1).ecI = new aau();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getapplist";
    ((b.a)localObject1).ecG = 387;
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.dmK = ((b.a)localObject1).Kt();
    this.ibZ = new LinkedList();
    aat localaat = (aat)this.dmK.ecE.ecN;
    g.DQ();
    Object localObject2 = g.DP().Dz().get(196610, null);
    if (localObject2 == null) {}
    for (localObject1 = "null";; localObject1 = localObject2.toString())
    {
      y.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", new Object[] { Integer.valueOf(196610), localObject1 });
      localaat.tas = bk.a((Integer)localObject2, 0);
      y.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[] { Integer.valueOf(localaat.tas) });
      return;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aau)this.dmK.ecF.ecN;
      y.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[] { Integer.valueOf(paramq.tas), Integer.valueOf(paramq.hPS) });
      y.i("MicroMsg.BrandService.NetSceneGetAppList", "result list is %s", new Object[] { paramq.hPT.toString() });
      a.g(196610, Integer.valueOf(paramq.tas));
      paramq = paramq.hPT.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (ai)paramq.next();
        this.ibZ.add(paramArrayOfByte.hPY);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 387;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */