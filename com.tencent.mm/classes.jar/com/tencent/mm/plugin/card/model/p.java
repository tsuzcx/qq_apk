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
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class p
  extends n
  implements k
{
  private g callback;
  public String nWw;
  public int nWx;
  public String nWy;
  private final b rr;
  
  public p(LinkedList<rl> paramLinkedList, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(112802);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new am();
    ((b.a)localObject).hvu = new an();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
    ((b.a)localObject).funcId = 1049;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (am)this.rr.hvr.hvw;
    ((am)localObject).DMp = paramLinkedList;
    ((am)localObject).dvQ = paramInt1;
    ((am)localObject).DMl = paramString1;
    ((am)localObject).DMk = paramString2;
    ((am)localObject).DMm = paramInt2;
    AppMethodBeat.o(112802);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112803);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112803);
    return i;
  }
  
  public final int getType()
  {
    return 1049;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112804);
    ac.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (an)this.rr.hvs.hvw;
      this.nWw = paramq.nWw;
      this.nWx = paramq.nWx;
      this.nWy = paramq.nWy;
      ac.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.nWx + " ret_msg = " + this.nWy);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.p
 * JD-Core Version:    0.7.0.1
 */