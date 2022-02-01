package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private com.tencent.mm.ak.g callback;
  private String chatroomName;
  private int dni;
  public final List<String> dom;
  private final List<String> dop;
  private final List<String> dor;
  private final List<String> dos;
  private final List<String> fsi;
  private final List<String> fsj;
  private final List<String> fsk;
  private final b rr;
  
  public g(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(12455);
    this.callback = null;
    this.dni = 0;
    this.chatroomName = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ci();
    ((b.a)localObject).hvu = new cj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((b.a)localObject).funcId = 120;
    ((b.a)localObject).reqCmdId = 36;
    ((b.a)localObject).respCmdId = 1000000036;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ci)this.rr.hvr.hvw;
    ((ci)localObject).DPA = z.FI(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bud localbud = new bud();
      localbud.EuJ = z.FI(str);
      paramString1.add(localbud);
    }
    ((ci)localObject).DPz = paramString1;
    ((ci)localObject).fsB = paramString1.size();
    this.fsi = new ArrayList();
    this.dop = new LinkedList();
    this.fsj = new LinkedList();
    this.dor = new LinkedList();
    this.dos = new LinkedList();
    this.fsk = new ArrayList();
    this.dom = paramList;
    ((ci)localObject).DPC = paramString2;
    AppMethodBeat.o(12455);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).dop = this.dop;
      ((c)localObject).dni = this.dni;
      ((c)localObject).dom = this.dom;
      ((c)localObject).fsj = this.fsj;
      ((c)localObject).fsi = this.fsi;
      ((c)localObject).dor = this.dor;
      ((c)localObject).fsk = this.fsk;
      ((c)localObject).dos = this.dos;
    }
    return localObject;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    paramq = (ci)this.rr.hvr.hvw;
    paramArrayOfByte = (cj)this.rr.hvs.hvw;
    this.dni = paramArrayOfByte.fsB;
    LinkedList localLinkedList = paramArrayOfByte.DPz;
    paramInt1 = 0;
    if (paramInt1 < localLinkedList.size())
    {
      int i = ((bue)localLinkedList.get(paramInt1)).Fkj;
      if (i == 0) {
        this.fsi.add(z.a(((bue)localLinkedList.get(paramInt1)).EuJ));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (i == 3)
        {
          ac.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((bue)localLinkedList.get(paramInt1)).EuJ);
          this.fsj.add(z.a(((bue)localLinkedList.get(paramInt1)).EuJ));
        }
        else if (i == 1)
        {
          ac.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((bue)localLinkedList.get(paramInt1)).EuJ);
          this.dor.add(z.a(((bue)localLinkedList.get(paramInt1)).EuJ));
        }
        else if (i == 2)
        {
          ac.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((bue)localLinkedList.get(paramInt1)).EuJ);
          this.dop.add(z.a(((bue)localLinkedList.get(paramInt1)).EuJ));
        }
        else if (i == 4)
        {
          ac.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((bue)localLinkedList.get(paramInt1)).EuJ);
          this.dos.add(z.a(((bue)localLinkedList.get(paramInt1)).EuJ));
        }
        else if (i != 5)
        {
          if (i == 6) {
            this.fsk.add(z.a(((bue)localLinkedList.get(paramInt1)).EuJ));
          } else {
            ac.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(i)));
          }
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.model.q.a(z.a(paramq.DPA), paramArrayOfByte);
    }
    AppMethodBeat.o(12457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.g
 * JD-Core Version:    0.7.0.1
 */