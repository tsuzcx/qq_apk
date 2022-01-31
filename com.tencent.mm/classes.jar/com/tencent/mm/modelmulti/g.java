package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.j.a;
import org.b.d.i;

public final class g
  extends m
  implements k
{
  private f callback;
  private int fIi;
  private b rr;
  
  public g(int paramInt, String paramString)
  {
    AppMethodBeat.i(16500);
    this.fIi = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bmy();
    ((b.a)localObject).fsY = new bmz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
    ((b.a)localObject).funcId = 1804;
    this.rr = ((b.a)localObject).ado();
    bmy localbmy = (bmy)this.rr.fsV.fta;
    localbmy.xcm = paramInt;
    localbmy.xco = paramString;
    if ((paramInt & 0x10) > 0)
    {
      a locala = new a();
      localObject = new clw();
      if (locala.ABb == null) {
        break label185;
      }
      paramString = (String)localObject;
      if (!bo.isNullOrNil(locala.ABb.token))
      {
        ((clw)localObject).xVS = locala.ABb.token;
        ((clw)localObject).xVT = locala.ABb.xsy;
      }
    }
    label185:
    for (paramString = (String)localObject;; paramString = null)
    {
      localbmy.xBi = paramString;
      this.fIi = paramInt;
      AppMethodBeat.o(16500);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16502);
    ab.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16502);
    return i;
  }
  
  public final int getType()
  {
    return 1804;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16501);
    ab.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(16501);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */