package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private static long nWY = 0L;
  private f callback;
  private b rr;
  
  public static boolean bNM()
  {
    AppMethodBeat.i(5580);
    if (System.currentTimeMillis() - nWY > 3600000L)
    {
      AppMethodBeat.o(5580);
      return true;
    }
    AppMethodBeat.o(5580);
    return false;
  }
  
  public static LinkedList<crx> bNN()
  {
    AppMethodBeat.i(5583);
    try
    {
      Object localObject = com.tencent.mm.vfs.i.aY(g.ajC().gBm + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        cry localcry = new cry();
        localcry.parseFrom((byte[])localObject);
        ad.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localcry.GroupCount) });
        localObject = localcry.Hku;
        AppMethodBeat.o(5583);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ad.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException.getMessage());
      ad.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException, "", new Object[0]);
      LinkedList localLinkedList = new LinkedList();
      AppMethodBeat.o(5583);
      return localLinkedList;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5581);
    nWY = System.currentTimeMillis();
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new bmt();
    paramf.hNN = new bmu();
    paramf.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    paramf.funcId = 456;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDC();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5581);
    return i;
  }
  
  public final int getType()
  {
    return 456;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5582);
    ad.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bmu)this.rr.hNL.hNQ;
      if (paramq.GGV.GroupCount <= 0) {
        break label329;
      }
      ad.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(paramq.GGV.GroupCount) });
      try
      {
        paramArrayOfByte = paramq.GGV.toByteArray();
        com.tencent.mm.vfs.i.f(g.ajC().gBm + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        paramq = paramq.GGV.Hku.iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = ((crx)paramq.next()).Hkt.iterator();
          while (paramArrayOfByte.hasNext())
          {
            cys localcys = (cys)paramArrayOfByte.next();
            com.tencent.mm.ak.i locali = new com.tencent.mm.ak.i();
            locali.username = z.a(localcys.GbY);
            locali.hMX = localcys.FVo;
            locali.hMW = localcys.FVp;
            locali.dDp = -1;
            locali.ePj = 3;
            locali.eB(true);
            p.aEx().b(locali);
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (IOException paramq)
      {
        ad.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq.getMessage());
        ad.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq, "", new Object[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(5582);
      return;
      label329:
      com.tencent.mm.vfs.i.deleteFile(g.ajC().gBm + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */