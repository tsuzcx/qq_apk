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
import com.tencent.mm.ak.j.a;
import com.tencent.mm.ak.j.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  private List<String> fRY;
  final aw iCn;
  private Vibrator nQa;
  final aw pAh;
  long pzW;
  Toast pzX;
  p tipDialog;
  private boolean vTA;
  private final j.a vTB;
  private final j.b vTC;
  MassSendMsgUI vTw;
  ChatFooter vTx;
  a vTy;
  private String vTz;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26394);
    this.pzW = -1L;
    this.tipDialog = null;
    this.iCn = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26387);
        b.this.vTx.ZM(b.this.vTy.getMaxAmplitude());
        AppMethodBeat.o(26387);
        return true;
      }
    }, true);
    this.vTB = new j.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(26388);
        b.this.vTy.reset();
        b.this.iCn.stopTimer();
        b.this.pAh.stopTimer();
        ao.aRS("keep_app_silent");
        b.this.vTx.a(ChatFooter.h.FvD);
        ae.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(b.this.vTw, b.this.vTw.getString(2131757276), 0).show();
        AppMethodBeat.o(26388);
      }
    };
    this.vTC = new j.b()
    {
      public final void aEY()
      {
        AppMethodBeat.i(26389);
        b.this.vTx.fhi();
        AppMethodBeat.o(26389);
      }
    };
    this.pAh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26390);
        if (b.this.pzW == -1L) {
          b.this.pzW = bu.HQ();
        }
        long l = bu.aO(b.this.pzW);
        int i;
        if ((l >= 50000L) && (l <= 60000L))
        {
          if (b.this.pzX == null)
          {
            i = (int)((60000L - l) / 1000L);
            b.this.pzX = Toast.makeText(b.this.vTw, b.this.vTw.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }), 0);
            b.this.pzX.show();
          }
        }
        else
        {
          if (l < 60000L) {
            break label278;
          }
          ae.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
          if (!b.this.vTx.fib()) {
            break label242;
          }
          b.this.vTx.fhH();
        }
        for (;;)
        {
          be.aI(b.this.vTw, 2131764424);
          AppMethodBeat.o(26390);
          return false;
          i = (int)((60000L - l) / 1000L);
          b.this.pzX.setText(b.this.vTw.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }));
          break;
          label242:
          if (b.this.vTy.GB()) {
            b.this.dnX();
          }
          b.this.vTx.a(ChatFooter.h.Fvy);
        }
        label278:
        AppMethodBeat.o(26390);
        return true;
      }
    }, true);
    this.vTw = paramMassSendMsgUI;
    this.vTx = paramChatFooter;
    this.vTz = paramString;
    this.fRY = paramList;
    this.vTA = paramBoolean;
    this.vTy = new a(paramMassSendMsgUI);
    this.vTy.a(this.vTB);
    this.vTy.a(this.vTC);
    this.nQa = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(26394);
  }
  
  public final long PY()
  {
    AppMethodBeat.i(26404);
    if (this.vTy != null)
    {
      long l = this.vTy.PY();
      AppMethodBeat.o(26404);
      return l;
    }
    AppMethodBeat.o(26404);
    return 0L;
  }
  
  public final void T(MotionEvent paramMotionEvent) {}
  
  public final void aoa(String paramString) {}
  
  public final boolean aqs(final String paramString)
  {
    AppMethodBeat.i(26400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26400);
      return false;
    }
    MassSendMsgUI.aqw(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vTg = this.vTz;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vTh = this.fRY.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.vTA);
    bc.ajj().a(paramString, 0);
    localObject = this.vTw;
    this.vTw.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.vTw.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26392);
        bc.ajj().a(paramString);
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
  
  public final boolean aqt(String paramString)
  {
    AppMethodBeat.i(26402);
    boolean bool = s.Iz(paramString);
    AppMethodBeat.o(26402);
    return bool;
  }
  
  public final boolean dnV()
  {
    AppMethodBeat.i(26395);
    this.iCn.stopTimer();
    this.pAh.stopTimer();
    this.pzW = -1L;
    if (this.vTy.GB())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.a.c.BTw;
      com.tencent.mm.plugin.transvoice.a.c.evb().setExitType(0);
      dnX();
      this.vTx.a(ChatFooter.h.Fvy);
    }
    for (;;)
    {
      bc.MW().WC();
      AppMethodBeat.o(26395);
      return false;
      this.vTx.cfn();
    }
  }
  
  public final boolean dnW()
  {
    AppMethodBeat.i(26396);
    this.iCn.stopTimer();
    this.pAh.stopTimer();
    this.pzW = -1L;
    this.vTy.GB();
    this.vTx.a(ChatFooter.h.Fvz);
    bc.MW().WC();
    AppMethodBeat.o(26396);
    return true;
  }
  
  final void dnX()
  {
    AppMethodBeat.i(26397);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vTg = this.vTz;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vTh = this.fRY.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = this.vTy.fileName;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vTi = this.vTy.djc;
    localObject = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.vTA);
    bc.ajj().a((n)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.vTw;
    this.vTw.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localMassSendMsgUI, this.vTw.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26391);
        bc.ajj().a(this.vTE);
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
  
  public final boolean dnY()
  {
    AppMethodBeat.i(26398);
    this.iCn.stopTimer();
    this.pAh.stopTimer();
    this.pzW = -1L;
    this.vTx.a(ChatFooter.h.FvB);
    this.vTy.cvy();
    bc.MW().WC();
    AppMethodBeat.o(26398);
    return false;
  }
  
  public final void dnZ()
  {
    AppMethodBeat.i(185750);
    this.vTx.a(ChatFooter.h.FvB);
    this.vTy.cvy();
    AppMethodBeat.o(185750);
  }
  
  public final boolean doa()
  {
    AppMethodBeat.i(26399);
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.vTw, null);
      AppMethodBeat.o(26399);
      return false;
    }
    if (com.tencent.mm.r.a.cg(this.vTw))
    {
      AppMethodBeat.o(26399);
      return false;
    }
    this.nQa.vibrate(50L);
    Object localObject = com.tencent.mm.plugin.transvoice.a.c.BTw;
    com.tencent.mm.plugin.transvoice.a.c.evb().BTd = true;
    this.iCn.ay(100L, 100L);
    this.pAh.ay(200L, 200L);
    localObject = this.vTw.getResources().getDisplayMetrics();
    this.vTx.ZL(((DisplayMetrics)localObject).heightPixels - this.vTx.getHeight());
    this.vTy.gG("_USER_FOR_THROWBOTTLE_");
    this.vTy.a(this.vTC);
    this.vTy.a(this.vTB);
    bc.MW().WD();
    AppMethodBeat.o(26399);
    return false;
  }
  
  public final void dob() {}
  
  public final void doc() {}
  
  public final void dod() {}
  
  public final boolean eg(String paramString, int paramInt)
  {
    AppMethodBeat.i(26401);
    dnX();
    AppMethodBeat.o(26401);
    return true;
  }
  
  public final String getFileName()
  {
    if (this.vTy != null) {
      return this.vTy.fileName;
    }
    return "";
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(26403);
    this.iCn.stopTimer();
    this.pAh.stopTimer();
    this.pzW = -1L;
    a.a locala = com.tencent.mm.cj.a.Jmx;
    if (!a.a.aWJ(this.vTy.fileName))
    {
      locala = com.tencent.mm.cj.a.Jmx;
      if (!a.a.aWL(this.vTy.fileName)) {
        this.vTy.GB();
      }
    }
    bc.MW().WC();
    AppMethodBeat.o(26403);
  }
  
  public final void ot(boolean paramBoolean) {}
  
  public final void release() {}
  
  final class a
    extends com.tencent.mm.audio.b.h
  {
    String fileName;
    
    public a(Context paramContext)
    {
      super(false);
    }
    
    public final boolean GB()
    {
      AppMethodBeat.i(26393);
      this.fileName = super.getFileName();
      boolean bool = super.GB();
      super.reset();
      AppMethodBeat.o(26393);
      return bool;
    }
    
    public final void cvy()
    {
      AppMethodBeat.i(185749);
      GB();
      s.Iz(this.fileName);
      AppMethodBeat.o(185749);
    }
    
    public final String getFileName()
    {
      return this.fileName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b
 * JD-Core Version:    0.7.0.1
 */