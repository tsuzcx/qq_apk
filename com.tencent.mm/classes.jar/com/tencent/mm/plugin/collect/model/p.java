package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  public String fyd;
  private d rr;
  public wi tVB;
  
  public p(int paramInt, b paramb, String paramString)
  {
    AppMethodBeat.i(63835);
    this.TAG = "MicroMsg.NetSceneMDRcvVoice";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new wh();
    ((d.a)localObject).lBV = new wi();
    ((d.a)localObject).funcId = 1317;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (wh)d.b.b(this.rr.lBR);
    ((wh)localObject).amount = paramInt;
    ((wh)localObject).Scm = 0;
    ((wh)localObject).tVM = paramString;
    ((wh)localObject).Sip = null;
    ((wh)localObject).Siq = paramb;
    this.fyd = paramString;
    Log.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(63835);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63836);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63836);
    return i;
  }
  
  public final int getType()
  {
    return 1317;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63837);
    Log.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.tVB = ((wi)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.tVB.fwx), this.tVB.tVo, Integer.valueOf(this.tVB.Scm) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.p
 * JD-Core Version:    0.7.0.1
 */