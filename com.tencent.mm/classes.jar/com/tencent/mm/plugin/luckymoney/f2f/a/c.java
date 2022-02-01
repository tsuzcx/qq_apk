package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  public int dBA;
  public int dcp;
  private b gvE;
  public String uhB;
  private afx uiG;
  private afy uiH;
  public int uiI;
  public String uiJ;
  public int uiK;
  public cma uiL;
  public int uiM;
  public String uiN;
  public String uiO;
  public String uiP;
  public int uiQ;
  public String uiR;
  public String uiS;
  
  public c(String paramString)
  {
    AppMethodBeat.i(65041);
    b.a locala = new b.a();
    locala.hvt = new afx();
    locala.hvu = new afy();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.gvE = locala.aAz();
    this.uiG = ((afx)this.gvE.hvr.hvw);
    this.uiG.pBl = paramString;
    paramString = com.tencent.mm.plugin.wallet_core.model.k.ero();
    if (paramString != null)
    {
      this.uiG.exW = paramString.exW;
      this.uiG.exV = paramString.exV;
      this.uiG.Eyf = paramString.DNA;
      this.uiG.Eyg = paramString.DNB;
      this.uiG.Eyh = paramString.DNz;
      this.uiG.Eyi = paramString.latitude;
      this.uiG.Eyj = paramString.longitude;
    }
    AppMethodBeat.o(65041);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65043);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    this.uiH = ((afy)((b)paramq).hvs.hvw);
    ac.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.uiH.dae), this.uiH.oxf });
    this.uhB = this.uiH.uhB;
    this.dBA = this.uiH.dBA;
    this.uiI = this.uiH.dBB;
    this.dcp = this.uiH.dcp;
    this.uiJ = this.uiH.ulT;
    this.uiK = this.uiH.uiK;
    this.uiL = this.uiH.EmH;
    this.uiM = this.uiH.uiM;
    this.uiN = this.uiH.uiN;
    this.uiO = this.uiH.uiO;
    this.uiP = this.uiH.uiP;
    this.uiQ = this.uiH.uiQ;
    this.uiR = this.uiH.uiR;
    this.uiS = this.uiH.uiS;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.uiH.dae, this.uiH.oxf, this);
    }
    AppMethodBeat.o(65042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */