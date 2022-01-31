package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.bs;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private int bRQ = 0;
  public final List<String> bSN;
  private final List<String> bSQ;
  private final List<String> bSS;
  private final List<String> bST;
  private String chatroomName = null;
  private final b dmK;
  private f dmL = null;
  private final List<String> dmM;
  private final List<String> dmN;
  private final List<String> dmO;
  
  public e(String paramString1, List<String> paramList, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bs();
    ((b.a)localObject).ecI = new bt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((b.a)localObject).ecG = 120;
    ((b.a)localObject).ecJ = 36;
    ((b.a)localObject).ecK = 1000000036;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bs)this.dmK.ecE.ecN;
    ((bs)localObject).svp = aa.pj(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      awh localawh = new awh();
      localawh.sQx = aa.pj(str);
      paramString1.add(localawh);
    }
    ((bs)localObject).svo = paramString1;
    ((bs)localObject).dne = paramString1.size();
    this.dmM = new ArrayList();
    this.bSQ = new LinkedList();
    this.dmN = new LinkedList();
    this.bSS = new LinkedList();
    this.bST = new LinkedList();
    this.dmO = new ArrayList();
    this.bSN = paramList;
    ((bs)localObject).svr = paramString2;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
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
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).bSQ = this.bSQ;
      ((c)localObject).bRQ = this.bRQ;
      ((c)localObject).bSN = this.bSN;
      ((c)localObject).dmN = this.dmN;
      ((c)localObject).dmM = this.dmM;
      ((c)localObject).bSS = this.bSS;
      ((c)localObject).dmO = this.dmO;
      ((c)localObject).bST = this.bST;
    }
    return localObject;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (bs)this.dmK.ecE.ecN;
    paramArrayOfByte = (bt)this.dmK.ecF.ecN;
    this.bRQ = paramArrayOfByte.dne;
    LinkedList localLinkedList = paramArrayOfByte.svo;
    paramInt1 = 0;
    if (paramInt1 < localLinkedList.size())
    {
      int i = ((awi)localLinkedList.get(paramInt1)).tsR;
      if (i == 0) {
        this.dmM.add(aa.a(((awi)localLinkedList.get(paramInt1)).sQx));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (i == 3)
        {
          y.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((awi)localLinkedList.get(paramInt1)).sQx);
          this.dmN.add(aa.a(((awi)localLinkedList.get(paramInt1)).sQx));
        }
        else if (i == 1)
        {
          y.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((awi)localLinkedList.get(paramInt1)).sQx);
          this.bSS.add(aa.a(((awi)localLinkedList.get(paramInt1)).sQx));
        }
        else if (i == 2)
        {
          y.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((awi)localLinkedList.get(paramInt1)).sQx);
          this.bSQ.add(aa.a(((awi)localLinkedList.get(paramInt1)).sQx));
        }
        else if (i == 4)
        {
          y.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((awi)localLinkedList.get(paramInt1)).sQx);
          this.bST.add(aa.a(((awi)localLinkedList.get(paramInt1)).sQx));
        }
        else if (i != 5)
        {
          if (i == 6) {
            this.dmO.add(aa.a(((awi)localLinkedList.get(paramInt1)).sQx));
          } else {
            y.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = " + i);
          }
        }
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      m.a(aa.a(paramq.svp), paramArrayOfByte);
    }
  }
  
  public final int getType()
  {
    return 120;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.e
 * JD-Core Version:    0.7.0.1
 */