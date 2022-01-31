package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private static long ica = 0L;
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public static boolean axt()
  {
    return System.currentTimeMillis() - ica > 3600000L;
  }
  
  public static LinkedList<bjr> axu()
  {
    try
    {
      Object localObject = com.tencent.mm.vfs.e.c(g.DP().dKt + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        bjs localbjs = new bjs();
        localbjs.aH((byte[])localObject);
        y.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localbjs.tuG) });
        localObject = localbjs.tDx;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      y.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException.getMessage());
      y.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException, "", new Object[0]);
    }
    return new LinkedList();
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    ica = System.currentTimeMillis();
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new aoc();
    paramf.ecI = new aod();
    paramf.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    paramf.ecG = 456;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aod)this.dmK.ecF.ecN;
      if (paramq.tjU.tuG <= 0) {
        break label317;
      }
      y.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(paramq.tjU.tuG) });
      try
      {
        paramArrayOfByte = paramq.tjU.toByteArray();
        com.tencent.mm.vfs.e.b(g.DP().dKt + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        paramq = paramq.tjU.tDx.iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = ((bjr)paramq.next()).tDw.iterator();
          while (paramArrayOfByte.hasNext())
          {
            boe localboe = (boe)paramArrayOfByte.next();
            h localh = new h();
            localh.username = aa.a(localboe.sQs);
            localh.ebT = localboe.sLD;
            localh.ebS = localboe.sLE;
            localh.bcw = -1;
            localh.cCq = 3;
            localh.bK(true);
            o.Kh().a(localh);
          }
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (IOException paramq)
      {
        y.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq.getMessage());
        y.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq, "", new Object[0]);
      }
    }
    for (;;)
    {
      return;
      label317:
      com.tencent.mm.vfs.e.deleteFile(g.DP().dKt + "search_biz_recommend");
    }
  }
  
  public final int getType()
  {
    return 456;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f
 * JD-Core Version:    0.7.0.1
 */