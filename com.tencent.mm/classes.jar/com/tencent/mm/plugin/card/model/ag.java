package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.sdk.platformtools.ac;

public final class ag
  extends n
  implements k
{
  private g callback;
  public String content;
  public String dtD;
  public String jBX;
  public String nWQ;
  public String nWR;
  public boolean nWS;
  public String nWT;
  public String nWU;
  public String nWV;
  public String nWW;
  private final b rr;
  public int status;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112855);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cgk();
    ((b.a)localObject).hvu = new cgl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((b.a)localObject).funcId = 1171;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cgk)this.rr.hvr.hvw;
    ((cgk)localObject).DMq = paramInt;
    ((cgk)localObject).DMr = paramString1;
    ((cgk)localObject).DMs = paramString2;
    AppMethodBeat.o(112855);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112857);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cgl)this.rr.hvs.hvw;
      this.dtD = paramq.DMv;
      this.nWQ = paramq.DMw;
      this.status = paramq.status;
      this.content = paramq.content;
      this.nWR = paramq.nWi;
      this.jBX = paramq.FnQ;
      this.nWS = paramq.nWS;
      this.nWT = paramq.Fut;
      this.nWU = paramq.Fuu;
      this.nWV = paramq.Fuv;
      this.nWW = paramq.Fuw;
      ac.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.dtD, this.nWQ, Integer.valueOf(this.status), this.content, this.nWR, this.jBX, Boolean.valueOf(this.nWS) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */