package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fbf;
import com.tencent.mm.protocal.protobuf.fbg;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String wuA;
  public String wuy;
  public int wuz;
  
  public g(int paramInt1, LinkedList<fbh> paramLinkedList, String paramString1, String paramString2, fbz paramfbz, int paramInt2, fhj paramfhj)
  {
    AppMethodBeat.i(112972);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fbf();
    ((c.a)localObject).otF = new fbg();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((c.a)localObject).funcId = 902;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fbf)c.b.b(this.rr.otB);
    ((fbf)localObject).abBj = paramInt1;
    ((fbf)localObject).nUC = paramLinkedList;
    ((fbf)localObject).met = paramString1;
    ((fbf)localObject).aapy = paramString2;
    Log.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((fbf)localObject).abBk = paramfbz;
    ((fbf)localObject).iaK = paramInt2;
    ((fbf)localObject).YBf = paramfhj;
    AppMethodBeat.o(112972);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(112974);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112974);
    return i;
  }
  
  public final int getType()
  {
    return 902;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112973);
    Log.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      params = (fbg)c.c.b(this.rr.otC);
      if (params != null)
      {
        this.wuy = params.wuy;
        this.wuz = params.wuz;
        this.wuA = params.wuA;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112973);
      return;
      params = (fbg)c.c.b(this.rr.otC);
      if (params != null)
      {
        this.wuy = params.wuy;
        this.wuz = params.wuz;
        this.wuA = params.wuA;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */