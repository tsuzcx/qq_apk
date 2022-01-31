package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bwr;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class w
  extends m
  implements k
{
  private f callback;
  public long cpO;
  public int errCode;
  public int errType;
  private final long fPZ;
  private Runnable fQa;
  public b rr;
  
  public w(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(78588);
    this.fPZ = 60000L;
    this.cpO = -1L;
    bmw localbmw = new bmw();
    localbmw.wDh = paramFloat1;
    localbmw.wDi = paramFloat2;
    localbmw.wSn = 1;
    localbmw.wSk = 0;
    a(localbmw, 1, -10000.0F, -10000.0F);
    this.cpO = paramLong;
    AppMethodBeat.o(78588);
  }
  
  public w(bmw parambmw, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(78590);
    this.fPZ = 60000L;
    this.cpO = -1L;
    a(parambmw, 0, paramFloat1, paramFloat2);
    AppMethodBeat.o(78590);
  }
  
  public w(bwr parambwr)
  {
    AppMethodBeat.i(78589);
    this.fPZ = 60000L;
    this.cpO = -1L;
    b.a locala = new b.a();
    locala.fsX = parambwr;
    locala.fsY = new bws();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(78589);
  }
  
  private void a(bmw parambmw, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(78591);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bwr();
    ((b.a)localObject).fsY = new bws();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((b.a)localObject).funcId = 424;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bwr)this.rr.fsV.fta;
    ((bwr)localObject).xJU = parambmw;
    ((bwr)localObject).Scene = paramInt;
    ((bwr)localObject).xJV = paramFloat1;
    ((bwr)localObject).xJW = paramFloat2;
    AppMethodBeat.o(78591);
  }
  
  public static String us(String paramString)
  {
    AppMethodBeat.i(78595);
    paramString = br.F(paramString, "streetview");
    if (paramString == null)
    {
      AppMethodBeat.o(78595);
      return null;
    }
    paramString = (String)paramString.get(".streetview.link");
    AppMethodBeat.o(78595);
    return paramString;
  }
  
  public final bws ajW()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (bws)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78592);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78592);
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
    AppMethodBeat.i(78594);
    ab.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    for (;;)
    {
      ab.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { ajW().wzV });
      if (this.fQa != null) {
        this.fQa.run();
      }
      AppMethodBeat.o(78594);
      return;
      ab.e("MicroMsg.NetSceneScanStreetView", "callback null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(78593);
    if (((bwr)((b)paramq).fsV.fta).xJU == null)
    {
      ab.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      paramq = m.b.ftv;
      AppMethodBeat.o(78593);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(78593);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */