package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.res.Resources;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.ah.j.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.ui.base.s;
import java.util.List;

public final class b
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  final am eNb = new am(new b.1(this), true);
  final am ibI = new am(new b.4(this), true);
  private final j.a ibK = new b.2(this);
  ToneGenerator ibo;
  long ibp = -1L;
  Toast ibq;
  private Vibrator ibr;
  MassSendMsgUI maU;
  ChatFooter maV;
  b.a maW;
  private String maX;
  private List<String> maY;
  private boolean maZ;
  private final j.b mba = new b.3(this);
  com.tencent.mm.ui.base.p tipDialog = null;
  
  public b(MassSendMsgUI paramMassSendMsgUI, ChatFooter paramChatFooter, String paramString, List<String> paramList, boolean paramBoolean)
  {
    this.maU = paramMassSendMsgUI;
    this.maV = paramChatFooter;
    this.maX = paramString;
    this.maY = paramList;
    this.maZ = paramBoolean;
    this.maW = new b.a(this, paramMassSendMsgUI);
    this.maW.a(this.ibK);
    this.maW.a(this.mba);
    this.ibo = new ToneGenerator(1, 60);
    this.ibr = ((Vibrator)paramMassSendMsgUI.getSystemService("vibrator"));
  }
  
  public final void D(MotionEvent paramMotionEvent) {}
  
  public final boolean GU(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    MassSendMsgUI.GY(paramString);
    Object localObject = new a();
    ((a)localObject).maF = this.maX;
    ((a)localObject).maG = this.maY.size();
    ((a)localObject).filename = paramString;
    ((a)localObject).msgType = 1;
    paramString = new f((a)localObject, this.maZ);
    au.Dk().a(paramString, 0);
    localObject = this.maU;
    this.maU.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, this.maU.getString(R.l.sendrequest_sending), true, new b.7(this, paramString));
    return true;
  }
  
  public final boolean bhf()
  {
    this.eNb.stopTimer();
    this.ibI.stopTimer();
    this.ibp = -1L;
    if (this.maW.un())
    {
      bhg();
      this.maV.aRj();
    }
    for (;;)
    {
      au.tu().vS();
      return false;
      this.maV.cnh();
    }
  }
  
  final void bhg()
  {
    Object localObject = new a();
    ((a)localObject).maF = this.maX;
    ((a)localObject).maG = this.maY.size();
    ((a)localObject).filename = this.maW.fileName;
    ((a)localObject).msgType = 34;
    ((a)localObject).maH = this.maW.bDF;
    localObject = new f((a)localObject, this.maZ);
    au.Dk().a((m)localObject, 0);
    MassSendMsgUI localMassSendMsgUI = this.maU;
    this.maU.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localMassSendMsgUI, this.maU.getString(R.l.sendrequest_sending), true, new b.5(this, (f)localObject));
  }
  
  public final boolean bhh()
  {
    this.eNb.stopTimer();
    this.ibI.stopTimer();
    this.ibp = -1L;
    this.maV.aRj();
    b.a locala = this.maW;
    locala.un();
    q.oD(locala.fileName);
    au.tu().vS();
    return false;
  }
  
  public final boolean bhi()
  {
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(this.maU);
      return false;
    }
    this.ibo.startTone(24);
    new ah().postDelayed(new b.6(this), 200L);
    this.ibr.vibrate(50L);
    this.eNb.S(100L, 100L);
    this.ibI.S(200L, 200L);
    DisplayMetrics localDisplayMetrics = this.maU.getResources().getDisplayMetrics();
    this.maV.Ej(localDisplayMetrics.heightPixels - this.maV.getHeight());
    this.maW.cE("_USER_FOR_THROWBOTTLE_");
    this.maW.a(this.mba);
    this.maW.a(this.ibK);
    au.tu().vT();
    return false;
  }
  
  public final void bhj() {}
  
  public final void bhk() {}
  
  public final void hq(boolean paramBoolean) {}
  
  public final void onPause()
  {
    this.eNb.stopTimer();
    this.ibI.stopTimer();
    this.ibp = -1L;
    this.maW.un();
    au.tu().vS();
  }
  
  public final void release()
  {
    this.ibo.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b
 * JD-Core Version:    0.7.0.1
 */