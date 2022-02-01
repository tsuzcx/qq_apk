package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends p
  implements m
{
  private h callback;
  public List<String> hSb;
  private c rr;
  
  public l(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12467);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aib();
    ((c.a)localObject).otF = new aic();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/delchatroommember";
    ((c.a)localObject).funcId = 179;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aib)c.b.b(this.rr.otB);
    ((aib)localObject).YFk = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ail localail = new ail();
      localail.ZqQ = w.Sk(str);
      paramString.add(localail);
    }
    ((aib)localObject).YFm = paramString;
    ((aib)localObject).lyF = paramString.size();
    ((aib)localObject).IJG = paramInt;
    this.hSb = paramList;
    AppMethodBeat.o(12467);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12468);
    this.callback = paramh;
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
    params = (aib)c.b.b(this.rr.otB);
    paramArrayOfByte = (aic)c.c.b(this.rr.otC);
    if (this.rr.otC.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12469);
      return;
    }
    v.a(params.YFk, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.l
 * JD-Core Version:    0.7.0.1
 */