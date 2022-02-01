package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  public int dPd;
  public int doQ;
  private b gRX;
  public String vwq;
  public String vxA;
  public String vxB;
  public String vxC;
  public int vxD;
  public String vxE;
  public String vxF;
  private aix vxt;
  public aiy vxu;
  public int vxv;
  public String vxw;
  public int vxx;
  public cru vxy;
  public int vxz;
  
  public c(String paramString)
  {
    AppMethodBeat.i(65041);
    b.a locala = new b.a();
    locala.hQF = new aix();
    locala.hQG = new aiy();
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.gRX = locala.aDS();
    this.vxt = ((aix)this.gRX.hQD.hQJ);
    this.vxt.qlv = paramString;
    paramString = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    if (paramString != null)
    {
      this.vxt.eRg = paramString.eRg;
      this.vxt.eRf = paramString.eRf;
      this.vxt.Gyz = paramString.FLd;
      this.vxt.GyA = paramString.FLe;
      this.vxt.GyB = paramString.FLc;
      this.vxt.GyC = paramString.latitude;
      this.vxt.GyD = paramString.longitude;
    }
    AppMethodBeat.o(65041);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65043);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    this.vxu = ((aiy)((b)paramq).hQE.hQJ);
    ae.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.vxu.dmy), this.vxu.phe });
    this.vwq = this.vxu.vwq;
    this.dPd = this.vxu.dPd;
    this.vxv = this.vxu.dPe;
    this.doQ = this.vxu.doQ;
    this.vxw = this.vxu.vAE;
    this.vxx = this.vxu.vxx;
    this.vxy = this.vxu.Gmp;
    this.vxz = this.vxu.vxz;
    this.vxA = this.vxu.vxA;
    this.vxB = this.vxu.vxB;
    this.vxC = this.vxu.vxC;
    this.vxD = this.vxu.vxD;
    this.vxE = this.vxu.vxE;
    this.vxF = this.vxu.vxF;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vxu.dmy, this.vxu.phe, this);
    }
    AppMethodBeat.o(65042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */