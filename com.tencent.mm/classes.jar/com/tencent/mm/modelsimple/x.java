package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.dqy;
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
  private final long jky;
  private Runnable jkz;
  public long msgId;
  public d rr;
  
  public x(float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(150940);
    this.jky = 60000L;
    this.msgId = -1L;
    ddi localddi = new ddi();
    localddi.LbC = paramFloat1;
    localddi.LbD = paramFloat2;
    localddi.LuW = 1;
    localddi.LuT = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dqx();
    ((d.a)localObject).iLO = new dqy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((d.a)localObject).funcId = 424;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dqx)this.rr.iLK.iLR;
    ((dqx)localObject).MTE = localddi;
    ((dqx)localObject).Scene = 1;
    ((dqx)localObject).MTF = -10000.0F;
    ((dqx)localObject).MTG = -10000.0F;
    this.msgId = paramLong;
    AppMethodBeat.o(150940);
  }
  
  public x(dqx paramdqx)
  {
    AppMethodBeat.i(150941);
    this.jky = 60000L;
    this.msgId = -1L;
    d.a locala = new d.a();
    locala.iLN = paramdqx;
    locala.iLO = new dqy();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.funcId = 424;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(150941);
  }
  
  public static String PE(String paramString)
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
  
  public final dqy bfB()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (dqy)this.rr.iLL.iLR;
    }
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
      Log.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { bfB().MbV });
      if (this.jkz != null) {
        this.jkz.run();
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
    if (((dqx)((d)params).iLK.iLR).MTE == null)
    {
      Log.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      params = q.b.iMr;
      AppMethodBeat.o(150943);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(150943);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */