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
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djn;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  private i callback;
  public int ksR;
  private d rr;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(20780);
    this.ksR = 0;
    d.a locala = new d.a();
    locala.iLN = new djn();
    locala.iLO = new djo();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
    locala.funcId = 416;
    locala.iLP = 201;
    locala.respCmdId = 1000000201;
    this.rr = locala.aXF();
    this.ksR = paramInt;
    Log.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(paramInt)));
    ((djn)this.rr.iLK.iLR).id = paramInt;
    AppMethodBeat.o(20780);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20782);
    this.callback = parami;
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
      params = (djo)((d)params).iLL.iLR;
      if (params.MNs.MNv != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + params.MNs.MNv.size());
        a.bqb();
        a.bqd().t(params.MNs.MNv);
        a.bqb();
        a.bqd().bqf();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.f
 * JD-Core Version:    0.7.0.1
 */