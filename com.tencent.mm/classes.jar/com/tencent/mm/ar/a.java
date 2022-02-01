package com.tencent.mm.ar;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ca;
import junit.framework.Assert;

public final class a
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private ca dCM;
  private MMHandler handler;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20484);
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(20483);
        a.this.onGYNetEnd(999, 0, 0, "", null, null);
        AppMethodBeat.o(20483);
      }
    };
    this.dCM = new ca();
    this.dCM.setStatus(1);
    this.dCM.Cy(paramString1);
    this.dCM.setCreateTime(bp.Kw(paramString1));
    this.dCM.nv(1);
    this.dCM.setContent(paramString2);
    this.dCM.setType(ab.JG(paramString1));
    bg.aVF();
    long l = c.aSQ().aC(this.dCM);
    if (l != -1L) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
      AppMethodBeat.o(20484);
      return;
      bool = false;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(20485);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.dCM.field_msgId);
    this.handler.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(20485);
    return 999;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20486);
    Log.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.dCM.field_msgId);
    this.dCM.setStatus(2);
    this.dCM.setCreateTime(bp.C(this.dCM.field_talker, System.currentTimeMillis() / 1000L));
    bg.aVF();
    c.aSQ().a(this.dCM.field_msgId, this.dCM);
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(20486);
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ar.a
 * JD-Core Version:    0.7.0.1
 */