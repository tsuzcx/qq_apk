package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private f callback;
  public bbh rpi;
  private b rr;
  
  public c(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(213175);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bbg();
    ((b.a)localObject).hNN = new bbh();
    ((b.a)localObject).funcId = 1108;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getfacecontractstatus";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bbg)this.rr.hNK.hNQ;
    ((bbg)localObject).scene = paramInt;
    ((bbg)localObject).Gyq = paramString1;
    ((bbg)localObject).Gyh = paramString2;
    ad.i("MicroMsg.FaceAgreementUICGI", "[cgi-request]NetSceneGetFaceContract scene:%s,userInfo:%s,sign:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(213175);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(213176);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(213176);
    return i;
  }
  
  public final int getType()
  {
    return 1108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(213177);
    ad.i("MicroMsg.FaceAgreementUICGI", "[cgi-ret]onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.rpi = ((bbh)((b)paramq).hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(213177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.c
 * JD-Core Version:    0.7.0.1
 */