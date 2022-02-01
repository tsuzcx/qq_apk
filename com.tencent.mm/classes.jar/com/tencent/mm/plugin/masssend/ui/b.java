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
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  private List<String> fwF;
  final au iga;
  private Vibrator njY;
  long oPI;
  Toast oPJ;
  final au oPT;
  p tipDialog;
  MassSendMsgUI uEs;
  ChatFooter uEt;
  a uEu;
  private String uEv;
  private boolean uEw;
  private final k.a uEx;
  private final k.b uEy;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26394);
    this.oPI = -1L;
    this.tipDialog = null;
    this.iga = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26387);
        b.this.uEt.Xk(b.this.uEu.getMaxAmplitude());
        AppMethodBeat.o(26387);
        return true;
      }
    }, true);
    this.uEx = new k.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(26388);
        b.this.uEu.reset();
        b.this.iga.stopTimer();
        b.this.oPT.stopTimer();
        am.aKP("keep_app_silent");
        b.this.uEt.a(ChatFooter.h.DxW);
        ac.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(b.this.uEs, b.this.uEs.getString(2131757276), 0).show();
        AppMethodBeat.o(26388);
      }
    };
    this.uEy = new k.b()
    {
      public final void aBG()
      {
        AppMethodBeat.i(26389);
        b.this.uEt.eOu();
        AppMethodBeat.o(26389);
      }
    };
    this.oPT = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26390);
        if (b.this.oPI == -1L) {
          b.this.oPI = bs.Gn();
        }
        long l = bs.aO(b.this.oPI);
        int i;
        if ((l >= 50000L) && (l <= 60000L))
        {
          if (b.this.oPJ == null)
          {
            i = (int)((60000L - l) / 1000L);
            b.this.oPJ = Toast.makeText(b.this.uEs, b.this.uEs.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }), 0);
            b.this.oPJ.show();
          }
        }
        else
        {
          if (l < 60000L) {
            break label278;
          }
          ac.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
          if (!b.this.uEt.ePk()) {
            break label242;
          }
          b.this.uEt.eOS();
        }
        for (;;)
        {
          bc.aF(b.this.uEs, 2131764424);
          AppMethodBeat.o(26390);
          return false;
          i = (int)((60000L - l) / 1000L);
          b.this.oPJ.setText(b.this.uEs.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }));
          break;
          label242:
          if (b.this.uEu.Fb()) {
            b.this.dbD();
          }
          b.this.uEt.a(ChatFooter.h.DxR);
        }
        label278:
        AppMethodBeat.o(26390);
        return true;
      }
    }, true);
    this.uEs = paramMassSendMsgUI;
    this.uEt = paramChatFooter;
    this.uEv = paramString;
    this.fwF = paramList;
    this.uEw = paramBoolean;
    this.uEu = new a(paramMassSendMsgUI);
    this.uEu.a(this.uEx);
    this.uEu.a(this.uEy);
    this.njY = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(26394);
  }
  
  public final long Oq()
  {
    AppMethodBeat.i(26404);
    if (this.uEu != null)
    {
      long l = this.uEu.Oq();
      AppMethodBeat.o(26404);
      return l;
    }
    AppMethodBeat.o(26404);
    return 0L;
  }
  
  public final void W(MotionEvent paramMotionEvent) {}
  
  public final void aim(String paramString) {}
  
  public final boolean akA(final String paramString)
  {
    AppMethodBeat.i(26400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26400);
      return false;
    }
    MassSendMsgUI.akE(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).uEc = this.uEv;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).uEd = this.fwF.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.uEw);
    az.agi().a(paramString, 0);
    localObject = this.uEs;
    this.uEs.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.uEs.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26392);
        az.agi().a(paramString);
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
  
  public final boolean akB(String paramString)
  {
    AppMethodBeat.i(26402);
    boolean bool = s.EI(paramString);
    AppMethodBeat.o(26402);
    return bool;
  }
  
  public final boolean dI(String paramString, int paramInt)
  {
    AppMethodBeat.i(26401);
    dbD();
    AppMethodBeat.o(26401);
    return true;
  }
  
  public final boolean dbB()
  {
    AppMethodBeat.i(26395);
    this.iga.stopTimer();
    this.oPT.stopTimer();
    this.oPI = -1L;
    if (this.uEu.Fb())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.a.c.Akm;
      com.tencent.mm.plugin.transvoice.a.c.efd().setExitType(0);
      dbD();
      this.uEt.a(ChatFooter.h.DxR);
    }
    for (;;)
    {
      az.Lt().Ud();
      AppMethodBeat.o(26395);
      return false;
      this.uEt.bZu();
    }
  }
  
  public final boolean dbC()
  {
    AppMethodBeat.i(26396);
    this.iga.stopTimer();
    this.oPT.stopTimer();
    this.oPI = -1L;
    this.uEu.Fb();
    this.uEt.a(ChatFooter.h.DxS);
    az.Lt().Ud();
    AppMethodBeat.o(26396);
    return true;
  }
  
  final void dbD()
  {
    AppMethodBeat.i(26397);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).uEc = this.uEv;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).uEd = this.fwF.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = this.uEu.fileName;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).uEe = this.uEu.cWJ;
    localObject = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.uEw);
    az.agi().a((n)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.uEs;
    this.uEs.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localMassSendMsgUI, this.uEs.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26391);
        az.agi().a(this.uEA);
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
  
  public final boolean dbE()
  {
    AppMethodBeat.i(26398);
    this.iga.stopTimer();
    this.oPT.stopTimer();
    this.oPI = -1L;
    this.uEt.a(ChatFooter.h.DxU);
    this.uEu.cos();
    az.Lt().Ud();
    AppMethodBeat.o(26398);
    return false;
  }
  
  public final void dbF()
  {
    AppMethodBeat.i(185750);
    this.uEt.a(ChatFooter.h.DxU);
    this.uEu.cos();
    AppMethodBeat.o(185750);
  }
  
  public final boolean dbG()
  {
    AppMethodBeat.i(26399);
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.uEs, null);
      AppMethodBeat.o(26399);
      return false;
    }
    if (com.tencent.mm.r.a.ch(this.uEs))
    {
      AppMethodBeat.o(26399);
      return false;
    }
    this.njY.vibrate(50L);
    Object localObject = com.tencent.mm.plugin.transvoice.a.c.Akm;
    com.tencent.mm.plugin.transvoice.a.c.efd().AjT = true;
    this.iga.au(100L, 100L);
    this.oPT.au(200L, 200L);
    localObject = this.uEs.getResources().getDisplayMetrics();
    this.uEt.Xj(((DisplayMetrics)localObject).heightPixels - this.uEt.getHeight());
    this.uEu.fF("_USER_FOR_THROWBOTTLE_");
    this.uEu.a(this.uEy);
    this.uEu.a(this.uEx);
    az.Lt().Ue();
    AppMethodBeat.o(26399);
    return false;
  }
  
  public final void dbH() {}
  
  public final void dbI() {}
  
  public final void dbJ() {}
  
  public final String getFileName()
  {
    if (this.uEu != null) {
      return this.uEu.fileName;
    }
    return "";
  }
  
  public final void nU(boolean paramBoolean) {}
  
  public final void onPause()
  {
    AppMethodBeat.i(26403);
    this.iga.stopTimer();
    this.oPT.stopTimer();
    this.oPI = -1L;
    a.a locala = com.tencent.mm.ck.a.Hez;
    if (!a.a.aPr(this.uEu.fileName))
    {
      locala = com.tencent.mm.ck.a.Hez;
      if (!a.a.aPt(this.uEu.fileName)) {
        this.uEu.Fb();
      }
    }
    az.Lt().Ud();
    AppMethodBeat.o(26403);
  }
  
  public final void release() {}
  
  final class a
    extends com.tencent.mm.audio.b.h
  {
    String fileName;
    
    public a(Context paramContext)
    {
      super(false);
    }
    
    public final boolean Fb()
    {
      AppMethodBeat.i(26393);
      this.fileName = super.getFileName();
      boolean bool = super.Fb();
      super.reset();
      AppMethodBeat.o(26393);
      return bool;
    }
    
    public final void cos()
    {
      AppMethodBeat.i(185749);
      Fb();
      s.EI(this.fileName);
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