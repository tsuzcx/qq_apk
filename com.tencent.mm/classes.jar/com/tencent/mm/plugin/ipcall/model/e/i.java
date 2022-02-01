package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.protocal.protobuf.dfl;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private d rr;
  public dfl yrE;
  public dfm yrF;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25475);
    this.rr = null;
    this.yrE = null;
    this.yrF = null;
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dfl();
    ((d.a)localObject).iLO = new dfm();
    ((d.a)localObject).funcId = 991;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    long l = System.currentTimeMillis();
    int i = c.ebM();
    localObject = (dfl)this.rr.iLK.iLR;
    ((dfl)localObject).xNH = z.aTY();
    ((dfl)localObject).MKh = paramString2;
    ((dfl)localObject).xNG = paramString1;
    ((dfl)localObject).MKg = paramInt1;
    ((dfl)localObject).Llx = i;
    ((dfl)localObject).MKp = 1;
    ((dfl)localObject).MKf = l;
    ((dfl)localObject).MKo = paramInt2;
    ((dfl)localObject).MKq = paramInt3;
    this.yrE = ((dfl)localObject);
    Log.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(25475);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(25476);
    this.callback = parami;
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
    this.yrF = ((dfm)((d)params).iLL.iLR);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.i
 * JD-Core Version:    0.7.0.1
 */