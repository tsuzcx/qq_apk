package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends p
  implements m
{
  public byte[] Kcj;
  public byte[] Kck;
  public String Kcl;
  public int Kcm;
  private h callback;
  public int errCode;
  public String errMsg;
  public int errType;
  public int hHC;
  public List<f> list;
  public String mpa;
  public boolean nxG;
  private Runnable oTq;
  public final c rr;
  
  public i(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55694);
    this.list = new ArrayList();
    this.Kck = null;
    this.nxG = false;
    this.Kcl = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cpb();
    ((c.a)localObject).otF = new cpc();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((c.a)localObject).funcId = 457;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    cpb localcpb = (cpb)c.b.b(this.rr.otB);
    if (paramArrayOfByte == null)
    {
      localObject = new gol();
      localcpb.aatT = ((gol)localObject);
      localcpb.aakp = paramString2;
      localcpb.YTd = paramDouble1;
      localcpb.YTc = paramDouble2;
      localcpb.IJG = paramInt1;
      localcpb.YIq = paramInt2;
      localcpb.aavS = paramDouble4;
      localcpb.aavR = paramDouble3;
      if (!paramBoolean) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      localcpb.aatV = i;
      this.hHC = localcpb.YIq;
      this.Kcl = paramString1;
      this.Kcj = paramArrayOfByte;
      Log.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55694);
      return;
      localObject = new gol().df(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(55695);
    Log.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
    this.callback = paramh;
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
    return this.Kcj == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55696);
    Log.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    params = (cpc)c.c.b(this.rr.otC);
    this.list.clear();
    Log.d("MicroMsg.NetSceneGetPoiList", "url " + params.aauc + " " + params.YRE + " " + params.Url + " " + params.YYr);
    Log.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(params.aaud) });
    this.mpa = params.YYr;
    this.Kcm = params.aaud;
    if (params.aavU != null)
    {
      Log.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(params.aavU.size()) });
      if (params.aavU.size() > 0) {
        Log.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((dzn)params.aavU.get(0)).abeG, ((dzn)params.aavU.get(0)).pSg, ((dzn)params.aavU.get(0)).Zqi, ((dzn)params.aavU.get(0)).pSh });
      }
      paramArrayOfByte = params.aavU.iterator();
      while (paramArrayOfByte.hasNext())
      {
        f localf = new f((dzn)paramArrayOfByte.next(), this.mpa);
        Log.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", new Object[] { Double.valueOf(localf.HHO), Double.valueOf(localf.HHN) });
        this.list.add(localf);
      }
    }
    if (params.aatT != null) {
      this.Kck = w.a(params.aatT);
    }
    if (params.YVg == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.nxG = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.oTq != null) {
        this.oTq.run();
      }
      AppMethodBeat.o(55696);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i
 * JD-Core Version:    0.7.0.1
 */