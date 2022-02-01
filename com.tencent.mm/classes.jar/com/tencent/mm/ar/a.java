package com.tencent.mm.ar;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.cc;
import junit.framework.Assert;

public final class a
  extends p
  implements m
{
  private h callback;
  private MMHandler handler;
  private cc hzO;
  
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
    this.hzO = new cc();
    this.hzO.setStatus(1);
    this.hzO.BS(paramString1);
    this.hzO.setCreateTime(br.JN(paramString1));
    this.hzO.pI(1);
    this.hzO.setContent(paramString2);
    this.hzO.setType(ab.IX(paramString1));
    bh.bCz();
    long l = c.bzD().ba(this.hzO);
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20485);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.hzO.field_msgId);
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
    Log.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.hzO.field_msgId);
    this.hzO.setStatus(2);
    this.hzO.setCreateTime(br.D(this.hzO.field_talker, System.currentTimeMillis() / 1000L));
    bh.bCz();
    c.bzD().a(this.hzO.field_msgId, this.hzO);
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(20486);
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ar.a
 * JD-Core Version:    0.7.0.1
 */