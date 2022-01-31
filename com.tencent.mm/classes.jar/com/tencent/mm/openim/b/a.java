package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  private String ePP;
  
  public a(String paramString, LinkedList<bba> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cf();
    ((b.a)localObject).ecI = new cg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((b.a)localObject).ecG = 814;
    this.dmK = ((b.a)localObject).Kt();
    this.ePP = paramString;
    localObject = (cf)this.dmK.ecE.ecN;
    ((cf)localObject).ePR = paramString;
    ((cf)localObject).svR = paramLinkedList;
    y.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
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
      if ((parama instanceof c))
      {
        cg localcg = (cg)this.dmK.ecF.ecN;
        localObject = parama;
        if (localcg != null)
        {
          com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
          localb.q(localcg.svR);
          localObject = (c)parama;
          ((c)localObject).chatroomName = this.ePP;
          ((c)localObject).bRQ = localb.dmM.size();
          ((c)localObject).bSN = localb.dmM;
          ((c)localObject).dmM = localb.dmM;
          ((c)localObject).bSQ = localb.bSQ;
          ((c)localObject).dmN = localb.dmN;
          ((c)localObject).bSS = localb.bSS;
          ((c)localObject).dmO = localb.dmO;
          ((c)localObject).bST = localb.bST;
          ((c)localObject).svS = localcg.svS;
        }
      }
    }
    return localObject;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePP });
    if (paramq.HF().spN == 0)
    {
      paramq = (cg)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      paramArrayOfByte = this.ePP;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!paramq.svR.isEmpty())) {
        break label159;
      }
      y.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + paramq.svR.size());
    }
    for (;;)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
      label159:
      ArrayList localArrayList = new ArrayList();
      bd localbd = ((j)g.r(j.class)).Fw();
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
            localArrayList.add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localbbb);
            localbd.V(paramq);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.b)g.r(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
  
  public final int getType()
  {
    return 814;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */