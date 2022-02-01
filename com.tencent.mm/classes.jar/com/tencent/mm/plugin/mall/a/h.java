package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  public dvj uAK;
  
  public h()
  {
    AppMethodBeat.i(66000);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new ced();
    ((b.a)localObject1).hvu = new cee();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
    ((b.a)localObject1).funcId = 1577;
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (ced)this.rr.hvr.hvw;
    com.tencent.mm.kernel.g.agS();
    Object localObject2 = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHK, Boolean.FALSE);
    if (localObject2 != null) {}
    for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        ((ced)localObject1).FsF = i;
        ((ced)localObject1).aTm = ab.eUO();
        ((ced)localObject1).FsI = Build.VERSION.RELEASE;
        ((ced)localObject1).FsH = i.aA(null, d.DIc);
        ((ced)localObject1).FsJ = Build.MANUFACTURER;
        ac.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[] { Integer.valueOf(((ced)localObject1).FsF), ((ced)localObject1).aTm, ((ced)localObject1).FsI, ((ced)localObject1).FsH, ((ced)localObject1).FsJ });
        AppMethodBeat.o(66000);
        return;
      }
    }
  }
  
  public final String daM()
  {
    if (this.uAK == null) {
      return "";
    }
    return this.uAK.url;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cee)((b)paramq).hvs.hvw;
      if ((paramq.FsM == null) || (paramq.FsN == null)) {
        break label242;
      }
      ac.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", new Object[] { Integer.valueOf(paramq.uAH), Integer.valueOf(paramq.FsM.EMe.size()), Integer.valueOf(paramq.FsN.EMe.size()) });
      if (paramq.FsQ != null)
      {
        this.uAK = paramq.FsQ;
        ac.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", new Object[] { Integer.valueOf(paramq.FsQ.GcQ), paramq.FsQ.url });
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIP, Integer.valueOf(paramq.uAH));
      s.erE().a(paramq.uAH, paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(66001);
      return;
      label242:
      ac.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + paramq.uAH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.h
 * JD-Core Version:    0.7.0.1
 */