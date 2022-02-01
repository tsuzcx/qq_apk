package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class n
  extends w
{
  private final String TAG;
  private h callback;
  public String hCI;
  private c rr;
  public ya wYV;
  
  public n(int paramInt, b paramb, String paramString)
  {
    AppMethodBeat.i(63835);
    this.TAG = "MicroMsg.NetSceneMDRcvVoice";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new xz();
    ((c.a)localObject).otF = new ya();
    ((c.a)localObject).funcId = 1317;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (xz)c.b.b(this.rr.otB);
    ((xz)localObject).amount = paramInt;
    ((xz)localObject).Zae = 0;
    ((xz)localObject).wZg = paramString;
    ((xz)localObject).Zgv = null;
    ((xz)localObject).Zgw = paramb;
    this.hCI = paramString;
    Log.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(63835);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63836);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63836);
    return i;
  }
  
  public final int getType()
  {
    return 1317;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(293531);
    Log.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wYV = ((ya)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.wYV.hAV), this.wYV.wYI, Integer.valueOf(this.wYV.Zae) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(293531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.n
 * JD-Core Version:    0.7.0.1
 */