package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sdk.platformtools.ae;

public final class w
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124322);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cqu();
    ((b.a)localObject).hQG = new cqv();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
    ((b.a)localObject).funcId = 1361;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cqu)this.rr.hQD.hQJ;
    ((cqu)localObject).FZx = paramString1;
    ((cqu)localObject).FZq = paramString2;
    ((cqu)localObject).time_stamp = paramInt;
    AppMethodBeat.o(124322);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124324);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
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
    ae.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.w
 * JD-Core Version:    0.7.0.1
 */