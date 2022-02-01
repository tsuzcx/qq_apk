package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class c
  extends w
{
  public String CAf;
  private aqe Koo;
  public aqf Kop;
  public int Koq;
  public eme Kor;
  public int Kos;
  public String Kot;
  public String Kou;
  public String Kov;
  public int Kow;
  public String Kox;
  public String Koy;
  public b Koz;
  public int amount;
  private h callback;
  public int hDx;
  public String ihI;
  public int ihz;
  private com.tencent.mm.am.c nao;
  
  public c(String paramString)
  {
    this(paramString, null);
    AppMethodBeat.i(65041);
    AppMethodBeat.o(65041);
  }
  
  public c(String paramString, b paramb)
  {
    AppMethodBeat.i(283850);
    c.a locala = new c.a();
    locala.otE = new aqe();
    locala.otF = new aqf();
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.nao = locala.bEF();
    this.Koo = ((aqe)c.b.b(this.nao.otB));
    this.Koo.ytZ = paramString;
    this.Koo.Zxz = paramb;
    paramString = k.iis();
    if (paramString != null)
    {
      this.Koo.city = paramString.city;
      this.Koo.province = paramString.province;
      this.Koo.Zxu = paramString.YCJ;
      this.Koo.Zxv = paramString.YCK;
      this.Koo.Zxw = paramString.YCI;
      this.Koo.Zxx = paramString.latitude;
      this.Koo.Zxy = paramString.longitude;
    }
    AppMethodBeat.o(283850);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(65043);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(65043);
    return i;
  }
  
  public final int getType()
  {
    return 1997;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(283852);
    this.Kop = ((aqf)c.c.b(((com.tencent.mm.am.c)params).otC));
    Log.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.Kop.hAV), this.Kop.wYI });
    this.CAf = this.Kop.CAf;
    this.ihz = this.Kop.ihz;
    this.Koq = this.Kop.ihA;
    this.hDx = this.Kop.hDx;
    this.ihI = this.Kop.Ksi;
    this.amount = this.Kop.amount;
    this.Kor = this.Kop.Zgn;
    this.Kos = this.Kop.Kos;
    this.Kot = this.Kop.Kot;
    this.Kou = this.Kop.Kou;
    this.Kov = this.Kop.Kov;
    this.Kow = this.Kop.Kow;
    this.Kox = this.Kop.Kox;
    this.Koy = this.Kop.Koy;
    this.Koz = this.Kop.Zxz;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.Kop.hAV, this.Kop.wYI, this);
    }
    AppMethodBeat.o(283852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */