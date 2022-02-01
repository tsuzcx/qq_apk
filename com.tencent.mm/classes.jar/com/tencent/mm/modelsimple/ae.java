package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class ae
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private final com.tencent.mm.al.b gOF;
  private int retryCount;
  
  public ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(150966);
    this.retryCount = 3;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dwy();
    ((b.a)localObject).gUV = new dwz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((b.a)localObject).funcId = 729;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gOF = ((b.a)localObject).atI();
    localObject = (dwy)this.gOF.gUS.gUX;
    ((dwy)localObject).oXs = ac.eFu();
    ((dwy)localObject).CBO = com.tencent.mm.plugin.normsg.a.b.ufs.Ix(0);
    ((dwy)localObject).EKS = paramString;
    ((dwy)localObject).rZz = paramInt;
    ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((dwy)localObject).oXs, paramString, Integer.valueOf(paramInt), bt.eGN() });
    AppMethodBeat.o(150966);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150967);
    this.callback = paramg;
    int i = dispatch(parame, this.gOF, this);
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
    paramq = (dwy)this.gOF.gUS.gUX;
    paramArrayOfByte = (dwz)this.gOF.gUT.gUX;
    ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.EKT), paramArrayOfByte.EKU });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      h.vKh.idkeyStat(322L, 1L, 1L, false);
      h.vKh.f(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { paramq.EKS, Integer.valueOf(paramq.rZz), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150968);
      return;
    }
    if ((paramArrayOfByte.EKT == 2) || (paramArrayOfByte.EKT == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        ad.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        h.vKh.idkeyStat(322L, 2L, 1L, false);
        h.vKh.f(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { paramq.EKS, Integer.valueOf(paramq.rZz) }) });
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
      if (paramArrayOfByte.EKT == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.XN()).edit().remove(paramq.EKS).commit();
        h.vKh.idkeyStat(322L, 5L, 1L, false);
        h.vKh.f(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { paramq.EKS, Integer.valueOf(paramq.rZz) }) });
        ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.EKU });
      }
      else if (paramArrayOfByte.EKT == 4)
      {
        ad.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        h.vKh.idkeyStat(322L, 4L, 1L, false);
        h.vKh.f(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { paramq.EKS, Integer.valueOf(paramq.rZz) }) });
      }
      else
      {
        ad.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.EKU });
        MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.XN()).edit().putString(paramq.EKS, paramArrayOfByte.EKU).commit();
        h.vKh.idkeyStat(322L, 3L, 1L, false);
        h.vKh.f(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { paramq.EKS, Integer.valueOf(paramq.rZz), paramArrayOfByte.EKU }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ae
 * JD-Core Version:    0.7.0.1
 */