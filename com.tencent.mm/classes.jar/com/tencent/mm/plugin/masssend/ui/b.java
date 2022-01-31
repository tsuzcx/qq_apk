package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.cj.a.a;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.transvoice.a.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.t;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  final ap gcG;
  private Vibrator kqP;
  long mwM;
  Toast mwN;
  final ap mwY;
  private boolean oBA;
  private final j.a oBB;
  private final j.b oBC;
  MassSendMsgUI oBv;
  ChatFooter oBw;
  b.a oBx;
  private String oBy;
  private List<String> oBz;
  com.tencent.mm.ui.base.p tipDialog;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(22775);
    this.mwM = -1L;
    this.tipDialog = null;
    this.gcG = new ap(new b.1(this), true);
    this.oBB = new b.2(this);
    this.oBC = new b.3(this);
    this.mwY = new ap(new b.4(this), true);
    this.oBv = paramMassSendMsgUI;
    this.oBw = paramChatFooter;
    this.oBy = paramString;
    this.oBz = paramList;
    this.oBA = paramBoolean;
    this.oBx = new b.a(this, paramMassSendMsgUI);
    this.oBx.a(this.oBB);
    this.oBx.a(this.oBC);
    this.kqP = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
    AppMethodBeat.o(22775);
  }
  
  public final long EN()
  {
    AppMethodBeat.i(155410);
    if (this.oBx != null)
    {
      long l = this.oBx.EN();
      AppMethodBeat.o(155410);
      return l;
    }
    AppMethodBeat.o(155410);
    return 0L;
  }
  
  public final void M(MotionEvent paramMotionEvent) {}
  
  public final boolean SE(String paramString)
  {
    AppMethodBeat.i(22780);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(22780);
      return false;
    }
    MassSendMsgUI.SJ(paramString);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).oBe = this.oBy;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).oBf = this.oBz.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = paramString;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 1;
    paramString = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.oBA);
    aw.Rc().a(paramString, 0);
    localObject = this.oBv;
    this.oBv.getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.oBv.getString(2131303128), true, new b.6(this, paramString));
    AppMethodBeat.o(22780);
    return true;
  }
  
  public final boolean SF(String paramString)
  {
    AppMethodBeat.i(155409);
    boolean bool = s.vQ(paramString);
    AppMethodBeat.o(155409);
    return bool;
  }
  
  public final boolean bPe()
  {
    AppMethodBeat.i(22776);
    this.gcG.stopTimer();
    this.mwY.stopTimer();
    this.mwM = -1L;
    if (this.oBx.Ez())
    {
      c.a locala = com.tencent.mm.plugin.transvoice.a.c.tpD;
      com.tencent.mm.plugin.transvoice.a.c.cKY().GV(0);
      bPg();
      this.oBw.bxy();
    }
    for (;;)
    {
      aw.BY().Ib();
      AppMethodBeat.o(22776);
      return false;
      this.oBw.dhO();
    }
  }
  
  public final boolean bPf()
  {
    AppMethodBeat.i(155407);
    this.gcG.stopTimer();
    this.mwY.stopTimer();
    this.mwM = -1L;
    if (this.oBx.Ez()) {
      this.oBw.bxy();
    }
    for (;;)
    {
      aw.BY().Ib();
      AppMethodBeat.o(155407);
      return true;
      this.oBw.dhO();
    }
  }
  
  final void bPg()
  {
    AppMethodBeat.i(22777);
    Object localObject = new com.tencent.mm.plugin.masssend.a.a();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).oBe = this.oBy;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).oBf = this.oBz.size();
    ((com.tencent.mm.plugin.masssend.a.a)localObject).filename = this.oBx.fileName;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).msgType = 34;
    ((com.tencent.mm.plugin.masssend.a.a)localObject).oBg = this.oBx.cku;
    localObject = new f((com.tencent.mm.plugin.masssend.a.a)localObject, this.oBA);
    aw.Rc().a((m)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.oBv;
    this.oBv.getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localMassSendMsgUI, this.oBv.getString(2131303128), true, new b.5(this, (f)localObject));
    AppMethodBeat.o(22777);
  }
  
  public final boolean bPh()
  {
    AppMethodBeat.i(22778);
    this.gcG.stopTimer();
    this.mwY.stopTimer();
    this.mwM = -1L;
    this.oBw.bxy();
    b.a locala = this.oBx;
    locala.Ez();
    s.vQ(locala.fileName);
    aw.BY().Ib();
    AppMethodBeat.o(22778);
    return false;
  }
  
  public final boolean bPi()
  {
    AppMethodBeat.i(22779);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.ii(this.oBv);
      AppMethodBeat.o(22779);
      return false;
    }
    this.kqP.vibrate(50L);
    this.gcG.ag(100L, 100L);
    this.mwY.ag(200L, 200L);
    DisplayMetrics localDisplayMetrics = this.oBv.getResources().getDisplayMetrics();
    this.oBw.Mi(localDisplayMetrics.heightPixels - this.oBw.getHeight());
    this.oBx.eI("_USER_FOR_THROWBOTTLE_");
    this.oBx.a(this.oBC);
    this.oBx.a(this.oBB);
    aw.BY().Ic();
    AppMethodBeat.o(22779);
    return false;
  }
  
  public final void bPj() {}
  
  public final void bPk() {}
  
  public final boolean cA(String paramString, int paramInt)
  {
    AppMethodBeat.i(155408);
    bPg();
    AppMethodBeat.o(155408);
    return true;
  }
  
  public final String getFileName()
  {
    if (this.oBx != null) {
      return this.oBx.fileName;
    }
    return "";
  }
  
  public final void jj(boolean paramBoolean) {}
  
  public final void onPause()
  {
    AppMethodBeat.i(22782);
    this.gcG.stopTimer();
    this.mwY.stopTimer();
    this.mwM = -1L;
    a.a locala = com.tencent.mm.cj.a.yTb;
    if (!a.a.atj(this.oBx.fileName)) {
      this.oBx.Ez();
    }
    aw.BY().Ib();
    AppMethodBeat.o(22782);
  }
  
  public final void release()
  {
    AppMethodBeat.i(22781);
    AppMethodBeat.o(22781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b
 * JD-Core Version:    0.7.0.1
 */