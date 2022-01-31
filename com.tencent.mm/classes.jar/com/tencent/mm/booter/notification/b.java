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
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.y.1;
import com.tencent.mm.platformtools.y.2;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.model.an, aq
{
  bi cEE;
  Context context;
  private final com.tencent.mm.sdk.b.c eaA;
  private final com.tencent.mm.sdk.b.c eaB;
  private String eaq;
  private String ear;
  String eas;
  Intent eat;
  private boolean eau;
  private boolean eav;
  private long eaw;
  f eax;
  private com.tencent.mm.booter.notification.a.e eay;
  @SuppressLint({"HandlerLeak"})
  ak eaz;
  String talker;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(15898);
    this.context = null;
    this.eax = f.a.IN();
    this.eaz = new ak(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(15892);
        super.handleMessage(paramAnonymousMessage);
        String str1 = paramAnonymousMessage.getData().getString("notification.show.talker");
        String str2 = paramAnonymousMessage.getData().getString("notification.show.message.content");
        int i = paramAnonymousMessage.getData().getInt("notification.show.message.type");
        int j = paramAnonymousMessage.getData().getInt("notification.show.tipsflag");
        ab.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[] { str1 });
        try
        {
          if (paramAnonymousMessage.what == 1)
          {
            b.a(b.this, str1, str2, i, j, true);
            AppMethodBeat.o(15892);
            return;
          }
          b.a(b.this, str1, str2, i, j, false);
          AppMethodBeat.o(15892);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          ab.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousMessage, "showNotifiHandler", new Object[0]);
          AppMethodBeat.o(15892);
        }
      }
    };
    this.eaA = new b.2(this);
    this.eaB = new b.3(this);
    this.context = paramContext;
    this.talker = "";
    this.eas = "";
    this.eaq = "";
    this.eaw = 0L;
    this.eav = false;
    this.eat = null;
    this.eay = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.d.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.eaB);
    com.tencent.mm.sdk.b.a.ymk.c(this.eaA);
    AppMethodBeat.o(15898);
  }
  
  static Message a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15905);
    ab.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), bo.dtY().toString() });
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("notification.show.talker", paramString1);
    localBundle.putString("notification.show.message.content", paramString2);
    localBundle.putInt("notification.show.message.type", paramInt1);
    localBundle.putInt("notification.show.tipsflag", paramInt2);
    localMessage.setData(localBundle);
    localMessage.what = paramInt3;
    AppMethodBeat.o(15905);
    return localMessage;
  }
  
  static int b(bi parambi)
  {
    int j = 0;
    AppMethodBeat.i(15923);
    if (t.nU(parambi.field_talker)) {}
    for (int i = 0; (parambi.field_bizChatId != -1L) && (com.tencent.mm.aj.f.lg(parambi.field_talker)); i = 3)
    {
      com.tencent.mm.aj.a.c localc = z.afk().aG(parambi.field_bizChatId);
      if ((localc.isGroup()) || (!localc.kY(1))) {
        break;
      }
      AppMethodBeat.o(15923);
      return i;
    }
    parambi = parambi.dns;
    if (bo.isNullOrNil(parambi))
    {
      AppMethodBeat.o(15923);
      return i;
    }
    parambi = br.F(parambi, "msgsource");
    if ((parambi == null) || (parambi.isEmpty()))
    {
      AppMethodBeat.o(15923);
      return i;
    }
    for (;;)
    {
      int k;
      try
      {
        k = bo.getInt((String)parambi.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          AppMethodBeat.o(15923);
          return i;
        }
      }
      catch (Exception parambi)
      {
        AppMethodBeat.o(15923);
        return i;
      }
      i = k;
    }
  }
  
  private void cancel()
  {
    AppMethodBeat.i(15903);
    this.eav = false;
    e.cancel();
    AppMethodBeat.o(15903);
  }
  
  public final void BR()
  {
    AppMethodBeat.i(15902);
    ab.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(15902);
  }
  
  public final String IF()
  {
    return this.eaq;
  }
  
  public final void IG()
  {
    AppMethodBeat.i(15901);
    try
    {
      Object localObject = ah.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = bo.apV(localObject[i]);
          if (k > 0) {
            aw.getNotification().cancel(k);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(15901);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMNotification", localException, "try cancel notification fail: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(15901);
    }
  }
  
  public final void IH()
  {
    AppMethodBeat.i(15911);
    f.a.IN();
    c.IH();
    AppMethodBeat.o(15911);
  }
  
  public final void J(List<bi> paramList)
  {
    String str = null;
    AppMethodBeat.i(15907);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        ab.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), bo.dtY() });
        AppMethodBeat.o(15907);
        return;
      }
    }
    int j = paramList.size() - 1;
    int i = 0;
    bi localbi;
    for (;;)
    {
      if (j < 0) {
        break label258;
      }
      localbi = (bi)paramList.get(j);
      i = b(localbi);
      if (f.a(localbi.field_talker, localbi, i, false)) {
        break;
      }
      j -= 1;
    }
    label258:
    for (paramList = localbi;; paramList = str)
    {
      if (paramList == null)
      {
        ab.w("MicroMsg.MMNotification", "notifyOther msg == null");
        AppMethodBeat.o(15907);
        return;
      }
      this.eas = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.cEE = paramList;
      ab.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bo.aqg(str) });
      this.eaz.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(15907);
      return;
    }
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(15918);
    int i = f.a.IN().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(15918);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(15922);
    paramNotification = f.a.IN().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(15922);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(15909);
    paramNotification = f.a.IN().ebd.eaV.a(paramNotification, paramInt, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, 2130839849, paramString4, paramPendingIntent2, 2130839848, paramString5, paramPendingIntent3, paramString6);
    AppMethodBeat.o(15909);
    return paramNotification;
  }
  
  public final Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(15921);
    paramPendingIntent = a(null, -1, 0, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(15921);
    return paramPendingIntent;
  }
  
  public final void a(int paramInt, Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(15917);
    f.a.IN().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(15917);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(15908);
    com.tencent.mm.bq.d.a("webview", new y.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt), new y.2());
    AppMethodBeat.o(15908);
  }
  
  public final void a(bi parambi)
  {
    AppMethodBeat.i(15904);
    if (parambi == null)
    {
      AppMethodBeat.o(15904);
      return;
    }
    if (parambi.field_isSend == 1)
    {
      ab.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
      AppMethodBeat.o(15904);
      return;
    }
    Object localObject = bf.pA(parambi.dns);
    if ((localObject != null) && (((bf.b)localObject).scene == 1))
    {
      AppMethodBeat.o(15904);
      return;
    }
    int i = b(parambi);
    this.cEE = parambi;
    this.talker = parambi.field_talker;
    localObject = parambi.field_content;
    int j = parambi.getType();
    this.eas = "";
    this.eat = null;
    ab.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bo.aqg((String)localObject) });
    if (!f.a(this.talker, this.cEE, i, false))
    {
      ab.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(15904);
      return;
    }
    this.eaz.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
    AppMethodBeat.o(15904);
  }
  
  public final void bE(boolean paramBoolean)
  {
    AppMethodBeat.i(15899);
    this.eau = paramBoolean;
    ab.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", new Object[] { Boolean.valueOf(this.eau), bo.dtY() });
    AppMethodBeat.o(15899);
  }
  
  public final void bF(boolean paramBoolean)
  {
    AppMethodBeat.i(15914);
    d.bG(paramBoolean);
    AppMethodBeat.o(15914);
  }
  
  public final int c(Notification paramNotification)
  {
    AppMethodBeat.i(15919);
    int i = a(paramNotification, true);
    AppMethodBeat.o(15919);
    return i;
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(15920);
    f.a.IN();
    com.tencent.mm.booter.notification.queue.b.IO().cancel(paramInt);
    AppMethodBeat.o(15920);
  }
  
  public final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(15900);
    ab.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.ear + "  curChattingTalker:" + this.eaq);
    if (!this.eav)
    {
      AppMethodBeat.o(15900);
      return;
    }
    aw.aaz();
    paramString = com.tencent.mm.model.c.YF().arH(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(15900);
      return;
    }
    if (u.oM(t.flc) == 0)
    {
      cancel();
      AppMethodBeat.o(15900);
      return;
    }
    AppMethodBeat.o(15900);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(15906);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(15906);
    return localLooper;
  }
  
  public final void ih(int paramInt)
  {
    AppMethodBeat.i(15912);
    d.ik(paramInt);
    AppMethodBeat.o(15912);
  }
  
  public final void ii(int paramInt)
  {
    AppMethodBeat.i(15915);
    f.a.IN();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.IO().ebk.il(paramInt);
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(15915);
        return;
      }
      v localv = v.K(ah.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.IO().a(localv, localInteger.intValue());
      }
    }
    AppMethodBeat.o(15915);
  }
  
  public final void kD(String paramString)
  {
    this.eaq = paramString;
  }
  
  public final void n(int paramInt, String paramString)
  {
    AppMethodBeat.i(15910);
    f.a.IN();
    e.n(paramInt, paramString);
    AppMethodBeat.o(15910);
  }
  
  public final void notify(int paramInt, Notification paramNotification)
  {
    AppMethodBeat.i(15916);
    a(paramInt, paramNotification, true);
    AppMethodBeat.o(15916);
  }
  
  public final void y(String paramString, int paramInt)
  {
    AppMethodBeat.i(15913);
    d.z(paramString, paramInt);
    AppMethodBeat.o(15913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b
 * JD-Core Version:    0.7.0.1
 */