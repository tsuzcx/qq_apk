package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  public int dDO;
  public int deV;
  private b iaa;
  public String sZn;
  public String taA;
  public int taB;
  public String taC;
  public String taD;
  private aey tar;
  private aez tas;
  public int tat;
  public String tau;
  public int tav;
  public cgx taw;
  public int tax;
  public String tay;
  public String taz;
  
  public c(String paramString)
  {
    AppMethodBeat.i(65041);
    b.a locala = new b.a();
    locala.gUU = new aey();
    locala.gUV = new aez();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.iaa = locala.atI();
    this.tar = ((aey)this.iaa.gUS.gUX);
    this.tar.oYa = paramString;
    paramString = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    if (paramString != null)
    {
      this.tar.evA = paramString.evA;
      this.tar.evz = paramString.evz;
      this.tar.DeZ = paramString.Cvf;
      this.tar.Dfa = paramString.Cvg;
      this.tar.Dfb = paramString.Cve;
      this.tar.Dfc = paramString.latitude;
      this.tar.Dfd = paramString.longitude;
    }
    AppMethodBeat.o(65041);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65043);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(65043);
    return i;
  }
  
  public final int getType()
  {
    return 1997;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65042);
    this.tas = ((aez)((b)paramq).gUT.gUX);
    ad.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.tas.dcG), this.tas.nTK });
    this.sZn = this.tas.sZn;
    this.dDO = this.tas.dDO;
    this.tat = this.tas.dDP;
    this.deV = this.tas.deV;
    this.tau = this.tas.tdE;
    this.tav = this.tas.tav;
    this.taw = this.tas.CTW;
    this.tax = this.tas.tax;
    this.tay = this.tas.tay;
    this.taz = this.tas.taz;
    this.taA = this.tas.taA;
    this.taB = this.tas.taB;
    this.taC = this.tas.taC;
    this.taD = this.tas.taD;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.tas.dcG, this.tas.nTK, this);
    }
    AppMethodBeat.o(65042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */