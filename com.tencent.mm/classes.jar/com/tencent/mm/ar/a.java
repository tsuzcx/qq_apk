package com.tencent.mm.ar;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.bo;
import junit.framework.Assert;

public final class a
  extends n
  implements k
{
  private bo cZc;
  private g callback;
  private ao handler;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20484);
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(20483);
        a.this.onGYNetEnd(999, 0, 0, "", null, null);
        AppMethodBeat.o(20483);
      }
    };
    this.cZc = new bo();
    this.cZc.setStatus(1);
    this.cZc.re(paramString1);
    this.cZc.oA(bi.yp(paramString1));
    this.cZc.jT(1);
    this.cZc.setContent(paramString2);
    this.cZc.setType(w.xt(paramString1));
    az.ayM();
    long l = c.awD().ap(this.cZc);
    if (l != -1L) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      ac.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
      AppMethodBeat.o(20484);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20485);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.cZc.field_msgId);
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
    ac.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.cZc.field_msgId);
    this.cZc.setStatus(2);
    this.cZc.oA(bi.z(this.cZc.field_talker, System.currentTimeMillis() / 1000L));
    az.ayM();
    c.awD().a(this.cZc.field_msgId, this.cZc);
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(20486);
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ar.a
 * JD-Core Version:    0.7.0.1
 */