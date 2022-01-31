package com.tencent.mm.chatroom.c;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  public int bSO = 0;
  public String bSP;
  public final List<String> bSQ;
  public final List<String> bSS;
  public List<String> bST;
  public List<String> bSU;
  private final b dmK;
  private f dmL;
  public final List<String> dmN;
  
  public g(String paramString, List<String> paramList)
  {
    y.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + paramString + " size : " + paramList.size() + " username : " + (String)paramList.get(0));
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ry();
    ((b.a)localObject).ecI = new rz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((b.a)localObject).ecG = 119;
    ((b.a)localObject).ecJ = 37;
    ((b.a)localObject).ecK = 1000000037;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ry)this.dmK.ecE.ecN;
    ((ry)localObject).sPY = aa.pj(paramString);
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      awh localawh = new awh();
      localawh.sQx = aa.pj(str);
      paramString.add(localawh);
    }
    ((ry)localObject).svo = paramString;
    ((ry)localObject).dne = paramString.size();
    this.bSQ = new LinkedList();
    this.dmN = new LinkedList();
    this.bSS = new LinkedList();
    this.bST = new LinkedList();
    this.bSU = new LinkedList();
    this.bSP = "";
  }
  
  private void D(List<awi> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((awi)paramList.get(i)).tsR;
      if (j == 0) {
        this.bSU.add(aa.a(((awi)paramList.get(i)).sQx));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          y.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((awi)paramList.get(i)).sQx);
          this.dmN.add(aa.a(((awi)paramList.get(i)).sQx));
        }
        else if (j == 1)
        {
          y.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((awi)paramList.get(i)).sQx);
          this.bSS.add(aa.a(((awi)paramList.get(i)).sQx));
        }
        else if (j == 2)
        {
          y.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((awi)paramList.get(i)).sQx);
          this.bSQ.add(aa.a(((awi)paramList.get(i)).sQx));
        }
        else if (j == 4)
        {
          y.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((awi)paramList.get(i)).sQx);
          this.bST.add(aa.a(((awi)paramList.get(i)).sQx));
        }
        else if ((j != 5) && (j != 6))
        {
          y.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = " + j);
        }
      }
    }
  }
  
  private static boolean a(rz paramrz)
  {
    int i = 0;
    if ((!aa.a(paramrz.svp).toLowerCase().endsWith("@chatroom")) || (paramrz.dne == 0))
    {
      y.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramrz.svp + "] listCnt:" + paramrz.dne);
      return false;
    }
    ad localad = new ad();
    localad.dk(aa.a(paramrz.sPY));
    localad.dl(aa.a(paramrz.sQa));
    localad.dm(aa.a(paramrz.sQb));
    localad.setUsername(aa.a(paramrz.svp));
    bd localbd = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw();
    if (!localbd.abn(localad.field_username)) {
      localbd.V(localad);
    }
    Object localObject = new h();
    ((h)localObject).username = localad.field_username;
    ((h)localObject).ebT = paramrz.sLD;
    ((h)localObject).ebS = paramrz.sLE;
    ((h)localObject).cCq = 3;
    ((h)localObject).bK(false);
    ((h)localObject).bcw = -1;
    o.Kh().a((h)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramrz.svo.size())
    {
      if (((awi)paramrz.svo.get(i)).tsR == 0)
      {
        localObject = localbd.abl(aa.a(((awi)paramrz.svo.get(i)).sQx));
        if ((int)((com.tencent.mm.n.a)localObject).dBe == 0) {
          break label314;
        }
        ((ad)localObject).AG();
        localbd.a(((ao)localObject).field_username, (ad)localObject);
      }
      for (;;)
      {
        localArrayList.add(((ao)localObject).field_username);
        i += 1;
        break;
        label314:
        localObject = m.a((ad)localObject, (awi)paramrz.svo.get(i));
        localbd.V((ad)localObject);
      }
    }
    if (!localArrayList.contains(com.tencent.mm.model.q.Gj()))
    {
      localArrayList.add(com.tencent.mm.model.q.Gj());
      y.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(com.tencent.mm.model.q.Gj()));
    }
    return m.a(localad.field_username, localArrayList, com.tencent.mm.model.q.Gj());
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.bSP;
      ((c)localObject).bSQ = this.bSQ;
      ((c)localObject).bRQ = this.bSO;
      ((c)localObject).bSN = this.bSU;
      ((c)localObject).dmM = this.bSU;
      ((c)localObject).dmN = this.dmN;
      ((c)localObject).bSS = this.bSS;
      ((c)localObject).dmO = new LinkedList();
      ((c)localObject).bST = this.bST;
    }
    return localObject;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (rz)this.dmK.ecF.ecN;
    this.bSP = aa.a(paramq.svp);
    paramInt1 = this.dmK.ecF.spN;
    this.bSO = paramq.dne;
    D(paramq.svo);
    if ((!bk.bl(this.bSP)) && (paramInt1 == 0)) {
      a(paramq);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 119;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.g
 * JD-Core Version:    0.7.0.1
 */