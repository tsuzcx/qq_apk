package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.aqm;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.roomsdk.a.b.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  public bi bWO;
  private final b dmK;
  private f dmL;
  public int dne;
  
  public m(String paramString, List<String> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aqm();
    ((b.a)localObject).ecI = new aqn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((b.a)localObject).ecG = 610;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aqm)this.dmK.ecE.ecN;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      awh localawh = new awh();
      localawh.sQx = aa.pj(str);
      localLinkedList.add(localawh);
    }
    ((aqm)localObject).svo = localLinkedList;
    ((aqm)localObject).dne = localLinkedList.size();
    ((aqm)localObject).svp = aa.pj(paramString);
    ((aqm)localObject).tmu = 0;
  }
  
  public m(String paramString1, List<String> paramList, String paramString2, bi parambi)
  {
    this.bWO = parambi;
    parambi = new b.a();
    parambi.ecH = new aqm();
    parambi.ecI = new aqn();
    parambi.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    parambi.ecG = 610;
    parambi.ecJ = 0;
    parambi.ecK = 0;
    this.dmK = parambi.Kt();
    parambi = (aqm)this.dmK.ecE.ecN;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      awh localawh = new awh();
      localawh.sQx = aa.pj(str);
      localLinkedList.add(localawh);
    }
    this.dne = localLinkedList.size();
    parambi.svo = localLinkedList;
    parambi.dne = localLinkedList.size();
    parambi.svp = aa.pj(paramString1);
    parambi.tmu = 2;
    parambi.tmv = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof d))
    {
      localObject = (d)parama;
      ((d)localObject).dne = this.dne;
      ((d)localObject).ubq = this.bWO;
    }
    return localObject;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 610;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.m
 * JD-Core Version:    0.7.0.1
 */