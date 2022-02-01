package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class p
  extends n
  implements k
{
  private f callback;
  public String oGs;
  public int oGt;
  public String oGu;
  private final b rr;
  
  public p(LinkedList<th> paramLinkedList, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(112802);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new am();
    ((b.a)localObject).hQG = new an();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
    ((b.a)localObject).funcId = 1049;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (am)this.rr.hQD.hQJ;
    ((am)localObject).FJS = paramLinkedList;
    ((am)localObject).dJd = paramInt1;
    ((am)localObject).FJO = paramString1;
    ((am)localObject).FJN = paramString2;
    ((am)localObject).FJP = paramInt2;
    AppMethodBeat.o(112802);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112803);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (an)this.rr.hQE.hQJ;
      this.oGs = paramq.oGs;
      this.oGt = paramq.oGt;
      this.oGu = paramq.oGu;
      ae.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.oGt + " ret_msg = " + this.oGu);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.p
 * JD-Core Version:    0.7.0.1
 */