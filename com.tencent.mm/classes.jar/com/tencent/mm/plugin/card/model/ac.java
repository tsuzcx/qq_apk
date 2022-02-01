package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public LinkedList<String> tmH;
  public int tmJ;
  public int tmK;
  public int tmL;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(112843);
    d.a locala = new d.a();
    locala.lBU = new bry();
    locala.lBV = new brz();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((bry)d.b.b(this.rr.lBR)).fUL = paramString;
    AppMethodBeat.o(112843);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112844);
    this.callback = parami;
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
      params = (brz)d.c.b(this.rr.lBS);
      this.tmH = params.tmH;
      this.tmJ = params.tmJ;
      this.tmK = params.tmK;
      this.tmL = params.tmL;
    }
    Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.tmJ), Integer.valueOf(this.tmK), Integer.valueOf(this.tmL) });
    if (this.tmH != null) {
      Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.tmH.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */