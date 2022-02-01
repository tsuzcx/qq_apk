package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  public long delay;
  public String fyd;
  private d kwO;
  public int source;
  public vz tVe;
  public long tVf;
  private long tVg;
  
  public i(int paramInt1, b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(63819);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new vy();
    ((d.a)localObject).lBV = new vz();
    ((d.a)localObject).funcId = 1384;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.kwO = ((d.a)localObject).bgN();
    localObject = (vy)d.b.b(this.kwO.lBR);
    ((vy)localObject).amount = paramInt1;
    ((vy)localObject).Scm = 0;
    ((vy)localObject).tVM = paramString;
    ((vy)localObject).Sip = null;
    ((vy)localObject).Siq = paramb;
    this.fyd = paramString;
    this.source = paramInt2;
    this.delay = paramLong;
    this.tVg = System.currentTimeMillis();
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(63819);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(63820);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(63820);
    return i;
  }
  
  public final int getType()
  {
    return 1384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63821);
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.tVe = ((vz)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.tVe.fwx), this.tVe.tVo, Integer.valueOf(this.tVe.Scm) });
    this.tVf = (System.currentTimeMillis() - this.tVg);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.i
 * JD-Core Version:    0.7.0.1
 */