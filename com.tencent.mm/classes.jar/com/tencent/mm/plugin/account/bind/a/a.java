package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class a
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(109742);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new md();
    ((d.a)localObject).iLO = new me();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (md)this.rr.iLK.iLR;
    ((md)localObject).KMz = 1;
    ((md)localObject).KPF = paramInt;
    ((md)localObject).KPG = paramString1;
    ((md)localObject).KPH = paramString2;
    ((md)localObject).KPI = paramString3;
    ((md)localObject).KPJ = paramString4;
    ((md)localObject).KPK = paramString5;
    ((md)localObject).KPL = paramString6;
    ((md)localObject).KPM = paramString7;
    AppMethodBeat.o(109742);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(109743);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(109743);
    return i;
  }
  
  public final int getType()
  {
    return 549;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109744);
    Log.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (md)this.rr.iLK.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(286722, params.KPH);
      com.tencent.mm.kernel.g.aAh().azQ().set(286721, params.KPG);
      com.tencent.mm.kernel.g.aAh().azQ().set(286723, params.KPI);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */