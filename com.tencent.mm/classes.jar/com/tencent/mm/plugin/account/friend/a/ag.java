package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag
  extends m
  implements k
{
  private final b dmK;
  private f dmL = null;
  
  public ag(String paramString, List<String[]> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aud();
    ((b.a)localObject).ecI = new aue();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((b.a)localObject).ecG = 431;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aud)this.dmK.ecE.ecN;
    ((aud)localObject).sRr = paramString;
    ((aud)localObject).tpD = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((aud)localObject).tpB = i;
      ((aud)localObject).tpE = new LinkedList();
      ((aud)localObject).tpC = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!bk.bl(paramList[2])) {
          ((aud)localObject).tpC.add(new bml().YI(paramList[2]));
        }
      }
      i = paramList.size();
    }
  }
  
  public final LinkedList<auc> Xd()
  {
    Object localObject = ((aue)this.dmK.ecF.ecN).tpF;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        auc localauc = (auc)((Iterator)localObject).next();
        a.YT().Ga().gm(localauc.hPY, localauc.tac);
      }
    }
    return ((aue)this.dmK.ecF.ecN).tpF;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (aue)this.dmK.ecF.ecN;
    com.tencent.mm.kernel.g.DS().a(new ag.1(this, paramq));
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 431;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ag
 * JD-Core Version:    0.7.0.1
 */