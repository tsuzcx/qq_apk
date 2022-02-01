package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.sdk.platformtools.ad;

public final class x
  extends n
  implements k
{
  public static int ikK = 0;
  public static int ikL = 1;
  public static int ikM = -85;
  private g callback;
  private int ikN;
  private String ikO;
  private int ikP;
  private final b rr;
  
  public x(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(131086);
    this.ikN = -1;
    this.ikP = 0;
    switch (1.ikQ[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.ikO = paramString;
      this.ikP = paramInt;
      parama = new b.a();
      parama.gUU = new ks();
      parama.gUV = new kt();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.funcId = 487;
      parama.reqCmdId = 0;
      parama.respCmdId = 0;
      this.rr = parama.atI();
      AppMethodBeat.o(131086);
      return;
      this.ikN = 1;
      continue;
      this.ikN = 2;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(131087);
    ad.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramg;
    paramg = (ks)this.rr.gUS.gUX;
    paramg.CCB = this.ikN;
    paramg.CFy = this.ikO;
    paramg.CFz = this.ikP;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131087);
    return i;
  }
  
  public final int getType()
  {
    return 487;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131088);
    ad.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131088);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131085);
      ikR = new a("MM_BIND_GCONTACT_OPCODE_BIND", 0);
      ikS = new a("MM_BIND_GCONTACT_OPCODE_UNBIND", 1);
      ikT = new a[] { ikR, ikS };
      AppMethodBeat.o(131085);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.x
 * JD-Core Version:    0.7.0.1
 */