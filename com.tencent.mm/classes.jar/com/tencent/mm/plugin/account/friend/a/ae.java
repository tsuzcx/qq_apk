package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public final class ae
  extends n
  implements k
{
  private g callback;
  b iaa;
  int ilb;
  
  public ae(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184425);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/getoldacctfriend";
    aww localaww = new aww();
    this.ilb = paramInt;
    localaww.Dwb = paramInt;
    localaww.mAQ = paramString1;
    localaww.CzY = paramString2;
    locala.gUU = localaww;
    locala.gUV = new awx();
    this.iaa = locala.atI();
    ad.i("MicroMsg.NetSceneGetOldAccountFriend", "get old account friend %s, max seq %d, session %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(184425);
  }
  
  public final List<buk> aJa()
  {
    return ((awx)this.iaa.gUT.gUX).Dwc;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(184426);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (!aJa().isEmpty())) {
      this.ilb = ((buk)aJa().get(aJa().size() - 1)).CLY;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ae
 * JD-Core Version:    0.7.0.1
 */