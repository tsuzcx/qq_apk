package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i callback;
  private d hJu;
  private x jTo;
  public y jTp;
  
  public k(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(63391);
    d.a locala = new d.a();
    locala.iLN = new x();
    locala.iLO = new y();
    locala.funcId = 1695;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.jTo = ((x)this.hJu.iLK.iLR);
    this.jTo.KBs = paramString1;
    this.jTo.scene = paramInt1;
    this.jTo.KBt = paramString2;
    if (paramInt1 == 5)
    {
      Log.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
      this.jTo.sign = paramString3;
      this.jTo.ver = paramInt2;
    }
    Log.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
    AppMethodBeat.o(63391);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63393);
    Log.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(63393);
    return i;
  }
  
  public final int getType()
  {
    return 1695;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63392);
    Log.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.jTp = ((y)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.jTp.dDN), this.jTp.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.k
 * JD-Core Version:    0.7.0.1
 */