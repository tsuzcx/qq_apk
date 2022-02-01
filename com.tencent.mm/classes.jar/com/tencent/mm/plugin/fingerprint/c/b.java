package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends d
  implements k
{
  private f callback;
  public final com.tencent.mm.al.b rr;
  private int thJ;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64458);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dho();
    ((b.a)localObject).hNN = new dhp();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((b.a)localObject).funcId = 1638;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dho)this.rr.hNK.hNQ;
    ((dho)localObject).GZd = paramString1;
    ((dho)localObject).signature = paramString2;
    ((dho)localObject).HvZ = paramString3;
    ((dho)localObject).dwF = TenpayUtil.signWith3Des("passwd=" + ((dho)localObject).HvZ);
    ((dho)localObject).HvW = paramInt;
    ((dho)localObject).HvX = 1;
    this.thJ = paramInt;
    ad.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64458);
  }
  
  public final void GC(int paramInt)
  {
    AppMethodBeat.i(64461);
    ad.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64461);
  }
  
  public final void cQb()
  {
    AppMethodBeat.i(64460);
    ad.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64460);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64459);
    ad.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
      if (this.thJ == 1)
      {
        ((a)g.ab(a.class)).my(true);
        ((a)g.ab(a.class)).mz(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(64459);
      return;
      ((a)g.ab(a.class)).mz(true);
      ((a)g.ab(a.class)).my(false);
      continue;
      ad.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(64462);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(64462);
    return i;
  }
  
  public final int getType()
  {
    return 1638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.b
 * JD-Core Version:    0.7.0.1
 */