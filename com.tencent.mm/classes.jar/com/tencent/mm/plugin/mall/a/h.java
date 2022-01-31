package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class h
  extends m
  implements k
{
  private f callback;
  public cvl oxR;
  private b rr;
  
  public h()
  {
    AppMethodBeat.i(43105);
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new blh();
    ((b.a)localObject1).fsY = new bli();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((b.a)localObject1).funcId = 1577;
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (blh)this.rr.fsV.fta;
    com.tencent.mm.kernel.g.RM();
    Object localObject2 = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yBz, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((blh)localObject1).xzK = i;
        ((blh)localObject1).axa = aa.dsG();
        ((blh)localObject1).xzN = Build.VERSION.RELEASE;
        ((blh)localObject1).xzM = com.tencent.mm.sdk.platformtools.g.au(null, d.whH);
        ((blh)localObject1).xzO = Build.MANUFACTURER;
        ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((blh)localObject1).xzK), ((blh)localObject1).axa, ((blh)localObject1).xzN, ((blh)localObject1).xzM, ((blh)localObject1).xzO });
        AppMethodBeat.o(43105);
        return;
      }
    }
  }
  
  public final String bOr()
  {
    if (this.oxR == null) {
      return "";
    }
    return this.oxR.url;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(43107);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43107);
    return i;
  }
  
  public final int getType()
  {
    return 1577;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43106);
    ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bli)((b)paramq).fsW.fta;
      if ((paramq.xzR == null) || (paramq.xzS == null)) {
        break label242;
      }
      ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(paramq.oxO), Integer.valueOf(paramq.xzR.wZn.size()), Integer.valueOf(paramq.xzS.wZn.size()) });
      if (paramq.xzV != null)
      {
        this.oxR = paramq.xzV;
        ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(paramq.xzV.ydS), paramq.xzV.url });
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCE, Integer.valueOf(paramq.oxO));
      t.cTT().a(paramq.oxO, paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43106);
      return;
      label242:
      ab.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + paramq.oxO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.h
 * JD-Core Version:    0.7.0.1
 */