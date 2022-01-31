package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.tb;
import com.tencent.mm.protocal.c.tc;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  private String ePP;
  
  public d(String paramString, LinkedList<bba> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new tb();
    ((b.a)localObject).ecI = new tc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((b.a)localObject).ecG = 943;
    this.dmK = ((b.a)localObject).Kt();
    this.ePP = paramString;
    localObject = (tb)this.dmK.ecE.ecN;
    ((tb)localObject).ePR = paramString;
    ((tb)localObject).svR = paramLinkedList;
    y.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePP });
    Object localObject;
    if (paramq.HF().spN == 0)
    {
      localObject = (tc)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      paramArrayOfByte = this.ePP;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((tc)localObject).svR.isEmpty())) {
        break label159;
      }
      y.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((tc)localObject).svR.size());
    }
    for (;;)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
      label159:
      paramq = ((c)g.r(c.class)).FF();
      paramArrayOfByte = paramq.in(paramArrayOfByte);
      List localList = u.aaO(paramArrayOfByte.field_memberlist);
      y.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((tc)localObject).svR.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((bbb)((Iterator)localObject).next()).userName);
      }
      y.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)g.r(com.tencent.mm.plugin.chatroom.a.b.class)).K(localList);
      paramArrayOfByte.jdMethod_do(localList).field_displayname = ((String)localObject);
      boolean bool = paramq.a(paramArrayOfByte);
      y.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember " + bool);
    }
  }
  
  public final int getType()
  {
    return 943;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */