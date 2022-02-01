package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class ae
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b hpf;
  private int retryCount;
  
  public ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(150966);
    this.retryCount = 3;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ecp();
    ((b.a)localObject).hvu = new ecq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((b.a)localObject).funcId = 729;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hpf = ((b.a)localObject).aAz();
    localObject = (ecp)this.hpf.hvr.hvw;
    ((ecp)localObject).pAD = ab.eUO();
    ((ecp)localObject).DUm = com.tencent.mm.plugin.normsg.a.b.vor.Kw(0);
    ((ecp)localObject).Gie = paramString;
    ((ecp)localObject).ths = paramInt;
    ac.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((ecp)localObject).pAD, paramString, Integer.valueOf(paramInt), bs.eWi() });
    AppMethodBeat.o(150966);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150967);
    this.callback = paramg;
    int i = dispatch(parame, this.hpf, this);
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
    paramq = (ecp)this.hpf.hvr.hvw;
    paramArrayOfByte = (ecq)this.hpf.hvs.hvw;
    ac.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.Gif), paramArrayOfByte.Gig });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      h.wUl.idkeyStat(322L, 1L, 1L, false);
      h.wUl.f(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { paramq.Gie, Integer.valueOf(paramq.ths), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
    }
    if ((paramArrayOfByte.Gif == 2) || (paramArrayOfByte.Gif == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        ac.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        h.wUl.idkeyStat(322L, 2L, 1L, false);
        h.wUl.f(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { paramq.Gie, Integer.valueOf(paramq.ths) }) });
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(150968);
        return;
      }
      ac.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[] { Integer.valueOf(this.retryCount) });
      doScene(dispatcher(), this.callback);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
      if (paramArrayOfByte.Gif == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.YK()).edit().remove(paramq.Gie).commit();
        h.wUl.idkeyStat(322L, 5L, 1L, false);
        h.wUl.f(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { paramq.Gie, Integer.valueOf(paramq.ths) }) });
        ac.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.Gig });
      }
      else if (paramArrayOfByte.Gif == 4)
      {
        ac.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        h.wUl.idkeyStat(322L, 4L, 1L, false);
        h.wUl.f(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { paramq.Gie, Integer.valueOf(paramq.ths) }) });
      }
      else
      {
        ac.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.Gig });
        MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.YK()).edit().putString(paramq.Gie, paramArrayOfByte.Gig).commit();
        h.wUl.idkeyStat(322L, 3L, 1L, false);
        h.wUl.f(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { paramq.Gie, Integer.valueOf(paramq.ths), paramArrayOfByte.Gig }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ae
 * JD-Core Version:    0.7.0.1
 */