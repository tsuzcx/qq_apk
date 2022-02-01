package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  public String dFw;
  public wg qwA;
  private d rr;
  
  public o(int paramInt, b paramb, String paramString)
  {
    AppMethodBeat.i(63835);
    this.TAG = "MicroMsg.NetSceneMDRcvVoice";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new wf();
    ((d.a)localObject).iLO = new wg();
    ((d.a)localObject).funcId = 1317;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (wf)this.rr.iLK.iLR;
    ((wf)localObject).yRL = paramInt;
    ((wf)localObject).Lba = 0;
    ((wf)localObject).qwM = paramString;
    ((wf)localObject).Lhb = null;
    ((wf)localObject).Lhc = paramb;
    this.dFw = paramString;
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
    this.qwA = ((wg)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.qwA.dDN), this.qwA.qwn, Integer.valueOf(this.qwA.Lba) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.o
 * JD-Core Version:    0.7.0.1
 */