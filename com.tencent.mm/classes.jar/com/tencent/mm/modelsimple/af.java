package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ffj;
import com.tencent.mm.protocal.protobuf.ffk;
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
  private final com.tencent.mm.ak.d iFd;
  private int retryCount;
  
  public af(String paramString, int paramInt)
  {
    AppMethodBeat.i(150966);
    this.retryCount = 3;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ffj();
    ((d.a)localObject).iLO = new ffk();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((d.a)localObject).funcId = 729;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.iFd = ((d.a)localObject).aXF();
    localObject = (ffj)this.iFd.iLK.iLR;
    ((ffj)localObject).rBI = LocaleUtil.getApplicationLanguage();
    ((ffj)localObject).KLL = com.tencent.mm.plugin.normsg.a.d.AEF.TK(0);
    ((ffj)localObject).NAF = paramString;
    ((ffj)localObject).xIL = paramInt;
    Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((ffj)localObject).rBI, paramString, Integer.valueOf(paramInt), Util.getStack() });
    AppMethodBeat.o(150966);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150967);
    this.callback = parami;
    int i = dispatch(paramg, this.iFd, this);
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
    params = (ffj)this.iFd.iLK.iLR;
    paramArrayOfByte = (ffk)this.iFd.iLL.iLR;
    Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.NAG), paramArrayOfByte.NAH });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      h.CyF.idkeyStat(322L, 1L, 1L, false);
      h.CyF.a(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { params.NAF, Integer.valueOf(params.xIL), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
    }
    if ((paramArrayOfByte.NAG == 2) || (paramArrayOfByte.NAG == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        h.CyF.idkeyStat(322L, 2L, 1L, false);
        h.CyF.a(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { params.NAF, Integer.valueOf(params.xIL) }) });
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
      if (paramArrayOfByte.NAG == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aps()).edit().remove(params.NAF).commit();
        h.CyF.idkeyStat(322L, 5L, 1L, false);
        h.CyF.a(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { params.NAF, Integer.valueOf(params.xIL) }) });
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.NAH });
      }
      else if (paramArrayOfByte.NAG == 4)
      {
        Log.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        h.CyF.idkeyStat(322L, 4L, 1L, false);
        h.CyF.a(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { params.NAF, Integer.valueOf(params.xIL) }) });
      }
      else
      {
        Log.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.NAH });
        MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putString(params.NAF, paramArrayOfByte.NAH).commit();
        h.CyF.idkeyStat(322L, 3L, 1L, false);
        h.CyF.a(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { params.NAF, Integer.valueOf(params.xIL), paramArrayOfByte.NAH }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af
 * JD-Core Version:    0.7.0.1
 */