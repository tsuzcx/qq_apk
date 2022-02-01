package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.an.q
  implements m
{
  private static long swE = 0L;
  private i callback;
  private d rr;
  
  public static boolean czt()
  {
    AppMethodBeat.i(5580);
    if (System.currentTimeMillis() - swE > 3600000L)
    {
      AppMethodBeat.o(5580);
      return true;
    }
    AppMethodBeat.o(5580);
    return false;
  }
  
  public static LinkedList<dup> czu()
  {
    AppMethodBeat.i(5583);
    try
    {
      Object localObject = u.aY(h.aHG().kcB + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        duq localduq = new duq();
        localduq.parseFrom((byte[])localObject);
        Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localduq.GroupCount) });
        localObject = localduq.UaV;
        AppMethodBeat.o(5583);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException.getMessage());
      Log.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", localException, "", new Object[0]);
      LinkedList localLinkedList = new LinkedList();
      AppMethodBeat.o(5583);
      return localLinkedList;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5581);
    swE = System.currentTimeMillis();
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new chx();
    parami.lBV = new chy();
    parami.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    parami.funcId = 456;
    parami.lBW = 0;
    parami.respCmdId = 0;
    this.rr = parami.bgN();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5581);
    return i;
  }
  
  public final int getType()
  {
    return 456;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5582);
    Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (chy)d.c.b(this.rr.lBS);
      if (params.Tpb.GroupCount <= 0) {
        break label326;
      }
      Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(params.Tpb.GroupCount) });
      try
      {
        paramArrayOfByte = params.Tpb.toByteArray();
        u.H(h.aHG().kcB + "search_biz_recommend", paramArrayOfByte);
        params = params.Tpb.UaV.iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = ((dup)params.next()).UaU.iterator();
          while (paramArrayOfByte.hasNext())
          {
            ecj localecj = (ecj)paramArrayOfByte.next();
            j localj = new j();
            localj.username = z.a(localecj.SrH);
            localj.lBe = localecj.SjI;
            localj.lBd = localecj.SjJ;
            localj.cUP = -1;
            localj.hDc = 3;
            localj.gg(true);
            com.tencent.mm.am.q.bhP().b(localj);
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      catch (IOException params)
      {
        Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", params.getMessage());
        Log.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", params, "", new Object[0]);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(5582);
      return;
      label326:
      u.deleteFile(h.aHG().kcB + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */