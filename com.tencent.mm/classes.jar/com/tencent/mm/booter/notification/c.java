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
import androidx.core.app.e.d;
import androidx.core.app.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.a.vb;
import com.tencent.mm.f.a.vb.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.platformtools.w.1;
import com.tencent.mm.platformtools.w.2;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements ay, com.tencent.mm.model.bb
{
  Context context;
  ca fNz;
  private String iRG;
  private String iRH;
  String iRI;
  Intent iRJ;
  private boolean iRK;
  private boolean iRL;
  private long iRM;
  g iRN;
  private com.tencent.mm.booter.notification.a.e iRO;
  @SuppressLint({"HandlerLeak"})
  MMHandler iRP;
  private final IListener iRQ;
  private final IListener iRR;
  private boolean iRS;
  String talker;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(19930);
    this.context = null;
    this.iRN = g.a.arf();
    this.iRP = new MMHandler(Looper.getMainLooper())
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
    this.iRQ = new IListener() {};
    this.iRR = new IListener()
    {
      private boolean a(vb paramAnonymousvb)
      {
        AppMethodBeat.i(19928);
        Object localObject1;
        int i;
        if ((paramAnonymousvb != null) && ((paramAnonymousvb instanceof vb)))
        {
          localObject1 = paramAnonymousvb.fUp.fSj;
          i = paramAnonymousvb.fUp.msgType;
          paramAnonymousvb = c.this;
        }
        try
        {
          Log.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
          Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramAnonymousvb.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
          if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
          {
            localObject2 = new Intent(paramAnonymousvb.context, ChattingUI.class);
            ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
            ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = PendingIntent.getActivity(paramAnonymousvb.context, 35, (Intent)localObject2, 1073741824);
            localObject2 = com.tencent.mm.bx.a.cp(paramAnonymousvb.context, com.tencent.mm.bx.a.hfv()).n(null).e(System.currentTimeMillis()).k(paramAnonymousvb.context.getString(R.l.app_pushcontent_title)).l(paramAnonymousvb.context.getString(R.l.eLV));
            ((e.d)localObject2).Ip = ((PendingIntent)localObject1);
            localObject1 = ((e.d)localObject2).gr();
            ((Notification)localObject1).icon = com.tencent.mm.bx.a.fkG();
            ((Notification)localObject1).defaults |= 0x1;
            ((Notification)localObject1).flags |= 0x10;
            paramAnonymousvb.a(35, (Notification)localObject1, true);
          }
          AppMethodBeat.o(19928);
          return false;
        }
        catch (Exception paramAnonymousvb)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousvb, "", new Object[0]);
          }
        }
      }
    };
    this.iRS = false;
    this.context = paramContext;
    this.talker = "";
    this.iRI = "";
    this.iRG = "";
    this.iRM = 0L;
    this.iRL = false;
    this.iRJ = null;
    this.iRO = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.f.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    EventCenter.instance.addListener(this.iRR);
    EventCenter.instance.addListener(this.iRQ);
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
  
  static int b(ca paramca)
  {
    int j = 0;
    AppMethodBeat.i(19955);
    if (ab.Qm(paramca.field_talker)) {}
    for (int i = 0; (paramca.field_bizChatId != -1L) && (com.tencent.mm.ao.g.KI(paramca.field_talker)); i = 3)
    {
      com.tencent.mm.ao.a.c localc = af.bjx().bF(paramca.field_bizChatId);
      if ((localc.bjM()) || (!localc.jQ(1))) {
        break;
      }
      AppMethodBeat.o(19955);
      return i;
    }
    paramca = paramca.hxy;
    if (Util.isNullOrNil(paramca))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    paramca = XmlParser.parseXml(paramca, "msgsource", null);
    if ((paramca == null) || (paramca.isEmpty()))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    for (;;)
    {
      int k;
      try
      {
        k = Util.getInt((String)paramca.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          AppMethodBeat.o(19955);
          return i;
        }
      }
      catch (Exception paramca)
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
    this.iRL = false;
    f.cancel();
    AppMethodBeat.o(19935);
  }
  
  public final void JP(String paramString)
  {
    this.iRG = paramString;
  }
  
  public final void P(List<ca> paramList)
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
    ca localca;
    for (;;)
    {
      if (j < 0) {
        break label258;
      }
      localca = (ca)paramList.get(j);
      i = b(localca);
      if (g.a(localca.field_talker, localca, i, false)) {
        break;
      }
      j -= 1;
    }
    label258:
    for (paramList = localca;; paramList = str)
    {
      if (paramList == null)
      {
        Log.w("MicroMsg.MMNotification", "notifyOther msg == null");
        AppMethodBeat.o(19939);
        return;
      }
      this.iRI = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.fNz = paramList;
      Log.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), Util.secPrint(str) });
      this.iRP.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(19939);
      return;
    }
  }
  
  public final void U(String paramString, int paramInt)
  {
    AppMethodBeat.i(19945);
    e.V(paramString, paramInt);
    AppMethodBeat.o(19945);
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19950);
    int i = g.a.arf().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(19950);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19954);
    paramNotification = g.a.arf().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19954);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt2, String paramString4, PendingIntent paramPendingIntent2, int paramInt3, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(267184);
    paramNotification = g.a.arf().iSt.iSl.a(paramNotification, paramInt1, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, paramInt2, paramString4, paramPendingIntent2, paramInt3, paramString5, paramPendingIntent3, paramString6);
    AppMethodBeat.o(267184);
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
    g.a.arf().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(19949);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(19940);
    paramString1 = new w.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt);
    new w.2();
    com.tencent.mm.by.c.a("webview", paramString1);
    AppMethodBeat.o(19940);
  }
  
  public final void a(ca paramca)
  {
    AppMethodBeat.i(19936);
    if (paramca == null)
    {
      AppMethodBeat.o(19936);
      return;
    }
    if (paramca.field_isSend == 1)
    {
      Log.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(paramca.field_msgSvrId) });
      AppMethodBeat.o(19936);
      return;
    }
    Object localObject = bq.RR(paramca.hxy);
    if ((localObject != null) && (((bq.b)localObject).scene == 1))
    {
      AppMethodBeat.o(19936);
      return;
    }
    int i = b(paramca);
    this.fNz = paramca;
    this.talker = paramca.field_talker;
    localObject = paramca.field_content;
    int j = paramca.getType();
    this.iRI = "";
    this.iRJ = null;
    Log.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), Util.secPrint((String)localObject) });
    if (!g.a(this.talker, this.fNz, i, false))
    {
      Log.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(19936);
      return;
    }
    this.iRP.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
    AppMethodBeat.o(19936);
  }
  
  public final void abF()
  {
    AppMethodBeat.i(19934);
    Log.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(19934);
  }
  
  public final String aqX()
  {
    return this.iRG;
  }
  
  public final void aqY()
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
  
  public final void aqZ()
  {
    AppMethodBeat.i(19943);
    g.a.arf();
    d.aqZ();
    AppMethodBeat.o(19943);
  }
  
  public final int c(Notification paramNotification)
  {
    AppMethodBeat.i(19951);
    int i = a(paramNotification, true);
    AppMethodBeat.o(19951);
    return i;
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
    g.a.arf();
    com.tencent.mm.booter.notification.queue.b.arh().cancel(paramInt);
    AppMethodBeat.o(19952);
  }
  
  public final void dH(boolean paramBoolean)
  {
    AppMethodBeat.i(19931);
    this.iRK = paramBoolean;
    Log.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", new Object[] { Boolean.valueOf(this.iRK), Util.getStack() });
    AppMethodBeat.o(19931);
  }
  
  public final void dI(boolean paramBoolean)
  {
    this.iRS = paramBoolean;
  }
  
  public final void dJ(boolean paramBoolean)
  {
    AppMethodBeat.i(19946);
    e.dK(paramBoolean);
    AppMethodBeat.o(19946);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(19938);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(19938);
    return localLooper;
  }
  
  public final void hg(String paramString)
  {
    AppMethodBeat.i(19932);
    Log.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.iRH + "  curChattingTalker:" + this.iRG);
    if (!this.iRL)
    {
      AppMethodBeat.o(19932);
      return;
    }
    bh.beI();
    paramString = com.tencent.mm.model.c.bbR().bwx(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    if (i.hWh() == 0)
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
    e.qj(paramInt);
    AppMethodBeat.o(19944);
  }
  
  public final void qh(int paramInt)
  {
    AppMethodBeat.i(19947);
    g.a.arf();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.arh().iSA.qk(paramInt);
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(19947);
        return;
      }
      h localh = h.M(MMApplicationContext.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.arh().a(localh, localInteger.intValue());
      }
    }
    AppMethodBeat.o(19947);
  }
  
  public final void s(int paramInt, String paramString)
  {
    AppMethodBeat.i(19942);
    g.a.arf().s(paramInt, paramString);
    AppMethodBeat.o(19942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */