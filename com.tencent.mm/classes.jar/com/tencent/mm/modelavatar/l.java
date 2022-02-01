package com.tencent.mm.modelavatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends p
  implements m
{
  private h callback;
  LinkedList<etl> osR = null;
  LinkedList<dcb> osS = null;
  
  public l(LinkedList<etl> paramLinkedList)
  {
    this.osR = paramLinkedList;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150294);
    if ((this.osR == null) || (this.osR.size() <= 0))
    {
      Log.e("MicroMsg.NetSceneBatchGetHeadImg", f.aPX() + "doScene ReqSize==0");
      AppMethodBeat.o(150294);
      return -1;
    }
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new lc();
    paramh.otF = new ld();
    paramh.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    paramh.funcId = 123;
    paramh.otG = 15;
    paramh.respCmdId = 1000000015;
    paramh = paramh.bEF();
    lc locallc = (lc)c.b.b(paramh.otB);
    locallc.YFl = this.osR;
    locallc.vgN = this.osR.size();
    int i = dispatch(paramg, paramh, this);
    AppMethodBeat.o(150294);
    return i;
  }
  
  public final int getType()
  {
    return 123;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150295);
    Log.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.osS = ((ld)c.c.b(((c)params).otC)).YMU;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150295);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelavatar.l
 * JD-Core Version:    0.7.0.1
 */