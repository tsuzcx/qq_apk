package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apt;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  public String koi;
  public int koj;
  public String kok;
  private final b rr;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(88024);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new apt();
    ((b.a)localObject).fsY = new apu();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
    ((b.a)localObject).funcId = 910;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (apt)this.rr.fsV.fta;
    ((apt)localObject).cHn = paramString1;
    ((apt)localObject).scene = 20;
    ((apt)localObject).kml = paramString2;
    ((apt)localObject).code = paramString3;
    AppMethodBeat.o(88024);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(88026);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88026);
    return i;
  }
  
  public final int getType()
  {
    return 910;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88025);
    ab.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (apu)this.rr.fsW.fta;
      ab.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + paramq.koi);
      this.koi = paramq.koi;
      this.kok = paramq.kok;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.d
 * JD-Core Version:    0.7.0.1
 */