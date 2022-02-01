package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends q
  implements m
{
  private i callback;
  public List<String> dSU;
  private d rr;
  
  public j(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12467);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new aff();
    ((d.a)localObject).iLO = new afg();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/delchatroommember";
    ((d.a)localObject).funcId = 179;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (aff)this.rr.iLK.iLR;
    ((aff)localObject).KGO = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      afp localafp = new afp();
      localafp.Lqp = z.Su(str);
      paramString.add(localafp);
    }
    ((aff)localObject).KGQ = paramString;
    ((aff)localObject).gsq = paramString.size();
    ((aff)localObject).Scene = paramInt;
    this.dSU = paramList;
    AppMethodBeat.o(12467);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12468);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12468);
    return i;
  }
  
  public final int getType()
  {
    return 179;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12469);
    updateDispatchId(paramInt1);
    Log.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = (aff)this.rr.iLK.iLR;
    paramArrayOfByte = (afg)this.rr.iLL.iLR;
    if (this.rr.iLL.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12469);
      return;
    }
    v.a(params.KGO, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.j
 * JD-Core Version:    0.7.0.1
 */