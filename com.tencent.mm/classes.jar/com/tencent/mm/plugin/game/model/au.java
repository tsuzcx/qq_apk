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
import com.tencent.mm.plugin.game.protobuf.dw;
import com.tencent.mm.plugin.game.protobuf.dx;
import com.tencent.mm.sdk.platformtools.Log;

public final class au
  extends q
  implements m
{
  private i callback;
  public final d hhm;
  
  public au(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(41625);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dw();
    ((d.a)localObject).iLO = new dx();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (dw)this.hhm.iLK.iLR;
    ((dw)localObject).hik = paramString1;
    ((dw)localObject).xLl = paramString2;
    ((dw)localObject).xIG = paramString3;
    ((dw)localObject).xIT = paramBoolean;
    AppMethodBeat.o(41625);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41626);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(41626);
    return i;
  }
  
  public final int getType()
  {
    return 1219;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41627);
    Log.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */