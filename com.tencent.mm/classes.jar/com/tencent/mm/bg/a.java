package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  String ikk;
  private final b rr;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(150874);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new das();
    ((b.a)localObject).hNN = new dat();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((b.a)localObject).funcId = 752;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = new btm();
    ((btm)localObject).Ggy = paramString2;
    ((btm)localObject).Ggz = paramInt2;
    ((btm)localObject).FOB = paramFloat2;
    ((btm)localObject).FOA = paramFloat1;
    ((btm)localObject).Ggx = paramString1;
    ((btm)localObject).Ggw = paramInt1;
    paramString1 = (das)this.rr.hNK.hNQ;
    paramString1.GbC = ((btm)localObject);
    paramString1.HqK = paramInt3;
    paramString1.Scene = paramInt4;
    paramString1.hDa = paramString3;
    AppMethodBeat.o(150874);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150876);
    this.callback = paramf;
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
      this.ikk = ((dat)((b)paramq).hNL.hNQ).hDa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bg.a
 * JD-Core Version:    0.7.0.1
 */