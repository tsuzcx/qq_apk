package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ehz;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  extends p
  implements m
{
  public ehz JIQ;
  public eia JIR;
  private h callback;
  private c rr;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25475);
    this.rr = null;
    this.JIQ = null;
    this.JIR = null;
    this.callback = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ehz();
    ((c.a)localObject).otF = new eia();
    ((c.a)localObject).funcId = 991;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    long l = System.currentTimeMillis();
    MMApplicationContext.getContext();
    int i = com.tencent.mm.plugin.voip.f.g.ibq();
    localObject = (ehz)c.b.b(this.rr.otB);
    ((ehz)localObject).IMh = z.bAM();
    ((ehz)localObject).abmQ = paramString2;
    ((ehz)localObject).IMg = paramString1;
    ((ehz)localObject).abmP = paramInt1;
    ((ehz)localObject).ZkT = i;
    ((ehz)localObject).abmY = 1;
    ((ehz)localObject).abmO = l;
    ((ehz)localObject).abmX = paramInt2;
    ((ehz)localObject).abmZ = paramInt3;
    this.JIQ = ((ehz)localObject);
    Log.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(25475);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(25476);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25476);
    return i;
  }
  
  public final int getType()
  {
    return 991;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25477);
    Log.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.JIR = ((eia)c.c.b(((c)params).otC));
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(25477);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.i
 * JD-Core Version:    0.7.0.1
 */