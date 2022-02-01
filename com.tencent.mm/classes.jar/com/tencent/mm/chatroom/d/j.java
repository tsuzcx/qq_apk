package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements k
{
  private f callback;
  public List<String> dAa;
  private b rr;
  
  public j(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12467);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new act();
    ((b.a)localObject).hNN = new acu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delchatroommember";
    ((b.a)localObject).funcId = 179;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (act)this.rr.hNK.hNQ;
    ((act)localObject).FuL = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      add localadd = new add();
      localadd.Gcd = z.IX(str);
      paramString.add(localadd);
    }
    ((act)localObject).FuN = paramString;
    ((act)localObject).fLb = paramString.size();
    ((act)localObject).Scene = paramInt;
    this.dAa = paramList;
    AppMethodBeat.o(12467);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12468);
    this.callback = paramf;
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
    ad.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (act)this.rr.hNK.hNQ;
    paramArrayOfByte = (acu)this.rr.hNL.hNQ;
    if (this.rr.hNL.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12469);
      return;
    }
    com.tencent.mm.model.q.a(paramq.FuL, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.j
 * JD-Core Version:    0.7.0.1
 */