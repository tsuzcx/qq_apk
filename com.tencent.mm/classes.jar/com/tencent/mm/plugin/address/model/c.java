package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.elp;
import com.tencent.mm.protocal.protobuf.elq;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.elu;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends p
  implements m
{
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public c(b paramb)
  {
    AppMethodBeat.i(20771);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new elp();
    ((c.a)localObject).otF = new elq();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((c.a)localObject).funcId = 415;
    ((c.a)localObject).otG = 200;
    ((c.a)localObject).respCmdId = 1000000200;
    this.rr = ((c.a)localObject).bEF();
    localObject = (elp)c.b.b(this.rr.otB);
    ((elp)localObject).abqh = new elu();
    ((elp)localObject).abqh.abqo = new etl().btH(Util.nullAs(paramb.qie, ""));
    ((elp)localObject).abqh.abqm = new etl().btH(Util.nullAs(paramb.qic, ""));
    ((elp)localObject).abqh.abqr = new etl().btH(Util.nullAs(paramb.qih, ""));
    ((elp)localObject).abqh.abqp = new etl().btH(Util.nullAs(paramb.qif, ""));
    ((elp)localObject).abqh.abqv = new etl().btH(Util.nullAs(paramb.qil, ""));
    ((elp)localObject).abqh.abqs = new etl().btH(Util.nullAs(paramb.qii, ""));
    ((elp)localObject).abqh.abqt = new etl().btH(Util.nullAs(paramb.qij, ""));
    ((elp)localObject).abqh.abqn = new etl().btH(Util.nullAs(paramb.qid, ""));
    ((elp)localObject).abqh.abqq = new etl().btH(Util.nullAs(paramb.qig, ""));
    ((elp)localObject).abqh.abqu = new etl().btH(Util.nullAs(paramb.qik, ""));
    AppMethodBeat.o(20771);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20773);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20773);
    return i;
  }
  
  public final int getType()
  {
    return 415;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20772);
    Log.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (elq)c.c.b(((com.tencent.mm.am.c)params).otC);
      if (params.abqi.abql != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + params.abqi.abql.size());
        a.bZe();
        a.bZg().x(params.abqi.abql);
        a.bZe();
        a.bZg().bZj();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */