package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcg;
import com.tencent.mm.protocal.c.bkx;
import com.tencent.mm.protocal.c.bky;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public ah(LinkedList<bcg> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bkx();
    ((b.a)localObject).ecI = new bky();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
    ((b.a)localObject).ecG = 1275;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    ((bkx)this.dmK.ecE.ecN).tEz = paramLinkedList;
    if (paramLinkedList != null)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (bcg)paramLinkedList.next();
        y.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[] { ((bcg)localObject).bZc, ((bcg)localObject).inb, Integer.valueOf(((bcg)localObject).txJ), Integer.valueOf(((bcg)localObject).txK) });
      }
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1275;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ah
 * JD-Core Version:    0.7.0.1
 */