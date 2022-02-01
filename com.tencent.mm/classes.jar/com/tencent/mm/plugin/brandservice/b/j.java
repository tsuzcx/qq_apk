package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends q
  implements m
{
  private static long pnE = 0L;
  private com.tencent.mm.ak.i callback;
  private d rr;
  
  public static boolean clP()
  {
    AppMethodBeat.i(5580);
    if (System.currentTimeMillis() - pnE > 3600000L)
    {
      AppMethodBeat.o(5580);
      return true;
    }
    AppMethodBeat.o(5580);
    return false;
  }
  
  public static LinkedList<dkz> clQ()
  {
    AppMethodBeat.i(5583);
    try
    {
      Object localObject = com.tencent.mm.vfs.s.aW(com.tencent.mm.kernel.g.aAh().hqG + "search_biz_recommend", 0, 2147483647);
      if (localObject != null)
      {
        dla localdla = new dla();
        localdla.parseFrom((byte[])localObject);
        Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[] { Integer.valueOf(localdla.GroupCount) });
        localObject = localdla.MOW;
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(5581);
    pnE = System.currentTimeMillis();
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new cac();
    parami.iLO = new cad();
    parami.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
    parami.funcId = 456;
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5581);
    return i;
  }
  
  public final int getType()
  {
    return 456;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5582);
    Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cad)this.rr.iLL.iLR;
      if (params.Mfx.GroupCount <= 0) {
        break label329;
      }
      Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[] { Integer.valueOf(params.Mfx.GroupCount) });
      try
      {
        paramArrayOfByte = params.Mfx.toByteArray();
        com.tencent.mm.vfs.s.f(com.tencent.mm.kernel.g.aAh().hqG + "search_biz_recommend", paramArrayOfByte, paramArrayOfByte.length);
        params = params.Mfx.MOW.iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = ((dkz)params.next()).MOV.iterator();
          while (paramArrayOfByte.hasNext())
          {
            dsn localdsn = (dsn)paramArrayOfByte.next();
            com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
            locali.username = z.a(localdsn.Lqk);
            locali.iKX = localdsn.Lir;
            locali.iKW = localdsn.Lis;
            locali.cSx = -1;
            locali.fuz = 3;
            locali.fv(true);
            p.aYB().b(locali);
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
      com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.kernel.g.aAh().hqG + "search_biz_recommend");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */