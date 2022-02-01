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
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.a.ty.a;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
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
import com.tencent.mm.ui.conversation.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements ax, ba
{
  Context context;
  ca dTX;
  Intent gnA;
  private boolean gnB;
  private boolean gnC;
  private long gnD;
  g gnE;
  private com.tencent.mm.booter.notification.a.e gnF;
  @SuppressLint({"HandlerLeak"})
  MMHandler gnG;
  private final IListener gnH;
  private final IListener gnI;
  private boolean gnJ;
  private String gnx;
  private String gny;
  String gnz;
  String talker;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(19930);
    this.context = null;
    this.gnE = g.a.ali();
    this.gnG = new MMHandler(Looper.getMainLooper())
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
    this.gnH = new IListener() {};
    this.gnI = new IListener()
    {
      private boolean a(ty paramAnonymousty)
      {
        AppMethodBeat.i(19928);
        Object localObject1;
        int i;
        if ((paramAnonymousty != null) && ((paramAnonymousty instanceof ty)))
        {
          localObject1 = paramAnonymousty.eas.dYs;
          i = paramAnonymousty.eas.msgType;
          paramAnonymousty = c.this;
        }
        try
        {
          Log.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
          Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramAnonymousty.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
          if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
          {
            localObject2 = new Intent(paramAnonymousty.context, ChattingUI.class);
            ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
            ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = PendingIntent.getActivity(paramAnonymousty.context, 35, (Intent)localObject2, 1073741824);
            localObject2 = com.tencent.mm.bq.a.cd(paramAnonymousty.context, com.tencent.mm.bq.a.glE()).i(null).i(System.currentTimeMillis()).f(paramAnonymousty.context.getString(2131755955)).g(paramAnonymousty.context.getString(2131763043));
            ((s.c)localObject2).Hv = ((PendingIntent)localObject1);
            localObject1 = ((s.c)localObject2).build();
            ((Notification)localObject1).icon = com.tencent.mm.bq.a.ezb();
            ((Notification)localObject1).defaults |= 0x1;
            ((Notification)localObject1).flags |= 0x10;
            paramAnonymousty.a(35, (Notification)localObject1, true);
          }
          AppMethodBeat.o(19928);
          return false;
        }
        catch (Exception paramAnonymousty)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousty, "", new Object[0]);
          }
        }
      }
    };
    this.gnJ = false;
    this.context = paramContext;
    this.talker = "";
    this.gnz = "";
    this.gnx = "";
    this.gnD = 0L;
    this.gnC = false;
    this.gnA = null;
    this.gnF = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.e.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    EventCenter.instance.addListener(this.gnI);
    EventCenter.instance.addListener(this.gnH);
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
    if (ab.IT(paramca.field_talker)) {}
    for (int i = 0; (paramca.field_bizChatId != -1L) && (com.tencent.mm.al.g.DQ(paramca.field_talker)); i = 3)
    {
      com.tencent.mm.al.a.c localc = ag.baj().bs(paramca.field_bizChatId);
      if ((localc.isGroup()) || (!localc.iE(1))) {
        break;
      }
      AppMethodBeat.o(19955);
      return i;
    }
    paramca = paramca.fqK;
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
    this.gnC = false;
    f.cancel();
    AppMethodBeat.o(19935);
  }
  
  public final void C(String paramString, int paramInt)
  {
    AppMethodBeat.i(19945);
    e.D(paramString, paramInt);
    AppMethodBeat.o(19945);
  }
  
  public final void CY(String paramString)
  {
    this.gnx = paramString;
  }
  
  public final void S(List<ca> paramList)
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
      this.gnz = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.dTX = paramList;
      Log.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), Util.secPrint(str) });
      this.gnG.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(19939);
      return;
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(19934);
    Log.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(19934);
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19950);
    int i = g.a.ali().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(19950);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19954);
    paramNotification = g.a.ali().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19954);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(19941);
    paramNotification = g.a.ali().gok.goc.a(paramNotification, paramInt, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, 2131234307, paramString4, paramPendingIntent2, 2131234306, paramString5, paramPendingIntent3, paramString6);
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
    g.a.ali().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(19949);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(19940);
    paramString1 = new w.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt);
    new w.2();
    com.tencent.mm.br.c.a("webview", paramString1);
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
    Object localObject = bp.Ky(paramca.fqK);
    if ((localObject != null) && (((bp.b)localObject).scene == 1))
    {
      AppMethodBeat.o(19936);
      return;
    }
    int i = b(paramca);
    this.dTX = paramca;
    this.talker = paramca.field_talker;
    localObject = paramca.field_content;
    int j = paramca.getType();
    this.gnz = "";
    this.gnA = null;
    Log.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), Util.secPrint((String)localObject) });
    if (!g.a(this.talker, this.dTX, i, false))
    {
      Log.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(19936);
      return;
    }
    this.gnG.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
    AppMethodBeat.o(19936);
  }
  
  public final String ala()
  {
    return this.gnx;
  }
  
  public final void alb()
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
            bg.getNotification().cancel(k);
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
  
  public final void alc()
  {
    AppMethodBeat.i(19943);
    g.a.ali();
    d.alc();
    AppMethodBeat.o(19943);
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
    g.a.ali();
    com.tencent.mm.booter.notification.queue.b.alj().cancel(paramInt);
    AppMethodBeat.o(19952);
  }
  
  public final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(19932);
    Log.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.gny + "  curChattingTalker:" + this.gnx);
    if (!this.gnC)
    {
      AppMethodBeat.o(19932);
      return;
    }
    bg.aVF();
    paramString = com.tencent.mm.model.c.aST().bjY(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    if (h.gVB() == 0)
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    AppMethodBeat.o(19932);
  }
  
  public final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(19931);
    this.gnB = paramBoolean;
    Log.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", new Object[] { Boolean.valueOf(this.gnB), Util.getStack() });
    AppMethodBeat.o(19931);
  }
  
  public final void di(boolean paramBoolean)
  {
    this.gnJ = paramBoolean;
  }
  
  public final void dj(boolean paramBoolean)
  {
    AppMethodBeat.i(19946);
    e.dk(paramBoolean);
    AppMethodBeat.o(19946);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(19938);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(19938);
    return localLooper;
  }
  
  public final void nR(int paramInt)
  {
    AppMethodBeat.i(19944);
    e.nU(paramInt);
    AppMethodBeat.o(19944);
  }
  
  public final void nS(int paramInt)
  {
    AppMethodBeat.i(19947);
    g.a.ali();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.alj().gor.nV(paramInt);
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(19947);
        return;
      }
      v localv = v.P(MMApplicationContext.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.alj().a(localv, localInteger.intValue());
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
  
  public final void r(int paramInt, String paramString)
  {
    AppMethodBeat.i(19942);
    g.a.ali();
    f.r(paramInt, paramString);
    AppMethodBeat.o(19942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */