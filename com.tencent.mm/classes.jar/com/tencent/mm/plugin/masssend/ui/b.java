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
import com.tencent.mm.ak.m.a;
import com.tencent.mm.ak.m.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  private List<String> gxh;
  final MTimerHandler jxC;
  private Vibrator paT;
  long qPn;
  Toast qPo;
  final MTimerHandler qPy;
  com.tencent.mm.ui.base.q tipDialog;
  MassSendMsgUI znC;
  ChatFooter znD;
  a znE;
  private String znF;
  private boolean znG;
  private final m.a znH;
  private final m.b znI;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26394);
    this.qPn = -1L;
    this.tipDialog = null;
    this.jxC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26387);
        b.this.znD.aiy(b.this.znE.getMaxAmplitude());
        AppMethodBeat.o(26387);
        return true;
      }
    }, true);
    this.znH = new m.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(26388);
        b.this.znE.reset();
        b.this.jxC.stopTimer();
        b.this.qPy.stopTimer();
        MMEntryLock.unlock("keep_app_silent");
        b.this.znD.a(ChatFooter.h.Kmy);
        Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(b.this.znC, b.this.znC.getString(2131757490), 0).show();
        AppMethodBeat.o(26388);
      }
    };
    this.znI = new m.b()
    {
      public final void aYN()
      {
        AppMethodBeat.i(26389);
        b.this.znD.gqr();
        AppMethodBeat.o(26389);
      }
    };
    this.qPy = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26390);
        if (b.this.qPn == -1L) {
          b.this.qPn = Util.currentTicks();
        }
        long l = Util.ticksToNow(b.this.qPn);
        int i;
        if ((l >= 50000L) && (l <= 60000L))
        {
          if (b.this.qPo == null)
          {
            i = (int)((60000L - l) / 1000L);
            b.this.qPo = Toast.makeText(b.this.znC, b.this.znC.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }), 0);
            b.this.qPo.show();
          }
        }
        else
        {
          if (l < 60000L) {
            break label278;
          }
          Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
          if (!b.this.znD.grl()) {
            break label242;
          }
          b.this.znD.gqR();
        }
        for (;;)
        {
          PlaySound.play(b.this.znC, 2131766767);
          AppMethodBeat.o(26390);
          return false;
          i = (int)((60000L - l) / 1000L);
          b.this.qPo.setText(b.this.znC.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }));
          break;
          label242:
          if (b.this.znE.Qt()) {
            b.this.ehK();
          }
          b.this.znD.a(ChatFooter.h.Kmt);
        }
        label278:
        AppMethodBeat.o(26390);
        return true;
      }
    }, true);
    this.znC = paramMassSendMsgUI;
    this.znD = paramChatFooter;
    this.znF = paramString;
    this.gxh = paramList;
    this.znG = paramBoolean;
    this.znE = new a(paramMassSendMsgUI);
    this.znE.a(this.znH);
    this.znE.a(this.znI);
    this.paT = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(26394);
  }
  
  public final void X(MotionEvent paramMotionEvent) {}
  
  public final void aBt(String paramString) {}
  
  public final boolean aDN(final String paramString)
  {
    AppMethodBeat.i(26400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26400);
      return false;
    }
    MassSendMsgUI.aDR(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).znm = this.znF;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).znn = this.gxh.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.znG);
    bg.azz().a(paramString, 0);
    localObject = this.znC;
    this.znC.getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, this.znC.getString(2131765237), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26392);
        bg.azz().a(paramString);
        if (b.this.tipDialog != null)
        {
          b.this.tipDialog.dismiss();
          b.this.tipDialog = null;
        }
        AppMethodBeat.o(26392);
      }
    });
    AppMethodBeat.o(26400);
    return true;
  }
  
  public final boolean aDO(String paramString)
  {
    AppMethodBeat.i(26402);
    boolean bool = s.Rl(paramString);
    AppMethodBeat.o(26402);
    return bool;
  }
  
  public final long aas()
  {
    AppMethodBeat.i(26404);
    if (this.znE != null)
    {
      long l = this.znE.aas();
      AppMethodBeat.o(26404);
      return l;
    }
    AppMethodBeat.o(26404);
    return 0L;
  }
  
  public final boolean ehI()
  {
    AppMethodBeat.i(26395);
    this.jxC.stopTimer();
    this.qPy.stopTimer();
    this.qPn = -1L;
    if (this.znE.Qt())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.a.c.Guc;
      com.tencent.mm.plugin.transvoice.a.c.fAu().setExitType(0);
      ehK();
      this.znD.a(ChatFooter.h.Kmt);
    }
    for (;;)
    {
      bg.Xi().akq();
      AppMethodBeat.o(26395);
      return false;
      this.znD.cDd();
    }
  }
  
  public final boolean ehJ()
  {
    AppMethodBeat.i(26396);
    this.jxC.stopTimer();
    this.qPy.stopTimer();
    this.qPn = -1L;
    this.znE.Qt();
    this.znD.a(ChatFooter.h.Kmu);
    bg.Xi().akq();
    AppMethodBeat.o(26396);
    return true;
  }
  
  final void ehK()
  {
    AppMethodBeat.i(26397);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).znm = this.znF;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).znn = this.gxh.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = this.znE.fileName;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).zno = this.znE.dAn;
    localObject = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.znG);
    bg.azz().a((com.tencent.mm.ak.q)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.znC;
    this.znC.getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a(localMassSendMsgUI, this.znC.getString(2131765237), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26391);
        bg.azz().a(this.znK);
        if (b.this.tipDialog != null)
        {
          b.this.tipDialog.dismiss();
          b.this.tipDialog = null;
        }
        AppMethodBeat.o(26391);
      }
    });
    AppMethodBeat.o(26397);
  }
  
  public final boolean ehL()
  {
    AppMethodBeat.i(26398);
    this.jxC.stopTimer();
    this.qPy.stopTimer();
    this.qPn = -1L;
    this.znD.a(ChatFooter.h.Kmw);
    this.znE.cTH();
    bg.Xi().akq();
    AppMethodBeat.o(26398);
    return false;
  }
  
  public final void ehM()
  {
    AppMethodBeat.i(185750);
    this.znD.a(ChatFooter.h.Kmw);
    this.znE.cTH();
    AppMethodBeat.o(185750);
  }
  
  public final boolean ehN()
  {
    AppMethodBeat.i(26399);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      u.g(this.znC, null);
      AppMethodBeat.o(26399);
      return false;
    }
    if (com.tencent.mm.q.a.cB(this.znC))
    {
      AppMethodBeat.o(26399);
      return false;
    }
    this.paT.vibrate(50L);
    Object localObject = com.tencent.mm.plugin.transvoice.a.c.Guc;
    com.tencent.mm.plugin.transvoice.a.c.fAu().GtJ = true;
    this.jxC.startTimer(100L);
    this.qPy.startTimer(200L);
    localObject = this.znC.getResources().getDisplayMetrics();
    this.znD.aix(((DisplayMetrics)localObject).heightPixels - this.znD.getHeight());
    this.znE.hx("_USER_FOR_THROWBOTTLE_");
    this.znE.a(this.znI);
    this.znE.a(this.znH);
    bg.Xi().akr();
    AppMethodBeat.o(26399);
    return false;
  }
  
  public final void ehO() {}
  
  public final void ehP() {}
  
  public final void ehQ() {}
  
  public final boolean eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(26401);
    ehK();
    AppMethodBeat.o(26401);
    return true;
  }
  
  public final String getFileName()
  {
    if (this.znE != null) {
      return this.znE.fileName;
    }
    return "";
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(26403);
    this.jxC.stopTimer();
    this.qPy.stopTimer();
    this.qPn = -1L;
    a.a locala = com.tencent.mm.cj.a.Owq;
    if (!a.a.blI(this.znE.fileName))
    {
      locala = com.tencent.mm.cj.a.Owq;
      if (!a.a.blK(this.znE.fileName)) {
        this.znE.Qt();
      }
    }
    bg.Xi().akq();
    AppMethodBeat.o(26403);
  }
  
  public final void qY(boolean paramBoolean) {}
  
  public final void release() {}
  
  final class a
    extends com.tencent.mm.audio.b.h
  {
    String fileName;
    
    public a(Context paramContext)
    {
      super(false);
    }
    
    public final boolean Qt()
    {
      AppMethodBeat.i(26393);
      this.fileName = super.getFileName();
      boolean bool = super.Qt();
      super.reset();
      AppMethodBeat.o(26393);
      return bool;
    }
    
    public final void cTH()
    {
      AppMethodBeat.i(185749);
      Qt();
      s.Rl(this.fileName);
      AppMethodBeat.o(185749);
    }
    
    public final String getFileName()
    {
      return this.fileName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b
 * JD-Core Version:    0.7.0.1
 */