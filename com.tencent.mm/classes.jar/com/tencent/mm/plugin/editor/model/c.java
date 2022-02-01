package com.tencent.mm.plugin.editor.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.m.a;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class c
{
  private static c ury = null;
  public long duration;
  public com.tencent.mm.compatible.util.b mlj;
  public String path;
  public int urA;
  public a urB;
  public com.tencent.mm.plugin.editor.model.a.m urC;
  private final MMHandler urD;
  public final MTimerHandler urE;
  public final MMHandler urf;
  public boolean urq;
  public long urr;
  public boolean urs;
  public long urt;
  private Toast uru;
  public j urv;
  public com.tencent.mm.modelvoice.m urw;
  public String urx;
  public TextView urz;
  
  private c()
  {
    AppMethodBeat.i(181679);
    this.urt = -1L;
    this.urx = "";
    this.path = "";
    this.urA = 0;
    this.urC = null;
    this.urD = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181676);
        super.handleMessage(paramAnonymousMessage);
        c.b(c.this);
        AppMethodBeat.o(181676);
      }
    };
    this.urf = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181677);
        if (c.c(c.this).use.booleanValue())
        {
          c.d(c.this).cRN();
          c.c(c.this).use = Boolean.FALSE;
        }
        c.c(c.this).urW = ((int)com.tencent.mm.plugin.editor.b.GW(c.e(c.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(181677);
      }
    };
    this.urE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(181678);
        if (c.f(c.this) == -1L) {
          c.a(c.this, Util.currentTicks());
        }
        long l = Util.ticksToNow(c.f(c.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (c.g(c.this) != null) {
            break label180;
          }
          c.a(c.this, Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.h.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          c.g(c.this).show();
          if (l < 3600000L) {
            break;
          }
          Log.v("MicroMsg.EditorVoiceLogic", "record stop on countdown");
          c.h(c.this);
          c.i(c.this);
          if (c.d(c.this) != null) {
            c.d(c.this).cRM();
          }
          AppMethodBeat.o(181678);
          return false;
          label180:
          c.g(c.this).setText(MMApplicationContext.getContext().getString(d.h.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(181678);
        return true;
      }
    }, true);
    this.mlj = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    AppMethodBeat.o(181679);
  }
  
  public static c cRE()
  {
    AppMethodBeat.i(181680);
    if (ury == null) {
      ury = new c();
    }
    c localc = ury;
    AppMethodBeat.o(181680);
    return localc;
  }
  
  private void cRH()
  {
    AppMethodBeat.i(181684);
    if (!this.urq)
    {
      AppMethodBeat.o(181684);
      return;
    }
    this.urf.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.urE.stopTimer();
      if (i != 0)
      {
        cRJ();
        cRI();
      }
      this.urq = false;
      AppMethodBeat.o(181684);
      return;
    }
  }
  
  private void cRI()
  {
    AppMethodBeat.i(181685);
    this.urD.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(181685);
  }
  
  private void cRJ()
  {
    AppMethodBeat.i(181687);
    q localq = new q(this.path);
    if (localq.ifE()) {
      localq.cFq();
    }
    AppMethodBeat.o(181687);
  }
  
  public static c cRK()
  {
    return ury;
  }
  
  public static void destroy()
  {
    ury = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(181686);
    if (this.urr == 0L)
    {
      AppMethodBeat.o(181686);
      return 0L;
    }
    long l = Util.ticksToNow(this.urr);
    AppMethodBeat.o(181686);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(181683);
    if (this.urx.equals("speex")) {
      this.urw.aeJ();
    }
    for (;;)
    {
      if (this.mlj != null) {
        this.mlj.avz();
      }
      AppMethodBeat.o(181683);
      return;
      this.urv.aeJ();
    }
  }
  
  public final void cRF()
  {
    AppMethodBeat.i(181681);
    if (!this.urq)
    {
      AppMethodBeat.o(181681);
      return;
    }
    if (!this.urs) {
      cRH();
    }
    AppMethodBeat.o(181681);
  }
  
  public final String cRG()
  {
    AppMethodBeat.i(181682);
    if (u.agG(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(181682);
      return str;
    }
    AppMethodBeat.o(181682);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.c
 * JD-Core Version:    0.7.0.1
 */