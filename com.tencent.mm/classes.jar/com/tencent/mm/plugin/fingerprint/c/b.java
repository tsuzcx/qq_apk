package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends d
  implements k
{
  private f callback;
  private int mGE;
  public final com.tencent.mm.ai.b rr;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(41573);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cfq();
    ((b.a)localObject).fsY = new cfr();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((b.a)localObject).funcId = 1638;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cfq)this.rr.fsV.fta;
    ((cfq)localObject).xxA = paramString1;
    ((cfq)localObject).signature = paramString2;
    ((cfq)localObject).xPY = paramString3;
    ((cfq)localObject).cxF = TenpayUtil.signWith3Des("passwd=" + ((cfq)localObject).xPY);
    ((cfq)localObject).xPV = paramInt;
    ((cfq)localObject).xPW = 1;
    this.mGE = paramInt;
    ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(41573);
  }
  
  public final void bzB()
  {
    AppMethodBeat.i(41575);
    ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(41575);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41574);
    ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
      if (this.mGE == 1)
      {
        ((l)g.E(l.class)).hH(true);
        ((l)g.E(l.class)).hI(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(41574);
      return;
      ((l)g.E(l.class)).hI(true);
      ((l)g.E(l.class)).hH(false);
      continue;
      ab.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41577);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41577);
    return i;
  }
  
  public final int getType()
  {
    return 1638;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(41576);
    ab.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(41576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.b
 * JD-Core Version:    0.7.0.1
 */