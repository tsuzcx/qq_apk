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
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124319);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dsh();
    ((d.a)localObject).lBV = new dsi();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
    ((d.a)localObject).funcId = 1358;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dsh)d.b.b(this.rr.lBR);
    ((dsh)localObject).RUp = paramString1;
    ((dsh)localObject).RUi = paramString2;
    AppMethodBeat.o(124319);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124321);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.ao.a.v
 * JD-Core Version:    0.7.0.1
 */