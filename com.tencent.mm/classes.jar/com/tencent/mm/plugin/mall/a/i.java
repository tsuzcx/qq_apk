package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.protocal.protobuf.gec;
import com.tencent.mm.protocal.protobuf.geg;
import com.tencent.mm.protocal.protobuf.gej;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.w;
import java.util.LinkedList;

public final class i
  extends w
{
  public geg KJm;
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  
  public i()
  {
    AppMethodBeat.i(66000);
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new ecc();
    ((c.a)localObject1).otF = new ecd();
    ((c.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((c.a)localObject1).funcId = 1577;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (ecc)c.b.b(this.rr.otB);
    com.tencent.mm.kernel.h.baF();
    Object localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acLV, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((ecc)localObject1).abhw = i;
        ((ecc)localObject1).language = LocaleUtil.getApplicationLanguage();
        ((ecc)localObject1).abhz = Build.VERSION.RELEASE;
        ((ecc)localObject1).abhy = ChannelUtil.formatVersion(null, d.Yxh);
        ((ecc)localObject1).abhA = Build.MANUFACTURER;
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((ecc)localObject1).abhw), ((ecc)localObject1).language, ((ecc)localObject1).abhz, ((ecc)localObject1).abhy, ((ecc)localObject1).abhA });
        AppMethodBeat.o(66000);
        return;
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(66002);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66002);
    return i;
  }
  
  public final String fZa()
  {
    if (this.KJm == null) {
      return "";
    }
    return this.KJm.url;
  }
  
  public final int getType()
  {
    return 1577;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(262381);
    Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ecd)c.c.b(((com.tencent.mm.am.c)params).otC);
      if ((params.abhD == null) || (params.abhE == null)) {
        break label245;
      }
      Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(params.KJh), Integer.valueOf(params.abhD.aaoI.size()), Integer.valueOf(params.abhE.aaoI.size()) });
      if (params.abhH != null)
      {
        this.KJm = params.abhH;
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(params.abhH.acbR), params.abhH.url });
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNa, Integer.valueOf(params.KJh));
      com.tencent.mm.plugin.base.model.c.cZN();
      u.iiI().a(params.KJh, params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(262381);
      return;
      label245:
      Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + params.KJh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i
 * JD-Core Version:    0.7.0.1
 */