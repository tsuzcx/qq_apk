package com.tencent.mm.au;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
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
  private com.tencent.mm.an.i callback;
  private ca fvt;
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
    this.fvt = new ca();
    this.fvt.setStatus(1);
    this.fvt.Jm(paramString1);
    this.fvt.setCreateTime(bq.RP(paramString1));
    this.fvt.pJ(1);
    this.fvt.setContent(paramString2);
    this.fvt.setType(ab.QZ(paramString1));
    bh.beI();
    long l = c.bbO().aM(this.fvt);
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
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(20485);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.fvt.field_msgId);
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
    Log.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.fvt.field_msgId);
    this.fvt.setStatus(2);
    this.fvt.setCreateTime(bq.z(this.fvt.field_talker, System.currentTimeMillis() / 1000L));
    bh.beI();
    c.bbO().a(this.fvt.field_msgId, this.fvt);
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(20486);
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.au.a
 * JD-Core Version:    0.7.0.1
 */