package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public int drI;
  public int errCode;
  public String errMsg;
  public int errType;
  public boolean hhJ;
  private Runnable imy;
  public String keN;
  public List<com.tencent.mm.plugin.location.ui.impl.f> list;
  public final b rr;
  public byte[] uZE;
  public byte[] uZF;
  public String uZG;
  public int uZH;
  
  public i(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55694);
    this.list = new ArrayList();
    this.uZF = null;
    this.hhJ = false;
    this.uZG = "";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bfk();
    ((b.a)localObject).hNN = new bfl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((b.a)localObject).funcId = 457;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    bfk localbfk = (bfk)this.rr.hNK.hNQ;
    if (paramArrayOfByte == null)
    {
      localObject = new SKBuiltinBuffer_t();
      localbfk.GzA = ((SKBuiltinBuffer_t)localObject);
      localbfk.Gsr = paramString2;
      localbfk.FIc = paramDouble1;
      localbfk.FIb = paramDouble2;
      localbfk.Scene = paramInt1;
      localbfk.OpCode = paramInt2;
      localbfk.GBi = paramDouble4;
      localbfk.GBh = paramDouble3;
      if (!paramBoolean) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      localbfk.GzC = i;
      this.drI = localbfk.OpCode;
      this.uZG = paramString1;
      this.uZE = paramArrayOfByte;
      ad.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55694);
      return;
      localObject = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(55695);
    ad.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
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
    return this.uZE == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55696);
    ad.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    paramq = (bfl)this.rr.hNL.hNQ;
    this.list.clear();
    ad.d("MicroMsg.NetSceneGetPoiList", "url " + paramq.GzJ + " " + paramq.FGP + " " + paramq.Url + " " + paramq.FMt);
    ad.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(paramq.GzK) });
    this.keN = paramq.FMt;
    this.uZH = paramq.GzK;
    if (paramq.GBk != null)
    {
      ad.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(paramq.GBk.size()) });
      if (paramq.GBk.size() > 0) {
        ad.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((cgs)paramq.GBk.get(0)).Hag, ((cgs)paramq.GBk.get(0)).jdd, ((cgs)paramq.GBk.get(0)).GbB, ((cgs)paramq.GBk.get(0)).jde });
      }
      paramArrayOfByte = paramq.GBk.iterator();
      while (paramArrayOfByte.hasNext())
      {
        com.tencent.mm.plugin.location.ui.impl.f localf = new com.tencent.mm.plugin.location.ui.impl.f((cgs)paramArrayOfByte.next(), this.keN);
        ad.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", new Object[] { Double.valueOf(localf.bXD), Double.valueOf(localf.bXE) });
        this.list.add(localf);
      }
    }
    if (paramq.GzA != null) {
      this.uZF = z.a(paramq.GzA);
    }
    if (paramq.FJy == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.hhJ = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.imy != null) {
        this.imy.run();
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