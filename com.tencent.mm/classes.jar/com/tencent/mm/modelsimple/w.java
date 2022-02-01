package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class w
  extends n
  implements k
{
  private g callback;
  public int errCode;
  public int errType;
  private final long hTg;
  private Runnable hTh;
  public long msgId;
  public b rr;
  
  public w(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(150940);
    this.hTg = 60000L;
    this.msgId = -1L;
    cge localcge = new cge();
    localcge.Eht = paramFloat1;
    localcge.Ehu = paramFloat2;
    localcge.EyN = 1;
    localcge.EyK = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new csb();
    ((b.a)localObject).hvu = new csc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((b.a)localObject).funcId = 424;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (csb)this.rr.hvr.hvw;
    ((csb)localObject).FEC = localcge;
    ((csb)localObject).Scene = 1;
    ((csb)localObject).FED = -10000.0F;
    ((csb)localObject).FEE = -10000.0F;
    this.msgId = paramLong;
    AppMethodBeat.o(150940);
  }
  
  public w(csb paramcsb)
  {
    AppMethodBeat.i(150941);
    this.hTg = 60000L;
    this.msgId = -1L;
    b.a locala = new b.a();
    locala.hvt = paramcsb;
    locala.hvu = new csc();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(150941);
  }
  
  public static String Dk(String paramString)
  {
    AppMethodBeat.i(150945);
    paramString = bv.L(paramString, "streetview");
    if (paramString == null)
    {
      AppMethodBeat.o(150945);
      return null;
    }
    paramString = (String)paramString.get(".streetview.link");
    AppMethodBeat.o(150945);
    return paramString;
  }
  
  public final csc aHQ()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (csc)this.rr.hvs.hvw;
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
    ac.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { aHQ().EUm });
      if (this.hTh != null) {
        this.hTh.run();
      }
      AppMethodBeat.o(150944);
      return;
      ac.e("MicroMsg.NetSceneScanStreetView", "callback null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(150943);
    if (((csb)((b)paramq).hvr.hvw).FEC == null)
    {
      ac.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      paramq = n.b.hwb;
      AppMethodBeat.o(150943);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(150943);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */