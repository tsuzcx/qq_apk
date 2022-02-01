package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.sdk.platformtools.ae;

public final class ag
  extends n
  implements k
{
  private f callback;
  public String content;
  public String dGJ;
  public String jZm;
  public String oGM;
  public String oGN;
  public boolean oGO;
  public String oGP;
  public String oGQ;
  public String oGR;
  public String oGS;
  private final b rr;
  public int status;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112855);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cmd();
    ((b.a)localObject).hQG = new cme();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((b.a)localObject).funcId = 1171;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cmd)this.rr.hQD.hQJ;
    ((cmd)localObject).FJT = paramInt;
    ((cmd)localObject).FJU = paramString1;
    ((cmd)localObject).FJV = paramString2;
    AppMethodBeat.o(112855);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112857);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112857);
    return i;
  }
  
  public final int getType()
  {
    return 1171;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112856);
    ae.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cme)this.rr.hQE.hQJ;
      this.dGJ = paramq.FJY;
      this.oGM = paramq.FJZ;
      this.status = paramq.status;
      this.content = paramq.content;
      this.oGN = paramq.oGe;
      this.jZm = paramq.HqZ;
      this.oGO = paramq.oGO;
      this.oGP = paramq.HxY;
      this.oGQ = paramq.HxZ;
      this.oGR = paramq.Hya;
      this.oGS = paramq.Hyb;
      ae.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.dGJ, this.oGM, Integer.valueOf(this.status), this.content, this.oGN, this.jZm, Boolean.valueOf(this.oGO) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */