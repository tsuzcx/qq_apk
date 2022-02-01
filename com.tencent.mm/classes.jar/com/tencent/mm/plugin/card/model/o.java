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
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends n
  implements k
{
  private g callback;
  public String nWw;
  public int nWx;
  public String nWy;
  private final b rr;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, dcq paramdcq)
  {
    AppMethodBeat.i(112799);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ak();
    ((b.a)localObject).hvu = new al();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((b.a)localObject).funcId = 1037;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ak)this.rr.hvr.hvw;
    ((ak)localObject).dvO = paramString1;
    ((ak)localObject).nVI = paramString2;
    ((ak)localObject).dvQ = paramInt1;
    ((ak)localObject).dvP = paramString3;
    ((ak)localObject).DMl = paramString4;
    ((ak)localObject).DMk = paramString5;
    ((ak)localObject).DMm = paramInt2;
    ((ak)localObject).DMn = paramInt3;
    ((ak)localObject).DMo = paramdcq;
    AppMethodBeat.o(112799);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112800);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (al)this.rr.hvs.hvw;
      if (paramq != null)
      {
        this.nWw = paramq.nWw;
        this.nWx = paramq.nWx;
        this.nWy = paramq.nWy;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112801);
      return;
      paramq = (al)this.rr.hvs.hvw;
      if (paramq != null)
      {
        this.nWw = paramq.nWw;
        this.nWx = paramq.nWx;
        this.nWy = paramq.nWy;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */