package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public int dsO;
  public int errCode;
  public String errMsg;
  public int errType;
  public boolean hkx;
  private Runnable ips;
  public String kid;
  public List<com.tencent.mm.plugin.location.ui.impl.f> list;
  public final b rr;
  public byte[] vlP;
  public byte[] vlQ;
  public String vlR;
  public int vlS;
  
  public i(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55694);
    this.list = new ArrayList();
    this.vlQ = null;
    this.hkx = false;
    this.vlR = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bga();
    ((b.a)localObject).hQG = new bgb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((b.a)localObject).funcId = 457;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    bga localbga = (bga)this.rr.hQD.hQJ;
    if (paramArrayOfByte == null)
    {
      localObject = new SKBuiltinBuffer_t();
      localbga.GTa = ((SKBuiltinBuffer_t)localObject);
      localbga.GLP = paramString2;
      localbga.Gay = paramDouble1;
      localbga.Gax = paramDouble2;
      localbga.Scene = paramInt1;
      localbga.OpCode = paramInt2;
      localbga.GUI = paramDouble4;
      localbga.GUH = paramDouble3;
      if (!paramBoolean) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      localbga.GTc = i;
      this.dsO = localbga.OpCode;
      this.vlR = paramString1;
      this.vlP = paramArrayOfByte;
      ae.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55694);
      return;
      localObject = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(55695);
    ae.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
    this.callback = paramf;
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
    return this.vlP == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55696);
    ae.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    paramq = (bgb)this.rr.hQE.hQJ;
    this.list.clear();
    ae.d("MicroMsg.NetSceneGetPoiList", "url " + paramq.GTj + " " + paramq.FZl + " " + paramq.Url + " " + paramq.GeS);
    ae.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(paramq.GTk) });
    this.kid = paramq.GeS;
    this.vlS = paramq.GTk;
    if (paramq.GUK != null)
    {
      ae.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(paramq.GUK.size()) });
      if (paramq.GUK.size() > 0) {
        ae.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((chm)paramq.GUK.get(0)).HtG, ((chm)paramq.GUK.get(0)).jfW, ((chm)paramq.GUK.get(0)).Gui, ((chm)paramq.GUK.get(0)).jfX });
      }
      paramArrayOfByte = paramq.GUK.iterator();
      while (paramArrayOfByte.hasNext())
      {
        com.tencent.mm.plugin.location.ui.impl.f localf = new com.tencent.mm.plugin.location.ui.impl.f((chm)paramArrayOfByte.next(), this.kid);
        ae.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", new Object[] { Double.valueOf(localf.bXD), Double.valueOf(localf.bXE) });
        this.list.add(localf);
      }
    }
    if (paramq.GTa != null) {
      this.vlQ = z.a(paramq.GTa);
    }
    if (paramq.GbX == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.hkx = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.ips != null) {
        this.ips.run();
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