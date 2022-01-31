package com.tencent.mm.openim.b;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public c(LinkedList<bba> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new sc();
    locala.ecI = new sd();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.ecG = 371;
    this.dmK = locala.Kt();
    ((sc)this.dmK.ecE.ecN).svR = paramLinkedList;
    y.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if (parama != null)
    {
      localObject = parama;
      if ((parama instanceof com.tencent.mm.roomsdk.a.b.c))
      {
        sd localsd = (sd)this.dmK.ecF.ecN;
        localObject = parama;
        if (localsd != null)
        {
          com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
          localb.q(localsd.svR);
          localObject = (com.tencent.mm.roomsdk.a.b.c)parama;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).chatroomName = localsd.ePR;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).bRQ = localb.dmM.size();
          ((com.tencent.mm.roomsdk.a.b.c)localObject).bSN = localb.dmM;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).dmM = localb.dmM;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).bSQ = localb.bSQ;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).dmN = localb.dmN;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).bSS = localb.bSS;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).dmO = localb.dmO;
          ((com.tencent.mm.roomsdk.a.b.c)localObject).bST = localb.bST;
        }
      }
    }
    return localObject;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (paramq.HF().spN == 0)
    {
      paramq = (sd)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if (!bk.bl(paramq.ePR))
      {
        if (paramq.ePR.toLowerCase().endsWith("@im.chatroom")) {
          break label141;
        }
        y.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + paramq.ePR + "]");
      }
    }
    for (;;)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
      label141:
      paramArrayOfByte = new ad();
      paramArrayOfByte.setUsername(paramq.ePR);
      bd localbd = ((j)g.r(j.class)).Fw();
      if (!localbd.abn(paramArrayOfByte.field_username)) {
        localbd.V(paramArrayOfByte);
      }
      if ((!bk.bl(paramArrayOfByte.field_username)) && (!bk.bl(paramq.sQg)))
      {
        localObject = new h();
        ((h)localObject).username = paramArrayOfByte.field_username;
        ((h)localObject).ebT = paramq.sQf;
        ((h)localObject).ebS = paramq.sQg;
        ((h)localObject).cCq = 3;
        ((h)localObject).bK(false);
        ((h)localObject).bcw = -1;
        o.Kh().a((h)localObject);
      }
      Object localObject = new ArrayList();
      Iterator localIterator = paramq.svR.iterator();
      while (localIterator.hasNext())
      {
        bbb localbbb = (bbb)localIterator.next();
        if (localbbb.status == 0)
        {
          paramq = localbd.abl(localbbb.userName);
          if ((int)paramq.dBe != 0)
          {
            paramq.AG();
            localbd.a(paramq.field_username, paramq);
          }
          for (;;)
          {
            ((ArrayList)localObject).add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localbbb);
            localbd.V(paramq);
          }
        }
      }
      if (!((ArrayList)localObject).contains(com.tencent.mm.model.q.Gj()))
      {
        ((ArrayList)localObject).add(com.tencent.mm.model.q.Gj());
        y.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(com.tencent.mm.model.q.Gj()));
      }
      ((com.tencent.mm.plugin.chatroom.a.b)g.r(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, com.tencent.mm.model.q.Gj());
    }
  }
  
  public final int getType()
  {
    return 371;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */