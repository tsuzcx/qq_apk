package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.protocal.protobuf.fhq;
import com.tencent.mm.protocal.protobuf.fhu;
import com.tencent.mm.protocal.protobuf.fhx;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;

public final class i
  extends q
  implements m
{
  public fhu EOO;
  private com.tencent.mm.an.i callback;
  private com.tencent.mm.an.d rr;
  
  public i()
  {
    AppMethodBeat.i(66000);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new djs();
    ((d.a)localObject1).lBV = new djt();
    ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((d.a)localObject1).funcId = 1577;
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (djs)d.b.b(this.rr.lBR);
    h.aHH();
    Object localObject2 = h.aHG().aHp().get(ar.a.VkB, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((djs)localObject1).TQX = i;
        ((djs)localObject1).language = LocaleUtil.getApplicationLanguage();
        ((djs)localObject1).TRa = Build.VERSION.RELEASE;
        ((djs)localObject1).TQZ = ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.RAD);
        ((djs)localObject1).TRb = Build.MANUFACTURER;
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((djs)localObject1).TQX), ((djs)localObject1).language, ((djs)localObject1).TRa, ((djs)localObject1).TQZ, ((djs)localObject1).TRb });
        AppMethodBeat.o(66000);
        return;
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(66002);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66002);
    return i;
  }
  
  public final String eQq()
  {
    if (this.EOO == null) {
      return "";
    }
    return this.EOO.url;
  }
  
  public final int getType()
  {
    return 1577;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66001);
    Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (djt)d.c.b(((com.tencent.mm.an.d)params).lBS);
      if ((params.TRe == null) || (params.TRf == null)) {
        break label245;
      }
      Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(params.EOJ), Integer.valueOf(params.TRe.Tbw.size()), Integer.valueOf(params.TRf.Tbw.size()) });
      if (params.TRi != null)
      {
        this.EOO = params.TRi;
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(params.TRi.UHI), params.TRi.url });
      }
    }
    for (;;)
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.VlG, Integer.valueOf(params.EOJ));
      c.cxc();
      u.gJu().a(params.EOJ, params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(66001);
      return;
      label245:
      Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + params.EOJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i
 * JD-Core Version:    0.7.0.1
 */