package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends q
  implements m
{
  public byte[] EjA;
  public byte[] EjB;
  public String EjC;
  public int EjD;
  private com.tencent.mm.an.i callback;
  public int errCode;
  public String errMsg;
  public int errType;
  public int fCN;
  public String jQi;
  public boolean kSa;
  public List<f> list;
  private Runnable maA;
  public final d rr;
  
  public i(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55694);
    this.list = new ArrayList();
    this.EjB = null;
    this.kSa = false;
    this.EjC = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bzs();
    ((d.a)localObject).lBV = new bzt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((d.a)localObject).funcId = 457;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    bzs localbzs = (bzs)d.b.b(this.rr.lBR);
    if (paramArrayOfByte == null)
    {
      localObject = new eae();
      localbzs.TgD = ((eae)localObject);
      localbzs.SYn = paramString2;
      localbzs.RVz = paramDouble1;
      localbzs.RVy = paramDouble2;
      localbzs.CPw = paramInt1;
      localbzs.RLe = paramInt2;
      localbzs.Tiu = paramDouble4;
      localbzs.Tit = paramDouble3;
      if (!paramBoolean) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      localbzs.TgF = i;
      this.fCN = localbzs.RLe;
      this.EjC = paramString1;
      this.EjA = paramArrayOfByte;
      Log.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55694);
      return;
      localObject = new eae().dc(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(55695);
    Log.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55695);
    return i;
  }
  
  public final int getType()
  {
    return 457;
  }
  
  public final boolean isFirst()
  {
    return this.EjA == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55696);
    Log.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    params = (bzt)d.c.b(this.rr.lBS);
    this.list.clear();
    Log.d("MicroMsg.NetSceneGetPoiList", "url " + params.TgM + " " + params.RUd + " " + params.Url + " " + params.Sas);
    Log.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(params.TgN) });
    this.jQi = params.Sas;
    this.EjD = params.TgN;
    if (params.Tiw != null)
    {
      Log.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(params.Tiw.size()) });
      if (params.Tiw.size() > 0) {
        Log.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((dhe)params.Tiw.get(0)).TOk, ((dhe)params.Tiw.get(0)).mVz, ((dhe)params.Tiw.get(0)).Srg, ((dhe)params.Tiw.get(0)).mVA });
      }
      paramArrayOfByte = params.Tiw.iterator();
      while (paramArrayOfByte.hasNext())
      {
        f localf = new f((dhe)paramArrayOfByte.next(), this.jQi);
        Log.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", new Object[] { Double.valueOf(localf.BVq), Double.valueOf(localf.BVp) });
        this.list.add(localf);
      }
    }
    if (params.TgD != null) {
      this.EjB = z.a(params.TgD);
    }
    if (params.RXo == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.kSa = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.maA != null) {
        this.maA.run();
      }
      AppMethodBeat.o(55696);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i
 * JD-Core Version:    0.7.0.1
 */