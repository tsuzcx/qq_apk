package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.sdk.platformtools.Log;

public final class aj
  extends p
  implements m
{
  private h callback;
  public boolean nxG;
  private final c rr;
  public b wuZ;
  public String wuy;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, b paramb)
  {
    AppMethodBeat.i(112864);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cen();
    ((c.a)localObject).otF = new ceo();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((c.a)localObject).funcId = 1059;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cen)c.b.b(this.rr.otB);
    ((cen)localObject).app_id = paramString1;
    ((cen)localObject).wDd = paramInt1;
    ((cen)localObject).wDe = paramString2;
    ((cen)localObject).wDf = paramString3;
    ((cen)localObject).time_stamp = paramInt2;
    ((cen)localObject).wDg = paramString4;
    ((cen)localObject).wsy = paramString5;
    ((cen)localObject).wDh = paramString6;
    ((cen)localObject).wuZ = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((cen)localObject).aaoA = 1;
      AppMethodBeat.o(112864);
      return;
    }
    ((cen)localObject).aaoA = 0;
    AppMethodBeat.o(112864);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112865);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112865);
    return i;
  }
  
  public final int getType()
  {
    return 1059;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112866);
    Log.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ceo)c.c.b(this.rr.otC);
      this.wuy = params.wuy;
      this.wuZ = params.wuZ;
      if (params.aaoB == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.nxG = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */