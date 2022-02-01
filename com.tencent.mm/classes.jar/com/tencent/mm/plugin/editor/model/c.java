package com.tencent.mm.plugin.editor.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.plugin.editor.model.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class c
{
  private static c oPN = null;
  public long duration;
  public com.tencent.mm.compatible.util.b ied;
  public boolean oPF;
  public long oPG;
  public boolean oPH;
  public long oPI;
  private Toast oPJ;
  public j oPK;
  public com.tencent.mm.modelvoice.m oPL;
  public String oPM;
  public TextView oPO;
  public int oPP;
  public a oPQ;
  public com.tencent.mm.plugin.editor.model.a.m oPR;
  private final ao oPS;
  public final au oPT;
  public final ao oPw;
  public String path;
  
  private c()
  {
    AppMethodBeat.i(181679);
    this.oPI = -1L;
    this.oPM = "";
    this.path = "";
    this.oPP = 0;
    this.oPR = null;
    this.oPS = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181676);
        super.handleMessage(paramAnonymousMessage);
        c.b(c.this);
        AppMethodBeat.o(181676);
      }
    };
    this.oPw = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181677);
        if (c.c(c.this).oQt.booleanValue())
        {
          c.d(c.this).bZz();
          c.c(c.this).oQt = Boolean.FALSE;
        }
        c.c(c.this).oQl = ((int)com.tencent.mm.plugin.editor.b.qw(c.e(c.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(181677);
      }
    };
    this.oPT = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(181678);
        if (c.f(c.this) == -1L) {
          c.a(c.this, bs.Gn());
        }
        long l = bs.aO(c.f(c.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (c.g(c.this) != null) {
            break label179;
          }
          c.a(c.this, Toast.makeText(ai.getContext(), ai.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          c.g(c.this).show();
          if (l < 3600000L) {
            break;
          }
          ac.v("MicroMsg.EditorVoiceLogic", "record stop on countdown");
          c.h(c.this);
          c.i(c.this);
          if (c.d(c.this) != null) {
            c.d(c.this).bZy();
          }
          AppMethodBeat.o(181678);
          return false;
          label179:
          c.g(c.this).setText(ai.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(181678);
        return true;
      }
    }, true);
    this.ied = new com.tencent.mm.compatible.util.b(ai.getContext());
    AppMethodBeat.o(181679);
  }
  
  public static c bZq()
  {
    AppMethodBeat.i(181680);
    if (oPN == null) {
      oPN = new c();
    }
    c localc = oPN;
    AppMethodBeat.o(181680);
    return localc;
  }
  
  private void bZt()
  {
    AppMethodBeat.i(181684);
    if (!this.oPF)
    {
      AppMethodBeat.o(181684);
      return;
    }
    this.oPw.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.oPT.stopTimer();
      if (i != 0)
      {
        bZv();
        bZu();
      }
      this.oPF = false;
      AppMethodBeat.o(181684);
      return;
    }
  }
  
  private void bZu()
  {
    AppMethodBeat.i(181685);
    this.oPS.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(181685);
  }
  
  private void bZv()
  {
    AppMethodBeat.i(181687);
    e locale = new e(this.path);
    if (locale.exists()) {
      locale.delete();
    }
    AppMethodBeat.o(181687);
  }
  
  public static c bZw()
  {
    return oPN;
  }
  
  public static void destroy()
  {
    oPN = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(181686);
    if (this.oPG == 0L)
    {
      AppMethodBeat.o(181686);
      return 0L;
    }
    long l = bs.aO(this.oPG);
    AppMethodBeat.o(181686);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(181683);
    if (this.oPM.equals("speex")) {
      this.oPL.NX();
    }
    for (;;)
    {
      if (this.ied != null) {
        this.ied.YC();
      }
      AppMethodBeat.o(181683);
      return;
      this.oPK.NX();
    }
  }
  
  public final void bZr()
  {
    AppMethodBeat.i(181681);
    if (!this.oPF)
    {
      AppMethodBeat.o(181681);
      return;
    }
    if (!this.oPH) {
      bZt();
    }
    AppMethodBeat.o(181681);
  }
  
  public final String bZs()
  {
    AppMethodBeat.i(181682);
    if (i.eA(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(181682);
      return str;
    }
    AppMethodBeat.o(181682);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.c
 * JD-Core Version:    0.7.0.1
 */