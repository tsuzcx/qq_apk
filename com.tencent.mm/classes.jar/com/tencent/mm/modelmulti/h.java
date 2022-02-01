package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.k.a;
import org.b.d.i;

public final class h
  extends n
  implements k
{
  private f callback;
  private int ihA;
  private b rr;
  
  public h(int paramInt, String paramString)
  {
    AppMethodBeat.i(20546);
    this.ihA = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new clz();
    ((b.a)localObject).hQG = new cma();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
    ((b.a)localObject).funcId = 1804;
    this.rr = ((b.a)localObject).aDS();
    clz localclz = (clz)this.rr.hQD.hQJ;
    localclz.GSF = paramInt;
    localclz.GSH = paramString;
    if ((paramInt & 0x10) > 0)
    {
      a locala = new a();
      localObject = new dqz();
      if (locala.Llz == null) {
        break label185;
      }
      paramString = (String)localObject;
      if (!bu.isNullOrNil(locala.Llz.token))
      {
        ((dqz)localObject).HXY = locala.Llz.token;
        ((dqz)localObject).HXZ = locala.Llz.HmQ;
      }
    }
    label185:
    for (paramString = (String)localObject;; paramString = null)
    {
      localclz.HxX = paramString;
      this.ihA = paramInt;
      AppMethodBeat.o(20546);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20548);
    ae.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20548);
    return i;
  }
  
  public final int getType()
  {
    return 1804;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20547);
    ae.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h
 * JD-Core Version:    0.7.0.1
 */