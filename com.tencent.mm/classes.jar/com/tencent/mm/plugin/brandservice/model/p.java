package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  public c rr;
  
  public p(String paramString, LinkedList<dkv> paramLinkedList)
  {
    AppMethodBeat.i(5596);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dky();
    ((c.a)localObject).otF = new dkz();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
    ((c.a)localObject).funcId = 1030;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dky)c.b.b(this.rr.otB);
    ((dky)localObject).aaGq = paramString;
    ((dky)localObject).aaQR = paramLinkedList;
    AppMethodBeat.o(5596);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(5598);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5598);
    return i;
  }
  
  public final int getType()
  {
    return 1030;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5597);
    Log.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.p
 * JD-Core Version:    0.7.0.1
 */