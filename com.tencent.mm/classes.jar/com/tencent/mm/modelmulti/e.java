package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private f callback;
  public String content;
  public int ieI;
  private b rr;
  public String title;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(20543);
    this.title = "";
    this.content = "";
    this.ieI = 0;
    b.a locala = new b.a();
    locala.hNM = new bco();
    locala.hNN = new bcp();
    locala.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
    locala.funcId = 1803;
    this.rr = locala.aDC();
    ((bco)this.rr.hNK.hNQ).Gzf = paramInt;
    this.ieI = paramInt;
    AppMethodBeat.o(20543);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(20545);
    ad.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20545);
    return i;
  }
  
  public final int getType()
  {
    return 1803;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20544);
    ad.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bcp)this.rr.hNL.hNQ;
      this.title = paramq.Gzg;
      this.content = paramq.Gzh;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20544);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.e
 * JD-Core Version:    0.7.0.1
 */