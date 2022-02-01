package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String wuy;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, fhj paramfhj)
  {
    AppMethodBeat.i(112837);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cgl();
    ((c.a)localObject).otF = new cgm();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((c.a)localObject).funcId = 1057;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cgl)c.b.b(this.rr.otB);
    ((cgl)localObject).iaI = paramString1;
    ((cgl)localObject).iaK = paramInt1;
    ((cgl)localObject).from_username = paramString2;
    ((cgl)localObject).iaJ = paramString3;
    ((cgl)localObject).YBc = paramString4;
    ((cgl)localObject).YBb = paramString5;
    ((cgl)localObject).YBd = paramInt2;
    ((cgl)localObject).aapy = paramString6;
    ((cgl)localObject).YBf = paramfhj;
    AppMethodBeat.o(112837);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112838);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112838);
    return i;
  }
  
  public final int getType()
  {
    return 1057;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112839);
    Log.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.wuy = ((cgm)c.c.b(this.rr.otC)).wuy;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */