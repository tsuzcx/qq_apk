package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f callback;
  public String cpq;
  public long cps;
  public int cpt;
  private com.tencent.mm.ai.b goo;
  public py kNp;
  public long kNq;
  private long kNr;
  
  public i(int paramInt1, com.tencent.mm.bv.b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(40967);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new px();
    ((b.a)localObject).fsY = new py();
    ((b.a)localObject).funcId = 1384;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.goo = ((b.a)localObject).ado();
    localObject = (px)this.goo.fsV.fta;
    ((px)localObject).okH = paramInt1;
    ((px)localObject).wIn = 0;
    ((px)localObject).kNU = paramString;
    ((px)localObject).wIl = null;
    ((px)localObject).wIm = paramb;
    this.cpq = paramString;
    this.cpt = paramInt2;
    this.cps = paramLong;
    this.kNr = System.currentTimeMillis();
    ab.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(40967);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(40968);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40968);
    return i;
  }
  
  public final int getType()
  {
    return 1384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40969);
    ab.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.kNp = ((py)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.kNp.cnK), this.kNp.kNv, Integer.valueOf(this.kNp.wIn) });
    this.kNq = (System.currentTimeMillis() - this.kNr);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(40969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.i
 * JD-Core Version:    0.7.0.1
 */