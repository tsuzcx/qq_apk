package com.tencent.mm.plugin.location.model.a;

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
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  public String KbU;
  private h callback;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable oTq;
  public final c rr;
  public String wZb;
  
  public b(String paramString)
  {
    AppMethodBeat.i(55788);
    this.KbU = "";
    c.a locala = new c.a();
    locala.otE = new det();
    locala.otF = new deu();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.funcId = 490;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((det)c.b.b(this.rr.otB)).aaKQ = paramString;
    Log.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55788);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(55789);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55789);
    return i;
  }
  
  public final int getType()
  {
    return 490;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55790);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    if (c.c.b(((c)params).otC) != null) {}
    for (params = (deu)c.c.b(((c)params).otC);; params = null)
    {
      Log.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (params != null))
      {
        this.KbU = params.ZvR;
        Log.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.KbU });
      }
      if (params != null) {
        this.wZb = params.YMF;
      }
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.oTq != null) {
        this.oTq.run();
      }
      AppMethodBeat.o(55790);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.b
 * JD-Core Version:    0.7.0.1
 */