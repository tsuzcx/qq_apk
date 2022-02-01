package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  private f callback;
  public String content;
  public int ihA;
  private b rr;
  public String title;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(20543);
    this.title = "";
    this.content = "";
    this.ihA = 0;
    b.a locala = new b.a();
    locala.hQF = new bde();
    locala.hQG = new bdf();
    locala.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
    locala.funcId = 1803;
    this.rr = locala.aDS();
    ((bde)this.rr.hQD.hQJ).GSF = paramInt;
    this.ihA = paramInt;
    AppMethodBeat.o(20543);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(20545);
    ae.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
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
    ae.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bdf)this.rr.hQE.hQJ;
      this.title = paramq.GSG;
      this.content = paramq.GSH;
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