package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  private b rr;
  public bbx rxm;
  
  public c(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188647);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bbw();
    ((b.a)localObject).hQG = new bbx();
    ((b.a)localObject).funcId = 1108;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getfacecontractstatus";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bbw)this.rr.hQD.hQJ;
    ((bbw)localObject).scene = paramInt;
    ((bbw)localObject).GRQ = paramString1;
    ((bbw)localObject).GRH = paramString2;
    ae.i("MicroMsg.FaceAgreementUICGI", "[cgi-request]NetSceneGetFaceContract scene:%s,userInfo:%s,sign:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(188647);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(188648);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(188648);
    return i;
  }
  
  public final int getType()
  {
    return 1108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(188649);
    ae.i("MicroMsg.FaceAgreementUICGI", "[cgi-ret]onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.rxm = ((bbx)((b)paramq).hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(188649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.c
 * JD-Core Version:    0.7.0.1
 */