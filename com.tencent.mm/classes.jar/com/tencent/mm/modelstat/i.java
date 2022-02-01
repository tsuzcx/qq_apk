package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private g gfX;
  private final com.tencent.mm.ak.b rr;
  
  public i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(94871);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new br();
    ((b.a)localObject).hvu = new bs();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((b.a)localObject).funcId = 1295;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (br)this.rr.hvr.hvw;
    bx localbx = new bx();
    localbx.DPl = paramInt1;
    localbx.DPm = new com.tencent.mm.bw.b(paramString.getBytes());
    localbx.sVY = paramInt2;
    ((br)localObject).DOO.add(localbx);
    ac.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(94871);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(94873);
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(94873);
    return i;
  }
  
  public final int getType()
  {
    return 1295;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94872);
    paramq = (bs)this.rr.hvs.hvw;
    ac.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.ret), paramq.bIO });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.i
 * JD-Core Version:    0.7.0.1
 */