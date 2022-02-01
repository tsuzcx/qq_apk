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
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public LinkedList<String> wrh;
  public int wrj;
  public int wrk;
  public int wrl;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(112843);
    c.a locala = new c.a();
    locala.otE = new cgr();
    locala.otF = new cgs();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((cgr)c.b.b(this.rr.otB)).iaI = paramString;
    AppMethodBeat.o(112843);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112844);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112844);
    return i;
  }
  
  public final int getType()
  {
    return 577;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112845);
    Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cgs)c.c.b(this.rr.otC);
      this.wrh = params.wrh;
      this.wrj = params.wrj;
      this.wrk = params.wrk;
      this.wrl = params.wrl;
    }
    Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.wrj), Integer.valueOf(this.wrk), Integer.valueOf(this.wrl) });
    if (this.wrh != null) {
      Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.wrh.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */