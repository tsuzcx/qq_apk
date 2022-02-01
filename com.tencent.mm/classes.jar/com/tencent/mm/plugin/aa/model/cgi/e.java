package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d hJu;
  private com.tencent.mm.protocal.protobuf.d jTc;
  public com.tencent.mm.protocal.protobuf.e jTd;
  public int scene;
  
  public e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63375);
    d.a locala = new d.a();
    locala.iLN = new com.tencent.mm.protocal.protobuf.d();
    locala.iLO = new com.tencent.mm.protocal.protobuf.e();
    locala.funcId = 1530;
    locala.uri = "/cgi-bin/mmpay-bin/newaaclose";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.jTc = ((com.tencent.mm.protocal.protobuf.d)this.hJu.iLK.iLR);
    this.jTc.KBt = paramString2;
    this.jTc.KBs = paramString1;
    this.jTc.scene = paramInt;
    this.scene = paramInt;
    Log.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[] { this.jTc.KBs, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63375);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63376);
    Log.i("MicroMsg.NetSceneAAClose", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(63376);
    return i;
  }
  
  public final int getType()
  {
    return 1530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63377);
    Log.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.jTd = ((com.tencent.mm.protocal.protobuf.e)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.jTd.dDN), this.jTd.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */