package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private static long mTi = 0L;
  private com.tencent.mm.al.g callback;
  private b rr;
  
  public static boolean bCq()
  {
    AppMethodBeat.i(5580);
    if (System.currentTimeMillis() - mTi > 3600000L)
    {
      AppMethodBeat.o(5580);
      return true;
    }
    AppMethodBeat.o(5580);
    return false;
  }
  
  public static LinkedList<chr> bCr()
  {
    AppMethodBeat.i(5583);
    try
    {
      Object localObject = com.tencent.mm.vfs.i.aR(com.tencent.mm.kernel.g.afB().gcW + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        chs localchs = new chs();
        localchs.parseFrom((byte[])localObject);
        ad.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localchs.GroupCount) });
        localObject = localchs.Edk;
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(5581);
    mTi = System.currentTimeMillis();
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new bet();
    paramg.gUV = new beu();
    paramg.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    paramg.funcId = 456;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.atI();
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
      paramq = (beu)this.rr.gUT.gUX;
      if (paramq.DCd.GroupCount <= 0) {
        break label329;
      }
      ad.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(paramq.DCd.GroupCount) });
      try
      {
        paramArrayOfByte = paramq.DCd.toByteArray();
        com.tencent.mm.vfs.i.f(com.tencent.mm.kernel.g.afB().gcW + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        paramq = paramq.DCd.Edk.iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = ((chr)paramq.next()).Edj.iterator();
          while (paramArrayOfByte.hasNext())
          {
            cob localcob = (cob)paramArrayOfByte.next();
            com.tencent.mm.ak.i locali = new com.tencent.mm.ak.i();
            locali.username = z.a(localcob.Dby);
            locali.gUg = localcob.CVv;
            locali.gUf = localcob.CVw;
            locali.dtM = -1;
            locali.evo = 3;
            locali.ee(true);
            p.auF().b(locali);
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
      com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.kernel.g.afB().gcW + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */