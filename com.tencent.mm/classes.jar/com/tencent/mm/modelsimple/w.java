package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class w
  extends n
  implements k
{
  private g callback;
  public int errCode;
  public int errType;
  private final long hsE;
  private Runnable hsF;
  public long msgId;
  public b rr;
  
  public w(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(150940);
    this.hsE = 60000L;
    this.msgId = -1L;
    cbe localcbe = new cbe();
    localcbe.COI = paramFloat1;
    localcbe.COJ = paramFloat2;
    localcbe.DfH = 1;
    localcbe.DfE = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cmu();
    ((b.a)localObject).gUV = new cmv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((b.a)localObject).funcId = 424;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cmu)this.rr.gUS.gUX;
    ((cmu)localObject).EhD = localcbe;
    ((cmu)localObject).Scene = 1;
    ((cmu)localObject).EhE = -10000.0F;
    ((cmu)localObject).EhF = -10000.0F;
    this.msgId = paramLong;
    AppMethodBeat.o(150940);
  }
  
  public w(cmu paramcmu)
  {
    AppMethodBeat.i(150941);
    this.hsE = 60000L;
    this.msgId = -1L;
    b.a locala = new b.a();
    locala.gUU = paramcmu;
    locala.gUV = new cmv();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(150941);
  }
  
  public static String zf(String paramString)
  {
    AppMethodBeat.i(150945);
    paramString = bw.K(paramString, "streetview");
    if (paramString == null)
    {
      AppMethodBeat.o(150945);
      return null;
    }
    paramString = (String)paramString.get(".streetview.link");
    AppMethodBeat.o(150945);
    return paramString;
  }
  
  public final cmv aBa()
  {
    if ((this.rr != null) && (this.rr.gUT.gUX != null)) {
      return (cmv)this.rr.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150942);
    this.callback = paramg;
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
      ad.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { aBa().DyQ });
      if (this.hsF != null) {
        this.hsF.run();
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
    if (((cmu)((b)paramq).gUS.gUX).EhD == null)
    {
      ad.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      paramq = n.b.gVC;
      AppMethodBeat.o(150943);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(150943);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */