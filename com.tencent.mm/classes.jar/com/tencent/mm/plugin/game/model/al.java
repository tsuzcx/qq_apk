package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class al
  extends q
  implements m
{
  private i callback;
  public String dDv;
  public final d hhm;
  
  public al(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(41595);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bge();
    ((d.a)localObject).iLO = new bgf();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    if (paramString2 == null) {}
    for (this.dDv = "";; this.dDv = paramString2.trim())
    {
      this.hhm = ((d.a)localObject).aXF();
      localObject = (bge)this.hhm.iLK.iLR;
      ((bge)localObject).xLl = paramString1;
      ((bge)localObject).LPT = paramString2;
      ((bge)localObject).LPU = paramLinkedList;
      AppMethodBeat.o(41595);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41596);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(41596);
    return i;
  }
  
  public final int getType()
  {
    return 1329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41597);
    Log.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.al
 * JD-Core Version:    0.7.0.1
 */