package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.protobuf.gnt;
import com.tencent.mm.protocal.protobuf.gnu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c omC;
  private int retryCount;
  
  public ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(150966);
    this.retryCount = 3;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new gnt();
    ((c.a)localObject).otF = new gnu();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((c.a)localObject).funcId = 729;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.omC = ((c.a)localObject).bEF();
    localObject = (gnt)c.b.b(this.omC.otB);
    ((gnt)localObject).yts = LocaleUtil.getApplicationLanguage();
    ((gnt)localObject).YJV = d.MtP.aeQ(0);
    ((gnt)localObject).aciJ = paramString;
    ((gnt)localObject).IGW = paramInt;
    Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((gnt)localObject).yts, paramString, Integer.valueOf(paramInt), Util.getStack() });
    AppMethodBeat.o(150966);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150967);
    this.callback = paramh;
    int i = dispatch(paramg, this.omC, this);
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
    params = (gnt)c.b.b(this.omC.otB);
    paramArrayOfByte = (gnu)c.c.b(this.omC.otC);
    Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.aciK), paramArrayOfByte.aciL });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { params.aciJ, Integer.valueOf(params.IGW), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
    }
    if ((paramArrayOfByte.aciK == 2) || (paramArrayOfByte.aciK == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 2L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { params.aciJ, Integer.valueOf(params.IGW) }) });
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
      if (paramArrayOfByte.aciK == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().remove(params.aciJ).commit();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 5L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { params.aciJ, Integer.valueOf(params.IGW) }) });
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.aciL });
      }
      else if (paramArrayOfByte.aciK == 4)
      {
        Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { params.aciJ, Integer.valueOf(params.IGW) }) });
      }
      else
      {
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.aciL });
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().putString(params.aciJ, paramArrayOfByte.aciL).commit();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(322L, 3L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.b(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { params.aciJ, Integer.valueOf(params.IGW), paramArrayOfByte.aciL }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */