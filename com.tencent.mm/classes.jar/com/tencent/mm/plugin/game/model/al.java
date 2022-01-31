package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class al
  extends m
  implements k
{
  private f callback;
  public String cnv;
  public final b lFp;
  
  public al(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(111430);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aen();
    ((b.a)localObject).fsY = new aeo();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    if (paramString2 == null) {}
    for (this.cnv = "";; this.cnv = paramString2.trim())
    {
      this.lFp = ((b.a)localObject).ado();
      localObject = (aen)this.lFp.fsV.fta;
      ((aen)localObject).nsa = paramString1;
      ((aen)localObject).wXt = paramString2;
      ((aen)localObject).wXu = paramLinkedList;
      AppMethodBeat.o(111430);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111431);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111431);
    return i;
  }
  
  public final int getType()
  {
    return 1329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111432);
    ab.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.al
 * JD-Core Version:    0.7.0.1
 */