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
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class al
  extends n
  implements k
{
  private f callback;
  public String dmf;
  public final b gux;
  
  public al(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(41595);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new auv();
    ((b.a)localObject).hQG = new auw();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    if (paramString2 == null) {}
    for (this.dmf = "";; this.dmf = paramString2.trim())
    {
      this.gux = ((b.a)localObject).aDS();
      localObject = (auv)this.gux.hQD.hQJ;
      ((auv)localObject).usS = paramString1;
      ((auv)localObject).GLP = paramString2;
      ((auv)localObject).GLQ = paramLinkedList;
      AppMethodBeat.o(41595);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41596);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
    AppMethodBeat.o(41596);
    return i;
  }
  
  public final int getType()
  {
    return 1329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41597);
    ae.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.al
 * JD-Core Version:    0.7.0.1
 */