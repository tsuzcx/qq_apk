package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  boolean oyx;
  public c rr;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124301);
    this.oyx = false;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cfl();
    ((c.a)localObject).otF = new cfm();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
    ((c.a)localObject).funcId = 1352;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cfl)c.b.b(this.rr.otB);
    ((cfl)localObject).YRJ = paramString1;
    ((cfl)localObject).YRQ = paramString2;
    this.oyx = true;
    AppMethodBeat.o(124301);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124303);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.an.a.p
 * JD-Core Version:    0.7.0.1
 */