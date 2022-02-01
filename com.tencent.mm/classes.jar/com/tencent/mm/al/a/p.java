package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends q
  implements m
{
  private i callback;
  boolean iQA;
  public d rr;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124301);
    this.iQA = false;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bjl();
    ((d.a)localObject).iLO = new bjm();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
    ((d.a)localObject).funcId = 1352;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bjl)this.rr.iLK.iLR;
    ((bjl)localObject).KTl = paramString1;
    ((bjl)localObject).KTt = paramString2;
    this.iQA = true;
    AppMethodBeat.o(124301);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124303);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124303);
    return i;
  }
  
  public final int getType()
  {
    return 1352;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124302);
    Log.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.p
 * JD-Core Version:    0.7.0.1
 */