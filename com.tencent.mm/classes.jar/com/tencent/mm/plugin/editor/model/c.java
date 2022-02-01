package com.tencent.mm.plugin.editor.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m.a;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.plugin.editor.model.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class c
{
  private static c qPs = null;
  public long duration;
  public com.tencent.mm.compatible.util.b jvG;
  public String path;
  public final MMHandler qPb;
  public boolean qPk;
  public long qPl;
  public boolean qPm;
  public long qPn;
  private Toast qPo;
  public j qPp;
  public com.tencent.mm.modelvoice.m qPq;
  public String qPr;
  public TextView qPt;
  public int qPu;
  public a qPv;
  public com.tencent.mm.plugin.editor.model.a.m qPw;
  private final MMHandler qPx;
  public final MTimerHandler qPy;
  
  private c()
  {
    AppMethodBeat.i(181679);
    this.qPn = -1L;
    this.qPr = "";
    this.path = "";
    this.qPu = 0;
    this.qPw = null;
    this.qPx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181676);
        super.handleMessage(paramAnonymousMessage);
        c.b(c.this);
        AppMethodBeat.o(181676);
      }
    };
    this.qPb = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181677);
        if (c.c(c.this).qPY.booleanValue())
        {
          c.d(c.this).cDi();
          c.c(c.this).qPY = Boolean.FALSE;
        }
        c.c(c.this).qPQ = ((int)com.tencent.mm.plugin.editor.b.AO(c.e(c.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(181677);
      }
    };
    this.qPy = new MTimerHandler(new MTimerHandler.CallBack()
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
            break label179;
          }
          c.a(c.this, Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131759165, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
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
            c.d(c.this).cDh();
          }
          AppMethodBeat.o(181678);
          return false;
          label179:
          c.g(c.this).setText(MMApplicationContext.getContext().getString(2131759165, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(181678);
        return true;
      }
    }, true);
    this.jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    AppMethodBeat.o(181679);
  }
  
  public static c cCZ()
  {
    AppMethodBeat.i(181680);
    if (qPs == null) {
      qPs = new c();
    }
    c localc = qPs;
    AppMethodBeat.o(181680);
    return localc;
  }
  
  private void cDc()
  {
    AppMethodBeat.i(181684);
    if (!this.qPk)
    {
      AppMethodBeat.o(181684);
      return;
    }
    this.qPb.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.qPy.stopTimer();
      if (i != 0)
      {
        cDe();
        cDd();
      }
      this.qPk = false;
      AppMethodBeat.o(181684);
      return;
    }
  }
  
  private void cDd()
  {
    AppMethodBeat.i(181685);
    this.qPx.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(181685);
  }
  
  private void cDe()
  {
    AppMethodBeat.i(181687);
    o localo = new o(this.path);
    if (localo.exists()) {
      localo.delete();
    }
    AppMethodBeat.o(181687);
  }
  
  public static c cDf()
  {
    return qPs;
  }
  
  public static void destroy()
  {
    qPs = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(181686);
    if (this.qPl == 0L)
    {
      AppMethodBeat.o(181686);
      return 0L;
    }
    long l = Util.ticksToNow(this.qPl);
    AppMethodBeat.o(181686);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(181683);
    if (this.qPr.equals("speex")) {
      this.qPq.ZZ();
    }
    for (;;)
    {
      if (this.jvG != null) {
        this.jvG.apm();
      }
      AppMethodBeat.o(181683);
      return;
      this.qPp.ZZ();
    }
  }
  
  public final void cDa()
  {
    AppMethodBeat.i(181681);
    if (!this.qPk)
    {
      AppMethodBeat.o(181681);
      return;
    }
    if (!this.qPm) {
      cDc();
    }
    AppMethodBeat.o(181681);
  }
  
  public final String cDb()
  {
    AppMethodBeat.i(181682);
    if (s.YS(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(181682);
      return str;
    }
    AppMethodBeat.o(181682);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.c
 * JD-Core Version:    0.7.0.1
 */