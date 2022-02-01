package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  private h callback;
  private c rr;
  public cjx zZu;
  
  public d(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(262595);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cjw();
    ((c.a)localObject).otF = new cjx();
    ((c.a)localObject).funcId = 1108;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/getfacecontractstatus";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cjw)c.b.b(this.rr.otB);
    ((cjw)localObject).scene = paramInt;
    ((cjw)localObject).aasv = paramString1;
    ((cjw)localObject).aasl = paramString2;
    Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-request]NetSceneGetFaceContract scene:%s,userInfo:%s,sign:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(262595);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262598);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(262598);
    return i;
  }
  
  public final int getType()
  {
    return 1108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262601);
    Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-ret]onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zZu = ((cjx)c.c.b(((c)params).otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(262601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.d
 * JD-Core Version:    0.7.0.1
 */