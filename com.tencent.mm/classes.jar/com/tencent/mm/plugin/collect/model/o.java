package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.ae;

public final class o
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public String doh;
  public uz phr;
  private com.tencent.mm.ak.b rr;
  
  public o(int paramInt, com.tencent.mm.bw.b paramb, String paramString)
  {
    AppMethodBeat.i(63835);
    this.TAG = "MicroMsg.NetSceneMDRcvVoice";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new uy();
    ((b.a)localObject).hQG = new uz();
    ((b.a)localObject).funcId = 1317;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (uy)this.rr.hQD.hQJ;
    ((uy)localObject).vxx = paramInt;
    ((uy)localObject).Ggx = 0;
    ((uy)localObject).phC = paramString;
    ((uy)localObject).Gmx = null;
    ((uy)localObject).Gmy = paramb;
    this.doh = paramString;
    ae.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(63835);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63836);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.phr = ((uz)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.phr.dmy), this.phr.phe, Integer.valueOf(this.phr.Ggx) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.o
 * JD-Core Version:    0.7.0.1
 */