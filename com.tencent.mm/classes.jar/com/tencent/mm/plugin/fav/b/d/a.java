package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  private f dmL = null;
  private b esv;
  
  public a(ym paramym)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ot();
    ((b.a)localObject).ecI = new ou();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).ecG = 405;
    ((b.a)localObject).ecJ = 196;
    ((b.a)localObject).ecK = 1000000196;
    this.esv = ((b.a)localObject).Kt();
    localObject = (ot)this.esv.ecE.ecN;
    ((ot)localObject).sMt = paramym;
    ((ot)localObject).pyo = 2;
    y.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[] { Integer.valueOf(paramym.svw) });
  }
  
  public a(List<yb> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ot();
    ((b.a)localObject).ecI = new ou();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).ecG = 405;
    ((b.a)localObject).ecJ = 196;
    ((b.a)localObject).ecK = 1000000196;
    this.esv = ((b.a)localObject).Kt();
    localObject = (ot)this.esv.ecE.ecN;
    ((ot)localObject).sMs = new LinkedList();
    ((ot)localObject).sMs.addAll(paramList);
    ((ot)localObject).pyo = 1;
    y.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[] { Integer.valueOf(paramList.size()) });
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ou)((b)paramq).ecF.ecN;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = paramq.sMu.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (ov)paramq.next();
      y.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.svw), Integer.valueOf(paramArrayOfByte.sze) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 405;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.d.a
 * JD-Core Version:    0.7.0.1
 */