package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private com.tencent.mm.al.g callback;
  private String chatroomName;
  private int dpx;
  public final List<String> dqB;
  private final List<String> dqE;
  private final List<String> dqG;
  private final List<String> dqH;
  private final List<String> foI;
  private final List<String> foJ;
  private final List<String> foK;
  private final b rr;
  
  public g(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(12455);
    this.callback = null;
    this.dpx = 0;
    this.chatroomName = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cg();
    ((b.a)localObject).gUV = new ch();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((b.a)localObject).funcId = 120;
    ((b.a)localObject).reqCmdId = 36;
    ((b.a)localObject).respCmdId = 1000000036;
    this.rr = ((b.a)localObject).atI();
    localObject = (cg)this.rr.gUS.gUX;
    ((cg)localObject).Cxe = z.BE(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bpm localbpm = new bpm();
      localbpm.DbD = z.BE(str);
      paramString1.add(localbpm);
    }
    ((cg)localObject).Cxd = paramString1;
    ((cg)localObject).fpb = paramString1.size();
    this.foI = new ArrayList();
    this.dqE = new LinkedList();
    this.foJ = new LinkedList();
    this.dqG = new LinkedList();
    this.dqH = new LinkedList();
    this.foK = new ArrayList();
    this.dqB = paramList;
    ((cg)localObject).Cxg = paramString2;
    AppMethodBeat.o(12455);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).dqE = this.dqE;
      ((c)localObject).dpx = this.dpx;
      ((c)localObject).dqB = this.dqB;
      ((c)localObject).foJ = this.foJ;
      ((c)localObject).foI = this.foI;
      ((c)localObject).dqG = this.dqG;
      ((c)localObject).foK = this.foK;
      ((c)localObject).dqH = this.dqH;
    }
    return localObject;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(12456);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12456);
    return i;
  }
  
  public final int getType()
  {
    return 120;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12457);
    updateDispatchId(paramInt1);
    paramq = (cg)this.rr.gUS.gUX;
    paramArrayOfByte = (ch)this.rr.gUT.gUX;
    this.dpx = paramArrayOfByte.fpb;
    LinkedList localLinkedList = paramArrayOfByte.Cxd;
    paramInt1 = 0;
    if (paramInt1 < localLinkedList.size())
    {
      int i = ((bpn)localLinkedList.get(paramInt1)).DNS;
      if (i == 0) {
        this.foI.add(z.a(((bpn)localLinkedList.get(paramInt1)).DbD));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (i == 3)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((bpn)localLinkedList.get(paramInt1)).DbD);
          this.foJ.add(z.a(((bpn)localLinkedList.get(paramInt1)).DbD));
        }
        else if (i == 1)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((bpn)localLinkedList.get(paramInt1)).DbD);
          this.dqG.add(z.a(((bpn)localLinkedList.get(paramInt1)).DbD));
        }
        else if (i == 2)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((bpn)localLinkedList.get(paramInt1)).DbD);
          this.dqE.add(z.a(((bpn)localLinkedList.get(paramInt1)).DbD));
        }
        else if (i == 4)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((bpn)localLinkedList.get(paramInt1)).DbD);
          this.dqH.add(z.a(((bpn)localLinkedList.get(paramInt1)).DbD));
        }
        else if (i != 5)
        {
          if (i == 6) {
            this.foK.add(z.a(((bpn)localLinkedList.get(paramInt1)).DbD));
          } else {
            ad.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(i)));
          }
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.model.q.a(z.a(paramq.Cxe), paramArrayOfByte);
    }
    AppMethodBeat.o(12457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.g
 * JD-Core Version:    0.7.0.1
 */