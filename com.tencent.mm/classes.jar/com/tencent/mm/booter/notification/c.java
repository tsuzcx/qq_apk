package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.s.c;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.sz.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.w.1;
import com.tencent.mm.platformtools.w.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements ar, au
{
  Context context;
  bu dBd;
  private String fGg;
  private String fGh;
  String fGi;
  Intent fGj;
  private boolean fGk;
  private boolean fGl;
  private long fGm;
  g fGn;
  private com.tencent.mm.booter.notification.a.e fGo;
  @SuppressLint({"HandlerLeak"})
  ap fGp;
  private final com.tencent.mm.sdk.b.c fGq;
  private final com.tencent.mm.sdk.b.c fGr;
  String talker;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(19930);
    this.context = null;
    this.fGn = g.a.Xn();
    this.fGp = new ap(Looper.getMainLooper())
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
          ad.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousMessage, "showNotifiHandler", new Object[0]);
          AppMethodBeat.o(19926);
        }
      }
    };
    this.fGq = new com.tencent.mm.sdk.b.c() {};
    this.fGr = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(sz paramAnonymoussz)
      {
        AppMethodBeat.i(19928);
        Object localObject1;
        int i;
        if ((paramAnonymoussz != null) && ((paramAnonymoussz instanceof sz)))
        {
          localObject1 = paramAnonymoussz.dHB.dFE;
          i = paramAnonymoussz.dHB.msgType;
          paramAnonymoussz = c.this;
        }
        try
        {
          ad.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
          Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramAnonymoussz.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
          if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
          {
            localObject2 = new Intent(paramAnonymoussz.context, ChattingUI.class);
            ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
            ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = PendingIntent.getActivity(paramAnonymoussz.context, 35, (Intent)localObject2, 1073741824);
            localObject2 = com.tencent.mm.br.a.bI(paramAnonymoussz.context, com.tencent.mm.br.a.eYF()).i(null).i(System.currentTimeMillis()).f(paramAnonymoussz.context.getString(2131755866)).g(paramAnonymoussz.context.getString(2131761228));
            ((s.c)localObject2).Hl = ((PendingIntent)localObject1);
            localObject1 = ((s.c)localObject2).build();
            ((Notification)localObject1).icon = com.tencent.mm.br.a.dwe();
            ((Notification)localObject1).defaults |= 0x1;
            ((Notification)localObject1).flags |= 0x10;
            paramAnonymoussz.a(35, (Notification)localObject1, true);
          }
          AppMethodBeat.o(19928);
          return false;
        }
        catch (Exception paramAnonymoussz)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.MMNotification", paramAnonymoussz, "", new Object[0]);
          }
        }
      }
    };
    this.context = paramContext;
    this.talker = "";
    this.fGi = "";
    this.fGg = "";
    this.fGm = 0L;
    this.fGl = false;
    this.fGj = null;
    this.fGo = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.d.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    com.tencent.mm.sdk.b.a.IbL.c(this.fGr);
    com.tencent.mm.sdk.b.a.IbL.c(this.fGq);
    AppMethodBeat.o(19930);
  }
  
  static Message a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19937);
    ad.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), bt.flS().toString() });
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
  
  static int b(bu parambu)
  {
    int j = 0;
    AppMethodBeat.i(19955);
    if (w.zE(parambu.field_talker)) {}
    for (int i = 0; (parambu.field_bizChatId != -1L) && (com.tencent.mm.am.g.vd(parambu.field_talker)); i = 3)
    {
      com.tencent.mm.am.a.c localc = ag.aGb().bd(parambu.field_bizChatId);
      if ((localc.isGroup()) || (!localc.hj(1))) {
        break;
      }
      AppMethodBeat.o(19955);
      return i;
    }
    parambu = parambu.eLs;
    if (bt.isNullOrNil(parambu))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    parambu = bw.M(parambu, "msgsource");
    if ((parambu == null) || (parambu.isEmpty()))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    for (;;)
    {
      int k;
      try
      {
        k = bt.getInt((String)parambu.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          AppMethodBeat.o(19955);
          return i;
        }
      }
      catch (Exception parambu)
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
    this.fGl = false;
    f.cancel();
    AppMethodBeat.o(19935);
  }
  
  public final void A(String paramString, int paramInt)
  {
    AppMethodBeat.i(19945);
    e.B(paramString, paramInt);
    AppMethodBeat.o(19945);
  }
  
  public final void M(List<bu> paramList)
  {
    String str = null;
    AppMethodBeat.i(19939);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        ad.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), bt.flS() });
        AppMethodBeat.o(19939);
        return;
      }
    }
    int j = paramList.size() - 1;
    int i = 0;
    bu localbu;
    for (;;)
    {
      if (j < 0) {
        break label258;
      }
      localbu = (bu)paramList.get(j);
      i = b(localbu);
      if (g.a(localbu.field_talker, localbu, i, false)) {
        break;
      }
      j -= 1;
    }
    label258:
    for (paramList = localbu;; paramList = str)
    {
      if (paramList == null)
      {
        ad.w("MicroMsg.MMNotification", "notifyOther msg == null");
        AppMethodBeat.o(19939);
        return;
      }
      this.fGi = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.dBd = paramList;
      ad.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bt.aRp(str) });
      this.fGp.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(19939);
      return;
    }
  }
  
  public final void MU()
  {
    AppMethodBeat.i(19934);
    ad.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(19934);
  }
  
  public final String Xf()
  {
    return this.fGg;
  }
  
  public final void Xg()
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
          int k = bt.aRe(localObject[i]);
          if (k > 0) {
            com.tencent.mm.model.ba.getNotification().cancel(k);
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
  
  public final void Xh()
  {
    AppMethodBeat.i(19943);
    g.a.Xn();
    d.Xh();
    AppMethodBeat.o(19943);
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19950);
    int i = g.a.Xn().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(19950);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19954);
    paramNotification = g.a.Xn().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19954);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(19941);
    paramNotification = g.a.Xn().fGS.fGK.a(paramNotification, paramInt, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, 2131233504, paramString4, paramPendingIntent2, 2131233503, paramString5, paramPendingIntent3, paramString6);
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
    g.a.Xn().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(19949);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(19940);
    com.tencent.mm.bs.d.a("webview", new w.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt), new w.2());
    AppMethodBeat.o(19940);
  }
  
  public final void a(bu parambu)
  {
    AppMethodBeat.i(19936);
    if (parambu == null)
    {
      AppMethodBeat.o(19936);
      return;
    }
    if (parambu.field_isSend == 1)
    {
      ad.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(parambu.field_msgSvrId) });
      AppMethodBeat.o(19936);
      return;
    }
    Object localObject = bj.Bq(parambu.eLs);
    if ((localObject != null) && (((bj.b)localObject).scene == 1))
    {
      AppMethodBeat.o(19936);
      return;
    }
    int i = b(parambu);
    this.dBd = parambu;
    this.talker = parambu.field_talker;
    localObject = parambu.field_content;
    int j = parambu.getType();
    this.fGi = "";
    this.fGj = null;
    ad.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(parambu.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bt.aRp((String)localObject) });
    if (!g.a(this.talker, this.dBd, i, false))
    {
      ad.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(19936);
      return;
    }
    this.fGp.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
    AppMethodBeat.o(19936);
  }
  
  public final int c(Notification paramNotification)
  {
    AppMethodBeat.i(19951);
    int i = a(paramNotification, true);
    AppMethodBeat.o(19951);
    return i;
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(19946);
    e.cB(paramBoolean);
    AppMethodBeat.o(19946);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(19952);
    g.a.Xn();
    com.tencent.mm.booter.notification.queue.b.Xo().cancel(paramInt);
    AppMethodBeat.o(19952);
  }
  
  public final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(19932);
    ad.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.fGh + "  curChattingTalker:" + this.fGg);
    if (!this.fGl)
    {
      AppMethodBeat.o(19932);
      return;
    }
    com.tencent.mm.model.ba.aBQ();
    paramString = com.tencent.mm.model.c.azv().aTz(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    if (h.fIP() == 0)
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    AppMethodBeat.o(19932);
  }
  
  public final void cz(boolean paramBoolean)
  {
    AppMethodBeat.i(19931);
    this.fGk = paramBoolean;
    ad.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", new Object[] { Boolean.valueOf(this.fGk), bt.flS() });
    AppMethodBeat.o(19931);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(19938);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(19938);
    return localLooper;
  }
  
  public final void kN(int paramInt)
  {
    AppMethodBeat.i(19944);
    e.kQ(paramInt);
    AppMethodBeat.o(19944);
  }
  
  public final void kO(int paramInt)
  {
    AppMethodBeat.i(19947);
    g.a.Xn();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.Xo().fGY.kR(paramInt);
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(19947);
        return;
      }
      v localv = v.N(aj.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.Xo().a(localv, localInteger.intValue());
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
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(19942);
    g.a.Xn();
    f.p(paramInt, paramString);
    AppMethodBeat.o(19942);
  }
  
  public final void un(String paramString)
  {
    this.fGg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */