package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(20765);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ajt();
    ((c.a)localObject).otF = new aju();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
    ((c.a)localObject).funcId = 1194;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ajt)c.b.b(this.rr.otB);
    ((ajt)localObject).Zra = "invoice_info";
    ((ajt)localObject).group_id = paramInt;
    ((ajt)localObject).source = 2;
    AppMethodBeat.o(20765);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20767);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20767);
    return i;
  }
  
  public final int getType()
  {
    return 1194;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20766);
    Log.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.a
 * JD-Core Version:    0.7.0.1
 */