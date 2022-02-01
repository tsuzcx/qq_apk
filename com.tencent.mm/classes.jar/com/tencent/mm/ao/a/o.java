package com.tencent.mm.ao.a;

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
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  Object bnW;
  private i callback;
  public d rr;
  
  public o(String paramString, bms parambms, Object paramObject)
  {
    AppMethodBeat.i(124298);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new aei();
    ((d.a)localObject).lBV = new aej();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((d.a)localObject).funcId = 1355;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (aei)d.b.b(this.rr.lBR);
    ((aei)localObject).RUp = paramString;
    ((aei)localObject).SqS = parambms;
    this.bnW = paramObject;
    AppMethodBeat.o(124298);
  }
  
  public final aej bjS()
  {
    AppMethodBeat.i(205627);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      aej localaej = (aej)d.c.b(this.rr.lBS);
      AppMethodBeat.o(205627);
      return localaej;
    }
    AppMethodBeat.o(205627);
    return null;
  }
  
  public final aei bjT()
  {
    AppMethodBeat.i(205628);
    if ((this.rr != null) && (d.b.b(this.rr.lBR) != null))
    {
      aei localaei = (aei)d.b.b(this.rr.lBR);
      AppMethodBeat.o(205628);
      return localaei;
    }
    AppMethodBeat.o(205628);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124300);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124300);
    return i;
  }
  
  public final int getType()
  {
    return 1355;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124299);
    Log.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.a.o
 * JD-Core Version:    0.7.0.1
 */