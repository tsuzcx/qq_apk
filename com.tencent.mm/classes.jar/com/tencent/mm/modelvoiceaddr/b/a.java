package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.protocal.protobuf.dye;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
  extends q
  implements m
{
  private i callback;
  dyd mnp;
  private d rr;
  
  a(int paramInt, LinkedList<eaf> paramLinkedList, eaf parameaf1, eaf parameaf2)
  {
    AppMethodBeat.i(148644);
    d.a locala = new d.a();
    locala.lBU = new dyd();
    locala.lBV = new dye();
    locala.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    locala.funcId = 228;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.mnp = ((dyd)d.b.b(this.rr.lBR));
    this.mnp.UdQ = paramInt;
    this.mnp.UdR = paramLinkedList;
    this.mnp.UdS = parameaf1;
    this.mnp.UdT = parameaf2;
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