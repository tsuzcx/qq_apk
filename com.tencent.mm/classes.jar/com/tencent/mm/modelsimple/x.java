package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dmy;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class x
  extends q
  implements m
{
  private i callback;
  public int errCode;
  public int errType;
  private Runnable maA;
  private final long maz;
  public long msgId;
  public d rr;
  
  public x(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(150940);
    this.maz = 60000L;
    this.msgId = -1L;
    dmy localdmy = new dmy();
    localdmy.ScO = paramFloat1;
    localdmy.ScP = paramFloat2;
    localdmy.Sxw = 1;
    localdmy.Sxt = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eat();
    ((d.a)localObject).lBV = new eau();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((d.a)localObject).funcId = 424;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (eat)d.b.b(this.rr.lBR);
    ((eat)localObject).UfN = localdmy;
    ((eat)localObject).CPw = 1;
    ((eat)localObject).UfO = -10000.0F;
    ((eat)localObject).UfP = -10000.0F;
    this.msgId = paramLong;
    AppMethodBeat.o(150940);
  }
  
  public x(eat parameat)
  {
    AppMethodBeat.i(150941);
    this.maz = 60000L;
    this.msgId = -1L;
    d.a locala = new d.a();
    locala.lBU = parameat;
    locala.lBV = new eau();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(150941);
  }
  
  public static String Xc(String paramString)
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
  
  public static int arZ()
  {
    return 424;
  }
  
  public final eau boR()
  {
    AppMethodBeat.i(205252);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      eau localeau = (eau)d.c.b(this.rr.lBS);
      AppMethodBeat.o(205252);
      return localeau;
    }
    AppMethodBeat.o(205252);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150942);
    this.callback = parami;
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
      Log.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { boR().Tlx });
      if (this.maA != null) {
        this.maA.run();
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
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(150943);
    if (((eat)d.b.b(((d)params).lBR)).UfN == null)
    {
      Log.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      params = q.b.lCy;
      AppMethodBeat.o(150943);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(150943);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */