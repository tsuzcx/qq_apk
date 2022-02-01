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
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class h
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public h(b paramb)
  {
    AppMethodBeat.i(20786);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dtg();
    ((d.a)localObject).lBV = new dth();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((d.a)localObject).funcId = 418;
    ((d.a)localObject).lBW = 203;
    ((d.a)localObject).respCmdId = 1000000203;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dtg)d.b.b(this.rr.lBR);
    ((dtg)localObject).TZk = new dsz();
    ((dtg)localObject).TZk.id = paramb.id;
    ((dtg)localObject).TZk.TZr = new eaf().btQ(Util.nullAs(paramb.nkV, ""));
    ((dtg)localObject).TZk.TZp = new eaf().btQ(Util.nullAs(paramb.nkT, ""));
    ((dtg)localObject).TZk.TZu = new eaf().btQ(Util.nullAs(paramb.nkY, ""));
    ((dtg)localObject).TZk.TZs = new eaf().btQ(Util.nullAs(paramb.nkW, ""));
    ((dtg)localObject).TZk.TZy = new eaf().btQ(Util.nullAs(paramb.nlc, ""));
    ((dtg)localObject).TZk.TZv = new eaf().btQ(Util.nullAs(paramb.nkZ, ""));
    ((dtg)localObject).TZk.TZw = new eaf().btQ(Util.nullAs(paramb.nla, ""));
    ((dtg)localObject).TZk.TZq = new eaf().btQ(Util.nullAs(paramb.nkU, ""));
    ((dtg)localObject).TZk.TZt = new eaf().btQ(Util.nullAs(paramb.nkX, ""));
    ((dtg)localObject).TZk.TZx = new eaf().btQ(Util.nullAs(paramb.nlb, ""));
    AppMethodBeat.o(20786);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20788);
    this.callback = parami;
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
      params = (dth)d.c.b(((d)params).lBS);
      if (params.TZl.TZo != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + params.TZl.TZo.size());
        a.bAn();
        a.bAp().u(params.TZl.TZo);
        a.bAn();
        a.bAp().bAs();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */