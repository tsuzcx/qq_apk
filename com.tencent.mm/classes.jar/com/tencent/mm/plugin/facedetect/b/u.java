package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.sdk.platformtools.ab;

public final class u
  extends m
  implements k, b
{
  private f callback;
  private long mhn;
  private byte[] mho;
  private com.tencent.mm.ai.b rr;
  
  public u(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109);
    this.mhn = -1L;
    this.mho = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new agy();
    ((b.a)localObject).fsY = new agz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (agy)this.rr.fsV.fta;
    ((agy)localObject).jKs = 1;
    ((agy)localObject).Scene = paramInt1;
    ((agy)localObject).wZB = paramInt2;
    ab.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
    ab.i("MicroMsg.NetSceneGetBioConfig", "mChechLiveFlag is ".concat(String.valueOf(paramInt2)));
    AppMethodBeat.o(109);
  }
  
  public final long btW()
  {
    return this.mhn;
  }
  
  public final byte[] btX()
  {
    return this.mho;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(110);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(110);
    return i;
  }
  
  public final int getType()
  {
    return 732;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111);
    paramq = (agz)((com.tencent.mm.ai.b)paramq).fsW.fta;
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.mhn = paramq.wZC;
      this.mho = paramq.wZD.pW;
      ab.i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
      ab.i("MicroMsg.NetSceneGetBioConfig", "Config is " + this.mho);
      l = this.mhn;
      if (this.mho != null) {
        break label149;
      }
    }
    label149:
    for (paramInt1 = 0;; paramInt1 = this.mho.length)
    {
      ab.i("MicroMsg.NetSceneGetBioConfig", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(111);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.u
 * JD-Core Version:    0.7.0.1
 */