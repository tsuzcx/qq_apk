package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends q
  implements m
{
  public static int mWw = 0;
  public static int mWx = 1;
  public static int mWy = -85;
  private i callback;
  private String mWA;
  private int mWB;
  private int mWz;
  private final d rr;
  
  public x(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(131086);
    this.mWz = -1;
    this.mWB = 0;
    switch (1.mWC[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.mWA = paramString;
      this.mWB = paramInt;
      parama = new d.a();
      parama.lBU = new lp();
      parama.lBV = new lq();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.funcId = 487;
      parama.lBW = 0;
      parama.respCmdId = 0;
      this.rr = parama.bgN();
      AppMethodBeat.o(131086);
      return;
      this.mWz = 1;
      continue;
      this.mWz = 2;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131087);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = parami;
    parami = (lp)d.b.b(this.rr.lBR);
    parami.RNt = this.mWz;
    parami.RQy = this.mWA;
    parami.RQz = this.mWB;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131087);
    return i;
  }
  
  public final int getType()
  {
    return 487;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131088);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131088);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131085);
      mWD = new a("MM_BIND_GCONTACT_OPCODE_BIND", 0);
      mWE = new a("MM_BIND_GCONTACT_OPCODE_UNBIND", 1);
      mWF = new a[] { mWD, mWE };
      AppMethodBeat.o(131085);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.x
 * JD-Core Version:    0.7.0.1
 */