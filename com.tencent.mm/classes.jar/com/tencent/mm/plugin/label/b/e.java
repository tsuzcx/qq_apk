package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dql;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.protocal.protobuf.fve;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e
  extends p
  implements m
{
  private LinkedList<fve> JUm;
  private h callback;
  private final c rr;
  
  public e(LinkedList<fve> paramLinkedList)
  {
    AppMethodBeat.i(26152);
    this.JUm = new LinkedList();
    c.a locala = new c.a();
    locala.otE = new dql();
    locala.otF = new dqm();
    locala.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
    locala.funcId = 638;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.JUm = paramLinkedList;
    AppMethodBeat.o(26152);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26154);
    Log.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
    this.callback = paramh;
    paramh = (dql)c.b.b(this.rr.otB);
    paramh.aaWW = this.JUm;
    paramh.aaqr = this.JUm.size();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26154);
    return i;
  }
  
  public final int getType()
  {
    return 638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26153);
    Log.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.e
 * JD-Core Version:    0.7.0.1
 */