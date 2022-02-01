package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class p
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String tpZ;
  public int tqa;
  public String tqb;
  
  public p(LinkedList<uo> paramLinkedList, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(112802);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new am();
    ((d.a)localObject).lBV = new an();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
    ((d.a)localObject).funcId = 1049;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (am)d.b.b(this.rr.lBR);
    ((am)localObject).REB = paramLinkedList;
    ((am)localObject).fUN = paramInt1;
    ((am)localObject).REx = paramString1;
    ((am)localObject).REw = paramString2;
    ((am)localObject).REy = paramInt2;
    AppMethodBeat.o(112802);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112803);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112803);
    return i;
  }
  
  public final int getType()
  {
    return 1049;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112804);
    Log.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (an)d.c.b(this.rr.lBS);
      this.tpZ = params.tpZ;
      this.tqa = params.tqa;
      this.tqb = params.tqb;
      Log.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.tqa + " ret_msg = " + this.tqb);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.p
 * JD-Core Version:    0.7.0.1
 */