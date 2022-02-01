package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  private final c rr;
  public String wuA;
  public String wuy;
  public int wuz;
  
  public p(LinkedList<wf> paramLinkedList, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(112802);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ao();
    ((c.a)localObject).otF = new ap();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
    ((c.a)localObject).funcId = 1049;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ao)c.b.b(this.rr.otB);
    ((ao)localObject).YBg = paramLinkedList;
    ((ao)localObject).iaK = paramInt1;
    ((ao)localObject).YBc = paramString1;
    ((ao)localObject).YBb = paramString2;
    ((ao)localObject).YBd = paramInt2;
    AppMethodBeat.o(112802);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112803);
    this.callback = paramh;
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
      params = (ap)c.c.b(this.rr.otC);
      this.wuy = params.wuy;
      this.wuz = params.wuz;
      this.wuA = params.wuA;
      Log.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.wuz + " ret_msg = " + this.wuA);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.p
 * JD-Core Version:    0.7.0.1
 */