package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.eri;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a
  extends p
  implements m
{
  private h callback;
  erh phb;
  private c rr;
  
  a(int paramInt, LinkedList<etl> paramLinkedList, etl parametl1, etl parametl2)
  {
    AppMethodBeat.i(148644);
    c.a locala = new c.a();
    locala.otE = new erh();
    locala.otF = new eri();
    locala.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    locala.funcId = 228;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.phb = ((erh)c.b.b(this.rr.otB));
    this.phb.abve = paramInt;
    this.phb.abvf = paramLinkedList;
    this.phb.abvg = parametl1;
    this.phb.abvh = parametl2;
    AppMethodBeat.o(148644);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(148645);
    this.callback = paramh;
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