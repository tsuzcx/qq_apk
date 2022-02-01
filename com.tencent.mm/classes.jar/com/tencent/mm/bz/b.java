package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b hQy;
  
  public b(cuz paramcuz)
  {
    AppMethodBeat.i(9330);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cuz();
    ((b.a)localObject).hQG = new cva();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((b.a)localObject).funcId = 809;
    this.hQy = ((b.a)localObject).aDS();
    localObject = (cuz)this.hQy.hQD.hQJ;
    ((cuz)localObject).HFE = paramcuz.HFE;
    ((cuz)localObject).HFD = paramcuz.HFD;
    ((cuz)localObject).FZl = paramcuz.FZl;
    ((cuz)localObject).EmotionList.addAll(paramcuz.EmotionList);
    ((cuz)localObject).nJA = paramcuz.nJA;
    AppMethodBeat.o(9330);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(9331);
    this.callback = paramf;
    int i = dispatch(parame, this.hQy, this);
    AppMethodBeat.o(9331);
    return i;
  }
  
  public final int getType()
  {
    return 809;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9332);
    ae.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bz.b
 * JD-Core Version:    0.7.0.1
 */