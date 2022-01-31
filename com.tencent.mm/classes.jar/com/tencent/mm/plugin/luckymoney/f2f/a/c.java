package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends com.tencent.mm.ai.m
  implements k
{
  public int cMQ;
  private f callback;
  public int cpX;
  private b goo;
  public String ojA;
  private abg okD;
  private abh okE;
  public int okF;
  public String okG;
  public int okH;
  public bry okI;
  public int okJ;
  public String okK;
  public String okL;
  public String okM;
  public int okN;
  
  public c(String paramString)
  {
    AppMethodBeat.i(42151);
    b.a locala = new b.a();
    locala.fsX = new abg();
    locala.fsY = new abh();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.goo = locala.ado();
    this.okD = ((abg)this.goo.fsV.fta);
    this.okD.lHq = paramString;
    paramString = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    if (paramString != null)
    {
      this.okD.city = paramString.city;
      this.okD.province = paramString.province;
      this.okD.wRH = paramString.wmQ;
      this.okD.wRI = paramString.wmR;
      this.okD.wRJ = paramString.wmP;
      this.okD.wRK = paramString.latitude;
      this.okD.wRL = paramString.longitude;
    }
    AppMethodBeat.o(42151);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(42153);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(42153);
    return i;
  }
  
  public final int getType()
  {
    return 1997;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42152);
    this.okE = ((abh)((b)paramq).fsW.fta);
    ab.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.okE.cnK), this.okE.kNv });
    this.ojA = this.okE.ojA;
    this.cMQ = this.okE.cMQ;
    this.okF = this.okE.cMR;
    this.cpX = this.okE.cpX;
    this.okG = this.okE.onN;
    this.okH = this.okE.okH;
    this.okI = this.okE.wIk;
    this.okJ = this.okE.okJ;
    this.okK = this.okE.okK;
    this.okL = this.okE.okL;
    this.okM = this.okE.okM;
    this.okN = this.okE.okN;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.okE.cnK, this.okE.kNv, this);
    }
    AppMethodBeat.o(42152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */