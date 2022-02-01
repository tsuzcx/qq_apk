package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends q
  implements m
{
  public static int keX = 0;
  public static int keY = 1;
  public static int keZ = -85;
  private i callback;
  private int kfa;
  private String kfb;
  private int kfc;
  private final d rr;
  
  public x(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(131086);
    this.kfa = -1;
    this.kfc = 0;
    switch (1.kfd[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.kfb = paramString;
      this.kfc = paramInt;
      parama = new d.a();
      parama.iLN = new lz();
      parama.iLO = new ma();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.funcId = 487;
      parama.iLP = 0;
      parama.respCmdId = 0;
      this.rr = parama.aXF();
      AppMethodBeat.o(131086);
      return;
      this.kfa = 1;
      continue;
      this.kfa = 2;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131087);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = parami;
    parami = (lz)this.rr.iLK.iLR;
    parami.KMz = this.kfa;
    parami.KPA = this.kfb;
    parami.KPB = this.kfc;
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
      kfe = new a("MM_BIND_GCONTACT_OPCODE_BIND", 0);
      kff = new a("MM_BIND_GCONTACT_OPCODE_UNBIND", 1);
      kfg = new a[] { kfe, kff };
      AppMethodBeat.o(131085);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.x
 * JD-Core Version:    0.7.0.1
 */