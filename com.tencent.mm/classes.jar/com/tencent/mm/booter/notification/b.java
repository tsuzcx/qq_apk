package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.w.1;
import com.tencent.mm.platformtools.w.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements aq, com.tencent.mm.model.at
{
  Context context;
  bl drF;
  private String fkE;
  private String fkF;
  String fkG;
  Intent fkH;
  private boolean fkI;
  private boolean fkJ;
  private long fkK;
  f fkL;
  private com.tencent.mm.booter.notification.a.e fkM;
  @SuppressLint({"HandlerLeak"})
  ap fkN;
  private final com.tencent.mm.sdk.b.c fkO;
  private final com.tencent.mm.sdk.b.c fkP;
  String talker;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(19930);
    this.context = null;
    this.fkL = f.a.Ub();
    this.fkN = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19926);
        super.handleMessage(paramAnonymousMessage);
        String str1 = paramAnonymousMessage.getData().getString("notification.show.talker");
        String str2 = paramAnonymousMessage.getData().getString("notification.show.message.content");
        int i = paramAnonymousMessage.getData().getInt("notification.show.message.type");
        int j = paramAnonymousMessage.getData().getInt("notification.show.tipsflag");
        ad.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[] { str1 });
        try
        {
          if (paramAnonymousMessage.what == 1)
          {
            b.a(b.this, str1, str2, i, j, true);
            AppMethodBeat.o(19926);
            return;
          }
          b.a(b.this, str1, str2, i, j, false);
          AppMethodBeat.o(19926);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ad.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousMessage, "showNotifiHandler", new Object[0]);
          AppMethodBeat.o(19926);
        }
      }
    };
    this.fkO = new com.tencent.mm.sdk.b.c() {};
    this.fkP = new b.3(this);
    this.context = paramContext;
    this.talker = "";
    this.fkG = "";
    this.fkE = "";
    this.fkK = 0L;
    this.fkJ = false;
    this.fkH = null;
    this.fkM = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.d.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.fkP);
    com.tencent.mm.sdk.b.a.ESL.c(this.fkO);
    AppMethodBeat.o(19930);
  }
  
  static Message a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19937);
    ad.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), bt.eGN().toString() });
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
  
  static int b(bl parambl)
  {
    int j = 0;
    AppMethodBeat.i(19955);
    if (w.sE(parambl.field_talker)) {}
    for (int i = 0; (parambl.field_bizChatId != -1L) && (com.tencent.mm.am.f.pc(parambl.field_talker)); i = 3)
    {
      com.tencent.mm.am.a.c localc = af.awg().bg(parambl.field_bizChatId);
      if ((localc.isGroup()) || (!localc.ht(1))) {
        break;
      }
      AppMethodBeat.o(19955);
      return i;
    }
    parambl = parambl.esh;
    if (bt.isNullOrNil(parambl))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    parambl = bw.K(parambl, "msgsource");
    if ((parambl == null) || (parambl.isEmpty()))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    for (;;)
    {
      int k;
      try
      {
        k = bt.getInt((String)parambl.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          AppMethodBeat.o(19955);
          return i;
        }
      }
      catch (Exception parambl)
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
    this.fkJ = false;
    e.cancel();
    AppMethodBeat.o(19935);
  }
  
  public final void Lo()
  {
    AppMethodBeat.i(19934);
    ad.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(19934);
  }
  
  public final String TT()
  {
    return this.fkE;
  }
  
  public final void TU()
  {
    AppMethodBeat.i(19933);
    try
    {
      Object localObject = aj.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = bt.aGh(localObject[i]);
          if (k > 0) {
            az.getNotification().cancel(k);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(19933);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMNotification", localException, "try cancel notification fail: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(19933);
    }
  }
  
  public final void TV()
  {
    AppMethodBeat.i(19943);
    f.a.Ub();
    c.TV();
    AppMethodBeat.o(19943);
  }
  
  public final void V(List<bl> paramList)
  {
    String str = null;
    AppMethodBeat.i(19939);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        ad.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), bt.eGN() });
        AppMethodBeat.o(19939);
        return;
      }
    }
    int j = paramList.size() - 1;
    int i = 0;
    bl localbl;
    for (;;)
    {
      if (j < 0) {
        break label258;
      }
      localbl = (bl)paramList.get(j);
      i = b(localbl);
      if (f.a(localbl.field_talker, localbl, i, false)) {
        break;
      }
      j -= 1;
    }
    label258:
    for (paramList = localbl;; paramList = str)
    {
      if (paramList == null)
      {
        ad.w("MicroMsg.MMNotification", "notifyOther msg == null");
        AppMethodBeat.o(19939);
        return;
      }
      this.fkG = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.drF = paramList;
      ad.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bt.aGs(str) });
      this.fkN.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(19939);
      return;
    }
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19950);
    int i = f.a.Ub().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(19950);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19954);
    paramNotification = f.a.Ub().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19954);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(19941);
    paramNotification = f.a.Ub().flq.fli.a(paramNotification, paramInt, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, 2131233504, paramString4, paramPendingIntent2, 2131233503, paramString5, paramPendingIntent3, paramString6);
    AppMethodBeat.o(19941);
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
    f.a.Ub().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(19949);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(19940);
    com.tencent.mm.bs.d.a("webview", new w.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt), new w.2());
    AppMethodBeat.o(19940);
  }
  
  public final void a(bl parambl)
  {
    AppMethodBeat.i(19936);
    if (parambl == null)
    {
      AppMethodBeat.o(19936);
      return;
    }
    if (parambl.field_isSend == 1)
    {
      ad.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(parambl.field_msgSvrId) });
      AppMethodBeat.o(19936);
      return;
    }
    Object localObject = bi.ul(parambl.esh);
    if ((localObject != null) && (((bi.b)localObject).scene == 1))
    {
      AppMethodBeat.o(19936);
      return;
    }
    int i = b(parambl);
    this.drF = parambl;
    this.talker = parambl.field_talker;
    localObject = parambl.field_content;
    int j = parambl.getType();
    this.fkG = "";
    this.fkH = null;
    ad.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(parambl.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bt.aGs((String)localObject) });
    if (!f.a(this.talker, this.drF, i, false))
    {
      ad.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(19936);
      return;
    }
    this.fkN.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
    AppMethodBeat.o(19936);
  }
  
  public final int c(Notification paramNotification)
  {
    AppMethodBeat.i(19951);
    int i = a(paramNotification, true);
    AppMethodBeat.o(19951);
    return i;
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(19952);
    f.a.Ub();
    com.tencent.mm.booter.notification.queue.b.Uc().cancel(paramInt);
    AppMethodBeat.o(19952);
  }
  
  public final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(19932);
    ad.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.fkF + "  curChattingTalker:" + this.fkE);
    if (!this.fkJ)
    {
      AppMethodBeat.o(19932);
      return;
    }
    az.arV();
    paramString = com.tencent.mm.model.c.apR().aIn(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    if (x.tz(w.gMn) == 0)
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    AppMethodBeat.o(19932);
  }
  
  public final void cw(boolean paramBoolean)
  {
    AppMethodBeat.i(19931);
    this.fkI = paramBoolean;
    ad.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", new Object[] { Boolean.valueOf(this.fkI), bt.eGN() });
    AppMethodBeat.o(19931);
  }
  
  public final void cx(boolean paramBoolean)
  {
    AppMethodBeat.i(19946);
    d.cy(paramBoolean);
    AppMethodBeat.o(19946);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(19938);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(19938);
    return localLooper;
  }
  
  public final void kt(int paramInt)
  {
    AppMethodBeat.i(19944);
    d.kw(paramInt);
    AppMethodBeat.o(19944);
  }
  
  public final void ku(int paramInt)
  {
    AppMethodBeat.i(19947);
    f.a.Ub();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.Uc().flw.kx(paramInt);
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(19947);
        return;
      }
      v localv = v.M(aj.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.Uc().a(localv, localInteger.intValue());
      }
    }
    AppMethodBeat.o(19947);
  }
  
  public final void notify(int paramInt, Notification paramNotification)
  {
    AppMethodBeat.i(19948);
    a(paramInt, paramNotification, true);
    AppMethodBeat.o(19948);
  }
  
  public final void ou(String paramString)
  {
    this.fkE = paramString;
  }
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(19942);
    f.a.Ub();
    e.p(paramInt, paramString);
    AppMethodBeat.o(19942);
  }
  
  public final void y(String paramString, int paramInt)
  {
    AppMethodBeat.i(19945);
    d.z(paramString, paramInt);
    AppMethodBeat.o(19945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b
 * JD-Core Version:    0.7.0.1
 */