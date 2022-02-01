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
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dqi;
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
    ((d.a)localObject).iLN = new djr();
    ((d.a)localObject).iLO = new djs();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((d.a)localObject).funcId = 418;
    ((d.a)localObject).iLP = 203;
    ((d.a)localObject).respCmdId = 1000000203;
    this.rr = ((d.a)localObject).aXF();
    localObject = (djr)this.rr.iLK.iLR;
    ((djr)localObject).MNr = new djk();
    ((djr)localObject).MNr.id = paramb.id;
    ((djr)localObject).MNr.MNy = new dqi().bhy(Util.nullAs(paramb.kti, ""));
    ((djr)localObject).MNr.MNw = new dqi().bhy(Util.nullAs(paramb.ktg, ""));
    ((djr)localObject).MNr.MNB = new dqi().bhy(Util.nullAs(paramb.ktl, ""));
    ((djr)localObject).MNr.MNz = new dqi().bhy(Util.nullAs(paramb.ktj, ""));
    ((djr)localObject).MNr.MNC = new dqi().bhy(Util.nullAs(paramb.ktm, ""));
    ((djr)localObject).MNr.MND = new dqi().bhy(Util.nullAs(paramb.ktn, ""));
    ((djr)localObject).MNr.MNx = new dqi().bhy(Util.nullAs(paramb.kth, ""));
    ((djr)localObject).MNr.MNA = new dqi().bhy(Util.nullAs(paramb.ktk, ""));
    ((djr)localObject).MNr.MNE = new dqi().bhy(Util.nullAs(paramb.kto, ""));
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
      params = (djs)((d)params).iLL.iLR;
      if (params.MNs.MNv != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + params.MNs.MNv.size());
        a.bqb();
        a.bqd().t(params.MNs.MNv);
        a.bqb();
        a.bqd().bqf();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */