package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class q
  extends p
  implements m
{
  private h callback;
  Map<String, String> oyy;
  public c rr;
  
  public q(LinkedList<oq> paramLinkedList)
  {
    AppMethodBeat.i(124304);
    this.oyy = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (oq)((Iterator)localObject1).next();
      String str = ((oq)localObject2).YRJ;
      localObject2 = ((oq)localObject2).YRQ;
      if ((localObject2 != null) && (str != null)) {
        this.oyy.put(str, localObject2);
      }
    }
    localObject1 = new c.a();
    ((c.a)localObject1).otE = new cfj();
    ((c.a)localObject1).otF = new cfk();
    ((c.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
    ((c.a)localObject1).funcId = 1365;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.rr = ((c.a)localObject1).bEF();
    ((cfj)c.b.b(this.rr.otB)).aapd = paramLinkedList;
    AppMethodBeat.o(124304);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124306);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124306);
    return i;
  }
  
  public final int getType()
  {
    return 1365;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124305);
    Log.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.a.q
 * JD-Core Version:    0.7.0.1
 */