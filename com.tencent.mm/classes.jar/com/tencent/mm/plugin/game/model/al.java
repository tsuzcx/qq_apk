package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class al
  extends p
  implements m
{
  private h callback;
  public String hAB;
  public final c mtC;
  
  public al(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(41595);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cbd();
    ((c.a)localObject).otF = new cbe();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    if (paramString2 == null) {}
    for (this.hAB = "";; this.hAB = paramString2.trim())
    {
      this.mtC = ((c.a)localObject).bEF();
      localObject = (cbd)c.b.b(this.mtC.otB);
      ((cbd)localObject).IJD = paramString1;
      ((cbd)localObject).aakp = paramString2;
      ((cbd)localObject).aakq = paramLinkedList;
      AppMethodBeat.o(41595);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(41596);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
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