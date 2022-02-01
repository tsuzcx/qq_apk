package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private g callback;
  String hqu;
  private final b rr;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(150874);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cpz();
    ((b.a)localObject).gUV = new cqa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((b.a)localObject).funcId = 752;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = new bld();
    ((bld)localObject).DfG = paramString2;
    ((bld)localObject).DfH = paramInt2;
    ((bld)localObject).COJ = paramFloat2;
    ((bld)localObject).COI = paramFloat1;
    ((bld)localObject).DfF = paramString1;
    ((bld)localObject).DfE = paramInt1;
    paramString1 = (cpz)this.rr.gUS.gUX;
    paramString1.Dbk = ((bld)localObject);
    paramString1.Ejk = paramInt3;
    paramString1.Scene = paramInt4;
    paramString1.gKr = paramString3;
    AppMethodBeat.o(150874);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150876);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150876);
    return i;
  }
  
  public final int getType()
  {
    return 752;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150875);
    ad.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.hqu = ((cqa)((b)paramq).gUT.gUX).gKr;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150875);
      return;
      ad.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bg.a
 * JD-Core Version:    0.7.0.1
 */