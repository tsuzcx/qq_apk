package com.tencent.mm.plugin.editor.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.plugin.editor.model.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class c
{
  private static c ptx = null;
  public long duration;
  public com.tencent.mm.compatible.util.b ixy;
  public String path;
  public a ptA;
  public com.tencent.mm.plugin.editor.model.a.m ptB;
  private final ap ptC;
  public final av ptD;
  public final ap pte;
  public boolean ptn;
  public long pto;
  public boolean ptp;
  public long ptq;
  private Toast ptt;
  public j ptu;
  public com.tencent.mm.modelvoice.m ptv;
  public String ptw;
  public TextView pty;
  public int ptz;
  
  private c()
  {
    AppMethodBeat.i(181679);
    this.ptq = -1L;
    this.ptw = "";
    this.path = "";
    this.ptz = 0;
    this.ptB = null;
    this.ptC = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181676);
        super.handleMessage(paramAnonymousMessage);
        c.b(c.this);
        AppMethodBeat.o(181676);
      }
    };
    this.pte = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181677);
        if (c.c(c.this).pud.booleanValue())
        {
          c.d(c.this).ced();
          c.c(c.this).pud = Boolean.FALSE;
        }
        c.c(c.this).ptV = ((int)com.tencent.mm.plugin.editor.b.sv(c.e(c.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(181677);
      }
    };
    this.ptD = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(181678);
        if (c.f(c.this) == -1L) {
          c.a(c.this, bt.HI());
        }
        long l = bt.aO(c.f(c.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (c.g(c.this) != null) {
            break label179;
          }
          c.a(c.this, Toast.makeText(aj.getContext(), aj.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          c.g(c.this).show();
          if (l < 3600000L) {
            break;
          }
          ad.v("MicroMsg.EditorVoiceLogic", "record stop on countdown");
          c.h(c.this);
          c.i(c.this);
          if (c.d(c.this) != null) {
            c.d(c.this).cec();
          }
          AppMethodBeat.o(181678);
          return false;
          label179:
          c.g(c.this).setText(aj.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(181678);
        return true;
      }
    }, true);
    this.ixy = new com.tencent.mm.compatible.util.b(aj.getContext());
    AppMethodBeat.o(181679);
  }
  
  public static c cdU()
  {
    AppMethodBeat.i(181680);
    if (ptx == null) {
      ptx = new c();
    }
    c localc = ptx;
    AppMethodBeat.o(181680);
    return localc;
  }
  
  private void cdX()
  {
    AppMethodBeat.i(181684);
    if (!this.ptn)
    {
      AppMethodBeat.o(181684);
      return;
    }
    this.pte.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.ptD.stopTimer();
      if (i != 0)
      {
        cdZ();
        cdY();
      }
      this.ptn = false;
      AppMethodBeat.o(181684);
      return;
    }
  }
  
  private void cdY()
  {
    AppMethodBeat.i(181685);
    this.ptC.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(181685);
  }
  
  private void cdZ()
  {
    AppMethodBeat.i(181687);
    e locale = new e(this.path);
    if (locale.exists()) {
      locale.delete();
    }
    AppMethodBeat.o(181687);
  }
  
  public static c cea()
  {
    return ptx;
  }
  
  public static void destroy()
  {
    ptx = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(181686);
    if (this.pto == 0L)
    {
      AppMethodBeat.o(181686);
      return 0L;
    }
    long l = bt.aO(this.pto);
    AppMethodBeat.o(181686);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(181683);
    if (this.ptw.equals("speex")) {
      this.ptv.PG();
    }
    for (;;)
    {
      if (this.ixy != null) {
        this.ixy.abe();
      }
      AppMethodBeat.o(181683);
      return;
      this.ptu.PG();
    }
  }
  
  public final void cdV()
  {
    AppMethodBeat.i(181681);
    if (!this.ptn)
    {
      AppMethodBeat.o(181681);
      return;
    }
    if (!this.ptp) {
      cdX();
    }
    AppMethodBeat.o(181681);
  }
  
  public final String cdW()
  {
    AppMethodBeat.i(181682);
    if (i.fv(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(181682);
      return str;
    }
    AppMethodBeat.o(181682);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.c
 * JD-Core Version:    0.7.0.1
 */