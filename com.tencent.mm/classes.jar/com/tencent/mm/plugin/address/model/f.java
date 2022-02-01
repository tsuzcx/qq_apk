package com.tencent.mm.plugin.address.model;

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
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.protocal.protobuf.ely;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends p
  implements m
{
  private h callback;
  public int qhH;
  private c rr;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(20780);
    this.qhH = 0;
    c.a locala = new c.a();
    locala.otE = new elx();
    locala.otF = new ely();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
    locala.funcId = 416;
    locala.otG = 201;
    locala.respCmdId = 1000000201;
    this.rr = locala.bEF();
    this.qhH = paramInt;
    Log.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(paramInt)));
    ((elx)c.b.b(this.rr.otB)).id = paramInt;
    AppMethodBeat.o(20780);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20782);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20782);
    return i;
  }
  
  public final int getType()
  {
    return 416;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20781);
    Log.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ely)c.c.b(((c)params).otC);
      if (params.abqi.abql != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + params.abqi.abql.size());
        a.bZe();
        a.bZg().x(params.abqi.abql);
        a.bZe();
        a.bZg().bZj();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.f
 * JD-Core Version:    0.7.0.1
 */