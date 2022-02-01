package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String wuA;
  public String wuy;
  public int wuz;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(112963);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new csf();
    ((c.a)localObject).otF = new csg();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
    ((c.a)localObject).funcId = 910;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (csf)c.b.b(this.rr.otB);
    ((csf)localObject).iaI = paramString1;
    ((csf)localObject).scene = 20;
    ((csf)localObject).wsy = paramString2;
    ((csf)localObject).code = paramString3;
    AppMethodBeat.o(112963);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112965);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112965);
    return i;
  }
  
  public final int getType()
  {
    return 910;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112964);
    Log.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (csg)c.c.b(this.rr.otC);
      Log.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + params.wuy);
      this.wuy = params.wuy;
      this.wuA = params.wuA;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.d
 * JD-Core Version:    0.7.0.1
 */