package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cnp;
import com.tencent.mm.protocal.c.cnq;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class ad
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dWV;
  private f dmL;
  private int retryCount = 3;
  
  public ad(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cnp();
    ((b.a)localObject).ecI = new cnq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/yybgetpkgsig";
    ((b.a)localObject).ecG = 729;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dWV = ((b.a)localObject).Kt();
    localObject = (cnp)this.dWV.ecE.ecN;
    ((cnp)localObject).jxi = x.cqJ();
    ((cnp)localObject).syF = com.tencent.mm.plugin.normsg.a.b.mGK.vr(0);
    ((cnp)localObject).ual = paramString;
    ((cnp)localObject).kSc = paramInt;
    y.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig Language[%s], PkgName[%s], versionCode[%d], stack[%s]", new Object[] { ((cnp)localObject).jxi, paramString, Integer.valueOf(paramInt), bk.csb() });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dWV, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (cnp)this.dWV.ecE.ecN;
    paramArrayOfByte = (cnq)this.dWV.ecF.ecN;
    y.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s], ret[%d], sig[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramArrayOfByte.uam), paramArrayOfByte.uan });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken YybGetPkgSig err and return!");
      h.nFQ.a(322L, 1L, 1L, false);
      h.nFQ.f(11098, new Object[] { Integer.valueOf(4001), String.format("%s,%d,%d,%d", new Object[] { paramq.ual, Integer.valueOf(paramq.kSc), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramArrayOfByte.uam == 2) || (paramArrayOfByte.uam == 3))
    {
      this.retryCount -= 1;
      if (this.retryCount <= 0)
      {
        y.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken err and return with no try!");
        h.nFQ.a(322L, 2L, 1L, false);
        h.nFQ.f(11098, new Object[] { Integer.valueOf(4002), String.format("%s,%d", new Object[] { paramq.ual, Integer.valueOf(paramq.kSc) }) });
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      y.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken do scene again retryCount:%d", new Object[] { Integer.valueOf(this.retryCount) });
      a(this.edc, this.dmL);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      if (paramArrayOfByte.uam == 1)
      {
        MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "yyb_pkg_sig_prefs", 4).edit().remove(paramq.ual).commit();
        h.nFQ.a(322L, 5L, 1L, false);
        h.nFQ.f(11098, new Object[] { Integer.valueOf(4005), String.format("%s,%d", new Object[] { paramq.ual, Integer.valueOf(paramq.kSc) }) });
        y.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no sig[%s] and remove", new Object[] { paramArrayOfByte.uan });
      }
      else if (paramArrayOfByte.uam == 4)
      {
        y.w("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret no need try and revise");
        h.nFQ.a(322L, 4L, 1L, false);
        h.nFQ.f(11098, new Object[] { Integer.valueOf(4004), String.format("%s,%d", new Object[] { paramq.ual, Integer.valueOf(paramq.kSc) }) });
      }
      else
      {
        y.i("MicroMsg.NetSceneYybGetPkgSig", "summertoken ret sig[%s]", new Object[] { paramArrayOfByte.uan });
        MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "yyb_pkg_sig_prefs", 4).edit().putString(paramq.ual, paramArrayOfByte.uan).commit();
        h.nFQ.a(322L, 3L, 1L, false);
        h.nFQ.f(11098, new Object[] { Integer.valueOf(4003), String.format("%s,%d,%s", new Object[] { paramq.ual, Integer.valueOf(paramq.kSc), paramArrayOfByte.uan }) });
      }
    }
  }
  
  public final int getType()
  {
    return 729;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ad
 * JD-Core Version:    0.7.0.1
 */