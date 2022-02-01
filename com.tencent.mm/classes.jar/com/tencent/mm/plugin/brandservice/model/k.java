package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.enn;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.protocal.protobuf.ewa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends p
  implements m
{
  private static long vCl = 0L;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public static boolean dcl()
  {
    AppMethodBeat.i(5580);
    if (System.currentTimeMillis() - vCl > 3600000L)
    {
      AppMethodBeat.o(5580);
      return true;
    }
    AppMethodBeat.o(5580);
    return false;
  }
  
  public static LinkedList<enn> dcm()
  {
    AppMethodBeat.i(5583);
    try
    {
      Object localObject = y.bi(com.tencent.mm.kernel.h.baE().mCJ + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        eno localeno = new eno();
        localeno.parseFrom((byte[])localObject);
        Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localeno.GroupCount) });
        localObject = localeno.absc;
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(5581);
    vCl = System.currentTimeMillis();
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new cxx();
    paramh.otF = new cxy();
    paramh.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    paramh.funcId = 456;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
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
      params = (cxy)c.c.b(this.rr.otC);
      if (params.aaDd.GroupCount <= 0) {
        break label329;
      }
      Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(params.aaDd.GroupCount) });
      try
      {
        paramArrayOfByte = params.aaDd.toByteArray();
        y.f(com.tencent.mm.kernel.h.baE().mCJ + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        params = params.aaDd.absc.iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = ((enn)params.next()).absb.iterator();
          while (paramArrayOfByte.hasNext())
          {
            ewa localewa = (ewa)paramArrayOfByte.next();
            j localj = new j();
            localj.username = w.a(localewa.ZqL);
            localj.osN = localewa.ZhO;
            localj.osM = localewa.ZhP;
            localj.eQp = -1;
            localj.jZY = 3;
            localj.gX(true);
            q.bFE().b(localj);
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
      label329:
      y.deleteFile(com.tencent.mm.kernel.h.baE().mCJ + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.k
 * JD-Core Version:    0.7.0.1
 */