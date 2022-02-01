package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.ecv;
import com.tencent.mm.protocal.protobuf.ecz;
import com.tencent.mm.protocal.protobuf.edc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.LinkedList;

public final class i
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b rr;
  public ecz vPt;
  
  public i()
  {
    AppMethodBeat.i(66000);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new cjw();
    ((b.a)localObject1).hQG = new cjx();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((b.a)localObject1).funcId = 1577;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (cjw)this.rr.hQD.hQJ;
    g.ajS();
    Object localObject2 = g.ajR().ajA().get(am.a.IOz, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((cjw)localObject1).Hwm = i;
        ((cjw)localObject1).language = ad.fom();
        ((cjw)localObject1).Hwp = Build.VERSION.RELEASE;
        ((cjw)localObject1).Hwo = com.tencent.mm.sdk.platformtools.k.aD(null, d.FFH);
        ((cjw)localObject1).Hwq = Build.MANUFACTURER;
        ae.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((cjw)localObject1).Hwm), ((cjw)localObject1).language, ((cjw)localObject1).Hwp, ((cjw)localObject1).Hwo, ((cjw)localObject1).Hwq });
        AppMethodBeat.o(66000);
        return;
      }
    }
  }
  
  public final String dmY()
  {
    if (this.vPt == null) {
      return "";
    }
    return this.vPt.url;
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
    ae.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cjx)((b)paramq).hQE.hQJ;
      if ((paramq.Hwt == null) || (paramq.Hwu == null)) {
        break label242;
      }
      ae.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(paramq.vPo), Integer.valueOf(paramq.Hwt.GOH.size()), Integer.valueOf(paramq.Hwu.GOH.size()) });
      if (paramq.Hwx != null)
      {
        this.vPt = paramq.Hwx;
        ae.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(paramq.Hwx.Iid), paramq.Hwx.url });
      }
    }
    for (;;)
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IPF, Integer.valueOf(paramq.vPo));
      t.eJl().a(paramq.vPo, paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(66001);
      return;
      label242:
      ae.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + paramq.vPo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.i
 * JD-Core Version:    0.7.0.1
 */