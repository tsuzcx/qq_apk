package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.d;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.booter.notification.queue.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.platformtools.t.1;
import com.tencent.mm.platformtools.t.2;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.conversation.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements ay, bb
{
  Context context;
  cc hTm;
  private String ltD;
  private String ltE;
  String ltF;
  Intent ltG;
  private boolean ltH;
  private boolean ltI;
  private long ltJ;
  h ltK;
  private com.tencent.mm.booter.notification.a.e ltL;
  MMHandler ltM;
  private final IListener ltN;
  private final IListener ltO;
  private boolean ltP;
  String talker;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(19930);
    this.context = null;
    this.ltK = h.a.aLc();
    this.ltM = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19926);
        super.handleMessage(paramAnonymousMessage);
        String str1 = paramAnonymousMessage.getData().getString("notification.show.talker");
        String str2 = paramAnonymousMessage.getData().getString("notification.show.message.content");
        int i = paramAnonymousMessage.getData().getInt("notification.show.message.type");
        int j = paramAnonymousMessage.getData().getInt("notification.show.tipsflag");
        Log.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[] { str1 });
        try
        {
          if (paramAnonymousMessage.what == 1)
          {
            c.a(c.this, str1, str2, i, j, true);
            AppMethodBeat.o(19926);
            return;
          }
          c.a(c.this, str1, str2, i, j, false);
          AppMethodBeat.o(19926);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          Log.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousMessage, "showNotifiHandler", new Object[0]);
          AppMethodBeat.o(19926);
        }
      }
    };
    this.ltN = new MMNotification.2(this, com.tencent.mm.app.f.hfK);
    this.ltO = new MMNotification.3(this, com.tencent.mm.app.f.hfK);
    this.ltP = false;
    this.context = paramContext;
    this.talker = "";
    this.ltF = "";
    this.ltD = "";
    this.ltJ = 0L;
    this.ltI = false;
    this.ltG = null;
    this.ltL = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.h.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    this.ltO.alive();
    this.ltN.alive();
    AppMethodBeat.o(19930);
  }
  
  static Message a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19937);
    Log.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Util.getStack().toString() });
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("notification.show.talker", paramString1);
    localBundle.putString("notification.show.message.content", paramString2);
    localBundle.putInt("notification.show.message.type", paramInt1);
    localBundle.putInt("notification.show.tipsflag", paramInt2);
    localMessage.setData(localBundle);
    localMessage.what = paramInt3;
    AppMethodBeat.o(19937);
    return localMessage;
  }
  
  static int b(cc paramcc)
  {
    int j = 0;
    AppMethodBeat.i(19955);
    if (ab.IS(paramcc.field_talker)) {}
    for (int i = 0; (paramcc.field_bizChatId != -1L) && (com.tencent.mm.an.g.Dn(paramcc.field_talker)); i = 3)
    {
      com.tencent.mm.an.a.c localc = af.bHh().dW(paramcc.field_bizChatId);
      if ((localc == null) || (localc.bHx()) || (!localc.nG(1))) {
        break;
      }
      AppMethodBeat.o(19955);
      return i;
    }
    paramcc = paramcc.jUr;
    if (Util.isNullOrNil(paramcc))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    paramcc = XmlParser.parseXml(paramcc, "msgsource", null);
    if ((paramcc == null) || (paramcc.isEmpty()))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    for (;;)
    {
      int k;
      try
      {
        k = Util.getInt((String)paramcc.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          AppMethodBeat.o(19955);
          return i;
        }
      }
      catch (Exception paramcc)
      {
        AppMethodBeat.o(19955);
        return i;
      }
      i = k;
    }
  }
  
  private void cancel()
  {
    AppMethodBeat.i(19935);
    this.ltI = false;
    g.cancel();
    AppMethodBeat.o(19935);
  }
  
  public final void Cv(String paramString)
  {
    this.ltD = paramString;
  }
  
  public final int Cw(String paramString)
  {
    AppMethodBeat.i(238938);
    int i = com.tencent.mm.booter.notification.queue.b.aLd().r(paramString, true);
    AppMethodBeat.o(238938);
    return i;
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19950);
    int i = h.a.aLc().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(19950);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19954);
    paramNotification = h.a.aLc().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19954);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt2, String paramString4, PendingIntent paramPendingIntent2, int paramInt3, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(238935);
    paramNotification = h.a.aLc().luq.lui.a(paramNotification, paramInt1, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, paramInt2, paramString4, paramPendingIntent2, paramInt3, paramString5, paramPendingIntent3, paramString6);
    AppMethodBeat.o(238935);
    return paramNotification;
  }
  
  public final Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19953);
    paramPendingIntent = a(null, -1, 0, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19953);
    return paramPendingIntent;
  }
  
  public final void a(int paramInt, Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19949);
    h.a.aLc().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(19949);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(19940);
    paramString1 = new t.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt);
    new t.2();
    com.tencent.mm.br.c.a("webview", paramString1);
    AppMethodBeat.o(19940);
  }
  
  public final void a(cc paramcc)
  {
    AppMethodBeat.i(19936);
    if (paramcc == null)
    {
      AppMethodBeat.o(19936);
      return;
    }
    if (paramcc.field_isSend == 1)
    {
      Log.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(paramcc.field_msgSvrId) });
      AppMethodBeat.o(19936);
      return;
    }
    Object localObject = br.JP(paramcc.jUr);
    if ((localObject != null) && (((br.b)localObject).scene == 1))
    {
      AppMethodBeat.o(19936);
      return;
    }
    int i = b(paramcc);
    this.hTm = paramcc;
    this.talker = paramcc.field_talker;
    localObject = paramcc.field_content;
    int j = paramcc.getType();
    this.ltF = "";
    this.ltG = null;
    Log.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramcc.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), Util.secPrint((String)localObject) });
    if (!this.ltK.a(this.talker, this.hTm, i, false))
    {
      Log.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(19936);
      return;
    }
    this.ltM.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
    AppMethodBeat.o(19936);
  }
  
  public final void aDA()
  {
    AppMethodBeat.i(19934);
    Log.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(19934);
  }
  
  public final String aKU()
  {
    return this.ltD;
  }
  
  public final void aKV()
  {
    AppMethodBeat.i(19933);
    try
    {
      Object localObject = MMApplicationContext.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = Util.safeParseInt(localObject[i]);
          if (k > 0) {
            bh.getNotification().cancel(k);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(19933);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMNotification", localException, "try cancel notification fail: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(19933);
    }
  }
  
  public final void aKW()
  {
    AppMethodBeat.i(19943);
    h.a.aLc();
    e.aKW();
    AppMethodBeat.o(19943);
  }
  
  public final void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(19945);
    f.ae(paramString, paramInt);
    AppMethodBeat.o(19945);
  }
  
  public final void bp(List<cc> paramList)
  {
    String str = null;
    AppMethodBeat.i(19939);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        Log.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), Util.getStack() });
        AppMethodBeat.o(19939);
        return;
      }
    }
    int j = paramList.size() - 1;
    int i = 0;
    cc localcc;
    for (;;)
    {
      if (j < 0) {
        break label262;
      }
      localcc = (cc)paramList.get(j);
      i = b(localcc);
      if (this.ltK.a(localcc.field_talker, localcc, i, false)) {
        break;
      }
      j -= 1;
    }
    label262:
    for (paramList = localcc;; paramList = str)
    {
      if (paramList == null)
      {
        Log.w("MicroMsg.MMNotification", "notifyOther msg == null");
        AppMethodBeat.o(19939);
        return;
      }
      this.ltF = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.hTm = paramList;
      Log.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), Util.secPrint(str) });
      this.ltM.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(19939);
      return;
    }
  }
  
  public final int c(Notification paramNotification)
  {
    boolean bool2 = true;
    AppMethodBeat.i(238937);
    com.tencent.mm.booter.notification.a.b localb = new com.tencent.mm.booter.notification.a.b();
    Context localContext = MMApplicationContext.getContext();
    com.tencent.mm.booter.notification.a.e locale = new com.tencent.mm.booter.notification.a.e();
    MMApplicationContext.getContext();
    boolean bool4 = com.tencent.mm.booter.notification.a.e.aLj();
    boolean bool3 = bool4;
    boolean bool1;
    if (bool4)
    {
      if (com.tencent.mm.booter.notification.a.e.CB("")) {
        break label362;
      }
      bool1 = true;
      bool4 &= bool1;
      bool3 = bool4;
      if (bool4)
      {
        bool4 &= com.tencent.mm.booter.notification.a.e.qp(3);
        bool3 = bool4;
        if (bool4)
        {
          if (locale.c(false, 0L)) {
            break label367;
          }
          bool1 = true;
          label104:
          bool4 &= bool1;
          bool3 = bool4;
          if (bool4)
          {
            if (com.tencent.mm.booter.notification.a.e.CA("")) {
              break label372;
            }
            bool1 = true;
            label129:
            bool4 &= bool1;
            bool3 = bool4;
            if (bool4)
            {
              if (com.tencent.mm.booter.notification.a.e.a("", null)) {
                break label377;
              }
              bool1 = true;
              label155:
              bool4 &= bool1;
              bool3 = bool4;
              if (bool4)
              {
                bool3 = com.tencent.mm.booter.notification.a.e.t(0, "") & bool4;
                if (!bool3) {
                  break label413;
                }
                if (com.tencent.mm.booter.notification.a.e.aLl()) {
                  break label382;
                }
                bool1 = true;
                label194:
                bool3 = bool1 & bool3;
              }
            }
          }
        }
      }
    }
    label278:
    label407:
    label413:
    for (;;)
    {
      locale = new com.tencent.mm.booter.notification.a.e();
      MMApplicationContext.getContext();
      bool4 = com.tencent.mm.booter.notification.a.e.aLm();
      if (bool4) {
        if (!com.tencent.mm.booter.notification.a.e.CB(""))
        {
          bool1 = true;
          label233:
          boolean bool5 = bool4 & bool1;
          bool4 = bool5;
          if (!bool5) {
            break label407;
          }
          bool5 &= com.tencent.mm.booter.notification.a.e.qq(3);
          bool4 = bool5;
          if (!bool5) {
            break label407;
          }
          if (locale.c(false, 0L)) {
            break label392;
          }
          bool1 = true;
          bool5 &= bool1;
          bool4 = bool5;
          if (!bool5) {
            break label407;
          }
          if (com.tencent.mm.booter.notification.a.e.a("", null)) {
            break label397;
          }
          bool1 = true;
          label304:
          bool5 &= bool1;
          bool4 = bool5;
          if (!bool5) {
            break label407;
          }
          if (com.tencent.mm.booter.notification.a.e.aLl()) {
            break label402;
          }
          bool1 = bool2;
          label327:
          bool4 = bool1 & bool5;
        }
      }
      for (;;)
      {
        localb.a(localContext, bool3, bool4, paramNotification, "");
        int i = localb.luA;
        AppMethodBeat.o(238937);
        return i;
        label362:
        i = 0;
        break;
        label367:
        i = 0;
        break label104;
        label372:
        i = 0;
        break label129;
        label377:
        i = 0;
        break label155;
        label382:
        i = 0;
        break label194;
        i = 0;
        break label233;
        i = 0;
        break label278;
        i = 0;
        break label304;
        i = 0;
        break label327;
      }
    }
  }
  
  public final void c(int paramInt, Notification paramNotification)
  {
    AppMethodBeat.i(19948);
    a(paramInt, paramNotification, true);
    AppMethodBeat.o(19948);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(19952);
    h.a.aLc();
    com.tencent.mm.booter.notification.queue.b.aLd().cancel(paramInt);
    AppMethodBeat.o(19952);
  }
  
  public final int d(Notification paramNotification)
  {
    AppMethodBeat.i(19951);
    int i = a(paramNotification, true);
    AppMethodBeat.o(19951);
    return i;
  }
  
  public final void et(boolean paramBoolean)
  {
    AppMethodBeat.i(19931);
    this.ltH = paramBoolean;
    Log.i("MicroMsg.MMNotification", "set hideNotification: %s", new Object[] { Boolean.valueOf(this.ltH) });
    AppMethodBeat.o(19931);
  }
  
  public final void eu(boolean paramBoolean)
  {
    this.ltP = paramBoolean;
  }
  
  public final void ev(boolean paramBoolean)
  {
    AppMethodBeat.i(19946);
    f.ew(paramBoolean);
    AppMethodBeat.o(19946);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(19938);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(19938);
    return localLooper;
  }
  
  public final void iH(String paramString)
  {
    AppMethodBeat.i(19932);
    Log.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.ltE + "  curChattingTalker:" + this.ltD);
    if (!this.ltI)
    {
      AppMethodBeat.o(19932);
      return;
    }
    bh.bCz();
    paramString = com.tencent.mm.model.c.bzG().bxM(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    if (j.jAf() == 0)
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    AppMethodBeat.o(19932);
  }
  
  public final void qg(int paramInt)
  {
    AppMethodBeat.i(19944);
    f.qj(paramInt);
    AppMethodBeat.o(19944);
  }
  
  public final void qh(int paramInt)
  {
    AppMethodBeat.i(19947);
    h.a.aLc();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.aLd().luw.qk(paramInt);
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        AppMethodBeat.o(19947);
        return;
      }
      i locali = i.X(MMApplicationContext.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.aLd().a(locali, localInteger.intValue());
      }
    }
    AppMethodBeat.o(19947);
  }
  
  public final void s(int paramInt, String paramString)
  {
    AppMethodBeat.i(19942);
    h.a.aLc().s(paramInt, paramString);
    AppMethodBeat.o(19942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */