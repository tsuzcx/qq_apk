package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.fgl;
import com.tencent.mm.protocal.protobuf.fgm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.android.wechat.TenpayUtil;

public final class b
  extends d
{
  private int HgK;
  private com.tencent.mm.am.h callback;
  public final c rr;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(64458);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fgl();
    ((c.a)localObject).otF = new fgm();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
    ((c.a)localObject).funcId = 1638;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fgl)c.b.b(this.rr.otB);
    ((fgl)localObject).abdA = paramString1;
    ((fgl)localObject).signature = paramString2;
    ((fgl)localObject).abGp = paramString3;
    ((fgl)localObject).hOg = TenpayUtil.signWith3Des("passwd=" + ((fgl)localObject).abGp);
    ((fgl)localObject).abGn = paramInt;
    ((fgl)localObject).aamt = 1;
    this.HgK = paramInt;
    Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(64458);
  }
  
  public final void VE(int paramInt)
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
      if (this.HgK == 1)
      {
        ((a)com.tencent.mm.kernel.h.ax(a.class)).vu(true);
        ((a)com.tencent.mm.kernel.h.ax(a.class)).vv(false);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, paramInt2, "", this);
      AppMethodBeat.o(64459);
      return;
      ((a)com.tencent.mm.kernel.h.ax(a.class)).vv(true);
      ((a)com.tencent.mm.kernel.h.ax(a.class)).vu(false);
      continue;
      Log.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(64462);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(64462);
    return i;
  }
  
  public final void fuc()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.b
 * JD-Core Version:    0.7.0.1
 */