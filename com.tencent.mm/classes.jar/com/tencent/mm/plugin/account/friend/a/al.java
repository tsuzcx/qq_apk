package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.protocal.c.awt;
import com.tencent.mm.protocal.c.cbb;
import com.tencent.mm.protocal.c.cbc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends m
  implements k
{
  private int bNb;
  private f dmL;
  public final List<String> fgJ;
  public final List<String> fgK;
  private final String fgL = (String)com.tencent.mm.kernel.g.DP().Dz().get(6, null);
  private int fgM = 0;
  private int fgN = 0;
  
  public al(List<String> paramList1, List<String> paramList2)
  {
    this.fgJ = paramList1;
    this.fgK = paramList2;
    this.bNb = 1;
  }
  
  private static List<String> al(List<auq> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((auq)paramList.next()).v);
    }
    return localArrayList;
  }
  
  private static List<String> am(List<awt> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(com.tencent.mm.a.g.o(a.qa(((awt)paramList.next()).v).getBytes()));
    }
    return localArrayList;
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    int m = 0;
    this.dmL = paramf;
    if (((this.fgJ == null) || (this.fgJ.size() == 0)) && ((this.fgK == null) || (this.fgK.size() == 0)))
    {
      y.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      return -1;
    }
    paramf = new b.a();
    paramf.ecH = new cbb();
    paramf.ecI = new cbc();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    paramf.ecG = 133;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    paramf = paramf.Kt();
    cbb localcbb = (cbb)paramf.ecE.ecN;
    localcbb.sBm = this.fgL;
    localcbb.hPY = com.tencent.mm.model.q.Gj();
    localcbb.syV = this.bNb;
    int i = 200;
    Object localObject1 = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    do
    {
      int k;
      do
      {
        if (i <= 0) {
          break label428;
        }
        int j = i;
        Object localObject2;
        if (this.fgJ != null)
        {
          j = i;
          if (this.fgM < this.fgJ.size())
          {
            if (this.fgJ.get(this.fgM) != null)
            {
              localObject2 = new awt();
              ((awt)localObject2).v = ((String)this.fgJ.get(this.fgM));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.fgM += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.fgK != null)
        {
          k = j;
          if (this.fgN < this.fgK.size())
          {
            if (this.fgK.get(this.fgN) != null)
            {
              localObject2 = new auq();
              ((auq)localObject2).v = ((String)this.fgK.get(this.fgN));
              localLinkedList.add(localObject2);
            }
            this.fgN += 1;
            k = j - 1;
          }
        }
        if (this.fgK == null) {
          break;
        }
        i = k;
      } while (this.fgN < this.fgK.size());
      if (this.fgJ == null) {
        break;
      }
      i = k;
    } while (this.fgM < this.fgJ.size());
    label428:
    localcbb.tpC = ((LinkedList)localObject1);
    localcbb.tQf = ((LinkedList)localObject1).size();
    localcbb.tQh = localLinkedList;
    localcbb.tQg = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.fgK == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.fgJ != null) {
        break label601;
      }
    }
    label601:
    for (i = m;; i = this.fgJ.size())
    {
      y.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.fgN + "," + this.fgM + "] req:[" + localcbb.tQh.size() + "," + localcbb.tpC.size() + "]");
      return a(parame, paramf, this);
      i = this.fgK.size();
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      paramq = (cbb)((b)paramq).ecE.ecN;
      l.aj(al(paramq.tQh));
      l.aj(am(paramq.tpC));
      if (((this.fgK == null) || (this.fgN >= this.fgK.size())) && ((this.fgJ == null) || (this.fgM >= this.fgJ.size())))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    } while (a(this.edc, this.dmL) >= 0);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    paramq = (cbb)((b)paramq).ecE.ecN;
    int i = paramq.tQh.size() + paramq.tpC.size();
    if ((i == 0) || (i > 200))
    {
      y.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      return m.b.eds;
    }
    if ((paramq.sBm == null) || (paramq.sBm.length() <= 0))
    {
      y.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      return m.b.eds;
    }
    if ((paramq.hPY == null) || (paramq.hPY.length() <= 0))
    {
      y.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 133;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.al
 * JD-Core Version:    0.7.0.1
 */