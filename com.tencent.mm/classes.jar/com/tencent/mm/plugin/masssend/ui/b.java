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
import com.tencent.mm.an.m.a;
import com.tencent.mm.an.m.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cq.a.a;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.ui.base.w;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  private MassSendMsgUI EST;
  private ChatFooter ESU;
  private a ESV;
  private String ESW;
  private boolean ESX;
  private final m.a ESY;
  private final m.b ESZ;
  private List<String> jbu;
  private final MTimerHandler mnf;
  private Vibrator rqC;
  com.tencent.mm.ui.base.s tipDialog;
  private final MTimerHandler urE;
  private long urt;
  private Toast uru;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26394);
    this.urt = -1L;
    this.tipDialog = null;
    this.mnf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26387);
        b.b(b.this).aqA(b.a(b.this).aeK());
        AppMethodBeat.o(26387);
        return true;
      }
    }, true);
    this.ESY = new m.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(26388);
        b.a(b.this).reset();
        b.c(b.this).stopTimer();
        b.d(b.this).stopTimer();
        MMEntryLock.unlock("keep_app_silent");
        b.b(b.this).a(ChatFooter.h.Rnl);
        Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(b.e(b.this), b.e(b.this).getString(R.l.ewE), 0).show();
        AppMethodBeat.o(26388);
      }
    };
    this.ESZ = new m.b()
    {
      public final void bic()
      {
        AppMethodBeat.i(26389);
        b.b(b.this).hlq();
        AppMethodBeat.o(26389);
      }
    };
    this.urE = new MTimerHandler(new MTimerHandler.CallBack()
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
            b.a(b.this, Toast.makeText(b.e(b.this), b.e(b.this).getResources().getQuantityString(R.j.emj, i, new Object[] { Integer.valueOf(i) }), 0));
            b.g(b.this).show();
          }
        }
        else
        {
          if (l < 60000L) {
            break label283;
          }
          Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
          if (!b.b(b.this).hmk()) {
            break label247;
          }
          b.b(b.this).hlQ();
        }
        for (;;)
        {
          PlaySound.play(b.e(b.this), R.l.time_limit);
          AppMethodBeat.o(26390);
          return false;
          i = (int)((60000L - l) / 1000L);
          b.g(b.this).setText(b.e(b.this).getResources().getQuantityString(R.j.emj, i, new Object[] { Integer.valueOf(i) }));
          break;
          label247:
          if (b.a(b.this).TV()) {
            b.h(b.this);
          }
          b.b(b.this).a(ChatFooter.h.Rng);
        }
        label283:
        AppMethodBeat.o(26390);
        return true;
      }
    }, true);
    this.EST = paramMassSendMsgUI;
    this.ESU = paramChatFooter;
    this.ESW = paramString;
    this.jbu = paramList;
    this.ESX = paramBoolean;
    this.ESV = new a(paramMassSendMsgUI);
    this.ESV.a(this.ESY);
    this.ESV.a(this.ESZ);
    this.rqC = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(26394);
  }
  
  private void eRr()
  {
    AppMethodBeat.i(26397);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).ESD = this.ESW;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).ESE = this.jbu.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = this.ESV.fileName;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).ESF = this.ESV.ftc;
    localObject = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.ESX);
    bh.aGY().a((q)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.EST;
    this.EST.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(localMassSendMsgUI, this.EST.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26391);
        bh.aGY().a(this.ETb);
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
  
  public final void aLh(String paramString) {}
  
  public final boolean aNX(final String paramString)
  {
    AppMethodBeat.i(26400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26400);
      return false;
    }
    MassSendMsgUI.aOb(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).ESD = this.ESW;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).ESE = this.jbu.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.ESX);
    bh.aGY().a(paramString, 0);
    localObject = this.EST;
    this.EST.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, this.EST.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26392);
        bh.aGY().a(paramString);
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
  
  public final boolean aNY(String paramString)
  {
    AppMethodBeat.i(26402);
    boolean bool = com.tencent.mm.modelvoice.s.YI(paramString);
    AppMethodBeat.o(26402);
    return bool;
  }
  
  public final long aff()
  {
    AppMethodBeat.i(26404);
    if (this.ESV != null)
    {
      long l = this.ESV.aff();
      AppMethodBeat.o(26404);
      return l;
    }
    AppMethodBeat.o(26404);
    return 0L;
  }
  
  public final void ag(MotionEvent paramMotionEvent) {}
  
  public final boolean eRp()
  {
    AppMethodBeat.i(26395);
    this.mnf.stopTimer();
    this.urE.stopTimer();
    this.urt = -1L;
    if (this.ESV.TV())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.a.c.Nhv;
      com.tencent.mm.plugin.transvoice.a.c.gsv().setExitType(0);
      eRr();
      this.ESU.a(ChatFooter.h.Rng);
    }
    for (;;)
    {
      bh.abL().aqm();
      AppMethodBeat.o(26395);
      return false;
      this.ESU.cRI();
    }
  }
  
  public final boolean eRq()
  {
    AppMethodBeat.i(26396);
    this.mnf.stopTimer();
    this.urE.stopTimer();
    this.urt = -1L;
    this.ESV.TV();
    this.ESU.a(ChatFooter.h.Rnh);
    bh.abL().aqm();
    AppMethodBeat.o(26396);
    return true;
  }
  
  public final boolean eRs()
  {
    AppMethodBeat.i(26398);
    this.mnf.stopTimer();
    this.urE.stopTimer();
    this.urt = -1L;
    this.ESU.a(ChatFooter.h.Rnj);
    this.ESV.diM();
    bh.abL().aqm();
    AppMethodBeat.o(26398);
    return false;
  }
  
  public final void eRt()
  {
    AppMethodBeat.i(185750);
    this.ESU.a(ChatFooter.h.Rnj);
    this.ESV.diM();
    AppMethodBeat.o(185750);
  }
  
  public final boolean eRu()
  {
    AppMethodBeat.i(26399);
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      w.g(this.EST, null);
      AppMethodBeat.o(26399);
      return false;
    }
    if (com.tencent.mm.q.a.cx(this.EST))
    {
      AppMethodBeat.o(26399);
      return false;
    }
    this.rqC.vibrate(50L);
    Object localObject = com.tencent.mm.plugin.transvoice.a.c.Nhv;
    com.tencent.mm.plugin.transvoice.a.c.gsv().Nhc = true;
    this.mnf.startTimer(100L);
    this.urE.startTimer(200L);
    localObject = this.EST.getResources().getDisplayMetrics();
    this.ESU.aqz(((DisplayMetrics)localObject).heightPixels - this.ESU.getHeight());
    this.ESV.start();
    this.ESV.a(this.ESZ);
    this.ESV.a(this.ESY);
    bh.abL().aqn();
    AppMethodBeat.o(26399);
    return false;
  }
  
  public final void eRv() {}
  
  public final void eRw() {}
  
  public final void eRx() {}
  
  public final boolean eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(26401);
    eRr();
    AppMethodBeat.o(26401);
    return true;
  }
  
  public final String getFileName()
  {
    if (this.ESV != null) {
      return this.ESV.fileName;
    }
    return "";
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(26403);
    this.mnf.stopTimer();
    this.urE.stopTimer();
    this.urt = -1L;
    a.a locala = com.tencent.mm.cq.a.VPo;
    if (!a.a.byh(this.ESV.fileName))
    {
      locala = com.tencent.mm.cq.a.VPo;
      if (!a.a.byj(this.ESV.fileName)) {
        this.ESV.TV();
      }
    }
    bh.abL().aqm();
    AppMethodBeat.o(26403);
  }
  
  public final void release() {}
  
  public final void ua(boolean paramBoolean) {}
  
  final class a
    extends com.tencent.mm.audio.b.h
  {
    String fileName;
    
    public a(Context paramContext)
    {
      super(false);
    }
    
    public final boolean TV()
    {
      AppMethodBeat.i(26393);
      this.fileName = super.getFileName();
      boolean bool = super.TV();
      super.reset();
      AppMethodBeat.o(26393);
      return bool;
    }
    
    public final void diM()
    {
      AppMethodBeat.i(185749);
      TV();
      com.tencent.mm.modelvoice.s.YI(this.fileName);
      AppMethodBeat.o(185749);
    }
    
    public final String getFileName()
    {
      return this.fileName;
    }
    
    public final boolean start()
    {
      AppMethodBeat.i(242375);
      boolean bool = super.afd();
      AppMethodBeat.o(242375);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b
 * JD-Core Version:    0.7.0.1
 */