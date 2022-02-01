package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  public int dGe;
  public int egZ;
  public String ehh;
  private d hJu;
  public String yQE;
  private all yRI;
  public alm yRJ;
  public int yRK;
  public int yRL;
  public dju yRM;
  public int yRN;
  public String yRO;
  public String yRP;
  public String yRQ;
  public int yRR;
  public String yRS;
  public String yRT;
  
  public c(String paramString)
  {
    AppMethodBeat.i(65041);
    d.a locala = new d.a();
    locala.iLN = new all();
    locala.iLO = new alm();
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.hJu = locala.aXF();
    this.yRI = ((all)this.hJu.iLK.iLR);
    this.yRI.rCq = paramString;
    paramString = k.fQy();
    if (paramString != null)
    {
      this.yRI.fuK = paramString.fuK;
      this.yRI.fuJ = paramString.fuJ;
      this.yRI.Lun = paramString.KED;
      this.yRI.Luo = paramString.KEE;
      this.yRI.Lup = paramString.KEC;
      this.yRI.Luq = paramString.latitude;
      this.yRI.Lur = paramString.longitude;
    }
    AppMethodBeat.o(65041);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65043);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
    this.yRJ = ((alm)((d)params).iLL.iLR);
    Log.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.yRJ.dDN), this.yRJ.qwn });
    this.yQE = this.yRJ.yQE;
    this.egZ = this.yRJ.egZ;
    this.yRK = this.yRJ.eha;
    this.dGe = this.yRJ.dGe;
    this.ehh = this.yRJ.yVy;
    this.yRL = this.yRJ.yRL;
    this.yRM = this.yRJ.LgT;
    this.yRN = this.yRJ.yRN;
    this.yRO = this.yRJ.yRO;
    this.yRP = this.yRJ.yRP;
    this.yRQ = this.yRJ.yRQ;
    this.yRR = this.yRJ.yRR;
    this.yRS = this.yRJ.yRS;
    this.yRT = this.yRJ.yRT;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.yRJ.dDN, this.yRJ.qwn, this);
    }
    AppMethodBeat.o(65042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */