package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ekm;
import com.tencent.mm.protocal.protobuf.ekn;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class af
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b hKp;
  private int retryCount;
  
  public af(String paramString, int paramInt)
  {
    AppMethodBeat.i(150966);
    this.retryCount = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ekm();
    ((b.a)localObject).hQG = new ekn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((b.a)localObject).funcId = 729;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hKp = ((b.a)localObject).aDS();
    localObject = (ekm)this.hKp.hQD.hQJ;
    ((ekm)localObject).qkN = ad.fom();
    ((ekm)localObject).FSe = com.tencent.mm.plugin.normsg.a.b.wJt.MD(0);
    ((ekm)localObject).Inz = paramString;
    ((ekm)localObject).uqt = paramInt;
    ae.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((ekm)localObject).qkN, paramString, Integer.valueOf(paramInt), bu.fpN() });
    AppMethodBeat.o(150966);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150967);
    this.callback = paramf;
    int i = dispatch(parame, this.hKp, this);
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
    paramq = (ekm)this.hKp.hQD.hQJ;
    paramArrayOfByte = (ekn)this.hKp.hQE.hQJ;
    ae.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.InA), paramArrayOfByte.InB });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { paramq.Inz, Integer.valueOf(paramq.uqt), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
    }
    if ((paramArrayOfByte.InA == 2) || (paramArrayOfByte.InA == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        ae.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 2L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { paramq.Inz, Integer.valueOf(paramq.uqt) }) });
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(150968);
        return;
      }
      ae.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[] { Integer.valueOf(this.retryCount) });
      doScene(dispatcher(), this.callback);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
      if (paramArrayOfByte.InA == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abv()).edit().remove(paramq.Inz).commit();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 5L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { paramq.Inz, Integer.valueOf(paramq.uqt) }) });
        ae.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.InB });
      }
      else if (paramArrayOfByte.InA == 4)
      {
        ae.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { paramq.Inz, Integer.valueOf(paramq.uqt) }) });
      }
      else
      {
        ae.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.InB });
        MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.abv()).edit().putString(paramq.Inz, paramArrayOfByte.InB).commit();
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 3L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { paramq.Inz, Integer.valueOf(paramq.uqt), paramArrayOfByte.InB }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af
 * JD-Core Version:    0.7.0.1
 */