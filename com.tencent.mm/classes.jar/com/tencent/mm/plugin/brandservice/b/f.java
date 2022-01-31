package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private static long jSQ = 0L;
  private com.tencent.mm.ai.f callback;
  private b rr;
  
  public static boolean aWr()
  {
    AppMethodBeat.i(13839);
    if (System.currentTimeMillis() - jSQ > 3600000L)
    {
      AppMethodBeat.o(13839);
      return true;
    }
    AppMethodBeat.o(13839);
    return false;
  }
  
  public static LinkedList<bsm> aWs()
  {
    AppMethodBeat.i(13842);
    try
    {
      Object localObject = com.tencent.mm.vfs.e.i(g.RL().eHR + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        bsn localbsn = new bsn();
        localbsn.parseFrom((byte[])localObject);
        ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localbsn.GroupCount) });
        localObject = localbsn.xFY;
        AppMethodBeat.o(13842);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException, "", new Object[0]);
      LinkedList localLinkedList = new LinkedList();
      AppMethodBeat.o(13842);
      return localLinkedList;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(13840);
    jSQ = System.currentTimeMillis();
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new ats();
    paramf.fsY = new att();
    paramf.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    paramf.funcId = 456;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13840);
    return i;
  }
  
  public final int getType()
  {
    return 456;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13841);
    ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (att)this.rr.fsW.fta;
      if (paramq.xiL.GroupCount <= 0) {
        break label329;
      }
      ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(paramq.xiL.GroupCount) });
      try
      {
        paramArrayOfByte = paramq.xiL.toByteArray();
        com.tencent.mm.vfs.e.b(g.RL().eHR + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        paramq = paramq.xiL.xFY.iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = ((bsm)paramq.next()).xFX.iterator();
          while (paramArrayOfByte.hasNext())
          {
            bxz localbxz = (bxz)paramArrayOfByte.next();
            h localh = new h();
            localh.username = aa.a(localbxz.wOT);
            localh.fsl = localbxz.wJq;
            localh.fsk = localbxz.wJr;
            localh.bsY = -1;
            localh.dqB = 3;
            localh.cM(true);
            o.adg().b(localh);
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (IOException paramq)
      {
        ab.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq.getMessage());
        ab.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", paramq, "", new Object[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(13841);
      return;
      label329:
      com.tencent.mm.vfs.e.deleteFile(g.RL().eHR + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f
 * JD-Core Version:    0.7.0.1
 */