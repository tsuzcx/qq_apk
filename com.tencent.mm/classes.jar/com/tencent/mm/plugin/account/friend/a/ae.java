package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.cem;
import java.util.List;

public final class ae
  extends n
  implements k
{
  private f callback;
  b gRX;
  int jhk;
  
  public ae(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184425);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/getoldacctfriend";
    bfi localbfi = new bfi();
    this.jhk = paramInt;
    localbfi.GUo = paramInt;
    localbfi.nIJ = paramString1;
    localbfi.FQl = paramString2;
    locala.hQF = localbfi;
    locala.hQG = new bfj();
    this.gRX = locala.aDS();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneGetOldAccountFriend", "get old account friend %s, max seq %d, session %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(184425);
  }
  
  public final List<cem> aTC()
  {
    return ((bfj)this.gRX.hQE.hQJ).GUp;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(184426);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneGetOldAccountFriend", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (!aTC().isEmpty())) {
      this.jhk = ((cem)aTC().get(aTC().size() - 1)).Gdy;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ae
 * JD-Core Version:    0.7.0.1
 */