package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.protocal.protobuf.ebs;
import com.tencent.mm.protocal.protobuf.ebt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends com.tencent.mm.plugin.soter.b.d
  implements m
{
  private i callback;
  public final com.tencent.mm.ak.d rr;
  private int wGi;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64458);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ebs();
    ((d.a)localObject).iLO = new ebt();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((d.a)localObject).funcId = 1638;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ebs)this.rr.iLK.iLR;
    ((ebs)localObject).MBA = paramString1;
    ((ebs)localObject).signature = paramString2;
    ((ebs)localObject).Nbu = paramString3;
    ((ebs)localObject).dPr = TenpayUtil.signWith3Des("passwd=" + ((ebs)localObject).Nbu);
    ((ebs)localObject).Nbr = paramInt;
    ((ebs)localObject).Nbs = 1;
    this.wGi = paramInt;
    Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64458);
  }
  
  public final void MO(int paramInt)
  {
    AppMethodBeat.i(64461);
    Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt) });
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64461);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64459);
    Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
      if (this.wGi == 1)
      {
        ((a)com.tencent.mm.kernel.g.af(a.class)).pj(true);
        ((a)com.tencent.mm.kernel.g.af(a.class)).pk(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(64459);
      return;
      ((a)com.tencent.mm.kernel.g.af(a.class)).pk(true);
      ((a)com.tencent.mm.kernel.g.af(a.class)).pj(false);
      continue;
      Log.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final void dKB()
  {
    AppMethodBeat.i(64460);
    Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64460);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(64462);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
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