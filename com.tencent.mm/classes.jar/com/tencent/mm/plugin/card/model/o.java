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
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.sdk.platformtools.ae;

public final class o
  extends n
  implements k
{
  private f callback;
  public String oGs;
  public int oGt;
  public String oGu;
  private final b rr;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, diy paramdiy)
  {
    AppMethodBeat.i(112799);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ak();
    ((b.a)localObject).hQG = new al();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((b.a)localObject).funcId = 1037;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ak)this.rr.hQD.hQJ;
    ((ak)localObject).dJb = paramString1;
    ((ak)localObject).oBM = paramString2;
    ((ak)localObject).dJd = paramInt1;
    ((ak)localObject).dJc = paramString3;
    ((ak)localObject).FJO = paramString4;
    ((ak)localObject).FJN = paramString5;
    ((ak)localObject).FJP = paramInt2;
    ((ak)localObject).FJQ = paramInt3;
    ((ak)localObject).FJR = paramdiy;
    AppMethodBeat.o(112799);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112800);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112800);
    return i;
  }
  
  public final int getType()
  {
    return 1037;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112801);
    ae.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (al)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        this.oGs = paramq.oGs;
        this.oGt = paramq.oGt;
        this.oGu = paramq.oGu;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112801);
      return;
      paramq = (al)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        this.oGs = paramq.oGs;
        this.oGt = paramq.oGt;
        this.oGu = paramq.oGu;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */