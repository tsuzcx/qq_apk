package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  private static long ocH = 0L;
  private f callback;
  private b rr;
  
  public static boolean bOJ()
  {
    AppMethodBeat.i(5580);
    if (System.currentTimeMillis() - ocH > 3600000L)
    {
      AppMethodBeat.o(5580);
      return true;
    }
    AppMethodBeat.o(5580);
    return false;
  }
  
  public static LinkedList<csr> bOK()
  {
    AppMethodBeat.i(5583);
    try
    {
      Object localObject = o.bb(g.ajR().gDT + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        css localcss = new css();
        localcss.parseFrom((byte[])localObject);
        ae.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localcss.GroupCount) });
        localObject = localcss.HDU;
        AppMethodBeat.o(5583);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ae.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException.getMessage());
      ae.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException, "", new Object[0]);
      LinkedList localLinkedList = new LinkedList();
      AppMethodBeat.o(5583);
      return localLinkedList;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5581);
    ocH = System.currentTimeMillis();
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new bnl();
    paramf.hQG = new bnm();
    paramf.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    paramf.funcId = 456;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
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
    ae.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bnm)this.rr.hQE.hQJ;
      if (paramq.Hax.GroupCount <= 0) {
        break label329;
      }
      ae.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(paramq.Hax.GroupCount) });
      try
      {
        paramArrayOfByte = paramq.Hax.toByteArray();
        o.f(g.ajR().gDT + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        paramq = paramq.Hax.HDU.iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = ((csr)paramq.next()).HDT.iterator();
          while (paramArrayOfByte.hasNext())
          {
            czm localczm = (czm)paramArrayOfByte.next();
            i locali = new i();
            locali.username = z.a(localczm.GuF);
            locali.hPQ = localczm.GnN;
            locali.hPP = localczm.GnO;
            locali.dEu = -1;
            locali.eQU = 3;
            locali.eD(true);
            p.aEN().b(locali);
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (IOException paramq)
      {
        ae.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq.getMessage());
        ae.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq, "", new Object[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(5582);
      return;
      label329:
      o.deleteFile(g.ajR().gDT + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */