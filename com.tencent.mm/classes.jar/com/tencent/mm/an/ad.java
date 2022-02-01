package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epw;
import com.tencent.mm.protocal.protobuf.epx;
import com.tencent.mm.protocal.protobuf.epy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ad
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public ad(LinkedList<epw> paramLinkedList)
  {
    AppMethodBeat.i(124143);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new epx();
    ((c.a)localObject).otF = new epy();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/reportcommand";
    ((c.a)localObject).funcId = 2592;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (epx)c.b.b(this.rr.otB);
    ((epx)localObject).Zlm = paramLinkedList;
    Log.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[] { Integer.valueOf(((epx)localObject).Zlm.size()) });
    AppMethodBeat.o(124143);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124145);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124145);
    return i;
  }
  
  public final int getType()
  {
    return 2592;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124144);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(124144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.ad
 * JD-Core Version:    0.7.0.1
 */