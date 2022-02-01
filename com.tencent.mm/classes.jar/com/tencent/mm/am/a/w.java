package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.sdk.platformtools.ad;

public final class w
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124322);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cfx();
    ((b.a)localObject).gUV = new cfy();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
    ((b.a)localObject).funcId = 1361;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cfx)this.rr.gUS.gUX;
    ((cfx)localObject).CIQ = paramString1;
    ((cfx)localObject).CIJ = paramString2;
    ((cfx)localObject).time_stamp = paramInt;
    AppMethodBeat.o(124322);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124324);
    this.callback = paramg;
    ad.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124324);
    return i;
  }
  
  public final int getType()
  {
    return 1361;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124323);
    ad.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a.w
 * JD-Core Version:    0.7.0.1
 */