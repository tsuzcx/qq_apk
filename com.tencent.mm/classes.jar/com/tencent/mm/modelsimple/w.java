package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class w
  extends n
  implements k
{
  private f callback;
  public int errCode;
  public int errType;
  private final long imx;
  private Runnable imy;
  public long msgId;
  public b rr;
  
  public w(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(150940);
    this.imx = 60000L;
    this.msgId = -1L;
    cld localcld = new cld();
    localcld.FOA = paramFloat1;
    localcld.FOB = paramFloat2;
    localcld.Ggz = 1;
    localcld.Ggw = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cxi();
    ((b.a)localObject).hNN = new cxj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((b.a)localObject).funcId = 424;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cxi)this.rr.hNK.hNQ;
    ((cxi)localObject).HoR = localcld;
    ((cxi)localObject).Scene = 1;
    ((cxi)localObject).HoS = -10000.0F;
    ((cxi)localObject).HoT = -10000.0F;
    this.msgId = paramLong;
    AppMethodBeat.o(150940);
  }
  
  public w(cxi paramcxi)
  {
    AppMethodBeat.i(150941);
    this.imx = 60000L;
    this.msgId = -1L;
    b.a locala = new b.a();
    locala.hNM = paramcxi;
    locala.hNN = new cxj();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(150941);
  }
  
  public static String Gp(String paramString)
  {
    AppMethodBeat.i(150945);
    paramString = bw.M(paramString, "streetview");
    if (paramString == null)
    {
      AppMethodBeat.o(150945);
      return null;
    }
    paramString = (String)paramString.get(".streetview.link");
    AppMethodBeat.o(150945);
    return paramString;
  }
  
  public final cxj aLb()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (cxj)this.rr.hNL.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150942);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150942);
    return i;
  }
  
  public final long getReturnTimeout()
  {
    return 60000L;
  }
  
  public final int getType()
  {
    return 424;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150944);
    ad.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { aLb().GDJ });
      if (this.imy != null) {
        this.imy.run();
      }
      AppMethodBeat.o(150944);
      return;
      ad.e("MicroMsg.NetSceneScanStreetView", "callback null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(150943);
    if (((cxi)((b)paramq).hNK.hNQ).HoR == null)
    {
      ad.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      paramq = n.b.hOq;
      AppMethodBeat.o(150943);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(150943);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */