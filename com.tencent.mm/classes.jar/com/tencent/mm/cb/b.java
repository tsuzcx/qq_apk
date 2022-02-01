package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.al.b gUN;
  
  public b(cjt paramcjt)
  {
    AppMethodBeat.i(9330);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cjt();
    ((b.a)localObject).gUV = new cju();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((b.a)localObject).funcId = 809;
    this.gUN = ((b.a)localObject).atI();
    localObject = (cjt)this.gUN.gUS.gUX;
    ((cjt)localObject).EeP = paramcjt.EeP;
    ((cjt)localObject).EeO = paramcjt.EeO;
    ((cjt)localObject).CIE = paramcjt.CIE;
    ((cjt)localObject).EmotionList.addAll(paramcjt.EmotionList);
    ((cjt)localObject).mBH = paramcjt.mBH;
    AppMethodBeat.o(9330);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(9331);
    this.callback = paramg;
    int i = dispatch(parame, this.gUN, this);
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
 * Qualified Name:     com.tencent.mm.cb.b
 * JD-Core Version:    0.7.0.1
 */