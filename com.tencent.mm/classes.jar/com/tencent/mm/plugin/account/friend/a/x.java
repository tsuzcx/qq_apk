package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.so;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.protocal.c.ib;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class x
  extends m
  implements k
{
  private String bPS = null;
  private String bPU = null;
  public final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  private int edu = 2;
  
  public x(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ia();
    ((b.a)localObject).ecI = new ib();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((b.a)localObject).ecG = 132;
    ((b.a)localObject).ecJ = 45;
    ((b.a)localObject).ecK = 1000000045;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ia)this.dmK.ecE.ecN;
    ((ia)localObject).syV = paramInt1;
    ((ia)localObject).sBo = paramInt2;
    ((ia)localObject).sBp = paramString3;
    if ((bk.bl(this.bPS)) && (bk.bl(this.bPU)))
    {
      if (com.tencent.mm.sdk.platformtools.e.uen)
      {
        paramString3 = ae.getContext().getString(a.h.safe_device_android_device_nm);
        ((ia)localObject).sBr = paramString3;
        ((ia)localObject).sBs = d.DEVICE_NAME;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label296;
      }
      g.DP().Dz().o(4097, paramString1);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((ia)localObject).sBm = paramString1;
      ((ia)localObject).sBn = paramString2;
      ((ia)localObject).jxi = com.tencent.mm.sdk.platformtools.x.cqJ();
      return;
      paramString3 = ae.getContext().getString(a.h.safe_device_android_device);
      break;
      label296:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)g.DP().Dz().get(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)g.DP().Dz().get(6, null);
      }
    }
  }
  
  public x(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    this.bPS = paramString4;
    this.bPU = paramString5;
    paramString1 = (ia)this.dmK.ecE.ecN;
    paramString1.sBr = paramString4;
    paramString1.sBs = paramString5;
  }
  
  public final String NJ()
  {
    return ((ib)this.dmK.ecF.ecN).bJY;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (ia)this.dmK.ecE.ecN;
    if ((paramf.sBm == null) || (paramf.sBm.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + paramf.sBm);
      return -1;
    }
    if (((paramf.syV == 2) || (paramf.syV == 19)) && ((paramf.sBn == null) || (paramf.sBn.length() <= 0)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + paramf.sBm);
      return -1;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramq = (ia)this.dmK.ecE.ecN;
    paramArrayOfByte = (ib)this.dmK.ecF.ecN;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.syx;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.DQ();
      g.DP().dKo.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.e locale = g.DO().dJT.edx;
      if (locale != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label219;
        }
        bool = true;
        locale.bR(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.edu) });
          this.edu -= 1;
          if (this.edu <= 0)
          {
            this.dmL.onSceneEnd(3, -1, "", this);
            return;
            label219:
            bool = false;
            break;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[] { paramArrayOfByte });
            continue;
          }
          a(this.edc, this.dmL);
          return;
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    }
    if (paramArrayOfByte != null) {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.sBA + "safedevice status = " + paramArrayOfByte.stS);
    }
    if ((paramq.syV == 2) || (paramq.syV == 4) || (paramq.syV == 11) || (paramq.syV == 19))
    {
      g.DP().Dz().o(4097, "");
      paramArrayOfByte = (String)g.DP().Dz().get(6, "");
      g.DP().Dz().o(6, paramq.sBm);
      if ((!bk.bl(paramArrayOfByte)) && (g.DP().Dz().get(ac.a.uze, "").equals(paramArrayOfByte)))
      {
        g.DP().Dz().c(ac.a.uze, com.tencent.mm.model.q.Gj());
        at.dVC.Y("login_user_name", com.tencent.mm.model.q.Gj());
      }
      if ((bk.bl(this.bPS)) || (bk.bl(this.bPU))) {
        l.WM();
      }
      if (paramq.syV == 19) {
        g.DP().Dz().o(12322, null);
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      if (paramq.syV == 3)
      {
        g.DP().Dz().o(4097, "");
        paramq = (String)g.DP().Dz().get(6, "");
        g.DP().Dz().o(6, "");
        if ((!bk.bl(paramq)) && (g.DP().Dz().get(ac.a.uze, null).equals(paramq)))
        {
          g.DP().Dz().c(ac.a.uze, com.tencent.mm.model.q.Gj());
          at.dVC.Y("login_user_name", com.tencent.mm.model.q.Gj());
        }
        g.DP().Dz().o(12322, null);
        g.DP().Dz().o(64, Integer.valueOf(paramArrayOfByte.stS));
        paramq = new so();
        paramq.ccd.cce = false;
        paramq.ccd.ccf = true;
        a.udP.m(paramq);
        l.WT();
        l.WU();
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
  
  public final int getType()
  {
    return 132;
  }
  
  public final int rN()
  {
    return ((ia)this.dmK.ecE.ecN).syV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.x
 * JD-Core Version:    0.7.0.1
 */