package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  private d rr;
  public bnj sXj;
  
  public c(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186389);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bni();
    ((d.a)localObject).iLO = new bnj();
    ((d.a)localObject).funcId = 1108;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/getfacecontractstatus";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bni)this.rr.iLK.iLR;
    ((bni)localObject).scene = paramInt;
    ((bni)localObject).LVV = paramString1;
    ((bni)localObject).LVM = paramString2;
    Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-request]NetSceneGetFaceContract scene:%s,userInfo:%s,sign:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(186389);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(186390);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(186390);
    return i;
  }
  
  public final int getType()
  {
    return 1108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186391);
    Log.i("MicroMsg.FaceAgreementUICGI", "[cgi-ret]onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.sXj = ((bnj)((d)params).iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(186391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.c
 * JD-Core Version:    0.7.0.1
 */