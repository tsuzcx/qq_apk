package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.frm;
import com.tencent.mm.protocal.protobuf.frn;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends p
  implements m
{
  private h callback;
  Object cpt;
  public c rr;
  
  public x(String paramString, op paramop, Object paramObject)
  {
    AppMethodBeat.i(124325);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new frm();
    ((c.a)localObject).otF = new frn();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
    ((c.a)localObject).funcId = 1356;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (frm)c.b.b(this.rr.otB);
    ((frm)localObject).YRQ = paramString;
    ((frm)localObject).aajx = paramop;
    this.cpt = paramObject;
    AppMethodBeat.o(124325);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124327);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124327);
    return i;
  }
  
  public final int getType()
  {
    return 1356;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124326);
    Log.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.a.x
 * JD-Core Version:    0.7.0.1
 */