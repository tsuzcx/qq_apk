package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i callback;
  public String mFileName;
  private d rr;
  
  public r(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103623);
    this.mFileName = "";
    d.a locala = new d.a();
    locala.iLN = new amc();
    locala.iLO = new amd();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.mFileName = paramString1;
    paramString1 = (amc)this.rr.iLK.iLR;
    paramString1.dNI = paramString2;
    paramString1.LuJ = paramLong;
    paramString1.LuK = paramString4;
    paramString1.LuR = paramString3;
    AppMethodBeat.o(103623);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103624);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103624);
    return i;
  }
  
  public final int getType()
  {
    return 1197;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103625);
    Log.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.r
 * JD-Core Version:    0.7.0.1
 */