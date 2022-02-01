package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.ae;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends d
  implements k
{
  private f callback;
  public final com.tencent.mm.ak.b rr;
  private int tsC;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64458);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dii();
    ((b.a)localObject).hQG = new dij();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((b.a)localObject).funcId = 1638;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dii)this.rr.hQD.hQJ;
    ((dii)localObject).HsE = paramString1;
    ((dii)localObject).signature = paramString2;
    ((dii)localObject).HPC = paramString3;
    ((dii)localObject).dxK = TenpayUtil.signWith3Des("passwd=" + ((dii)localObject).HPC);
    ((dii)localObject).HPz = paramInt;
    ((dii)localObject).HPA = 1;
    this.tsC = paramInt;
    ae.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64458);
  }
  
  public final void GZ(int paramInt)
  {
    AppMethodBeat.i(64461);
    ae.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64461);
  }
  
  public final void cSG()
  {
    AppMethodBeat.i(64460);
    ae.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64460);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64459);
    ae.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
      if (this.tsC == 1)
      {
        ((a)g.ab(a.class)).mC(true);
        ((a)g.ab(a.class)).mD(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(64459);
      return;
      ((a)g.ab(a.class)).mD(true);
      ((a)g.ab(a.class)).mC(false);
      continue;
      ae.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
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