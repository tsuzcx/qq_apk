package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.am.l.a;
import com.tencent.mm.am.l.b;
import com.tencent.mm.am.p;
import com.tencent.mm.audio.b.h;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.masssend.model.f;
import com.tencent.mm.plugin.transvoice.model.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  private String KNA;
  private boolean KNB;
  private final l.a KNC;
  private final l.b KND;
  private MassSendMsgUI KNx;
  private ChatFooter KNy;
  private a KNz;
  private List<String> lDu;
  private final MTimerHandler pgR;
  w tipDialog;
  private Vibrator uAL;
  private long xxO;
  private Toast xxP;
  private final MTimerHandler xxZ;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26394);
    this.xxO = -1L;
    this.tipDialog = null;
    this.pgR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26387);
        b.b(b.this).awE(b.a(b.this).aGI());
        AppMethodBeat.o(26387);
        return true;
      }
    }, true);
    this.KNC = new l.a()
    {
      public final void atR()
      {
        AppMethodBeat.i(26388);
        b.a(b.this).reset();
        b.c(b.this).stopTimer();
        b.d(b.this).stopTimer();
        MMEntryLock.unlock("keep_app_silent");
        b.b(b.this).a(ChatFooter.h.YjB);
        Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(b.e(b.this), b.e(b.this).getString(R.l.gzh), 0).show();
        AppMethodBeat.o(26388);
      }
    };
    this.KND = new l.b()
    {
      public final void bFK()
      {
        AppMethodBeat.i(26389);
        b.b(b.this).iMh();
        AppMethodBeat.o(26389);
      }
    };
    this.xxZ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26390);
        if (b.f(b.this) == -1L) {
          b.a(b.this, Util.currentTicks());
        }
        long l = Util.ticksToNow(b.f(b.this));
        int i;
        if ((l >= 50000L) && (l <= 60000L))
        {
          if (b.g(b.this) == null)
          {
            i = (int)((60000L - l) / 1000L);
            b.a(b.this, Toast.makeText(b.e(b.this), b.e(b.this).getResources().getQuantityString(R.j.gpm, i, new Object[] { Integer.valueOf(i) }), 0));
            b.g(b.this).show();
          }
        }
        else
        {
          if (l < 60000L) {
            break label283;
          }
          Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
          if (!b.b(b.this).iNb()) {
            break label247;
          }
          b.b(b.this).iMH();
        }
        for (;;)
        {
          PlaySound.play(b.e(b.this), R.l.time_limit);
          AppMethodBeat.o(26390);
          return false;
          i = (int)((60000L - l) / 1000L);
          b.g(b.this).setText(b.e(b.this).getResources().getQuantityString(R.j.gpm, i, new Object[] { Integer.valueOf(i) }));
          break;
          label247:
          if (b.a(b.this).stop()) {
            b.h(b.this);
          }
          b.b(b.this).a(ChatFooter.h.Yjw);
        }
        label283:
        AppMethodBeat.o(26390);
        return true;
      }
    }, true);
    this.KNx = paramMassSendMsgUI;
    this.KNy = paramChatFooter;
    this.KNA = paramString;
    this.lDu = paramList;
    this.KNB = paramBoolean;
    this.KNz = new a(paramMassSendMsgUI);
    this.KNz.a(this.KNC);
    this.KNz.a(this.KND);
    this.uAL = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(26394);
  }
  
  private void gaa()
  {
    AppMethodBeat.i(26397);
    Object localObject = new com.tencent.mm.plugin.masssend.model.a();
    ((com.tencent.mm.plugin.masssend.model.a)localObject).KNh = this.KNA;
    ((com.tencent.mm.plugin.masssend.model.a)localObject).KNi = this.lDu.size();
    ((com.tencent.mm.plugin.masssend.model.a)localObject).filename = this.KNz.fileName;
    ((com.tencent.mm.plugin.masssend.model.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.model.a)localObject).KNj = this.KNz.hxr;
    localObject = new f((com.tencent.mm.plugin.masssend.model.a)localObject, this.KNB);
    bh.aZW().a((p)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.KNx;
    this.KNx.getString(R.l.app_tip);
    this.tipDialog = k.a(localMassSendMsgUI, this.KNx.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26391);
        bh.aZW().a(this.KNF);
        if (b.i(b.this) != null)
        {
          b.i(b.this).dismiss();
          b.j(b.this);
        }
        AppMethodBeat.o(26391);
      }
    });
    AppMethodBeat.o(26397);
  }
  
  public final void aHY(String paramString) {}
  
  public final long aHd()
  {
    AppMethodBeat.i(26404);
    if (this.KNz != null)
    {
      long l = this.KNz.aHd();
      AppMethodBeat.o(26404);
      return l;
    }
    AppMethodBeat.o(26404);
    return 0L;
  }
  
  public final boolean aKU(final String paramString)
  {
    AppMethodBeat.i(26400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26400);
      return false;
    }
    MassSendMsgUI.aKY(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.model.a();
    ((com.tencent.mm.plugin.masssend.model.a)localObject).KNh = this.KNA;
    ((com.tencent.mm.plugin.masssend.model.a)localObject).KNi = this.lDu.size();
    ((com.tencent.mm.plugin.masssend.model.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.model.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.model.a)localObject, this.KNB);
    bh.aZW().a(paramString, 0);
    localObject = this.KNx;
    this.KNx.getString(R.l.app_tip);
    this.tipDialog = k.a((Context)localObject, this.KNx.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26392);
        bh.aZW().a(paramString);
        if (b.i(b.this) != null)
        {
          b.i(b.this).dismiss();
          b.j(b.this);
        }
        AppMethodBeat.o(26392);
      }
    });
    AppMethodBeat.o(26400);
    return true;
  }
  
  public final boolean aKV(String paramString)
  {
    AppMethodBeat.i(26402);
    boolean bool = com.tencent.mm.modelvoice.s.QN(paramString);
    AppMethodBeat.o(26402);
    return bool;
  }
  
  public final void ah(MotionEvent paramMotionEvent) {}
  
  public final boolean fN(String paramString, int paramInt)
  {
    AppMethodBeat.i(26401);
    gaa();
    AppMethodBeat.o(26401);
    return true;
  }
  
  public final boolean fZY()
  {
    AppMethodBeat.i(26395);
    this.pgR.stopTimer();
    this.xxZ.stopTimer();
    this.xxO = -1L;
    if (this.KNz.stop())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.model.c.TUa;
      com.tencent.mm.plugin.transvoice.model.c.hPD().setExitType(0);
      gaa();
      this.KNy.a(ChatFooter.h.Yjw);
    }
    for (;;)
    {
      bh.aDI().aKk();
      AppMethodBeat.o(26395);
      return false;
      this.KNy.dwb();
    }
  }
  
  public final boolean fZZ()
  {
    AppMethodBeat.i(26396);
    this.pgR.stopTimer();
    this.xxZ.stopTimer();
    this.xxO = -1L;
    this.KNz.stop();
    this.KNy.a(ChatFooter.h.Yjx);
    bh.aDI().aKk();
    AppMethodBeat.o(26396);
    return true;
  }
  
  public final boolean gab()
  {
    AppMethodBeat.i(26398);
    this.pgR.stopTimer();
    this.xxZ.stopTimer();
    this.xxO = -1L;
    this.KNy.a(ChatFooter.h.Yjz);
    this.KNz.dPx();
    bh.aDI().aKk();
    AppMethodBeat.o(26398);
    return false;
  }
  
  public final void gac()
  {
    AppMethodBeat.i(185750);
    this.KNy.a(ChatFooter.h.Yjz);
    this.KNz.dPx();
    AppMethodBeat.o(185750);
  }
  
  public final boolean gad()
  {
    AppMethodBeat.i(26399);
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.j(this.KNx, null);
      AppMethodBeat.o(26399);
      return false;
    }
    if (com.tencent.mm.n.a.c(this.KNx, null))
    {
      AppMethodBeat.o(26399);
      return false;
    }
    this.uAL.vibrate(50L);
    Object localObject = com.tencent.mm.plugin.transvoice.model.c.TUa;
    com.tencent.mm.plugin.transvoice.model.c.hPD().TUb = true;
    this.pgR.startTimer(100L);
    this.xxZ.startTimer(200L);
    localObject = this.KNx.getResources().getDisplayMetrics();
    this.KNy.awD(((DisplayMetrics)localObject).heightPixels - this.KNy.getHeight());
    this.KNz.start();
    this.KNz.a(this.KND);
    this.KNz.a(this.KNC);
    bh.aDI().aKl();
    AppMethodBeat.o(26399);
    return false;
  }
  
  public final void gae() {}
  
  public final void gaf() {}
  
  public final void gag() {}
  
  public final String getFileName()
  {
    if (this.KNz != null) {
      return this.KNz.fileName;
    }
    return "";
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(26403);
    this.pgR.stopTimer();
    this.xxZ.stopTimer();
    this.xxO = -1L;
    a.a locala = com.tencent.mm.cj.a.adtq;
    if (!a.a.bzC(this.KNz.fileName))
    {
      locala = com.tencent.mm.cj.a.adtq;
      if (!a.a.bzE(this.KNz.fileName)) {
        this.KNz.stop();
      }
    }
    bh.aDI().aKk();
    AppMethodBeat.o(26403);
  }
  
  public final void release() {}
  
  public final void yp(boolean paramBoolean) {}
  
  final class a
    extends h
  {
    String fileName;
    
    public a(Context paramContext)
    {
      super(false);
    }
    
    public final void dPx()
    {
      AppMethodBeat.i(185749);
      stop();
      com.tencent.mm.modelvoice.s.QN(this.fileName);
      AppMethodBeat.o(185749);
    }
    
    public final String getFileName()
    {
      return this.fileName;
    }
    
    public final boolean start()
    {
      AppMethodBeat.i(272760);
      boolean bool = super.aHb();
      AppMethodBeat.o(272760);
      return bool;
    }
    
    public final boolean stop()
    {
      AppMethodBeat.i(26393);
      this.fileName = super.getFileName();
      boolean bool = super.stop();
      super.reset();
      AppMethodBeat.o(26393);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b
 * JD-Core Version:    0.7.0.1
 */