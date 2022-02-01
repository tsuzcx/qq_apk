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
import com.tencent.mm.al.af;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.w.1;
import com.tencent.mm.platformtools.w.2;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements aq, at
{
  Context context;
  bo dpq;
  private String fnY;
  private String fnZ;
  String foa;
  Intent fob;
  private boolean foc;
  private boolean fod;
  private long foe;
  f fof;
  private com.tencent.mm.booter.notification.a.e fog;
  @SuppressLint({"HandlerLeak"})
  ao foh;
  private final com.tencent.mm.sdk.b.c foi;
  private final com.tencent.mm.sdk.b.c foj;
  String talker;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(19930);
    this.context = null;
    this.fof = f.a.UW();
    this.foh = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19926);
        super.handleMessage(paramAnonymousMessage);
        String str1 = paramAnonymousMessage.getData().getString("notification.show.talker");
        String str2 = paramAnonymousMessage.getData().getString("notification.show.message.content");
        int i = paramAnonymousMessage.getData().getInt("notification.show.message.type");
        int j = paramAnonymousMessage.getData().getInt("notification.show.tipsflag");
        ac.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[] { str1 });
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
          ac.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousMessage, "showNotifiHandler", new Object[0]);
          AppMethodBeat.o(19926);
        }
      }
    };
    this.foi = new com.tencent.mm.sdk.b.c() {};
    this.foj = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(sm paramAnonymoussm)
      {
        AppMethodBeat.i(19928);
        Object localObject1;
        int i;
        if ((paramAnonymoussm != null) && ((paramAnonymoussm instanceof sm)))
        {
          localObject1 = paramAnonymoussm.dvy.dtD;
          i = paramAnonymoussm.dvy.msgType;
          paramAnonymoussm = b.this;
        }
        try
        {
          ac.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
          Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramAnonymoussm.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
          if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
          {
            localObject2 = new Intent(paramAnonymoussm.context, ChattingUI.class);
            ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
            ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = PendingIntent.getActivity(paramAnonymoussm.context, 35, (Intent)localObject2, 1073741824);
            localObject2 = com.tencent.mm.bq.a.bE(paramAnonymoussm.context, com.tencent.mm.bq.a.eJR()).i(null).i(System.currentTimeMillis()).f(paramAnonymoussm.context.getString(2131755866)).g(paramAnonymoussm.context.getString(2131761228));
            ((s.c)localObject2).Fu = ((PendingIntent)localObject1);
            localObject1 = ((s.c)localObject2).build();
            ((Notification)localObject1).icon = com.tencent.mm.bq.a.dlN();
            ((Notification)localObject1).defaults |= 0x1;
            ((Notification)localObject1).flags |= 0x10;
            paramAnonymoussm.a(35, (Notification)localObject1, true);
          }
          AppMethodBeat.o(19928);
          return false;
        }
        catch (Exception paramAnonymoussm)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.MMNotification", paramAnonymoussm, "", new Object[0]);
          }
        }
      }
    };
    this.context = paramContext;
    this.talker = "";
    this.foa = "";
    this.fnY = "";
    this.foe = 0L;
    this.fod = false;
    this.fob = null;
    this.fog = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.d.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.foj);
    com.tencent.mm.sdk.b.a.GpY.c(this.foi);
    AppMethodBeat.o(19930);
  }
  
  static Message a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19937);
    ac.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), bs.eWi().toString() });
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
  
  static int b(bo parambo)
  {
    int j = 0;
    AppMethodBeat.i(19955);
    if (w.wH(parambo.field_talker)) {}
    for (int i = 0; (parambo.field_bizChatId != -1L) && (com.tencent.mm.al.f.so(parambo.field_talker)); i = 3)
    {
      com.tencent.mm.al.a.c localc = af.aCY().bd(parambo.field_bizChatId);
      if ((localc.isGroup()) || (!localc.hc(1))) {
        break;
      }
      AppMethodBeat.o(19955);
      return i;
    }
    parambo = parambo.eul;
    if (bs.isNullOrNil(parambo))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    parambo = bv.L(parambo, "msgsource");
    if ((parambo == null) || (parambo.isEmpty()))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    for (;;)
    {
      int k;
      try
      {
        k = bs.getInt((String)parambo.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          AppMethodBeat.o(19955);
          return i;
        }
      }
      catch (Exception parambo)
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
    this.fod = false;
    e.cancel();
    AppMethodBeat.o(19935);
  }
  
  public final void Lm()
  {
    AppMethodBeat.i(19934);
    ac.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(19934);
  }
  
  public final void M(List<bo> paramList)
  {
    String str = null;
    AppMethodBeat.i(19939);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        ac.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), bs.eWi() });
        AppMethodBeat.o(19939);
        return;
      }
    }
    int j = paramList.size() - 1;
    int i = 0;
    bo localbo;
    for (;;)
    {
      if (j < 0) {
        break label258;
      }
      localbo = (bo)paramList.get(j);
      i = b(localbo);
      if (f.a(localbo.field_talker, localbo, i, false)) {
        break;
      }
      j -= 1;
    }
    label258:
    for (paramList = localbo;; paramList = str)
    {
      if (paramList == null)
      {
        ac.w("MicroMsg.MMNotification", "notifyOther msg == null");
        AppMethodBeat.o(19939);
        return;
      }
      this.foa = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.dpq = paramList;
      ac.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bs.aLJ(str) });
      this.foh.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(19939);
      return;
    }
  }
  
  public final String UO()
  {
    return this.fnY;
  }
  
  public final void UP()
  {
    AppMethodBeat.i(19933);
    try
    {
      Object localObject = ai.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = bs.aLy(localObject[i]);
          if (k > 0) {
            com.tencent.mm.model.az.getNotification().cancel(k);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(19933);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMNotification", localException, "try cancel notification fail: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(19933);
    }
  }
  
  public final void UQ()
  {
    AppMethodBeat.i(19943);
    f.a.UW();
    c.UQ();
    AppMethodBeat.o(19943);
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19950);
    int i = f.a.UW().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(19950);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19954);
    paramNotification = f.a.UW().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19954);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(19941);
    paramNotification = f.a.UW().foK.foC.a(paramNotification, paramInt, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, 2131233504, paramString4, paramPendingIntent2, 2131233503, paramString5, paramPendingIntent3, paramString6);
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
    f.a.UW().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(19949);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(19940);
    com.tencent.mm.br.d.a("webview", new w.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt), new w.2());
    AppMethodBeat.o(19940);
  }
  
  public final void a(bo parambo)
  {
    AppMethodBeat.i(19936);
    if (parambo == null)
    {
      AppMethodBeat.o(19936);
      return;
    }
    if (parambo.field_isSend == 1)
    {
      ac.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(parambo.field_msgSvrId) });
      AppMethodBeat.o(19936);
      return;
    }
    Object localObject = bi.yr(parambo.eul);
    if ((localObject != null) && (((bi.b)localObject).scene == 1))
    {
      AppMethodBeat.o(19936);
      return;
    }
    int i = b(parambo);
    this.dpq = parambo;
    this.talker = parambo.field_talker;
    localObject = parambo.field_content;
    int j = parambo.getType();
    this.foa = "";
    this.fob = null;
    ac.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(parambo.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bs.aLJ((String)localObject) });
    if (!f.a(this.talker, this.dpq, i, false))
    {
      ac.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(19936);
      return;
    }
    this.foh.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
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
    f.a.UW();
    com.tencent.mm.booter.notification.queue.b.UX().cancel(paramInt);
    AppMethodBeat.o(19952);
  }
  
  public final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(19932);
    ac.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.fnZ + "  curChattingTalker:" + this.fnY);
    if (!this.fod)
    {
      AppMethodBeat.o(19932);
      return;
    }
    com.tencent.mm.model.az.ayM();
    paramString = com.tencent.mm.model.c.awG().aNI(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    if (h.fsb() == 0)
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    AppMethodBeat.o(19932);
  }
  
  public final void cx(boolean paramBoolean)
  {
    AppMethodBeat.i(19931);
    this.foc = paramBoolean;
    ac.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", new Object[] { Boolean.valueOf(this.foc), bs.eWi() });
    AppMethodBeat.o(19931);
  }
  
  public final void cy(boolean paramBoolean)
  {
    AppMethodBeat.i(19946);
    d.cz(paramBoolean);
    AppMethodBeat.o(19946);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(19938);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(19938);
    return localLooper;
  }
  
  public final void kq(int paramInt)
  {
    AppMethodBeat.i(19944);
    d.kt(paramInt);
    AppMethodBeat.o(19944);
  }
  
  public final void kr(int paramInt)
  {
    AppMethodBeat.i(19947);
    f.a.UW();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.UX().foQ.ku(paramInt);
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(19947);
        return;
      }
      v localv = v.N(ai.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.UX().a(localv, localInteger.intValue());
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
    f.a.UW();
    e.p(paramInt, paramString);
    AppMethodBeat.o(19942);
  }
  
  public final void rA(String paramString)
  {
    this.fnY = paramString;
  }
  
  public final void y(String paramString, int paramInt)
  {
    AppMethodBeat.i(19945);
    d.z(paramString, paramInt);
    AppMethodBeat.o(19945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b
 * JD-Core Version:    0.7.0.1
 */