package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  String ind;
  private final b rr;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(150874);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dbm();
    ((b.a)localObject).hQG = new dbn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((b.a)localObject).funcId = 752;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = new bug();
    ((bug)localObject).Gzh = paramString2;
    ((bug)localObject).Gzi = paramInt2;
    ((bug)localObject).Gha = paramFloat2;
    ((bug)localObject).GgZ = paramFloat1;
    ((bug)localObject).Gzg = paramString1;
    ((bug)localObject).Gzf = paramInt1;
    paramString1 = (dbm)this.rr.hQD.hQJ;
    paramString1.Guj = ((bug)localObject);
    paramString1.HKm = paramInt3;
    paramString1.Scene = paramInt4;
    paramString1.hFS = paramString3;
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
    ae.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.ind = ((dbn)((b)paramq).hQE.hQJ).hFS;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150875);
      return;
      ae.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bf.a
 * JD-Core Version:    0.7.0.1
 */