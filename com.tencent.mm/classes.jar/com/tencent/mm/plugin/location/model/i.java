package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends n
  implements k
{
  private g callback;
  public int dgm;
  public int errCode;
  public String errMsg;
  public int errType;
  public boolean gNN;
  private Runnable hTh;
  public String jKB;
  public List<f> list;
  public final b rr;
  public byte[] tWV;
  public byte[] tWW;
  public String tWX;
  public int tWY;
  
  public i(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55694);
    this.list = new ArrayList();
    this.tWW = null;
    this.gNN = false;
    this.tWX = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bbg();
    ((b.a)localObject).hvu = new bbh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((b.a)localObject).funcId = 457;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    bbg localbbg = (bbg)this.rr.hvr.hvw;
    if (paramArrayOfByte == null)
    {
      localObject = new SKBuiltinBuffer_t();
      localbbg.EQj = ((SKBuiltinBuffer_t)localObject);
      localbbg.EJp = paramString2;
      localbbg.Ecg = paramDouble1;
      localbbg.Ecf = paramDouble2;
      localbbg.Scene = paramInt1;
      localbbg.OpCode = paramInt2;
      localbbg.ERQ = paramDouble4;
      localbbg.ERP = paramDouble3;
      if (!paramBoolean) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      localbbg.EQl = i;
      this.dgm = localbbg.OpCode;
      this.tWX = paramString1;
      this.tWV = paramArrayOfByte;
      ac.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55694);
      return;
      localObject = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(55695);
    ac.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55695);
    return i;
  }
  
  public final int getType()
  {
    return 457;
  }
  
  public final boolean isFirst()
  {
    return this.tWV == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55696);
    ac.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    paramq = (bbh)this.rr.hvs.hvw;
    this.list.clear();
    ac.d("MicroMsg.NetSceneGetPoiList", "url " + paramq.EQs + " " + paramq.Ebg + " " + paramq.Url + " " + paramq.EfU);
    ac.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(paramq.EQt) });
    this.jKB = paramq.EfU;
    this.tWY = paramq.EQt;
    if (paramq.ERS != null)
    {
      ac.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(paramq.ERS.size()) });
      if (paramq.ERS.size() > 0) {
        ac.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((ccb)paramq.ERS.get(0)).Fqw, ((ccb)paramq.ERS.get(0)).iJU, ((ccb)paramq.ERS.get(0)).Eui, ((ccb)paramq.ERS.get(0)).iJV });
      }
      paramArrayOfByte = paramq.ERS.iterator();
      while (paramArrayOfByte.hasNext())
      {
        f localf = new f((ccb)paramArrayOfByte.next(), this.jKB);
        ac.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", new Object[] { Double.valueOf(localf.bNq), Double.valueOf(localf.bNr) });
        this.list.add(localf);
      }
    }
    if (paramq.EQj != null) {
      this.tWW = z.a(paramq.EQj);
    }
    if (paramq.Edp == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.gNN = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.hTh != null) {
        this.hTh.run();
      }
      AppMethodBeat.o(55696);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i
 * JD-Core Version:    0.7.0.1
 */