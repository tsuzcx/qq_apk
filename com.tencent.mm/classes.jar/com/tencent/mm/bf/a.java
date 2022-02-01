package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  private g callback;
  String hQW;
  private final b rr;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(150874);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cvg();
    ((b.a)localObject).hvu = new cvh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((b.a)localObject).funcId = 752;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = new boz();
    ((boz)localObject).EyM = paramString2;
    ((boz)localObject).EyN = paramInt2;
    ((boz)localObject).Ehu = paramFloat2;
    ((boz)localObject).Eht = paramFloat1;
    ((boz)localObject).EyL = paramString1;
    ((boz)localObject).EyK = paramInt1;
    paramString1 = (cvg)this.rr.hvr.hvw;
    paramString1.Euj = ((boz)localObject);
    paramString1.FGi = paramInt3;
    paramString1.Scene = paramInt4;
    paramString1.hkR = paramString3;
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
    ac.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.hQW = ((cvh)((b)paramq).hvs.hvw).hkR;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150875);
      return;
      ac.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bf.a
 * JD-Core Version:    0.7.0.1
 */