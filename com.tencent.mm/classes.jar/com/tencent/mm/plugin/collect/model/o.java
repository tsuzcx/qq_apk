package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends n
  implements k
{
  private final String TAG;
  private g callback;
  public String dbJ;
  public tc oxs;
  private com.tencent.mm.ak.b rr;
  
  public o(int paramInt, com.tencent.mm.bw.b paramb, String paramString)
  {
    AppMethodBeat.i(63835);
    this.TAG = "MicroMsg.NetSceneMDRcvVoice";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tb();
    ((b.a)localObject).hvu = new tc();
    ((b.a)localObject).funcId = 1317;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (tb)this.rr.hvr.hvw;
    ((tb)localObject).uiK = paramInt;
    ((tb)localObject).EgR = 0;
    ((tb)localObject).oxD = paramString;
    ((tb)localObject).EmP = null;
    ((tb)localObject).EmQ = paramb;
    this.dbJ = paramString;
    ac.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(63835);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63836);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63836);
    return i;
  }
  
  public final int getType()
  {
    return 1317;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63837);
    ac.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.oxs = ((tc)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.oxs.dae), this.oxs.oxf, Integer.valueOf(this.oxs.EgR) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.o
 * JD-Core Version:    0.7.0.1
 */