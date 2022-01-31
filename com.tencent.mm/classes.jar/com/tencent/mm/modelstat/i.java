package com.tencent.mm.modelstat;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class i
  extends m
  implements k
{
  private f dIJ;
  private final com.tencent.mm.ah.b dmK;
  
  public i(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bd();
    ((b.a)localObject).ecI = new be();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((b.a)localObject).ecG = 1295;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bd)this.dmK.ecE.ecN;
    bj localbj = new bj();
    localbj.sva = paramInt1;
    localbj.svb = new com.tencent.mm.bv.b(paramString.getBytes());
    localbj.svc = paramInt2;
    ((bd)localObject).suL.add(localbj);
    y.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", new Object[] { Integer.valueOf(paramInt1), paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (be)this.dmK.ecF.ecN;
    y.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramq.ret), paramq.bHk });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1295;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.i
 * JD-Core Version:    0.7.0.1
 */