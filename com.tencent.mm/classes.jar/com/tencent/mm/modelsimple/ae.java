package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dbx;
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class ae
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b fnd;
  private int retryCount;
  
  public ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(78615);
    this.retryCount = 3;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new dbx();
    ((b.a)localObject).fsY = new dby();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((b.a)localObject).funcId = 729;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fnd = ((b.a)localObject).ado();
    localObject = (dbx)this.fnd.fsV.fta;
    ((dbx)localObject).lGH = aa.dsG();
    ((dbx)localObject).wsn = com.tencent.mm.plugin.normsg.a.b.pgQ.AP(0);
    ((dbx)localObject).yie = paramString;
    ((dbx)localObject).nqd = paramInt;
    ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((dbx)localObject).lGH, paramString, Integer.valueOf(paramInt), bo.dtY() });
    AppMethodBeat.o(78615);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78616);
    this.callback = paramf;
    int i = dispatch(parame, this.fnd, this);
    AppMethodBeat.o(78616);
    return i;
  }
  
  public final int getType()
  {
    return 729;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78617);
    paramq = (dbx)this.fnd.fsV.fta;
    paramArrayOfByte = (dby)this.fnd.fsW.fta;
    ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.yif), paramArrayOfByte.yig });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { paramq.yie, Integer.valueOf(paramq.nqd), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78617);
      return;
    }
    if ((paramArrayOfByte.yif == 2) || (paramArrayOfByte.yif == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        ab.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 2L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { paramq.yie, Integer.valueOf(paramq.nqd) }) });
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(78617);
        return;
      }
      ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[] { Integer.valueOf(this.retryCount) });
      doScene(dispatcher(), this.callback);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78617);
      return;
      if (paramArrayOfByte.yif == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().remove(paramq.yie).commit();
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 5L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { paramq.yie, Integer.valueOf(paramq.nqd) }) });
        ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.yig });
      }
      else if (paramArrayOfByte.yif == 4)
      {
        ab.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { paramq.yie, Integer.valueOf(paramq.nqd) }) });
      }
      else
      {
        ab.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.yig });
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().putString(paramq.yie, paramArrayOfByte.yig).commit();
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 3L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { paramq.yie, Integer.valueOf(paramq.nqd), paramArrayOfByte.yig }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ae
 * JD-Core Version:    0.7.0.1
 */