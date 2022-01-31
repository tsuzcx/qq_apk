package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends m
  implements k
{
  private f callback;
  private azf nYa;
  private final b rr;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(22533);
    this.nYa = null;
    b.a locala = new b.a();
    locala.fsX = new cms();
    locala.fsY = new cmt();
    locala.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
    locala.funcId = 637;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    if ((paramInt >= 0) && (!bo.isNullOrNil(paramString)))
    {
      this.nYa = new azf();
      this.nYa.xoC = paramInt;
      this.nYa.xoB = paramString;
    }
    AppMethodBeat.o(22533);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(22535);
    this.callback = paramf;
    cms localcms = (cms)this.rr.fsV.fta;
    if (this.nYa != null)
    {
      localcms.xWs = this.nYa;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(22535);
      return i;
    }
    ab.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
    AppMethodBeat.o(22535);
    return 0;
  }
  
  public final int getType()
  {
    return 637;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22534);
    ab.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(22534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.e
 * JD-Core Version:    0.7.0.1
 */