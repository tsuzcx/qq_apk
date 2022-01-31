package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.protocal.c.sv;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ag
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  private LinkedList<Integer> jZH;
  private int jZI = 0;
  
  public ag(LinkedList<Integer> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new gg();
    locala.ecI = new gh();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.ecG = 403;
    locala.ecJ = 194;
    locala.ecK = 1000000194;
    this.dmK = locala.Kt();
    this.jZH = paramLinkedList;
  }
  
  private boolean aQE()
  {
    if ((this.jZH != null) && (this.jZI < this.jZH.size())) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(e parame, f paramf)
  {
    if ((this.jZH == null) || (this.jZH.isEmpty()) || (this.jZI >= this.jZH.size()))
    {
      y.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.jZI) });
      return -1;
    }
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.jZH.size()), Integer.valueOf(this.jZI), this.jZH });
    paramf = (gg)this.dmK.ecE.ecN;
    paramf.sAq.clear();
    int j = this.jZI;
    int i = 0;
    if (j < this.jZH.size())
    {
      int k = ((Integer)this.jZH.get(j)).intValue();
      if (k <= 0) {
        break label253;
      }
      paramf.sAq.add(Integer.valueOf(k));
      i += 1;
    }
    label253:
    for (;;)
    {
      if (i < 20)
      {
        j += 1;
        break;
      }
      this.jZI = (j + 1);
      paramf.hPS = paramf.sAq.size();
      y.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(paramf.hPS), paramf.sAq });
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.jZI), Integer.valueOf(this.jZH.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (aQE())
      {
        a(this.edc, this.dmL);
        return;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = ((gh)((com.tencent.mm.ah.b)paramq).ecF.ecN).hPT;
    if ((paramq == null) || (paramq.size() == 0))
    {
      y.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (aQE())
      {
        a(this.edc, this.dmL);
        return;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte = new ArrayList();
    y.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[] { Integer.valueOf(paramq.size()) });
    paramInt1 = 0;
    if (paramInt1 < paramq.size())
    {
      sv localsv = (sv)paramq.get(paramInt1);
      if (localsv.sze < 0) {
        y.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localsv.svw) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localsv.svw));
        y.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localsv.svw) });
      }
    }
    b.bm(paramArrayOfByte);
    if (aQE())
    {
      a(this.edc, this.dmL);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 403;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */