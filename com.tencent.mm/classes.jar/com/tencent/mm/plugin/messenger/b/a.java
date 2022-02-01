package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
  implements k
{
  public int action;
  private f callback;
  private final b rr;
  public ccv vKn;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(211840);
    ad.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", new Object[] { Integer.valueOf(paramInt), bt.bI(paramString1, ""), bt.bI(paramString1, ""), bt.aRp(paramString3) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/notautosucceed";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNM = new ccu();
    ((b.a)localObject).hNN = new ccv();
    this.rr = ((b.a)localObject).aDC();
    this.action = paramInt;
    localObject = (ccu)this.rr.hNK.hNQ;
    ((ccu)localObject).GWX = bt.bI(paramString1, "");
    ((ccu)localObject).GWY = bt.bI(paramString2, "");
    ((ccu)localObject).GWZ = bt.bI(paramString3, "");
    ((ccu)localObject).action = paramInt;
    AppMethodBeat.o(211840);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(211841);
    this.callback = paramf;
    this.vKn = ((ccv)this.rr.hNL.hNQ);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(211841);
    return i;
  }
  
  public final int getType()
  {
    return 3713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211842);
    ad.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(211842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */