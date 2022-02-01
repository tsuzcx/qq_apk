package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.ad;

public final class x
  extends n
  implements k
{
  public static int jea = 0;
  public static int jeb = 1;
  public static int jec = -85;
  private f callback;
  private int jed;
  private String jee;
  private int jef;
  private final b rr;
  
  public x(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(131086);
    this.jed = -1;
    this.jef = 0;
    switch (1.jeg[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.jee = paramString;
      this.jef = paramInt;
      parama = new b.a();
      parama.hNM = new li();
      parama.hNN = new lj();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.funcId = 487;
      parama.hNO = 0;
      parama.respCmdId = 0;
      this.rr = parama.aDC();
      AppMethodBeat.o(131086);
      return;
      this.jed = 1;
      continue;
      this.jed = 2;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131087);
    ad.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (li)this.rr.hNK.hNQ;
    paramf.FAt = this.jed;
    paramf.FDu = this.jee;
    paramf.FDv = this.jef;
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
      jeh = new a("MM_BIND_GCONTACT_OPCODE_BIND", 0);
      jei = new a("MM_BIND_GCONTACT_OPCODE_UNBIND", 1);
      jej = new a[] { jeh, jei };
      AppMethodBeat.o(131085);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.x
 * JD-Core Version:    0.7.0.1
 */