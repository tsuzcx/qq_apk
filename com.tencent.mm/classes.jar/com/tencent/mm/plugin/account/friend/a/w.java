package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.ab;

public final class w
  extends m
  implements k
{
  public static int gxN = 0;
  public static int gxO = 1;
  public static int gxP = -85;
  private f callback;
  private int gxQ;
  private String gxR;
  private int gxS;
  private final b rr;
  
  public w(w.a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(108425);
    this.gxQ = -1;
    this.gxS = 0;
    switch (w.1.gxT[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.gxR = paramString;
      this.gxS = paramInt;
      parama = new b.a();
      parama.fsX = new jm();
      parama.fsY = new jn();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.funcId = 487;
      parama.reqCmdId = 0;
      parama.respCmdId = 0;
      this.rr = parama.ado();
      AppMethodBeat.o(108425);
      return;
      this.gxQ = 1;
      continue;
      this.gxQ = 2;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108426);
    ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (jm)this.rr.fsV.fta;
    paramf.wsW = this.gxQ;
    paramf.wvt = this.gxR;
    paramf.wvu = this.gxS;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108426);
    return i;
  }
  
  public final int getType()
  {
    return 487;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108427);
    ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.w
 * JD-Core Version:    0.7.0.1
 */