package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.protocal.protobuf.els;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends com.tencent.mm.plugin.soter.b.d
{
  private int Bzf;
  private i callback;
  public final com.tencent.mm.an.d rr;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64458);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new els();
    ((d.a)localObject).lBV = new elt();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((d.a)localObject).funcId = 1638;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (els)d.b.b(this.rr.lBR);
    ((els)localObject).TNh = paramString1;
    ((els)localObject).signature = paramString2;
    ((els)localObject).UnN = paramString3;
    ((els)localObject).fIF = TenpayUtil.signWith3Des("passwd=" + ((els)localObject).UnN);
    ((els)localObject).UnL = paramInt;
    ((els)localObject).SZz = 1;
    this.Bzf = paramInt;
    Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64458);
  }
  
  public final void Sl(int paramInt)
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
      if (this.Bzf == 1)
      {
        ((a)h.ae(a.class)).rD(true);
        ((a)h.ae(a.class)).rE(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(64459);
      return;
      ((a)h.ae(a.class)).rE(true);
      ((a)h.ae(a.class)).rD(false);
      continue;
      Log.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(64462);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(64462);
    return i;
  }
  
  public final void epa()
  {
    AppMethodBeat.i(64460);
    Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64460);
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