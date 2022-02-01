package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.sdk.platformtools.Log;

public final class ag
  extends q
  implements m
{
  private i callback;
  public String content;
  public String fSj;
  public String nWx;
  private final d rr;
  public int status;
  public String tqt;
  public String tqu;
  public boolean tqv;
  public String tqw;
  public String tqx;
  public String tqy;
  public String tqz;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112855);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dng();
    ((d.a)localObject).lBV = new dnh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((d.a)localObject).funcId = 1171;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dng)d.b.b(this.rr.lBR);
    ((dng)localObject).REC = paramInt;
    ((dng)localObject).REE = paramString1;
    ((dng)localObject).chatroom_name = paramString2;
    AppMethodBeat.o(112855);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112857);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112857);
    return i;
  }
  
  public final int getType()
  {
    return 1171;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112856);
    Log.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dnh)d.c.b(this.rr.lBS);
      this.fSj = params.REI;
      this.tqt = params.REJ;
      this.status = params.status;
      this.content = params.content;
      this.tqu = params.tpM;
      this.nWx = params.background_color;
      this.tqv = params.tqv;
      this.tqw = params.TUt;
      this.tqx = params.TUu;
      this.tqy = params.TUv;
      this.tqz = params.TUw;
      Log.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.fSj, this.tqt, Integer.valueOf(this.status), this.content, this.tqu, this.nWx, Boolean.valueOf(this.tqv) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */