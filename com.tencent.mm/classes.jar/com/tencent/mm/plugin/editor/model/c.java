package com.tencent.mm.plugin.editor.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.l.a;
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
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class c
{
  private static c xxT = null;
  public long duration;
  public String path;
  public com.tencent.mm.compatible.util.b peV;
  public final MMHandler xxC;
  public boolean xxL;
  public long xxM;
  public boolean xxN;
  public long xxO;
  private Toast xxP;
  public j xxQ;
  public com.tencent.mm.modelvoice.m xxR;
  public String xxS;
  public TextView xxU;
  public int xxV;
  public a xxW;
  public com.tencent.mm.plugin.editor.model.a.m xxX;
  private final MMHandler xxY;
  public final MTimerHandler xxZ;
  
  private c()
  {
    AppMethodBeat.i(181679);
    this.xxO = -1L;
    this.xxS = "";
    this.path = "";
    this.xxV = 0;
    this.xxX = null;
    this.xxY = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181676);
        super.handleMessage(paramAnonymousMessage);
        c.b(c.this);
        AppMethodBeat.o(181676);
      }
    };
    this.xxC = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181677);
        if (c.c(c.this).xyA.booleanValue())
        {
          c.d(c.this).dwg();
          c.c(c.this).xyA = Boolean.FALSE;
        }
        c.c(c.this).xyr = ((int)com.tencent.mm.plugin.editor.b.jh(c.e(c.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(181677);
      }
    };
    this.xxZ = new MTimerHandler(new MTimerHandler.CallBack()
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
            c.d(c.this).dwf();
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
    this.peV = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    AppMethodBeat.o(181679);
  }
  
  public static void destroy()
  {
    xxT = null;
  }
  
  public static c dvX()
  {
    AppMethodBeat.i(181680);
    if (xxT == null) {
      xxT = new c();
    }
    c localc = xxT;
    AppMethodBeat.o(181680);
    return localc;
  }
  
  private void dwa()
  {
    AppMethodBeat.i(181684);
    if (!this.xxL)
    {
      AppMethodBeat.o(181684);
      return;
    }
    this.xxC.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.xxZ.stopTimer();
      if (i != 0)
      {
        dwc();
        dwb();
      }
      this.xxL = false;
      AppMethodBeat.o(181684);
      return;
    }
  }
  
  private void dwb()
  {
    AppMethodBeat.i(181685);
    this.xxY.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(181685);
  }
  
  private void dwc()
  {
    AppMethodBeat.i(181687);
    u localu = new u(this.path);
    if (localu.jKS()) {
      localu.diJ();
    }
    AppMethodBeat.o(181687);
  }
  
  public static c dwd()
  {
    return xxT;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(181686);
    if (this.xxM == 0L)
    {
      AppMethodBeat.o(181686);
      return 0L;
    }
    long l = Util.ticksToNow(this.xxM);
    AppMethodBeat.o(181686);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(181683);
    if (this.xxS.equals("speex")) {
      this.xxR.aGH();
    }
    for (;;)
    {
      if (this.peV != null) {
        this.peV.aPS();
      }
      AppMethodBeat.o(181683);
      return;
      this.xxQ.aGH();
    }
  }
  
  public final void dvY()
  {
    AppMethodBeat.i(181681);
    if (!this.xxL)
    {
      AppMethodBeat.o(181681);
      return;
    }
    if (!this.xxN) {
      dwa();
    }
    AppMethodBeat.o(181681);
  }
  
  public final String dvZ()
  {
    AppMethodBeat.i(181682);
    if (y.ZC(this.path))
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