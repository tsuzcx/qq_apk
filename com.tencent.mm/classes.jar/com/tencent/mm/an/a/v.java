package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elc;
import com.tencent.mm.protocal.protobuf.eld;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124319);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new elc();
    ((c.a)localObject).otF = new eld();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
    ((c.a)localObject).funcId = 1358;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (elc)c.b.b(this.rr.otB);
    ((elc)localObject).YRQ = paramString1;
    ((elc)localObject).YRJ = paramString2;
    AppMethodBeat.o(124319);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124321);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124321);
    return i;
  }
  
  public final int getType()
  {
    return 1358;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124320);
    Log.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.a.v
 * JD-Core Version:    0.7.0.1
 */