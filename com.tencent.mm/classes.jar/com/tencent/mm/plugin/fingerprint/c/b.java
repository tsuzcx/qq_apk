package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends d
  implements k
{
  private com.tencent.mm.ak.g callback;
  public final com.tencent.mm.ak.b rr;
  private int slh;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64458);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dcb();
    ((b.a)localObject).hvu = new dcc();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((b.a)localObject).funcId = 1638;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dcb)this.rr.hvr.hvw;
    ((dcb)localObject).Fpt = paramString1;
    ((dcb)localObject).signature = paramString2;
    ((dcb)localObject).FLr = paramString3;
    ((dcb)localObject).dkS = TenpayUtil.signWith3Des("passwd=" + ((dcb)localObject).FLr);
    ((dcb)localObject).FLo = paramInt;
    ((dcb)localObject).FLp = 1;
    this.slh = paramInt;
    ac.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64458);
  }
  
  public final void Fn(int paramInt)
  {
    AppMethodBeat.i(64461);
    ac.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64461);
  }
  
  public final void cHM()
  {
    AppMethodBeat.i(64460);
    ac.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64460);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64459);
    ac.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
      if (this.slh == 1)
      {
        ((a)com.tencent.mm.kernel.g.ab(a.class)).mh(true);
        ((a)com.tencent.mm.kernel.g.ab(a.class)).mi(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(64459);
      return;
      ((a)com.tencent.mm.kernel.g.ab(a.class)).mi(true);
      ((a)com.tencent.mm.kernel.g.ab(a.class)).mh(false);
      continue;
      ac.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.b
 * JD-Core Version:    0.7.0.1
 */