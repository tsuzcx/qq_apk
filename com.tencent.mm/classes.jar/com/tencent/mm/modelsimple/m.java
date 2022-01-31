package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.sm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.protocal.c.ajf;
import com.tencent.mm.protocal.c.axx;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.ccb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private String account;
  private b dmK;
  private f dmL;
  
  public m(String paramString)
  {
    this.account = paramString;
    b.a locala = new b.a();
    locala.ecH = new aje();
    locala.ecI = new ajf();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.ecG = 302;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((aje)this.dmK.ecE.ecN).hPY = paramString;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    if (bk.bl(this.account))
    {
      y.e("MicroMsg.NetSceneGetProfile", "null or empty username");
      return -1;
    }
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ajf)this.dmK.ecF.ecN;
      paramArrayOfByte = new sm();
      paramArrayOfByte.ccb.ccc = paramq.tfQ.tRt;
      a.udP.m(paramArrayOfByte);
      if ((com.tencent.mm.model.q.Gj().equals(paramq.tfP.sQs.toString())) && (!bk.bl(paramq.tfQ.sLE))) {
        g.DP().Dz().c(ac.a.uoA, paramq.tfQ.sLE);
      }
      y.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(paramq.tfP.tul), Integer.valueOf(paramq.tfQ.tRn) });
      g.DP().Dz().o(64, Integer.valueOf(paramq.tfQ.stS));
      g.DP().Dz().o(144385, Integer.valueOf(paramq.tfQ.tRn));
      g.DP().Dz().o(40, Integer.valueOf(paramq.tfP.tul));
      g.DP().Dz().o(339975, Integer.valueOf(paramq.tfQ.tRv));
      y.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(paramq.tfQ.tRv) });
      g.DP().Dz().c(ac.a.usE, Integer.valueOf(paramq.tfQ.sZT));
      y.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(paramq.tfQ.tRv), Integer.valueOf(paramq.tfQ.sZT) });
      g.DP().Dz().o(208903, paramq.tfQ.sAZ);
      g.DP().Dz().o(274433, paramq.tfQ.ttw);
      g.DP().Dz().o(274434, paramq.tfQ.ttv);
      g.DP().Dz().o(274436, paramq.tfQ.tRo);
      g.DP().Dz().c(ac.a.uqI, bk.aM(paramq.tfQ.cCO, ""));
      g.DP().Dz().c(ac.a.uuM, paramq.tfQ.tRx);
      y.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { paramq.tfQ.cCO });
      at.dVC.Y("last_login_use_voice", paramq.tfP.tul);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(ae.getContext().getContentResolver(), "89884a87498ef44f", paramq.tfQ.tRu);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 302;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.m
 * JD-Core Version:    0.7.0.1
 */