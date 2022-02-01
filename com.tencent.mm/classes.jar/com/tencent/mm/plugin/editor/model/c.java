package com.tencent.mm.plugin.editor.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.plugin.editor.model.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

public final class c
{
  private static c pAb = null;
  public long duration;
  public com.tencent.mm.compatible.util.b iAr;
  public String pAa;
  public TextView pAc;
  public int pAd;
  public a pAe;
  public com.tencent.mm.plugin.editor.model.a.m pAf;
  private final aq pAg;
  public final aw pAh;
  public String path;
  public final aq pzK;
  public boolean pzT;
  public long pzU;
  public boolean pzV;
  public long pzW;
  private Toast pzX;
  public j pzY;
  public com.tencent.mm.modelvoice.m pzZ;
  
  private c()
  {
    AppMethodBeat.i(181679);
    this.pzW = -1L;
    this.pAa = "";
    this.path = "";
    this.pAd = 0;
    this.pAf = null;
    this.pAg = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181676);
        super.handleMessage(paramAnonymousMessage);
        c.b(c.this);
        AppMethodBeat.o(181676);
      }
    };
    this.pzK = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181677);
        if (c.c(c.this).pAH.booleanValue())
        {
          c.d(c.this).cfs();
          c.c(c.this).pAH = Boolean.FALSE;
        }
        c.c(c.this).pAz = ((int)com.tencent.mm.plugin.editor.b.sI(c.e(c.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(181677);
      }
    };
    this.pAh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(181678);
        if (c.f(c.this) == -1L) {
          c.a(c.this, bu.HQ());
        }
        long l = bu.aO(c.f(c.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (c.g(c.this) != null) {
            break label179;
          }
          c.a(c.this, Toast.makeText(ak.getContext(), ak.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          c.g(c.this).show();
          if (l < 3600000L) {
            break;
          }
          ae.v("MicroMsg.EditorVoiceLogic", "record stop on countdown");
          c.h(c.this);
          c.i(c.this);
          if (c.d(c.this) != null) {
            c.d(c.this).cfr();
          }
          AppMethodBeat.o(181678);
          return false;
          label179:
          c.g(c.this).setText(ak.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(181678);
        return true;
      }
    }, true);
    this.iAr = new com.tencent.mm.compatible.util.b(ak.getContext());
    AppMethodBeat.o(181679);
  }
  
  public static c cfj()
  {
    AppMethodBeat.i(181680);
    if (pAb == null) {
      pAb = new c();
    }
    c localc = pAb;
    AppMethodBeat.o(181680);
    return localc;
  }
  
  private void cfm()
  {
    AppMethodBeat.i(181684);
    if (!this.pzT)
    {
      AppMethodBeat.o(181684);
      return;
    }
    this.pzK.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.pAh.stopTimer();
      if (i != 0)
      {
        cfo();
        cfn();
      }
      this.pzT = false;
      AppMethodBeat.o(181684);
      return;
    }
  }
  
  private void cfn()
  {
    AppMethodBeat.i(181685);
    this.pAg.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(181685);
  }
  
  private void cfo()
  {
    AppMethodBeat.i(181687);
    k localk = new k(this.path);
    if (localk.exists()) {
      localk.delete();
    }
    AppMethodBeat.o(181687);
  }
  
  public static c cfp()
  {
    return pAb;
  }
  
  public static void destroy()
  {
    pAb = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(181686);
    if (this.pzU == 0L)
    {
      AppMethodBeat.o(181686);
      return 0L;
    }
    long l = bu.aO(this.pzU);
    AppMethodBeat.o(181686);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(181683);
    if (this.pAa.equals("speex")) {
      this.pzZ.PF();
    }
    for (;;)
    {
      if (this.iAr != null) {
        this.iAr.abn();
      }
      AppMethodBeat.o(181683);
      return;
      this.pzY.PF();
    }
  }
  
  public final void cfk()
  {
    AppMethodBeat.i(181681);
    if (!this.pzT)
    {
      AppMethodBeat.o(181681);
      return;
    }
    if (!this.pzV) {
      cfm();
    }
    AppMethodBeat.o(181681);
  }
  
  public final String cfl()
  {
    AppMethodBeat.i(181682);
    if (o.fB(this.path))
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