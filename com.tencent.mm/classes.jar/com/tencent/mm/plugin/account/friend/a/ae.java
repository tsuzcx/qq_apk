package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public final class ae
  extends n
  implements k
{
  private f callback;
  b gPp;
  int jer;
  
  public ae(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184425);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/getoldacctfriend";
    bes localbes = new bes();
    this.jer = paramInt;
    localbes.GAO = paramInt;
    localbes.nDo = paramString1;
    localbes.FxN = paramString2;
    locala.hNM = localbes;
    locala.hNN = new bet();
    this.gPp = locala.aDC();
    ad.i("MicroMsg.NetSceneGetOldAccountFriend", "get old account friend %s, max seq %d, session %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(184425);
  }
  
  public final List<cds> aTd()
  {
    return ((bet)this.gPp.hNL.hNQ).GAP;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(184426);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(184426);
    return i;
  }
  
  public final int getType()
  {
    return 3513;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184427);
    ad.i("MicroMsg.NetSceneGetOldAccountFriend", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (!aTd().isEmpty())) {
      this.jer = ((cds)aTd().get(aTd().size() - 1)).FKZ;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ae
 * JD-Core Version:    0.7.0.1
 */