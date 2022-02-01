package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.location.ui.impl.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends n
  implements k
{
  private g callback;
  public int diR;
  public int errCode;
  public String errMsg;
  public int errType;
  public boolean gna;
  private Runnable hsF;
  public String jko;
  public List<f> list;
  public final b rr;
  public byte[] sOI;
  public byte[] sOJ;
  public String sOK;
  public int sOL;
  
  public i(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55694);
    this.list = new ArrayList();
    this.sOJ = null;
    this.gna = false;
    this.sOK = "";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new axo();
    ((b.a)localObject).gUV = new axp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((b.a)localObject).funcId = 457;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    axo localaxo = (axo)this.rr.gUS.gUX;
    if (paramArrayOfByte == null)
    {
      localObject = new SKBuiltinBuffer_t();
      localaxo.Dva = ((SKBuiltinBuffer_t)localObject);
      localaxo.Dop = paramString2;
      localaxo.CJE = paramDouble1;
      localaxo.CJD = paramDouble2;
      localaxo.Scene = paramInt1;
      localaxo.OpCode = paramInt2;
      localaxo.Dwv = paramDouble4;
      localaxo.Dwu = paramDouble3;
      if (!paramBoolean) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      localaxo.Dvc = i;
      this.diR = localaxo.OpCode;
      this.sOK = paramString1;
      this.sOI = paramArrayOfByte;
      ad.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutoQuery %s buffer ".concat(String.valueOf(paramArrayOfByte)), new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(55694);
      return;
      localObject = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
      break;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(55695);
    ad.i("MicroMsg.NetSceneGetPoiList", "NetSceneGetPoiList done.");
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
    return this.sOI == null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55696);
    ad.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    paramq = (axp)this.rr.gUT.gUX;
    this.list.clear();
    ad.d("MicroMsg.NetSceneGetPoiList", "url " + paramq.Dvj + " " + paramq.CIE + " " + paramq.Url + " " + paramq.CNs);
    ad.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(paramq.Dvk) });
    this.jko = paramq.CNs;
    this.sOL = paramq.Dvk;
    if (paramq.Dwx != null)
    {
      ad.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(paramq.Dwx.size()) });
      if (paramq.Dwx.size() > 0) {
        ad.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((bxg)paramq.Dwx.get(0)).DTI, ((bxg)paramq.Dwx.get(0)).ijN, ((bxg)paramq.Dwx.get(0)).Dbj, ((bxg)paramq.Dwx.get(0)).ijO });
      }
      paramArrayOfByte = paramq.Dwx.iterator();
      while (paramArrayOfByte.hasNext())
      {
        f localf = new f((bxg)paramArrayOfByte.next(), this.jko);
        ad.d("MicroMsg.NetSceneGetPoiList", "lat %s lng %s", new Object[] { Double.valueOf(localf.bPI), Double.valueOf(localf.bPJ) });
        this.list.add(localf);
      }
    }
    if (paramq.Dva != null) {
      this.sOJ = z.a(paramq.Dva);
    }
    if (paramq.CKN == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.gna = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.hsF != null) {
        this.hsF.run();
      }
      AppMethodBeat.o(55696);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i
 * JD-Core Version:    0.7.0.1
 */