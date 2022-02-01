package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.protocal.protobuf.exk;
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
  private com.tencent.mm.ak.i callback;
  private com.tencent.mm.ak.d rr;
  public exh zjx;
  
  public i()
  {
    AppMethodBeat.i(66000);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new dae();
    ((d.a)localObject1).iLO = new daf();
    ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((d.a)localObject1).funcId = 1577;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (dae)this.rr.iLK.iLR;
    com.tencent.mm.kernel.g.aAi();
    Object localObject2 = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWB, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((dae)localObject1).MFl = i;
        ((dae)localObject1).language = LocaleUtil.getApplicationLanguage();
        ((dae)localObject1).MFo = Build.VERSION.RELEASE;
        ((dae)localObject1).MFn = ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.KyO);
        ((dae)localObject1).MFp = Build.MANUFACTURER;
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((dae)localObject1).MFl), ((dae)localObject1).language, ((dae)localObject1).MFo, ((dae)localObject1).MFn, ((dae)localObject1).MFp });
        AppMethodBeat.o(66000);
        return;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(66002);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66002);
    return i;
  }
  
  public final String egK()
  {
    if (this.zjx == null) {
      return "";
    }
    return this.zjx.url;
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
      params = (daf)((com.tencent.mm.ak.d)params).iLL.iLR;
      if ((params.MFs == null) || (params.MFt == null)) {
        break label245;
      }
      Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(params.zjs), Integer.valueOf(params.MFs.LSL.size()), Integer.valueOf(params.MFt.LSL.size()) });
      if (params.MFw != null)
      {
        this.zjx = params.MFw;
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(params.MFw.NuH), params.MFw.url });
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXG, Integer.valueOf(params.zjs));
      c.cjL();
      t.fQO().a(params.zjs, params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(66001);
      return;
      label245:
      Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + params.zjs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i
 * JD-Core Version:    0.7.0.1
 */