package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private final b dmK;
  private f dmL;
  private String ePP;
  
  public k(String paramString, LinkedList<bba> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aqt();
    ((b.a)localObject).ecI = new aqu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
    ((b.a)localObject).ecG = 887;
    this.dmK = ((b.a)localObject).Kt();
    this.ePP = paramString;
    localObject = (aqt)this.dmK.ecE.ecN;
    ((aqt)localObject).ePR = paramString;
    ((aqt)localObject).svR = paramLinkedList;
    y.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePP });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 887;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openim.b.k
 * JD-Core Version:    0.7.0.1
 */