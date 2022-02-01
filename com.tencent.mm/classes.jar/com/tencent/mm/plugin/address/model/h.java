package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.elu;
import com.tencent.mm.protocal.protobuf.emb;
import com.tencent.mm.protocal.protobuf.emc;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public h(b paramb)
  {
    AppMethodBeat.i(20786);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new emb();
    ((c.a)localObject).otF = new emc();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((c.a)localObject).funcId = 418;
    ((c.a)localObject).otG = 203;
    ((c.a)localObject).respCmdId = 1000000203;
    this.rr = ((c.a)localObject).bEF();
    localObject = (emb)c.b.b(this.rr.otB);
    ((emb)localObject).abqh = new elu();
    ((emb)localObject).abqh.id = paramb.id;
    ((emb)localObject).abqh.abqo = new etl().btH(Util.nullAs(paramb.qie, ""));
    ((emb)localObject).abqh.abqm = new etl().btH(Util.nullAs(paramb.qic, ""));
    ((emb)localObject).abqh.abqr = new etl().btH(Util.nullAs(paramb.qih, ""));
    ((emb)localObject).abqh.abqp = new etl().btH(Util.nullAs(paramb.qif, ""));
    ((emb)localObject).abqh.abqv = new etl().btH(Util.nullAs(paramb.qil, ""));
    ((emb)localObject).abqh.abqs = new etl().btH(Util.nullAs(paramb.qii, ""));
    ((emb)localObject).abqh.abqt = new etl().btH(Util.nullAs(paramb.qij, ""));
    ((emb)localObject).abqh.abqn = new etl().btH(Util.nullAs(paramb.qid, ""));
    ((emb)localObject).abqh.abqq = new etl().btH(Util.nullAs(paramb.qig, ""));
    ((emb)localObject).abqh.abqu = new etl().btH(Util.nullAs(paramb.qik, ""));
    AppMethodBeat.o(20786);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(20788);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20788);
    return i;
  }
  
  public final int getType()
  {
    return 418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20787);
    Log.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (emc)c.c.b(((c)params).otC);
      if (params.abqi.abql != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + params.abqi.abql.size());
        a.bZe();
        a.bZg().x(params.abqi.abql);
        a.bZe();
        a.bZg().bZj();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */