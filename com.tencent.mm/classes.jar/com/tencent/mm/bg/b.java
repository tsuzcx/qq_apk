package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.exj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.u;

public final class b
  extends com.tencent.mm.an.q
  implements m
{
  private int bPt;
  private i callback;
  private String clientId;
  private String fKH;
  private int lAW;
  public String lYG;
  private com.tencent.mm.an.d rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(90688);
    this.username = paramString;
    this.lAW = 0;
    this.bPt = 0;
    paramString = new StringBuilder();
    h.aHE();
    this.clientId = (com.tencent.mm.kernel.b.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(90688);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.fKH = paramString2;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(90690);
    this.callback = parami;
    if ((this.fKH == null) || (this.fKH.length() == 0))
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(90690);
      return -1;
    }
    if (!u.agG(this.fKH))
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.fKH);
      AppMethodBeat.o(90690);
      return -1;
    }
    if (this.lAW == 0) {
      this.lAW = ((int)new com.tencent.mm.vfs.q(this.fKH).length());
    }
    parami = new d.a();
    parami.lBU = new exi();
    parami.lBV = new exj();
    parami.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    parami.funcId = 575;
    parami.lBW = 0;
    parami.respCmdId = 0;
    this.rr = parami.bgN();
    int i = Math.min(this.lAW - this.bPt, 32768);
    parami = u.aY(this.fKH, this.bPt, i);
    if (parami == null)
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(90690);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(parami.length), Integer.valueOf(this.lAW) });
    exi localexi = (exi)d.b.b(this.rr.lBR);
    localexi.SrU = this.username;
    localexi.HmZ = this.lAW;
    localexi.Hna = this.bPt;
    localexi.Hnc = new eae().dc(parami);
    localexi.Hnb = localexi.Hnc.Ufv;
    localexi.lps = this.clientId;
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
    params = (exj)d.c.b(((com.tencent.mm.an.d)params).lBS);
    this.lYG = params.TGu;
    this.bPt = params.Hna;
    if (this.bPt < this.lAW)
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
    if (!Util.isNullOrNil(this.lYG))
    {
      params = ((n)h.ae(n.class)).bbL().RG(this.username);
      if ((params != null) && ((int)params.jxt > 0) && (com.tencent.mm.contact.d.rk(params.field_type)))
      {
        params.IR(this.lYG);
        ((n)h.ae(n.class)).bbL().c(this.username, params);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90691);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(90689);
    if ((this.fKH == null) || (this.fKH.length() == 0))
    {
      params = q.b.lCy;
      AppMethodBeat.o(90689);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(90689);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bg.b
 * JD-Core Version:    0.7.0.1
 */