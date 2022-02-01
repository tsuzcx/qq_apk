package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d rr;
  private bxu yrt;
  public bxv yru;
  
  public d()
  {
    AppMethodBeat.i(25460);
    this.rr = null;
    this.yrt = null;
    this.yru = null;
    d.a locala = new d.a();
    locala.iLN = new bxu();
    locala.iLO = new bxv();
    locala.funcId = 288;
    locala.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yrt = ((bxu)this.rr.iLK.iLR);
    Log.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
    AppMethodBeat.o(25460);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25461);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25461);
    return i;
  }
  
  public final int getType()
  {
    return 288;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25462);
    Log.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yru = ((bxv)((com.tencent.mm.ak.d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.d
 * JD-Core Version:    0.7.0.1
 */