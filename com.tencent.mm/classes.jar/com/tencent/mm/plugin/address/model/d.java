package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class d
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d rr;
  public int status;
  
  public d(String paramString1, String paramString2, p paramp)
  {
    AppMethodBeat.i(20774);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new djh();
    ((d.a)localObject).iLO = new dji();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
    ((d.a)localObject).funcId = 582;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    StringBuilder localStringBuilder = new StringBuilder("a2key is ");
    if (!Util.isNullOrNil(paramString1))
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", newa2key is ");
      if (Util.isNullOrNil(paramString2)) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", bool1);
      this.rr = ((d.a)localObject).aXF();
      localObject = (djh)this.rr.iLK.iLR;
      ((djh)localObject).KLh = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(paramString1));
      ((djh)localObject).MNt = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(paramString2));
      ((djh)localObject).qq = paramp.intValue();
      AppMethodBeat.o(20774);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20776);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20776);
    return i;
  }
  
  public final int getType()
  {
    return 582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20775);
    Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dji)((com.tencent.mm.ak.d)params).iLL.iLR;
      this.status = params.MNu;
      Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
      if ((params.MNs.MNv != null) && (this.status == 0))
      {
        Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + params.MNs.MNv.size());
        a.bqb();
        a.bqd().t(params.MNs.MNv);
        a.bqb();
        a.bqd().bqf();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.d
 * JD-Core Version:    0.7.0.1
 */