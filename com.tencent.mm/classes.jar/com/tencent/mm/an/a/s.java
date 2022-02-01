package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class s
  extends p
  implements m
{
  private h callback;
  Object cpt;
  Map<String, String> oyz;
  public c rr;
  
  public s(LinkedList<rz> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124310);
    this.oyz = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (rz)((Iterator)localObject1).next();
      Object localObject3 = ((rz)localObject2).YWT;
      localObject2 = ((rz)localObject2).YRQ;
      if ((localObject2 != null) && (localObject3 != null) && (((LinkedList)localObject3).size() > 0))
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          this.oyz.put(str, localObject2);
        }
      }
    }
    localObject1 = new c.a();
    ((c.a)localObject1).otE = new cfp();
    ((c.a)localObject1).otF = new cfq();
    ((c.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
    ((c.a)localObject1).funcId = 1353;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.rr = ((c.a)localObject1).bEF();
    ((cfp)c.b.b(this.rr.otB)).aapf = paramLinkedList;
    this.cpt = paramObject;
    AppMethodBeat.o(124310);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124312);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124312);
    return i;
  }
  
  public final int getType()
  {
    return 1353;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124311);
    Log.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.a.s
 * JD-Core Version:    0.7.0.1
 */