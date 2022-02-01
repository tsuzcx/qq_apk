package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private static long nvA = 0L;
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public static boolean bJt()
  {
    AppMethodBeat.i(5580);
    if (System.currentTimeMillis() - nvA > 3600000L)
    {
      AppMethodBeat.o(5580);
      return true;
    }
    AppMethodBeat.o(5580);
    return false;
  }
  
  public static LinkedList<cmu> bJu()
  {
    AppMethodBeat.i(5583);
    try
    {
      Object localObject = com.tencent.mm.vfs.i.aU(com.tencent.mm.kernel.g.agR().ghC + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        cmv localcmv = new cmv();
        localcmv.parseFrom((byte[])localObject);
        ac.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localcmv.GroupCount) });
        localObject = localcmv.FAg;
        AppMethodBeat.o(5583);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ac.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException.getMessage());
      ac.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException, "", new Object[0]);
      LinkedList localLinkedList = new LinkedList();
      AppMethodBeat.o(5583);
      return localLinkedList;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(5581);
    nvA = System.currentTimeMillis();
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new bil();
    paramg.hvu = new bim();
    paramg.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    paramg.funcId = 456;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.aAz();
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
    ac.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bim)this.rr.hvs.hvw;
      if (paramq.EXz.GroupCount <= 0) {
        break label329;
      }
      ac.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(paramq.EXz.GroupCount) });
      try
      {
        paramArrayOfByte = paramq.EXz.toByteArray();
        com.tencent.mm.vfs.i.f(com.tencent.mm.kernel.g.agR().ghC + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        paramq = paramq.EXz.FAg.iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = ((cmu)paramq.next()).FAf.iterator();
          while (paramArrayOfByte.hasNext())
          {
            cti localcti = (cti)paramArrayOfByte.next();
            com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
            locali.username = z.a(localcti.EuE);
            locali.huF = localcti.Eof;
            locali.huE = localcti.Eog;
            locali.drx = -1;
            locali.exK = 3;
            locali.ez(true);
            p.aBw().b(locali);
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (IOException paramq)
      {
        ac.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq.getMessage());
        ac.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq, "", new Object[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(5582);
      return;
      label329:
      com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.kernel.g.agR().ghC + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */