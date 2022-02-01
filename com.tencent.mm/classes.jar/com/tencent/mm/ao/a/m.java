package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private Object bnW;
  private i callback;
  public d rr;
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124292);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new no();
    ((d.a)localObject).lBV = new np();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((d.a)localObject).funcId = 1364;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (no)d.b.b(this.rr.lBR);
    ((no)localObject).RUp = paramString1;
    ((no)localObject).fwe = paramString2;
    ((no)localObject).offset = paramInt;
    this.bnW = null;
    AppMethodBeat.o(124292);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124294);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124294);
    return i;
  }
  
  public final int getType()
  {
    return 1364;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124293);
    Log.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.a.m
 * JD-Core Version:    0.7.0.1
 */