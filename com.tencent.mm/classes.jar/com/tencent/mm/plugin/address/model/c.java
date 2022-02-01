package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.dqi;
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
    ((d.a)localObject).iLN = new djf();
    ((d.a)localObject).iLO = new djg();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((d.a)localObject).funcId = 415;
    ((d.a)localObject).iLP = 200;
    ((d.a)localObject).respCmdId = 1000000200;
    this.rr = ((d.a)localObject).aXF();
    localObject = (djf)this.rr.iLK.iLR;
    ((djf)localObject).MNr = new djk();
    ((djf)localObject).MNr.MNy = new dqi().bhy(Util.nullAs(paramb.kti, ""));
    ((djf)localObject).MNr.MNw = new dqi().bhy(Util.nullAs(paramb.ktg, ""));
    ((djf)localObject).MNr.MNB = new dqi().bhy(Util.nullAs(paramb.ktl, ""));
    ((djf)localObject).MNr.MNz = new dqi().bhy(Util.nullAs(paramb.ktj, ""));
    ((djf)localObject).MNr.MNC = new dqi().bhy(Util.nullAs(paramb.ktm, ""));
    ((djf)localObject).MNr.MND = new dqi().bhy(Util.nullAs(paramb.ktn, ""));
    ((djf)localObject).MNr.MNx = new dqi().bhy(Util.nullAs(paramb.kth, ""));
    ((djf)localObject).MNr.MNA = new dqi().bhy(Util.nullAs(paramb.ktk, ""));
    ((djf)localObject).MNr.MNE = new dqi().bhy(Util.nullAs(paramb.kto, ""));
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
      params = (djg)((d)params).iLL.iLR;
      if (params.MNs.MNv != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + params.MNs.MNv.size());
        a.bqb();
        a.bqd().t(params.MNs.MNv);
        a.bqb();
        a.bqd().bqf();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */