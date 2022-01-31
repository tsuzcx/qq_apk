package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.ip;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  Map<String, String> eic = new HashMap();
  
  public p(LinkedList<ip> paramLinkedList)
  {
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ip)((Iterator)localObject1).next();
      String str = ((ip)localObject2).sCI;
      localObject2 = ((ip)localObject2).sCO;
      if ((localObject2 != null) && (str != null)) {
        this.eic.put(str, localObject2);
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).ecH = new aci();
    ((b.a)localObject1).ecI = new acj();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
    ((b.a)localObject1).ecG = 1365;
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.dmK = ((b.a)localObject1).Kt();
    ((aci)this.dmK.ecE.ecN).tbp = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1365;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.a.p
 * JD-Core Version:    0.7.0.1
 */