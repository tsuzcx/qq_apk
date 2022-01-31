package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  String fNy;
  private final b rr;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(78524);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bzr();
    ((b.a)localObject).fsY = new bzs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((b.a)localObject).funcId = 752;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = new azt();
    ((azt)localObject).wSm = paramString2;
    ((azt)localObject).wSn = paramInt2;
    ((azt)localObject).wDi = paramFloat2;
    ((azt)localObject).wDh = paramFloat1;
    ((azt)localObject).wSl = paramString1;
    ((azt)localObject).wSk = paramInt1;
    paramString1 = (bzr)this.rr.fsV.fta;
    paramString1.wOE = ((azt)localObject);
    paramString1.xLs = paramInt3;
    paramString1.Scene = paramInt4;
    paramString1.ntu = paramString3;
    AppMethodBeat.o(78524);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78526);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78526);
    return i;
  }
  
  public final int getType()
  {
    return 752;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78525);
    ab.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.fNy = ((bzs)((b)paramq).fsW.fta).ntu;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78525);
      return;
      ab.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.a
 * JD-Core Version:    0.7.0.1
 */