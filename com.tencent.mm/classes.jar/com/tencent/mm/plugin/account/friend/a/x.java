package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.ae;

public final class x
  extends n
  implements k
{
  public static int jgT = 0;
  public static int jgU = 1;
  public static int jgV = -85;
  private f callback;
  private int jgW;
  private String jgX;
  private int jgY;
  private final b rr;
  
  public x(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(131086);
    this.jgW = -1;
    this.jgY = 0;
    switch (1.jgZ[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.jgX = paramString;
      this.jgY = paramInt;
      parama = new b.a();
      parama.hQF = new li();
      parama.hQG = new lj();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.funcId = 487;
      parama.hQH = 0;
      parama.respCmdId = 0;
      this.rr = parama.aDS();
      AppMethodBeat.o(131086);
      return;
      this.jgW = 1;
      continue;
      this.jgW = 2;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131087);
    ae.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (li)this.rr.hQD.hQJ;
    paramf.FSQ = this.jgW;
    paramf.FVP = this.jgX;
    paramf.FVQ = this.jgY;
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
    ae.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131088);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131085);
      jha = new a("MM_BIND_GCONTACT_OPCODE_BIND", 0);
      jhb = new a("MM_BIND_GCONTACT_OPCODE_UNBIND", 1);
      jhc = new a[] { jha, jhb };
      AppMethodBeat.o(131085);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.x
 * JD-Core Version:    0.7.0.1
 */