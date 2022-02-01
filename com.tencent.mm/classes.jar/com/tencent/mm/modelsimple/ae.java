package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class ae
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b hHx;
  private int retryCount;
  
  public ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(150966);
    this.retryCount = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new eiv();
    ((b.a)localObject).hNN = new eiw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((b.a)localObject).funcId = 729;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hHx = ((b.a)localObject).aDC();
    localObject = (eiv)this.hHx.hNK.hNQ;
    ((eiv)localObject).qei = ac.fks();
    ((eiv)localObject).FzG = com.tencent.mm.plugin.normsg.a.b.wtJ.LY(0);
    ((eiv)localObject).HTs = paramString;
    ((eiv)localObject).ufj = paramInt;
    ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((eiv)localObject).qei, paramString, Integer.valueOf(paramInt), bt.flS() });
    AppMethodBeat.o(150966);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150967);
    this.callback = paramf;
    int i = dispatch(parame, this.hHx, this);
    AppMethodBeat.o(150967);
    return i;
  }
  
  public final int getType()
  {
    return 729;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150968);
    paramq = (eiv)this.hHx.hNK.hNQ;
    paramArrayOfByte = (eiw)this.hHx.hNL.hNQ;
    ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.HTt), paramArrayOfByte.HTu });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { paramq.HTs, Integer.valueOf(paramq.ufj), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
    }
    if ((paramArrayOfByte.HTt == 2) || (paramArrayOfByte.HTt == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        ad.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 2L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { paramq.HTs, Integer.valueOf(paramq.ufj) }) });
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(150968);
        return;
      }
      ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[] { Integer.valueOf(this.retryCount) });
      doScene(dispatcher(), this.callback);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
      if (paramArrayOfByte.HTt == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abm()).edit().remove(paramq.HTs).commit();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 5L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { paramq.HTs, Integer.valueOf(paramq.ufj) }) });
        ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.HTu });
      }
      else if (paramArrayOfByte.HTt == 4)
      {
        ad.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { paramq.HTs, Integer.valueOf(paramq.ufj) }) });
      }
      else
      {
        ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.HTu });
        MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abm()).edit().putString(paramq.HTs, paramArrayOfByte.HTu).commit();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 3L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { paramq.HTs, Integer.valueOf(paramq.ufj), paramArrayOfByte.HTu }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ae
 * JD-Core Version:    0.7.0.1
 */