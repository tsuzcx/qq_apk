package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends a
{
  private final String TAG;
  private com.tencent.mm.ak.f callback;
  public vj piu;
  private b rr;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63905);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new vi();
    ((b.a)localObject).hQG = new vj();
    ((b.a)localObject).funcId = 1516;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (vi)this.rr.hQD.hQJ;
    ((vi)localObject).phf = paramString1;
    ((vi)localObject).channel = paramInt;
    ((vi)localObject).Gnf = paramString2;
    AppMethodBeat.o(63905);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63907);
    ae.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.piu = ((vj)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.piu.dmy), this.piu.phe });
    if ((!this.pil) && (this.piu.dmy != 0)) {
      this.pim = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63907);
  }
  
  protected final boolean cbV()
  {
    return false;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(63906);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63906);
    return i;
  }
  
  public final int getType()
  {
    return 1516;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.f
 * JD-Core Version:    0.7.0.1
 */