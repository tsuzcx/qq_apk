package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private amm EvG;
  public amn EvH;
  public int EvI;
  public dtj EvJ;
  public int EvK;
  public String EvL;
  public String EvM;
  public String EvN;
  public int EvO;
  public String EvP;
  public String EvQ;
  public int amount;
  private i callback;
  public int fyO;
  public int gbp;
  public String gby;
  private d kwO;
  public String ybP;
  
  public c(String paramString)
  {
    AppMethodBeat.i(65041);
    d.a locala = new d.a();
    locala.lBU = new amm();
    locala.lBV = new amn();
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.kwO = locala.bgN();
    this.EvG = ((amm)d.b.b(this.kwO.lBR));
    this.EvG.vhY = paramString;
    paramString = k.gJe();
    if (paramString != null)
    {
      this.EvG.city = paramString.city;
      this.EvG.province = paramString.province;
      this.EvG.SwL = paramString.RFV;
      this.EvG.SwM = paramString.RFW;
      this.EvG.SwN = paramString.RFU;
      this.EvG.SwO = paramString.latitude;
      this.EvG.SwP = paramString.longitude;
    }
    AppMethodBeat.o(65041);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65043);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(65043);
    return i;
  }
  
  public final int getType()
  {
    return 1997;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65042);
    this.EvH = ((amn)d.c.b(((d)params).lBS));
    Log.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.EvH.fwx), this.EvH.tVo });
    this.ybP = this.EvH.ybP;
    this.gbp = this.EvH.gbp;
    this.EvI = this.EvH.gbq;
    this.fyO = this.EvH.fyO;
    this.gby = this.EvH.Ezw;
    this.amount = this.EvH.amount;
    this.EvJ = this.EvH.Sih;
    this.EvK = this.EvH.EvK;
    this.EvL = this.EvH.EvL;
    this.EvM = this.EvH.EvM;
    this.EvN = this.EvH.EvN;
    this.EvO = this.EvH.EvO;
    this.EvP = this.EvH.EvP;
    this.EvQ = this.EvH.EvQ;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.EvH.fwx, this.EvH.tVo, this);
    }
    AppMethodBeat.o(65042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */