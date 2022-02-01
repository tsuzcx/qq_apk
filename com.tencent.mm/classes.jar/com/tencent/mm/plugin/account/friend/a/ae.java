package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class ae
  extends q
  implements m
{
  private i callback;
  d hJu;
  int kfo;
  
  public ae(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184425);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/getoldacctfriend";
    bre localbre = new bre();
    this.kfo = paramInt;
    localbre.LYG = paramInt;
    localbre.UserName = paramString1;
    localbre.SessionId = paramString2;
    locala.iLN = localbre;
    locala.iLO = new brf();
    this.hJu = locala.aXF();
    Log.i("MicroMsg.NetSceneGetOldAccountFriend", "get old account friend %s, max seq %d, session %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(184425);
  }
  
  public final List<cut> boo()
  {
    return ((brf)this.hJu.iLL.iLR).LYH;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(184426);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(184426);
    return i;
  }
  
  public final int getType()
  {
    return 3513;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184427);
    Log.i("MicroMsg.NetSceneGetOldAccountFriend", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (!boo().isEmpty())) {
      this.kfo = ((cut)boo().get(boo().size() - 1)).KXP;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ae
 * JD-Core Version:    0.7.0.1
 */