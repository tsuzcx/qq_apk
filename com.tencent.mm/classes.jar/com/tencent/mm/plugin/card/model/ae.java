package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class ae
  extends n
  implements k
{
  private g callback;
  public cjc nWP;
  private final b rr;
  
  public ae(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(112849);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new awk();
    ((b.a)localObject).hvu = new awl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
    ((b.a)localObject).funcId = 1382;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (awk)this.rr.hvr.hvw;
    ((awk)localObject).EOu = paramLinkedList;
    ((awk)localObject).scene = paramInt;
    AppMethodBeat.o(112849);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112851);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.nWP = ((awl)this.rr.hvs.hvw).EOv;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ae
 * JD-Core Version:    0.7.0.1
 */