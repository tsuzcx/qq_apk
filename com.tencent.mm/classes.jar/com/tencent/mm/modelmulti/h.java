package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.k.a;
import org.b.d.i;

public final class h
  extends n
  implements k
{
  private g callback;
  private int hll;
  private b rr;
  
  public h(int paramInt, String paramString)
  {
    AppMethodBeat.i(20546);
    this.hll = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cbg();
    ((b.a)localObject).gUV = new cbh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
    ((b.a)localObject).funcId = 1804;
    this.rr = ((b.a)localObject).atI();
    cbg localcbg = (cbg)this.rr.gUS.gUX;
    localcbg.DuF = paramInt;
    localcbg.DuH = paramString;
    if ((paramInt & 0x10) > 0)
    {
      a locala = new a();
      localObject = new dew();
      if (locala.Hxz == null) {
        break label185;
      }
      paramString = (String)localObject;
      if (!bt.isNullOrNil(locala.Hxz.token))
      {
        ((dew)localObject).Ewv = locala.Hxz.token;
        ((dew)localObject).Eww = locala.Hxz.DNx;
      }
    }
    label185:
    for (paramString = (String)localObject;; paramString = null)
    {
      localcbg.DXy = paramString;
      this.hll = paramInt;
      AppMethodBeat.o(20546);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20548);
    ad.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
    this.callback = paramg;
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
    ad.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
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