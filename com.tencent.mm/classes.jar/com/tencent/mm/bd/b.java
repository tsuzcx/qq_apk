package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ena;
import com.tencent.mm.protocal.protobuf.enb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;

public final class b
  extends q
  implements m
{
  private int bNu;
  private i callback;
  private String clientId;
  private String dRr;
  private int iKP;
  public String jid;
  private d rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(90688);
    this.username = paramString;
    this.iKP = 0;
    this.bNu = 0;
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    this.clientId = (a.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(90688);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.dRr = paramString2;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(90690);
    this.callback = parami;
    if ((this.dRr == null) || (this.dRr.length() == 0))
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(90690);
      return -1;
    }
    if (!com.tencent.mm.vfs.s.YS(this.dRr))
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.dRr);
      AppMethodBeat.o(90690);
      return -1;
    }
    if (this.iKP == 0) {
      this.iKP = ((int)new o(this.dRr).length());
    }
    parami = new d.a();
    parami.iLN = new ena();
    parami.iLO = new enb();
    parami.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    parami.funcId = 575;
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    int i = Math.min(this.iKP - this.bNu, 32768);
    parami = com.tencent.mm.vfs.s.aW(this.dRr, this.bNu, i);
    if (parami == null)
    {
      Log.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(90690);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(parami.length), Integer.valueOf(this.iKP) });
    ena localena = (ena)this.rr.iLK.iLR;
    localena.Lqx = this.username;
    localena.BsF = this.iKP;
    localena.BsG = this.bNu;
    localena.BsI = new SKBuiltinBuffer_t().setBuffer(parami);
    localena.BsH = localena.BsI.getILen();
    localena.izX = this.clientId;
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(90690);
    return i;
  }
  
  public final int getType()
  {
    return 575;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
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
    params = (enb)((d)params).iLL.iLR;
    this.jid = params.Mvw;
    this.bNu = params.BsG;
    if (this.bNu < this.iKP)
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
    if (!Util.isNullOrNil(this.jid))
    {
      params = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.username);
      if ((params != null) && ((int)params.gMZ > 0) && (c.oR(params.field_type)))
      {
        params.Cd(this.jid);
        ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().c(this.username, params);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90691);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(90689);
    if ((this.dRr == null) || (this.dRr.length() == 0))
    {
      params = q.b.iMr;
      AppMethodBeat.o(90689);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(90689);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.b
 * JD-Core Version:    0.7.0.1
 */