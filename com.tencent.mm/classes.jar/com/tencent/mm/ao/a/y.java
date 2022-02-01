package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.evv;
import com.tencent.mm.protocal.protobuf.evw;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  Object bnW;
  private i callback;
  public d rr;
  
  public y(String paramString1, String paramString2, nm paramnm1, nm paramnm2, Object paramObject)
  {
    AppMethodBeat.i(124328);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new evv();
    ((d.a)localObject).lBV = new evw();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((d.a)localObject).funcId = 1357;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (evv)d.b.b(this.rr.lBR);
    ((evv)localObject).RUp = paramString1;
    ((evv)localObject).RUi = paramString2;
    ((evv)localObject).Uxn = paramnm1;
    ((evv)localObject).Uxo = paramnm2;
    this.bnW = paramObject;
    AppMethodBeat.o(124328);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124330);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124330);
    return i;
  }
  
  public final int getType()
  {
    return 1357;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124329);
    Log.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.a.y
 * JD-Core Version:    0.7.0.1
 */