package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private g callback;
  public String content;
  public int hll;
  private b rr;
  public String title;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(20543);
    this.title = "";
    this.content = "";
    this.hll = 0;
    b.a locala = new b.a();
    locala.gUU = new ave();
    locala.gUV = new avf();
    locala.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
    locala.funcId = 1803;
    this.rr = locala.atI();
    ((ave)this.rr.gUS.gUX).DuF = paramInt;
    this.hll = paramInt;
    AppMethodBeat.o(20543);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(20545);
    ad.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
    this.callback = paramg;
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
      paramq = (avf)this.rr.gUT.gUX;
      this.title = paramq.DuG;
      this.content = paramq.DuH;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20544);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.e
 * JD-Core Version:    0.7.0.1
 */