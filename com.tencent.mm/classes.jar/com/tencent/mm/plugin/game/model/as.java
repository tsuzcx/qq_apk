package com.tencent.mm.plugin.game.model;

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
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class as
  extends p
  implements m
{
  private String appId;
  private h callback;
  final c mtC;
  
  public as(String paramString)
  {
    AppMethodBeat.i(41616);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cyq();
    ((c.a)localObject).otF = new cyr();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.appId = paramString;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (cyq)c.b.b(this.mtC.otB);
    ((cyq)localObject).IJD = LocaleUtil.getApplicationLanguage();
    ((cyq)localObject).pSo = Util.getSimCountryCode(MMApplicationContext.getContext());
    ((cyq)localObject).oOI = paramString;
    Log.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[] { ((cyq)localObject).IJD, ((cyq)localObject).pSo, ((cyq)localObject).oOI });
    AppMethodBeat.o(41616);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(41618);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41618);
    return i;
  }
  
  public final int getType()
  {
    return 1369;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41617);
    Log.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(41617);
      return;
    }
    if ((cyr)c.c.b(((c)params).otC) == null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(41617);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.as
 * JD-Core Version:    0.7.0.1
 */