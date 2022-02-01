package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends q
  implements m
{
  private i callback;
  public LinkedList<String> pQI;
  public int pQK;
  public int pQL;
  public int pQM;
  private final d rr;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(112843);
    d.a locala = new d.a();
    locala.iLN = new bkp();
    locala.iLO = new bkq();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bkp)this.rr.iLK.iLR).eaO = paramString;
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
      params = (bkq)this.rr.iLL.iLR;
      this.pQI = params.pQI;
      this.pQK = params.pQK;
      this.pQL = params.pQL;
      this.pQM = params.pQM;
    }
    Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.pQK), Integer.valueOf(this.pQL), Integer.valueOf(this.pQM) });
    if (this.pQI != null) {
      Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.pQI.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */