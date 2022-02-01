package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public af()
  {
    this(2, 0, 0);
  }
  
  public af(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(236693);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new djz();
    ((c.a)localObject).otF = new dka();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/logoutwebwx";
    ((c.a)localObject).funcId = 281;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (djz)c.b.b(this.rr.otB);
    ((djz)localObject).YIq = paramInt1;
    ((djz)localObject).aaPS = paramInt2;
    ((djz)localObject).aaPT = paramInt3;
    Log.i("MicroMsg.NetSceneWebWXLogout", "OpCode:%s, targetDeviceType:%s, targetClientVersion:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(236693);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150964);
    Log.d("MicroMsg.NetSceneWebWXLogout", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150964);
    return i;
  }
  
  public final int getType()
  {
    return 281;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150965);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af
 * JD-Core Version:    0.7.0.1
 */