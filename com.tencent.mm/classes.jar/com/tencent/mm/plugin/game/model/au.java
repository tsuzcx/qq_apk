package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.dn;
import com.tencent.mm.plugin.game.d.do;
import com.tencent.mm.sdk.platformtools.ad;

public final class au
  extends n
  implements k
{
  private f callback;
  public final b grW;
  
  public au(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(41625);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dn();
    ((b.a)localObject).hNN = new do();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (dn)this.grW.hNK.hNQ;
    ((dn)localObject).gsT = paramString1;
    ((dn)localObject).uhu = paramString2;
    ((dn)localObject).ufd = paramString3;
    ((dn)localObject).ufr = paramBoolean;
    AppMethodBeat.o(41625);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41626);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(41626);
    return i;
  }
  
  public final int getType()
  {
    return 1219;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41627);
    ad.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */