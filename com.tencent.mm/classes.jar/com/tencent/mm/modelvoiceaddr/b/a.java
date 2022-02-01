package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doj;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
  extends q
  implements m
{
  private i callback;
  doj jxM;
  private d rr;
  
  a(int paramInt, LinkedList<dqi> paramLinkedList, dqi paramdqi1, dqi paramdqi2)
  {
    AppMethodBeat.i(148644);
    d.a locala = new d.a();
    locala.iLN = new doj();
    locala.iLO = new dok();
    locala.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    locala.funcId = 228;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.jxM = ((doj)this.rr.iLK.iLR);
    this.jxM.MRJ = paramInt;
    this.jxM.MRK = paramLinkedList;
    this.jxM.MRL = paramdqi1;
    this.jxM.MRM = paramdqi2;
    AppMethodBeat.o(148644);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(148645);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(148645);
    return i;
  }
  
  public final int getType()
  {
    return 228;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148646);
    Log.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(148646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.a
 * JD-Core Version:    0.7.0.1
 */