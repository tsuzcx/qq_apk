package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.protocal.c.aek;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public c()
  {
    b.a locala = new b.a();
    locala.ecH = new aej();
    locala.ecI = new aek();
    locala.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
    locala.ecG = 639;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 0;
    y.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(209408, Long.valueOf(System.currentTimeMillis()));
      paramq = (aek)this.dmK.ecF.ecN;
      if ((paramq != null) && (paramq.svt != null))
      {
        paramq = paramq.svt;
        paramArrayOfByte = new ArrayList();
        int j = paramq.size();
        paramInt1 = i;
        while (paramInt1 < j)
        {
          atc localatc = (atc)paramq.get(paramInt1);
          af localaf = new af();
          localaf.field_labelID = localatc.toI;
          localaf.field_labelName = localatc.toH;
          localaf.field_labelPYFull = g.oY(localatc.toH);
          localaf.field_labelPYShort = g.oZ(localatc.toH);
          paramArrayOfByte.add(localaf);
          paramInt1 += 1;
        }
        com.tencent.mm.plugin.label.e.bdz().dq(paramArrayOfByte);
        com.tencent.mm.plugin.label.e.bdz().dr(com.tencent.mm.plugin.label.e.bdz().ds(paramArrayOfByte));
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
    }
  }
  
  public final int getType()
  {
    return 639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.c
 * JD-Core Version:    0.7.0.1
 */