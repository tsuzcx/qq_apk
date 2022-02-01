package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends n
  implements k
{
  public int action;
  private f callback;
  private final b rr;
  public cdp vWr;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(218149);
    ae.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", new Object[] { Integer.valueOf(paramInt), bu.bI(paramString1, ""), bu.bI(paramString1, ""), bu.aSM(paramString3) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/notautosucceed";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQF = new cdo();
    ((b.a)localObject).hQG = new cdp();
    this.rr = ((b.a)localObject).aDS();
    this.action = paramInt;
    localObject = (cdo)this.rr.hQD.hQJ;
    ((cdo)localObject).Hqx = bu.bI(paramString1, "");
    ((cdo)localObject).Hqy = bu.bI(paramString2, "");
    ((cdo)localObject).Hqz = bu.bI(paramString3, "");
    ((cdo)localObject).action = paramInt;
    AppMethodBeat.o(218149);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(218150);
    this.callback = paramf;
    this.vWr = ((cdp)this.rr.hQE.hQJ);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(218150);
    return i;
  }
  
  public final int getType()
  {
    return 3713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218151);
    ae.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(218151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */