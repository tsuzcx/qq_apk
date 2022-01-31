package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  public final List<String> cAs;
  private final List<String> cAv;
  private final List<String> cAx;
  private final List<String> cAy;
  private f callback;
  private String chatroomName;
  private int czr;
  private final List<String> een;
  private final List<String> eeo;
  private final List<String> eep;
  private final b rr;
  
  public e(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(103910);
    this.callback = null;
    this.czr = 0;
    this.chatroomName = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ca();
    ((b.a)localObject).fsY = new cb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((b.a)localObject).funcId = 120;
    ((b.a)localObject).reqCmdId = 36;
    ((b.a)localObject).respCmdId = 1000000036;
    this.rr = ((b.a)localObject).ado();
    localObject = (ca)this.rr.fsV.fta;
    ((ca)localObject).wow = aa.wA(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bcw localbcw = new bcw();
      localbcw.wOY = aa.wA(str);
      paramString1.add(localbcw);
    }
    ((ca)localObject).wov = paramString1;
    ((ca)localObject).eeF = paramString1.size();
    this.een = new ArrayList();
    this.cAv = new LinkedList();
    this.eeo = new LinkedList();
    this.cAx = new LinkedList();
    this.cAy = new LinkedList();
    this.eep = new ArrayList();
    this.cAs = paramList;
    ((ca)localObject).woy = paramString2;
    AppMethodBeat.o(103910);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).cAv = this.cAv;
      ((c)localObject).czr = this.czr;
      ((c)localObject).cAs = this.cAs;
      ((c)localObject).eeo = this.eeo;
      ((c)localObject).een = this.een;
      ((c)localObject).cAx = this.cAx;
      ((c)localObject).eep = this.eep;
      ((c)localObject).cAy = this.cAy;
    }
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103911);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103911);
    return i;
  }
  
  public final int getType()
  {
    return 120;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103912);
    updateDispatchId(paramInt1);
    paramq = (ca)this.rr.fsV.fta;
    paramArrayOfByte = (cb)this.rr.fsW.fta;
    this.czr = paramArrayOfByte.eeF;
    LinkedList localLinkedList = paramArrayOfByte.wov;
    paramInt1 = 0;
    if (paramInt1 < localLinkedList.size())
    {
      int i = ((bcx)localLinkedList.get(paramInt1)).xsS;
      if (i == 0) {
        this.een.add(aa.a(((bcx)localLinkedList.get(paramInt1)).wOY));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (i == 3)
        {
          ab.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((bcx)localLinkedList.get(paramInt1)).wOY);
          this.eeo.add(aa.a(((bcx)localLinkedList.get(paramInt1)).wOY));
        }
        else if (i == 1)
        {
          ab.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((bcx)localLinkedList.get(paramInt1)).wOY);
          this.cAx.add(aa.a(((bcx)localLinkedList.get(paramInt1)).wOY));
        }
        else if (i == 2)
        {
          ab.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((bcx)localLinkedList.get(paramInt1)).wOY);
          this.cAv.add(aa.a(((bcx)localLinkedList.get(paramInt1)).wOY));
        }
        else if (i == 4)
        {
          ab.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((bcx)localLinkedList.get(paramInt1)).wOY);
          this.cAy.add(aa.a(((bcx)localLinkedList.get(paramInt1)).wOY));
        }
        else if (i != 5)
        {
          if (i == 6) {
            this.eep.add(aa.a(((bcx)localLinkedList.get(paramInt1)).wOY));
          } else {
            ab.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(i)));
          }
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      n.a(aa.a(paramq.wow), paramArrayOfByte);
    }
    AppMethodBeat.o(103912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.e
 * JD-Core Version:    0.7.0.1
 */