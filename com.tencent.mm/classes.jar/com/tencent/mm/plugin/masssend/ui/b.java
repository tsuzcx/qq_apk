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
import com.tencent.mm.al.k.a;
import com.tencent.mm.al.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.cl.a.a;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.az;
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
  private List<String> fsY;
  final av hFy;
  private Vibrator mHT;
  long omi;
  Toast omj;
  final av omt;
  p tipDialog;
  MassSendMsgUI twa;
  ChatFooter twb;
  a twc;
  private String twd;
  private boolean twe;
  private final k.a twf;
  private final k.b twg;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26394);
    this.omi = -1L;
    this.tipDialog = null;
    this.hFy = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26387);
        b.this.twb.Vb(b.this.twc.getMaxAmplitude());
        AppMethodBeat.o(26387);
        return true;
      }
    }, true);
    this.twf = new k.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(26388);
        b.this.twc.reset();
        b.this.hFy.stopTimer();
        b.this.omt.stopTimer();
        an.aFy("keep_app_silent");
        b.this.twb.a(ChatFooter.h.CfF);
        ad.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
        Toast.makeText(b.this.twa, b.this.twa.getString(2131757276), 0).show();
        AppMethodBeat.o(26388);
      }
    };
    this.twg = new k.b()
    {
      public final void auN()
      {
        AppMethodBeat.i(26389);
        b.this.twb.eza();
        AppMethodBeat.o(26389);
      }
    };
    this.omt = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(26390);
        if (b.this.omi == -1L) {
          b.this.omi = bt.GC();
        }
        long l = bt.aS(b.this.omi);
        int i;
        if ((l >= 50000L) && (l <= 60000L))
        {
          if (b.this.omj == null)
          {
            i = (int)((60000L - l) / 1000L);
            b.this.omj = Toast.makeText(b.this.twa, b.this.twa.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }), 0);
            b.this.omj.show();
          }
        }
        else
        {
          if (l < 60000L) {
            break label278;
          }
          ad.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
          if (!b.this.twb.ezQ()) {
            break label242;
          }
          b.this.twb.ezy();
        }
        for (;;)
        {
          bd.az(b.this.twa, 2131764424);
          AppMethodBeat.o(26390);
          return false;
          i = (int)((60000L - l) / 1000L);
          b.this.omj.setText(b.this.twa.getResources().getQuantityString(2131623938, i, new Object[] { Integer.valueOf(i) }));
          break;
          label242:
          if (b.this.twc.Ft()) {
            b.this.cNW();
          }
          b.this.twb.a(ChatFooter.h.CfA);
        }
        label278:
        AppMethodBeat.o(26390);
        return true;
      }
    }, true);
    this.twa = paramMassSendMsgUI;
    this.twb = paramChatFooter;
    this.twd = paramString;
    this.fsY = paramList;
    this.twe = paramBoolean;
    this.twc = new a(paramMassSendMsgUI);
    this.twc.a(this.twf);
    this.twc.a(this.twg);
    this.mHT = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(26394);
  }
  
  public final long Ou()
  {
    AppMethodBeat.i(26404);
    if (this.twc != null)
    {
      long l = this.twc.Ou();
      AppMethodBeat.o(26404);
      return l;
    }
    AppMethodBeat.o(26404);
    return 0L;
  }
  
  public final void W(MotionEvent paramMotionEvent) {}
  
  public final void adu(String paramString) {}
  
  public final boolean afG(final String paramString)
  {
    AppMethodBeat.i(26400);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26400);
      return false;
    }
    MassSendMsgUI.afK(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).tvJ = this.twd;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).tvK = this.fsY.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.twe);
    az.aeS().a(paramString, 0);
    localObject = this.twa;
    this.twa.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.twa.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26392);
        az.aeS().a(paramString);
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
  
  public final boolean afH(String paramString)
  {
    AppMethodBeat.i(26402);
    boolean bool = s.AD(paramString);
    AppMethodBeat.o(26402);
    return bool;
  }
  
  public final boolean cNU()
  {
    AppMethodBeat.i(26395);
    this.hFy.stopTimer();
    this.omt.stopTimer();
    this.omi = -1L;
    if (this.twc.Ft())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.a.c.yWx;
      com.tencent.mm.plugin.transvoice.a.c.dQE().setExitType(0);
      cNW();
      this.twb.a(ChatFooter.h.CfA);
    }
    for (;;)
    {
      az.Lv().Tj();
      AppMethodBeat.o(26395);
      return false;
      this.twb.bSf();
    }
  }
  
  public final boolean cNV()
  {
    AppMethodBeat.i(26396);
    this.hFy.stopTimer();
    this.omt.stopTimer();
    this.omi = -1L;
    this.twc.Ft();
    this.twb.a(ChatFooter.h.CfB);
    az.Lv().Tj();
    AppMethodBeat.o(26396);
    return true;
  }
  
  final void cNW()
  {
    AppMethodBeat.i(26397);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).tvJ = this.twd;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).tvK = this.fsY.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = this.twc.fileName;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).tvL = this.twc.cZn;
    localObject = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.twe);
    az.aeS().a((n)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.twa;
    this.twa.getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localMassSendMsgUI, this.twa.getString(2131763077), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26391);
        az.aeS().a(this.twi);
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
  
  public final boolean cNX()
  {
    AppMethodBeat.i(26398);
    this.hFy.stopTimer();
    this.omt.stopTimer();
    this.omi = -1L;
    this.twb.a(ChatFooter.h.CfD);
    this.twc.cgL();
    az.Lv().Tj();
    AppMethodBeat.o(26398);
    return false;
  }
  
  public final void cNY()
  {
    AppMethodBeat.i(185750);
    this.twb.a(ChatFooter.h.CfD);
    this.twc.cgL();
    AppMethodBeat.o(185750);
  }
  
  public final boolean cNZ()
  {
    AppMethodBeat.i(26399);
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this.twa, null);
      AppMethodBeat.o(26399);
      return false;
    }
    this.mHT.vibrate(50L);
    Object localObject = com.tencent.mm.plugin.transvoice.a.c.yWx;
    com.tencent.mm.plugin.transvoice.a.c.dQE().yWe = true;
    this.hFy.av(100L, 100L);
    this.omt.av(200L, 200L);
    localObject = this.twa.getResources().getDisplayMetrics();
    this.twb.Va(((DisplayMetrics)localObject).heightPixels - this.twb.getHeight());
    this.twc.fP("_USER_FOR_THROWBOTTLE_");
    this.twc.a(this.twg);
    this.twc.a(this.twf);
    az.Lv().Tk();
    AppMethodBeat.o(26399);
    return false;
  }
  
  public final void cOa() {}
  
  public final void cOb() {}
  
  public final boolean dC(String paramString, int paramInt)
  {
    AppMethodBeat.i(26401);
    cNW();
    AppMethodBeat.o(26401);
    return true;
  }
  
  public final String getFileName()
  {
    if (this.twc != null) {
      return this.twc.fileName;
    }
    return "";
  }
  
  public final void nb(boolean paramBoolean) {}
  
  public final void onPause()
  {
    AppMethodBeat.i(26403);
    this.hFy.stopTimer();
    this.omt.stopTimer();
    this.omi = -1L;
    a.a locala = com.tencent.mm.cl.a.FFw;
    if (!a.a.aJT(this.twc.fileName))
    {
      locala = com.tencent.mm.cl.a.FFw;
      if (!a.a.aJV(this.twc.fileName)) {
        this.twc.Ft();
      }
    }
    az.Lv().Tj();
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
    
    public final boolean Ft()
    {
      AppMethodBeat.i(26393);
      this.fileName = super.getFileName();
      boolean bool = super.Ft();
      super.reset();
      AppMethodBeat.o(26393);
      return bool;
    }
    
    public final void cgL()
    {
      AppMethodBeat.i(185749);
      Ft();
      s.AD(this.fileName);
      AppMethodBeat.o(185749);
    }
    
    public final String getFileName()
    {
      return this.fileName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b
 * JD-Core Version:    0.7.0.1
 */