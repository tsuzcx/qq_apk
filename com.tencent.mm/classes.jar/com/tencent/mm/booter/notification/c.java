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
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.a.ta.a;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.w.1;
import com.tencent.mm.platformtools.w.2;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  implements at, aw
{
  Context context;
  bv dCi;
  private String fIk;
  private String fIl;
  String fIm;
  Intent fIn;
  private boolean fIo;
  private boolean fIp;
  private long fIq;
  g fIr;
  private com.tencent.mm.booter.notification.a.e fIs;
  @SuppressLint({"HandlerLeak"})
  aq fIt;
  private final com.tencent.mm.sdk.b.c fIu;
  private final com.tencent.mm.sdk.b.c fIv;
  String talker;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(19930);
    this.context = null;
    this.fIr = g.a.Xv();
    this.fIt = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19926);
        super.handleMessage(paramAnonymousMessage);
        String str1 = paramAnonymousMessage.getData().getString("notification.show.talker");
        String str2 = paramAnonymousMessage.getData().getString("notification.show.message.content");
        int i = paramAnonymousMessage.getData().getInt("notification.show.message.type");
        int j = paramAnonymousMessage.getData().getInt("notification.show.tipsflag");
        ae.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[] { str1 });
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
          ae.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousMessage, "showNotifiHandler", new Object[0]);
          AppMethodBeat.o(19926);
        }
      }
    };
    this.fIu = new com.tencent.mm.sdk.b.c() {};
    this.fIv = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ta paramAnonymousta)
      {
        AppMethodBeat.i(19928);
        Object localObject1;
        int i;
        if ((paramAnonymousta != null) && ((paramAnonymousta instanceof ta)))
        {
          localObject1 = paramAnonymousta.dIF.dGJ;
          i = paramAnonymousta.dIF.msgType;
          paramAnonymousta = c.this;
        }
        try
        {
          ae.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
          Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramAnonymousta.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
          if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
          {
            localObject2 = new Intent(paramAnonymousta.context, ChattingUI.class);
            ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
            ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
            ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
            ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            localObject1 = PendingIntent.getActivity(paramAnonymousta.context, 35, (Intent)localObject2, 1073741824);
            localObject2 = com.tencent.mm.bq.a.bJ(paramAnonymousta.context, com.tencent.mm.bq.a.fct()).i(null).i(System.currentTimeMillis()).f(paramAnonymousta.context.getString(2131755866)).g(paramAnonymousta.context.getString(2131761228));
            ((s.c)localObject2).Hl = ((PendingIntent)localObject1);
            localObject1 = ((s.c)localObject2).build();
            ((Notification)localObject1).icon = com.tencent.mm.bq.a.dzu();
            ((Notification)localObject1).defaults |= 0x1;
            ((Notification)localObject1).flags |= 0x10;
            paramAnonymousta.a(35, (Notification)localObject1, true);
          }
          AppMethodBeat.o(19928);
          return false;
        }
        catch (Exception paramAnonymousta)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.MMNotification", paramAnonymousta, "", new Object[0]);
          }
        }
      }
    };
    this.context = paramContext;
    this.talker = "";
    this.fIm = "";
    this.fIk = "";
    this.fIq = 0L;
    this.fIp = false;
    this.fIn = null;
    this.fIs = new com.tencent.mm.booter.notification.a.e();
    com.tencent.mm.plugin.notification.e.a(this);
    com.tencent.mm.modelvoice.e.a(this);
    com.tencent.mm.plugin.base.stub.b.a(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.fIv);
    com.tencent.mm.sdk.b.a.IvT.c(this.fIu);
    AppMethodBeat.o(19930);
  }
  
  static Message a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19937);
    ae.d("MicroMsg.MMNotification", "[wrapMessage] talker:%s msgType:%s stack:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), bu.fpN().toString() });
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
  
  static int b(bv parambv)
  {
    int j = 0;
    AppMethodBeat.i(19955);
    if (x.Ao(parambv.field_talker)) {}
    for (int i = 0; (parambv.field_bizChatId != -1L) && (com.tencent.mm.al.g.vz(parambv.field_talker)); i = 3)
    {
      com.tencent.mm.al.a.c localc = ag.aGr().bd(parambv.field_bizChatId);
      if ((localc.isGroup()) || (!localc.hk(1))) {
        break;
      }
      AppMethodBeat.o(19955);
      return i;
    }
    parambv = parambv.eNd;
    if (bu.isNullOrNil(parambv))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    parambv = bx.M(parambv, "msgsource");
    if ((parambv == null) || (parambv.isEmpty()))
    {
      AppMethodBeat.o(19955);
      return i;
    }
    for (;;)
    {
      int k;
      try
      {
        k = bu.getInt((String)parambv.get(".msgsource.tips"), i);
        if (((k & 0x1) == 0) && ((k & 0x2) != 0))
        {
          i = j;
          AppMethodBeat.o(19955);
          return i;
        }
      }
      catch (Exception parambv)
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
    this.fIp = false;
    f.cancel();
    AppMethodBeat.o(19935);
  }
  
  public final void B(String paramString, int paramInt)
  {
    AppMethodBeat.i(19945);
    e.C(paramString, paramInt);
    AppMethodBeat.o(19945);
  }
  
  public final void M(List<bv> paramList)
  {
    String str = null;
    AppMethodBeat.i(19939);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (paramList == null) {}
      for (i = -1;; i = paramList.size())
      {
        ae.w("MicroMsg.MMNotification", "notifyOther newMsgList:%d :%s", new Object[] { Integer.valueOf(i), bu.fpN() });
        AppMethodBeat.o(19939);
        return;
      }
    }
    int j = paramList.size() - 1;
    int i = 0;
    bv localbv;
    for (;;)
    {
      if (j < 0) {
        break label258;
      }
      localbv = (bv)paramList.get(j);
      i = b(localbv);
      if (g.a(localbv.field_talker, localbv, i, false)) {
        break;
      }
      j -= 1;
    }
    label258:
    for (paramList = localbv;; paramList = str)
    {
      if (paramList == null)
      {
        ae.w("MicroMsg.MMNotification", "notifyOther msg == null");
        AppMethodBeat.o(19939);
        return;
      }
      this.fIm = "";
      this.talker = paramList.field_talker;
      str = paramList.field_content;
      j = paramList.getType();
      this.dCi = paramList;
      ae.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(paramList.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bu.aSM(str) });
      this.fIt.sendMessageDelayed(a(this.talker, str, j, i, 0), 200L);
      AppMethodBeat.o(19939);
      return;
    }
  }
  
  public final void MP()
  {
    AppMethodBeat.i(19934);
    ae.d("MicroMsg.MMNotification", "force cancelNotification");
    cancel();
    AppMethodBeat.o(19934);
  }
  
  public final String Xn()
  {
    return this.fIk;
  }
  
  public final void Xo()
  {
    AppMethodBeat.i(19933);
    try
    {
      Object localObject = ak.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = bu.aSB(localObject[i]);
          if (k > 0) {
            bc.getNotification().cancel(k);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(19933);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MMNotification", localException, "try cancel notification fail: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(19933);
    }
  }
  
  public final void Xp()
  {
    AppMethodBeat.i(19943);
    g.a.Xv();
    d.Xp();
    AppMethodBeat.o(19943);
  }
  
  public final int a(Notification paramNotification, boolean paramBoolean)
  {
    AppMethodBeat.i(19950);
    int i = g.a.Xv().b(new NotificationItem(paramNotification, paramBoolean));
    AppMethodBeat.o(19950);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19954);
    paramNotification = g.a.Xv().a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19954);
    return paramNotification;
  }
  
  public final Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(19941);
    paramNotification = g.a.Xv().fIW.fIO.a(paramNotification, paramInt, 1, paramPendingIntent1, paramString1, paramString2, paramString3, paramBitmap, 2131233504, paramString4, paramPendingIntent2, 2131233503, paramString5, paramPendingIntent3, paramString6);
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
    g.a.Xv().b(new NotificationItem(paramInt, paramNotification, paramBoolean));
    AppMethodBeat.o(19949);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    AppMethodBeat.i(19940);
    com.tencent.mm.br.d.a("webview", new w.1(paramString3, paramString4, paramBundle, paramString1, paramString2, paramInt), new w.2());
    AppMethodBeat.o(19940);
  }
  
  public final void a(bv parambv)
  {
    AppMethodBeat.i(19936);
    if (parambv == null)
    {
      AppMethodBeat.o(19936);
      return;
    }
    if (parambv.field_isSend == 1)
    {
      ae.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", new Object[] { Long.valueOf(parambv.field_msgSvrId) });
      AppMethodBeat.o(19936);
      return;
    }
    Object localObject = bl.BS(parambv.eNd);
    if ((localObject != null) && (((bl.b)localObject).scene == 1))
    {
      AppMethodBeat.o(19936);
      return;
    }
    int i = b(parambv);
    this.dCi = parambv;
    this.talker = parambv.field_talker;
    localObject = parambv.field_content;
    int j = parambv.getType();
    this.fIm = "";
    this.fIn = null;
    ae.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[] { this.talker, Long.valueOf(parambv.field_msgSvrId), Integer.valueOf(j), Integer.valueOf(i), bu.aSM((String)localObject) });
    if (!g.a(this.talker, this.dCi, i, false))
    {
      ae.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
      AppMethodBeat.o(19936);
      return;
    }
    this.fIt.sendMessageDelayed(a(this.talker, (String)localObject, j, i, 0), 200L);
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
    g.a.Xv();
    com.tencent.mm.booter.notification.queue.b.Xw().cancel(paramInt);
    AppMethodBeat.o(19952);
  }
  
  public final void cancelNotification(String paramString)
  {
    AppMethodBeat.i(19932);
    ae.v("MicroMsg.MMNotification", "cancel notification talker:" + paramString + " last talker:" + this.fIl + "  curChattingTalker:" + this.fIk);
    if (!this.fIp)
    {
      AppMethodBeat.o(19932);
      return;
    }
    bc.aCg();
    paramString = com.tencent.mm.model.c.azL().aVa(paramString);
    if ((paramString != null) && (paramString.field_unReadCount != 0))
    {
      cancel();
      AppMethodBeat.o(19932);
      return;
    }
    if (h.fNg() == 0)
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
    this.fIo = paramBoolean;
    ae.i("MicroMsg.MMNotification", "set hideNotification: %s, stack[%s]", new Object[] { Boolean.valueOf(this.fIo), bu.fpN() });
    AppMethodBeat.o(19931);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(19938);
    Looper localLooper = Looper.getMainLooper();
    AppMethodBeat.o(19938);
    return localLooper;
  }
  
  public final void kP(int paramInt)
  {
    AppMethodBeat.i(19944);
    e.kS(paramInt);
    AppMethodBeat.o(19944);
  }
  
  public final void kQ(int paramInt)
  {
    AppMethodBeat.i(19947);
    g.a.Xv();
    if (paramInt != 0)
    {
      Object localObject = com.tencent.mm.booter.notification.queue.b.Xw().fJc.kT(paramInt);
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(19947);
        return;
      }
      v localv = v.O(ak.getContext());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        com.tencent.mm.booter.notification.queue.b.Xw().a(localv, localInteger.intValue());
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
    g.a.Xv();
    f.p(paramInt, paramString);
    AppMethodBeat.o(19942);
  }
  
  public final void uI(String paramString)
  {
    this.fIk = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */