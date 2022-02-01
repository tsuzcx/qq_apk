package com.tencent.mm.ar;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class a
  extends n
  implements k
{
  private f callback;
  private bv dlw;
  private aq handler;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20484);
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(20483);
        a.this.onGYNetEnd(999, 0, 0, "", null, null);
        AppMethodBeat.o(20483);
      }
    };
    this.dlw = new bv();
    this.dlw.setStatus(1);
    this.dlw.ui(paramString1);
    this.dlw.qN(bl.BQ(paramString1));
    this.dlw.kt(1);
    this.dlw.setContent(paramString2);
    this.dlw.setType(x.Bb(paramString1));
    bc.aCg();
    long l = c.azI().ar(this.dlw);
    if (l != -1L) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      ae.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
      AppMethodBeat.o(20484);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20485);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.dlw.field_msgId);
    this.handler.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(20485);
    return 999;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20486);
    ae.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.dlw.field_msgId);
    this.dlw.setStatus(2);
    this.dlw.qN(bl.B(this.dlw.field_talker, System.currentTimeMillis() / 1000L));
    bc.aCg();
    c.azI().a(this.dlw.field_msgId, this.dlw);
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(20486);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ar.a
 * JD-Core Version:    0.7.0.1
 */