package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public final class ae
  extends n
  implements k
{
  private g callback;
  b gvE;
  int iLi;
  
  public ae(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184425);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/getoldacctfriend";
    bao localbao = new bao();
    this.iLi = paramInt;
    localbao.ERw = paramInt;
    localbao.ncR = paramString1;
    localbao.DSu = paramString2;
    locala.hvt = localbao;
    locala.hvu = new bap();
    this.gvE = locala.aAz();
    ac.i("MicroMsg.NetSceneGetOldAccountFriend", "get old account friend %s, max seq %d, session %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(184425);
  }
  
  public final List<bzb> aPR()
  {
    return ((bap)this.gvE.hvs.hvw).ERx;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(184426);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneGetOldAccountFriend", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (!aPR().isEmpty())) {
      this.iLi = ((bzb)aPR().get(aPR().size() - 1)).EeA;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ae
 * JD-Core Version:    0.7.0.1
 */