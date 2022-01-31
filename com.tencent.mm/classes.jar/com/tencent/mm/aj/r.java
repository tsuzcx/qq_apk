package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Date;

public final class r
  extends m
  implements k
{
  private f callback;
  private Object data;
  public com.tencent.mm.ai.b rr;
  
  public r(b paramb, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(11438);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bow();
    ((b.a)localObject).fsY = new box();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((b.a)localObject).funcId = 2805;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bow)this.rr.fsV.fta;
    ((bow)localObject).xCW = 1;
    ((bow)localObject).xCX = paramb.field_wwCorpId;
    ((bow)localObject).wyE = paramb.field_wwUserVid;
    com.tencent.mm.kernel.g.RJ();
    ((bow)localObject).xCY = a.getUin();
    ((bow)localObject).scene = paramInt2;
    ((bow)localObject).coO = paramInt1;
    ((bow)localObject).xCZ = 0L;
    ((bow)localObject).xDa = new Date().getTime();
    ((bow)localObject).platform = 1;
    ((bow)localObject).xzN = com.tencent.mm.sdk.platformtools.g.au(null, d.whH);
    this.data = paramObject;
    AppMethodBeat.o(11438);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11440);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11440);
    return i;
  }
  
  public final int getType()
  {
    return 2805;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11439);
    ab.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.r
 * JD-Core Version:    0.7.0.1
 */