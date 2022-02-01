package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.protocal.protobuf.dpg;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  public dpf DRG;
  public dpg DRH;
  private com.tencent.mm.an.i callback;
  private d rr;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25475);
    this.rr = null;
    this.DRG = null;
    this.DRH = null;
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dpf();
    ((d.a)localObject).lBV = new dpg();
    ((d.a)localObject).funcId = 991;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    long l = System.currentTimeMillis();
    int i = c.eKK();
    localObject = (dpf)d.b.b(this.rr.lBR);
    ((dpf)localObject).CRR = z.bcZ();
    ((dpf)localObject).TWb = paramString2;
    ((dpf)localObject).CRQ = paramString1;
    ((dpf)localObject).TWa = paramInt1;
    ((dpf)localObject).SmH = i;
    ((dpf)localObject).TWj = 1;
    ((dpf)localObject).TVZ = l;
    ((dpf)localObject).TWi = paramInt2;
    ((dpf)localObject).TWk = paramInt3;
    this.DRG = ((dpf)localObject);
    Log.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(25475);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
    this.DRH = ((dpg)d.c.b(((d)params).lBS));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.i
 * JD-Core Version:    0.7.0.1
 */