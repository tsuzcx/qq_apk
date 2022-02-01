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
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e
  extends q
  implements m
{
  private i callback;
  public boolean ksQ;
  public String nickname;
  private d rr;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20777);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new djl();
    ((d.a)localObject).iLO = new djm();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((d.a)localObject).funcId = 417;
    ((d.a)localObject).iLP = 202;
    ((d.a)localObject).respCmdId = 1000000202;
    this.rr = ((d.a)localObject).aXF();
    localObject = (djl)this.rr.iLK.iLR;
    ((djl)localObject).qwL = 0;
    ((djl)localObject).MNF = paramString1;
    ((djl)localObject).dNI = paramString2;
    ((djl)localObject).scene = paramInt;
    AppMethodBeat.o(20777);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20779);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20779);
    return i;
  }
  
  public final int getType()
  {
    return 417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(20778);
    Log.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (djm)((d)params).iLL.iLR;
      this.username = params.rJH;
      this.nickname = params.MNI;
      if (params.MNH != 1) {
        break label198;
      }
    }
    for (;;)
    {
      this.ksQ = bool;
      if (params.MNs.MNv != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + params.MNs.MNv.size());
        a.bqb();
        a.bqd().t(params.MNs.MNv);
        a.bqb();
        a.bqd().bqf();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20778);
      return;
      label198:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.e
 * JD-Core Version:    0.7.0.1
 */