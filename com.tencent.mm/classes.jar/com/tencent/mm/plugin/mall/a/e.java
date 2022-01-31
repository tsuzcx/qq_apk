package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.chx;
import com.tencent.mm.protocal.c.chz;
import com.tencent.mm.protocal.c.cic;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public chz lYq;
  
  public e()
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new bdn();
    ((b.a)localObject1).ecI = new bdo();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((b.a)localObject1).ecG = 1577;
    this.dmK = ((b.a)localObject1).Kt();
    localObject1 = (bdn)this.dmK.ecE.ecN;
    g.DQ();
    Object localObject2 = g.DP().Dz().get(ac.a.urA, Boolean.valueOf(false));
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((bdn)localObject1).tyC = i;
        ((bdn)localObject1).auI = x.cqJ();
        ((bdn)localObject1).tyF = Build.VERSION.RELEASE;
        ((bdn)localObject1).tyE = com.tencent.mm.sdk.platformtools.e.ag(null, d.spa);
        ((bdn)localObject1).tyG = Build.MANUFACTURER;
        y.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((bdn)localObject1).tyC), ((bdn)localObject1).auI, ((bdn)localObject1).tyF, ((bdn)localObject1).tyE, ((bdn)localObject1).tyG });
        return;
      }
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bdo)((b)paramq).ecF.ecN;
      if ((paramq.tyJ == null) || (paramq.tyK == null)) {
        break label232;
      }
      y.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(paramq.lYn), Integer.valueOf(paramq.tyJ.taW.size()), Integer.valueOf(paramq.tyK.taW.size()) });
      if (paramq.tyN != null)
      {
        this.lYq = paramq.tyN;
        y.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(paramq.tyN.tWA), paramq.tyN.url });
      }
    }
    for (;;)
    {
      g.DQ();
      g.DP().Dz().c(ac.a.usE, Integer.valueOf(paramq.lYn));
      o.bVy().a(paramq.lYn, paramq);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label232:
      y.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + paramq.lYn);
    }
  }
  
  public final String bgy()
  {
    if (this.lYq == null) {
      return "";
    }
    return this.lYq.url;
  }
  
  public final int getType()
  {
    return 1577;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.e
 * JD-Core Version:    0.7.0.1
 */