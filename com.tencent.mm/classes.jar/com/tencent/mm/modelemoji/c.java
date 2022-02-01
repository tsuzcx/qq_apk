package com.tencent.mm.modelemoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfa;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  private final com.tencent.mm.am.c oDw;
  public Object tag;
  
  public c(String paramString)
  {
    AppMethodBeat.i(104520);
    c.a locala = new c.a();
    locala.otE = new dfa();
    locala.otF = new dfb();
    locala.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
    locala.funcId = 666;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.oDw = locala.bEF();
    ((dfa)c.b.b(this.oDw.otB)).Url = paramString;
    AppMethodBeat.o(104520);
  }
  
  public final dfb bIM()
  {
    AppMethodBeat.i(231390);
    dfb localdfb = (dfb)c.c.b(this.oDw.otC);
    AppMethodBeat.o(231390);
    return localdfb;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(104521);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(104521);
    return i;
  }
  
  public final int getType()
  {
    return 666;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104522);
    Log.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelemoji.c
 * JD-Core Version:    0.7.0.1
 */