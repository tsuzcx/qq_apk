package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  public String content;
  public int jcv;
  private d rr;
  public String title;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(20543);
    this.title = "";
    this.content = "";
    this.jcv = 0;
    d.a locala = new d.a();
    locala.iLN = new bos();
    locala.iLO = new bot();
    locala.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
    locala.funcId = 1803;
    this.rr = locala.aXF();
    ((bos)this.rr.iLK.iLR).LWR = paramInt;
    this.jcv = paramInt;
    AppMethodBeat.o(20543);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20545);
    Log.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20545);
    return i;
  }
  
  public final int getType()
  {
    return 1803;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20544);
    Log.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bot)this.rr.iLL.iLR;
      this.title = params.LWS;
      this.content = params.LWT;
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