package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.bv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private LinkedList<atc> lAM = new LinkedList();
  
  public a(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bu();
    ((b.a)localObject).ecI = new bv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).ecG = 635;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    if (!bk.bl(paramString))
    {
      localObject = new atc();
      ((atc)localObject).toH = paramString;
      this.lAM.add(localObject);
    }
  }
  
  public a(List<String> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bu();
    ((b.a)localObject).ecI = new bv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).ecG = 635;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new atc();
        ((atc)localObject).toH = ((String)paramList.get(i));
        this.lAM.add(localObject);
        i += 1;
      }
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.dmL = paramf;
    bu localbu = (bu)this.dmK.ecE.ecN;
    if ((this.lAM != null) && (this.lAM.size() > 0))
    {
      localbu.svt = this.lAM;
      localbu.svs = this.lAM.size();
      return a(parame, this.dmK, this);
    }
    y.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = bdB();
    if (paramq != null)
    {
      paramq = paramq.svt;
      paramArrayOfByte = new ArrayList();
      int i = paramq.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        atc localatc = (atc)paramq.get(paramInt1);
        af localaf = new af();
        localaf.field_labelID = localatc.toI;
        localaf.field_labelName = localatc.toH;
        localaf.field_labelPYFull = g.oY(localatc.toH);
        localaf.field_labelPYShort = g.oZ(localatc.toH);
        localaf.field_isTemporary = false;
        paramArrayOfByte.add(localaf);
        paramInt1 += 1;
      }
      com.tencent.mm.plugin.label.e.bdz().dp(paramArrayOfByte);
      com.tencent.mm.plugin.label.e.bdz().dq(paramArrayOfByte);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bv bdB()
  {
    return (bv)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */