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
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class aq
  extends n
  implements k
{
  private f callback;
  public final b grW;
  
  public aq(int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(41610);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bo();
    ((b.a)localObject).hNN = new bp();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (bo)this.grW.hNK.hNQ;
    ((bo)localObject).uiv = paramInt1;
    ((bo)localObject).uiw = 15;
    ((bo)localObject).uhu = ac.fks();
    ((bo)localObject).jdl = bt.jg(aj.getContext());
    ((bo)localObject).uix = paramInt2;
    ((bo)localObject).uie = paramLinkedList;
    ((bo)localObject).uiy = paramBoolean;
    AppMethodBeat.o(41610);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41611);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
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
    ad.i("MicroMsg.NetSceneGetLibGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aq
 * JD-Core Version:    0.7.0.1
 */