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
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aw;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends p
  implements m
{
  public LinkedList<Integer> JUj;
  public ArrayList<aw> JUk;
  private h callback;
  public final c rr;
  
  public b(List<Integer> paramList)
  {
    AppMethodBeat.i(268627);
    this.JUj = new LinkedList();
    this.JUk = new ArrayList();
    c.a locala = new c.a();
    locala.otE = new lx();
    locala.otF = new ly();
    locala.uri = "/cgi-bin/micromsg-bin/batchupdatecontactlabelwithseq";
    locala.funcId = 5882;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.JUj.addAll(paramList);
    AppMethodBeat.o(268627);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(268633);
    this.callback = paramh;
    lx locallx = (lx)c.b.b(this.rr.otB);
    if ((this.JUj != null) && (this.JUj.size() > 0))
    {
      locallx.YNq = this.JUj;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(268633);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneBatchUpdateContactLabelList", "[doScene] label id list is null.");
    paramh.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
    AppMethodBeat.o(268633);
    return 0;
  }
  
  public final int getType()
  {
    return 5882;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(268630);
    Log.d("MicroMsg.Label.NetSceneBatchUpdateContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(268630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.b
 * JD-Core Version:    0.7.0.1
 */