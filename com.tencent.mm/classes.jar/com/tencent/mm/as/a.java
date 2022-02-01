package com.tencent.mm.as;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bu;
import junit.framework.Assert;

public final class a
  extends n
  implements k
{
  private f callback;
  private bu dku;
  private ap handler;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20484);
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(20483);
        a.this.onGYNetEnd(999, 0, 0, "", null, null);
        AppMethodBeat.o(20483);
      }
    };
    this.dku = new bu();
    this.dku.setStatus(1);
    this.dku.tN(paramString1);
    this.dku.qA(bj.Bo(paramString1));
    this.dku.kr(1);
    this.dku.setContent(paramString2);
    this.dku.setType(w.Ar(paramString1));
    ba.aBQ();
    long l = c.azs().as(this.dku);
    if (l != -1L) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      ad.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
      AppMethodBeat.o(20484);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20485);
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.dku.field_msgId);
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
    ad.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.dku.field_msgId);
    this.dku.setStatus(2);
    this.dku.qA(bj.B(this.dku.field_talker, System.currentTimeMillis() / 1000L));
    ba.aBQ();
    c.azs().a(this.dku.field_msgId, this.dku);
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(20486);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.a
 * JD-Core Version:    0.7.0.1
 */