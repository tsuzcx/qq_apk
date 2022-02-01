package com.tencent.mm.plugin.account.security.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.protocal.protobuf.etp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class b
  extends p
  implements m
{
  private h callback;
  private cru pXL;
  private c rr;
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(125515);
    c.a locala = new c.a();
    locala.otE = new crt();
    locala.otF = new cru();
    locala.uri = "/cgi-bin/micromsg-bin/getsafetyinfo";
    locala.funcId = 850;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125515);
    return i;
  }
  
  public final int getType()
  {
    return 850;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125514);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneGetSafetyInfo", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.pXL = ((cru)c.c.b(((c)params).otC));
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if ((this.pXL != null) && (this.pXL.aaya != null) && (this.pXL.aaya.abwQ != null)) {}
      for (params = this.pXL.aaya.abwQ; (params != null) && (params != null); params = null)
      {
        g.bXS().execSQL("SafeDeviceInfo", "delete from SafeDeviceInfo");
        params = params.iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = (dkb)params.next();
          g.bXS().a(new d(paramArrayOfByte));
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.model.b
 * JD-Core Version:    0.7.0.1
 */