package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends n
  implements k
{
  public int action;
  private g callback;
  private final b rr;
  public bye uHk;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(198590);
    ac.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", new Object[] { Integer.valueOf(paramInt), bs.bG(paramString1, ""), bs.bG(paramString1, ""), bs.aLJ(paramString3) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/notautosucceed";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hvt = new byd();
    ((b.a)localObject).hvu = new bye();
    this.rr = ((b.a)localObject).aAz();
    this.action = paramInt;
    localObject = (byd)this.rr.hvr.hvw;
    ((byd)localObject).Fno = bs.bG(paramString1, "");
    ((byd)localObject).Fnp = bs.bG(paramString2, "");
    ((byd)localObject).Fnq = bs.bG(paramString3, "");
    ((byd)localObject).action = paramInt;
    AppMethodBeat.o(198590);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(198591);
    this.callback = paramg;
    this.uHk = ((bye)this.rr.hvs.hvw);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(198591);
    return i;
  }
  
  public final int getType()
  {
    return 3713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198592);
    ac.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */