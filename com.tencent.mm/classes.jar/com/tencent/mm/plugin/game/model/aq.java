package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class aq
  extends n
  implements k
{
  private g callback;
  public final b fYA;
  
  public aq(int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(41610);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bl();
    ((b.a)localObject).hvu = new bm();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (bl)this.fYA.hvr.hvw;
    ((bl)localObject).tkr = paramInt1;
    ((bl)localObject).tks = 15;
    ((bl)localObject).tju = ab.eUO();
    ((bl)localObject).iKc = bs.iW(ai.getContext());
    ((bl)localObject).tkt = paramInt2;
    ((bl)localObject).tkb = paramLinkedList;
    ((bl)localObject).tku = paramBoolean;
    AppMethodBeat.o(41610);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41611);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneGetLibGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aq
 * JD-Core Version:    0.7.0.1
 */