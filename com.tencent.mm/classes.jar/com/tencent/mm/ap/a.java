package com.tencent.mm.ap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bi;
import junit.framework.Assert;

public final class a
  extends m
  implements k
{
  private f callback;
  private bi cmQ;
  private ak handler;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(16438);
    this.handler = new a.1(this);
    this.cmQ = new bi();
    this.cmQ.setStatus(1);
    this.cmQ.kj(paramString1);
    this.cmQ.fQ(bf.py(paramString1));
    this.cmQ.hL(1);
    this.cmQ.setContent(paramString2);
    this.cmQ.setType(t.oF(paramString1));
    aw.aaz();
    long l = c.YC().Z(this.cmQ);
    if (l != -1L) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      ab.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
      AppMethodBeat.o(16438);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16439);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.cmQ.field_msgId);
    this.handler.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(16439);
    return 999;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16440);
    ab.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.cmQ.field_msgId);
    this.cmQ.setStatus(2);
    this.cmQ.fQ(bf.x(this.cmQ.field_talker, System.currentTimeMillis() / 1000L));
    aw.aaz();
    c.YC().a(this.cmQ.field_msgId, this.cmQ);
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(16440);
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ap.a
 * JD-Core Version:    0.7.0.1
 */