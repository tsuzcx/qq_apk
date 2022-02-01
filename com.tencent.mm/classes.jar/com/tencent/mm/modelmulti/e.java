package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n
  implements k
{
  private g callback;
  public String content;
  public int hLO;
  private b rr;
  public String title;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(20543);
    this.title = "";
    this.content = "";
    this.hLO = 0;
    b.a locala = new b.a();
    locala.hvt = new ayk();
    locala.hvu = new ayl();
    locala.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
    locala.funcId = 1803;
    this.rr = locala.aAz();
    ((ayk)this.rr.hvr.hvw).EPO = paramInt;
    this.hLO = paramInt;
    AppMethodBeat.o(20543);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(20545);
    ac.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
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
    ac.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ayl)this.rr.hvs.hvw;
      this.title = paramq.EPP;
      this.content = paramq.EPQ;
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