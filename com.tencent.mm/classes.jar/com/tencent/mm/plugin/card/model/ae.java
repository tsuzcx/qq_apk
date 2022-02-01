package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class ae
  extends n
  implements k
{
  private f callback;
  public coc oAj;
  private final b rr;
  
  public ae(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(112849);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bai();
    ((b.a)localObject).hNN = new baj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
    ((b.a)localObject).funcId = 1382;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bai)this.rr.hNK.hNQ;
    ((bai)localObject).Gxy = paramLinkedList;
    ((bai)localObject).scene = paramInt;
    AppMethodBeat.o(112849);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112851);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112851);
    return i;
  }
  
  public final int getType()
  {
    return 1382;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112850);
    ad.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.oAj = ((baj)this.rr.hNL.hNQ).Gxz;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ae
 * JD-Core Version:    0.7.0.1
 */