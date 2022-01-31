package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.brs;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class am
  extends m
  implements k
{
  private final b dmK;
  private f dmL = null;
  private List<Integer> kad;
  private am.a kae = null;
  private SparseArray<String> kaf = new SparseArray();
  private int scene;
  private String toUser;
  
  public am(String paramString, List<Integer> paramList, am.a parama)
  {
    b.a locala = new b.a();
    locala.ecH = new brs();
    locala.ecI = new brt();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.ecG = 608;
    locala.ecJ = 246;
    locala.ecK = 1000000246;
    this.dmK = locala.Kt();
    this.toUser = paramString;
    this.scene = 2;
    this.kad = paramList;
    this.kae = parama;
  }
  
  public final int a(e parame, f paramf)
  {
    brs localbrs = (brs)this.dmK.ecE.ecN;
    localbrs.tIm = this.toUser;
    localbrs.pyo = this.scene;
    localbrs.sAq = new LinkedList(this.kad);
    localbrs.hPS = localbrs.sAq.size();
    y.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localbrs.tIm, Integer.valueOf(localbrs.pyo), localbrs.sAq, Integer.valueOf(localbrs.hPS) });
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneShareFavItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.kaf.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (brt)((b)paramq).ecF.ecN;
      if (paramq.thu != this.kad.size()) {
        y.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.kad.size()), Integer.valueOf(paramq.thu) });
      }
      paramInt1 = 0;
      while ((paramInt1 < paramq.sAv.size()) && (paramInt1 < this.kad.size()))
      {
        y.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.kad.get(paramInt1), paramq.sAv.get(paramInt1) });
        this.kaf.put(((Integer)this.kad.get(paramInt1)).intValue(), ((bml)paramq.sAv.get(paramInt1)).tFO);
        paramInt1 += 1;
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.kae != null) {
      this.kae.c(this.kaf);
    }
  }
  
  public final int getType()
  {
    return 608;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */