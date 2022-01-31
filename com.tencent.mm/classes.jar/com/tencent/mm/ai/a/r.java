package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aco;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.protocal.c.js;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r
  extends m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  Map<String, String> eid = new HashMap();
  
  public r(LinkedList<js> paramLinkedList, Object paramObject)
  {
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (js)((Iterator)localObject1).next();
      Object localObject3 = ((js)localObject2).sEz;
      localObject2 = ((js)localObject2).sCO;
      if ((localObject2 != null) && (localObject3 != null) && (((LinkedList)localObject3).size() > 0))
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          this.eid.put(str, localObject2);
        }
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).ecH = new aco();
    ((b.a)localObject1).ecI = new acp();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
    ((b.a)localObject1).ecG = 1353;
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.dmK = ((b.a)localObject1).Kt();
    ((aco)this.dmK.ecE.ecN).tbr = paramLinkedList;
    this.data = paramObject;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1353;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.a.r
 * JD-Core Version:    0.7.0.1
 */