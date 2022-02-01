package com.tencent.mm.plugin.address.model;

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
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.dsv;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public c(b paramb)
  {
    AppMethodBeat.i(20771);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dsu();
    ((d.a)localObject).lBV = new dsv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((d.a)localObject).funcId = 415;
    ((d.a)localObject).lBW = 200;
    ((d.a)localObject).respCmdId = 1000000200;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dsu)d.b.b(this.rr.lBR);
    ((dsu)localObject).TZk = new dsz();
    ((dsu)localObject).TZk.TZr = new eaf().btQ(Util.nullAs(paramb.nkV, ""));
    ((dsu)localObject).TZk.TZp = new eaf().btQ(Util.nullAs(paramb.nkT, ""));
    ((dsu)localObject).TZk.TZu = new eaf().btQ(Util.nullAs(paramb.nkY, ""));
    ((dsu)localObject).TZk.TZs = new eaf().btQ(Util.nullAs(paramb.nkW, ""));
    ((dsu)localObject).TZk.TZy = new eaf().btQ(Util.nullAs(paramb.nlc, ""));
    ((dsu)localObject).TZk.TZv = new eaf().btQ(Util.nullAs(paramb.nkZ, ""));
    ((dsu)localObject).TZk.TZw = new eaf().btQ(Util.nullAs(paramb.nla, ""));
    ((dsu)localObject).TZk.TZq = new eaf().btQ(Util.nullAs(paramb.nkU, ""));
    ((dsu)localObject).TZk.TZt = new eaf().btQ(Util.nullAs(paramb.nkX, ""));
    ((dsu)localObject).TZk.TZx = new eaf().btQ(Util.nullAs(paramb.nlb, ""));
    AppMethodBeat.o(20771);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20773);
    this.callback = parami;
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
      params = (dsv)d.c.b(((d)params).lBS);
      if (params.TZl.TZo != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + params.TZl.TZo.size());
        a.bAn();
        a.bAp().u(params.TZl.TZo);
        a.bAn();
        a.bAp().bAs();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */