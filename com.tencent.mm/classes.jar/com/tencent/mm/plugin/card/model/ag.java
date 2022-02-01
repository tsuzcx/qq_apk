package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efv;
import com.tencent.mm.protocal.protobuf.efw;
import com.tencent.mm.sdk.platformtools.Log;

public final class ag
  extends p
  implements m
{
  private h callback;
  public String content;
  public String hYg;
  public String qWk;
  private final c rr;
  public int status;
  public String wuS;
  public String wuT;
  public boolean wuU;
  public String wuV;
  public String wuW;
  public String wuX;
  public String wuY;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112855);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new efv();
    ((c.a)localObject).otF = new efw();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((c.a)localObject).funcId = 1171;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (efv)c.b.b(this.rr.otB);
    ((efv)localObject).YBh = paramInt;
    ((efv)localObject).YBi = paramString1;
    ((efv)localObject).chatroom_name = paramString2;
    AppMethodBeat.o(112855);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112857);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112857);
    return i;
  }
  
  public final int getType()
  {
    return 1171;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112856);
    Log.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (efw)c.c.b(this.rr.otC);
      this.hYg = params.YBl;
      this.wuS = params.YBm;
      this.status = params.status;
      this.content = params.content;
      this.wuT = params.wul;
      this.qWk = params.background_color;
      this.wuU = params.wuU;
      this.wuV = params.able;
      this.wuW = params.ablf;
      this.wuX = params.ablg;
      this.wuY = params.ablh;
      Log.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.hYg, this.wuS, Integer.valueOf(this.status), this.content, this.wuT, this.qWk, Boolean.valueOf(this.wuU) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */