package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  private final d iUB;
  public Object tag;
  
  public c(String paramString)
  {
    AppMethodBeat.i(104520);
    d.a locala = new d.a();
    locala.iLN = new cfj();
    locala.iLO = new cfk();
    locala.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
    locala.funcId = 666;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iUB = locala.aXF();
    ((cfj)this.iUB.iLK.iLR).Url = paramString;
    AppMethodBeat.o(104520);
  }
  
  public final cfk bbD()
  {
    return (cfk)this.iUB.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(104521);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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
 * Qualified Name:     com.tencent.mm.aq.c
 * JD-Core Version:    0.7.0.1
 */