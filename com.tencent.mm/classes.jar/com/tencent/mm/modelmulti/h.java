package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddm;
import com.tencent.mm.protocal.protobuf.ddn;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.o.a;

public final class h
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private int jcv;
  private d rr;
  
  public h(int paramInt, String paramString)
  {
    AppMethodBeat.i(20546);
    this.jcv = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ddm();
    ((d.a)localObject).iLO = new ddn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
    ((d.a)localObject).funcId = 1804;
    this.rr = ((d.a)localObject).aXF();
    ddm localddm = (ddm)this.rr.iLK.iLR;
    localddm.LWR = paramInt;
    localddm.LWT = paramString;
    if ((paramInt & 0x10) > 0)
    {
      a locala = new a();
      localObject = new ekv();
      if (locala.QAH == null) {
        break label185;
      }
      paramString = (String)localObject;
      if (!Util.isNullOrNil(locala.QAH.token))
      {
        ((ekv)localObject).Nke = locala.QAH.token;
        ((ekv)localObject).Nkf = locala.QAH.Mte;
      }
    }
    label185:
    for (paramString = (String)localObject;; paramString = null)
    {
      localddm.MID = paramString;
      this.jcv = paramInt;
      AppMethodBeat.o(20546);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h
 * JD-Core Version:    0.7.0.1
 */