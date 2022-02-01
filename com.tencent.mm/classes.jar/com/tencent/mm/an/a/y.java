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
import com.tencent.mm.protocal.protobuf.frk;
import com.tencent.mm.protocal.protobuf.frl;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends p
  implements m
{
  private h callback;
  Object cpt;
  public c rr;
  
  public y(String paramString1, String paramString2, os paramos1, os paramos2, Object paramObject)
  {
    AppMethodBeat.i(124328);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new frk();
    ((c.a)localObject).otF = new frl();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((c.a)localObject).funcId = 1357;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (frk)c.b.b(this.rr.otB);
    ((frk)localObject).YRQ = paramString1;
    ((frk)localObject).YRJ = paramString2;
    ((frk)localObject).abQV = paramos1;
    ((frk)localObject).abQW = paramos2;
    this.cpt = paramObject;
    AppMethodBeat.o(124328);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124330);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124330);
    return i;
  }
  
  public final int getType()
  {
    return 1357;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124329);
    Log.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.a.y
 * JD-Core Version:    0.7.0.1
 */