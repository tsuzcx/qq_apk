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
import com.tencent.mm.al.j.a;
import com.tencent.mm.al.j.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  private List<String> fPS;
  final av izu;
  private Vibrator nKv;
  final av ptD;
  long ptq;
  Toast ptt;
  p tipDialog;
  MassSendMsgUI vHs;
  ChatFooter vHt;
  a vHu;
  private String vHv;
  private boolean vHw;
  private final j.a vHx;
  private final j.b vHy;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26394);
    this.ptq = -1L;
    this.tipDialog = null;
    this.izu = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26387);
        b.this.vHt.Zg(b.this.vHu.getMaxAmplitude());
        AppMethodBeat.o(26387);
        return true;
      }
    }, true);
    this.vHx = new j.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(26388);
        b.this.vHu.reset();
        b.this.izu.stopTimer();
        b.this.ptD.stopTimer();
        an.aQv("keep_app_silent");
        b.this.vHt.a(ChatFooter.h.Fdf);
        ad.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(b.this.vHs, b.this.vHs.getString(2131757276), 0).show();
        AppMethodBeat.o(26388);
      }
    };
    this.vHy = new j.b()
    {
      public final void aEI()
      {
        AppMethodBeat.i(26389);
        b.this.vHt.fdt();
        AppMethodBeat.o(26389);
      }
    };
    this.ptD = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26390);
        if (b.this.ptq == -1L) {
          b.this.ptq = bt.HI();
        }
        long l = bt.aO(b.this.ptq);
        int i;
        if ((l >= 50000L) && (l <= 60000L))
        {
          if (b.this.ptt == null)
          {
            i = (int)((60000L - l) / 1000L);
            b.this.ptt = Toast.makeText(b.this.vHs, b.this.vHs.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }), 0);
            b.this.ptt.show();
          }
        }
        else
        {
          if (l < 60000L) {
            break label278;
          }
          ad.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
          if (!b.this.vHt.fel()) {
            break label242;
          }
          b.this.vHt.fdS();
        }
        for (;;)
        {
          bd.aI(b.this.vHs, 2131764424);
          AppMethodBeat.o(26390);
          return false;
          i = (int)((60000L - l) / 1000L);
          b.this.ptt.setText(b.this.vHs.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }));
          break;
          label242:
          if (b.this.vHu.Gv()) {
            b.this.dkX();
          }
          b.this.vHt.a(ChatFooter.h.Fda);
        }
        label278:
        AppMethodBeat.o(26390);
        return true;
      }
    }, true);
    this.vHs = paramMassSendMsgUI;
    this.vHt = paramChatFooter;
    this.vHv = paramString;
    this.fPS = paramList;
    this.vHw = paramBoolean;
    this.vHu = new a(paramMassSendMsgUI);
    this.vHu.a(this.vHx);
    this.vHu.a(this.vHy);
    this.nKv = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(26394);
  }
  
  public final long PZ()
  {
    AppMethodBeat.i(26404);
    if (this.vHu != null)
    {
      long l = this.vHu.PZ();
      AppMethodBeat.o(26404);
      return l;
    }
    AppMethodBeat.o(26404);
    return 0L;
  }
  
  public final void V(MotionEvent paramMotionEvent) {}
  
  public final void amZ(String paramString) {}
  
  public final boolean apn(final String paramString)
  {
    AppMethodBeat.i(26400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26400);
      return false;
    }
    MassSendMsgUI.apr(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vHc = this.vHv;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vHd = this.fPS.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.vHw);
    ba.aiU().a(paramString, 0);
    localObject = this.vHs;
    this.vHs.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.vHs.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26392);
        ba.aiU().a(paramString);
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
  
  public final boolean apo(String paramString)
  {
    AppMethodBeat.i(26402);
    boolean bool = s.HX(paramString);
    AppMethodBeat.o(26402);
    return bool;
  }
  
  public final boolean dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(26401);
    dkX();
    AppMethodBeat.o(26401);
    return true;
  }
  
  public final boolean dkV()
  {
    AppMethodBeat.i(26395);
    this.izu.stopTimer();
    this.ptD.stopTimer();
    this.ptq = -1L;
    if (this.vHu.Gv())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.a.c.BBY;
      com.tencent.mm.plugin.transvoice.a.c.eru().setExitType(0);
      dkX();
      this.vHt.a(ChatFooter.h.Fda);
    }
    for (;;)
    {
      ba.Nb().Wu();
      AppMethodBeat.o(26395);
      return false;
      this.vHt.cdY();
    }
  }
  
  public final boolean dkW()
  {
    AppMethodBeat.i(26396);
    this.izu.stopTimer();
    this.ptD.stopTimer();
    this.ptq = -1L;
    this.vHu.Gv();
    this.vHt.a(ChatFooter.h.Fdb);
    ba.Nb().Wu();
    AppMethodBeat.o(26396);
    return true;
  }
  
  final void dkX()
  {
    AppMethodBeat.i(26397);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vHc = this.vHv;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vHd = this.fPS.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = this.vHu.fileName;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).vHe = this.vHu.dhZ;
    localObject = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.vHw);
    ba.aiU().a((n)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.vHs;
    this.vHs.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localMassSendMsgUI, this.vHs.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26391);
        ba.aiU().a(this.vHA);
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
  
  public final boolean dkY()
  {
    AppMethodBeat.i(26398);
    this.izu.stopTimer();
    this.ptD.stopTimer();
    this.ptq = -1L;
    this.vHt.a(ChatFooter.h.Fdd);
    this.vHu.ctX();
    ba.Nb().Wu();
    AppMethodBeat.o(26398);
    return false;
  }
  
  public final void dkZ()
  {
    AppMethodBeat.i(185750);
    this.vHt.a(ChatFooter.h.Fdd);
    this.vHu.ctX();
    AppMethodBeat.o(185750);
  }
  
  public final boolean dla()
  {
    AppMethodBeat.i(26399);
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.vHs, null);
      AppMethodBeat.o(26399);
      return false;
    }
    if (com.tencent.mm.s.a.ce(this.vHs))
    {
      AppMethodBeat.o(26399);
      return false;
    }
    this.nKv.vibrate(50L);
    Object localObject = com.tencent.mm.plugin.transvoice.a.c.BBY;
    com.tencent.mm.plugin.transvoice.a.c.eru().BBF = true;
    this.izu.az(100L, 100L);
    this.ptD.az(200L, 200L);
    localObject = this.vHs.getResources().getDisplayMetrics();
    this.vHt.Zf(((DisplayMetrics)localObject).heightPixels - this.vHt.getHeight());
    this.vHu.gA("_USER_FOR_THROWBOTTLE_");
    this.vHu.a(this.vHy);
    this.vHu.a(this.vHx);
    ba.Nb().Wv();
    AppMethodBeat.o(26399);
    return false;
  }
  
  public final void dlb() {}
  
  public final void dlc() {}
  
  public final void dld() {}
  
  public final String getFileName()
  {
    if (this.vHu != null) {
      return this.vHu.fileName;
    }
    return "";
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(26403);
    this.izu.stopTimer();
    this.ptD.stopTimer();
    this.ptq = -1L;
    a.a locala = com.tencent.mm.ck.a.IRP;
    if (!a.a.aVi(this.vHu.fileName))
    {
      locala = com.tencent.mm.ck.a.IRP;
      if (!a.a.aVk(this.vHu.fileName)) {
        this.vHu.Gv();
      }
    }
    ba.Nb().Wu();
    AppMethodBeat.o(26403);
  }
  
  public final void oo(boolean paramBoolean) {}
  
  public final void release() {}
  
  final class a
    extends com.tencent.mm.audio.b.h
  {
    String fileName;
    
    public a(Context paramContext)
    {
      super(false);
    }
    
    public final boolean Gv()
    {
      AppMethodBeat.i(26393);
      this.fileName = super.getFileName();
      boolean bool = super.Gv();
      super.reset();
      AppMethodBeat.o(26393);
      return bool;
    }
    
    public final void ctX()
    {
      AppMethodBeat.i(185749);
      Gv();
      s.HX(this.fileName);
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