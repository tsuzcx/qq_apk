package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class al
  extends n
  implements k
{
  private g callback;
  public String dcm;
  public final b fUF;
  
  public al(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(41595);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new anf();
    ((b.a)localObject).gUV = new ang();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    if (paramString2 == null) {}
    for (this.dcm = "";; this.dcm = paramString2.trim())
    {
      this.fUF = ((b.a)localObject).atI();
      localObject = (anf)this.fUF.gUS.gUX;
      ((anf)localObject).sbA = paramString1;
      ((anf)localObject).Dop = paramString2;
      ((anf)localObject).Doq = paramLinkedList;
      AppMethodBeat.o(41595);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41596);
    this.callback = paramg;
    int i = dispatch(parame, this.fUF, this);
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
    ad.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.al
 * JD-Core Version:    0.7.0.1
 */