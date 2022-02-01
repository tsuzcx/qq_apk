package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class as
  extends q
  implements m
{
  private String appId;
  private i callback;
  final d jTk;
  
  public as(String paramString)
  {
    AppMethodBeat.i(41616);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cin();
    ((d.a)localObject).lBV = new cio();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.appId = paramString;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (cin)d.b.b(this.jTk.lBR);
    ((cin)localObject).CPt = LocaleUtil.getApplicationLanguage();
    ((cin)localObject).mVH = Util.getSimCountryCode(MMApplicationContext.getContext());
    ((cin)localObject).lVG = paramString;
    Log.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[] { ((cin)localObject).CPt, ((cin)localObject).mVH, ((cin)localObject).lVG });
    AppMethodBeat.o(41616);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41618);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
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
    if ((cio)d.c.b(((d)params).lBS) == null)
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