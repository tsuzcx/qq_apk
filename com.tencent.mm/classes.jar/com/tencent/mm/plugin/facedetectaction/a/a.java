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
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private d rr;
  private bne sXf;
  public bnf sXg;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104195);
    d.a locala = new d.a();
    locala.iLN = new bne();
    locala.iLO = new bnf();
    locala.funcId = 2696;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.sXf = ((bne)this.rr.iLK.iLR);
    this.sXf.scene = paramInt;
    this.sXf.qGp = paramString1;
    this.sXf.LVM = paramString2;
    Log.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(104195);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(104196);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(104196);
    return i;
  }
  
  public final int getType()
  {
    return 2696;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104197);
    Log.i("MicroMsg.NetSceneGetFaceCheckAction", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.sXg = ((bnf)((d)params).iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.a
 * JD-Core Version:    0.7.0.1
 */