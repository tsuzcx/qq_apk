package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  public int dNN;
  public int dnL;
  private b gPp;
  public String vkl;
  public String vlA;
  private ain vlo;
  private aio vlp;
  public int vlq;
  public String vlr;
  public int vls;
  public cra vlt;
  public int vlu;
  public String vlv;
  public String vlw;
  public String vlx;
  public int vly;
  public String vlz;
  
  public c(String paramString)
  {
    AppMethodBeat.i(65041);
    b.a locala = new b.a();
    locala.hNM = new ain();
    locala.hNN = new aio();
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.gPp = locala.aDC();
    this.vlo = ((ain)this.gPp.hNK.hNQ);
    this.vlo.qeQ = paramString;
    paramString = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    if (paramString != null)
    {
      this.vlo.ePv = paramString.ePv;
      this.vlo.ePu = paramString.ePu;
      this.vlo.GfR = paramString.FsF;
      this.vlo.GfS = paramString.FsG;
      this.vlo.GfT = paramString.FsE;
      this.vlo.GfU = paramString.latitude;
      this.vlo.GfV = paramString.longitude;
    }
    AppMethodBeat.o(65041);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65043);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    this.vlp = ((aio)((b)paramq).hNL.hNQ);
    ad.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.vlp.dlw), this.vlp.paA });
    this.vkl = this.vlp.vkl;
    this.dNN = this.vlp.dNN;
    this.vlq = this.vlp.dNO;
    this.dnL = this.vlp.dnL;
    this.vlr = this.vlp.voz;
    this.vls = this.vlp.vls;
    this.vlt = this.vlp.FTQ;
    this.vlu = this.vlp.vlu;
    this.vlv = this.vlp.vlv;
    this.vlw = this.vlp.vlw;
    this.vlx = this.vlp.vlx;
    this.vly = this.vlp.vly;
    this.vlz = this.vlp.vlz;
    this.vlA = this.vlp.vlA;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vlp.dlw, this.vlp.paA, this);
    }
    AppMethodBeat.o(65042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */