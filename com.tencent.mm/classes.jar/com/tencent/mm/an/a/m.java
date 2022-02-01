package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private Object cpt;
  public c rr;
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124292);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ou();
    ((c.a)localObject).otF = new ov();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((c.a)localObject).funcId = 1364;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ou)c.b.b(this.rr.otB);
    ((ou)localObject).YRQ = paramString1;
    ((ou)localObject).hAB = paramString2;
    ((ou)localObject).offset = paramInt;
    this.cpt = null;
    AppMethodBeat.o(124292);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124294);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.an.a.m
 * JD-Core Version:    0.7.0.1
 */