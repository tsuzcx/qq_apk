package com.tencent.mm.plugin.editor.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k.a;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
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
  private static c omn = null;
  public long duration;
  public com.tencent.mm.compatible.util.b hDB;
  public final ap olW;
  public boolean omf;
  public long omg;
  public boolean omh;
  public long omi;
  private Toast omj;
  public j omk;
  public com.tencent.mm.modelvoice.m oml;
  public String omm;
  public TextView omo;
  public int omp;
  public a omq;
  public com.tencent.mm.plugin.editor.model.a.m omr;
  private final ap oms;
  public final av omt;
  public String path;
  
  private c()
  {
    AppMethodBeat.i(181679);
    this.omi = -1L;
    this.omm = "";
    this.path = "";
    this.omp = 0;
    this.omr = null;
    this.oms = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181676);
        super.handleMessage(paramAnonymousMessage);
        c.b(c.this);
        AppMethodBeat.o(181676);
      }
    };
    this.olW = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181677);
        if (c.c(c.this).omT.booleanValue())
        {
          c.d(c.this).bSk();
          c.c(c.this).omT = Boolean.FALSE;
        }
        c.c(c.this).omL = ((int)com.tencent.mm.plugin.editor.b.mI(c.e(c.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(181677);
      }
    };
    this.omt = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(181678);
        if (c.f(c.this) == -1L) {
          c.a(c.this, bt.GC());
        }
        long l = bt.aS(c.f(c.this));
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
            c.d(c.this).bSj();
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
    this.hDB = new com.tencent.mm.compatible.util.b(aj.getContext());
    AppMethodBeat.o(181679);
  }
  
  public static c bSb()
  {
    AppMethodBeat.i(181680);
    if (omn == null) {
      omn = new c();
    }
    c localc = omn;
    AppMethodBeat.o(181680);
    return localc;
  }
  
  private void bSe()
  {
    AppMethodBeat.i(181684);
    if (!this.omf)
    {
      AppMethodBeat.o(181684);
      return;
    }
    this.olW.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.omt.stopTimer();
      if (i != 0)
      {
        bSg();
        bSf();
      }
      this.omf = false;
      AppMethodBeat.o(181684);
      return;
    }
  }
  
  private void bSf()
  {
    AppMethodBeat.i(181685);
    this.oms.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(181685);
  }
  
  private void bSg()
  {
    AppMethodBeat.i(181687);
    e locale = new e(this.path);
    if (locale.exists()) {
      locale.delete();
    }
    AppMethodBeat.o(181687);
  }
  
  public static c bSh()
  {
    return omn;
  }
  
  public static void destroy()
  {
    omn = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(181686);
    if (this.omg == 0L)
    {
      AppMethodBeat.o(181686);
      return 0L;
    }
    long l = bt.aS(this.omg);
    AppMethodBeat.o(181686);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(181683);
    if (this.omm.equals("speex")) {
      this.oml.Ob();
    }
    for (;;)
    {
      if (this.hDB != null) {
        this.hDB.XF();
      }
      AppMethodBeat.o(181683);
      return;
      this.omk.Ob();
    }
  }
  
  public final void bSc()
  {
    AppMethodBeat.i(181681);
    if (!this.omf)
    {
      AppMethodBeat.o(181681);
      return;
    }
    if (!this.omh) {
      bSe();
    }
    AppMethodBeat.o(181681);
  }
  
  public final String bSd()
  {
    AppMethodBeat.i(181682);
    if (i.eK(this.path))
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