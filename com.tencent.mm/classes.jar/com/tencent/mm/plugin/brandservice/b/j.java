package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.bqa;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public j(List<jt> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqa();
    ((b.a)localObject).ecI = new bqb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((b.a)localObject).ecG = 386;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bqa)this.dmK.ecE.ecN;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      jt localjt = (jt)paramList.next();
      ai localai = new ai();
      localai.hPY = localjt.userName;
      localLinkedList.add(localai);
    }
    ((bqa)localObject).hPS = localLinkedList.size();
    ((bqa)localObject).hPT = localLinkedList;
    y.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bqb)this.dmK.ecF.ecN;
      y.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(paramq.tas) });
      a.g(196610, Integer.valueOf(paramq.tas));
      a.g(196611, Boolean.valueOf(false));
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      a.g(196611, Boolean.valueOf(true));
    }
  }
  
  public final int getType()
  {
    return 386;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */