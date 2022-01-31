package com.tencent.mm.ao;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import junit.framework.Assert;

public final class a
  extends m
  implements k
{
  private bi bFH = new bi();
  private f dmL;
  private ah handler = new a.1(this);
  
  public a(String paramString1, String paramString2)
  {
    this.bFH.setStatus(1);
    this.bFH.ec(paramString1);
    this.bFH.bg(bd.iK(paramString1));
    this.bFH.fA(1);
    this.bFH.setContent(paramString2);
    this.bFH.setType(s.hW(paramString1));
    au.Hx();
    long l = c.Fy().T(this.bFH);
    if (l != -1L) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      y.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = " + l);
      return;
      bool = false;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.bFH.field_msgId);
    this.handler.sendEmptyMessageDelayed(0, 500L);
    return 999;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.bFH.field_msgId);
    this.bFH.setStatus(2);
    this.bFH.bg(bd.o(this.bFH.field_talker, System.currentTimeMillis() / 1000L));
    au.Hx();
    c.Fy().a(this.bFH.field_msgId, this.bFH);
    this.dmL.onSceneEnd(0, 0, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ao.a
 * JD-Core Version:    0.7.0.1
 */