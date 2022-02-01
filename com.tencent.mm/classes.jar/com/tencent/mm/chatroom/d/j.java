package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements k
{
  private g callback;
  public List<String> dom;
  private b rr;
  
  public j(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12467);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aat();
    ((b.a)localObject).hvu = new aau();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delchatroommember";
    ((b.a)localObject).funcId = 179;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (aat)this.rr.hvr.hvw;
    ((aat)localObject).DPx = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      abd localabd = new abd();
      localabd.EuJ = z.FI(str);
      paramString.add(localabd);
    }
    ((aat)localObject).DPz = paramString;
    ((aat)localObject).fsB = paramString.size();
    ((aat)localObject).Scene = paramInt;
    this.dom = paramList;
    AppMethodBeat.o(12467);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(12468);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12468);
    return i;
  }
  
  public final int getType()
  {
    return 179;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12469);
    updateDispatchId(paramInt1);
    ac.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (aat)this.rr.hvr.hvw;
    paramArrayOfByte = (aau)this.rr.hvs.hvw;
    if (this.rr.hvs.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12469);
      return;
    }
    com.tencent.mm.model.q.a(paramq.DPx, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.j
 * JD-Core Version:    0.7.0.1
 */