package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fqk;
import com.tencent.mm.protocal.protobuf.fql;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;

public final class af
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.an.d lvf;
  private int retryCount;
  
  public af(String paramString, int paramInt)
  {
    AppMethodBeat.i(150966);
    this.retryCount = 3;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fqk();
    ((d.a)localObject).lBV = new fql();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((d.a)localObject).funcId = 729;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.lvf = ((d.a)localObject).bgN();
    localObject = (fqk)d.b.b(this.lvf.lBR);
    ((fqk)localObject).vhq = LocaleUtil.getApplicationLanguage();
    ((fqk)localObject).RMH = com.tencent.mm.plugin.normsg.a.d.GxJ.aax(0);
    ((fqk)localObject).UOh = paramString;
    ((fqk)localObject).CMR = paramInt;
    Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((fqk)localObject).vhq, paramString, Integer.valueOf(paramInt), Util.getStack() });
    AppMethodBeat.o(150966);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150967);
    this.callback = parami;
    int i = dispatch(paramg, this.lvf, this);
    AppMethodBeat.o(150967);
    return i;
  }
  
  public final int getType()
  {
    return 729;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150968);
    params = (fqk)d.b.b(this.lvf.lBR);
    paramArrayOfByte = (fql)d.c.b(this.lvf.lBS);
    Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.UOi), paramArrayOfByte.UOj });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      h.IzE.idkeyStat(322L, 1L, 1L, false);
      h.IzE.a(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { params.UOh, Integer.valueOf(params.CMR), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
    }
    if ((paramArrayOfByte.UOi == 2) || (paramArrayOfByte.UOi == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        h.IzE.idkeyStat(322L, 2L, 1L, false);
        h.IzE.a(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { params.UOh, Integer.valueOf(params.CMR) }) });
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(150968);
        return;
      }
      Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[] { Integer.valueOf(this.retryCount) });
      doScene(dispatcher(), this.callback);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
      if (paramArrayOfByte.UOi == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.avK()).edit().remove(params.UOh).commit();
        h.IzE.idkeyStat(322L, 5L, 1L, false);
        h.IzE.a(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { params.UOh, Integer.valueOf(params.CMR) }) });
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.UOj });
      }
      else if (paramArrayOfByte.UOi == 4)
      {
        Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        h.IzE.idkeyStat(322L, 4L, 1L, false);
        h.IzE.a(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { params.UOh, Integer.valueOf(params.CMR) }) });
      }
      else
      {
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.UOj });
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.avK()).edit().putString(params.UOh, paramArrayOfByte.UOj).commit();
        h.IzE.idkeyStat(322L, 3L, 1L, false);
        h.IzE.a(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { params.UOh, Integer.valueOf(params.CMR), paramArrayOfByte.UOj }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af
 * JD-Core Version:    0.7.0.1
 */