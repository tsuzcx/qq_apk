package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i heq;
  private final d rr;
  
  public i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(94871);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bx();
    ((d.a)localObject).iLO = new by();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((d.a)localObject).funcId = 1295;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bx)this.rr.iLK.iLR;
    cg localcg = new cg();
    localcg.KGy = paramInt1;
    localcg.KGz = new b(paramString.getBytes());
    localcg.xvg = paramInt2;
    ((bx)localObject).KFY.add(localcg);
    Log.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(94871);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(94873);
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(94873);
    return i;
  }
  
  public final int getType()
  {
    return 1295;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94872);
    params = (by)this.rr.iLL.iLR;
    Log.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(params.ret), params.msg });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.i
 * JD-Core Version:    0.7.0.1
 */