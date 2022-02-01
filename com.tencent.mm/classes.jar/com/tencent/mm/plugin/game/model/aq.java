package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class aq
  extends n
  implements k
{
  private f callback;
  public final b gux;
  
  public aq(int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(41610);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bv();
    ((b.a)localObject).hQG = new bw();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (bv)this.gux.hQD.hQJ;
    ((bv)localObject).utT = paramInt1;
    ((bv)localObject).utU = 15;
    ((bv)localObject).usS = ad.fom();
    ((bv)localObject).jge = bu.jm(ak.getContext());
    ((bv)localObject).utV = paramInt2;
    ((bv)localObject).utD = paramLinkedList;
    ((bv)localObject).utW = paramBoolean;
    AppMethodBeat.o(41610);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41611);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
    AppMethodBeat.o(41611);
    return i;
  }
  
  public final int getType()
  {
    return 1218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41612);
    ae.i("MicroMsg.NetSceneGetLibGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aq
 * JD-Core Version:    0.7.0.1
 */