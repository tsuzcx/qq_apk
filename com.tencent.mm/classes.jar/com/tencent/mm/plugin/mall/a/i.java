package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private f callback;
  private b rr;
  public ebi vDp;
  
  public i()
  {
    AppMethodBeat.i(66000);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new cjc();
    ((b.a)localObject1).hNN = new cjd();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((b.a)localObject1).funcId = 1577;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (cjc)this.rr.hNK.hNQ;
    g.ajD();
    Object localObject2 = g.ajC().ajl().get(al.a.Iuc, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((cjc)localObject1).HcM = i;
        ((cjc)localObject1).language = ac.fks();
        ((cjc)localObject1).HcP = Build.VERSION.RELEASE;
        ((cjc)localObject1).HcO = com.tencent.mm.sdk.platformtools.j.aD(null, d.Fnj);
        ((cjc)localObject1).HcQ = Build.MANUFACTURER;
        ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((cjc)localObject1).HcM), ((cjc)localObject1).language, ((cjc)localObject1).HcP, ((cjc)localObject1).HcO, ((cjc)localObject1).HcQ });
        AppMethodBeat.o(66000);
        return;
      }
    }
  }
  
  public final String djZ()
  {
    if (this.vDp == null) {
      return "";
    }
    return this.vDp.url;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(66002);
    this.callback = paramf;
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
      paramq = (cjd)((b)paramq).hNL.hNQ;
      if ((paramq.HcT == null) || (paramq.HcU == null)) {
        break label242;
      }
      ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(paramq.vDk), Integer.valueOf(paramq.HcT.Gvi.size()), Integer.valueOf(paramq.HcU.Gvi.size()) });
      if (paramq.HcX != null)
      {
        this.vDp = paramq.HcX;
        ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(paramq.HcX.HNW), paramq.HcX.url });
      }
    }
    for (;;)
    {
      g.ajD();
      g.ajC().ajl().set(al.a.Ivh, Integer.valueOf(paramq.vDk));
      t.eFE().a(paramq.vDk, paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(66001);
      return;
      label242:
      ad.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + paramq.vDk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i
 * JD-Core Version:    0.7.0.1
 */