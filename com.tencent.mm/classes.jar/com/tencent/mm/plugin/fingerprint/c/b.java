package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.cwp;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends d
  implements k
{
  private com.tencent.mm.al.g callback;
  private int rcN;
  public final com.tencent.mm.al.b rr;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64458);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cwp();
    ((b.a)localObject).gUV = new cwq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((b.a)localObject).funcId = 1638;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cwp)this.rr.gUS.gUX;
    ((cwp)localObject).DSX = paramString1;
    ((cwp)localObject).signature = paramString2;
    ((cwp)localObject).Eos = paramString3;
    ((cwp)localObject).dnk = TenpayUtil.signWith3Des("passwd=" + ((cwp)localObject).Eos);
    ((cwp)localObject).Eop = paramInt;
    ((cwp)localObject).Eoq = 1;
    this.rcN = paramInt;
    ad.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64458);
  }
  
  public final void Dr(int paramInt)
  {
    AppMethodBeat.i(64461);
    ad.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64461);
  }
  
  public final void cuA()
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
      if (this.rcN == 1)
      {
        ((a)com.tencent.mm.kernel.g.ab(a.class)).lp(true);
        ((a)com.tencent.mm.kernel.g.ab(a.class)).lq(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(64459);
      return;
      ((a)com.tencent.mm.kernel.g.ab(a.class)).lq(true);
      ((a)com.tencent.mm.kernel.g.ab(a.class)).lp(false);
      continue;
      ad.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(64462);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(64462);
    return i;
  }
  
  public final int getType()
  {
    return 1638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.b
 * JD-Core Version:    0.7.0.1
 */