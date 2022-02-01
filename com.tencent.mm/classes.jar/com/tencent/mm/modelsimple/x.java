package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class x
  extends n
  implements k
{
  private f callback;
  public int errCode;
  public int errType;
  private final long ipr;
  private Runnable ips;
  public long msgId;
  public b rr;
  
  public x(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(150940);
    this.ipr = 60000L;
    this.msgId = -1L;
    clx localclx = new clx();
    localclx.GgZ = paramFloat1;
    localclx.Gha = paramFloat2;
    localclx.Gzi = 1;
    localclx.Gzf = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cyc();
    ((b.a)localObject).hQG = new cyd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((b.a)localObject).funcId = 424;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cyc)this.rr.hQD.hQJ;
    ((cyc)localObject).HIt = localclx;
    ((cyc)localObject).Scene = 1;
    ((cyc)localObject).HIu = -10000.0F;
    ((cyc)localObject).HIv = -10000.0F;
    this.msgId = paramLong;
    AppMethodBeat.o(150940);
  }
  
  public x(cyc paramcyc)
  {
    AppMethodBeat.i(150941);
    this.ipr = 60000L;
    this.msgId = -1L;
    b.a locala = new b.a();
    locala.hQF = paramcyc;
    locala.hQG = new cyd();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(150941);
  }
  
  public static String GR(String paramString)
  {
    AppMethodBeat.i(150945);
    paramString = bx.M(paramString, "streetview");
    if (paramString == null)
    {
      AppMethodBeat.o(150945);
      return null;
    }
    paramString = (String)paramString.get(".streetview.link");
    AppMethodBeat.o(150945);
    return paramString;
  }
  
  public final cyd aLy()
  {
    if ((this.rr != null) && (this.rr.hQE.hQJ != null)) {
      return (cyd)this.rr.hQE.hQJ;
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
    ae.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { aLy().GXm });
      if (this.ips != null) {
        this.ips.run();
      }
      AppMethodBeat.o(150944);
      return;
      ae.e("MicroMsg.NetSceneScanStreetView", "callback null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(150943);
    if (((cyc)((b)paramq).hQD.hQJ).HIt == null)
    {
      ae.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      paramq = n.b.hRj;
      AppMethodBeat.o(150943);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(150943);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */