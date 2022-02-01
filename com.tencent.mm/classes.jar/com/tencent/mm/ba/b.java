package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.ftb;
import com.tencent.mm.protocal.protobuf.ftc;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class b
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private String clientId;
  private int dIY;
  private String hQn;
  public String oRL;
  private int osy;
  private c rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(90688);
    this.username = paramString;
    this.osy = 0;
    this.dIY = 0;
    paramString = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    this.clientId = (com.tencent.mm.kernel.b.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(90688);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.hQn = paramString2;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(90690);
    this.callback = paramh;
    if ((this.hQn == null) || (this.hQn.length() == 0))
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(90690);
      return -1;
    }
    if (!y.ZC(this.hQn))
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.hQn);
      AppMethodBeat.o(90690);
      return -1;
    }
    if (this.osy == 0) {
      this.osy = ((int)new u(this.hQn).length());
    }
    paramh = new c.a();
    paramh.otE = new ftb();
    paramh.otF = new ftc();
    paramh.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    paramh.funcId = 575;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
    int i = Math.min(this.osy - this.dIY, 32768);
    paramh = y.bi(this.hQn, this.dIY, i);
    if (paramh == null)
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(90690);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramh.length), Integer.valueOf(this.osy) });
    ftb localftb = (ftb)c.b.b(this.rr.otB);
    localftb.ZqZ = this.username;
    localftb.NkN = this.osy;
    localftb.NkO = this.dIY;
    localftb.NkQ = new gol().df(paramh);
    localftb.NkP = localftb.NkQ.abwJ;
    localftb.nUv = this.clientId;
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(90690);
    return i;
  }
  
  public final int getType()
  {
    return 575;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90691);
    Log.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(90691);
      return;
    }
    params = (ftc)c.c.b(((c)params).otC);
    this.oRL = params.aaWa;
    this.dIY = params.NkO;
    if (this.dIY < this.osy)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        Log.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      Log.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
      AppMethodBeat.o(90691);
      return;
    }
    if (!Util.isNullOrNil(this.oRL))
    {
      params = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.username);
      if ((params != null) && ((int)params.maN > 0) && (d.rs(params.field_type)))
      {
        params.Bw(this.oRL);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(this.username, params);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90691);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(90689);
    if ((this.hQn == null) || (this.hQn.length() == 0))
    {
      params = p.b.oui;
      AppMethodBeat.o(90689);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(90689);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.b
 * JD-Core Version:    0.7.0.1
 */