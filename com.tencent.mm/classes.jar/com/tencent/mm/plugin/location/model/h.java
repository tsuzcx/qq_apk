package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public int ctW;
  public boolean eRq;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable fQa;
  public String hng;
  public List<com.tencent.mm.plugin.location.ui.impl.f> list;
  public byte[] oai;
  public byte[] oaj;
  public String oak;
  public int oal;
  public final b rr;
  
  public h(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(113315);
    this.list = new ArrayList();
    this.oaj = null;
    this.eRq = false;
    this.oak = "";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new anj();
    ((b.a)localObject).fsY = new ank();
    ((b.a)localObject).fsY = new ank();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((b.a)localObject).funcId = 457;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    anj localanj = (anj)this.rr.fsV.fta;
    if (paramArrayOfByte == null)
    {
      localObject = new SKBuiltinBuffer_t();
      localanj.xcE = ((SKBuiltinBuffer_t)localObject);
      localanj.wXt = paramString2;
      localanj.wyP = paramDouble1;
      localanj.wyO = paramDouble2;
      localanj.Scene = paramInt1;
      localanj.OpCode = paramInt2;
      localanj.xdK = paramDouble4;
      localanj.xdJ = paramDouble3;
      if (!paramBoolean) {
        break label332;
      }
    }
    label332:
    for (int i = 1;; i = 0)
    {
      localanj.xcG = i;
      this.ctW = localanj.OpCode;
      this.oak = paramString1;
      this.oai = paramArrayOfByte;
      ab.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutuQuery %s".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(113315);
      return;
      localObject = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(113316);
    ab.d("MicroMsg.NetSceneGetPoiList", "scene done");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(113316);
    return i;
  }
  
  public final int getType()
  {
    return 457;
  }
  
  public final boolean isFirst()
  {
    return this.oai == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113317);
    ab.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    paramq = (ank)this.rr.fsW.fta;
    this.list.clear();
    ab.d("MicroMsg.NetSceneGetPoiList", "url " + paramq.xcN + " " + paramq.wxW + " " + paramq.Url + " " + paramq.wBZ);
    ab.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(paramq.xcO) });
    this.hng = paramq.wBZ;
    this.oal = paramq.xcO;
    if (paramq.xdM != null)
    {
      ab.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(paramq.xdM.size()) });
      if (paramq.xdM.size() > 0) {
        ab.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((bjs)paramq.xdM.get(0)).xyb, ((bjs)paramq.xdM.get(0)).gwQ, ((bjs)paramq.xdM.get(0)).wOD, ((bjs)paramq.xdM.get(0)).gwR });
      }
      paramArrayOfByte = paramq.xdM.iterator();
      while (paramArrayOfByte.hasNext())
      {
        com.tencent.mm.plugin.location.ui.impl.f localf = new com.tencent.mm.plugin.location.ui.impl.f((bjs)paramArrayOfByte.next(), this.hng);
        this.list.add(localf);
      }
    }
    if (paramq.xcE != null) {
      this.oaj = aa.a(paramq.xcE);
    }
    if (paramq.wzD == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.eRq = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.fQa != null) {
        this.fQa.run();
      }
      AppMethodBeat.o(113317);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.h
 * JD-Core Version:    0.7.0.1
 */