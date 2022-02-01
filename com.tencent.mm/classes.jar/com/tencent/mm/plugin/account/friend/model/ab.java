package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class ab
  extends p
  implements m
{
  private h callback;
  c nao;
  int pTu;
  
  public ab(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184425);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/getoldacctfriend";
    cod localcod = new cod();
    this.pTu = paramInt;
    localcod.aavq = paramInt;
    localcod.UserName = paramString1;
    localcod.SessionId = paramString2;
    locala.otE = localcod;
    locala.otF = new coe();
    this.nao = locala.bEF();
    Log.i("MicroMsg.NetSceneGetOldAccountFriend", "get old account friend %s, max seq %d, session %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(184425);
  }
  
  public final List<dvz> bXl()
  {
    AppMethodBeat.i(304789);
    LinkedList localLinkedList = ((coe)c.c.b(this.nao.otC)).aavr;
    AppMethodBeat.o(304789);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(184426);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (!bXl().isEmpty())) {
      this.pTu = ((dvz)bXl().get(bXl().size() - 1)).YWY;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ab
 * JD-Core Version:    0.7.0.1
 */