package com.tencent.mm.ca;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b hNF;
  
  public b(cuf paramcuf)
  {
    AppMethodBeat.i(9330);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cuf();
    ((b.a)localObject).hNN = new cug();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((b.a)localObject).funcId = 809;
    this.hNF = ((b.a)localObject).aDC();
    localObject = (cuf)this.hNF.hNK.hNQ;
    ((cuf)localObject).Hme = paramcuf.Hme;
    ((cuf)localObject).Hmd = paramcuf.Hmd;
    ((cuf)localObject).FGP = paramcuf.FGP;
    ((cuf)localObject).EmotionList.addAll(paramcuf.EmotionList);
    ((cuf)localObject).nEf = paramcuf.nEf;
    AppMethodBeat.o(9330);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(9331);
    this.callback = paramf;
    int i = dispatch(parame, this.hNF, this);
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
    ad.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ca.b
 * JD-Core Version:    0.7.0.1
 */