package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
  implements k
{
  public int action;
  private g callback;
  private final b rr;
  public btn tyN;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(196706);
    ad.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", new Object[] { Integer.valueOf(paramInt), bt.by(paramString1, ""), bt.by(paramString1, ""), bt.aGs(paramString3) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/notautosucceed";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).gUU = new btm();
    ((b.a)localObject).gUV = new btn();
    this.rr = ((b.a)localObject).atI();
    this.action = paramInt;
    localObject = (btm)this.rr.gUS.gUX;
    ((btm)localObject).DQW = bt.by(paramString1, "");
    ((btm)localObject).DQX = bt.by(paramString2, "");
    ((btm)localObject).DQY = bt.by(paramString3, "");
    ((btm)localObject).action = paramInt;
    AppMethodBeat.o(196706);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(196707);
    this.callback = paramg;
    this.tyN = ((btn)this.rr.gUT.gUX);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(196707);
    return i;
  }
  
  public final int getType()
  {
    return 3713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196708);
    ad.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(196708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */