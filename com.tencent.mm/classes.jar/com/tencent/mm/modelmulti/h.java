package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.evb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.q.a;

public final class h
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private int lSU;
  private d rr;
  
  public h(int paramInt, String paramString)
  {
    AppMethodBeat.i(20546);
    this.lSU = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dnc();
    ((d.a)localObject).lBV = new dnd();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
    ((d.a)localObject).funcId = 1804;
    this.rr = ((d.a)localObject).bgN();
    dnc localdnc = (dnc)d.b.b(this.rr.lBR);
    localdnc.Tgp = paramInt;
    localdnc.Tgr = paramString;
    if ((paramInt & 0x10) > 0)
    {
      a locala = new a();
      localObject = new evb();
      if (locala.XZg == null) {
        break label185;
      }
      paramString = (String)localObject;
      if (!Util.isNullOrNil(locala.XZg.token))
      {
        ((evb)localObject).UwO = locala.XZg.token;
        ((evb)localObject).UwP = locala.XZg.TEk;
      }
    }
    label185:
    for (paramString = (String)localObject;; paramString = null)
    {
      localdnc.TUs = paramString;
      this.lSU = paramInt;
      AppMethodBeat.o(20546);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(20548);
    Log.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20548);
    return i;
  }
  
  public final int getType()
  {
    return 1804;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20547);
    Log.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20547);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h
 * JD-Core Version:    0.7.0.1
 */