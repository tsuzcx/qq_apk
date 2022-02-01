package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.an.d rr;
  public buz wDj;
  
  public d(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191414);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new buy();
    ((d.a)localObject).lBV = new buz();
    ((d.a)localObject).funcId = 1108;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/getfacecontractstatus";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (buy)d.b.b(this.rr.lBR);
    ((buy)localObject).scene = paramInt;
    ((buy)localObject).Tfb = paramString1;
    ((buy)localObject).TeR = paramString2;
    Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-request]NetSceneGetFaceContract scene:%s,userInfo:%s,sign:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(191414);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(191416);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(191416);
    return i;
  }
  
  public final int getType()
  {
    return 1108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(191419);
    Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-ret]onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wDj = ((buz)d.c.b(((com.tencent.mm.an.d)params).lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(191419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.d
 * JD-Core Version:    0.7.0.1
 */