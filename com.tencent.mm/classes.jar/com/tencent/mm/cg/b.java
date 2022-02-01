package com.tencent.mm.cg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxk;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  private i callback;
  private final d lBM;
  
  public b(dxk paramdxk)
  {
    AppMethodBeat.i(9330);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dxk();
    ((d.a)localObject).lBV = new dxl();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((d.a)localObject).funcId = 809;
    this.lBM = ((d.a)localObject).bgN();
    localObject = (dxk)d.b.b(this.lBM.lBR);
    ((dxk)localObject).UcV = paramdxk.UcV;
    ((dxk)localObject).UcU = paramdxk.UcU;
    ((dxk)localObject).RUd = paramdxk.RUd;
    ((dxk)localObject).Tek.addAll(paramdxk.Tek);
    ((dxk)localObject).rWu = paramdxk.rWu;
    AppMethodBeat.o(9330);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(9331);
    this.callback = parami;
    int i = dispatch(paramg, this.lBM, this);
    AppMethodBeat.o(9331);
    return i;
  }
  
  public final int getType()
  {
    return 809;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9332);
    Log.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cg.b
 * JD-Core Version:    0.7.0.1
 */