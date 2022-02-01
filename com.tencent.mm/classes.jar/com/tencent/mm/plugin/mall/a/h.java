package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private b rr;
  public dps tsr;
  
  public h()
  {
    AppMethodBeat.i(66000);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new bzh();
    ((b.a)localObject1).gUV = new bzi();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((b.a)localObject1).funcId = 1577;
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (bzh)this.rr.gUS.gUX;
    com.tencent.mm.kernel.g.afC();
    Object localObject2 = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FjV, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((bzh)localObject1).DVR = i;
        ((bzh)localObject1).aSt = ac.eFu();
        ((bzh)localObject1).DVU = Build.VERSION.RELEASE;
        ((bzh)localObject1).DVT = i.au(null, d.CpK);
        ((bzh)localObject1).DVV = Build.MANUFACTURER;
        ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((bzh)localObject1).DVR), ((bzh)localObject1).aSt, ((bzh)localObject1).DVU, ((bzh)localObject1).DVT, ((bzh)localObject1).DVV });
        AppMethodBeat.o(66000);
        return;
      }
    }
  }
  
  public final String cNf()
  {
    if (this.tsr == null) {
      return "";
    }
    return this.tsr.url;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(66002);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66002);
    return i;
  }
  
  public final int getType()
  {
    return 1577;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66001);
    ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bzi)((b)paramq).gUT.gUX;
      if ((paramq.DVY == null) || (paramq.DVZ == null)) {
        break label242;
      }
      ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(paramq.tso), Integer.valueOf(paramq.DVY.Drc.size()), Integer.valueOf(paramq.DVZ.Drc.size()) });
      if (paramq.DWc != null)
      {
        this.tsr = paramq.DWc;
        ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(paramq.DWc.EFE), paramq.DWc.url });
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fla, Integer.valueOf(paramq.tso));
      s.eci().a(paramq.tso, paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(66001);
      return;
      label242:
      ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + paramq.tso);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.h
 * JD-Core Version:    0.7.0.1
 */