package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.euc;
import com.tencent.mm.protocal.protobuf.eud;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class y
  extends p
  implements m
{
  private h callback;
  public int errCode;
  public int errType;
  public long msgId;
  private final long oTp;
  private Runnable oTq;
  public c rr;
  
  public y(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(150940);
    this.oTp = 60000L;
    this.msgId = -1L;
    efm localefm = new efm();
    localefm.ZaG = paramFloat1;
    localefm.ZaH = paramFloat2;
    localefm.Zyo = 1;
    localefm.Zyl = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new euc();
    ((c.a)localObject).otF = new eud();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((c.a)localObject).funcId = 424;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (euc)c.b.b(this.rr.otB);
    ((euc)localObject).abxd = localefm;
    ((euc)localObject).IJG = 1;
    ((euc)localObject).abxe = -10000.0F;
    ((euc)localObject).abxf = -10000.0F;
    this.msgId = paramLong;
    AppMethodBeat.o(150940);
  }
  
  public y(euc parameuc)
  {
    AppMethodBeat.i(150941);
    this.oTp = 60000L;
    this.msgId = -1L;
    c.a locala = new c.a();
    locala.otE = parameuc;
    locala.otF = new eud();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(150941);
  }
  
  public static String Pc(String paramString)
  {
    AppMethodBeat.i(150945);
    paramString = XmlParser.parseXml(paramString, "streetview", null);
    if (paramString == null)
    {
      AppMethodBeat.o(150945);
      return null;
    }
    paramString = (String)paramString.get(".streetview.link");
    AppMethodBeat.o(150945);
    return paramString;
  }
  
  public static int aLV()
  {
    return 424;
  }
  
  public final eud bMy()
  {
    AppMethodBeat.i(236754);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      eud localeud = (eud)c.c.b(this.rr.otC);
      AppMethodBeat.o(236754);
      return localeud;
    }
    AppMethodBeat.o(236754);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150942);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150944);
    Log.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { bMy().aazh });
      if (this.oTq != null) {
        this.oTq.run();
      }
      AppMethodBeat.o(150944);
      return;
      Log.e("MicroMsg.NetSceneScanStreetView", "callback null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(150943);
    if (((euc)c.b.b(((c)params).otB)).abxd == null)
    {
      Log.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      params = p.b.oui;
      AppMethodBeat.o(150943);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(150943);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */